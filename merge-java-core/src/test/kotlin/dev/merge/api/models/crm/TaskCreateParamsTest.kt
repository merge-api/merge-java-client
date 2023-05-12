package dev.merge.api.models.crm

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TaskCreateParamsTest {

    @Test
    fun createTaskCreateParams() {
        TaskCreateParams.builder()
            .model(
                TaskCreateParams.TaskRequest.builder()
                    .subject("Contact about Integration Strategy")
                    .content("Follow up to see whether they need integrations")
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .completedDate(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
                    .dueDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .status(TaskCreateParams.TaskRequest.TaskStatusEnum.OPEN)
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
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            TaskCreateParams.builder()
                .model(
                    TaskCreateParams.TaskRequest.builder()
                        .subject("Contact about Integration Strategy")
                        .content("Follow up to see whether they need integrations")
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .completedDate(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
                        .dueDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .status(TaskCreateParams.TaskRequest.TaskStatusEnum.OPEN)
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
            TaskCreateParams.builder().model(TaskCreateParams.TaskRequest.builder().build()).build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            TaskCreateParams.builder()
                .model(
                    TaskCreateParams.TaskRequest.builder()
                        .subject("Contact about Integration Strategy")
                        .content("Follow up to see whether they need integrations")
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .completedDate(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
                        .dueDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .status(TaskCreateParams.TaskRequest.TaskStatusEnum.OPEN)
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
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                TaskCreateParams.TaskRequest.builder()
                    .subject("Contact about Integration Strategy")
                    .content("Follow up to see whether they need integrations")
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .completedDate(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
                    .dueDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .status(TaskCreateParams.TaskRequest.TaskStatusEnum.OPEN)
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
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            TaskCreateParams.builder().model(TaskCreateParams.TaskRequest.builder().build()).build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(TaskCreateParams.TaskRequest.builder().build())
    }
}
