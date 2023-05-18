package dev.merge.api.models.accounting

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AddressRetrieveParamsTest {

    @Test
    fun createAddressRetrieveParams() {
        AddressRetrieveParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .includeRemoteData(true)
            .remoteFields(AddressRetrieveParams.RemoteFields.TYPE)
            .showEnumOrigins(AddressRetrieveParams.ShowEnumOrigins.TYPE)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            AddressRetrieveParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .includeRemoteData(true)
                .remoteFields(AddressRetrieveParams.RemoteFields.TYPE)
                .showEnumOrigins(AddressRetrieveParams.ShowEnumOrigins.TYPE)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("include_remote_data", listOf("true"))
        expected.put("remote_fields", listOf(AddressRetrieveParams.RemoteFields.TYPE.toString()))
        expected.put(
            "show_enum_origins",
            listOf(AddressRetrieveParams.ShowEnumOrigins.TYPE.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            AddressRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            AddressRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
