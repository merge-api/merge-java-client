package dev.merge.api.models.crm

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
                .email("merge_is_hiring@merge.dev")
                .isActive(true)
                .remoteWasDeleted(true)
                .id("0358cbc6-2040-430a-848e-aafacbadf3aa")
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
                        User.RemoteField.builder()
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
        assertThat(user).isNotNull
        assertThat(user.name()).contains("Gil Feig")
        assertThat(user.email()).contains("merge_is_hiring@merge.dev")
        assertThat(user.isActive()).contains(true)
        assertThat(user.remoteWasDeleted()).contains(true)
        assertThat(user.id()).contains("0358cbc6-2040-430a-848e-aafacbadf3aa")
        assertThat(user.remoteId()).contains("19202938")
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
        assertThat(user.remoteFields().get())
            .containsExactly(
                User.RemoteField.builder()
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
