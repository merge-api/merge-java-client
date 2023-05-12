package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.SelectiveSyncListMetadataParams
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
        val selectiveSyncService = client.accounting().selectiveSync()
        val paginatedConditionSchemaList =
            selectiveSyncService.listMetadata(SelectiveSyncListMetadataParams.builder().build())
        println(paginatedConditionSchemaList)
        paginatedConditionSchemaList.results().forEach { it.validate() }
    }
}
