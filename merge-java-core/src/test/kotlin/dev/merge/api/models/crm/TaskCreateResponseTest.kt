package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TaskCreateResponseTest {

    @Test
    fun createTaskCreateResponse() {
        val taskCreateResponse =
            TaskCreateResponse.builder()
                .model(
                    Task.builder()
                        .subject("Contact about Integration Strategy")
                        .content("Follow up to see whether they need integrations")
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .completedDate(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
                        .dueDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .status(Task.TaskStatusEnum.OPEN)
                        .remoteWasDeleted(true)
                        .id("03455bc6-6040-430a-848e-aafacbfdf4fg")
                        .remoteId("19202938")
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
                        .remoteFields(
                            listOf(
                                Task.RemoteField.builder()
                                    .remoteFieldClass(
                                        RemoteFieldClass.builder()
                                            .id("string")
                                            .displayName("string")
                                            .remoteKeyName("string")
                                            .description("string")
                                            .isCustom(true)
                                            .isRequired(true)
                                            .fieldType(RemoteFieldClass.FieldTypeEnum.STRING)
                                            .fieldFormat(RemoteFieldClass.FieldFormatEnum.STRING)
                                            .fieldChoices(listOf("string"))
                                            .itemSchema(
                                                RemoteFieldClass.ItemSchema.builder()
                                                    .itemType(JsonString.of("abc"))
                                                    .itemFormat(JsonString.of("abc"))
                                                    .itemChoices(listOf("string"))
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .value(JsonString.of("abc"))
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
        assertThat(taskCreateResponse).isNotNull
        assertThat(taskCreateResponse.model())
            .isEqualTo(
                Task.builder()
                    .subject("Contact about Integration Strategy")
                    .content("Follow up to see whether they need integrations")
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .completedDate(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
                    .dueDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .status(Task.TaskStatusEnum.OPEN)
                    .remoteWasDeleted(true)
                    .id("03455bc6-6040-430a-848e-aafacbfdf4fg")
                    .remoteId("19202938")
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
                    .remoteFields(
                        listOf(
                            Task.RemoteField.builder()
                                .remoteFieldClass(
                                    RemoteFieldClass.builder()
                                        .id("string")
                                        .displayName("string")
                                        .remoteKeyName("string")
                                        .description("string")
                                        .isCustom(true)
                                        .isRequired(true)
                                        .fieldType(RemoteFieldClass.FieldTypeEnum.STRING)
                                        .fieldFormat(RemoteFieldClass.FieldFormatEnum.STRING)
                                        .fieldChoices(listOf("string"))
                                        .itemSchema(
                                            RemoteFieldClass.ItemSchema.builder()
                                                .itemType(JsonString.of("abc"))
                                                .itemFormat(JsonString.of("abc"))
                                                .itemChoices(listOf("string"))
                                                .build()
                                        )
                                        .build()
                                )
                                .value(JsonString.of("abc"))
                                .build()
                        )
                    )
                    .build()
            )
        assertThat(taskCreateResponse.warnings())
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
        assertThat(taskCreateResponse.errors())
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
        assertThat(taskCreateResponse.logs().get())
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
