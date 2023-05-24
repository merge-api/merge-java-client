package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmploymentTest {

    @Test
    fun createEmployment() {
        val employment =
            Employment.builder()
                .id("65d8ffd0-211b-4ba4-b85a-fbe2ce220982")
                .remoteId("19202938")
                .employee("0958cbc6-6040-430a-848e-aafacbadf4ae")
                .jobTitle("Executive Assistant to Tom Wambsgans")
                .payRate(42.23)
                .payPeriod(Employment.PayPeriodEnum.HOUR)
                .payFrequency(Employment.PayFrequencyEnum.WEEKLY)
                .payCurrency(Employment.PayCurrencyEnum.XUA)
                .payGroup("d4e4837f-9900-484c-ac40-528365bb08ef")
                .flsaStatus(Employment.FlsaStatusEnum.EXEMPT)
                .effectiveDate(OffsetDateTime.parse("2023-10-06T18:42:34Z"))
                .employmentType(Employment.EmploymentTypeEnum.FULL_TIME)
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
        assertThat(employment).isNotNull
        assertThat(employment.id()).contains("65d8ffd0-211b-4ba4-b85a-fbe2ce220982")
        assertThat(employment.remoteId()).contains("19202938")
        assertThat(employment.employee()).contains("0958cbc6-6040-430a-848e-aafacbadf4ae")
        assertThat(employment.jobTitle()).contains("Executive Assistant to Tom Wambsgans")
        assertThat(employment.payRate()).contains(42.23)
        assertThat(employment.payPeriod()).contains(Employment.PayPeriodEnum.HOUR)
        assertThat(employment.payFrequency()).contains(Employment.PayFrequencyEnum.WEEKLY)
        assertThat(employment.payCurrency()).contains(Employment.PayCurrencyEnum.XUA)
        assertThat(employment.payGroup()).contains("d4e4837f-9900-484c-ac40-528365bb08ef")
        assertThat(employment.flsaStatus()).contains(Employment.FlsaStatusEnum.EXEMPT)
        assertThat(employment.effectiveDate())
            .contains(OffsetDateTime.parse("2023-10-06T18:42:34Z"))
        assertThat(employment.employmentType()).contains(Employment.EmploymentTypeEnum.FULL_TIME)
        assertThat(employment.remoteWasDeleted()).contains(true)
        assertThat(employment._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(employment.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(employment.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
