package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import dev.merge.api.models.hris.PayGroupListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class PayGroupServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val payGroupService = client.hris().payGroups()
        val payGroup =
            payGroupService.retrieve(
                PayGroupRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .build()
            )
        println(payGroup)
        payGroup.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val payGroupService = client.hris().payGroups()
        val paginatedPayGroupList = payGroupService.list(PayGroupListParams.builder().build())
        println(paginatedPayGroupList)
        paginatedPayGroupList.results().forEach { it.validate() }
    }
}
