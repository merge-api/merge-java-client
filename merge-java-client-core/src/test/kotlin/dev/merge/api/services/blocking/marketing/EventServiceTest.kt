package dev.merge.api.services.blocking.marketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.marketing.*
import dev.merge.api.models.marketing.EventListContactsParams
import dev.merge.api.models.marketing.EventListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EventServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val eventService = client.marketing().events()
        val event =
            eventService.retrieve(
                EventRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .build()
            )
        println(event)
        event.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val eventService = client.marketing().events()
        val paginatedEventList = eventService.list(EventListParams.builder().build())
        println(paginatedEventList)
        paginatedEventList.results().forEach { it.validate() }
    }

    @Test
    fun callListContacts() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val eventService = client.marketing().events()
        val paginatedContactList =
            eventService.listContacts(
                EventListContactsParams.builder()
                    .parentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(paginatedContactList)
        paginatedContactList.results().forEach { it.validate() }
    }
}
