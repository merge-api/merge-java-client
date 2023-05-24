package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import dev.merge.api.models.hris.TimeOffBalanceListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TimeOffBalanceServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val timeOffBalanceService = client.hris().timeOffBalances()
        val timeOffBalance =
            timeOffBalanceService.retrieve(
                TimeOffBalanceRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(TimeOffBalanceRetrieveParams.Expand.EMPLOYEE))
                    .includeRemoteData(true)
                    .remoteFields(TimeOffBalanceRetrieveParams.RemoteFields.POLICY_TYPE)
                    .showEnumOrigins(TimeOffBalanceRetrieveParams.ShowEnumOrigins.POLICY_TYPE)
                    .build()
            )
        println(timeOffBalance)
        timeOffBalance.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val timeOffBalanceService = client.hris().timeOffBalances()
        val paginatedTimeOffBalanceList =
            timeOffBalanceService.list(TimeOffBalanceListParams.builder().build())
        println(paginatedTimeOffBalanceList)
        paginatedTimeOffBalanceList.results().forEach { it.validate() }
    }
}
