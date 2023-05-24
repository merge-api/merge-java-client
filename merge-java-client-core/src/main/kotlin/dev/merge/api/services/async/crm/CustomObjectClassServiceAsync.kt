@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.CustomObjectClass
import dev.merge.api.models.crm.CustomObjectClassListPageAsync
import dev.merge.api.models.crm.CustomObjectClassListParams
import dev.merge.api.models.crm.CustomObjectClassRetrieveParams
import dev.merge.api.services.async.crm.customObjectClasses.AssociationTypeServiceAsync
import java.util.concurrent.CompletableFuture

interface CustomObjectClassServiceAsync {

    fun associationTypes(): AssociationTypeServiceAsync

    /** Returns a `CustomObjectClass` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CustomObjectClassRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CustomObjectClass>

    /** Returns a list of `CustomObjectClass` objects. */
    @JvmOverloads
    fun list(
        params: CustomObjectClassListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CustomObjectClassListPageAsync>
}
