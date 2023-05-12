package dev.merge.api.models.marketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TemplateTest {

    @Test
    fun createTemplate() {
        val template =
            Template.builder()
                .name("Welcome Email Template")
                .type(Template.TypeEnum.EMAIL)
                .contents("Welcome onboard! Stay connected and find out more.")
                .owner("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .remoteCreatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                .remoteUpdatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                .remoteWasDeleted(true)
                .id("4958cbc6-4874-430a-475r-aafacbadd5ty")
                .remoteId("40")
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
        assertThat(template).isNotNull
        assertThat(template.name()).contains("Welcome Email Template")
        assertThat(template.type()).contains(Template.TypeEnum.EMAIL)
        assertThat(template.contents())
            .contains("Welcome onboard! Stay connected and find out more.")
        assertThat(template.owner()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(template.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
        assertThat(template.remoteUpdatedAt())
            .contains(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
        assertThat(template.remoteWasDeleted()).contains(true)
        assertThat(template.id()).contains("4958cbc6-4874-430a-475r-aafacbadd5ty")
        assertThat(template.remoteId()).contains("40")
        assertThat(template._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(template.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(template.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
