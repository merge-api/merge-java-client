package dev.merge.api.models.ats

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ScorecardRetrieveParamsTest {

    @Test
    fun createScorecardRetrieveParams() {
        ScorecardRetrieveParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .expand(listOf(ScorecardRetrieveParams.Expand.APPLICATION))
            .includeRemoteData(true)
            .remoteFields(ScorecardRetrieveParams.RemoteFields.OVERALL_RECOMMENDATION)
            .showEnumOrigins(ScorecardRetrieveParams.ShowEnumOrigins.OVERALL_RECOMMENDATION)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            ScorecardRetrieveParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .expand(listOf(ScorecardRetrieveParams.Expand.APPLICATION))
                .includeRemoteData(true)
                .remoteFields(ScorecardRetrieveParams.RemoteFields.OVERALL_RECOMMENDATION)
                .showEnumOrigins(ScorecardRetrieveParams.ShowEnumOrigins.OVERALL_RECOMMENDATION)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("expand", listOf(ScorecardRetrieveParams.Expand.APPLICATION.toString()))
        expected.put("include_remote_data", listOf("true"))
        expected.put(
            "remote_fields",
            listOf(ScorecardRetrieveParams.RemoteFields.OVERALL_RECOMMENDATION.toString())
        )
        expected.put(
            "show_enum_origins",
            listOf(ScorecardRetrieveParams.ShowEnumOrigins.OVERALL_RECOMMENDATION.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            ScorecardRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            ScorecardRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
