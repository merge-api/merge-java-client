package dev.merge.api.models.ticketing

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CollectionListParamsTest {

    @Test
    fun createCollectionListParams() {
        CollectionListParams.builder()
            .collectionType(CollectionListParams.CollectionType.LIST)
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .expand(listOf(CollectionListParams.Expand.PARENT_COLLECTION))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .parentCollectionId("string")
            .remoteFields(CollectionListParams.RemoteFields.COLLECTION_TYPE)
            .remoteId("string")
            .showEnumOrigins(CollectionListParams.ShowEnumOrigins.COLLECTION_TYPE)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            CollectionListParams.builder()
                .collectionType(CollectionListParams.CollectionType.LIST)
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .expand(listOf(CollectionListParams.Expand.PARENT_COLLECTION))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .parentCollectionId("string")
                .remoteFields(CollectionListParams.RemoteFields.COLLECTION_TYPE)
                .remoteId("string")
                .showEnumOrigins(CollectionListParams.ShowEnumOrigins.COLLECTION_TYPE)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("collection_type", listOf(CollectionListParams.CollectionType.LIST.toString()))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(CollectionListParams.Expand.PARENT_COLLECTION.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put("parent_collection_id", listOf("string"))
        expected.put(
            "remote_fields",
            listOf(CollectionListParams.RemoteFields.COLLECTION_TYPE.toString())
        )
        expected.put("remote_id", listOf("string"))
        expected.put(
            "show_enum_origins",
            listOf(CollectionListParams.ShowEnumOrigins.COLLECTION_TYPE.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = CollectionListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
