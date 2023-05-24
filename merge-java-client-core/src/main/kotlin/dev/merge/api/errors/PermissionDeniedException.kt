package dev.merge.api.errors

import com.google.common.collect.ListMultimap

class PermissionDeniedException
constructor(
    headers: ListMultimap<String, String>,
    private val error: MergeError,
) : MergeServiceException(headers, "${error}") {
    override fun statusCode(): Int = 403
    fun error(): MergeError = error
}
