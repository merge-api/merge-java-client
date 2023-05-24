package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NoteCreateParamsTest {

    @Test
    fun createNoteCreateParams() {
        NoteCreateParams.builder()
            .model(
                NoteCreateParams.NoteRequest.builder()
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .content("Merge is hiring!")
                    .contact("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .opportunity("754a244e-dd67-4731-a8d3-9bff9dc10465")
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
                    .remoteFields(
                        listOf(
                            NoteCreateParams.NoteRequest.RemoteFieldRequest.builder()
                                .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                .value(JsonString.of("abc"))
                                .build()
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
            NoteCreateParams.builder()
                .model(
                    NoteCreateParams.NoteRequest.builder()
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .content("Merge is hiring!")
                        .contact("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .opportunity("754a244e-dd67-4731-a8d3-9bff9dc10465")
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
                        .remoteFields(
                            listOf(
                                NoteCreateParams.NoteRequest.RemoteFieldRequest.builder()
                                    .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                    .value(JsonString.of("abc"))
                                    .build()
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
            NoteCreateParams.builder().model(NoteCreateParams.NoteRequest.builder().build()).build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            NoteCreateParams.builder()
                .model(
                    NoteCreateParams.NoteRequest.builder()
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .content("Merge is hiring!")
                        .contact("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .opportunity("754a244e-dd67-4731-a8d3-9bff9dc10465")
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
                        .remoteFields(
                            listOf(
                                NoteCreateParams.NoteRequest.RemoteFieldRequest.builder()
                                    .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                    .value(JsonString.of("abc"))
                                    .build()
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
                NoteCreateParams.NoteRequest.builder()
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .content("Merge is hiring!")
                    .contact("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .opportunity("754a244e-dd67-4731-a8d3-9bff9dc10465")
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
                    .remoteFields(
                        listOf(
                            NoteCreateParams.NoteRequest.RemoteFieldRequest.builder()
                                .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                .value(JsonString.of("abc"))
                                .build()
                        )
                    )
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            NoteCreateParams.builder().model(NoteCreateParams.NoteRequest.builder().build()).build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(NoteCreateParams.NoteRequest.builder().build())
    }
}
