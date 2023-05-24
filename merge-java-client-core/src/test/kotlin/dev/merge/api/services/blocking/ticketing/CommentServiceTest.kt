package dev.merge.api.services.blocking.ticketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.ticketing.*
import dev.merge.api.models.ticketing.CommentListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CommentServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val commentService = client.ticketing().comments()
        val commentResponse =
            commentService.create(
                CommentCreateParams.builder()
                    .model(
                        CommentCreateParams.CommentRequest.builder()
                            .user("17a54124-287f-494d-965e-3c5b330c9a68")
                            .contact("dde3fb16-b8eb-483d-81c4-b78100816f15")
                            .body("When will these integrations be done? You all should use Merge.")
                            .htmlBody(
                                "When will these integrations be done? You all should use <b>Merge<b>."
                            )
                            .ticket("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
                            .isPrivate(true)
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
        println(commentResponse)
        commentResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val commentService = client.ticketing().comments()
        val comment =
            commentService.retrieve(
                CommentRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(CommentRetrieveParams.Expand.CONTACT))
                    .includeRemoteData(true)
                    .build()
            )
        println(comment)
        comment.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val commentService = client.ticketing().comments()
        val paginatedCommentList = commentService.list(CommentListParams.builder().build())
        println(paginatedCommentList)
        paginatedCommentList.results().forEach { it.validate() }
    }
}
