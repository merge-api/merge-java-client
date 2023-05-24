package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.fileStorage.*
import dev.merge.api.models.fileStorage.FileListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FileServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val fileService = client.fileStorage().files()
        val fileResponse =
            fileService.create(
                FileCreateParams.builder()
                    .model(
                        FileCreateParams.FileRequest.builder()
                            .name("omg_common_model_scope.docx")
                            .fileUrl("https://drive.com/1234")
                            .fileThumbnailUrl("https://drive.com/1234/thumbnail.png")
                            .size(123L)
                            .mimeType(".docx")
                            .description("This file is OP")
                            .folder("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                            .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .drive("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
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
        println(fileResponse)
        fileResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val fileService = client.fileStorage().files()
        val file =
            fileService.retrieve(
                FileRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(FileRetrieveParams.Expand.DRIVE))
                    .includeRemoteData(true)
                    .build()
            )
        println(file)
        file.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val fileService = client.fileStorage().files()
        val paginatedFileList = fileService.list(FileListParams.builder().build())
        println(paginatedFileList)
        paginatedFileList.results().forEach { it.validate() }
    }

    @Test
    fun callDownload() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val fileService = client.fileStorage().files()
        fileService.download(
            FileDownloadParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        )
    }
}
