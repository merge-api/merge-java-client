@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.Engagement
import dev.merge.api.models.crm.EngagementCreateParams
import dev.merge.api.models.crm.EngagementListPage
import dev.merge.api.models.crm.EngagementListParams
import dev.merge.api.models.crm.EngagementListRemoteFieldClassesPage
import dev.merge.api.models.crm.EngagementListRemoteFieldClassesParams
import dev.merge.api.models.crm.EngagementResponse
import dev.merge.api.models.crm.EngagementRetrieveParams
import dev.merge.api.models.crm.EngagementUpdateParams
import dev.merge.api.services.blocking.crm.engagements.MetaService

interface EngagementService {

    fun meta(): MetaService

    /** Creates an `Engagement` object with the given values. */
    @JvmOverloads
    fun create(
        params: EngagementCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EngagementResponse

    /** Returns an `Engagement` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EngagementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Engagement

    /** Updates an `Engagement` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: EngagementUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EngagementResponse

    /** Returns a list of `Engagement` objects. */
    @JvmOverloads
    fun list(
        params: EngagementListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EngagementListPage

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: EngagementListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EngagementListRemoteFieldClassesPage
}
