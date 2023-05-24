package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.CreditNoteListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CreditNoteServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val creditNoteService = client.accounting().creditNotes()
        val creditNote =
            creditNoteService.retrieve(
                CreditNoteRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(CreditNoteRetrieveParams.Expand.LINE_ITEMS))
                    .includeRemoteData(true)
                    .remoteFields(CreditNoteRetrieveParams.RemoteFields.STATUS)
                    .showEnumOrigins(CreditNoteRetrieveParams.ShowEnumOrigins.STATUS)
                    .build()
            )
        println(creditNote)
        creditNote.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val creditNoteService = client.accounting().creditNotes()
        val paginatedCreditNoteList = creditNoteService.list(CreditNoteListParams.builder().build())
        println(paginatedCreditNoteList)
        paginatedCreditNoteList.results().forEach { it.validate() }
    }
}
