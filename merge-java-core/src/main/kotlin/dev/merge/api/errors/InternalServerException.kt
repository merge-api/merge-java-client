package dev.merge.api.errors

import com.google.common.collect.ListMultimap

class InternalServerException
constructor(
    private val statusCode: Int,
    headers: ListMultimap<String, String>,
    private val error: MergeError,
) : MergeServiceException(headers, "${error}") {
    override fun statusCode(): Int = statusCode
    fun error(): MergeError = error
}
