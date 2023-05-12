package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.ExpenseListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ExpenseServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val expenseService = client.accounting().expenses()
        val expenseResponse =
            expenseService.create(
                ExpenseCreateParams.builder()
                    .model(
                        ExpenseCreateParams.ExpenseRequest.builder()
                            .transactionDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                            .contact("3d263469-51a1-4766-9205-f6c997826be1")
                            .totalAmount(42.23)
                            .currency(ExpenseCreateParams.ExpenseRequest.CurrencyEnum.XUA)
                            .exchangeRate("2.9")
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .memo("New employee supplies")
                            .lines(
                                listOf(
                                    ExpenseCreateParams.ExpenseRequest.ExpenseLineRequest.builder()
                                        .remoteId("121222")
                                        .item("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                        .netAmount(42.23)
                                        .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                        .trackingCategories(
                                            listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                        )
                                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                        .account("2a56344a-a491-11ec-b909-0242ac120002")
                                        .contact("c640b80b-fac9-409f-aa19-1f9221aec445")
                                        .description("MacBook Pro")
                                        .exchangeRate("2.9")
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
        println(expenseResponse)
        expenseResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val expenseService = client.accounting().expenses()
        val expense =
            expenseService.retrieve(
                ExpenseRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(ExpenseRetrieveParams.Expand.ACCOUNT))
                    .includeRemoteData(true)
                    .build()
            )
        println(expense)
        expense.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val expenseService = client.accounting().expenses()
        val paginatedExpenseList = expenseService.list(ExpenseListParams.builder().build())
        println(paginatedExpenseList)
        paginatedExpenseList.results().forEach { it.validate() }
    }
}
