package dev.merge.api.models.ticketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserTest {

    @Test
    fun createUser() {
        val user =
            User.builder()
                .id("17a54124-287f-494d-965e-3c5b330c9a68")
                .remoteId("19202938")
                .name("Gil Feig")
                .emailAddress("help@merge.dev")
                .isActive(true)
                .teams(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .avatar("https://merge.dev/user_profile_pic.png")
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
        assertThat(user).isNotNull
        assertThat(user.id()).contains("17a54124-287f-494d-965e-3c5b330c9a68")
        assertThat(user.remoteId()).contains("19202938")
        assertThat(user.name()).contains("Gil Feig")
        assertThat(user.emailAddress()).contains("help@merge.dev")
        assertThat(user.isActive()).contains(true)
        assertThat(user.teams().get()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(user.avatar()).contains("https://merge.dev/user_profile_pic.png")
        assertThat(user.remoteWasDeleted()).contains(true)
        assertThat(user._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(user.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(user.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
