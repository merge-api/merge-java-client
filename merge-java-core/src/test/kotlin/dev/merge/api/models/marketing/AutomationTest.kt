package dev.merge.api.models.marketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AutomationTest {

    @Test
    fun createAutomation() {
        val automation =
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
                            "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                            "linked_account_defined_targets" to
                                mapOf("custom_key" to "custom_value")
                        )
                    )
                )
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .remoteData(listOf(JsonString.of("abc")))
                .build()
        assertThat(automation).isNotNull
        assertThat(automation.name()).contains("Welcome Email")
        assertThat(automation.triggerType()).contains(Automation.TriggerTypeEnum.TRIGGER_EVENT)
        assertThat(automation.startDate()).contains(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
        assertThat(automation.endDate()).contains(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
        assertThat(automation.description())
            .contains("This sends a welcome email to new customers.")
        assertThat(automation.status()).contains("Published")
        assertThat(automation._automationTrigger())
            .isEqualTo(
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
        assertThat(automation.actions()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(automation.remoteWasDeleted()).contains(true)
        assertThat(automation.id()).contains("45ce474c-dhcj-43a6-754r-629f799f7d68")
        assertThat(automation.remoteId()).contains("12")
        assertThat(automation._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(automation.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(automation.remoteData().get()).containsExactly(JsonString.of("abc"))
    }
}
