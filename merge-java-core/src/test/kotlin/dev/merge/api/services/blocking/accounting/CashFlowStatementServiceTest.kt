package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.CashFlowStatementListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CashFlowStatementServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val cashFlowStatementService = client.accounting().cashFlowStatements()
        val cashFlowStatement =
            cashFlowStatementService.retrieve(
                CashFlowStatementRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(CashFlowStatementRetrieveParams.Expand.COMPANY))
                    .includeRemoteData(true)
                    .build()
            )
        println(cashFlowStatement)
        cashFlowStatement.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val cashFlowStatementService = client.accounting().cashFlowStatements()
        val paginatedCashFlowStatementList =
            cashFlowStatementService.list(CashFlowStatementListParams.builder().build())
        println(paginatedCashFlowStatementList)
        paginatedCashFlowStatementList.results().forEach { it.validate() }
    }
}
