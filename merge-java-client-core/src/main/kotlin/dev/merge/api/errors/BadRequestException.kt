package dev.merge.api.errors

import com.google.common.collect.ListMultimap

class BadRequestException
constructor(
    headers: ListMultimap<String, String>,
    private val error: MergeError,
) : MergeServiceException(headers, "${error}") {
    override fun statusCode(): Int = 400
    fun error(): MergeError = error
}
