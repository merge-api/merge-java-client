@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ticketing.Project
import dev.merge.api.models.ticketing.ProjectListPageAsync
import dev.merge.api.models.ticketing.ProjectListParams
import dev.merge.api.models.ticketing.ProjectListUsersPageAsync
import dev.merge.api.models.ticketing.ProjectListUsersParams
import dev.merge.api.models.ticketing.ProjectRetrieveParams
import java.util.concurrent.CompletableFuture

interface ProjectServiceAsync {

    /** Returns a `Project` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ProjectRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Project>

    /** Returns a list of `Project` objects. */
    @JvmOverloads
    fun list(
        params: ProjectListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ProjectListPageAsync>

    /** Returns a list of `User` objects. */
    @JvmOverloads
    fun listUsers(
        params: ProjectListUsersParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ProjectListUsersPageAsync>
}
