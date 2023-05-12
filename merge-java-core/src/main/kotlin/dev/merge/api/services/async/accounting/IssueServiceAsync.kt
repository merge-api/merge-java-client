@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Issue
import dev.merge.api.models.accounting.IssueListPageAsync
import dev.merge.api.models.accounting.IssueListParams
import dev.merge.api.models.accounting.IssueRetrieveParams
import java.util.concurrent.CompletableFuture

interface IssueServiceAsync {

    /** Get a specific issue. */
    @JvmOverloads
    fun retrieve(
        params: IssueRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Issue>

    /** Gets issues. */
    @JvmOverloads
    fun list(
        params: IssueListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<IssueListPageAsync>
}
