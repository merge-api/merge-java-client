package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NoteTest {

    @Test
    fun createNote() {
        val note =
            Note.builder()
                .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                .content("Merge is hiring!")
                .contact("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .opportunity("754a244e-dd67-4731-a8d3-9bff9dc10465")
                .remoteUpdatedAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                .remoteCreatedAt(OffsetDateTime.parse("2021-11-10T00:00:00Z"))
                .remoteWasDeleted(true)
                .id("03455bc6-6040-430a-848e-aafacbfdf4fg")
                .remoteId("19202938")
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
                .remoteFields(
                    listOf(
                        Note.RemoteField.builder()
                            .remoteFieldClass(
                                RemoteFieldClass.builder()
                                    .id("string")
                                    .displayName("string")
                                    .remoteKeyName("string")
                                    .description("string")
                                    .isCustom(true)
                                    .isRequired(true)
                                    .fieldType(RemoteFieldClass.FieldTypeEnum.STRING)
                                    .fieldFormat(RemoteFieldClass.FieldFormatEnum.STRING)
                                    .fieldChoices(listOf("string"))
                                    .itemSchema(
                                        RemoteFieldClass.ItemSchema.builder()
                                            .itemType(JsonString.of("abc"))
                                            .itemFormat(JsonString.of("abc"))
                                            .itemChoices(listOf("string"))
                                            .build()
                                    )
                                    .build()
                            )
                            .value(JsonString.of("abc"))
                            .build()
                    )
                )
                .build()
        assertThat(note).isNotNull
        assertThat(note.owner()).contains("0358cbc6-2040-430a-848e-aafacbadf3aa")
        assertThat(note.content()).contains("Merge is hiring!")
        assertThat(note.contact()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(note.account()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(note.opportunity()).contains("754a244e-dd67-4731-a8d3-9bff9dc10465")
        assertThat(note.remoteUpdatedAt()).contains(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
        assertThat(note.remoteCreatedAt()).contains(OffsetDateTime.parse("2021-11-10T00:00:00Z"))
        assertThat(note.remoteWasDeleted()).contains(true)
        assertThat(note.id()).contains("03455bc6-6040-430a-848e-aafacbfdf4fg")
        assertThat(note.remoteId()).contains("19202938")
        assertThat(note._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(note.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(note.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
        assertThat(note.remoteFields().get())
            .containsExactly(
                Note.RemoteField.builder()
                    .remoteFieldClass(
                        RemoteFieldClass.builder()
                            .id("string")
                            .displayName("string")
                            .remoteKeyName("string")
                            .description("string")
                            .isCustom(true)
                            .isRequired(true)
                            .fieldType(RemoteFieldClass.FieldTypeEnum.STRING)
                            .fieldFormat(RemoteFieldClass.FieldFormatEnum.STRING)
                            .fieldChoices(listOf("string"))
                            .itemSchema(
                                RemoteFieldClass.ItemSchema.builder()
                                    .itemType(JsonString.of("abc"))
                                    .itemFormat(JsonString.of("abc"))
                                    .itemChoices(listOf("string"))
                                    .build()
                            )
                            .build()
                    )
                    .value(JsonString.of("abc"))
                    .build()
            )
    }
}
