package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.TaxRateListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TaxRateServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val taxRateService = client.accounting().taxRates()
        val taxRate =
            taxRateService.retrieve(
                TaxRateRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(TaxRateRetrieveParams.Expand.COMPANY))
                    .includeRemoteData(true)
                    .build()
            )
        println(taxRate)
        taxRate.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val taxRateService = client.accounting().taxRates()
        val paginatedTaxRateList = taxRateService.list(TaxRateListParams.builder().build())
        println(paginatedTaxRateList)
        paginatedTaxRateList.results().forEach { it.validate() }
    }
}
