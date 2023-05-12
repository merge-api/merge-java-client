package dev.merge.api.models.crm

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LeadCreateParamsTest {

    @Test
    fun createLeadCreateParams() {
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
                                    LeadCreateParams.LeadRequest.AddressRequest.AddressTypeEnum
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
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
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
                                        LeadCreateParams.LeadRequest.AddressRequest.AddressTypeEnum
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
                                    "unique_integration_field" to "unique_integration_field_value"
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
        val expected = mutableMapOf<String, List<String>>()
        expected.put("is_debug_mode", listOf("true"))
        expected.put("run_async", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            LeadCreateParams.builder().model(LeadCreateParams.LeadRequest.builder().build()).build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
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
                                        LeadCreateParams.LeadRequest.AddressRequest.AddressTypeEnum
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
                                    "unique_integration_field" to "unique_integration_field_value"
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
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
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
                                    LeadCreateParams.LeadRequest.AddressRequest.AddressTypeEnum
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
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            LeadCreateParams.builder().model(LeadCreateParams.LeadRequest.builder().build()).build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(LeadCreateParams.LeadRequest.builder().build())
    }
}
