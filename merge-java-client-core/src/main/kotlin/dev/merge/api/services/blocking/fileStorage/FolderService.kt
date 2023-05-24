@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.fileStorage.Folder
import dev.merge.api.models.fileStorage.FolderCreateParams
import dev.merge.api.models.fileStorage.FolderListPage
import dev.merge.api.models.fileStorage.FolderListParams
import dev.merge.api.models.fileStorage.FolderResponse
import dev.merge.api.models.fileStorage.FolderRetrieveParams
import dev.merge.api.services.blocking.fileStorage.folders.MetaService

interface FolderService {

    fun meta(): MetaService

    /** Creates a `Folder` object with the given values. */
    @JvmOverloads
    fun create(
        params: FolderCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): FolderResponse

    /** Returns a `Folder` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: FolderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Folder

    /** Returns a list of `Folder` objects. */
    @JvmOverloads
    fun list(
        params: FolderListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): FolderListPage
}
