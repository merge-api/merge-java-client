package dev.merge.api.models.hris

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
                .id("134e0111-0f67-44f6-98f0-597000290bb3")
                .remoteId("800293")
                .parentGroup("2ef51b11-2c4e-4b02-8d1d-50592d9e96ef")
                .name("COST_CENTER_US")
                .type(Group.GroupTypeEnum.TEAM)
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
        assertThat(group).isNotNull
        assertThat(group.id()).contains("134e0111-0f67-44f6-98f0-597000290bb3")
        assertThat(group.remoteId()).contains("800293")
        assertThat(group.parentGroup()).contains("2ef51b11-2c4e-4b02-8d1d-50592d9e96ef")
        assertThat(group.name()).contains("COST_CENTER_US")
        assertThat(group.type()).contains(Group.GroupTypeEnum.TEAM)
        assertThat(group.remoteWasDeleted()).contains(true)
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
        assertThat(group.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
