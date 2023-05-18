package dev.merge.api.models.ats

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationCreateParamsTest {

    @Test
    fun createApplicationCreateParams() {
        ApplicationCreateParams.builder()
            .model(
                ApplicationCreateParams.ApplicationRequest.builder()
                    .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                    .job("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                    .appliedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                    .rejectedAt(OffsetDateTime.parse("2021-11-15T00:00:00Z"))
                    .source("Campus recruiting event")
                    .creditedTo("58166795-8d68-4b30-9bfb-bfd402479484")
                    .currentStage("d578dfdc-7b0a-4ab6-a2b0-4b40f20eb9ea")
                    .rejectReason("59b25f2b-da02-40f5-9656-9fa0db555784")
                    .remoteTemplateId("92830948203")
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
            ApplicationCreateParams.builder()
                .model(
                    ApplicationCreateParams.ApplicationRequest.builder()
                        .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                        .job("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                        .appliedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                        .rejectedAt(OffsetDateTime.parse("2021-11-15T00:00:00Z"))
                        .source("Campus recruiting event")
                        .creditedTo("58166795-8d68-4b30-9bfb-bfd402479484")
                        .currentStage("d578dfdc-7b0a-4ab6-a2b0-4b40f20eb9ea")
                        .rejectReason("59b25f2b-da02-40f5-9656-9fa0db555784")
                        .remoteTemplateId("92830948203")
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
            ApplicationCreateParams.builder()
                .model(ApplicationCreateParams.ApplicationRequest.builder().build())
                .remoteUserId("string")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            ApplicationCreateParams.builder()
                .model(
                    ApplicationCreateParams.ApplicationRequest.builder()
                        .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                        .job("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                        .appliedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                        .rejectedAt(OffsetDateTime.parse("2021-11-15T00:00:00Z"))
                        .source("Campus recruiting event")
                        .creditedTo("58166795-8d68-4b30-9bfb-bfd402479484")
                        .currentStage("d578dfdc-7b0a-4ab6-a2b0-4b40f20eb9ea")
                        .rejectReason("59b25f2b-da02-40f5-9656-9fa0db555784")
                        .remoteTemplateId("92830948203")
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
                ApplicationCreateParams.ApplicationRequest.builder()
                    .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                    .job("52bf9b5e-0beb-4f6f-8a72-cd4dca7ca633")
                    .appliedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                    .rejectedAt(OffsetDateTime.parse("2021-11-15T00:00:00Z"))
                    .source("Campus recruiting event")
                    .creditedTo("58166795-8d68-4b30-9bfb-bfd402479484")
                    .currentStage("d578dfdc-7b0a-4ab6-a2b0-4b40f20eb9ea")
                    .rejectReason("59b25f2b-da02-40f5-9656-9fa0db555784")
                    .remoteTemplateId("92830948203")
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
            ApplicationCreateParams.builder()
                .model(ApplicationCreateParams.ApplicationRequest.builder().build())
                .remoteUserId("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(ApplicationCreateParams.ApplicationRequest.builder().build())
        assertThat(body.remoteUserId()).isEqualTo("string")
    }
}
