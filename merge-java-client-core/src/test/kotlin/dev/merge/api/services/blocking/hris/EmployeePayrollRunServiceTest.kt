package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import dev.merge.api.models.hris.EmployeePayrollRunListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EmployeePayrollRunServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val employeePayrollRunService = client.hris().employeePayrollRuns()
        val employeePayrollRun =
            employeePayrollRunService.retrieve(
                EmployeePayrollRunRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(EmployeePayrollRunRetrieveParams.Expand.EMPLOYEE))
                    .includeRemoteData(true)
                    .build()
            )
        println(employeePayrollRun)
        employeePayrollRun.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val employeePayrollRunService = client.hris().employeePayrollRuns()
        val paginatedEmployeePayrollRunList =
            employeePayrollRunService.list(EmployeePayrollRunListParams.builder().build())
        println(paginatedEmployeePayrollRunList)
        paginatedEmployeePayrollRunList.results().forEach { it.validate() }
    }
}
