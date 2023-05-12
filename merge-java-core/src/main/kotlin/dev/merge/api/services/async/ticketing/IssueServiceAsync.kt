@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Issue
import dev.merge.api.models.ticketing.IssueListPageAsync
import dev.merge.api.models.ticketing.IssueListParams
import dev.merge.api.models.ticketing.IssueRetrieveParams
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
