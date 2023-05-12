package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmployeePayrollRunTest {

    @Test
    fun createEmployeePayrollRun() {
        val employeePayrollRun =
            EmployeePayrollRun.builder()
                .id("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
                .remoteId("19202938")
                .employee("d2f972d0-2526-434b-9409-4c3b468e08f0")
                .payrollRun("35347df1-95e7-46e2-93cc-66f1191edca5")
                .grossPay(42.23)
                .netPay(42.23)
                .startDate(OffsetDateTime.parse("2020-11-08T00:00:00Z"))
                .endDate(OffsetDateTime.parse("2020-11-09T00:00:00Z"))
                .checkDate(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
                .earnings(
                    listOf(
                        EmployeePayrollRun.Earning.builder()
                            .id("babbced6-3a81-4775-8da2-490dc6385259")
                            .remoteId("52802")
                            .employeePayrollRun("35347df1-95e7-46e2-93cc-66f1191edca5")
                            .amount(42.23)
                            .type(EmployeePayrollRun.Earning.EarningTypeEnum.SALARY)
                            .remoteWasDeleted(true)
                            .fieldMappings(
                                JsonValue.from(
                                    mapOf(
                                        "organization_defined_targets" to
                                            mapOf("custom_key" to "custom_value"),
                                        "linked_account_defined_targets" to
                                            mapOf("custom_key" to "custom_value")
                                    )
                                )
                            )
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .remoteData(
                                listOf(
                                    RemoteData.builder()
                                        .path("string")
                                        .data(JsonString.of("abc"))
                                        .build()
                                )
                            )
                            .build()
                    )
                )
                .deductions(
                    listOf(
                        EmployeePayrollRun.Deduction.builder()
                            .id("5fd439fc-1b64-4755-b275-64918936c365")
                            .remoteId("93478612")
                            .employeePayrollRun("35347df1-95e7-46e2-93cc-66f1191edca5")
                            .name("Social Security")
                            .employeeDeduction(42.23)
                            .companyDeduction(42.23)
                            .remoteWasDeleted(true)
                            .fieldMappings(
                                JsonValue.from(
                                    mapOf(
                                        "organization_defined_targets" to
                                            mapOf("custom_key" to "custom_value"),
                                        "linked_account_defined_targets" to
                                            mapOf("custom_key" to "custom_value")
                                    )
                                )
                            )
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .remoteData(
                                listOf(
                                    RemoteData.builder()
                                        .path("string")
                                        .data(JsonString.of("abc"))
                                        .build()
                                )
                            )
                            .build()
                    )
                )
                .taxes(
                    listOf(
                        EmployeePayrollRun.Tax.builder()
                            .id("e3a825fd-c38d-4095-a717-df98c4cb9ebc")
                            .remoteId("26806834")
                            .employeePayrollRun("35347df1-95e7-46e2-93cc-66f1191edca5")
                            .name("California State Income Tax")
                            .amount(42.23)
                            .employerTax(true)
                            .remoteWasDeleted(true)
                            .fieldMappings(
                                JsonValue.from(
                                    mapOf(
                                        "organization_defined_targets" to
                                            mapOf("custom_key" to "custom_value"),
                                        "linked_account_defined_targets" to
                                            mapOf("custom_key" to "custom_value")
                                    )
                                )
                            )
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .remoteData(
                                listOf(
                                    RemoteData.builder()
                                        .path("string")
                                        .data(JsonString.of("abc"))
                                        .build()
                                )
                            )
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
        assertThat(employeePayrollRun).isNotNull
        assertThat(employeePayrollRun.id()).contains("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
        assertThat(employeePayrollRun.remoteId()).contains("19202938")
        assertThat(employeePayrollRun.employee()).contains("d2f972d0-2526-434b-9409-4c3b468e08f0")
        assertThat(employeePayrollRun.payrollRun()).contains("35347df1-95e7-46e2-93cc-66f1191edca5")
        assertThat(employeePayrollRun.grossPay()).contains(42.23)
        assertThat(employeePayrollRun.netPay()).contains(42.23)
        assertThat(employeePayrollRun.startDate())
            .contains(OffsetDateTime.parse("2020-11-08T00:00:00Z"))
        assertThat(employeePayrollRun.endDate())
            .contains(OffsetDateTime.parse("2020-11-09T00:00:00Z"))
        assertThat(employeePayrollRun.checkDate())
            .contains(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
        assertThat(employeePayrollRun.earnings().get())
            .containsExactly(
                EmployeePayrollRun.Earning.builder()
                    .id("babbced6-3a81-4775-8da2-490dc6385259")
                    .remoteId("52802")
                    .employeePayrollRun("35347df1-95e7-46e2-93cc-66f1191edca5")
                    .amount(42.23)
                    .type(EmployeePayrollRun.Earning.EarningTypeEnum.SALARY)
                    .remoteWasDeleted(true)
                    .fieldMappings(
                        JsonValue.from(
                            mapOf(
                                "organization_defined_targets" to
                                    mapOf("custom_key" to "custom_value"),
                                "linked_account_defined_targets" to
                                    mapOf("custom_key" to "custom_value")
                            )
                        )
                    )
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .remoteData(
                        listOf(
                            RemoteData.builder().path("string").data(JsonString.of("abc")).build()
                        )
                    )
                    .build()
            )
        assertThat(employeePayrollRun.deductions().get())
            .containsExactly(
                EmployeePayrollRun.Deduction.builder()
                    .id("5fd439fc-1b64-4755-b275-64918936c365")
                    .remoteId("93478612")
                    .employeePayrollRun("35347df1-95e7-46e2-93cc-66f1191edca5")
                    .name("Social Security")
                    .employeeDeduction(42.23)
                    .companyDeduction(42.23)
                    .remoteWasDeleted(true)
                    .fieldMappings(
                        JsonValue.from(
                            mapOf(
                                "organization_defined_targets" to
                                    mapOf("custom_key" to "custom_value"),
                                "linked_account_defined_targets" to
                                    mapOf("custom_key" to "custom_value")
                            )
                        )
                    )
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .remoteData(
                        listOf(
                            RemoteData.builder().path("string").data(JsonString.of("abc")).build()
                        )
                    )
                    .build()
            )
        assertThat(employeePayrollRun.taxes().get())
            .containsExactly(
                EmployeePayrollRun.Tax.builder()
                    .id("e3a825fd-c38d-4095-a717-df98c4cb9ebc")
                    .remoteId("26806834")
                    .employeePayrollRun("35347df1-95e7-46e2-93cc-66f1191edca5")
                    .name("California State Income Tax")
                    .amount(42.23)
                    .employerTax(true)
                    .remoteWasDeleted(true)
                    .fieldMappings(
                        JsonValue.from(
                            mapOf(
                                "organization_defined_targets" to
                                    mapOf("custom_key" to "custom_value"),
                                "linked_account_defined_targets" to
                                    mapOf("custom_key" to "custom_value")
                            )
                        )
                    )
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .remoteData(
                        listOf(
                            RemoteData.builder().path("string").data(JsonString.of("abc")).build()
                        )
                    )
                    .build()
            )
        assertThat(employeePayrollRun.remoteWasDeleted()).contains(true)
        assertThat(employeePayrollRun._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(employeePayrollRun.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(employeePayrollRun.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
