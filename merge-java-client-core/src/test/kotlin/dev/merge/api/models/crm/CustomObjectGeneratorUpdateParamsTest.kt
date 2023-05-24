package dev.merge.api.models.crm

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CustomObjectGeneratorUpdateParamsTest {

    @Test
    fun createCustomObjectGeneratorUpdateParams() {
        CustomObjectGeneratorUpdateParams.builder()
            .generatorId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            CustomObjectGeneratorUpdateParams.builder()
                .generatorId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("is_debug_mode", listOf("true"))
        expected.put("run_async", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            CustomObjectGeneratorUpdateParams.builder()
                .generatorId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            CustomObjectGeneratorUpdateParams.builder()
                .generatorId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        assertThat(params).isNotNull
        // path param "generatorId"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
