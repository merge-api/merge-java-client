package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JobInterviewStageTest {

    @Test
    fun createJobInterviewStage() {
        val jobInterviewStage =
            JobInterviewStage.builder()
                .id("f9813dd5-e70b-484c-91d8-00acd6065b07")
                .remoteId("876556788")
                .name("Phone Screen")
                .job("ba7d9648-5316-4a80-8d73-4e636cef5a90")
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
        assertThat(jobInterviewStage).isNotNull
        assertThat(jobInterviewStage.id()).contains("f9813dd5-e70b-484c-91d8-00acd6065b07")
        assertThat(jobInterviewStage.remoteId()).contains("876556788")
        assertThat(jobInterviewStage.name()).contains("Phone Screen")
        assertThat(jobInterviewStage.job()).contains("ba7d9648-5316-4a80-8d73-4e636cef5a90")
        assertThat(jobInterviewStage.remoteWasDeleted()).contains(true)
        assertThat(jobInterviewStage._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(jobInterviewStage.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(jobInterviewStage.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
