package dev.merge.api.models.accounting

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PaymentCreateParamsTest {

    @Test
    fun createPaymentCreateParams() {
        PaymentCreateParams.builder()
            .model(
                PaymentCreateParams.PaymentRequest.builder()
                    .transactionDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                    .contact("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                    .account("d6e687d6-0c36-48a1-8114-35324b5cb38f")
                    .currency(PaymentCreateParams.PaymentRequest.CurrencyEnum.XUA)
                    .exchangeRate("2.9")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .totalAmount(42.23)
                    .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            PaymentCreateParams.builder()
                .model(
                    PaymentCreateParams.PaymentRequest.builder()
                        .transactionDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                        .contact("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                        .account("d6e687d6-0c36-48a1-8114-35324b5cb38f")
                        .currency(PaymentCreateParams.PaymentRequest.CurrencyEnum.XUA)
                        .exchangeRate("2.9")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                        .totalAmount(42.23)
                        .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
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
            PaymentCreateParams.builder()
                .model(PaymentCreateParams.PaymentRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            PaymentCreateParams.builder()
                .model(
                    PaymentCreateParams.PaymentRequest.builder()
                        .transactionDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                        .contact("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                        .account("d6e687d6-0c36-48a1-8114-35324b5cb38f")
                        .currency(PaymentCreateParams.PaymentRequest.CurrencyEnum.XUA)
                        .exchangeRate("2.9")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                        .totalAmount(42.23)
                        .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
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
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                PaymentCreateParams.PaymentRequest.builder()
                    .transactionDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                    .contact("5b3c1341-a20f-4e51-b72c-f3830a16c97b")
                    .account("d6e687d6-0c36-48a1-8114-35324b5cb38f")
                    .currency(PaymentCreateParams.PaymentRequest.CurrencyEnum.XUA)
                    .exchangeRate("2.9")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .totalAmount(42.23)
                    .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            PaymentCreateParams.builder()
                .model(PaymentCreateParams.PaymentRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(PaymentCreateParams.PaymentRequest.builder().build())
    }
}
