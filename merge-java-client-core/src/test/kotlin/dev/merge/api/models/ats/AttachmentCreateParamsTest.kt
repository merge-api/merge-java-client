package dev.merge.api.models.ats

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AttachmentCreateParamsTest {

    @Test
    fun createAttachmentCreateParams() {
        AttachmentCreateParams.builder()
            .model(
                AttachmentCreateParams.AttachmentRequest.builder()
                    .fileName("Screenshot.png")
                    .fileUrl("http://alturl.com/p749b")
                    .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                    .attachmentType(
                        AttachmentCreateParams.AttachmentRequest.AttachmentTypeEnum.RESUME
                    )
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
                    .ticket("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .contentType("jpeg")
                    .uploadedBy("28b54125-287f-494d-965e-3c5b330c9a68")
                    .build()
            )
            .remoteUserId("string")
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            AttachmentCreateParams.builder()
                .model(
                    AttachmentCreateParams.AttachmentRequest.builder()
                        .fileName("Screenshot.png")
                        .fileUrl("http://alturl.com/p749b")
                        .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                        .attachmentType(
                            AttachmentCreateParams.AttachmentRequest.AttachmentTypeEnum.RESUME
                        )
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
                        .ticket("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .contentType("jpeg")
                        .uploadedBy("28b54125-287f-494d-965e-3c5b330c9a68")
                        .build()
                )
                .remoteUserId("string")
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
            AttachmentCreateParams.builder()
                .model(AttachmentCreateParams.AttachmentRequest.builder().build())
                .remoteUserId("string")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            AttachmentCreateParams.builder()
                .model(
                    AttachmentCreateParams.AttachmentRequest.builder()
                        .fileName("Screenshot.png")
                        .fileUrl("http://alturl.com/p749b")
                        .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                        .attachmentType(
                            AttachmentCreateParams.AttachmentRequest.AttachmentTypeEnum.RESUME
                        )
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
                        .ticket("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .contentType("jpeg")
                        .uploadedBy("28b54125-287f-494d-965e-3c5b330c9a68")
                        .build()
                )
                .remoteUserId("string")
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                AttachmentCreateParams.AttachmentRequest.builder()
                    .fileName("Screenshot.png")
                    .fileUrl("http://alturl.com/p749b")
                    .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                    .attachmentType(
                        AttachmentCreateParams.AttachmentRequest.AttachmentTypeEnum.RESUME
                    )
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
                    .ticket("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .contentType("jpeg")
                    .uploadedBy("28b54125-287f-494d-965e-3c5b330c9a68")
                    .build()
            )
        assertThat(body.remoteUserId()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            AttachmentCreateParams.builder()
                .model(AttachmentCreateParams.AttachmentRequest.builder().build())
                .remoteUserId("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(AttachmentCreateParams.AttachmentRequest.builder().build())
        assertThat(body.remoteUserId()).isEqualTo("string")
    }
}
