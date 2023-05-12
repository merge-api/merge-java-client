@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.SyncStatus
import dev.merge.api.models.marketing.SyncStatusListPage
import dev.merge.api.models.marketing.SyncStatusListParams
import dev.merge.api.models.marketing.SyncStatusResyncParams

interface SyncStatusService {

    /** Get syncing status. Possible values: `DISABLED`, `DONE`, `FAILED`, `PAUSED`, `SYNCING` */
    @JvmOverloads
    fun list(
        params: SyncStatusListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): SyncStatusListPage

    /**
     * Force re-sync of all models. This is available for all organizations via the dashboard. Force
     * re-sync is also available programmatically via API for monthly, quarterly, and highest sync
     * frequency customers on the Core, Professional, or Enterprise plans. Doing so will consume a
     * sync credit for the relevant linked account.
     */
    @JvmOverloads
    fun resync(
        params: SyncStatusResyncParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): List<SyncStatus>
}
