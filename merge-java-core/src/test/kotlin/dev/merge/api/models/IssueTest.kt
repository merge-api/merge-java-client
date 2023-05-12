package dev.merge.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IssueTest {

    @Test
    fun createIssue() {
        val issue =
            Issue.builder()
                .id("3fa85f64-5717-4562-b3fc-2c963f66afa6")
                .status(Issue.IssueStatusEnum.ONGOING)
                .errorDescription("string")
                .endUser("string")
                .firstIncidentTime(OffsetDateTime.parse("2022-12-05T16:19:15.161Z"))
                .lastIncidentTime(OffsetDateTime.parse("2022-12-05T16:19:15.161Z"))
                .isMuted(true)
                .errorDetails(listOf("string"))
                .build()
        assertThat(issue).isNotNull
        assertThat(issue.id()).contains("3fa85f64-5717-4562-b3fc-2c963f66afa6")
        assertThat(issue.status()).contains(Issue.IssueStatusEnum.ONGOING)
        assertThat(issue.errorDescription()).isEqualTo("string")
        assertThat(issue.endUser()).contains("string")
        assertThat(issue.firstIncidentTime())
            .contains(OffsetDateTime.parse("2022-12-05T16:19:15.161Z"))
        assertThat(issue.lastIncidentTime())
            .contains(OffsetDateTime.parse("2022-12-05T16:19:15.161Z"))
        assertThat(issue.isMuted()).contains(true)
        assertThat(issue.errorDetails().get()).containsExactly("string")
    }
}
