@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.Task
import dev.merge.api.models.crm.TaskCreateParams
import dev.merge.api.models.crm.TaskCreateResponse
import dev.merge.api.models.crm.TaskListPageAsync
import dev.merge.api.models.crm.TaskListParams
import dev.merge.api.models.crm.TaskListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.TaskListRemoteFieldClassesParams
import dev.merge.api.models.crm.TaskRetrieveParams
import dev.merge.api.models.crm.TaskUpdateParams
import dev.merge.api.services.async.crm.tasks.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface TaskServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `Task` object with the given values. */
    @JvmOverloads
    fun create(
        params: TaskCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TaskCreateResponse>

    /** Returns a `Task` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TaskRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Task>

    /** Updates a `Task` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: TaskUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TaskCreateResponse>

    /** Returns a list of `Task` objects. */
    @JvmOverloads
    fun list(
        params: TaskListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TaskListPageAsync>

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: TaskListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TaskListRemoteFieldClassesPageAsync>
}
