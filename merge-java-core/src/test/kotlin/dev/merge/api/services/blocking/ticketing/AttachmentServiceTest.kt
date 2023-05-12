package dev.merge.api.services.blocking.ticketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.ticketing.*
import dev.merge.api.models.ticketing.AttachmentListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AttachmentServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val attachmentService = client.ticketing().attachments()
        val attachmentCreateResponse =
            attachmentService.create(
                AttachmentCreateParams.builder()
                    .model(
                        AttachmentCreateParams.AttachmentRequest.builder()
                            .fileName("Screenshot.png")
                            .fileUrl("http://alturl.com/p749b")
                            .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                            .attachmentType(
                                AttachmentCreateParams.AttachmentRequest.AttachmentTypeEnum.RESUME
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
                            .ticket("0958cbc6-6040-430a-848e-aafacbadf4ae")
                            .contentType("jpeg")
                            .uploadedBy("28b54125-287f-494d-965e-3c5b330c9a68")
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(attachmentCreateResponse)
        attachmentCreateResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val attachmentService = client.ticketing().attachments()
        val attachment =
            attachmentService.retrieve(
                AttachmentRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(AttachmentRetrieveParams.Expand.TICKET))
                    .includeRemoteData(true)
                    .build()
            )
        println(attachment)
        attachment.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val attachmentService = client.ticketing().attachments()
        val paginatedAttachmentList = attachmentService.list(AttachmentListParams.builder().build())
        println(paginatedAttachmentList)
        paginatedAttachmentList.results().forEach { it.validate() }
    }
}
