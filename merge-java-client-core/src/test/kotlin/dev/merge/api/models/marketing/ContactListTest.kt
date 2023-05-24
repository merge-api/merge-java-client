package dev.merge.api.models.marketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ContactListTest {

    @Test
    fun createContactList() {
        val contactList =
            ContactList.builder()
                .name("New Customer List")
                .type("Static")
                .remoteCreatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                .remoteUpdatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                .remoteWasDeleted(true)
                .id("4747cbc6-6040-430a-475r-aafacbadrt36")
                .remoteId("25")
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
        assertThat(contactList).isNotNull
        assertThat(contactList.name()).contains("New Customer List")
        assertThat(contactList.type()).contains("Static")
        assertThat(contactList.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
        assertThat(contactList.remoteUpdatedAt())
            .contains(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
        assertThat(contactList.remoteWasDeleted()).contains(true)
        assertThat(contactList.id()).contains("4747cbc6-6040-430a-475r-aafacbadrt36")
        assertThat(contactList.remoteId()).contains("25")
        assertThat(contactList._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(contactList.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(contactList.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
