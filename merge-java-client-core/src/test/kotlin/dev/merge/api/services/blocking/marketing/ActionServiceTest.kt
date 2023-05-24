package dev.merge.api.services.blocking.marketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.marketing.*
import dev.merge.api.models.marketing.ActionListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ActionServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val actionService = client.marketing().actions()
        val actionResponse =
            actionService.create(
                ActionCreateParams.builder()
                    .model(
                        ActionCreateParams.ActionRequest.builder()
                            .name("Welcome Email")
                            .emails(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .messages(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .type(ActionCreateParams.ActionRequest.TypeEnum.EMAIL)
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
        println(actionResponse)
        actionResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val actionService = client.marketing().actions()
        val action =
            actionService.retrieve(
                ActionRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .build()
            )
        println(action)
        action.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val actionService = client.marketing().actions()
        val paginatedActionList = actionService.list(ActionListParams.builder().build())
        println(paginatedActionList)
        paginatedActionList.results().forEach { it.validate() }
    }
}
