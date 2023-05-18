package dev.merge.api.models.ticketing

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketRetrieveParamsTest {

    @Test
    fun createTicketRetrieveParams() {
        TicketRetrieveParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .expand(listOf(TicketRetrieveParams.Expand.ACCOUNT))
            .includeRemoteData(true)
            .includeRemoteFields(true)
            .remoteFields(TicketRetrieveParams.RemoteFields.PRIORITY)
            .showEnumOrigins(TicketRetrieveParams.ShowEnumOrigins.PRIORITY)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            TicketRetrieveParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .expand(listOf(TicketRetrieveParams.Expand.ACCOUNT))
                .includeRemoteData(true)
                .includeRemoteFields(true)
                .remoteFields(TicketRetrieveParams.RemoteFields.PRIORITY)
                .showEnumOrigins(TicketRetrieveParams.ShowEnumOrigins.PRIORITY)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("expand", listOf(TicketRetrieveParams.Expand.ACCOUNT.toString()))
        expected.put("include_remote_data", listOf("true"))
        expected.put("include_remote_fields", listOf("true"))
        expected.put("remote_fields", listOf(TicketRetrieveParams.RemoteFields.PRIORITY.toString()))
        expected.put(
            "show_enum_origins",
            listOf(TicketRetrieveParams.ShowEnumOrigins.PRIORITY.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            TicketRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            TicketRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
