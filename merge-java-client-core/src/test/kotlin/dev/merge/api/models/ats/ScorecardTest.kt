package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ScorecardTest {

    @Test
    fun createScorecard() {
        val scorecard =
            Scorecard.builder()
                .id("3eab2f17-eeb1-450d-97f0-029d8be1e06f")
                .remoteId("22234")
                .application("2872ba14-4084-492b-be96-e5eee6fc33ef")
                .interview("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                .interviewer("bbb519a3-246e-4b95-b6b3-dba16107ba6b")
                .remoteCreatedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                .submittedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                .overallRecommendation(Scorecard.OverallRecommendationEnum.DEFINITELY_NO)
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
        assertThat(scorecard).isNotNull
        assertThat(scorecard.id()).contains("3eab2f17-eeb1-450d-97f0-029d8be1e06f")
        assertThat(scorecard.remoteId()).contains("22234")
        assertThat(scorecard.application()).contains("2872ba14-4084-492b-be96-e5eee6fc33ef")
        assertThat(scorecard.interview()).contains("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
        assertThat(scorecard.interviewer()).contains("bbb519a3-246e-4b95-b6b3-dba16107ba6b")
        assertThat(scorecard.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(scorecard.submittedAt()).contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(scorecard.overallRecommendation())
            .contains(Scorecard.OverallRecommendationEnum.DEFINITELY_NO)
        assertThat(scorecard.remoteWasDeleted()).contains(true)
        assertThat(scorecard._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(scorecard.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(scorecard.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
