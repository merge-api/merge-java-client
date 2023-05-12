package dev.merge.api.models

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RemoteUserTest {

    @Test
    fun createRemoteUser() {
        val remoteUser =
            RemoteUser.builder()
                .id("b82302de-852e-4e60-b050-edf9da3b7c02")
                .remoteId("344321")
                .firstName("Shensi")
                .lastName("Ding")
                .email("hello@merge.dev")
                .disabled(true)
                .remoteCreatedAt(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
                .accessRole(RemoteUser.AccessRoleEnum.SUPER_ADMIN)
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
        assertThat(remoteUser).isNotNull
        assertThat(remoteUser.id()).contains("b82302de-852e-4e60-b050-edf9da3b7c02")
        assertThat(remoteUser.remoteId()).contains("344321")
        assertThat(remoteUser.firstName()).contains("Shensi")
        assertThat(remoteUser.lastName()).contains("Ding")
        assertThat(remoteUser.email()).contains("hello@merge.dev")
        assertThat(remoteUser.disabled()).contains(true)
        assertThat(remoteUser.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
        assertThat(remoteUser.accessRole()).contains(RemoteUser.AccessRoleEnum.SUPER_ADMIN)
        assertThat(remoteUser.remoteWasDeleted()).contains(true)
        assertThat(remoteUser._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(remoteUser.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(remoteUser.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
