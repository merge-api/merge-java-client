package dev.merge.api.models.marketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CampaignTest {

    @Test
    fun createCampaign() {
        val campaign =
            Campaign.builder()
                .name("New Customer Campaign")
                .uniqueOpens(123L)
                .remoteCreatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                .emailsSent(123L)
                .remoteWasDeleted(true)
                .id("3737cbc6-6040-430a-475r-aafacbadrf47")
                .remoteId("30")
                .fieldMappings(
                    JsonValue.from(
                        mapOf(
                            "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                            "linked_account_defined_targets" to
                                mapOf("custom_key" to "custom_value")
                        )
                    )
                )
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .remoteData(
                    listOf(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
                )
                .build()
        assertThat(campaign).isNotNull
        assertThat(campaign.name()).contains("New Customer Campaign")
        assertThat(campaign.uniqueOpens()).contains(123L)
        assertThat(campaign.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
        assertThat(campaign.emailsSent()).contains(123L)
        assertThat(campaign.remoteWasDeleted()).contains(true)
        assertThat(campaign.id()).contains("3737cbc6-6040-430a-475r-aafacbadrf47")
        assertThat(campaign.remoteId()).contains("30")
        assertThat(campaign._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(campaign.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(campaign.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
