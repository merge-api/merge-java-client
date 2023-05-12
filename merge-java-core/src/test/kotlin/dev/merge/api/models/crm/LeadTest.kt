package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LeadTest {

    @Test
    fun createLead() {
        val lead =
            Lead.builder()
                .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                .leadSource("API Blogger")
                .title("Co-Founder")
                .company("Merge API")
                .firstName("Gil")
                .lastName("Feig")
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
                .emailAddresses(
                    listOf(
                        Lead.EmailAddress.builder()
                            .value("merge_is_hiring@merge.dev")
                            .emailAddressType(Lead.EmailAddress.EmailAddressTypeEnum.PERSONAL)
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .emailAddress("merge_is_hiring@merge.dev")
                            .build()
                    )
                )
                .phoneNumbers(
                    listOf(
                        Lead.PhoneNumber.builder()
                            .value("+3198675309")
                            .phoneNumberType(Lead.PhoneNumber.PhoneNumberTypeEnum.HOME)
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .phoneNumber("+3198675309")
                            .build()
                    )
                )
                .remoteUpdatedAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                .remoteCreatedAt(OffsetDateTime.parse("2021-11-10T00:00:00Z"))
                .convertedDate(OffsetDateTime.parse("2022-03-10T00:00:00Z"))
                .convertedContact("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .convertedAccount("9c9de072-29cf-48e3-9578-1ca5b145b40e")
                .remoteWasDeleted(true)
                .id("03455bc6-6040-430a-848e-aafacbfdf4fg")
                .remoteId("19202938")
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
                .remoteFields(
                    listOf(
                        Lead.RemoteField.builder()
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
        assertThat(lead).isNotNull
        assertThat(lead.owner()).contains("0358cbc6-2040-430a-848e-aafacbadf3aa")
        assertThat(lead.leadSource()).contains("API Blogger")
        assertThat(lead.title()).contains("Co-Founder")
        assertThat(lead.company()).contains("Merge API")
        assertThat(lead.firstName()).contains("Gil")
        assertThat(lead.lastName()).contains("Feig")
        assertThat(lead.addresses().get())
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
        assertThat(lead.emailAddresses().get())
            .containsExactly(
                Lead.EmailAddress.builder()
                    .value("merge_is_hiring@merge.dev")
                    .emailAddressType(Lead.EmailAddress.EmailAddressTypeEnum.PERSONAL)
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .emailAddress("merge_is_hiring@merge.dev")
                    .build()
            )
        assertThat(lead.phoneNumbers().get())
            .containsExactly(
                Lead.PhoneNumber.builder()
                    .value("+3198675309")
                    .phoneNumberType(Lead.PhoneNumber.PhoneNumberTypeEnum.HOME)
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .phoneNumber("+3198675309")
                    .build()
            )
        assertThat(lead.remoteUpdatedAt()).contains(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
        assertThat(lead.remoteCreatedAt()).contains(OffsetDateTime.parse("2021-11-10T00:00:00Z"))
        assertThat(lead.convertedDate()).contains(OffsetDateTime.parse("2022-03-10T00:00:00Z"))
        assertThat(lead.convertedContact()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(lead.convertedAccount()).contains("9c9de072-29cf-48e3-9578-1ca5b145b40e")
        assertThat(lead.remoteWasDeleted()).contains(true)
        assertThat(lead.id()).contains("03455bc6-6040-430a-848e-aafacbfdf4fg")
        assertThat(lead.remoteId()).contains("19202938")
        assertThat(lead._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(lead.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(lead.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
        assertThat(lead.remoteFields().get())
            .containsExactly(
                Lead.RemoteField.builder()
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
