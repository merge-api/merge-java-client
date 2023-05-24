package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CashFlowStatementTest {

    @Test
    fun createCashFlowStatement() {
        val cashFlowStatement =
            CashFlowStatement.builder()
                .id("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                .remoteId("8211088")
                .name("CashFlow")
                .currency(CashFlowStatement.CurrencyEnum.XUA)
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                .startPeriod(OffsetDateTime.parse("2020-01-01T00:00:00Z"))
                .endPeriod(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .cashAtBeginningOfPeriod(42.23)
                .cashAtEndOfPeriod(42.23)
                .operatingActivities(
                    listOf(
                        CashFlowStatement.ReportItem.builder()
                            .remoteId("10299")
                            .name("Revenue")
                            .value(42.23)
                            .subItems(
                                listOf(CashFlowStatement.ReportItem.SubItem.builder().build())
                            )
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .investingActivities(
                    listOf(
                        CashFlowStatement.ReportItem.builder()
                            .remoteId("10299")
                            .name("Revenue")
                            .value(42.23)
                            .subItems(
                                listOf(CashFlowStatement.ReportItem.SubItem.builder().build())
                            )
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .financingActivities(
                    listOf(
                        CashFlowStatement.ReportItem.builder()
                            .remoteId("10299")
                            .name("Revenue")
                            .value(42.23)
                            .subItems(
                                listOf(CashFlowStatement.ReportItem.SubItem.builder().build())
                            )
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .remoteGeneratedAt(OffsetDateTime.parse("2020-04-01T00:00:00Z"))
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
        assertThat(cashFlowStatement).isNotNull
        assertThat(cashFlowStatement.id()).contains("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
        assertThat(cashFlowStatement.remoteId()).contains("8211088")
        assertThat(cashFlowStatement.name()).contains("CashFlow")
        assertThat(cashFlowStatement.currency()).contains(CashFlowStatement.CurrencyEnum.XUA)
        assertThat(cashFlowStatement.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(cashFlowStatement.startPeriod())
            .contains(OffsetDateTime.parse("2020-01-01T00:00:00Z"))
        assertThat(cashFlowStatement.endPeriod())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(cashFlowStatement.cashAtBeginningOfPeriod()).contains(42.23)
        assertThat(cashFlowStatement.cashAtEndOfPeriod()).contains(42.23)
        assertThat(cashFlowStatement.operatingActivities().get())
            .containsExactly(
                CashFlowStatement.ReportItem.builder()
                    .remoteId("10299")
                    .name("Revenue")
                    .value(42.23)
                    .subItems(listOf(CashFlowStatement.ReportItem.SubItem.builder().build()))
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(cashFlowStatement.investingActivities().get())
            .containsExactly(
                CashFlowStatement.ReportItem.builder()
                    .remoteId("10299")
                    .name("Revenue")
                    .value(42.23)
                    .subItems(listOf(CashFlowStatement.ReportItem.SubItem.builder().build()))
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(cashFlowStatement.financingActivities().get())
            .containsExactly(
                CashFlowStatement.ReportItem.builder()
                    .remoteId("10299")
                    .name("Revenue")
                    .value(42.23)
                    .subItems(listOf(CashFlowStatement.ReportItem.SubItem.builder().build()))
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(cashFlowStatement.remoteGeneratedAt())
            .contains(OffsetDateTime.parse("2020-04-01T00:00:00Z"))
        assertThat(cashFlowStatement.remoteWasDeleted()).contains(true)
        assertThat(cashFlowStatement._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(cashFlowStatement.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(cashFlowStatement.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
