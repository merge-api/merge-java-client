package dev.merge.api.models.fileStorage

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileResponseTest {

    @Test
    fun createFileResponse() {
        val fileResponse =
            FileResponse.builder()
                .model(
                    File.builder()
                        .id("45ce474c-dhcj-43a6-754r-629f799f7d68")
                        .remoteId("12")
                        .name("omg_common_model_scope.docx")
                        .fileUrl("https://drive.com/1234")
                        .fileThumbnailUrl("https://drive.com/1234/thumbnail.png")
                        .size(123L)
                        .mimeType(".docx")
                        .description("This file is OP")
                        .folder("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .drive("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                        .remoteCreatedAt(OffsetDateTime.parse("2022-02-02T00:00:00Z"))
                        .remoteUpdatedAt(OffsetDateTime.parse("2022-02-03T00:00:00Z"))
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
                        .remoteData(listOf(JsonString.of("abc")))
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
        assertThat(fileResponse).isNotNull
        assertThat(fileResponse.model())
            .isEqualTo(
                File.builder()
                    .id("45ce474c-dhcj-43a6-754r-629f799f7d68")
                    .remoteId("12")
                    .name("omg_common_model_scope.docx")
                    .fileUrl("https://drive.com/1234")
                    .fileThumbnailUrl("https://drive.com/1234/thumbnail.png")
                    .size(123L)
                    .mimeType(".docx")
                    .description("This file is OP")
                    .folder("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .drive("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                    .remoteCreatedAt(OffsetDateTime.parse("2022-02-02T00:00:00Z"))
                    .remoteUpdatedAt(OffsetDateTime.parse("2022-02-03T00:00:00Z"))
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
                    .remoteData(listOf(JsonString.of("abc")))
                    .build()
            )
        assertThat(fileResponse.warnings())
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
        assertThat(fileResponse.errors())
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
        assertThat(fileResponse.logs().get())
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
