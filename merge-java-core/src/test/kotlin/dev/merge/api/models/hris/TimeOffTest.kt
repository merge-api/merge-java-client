package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TimeOffTest {

    @Test
    fun createTimeOff() {
        val timeOff =
            TimeOff.builder()
                .id("91b2b905-e866-40c8-8be2-efe53827a0aa")
                .remoteId("19202938")
                .employee("d2f972d0-2526-434b-9409-4c3b468e08f0")
                .approver("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                .status(TimeOff.TimeOffStatusEnum.REQUESTED)
                .employeeNote("Moving into the new apartment Kendall Roy gave me!")
                .units(TimeOff.UnitsEnum.HOURS)
                .amount(42.23)
                .requestType(TimeOff.RequestTypeEnum.VACATION)
                .startTime(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
                .endTime(OffsetDateTime.parse("2020-11-17T00:00:00Z"))
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
        assertThat(timeOff).isNotNull
        assertThat(timeOff.id()).contains("91b2b905-e866-40c8-8be2-efe53827a0aa")
        assertThat(timeOff.remoteId()).contains("19202938")
        assertThat(timeOff.employee()).contains("d2f972d0-2526-434b-9409-4c3b468e08f0")
        assertThat(timeOff.approver()).contains("9efbc633-3387-4306-aa55-e2c635e6bb4f")
        assertThat(timeOff.status()).contains(TimeOff.TimeOffStatusEnum.REQUESTED)
        assertThat(timeOff.employeeNote())
            .contains("Moving into the new apartment Kendall Roy gave me!")
        assertThat(timeOff.units()).contains(TimeOff.UnitsEnum.HOURS)
        assertThat(timeOff.amount()).contains(42.23)
        assertThat(timeOff.requestType()).contains(TimeOff.RequestTypeEnum.VACATION)
        assertThat(timeOff.startTime()).contains(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
        assertThat(timeOff.endTime()).contains(OffsetDateTime.parse("2020-11-17T00:00:00Z"))
        assertThat(timeOff.remoteWasDeleted()).contains(true)
        assertThat(timeOff._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(timeOff.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(timeOff.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
