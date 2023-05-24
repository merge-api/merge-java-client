package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TimeOffResponseTest {

    @Test
    fun createTimeOffResponse() {
        val timeOffResponse =
            TimeOffResponse.builder()
                .model(
                    TimeOff.builder()
                        .id("91b2b905-e866-40c8-8be2-efe53827a0aa")
                        .remoteId("19202938")
                        .employee("d2f972d0-2526-434b-9409-4c3b468e08f0")
                        .approver("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                        .status(TimeOff.TimeOffStatusEnum.REQUESTED)
                        .employeeNote("Moving into the new apartment Kendall Roy gave me!")
                        .units(TimeOff.UnitsEnum.HOURS)
                        .amount(42.23)
                        .requestType(TimeOff.RequestTypeEnum.VACATION)
                        .startTime(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
                        .endTime(OffsetDateTime.parse("2020-11-17T00:00:00Z"))
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
        assertThat(timeOffResponse).isNotNull
        assertThat(timeOffResponse.model())
            .isEqualTo(
                TimeOff.builder()
                    .id("91b2b905-e866-40c8-8be2-efe53827a0aa")
                    .remoteId("19202938")
                    .employee("d2f972d0-2526-434b-9409-4c3b468e08f0")
                    .approver("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                    .status(TimeOff.TimeOffStatusEnum.REQUESTED)
                    .employeeNote("Moving into the new apartment Kendall Roy gave me!")
                    .units(TimeOff.UnitsEnum.HOURS)
                    .amount(42.23)
                    .requestType(TimeOff.RequestTypeEnum.VACATION)
                    .startTime(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
                    .endTime(OffsetDateTime.parse("2020-11-17T00:00:00Z"))
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
        assertThat(timeOffResponse.warnings())
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
        assertThat(timeOffResponse.errors())
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
        assertThat(timeOffResponse.logs().get())
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
