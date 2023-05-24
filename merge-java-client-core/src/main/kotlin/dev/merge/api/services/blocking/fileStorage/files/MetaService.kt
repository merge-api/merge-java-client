@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.fileStorage.files

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.fileStorage.FileMetaForCreateParams

interface MetaService {

    /** Returns metadata for `FileStorageFile` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: FileMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}
