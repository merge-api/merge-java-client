@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.fileStorage

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.fileStorage.Drive
import dev.merge.api.models.fileStorage.DriveListPageAsync
import dev.merge.api.models.fileStorage.DriveListParams
import dev.merge.api.models.fileStorage.DriveRetrieveParams
import java.util.concurrent.CompletableFuture

interface DriveServiceAsync {

    /** Returns a `Drive` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: DriveRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Drive>

    /** Returns a list of `Drive` objects. */
    @JvmOverloads
    fun list(
        params: DriveListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<DriveListPageAsync>
}
