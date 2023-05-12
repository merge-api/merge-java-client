package dev.merge.api.models.crm

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LeadListParamsTest {

    @Test
    fun createLeadListParams() {
        LeadListParams.builder()
            .convertedAccountId("string")
            .convertedContactId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .expand(listOf(LeadListParams.Expand.CONVERTED_ACCOUNT))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .includeRemoteFields(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .ownerId("string")
            .pageSize(123L)
            .remoteId("string")
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            LeadListParams.builder()
                .convertedAccountId("string")
                .convertedContactId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .expand(listOf(LeadListParams.Expand.CONVERTED_ACCOUNT))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .includeRemoteFields(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .ownerId("string")
                .pageSize(123L)
                .remoteId("string")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("converted_account_id", listOf("string"))
        expected.put("converted_contact_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(LeadListParams.Expand.CONVERTED_ACCOUNT.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("include_remote_fields", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("owner_id", listOf("string"))
        expected.put("page_size", listOf("123"))
        expected.put("remote_id", listOf("string"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = LeadListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
