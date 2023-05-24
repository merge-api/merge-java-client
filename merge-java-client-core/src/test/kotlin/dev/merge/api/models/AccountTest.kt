package dev.merge.api.models

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountTest {

    @Test
    fun createAccount() {
        val account =
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
                            "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                            "linked_account_defined_targets" to
                                mapOf("custom_key" to "custom_value")
                        )
                    )
                )
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .remoteData(
                    listOf(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
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
        assertThat(account).isNotNull
        assertThat(account.id()).contains("0958cbc6-6040-430a-848e-aafacbadf4ae")
        assertThat(account.remoteId()).contains("19202938")
        assertThat(account.name()).contains("Merge API")
        assertThat(account.description()).contains("One API for all integrations")
        assertThat(account.classification()).contains(Account.ClassificationEnum.ASSET)
        assertThat(account.type()).contains("Asset")
        assertThat(account.status()).contains(Account.AccountStatusEnum.ACTIVE)
        assertThat(account.currentBalance()).contains(42.23)
        assertThat(account.currency()).contains(Account.CurrencyEnum.XUA)
        assertThat(account.accountNumber()).contains("X12Y9AB")
        assertThat(account.parentAccount()).contains("22d92d6c-22f9-11ed-861d-0242ac120002")
        assertThat(account.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(account.remoteWasDeleted()).contains(true)
        assertThat(account._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(account.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(account.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
        assertThat(account.domains().get()).containsExactly("string")
        assertThat(account.owner()).contains("0258cbc6-6020-430a-848e-aafacbadf4ae")
        assertThat(account.industry()).contains("API's")
        assertThat(account.website()).contains("https://merge.dev/")
        assertThat(account.numberOfEmployees()).contains(123L)
        assertThat(account.addresses().get())
            .containsExactly(
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
        assertThat(account.phoneNumbers().get())
            .containsExactly(
                Account.PhoneNumber.builder()
                    .value("+3198675309")
                    .phoneNumberType(Account.PhoneNumber.PhoneNumberTypeEnum.HOME)
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .phoneNumber("+3198675309")
                    .build()
            )
        assertThat(account.lastActivityAt()).contains(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
        assertThat(account.remoteUpdatedAt()).contains(OffsetDateTime.parse("2022-01-09T00:00:00Z"))
        assertThat(account.remoteCreatedAt()).contains(OffsetDateTime.parse("2021-11-10T00:00:00Z"))
        assertThat(account.remoteFields().get())
            .containsExactly(
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
    }
}
