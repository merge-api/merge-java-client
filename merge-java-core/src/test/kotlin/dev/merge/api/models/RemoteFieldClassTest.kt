package dev.merge.api.models

import dev.merge.api.core.JsonString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RemoteFieldClassTest {

    @Test
    fun createRemoteFieldClass() {
        val remoteFieldClass =
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
        assertThat(remoteFieldClass).isNotNull
        assertThat(remoteFieldClass.id()).contains("string")
        assertThat(remoteFieldClass.displayName()).contains("string")
        assertThat(remoteFieldClass.remoteKeyName()).contains("string")
        assertThat(remoteFieldClass.description()).contains("string")
        assertThat(remoteFieldClass.isCustom()).contains(true)
        assertThat(remoteFieldClass.isRequired()).contains(true)
        assertThat(remoteFieldClass.fieldType()).contains(RemoteFieldClass.FieldTypeEnum.STRING)
        assertThat(remoteFieldClass.fieldFormat()).contains(RemoteFieldClass.FieldFormatEnum.STRING)
        assertThat(remoteFieldClass.fieldChoices().get()).containsExactly("string")
        assertThat(remoteFieldClass.itemSchema())
            .contains(
                RemoteFieldClass.ItemSchema.builder()
                    .itemType(JsonString.of("abc"))
                    .itemFormat(JsonString.of("abc"))
                    .itemChoices(listOf("string"))
                    .build()
            )
    }
}
