@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm.customObjectClasses

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.AssociationType
import dev.merge.api.models.crm.AssociationTypeResponse
import dev.merge.api.models.crm.CustomObjectClassAssociationTypeCreateParams
import dev.merge.api.models.crm.CustomObjectClassAssociationTypeListPageAsync
import dev.merge.api.models.crm.CustomObjectClassAssociationTypeListParams
import dev.merge.api.models.crm.CustomObjectClassAssociationTypeRetrieveParams
import dev.merge.api.services.async.crm.customObjectClasses.associationTypes.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface AssociationTypeServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `AssociationType` object with the given values. */
    @JvmOverloads
    fun create(
        params: CustomObjectClassAssociationTypeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AssociationTypeResponse>

    /** Returns an `AssociationType` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CustomObjectClassAssociationTypeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AssociationType>

    /** Returns a list of `AssociationType` objects. */
    @JvmOverloads
    fun list(
        params: CustomObjectClassAssociationTypeListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CustomObjectClassAssociationTypeListPageAsync>
}
