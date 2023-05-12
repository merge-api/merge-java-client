package dev.merge.api.services.blocking.crm

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.TaskListParams
import dev.merge.api.models.crm.TaskListRemoteFieldClassesParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TaskServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val taskService = client.crm().tasks()
        val taskCreateResponse =
            taskService.create(
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
                                        "unique_integration_field" to
                                            "unique_integration_field_value"
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
            )
        println(taskCreateResponse)
        taskCreateResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val taskService = client.crm().tasks()
        val task =
            taskService.retrieve(
                TaskRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(TaskRetrieveParams.Expand.ACCOUNT))
                    .includeRemoteData(true)
                    .includeRemoteFields(true)
                    .build()
            )
        println(task)
        task.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val taskService = client.crm().tasks()
        val taskCreateResponse =
            taskService.update(
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
                                        "unique_integration_field" to
                                            "unique_integration_field_value"
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
            )
        println(taskCreateResponse)
        taskCreateResponse.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val taskService = client.crm().tasks()
        val paginatedTaskList = taskService.list(TaskListParams.builder().build())
        println(paginatedTaskList)
        paginatedTaskList.results().forEach { it.validate() }
    }

    @Test
    fun callListRemoteFieldClasses() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val taskService = client.crm().tasks()
        val paginatedRemoteFieldClassList =
            taskService.listRemoteFieldClasses(TaskListRemoteFieldClassesParams.builder().build())
        println(paginatedRemoteFieldClassList)
        paginatedRemoteFieldClassList.results().forEach { it.validate() }
    }
}
