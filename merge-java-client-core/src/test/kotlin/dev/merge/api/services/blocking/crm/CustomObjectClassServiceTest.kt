package dev.merge.api.services.blocking.crm

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.CustomObjectClassListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CustomObjectClassServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val customObjectClassService = client.crm().customObjectClasses()
        val customObjectClass =
            customObjectClassService.retrieve(
                CustomObjectClassRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(CustomObjectClassRetrieveParams.Expand.FIELDS))
                    .includeRemoteData(true)
                    .build()
            )
        println(customObjectClass)
        customObjectClass.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val customObjectClassService = client.crm().customObjectClasses()
        val paginatedCustomObjectClassList =
            customObjectClassService.list(CustomObjectClassListParams.builder().build())
        println(paginatedCustomObjectClassList)
        paginatedCustomObjectClassList.results().forEach { it.validate() }
    }
}
