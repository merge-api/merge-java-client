package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PayGroupTest {

    @Test
    fun createPayGroup() {
        val payGroup =
            PayGroup.builder()
                .id("fd1e0fb5-8f92-4ec9-9f32-179cf732867d")
                .remoteId("800293")
                .payGroupName("contractor")
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
        assertThat(payGroup).isNotNull
        assertThat(payGroup.id()).contains("fd1e0fb5-8f92-4ec9-9f32-179cf732867d")
        assertThat(payGroup.remoteId()).contains("800293")
        assertThat(payGroup.payGroupName()).contains("contractor")
        assertThat(payGroup.remoteWasDeleted()).contains(true)
        assertThat(payGroup._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(payGroup.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(payGroup.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
