package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TimeOffBalanceTest {

    @Test
    fun createTimeOffBalance() {
        val timeOffBalance =
            TimeOffBalance.builder()
                .id("91b2b905-e866-40c8-8be2-efe53827a0aa")
                .remoteId("19202938")
                .employee("d2f972d0-2526-434b-9409-4c3b468e08f0")
                .balance(42.23)
                .used(42.23)
                .policyType(TimeOffBalance.PolicyTypeEnum.VACATION)
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
        assertThat(timeOffBalance).isNotNull
        assertThat(timeOffBalance.id()).contains("91b2b905-e866-40c8-8be2-efe53827a0aa")
        assertThat(timeOffBalance.remoteId()).contains("19202938")
        assertThat(timeOffBalance.employee()).contains("d2f972d0-2526-434b-9409-4c3b468e08f0")
        assertThat(timeOffBalance.balance()).contains(42.23)
        assertThat(timeOffBalance.used()).contains(42.23)
        assertThat(timeOffBalance.policyType()).contains(TimeOffBalance.PolicyTypeEnum.VACATION)
        assertThat(timeOffBalance.remoteWasDeleted()).contains(true)
        assertThat(timeOffBalance._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(timeOffBalance.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(timeOffBalance.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
