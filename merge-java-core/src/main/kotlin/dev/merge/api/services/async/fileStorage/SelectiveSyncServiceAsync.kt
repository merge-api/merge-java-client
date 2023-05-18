@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.fileStorage

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.fileStorage.SelectiveSyncListMetadataPageAsync
import dev.merge.api.models.fileStorage.SelectiveSyncListMetadataParams
import java.util.concurrent.CompletableFuture

interface SelectiveSyncServiceAsync {

    /** Get metadata for the conditions available to a linked account. */
    @JvmOverloads
    fun listMetadata(
        params: SelectiveSyncListMetadataParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<SelectiveSyncListMetadataPageAsync>
}
