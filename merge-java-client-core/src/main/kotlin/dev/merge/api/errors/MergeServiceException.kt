package dev.merge.api.errors

import com.google.common.collect.ListMultimap

abstract class MergeServiceException
@JvmOverloads
constructor(
    private val headers: ListMultimap<String, String>,
    message: String? = null,
    cause: Throwable? = null
) : MergeException(message, cause) {
    abstract fun statusCode(): Int
    fun headers(): ListMultimap<String, String> = headers
}
