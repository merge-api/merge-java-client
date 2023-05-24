package dev.merge.api.models.ats

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EeocListParamsTest {

    @Test
    fun createEeocListParams() {
        EeocListParams.builder()
            .candidateId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .expand(listOf(EeocListParams.Expand.CANDIDATE))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .remoteFields(EeocListParams.RemoteFields.DISABILITY_STATUS)
            .remoteId("string")
            .showEnumOrigins(EeocListParams.ShowEnumOrigins.DISABILITY_STATUS)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            EeocListParams.builder()
                .candidateId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .expand(listOf(EeocListParams.Expand.CANDIDATE))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .remoteFields(EeocListParams.RemoteFields.DISABILITY_STATUS)
                .remoteId("string")
                .showEnumOrigins(EeocListParams.ShowEnumOrigins.DISABILITY_STATUS)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("candidate_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(EeocListParams.Expand.CANDIDATE.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put(
            "remote_fields",
            listOf(EeocListParams.RemoteFields.DISABILITY_STATUS.toString())
        )
        expected.put("remote_id", listOf("string"))
        expected.put(
            "show_enum_origins",
            listOf(EeocListParams.ShowEnumOrigins.DISABILITY_STATUS.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = EeocListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
