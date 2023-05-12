package dev.merge.api.models.ats

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JobListParamsTest {

    @Test
    fun createJobListParams() {
        JobListParams.builder()
            .code("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .expand(listOf(JobListParams.Expand.DEPARTMENTS))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .offices("string")
            .pageSize(123L)
            .remoteFields(JobListParams.RemoteFields.STATUS)
            .remoteId("string")
            .showEnumOrigins(JobListParams.ShowEnumOrigins.STATUS)
            .status(JobListParams.Status.ARCHIVED)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            JobListParams.builder()
                .code("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .expand(listOf(JobListParams.Expand.DEPARTMENTS))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .offices("string")
                .pageSize(123L)
                .remoteFields(JobListParams.RemoteFields.STATUS)
                .remoteId("string")
                .showEnumOrigins(JobListParams.ShowEnumOrigins.STATUS)
                .status(JobListParams.Status.ARCHIVED)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("code", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(JobListParams.Expand.DEPARTMENTS.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("offices", listOf("string"))
        expected.put("page_size", listOf("123"))
        expected.put("remote_fields", listOf(JobListParams.RemoteFields.STATUS.toString()))
        expected.put("remote_id", listOf("string"))
        expected.put("show_enum_origins", listOf(JobListParams.ShowEnumOrigins.STATUS.toString()))
        expected.put("status", listOf(JobListParams.Status.ARCHIVED.toString()))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = JobListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
