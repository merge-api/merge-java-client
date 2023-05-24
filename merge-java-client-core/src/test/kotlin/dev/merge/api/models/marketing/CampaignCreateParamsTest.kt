package dev.merge.api.models.marketing

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CampaignCreateParamsTest {

    @Test
    fun createCampaignCreateParams() {
        CampaignCreateParams.builder()
            .model(
                CampaignCreateParams.CampaignRequest.builder()
                    .name("New Customer Campaign")
                    .uniqueOpens(123L)
                    .emailsSent(123L)
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            CampaignCreateParams.builder()
                .model(
                    CampaignCreateParams.CampaignRequest.builder()
                        .name("New Customer Campaign")
                        .uniqueOpens(123L)
                        .emailsSent(123L)
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
                        .build()
                )
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("is_debug_mode", listOf("true"))
        expected.put("run_async", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            CampaignCreateParams.builder()
                .model(CampaignCreateParams.CampaignRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            CampaignCreateParams.builder()
                .model(
                    CampaignCreateParams.CampaignRequest.builder()
                        .name("New Customer Campaign")
                        .uniqueOpens(123L)
                        .emailsSent(123L)
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
                        .build()
                )
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                CampaignCreateParams.CampaignRequest.builder()
                    .name("New Customer Campaign")
                    .uniqueOpens(123L)
                    .emailsSent(123L)
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            CampaignCreateParams.builder()
                .model(CampaignCreateParams.CampaignRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(CampaignCreateParams.CampaignRequest.builder().build())
    }
}
