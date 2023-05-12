package dev.merge.api.services.blocking.crm

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.EngagementTypeListParams
import dev.merge.api.models.crm.EngagementTypeListRemoteFieldClassesParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EngagementTypeServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val engagementTypeService = client.crm().engagementTypes()
        val engagementType =
            engagementTypeService.retrieve(
                EngagementTypeRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .includeRemoteFields(true)
                    .build()
            )
        println(engagementType)
        engagementType.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val engagementTypeService = client.crm().engagementTypes()
        val paginatedEngagementTypeList =
            engagementTypeService.list(EngagementTypeListParams.builder().build())
        println(paginatedEngagementTypeList)
        paginatedEngagementTypeList.results().forEach { it.validate() }
    }

    @Test
    fun callListRemoteFieldClasses() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val engagementTypeService = client.crm().engagementTypes()
        val paginatedRemoteFieldClassList =
            engagementTypeService.listRemoteFieldClasses(
                EngagementTypeListRemoteFieldClassesParams.builder().build()
            )
        println(paginatedRemoteFieldClassList)
        paginatedRemoteFieldClassList.results().forEach { it.validate() }
    }
}
