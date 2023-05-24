package dev.merge.api.models.hris

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TimeOffBalanceListParamsTest {

    @Test
    fun createTimeOffBalanceListParams() {
        TimeOffBalanceListParams.builder()
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .employeeId("string")
            .expand(listOf(TimeOffBalanceListParams.Expand.EMPLOYEE))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .policyType(TimeOffBalanceListParams.PolicyType.BEREAVEMENT)
            .remoteFields(TimeOffBalanceListParams.RemoteFields.POLICY_TYPE)
            .remoteId("string")
            .showEnumOrigins(TimeOffBalanceListParams.ShowEnumOrigins.POLICY_TYPE)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            TimeOffBalanceListParams.builder()
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .employeeId("string")
                .expand(listOf(TimeOffBalanceListParams.Expand.EMPLOYEE))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .policyType(TimeOffBalanceListParams.PolicyType.BEREAVEMENT)
                .remoteFields(TimeOffBalanceListParams.RemoteFields.POLICY_TYPE)
                .remoteId("string")
                .showEnumOrigins(TimeOffBalanceListParams.ShowEnumOrigins.POLICY_TYPE)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("employee_id", listOf("string"))
        expected.put("expand", listOf(TimeOffBalanceListParams.Expand.EMPLOYEE.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put(
            "policy_type",
            listOf(TimeOffBalanceListParams.PolicyType.BEREAVEMENT.toString())
        )
        expected.put(
            "remote_fields",
            listOf(TimeOffBalanceListParams.RemoteFields.POLICY_TYPE.toString())
        )
        expected.put("remote_id", listOf("string"))
        expected.put(
            "show_enum_origins",
            listOf(TimeOffBalanceListParams.ShowEnumOrigins.POLICY_TYPE.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = TimeOffBalanceListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
