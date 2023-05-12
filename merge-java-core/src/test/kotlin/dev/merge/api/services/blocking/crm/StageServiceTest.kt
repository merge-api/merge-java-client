package dev.merge.api.services.blocking.crm

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.StageListParams
import dev.merge.api.models.crm.StageListRemoteFieldClassesParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class StageServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val stageService = client.crm().stages()
        val stage =
            stageService.retrieve(
                StageRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .includeRemoteFields(true)
                    .build()
            )
        println(stage)
        stage.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val stageService = client.crm().stages()
        val paginatedStageList = stageService.list(StageListParams.builder().build())
        println(paginatedStageList)
        paginatedStageList.results().forEach { it.validate() }
    }

    @Test
    fun callListRemoteFieldClasses() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val stageService = client.crm().stages()
        val paginatedRemoteFieldClassList =
            stageService.listRemoteFieldClasses(StageListRemoteFieldClassesParams.builder().build())
        println(paginatedRemoteFieldClassList)
        paginatedRemoteFieldClassList.results().forEach { it.validate() }
    }
}
