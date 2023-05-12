package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.TrackingCategoryListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TrackingCategoryServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val trackingCategoryService = client.accounting().trackingCategories()
        val trackingCategory =
            trackingCategoryService.retrieve(
                TrackingCategoryRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(TrackingCategoryRetrieveParams.Expand.COMPANY))
                    .includeRemoteData(true)
                    .remoteFields(TrackingCategoryRetrieveParams.RemoteFields.STATUS)
                    .showEnumOrigins(TrackingCategoryRetrieveParams.ShowEnumOrigins.STATUS)
                    .build()
            )
        println(trackingCategory)
        trackingCategory.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val trackingCategoryService = client.accounting().trackingCategories()
        val paginatedTrackingCategoryList =
            trackingCategoryService.list(TrackingCategoryListParams.builder().build())
        println(paginatedTrackingCategoryList)
        paginatedTrackingCategoryList.results().forEach { it.validate() }
    }
}
