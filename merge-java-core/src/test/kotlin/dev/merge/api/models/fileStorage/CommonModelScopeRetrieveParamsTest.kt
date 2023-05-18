package dev.merge.api.models.fileStorage

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CommonModelScopeRetrieveParamsTest {

    @Test
    fun createCommonModelScopeRetrieveParams() {
        CommonModelScopeRetrieveParams.builder().linkedAccountId("string").build()
    }

    @Test
    fun getQueryParams() {
        val params = CommonModelScopeRetrieveParams.builder().linkedAccountId("string").build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("linked_account_id", listOf("string"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = CommonModelScopeRetrieveParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
