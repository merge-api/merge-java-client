package dev.merge.api.models.ats

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ActivityCreateParamsTest {

    @Test
    fun createActivityCreateParams() {
        ActivityCreateParams.builder()
            .model(
                ActivityCreateParams.ActivityRequest.builder()
                    .user("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                    .activityType(ActivityCreateParams.ActivityRequest.ActivityTypeEnum.CALL)
                    .subject("Gil Feig's interview")
                    .body("Candidate loves integrations!!.")
                    .visibility(ActivityCreateParams.ActivityRequest.VisibilityEnum.ADMIN_ONLY)
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
            .remoteUserId("string")
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            ActivityCreateParams.builder()
                .model(
                    ActivityCreateParams.ActivityRequest.builder()
                        .user("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                        .activityType(ActivityCreateParams.ActivityRequest.ActivityTypeEnum.CALL)
                        .subject("Gil Feig's interview")
                        .body("Candidate loves integrations!!.")
                        .visibility(ActivityCreateParams.ActivityRequest.VisibilityEnum.ADMIN_ONLY)
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
                        .build()
                )
                .remoteUserId("string")
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("is_debug_mode", listOf("true"))
        expected.put("run_async", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            ActivityCreateParams.builder()
                .model(ActivityCreateParams.ActivityRequest.builder().build())
                .remoteUserId("string")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            ActivityCreateParams.builder()
                .model(
                    ActivityCreateParams.ActivityRequest.builder()
                        .user("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                        .activityType(ActivityCreateParams.ActivityRequest.ActivityTypeEnum.CALL)
                        .subject("Gil Feig's interview")
                        .body("Candidate loves integrations!!.")
                        .visibility(ActivityCreateParams.ActivityRequest.VisibilityEnum.ADMIN_ONLY)
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
                        .build()
                )
                .remoteUserId("string")
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                ActivityCreateParams.ActivityRequest.builder()
                    .user("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                    .activityType(ActivityCreateParams.ActivityRequest.ActivityTypeEnum.CALL)
                    .subject("Gil Feig's interview")
                    .body("Candidate loves integrations!!.")
                    .visibility(ActivityCreateParams.ActivityRequest.VisibilityEnum.ADMIN_ONLY)
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
        assertThat(body.remoteUserId()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            ActivityCreateParams.builder()
                .model(ActivityCreateParams.ActivityRequest.builder().build())
                .remoteUserId("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(ActivityCreateParams.ActivityRequest.builder().build())
        assertThat(body.remoteUserId()).isEqualTo("string")
    }
}
