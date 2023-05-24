package dev.merge.api.services.blocking.ticketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.ticketing.*
import dev.merge.api.models.ticketing.TicketListCollaboratorsParams
import dev.merge.api.models.ticketing.TicketListParams
import dev.merge.api.models.ticketing.TicketListRemoteFieldClassesParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TicketServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val ticketService = client.ticketing().tickets()
        val ticketResponse =
            ticketService.create(
                TicketCreateParams.builder()
                    .model(
                        TicketCreateParams.TicketRequest.builder()
                            .name("Please add more integrations")
                            .assignees(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .creator("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .dueDate(OffsetDateTime.parse("2022-10-11T00:00:00Z"))
                            .status(TicketCreateParams.TicketRequest.TicketStatusEnum.OPEN)
                            .description(
                                "Can you please add more integrations? It'll make syncing data much easier!"
                            )
                            .project("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
                            .collections(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .ticketType("incident")
                            .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                            .contact("65c345ba-6870-4974-87ba-dd31509c367a")
                            .parentTicket("75b33d04-30d2-4f3e-be45-27838bc94342")
                            .attachments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .tags(listOf("string"))
                            .completedAt(OffsetDateTime.parse("2021-12-09T00:00:00Z"))
                            .ticketUrl("https://thirdpartysoftware.com/project/3/issue/1")
                            .priority(TicketCreateParams.TicketRequest.PriorityEnum.URGENT)
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
                            .remoteFields(
                                listOf(
                                    TicketCreateParams.TicketRequest.RemoteFieldRequest.builder()
                                        .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                        .value(JsonString.of("abc"))
                                        .build()
                                )
                            )
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(ticketResponse)
        ticketResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val ticketService = client.ticketing().tickets()
        val ticket =
            ticketService.retrieve(
                TicketRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(TicketRetrieveParams.Expand.ACCOUNT))
                    .includeRemoteData(true)
                    .includeRemoteFields(true)
                    .remoteFields(TicketRetrieveParams.RemoteFields.PRIORITY)
                    .showEnumOrigins(TicketRetrieveParams.ShowEnumOrigins.PRIORITY)
                    .build()
            )
        println(ticket)
        ticket.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val ticketService = client.ticketing().tickets()
        val ticketResponse =
            ticketService.update(
                TicketUpdateParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .model(
                        TicketUpdateParams.PatchedTicketRequest.builder()
                            .name("Please add more integrations")
                            .assignees(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .creator("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .dueDate(OffsetDateTime.parse("2022-10-11T00:00:00Z"))
                            .status(TicketUpdateParams.PatchedTicketRequest.TicketStatusEnum.OPEN)
                            .description(
                                "Can you please add more integrations? It'll make syncing data much easier!"
                            )
                            .project("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
                            .collections(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .ticketType("incident")
                            .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                            .contact("65c345ba-6870-4974-87ba-dd31509c367a")
                            .parentTicket("75b33d04-30d2-4f3e-be45-27838bc94342")
                            .tags(listOf("string"))
                            .completedAt(OffsetDateTime.parse("2021-12-09T00:00:00Z"))
                            .ticketUrl("https://thirdpartysoftware.com/project/3/issue/1")
                            .priority(TicketUpdateParams.PatchedTicketRequest.PriorityEnum.URGENT)
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
                            .remoteFields(
                                listOf(
                                    TicketUpdateParams.PatchedTicketRequest.RemoteFieldRequest
                                        .builder()
                                        .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                        .value(JsonString.of("abc"))
                                        .build()
                                )
                            )
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(ticketResponse)
        ticketResponse.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val ticketService = client.ticketing().tickets()
        val paginatedTicketList = ticketService.list(TicketListParams.builder().build())
        println(paginatedTicketList)
        paginatedTicketList.results().forEach { it.validate() }
    }

    @Test
    fun callListCollaborators() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val ticketService = client.ticketing().tickets()
        val ticketingPaginatedUserList =
            ticketService.listCollaborators(
                TicketListCollaboratorsParams.builder()
                    .parentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(ticketingPaginatedUserList)
        ticketingPaginatedUserList.results().forEach { it.validate() }
    }

    @Test
    fun callListRemoteFieldClasses() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val ticketService = client.ticketing().tickets()
        val paginatedRemoteFieldClassList =
            ticketService.listRemoteFieldClasses(
                TicketListRemoteFieldClassesParams.builder().build()
            )
        println(paginatedRemoteFieldClassList)
        paginatedRemoteFieldClassList.results().forEach { it.validate() }
    }
}
