package dev.merge.api.models.crm

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssociationTypeResponseTest {

    @Test
    fun createAssociationTypeResponse() {
        val associationTypeResponse =
            AssociationTypeResponse.builder()
                .model(
                    AssociationType.builder()
                        .sourceObjectClass(
                            JsonValue.from(
                                mapOf(
                                    "id" to "ff1ff4cb-a66b-47dc-8e2a-50388049e602",
                                    "origin_type" to "CUSTOM_OBJECT"
                                )
                            )
                        )
                        .targetObjectClasses(
                            listOf(
                                AssociationType.AssociationSubType.builder()
                                    .id("string")
                                    .originType("string")
                                    .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .build()
                            )
                        )
                        .remoteKeyName("order_to_opportunity")
                        .displayName("Order to Opportunity")
                        .cardinality(AssociationType.CardinalityEnum.ONE_TO_ONE)
                        .isRequired(true)
                        .id("5bb73c32-3c6c-4757-ab7d-7d3540a1be31")
                        .remoteId("93")
                        .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
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
        assertThat(associationTypeResponse).isNotNull
        assertThat(associationTypeResponse.model())
            .isEqualTo(
                AssociationType.builder()
                    .sourceObjectClass(
                        JsonValue.from(
                            mapOf(
                                "id" to "ff1ff4cb-a66b-47dc-8e2a-50388049e602",
                                "origin_type" to "CUSTOM_OBJECT"
                            )
                        )
                    )
                    .targetObjectClasses(
                        listOf(
                            AssociationType.AssociationSubType.builder()
                                .id("string")
                                .originType("string")
                                .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                    )
                    .remoteKeyName("order_to_opportunity")
                    .displayName("Order to Opportunity")
                    .cardinality(AssociationType.CardinalityEnum.ONE_TO_ONE)
                    .isRequired(true)
                    .id("5bb73c32-3c6c-4757-ab7d-7d3540a1be31")
                    .remoteId("93")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(associationTypeResponse.warnings())
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
        assertThat(associationTypeResponse.errors())
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
        assertThat(associationTypeResponse.logs().get())
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
