package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TaxRateTest {

    @Test
    fun createTaxRate() {
        val taxRate =
            TaxRate.builder()
                .description("Sales Tax")
                .totalTaxRate(42.23)
                .effectiveTaxRate(42.23)
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                .remoteWasDeleted(true)
                .id("b82302de-852e-4e60-b050-edf9da3b7c02")
                .remoteId("039111")
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
        assertThat(taxRate).isNotNull
        assertThat(taxRate.description()).contains("Sales Tax")
        assertThat(taxRate.totalTaxRate()).contains(42.23)
        assertThat(taxRate.effectiveTaxRate()).contains(42.23)
        assertThat(taxRate.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(taxRate.remoteWasDeleted()).contains(true)
        assertThat(taxRate.id()).contains("b82302de-852e-4e60-b050-edf9da3b7c02")
        assertThat(taxRate.remoteId()).contains("039111")
        assertThat(taxRate._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(taxRate.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(taxRate.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
