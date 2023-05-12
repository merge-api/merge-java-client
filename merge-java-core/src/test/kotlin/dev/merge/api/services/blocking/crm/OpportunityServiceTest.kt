package dev.merge.api.services.blocking.crm

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.OpportunityListParams
import dev.merge.api.models.crm.OpportunityListRemoteFieldClassesParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class OpportunityServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val opportunityService = client.crm().opportunities()
        val opportunityResponse =
            opportunityService.create(
                OpportunityCreateParams.builder()
                    .model(
                        OpportunityCreateParams.OpportunityRequest.builder()
                            .name("Needs Integrations")
                            .description("Needs a Unified API for Integrations!")
                            .amount(123L)
                            .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                            .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                            .stage("1968cbc6-6040-430a-848e-aafacbadf4ad")
                            .status(
                                OpportunityCreateParams.OpportunityRequest.OpportunityStatusEnum
                                    .OPEN
                            )
                            .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                            .closeDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
        println(opportunityResponse)
        opportunityResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val opportunityService = client.crm().opportunities()
        val opportunity =
            opportunityService.retrieve(
                OpportunityRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(OpportunityRetrieveParams.Expand.ACCOUNT))
                    .includeRemoteData(true)
                    .includeRemoteFields(true)
                    .remoteFields(OpportunityRetrieveParams.RemoteFields.STATUS)
                    .showEnumOrigins(OpportunityRetrieveParams.ShowEnumOrigins.STATUS)
                    .build()
            )
        println(opportunity)
        opportunity.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val opportunityService = client.crm().opportunities()
        val opportunityResponse =
            opportunityService.update(
                OpportunityUpdateParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .model(
                        OpportunityUpdateParams.PatchedOpportunityRequest.builder()
                            .name("Needs Integrations")
                            .description("Needs a Unified API for Integrations!")
                            .amount(123L)
                            .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                            .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                            .stage("1968cbc6-6040-430a-848e-aafacbadf4ad")
                            .status(
                                OpportunityUpdateParams.PatchedOpportunityRequest
                                    .OpportunityStatusEnum
                                    .OPEN
                            )
                            .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                            .closeDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
        println(opportunityResponse)
        opportunityResponse.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val opportunityService = client.crm().opportunities()
        val paginatedOpportunityList =
            opportunityService.list(OpportunityListParams.builder().build())
        println(paginatedOpportunityList)
        paginatedOpportunityList.results().forEach { it.validate() }
    }

    @Test
    fun callListRemoteFieldClasses() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val opportunityService = client.crm().opportunities()
        val paginatedRemoteFieldClassList =
            opportunityService.listRemoteFieldClasses(
                OpportunityListRemoteFieldClassesParams.builder().build()
            )
        println(paginatedRemoteFieldClassList)
        paginatedRemoteFieldClassList.results().forEach { it.validate() }
    }
}
