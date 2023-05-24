package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CreditNoteTest {

    @Test
    fun createCreditNote() {
        val creditNote =
            CreditNote.builder()
                .id("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
                .remoteId("123877")
                .transactionDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .status(CreditNote.CreditNoteStatusEnum.SUBMITTED)
                .number("CN-29")
                .contact("c6c7b870-bb4d-489a-921e-2f0ee4192ff9")
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                .totalAmount(42.23)
                .remainingCredit(42.23)
                .lineItems(
                    listOf(
                        CreditNote.CreditNoteLineItem.builder()
                            .item("0e3fd929-436c-4fd4-a48b-0c61f68d6178")
                            .name("Basic Monthly")
                            .description("prorated amount for items")
                            .quantity("1")
                            .memo("privNote")
                            .unitPrice("5.0")
                            .taxRate("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
                            .totalLineAmount("5.0")
                            .trackingCategory("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
                            .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .account("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .remoteId("121222")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .currency(CreditNote.CurrencyEnum.XUA)
                .remoteCreatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .remoteUpdatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .payments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .remoteWasDeleted(true)
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
        assertThat(creditNote).isNotNull
        assertThat(creditNote.id()).contains("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
        assertThat(creditNote.remoteId()).contains("123877")
        assertThat(creditNote.transactionDate())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(creditNote.status()).contains(CreditNote.CreditNoteStatusEnum.SUBMITTED)
        assertThat(creditNote.number()).contains("CN-29")
        assertThat(creditNote.contact()).contains("c6c7b870-bb4d-489a-921e-2f0ee4192ff9")
        assertThat(creditNote.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(creditNote.totalAmount()).contains(42.23)
        assertThat(creditNote.remainingCredit()).contains(42.23)
        assertThat(creditNote.lineItems().get())
            .containsExactly(
                CreditNote.CreditNoteLineItem.builder()
                    .item("0e3fd929-436c-4fd4-a48b-0c61f68d6178")
                    .name("Basic Monthly")
                    .description("prorated amount for items")
                    .quantity("1")
                    .memo("privNote")
                    .unitPrice("5.0")
                    .taxRate("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
                    .totalLineAmount("5.0")
                    .trackingCategory("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
                    .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .account("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .remoteId("121222")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(creditNote.trackingCategories().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(creditNote.currency()).contains(CreditNote.CurrencyEnum.XUA)
        assertThat(creditNote.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(creditNote.remoteUpdatedAt())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(creditNote.payments().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(creditNote.remoteWasDeleted()).contains(true)
        assertThat(creditNote._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(creditNote.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(creditNote.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
