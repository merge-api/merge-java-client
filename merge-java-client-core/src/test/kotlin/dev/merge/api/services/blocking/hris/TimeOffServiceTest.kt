package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import dev.merge.api.models.hris.TimeOffListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TimeOffServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val timeOffService = client.hris().timeOff()
        val timeOffResponse =
            timeOffService.create(
                TimeOffCreateParams.builder()
                    .model(
                        TimeOffCreateParams.TimeOffRequest.builder()
                            .employee("d2f972d0-2526-434b-9409-4c3b468e08f0")
                            .approver("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                            .status(TimeOffCreateParams.TimeOffRequest.TimeOffStatusEnum.REQUESTED)
                            .employeeNote("Moving into the new apartment Kendall Roy gave me!")
                            .units(TimeOffCreateParams.TimeOffRequest.UnitsEnum.HOURS)
                            .amount(42.23)
                            .requestType(
                                TimeOffCreateParams.TimeOffRequest.RequestTypeEnum.VACATION
                            )
                            .startTime(OffsetDateTime.parse("2020-11-10T00:00:00Z"))
                            .endTime(OffsetDateTime.parse("2020-11-17T00:00:00Z"))
                            .integrationParams(
                                JsonValue.from(
                                    mapOf(
                                        "unique_integration_field" to
                                            "unique_integration_field_value"
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
            )
        println(timeOffResponse)
        timeOffResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val timeOffService = client.hris().timeOff()
        val timeOff =
            timeOffService.retrieve(
                TimeOffRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(TimeOffRetrieveParams.Expand.APPROVER))
                    .includeRemoteData(true)
                    .remoteFields(TimeOffRetrieveParams.RemoteFields.REQUEST_TYPE)
                    .showEnumOrigins(TimeOffRetrieveParams.ShowEnumOrigins.REQUEST_TYPE)
                    .build()
            )
        println(timeOff)
        timeOff.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val timeOffService = client.hris().timeOff()
        val paginatedTimeOffList = timeOffService.list(TimeOffListParams.builder().build())
        println(paginatedTimeOffList)
        paginatedTimeOffList.results().forEach { it.validate() }
    }
}
