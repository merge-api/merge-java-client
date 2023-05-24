package dev.merge.api.models

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AttachmentTest {

    @Test
    fun createAttachment() {
        val attachment =
            Attachment.builder()
                .id("17a54124-287f-494d-965e-3c5b330c9a68")
                .remoteId("19202938")
                .fileName("Screenshot.png")
                .fileUrl("http://alturl.com/p749b")
                .candidate("2872ba14-4084-492b-be96-e5eee6fc33ef")
                .attachmentType(Attachment.AttachmentTypeEnum.RESUME)
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
                .ticket("0958cbc6-6040-430a-848e-aafacbadf4ae")
                .contentType("jpeg")
                .uploadedBy("28b54125-287f-494d-965e-3c5b330c9a68")
                .remoteCreatedAt(OffsetDateTime.parse("2022-11-10T00:00:00Z"))
                .build()
        assertThat(attachment).isNotNull
        assertThat(attachment.id()).contains("17a54124-287f-494d-965e-3c5b330c9a68")
        assertThat(attachment.remoteId()).contains("19202938")
        assertThat(attachment.fileName()).contains("Screenshot.png")
        assertThat(attachment.fileUrl()).contains("http://alturl.com/p749b")
        assertThat(attachment.candidate()).contains("2872ba14-4084-492b-be96-e5eee6fc33ef")
        assertThat(attachment.attachmentType()).contains(Attachment.AttachmentTypeEnum.RESUME)
        assertThat(attachment.remoteWasDeleted()).contains(true)
        assertThat(attachment._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(attachment.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(attachment.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
        assertThat(attachment.ticket()).contains("0958cbc6-6040-430a-848e-aafacbadf4ae")
        assertThat(attachment.contentType()).contains("jpeg")
        assertThat(attachment.uploadedBy()).contains("28b54125-287f-494d-965e-3c5b330c9a68")
        assertThat(attachment.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2022-11-10T00:00:00Z"))
    }
}
