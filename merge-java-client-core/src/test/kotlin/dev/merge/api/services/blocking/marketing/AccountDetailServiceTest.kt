package dev.merge.api.services.blocking.marketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.marketing.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AccountDetailServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val accountDetailService = client.marketing().accountDetails()
        val accountDetail =
            accountDetailService.retrieve(AccountDetailRetrieveParams.builder().build())
        println(accountDetail)
        accountDetail.validate()
    }
}
