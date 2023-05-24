package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ContactResponseTest {

    @Test
    fun createContactResponse() {
        val contactResponse =
            ContactResponse.builder()
                .model(
                    Contact.builder()
                        .id("5858cbc6-6040-430a-475r-aafacbadrg64")
                        .remoteId("35")
                        .name("Cousin Greg")
                        .isSupplier(true)
                        .isCustomer(true)
                        .emailAddress("greg@waystar-royco.com")
                        .taxNumber("12-3456789")
                        .status(Contact.Status7d1Enum.ACTIVE)
                        .currency("USD")
                        .remoteUpdatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                        .addresses(
                            listOf(
                                Address.builder()
                                    .type(Address.AddressTypeEnum.BILLING)
                                    .street1("50 Bowling Green Dr")
                                    .street2("Golden Gate Park")
                                    .city("San Francisco")
                                    .state("CA")
                                    .countrySubdivision("NY")
                                    .country(Country.AF)
                                    .zipCode("10027")
                                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                    .postalCode("94122")
                                    .addressType(Address.AddressTypeEnum.BILLING)
                                    .build()
                            )
                        )
                        .phoneNumbers(
                            listOf(
                                Contact.PhoneNumber.builder()
                                    .value("+3198675309")
                                    .phoneNumberType(Contact.PhoneNumber.PhoneNumberTypeEnum.HOME)
                                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                    .phoneNumber("+3198675309")
                                    .build()
                            )
                        )
                        .remoteWasDeleted(true)
                        .fieldMappings(
                            JsonValue.from(
                                mapOf(
                                    "organization_defined_targets" to
                                        mapOf("custom_key" to "custom_value"),
                                    "linked_account_defined_targets" to
                                        mapOf("custom_key" to "custom_value")
                                )
                            )
                        )
                        .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                        .remoteData(
                            listOf(
                                RemoteData.builder()
                                    .path("string")
                                    .data(JsonString.of("abc"))
                                    .build()
                            )
                        )
                        .phoneNumber("5108890293")
                        .details("Executive Assistant to Tom Wambsgans")
                        .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .firstName("Gil")
                        .lastName("Feig")
                        .emailAddresses(
                            listOf(
                                Contact.EmailAddress.builder()
                                    .value("merge_is_hiring@merge.dev")
                                    .emailAddressType(
                                        Contact.EmailAddress.EmailAddressTypeEnum.PERSONAL
                                    )
                                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                    .emailAddress("merge_is_hiring@merge.dev")
                                    .build()
                            )
                        )
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .remoteCreatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                        .remoteFields(
                            listOf(
                                Contact.RemoteField.builder()
                                    .remoteFieldClass(
                                        RemoteFieldClass.builder()
                                            .id("string")
                                            .displayName("string")
                                            .remoteKeyName("string")
                                            .description("string")
                                            .isCustom(true)
                                            .isRequired(true)
                                            .fieldType(RemoteFieldClass.FieldTypeEnum.STRING)
                                            .fieldFormat(RemoteFieldClass.FieldFormatEnum.STRING)
                                            .fieldChoices(listOf("string"))
                                            .itemSchema(
                                                RemoteFieldClass.ItemSchema.builder()
                                                    .itemType(JsonString.of("abc"))
                                                    .itemFormat(JsonString.of("abc"))
                                                    .itemChoices(listOf("string"))
                                                    .build()
                                            )
                                            .build()
                                    )
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
                .warnings(
                    listOf(
                        ValidationWarning.builder()
                            .source(
                                ValidationWarning.ValidationProblemSource.builder()
                                    .pointer("string")
                                    .build()
                            )
                            .title("Unrecognized Field")
                            .detail("An unrecognized field, age, was passed in with request data.")
                            .problemType("UNRECOGNIZED_FIELD")
                            .build()
                    )
                )
                .errors(
                    listOf(
                        ValidationError.builder()
                            .source(
                                ValidationError.ValidationProblemSource.builder()
                                    .pointer("string")
                                    .build()
                            )
                            .title("Missing Required Field")
                            .detail("custom_fields is a required field on model.")
                            .problemType("MISSING_REQUIRED_FIELD")
                            .build()
                    )
                )
                .logs(
                    listOf(
                        DebugLog.builder()
                            .logId("99433219-8017-4acd-bb3c-ceb23d663832")
                            .dashboardView(
                                "https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832"
                            )
                            .logSummary(
                                DebugLog.DebugModelLogSummary.builder()
                                    .url("https://harvest.greenhouse.io/v1/candidates/")
                                    .method("POST")
                                    .statusCode(123L)
                                    .build()
                            )
                            .build()
                    )
                )
                .build()
        assertThat(contactResponse).isNotNull
        assertThat(contactResponse.model())
            .isEqualTo(
                Contact.builder()
                    .id("5858cbc6-6040-430a-475r-aafacbadrg64")
                    .remoteId("35")
                    .name("Cousin Greg")
                    .isSupplier(true)
                    .isCustomer(true)
                    .emailAddress("greg@waystar-royco.com")
                    .taxNumber("12-3456789")
                    .status(Contact.Status7d1Enum.ACTIVE)
                    .currency("USD")
                    .remoteUpdatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .addresses(
                        listOf(
                            Address.builder()
                                .type(Address.AddressTypeEnum.BILLING)
                                .street1("50 Bowling Green Dr")
                                .street2("Golden Gate Park")
                                .city("San Francisco")
                                .state("CA")
                                .countrySubdivision("NY")
                                .country(Country.AF)
                                .zipCode("10027")
                                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                .postalCode("94122")
                                .addressType(Address.AddressTypeEnum.BILLING)
                                .build()
                        )
                    )
                    .phoneNumbers(
                        listOf(
                            Contact.PhoneNumber.builder()
                                .value("+3198675309")
                                .phoneNumberType(Contact.PhoneNumber.PhoneNumberTypeEnum.HOME)
                                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                .phoneNumber("+3198675309")
                                .build()
                        )
                    )
                    .remoteWasDeleted(true)
                    .fieldMappings(
                        JsonValue.from(
                            mapOf(
                                "organization_defined_targets" to
                                    mapOf("custom_key" to "custom_value"),
                                "linked_account_defined_targets" to
                                    mapOf("custom_key" to "custom_value")
                            )
                        )
                    )
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .remoteData(
                        listOf(
                            RemoteData.builder().path("string").data(JsonString.of("abc")).build()
                        )
                    )
                    .phoneNumber("5108890293")
                    .details("Executive Assistant to Tom Wambsgans")
                    .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .firstName("Gil")
                    .lastName("Feig")
                    .emailAddresses(
                        listOf(
                            Contact.EmailAddress.builder()
                                .value("merge_is_hiring@merge.dev")
                                .emailAddressType(
                                    Contact.EmailAddress.EmailAddressTypeEnum.PERSONAL
                                )
                                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                .emailAddress("merge_is_hiring@merge.dev")
                                .build()
                        )
                    )
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .remoteCreatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                    .remoteFields(
                        listOf(
                            Contact.RemoteField.builder()
                                .remoteFieldClass(
                                    RemoteFieldClass.builder()
                                        .id("string")
                                        .displayName("string")
                                        .remoteKeyName("string")
                                        .description("string")
                                        .isCustom(true)
                                        .isRequired(true)
                                        .fieldType(RemoteFieldClass.FieldTypeEnum.STRING)
                                        .fieldFormat(RemoteFieldClass.FieldFormatEnum.STRING)
                                        .fieldChoices(listOf("string"))
                                        .itemSchema(
                                            RemoteFieldClass.ItemSchema.builder()
                                                .itemType(JsonString.of("abc"))
                                                .itemFormat(JsonString.of("abc"))
                                                .itemChoices(listOf("string"))
                                                .build()
                                        )
                                        .build()
                                )
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
        assertThat(contactResponse.warnings())
            .containsExactly(
                ValidationWarning.builder()
                    .source(
                        ValidationWarning.ValidationProblemSource.builder()
                            .pointer("string")
                            .build()
                    )
                    .title("Unrecognized Field")
                    .detail("An unrecognized field, age, was passed in with request data.")
                    .problemType("UNRECOGNIZED_FIELD")
                    .build()
            )
        assertThat(contactResponse.errors())
            .containsExactly(
                ValidationError.builder()
                    .source(
                        ValidationError.ValidationProblemSource.builder().pointer("string").build()
                    )
                    .title("Missing Required Field")
                    .detail("custom_fields is a required field on model.")
                    .problemType("MISSING_REQUIRED_FIELD")
                    .build()
            )
        assertThat(contactResponse.logs().get())
            .containsExactly(
                DebugLog.builder()
                    .logId("99433219-8017-4acd-bb3c-ceb23d663832")
                    .dashboardView(
                        "https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832"
                    )
                    .logSummary(
                        DebugLog.DebugModelLogSummary.builder()
                            .url("https://harvest.greenhouse.io/v1/candidates/")
                            .method("POST")
                            .statusCode(123L)
                            .build()
                    )
                    .build()
            )
    }
}
