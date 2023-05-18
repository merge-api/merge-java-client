@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm.customObjectClasses.associationTypes

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.CustomObjectClassAssociationTypeMetaForCreateParams

interface MetaService {

    /** Returns metadata for `CRMAssociationType` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: CustomObjectClassAssociationTypeMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}
