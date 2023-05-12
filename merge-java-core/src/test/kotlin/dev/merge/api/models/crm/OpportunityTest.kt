package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OpportunityTest {

    @Test
    fun createOpportunity() {
        val opportunity =
            Opportunity.builder()
                .name("Needs Integrations")
                .description("Needs a Unified API for Integrations!")
                .amount(123L)
                .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                .stage("1968cbc6-6040-430a-848e-aafacbadf4ad")
                .status(Opportunity.OpportunityStatusEnum.OPEN)
                .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                .closeDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
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
                        Opportunity.RemoteField.builder()
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
        assertThat(opportunity).isNotNull
        assertThat(opportunity.name()).contains("Needs Integrations")
        assertThat(opportunity.description()).contains("Needs a Unified API for Integrations!")
        assertThat(opportunity.amount()).contains(123L)
        assertThat(opportunity.owner()).contains("0358cbc6-2040-430a-848e-aafacbadf3aa")
        assertThat(opportunity.account()).contains("0958cbc6-6040-430a-848e-aafacbadf4ae")
        assertThat(opportunity.stage()).contains("1968cbc6-6040-430a-848e-aafacbadf4ad")
        assertThat(opportunity.status()).contains(Opportunity.OpportunityStatusEnum.OPEN)
        assertThat(opportunity.lastActivityAt())
            .contains(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
        assertThat(opportunity.closeDate()).contains(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
        assertThat(opportunity.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2021-11-10T00:00:00Z"))
        assertThat(opportunity.remoteWasDeleted()).contains(true)
        assertThat(opportunity.id()).contains("03455bc6-6040-430a-848e-aafacbfdf4fg")
        assertThat(opportunity.remoteId()).contains("19202938")
        assertThat(opportunity._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(opportunity.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(opportunity.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
        assertThat(opportunity.remoteFields().get())
            .containsExactly(
                Opportunity.RemoteField.builder()
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
