package dev.merge.api.models.ats

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ActivityRetrieveParamsTest {

    @Test
    fun createActivityRetrieveParams() {
        ActivityRetrieveParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .expand(listOf(ActivityRetrieveParams.Expand.USER))
            .includeRemoteData(true)
            .remoteFields(ActivityRetrieveParams.RemoteFields.ACTIVITY_TYPE)
            .showEnumOrigins(ActivityRetrieveParams.ShowEnumOrigins.ACTIVITY_TYPE)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            ActivityRetrieveParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .expand(listOf(ActivityRetrieveParams.Expand.USER))
                .includeRemoteData(true)
                .remoteFields(ActivityRetrieveParams.RemoteFields.ACTIVITY_TYPE)
                .showEnumOrigins(ActivityRetrieveParams.ShowEnumOrigins.ACTIVITY_TYPE)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("expand", listOf(ActivityRetrieveParams.Expand.USER.toString()))
        expected.put("include_remote_data", listOf("true"))
        expected.put(
            "remote_fields",
            listOf(ActivityRetrieveParams.RemoteFields.ACTIVITY_TYPE.toString())
        )
        expected.put(
            "show_enum_origins",
            listOf(ActivityRetrieveParams.ShowEnumOrigins.ACTIVITY_TYPE.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            ActivityRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            ActivityRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
