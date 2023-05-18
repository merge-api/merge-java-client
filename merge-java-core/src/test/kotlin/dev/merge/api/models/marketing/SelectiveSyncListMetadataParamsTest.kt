package dev.merge.api.models.marketing

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SelectiveSyncListMetadataParamsTest {

    @Test
    fun createSelectiveSyncListMetadataParams() {
        SelectiveSyncListMetadataParams.builder()
            .commonModel("string")
            .cursor("string")
            .pageSize(123L)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            SelectiveSyncListMetadataParams.builder()
                .commonModel("string")
                .cursor("string")
                .pageSize(123L)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("common_model", listOf("string"))
        expected.put("cursor", listOf("string"))
        expected.put("page_size", listOf("123"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = SelectiveSyncListMetadataParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
