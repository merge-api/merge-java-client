package dev.merge.api.models.crm

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TaskUpdateParamsTest {

    @Test
    fun createTaskUpdateParams() {
        TaskUpdateParams.builder()
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .model(
                TaskUpdateParams.PatchedTaskRequest.builder()
                    .subject("Contact about Integration Strategy")
                    .content("Follow up to see whether they need integrations")
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .completedDate(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
                    .dueDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .status(TaskUpdateParams.PatchedTaskRequest.TaskStatusEnum.OPEN)
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
            TaskUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    TaskUpdateParams.PatchedTaskRequest.builder()
                        .subject("Contact about Integration Strategy")
                        .content("Follow up to see whether they need integrations")
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .completedDate(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
                        .dueDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .status(TaskUpdateParams.PatchedTaskRequest.TaskStatusEnum.OPEN)
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
            TaskUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(TaskUpdateParams.PatchedTaskRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            TaskUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(
                    TaskUpdateParams.PatchedTaskRequest.builder()
                        .subject("Contact about Integration Strategy")
                        .content("Follow up to see whether they need integrations")
                        .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                        .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .completedDate(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
                        .dueDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .status(TaskUpdateParams.PatchedTaskRequest.TaskStatusEnum.OPEN)
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
                TaskUpdateParams.PatchedTaskRequest.builder()
                    .subject("Contact about Integration Strategy")
                    .content("Follow up to see whether they need integrations")
                    .owner("0358cbc6-2040-430a-848e-aafacbadf3aa")
                    .account("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .completedDate(OffsetDateTime.parse("2022-02-11T00:00:00Z"))
                    .dueDate(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .status(TaskUpdateParams.PatchedTaskRequest.TaskStatusEnum.OPEN)
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
            TaskUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(TaskUpdateParams.PatchedTaskRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(TaskUpdateParams.PatchedTaskRequest.builder().build())
    }

    @Test
    fun getPathParam() {
        val params =
            TaskUpdateParams.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .model(TaskUpdateParams.PatchedTaskRequest.builder().build())
                .build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
