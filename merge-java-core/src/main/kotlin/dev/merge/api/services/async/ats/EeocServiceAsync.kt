@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Eeoc
import dev.merge.api.models.ats.EeocListPageAsync
import dev.merge.api.models.ats.EeocListParams
import dev.merge.api.models.ats.EeocRetrieveParams
import java.util.concurrent.CompletableFuture

interface EeocServiceAsync {

    /** Returns an `EEOC` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EeocRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Eeoc>

    /** Returns a list of `EEOC` objects. */
    @JvmOverloads
    fun list(
        params: EeocListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EeocListPageAsync>
}
