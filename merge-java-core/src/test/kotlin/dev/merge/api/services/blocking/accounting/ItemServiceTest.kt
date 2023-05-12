package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.ItemListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ItemServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val itemService = client.accounting().items()
        val item =
            itemService.retrieve(
                ItemRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(ItemRetrieveParams.Expand.COMPANY))
                    .includeRemoteData(true)
                    .remoteFields(ItemRetrieveParams.RemoteFields.STATUS)
                    .showEnumOrigins(ItemRetrieveParams.ShowEnumOrigins.STATUS)
                    .build()
            )
        println(item)
        item.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val itemService = client.accounting().items()
        val paginatedItemList = itemService.list(ItemListParams.builder().build())
        println(paginatedItemList)
        paginatedItemList.results().forEach { it.validate() }
    }
}
