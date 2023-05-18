package dev.merge.api.models.crm

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserIgnoreRowParamsTest {

    @Test
    fun createUserIgnoreRowParams() {
        UserIgnoreRowParams.builder()
            .modelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .reason(UserIgnoreRowParams.ReasonEnum.GENERAL_CUSTOMER_REQUEST)
            .message("deletion request by user id 51903790-7dfe-4053-8d63-5a10cc4ffd39")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            UserIgnoreRowParams.builder()
                .modelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .reason(UserIgnoreRowParams.ReasonEnum.GENERAL_CUSTOMER_REQUEST)
                .message("deletion request by user id 51903790-7dfe-4053-8d63-5a10cc4ffd39")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.reason()).isEqualTo(UserIgnoreRowParams.ReasonEnum.GENERAL_CUSTOMER_REQUEST)
        assertThat(body.message())
            .isEqualTo("deletion request by user id 51903790-7dfe-4053-8d63-5a10cc4ffd39")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            UserIgnoreRowParams.builder()
                .modelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .reason(UserIgnoreRowParams.ReasonEnum.GENERAL_CUSTOMER_REQUEST)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.reason()).isEqualTo(UserIgnoreRowParams.ReasonEnum.GENERAL_CUSTOMER_REQUEST)
    }

    @Test
    fun getPathParam() {
        val params =
            UserIgnoreRowParams.builder()
                .modelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .reason(UserIgnoreRowParams.ReasonEnum.GENERAL_CUSTOMER_REQUEST)
                .build()
        assertThat(params).isNotNull
        // path param "modelId"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
