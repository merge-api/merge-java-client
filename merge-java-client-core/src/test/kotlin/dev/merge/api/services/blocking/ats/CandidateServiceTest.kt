package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import dev.merge.api.models.ats.CandidateListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CandidateServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val candidateService = client.ats().candidates()
        val candidateResponse =
            candidateService.create(
                CandidateCreateParams.builder()
                    .model(
                        CandidateCreateParams.CandidateRequest.builder()
                            .firstName("Gil")
                            .lastName("Feig")
                            .company("Columbia Dining App.")
                            .title("Software Engineer")
                            .lastInteractionAt(OffsetDateTime.parse("2021-10-17T00:00:00Z"))
                            .isPrivate(true)
                            .canEmail(true)
                            .locations(listOf("string"))
                            .phoneNumbers(
                                listOf(
                                    CandidateCreateParams.CandidateRequest.PhoneNumberRequest
                                        .builder()
                                        .value("+3198675309")
                                        .phoneNumberType(
                                            CandidateCreateParams.CandidateRequest
                                                .PhoneNumberRequest
                                                .PhoneNumberTypeEnum
                                                .HOME
                                        )
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
                                        .phoneNumber("+3198675309")
                                        .build()
                                )
                            )
                            .emailAddresses(
                                listOf(
                                    CandidateCreateParams.CandidateRequest.EmailAddressRequest
                                        .builder()
                                        .value("merge_is_hiring@merge.dev")
                                        .emailAddressType(
                                            CandidateCreateParams.CandidateRequest
                                                .EmailAddressRequest
                                                .EmailAddressTypeEnum
                                                .PERSONAL
                                        )
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
                                        .emailAddress("merge_is_hiring@merge.dev")
                                        .build()
                                )
                            )
                            .urls(
                                listOf(
                                    CandidateCreateParams.CandidateRequest.UrlRequest.builder()
                                        .value("http://alturl.com/p749b")
                                        .urlType(
                                            CandidateCreateParams.CandidateRequest.UrlRequest
                                                .UrlTypeEnum
                                                .PERSONAL
                                        )
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
                            )
                            .tags(listOf("string"))
                            .applications(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .attachments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .remoteTemplateId("92830948203")
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
                    .remoteUserId("string")
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(candidateResponse)
        candidateResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val candidateService = client.ats().candidates()
        val candidate =
            candidateService.retrieve(
                CandidateRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(CandidateRetrieveParams.Expand.APPLICATIONS))
                    .includeRemoteData(true)
                    .build()
            )
        println(candidate)
        candidate.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val candidateService = client.ats().candidates()
        val paginatedCandidateList = candidateService.list(CandidateListParams.builder().build())
        println(paginatedCandidateList)
        paginatedCandidateList.results().forEach { it.validate() }
    }

    @Test
    fun callIgnoreRow() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val candidateService = client.ats().candidates()
        candidateService.ignoreRow(
            CandidateIgnoreRowParams.builder()
                .modelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .reason(CandidateIgnoreRowParams.ReasonEnum.GENERAL_CUSTOMER_REQUEST)
                .message("deletion request by user id 51903790-7dfe-4053-8d63-5a10cc4ffd39")
                .build()
        )
    }
}
