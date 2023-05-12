package dev.merge.api.services.blocking.crm

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.LeadListParams
import dev.merge.api.models.crm.LeadListRemoteFieldClassesParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class LeadServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val leadService = client.crm().leads()
        val leadResponse =
            leadService.create(
                LeadCreateParams.builder()
                    .model(
                        LeadCreateParams.LeadRequest.builder()
                            .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                            .leadSource("API Blogger")
                            .title("Co-Founder")
                            .company("Merge API")
                            .firstName("Gil")
                            .lastName("Feig")
                            .addresses(
                                listOf(
                                    LeadCreateParams.LeadRequest.AddressRequest.builder()
                                        .street1("50 Bowling Green Dr")
                                        .street2("Golden Gate Park")
                                        .city("San Francisco")
                                        .state("CA")
                                        .postalCode("94122")
                                        .country(Country.AF)
                                        .addressType(
                                            LeadCreateParams.LeadRequest.AddressRequest
                                                .AddressTypeEnum
                                                .BILLING
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
                            .emailAddresses(
                                listOf(
                                    LeadCreateParams.LeadRequest.EmailAddressRequest.builder()
                                        .value("merge_is_hiring@merge.dev")
                                        .emailAddressType(
                                            LeadCreateParams.LeadRequest.EmailAddressRequest
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
                            .phoneNumbers(
                                listOf(
                                    LeadCreateParams.LeadRequest.PhoneNumberRequest.builder()
                                        .value("+3198675309")
                                        .phoneNumberType(
                                            LeadCreateParams.LeadRequest.PhoneNumberRequest
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
                            .convertedDate(OffsetDateTime.parse("2022-03-10T00:00:00Z"))
                            .convertedContact("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                            .convertedAccount("9c9de072-29cf-48e3-9578-1ca5b145b40e")
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
        println(leadResponse)
        leadResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val leadService = client.crm().leads()
        val lead =
            leadService.retrieve(
                LeadRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(LeadRetrieveParams.Expand.CONVERTED_ACCOUNT))
                    .includeRemoteData(true)
                    .includeRemoteFields(true)
                    .build()
            )
        println(lead)
        lead.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val leadService = client.crm().leads()
        val paginatedLeadList = leadService.list(LeadListParams.builder().build())
        println(paginatedLeadList)
        paginatedLeadList.results().forEach { it.validate() }
    }

    @Test
    fun callListRemoteFieldClasses() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val leadService = client.crm().leads()
        val paginatedRemoteFieldClassList =
            leadService.listRemoteFieldClasses(LeadListRemoteFieldClassesParams.builder().build())
        println(paginatedRemoteFieldClassList)
        paginatedRemoteFieldClassList.results().forEach { it.validate() }
    }
}
