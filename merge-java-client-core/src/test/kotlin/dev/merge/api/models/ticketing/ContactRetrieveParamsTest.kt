package dev.merge.api.models.ticketing

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ContactRetrieveParamsTest {

    @Test
    fun createContactRetrieveParams() {
        ContactRetrieveParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .expand(listOf(ContactRetrieveParams.Expand.ACCOUNT))
            .includeRemoteData(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            ContactRetrieveParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .expand(listOf(ContactRetrieveParams.Expand.ACCOUNT))
                .includeRemoteData(true)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("expand", listOf(ContactRetrieveParams.Expand.ACCOUNT.toString()))
        expected.put("include_remote_data", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            ContactRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            ContactRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
