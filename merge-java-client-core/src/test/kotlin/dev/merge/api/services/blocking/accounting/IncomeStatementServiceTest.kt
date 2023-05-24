package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.IncomeStatementListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class IncomeStatementServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val incomeStatementService = client.accounting().incomeStatements()
        val incomeStatement =
            incomeStatementService.retrieve(
                IncomeStatementRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(IncomeStatementRetrieveParams.Expand.COMPANY))
                    .includeRemoteData(true)
                    .build()
            )
        println(incomeStatement)
        incomeStatement.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val incomeStatementService = client.accounting().incomeStatements()
        val paginatedIncomeStatementList =
            incomeStatementService.list(IncomeStatementListParams.builder().build())
        println(paginatedIncomeStatementList)
        paginatedIncomeStatementList.results().forEach { it.validate() }
    }
}
