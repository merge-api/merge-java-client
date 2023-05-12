package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import dev.merge.api.models.hris.PayrollRunListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class PayrollRunServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val payrollRunService = client.hris().payrollRuns()
        val payrollRun =
            payrollRunService.retrieve(
                PayrollRunRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .remoteFields(PayrollRunRetrieveParams.RemoteFields.RUN_STATE)
                    .showEnumOrigins(PayrollRunRetrieveParams.ShowEnumOrigins.RUN_STATE)
                    .build()
            )
        println(payrollRun)
        payrollRun.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val payrollRunService = client.hris().payrollRuns()
        val paginatedPayrollRunList = payrollRunService.list(PayrollRunListParams.builder().build())
        println(paginatedPayrollRunList)
        paginatedPayrollRunList.results().forEach { it.validate() }
    }
}
