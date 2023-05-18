package dev.merge.api.models.fileStorage

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileCreateParamsTest {

    @Test
    fun createFileCreateParams() {
        FileCreateParams.builder()
            .model(
                FileCreateParams.FileRequest.builder()
                    .name("omg_common_model_scope.docx")
                    .fileUrl("https://drive.com/1234")
                    .fileThumbnailUrl("https://drive.com/1234/thumbnail.png")
                    .size(123L)
                    .mimeType(".docx")
                    .description("This file is OP")
                    .folder("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .drive("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            FileCreateParams.builder()
                .model(
                    FileCreateParams.FileRequest.builder()
                        .name("omg_common_model_scope.docx")
                        .fileUrl("https://drive.com/1234")
                        .fileThumbnailUrl("https://drive.com/1234/thumbnail.png")
                        .size(123L)
                        .mimeType(".docx")
                        .description("This file is OP")
                        .folder("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .drive("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
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
            FileCreateParams.builder()
                .model(
                    FileCreateParams.FileRequest.builder()
                        .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .build()
                )
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            FileCreateParams.builder()
                .model(
                    FileCreateParams.FileRequest.builder()
                        .name("omg_common_model_scope.docx")
                        .fileUrl("https://drive.com/1234")
                        .fileThumbnailUrl("https://drive.com/1234/thumbnail.png")
                        .size(123L)
                        .mimeType(".docx")
                        .description("This file is OP")
                        .folder("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .drive("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
                        .build()
                )
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                FileCreateParams.FileRequest.builder()
                    .name("omg_common_model_scope.docx")
                    .fileUrl("https://drive.com/1234")
                    .fileThumbnailUrl("https://drive.com/1234/thumbnail.png")
                    .size(123L)
                    .mimeType(".docx")
                    .description("This file is OP")
                    .folder("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .drive("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            FileCreateParams.builder()
                .model(
                    FileCreateParams.FileRequest.builder()
                        .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .build()
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                FileCreateParams.FileRequest.builder()
                    .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .build()
            )
    }
}
