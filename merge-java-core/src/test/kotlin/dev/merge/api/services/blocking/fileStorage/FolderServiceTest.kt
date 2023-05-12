package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.fileStorage.*
import dev.merge.api.models.fileStorage.FolderListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FolderServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val folderService = client.fileStorage().folders()
        val folderResponse =
            folderService.create(
                FolderCreateParams.builder()
                    .model(
                        FolderCreateParams.FolderRequest.builder()
                            .name("Platform")
                            .folderUrl("https://drive.com/1234")
                            .size(123L)
                            .description("This is a wild folder.")
                            .parentFolder("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                            .drive("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                            .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
        println(folderResponse)
        folderResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val folderService = client.fileStorage().folders()
        val folder =
            folderService.retrieve(
                FolderRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(FolderRetrieveParams.Expand.DRIVE))
                    .includeRemoteData(true)
                    .build()
            )
        println(folder)
        folder.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val folderService = client.fileStorage().folders()
        val paginatedFolderList = folderService.list(FolderListParams.builder().build())
        println(paginatedFolderList)
        paginatedFolderList.results().forEach { it.validate() }
    }
}
