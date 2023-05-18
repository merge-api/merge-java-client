package dev.merge.api.models.marketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EventTest {

    @Test
    fun createEvent() {
        val event =
            Event.builder()
                .name("New Customer Webinar")
                .description("Webinar for new customers to learn more about the product.")
                .remoteCreatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                .emails(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .messages(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .startTime(OffsetDateTime.parse("2022-01-03T00:00:00Z"))
                .endTime(OffsetDateTime.parse("2022-01-03T01:00:00Z"))
                .remoteWasDeleted(true)
                .id("5648cbc6-6040-430a-475r-aafacbadf8ry")
                .remoteId("10")
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
                .remoteData(
                    listOf(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
                )
                .build()
        assertThat(event).isNotNull
        assertThat(event.name()).contains("New Customer Webinar")
        assertThat(event.description())
            .contains("Webinar for new customers to learn more about the product.")
        assertThat(event.remoteCreatedAt()).contains(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
        assertThat(event.emails()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(event.messages()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(event.startTime()).contains(OffsetDateTime.parse("2022-01-03T00:00:00Z"))
        assertThat(event.endTime()).contains(OffsetDateTime.parse("2022-01-03T01:00:00Z"))
        assertThat(event.remoteWasDeleted()).contains(true)
        assertThat(event.id()).contains("5648cbc6-6040-430a-475r-aafacbadf8ry")
        assertThat(event.remoteId()).contains("10")
        assertThat(event._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(event.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(event.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
