package dev.merge.api.models.ticketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketTest {

    @Test
    fun createTicket() {
        val ticket =
            Ticket.builder()
                .id("0958cbc6-6040-430a-848e-aafacbadf4ae")
                .remoteId("19202938")
                .name("Please add more integrations")
                .assignees(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .creator("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .dueDate(OffsetDateTime.parse("2022-10-11T00:00:00Z"))
                .status(Ticket.TicketStatusEnum.OPEN)
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
                .remoteCreatedAt(OffsetDateTime.parse("2021-11-10T00:00:00Z"))
                .remoteUpdatedAt(OffsetDateTime.parse("2021-12-09T00:00:00Z"))
                .completedAt(OffsetDateTime.parse("2021-12-09T00:00:00Z"))
                .remoteWasDeleted(true)
                .ticketUrl("https://thirdpartysoftware.com/project/3/issue/1")
                .priority(Ticket.PriorityEnum.URGENT)
                .fieldMappings(
                    JsonValue.from(
                        mapOf(
                            "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                            "linked_account_defined_targets" to
                                mapOf("custom_key" to "custom_value")
                        )
                    )
                )
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .remoteData(
                    listOf(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
                )
                .remoteFields(
                    listOf(
                        Ticket.RemoteField.builder()
                            .remoteFieldClass(
                                RemoteFieldClass.builder()
                                    .id("string")
                                    .displayName("string")
                                    .remoteKeyName("string")
                                    .description("string")
                                    .isCustom(true)
                                    .isRequired(true)
                                    .fieldType(RemoteFieldClass.FieldTypeEnum.STRING)
                                    .fieldFormat(RemoteFieldClass.FieldFormatEnum.STRING)
                                    .fieldChoices(listOf("string"))
                                    .itemSchema(
                                        RemoteFieldClass.ItemSchema.builder()
                                            .itemType(JsonString.of("abc"))
                                            .itemFormat(JsonString.of("abc"))
                                            .itemChoices(listOf("string"))
                                            .build()
                                    )
                                    .build()
                            )
                            .value(JsonString.of("abc"))
                            .build()
                    )
                )
                .build()
        assertThat(ticket).isNotNull
        assertThat(ticket.id()).contains("0958cbc6-6040-430a-848e-aafacbadf4ae")
        assertThat(ticket.remoteId()).contains("19202938")
        assertThat(ticket.name()).contains("Please add more integrations")
        assertThat(ticket.assignees().get()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ticket.creator()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ticket.dueDate()).contains(OffsetDateTime.parse("2022-10-11T00:00:00Z"))
        assertThat(ticket.status()).contains(Ticket.TicketStatusEnum.OPEN)
        assertThat(ticket.description())
            .contains("Can you please add more integrations? It'll make syncing data much easier!")
        assertThat(ticket.project()).contains("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
        assertThat(ticket.collections().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ticket.ticketType()).contains("incident")
        assertThat(ticket.account()).contains("0958cbc6-6040-430a-848e-aafacbadf4ae")
        assertThat(ticket.contact()).contains("65c345ba-6870-4974-87ba-dd31509c367a")
        assertThat(ticket.parentTicket()).contains("75b33d04-30d2-4f3e-be45-27838bc94342")
        assertThat(ticket.attachments().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ticket.tags().get()).containsExactly("string")
        assertThat(ticket.remoteCreatedAt()).contains(OffsetDateTime.parse("2021-11-10T00:00:00Z"))
        assertThat(ticket.remoteUpdatedAt()).contains(OffsetDateTime.parse("2021-12-09T00:00:00Z"))
        assertThat(ticket.completedAt()).contains(OffsetDateTime.parse("2021-12-09T00:00:00Z"))
        assertThat(ticket.remoteWasDeleted()).contains(true)
        assertThat(ticket.ticketUrl()).contains("https://thirdpartysoftware.com/project/3/issue/1")
        assertThat(ticket.priority()).contains(Ticket.PriorityEnum.URGENT)
        assertThat(ticket._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(ticket.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(ticket.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
        assertThat(ticket.remoteFields().get())
            .containsExactly(
                Ticket.RemoteField.builder()
                    .remoteFieldClass(
                        RemoteFieldClass.builder()
                            .id("string")
                            .displayName("string")
                            .remoteKeyName("string")
                            .description("string")
                            .isCustom(true)
                            .isRequired(true)
                            .fieldType(RemoteFieldClass.FieldTypeEnum.STRING)
                            .fieldFormat(RemoteFieldClass.FieldFormatEnum.STRING)
                            .fieldChoices(listOf("string"))
                            .itemSchema(
                                RemoteFieldClass.ItemSchema.builder()
                                    .itemType(JsonString.of("abc"))
                                    .itemFormat(JsonString.of("abc"))
                                    .itemChoices(listOf("string"))
                                    .build()
                            )
                            .build()
                    )
                    .value(JsonString.of("abc"))
                    .build()
            )
    }
}
