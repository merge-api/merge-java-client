package dev.merge.api.services.blocking.crm

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.EngagementListParams
import dev.merge.api.models.crm.EngagementListRemoteFieldClassesParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EngagementServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val engagementService = client.crm().engagements()
        val engagementResponse =
            engagementService.create(
                EngagementCreateParams.builder()
                    .model(
                        EngagementCreateParams.EngagementRequest.builder()
                            .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                            .content("Call for negotiation")
                            .subject("Call from customer")
                            .direction(
                                EngagementCreateParams.EngagementRequest.DirectionEnum.INBOUND
                            )
                            .engagementType("0358cbc6-2040-430a-848e-aafacbadf3aa")
                            .startTime(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                            .endTime(OffsetDateTime.parse("2022-02-10T00:05:00Z"))
                            .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                            .contacts(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
                            .remoteFields(
                                listOf(
                                    EngagementCreateParams.EngagementRequest.RemoteFieldRequest
                                        .builder()
                                        .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                        .value(JsonString.of("abc"))
                                        .build()
                                )
                            )
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(engagementResponse)
        engagementResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val engagementService = client.crm().engagements()
        val engagement =
            engagementService.retrieve(
                EngagementRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(EngagementRetrieveParams.Expand.ACCOUNT))
                    .includeRemoteData(true)
                    .includeRemoteFields(true)
                    .build()
            )
        println(engagement)
        engagement.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val engagementService = client.crm().engagements()
        val engagementResponse =
            engagementService.update(
                EngagementUpdateParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .model(
                        EngagementUpdateParams.PatchedEngagementRequest.builder()
                            .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                            .content("Call for negotiation")
                            .subject("Call from customer")
                            .direction(
                                EngagementUpdateParams.PatchedEngagementRequest.DirectionEnum
                                    .INBOUND
                            )
                            .engagementType("0358cbc6-2040-430a-848e-aafacbadf3aa")
                            .startTime(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                            .endTime(OffsetDateTime.parse("2022-02-10T00:05:00Z"))
                            .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                            .contacts(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
                            .remoteFields(
                                listOf(
                                    EngagementUpdateParams.PatchedEngagementRequest
                                        .RemoteFieldRequest
                                        .builder()
                                        .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                        .value(JsonString.of("abc"))
                                        .build()
                                )
                            )
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(engagementResponse)
        engagementResponse.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val engagementService = client.crm().engagements()
        val paginatedEngagementList = engagementService.list(EngagementListParams.builder().build())
        println(paginatedEngagementList)
        paginatedEngagementList.results().forEach { it.validate() }
    }

    @Test
    fun callListRemoteFieldClasses() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val engagementService = client.crm().engagements()
        val paginatedRemoteFieldClassList =
            engagementService.listRemoteFieldClasses(
                EngagementListRemoteFieldClassesParams.builder().build()
            )
        println(paginatedRemoteFieldClassList)
        paginatedRemoteFieldClassList.results().forEach { it.validate() }
    }
}
