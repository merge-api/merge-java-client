package dev.merge.api.models.crm

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IssueListParamsTest {

    @Test
    fun createIssueListParams() {
        IssueListParams.builder()
            .accountToken("string")
            .cursor("string")
            .endDate("string")
            .endUserOrganizationName("string")
            .firstIncidentTimeAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .firstIncidentTimeBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .includeMuted("string")
            .integrationName("string")
            .lastIncidentTimeAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .lastIncidentTimeBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .startDate("string")
            .status(IssueListParams.Status.ONGOING)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            IssueListParams.builder()
                .accountToken("string")
                .cursor("string")
                .endDate("string")
                .endUserOrganizationName("string")
                .firstIncidentTimeAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .firstIncidentTimeBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .includeMuted("string")
                .integrationName("string")
                .lastIncidentTimeAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .lastIncidentTimeBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .startDate("string")
                .status(IssueListParams.Status.ONGOING)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("account_token", listOf("string"))
        expected.put("cursor", listOf("string"))
        expected.put("end_date", listOf("string"))
        expected.put("end_user_organization_name", listOf("string"))
        expected.put("first_incident_time_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("first_incident_time_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("include_muted", listOf("string"))
        expected.put("integration_name", listOf("string"))
        expected.put("last_incident_time_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("last_incident_time_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put("start_date", listOf("string"))
        expected.put("status", listOf(IssueListParams.Status.ONGOING.toString()))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = IssueListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
