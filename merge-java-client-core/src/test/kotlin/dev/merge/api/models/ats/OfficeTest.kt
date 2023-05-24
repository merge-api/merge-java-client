package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OfficeTest {

    @Test
    fun createOffice() {
        val office =
            Office.builder()
                .id("9871b4a9-f5d2-4f3b-a66b-dfedbed42c46")
                .remoteId("876556788")
                .name("SF Office")
                .location("Embarcadero Center 2")
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
        assertThat(office).isNotNull
        assertThat(office.id()).contains("9871b4a9-f5d2-4f3b-a66b-dfedbed42c46")
        assertThat(office.remoteId()).contains("876556788")
        assertThat(office.name()).contains("SF Office")
        assertThat(office.location()).contains("Embarcadero Center 2")
        assertThat(office.remoteWasDeleted()).contains(true)
        assertThat(office._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(office.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(office.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
