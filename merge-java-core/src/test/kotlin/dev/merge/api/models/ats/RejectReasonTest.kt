package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RejectReasonTest {

    @Test
    fun createRejectReason() {
        val rejectReason =
            RejectReason.builder()
                .id("8be99a4a-f8d4-4339-bf1e-30eac970e217")
                .remoteId("876556788")
                .name("Not passionate enough about APIs.")
                .remoteWasDeleted(true)
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
        assertThat(rejectReason).isNotNull
        assertThat(rejectReason.id()).contains("8be99a4a-f8d4-4339-bf1e-30eac970e217")
        assertThat(rejectReason.remoteId()).contains("876556788")
        assertThat(rejectReason.name()).contains("Not passionate enough about APIs.")
        assertThat(rejectReason.remoteWasDeleted()).contains(true)
        assertThat(rejectReason._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(rejectReason.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(rejectReason.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
