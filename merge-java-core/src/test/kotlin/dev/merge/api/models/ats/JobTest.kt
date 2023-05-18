package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JobTest {

    @Test
    fun createJob() {
        val job =
            Job.builder()
                .id("022a2bef-57e5-4def-8ed2-7c41bd9a5ed8")
                .remoteId("8765432")
                .name("Software Engineer (Merge is actually hiring btw)")
                .description(
                    "<b>If you're reading this documentation, you might be a good fit for Merge!</b>"
                )
                .code("C0025")
                .status(Job.JobStatusEnum.OPEN)
                .jobPostingUrls(
                    listOf(
                        Job.Url.builder()
                            .value("http://alturl.com/p749b")
                            .urlType(Job.Url.UrlTypeEnum.PERSONAL)
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .remoteCreatedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                .remoteUpdatedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .confidential(true)
                .departments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .offices(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .hiringManagers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .recruiters(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .remoteWasDeleted(true)
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
        assertThat(job).isNotNull
        assertThat(job.id()).contains("022a2bef-57e5-4def-8ed2-7c41bd9a5ed8")
        assertThat(job.remoteId()).contains("8765432")
        assertThat(job.name()).contains("Software Engineer (Merge is actually hiring btw)")
        assertThat(job.description())
            .contains(
                "<b>If you're reading this documentation, you might be a good fit for Merge!</b>"
            )
        assertThat(job.code()).contains("C0025")
        assertThat(job.status()).contains(Job.JobStatusEnum.OPEN)
        assertThat(job.jobPostingUrls().get())
            .containsExactly(
                Job.Url.builder()
                    .value("http://alturl.com/p749b")
                    .urlType(Job.Url.UrlTypeEnum.PERSONAL)
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(job.remoteCreatedAt()).contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(job.remoteUpdatedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(job.confidential()).contains(true)
        assertThat(job.departments().get()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(job.offices().get()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(job.hiringManagers().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(job.recruiters().get()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(job.remoteWasDeleted()).contains(true)
        assertThat(job._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(job.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(job.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
