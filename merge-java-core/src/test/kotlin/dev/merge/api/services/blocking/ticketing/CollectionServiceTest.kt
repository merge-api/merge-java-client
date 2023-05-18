package dev.merge.api.services.blocking.ticketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ticketing.*
import dev.merge.api.models.ticketing.CollectionListParams
import dev.merge.api.models.ticketing.CollectionListUsersParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CollectionServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val collectionService = client.ticketing().collections()
        val collection =
            collectionService.retrieve(
                CollectionRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(CollectionRetrieveParams.Expand.PARENT_COLLECTION))
                    .includeRemoteData(true)
                    .remoteFields(CollectionRetrieveParams.RemoteFields.COLLECTION_TYPE)
                    .showEnumOrigins(CollectionRetrieveParams.ShowEnumOrigins.COLLECTION_TYPE)
                    .build()
            )
        println(collection)
        collection.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val collectionService = client.ticketing().collections()
        val paginatedCollectionList = collectionService.list(CollectionListParams.builder().build())
        println(paginatedCollectionList)
        paginatedCollectionList.results().forEach { it.validate() }
    }

    @Test
    fun callListUsers() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val collectionService = client.ticketing().collections()
        val ticketingPaginatedUserList =
            collectionService.listUsers(
                CollectionListUsersParams.builder()
                    .parentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(ticketingPaginatedUserList)
        ticketingPaginatedUserList.results().forEach { it.validate() }
    }
}
