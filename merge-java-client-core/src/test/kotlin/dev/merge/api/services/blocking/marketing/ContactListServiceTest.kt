package dev.merge.api.services.blocking.marketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.marketing.*
import dev.merge.api.models.marketing.ContactListListParams
import dev.merge.api.models.marketing.ContactListListSubscribersParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ContactListServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val contactListService = client.marketing().contactLists()
        val contactListCreateResponse =
            contactListService.create(
                ContactListCreateParams.builder()
                    .model(
                        ContactListCreateParams.ListRequest.builder()
                            .name("New Customer List")
                            .type("Static")
                            .integrationParams(
                                JsonValue.from(
                                    mapOf(
                                        "unique_integration_field" to
                                            "unique_integration_field_value"
                                    )
                                )
                            )
                            .linkedAccountParams(
                                JsonValue.from(
                                    mapOf(
                                        "unique_linked_account_field" to
                                            "unique_linked_account_field_value"
                                    )
                                )
                            )
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(contactListCreateResponse)
        contactListCreateResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val contactListService = client.marketing().contactLists()
        val contactList =
            contactListService.retrieve(
                ContactListRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .build()
            )
        println(contactList)
        contactList.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val contactListService = client.marketing().contactLists()
        val paginatedListList = contactListService.list(ContactListListParams.builder().build())
        println(paginatedListList)
        paginatedListList.results().forEach { it.validate() }
    }

    @Test
    fun callListSubscribers() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val contactListService = client.marketing().contactLists()
        val paginatedContactList =
            contactListService.listSubscribers(
                ContactListListSubscribersParams.builder()
                    .parentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(paginatedContactList)
        paginatedContactList.results().forEach { it.validate() }
    }
}
