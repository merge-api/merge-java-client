package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.fileStorage.*
import dev.merge.api.models.fileStorage.SelectiveSyncListMetadataParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class SelectiveSyncServiceTest {

    @Test
    fun callListMetadata() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val selectiveSyncService = client.fileStorage().selectiveSync()
        val paginatedConditionSchemaList =
            selectiveSyncService.listMetadata(SelectiveSyncListMetadataParams.builder().build())
        println(paginatedConditionSchemaList)
        paginatedConditionSchemaList.results().forEach { it.validate() }
    }
}
