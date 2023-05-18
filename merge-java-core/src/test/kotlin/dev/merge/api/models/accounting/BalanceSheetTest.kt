package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BalanceSheetTest {

    @Test
    fun createBalanceSheet() {
        val balanceSheet =
            BalanceSheet.builder()
                .id("9871b4a9-f5d2-4f3b-a66b-dfedbed42c46")
                .remoteId("8937018")
                .name("BalanceSheet")
                .currency(BalanceSheet.CurrencyEnum.XUA)
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                .date(OffsetDateTime.parse("2021-09-29T00:00:00Z"))
                .netAssets(42.23)
                .assets(
                    listOf(
                        BalanceSheet.ReportItem.builder()
                            .remoteId("10299")
                            .name("Revenue")
                            .value(42.23)
                            .subItems(listOf(BalanceSheet.ReportItem.SubItem.builder().build()))
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .liabilities(
                    listOf(
                        BalanceSheet.ReportItem.builder()
                            .remoteId("10299")
                            .name("Revenue")
                            .value(42.23)
                            .subItems(listOf(BalanceSheet.ReportItem.SubItem.builder().build()))
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .equity(
                    listOf(
                        BalanceSheet.ReportItem.builder()
                            .remoteId("10299")
                            .name("Revenue")
                            .value(42.23)
                            .subItems(listOf(BalanceSheet.ReportItem.SubItem.builder().build()))
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .remoteGeneratedAt(OffsetDateTime.parse("2021-10-01T00:00:00Z"))
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
        assertThat(balanceSheet).isNotNull
        assertThat(balanceSheet.id()).contains("9871b4a9-f5d2-4f3b-a66b-dfedbed42c46")
        assertThat(balanceSheet.remoteId()).contains("8937018")
        assertThat(balanceSheet.name()).contains("BalanceSheet")
        assertThat(balanceSheet.currency()).contains(BalanceSheet.CurrencyEnum.XUA)
        assertThat(balanceSheet.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(balanceSheet.date()).contains(OffsetDateTime.parse("2021-09-29T00:00:00Z"))
        assertThat(balanceSheet.netAssets()).contains(42.23)
        assertThat(balanceSheet.assets().get())
            .containsExactly(
                BalanceSheet.ReportItem.builder()
                    .remoteId("10299")
                    .name("Revenue")
                    .value(42.23)
                    .subItems(listOf(BalanceSheet.ReportItem.SubItem.builder().build()))
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(balanceSheet.liabilities().get())
            .containsExactly(
                BalanceSheet.ReportItem.builder()
                    .remoteId("10299")
                    .name("Revenue")
                    .value(42.23)
                    .subItems(listOf(BalanceSheet.ReportItem.SubItem.builder().build()))
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(balanceSheet.equity().get())
            .containsExactly(
                BalanceSheet.ReportItem.builder()
                    .remoteId("10299")
                    .name("Revenue")
                    .value(42.23)
                    .subItems(listOf(BalanceSheet.ReportItem.SubItem.builder().build()))
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(balanceSheet.remoteGeneratedAt())
            .contains(OffsetDateTime.parse("2021-10-01T00:00:00Z"))
        assertThat(balanceSheet.remoteWasDeleted()).contains(true)
        assertThat(balanceSheet._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(balanceSheet.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(balanceSheet.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
