package dev.merge.api.models.marketing

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
                .name("Gil Feig")
                .username("gilfeig")
                .email("merge_is_hiring@merge.dev")
                .role(User.RoleEnum.ADMIN)
                .timezone("New York/EST")
                .remoteWasDeleted(true)
                .id("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .remoteId("1")
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
        assertThat(user.name()).contains("Gil Feig")
        assertThat(user.username()).contains("gilfeig")
        assertThat(user.email()).contains("merge_is_hiring@merge.dev")
        assertThat(user.role()).contains(User.RoleEnum.ADMIN)
        assertThat(user.timezone()).contains("New York/EST")
        assertThat(user.remoteWasDeleted()).contains(true)
        assertThat(user.id()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(user.remoteId()).contains("1")
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
