package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import dev.merge.api.models.ats.RejectReasonListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class RejectReasonServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val rejectReasonService = client.ats().rejectReasons()
        val rejectReason =
            rejectReasonService.retrieve(
                RejectReasonRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .build()
            )
        println(rejectReason)
        rejectReason.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val rejectReasonService = client.ats().rejectReasons()
        val paginatedRejectReasonList =
            rejectReasonService.list(RejectReasonListParams.builder().build())
        println(paginatedRejectReasonList)
        paginatedRejectReasonList.results().forEach { it.validate() }
    }
}
