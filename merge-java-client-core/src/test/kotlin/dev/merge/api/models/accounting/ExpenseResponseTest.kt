package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpenseResponseTest {

    @Test
    fun createExpenseResponse() {
        val expenseResponse =
            ExpenseResponse.builder()
                .model(
                    Expense.builder()
                        .transactionDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .remoteCreatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                        .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                        .contact("3d263469-51a1-4766-9205-f6c997826be1")
                        .totalAmount(42.23)
                        .currency(Expense.CurrencyEnum.XUA)
                        .exchangeRate("2.9")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                        .memo("New employee supplies")
                        .lines(
                            listOf(
                                Expense.ExpenseLine.builder()
                                    .remoteId("121222")
                                    .item("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                    .netAmount(42.23)
                                    .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                    .trackingCategories(
                                        listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                    )
                                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                    .account("2a56344a-a491-11ec-b909-0242ac120002")
                                    .contact("c640b80b-fac9-409f-aa19-1f9221aec445")
                                    .description("MacBook Pro")
                                    .exchangeRate("2.9")
                                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                    .build()
                            )
                        )
                        .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .remoteWasDeleted(true)
                        .id("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
                        .remoteId("088899")
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
        assertThat(expenseResponse).isNotNull
        assertThat(expenseResponse.model())
            .isEqualTo(
                Expense.builder()
                    .transactionDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .remoteCreatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                    .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                    .contact("3d263469-51a1-4766-9205-f6c997826be1")
                    .totalAmount(42.23)
                    .currency(Expense.CurrencyEnum.XUA)
                    .exchangeRate("2.9")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .memo("New employee supplies")
                    .lines(
                        listOf(
                            Expense.ExpenseLine.builder()
                                .remoteId("121222")
                                .item("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                .netAmount(42.23)
                                .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                .account("2a56344a-a491-11ec-b909-0242ac120002")
                                .contact("c640b80b-fac9-409f-aa19-1f9221aec445")
                                .description("MacBook Pro")
                                .exchangeRate("2.9")
                                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                .build()
                        )
                    )
                    .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .remoteWasDeleted(true)
                    .id("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
                    .remoteId("088899")
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
        assertThat(expenseResponse.warnings())
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
        assertThat(expenseResponse.errors())
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
        assertThat(expenseResponse.logs().get())
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
