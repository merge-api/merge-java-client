package dev.merge.api.models.fileStorage

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileTest {

    @Test
    fun createFile() {
        val file =
            File.builder()
                .id("45ce474c-dhcj-43a6-754r-629f799f7d68")
                .remoteId("12")
                .name("omg_common_model_scope.docx")
                .fileUrl("https://drive.com/1234")
                .fileThumbnailUrl("https://drive.com/1234/thumbnail.png")
                .size(123L)
                .mimeType(".docx")
                .description("This file is OP")
                .folder("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .drive("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .remoteCreatedAt(OffsetDateTime.parse("2022-02-02T00:00:00Z"))
                .remoteUpdatedAt(OffsetDateTime.parse("2022-02-03T00:00:00Z"))
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
                .remoteData(listOf(JsonString.of("abc")))
                .build()
        assertThat(file).isNotNull
        assertThat(file.id()).contains("45ce474c-dhcj-43a6-754r-629f799f7d68")
        assertThat(file.remoteId()).contains("12")
        assertThat(file.name()).contains("omg_common_model_scope.docx")
        assertThat(file.fileUrl()).contains("https://drive.com/1234")
        assertThat(file.fileThumbnailUrl()).contains("https://drive.com/1234/thumbnail.png")
        assertThat(file.size()).contains(123L)
        assertThat(file.mimeType()).contains(".docx")
        assertThat(file.description()).contains("This file is OP")
        assertThat(file.folder()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(file.permissions()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(file.drive()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(file.remoteCreatedAt()).contains(OffsetDateTime.parse("2022-02-02T00:00:00Z"))
        assertThat(file.remoteUpdatedAt()).contains(OffsetDateTime.parse("2022-02-03T00:00:00Z"))
        assertThat(file._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(file.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(file.remoteData().get()).containsExactly(JsonString.of("abc"))
    }
}
