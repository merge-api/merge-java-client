package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import dev.merge.api.models.ats.ApplicationListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ApplicationServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val applicationService = client.ats().applications()
        val applicationResponse =
            applicationService.create(
                ApplicationCreateParams.builder()
                    .model(
                        ApplicationCreateParams.ApplicationRequest.builder()
                            .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                            .job("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                            .appliedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                            .rejectedAt(OffsetDateTime.parse("2021-11-15T00:00:00Z"))
                            .source("Campus recruiting event")
                            .creditedTo("58166795-8d68-4b30-9bfb-bfd402479484")
                            .currentStage("d578dfdc-7b0a-4ab6-a2b0-4b40f20eb9ea")
                            .rejectReason("59b25f2b-da02-40f5-9656-9fa0db555784")
                            .remoteTemplateId("92830948203")
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
        println(applicationResponse)
        applicationResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val applicationService = client.ats().applications()
        val application =
            applicationService.retrieve(
                ApplicationRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(ApplicationRetrieveParams.Expand.CANDIDATE))
                    .includeRemoteData(true)
                    .build()
            )
        println(application)
        application.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val applicationService = client.ats().applications()
        val paginatedApplicationList =
            applicationService.list(ApplicationListParams.builder().build())
        println(paginatedApplicationList)
        paginatedApplicationList.results().forEach { it.validate() }
    }

    @Test
    fun callChangeStage() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val applicationService = client.ats().applications()
        val applicationResponse =
            applicationService.changeStage(
                ApplicationChangeStageParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .jobInterviewStage("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .remoteUserId("x")
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(applicationResponse)
        applicationResponse.validate()
    }
}
