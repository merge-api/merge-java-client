package dev.merge.api.models.ticketing

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CommentCreateParamsTest {

    @Test
    fun createCommentCreateParams() {
        CommentCreateParams.builder()
            .model(
                CommentCreateParams.CommentRequest.builder()
                    .user("17a54124-287f-494d-965e-3c5b330c9a68")
                    .contact("dde3fb16-b8eb-483d-81c4-b78100816f15")
                    .body("When will these integrations be done? You all should use Merge.")
                    .htmlBody(
                        "When will these integrations be done? You all should use <b>Merge<b>."
                    )
                    .ticket("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
                    .isPrivate(true)
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
            CommentCreateParams.builder()
                .model(
                    CommentCreateParams.CommentRequest.builder()
                        .user("17a54124-287f-494d-965e-3c5b330c9a68")
                        .contact("dde3fb16-b8eb-483d-81c4-b78100816f15")
                        .body("When will these integrations be done? You all should use Merge.")
                        .htmlBody(
                            "When will these integrations be done? You all should use <b>Merge<b>."
                        )
                        .ticket("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
                        .isPrivate(true)
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
            CommentCreateParams.builder()
                .model(CommentCreateParams.CommentRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            CommentCreateParams.builder()
                .model(
                    CommentCreateParams.CommentRequest.builder()
                        .user("17a54124-287f-494d-965e-3c5b330c9a68")
                        .contact("dde3fb16-b8eb-483d-81c4-b78100816f15")
                        .body("When will these integrations be done? You all should use Merge.")
                        .htmlBody(
                            "When will these integrations be done? You all should use <b>Merge<b>."
                        )
                        .ticket("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
                        .isPrivate(true)
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
                CommentCreateParams.CommentRequest.builder()
                    .user("17a54124-287f-494d-965e-3c5b330c9a68")
                    .contact("dde3fb16-b8eb-483d-81c4-b78100816f15")
                    .body("When will these integrations be done? You all should use Merge.")
                    .htmlBody(
                        "When will these integrations be done? You all should use <b>Merge<b>."
                    )
                    .ticket("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
                    .isPrivate(true)
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
            CommentCreateParams.builder()
                .model(CommentCreateParams.CommentRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(CommentCreateParams.CommentRequest.builder().build())
    }
}
