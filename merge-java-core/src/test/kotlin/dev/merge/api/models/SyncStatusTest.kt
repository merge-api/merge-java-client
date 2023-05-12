package dev.merge.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SyncStatusTest {

    @Test
    fun createSyncStatus() {
        val syncStatus =
            SyncStatus.builder()
                .modelName("File")
                .modelId("filestorage.FileStorageFile")
                .lastSyncStart(OffsetDateTime.parse("2021-03-30T19:44:18.695973Z"))
                .nextSyncStart(OffsetDateTime.parse("2021-03-30T20:44:18.662942Z"))
                .status(SyncStatus.SyncStatusStatusEnum.SYNCING)
                .isInitialSync(true)
                .selectiveSyncConfigurationsUsage(
                    SyncStatus.SelectiveSyncConfigurationsUsageEnum.IN_NEXT_SYNC
                )
                .build()
        assertThat(syncStatus).isNotNull
        assertThat(syncStatus.modelName()).isEqualTo("File")
        assertThat(syncStatus.modelId()).isEqualTo("filestorage.FileStorageFile")
        assertThat(syncStatus.lastSyncStart())
            .contains(OffsetDateTime.parse("2021-03-30T19:44:18.695973Z"))
        assertThat(syncStatus.nextSyncStart())
            .contains(OffsetDateTime.parse("2021-03-30T20:44:18.662942Z"))
        assertThat(syncStatus.status()).isEqualTo(SyncStatus.SyncStatusStatusEnum.SYNCING)
        assertThat(syncStatus.isInitialSync()).isEqualTo(true)
        assertThat(syncStatus.selectiveSyncConfigurationsUsage())
            .contains(SyncStatus.SelectiveSyncConfigurationsUsageEnum.IN_NEXT_SYNC)
    }
}
