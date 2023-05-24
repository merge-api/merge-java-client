package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ScheduledInterviewTest {

    @Test
    fun createScheduledInterview() {
        val scheduledInterview =
            ScheduledInterview.builder()
                .id("b8faf072-98b9-4445-8a9a-6b4950efca19")
                .remoteId("3")
                .application("92e8a369-fffe-430d-b93a-f7e8a16563f1")
                .jobInterviewStage("2f7adb59-3fe6-4b5b-aef6-563f72bd13dc")
                .organizer("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                .interviewers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .location("Embarcadero Center 2")
                .startAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                .endAt(OffsetDateTime.parse("2021-10-15T02:00:00Z"))
                .remoteCreatedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                .remoteUpdatedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                .status(ScheduledInterview.ScheduledInterviewStatusEnum.SCHEDULED)
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
        assertThat(scheduledInterview).isNotNull
        assertThat(scheduledInterview.id()).contains("b8faf072-98b9-4445-8a9a-6b4950efca19")
        assertThat(scheduledInterview.remoteId()).contains("3")
        assertThat(scheduledInterview.application())
            .contains("92e8a369-fffe-430d-b93a-f7e8a16563f1")
        assertThat(scheduledInterview.jobInterviewStage())
            .contains("2f7adb59-3fe6-4b5b-aef6-563f72bd13dc")
        assertThat(scheduledInterview.organizer()).contains("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
        assertThat(scheduledInterview.interviewers().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(scheduledInterview.location()).contains("Embarcadero Center 2")
        assertThat(scheduledInterview.startAt())
            .contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(scheduledInterview.endAt())
            .contains(OffsetDateTime.parse("2021-10-15T02:00:00Z"))
        assertThat(scheduledInterview.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(scheduledInterview.remoteUpdatedAt())
            .contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(scheduledInterview.status())
            .contains(ScheduledInterview.ScheduledInterviewStatusEnum.SCHEDULED)
        assertThat(scheduledInterview.remoteWasDeleted()).contains(true)
        assertThat(scheduledInterview._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(scheduledInterview.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(scheduledInterview.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
