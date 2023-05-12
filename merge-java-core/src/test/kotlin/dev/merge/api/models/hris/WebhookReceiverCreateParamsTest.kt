package dev.merge.api.models.hris

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WebhookReceiverCreateParamsTest {

    @Test
    fun createWebhookReceiverCreateParams() {
        WebhookReceiverCreateParams.builder().event("x").isActive(true).key("x").build()
    }

    @Test
    fun getBody() {
        val params =
            WebhookReceiverCreateParams.builder().event("x").isActive(true).key("x").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.event()).isEqualTo("x")
        assertThat(body.isActive()).isEqualTo(true)
        assertThat(body.key()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = WebhookReceiverCreateParams.builder().event("x").isActive(true).build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.event()).isEqualTo("x")
        assertThat(body.isActive()).isEqualTo(true)
    }
}
