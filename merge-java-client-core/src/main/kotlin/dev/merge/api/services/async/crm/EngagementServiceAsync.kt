@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.Engagement
import dev.merge.api.models.crm.EngagementCreateParams
import dev.merge.api.models.crm.EngagementListPageAsync
import dev.merge.api.models.crm.EngagementListParams
import dev.merge.api.models.crm.EngagementListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.EngagementListRemoteFieldClassesParams
import dev.merge.api.models.crm.EngagementResponse
import dev.merge.api.models.crm.EngagementRetrieveParams
import dev.merge.api.models.crm.EngagementUpdateParams
import dev.merge.api.services.async.crm.engagements.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface EngagementServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `Engagement` object with the given values. */
    @JvmOverloads
    fun create(
        params: EngagementCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EngagementResponse>

    /** Returns an `Engagement` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EngagementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Engagement>

    /** Updates an `Engagement` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: EngagementUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EngagementResponse>

    /** Returns a list of `Engagement` objects. */
    @JvmOverloads
    fun list(
        params: EngagementListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EngagementListPageAsync>

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: EngagementListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EngagementListRemoteFieldClassesPageAsync>
}
