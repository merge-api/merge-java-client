package dev.merge.api.models.ats

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EeocRetrieveParamsTest {

    @Test
    fun createEeocRetrieveParams() {
        EeocRetrieveParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .expand(listOf(EeocRetrieveParams.Expand.CANDIDATE))
            .includeRemoteData(true)
            .remoteFields(EeocRetrieveParams.RemoteFields.DISABILITY_STATUS)
            .showEnumOrigins(EeocRetrieveParams.ShowEnumOrigins.DISABILITY_STATUS)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            EeocRetrieveParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .expand(listOf(EeocRetrieveParams.Expand.CANDIDATE))
                .includeRemoteData(true)
                .remoteFields(EeocRetrieveParams.RemoteFields.DISABILITY_STATUS)
                .showEnumOrigins(EeocRetrieveParams.ShowEnumOrigins.DISABILITY_STATUS)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("expand", listOf(EeocRetrieveParams.Expand.CANDIDATE.toString()))
        expected.put("include_remote_data", listOf("true"))
        expected.put(
            "remote_fields",
            listOf(EeocRetrieveParams.RemoteFields.DISABILITY_STATUS.toString())
        )
        expected.put(
            "show_enum_origins",
            listOf(EeocRetrieveParams.ShowEnumOrigins.DISABILITY_STATUS.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = EeocRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params = EeocRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
