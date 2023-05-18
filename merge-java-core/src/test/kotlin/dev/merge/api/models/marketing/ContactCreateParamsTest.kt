package dev.merge.api.models.marketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ContactCreateParamsTest {

    @Test
    fun createContactCreateParams() {
        ContactCreateParams.builder()
            .model(
                ContactCreateParams.ContactRequest.builder()
                    .name("Gil Feig's Pickleball Team")
                    .isSupplier(true)
                    .isCustomer(true)
                    .emailAddress("pickleball@merge.dev")
                    .taxNumber("12-3456789")
                    .status(ContactCreateParams.ContactRequest.Status7d1Enum.ACTIVE)
                    .currency("USD")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .addresses(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .phoneNumbers(
                        listOf(
                            ContactCreateParams.ContactRequest.PhoneNumberRequest.builder()
                                .value("+3198675309")
                                .phoneNumberType(
                                    ContactCreateParams.ContactRequest.PhoneNumberRequest
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
                    .firstName("Gil")
                    .lastName("Feig")
                    .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .emailAddresses(
                        listOf(
                            ContactCreateParams.ContactRequest.EmailAddressRequest.builder()
                                .value("merge_is_hiring@merge.dev")
                                .emailAddressType(
                                    ContactCreateParams.ContactRequest.EmailAddressRequest
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
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .remoteFields(
                        listOf(
                            ContactCreateParams.ContactRequest.RemoteFieldRequest.builder()
                                .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                .value(JsonString.of("abc"))
                                .build()
                        )
                    )
                    .email("hello@merge.dev")
                    .phone("+13785579223")
                    .state("NY")
                    .country(Country.AF)
                    .postalCode("string")
                    .build()
            )
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            ContactCreateParams.builder()
                .model(
                    ContactCreateParams.ContactRequest.builder()
                        .name("Gil Feig's Pickleball Team")
                        .isSupplier(true)
                        .isCustomer(true)
                        .emailAddress("pickleball@merge.dev")
                        .taxNumber("12-3456789")
                        .status(ContactCreateParams.ContactRequest.Status7d1Enum.ACTIVE)
                        .currency("USD")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                        .addresses(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .phoneNumbers(
                            listOf(
                                ContactCreateParams.ContactRequest.PhoneNumberRequest.builder()
                                    .value("+3198675309")
                                    .phoneNumberType(
                                        ContactCreateParams.ContactRequest.PhoneNumberRequest
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
                        .firstName("Gil")
                        .lastName("Feig")
                        .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .emailAddresses(
                            listOf(
                                ContactCreateParams.ContactRequest.EmailAddressRequest.builder()
                                    .value("merge_is_hiring@merge.dev")
                                    .emailAddressType(
                                        ContactCreateParams.ContactRequest.EmailAddressRequest
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
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .remoteFields(
                            listOf(
                                ContactCreateParams.ContactRequest.RemoteFieldRequest.builder()
                                    .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                    .value(JsonString.of("abc"))
                                    .build()
                            )
                        )
                        .email("hello@merge.dev")
                        .phone("+13785579223")
                        .state("NY")
                        .country(Country.AF)
                        .postalCode("string")
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
            ContactCreateParams.builder()
                .model(ContactCreateParams.ContactRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            ContactCreateParams.builder()
                .model(
                    ContactCreateParams.ContactRequest.builder()
                        .name("Gil Feig's Pickleball Team")
                        .isSupplier(true)
                        .isCustomer(true)
                        .emailAddress("pickleball@merge.dev")
                        .taxNumber("12-3456789")
                        .status(ContactCreateParams.ContactRequest.Status7d1Enum.ACTIVE)
                        .currency("USD")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                        .addresses(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .phoneNumbers(
                            listOf(
                                ContactCreateParams.ContactRequest.PhoneNumberRequest.builder()
                                    .value("+3198675309")
                                    .phoneNumberType(
                                        ContactCreateParams.ContactRequest.PhoneNumberRequest
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
                        .firstName("Gil")
                        .lastName("Feig")
                        .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .emailAddresses(
                            listOf(
                                ContactCreateParams.ContactRequest.EmailAddressRequest.builder()
                                    .value("merge_is_hiring@merge.dev")
                                    .emailAddressType(
                                        ContactCreateParams.ContactRequest.EmailAddressRequest
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
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .remoteFields(
                            listOf(
                                ContactCreateParams.ContactRequest.RemoteFieldRequest.builder()
                                    .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                    .value(JsonString.of("abc"))
                                    .build()
                            )
                        )
                        .email("hello@merge.dev")
                        .phone("+13785579223")
                        .state("NY")
                        .country(Country.AF)
                        .postalCode("string")
                        .build()
                )
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                ContactCreateParams.ContactRequest.builder()
                    .name("Gil Feig's Pickleball Team")
                    .isSupplier(true)
                    .isCustomer(true)
                    .emailAddress("pickleball@merge.dev")
                    .taxNumber("12-3456789")
                    .status(ContactCreateParams.ContactRequest.Status7d1Enum.ACTIVE)
                    .currency("USD")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .addresses(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .phoneNumbers(
                        listOf(
                            ContactCreateParams.ContactRequest.PhoneNumberRequest.builder()
                                .value("+3198675309")
                                .phoneNumberType(
                                    ContactCreateParams.ContactRequest.PhoneNumberRequest
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
                    .firstName("Gil")
                    .lastName("Feig")
                    .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .emailAddresses(
                        listOf(
                            ContactCreateParams.ContactRequest.EmailAddressRequest.builder()
                                .value("merge_is_hiring@merge.dev")
                                .emailAddressType(
                                    ContactCreateParams.ContactRequest.EmailAddressRequest
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
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .remoteFields(
                        listOf(
                            ContactCreateParams.ContactRequest.RemoteFieldRequest.builder()
                                .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                .value(JsonString.of("abc"))
                                .build()
                        )
                    )
                    .email("hello@merge.dev")
                    .phone("+13785579223")
                    .state("NY")
                    .country(Country.AF)
                    .postalCode("string")
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            ContactCreateParams.builder()
                .model(ContactCreateParams.ContactRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(ContactCreateParams.ContactRequest.builder().build())
    }
}
