package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import dev.merge.api.models.ats.JobListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class JobServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val jobService = client.ats().jobs()
        val job =
            jobService.retrieve(
                JobRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(JobRetrieveParams.Expand.DEPARTMENTS))
                    .includeRemoteData(true)
                    .remoteFields(JobRetrieveParams.RemoteFields.STATUS)
                    .showEnumOrigins(JobRetrieveParams.ShowEnumOrigins.STATUS)
                    .build()
            )
        println(job)
        job.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val jobService = client.ats().jobs()
        val paginatedJobList = jobService.list(JobListParams.builder().build())
        println(paginatedJobList)
        paginatedJobList.results().forEach { it.validate() }
    }
}
