package dev.merge.api.errors

import com.google.common.collect.ListMultimap

class UnprocessableEntityException
constructor(
    headers: ListMultimap<String, String>,
    private val error: MergeError,
) : MergeServiceException(headers, "${error}") {
    override fun statusCode(): Int = 422
    fun error(): MergeError = error
}
