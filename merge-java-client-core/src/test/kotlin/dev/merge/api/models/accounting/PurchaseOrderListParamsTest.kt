package dev.merge.api.models.accounting

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PurchaseOrderListParamsTest {

    @Test
    fun createPurchaseOrderListParams() {
        PurchaseOrderListParams.builder()
            .companyId("string")
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .expand(listOf(PurchaseOrderListParams.Expand.COMPANY))
            .includeDeletedData(true)
            .includeRemoteData(true)
            .issueDateAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .issueDateBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .remoteFields(PurchaseOrderListParams.RemoteFields.STATUS)
            .remoteId("string")
            .showEnumOrigins(PurchaseOrderListParams.ShowEnumOrigins.STATUS)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            PurchaseOrderListParams.builder()
                .companyId("string")
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .expand(listOf(PurchaseOrderListParams.Expand.COMPANY))
                .includeDeletedData(true)
                .includeRemoteData(true)
                .issueDateAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .issueDateBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .remoteFields(PurchaseOrderListParams.RemoteFields.STATUS)
                .remoteId("string")
                .showEnumOrigins(PurchaseOrderListParams.ShowEnumOrigins.STATUS)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("company_id", listOf("string"))
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("expand", listOf(PurchaseOrderListParams.Expand.COMPANY.toString()))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("issue_date_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("issue_date_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put(
            "remote_fields",
            listOf(PurchaseOrderListParams.RemoteFields.STATUS.toString())
        )
        expected.put("remote_id", listOf("string"))
        expected.put(
            "show_enum_origins",
            listOf(PurchaseOrderListParams.ShowEnumOrigins.STATUS.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = PurchaseOrderListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
