package dev.merge.api.models.crm

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CustomObjectUpdateParamsTest {

    @Test
    fun createCustomObjectUpdateParams() {
        CustomObjectUpdateParams.builder()
            .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .model(
                CustomObjectUpdateParams.CustomObjectRequest.builder()
                    .fields(JsonValue.from(mapOf("test_field" to "hello")))
                    .build()
            )
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            CustomObjectUpdateParams.builder()
                .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    CustomObjectUpdateParams.CustomObjectRequest.builder()
                        .fields(JsonValue.from(mapOf("test_field" to "hello")))
                        .build()
                )
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
            CustomObjectUpdateParams.builder()
                .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    CustomObjectUpdateParams.CustomObjectRequest.builder()
                        .fields(JsonValue.from(mapOf("test_field" to "hello")))
                        .build()
                )
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            CustomObjectUpdateParams.builder()
                .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    CustomObjectUpdateParams.CustomObjectRequest.builder()
                        .fields(JsonValue.from(mapOf("test_field" to "hello")))
                        .build()
                )
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                CustomObjectUpdateParams.CustomObjectRequest.builder()
                    .fields(JsonValue.from(mapOf("test_field" to "hello")))
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            CustomObjectUpdateParams.builder()
                .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    CustomObjectUpdateParams.CustomObjectRequest.builder()
                        .fields(JsonValue.from(mapOf("test_field" to "hello")))
                        .build()
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                CustomObjectUpdateParams.CustomObjectRequest.builder()
                    .fields(JsonValue.from(mapOf("test_field" to "hello")))
                    .build()
            )
    }

    @Test
    fun getPathParam() {
        val params =
            CustomObjectUpdateParams.builder()
                .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    CustomObjectUpdateParams.CustomObjectRequest.builder()
                        .fields(JsonValue.from(mapOf("test_field" to "hello")))
                        .build()
                )
                .build()
        assertThat(params).isNotNull
        // path param "customObjectClassId"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // path param "id"
        assertThat(params.getPathParam(1)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
