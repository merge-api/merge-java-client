package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EngagementTypeTest {

    @Test
    fun createEngagementType() {
        val engagementType =
            EngagementType.builder()
                .activityType(EngagementType.ActivityTypeEnum.CALL)
                .name("First Call")
                .id("03455bc6-6040-430a-848e-aafacbfdf4fg")
                .remoteId("19202938")
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .remoteFields(
                    listOf(
                        EngagementType.RemoteField.builder()
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
        assertThat(engagementType).isNotNull
        assertThat(engagementType.activityType()).contains(EngagementType.ActivityTypeEnum.CALL)
        assertThat(engagementType.name()).contains("First Call")
        assertThat(engagementType.id()).contains("03455bc6-6040-430a-848e-aafacbfdf4fg")
        assertThat(engagementType.remoteId()).contains("19202938")
        assertThat(engagementType.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(engagementType.remoteFields().get())
            .containsExactly(
                EngagementType.RemoteField.builder()
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
