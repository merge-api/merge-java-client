package dev.merge.api.models.accounting

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CreditNoteListParamsTest {

    @Test
    fun createCreditNoteListParams() {
        CreditNoteListParams.builder()
            .companyId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .expand(listOf(CreditNoteListParams.Expand.LINE_ITEMS))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .remoteFields(CreditNoteListParams.RemoteFields.STATUS)
            .remoteId("string")
            .showEnumOrigins(CreditNoteListParams.ShowEnumOrigins.STATUS)
            .transactionDateAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .transactionDateBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            CreditNoteListParams.builder()
                .companyId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .expand(listOf(CreditNoteListParams.Expand.LINE_ITEMS))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .remoteFields(CreditNoteListParams.RemoteFields.STATUS)
                .remoteId("string")
                .showEnumOrigins(CreditNoteListParams.ShowEnumOrigins.STATUS)
                .transactionDateAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .transactionDateBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("company_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(CreditNoteListParams.Expand.LINE_ITEMS.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put("remote_fields", listOf(CreditNoteListParams.RemoteFields.STATUS.toString()))
        expected.put("remote_id", listOf("string"))
        expected.put(
            "show_enum_origins",
            listOf(CreditNoteListParams.ShowEnumOrigins.STATUS.toString())
        )
        expected.put("transaction_date_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("transaction_date_before", listOf("2019-12-27T18:11:19.117Z"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = CreditNoteListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
