package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ScheduledInterviewResponseTest {

    @Test
    fun createScheduledInterviewResponse() {
        val scheduledInterviewResponse =
            ScheduledInterviewResponse.builder()
                .model(
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
                                    "organization_defined_targets" to
                                        mapOf("custom_key" to "custom_value"),
                                    "linked_account_defined_targets" to
                                        mapOf("custom_key" to "custom_value")
                                )
                            )
                        )
                        .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                        .remoteData(
                            listOf(
                                RemoteData.builder()
                                    .path("string")
                                    .data(JsonString.of("abc"))
                                    .build()
                            )
                        )
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
        assertThat(scheduledInterviewResponse).isNotNull
        assertThat(scheduledInterviewResponse.model())
            .isEqualTo(
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
                                "organization_defined_targets" to
                                    mapOf("custom_key" to "custom_value"),
                                "linked_account_defined_targets" to
                                    mapOf("custom_key" to "custom_value")
                            )
                        )
                    )
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .remoteData(
                        listOf(
                            RemoteData.builder().path("string").data(JsonString.of("abc")).build()
                        )
                    )
                    .build()
            )
        assertThat(scheduledInterviewResponse.warnings())
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
        assertThat(scheduledInterviewResponse.errors())
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
        assertThat(scheduledInterviewResponse.logs().get())
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
