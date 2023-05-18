package dev.merge.api.models.crm

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OpportunityListParamsTest {

    @Test
    fun createOpportunityListParams() {
        OpportunityListParams.builder()
            .accountId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .expand(listOf(OpportunityListParams.Expand.ACCOUNT))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .includeRemoteFields(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .ownerId("string")
            .pageSize(123L)
            .remoteFields(OpportunityListParams.RemoteFields.STATUS)
            .remoteId("string")
            .showEnumOrigins(OpportunityListParams.ShowEnumOrigins.STATUS)
            .stageId("string")
            .status(OpportunityListParams.Status.LOST)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            OpportunityListParams.builder()
                .accountId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .expand(listOf(OpportunityListParams.Expand.ACCOUNT))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .includeRemoteFields(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .ownerId("string")
                .pageSize(123L)
                .remoteFields(OpportunityListParams.RemoteFields.STATUS)
                .remoteId("string")
                .showEnumOrigins(OpportunityListParams.ShowEnumOrigins.STATUS)
                .stageId("string")
                .status(OpportunityListParams.Status.LOST)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("account_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(OpportunityListParams.Expand.ACCOUNT.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("include_remote_fields", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("owner_id", listOf("string"))
        expected.put("page_size", listOf("123"))
        expected.put("remote_fields", listOf(OpportunityListParams.RemoteFields.STATUS.toString()))
        expected.put("remote_id", listOf("string"))
        expected.put(
            "show_enum_origins",
            listOf(OpportunityListParams.ShowEnumOrigins.STATUS.toString())
        )
        expected.put("stage_id", listOf("string"))
        expected.put("status", listOf(OpportunityListParams.Status.LOST.toString()))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = OpportunityListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
