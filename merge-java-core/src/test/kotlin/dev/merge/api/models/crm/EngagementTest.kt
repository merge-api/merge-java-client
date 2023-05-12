package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EngagementTest {

    @Test
    fun createEngagement() {
        val engagement =
            Engagement.builder()
                .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                .content("Call for negotiation")
                .subject("Call from customer")
                .direction(Engagement.DirectionEnum.INBOUND)
                .engagementType("0358cbc6-2040-430a-848e-aafacbadf3aa")
                .startTime(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                .endTime(OffsetDateTime.parse("2022-02-10T00:05:00Z"))
                .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .contacts(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
                        Engagement.RemoteField.builder()
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
        assertThat(engagement).isNotNull
        assertThat(engagement.owner()).contains("0358cbc6-2040-430a-848e-aafacbadf3aa")
        assertThat(engagement.content()).contains("Call for negotiation")
        assertThat(engagement.subject()).contains("Call from customer")
        assertThat(engagement.direction()).contains(Engagement.DirectionEnum.INBOUND)
        assertThat(engagement.engagementType()).contains("0358cbc6-2040-430a-848e-aafacbadf3aa")
        assertThat(engagement.startTime()).contains(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
        assertThat(engagement.endTime()).contains(OffsetDateTime.parse("2022-02-10T00:05:00Z"))
        assertThat(engagement.account()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(engagement.contacts().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(engagement.remoteWasDeleted()).contains(true)
        assertThat(engagement.id()).contains("03455bc6-6040-430a-848e-aafacbfdf4fg")
        assertThat(engagement.remoteId()).contains("19202938")
        assertThat(engagement._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(engagement.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(engagement.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
        assertThat(engagement.remoteFields().get())
            .containsExactly(
                Engagement.RemoteField.builder()
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
