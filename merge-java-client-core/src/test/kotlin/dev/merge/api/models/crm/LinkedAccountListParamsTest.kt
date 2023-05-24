package dev.merge.api.models.crm

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LinkedAccountListParamsTest {

    @Test
    fun createLinkedAccountListParams() {
        LinkedAccountListParams.builder()
            .category(LinkedAccountListParams.Category.ACCOUNTING)
            .cursor("string")
            .endUserEmailAddress("string")
            .endUserOrganizationName("string")
            .endUserOriginId("string")
            .endUserOriginIds("string")
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .ids("string")
            .includeDuplicates(true)
            .integrationName("string")
            .isTestAccount("string")
            .pageSize(123L)
            .status("string")
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            LinkedAccountListParams.builder()
                .category(LinkedAccountListParams.Category.ACCOUNTING)
                .cursor("string")
                .endUserEmailAddress("string")
                .endUserOrganizationName("string")
                .endUserOriginId("string")
                .endUserOriginIds("string")
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .ids("string")
                .includeDuplicates(true)
                .integrationName("string")
                .isTestAccount("string")
                .pageSize(123L)
                .status("string")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("category", listOf(LinkedAccountListParams.Category.ACCOUNTING.toString()))
        expected.put("cursor", listOf("string"))
        expected.put("end_user_email_address", listOf("string"))
        expected.put("end_user_organization_name", listOf("string"))
        expected.put("end_user_origin_id", listOf("string"))
        expected.put("end_user_origin_ids", listOf("string"))
        expected.put("id", listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        expected.put("ids", listOf("string"))
        expected.put("include_duplicates", listOf("true"))
        expected.put("integration_name", listOf("string"))
        expected.put("is_test_account", listOf("string"))
        expected.put("page_size", listOf("123"))
        expected.put("status", listOf("string"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = LinkedAccountListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
