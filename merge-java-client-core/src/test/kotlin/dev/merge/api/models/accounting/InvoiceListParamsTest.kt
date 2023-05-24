package dev.merge.api.models.accounting

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InvoiceListParamsTest {

    @Test
    fun createInvoiceListParams() {
        InvoiceListParams.builder()
            .companyId("string")
            .contactId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .expand(listOf(InvoiceListParams.Expand.COMPANY))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .issueDateAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .issueDateBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .remoteFields(InvoiceListParams.RemoteFields.TYPE)
            .remoteId("string")
            .showEnumOrigins(InvoiceListParams.ShowEnumOrigins.TYPE)
            .type(InvoiceListParams.Type.ACCOUNTS_PAYABLE)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            InvoiceListParams.builder()
                .companyId("string")
                .contactId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .expand(listOf(InvoiceListParams.Expand.COMPANY))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .issueDateAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .issueDateBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .remoteFields(InvoiceListParams.RemoteFields.TYPE)
                .remoteId("string")
                .showEnumOrigins(InvoiceListParams.ShowEnumOrigins.TYPE)
                .type(InvoiceListParams.Type.ACCOUNTS_PAYABLE)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("company_id", listOf("string"))
        expected.put("contact_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(InvoiceListParams.Expand.COMPANY.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("issue_date_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("issue_date_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put("remote_fields", listOf(InvoiceListParams.RemoteFields.TYPE.toString()))
        expected.put("remote_id", listOf("string"))
        expected.put("show_enum_origins", listOf(InvoiceListParams.ShowEnumOrigins.TYPE.toString()))
        expected.put("type", listOf(InvoiceListParams.Type.ACCOUNTS_PAYABLE.toString()))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = InvoiceListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
