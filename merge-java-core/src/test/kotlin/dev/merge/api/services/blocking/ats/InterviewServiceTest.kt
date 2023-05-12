package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import dev.merge.api.models.ats.InterviewListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class InterviewServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val interviewService = client.ats().interviews()
        val scheduledInterviewResponse =
            interviewService.create(
                InterviewCreateParams.builder()
                    .model(
                        InterviewCreateParams.ScheduledInterviewRequest.builder()
                            .application("92e8a369-fffe-430d-b93a-f7e8a16563f1")
                            .jobInterviewStage("2f7adb59-3fe6-4b5b-aef6-563f72bd13dc")
                            .organizer("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                            .interviewers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .location("Embarcadero Center 2")
                            .startAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                            .endAt(OffsetDateTime.parse("2021-10-15T02:00:00Z"))
                            .status(
                                InterviewCreateParams.ScheduledInterviewRequest
                                    .ScheduledInterviewStatusEnum
                                    .SCHEDULED
                            )
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
                    .remoteUserId("string")
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(scheduledInterviewResponse)
        scheduledInterviewResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val interviewService = client.ats().interviews()
        val scheduledInterview =
            interviewService.retrieve(
                InterviewRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(InterviewRetrieveParams.Expand.APPLICATION))
                    .includeRemoteData(true)
                    .remoteFields(InterviewRetrieveParams.RemoteFields.STATUS)
                    .showEnumOrigins(InterviewRetrieveParams.ShowEnumOrigins.STATUS)
                    .build()
            )
        println(scheduledInterview)
        scheduledInterview.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val interviewService = client.ats().interviews()
        val paginatedScheduledInterviewList =
            interviewService.list(InterviewListParams.builder().build())
        println(paginatedScheduledInterviewList)
        paginatedScheduledInterviewList.results().forEach { it.validate() }
    }
}
