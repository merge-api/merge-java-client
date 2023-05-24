package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TaskTest {

    @Test
    fun createTask() {
        val task =
            Task.builder()
                .subject("Contact about Integration Strategy")
                .content("Follow up to see whether they need integrations")
                .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .completedDate(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
                .dueDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                .status(Task.TaskStatusEnum.OPEN)
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
                        Task.RemoteField.builder()
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
        assertThat(task).isNotNull
        assertThat(task.subject()).contains("Contact about Integration Strategy")
        assertThat(task.content()).contains("Follow up to see whether they need integrations")
        assertThat(task.owner()).contains("0358cbc6-2040-430a-848e-aafacbadf3aa")
        assertThat(task.account()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(task.completedDate()).contains(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
        assertThat(task.dueDate()).contains(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
        assertThat(task.status()).contains(Task.TaskStatusEnum.OPEN)
        assertThat(task.remoteWasDeleted()).contains(true)
        assertThat(task.id()).contains("03455bc6-6040-430a-848e-aafacbfdf4fg")
        assertThat(task.remoteId()).contains("19202938")
        assertThat(task._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(task.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(task.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
        assertThat(task.remoteFields().get())
            .containsExactly(
                Task.RemoteField.builder()
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
