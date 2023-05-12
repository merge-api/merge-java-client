package dev.merge.api.models.crm

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EngagementCreateParamsTest {

    @Test
    fun createEngagementCreateParams() {
        EngagementCreateParams.builder()
            .model(
                EngagementCreateParams.EngagementRequest.builder()
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .content("Call for negotiation")
                    .subject("Call from customer")
                    .direction(EngagementCreateParams.EngagementRequest.DirectionEnum.INBOUND)
                    .engagementType("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .startTime(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .endTime(OffsetDateTime.parse("2022-02-10T00:05:00Z"))
                    .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .contacts(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
            EngagementCreateParams.builder()
                .model(
                    EngagementCreateParams.EngagementRequest.builder()
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .content("Call for negotiation")
                        .subject("Call from customer")
                        .direction(EngagementCreateParams.EngagementRequest.DirectionEnum.INBOUND)
                        .engagementType("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .startTime(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .endTime(OffsetDateTime.parse("2022-02-10T00:05:00Z"))
                        .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .contacts(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
            EngagementCreateParams.builder()
                .model(EngagementCreateParams.EngagementRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            EngagementCreateParams.builder()
                .model(
                    EngagementCreateParams.EngagementRequest.builder()
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .content("Call for negotiation")
                        .subject("Call from customer")
                        .direction(EngagementCreateParams.EngagementRequest.DirectionEnum.INBOUND)
                        .engagementType("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .startTime(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .endTime(OffsetDateTime.parse("2022-02-10T00:05:00Z"))
                        .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .contacts(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
                EngagementCreateParams.EngagementRequest.builder()
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .content("Call for negotiation")
                    .subject("Call from customer")
                    .direction(EngagementCreateParams.EngagementRequest.DirectionEnum.INBOUND)
                    .engagementType("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .startTime(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .endTime(OffsetDateTime.parse("2022-02-10T00:05:00Z"))
                    .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .contacts(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
            EngagementCreateParams.builder()
                .model(EngagementCreateParams.EngagementRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(EngagementCreateParams.EngagementRequest.builder().build())
    }
}
