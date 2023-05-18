package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BankInfoTest {

    @Test
    fun createBankInfo() {
        val bankInfo =
            BankInfo.builder()
                .id("fd1e0fb5-8f92-4ec9-9f32-179cf732867d")
                .remoteId("123234")
                .employee("a3617eb4-dfe3-426f-921e-a65fc1661e10")
                .accountNumber("439291590")
                .routingNumber("089690059")
                .bankName("Chase")
                .accountType(BankInfo.AccountTypeEnum.SAVINGS)
                .remoteCreatedAt(OffsetDateTime.parse("2021-12-06T10:11:26Z"))
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
        assertThat(bankInfo).isNotNull
        assertThat(bankInfo.id()).contains("fd1e0fb5-8f92-4ec9-9f32-179cf732867d")
        assertThat(bankInfo.remoteId()).contains("123234")
        assertThat(bankInfo.employee()).contains("a3617eb4-dfe3-426f-921e-a65fc1661e10")
        assertThat(bankInfo.accountNumber()).contains("439291590")
        assertThat(bankInfo.routingNumber()).contains("089690059")
        assertThat(bankInfo.bankName()).contains("Chase")
        assertThat(bankInfo.accountType()).contains(BankInfo.AccountTypeEnum.SAVINGS)
        assertThat(bankInfo.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2021-12-06T10:11:26Z"))
        assertThat(bankInfo.remoteWasDeleted()).contains(true)
        assertThat(bankInfo._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(bankInfo.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(bankInfo.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
