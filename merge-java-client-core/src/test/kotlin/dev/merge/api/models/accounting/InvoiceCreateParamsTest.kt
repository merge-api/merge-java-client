package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InvoiceCreateParamsTest {

    @Test
    fun createInvoiceCreateParams() {
        InvoiceCreateParams.builder()
            .model(
                InvoiceCreateParams.InvoiceRequest.builder()
                    .type(InvoiceCreateParams.InvoiceRequest.InvoiceTypeEnum.ACCOUNTS_RECEIVABLE)
                    .contact("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .number("string")
                    .issueDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .dueDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .paidOnDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .memo("string")
                    .company("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .currency(InvoiceCreateParams.InvoiceRequest.CurrencyEnum.XUA)
                    .exchangeRate("string")
                    .totalDiscount(42.23)
                    .subTotal(42.23)
                    .totalTaxAmount(42.23)
                    .totalAmount(42.23)
                    .balance(42.23)
                    .payments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .lineItems(
                        listOf(
                            InvoiceCreateParams.InvoiceRequest.InvoiceLineItemRequest.builder()
                                .remoteId("8765432")
                                .description("Pickleball lessons")
                                .unitPrice(42.23)
                                .quantity(42.23)
                                .totalAmount(42.23)
                                .currency(
                                    InvoiceCreateParams.InvoiceRequest.InvoiceLineItemRequest
                                        .CurrencyEnum
                                        .XUA
                                )
                                .exchangeRate("2.9")
                                .item("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                                .account("cd0f32d4-a493-11ec-b909-0242ac120002")
                                .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
    }

    @Test
    fun getQueryParams() {
        val params =
            InvoiceCreateParams.builder()
                .model(
                    InvoiceCreateParams.InvoiceRequest.builder()
                        .type(
                            InvoiceCreateParams.InvoiceRequest.InvoiceTypeEnum.ACCOUNTS_RECEIVABLE
                        )
                        .contact("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .number("string")
                        .issueDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .dueDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .paidOnDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .memo("string")
                        .company("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .currency(InvoiceCreateParams.InvoiceRequest.CurrencyEnum.XUA)
                        .exchangeRate("string")
                        .totalDiscount(42.23)
                        .subTotal(42.23)
                        .totalTaxAmount(42.23)
                        .totalAmount(42.23)
                        .balance(42.23)
                        .payments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .lineItems(
                            listOf(
                                InvoiceCreateParams.InvoiceRequest.InvoiceLineItemRequest.builder()
                                    .remoteId("8765432")
                                    .description("Pickleball lessons")
                                    .unitPrice(42.23)
                                    .quantity(42.23)
                                    .totalAmount(42.23)
                                    .currency(
                                        InvoiceCreateParams.InvoiceRequest.InvoiceLineItemRequest
                                            .CurrencyEnum
                                            .XUA
                                    )
                                    .exchangeRate("2.9")
                                    .item("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                                    .account("cd0f32d4-a493-11ec-b909-0242ac120002")
                                    .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                    .trackingCategories(
                                        listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                    )
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
        val expected = mutableMapOf<String, List<String>>()
        expected.put("is_debug_mode", listOf("true"))
        expected.put("run_async", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            InvoiceCreateParams.builder()
                .model(InvoiceCreateParams.InvoiceRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            InvoiceCreateParams.builder()
                .model(
                    InvoiceCreateParams.InvoiceRequest.builder()
                        .type(
                            InvoiceCreateParams.InvoiceRequest.InvoiceTypeEnum.ACCOUNTS_RECEIVABLE
                        )
                        .contact("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .number("string")
                        .issueDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .dueDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .paidOnDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .memo("string")
                        .company("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .currency(InvoiceCreateParams.InvoiceRequest.CurrencyEnum.XUA)
                        .exchangeRate("string")
                        .totalDiscount(42.23)
                        .subTotal(42.23)
                        .totalTaxAmount(42.23)
                        .totalAmount(42.23)
                        .balance(42.23)
                        .payments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .lineItems(
                            listOf(
                                InvoiceCreateParams.InvoiceRequest.InvoiceLineItemRequest.builder()
                                    .remoteId("8765432")
                                    .description("Pickleball lessons")
                                    .unitPrice(42.23)
                                    .quantity(42.23)
                                    .totalAmount(42.23)
                                    .currency(
                                        InvoiceCreateParams.InvoiceRequest.InvoiceLineItemRequest
                                            .CurrencyEnum
                                            .XUA
                                    )
                                    .exchangeRate("2.9")
                                    .item("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                                    .account("cd0f32d4-a493-11ec-b909-0242ac120002")
                                    .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                    .trackingCategories(
                                        listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                    )
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
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                InvoiceCreateParams.InvoiceRequest.builder()
                    .type(InvoiceCreateParams.InvoiceRequest.InvoiceTypeEnum.ACCOUNTS_RECEIVABLE)
                    .contact("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .number("string")
                    .issueDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .dueDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .paidOnDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .memo("string")
                    .company("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .currency(InvoiceCreateParams.InvoiceRequest.CurrencyEnum.XUA)
                    .exchangeRate("string")
                    .totalDiscount(42.23)
                    .subTotal(42.23)
                    .totalTaxAmount(42.23)
                    .totalAmount(42.23)
                    .balance(42.23)
                    .payments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .lineItems(
                        listOf(
                            InvoiceCreateParams.InvoiceRequest.InvoiceLineItemRequest.builder()
                                .remoteId("8765432")
                                .description("Pickleball lessons")
                                .unitPrice(42.23)
                                .quantity(42.23)
                                .totalAmount(42.23)
                                .currency(
                                    InvoiceCreateParams.InvoiceRequest.InvoiceLineItemRequest
                                        .CurrencyEnum
                                        .XUA
                                )
                                .exchangeRate("2.9")
                                .item("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                                .account("cd0f32d4-a493-11ec-b909-0242ac120002")
                                .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            InvoiceCreateParams.builder()
                .model(InvoiceCreateParams.InvoiceRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(InvoiceCreateParams.InvoiceRequest.builder().build())
    }
}
