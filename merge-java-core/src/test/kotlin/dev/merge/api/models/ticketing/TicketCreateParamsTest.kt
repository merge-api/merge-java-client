package dev.merge.api.models.ticketing

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketCreateParamsTest {

    @Test
    fun createTicketCreateParams() {
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
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
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
                                    "unique_integration_field" to "unique_integration_field_value"
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
        val expected = mutableMapOf<String, List<String>>()
        expected.put("is_debug_mode", listOf("true"))
        expected.put("run_async", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            TicketCreateParams.builder()
                .model(TicketCreateParams.TicketRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
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
                                    "unique_integration_field" to "unique_integration_field_value"
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
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
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
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            TicketCreateParams.builder()
                .model(TicketCreateParams.TicketRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(TicketCreateParams.TicketRequest.builder().build())
    }
}
