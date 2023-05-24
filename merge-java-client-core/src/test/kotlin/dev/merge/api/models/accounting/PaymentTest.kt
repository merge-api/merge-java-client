package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PaymentTest {

    @Test
    fun createPayment() {
        val payment =
            Payment.builder()
                .id("b26fd49a-cbae-470a-a8f8-bcbc119e0390")
                .remoteId("987300")
                .transactionDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .contact("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                .account("d6e687d6-0c36-48a1-8114-35324b5cb38f")
                .currency(Payment.CurrencyEnum.XUA)
                .exchangeRate("2.9")
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                .totalAmount(42.23)
                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .remoteUpdatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
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
        assertThat(payment).isNotNull
        assertThat(payment.id()).contains("b26fd49a-cbae-470a-a8f8-bcbc119e0390")
        assertThat(payment.remoteId()).contains("987300")
        assertThat(payment.transactionDate()).contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(payment.contact()).contains("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
        assertThat(payment.account()).contains("d6e687d6-0c36-48a1-8114-35324b5cb38f")
        assertThat(payment.currency()).contains(Payment.CurrencyEnum.XUA)
        assertThat(payment.exchangeRate()).contains("2.9")
        assertThat(payment.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(payment.totalAmount()).contains(42.23)
        assertThat(payment.trackingCategories().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(payment.remoteUpdatedAt()).contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(payment.remoteWasDeleted()).contains(true)
        assertThat(payment._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(payment.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(payment.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
