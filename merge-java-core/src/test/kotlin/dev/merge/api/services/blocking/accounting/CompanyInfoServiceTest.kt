package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.CompanyInfoListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CompanyInfoServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val companyInfoService = client.accounting().companyInfo()
        val companyInfo =
            companyInfoService.retrieve(
                CompanyInfoRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(CompanyInfoRetrieveParams.Expand.ADDRESSES))
                    .includeRemoteData(true)
                    .build()
            )
        println(companyInfo)
        companyInfo.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val companyInfoService = client.accounting().companyInfo()
        val paginatedCompanyInfoList =
            companyInfoService.list(CompanyInfoListParams.builder().build())
        println(paginatedCompanyInfoList)
        paginatedCompanyInfoList.results().forEach { it.validate() }
    }
}
