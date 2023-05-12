package dev.merge.api.models.ticketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketResponseTest {

    @Test
    fun createTicketResponse() {
        val ticketResponse =
            TicketResponse.builder()
                .model(
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
                                    "organization_defined_targets" to
                                        mapOf("custom_key" to "custom_value"),
                                    "linked_account_defined_targets" to
                                        mapOf("custom_key" to "custom_value")
                                )
                            )
                        )
                        .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                        .remoteData(
                            listOf(
                                RemoteData.builder()
                                    .path("string")
                                    .data(JsonString.of("abc"))
                                    .build()
                            )
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
                )
                .warnings(
                    listOf(
                        ValidationWarning.builder()
                            .source(
                                ValidationWarning.ValidationProblemSource.builder()
                                    .pointer("string")
                                    .build()
                            )
                            .title("Unrecognized Field")
                            .detail("An unrecognized field, age, was passed in with request data.")
                            .problemType("UNRECOGNIZED_FIELD")
                            .build()
                    )
                )
                .errors(
                    listOf(
                        ValidationError.builder()
                            .source(
                                ValidationError.ValidationProblemSource.builder()
                                    .pointer("string")
                                    .build()
                            )
                            .title("Missing Required Field")
                            .detail("custom_fields is a required field on model.")
                            .problemType("MISSING_REQUIRED_FIELD")
                            .build()
                    )
                )
                .logs(
                    listOf(
                        DebugLog.builder()
                            .logId("99433219-8017-4acd-bb3c-ceb23d663832")
                            .dashboardView(
                                "https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832"
                            )
                            .logSummary(
                                DebugLog.DebugModelLogSummary.builder()
                                    .url("https://harvest.greenhouse.io/v1/candidates/")
                                    .method("POST")
                                    .statusCode(123L)
                                    .build()
                            )
                            .build()
                    )
                )
                .build()
        assertThat(ticketResponse).isNotNull
        assertThat(ticketResponse.model())
            .isEqualTo(
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
                                "organization_defined_targets" to
                                    mapOf("custom_key" to "custom_value"),
                                "linked_account_defined_targets" to
                                    mapOf("custom_key" to "custom_value")
                            )
                        )
                    )
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .remoteData(
                        listOf(
                            RemoteData.builder().path("string").data(JsonString.of("abc")).build()
                        )
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
            )
        assertThat(ticketResponse.warnings())
            .containsExactly(
                ValidationWarning.builder()
                    .source(
                        ValidationWarning.ValidationProblemSource.builder()
                            .pointer("string")
                            .build()
                    )
                    .title("Unrecognized Field")
                    .detail("An unrecognized field, age, was passed in with request data.")
                    .problemType("UNRECOGNIZED_FIELD")
                    .build()
            )
        assertThat(ticketResponse.errors())
            .containsExactly(
                ValidationError.builder()
                    .source(
                        ValidationError.ValidationProblemSource.builder().pointer("string").build()
                    )
                    .title("Missing Required Field")
                    .detail("custom_fields is a required field on model.")
                    .problemType("MISSING_REQUIRED_FIELD")
                    .build()
            )
        assertThat(ticketResponse.logs().get())
            .containsExactly(
                DebugLog.builder()
                    .logId("99433219-8017-4acd-bb3c-ceb23d663832")
                    .dashboardView(
                        "https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832"
                    )
                    .logSummary(
                        DebugLog.DebugModelLogSummary.builder()
                            .url("https://harvest.greenhouse.io/v1/candidates/")
                            .method("POST")
                            .statusCode(123L)
                            .build()
                    )
                    .build()
            )
    }
}
