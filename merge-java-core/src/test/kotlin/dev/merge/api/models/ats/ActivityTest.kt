package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ActivityTest {

    @Test
    fun createActivity() {
        val activity =
            Activity.builder()
                .id("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
                .remoteId("198123")
                .user("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                .remoteCreatedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                .activityType(Activity.ActivityTypeEnum.CALL)
                .subject("Gil Feig's interview")
                .body("Candidate loves integrations!!.")
                .visibility(Activity.VisibilityEnum.ADMIN_ONLY)
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
        assertThat(activity).isNotNull
        assertThat(activity.id()).contains("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
        assertThat(activity.remoteId()).contains("198123")
        assertThat(activity.user()).contains("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
        assertThat(activity.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(activity.activityType()).contains(Activity.ActivityTypeEnum.CALL)
        assertThat(activity.subject()).contains("Gil Feig's interview")
        assertThat(activity.body()).contains("Candidate loves integrations!!.")
        assertThat(activity.visibility()).contains(Activity.VisibilityEnum.ADMIN_ONLY)
        assertThat(activity.remoteWasDeleted()).contains(true)
        assertThat(activity._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(activity.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(activity.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
