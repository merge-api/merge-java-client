package dev.merge.api.models

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TeamTest {

    @Test
    fun createTeam() {
        val team =
            Team.builder()
                .id("17a54124-287f-494d-965e-3c5b330c9a68")
                .remoteId("19202938")
                .name("Platform")
                .parentTeam("1b998423-db0a-4037-a4cf-f79c60cb67b3")
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
                .description("Platform and Integrations Team")
                .build()
        assertThat(team).isNotNull
        assertThat(team.id()).contains("17a54124-287f-494d-965e-3c5b330c9a68")
        assertThat(team.remoteId()).contains("19202938")
        assertThat(team.name()).contains("Platform")
        assertThat(team.parentTeam()).contains("1b998423-db0a-4037-a4cf-f79c60cb67b3")
        assertThat(team.remoteWasDeleted()).contains(true)
        assertThat(team._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(team.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(team.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
        assertThat(team.description()).contains("Platform and Integrations Team")
    }
}
