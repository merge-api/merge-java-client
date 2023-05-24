@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm.customObjects

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.CustomObjectMetaForCreateParams
import dev.merge.api.models.crm.CustomObjectMetaForUpdateParams
import java.util.concurrent.CompletableFuture

interface MetaServiceAsync {

    /** Returns metadata for `CRMCustomObject` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: CustomObjectMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<MetaResponse>

    /** Returns metadata for `CRMCustomObject` PATCHs. */
    @JvmOverloads
    fun forUpdate(
        params: CustomObjectMetaForUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<MetaResponse>
}
