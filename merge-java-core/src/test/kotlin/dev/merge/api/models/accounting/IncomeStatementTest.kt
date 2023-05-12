package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IncomeStatementTest {

    @Test
    fun createIncomeStatement() {
        val incomeStatement =
            IncomeStatement.builder()
                .id("0958cbc6-6040-430a-848e-aafacbadf4ae")
                .remoteId("1342348")
                .name("IncomeStatement")
                .currency(IncomeStatement.CurrencyEnum.XUA)
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                .startPeriod(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .endPeriod(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .income(
                    listOf(
                        IncomeStatement.ReportItem.builder()
                            .remoteId("10299")
                            .name("Revenue")
                            .value(42.23)
                            .subItems(listOf(IncomeStatement.ReportItem.SubItem.builder().build()))
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .costOfSales(
                    listOf(
                        IncomeStatement.ReportItem.builder()
                            .remoteId("10299")
                            .name("Revenue")
                            .value(42.23)
                            .subItems(listOf(IncomeStatement.ReportItem.SubItem.builder().build()))
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .grossProfit(42.23)
                .operatingExpenses(
                    listOf(
                        IncomeStatement.ReportItem.builder()
                            .remoteId("10299")
                            .name("Revenue")
                            .value(42.23)
                            .subItems(listOf(IncomeStatement.ReportItem.SubItem.builder().build()))
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .netOperatingIncome(42.23)
                .nonOperatingExpenses(
                    listOf(
                        IncomeStatement.ReportItem.builder()
                            .remoteId("10299")
                            .name("Revenue")
                            .value(42.23)
                            .subItems(listOf(IncomeStatement.ReportItem.SubItem.builder().build()))
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .netIncome(42.23)
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
        assertThat(incomeStatement).isNotNull
        assertThat(incomeStatement.id()).contains("0958cbc6-6040-430a-848e-aafacbadf4ae")
        assertThat(incomeStatement.remoteId()).contains("1342348")
        assertThat(incomeStatement.name()).contains("IncomeStatement")
        assertThat(incomeStatement.currency()).contains(IncomeStatement.CurrencyEnum.XUA)
        assertThat(incomeStatement.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(incomeStatement.startPeriod())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(incomeStatement.endPeriod())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(incomeStatement.income().get())
            .containsExactly(
                IncomeStatement.ReportItem.builder()
                    .remoteId("10299")
                    .name("Revenue")
                    .value(42.23)
                    .subItems(listOf(IncomeStatement.ReportItem.SubItem.builder().build()))
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(incomeStatement.costOfSales().get())
            .containsExactly(
                IncomeStatement.ReportItem.builder()
                    .remoteId("10299")
                    .name("Revenue")
                    .value(42.23)
                    .subItems(listOf(IncomeStatement.ReportItem.SubItem.builder().build()))
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(incomeStatement.grossProfit()).contains(42.23)
        assertThat(incomeStatement.operatingExpenses().get())
            .containsExactly(
                IncomeStatement.ReportItem.builder()
                    .remoteId("10299")
                    .name("Revenue")
                    .value(42.23)
                    .subItems(listOf(IncomeStatement.ReportItem.SubItem.builder().build()))
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(incomeStatement.netOperatingIncome()).contains(42.23)
        assertThat(incomeStatement.nonOperatingExpenses().get())
            .containsExactly(
                IncomeStatement.ReportItem.builder()
                    .remoteId("10299")
                    .name("Revenue")
                    .value(42.23)
                    .subItems(listOf(IncomeStatement.ReportItem.SubItem.builder().build()))
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(incomeStatement.netIncome()).contains(42.23)
        assertThat(incomeStatement.remoteWasDeleted()).contains(true)
        assertThat(incomeStatement._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(incomeStatement.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(incomeStatement.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
