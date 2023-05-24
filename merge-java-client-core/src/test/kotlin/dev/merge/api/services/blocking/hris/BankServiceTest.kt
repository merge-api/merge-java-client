package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import dev.merge.api.models.hris.BankListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class BankServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val bankService = client.hris().banks()
        val bankInfo =
            bankService.retrieve(
                BankRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(BankRetrieveParams.Expand.EMPLOYEE))
                    .includeRemoteData(true)
                    .remoteFields(BankRetrieveParams.RemoteFields.ACCOUNT_TYPE)
                    .showEnumOrigins(BankRetrieveParams.ShowEnumOrigins.ACCOUNT_TYPE)
                    .build()
            )
        println(bankInfo)
        bankInfo.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val bankService = client.hris().banks()
        val paginatedBankInfoList = bankService.list(BankListParams.builder().build())
        println(paginatedBankInfoList)
        paginatedBankInfoList.results().forEach { it.validate() }
    }
}
