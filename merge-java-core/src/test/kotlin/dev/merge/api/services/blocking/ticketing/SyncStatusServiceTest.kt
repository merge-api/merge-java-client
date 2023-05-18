package dev.merge.api.services.blocking.ticketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ticketing.*
import dev.merge.api.models.ticketing.SyncStatusListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class SyncStatusServiceTest {

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val syncStatusService = client.ticketing().syncStatus()
        val paginatedSyncStatusList = syncStatusService.list(SyncStatusListParams.builder().build())
        println(paginatedSyncStatusList)
        paginatedSyncStatusList.results().forEach { it.validate() }
    }

    @Test
    fun callResync() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val syncStatusService = client.ticketing().syncStatus()
        val syncStatusResyncResponse =
            syncStatusService.resync(SyncStatusResyncParams.builder().build())
        println(syncStatusResyncResponse)
        for (syncStatus: SyncStatus in syncStatusResyncResponse) {
            syncStatus.validate()
        }
    }
}
