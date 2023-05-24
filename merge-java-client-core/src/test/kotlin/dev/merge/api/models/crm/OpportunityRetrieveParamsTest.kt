package dev.merge.api.models.crm

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OpportunityRetrieveParamsTest {

    @Test
    fun createOpportunityRetrieveParams() {
        OpportunityRetrieveParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .expand(listOf(OpportunityRetrieveParams.Expand.ACCOUNT))
            .includeRemoteData(true)
            .includeRemoteFields(true)
            .remoteFields(OpportunityRetrieveParams.RemoteFields.STATUS)
            .showEnumOrigins(OpportunityRetrieveParams.ShowEnumOrigins.STATUS)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            OpportunityRetrieveParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .expand(listOf(OpportunityRetrieveParams.Expand.ACCOUNT))
                .includeRemoteData(true)
                .includeRemoteFields(true)
                .remoteFields(OpportunityRetrieveParams.RemoteFields.STATUS)
                .showEnumOrigins(OpportunityRetrieveParams.ShowEnumOrigins.STATUS)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("expand", listOf(OpportunityRetrieveParams.Expand.ACCOUNT.toString()))
        expected.put("include_remote_data", listOf("true"))
        expected.put("include_remote_fields", listOf("true"))
        expected.put(
            "remote_fields",
            listOf(OpportunityRetrieveParams.RemoteFields.STATUS.toString())
        )
        expected.put(
            "show_enum_origins",
            listOf(OpportunityRetrieveParams.ShowEnumOrigins.STATUS.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            OpportunityRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            OpportunityRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
