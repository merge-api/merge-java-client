package dev.merge.api.models.ticketing

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CollectionListUsersParamsTest {

    @Test
    fun createCollectionListUsersParams() {
        CollectionListUsersParams.builder()
            .parentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .cursor("string")
            .expand(listOf(CollectionListUsersParams.Expand.TEAMS))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .pageSize(123L)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            CollectionListUsersParams.builder()
                .parentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .cursor("string")
                .expand(listOf(CollectionListUsersParams.Expand.TEAMS))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .pageSize(123L)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(CollectionListUsersParams.Expand.TEAMS.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("page_size", listOf("123"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            CollectionListUsersParams.builder()
                .parentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            CollectionListUsersParams.builder()
                .parentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        assertThat(params).isNotNull
        // path param "parentId"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
