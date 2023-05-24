@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.EngagementType
import dev.merge.api.models.crm.EngagementTypeListPage
import dev.merge.api.models.crm.EngagementTypeListParams
import dev.merge.api.models.crm.EngagementTypeListRemoteFieldClassesPage
import dev.merge.api.models.crm.EngagementTypeListRemoteFieldClassesParams
import dev.merge.api.models.crm.EngagementTypeRetrieveParams

interface EngagementTypeService {

    /** Returns an `EngagementType` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EngagementTypeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EngagementType

    /** Returns a list of `EngagementType` objects. */
    @JvmOverloads
    fun list(
        params: EngagementTypeListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EngagementTypeListPage

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: EngagementTypeListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EngagementTypeListRemoteFieldClassesPage
}
