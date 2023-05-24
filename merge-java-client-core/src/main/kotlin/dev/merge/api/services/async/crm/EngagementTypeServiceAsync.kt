@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.EngagementType
import dev.merge.api.models.crm.EngagementTypeListPageAsync
import dev.merge.api.models.crm.EngagementTypeListParams
import dev.merge.api.models.crm.EngagementTypeListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.EngagementTypeListRemoteFieldClassesParams
import dev.merge.api.models.crm.EngagementTypeRetrieveParams
import java.util.concurrent.CompletableFuture

interface EngagementTypeServiceAsync {

    /** Returns an `EngagementType` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EngagementTypeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EngagementType>

    /** Returns a list of `EngagementType` objects. */
    @JvmOverloads
    fun list(
        params: EngagementTypeListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EngagementTypeListPageAsync>

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: EngagementTypeListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EngagementTypeListRemoteFieldClassesPageAsync>
}
