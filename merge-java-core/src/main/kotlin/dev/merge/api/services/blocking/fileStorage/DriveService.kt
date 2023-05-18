@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.fileStorage.Drive
import dev.merge.api.models.fileStorage.DriveListPage
import dev.merge.api.models.fileStorage.DriveListParams
import dev.merge.api.models.fileStorage.DriveRetrieveParams

interface DriveService {

    /** Returns a `Drive` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: DriveRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Drive

    /** Returns a list of `Drive` objects. */
    @JvmOverloads
    fun list(
        params: DriveListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DriveListPage
}
