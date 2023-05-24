package dev.merge.api.models.ticketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CollectionTest {

    @Test
    fun createCollection() {
        val collection =
            Collection.builder()
                .id("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
                .remoteId("19202938")
                .name("Q1 Platform")
                .description("For tracking all tasks related to Platform for Q1")
                .collectionType(Collection.CollectionTypeEnum.LIST)
                .parentCollection("25782302-5be1-4d78-8f46-2a5db72204ef")
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
        assertThat(collection).isNotNull
        assertThat(collection.id()).contains("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
        assertThat(collection.remoteId()).contains("19202938")
        assertThat(collection.name()).contains("Q1 Platform")
        assertThat(collection.description())
            .contains("For tracking all tasks related to Platform for Q1")
        assertThat(collection.collectionType()).contains(Collection.CollectionTypeEnum.LIST)
        assertThat(collection.parentCollection()).contains("25782302-5be1-4d78-8f46-2a5db72204ef")
        assertThat(collection.remoteWasDeleted()).contains(true)
        assertThat(collection._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(collection.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(collection.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
