package dev.merge.api.models.ticketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProjectTest {

    @Test
    fun createProject() {
        val project =
            Project.builder()
                .id("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
                .remoteId("19202938")
                .name("Q1 Platform")
                .description("For tracking all tasks related to Platform for Q1")
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
        assertThat(project).isNotNull
        assertThat(project.id()).contains("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
        assertThat(project.remoteId()).contains("19202938")
        assertThat(project.name()).contains("Q1 Platform")
        assertThat(project.description())
            .contains("For tracking all tasks related to Platform for Q1")
        assertThat(project.remoteWasDeleted()).contains(true)
        assertThat(project._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(project.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(project.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
