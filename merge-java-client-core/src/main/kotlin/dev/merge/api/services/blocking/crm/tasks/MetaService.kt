@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm.tasks

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.TaskMetaForCreateParams
import dev.merge.api.models.crm.TaskMetaForUpdateParams

interface MetaService {

    /** Returns metadata for `Task` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: TaskMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse

    /** Returns metadata for `Task` PATCHs. */
    @JvmOverloads
    fun forUpdate(
        params: TaskMetaForUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}
