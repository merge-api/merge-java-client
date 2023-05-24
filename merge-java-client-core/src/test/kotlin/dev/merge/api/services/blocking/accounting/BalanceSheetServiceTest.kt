package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.BalanceSheetListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class BalanceSheetServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val balanceSheetService = client.accounting().balanceSheets()
        val balanceSheet =
            balanceSheetService.retrieve(
                BalanceSheetRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(BalanceSheetRetrieveParams.Expand.COMPANY))
                    .includeRemoteData(true)
                    .build()
            )
        println(balanceSheet)
        balanceSheet.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val balanceSheetService = client.accounting().balanceSheets()
        val paginatedBalanceSheetList =
            balanceSheetService.list(BalanceSheetListParams.builder().build())
        println(paginatedBalanceSheetList)
        paginatedBalanceSheetList.results().forEach { it.validate() }
    }
}
