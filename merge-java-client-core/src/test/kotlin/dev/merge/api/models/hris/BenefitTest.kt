package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BenefitTest {

    @Test
    fun createBenefit() {
        val benefit =
            Benefit.builder()
                .id("3fe5ae7a-f1ba-4529-b7af-84e86dc6d232")
                .remoteId("19202938")
                .employee("d2f972d0-2526-434b-9409-4c3b468e08f0")
                .providerName("Blue Shield of California")
                .benefitPlanType("MEDICAL")
                .employeeContribution(42.23)
                .companyContribution(42.23)
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
        assertThat(benefit).isNotNull
        assertThat(benefit.id()).contains("3fe5ae7a-f1ba-4529-b7af-84e86dc6d232")
        assertThat(benefit.remoteId()).contains("19202938")
        assertThat(benefit.employee()).contains("d2f972d0-2526-434b-9409-4c3b468e08f0")
        assertThat(benefit.providerName()).contains("Blue Shield of California")
        assertThat(benefit.benefitPlanType()).contains("MEDICAL")
        assertThat(benefit.employeeContribution()).contains(42.23)
        assertThat(benefit.companyContribution()).contains(42.23)
        assertThat(benefit.remoteWasDeleted()).contains(true)
        assertThat(benefit._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(benefit.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(benefit.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
