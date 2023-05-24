package dev.merge.api.models.accounting

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ItemListParamsTest {

    @Test
    fun createItemListParams() {
        ItemListParams.builder()
            .companyId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .expand(listOf(ItemListParams.Expand.COMPANY))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .remoteFields(ItemListParams.RemoteFields.STATUS)
            .remoteId("string")
            .showEnumOrigins(ItemListParams.ShowEnumOrigins.STATUS)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            ItemListParams.builder()
                .companyId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .expand(listOf(ItemListParams.Expand.COMPANY))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .remoteFields(ItemListParams.RemoteFields.STATUS)
                .remoteId("string")
                .showEnumOrigins(ItemListParams.ShowEnumOrigins.STATUS)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("company_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(ItemListParams.Expand.COMPANY.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put("remote_fields", listOf(ItemListParams.RemoteFields.STATUS.toString()))
        expected.put("remote_id", listOf("string"))
        expected.put("show_enum_origins", listOf(ItemListParams.ShowEnumOrigins.STATUS.toString()))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = ItemListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
