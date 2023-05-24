@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.CustomObjectClass
import dev.merge.api.models.crm.CustomObjectClassListPage
import dev.merge.api.models.crm.CustomObjectClassListParams
import dev.merge.api.models.crm.CustomObjectClassRetrieveParams
import dev.merge.api.services.blocking.crm.customObjectClasses.AssociationTypeService

interface CustomObjectClassService {

    fun associationTypes(): AssociationTypeService

    /** Returns a `CustomObjectClass` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CustomObjectClassRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CustomObjectClass

    /** Returns a list of `CustomObjectClass` objects. */
    @JvmOverloads
    fun list(
        params: CustomObjectClassListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CustomObjectClassListPage
}
