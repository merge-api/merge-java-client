package dev.merge.api.services.blocking.crm

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.CustomObjectListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CustomObjectServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val customObjectService = client.crm().customObjects()
        val customObjectResponse =
            customObjectService.create(
                CustomObjectCreateParams.builder()
                    .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .model(
                        CustomObjectCreateParams.CustomObjectRequest.builder()
                            .fields(JsonValue.from(mapOf("test_field" to "hello")))
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(customObjectResponse)
        customObjectResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val customObjectService = client.crm().customObjects()
        val customObject =
            customObjectService.retrieve(
                CustomObjectRetrieveParams.builder()
                    .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .includeRemoteFields(true)
                    .build()
            )
        println(customObject)
        customObject.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val customObjectService = client.crm().customObjects()
        val customObjectResponse =
            customObjectService.update(
                CustomObjectUpdateParams.builder()
                    .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .model(
                        CustomObjectUpdateParams.CustomObjectRequest.builder()
                            .fields(JsonValue.from(mapOf("test_field" to "hello")))
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(customObjectResponse)
        customObjectResponse.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val customObjectService = client.crm().customObjects()
        val paginatedCustomObjectList =
            customObjectService.list(
                CustomObjectListParams.builder()
                    .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(paginatedCustomObjectList)
        paginatedCustomObjectList.results().forEach { it.validate() }
    }
}
