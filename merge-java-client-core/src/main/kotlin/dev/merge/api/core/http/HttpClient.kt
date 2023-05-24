package dev.merge.api.core.http

import dev.merge.api.core.RequestOptions
import java.io.Closeable
import java.util.concurrent.CompletableFuture

interface HttpClient : Closeable {

    fun execute(
        request: HttpRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>
}
