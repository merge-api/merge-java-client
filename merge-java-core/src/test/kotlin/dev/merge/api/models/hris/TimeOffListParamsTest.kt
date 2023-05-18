package dev.merge.api.models.hris

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TimeOffListParamsTest {

    @Test
    fun createTimeOffListParams() {
        TimeOffListParams.builder()
            .approverId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .employeeId("string")
            .expand(listOf(TimeOffListParams.Expand.APPROVER))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .remoteFields(TimeOffListParams.RemoteFields.REQUEST_TYPE)
            .remoteId("string")
            .requestType(TimeOffListParams.RequestType.BEREAVEMENT)
            .showEnumOrigins(TimeOffListParams.ShowEnumOrigins.REQUEST_TYPE)
            .status(TimeOffListParams.Status.APPROVED)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            TimeOffListParams.builder()
                .approverId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .employeeId("string")
                .expand(listOf(TimeOffListParams.Expand.APPROVER))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .remoteFields(TimeOffListParams.RemoteFields.REQUEST_TYPE)
                .remoteId("string")
                .requestType(TimeOffListParams.RequestType.BEREAVEMENT)
                .showEnumOrigins(TimeOffListParams.ShowEnumOrigins.REQUEST_TYPE)
                .status(TimeOffListParams.Status.APPROVED)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("approver_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("employee_id", listOf("string"))
        expected.put("expand", listOf(TimeOffListParams.Expand.APPROVER.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put(
            "remote_fields",
            listOf(TimeOffListParams.RemoteFields.REQUEST_TYPE.toString())
        )
        expected.put("remote_id", listOf("string"))
        expected.put("request_type", listOf(TimeOffListParams.RequestType.BEREAVEMENT.toString()))
        expected.put(
            "show_enum_origins",
            listOf(TimeOffListParams.ShowEnumOrigins.REQUEST_TYPE.toString())
        )
        expected.put("status", listOf(TimeOffListParams.Status.APPROVED.toString()))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = TimeOffListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
