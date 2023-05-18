package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JournalEntryTest {

    @Test
    fun createJournalEntry() {
        val journalEntry =
            JournalEntry.builder()
                .transactionDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .remoteCreatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .remoteUpdatedAt(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .payments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .memo("Weekly Payment")
                .currency(JournalEntry.CurrencyEnum.XUA)
                .exchangeRate("2.9")
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                .lines(
                    listOf(
                        JournalEntry.JournalLine.builder()
                            .remoteId("121222")
                            .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                            .netAmount(42.23)
                            .trackingCategory("d25d609b-945f-4762-b55a-1c8fb220c43c")
                            .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .contact("d2d5ea3c-b032-11ec-b909-0242ac120002")
                            .description("Cash payment for lunch")
                            .exchangeRate("2.9")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .remoteWasDeleted(true)
                .postingStatus(JournalEntry.PostingStatusEnum.UNPOSTED)
                .id("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
                .remoteId("088899")
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
                .build()
        assertThat(journalEntry).isNotNull
        assertThat(journalEntry.transactionDate())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(journalEntry.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(journalEntry.remoteUpdatedAt())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(journalEntry.payments().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(journalEntry.memo()).contains("Weekly Payment")
        assertThat(journalEntry.currency()).contains(JournalEntry.CurrencyEnum.XUA)
        assertThat(journalEntry.exchangeRate()).contains("2.9")
        assertThat(journalEntry.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(journalEntry.lines().get())
            .containsExactly(
                JournalEntry.JournalLine.builder()
                    .remoteId("121222")
                    .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                    .netAmount(42.23)
                    .trackingCategory("d25d609b-945f-4762-b55a-1c8fb220c43c")
                    .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .contact("d2d5ea3c-b032-11ec-b909-0242ac120002")
                    .description("Cash payment for lunch")
                    .exchangeRate("2.9")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(journalEntry.trackingCategories().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(journalEntry.remoteWasDeleted()).contains(true)
        assertThat(journalEntry.postingStatus()).contains(JournalEntry.PostingStatusEnum.UNPOSTED)
        assertThat(journalEntry.id()).contains("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
        assertThat(journalEntry.remoteId()).contains("088899")
        assertThat(journalEntry._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(journalEntry.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(journalEntry.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
