package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OpportunityCreateParamsTest {

    @Test
    fun createOpportunityCreateParams() {
        OpportunityCreateParams.builder()
            .model(
                OpportunityCreateParams.OpportunityRequest.builder()
                    .name("Needs Integrations")
                    .description("Needs a Unified API for Integrations!")
                    .amount(123L)
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .stage("1968cbc6-6040-430a-848e-aafacbadf4ad")
                    .status(OpportunityCreateParams.OpportunityRequest.OpportunityStatusEnum.OPEN)
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .closeDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                            OpportunityCreateParams.OpportunityRequest.RemoteFieldRequest.builder()
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
            OpportunityCreateParams.builder()
                .model(
                    OpportunityCreateParams.OpportunityRequest.builder()
                        .name("Needs Integrations")
                        .description("Needs a Unified API for Integrations!")
                        .amount(123L)
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .stage("1968cbc6-6040-430a-848e-aafacbadf4ad")
                        .status(
                            OpportunityCreateParams.OpportunityRequest.OpportunityStatusEnum.OPEN
                        )
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .closeDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                                OpportunityCreateParams.OpportunityRequest.RemoteFieldRequest
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
            OpportunityCreateParams.builder()
                .model(OpportunityCreateParams.OpportunityRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            OpportunityCreateParams.builder()
                .model(
                    OpportunityCreateParams.OpportunityRequest.builder()
                        .name("Needs Integrations")
                        .description("Needs a Unified API for Integrations!")
                        .amount(123L)
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .stage("1968cbc6-6040-430a-848e-aafacbadf4ad")
                        .status(
                            OpportunityCreateParams.OpportunityRequest.OpportunityStatusEnum.OPEN
                        )
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .closeDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                                OpportunityCreateParams.OpportunityRequest.RemoteFieldRequest
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
                OpportunityCreateParams.OpportunityRequest.builder()
                    .name("Needs Integrations")
                    .description("Needs a Unified API for Integrations!")
                    .amount(123L)
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .stage("1968cbc6-6040-430a-848e-aafacbadf4ad")
                    .status(OpportunityCreateParams.OpportunityRequest.OpportunityStatusEnum.OPEN)
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .closeDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                            OpportunityCreateParams.OpportunityRequest.RemoteFieldRequest.builder()
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
            OpportunityCreateParams.builder()
                .model(OpportunityCreateParams.OpportunityRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(OpportunityCreateParams.OpportunityRequest.builder().build())
    }
}
