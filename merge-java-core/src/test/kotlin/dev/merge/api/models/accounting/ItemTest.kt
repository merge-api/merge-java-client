package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ItemTest {

    @Test
    fun createItem() {
        val item =
            Item.builder()
                .id("d2f972d0-2526-434b-9409-4c3b468e08f0")
                .remoteId("12374")
                .name("Pickleball Paddle")
                .status(Item.Status7d1Enum.ACTIVE)
                .unitPrice(42.23)
                .purchasePrice(42.23)
                .purchaseAccount("9871b4a9-f5d2-4f3b-a66b-dfedbed42c46")
                .salesAccount("3872b4c9-f5d2-4f3b-a66b-dfedbed42c49")
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                .remoteUpdatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .remoteWasDeleted(true)
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
        assertThat(item).isNotNull
        assertThat(item.id()).contains("d2f972d0-2526-434b-9409-4c3b468e08f0")
        assertThat(item.remoteId()).contains("12374")
        assertThat(item.name()).contains("Pickleball Paddle")
        assertThat(item.status()).contains(Item.Status7d1Enum.ACTIVE)
        assertThat(item.unitPrice()).contains(42.23)
        assertThat(item.purchasePrice()).contains(42.23)
        assertThat(item.purchaseAccount()).contains("9871b4a9-f5d2-4f3b-a66b-dfedbed42c46")
        assertThat(item.salesAccount()).contains("3872b4c9-f5d2-4f3b-a66b-dfedbed42c49")
        assertThat(item.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(item.remoteUpdatedAt()).contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(item.remoteWasDeleted()).contains(true)
        assertThat(item._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(item.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(item.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
