package dev.merge.api.models.accounting

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SyncStatusListParamsTest {

    @Test
    fun createSyncStatusListParams() {
        SyncStatusListParams.builder().cursor("string").pageSize(123L).build()
    }

    @Test
    fun getQueryParams() {
        val params = SyncStatusListParams.builder().cursor("string").pageSize(123L).build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("cursor", listOf("string"))
        expected.put("page_size", listOf("123"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = SyncStatusListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
