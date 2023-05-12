package dev.merge.api.services.blocking.marketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.marketing.*
import dev.merge.api.models.marketing.AutomationListParams
import dev.merge.api.models.marketing.AutomationListRecipientsParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AutomationServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val automationService = client.marketing().automations()
        val automationResponse =
            automationService.create(
                AutomationCreateParams.builder()
                    .model(
                        AutomationCreateParams.AutomationRequest.builder()
                            .name("Welcome Email")
                            .triggerType(
                                AutomationCreateParams.AutomationRequest.TriggerTypeEnum
                                    .TRIGGER_EVENT
                            )
                            .startDate(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                            .endDate(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                            .description("This sends a welcome email to new customers.")
                            .status("Published")
                            .automationTrigger(
                                JsonValue.from(
                                    mapOf(
                                        "recurrence_schedule" to
                                            mapOf(
                                                "days" to listOf("Sunday"),
                                                "hours" to mapOf("type" to "send_asap")
                                            ),
                                        "trigger_settings" to
                                            mapOf("trigger_event" to "NEW_CUSTOMER")
                                    )
                                )
                            )
                            .actions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
        println(automationResponse)
        automationResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val automationService = client.marketing().automations()
        val automation =
            automationService.retrieve(
                AutomationRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .build()
            )
        println(automation)
        automation.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val automationService = client.marketing().automations()
        val paginatedAutomationList = automationService.list(AutomationListParams.builder().build())
        println(paginatedAutomationList)
        paginatedAutomationList.results().forEach { it.validate() }
    }

    @Test
    fun callListRecipients() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val automationService = client.marketing().automations()
        val paginatedContactList =
            automationService.listRecipients(
                AutomationListRecipientsParams.builder()
                    .parentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(paginatedContactList)
        paginatedContactList.results().forEach { it.validate() }
    }
}
