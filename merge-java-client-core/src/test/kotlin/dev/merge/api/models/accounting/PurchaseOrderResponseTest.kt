package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PurchaseOrderResponseTest {

    @Test
    fun createPurchaseOrderResponse() {
        val purchaseOrderResponse =
            PurchaseOrderResponse.builder()
                .model(
                    PurchaseOrder.builder()
                        .status(PurchaseOrder.PurchaseOrderStatusEnum.DRAFT)
                        .issueDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                        .deliveryDate(OffsetDateTime.parse("2020-04-15T00:00:00Z"))
                        .deliveryAddress("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .customer("3e442c5d-8f51-4103-b5c9-dcee39c30a08")
                        .vendor("2c22ce34-5c6e-4fc7-a594-7f26bb4cf78b")
                        .memo("private note")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                        .totalAmount(42.23)
                        .currency(PurchaseOrder.CurrencyEnum.XUA)
                        .exchangeRate("2.9")
                        .lineItems(
                            listOf(
                                PurchaseOrder.PurchaseOrderLineItem.builder()
                                    .remoteId("121222")
                                    .description("Pickleball paddles")
                                    .unitPrice(42.23)
                                    .quantity(42.23)
                                    .item("0958cbc6-6040-430a-848e-aafacbadf4ae")
                                    .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                    .trackingCategory("f1214c24-2702-4617-b74b-3ddecfc0d384")
                                    .trackingCategories(
                                        listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                    )
                                    .taxAmount("10")
                                    .totalLineAmount("260")
                                    .currency(PurchaseOrder.PurchaseOrderLineItem.CurrencyEnum.XUA)
                                    .exchangeRate("2.9")
                                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                    .build()
                            )
                        )
                        .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .remoteCreatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                        .remoteUpdatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                        .remoteWasDeleted(true)
                        .id("0048ea5b-911e-4dff-9364-92070dea62ff")
                        .remoteId("239741")
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
        assertThat(purchaseOrderResponse).isNotNull
        assertThat(purchaseOrderResponse.model())
            .isEqualTo(
                PurchaseOrder.builder()
                    .status(PurchaseOrder.PurchaseOrderStatusEnum.DRAFT)
                    .issueDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                    .deliveryDate(OffsetDateTime.parse("2020-04-15T00:00:00Z"))
                    .deliveryAddress("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .customer("3e442c5d-8f51-4103-b5c9-dcee39c30a08")
                    .vendor("2c22ce34-5c6e-4fc7-a594-7f26bb4cf78b")
                    .memo("private note")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .totalAmount(42.23)
                    .currency(PurchaseOrder.CurrencyEnum.XUA)
                    .exchangeRate("2.9")
                    .lineItems(
                        listOf(
                            PurchaseOrder.PurchaseOrderLineItem.builder()
                                .remoteId("121222")
                                .description("Pickleball paddles")
                                .unitPrice(42.23)
                                .quantity(42.23)
                                .item("0958cbc6-6040-430a-848e-aafacbadf4ae")
                                .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .trackingCategory("f1214c24-2702-4617-b74b-3ddecfc0d384")
                                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                                .taxAmount("10")
                                .totalLineAmount("260")
                                .currency(PurchaseOrder.PurchaseOrderLineItem.CurrencyEnum.XUA)
                                .exchangeRate("2.9")
                                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                .build()
                        )
                    )
                    .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .remoteCreatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                    .remoteUpdatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                    .remoteWasDeleted(true)
                    .id("0048ea5b-911e-4dff-9364-92070dea62ff")
                    .remoteId("239741")
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
        assertThat(purchaseOrderResponse.warnings())
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
        assertThat(purchaseOrderResponse.errors())
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
        assertThat(purchaseOrderResponse.logs().get())
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
