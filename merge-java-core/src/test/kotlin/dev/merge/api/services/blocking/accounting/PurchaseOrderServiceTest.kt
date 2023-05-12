package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.PurchaseOrderListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class PurchaseOrderServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val purchaseOrderService = client.accounting().purchaseOrders()
        val purchaseOrderResponse =
            purchaseOrderService.create(
                PurchaseOrderCreateParams.builder()
                    .model(
                        PurchaseOrderCreateParams.PurchaseOrderRequest.builder()
                            .status(
                                PurchaseOrderCreateParams.PurchaseOrderRequest
                                    .PurchaseOrderStatusEnum
                                    .DRAFT
                            )
                            .issueDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .deliveryDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .deliveryAddress("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .customer("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .vendor("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .memo("string")
                            .company("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .totalAmount(42.23)
                            .currency(
                                PurchaseOrderCreateParams.PurchaseOrderRequest.CurrencyEnum.XUA
                            )
                            .exchangeRate("string")
                            .lineItems(
                                listOf(
                                    PurchaseOrderCreateParams.PurchaseOrderRequest
                                        .PurchaseOrderLineItemRequest
                                        .builder()
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
                                        .currency(
                                            PurchaseOrderCreateParams.PurchaseOrderRequest
                                                .PurchaseOrderLineItemRequest
                                                .CurrencyEnum
                                                .XUA
                                        )
                                        .exchangeRate("2.9")
                                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                        .integrationParams(
                                            JsonValue.from(
                                                mapOf(
                                                    "unique_integration_field" to
                                                        "unique_integration_field_value"
                                                )
                                            )
                                        )
                                        .linkedAccountParams(
                                            JsonValue.from(
                                                mapOf(
                                                    "unique_linked_account_field" to
                                                        "unique_linked_account_field_value"
                                                )
                                            )
                                        )
                                        .build()
                                )
                            )
                            .integrationParams(JsonString.of("abc"))
                            .linkedAccountParams(JsonString.of("abc"))
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(purchaseOrderResponse)
        purchaseOrderResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val purchaseOrderService = client.accounting().purchaseOrders()
        val purchaseOrder =
            purchaseOrderService.retrieve(
                PurchaseOrderRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(PurchaseOrderRetrieveParams.Expand.COMPANY))
                    .includeRemoteData(true)
                    .remoteFields(PurchaseOrderRetrieveParams.RemoteFields.STATUS)
                    .showEnumOrigins(PurchaseOrderRetrieveParams.ShowEnumOrigins.STATUS)
                    .build()
            )
        println(purchaseOrder)
        purchaseOrder.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val purchaseOrderService = client.accounting().purchaseOrders()
        val paginatedPurchaseOrderList =
            purchaseOrderService.list(PurchaseOrderListParams.builder().build())
        println(paginatedPurchaseOrderList)
        paginatedPurchaseOrderList.results().forEach { it.validate() }
    }
}
