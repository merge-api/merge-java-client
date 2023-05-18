package dev.merge.api.models.ats

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationMetaForCreateParamsTest {

    @Test
    fun createApplicationMetaForCreateParams() {
        ApplicationMetaForCreateParams.builder().applicationRemoteTemplateId("string").build()
    }

    @Test
    fun getQueryParams() {
        val params =
            ApplicationMetaForCreateParams.builder().applicationRemoteTemplateId("string").build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("application_remote_template_id", listOf("string"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = ApplicationMetaForCreateParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
