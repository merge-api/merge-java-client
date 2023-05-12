package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import dev.merge.api.models.ats.OfferListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class OfferServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val offerService = client.ats().offers()
        val offer =
            offerService.retrieve(
                OfferRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(OfferRetrieveParams.Expand.APPLICATION))
                    .includeRemoteData(true)
                    .remoteFields(OfferRetrieveParams.RemoteFields.STATUS)
                    .showEnumOrigins(OfferRetrieveParams.ShowEnumOrigins.STATUS)
                    .build()
            )
        println(offer)
        offer.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val offerService = client.ats().offers()
        val paginatedOfferList = offerService.list(OfferListParams.builder().build())
        println(paginatedOfferList)
        paginatedOfferList.results().forEach { it.validate() }
    }
}
