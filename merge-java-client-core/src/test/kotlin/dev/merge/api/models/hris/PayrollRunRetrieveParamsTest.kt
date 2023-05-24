package dev.merge.api.models.hris

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PayrollRunRetrieveParamsTest {

    @Test
    fun createPayrollRunRetrieveParams() {
        PayrollRunRetrieveParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .includeRemoteData(true)
            .remoteFields(PayrollRunRetrieveParams.RemoteFields.RUN_STATE)
            .showEnumOrigins(PayrollRunRetrieveParams.ShowEnumOrigins.RUN_STATE)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            PayrollRunRetrieveParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .includeRemoteData(true)
                .remoteFields(PayrollRunRetrieveParams.RemoteFields.RUN_STATE)
                .showEnumOrigins(PayrollRunRetrieveParams.ShowEnumOrigins.RUN_STATE)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("include_remote_data", listOf("true"))
        expected.put(
            "remote_fields",
            listOf(PayrollRunRetrieveParams.RemoteFields.RUN_STATE.toString())
        )
        expected.put(
            "show_enum_origins",
            listOf(PayrollRunRetrieveParams.ShowEnumOrigins.RUN_STATE.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            PayrollRunRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            PayrollRunRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
