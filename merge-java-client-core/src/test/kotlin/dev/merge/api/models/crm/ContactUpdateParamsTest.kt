package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ContactUpdateParamsTest {

    @Test
    fun createContactUpdateParams() {
        ContactUpdateParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .model(
                ContactUpdateParams.PatchedContactRequest.builder()
                    .firstName("Gil")
                    .lastName("Feig")
                    .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .addresses(
                        listOf(
                            ContactUpdateParams.PatchedContactRequest.AddressRequest.builder()
                                .street1("50 Bowling Green Dr")
                                .street2("Golden Gate Park")
                                .city("San Francisco")
                                .state("CA")
                                .postalCode("94122")
                                .country(Country.AF)
                                .addressType(
                                    ContactUpdateParams.PatchedContactRequest.AddressRequest
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
                            ContactUpdateParams.PatchedContactRequest.EmailAddressRequest.builder()
                                .value("merge_is_hiring@merge.dev")
                                .emailAddressType(
                                    ContactUpdateParams.PatchedContactRequest.EmailAddressRequest
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
                            ContactUpdateParams.PatchedContactRequest.PhoneNumberRequest.builder()
                                .value("+3198675309")
                                .phoneNumberType(
                                    ContactUpdateParams.PatchedContactRequest.PhoneNumberRequest
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
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                    .remoteFields(
                        listOf(
                            ContactUpdateParams.PatchedContactRequest.RemoteFieldRequest.builder()
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
    }

    @Test
    fun getQueryParams() {
        val params =
            ContactUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    ContactUpdateParams.PatchedContactRequest.builder()
                        .firstName("Gil")
                        .lastName("Feig")
                        .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .addresses(
                            listOf(
                                ContactUpdateParams.PatchedContactRequest.AddressRequest.builder()
                                    .street1("50 Bowling Green Dr")
                                    .street2("Golden Gate Park")
                                    .city("San Francisco")
                                    .state("CA")
                                    .postalCode("94122")
                                    .country(Country.AF)
                                    .addressType(
                                        ContactUpdateParams.PatchedContactRequest.AddressRequest
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
                                ContactUpdateParams.PatchedContactRequest.EmailAddressRequest
                                    .builder()
                                    .value("merge_is_hiring@merge.dev")
                                    .emailAddressType(
                                        ContactUpdateParams.PatchedContactRequest
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
                        .phoneNumbers(
                            listOf(
                                ContactUpdateParams.PatchedContactRequest.PhoneNumberRequest
                                    .builder()
                                    .value("+3198675309")
                                    .phoneNumberType(
                                        ContactUpdateParams.PatchedContactRequest.PhoneNumberRequest
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
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                        .remoteFields(
                            listOf(
                                ContactUpdateParams.PatchedContactRequest.RemoteFieldRequest
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
        val expected = mutableMapOf<String, List<String>>()
        expected.put("is_debug_mode", listOf("true"))
        expected.put("run_async", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            ContactUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(ContactUpdateParams.PatchedContactRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            ContactUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    ContactUpdateParams.PatchedContactRequest.builder()
                        .firstName("Gil")
                        .lastName("Feig")
                        .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .addresses(
                            listOf(
                                ContactUpdateParams.PatchedContactRequest.AddressRequest.builder()
                                    .street1("50 Bowling Green Dr")
                                    .street2("Golden Gate Park")
                                    .city("San Francisco")
                                    .state("CA")
                                    .postalCode("94122")
                                    .country(Country.AF)
                                    .addressType(
                                        ContactUpdateParams.PatchedContactRequest.AddressRequest
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
                                ContactUpdateParams.PatchedContactRequest.EmailAddressRequest
                                    .builder()
                                    .value("merge_is_hiring@merge.dev")
                                    .emailAddressType(
                                        ContactUpdateParams.PatchedContactRequest
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
                        .phoneNumbers(
                            listOf(
                                ContactUpdateParams.PatchedContactRequest.PhoneNumberRequest
                                    .builder()
                                    .value("+3198675309")
                                    .phoneNumberType(
                                        ContactUpdateParams.PatchedContactRequest.PhoneNumberRequest
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
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                        .remoteFields(
                            listOf(
                                ContactUpdateParams.PatchedContactRequest.RemoteFieldRequest
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
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                ContactUpdateParams.PatchedContactRequest.builder()
                    .firstName("Gil")
                    .lastName("Feig")
                    .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .addresses(
                        listOf(
                            ContactUpdateParams.PatchedContactRequest.AddressRequest.builder()
                                .street1("50 Bowling Green Dr")
                                .street2("Golden Gate Park")
                                .city("San Francisco")
                                .state("CA")
                                .postalCode("94122")
                                .country(Country.AF)
                                .addressType(
                                    ContactUpdateParams.PatchedContactRequest.AddressRequest
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
                            ContactUpdateParams.PatchedContactRequest.EmailAddressRequest.builder()
                                .value("merge_is_hiring@merge.dev")
                                .emailAddressType(
                                    ContactUpdateParams.PatchedContactRequest.EmailAddressRequest
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
                            ContactUpdateParams.PatchedContactRequest.PhoneNumberRequest.builder()
                                .value("+3198675309")
                                .phoneNumberType(
                                    ContactUpdateParams.PatchedContactRequest.PhoneNumberRequest
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
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                    .remoteFields(
                        listOf(
                            ContactUpdateParams.PatchedContactRequest.RemoteFieldRequest.builder()
                                .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                .value(JsonString.of("abc"))
                                .build()
                        )
                    )
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            ContactUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(ContactUpdateParams.PatchedContactRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(ContactUpdateParams.PatchedContactRequest.builder().build())
    }

    @Test
    fun getPathParam() {
        val params =
            ContactUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(ContactUpdateParams.PatchedContactRequest.builder().build())
                .build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
