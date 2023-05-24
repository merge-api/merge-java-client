package dev.merge.api.models.fileStorage

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
                .id("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .remoteId("14")
                .name("Max Gong")
                .emailAddress("max.gong@gmail.com")
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
                .remoteData(listOf(JsonString.of("abc")))
                .build()
        assertThat(user).isNotNull
        assertThat(user.id()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(user.remoteId()).contains("14")
        assertThat(user.name()).contains("Max Gong")
        assertThat(user.emailAddress()).contains("max.gong@gmail.com")
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
        assertThat(user.remoteData().get()).containsExactly(JsonString.of("abc"))
    }
}
