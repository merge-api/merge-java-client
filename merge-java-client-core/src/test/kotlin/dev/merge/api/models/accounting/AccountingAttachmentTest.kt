package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountingAttachmentTest {

    @Test
    fun createAccountingAttachment() {
        val accountingAttachment =
            AccountingAttachment.builder()
                .id("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
                .remoteId("1018270")
                .fileName("invoice.png")
                .fileUrl("https://merge-brand.s3.amazonaws.com/20210315/rect-logo-270x80%402x.png")
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
        assertThat(accountingAttachment).isNotNull
        assertThat(accountingAttachment.id()).contains("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
        assertThat(accountingAttachment.remoteId()).contains("1018270")
        assertThat(accountingAttachment.fileName()).contains("invoice.png")
        assertThat(accountingAttachment.fileUrl())
            .contains("https://merge-brand.s3.amazonaws.com/20210315/rect-logo-270x80%402x.png")
        assertThat(accountingAttachment.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(accountingAttachment.remoteWasDeleted()).contains(true)
        assertThat(accountingAttachment._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(accountingAttachment.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(accountingAttachment.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
