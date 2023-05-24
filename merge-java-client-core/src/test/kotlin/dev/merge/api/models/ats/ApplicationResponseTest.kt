package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationResponseTest {

    @Test
    fun createApplicationResponse() {
        val applicationResponse =
            ApplicationResponse.builder()
                .model(
                    Application.builder()
                        .id("92e8a369-fffe-430d-b93a-f7e8a16563f1")
                        .remoteId("98796")
                        .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                        .job("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                        .appliedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                        .rejectedAt(OffsetDateTime.parse("2021-11-15T00:00:00Z"))
                        .source("Campus recruiting event")
                        .creditedTo("58166795-8d68-4b30-9bfb-bfd402479484")
                        .currentStage("d578dfdc-7b0a-4ab6-a2b0-4b40f20eb9ea")
                        .rejectReason("59b25f2b-da02-40f5-9656-9fa0db555784")
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
        assertThat(applicationResponse).isNotNull
        assertThat(applicationResponse.model())
            .isEqualTo(
                Application.builder()
                    .id("92e8a369-fffe-430d-b93a-f7e8a16563f1")
                    .remoteId("98796")
                    .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                    .job("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                    .appliedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                    .rejectedAt(OffsetDateTime.parse("2021-11-15T00:00:00Z"))
                    .source("Campus recruiting event")
                    .creditedTo("58166795-8d68-4b30-9bfb-bfd402479484")
                    .currentStage("d578dfdc-7b0a-4ab6-a2b0-4b40f20eb9ea")
                    .rejectReason("59b25f2b-da02-40f5-9656-9fa0db555784")
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
        assertThat(applicationResponse.warnings())
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
        assertThat(applicationResponse.errors())
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
        assertThat(applicationResponse.logs().get())
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
