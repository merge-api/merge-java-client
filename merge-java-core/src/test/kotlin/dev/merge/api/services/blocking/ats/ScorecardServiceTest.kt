package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import dev.merge.api.models.ats.ScorecardListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ScorecardServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val scorecardService = client.ats().scorecards()
        val scorecard =
            scorecardService.retrieve(
                ScorecardRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(ScorecardRetrieveParams.Expand.APPLICATION))
                    .includeRemoteData(true)
                    .remoteFields(ScorecardRetrieveParams.RemoteFields.OVERALL_RECOMMENDATION)
                    .showEnumOrigins(ScorecardRetrieveParams.ShowEnumOrigins.OVERALL_RECOMMENDATION)
                    .build()
            )
        println(scorecard)
        scorecard.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val scorecardService = client.ats().scorecards()
        val paginatedScorecardList = scorecardService.list(ScorecardListParams.builder().build())
        println(paginatedScorecardList)
        paginatedScorecardList.results().forEach { it.validate() }
    }
}
