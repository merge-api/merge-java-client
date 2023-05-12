package dev.merge.api.services.blocking.marketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.marketing.*
import dev.merge.api.models.marketing.EmailListParams
import dev.merge.api.models.marketing.EmailListRecipientsParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EmailServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val emailService = client.marketing().emails()
        val email =
            emailService.retrieve(
                EmailRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .build()
            )
        println(email)
        email.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val emailService = client.marketing().emails()
        val paginatedMarketingEmailList = emailService.list(EmailListParams.builder().build())
        println(paginatedMarketingEmailList)
        paginatedMarketingEmailList.results().forEach { it.validate() }
    }

    @Test
    fun callListRecipients() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val emailService = client.marketing().emails()
        val paginatedContactList =
            emailService.listRecipients(
                EmailListRecipientsParams.builder()
                    .parentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(paginatedContactList)
        paginatedContactList.results().forEach { it.validate() }
    }
}
