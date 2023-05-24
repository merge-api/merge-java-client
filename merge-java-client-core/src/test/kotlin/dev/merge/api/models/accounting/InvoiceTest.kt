package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InvoiceTest {

    @Test
    fun createInvoice() {
        val invoice =
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
        assertThat(invoice).isNotNull
        assertThat(invoice.type()).contains(Invoice.InvoiceTypeEnum.ACCOUNTS_RECEIVABLE)
        assertThat(invoice.contact()).contains("022a2bef-57e5-4def-8ed2-7c41bd9a5ed8")
        assertThat(invoice.number()).contains("AIQ12546")
        assertThat(invoice.issueDate()).contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(invoice.dueDate()).contains(OffsetDateTime.parse("2020-04-15T00:00:00Z"))
        assertThat(invoice.paidOnDate()).contains(OffsetDateTime.parse("2020-04-01T00:00:00Z"))
        assertThat(invoice.memo()).contains("Weekly Payment")
        assertThat(invoice.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(invoice.currency()).contains(Invoice.CurrencyEnum.XUA)
        assertThat(invoice.exchangeRate()).contains("2.9")
        assertThat(invoice.totalDiscount()).contains(42.23)
        assertThat(invoice.subTotal()).contains(42.23)
        assertThat(invoice.totalTaxAmount()).contains(42.23)
        assertThat(invoice.totalAmount()).contains(42.23)
        assertThat(invoice.balance()).contains(42.23)
        assertThat(invoice.remoteUpdatedAt()).contains(OffsetDateTime.parse("2020-04-01T00:00:00Z"))
        assertThat(invoice.payments().get()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(invoice.lineItems().get())
            .containsExactly(
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
        assertThat(invoice.trackingCategories().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(invoice.remoteWasDeleted()).contains(true)
        assertThat(invoice.id()).contains("9871b4a9-f5d2-4f3b-a66b-dfedbed42c46")
        assertThat(invoice.remoteId()).contains("990110")
        assertThat(invoice._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(invoice.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(invoice.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
