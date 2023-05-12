package dev.merge.api.models.ats

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationListParamsTest {

    @Test
    fun createApplicationListParams() {
        ApplicationListParams.builder()
            .candidateId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .creditedToId("string")
            .currentStageId("string")
            .cursor("string")
            .expand(listOf(ApplicationListParams.Expand.CANDIDATE))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .jobId("string")
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .rejectReasonId("string")
            .remoteId("string")
            .source("string")
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            ApplicationListParams.builder()
                .candidateId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .creditedToId("string")
                .currentStageId("string")
                .cursor("string")
                .expand(listOf(ApplicationListParams.Expand.CANDIDATE))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .jobId("string")
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .rejectReasonId("string")
                .remoteId("string")
                .source("string")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("candidate_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("credited_to_id", listOf("string"))
        expected.put("current_stage_id", listOf("string"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(ApplicationListParams.Expand.CANDIDATE.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("job_id", listOf("string"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put("reject_reason_id", listOf("string"))
        expected.put("remote_id", listOf("string"))
        expected.put("source", listOf("string"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = ApplicationListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
