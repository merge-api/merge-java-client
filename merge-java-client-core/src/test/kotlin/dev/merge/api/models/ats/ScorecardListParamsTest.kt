package dev.merge.api.models.ats

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ScorecardListParamsTest {

    @Test
    fun createScorecardListParams() {
        ScorecardListParams.builder()
            .applicationId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .expand(listOf(ScorecardListParams.Expand.APPLICATION))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .interviewId("string")
            .interviewerId("string")
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .remoteFields(ScorecardListParams.RemoteFields.OVERALL_RECOMMENDATION)
            .remoteId("string")
            .showEnumOrigins(ScorecardListParams.ShowEnumOrigins.OVERALL_RECOMMENDATION)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            ScorecardListParams.builder()
                .applicationId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .expand(listOf(ScorecardListParams.Expand.APPLICATION))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .interviewId("string")
                .interviewerId("string")
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .remoteFields(ScorecardListParams.RemoteFields.OVERALL_RECOMMENDATION)
                .remoteId("string")
                .showEnumOrigins(ScorecardListParams.ShowEnumOrigins.OVERALL_RECOMMENDATION)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("application_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(ScorecardListParams.Expand.APPLICATION.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("interview_id", listOf("string"))
        expected.put("interviewer_id", listOf("string"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put(
            "remote_fields",
            listOf(ScorecardListParams.RemoteFields.OVERALL_RECOMMENDATION.toString())
        )
        expected.put("remote_id", listOf("string"))
        expected.put(
            "show_enum_origins",
            listOf(ScorecardListParams.ShowEnumOrigins.OVERALL_RECOMMENDATION.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = ScorecardListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
