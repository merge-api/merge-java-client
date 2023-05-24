package dev.merge.api.models.fileStorage

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GroupTest {

    @Test
    fun createGroup() {
        val group =
            Group.builder()
                .id("21ce474c-asdf-34a2-754r-629f799f7d12")
                .remoteId("340")
                .name("Platform")
                .users(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
        assertThat(group).isNotNull
        assertThat(group.id()).contains("21ce474c-asdf-34a2-754r-629f799f7d12")
        assertThat(group.remoteId()).contains("340")
        assertThat(group.name()).contains("Platform")
        assertThat(group.users()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(group._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(group.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(group.remoteData().get()).containsExactly(JsonString.of("abc"))
    }
}
