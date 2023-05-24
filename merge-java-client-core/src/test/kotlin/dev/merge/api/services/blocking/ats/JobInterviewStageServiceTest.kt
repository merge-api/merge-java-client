package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import dev.merge.api.models.ats.JobInterviewStageListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class JobInterviewStageServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val jobInterviewStageService = client.ats().jobInterviewStages()
        val jobInterviewStage =
            jobInterviewStageService.retrieve(
                JobInterviewStageRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(JobInterviewStageRetrieveParams.Expand.JOB))
                    .includeRemoteData(true)
                    .build()
            )
        println(jobInterviewStage)
        jobInterviewStage.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val jobInterviewStageService = client.ats().jobInterviewStages()
        val paginatedJobInterviewStageList =
            jobInterviewStageService.list(JobInterviewStageListParams.builder().build())
        println(paginatedJobInterviewStageList)
        paginatedJobInterviewStageList.results().forEach { it.validate() }
    }
}
