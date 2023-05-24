package dev.merge.api.models.marketing

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ActionCreateParamsTest {

    @Test
    fun createActionCreateParams() {
        ActionCreateParams.builder()
            .model(
                ActionCreateParams.ActionRequest.builder()
                    .name("Welcome Email")
                    .emails(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .messages(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .type(ActionCreateParams.ActionRequest.TypeEnum.EMAIL)
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
            ActionCreateParams.builder()
                .model(
                    ActionCreateParams.ActionRequest.builder()
                        .name("Welcome Email")
                        .emails(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .messages(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .type(ActionCreateParams.ActionRequest.TypeEnum.EMAIL)
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
            ActionCreateParams.builder()
                .model(
                    ActionCreateParams.ActionRequest.builder()
                        .emails(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .messages(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .build()
                )
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            ActionCreateParams.builder()
                .model(
                    ActionCreateParams.ActionRequest.builder()
                        .name("Welcome Email")
                        .emails(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .messages(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .type(ActionCreateParams.ActionRequest.TypeEnum.EMAIL)
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
                ActionCreateParams.ActionRequest.builder()
                    .name("Welcome Email")
                    .emails(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .messages(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .type(ActionCreateParams.ActionRequest.TypeEnum.EMAIL)
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
            ActionCreateParams.builder()
                .model(
                    ActionCreateParams.ActionRequest.builder()
                        .emails(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .messages(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .build()
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                ActionCreateParams.ActionRequest.builder()
                    .emails(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .messages(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .build()
            )
    }
}
