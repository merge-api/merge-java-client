package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import dev.merge.api.models.ats.ActivityListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ActivityServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val activityService = client.ats().activities()
        val activityCreateResponse =
            activityService.create(
                ActivityCreateParams.builder()
                    .model(
                        ActivityCreateParams.ActivityRequest.builder()
                            .user("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                            .activityType(
                                ActivityCreateParams.ActivityRequest.ActivityTypeEnum.CALL
                            )
                            .subject("Gil Feig's interview")
                            .body("Candidate loves integrations!!.")
                            .visibility(
                                ActivityCreateParams.ActivityRequest.VisibilityEnum.ADMIN_ONLY
                            )
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
                    .remoteUserId("string")
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(activityCreateResponse)
        activityCreateResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val activityService = client.ats().activities()
        val activity =
            activityService.retrieve(
                ActivityRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(ActivityRetrieveParams.Expand.USER))
                    .includeRemoteData(true)
                    .remoteFields(ActivityRetrieveParams.RemoteFields.ACTIVITY_TYPE)
                    .showEnumOrigins(ActivityRetrieveParams.ShowEnumOrigins.ACTIVITY_TYPE)
                    .build()
            )
        println(activity)
        activity.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val activityService = client.ats().activities()
        val paginatedActivityList = activityService.list(ActivityListParams.builder().build())
        println(paginatedActivityList)
        paginatedActivityList.results().forEach { it.validate() }
    }
}
