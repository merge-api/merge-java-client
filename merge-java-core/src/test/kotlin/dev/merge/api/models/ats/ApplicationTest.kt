package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest {

    @Test
    fun createApplication() {
        val application =
            Application.builder()
                .id("92e8a369-fffe-430d-b93a-f7e8a16563f1")
                .remoteId("98796")
                .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                .job("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                .appliedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                .rejectedAt(OffsetDateTime.parse("2021-11-15T00:00:00Z"))
                .source("Campus recruiting event")
                .creditedTo("58166795-8d68-4b30-9bfb-bfd402479484")
                .currentStage("d578dfdc-7b0a-4ab6-a2b0-4b40f20eb9ea")
                .rejectReason("59b25f2b-da02-40f5-9656-9fa0db555784")
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
        assertThat(application).isNotNull
        assertThat(application.id()).contains("92e8a369-fffe-430d-b93a-f7e8a16563f1")
        assertThat(application.remoteId()).contains("98796")
        assertThat(application.candidate()).contains("2872ba14-4084-492b-be96-e5eee6fc33ef")
        assertThat(application.job()).contains("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
        assertThat(application.appliedAt()).contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(application.rejectedAt()).contains(OffsetDateTime.parse("2021-11-15T00:00:00Z"))
        assertThat(application.source()).contains("Campus recruiting event")
        assertThat(application.creditedTo()).contains("58166795-8d68-4b30-9bfb-bfd402479484")
        assertThat(application.currentStage()).contains("d578dfdc-7b0a-4ab6-a2b0-4b40f20eb9ea")
        assertThat(application.rejectReason()).contains("59b25f2b-da02-40f5-9656-9fa0db555784")
        assertThat(application.remoteWasDeleted()).contains(true)
        assertThat(application._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(application.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(application.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
