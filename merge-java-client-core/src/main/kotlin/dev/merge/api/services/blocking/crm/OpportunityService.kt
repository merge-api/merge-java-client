@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.Opportunity
import dev.merge.api.models.crm.OpportunityCreateParams
import dev.merge.api.models.crm.OpportunityListPage
import dev.merge.api.models.crm.OpportunityListParams
import dev.merge.api.models.crm.OpportunityListRemoteFieldClassesPage
import dev.merge.api.models.crm.OpportunityListRemoteFieldClassesParams
import dev.merge.api.models.crm.OpportunityResponse
import dev.merge.api.models.crm.OpportunityRetrieveParams
import dev.merge.api.models.crm.OpportunityUpdateParams
import dev.merge.api.services.blocking.crm.opportunities.MetaService

interface OpportunityService {

    fun meta(): MetaService

    /** Creates an `Opportunity` object with the given values. */
    @JvmOverloads
    fun create(
        params: OpportunityCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OpportunityResponse

    /** Returns an `Opportunity` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: OpportunityRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Opportunity

    /** Updates an `Opportunity` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: OpportunityUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OpportunityResponse

    /** Returns a list of `Opportunity` objects. */
    @JvmOverloads
    fun list(
        params: OpportunityListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OpportunityListPage

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: OpportunityListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OpportunityListRemoteFieldClassesPage
}
