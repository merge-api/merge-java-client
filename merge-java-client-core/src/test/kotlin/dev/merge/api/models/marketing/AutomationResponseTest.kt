package dev.merge.api.models.marketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AutomationResponseTest {

    @Test
    fun createAutomationResponse() {
        val automationResponse =
            AutomationResponse.builder()
                .model(
                    Automation.builder()
                        .name("Welcome Email")
                        .triggerType(Automation.TriggerTypeEnum.TRIGGER_EVENT)
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
                        .remoteWasDeleted(true)
                        .id("45ce474c-dhcj-43a6-754r-629f799f7d68")
                        .remoteId("12")
                        .fieldMappings(
                            JsonValue.from(
                                mapOf(
                                    "organization_defined_targets" to
                                        mapOf("custom_key" to "custom_value"),
                                    "linked_account_defined_targets" to
                                        mapOf("custom_key" to "custom_value")
                                )
                            )
                        )
                        .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                        .remoteData(listOf(JsonString.of("abc")))
                        .build()
                )
                .warnings(
                    listOf(
                        ValidationWarning.builder()
                            .source(
                                ValidationWarning.ValidationProblemSource.builder()
                                    .pointer("string")
                                    .build()
                            )
                            .title("Unrecognized Field")
                            .detail("An unrecognized field, age, was passed in with request data.")
                            .problemType("UNRECOGNIZED_FIELD")
                            .build()
                    )
                )
                .errors(
                    listOf(
                        ValidationError.builder()
                            .source(
                                ValidationError.ValidationProblemSource.builder()
                                    .pointer("string")
                                    .build()
                            )
                            .title("Missing Required Field")
                            .detail("custom_fields is a required field on model.")
                            .problemType("MISSING_REQUIRED_FIELD")
                            .build()
                    )
                )
                .logs(
                    listOf(
                        DebugLog.builder()
                            .logId("99433219-8017-4acd-bb3c-ceb23d663832")
                            .dashboardView(
                                "https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832"
                            )
                            .logSummary(
                                DebugLog.DebugModelLogSummary.builder()
                                    .url("https://harvest.greenhouse.io/v1/candidates/")
                                    .method("POST")
                                    .statusCode(123L)
                                    .build()
                            )
                            .build()
                    )
                )
                .build()
        assertThat(automationResponse).isNotNull
        assertThat(automationResponse.model())
            .isEqualTo(
                Automation.builder()
                    .name("Welcome Email")
                    .triggerType(Automation.TriggerTypeEnum.TRIGGER_EVENT)
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
                    .remoteWasDeleted(true)
                    .id("45ce474c-dhcj-43a6-754r-629f799f7d68")
                    .remoteId("12")
                    .fieldMappings(
                        JsonValue.from(
                            mapOf(
                                "organization_defined_targets" to
                                    mapOf("custom_key" to "custom_value"),
                                "linked_account_defined_targets" to
                                    mapOf("custom_key" to "custom_value")
                            )
                        )
                    )
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .remoteData(listOf(JsonString.of("abc")))
                    .build()
            )
        assertThat(automationResponse.warnings())
            .containsExactly(
                ValidationWarning.builder()
                    .source(
                        ValidationWarning.ValidationProblemSource.builder()
                            .pointer("string")
                            .build()
                    )
                    .title("Unrecognized Field")
                    .detail("An unrecognized field, age, was passed in with request data.")
                    .problemType("UNRECOGNIZED_FIELD")
                    .build()
            )
        assertThat(automationResponse.errors())
            .containsExactly(
                ValidationError.builder()
                    .source(
                        ValidationError.ValidationProblemSource.builder().pointer("string").build()
                    )
                    .title("Missing Required Field")
                    .detail("custom_fields is a required field on model.")
                    .problemType("MISSING_REQUIRED_FIELD")
                    .build()
            )
        assertThat(automationResponse.logs().get())
            .containsExactly(
                DebugLog.builder()
                    .logId("99433219-8017-4acd-bb3c-ceb23d663832")
                    .dashboardView(
                        "https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832"
                    )
                    .logSummary(
                        DebugLog.DebugModelLogSummary.builder()
                            .url("https://harvest.greenhouse.io/v1/candidates/")
                            .method("POST")
                            .statusCode(123L)
                            .build()
                    )
                    .build()
            )
    }
}
