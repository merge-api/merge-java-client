package dev.merge.api.models.hris

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmployeePayrollRunListParamsTest {

    @Test
    fun createEmployeePayrollRunListParams() {
        EmployeePayrollRunListParams.builder()
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .employeeId("string")
            .endedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .endedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .expand(listOf(EmployeePayrollRunListParams.Expand.EMPLOYEE))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .payrollRunId("string")
            .remoteId("string")
            .startedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .startedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            EmployeePayrollRunListParams.builder()
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .employeeId("string")
                .endedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .endedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .expand(listOf(EmployeePayrollRunListParams.Expand.EMPLOYEE))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .payrollRunId("string")
                .remoteId("string")
                .startedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .startedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("employee_id", listOf("string"))
        expected.put("ended_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("ended_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("expand", listOf(EmployeePayrollRunListParams.Expand.EMPLOYEE.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put("payroll_run_id", listOf("string"))
        expected.put("remote_id", listOf("string"))
        expected.put("started_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("started_before", listOf("2019-12-27T18:11:19.117Z"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = EmployeePayrollRunListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
