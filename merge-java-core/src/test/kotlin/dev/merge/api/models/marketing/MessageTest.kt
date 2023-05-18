package dev.merge.api.models.marketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageTest {

    @Test
    fun createMessage() {
        val message =
            Message.builder()
                .fromName("Merge")
                .sendDate(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                .body("Here's what's new in December!")
                .remoteWasDeleted(true)
                .id("3734cbc6-6040-430a-475r-aafacbadr6wq")
                .remoteId("20")
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
        assertThat(message).isNotNull
        assertThat(message.fromName()).contains("Merge")
        assertThat(message.sendDate()).contains(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
        assertThat(message.body()).contains("Here's what's new in December!")
        assertThat(message.remoteWasDeleted()).contains(true)
        assertThat(message.id()).contains("3734cbc6-6040-430a-475r-aafacbadr6wq")
        assertThat(message.remoteId()).contains("20")
        assertThat(message._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(message.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(message.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
