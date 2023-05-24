package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PayrollRunTest {

    @Test
    fun createPayrollRun() {
        val payrollRun =
            PayrollRun.builder()
                .id("37336947-b3d4-4a4c-a310-ab6ab510e079")
                .remoteId("19202938")
                .runState(PayrollRun.RunStateEnum.PAID)
                .runType(PayrollRun.RunTypeEnum.REGULAR)
                .startDate(OffsetDateTime.parse("2020-11-08T00:00:00Z"))
                .endDate(OffsetDateTime.parse("2020-11-15T00:00:00Z"))
                .checkDate(OffsetDateTime.parse("2020-11-15T00:00:00Z"))
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
        assertThat(payrollRun).isNotNull
        assertThat(payrollRun.id()).contains("37336947-b3d4-4a4c-a310-ab6ab510e079")
        assertThat(payrollRun.remoteId()).contains("19202938")
        assertThat(payrollRun.runState()).contains(PayrollRun.RunStateEnum.PAID)
        assertThat(payrollRun.runType()).contains(PayrollRun.RunTypeEnum.REGULAR)
        assertThat(payrollRun.startDate()).contains(OffsetDateTime.parse("2020-11-08T00:00:00Z"))
        assertThat(payrollRun.endDate()).contains(OffsetDateTime.parse("2020-11-15T00:00:00Z"))
        assertThat(payrollRun.checkDate()).contains(OffsetDateTime.parse("2020-11-15T00:00:00Z"))
        assertThat(payrollRun.remoteWasDeleted()).contains(true)
        assertThat(payrollRun._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(payrollRun.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(payrollRun.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
