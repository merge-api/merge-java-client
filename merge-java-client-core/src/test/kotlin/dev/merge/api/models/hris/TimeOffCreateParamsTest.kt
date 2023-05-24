package dev.merge.api.models.hris

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TimeOffCreateParamsTest {

    @Test
    fun createTimeOffCreateParams() {
        TimeOffCreateParams.builder()
            .model(
                TimeOffCreateParams.TimeOffRequest.builder()
                    .employee("d2f972d0-2526-434b-9409-4c3b468e08f0")
                    .approver("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                    .status(TimeOffCreateParams.TimeOffRequest.TimeOffStatusEnum.REQUESTED)
                    .employeeNote("Moving into the new apartment Kendall Roy gave me!")
                    .units(TimeOffCreateParams.TimeOffRequest.UnitsEnum.HOURS)
                    .amount(42.23)
                    .requestType(TimeOffCreateParams.TimeOffRequest.RequestTypeEnum.VACATION)
                    .startTime(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
                    .endTime(OffsetDateTime.parse("2020-11-17T00:00:00Z"))
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            TimeOffCreateParams.builder()
                .model(
                    TimeOffCreateParams.TimeOffRequest.builder()
                        .employee("d2f972d0-2526-434b-9409-4c3b468e08f0")
                        .approver("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                        .status(TimeOffCreateParams.TimeOffRequest.TimeOffStatusEnum.REQUESTED)
                        .employeeNote("Moving into the new apartment Kendall Roy gave me!")
                        .units(TimeOffCreateParams.TimeOffRequest.UnitsEnum.HOURS)
                        .amount(42.23)
                        .requestType(TimeOffCreateParams.TimeOffRequest.RequestTypeEnum.VACATION)
                        .startTime(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
                        .endTime(OffsetDateTime.parse("2020-11-17T00:00:00Z"))
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
                        .build()
                )
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("is_debug_mode", listOf("true"))
        expected.put("run_async", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            TimeOffCreateParams.builder()
                .model(TimeOffCreateParams.TimeOffRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            TimeOffCreateParams.builder()
                .model(
                    TimeOffCreateParams.TimeOffRequest.builder()
                        .employee("d2f972d0-2526-434b-9409-4c3b468e08f0")
                        .approver("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                        .status(TimeOffCreateParams.TimeOffRequest.TimeOffStatusEnum.REQUESTED)
                        .employeeNote("Moving into the new apartment Kendall Roy gave me!")
                        .units(TimeOffCreateParams.TimeOffRequest.UnitsEnum.HOURS)
                        .amount(42.23)
                        .requestType(TimeOffCreateParams.TimeOffRequest.RequestTypeEnum.VACATION)
                        .startTime(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
                        .endTime(OffsetDateTime.parse("2020-11-17T00:00:00Z"))
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
                        .build()
                )
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                TimeOffCreateParams.TimeOffRequest.builder()
                    .employee("d2f972d0-2526-434b-9409-4c3b468e08f0")
                    .approver("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                    .status(TimeOffCreateParams.TimeOffRequest.TimeOffStatusEnum.REQUESTED)
                    .employeeNote("Moving into the new apartment Kendall Roy gave me!")
                    .units(TimeOffCreateParams.TimeOffRequest.UnitsEnum.HOURS)
                    .amount(42.23)
                    .requestType(TimeOffCreateParams.TimeOffRequest.RequestTypeEnum.VACATION)
                    .startTime(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
                    .endTime(OffsetDateTime.parse("2020-11-17T00:00:00Z"))
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            TimeOffCreateParams.builder()
                .model(TimeOffCreateParams.TimeOffRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(TimeOffCreateParams.TimeOffRequest.builder().build())
    }
}
