package dev.merge.api.models.accounting

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AttachmentCreateParamsTest {

    @Test
    fun createAttachmentCreateParams() {
        AttachmentCreateParams.builder()
            .model(
                AttachmentCreateParams.AccountingAttachmentRequest.builder()
                    .fileName("invoice.png")
                    .fileUrl(
                        "https://merge-brand.s3.amazonaws.com/20210315/rect-logo-270x80%402x.png"
                    )
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
            AttachmentCreateParams.builder()
                .model(
                    AttachmentCreateParams.AccountingAttachmentRequest.builder()
                        .fileName("invoice.png")
                        .fileUrl(
                            "https://merge-brand.s3.amazonaws.com/20210315/rect-logo-270x80%402x.png"
                        )
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
            AttachmentCreateParams.builder()
                .model(AttachmentCreateParams.AccountingAttachmentRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            AttachmentCreateParams.builder()
                .model(
                    AttachmentCreateParams.AccountingAttachmentRequest.builder()
                        .fileName("invoice.png")
                        .fileUrl(
                            "https://merge-brand.s3.amazonaws.com/20210315/rect-logo-270x80%402x.png"
                        )
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
                AttachmentCreateParams.AccountingAttachmentRequest.builder()
                    .fileName("invoice.png")
                    .fileUrl(
                        "https://merge-brand.s3.amazonaws.com/20210315/rect-logo-270x80%402x.png"
                    )
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
            AttachmentCreateParams.builder()
                .model(AttachmentCreateParams.AccountingAttachmentRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(AttachmentCreateParams.AccountingAttachmentRequest.builder().build())
    }
}
