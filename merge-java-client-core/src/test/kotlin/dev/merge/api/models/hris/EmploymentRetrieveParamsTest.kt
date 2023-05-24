package dev.merge.api.models.hris

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmploymentRetrieveParamsTest {

    @Test
    fun createEmploymentRetrieveParams() {
        EmploymentRetrieveParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .expand(listOf(EmploymentRetrieveParams.Expand.EMPLOYEE))
            .includeRemoteData(true)
            .remoteFields(EmploymentRetrieveParams.RemoteFields.EMPLOYMENT_TYPE)
            .showEnumOrigins(EmploymentRetrieveParams.ShowEnumOrigins.EMPLOYMENT_TYPE)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            EmploymentRetrieveParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .expand(listOf(EmploymentRetrieveParams.Expand.EMPLOYEE))
                .includeRemoteData(true)
                .remoteFields(EmploymentRetrieveParams.RemoteFields.EMPLOYMENT_TYPE)
                .showEnumOrigins(EmploymentRetrieveParams.ShowEnumOrigins.EMPLOYMENT_TYPE)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("expand", listOf(EmploymentRetrieveParams.Expand.EMPLOYEE.toString()))
        expected.put("include_remote_data", listOf("true"))
        expected.put(
            "remote_fields",
            listOf(EmploymentRetrieveParams.RemoteFields.EMPLOYMENT_TYPE.toString())
        )
        expected.put(
            "show_enum_origins",
            listOf(EmploymentRetrieveParams.ShowEnumOrigins.EMPLOYMENT_TYPE.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            EmploymentRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            EmploymentRetrieveParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
