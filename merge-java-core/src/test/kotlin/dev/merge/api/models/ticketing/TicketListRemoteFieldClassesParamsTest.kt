package dev.merge.api.models.ticketing

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketListRemoteFieldClassesParamsTest {

    @Test
    fun createTicketListRemoteFieldClassesParams() {
        TicketListRemoteFieldClassesParams.builder()
            .cursor("string")
            .includeDeletedData(true)
            .includeRemoteData(true)
            .pageSize(123L)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            TicketListRemoteFieldClassesParams.builder()
                .cursor("string")
                .includeDeletedData(true)
                .includeRemoteData(true)
                .pageSize(123L)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("cursor", listOf("string"))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("page_size", listOf("123"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = TicketListRemoteFieldClassesParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
