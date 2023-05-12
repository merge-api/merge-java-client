@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.CustomObject
import dev.merge.api.models.crm.CustomObjectCreateParams
import dev.merge.api.models.crm.CustomObjectListPageAsync
import dev.merge.api.models.crm.CustomObjectListParams
import dev.merge.api.models.crm.CustomObjectResponse
import dev.merge.api.models.crm.CustomObjectRetrieveParams
import dev.merge.api.models.crm.CustomObjectUpdateParams
import dev.merge.api.services.async.crm.customObjects.GeneratorServiceAsync
import dev.merge.api.services.async.crm.customObjects.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface CustomObjectServiceAsync {

    fun meta(): MetaServiceAsync

    fun generators(): GeneratorServiceAsync

    /** Creates a `CustomObject` object with the given values. */
    @JvmOverloads
    fun create(
        params: CustomObjectCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CustomObjectResponse>

    /** Returns a `CustomObject` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CustomObjectRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CustomObject>

    /** Updates a `CustomObject` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: CustomObjectUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CustomObjectResponse>

    /** Returns a list of `CustomObject` objects. */
    @JvmOverloads
    fun list(
        params: CustomObjectListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CustomObjectListPageAsync>
}
