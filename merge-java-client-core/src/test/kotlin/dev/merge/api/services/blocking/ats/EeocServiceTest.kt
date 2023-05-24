package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import dev.merge.api.models.ats.EeocListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EeocServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val eeocService = client.ats().eeocs()
        val eeoc =
            eeocService.retrieve(
                EeocRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(EeocRetrieveParams.Expand.CANDIDATE))
                    .includeRemoteData(true)
                    .remoteFields(EeocRetrieveParams.RemoteFields.DISABILITY_STATUS)
                    .showEnumOrigins(EeocRetrieveParams.ShowEnumOrigins.DISABILITY_STATUS)
                    .build()
            )
        println(eeoc)
        eeoc.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val eeocService = client.ats().eeocs()
        val paginatedEeocList = eeocService.list(EeocListParams.builder().build())
        println(paginatedEeocList)
        paginatedEeocList.results().forEach { it.validate() }
    }
}
