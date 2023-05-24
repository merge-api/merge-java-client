@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.Location
import dev.merge.api.models.hris.LocationListPageAsync
import dev.merge.api.models.hris.LocationListParams
import dev.merge.api.models.hris.LocationRetrieveParams
import java.util.concurrent.CompletableFuture

interface LocationServiceAsync {

    /** Returns a `Location` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: LocationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Location>

    /** Returns a list of `Location` objects. */
    @JvmOverloads
    fun list(
        params: LocationListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<LocationListPageAsync>
}
