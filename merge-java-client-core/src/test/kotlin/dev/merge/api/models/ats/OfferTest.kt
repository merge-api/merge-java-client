package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OfferTest {

    @Test
    fun createOffer() {
        val offer =
            Offer.builder()
                .id("dd85625c-6a59-446f-a317-6de64d83bae7")
                .remoteId("9876")
                .application("2872ba14-4084-492b-be96-e5eee6fc33ef")
                .creator("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                .remoteCreatedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                .closedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .sentAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                .startDate(OffsetDateTime.parse("2021-11-15T00:00:00Z"))
                .status(Offer.OfferStatusEnum.DRAFT)
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
        assertThat(offer).isNotNull
        assertThat(offer.id()).contains("dd85625c-6a59-446f-a317-6de64d83bae7")
        assertThat(offer.remoteId()).contains("9876")
        assertThat(offer.application()).contains("2872ba14-4084-492b-be96-e5eee6fc33ef")
        assertThat(offer.creator()).contains("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
        assertThat(offer.remoteCreatedAt()).contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(offer.closedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(offer.sentAt()).contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(offer.startDate()).contains(OffsetDateTime.parse("2021-11-15T00:00:00Z"))
        assertThat(offer.status()).contains(Offer.OfferStatusEnum.DRAFT)
        assertThat(offer.remoteWasDeleted()).contains(true)
        assertThat(offer._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(offer.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(offer.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
