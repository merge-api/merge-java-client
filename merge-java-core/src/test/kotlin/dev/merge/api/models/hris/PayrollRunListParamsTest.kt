package dev.merge.api.models.hris

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PayrollRunListParamsTest {

    @Test
    fun createPayrollRunListParams() {
        PayrollRunListParams.builder()
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .endedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .endedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .remoteFields(PayrollRunListParams.RemoteFields.RUN_STATE)
            .remoteId("string")
            .runType(PayrollRunListParams.RunType.CORRECTION)
            .showEnumOrigins(PayrollRunListParams.ShowEnumOrigins.RUN_STATE)
            .startedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .startedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            PayrollRunListParams.builder()
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .endedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .endedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .remoteFields(PayrollRunListParams.RemoteFields.RUN_STATE)
                .remoteId("string")
                .runType(PayrollRunListParams.RunType.CORRECTION)
                .showEnumOrigins(PayrollRunListParams.ShowEnumOrigins.RUN_STATE)
                .startedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .startedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("ended_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("ended_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put(
            "remote_fields",
            listOf(PayrollRunListParams.RemoteFields.RUN_STATE.toString())
        )
        expected.put("remote_id", listOf("string"))
        expected.put("run_type", listOf(PayrollRunListParams.RunType.CORRECTION.toString()))
        expected.put(
            "show_enum_origins",
            listOf(PayrollRunListParams.ShowEnumOrigins.RUN_STATE.toString())
        )
        expected.put("started_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("started_before", listOf("2019-12-27T18:11:19.117Z"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = PayrollRunListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
