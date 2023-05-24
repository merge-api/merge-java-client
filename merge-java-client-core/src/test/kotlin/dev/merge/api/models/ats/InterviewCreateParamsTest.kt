package dev.merge.api.models.ats

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InterviewCreateParamsTest {

    @Test
    fun createInterviewCreateParams() {
        InterviewCreateParams.builder()
            .model(
                InterviewCreateParams.ScheduledInterviewRequest.builder()
                    .application("92e8a369-fffe-430d-b93a-f7e8a16563f1")
                    .jobInterviewStage("2f7adb59-3fe6-4b5b-aef6-563f72bd13dc")
                    .organizer("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                    .interviewers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .location("Embarcadero Center 2")
                    .startAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                    .endAt(OffsetDateTime.parse("2021-10-15T02:00:00Z"))
                    .status(
                        InterviewCreateParams.ScheduledInterviewRequest.ScheduledInterviewStatusEnum
                            .SCHEDULED
                    )
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
            .remoteUserId("string")
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            InterviewCreateParams.builder()
                .model(
                    InterviewCreateParams.ScheduledInterviewRequest.builder()
                        .application("92e8a369-fffe-430d-b93a-f7e8a16563f1")
                        .jobInterviewStage("2f7adb59-3fe6-4b5b-aef6-563f72bd13dc")
                        .organizer("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                        .interviewers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .location("Embarcadero Center 2")
                        .startAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                        .endAt(OffsetDateTime.parse("2021-10-15T02:00:00Z"))
                        .status(
                            InterviewCreateParams.ScheduledInterviewRequest
                                .ScheduledInterviewStatusEnum
                                .SCHEDULED
                        )
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
                .remoteUserId("string")
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
            InterviewCreateParams.builder()
                .model(InterviewCreateParams.ScheduledInterviewRequest.builder().build())
                .remoteUserId("string")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            InterviewCreateParams.builder()
                .model(
                    InterviewCreateParams.ScheduledInterviewRequest.builder()
                        .application("92e8a369-fffe-430d-b93a-f7e8a16563f1")
                        .jobInterviewStage("2f7adb59-3fe6-4b5b-aef6-563f72bd13dc")
                        .organizer("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                        .interviewers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .location("Embarcadero Center 2")
                        .startAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                        .endAt(OffsetDateTime.parse("2021-10-15T02:00:00Z"))
                        .status(
                            InterviewCreateParams.ScheduledInterviewRequest
                                .ScheduledInterviewStatusEnum
                                .SCHEDULED
                        )
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
                .remoteUserId("string")
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                InterviewCreateParams.ScheduledInterviewRequest.builder()
                    .application("92e8a369-fffe-430d-b93a-f7e8a16563f1")
                    .jobInterviewStage("2f7adb59-3fe6-4b5b-aef6-563f72bd13dc")
                    .organizer("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                    .interviewers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .location("Embarcadero Center 2")
                    .startAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                    .endAt(OffsetDateTime.parse("2021-10-15T02:00:00Z"))
                    .status(
                        InterviewCreateParams.ScheduledInterviewRequest.ScheduledInterviewStatusEnum
                            .SCHEDULED
                    )
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
        assertThat(body.remoteUserId()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            InterviewCreateParams.builder()
                .model(InterviewCreateParams.ScheduledInterviewRequest.builder().build())
                .remoteUserId("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(InterviewCreateParams.ScheduledInterviewRequest.builder().build())
        assertThat(body.remoteUserId()).isEqualTo("string")
    }
}
