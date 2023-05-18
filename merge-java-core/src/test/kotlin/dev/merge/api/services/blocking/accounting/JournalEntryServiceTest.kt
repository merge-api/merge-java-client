package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.JournalEntryListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class JournalEntryServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val journalEntryService = client.accounting().journalEntries()
        val journalEntryResponse =
            journalEntryService.create(
                JournalEntryCreateParams.builder()
                    .model(
                        JournalEntryCreateParams.JournalEntryRequest.builder()
                            .transactionDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .payments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .memo("string")
                            .currency(JournalEntryCreateParams.JournalEntryRequest.CurrencyEnum.XUA)
                            .exchangeRate("string")
                            .company("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .lines(
                                listOf(
                                    JournalEntryCreateParams.JournalEntryRequest.JournalLineRequest
                                        .builder()
                                        .remoteId("121222")
                                        .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                                        .netAmount(42.23)
                                        .trackingCategory("d25d609b-945f-4762-b55a-1c8fb220c43c")
                                        .trackingCategories(
                                            listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                        )
                                        .contact("d2d5ea3c-b032-11ec-b909-0242ac120002")
                                        .description("Cash payment for lunch")
                                        .exchangeRate("2.9")
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
                            )
                            .postingStatus(
                                JournalEntryCreateParams.JournalEntryRequest.PostingStatusEnum
                                    .UNPOSTED
                            )
                            .integrationParams(JsonString.of("abc"))
                            .linkedAccountParams(JsonString.of("abc"))
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(journalEntryResponse)
        journalEntryResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val journalEntryService = client.accounting().journalEntries()
        val journalEntry =
            journalEntryService.retrieve(
                JournalEntryRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(JournalEntryRetrieveParams.Expand.COMPANY))
                    .includeRemoteData(true)
                    .build()
            )
        println(journalEntry)
        journalEntry.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val journalEntryService = client.accounting().journalEntries()
        val paginatedJournalEntryList =
            journalEntryService.list(JournalEntryListParams.builder().build())
        println(paginatedJournalEntryList)
        paginatedJournalEntryList.results().forEach { it.validate() }
    }
}
