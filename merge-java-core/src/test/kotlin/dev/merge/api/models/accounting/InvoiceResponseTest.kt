package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InvoiceResponseTest {

    @Test
    fun createInvoiceResponse() {
        val invoiceResponse =
            InvoiceResponse.builder()
                .model(
                    Invoice.builder()
                        .type(Invoice.InvoiceTypeEnum.ACCOUNTS_RECEIVABLE)
                        .contact("022a2bef-57e5-4def-8ed2-7c41bd9a5ed8")
                        .number("AIQ12546")
                        .issueDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                        .dueDate(OffsetDateTime.parse("2020-04-15T00:00:00Z"))
                        .paidOnDate(OffsetDateTime.parse("2020-04-01T00:00:00Z"))
                        .memo("Weekly Payment")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                        .currency(Invoice.CurrencyEnum.XUA)
                        .exchangeRate("2.9")
                        .totalDiscount(42.23)
                        .subTotal(42.23)
                        .totalTaxAmount(42.23)
                        .totalAmount(42.23)
                        .balance(42.23)
                        .remoteUpdatedAt(OffsetDateTime.parse("2020-04-01T00:00:00Z"))
                        .payments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .lineItems(
                            listOf(
                                Invoice.InvoiceLineItem.builder()
                                    .remoteId("8765432")
                                    .description("Pickleball lessons")
                                    .unitPrice(42.23)
                                    .quantity(42.23)
                                    .totalAmount(42.23)
                                    .currency(Invoice.InvoiceLineItem.CurrencyEnum.XUA)
                                    .exchangeRate("2.9")
                                    .item("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                                    .account("cd0f32d4-a493-11ec-b909-0242ac120002")
                                    .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                    .trackingCategories(
                                        listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                    )
                                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                    .id("022a2bef-57e5-4def-8ed2-7c41bd9a5ed8")
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
                                    .build()
                            )
                        )
                        .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .remoteWasDeleted(true)
                        .id("9871b4a9-f5d2-4f3b-a66b-dfedbed42c46")
                        .remoteId("990110")
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
        assertThat(invoiceResponse).isNotNull
        assertThat(invoiceResponse.model())
            .isEqualTo(
                Invoice.builder()
                    .type(Invoice.InvoiceTypeEnum.ACCOUNTS_RECEIVABLE)
                    .contact("022a2bef-57e5-4def-8ed2-7c41bd9a5ed8")
                    .number("AIQ12546")
                    .issueDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                    .dueDate(OffsetDateTime.parse("2020-04-15T00:00:00Z"))
                    .paidOnDate(OffsetDateTime.parse("2020-04-01T00:00:00Z"))
                    .memo("Weekly Payment")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .currency(Invoice.CurrencyEnum.XUA)
                    .exchangeRate("2.9")
                    .totalDiscount(42.23)
                    .subTotal(42.23)
                    .totalTaxAmount(42.23)
                    .totalAmount(42.23)
                    .balance(42.23)
                    .remoteUpdatedAt(OffsetDateTime.parse("2020-04-01T00:00:00Z"))
                    .payments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .lineItems(
                        listOf(
                            Invoice.InvoiceLineItem.builder()
                                .remoteId("8765432")
                                .description("Pickleball lessons")
                                .unitPrice(42.23)
                                .quantity(42.23)
                                .totalAmount(42.23)
                                .currency(Invoice.InvoiceLineItem.CurrencyEnum.XUA)
                                .exchangeRate("2.9")
                                .item("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                                .account("cd0f32d4-a493-11ec-b909-0242ac120002")
                                .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                .id("022a2bef-57e5-4def-8ed2-7c41bd9a5ed8")
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
                                .build()
                        )
                    )
                    .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .remoteWasDeleted(true)
                    .id("9871b4a9-f5d2-4f3b-a66b-dfedbed42c46")
                    .remoteId("990110")
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
        assertThat(invoiceResponse.warnings())
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
        assertThat(invoiceResponse.errors())
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
        assertThat(invoiceResponse.logs().get())
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
