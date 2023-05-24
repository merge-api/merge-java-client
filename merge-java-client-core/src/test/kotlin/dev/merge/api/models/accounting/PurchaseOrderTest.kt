package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PurchaseOrderTest {

    @Test
    fun createPurchaseOrder() {
        val purchaseOrder =
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
                            "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                            "linked_account_defined_targets" to
                                mapOf("custom_key" to "custom_value")
                        )
                    )
                )
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .remoteData(
                    listOf(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
                )
                .build()
        assertThat(purchaseOrder).isNotNull
        assertThat(purchaseOrder.status()).contains(PurchaseOrder.PurchaseOrderStatusEnum.DRAFT)
        assertThat(purchaseOrder.issueDate()).contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(purchaseOrder.deliveryDate())
            .contains(OffsetDateTime.parse("2020-04-15T00:00:00Z"))
        assertThat(purchaseOrder.deliveryAddress()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(purchaseOrder.customer()).contains("3e442c5d-8f51-4103-b5c9-dcee39c30a08")
        assertThat(purchaseOrder.vendor()).contains("2c22ce34-5c6e-4fc7-a594-7f26bb4cf78b")
        assertThat(purchaseOrder.memo()).contains("private note")
        assertThat(purchaseOrder.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(purchaseOrder.totalAmount()).contains(42.23)
        assertThat(purchaseOrder.currency()).contains(PurchaseOrder.CurrencyEnum.XUA)
        assertThat(purchaseOrder.exchangeRate()).contains("2.9")
        assertThat(purchaseOrder.lineItems().get())
            .containsExactly(
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
        assertThat(purchaseOrder.trackingCategories().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(purchaseOrder.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(purchaseOrder.remoteUpdatedAt())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(purchaseOrder.remoteWasDeleted()).contains(true)
        assertThat(purchaseOrder.id()).contains("0048ea5b-911e-4dff-9364-92070dea62ff")
        assertThat(purchaseOrder.remoteId()).contains("239741")
        assertThat(purchaseOrder._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(purchaseOrder.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(purchaseOrder.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
