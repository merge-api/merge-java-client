package dev.merge.api.models.hris

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmployeeListParamsTest {

    @Test
    fun createEmployeeListParams() {
        EmployeeListParams.builder()
            .companyId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .displayFullName("string")
            .employmentStatus(EmployeeListParams.EmploymentStatus.ACTIVE)
            .expand(listOf(EmployeeListParams.Expand.COMPANY))
            .firstName("string")
            .groups("string")
            .includeDeletedData(true)
            .includeRemoteData(true)
            .includeSensitiveFields(true)
            .lastName("string")
            .managerId("string")
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .payGroupId("string")
            .personalEmail("dev@stainlessapi.com")
            .remoteFields(EmployeeListParams.RemoteFields.EMPLOYMENT_STATUS)
            .remoteId("string")
            .showEnumOrigins(EmployeeListParams.ShowEnumOrigins.EMPLOYMENT_STATUS)
            .startedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .startedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .teamId("string")
            .terminatedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .terminatedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .workEmail("dev@stainlessapi.com")
            .workLocationId("string")
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            EmployeeListParams.builder()
                .companyId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .displayFullName("string")
                .employmentStatus(EmployeeListParams.EmploymentStatus.ACTIVE)
                .expand(listOf(EmployeeListParams.Expand.COMPANY))
                .firstName("string")
                .groups("string")
                .includeDeletedData(true)
                .includeRemoteData(true)
                .includeSensitiveFields(true)
                .lastName("string")
                .managerId("string")
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .payGroupId("string")
                .personalEmail("dev@stainlessapi.com")
                .remoteFields(EmployeeListParams.RemoteFields.EMPLOYMENT_STATUS)
                .remoteId("string")
                .showEnumOrigins(EmployeeListParams.ShowEnumOrigins.EMPLOYMENT_STATUS)
                .startedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .startedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .teamId("string")
                .terminatedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .terminatedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .workEmail("dev@stainlessapi.com")
                .workLocationId("string")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("company_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("display_full_name", listOf("string"))
        expected.put(
            "employment_status",
            listOf(EmployeeListParams.EmploymentStatus.ACTIVE.toString())
        )
        expected.put("expand", listOf(EmployeeListParams.Expand.COMPANY.toString()))
        expected.put("first_name", listOf("string"))
        expected.put("groups", listOf("string"))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("include_sensitive_fields", listOf("true"))
        expected.put("last_name", listOf("string"))
        expected.put("manager_id", listOf("string"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put("pay_group_id", listOf("string"))
        expected.put("personal_email", listOf("dev@stainlessapi.com"))
        expected.put(
            "remote_fields",
            listOf(EmployeeListParams.RemoteFields.EMPLOYMENT_STATUS.toString())
        )
        expected.put("remote_id", listOf("string"))
        expected.put(
            "show_enum_origins",
            listOf(EmployeeListParams.ShowEnumOrigins.EMPLOYMENT_STATUS.toString())
        )
        expected.put("started_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("started_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("team_id", listOf("string"))
        expected.put("terminated_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("terminated_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("work_email", listOf("dev@stainlessapi.com"))
        expected.put("work_location_id", listOf("string"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = EmployeeListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
