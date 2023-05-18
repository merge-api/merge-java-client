package dev.merge.api.services.blocking.marketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.marketing.*
import dev.merge.api.models.marketing.CampaignListContactsParams
import dev.merge.api.models.marketing.CampaignListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CampaignServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val campaignService = client.marketing().campaigns()
        val campaignResponse =
            campaignService.create(
                CampaignCreateParams.builder()
                    .model(
                        CampaignCreateParams.CampaignRequest.builder()
                            .name("New Customer Campaign")
                            .uniqueOpens(123L)
                            .emailsSent(123L)
                            .integrationParams(
                                JsonValue.from(
                                    mapOf(
                                        "unique_integration_field" to
                                            "unique_integration_field_value"
                                    )
                                )
                            )
                            .linkedAccountParams(
                                JsonValue.from(
                                    mapOf(
                                        "unique_linked_account_field" to
                                            "unique_linked_account_field_value"
                                    )
                                )
                            )
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(campaignResponse)
        campaignResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val campaignService = client.marketing().campaigns()
        val campaign =
            campaignService.retrieve(
                CampaignRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .build()
            )
        println(campaign)
        campaign.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val campaignService = client.marketing().campaigns()
        val paginatedCampaignList = campaignService.list(CampaignListParams.builder().build())
        println(paginatedCampaignList)
        paginatedCampaignList.results().forEach { it.validate() }
    }

    @Test
    fun callListContacts() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val campaignService = client.marketing().campaigns()
        val paginatedContactList =
            campaignService.listContacts(
                CampaignListContactsParams.builder()
                    .parentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(paginatedContactList)
        paginatedContactList.results().forEach { it.validate() }
    }
}
