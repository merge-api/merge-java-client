package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompanyInfoTest {

    @Test
    fun createCompanyInfo() {
        val companyInfo =
            CompanyInfo.builder()
                .id("65d8ffd0-211b-4ba4-b85a-fbe2ce220982")
                .remoteId("19202938")
                .name("Merge Pickleball Company")
                .legalName("Merge Pickleball Company Inc.")
                .taxNumber("11-0011000")
                .fiscalYearEndMonth(123L)
                .fiscalYearEndDay(123L)
                .currency(CompanyInfo.CurrencyEnum.XUA)
                .remoteCreatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .urls(listOf("string"))
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
                        PhoneNumber.builder()
                            .number("+3198675309")
                            .type("Mobile")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
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
                .build()
        assertThat(companyInfo).isNotNull
        assertThat(companyInfo.id()).contains("65d8ffd0-211b-4ba4-b85a-fbe2ce220982")
        assertThat(companyInfo.remoteId()).contains("19202938")
        assertThat(companyInfo.name()).contains("Merge Pickleball Company")
        assertThat(companyInfo.legalName()).contains("Merge Pickleball Company Inc.")
        assertThat(companyInfo.taxNumber()).contains("11-0011000")
        assertThat(companyInfo.fiscalYearEndMonth()).contains(123L)
        assertThat(companyInfo.fiscalYearEndDay()).contains(123L)
        assertThat(companyInfo.currency()).contains(CompanyInfo.CurrencyEnum.XUA)
        assertThat(companyInfo.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(companyInfo.urls().get()).containsExactly("string")
        assertThat(companyInfo.addresses().get())
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
        assertThat(companyInfo.phoneNumbers().get())
            .containsExactly(
                PhoneNumber.builder()
                    .number("+3198675309")
                    .type("Mobile")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(companyInfo.remoteWasDeleted()).contains(true)
        assertThat(companyInfo._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(companyInfo.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(companyInfo.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
