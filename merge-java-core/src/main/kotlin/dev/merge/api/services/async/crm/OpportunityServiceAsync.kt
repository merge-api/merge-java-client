@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.Opportunity
import dev.merge.api.models.crm.OpportunityCreateParams
import dev.merge.api.models.crm.OpportunityListPageAsync
import dev.merge.api.models.crm.OpportunityListParams
import dev.merge.api.models.crm.OpportunityListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.OpportunityListRemoteFieldClassesParams
import dev.merge.api.models.crm.OpportunityResponse
import dev.merge.api.models.crm.OpportunityRetrieveParams
import dev.merge.api.models.crm.OpportunityUpdateParams
import dev.merge.api.services.async.crm.opportunities.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface OpportunityServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `Opportunity` object with the given values. */
    @JvmOverloads
    fun create(
        params: OpportunityCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<OpportunityResponse>

    /** Returns an `Opportunity` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: OpportunityRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Opportunity>

    /** Updates an `Opportunity` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: OpportunityUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<OpportunityResponse>

    /** Returns a list of `Opportunity` objects. */
    @JvmOverloads
    fun list(
        params: OpportunityListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<OpportunityListPageAsync>

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: OpportunityListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<OpportunityListRemoteFieldClassesPageAsync>
}
