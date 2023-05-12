package dev.merge.api.models.hris

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmploymentListParamsTest {

    @Test
    fun createEmploymentListParams() {
        EmploymentListParams.builder()
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .employeeId("string")
            .expand(listOf(EmploymentListParams.Expand.EMPLOYEE))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .orderBy(EmploymentListParams.OrderBy.EFFECTIVE_DATE_DESC)
            .pageSize(123L)
            .remoteFields(EmploymentListParams.RemoteFields.EMPLOYMENT_TYPE)
            .remoteId("string")
            .showEnumOrigins(EmploymentListParams.ShowEnumOrigins.EMPLOYMENT_TYPE)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            EmploymentListParams.builder()
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .employeeId("string")
                .expand(listOf(EmploymentListParams.Expand.EMPLOYEE))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .orderBy(EmploymentListParams.OrderBy.EFFECTIVE_DATE_DESC)
                .pageSize(123L)
                .remoteFields(EmploymentListParams.RemoteFields.EMPLOYMENT_TYPE)
                .remoteId("string")
                .showEnumOrigins(EmploymentListParams.ShowEnumOrigins.EMPLOYMENT_TYPE)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("employee_id", listOf("string"))
        expected.put("expand", listOf(EmploymentListParams.Expand.EMPLOYEE.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put(
            "order_by",
            listOf(EmploymentListParams.OrderBy.EFFECTIVE_DATE_DESC.toString())
        )
        expected.put("page_size", listOf("123"))
        expected.put(
            "remote_fields",
            listOf(EmploymentListParams.RemoteFields.EMPLOYMENT_TYPE.toString())
        )
        expected.put("remote_id", listOf("string"))
        expected.put(
            "show_enum_origins",
            listOf(EmploymentListParams.ShowEnumOrigins.EMPLOYMENT_TYPE.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = EmploymentListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
