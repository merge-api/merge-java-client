@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Issue
import dev.merge.api.models.hris.IssueListPageAsync
import dev.merge.api.models.hris.IssueListParams
import dev.merge.api.models.hris.IssueRetrieveParams
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
