@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.Stage
import dev.merge.api.models.crm.StageListPageAsync
import dev.merge.api.models.crm.StageListParams
import dev.merge.api.models.crm.StageListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.StageListRemoteFieldClassesParams
import dev.merge.api.models.crm.StageRetrieveParams
import java.util.concurrent.CompletableFuture

interface StageServiceAsync {

    /** Returns a `Stage` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: StageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Stage>

    /** Returns a list of `Stage` objects. */
    @JvmOverloads
    fun list(
        params: StageListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<StageListPageAsync>

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: StageListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<StageListRemoteFieldClassesPageAsync>
}
