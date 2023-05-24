package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TransactionTest {

    @Test
    fun createTransaction() {
        val transaction =
            Transaction.builder()
                .transactionType("estimate")
                .number("122")
                .transactionDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .account("3e442c5d-8f51-4103-b5c9-dcee39c30a08")
                .contact("2c22ce34-5c6e-4fc7-a594-7f26bb4cf78b")
                .totalAmount("260")
                .currency(Transaction.CurrencyEnum.XUA)
                .exchangeRate("2.9")
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .lineItems(
                    listOf(
                        Transaction.TransactionLineItem.builder()
                            .remoteId("121222")
                            .memo("Pickleball paddles")
                            .unitPrice("25.0")
                            .quantity("10.0")
                            .item("0958cbc6-6040-430a-848e-aafacbadf4ae")
                            .account("2b38c085-2620-4269-b5ec-75dd9095ed2c")
                            .trackingCategory("f1214c24-2702-4617-b74b-3ddecfc0d384")
                            .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .totalLineAmount("260")
                            .taxRate("a12e7c20-1922-9df7-s75n-edfeewnn7384")
                            .currency(Transaction.TransactionLineItem.CurrencyEnum.XUA)
                            .exchangeRate("2.9")
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
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
        assertThat(transaction).isNotNull
        assertThat(transaction.transactionType()).contains("estimate")
        assertThat(transaction.number()).contains("122")
        assertThat(transaction.transactionDate())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(transaction.account()).contains("3e442c5d-8f51-4103-b5c9-dcee39c30a08")
        assertThat(transaction.contact()).contains("2c22ce34-5c6e-4fc7-a594-7f26bb4cf78b")
        assertThat(transaction.totalAmount()).contains("260")
        assertThat(transaction.currency()).contains(Transaction.CurrencyEnum.XUA)
        assertThat(transaction.exchangeRate()).contains("2.9")
        assertThat(transaction.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(transaction.trackingCategories().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(transaction.lineItems().get())
            .containsExactly(
                Transaction.TransactionLineItem.builder()
                    .remoteId("121222")
                    .memo("Pickleball paddles")
                    .unitPrice("25.0")
                    .quantity("10.0")
                    .item("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .account("2b38c085-2620-4269-b5ec-75dd9095ed2c")
                    .trackingCategory("f1214c24-2702-4617-b74b-3ddecfc0d384")
                    .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .totalLineAmount("260")
                    .taxRate("a12e7c20-1922-9df7-s75n-edfeewnn7384")
                    .currency(Transaction.TransactionLineItem.CurrencyEnum.XUA)
                    .exchangeRate("2.9")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(transaction.remoteWasDeleted()).contains(true)
        assertThat(transaction.id()).contains("0048ea5b-911e-4dff-9364-92070dea62ff")
        assertThat(transaction.remoteId()).contains("239741")
        assertThat(transaction._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(transaction.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(transaction.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
