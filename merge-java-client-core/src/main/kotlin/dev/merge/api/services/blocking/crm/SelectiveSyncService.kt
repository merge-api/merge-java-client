@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.SelectiveSyncListMetadataPage
import dev.merge.api.models.crm.SelectiveSyncListMetadataParams

interface SelectiveSyncService {

    /** Get metadata for the conditions available to a linked account. */
    @JvmOverloads
    fun listMetadata(
        params: SelectiveSyncListMetadataParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): SelectiveSyncListMetadataPage
}
