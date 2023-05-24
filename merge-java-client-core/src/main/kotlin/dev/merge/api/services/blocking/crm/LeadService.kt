@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.Lead
import dev.merge.api.models.crm.LeadCreateParams
import dev.merge.api.models.crm.LeadListPage
import dev.merge.api.models.crm.LeadListParams
import dev.merge.api.models.crm.LeadListRemoteFieldClassesPage
import dev.merge.api.models.crm.LeadListRemoteFieldClassesParams
import dev.merge.api.models.crm.LeadResponse
import dev.merge.api.models.crm.LeadRetrieveParams
import dev.merge.api.services.blocking.crm.leads.MetaService

interface LeadService {

    fun meta(): MetaService

    /** Creates a `Lead` object with the given values. */
    @JvmOverloads
    fun create(
        params: LeadCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LeadResponse

    /** Returns a `Lead` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: LeadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Lead

    /** Returns a list of `Lead` objects. */
    @JvmOverloads
    fun list(
        params: LeadListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LeadListPage

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: LeadListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LeadListRemoteFieldClassesPage
}
