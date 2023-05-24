@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.fileStorage.folders

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.fileStorage.FolderMetaForCreateParams

interface MetaService {

    /** Returns metadata for `FileStorageFolder` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: FolderMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}
