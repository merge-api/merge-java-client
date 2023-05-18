@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.fileStorage.File
import dev.merge.api.models.fileStorage.FileCreateParams
import dev.merge.api.models.fileStorage.FileDownloadParams
import dev.merge.api.models.fileStorage.FileListPage
import dev.merge.api.models.fileStorage.FileListParams
import dev.merge.api.models.fileStorage.FileResponse
import dev.merge.api.models.fileStorage.FileRetrieveParams
import dev.merge.api.services.blocking.fileStorage.files.MetaService

interface FileService {

    fun meta(): MetaService

    /** Creates a `File` object with the given values. */
    @JvmOverloads
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): FileResponse

    /** Returns a `File` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): File

    /** Returns a list of `File` objects. */
    @JvmOverloads
    fun list(
        params: FileListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): FileListPage

    /** Returns a `File` object with the given `id`. */
    @JvmOverloads
    fun download(params: FileDownloadParams, requestOptions: RequestOptions = RequestOptions.none())
}
