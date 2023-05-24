@file:JvmName("Handlers")

package dev.merge.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dev.merge.api.core.http.HttpResponse
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.BadRequestException
import dev.merge.api.errors.InternalServerException
import dev.merge.api.errors.MergeError
import dev.merge.api.errors.MergeException
import dev.merge.api.errors.NotFoundException
import dev.merge.api.errors.PermissionDeniedException
import dev.merge.api.errors.RateLimitException
import dev.merge.api.errors.UnauthorizedException
import dev.merge.api.errors.UnexpectedStatusCodeException
import dev.merge.api.errors.UnprocessableEntityException

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandler

private object EmptyHandler : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandler

private object StringHandler : Handler<String> {
    override fun handle(response: HttpResponse): String {
        return response.body().readBytes().toString(Charsets.UTF_8)
    }
}

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> {
    return object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            try {
                return jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw MergeException("Error reading response", e)
            }
        }
    }
}

@JvmSynthetic
internal fun errorHandler(jsonMapper: JsonMapper): Handler<MergeError> {
    val handler = jsonHandler<MergeError>(jsonMapper)

    return object : Handler<MergeError> {
        override fun handle(response: HttpResponse): MergeError {
            try {
                return handler.handle(response)
            } catch (e: Exception) {
                return MergeError.builder().build()
            }
        }
    }
}

@JvmSynthetic
internal fun <T> Handler<T>.withErrorHandler(errorHandler: Handler<MergeError>): Handler<T> {
    return object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            when (val statusCode = response.statusCode()) {
                in 200..299 -> return this@withErrorHandler.handle(response)
                400 -> throw BadRequestException(response.headers(), errorHandler.handle(response))
                401 ->
                    throw UnauthorizedException(response.headers(), errorHandler.handle(response))
                403 ->
                    throw PermissionDeniedException(
                        response.headers(),
                        errorHandler.handle(response)
                    )
                404 -> throw NotFoundException(response.headers(), errorHandler.handle(response))
                422 ->
                    throw UnprocessableEntityException(
                        response.headers(),
                        errorHandler.handle(response)
                    )
                429 -> throw RateLimitException(response.headers(), errorHandler.handle(response))
                in 500..599 ->
                    throw InternalServerException(
                        statusCode,
                        response.headers(),
                        errorHandler.handle(response)
                    )
                else ->
                    throw UnexpectedStatusCodeException(
                        statusCode,
                        response.headers(),
                        StringHandler.handle(response)
                    )
            }
        }
    }
}
