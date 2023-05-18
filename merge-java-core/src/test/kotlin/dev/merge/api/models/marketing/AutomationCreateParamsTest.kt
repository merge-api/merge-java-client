package dev.merge.api.models.marketing

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AutomationCreateParamsTest {

    @Test
    fun createAutomationCreateParams() {
        AutomationCreateParams.builder()
            .model(
                AutomationCreateParams.AutomationRequest.builder()
                    .name("Welcome Email")
                    .triggerType(
                        AutomationCreateParams.AutomationRequest.TriggerTypeEnum.TRIGGER_EVENT
                    )
                    .startDate(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                    .endDate(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                    .description("This sends a welcome email to new customers.")
                    .status("Published")
                    .automationTrigger(
                        JsonValue.from(
                            mapOf(
                                "recurrence_schedule" to
                                    mapOf(
                                        "days" to listOf("Sunday"),
                                        "hours" to mapOf("type" to "send_asap")
                                    ),
                                "trigger_settings" to mapOf("trigger_event" to "NEW_CUSTOMER")
                            )
                        )
                    )
                    .actions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
            AutomationCreateParams.builder()
                .model(
                    AutomationCreateParams.AutomationRequest.builder()
                        .name("Welcome Email")
                        .triggerType(
                            AutomationCreateParams.AutomationRequest.TriggerTypeEnum.TRIGGER_EVENT
                        )
                        .startDate(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                        .endDate(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                        .description("This sends a welcome email to new customers.")
                        .status("Published")
                        .automationTrigger(
                            JsonValue.from(
                                mapOf(
                                    "recurrence_schedule" to
                                        mapOf(
                                            "days" to listOf("Sunday"),
                                            "hours" to mapOf("type" to "send_asap")
                                        ),
                                    "trigger_settings" to mapOf("trigger_event" to "NEW_CUSTOMER")
                                )
                            )
                        )
                        .actions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
            AutomationCreateParams.builder()
                .model(
                    AutomationCreateParams.AutomationRequest.builder()
                        .actions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .build()
                )
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            AutomationCreateParams.builder()
                .model(
                    AutomationCreateParams.AutomationRequest.builder()
                        .name("Welcome Email")
                        .triggerType(
                            AutomationCreateParams.AutomationRequest.TriggerTypeEnum.TRIGGER_EVENT
                        )
                        .startDate(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                        .endDate(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                        .description("This sends a welcome email to new customers.")
                        .status("Published")
                        .automationTrigger(
                            JsonValue.from(
                                mapOf(
                                    "recurrence_schedule" to
                                        mapOf(
                                            "days" to listOf("Sunday"),
                                            "hours" to mapOf("type" to "send_asap")
                                        ),
                                    "trigger_settings" to mapOf("trigger_event" to "NEW_CUSTOMER")
                                )
                            )
                        )
                        .actions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
                AutomationCreateParams.AutomationRequest.builder()
                    .name("Welcome Email")
                    .triggerType(
                        AutomationCreateParams.AutomationRequest.TriggerTypeEnum.TRIGGER_EVENT
                    )
                    .startDate(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                    .endDate(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                    .description("This sends a welcome email to new customers.")
                    .status("Published")
                    .automationTrigger(
                        JsonValue.from(
                            mapOf(
                                "recurrence_schedule" to
                                    mapOf(
                                        "days" to listOf("Sunday"),
                                        "hours" to mapOf("type" to "send_asap")
                                    ),
                                "trigger_settings" to mapOf("trigger_event" to "NEW_CUSTOMER")
                            )
                        )
                    )
                    .actions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
            AutomationCreateParams.builder()
                .model(
                    AutomationCreateParams.AutomationRequest.builder()
                        .actions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .build()
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                AutomationCreateParams.AutomationRequest.builder()
                    .actions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .build()
            )
    }
}
