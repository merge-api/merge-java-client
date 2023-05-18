@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.Lead
import dev.merge.api.models.crm.LeadCreateParams
import dev.merge.api.models.crm.LeadListPageAsync
import dev.merge.api.models.crm.LeadListParams
import dev.merge.api.models.crm.LeadListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.LeadListRemoteFieldClassesParams
import dev.merge.api.models.crm.LeadResponse
import dev.merge.api.models.crm.LeadRetrieveParams
import dev.merge.api.services.async.crm.leads.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface LeadServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `Lead` object with the given values. */
    @JvmOverloads
    fun create(
        params: LeadCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<LeadResponse>

    /** Returns a `Lead` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: LeadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Lead>

    /** Returns a list of `Lead` objects. */
    @JvmOverloads
    fun list(
        params: LeadListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<LeadListPageAsync>

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: LeadListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<LeadListRemoteFieldClassesPageAsync>
}
