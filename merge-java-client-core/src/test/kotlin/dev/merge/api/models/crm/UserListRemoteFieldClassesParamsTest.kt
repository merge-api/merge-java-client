package dev.merge.api.models.crm

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserListRemoteFieldClassesParamsTest {

    @Test
    fun createUserListRemoteFieldClassesParams() {
        UserListRemoteFieldClassesParams.builder()
            .cursor("string")
            .includeDeletedData(true)
            .includeRemoteData(true)
            .includeRemoteFields(true)
            .pageSize(123L)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            UserListRemoteFieldClassesParams.builder()
                .cursor("string")
                .includeDeletedData(true)
                .includeRemoteData(true)
                .includeRemoteFields(true)
                .pageSize(123L)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("cursor", listOf("string"))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("include_remote_fields", listOf("true"))
        expected.put("page_size", listOf("123"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = UserListRemoteFieldClassesParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
