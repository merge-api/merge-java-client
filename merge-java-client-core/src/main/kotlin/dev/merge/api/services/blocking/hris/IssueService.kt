@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Issue
import dev.merge.api.models.hris.IssueListPage
import dev.merge.api.models.hris.IssueListParams
import dev.merge.api.models.hris.IssueRetrieveParams

interface IssueService {

    /** Get a specific issue. */
    @JvmOverloads
    fun retrieve(
        params: IssueRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Issue

    /** Gets issues. */
    @JvmOverloads
    fun list(
        params: IssueListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IssueListPage
}
