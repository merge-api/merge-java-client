package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountUpdateParamsTest {

    @Test
    fun createAccountUpdateParams() {
        AccountUpdateParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .model(
                AccountUpdateParams.PatchedAccountRequest.builder()
                    .owner("0258cbc6-6020-430a-848e-aafacbadf4ae")
                    .name("Merge API")
                    .description("One API for all integrations")
                    .industry("API's")
                    .website("https://merge.dev/")
                    .numberOfEmployees(123L)
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                            AccountUpdateParams.PatchedAccountRequest.RemoteFieldRequest.builder()
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
            AccountUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    AccountUpdateParams.PatchedAccountRequest.builder()
                        .owner("0258cbc6-6020-430a-848e-aafacbadf4ae")
                        .name("Merge API")
                        .description("One API for all integrations")
                        .industry("API's")
                        .website("https://merge.dev/")
                        .numberOfEmployees(123L)
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                                AccountUpdateParams.PatchedAccountRequest.RemoteFieldRequest
                                    .builder()
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
            AccountUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(AccountUpdateParams.PatchedAccountRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            AccountUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    AccountUpdateParams.PatchedAccountRequest.builder()
                        .owner("0258cbc6-6020-430a-848e-aafacbadf4ae")
                        .name("Merge API")
                        .description("One API for all integrations")
                        .industry("API's")
                        .website("https://merge.dev/")
                        .numberOfEmployees(123L)
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                                AccountUpdateParams.PatchedAccountRequest.RemoteFieldRequest
                                    .builder()
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
                AccountUpdateParams.PatchedAccountRequest.builder()
                    .owner("0258cbc6-6020-430a-848e-aafacbadf4ae")
                    .name("Merge API")
                    .description("One API for all integrations")
                    .industry("API's")
                    .website("https://merge.dev/")
                    .numberOfEmployees(123L)
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                            AccountUpdateParams.PatchedAccountRequest.RemoteFieldRequest.builder()
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
            AccountUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(AccountUpdateParams.PatchedAccountRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(AccountUpdateParams.PatchedAccountRequest.builder().build())
    }

    @Test
    fun getPathParam() {
        val params =
            AccountUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(AccountUpdateParams.PatchedAccountRequest.builder().build())
                .build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
