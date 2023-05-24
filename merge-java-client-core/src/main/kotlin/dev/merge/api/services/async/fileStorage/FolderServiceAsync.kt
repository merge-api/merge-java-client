@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.fileStorage

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.fileStorage.Folder
import dev.merge.api.models.fileStorage.FolderCreateParams
import dev.merge.api.models.fileStorage.FolderListPageAsync
import dev.merge.api.models.fileStorage.FolderListParams
import dev.merge.api.models.fileStorage.FolderResponse
import dev.merge.api.models.fileStorage.FolderRetrieveParams
import dev.merge.api.services.async.fileStorage.folders.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface FolderServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `Folder` object with the given values. */
    @JvmOverloads
    fun create(
        params: FolderCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FolderResponse>

    /** Returns a `Folder` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: FolderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Folder>

    /** Returns a list of `Folder` objects. */
    @JvmOverloads
    fun list(
        params: FolderListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FolderListPageAsync>
}
