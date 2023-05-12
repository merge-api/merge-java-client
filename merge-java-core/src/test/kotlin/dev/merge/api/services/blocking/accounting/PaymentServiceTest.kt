package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.PaymentListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class PaymentServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val paymentService = client.accounting().payments()
        val paymentResponse =
            paymentService.create(
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
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(paymentResponse)
        paymentResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val paymentService = client.accounting().payments()
        val payment =
            paymentService.retrieve(
                PaymentRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(PaymentRetrieveParams.Expand.ACCOUNT))
                    .includeRemoteData(true)
                    .build()
            )
        println(payment)
        payment.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val paymentService = client.accounting().payments()
        val paginatedPaymentList = paymentService.list(PaymentListParams.builder().build())
        println(paginatedPaymentList)
        paginatedPaymentList.results().forEach { it.validate() }
    }
}
