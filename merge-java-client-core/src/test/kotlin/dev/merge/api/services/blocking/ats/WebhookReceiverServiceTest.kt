package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class WebhookReceiverServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val webhookReceiverService = client.ats().webhookReceivers()
        val webhookReceiver =
            webhookReceiverService.create(
                WebhookReceiverCreateParams.builder().event("x").isActive(true).key("x").build()
            )
        println(webhookReceiver)
        webhookReceiver.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val webhookReceiverService = client.ats().webhookReceivers()
        val webhookReceiverListResponse =
            webhookReceiverService.list(WebhookReceiverListParams.builder().build())
        println(webhookReceiverListResponse)
        for (webhookReceiver: WebhookReceiver in webhookReceiverListResponse) {
            webhookReceiver.validate()
        }
    }
}
