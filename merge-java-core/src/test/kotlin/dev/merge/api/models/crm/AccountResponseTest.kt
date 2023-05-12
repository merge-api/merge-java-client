package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountResponseTest {

    @Test
    fun createAccountResponse() {
        val accountResponse =
            AccountResponse.builder()
                .model(
                    Account.builder()
                        .id("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .remoteId("19202938")
                        .name("Merge API")
                        .description("One API for all integrations")
                        .classification(Account.ClassificationEnum.ASSET)
                        .type("Asset")
                        .status(Account.AccountStatusEnum.ACTIVE)
                        .currentBalance(42.23)
                        .currency(Account.CurrencyEnum.XUA)
                        .accountNumber("X12Y9AB")
                        .parentAccount("22d92d6c-22f9-11ed-861d-0242ac120002")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
                        .domains(listOf("string"))
                        .owner("0258cbc6-6020-430a-848e-aafacbadf4ae")
                        .industry("API's")
                        .website("https://merge.dev/")
                        .numberOfEmployees(123L)
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
                                Account.PhoneNumber.builder()
                                    .value("+3198675309")
                                    .phoneNumberType(Account.PhoneNumber.PhoneNumberTypeEnum.HOME)
                                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                    .phoneNumber("+3198675309")
                                    .build()
                            )
                        )
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .remoteUpdatedAt(OffsetDateTime.parse("2022-01-09T00:00:00Z"))
                        .remoteCreatedAt(OffsetDateTime.parse("2021-11-10T00:00:00Z"))
                        .remoteFields(
                            listOf(
                                Account.RemoteField.builder()
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
        assertThat(accountResponse).isNotNull
        assertThat(accountResponse.model())
            .isEqualTo(
                Account.builder()
                    .id("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .remoteId("19202938")
                    .name("Merge API")
                    .description("One API for all integrations")
                    .classification(Account.ClassificationEnum.ASSET)
                    .type("Asset")
                    .status(Account.AccountStatusEnum.ACTIVE)
                    .currentBalance(42.23)
                    .currency(Account.CurrencyEnum.XUA)
                    .accountNumber("X12Y9AB")
                    .parentAccount("22d92d6c-22f9-11ed-861d-0242ac120002")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
                    .domains(listOf("string"))
                    .owner("0258cbc6-6020-430a-848e-aafacbadf4ae")
                    .industry("API's")
                    .website("https://merge.dev/")
                    .numberOfEmployees(123L)
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
                            Account.PhoneNumber.builder()
                                .value("+3198675309")
                                .phoneNumberType(Account.PhoneNumber.PhoneNumberTypeEnum.HOME)
                                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                .phoneNumber("+3198675309")
                                .build()
                        )
                    )
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .remoteUpdatedAt(OffsetDateTime.parse("2022-01-09T00:00:00Z"))
                    .remoteCreatedAt(OffsetDateTime.parse("2021-11-10T00:00:00Z"))
                    .remoteFields(
                        listOf(
                            Account.RemoteField.builder()
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
                    .build()
            )
        assertThat(accountResponse.warnings())
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
        assertThat(accountResponse.errors())
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
        assertThat(accountResponse.logs().get())
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
