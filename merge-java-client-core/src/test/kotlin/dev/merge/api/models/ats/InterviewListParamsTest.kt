package dev.merge.api.models.ats

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InterviewListParamsTest {

    @Test
    fun createInterviewListParams() {
        InterviewListParams.builder()
            .applicationId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .expand(listOf(InterviewListParams.Expand.APPLICATION))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .jobInterviewStageId("string")
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .organizerId("string")
            .pageSize(123L)
            .remoteFields(InterviewListParams.RemoteFields.STATUS)
            .remoteId("string")
            .showEnumOrigins(InterviewListParams.ShowEnumOrigins.STATUS)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            InterviewListParams.builder()
                .applicationId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .expand(listOf(InterviewListParams.Expand.APPLICATION))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .jobInterviewStageId("string")
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .organizerId("string")
                .pageSize(123L)
                .remoteFields(InterviewListParams.RemoteFields.STATUS)
                .remoteId("string")
                .showEnumOrigins(InterviewListParams.ShowEnumOrigins.STATUS)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("application_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(InterviewListParams.Expand.APPLICATION.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("job_interview_stage_id", listOf("string"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("organizer_id", listOf("string"))
        expected.put("page_size", listOf("123"))
        expected.put("remote_fields", listOf(InterviewListParams.RemoteFields.STATUS.toString()))
        expected.put("remote_id", listOf("string"))
        expected.put(
            "show_enum_origins",
            listOf(InterviewListParams.ShowEnumOrigins.STATUS.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = InterviewListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
