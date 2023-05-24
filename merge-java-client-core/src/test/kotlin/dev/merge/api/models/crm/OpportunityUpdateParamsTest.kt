package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OpportunityUpdateParamsTest {

    @Test
    fun createOpportunityUpdateParams() {
        OpportunityUpdateParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .model(
                OpportunityUpdateParams.PatchedOpportunityRequest.builder()
                    .name("Needs Integrations")
                    .description("Needs a Unified API for Integrations!")
                    .amount(123L)
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .stage("1968cbc6-6040-430a-848e-aafacbadf4ad")
                    .status(
                        OpportunityUpdateParams.PatchedOpportunityRequest.OpportunityStatusEnum.OPEN
                    )
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
                            OpportunityUpdateParams.PatchedOpportunityRequest.RemoteFieldRequest
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
    }

    @Test
    fun getQueryParams() {
        val params =
            OpportunityUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    OpportunityUpdateParams.PatchedOpportunityRequest.builder()
                        .name("Needs Integrations")
                        .description("Needs a Unified API for Integrations!")
                        .amount(123L)
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .stage("1968cbc6-6040-430a-848e-aafacbadf4ad")
                        .status(
                            OpportunityUpdateParams.PatchedOpportunityRequest.OpportunityStatusEnum
                                .OPEN
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
                                OpportunityUpdateParams.PatchedOpportunityRequest.RemoteFieldRequest
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
            OpportunityUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(OpportunityUpdateParams.PatchedOpportunityRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            OpportunityUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    OpportunityUpdateParams.PatchedOpportunityRequest.builder()
                        .name("Needs Integrations")
                        .description("Needs a Unified API for Integrations!")
                        .amount(123L)
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .stage("1968cbc6-6040-430a-848e-aafacbadf4ad")
                        .status(
                            OpportunityUpdateParams.PatchedOpportunityRequest.OpportunityStatusEnum
                                .OPEN
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
                                OpportunityUpdateParams.PatchedOpportunityRequest.RemoteFieldRequest
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
                OpportunityUpdateParams.PatchedOpportunityRequest.builder()
                    .name("Needs Integrations")
                    .description("Needs a Unified API for Integrations!")
                    .amount(123L)
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .stage("1968cbc6-6040-430a-848e-aafacbadf4ad")
                    .status(
                        OpportunityUpdateParams.PatchedOpportunityRequest.OpportunityStatusEnum.OPEN
                    )
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
                            OpportunityUpdateParams.PatchedOpportunityRequest.RemoteFieldRequest
                                .builder()
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
            OpportunityUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(OpportunityUpdateParams.PatchedOpportunityRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(OpportunityUpdateParams.PatchedOpportunityRequest.builder().build())
    }

    @Test
    fun getPathParam() {
        val params =
            OpportunityUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(OpportunityUpdateParams.PatchedOpportunityRequest.builder().build())
                .build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
