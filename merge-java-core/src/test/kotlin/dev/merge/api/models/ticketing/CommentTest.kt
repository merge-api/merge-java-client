package dev.merge.api.models.ticketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CommentTest {

    @Test
    fun createComment() {
        val comment =
            Comment.builder()
                .id("0958cbc6-6040-430a-848e-aafacbadf4ae")
                .remoteId("19202938")
                .user("17a54124-287f-494d-965e-3c5b330c9a68")
                .contact("dde3fb16-b8eb-483d-81c4-b78100816f15")
                .body("When will these integrations be done? You all should use Merge.")
                .htmlBody("When will these integrations be done? You all should use <b>Merge<b>.")
                .ticket("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
                .isPrivate(true)
                .remoteCreatedAt(OffsetDateTime.parse("1990-11-10T00:00:00Z"))
                .remoteWasDeleted(true)
                .fieldMappings(
                    JsonValue.from(
                        mapOf(
                            "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                            "linked_account_defined_targets" to
                                mapOf("custom_key" to "custom_value")
                        )
                    )
                )
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .remoteData(
                    listOf(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
                )
                .build()
        assertThat(comment).isNotNull
        assertThat(comment.id()).contains("0958cbc6-6040-430a-848e-aafacbadf4ae")
        assertThat(comment.remoteId()).contains("19202938")
        assertThat(comment.user()).contains("17a54124-287f-494d-965e-3c5b330c9a68")
        assertThat(comment.contact()).contains("dde3fb16-b8eb-483d-81c4-b78100816f15")
        assertThat(comment.body())
            .contains("When will these integrations be done? You all should use Merge.")
        assertThat(comment.htmlBody())
            .contains("When will these integrations be done? You all should use <b>Merge<b>.")
        assertThat(comment.ticket()).contains("fb8c55b6-1cb8-4b4c-9fb6-17924231619d")
        assertThat(comment.isPrivate()).contains(true)
        assertThat(comment.remoteCreatedAt()).contains(OffsetDateTime.parse("1990-11-10T00:00:00Z"))
        assertThat(comment.remoteWasDeleted()).contains(true)
        assertThat(comment._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(comment.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(comment.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
