package dev.merge.api.errors

import com.google.common.collect.ListMultimap

class NotFoundException
constructor(
    headers: ListMultimap<String, String>,
    private val error: MergeError,
) : MergeServiceException(headers, "${error}") {
    override fun statusCode(): Int = 404
    fun error(): MergeError = error
}
