package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.AttachmentListParams
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
        val attachmentService = client.accounting().attachments()
        val accountingAttachmentResponse =
            attachmentService.create(
                AttachmentCreateParams.builder()
                    .model(
                        AttachmentCreateParams.AccountingAttachmentRequest.builder()
                            .fileName("invoice.png")
                            .fileUrl(
                                "https://merge-brand.s3.amazonaws.com/20210315/rect-logo-270x80%402x.png"
                            )
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
        println(accountingAttachmentResponse)
        accountingAttachmentResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val attachmentService = client.accounting().attachments()
        val accountingAttachment =
            attachmentService.retrieve(
                AttachmentRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .build()
            )
        println(accountingAttachment)
        accountingAttachment.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val attachmentService = client.accounting().attachments()
        val paginatedAccountingAttachmentList =
            attachmentService.list(AttachmentListParams.builder().build())
        println(paginatedAccountingAttachmentList)
        paginatedAccountingAttachmentList.results().forEach { it.validate() }
    }
}
