package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import dev.merge.api.models.hris.EmploymentListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EmploymentServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val employmentService = client.hris().employments()
        val employment =
            employmentService.retrieve(
                EmploymentRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(EmploymentRetrieveParams.Expand.EMPLOYEE))
                    .includeRemoteData(true)
                    .remoteFields(EmploymentRetrieveParams.RemoteFields.EMPLOYMENT_TYPE)
                    .showEnumOrigins(EmploymentRetrieveParams.ShowEnumOrigins.EMPLOYMENT_TYPE)
                    .build()
            )
        println(employment)
        employment.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val employmentService = client.hris().employments()
        val paginatedEmploymentList = employmentService.list(EmploymentListParams.builder().build())
        println(paginatedEmploymentList)
        paginatedEmploymentList.results().forEach { it.validate() }
    }
}
