@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Issue
import dev.merge.api.models.marketing.IssueListPageAsync
import dev.merge.api.models.marketing.IssueListParams
import dev.merge.api.models.marketing.IssueRetrieveParams
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
