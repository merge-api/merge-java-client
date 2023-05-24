package dev.merge.api.services.blocking.marketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.marketing.*
import dev.merge.api.models.marketing.TemplateListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TemplateServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val templateService = client.marketing().templates()
        val templateResponse =
            templateService.create(
                TemplateCreateParams.builder()
                    .model(
                        TemplateCreateParams.TemplateRequest.builder()
                            .name("Welcome Email Template")
                            .type(TemplateCreateParams.TemplateRequest.TypeEnum.EMAIL)
                            .contents("Welcome onboard! Stay connected and find out more.")
                            .owner("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
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
        println(templateResponse)
        templateResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val templateService = client.marketing().templates()
        val template =
            templateService.retrieve(
                TemplateRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .build()
            )
        println(template)
        template.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val templateService = client.marketing().templates()
        val paginatedTemplateList = templateService.list(TemplateListParams.builder().build())
        println(paginatedTemplateList)
        paginatedTemplateList.results().forEach { it.validate() }
    }
}
