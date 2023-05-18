@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.Task
import dev.merge.api.models.crm.TaskCreateParams
import dev.merge.api.models.crm.TaskCreateResponse
import dev.merge.api.models.crm.TaskListPage
import dev.merge.api.models.crm.TaskListParams
import dev.merge.api.models.crm.TaskListRemoteFieldClassesPage
import dev.merge.api.models.crm.TaskListRemoteFieldClassesParams
import dev.merge.api.models.crm.TaskRetrieveParams
import dev.merge.api.models.crm.TaskUpdateParams
import dev.merge.api.services.blocking.crm.tasks.MetaService

interface TaskService {

    fun meta(): MetaService

    /** Creates a `Task` object with the given values. */
    @JvmOverloads
    fun create(
        params: TaskCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TaskCreateResponse

    /** Returns a `Task` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TaskRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Task

    /** Updates a `Task` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: TaskUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TaskCreateResponse

    /** Returns a list of `Task` objects. */
    @JvmOverloads
    fun list(
        params: TaskListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TaskListPage

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: TaskListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TaskListRemoteFieldClassesPage
}
