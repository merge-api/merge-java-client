package dev.merge.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WebhookReceiverTest {

    @Test
    fun createWebhookReceiver() {
        val webhookReceiver =
            WebhookReceiver.builder().event("string").isActive(true).key("string").build()
        assertThat(webhookReceiver).isNotNull
        assertThat(webhookReceiver.event()).isEqualTo("string")
        assertThat(webhookReceiver.isActive()).isEqualTo(true)
        assertThat(webhookReceiver.key()).contains("string")
    }
}
