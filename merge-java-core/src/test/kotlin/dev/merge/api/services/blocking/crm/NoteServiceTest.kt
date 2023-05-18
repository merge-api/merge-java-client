package dev.merge.api.services.blocking.crm

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.NoteListParams
import dev.merge.api.models.crm.NoteListRemoteFieldClassesParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class NoteServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val noteService = client.crm().notes()
        val noteResponse =
            noteService.create(
                NoteCreateParams.builder()
                    .model(
                        NoteCreateParams.NoteRequest.builder()
                            .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                            .content("Merge is hiring!")
                            .contact("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                            .account("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                            .opportunity("754a244e-dd67-4731-a8d3-9bff9dc10465")
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
                                    NoteCreateParams.NoteRequest.RemoteFieldRequest.builder()
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
        println(noteResponse)
        noteResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val noteService = client.crm().notes()
        val note =
            noteService.retrieve(
                NoteRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(NoteRetrieveParams.Expand.ACCOUNT))
                    .includeRemoteData(true)
                    .includeRemoteFields(true)
                    .build()
            )
        println(note)
        note.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val noteService = client.crm().notes()
        val paginatedNoteList = noteService.list(NoteListParams.builder().build())
        println(paginatedNoteList)
        paginatedNoteList.results().forEach { it.validate() }
    }

    @Test
    fun callListRemoteFieldClasses() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val noteService = client.crm().notes()
        val paginatedRemoteFieldClassList =
            noteService.listRemoteFieldClasses(NoteListRemoteFieldClassesParams.builder().build())
        println(paginatedRemoteFieldClassList)
        paginatedRemoteFieldClassList.results().forEach { it.validate() }
    }
}
