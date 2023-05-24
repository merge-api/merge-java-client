package dev.merge.api.models.fileStorage

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FolderTest {

    @Test
    fun createFolder() {
        val folder =
            Folder.builder()
                .id("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .remoteId("14")
                .name("Platform")
                .folderUrl("https://drive.com/1234")
                .size(123L)
                .description("This is a wild folder.")
                .parentFolder("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .drive("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .permissions(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
        assertThat(folder).isNotNull
        assertThat(folder.id()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(folder.remoteId()).contains("14")
        assertThat(folder.name()).contains("Platform")
        assertThat(folder.folderUrl()).contains("https://drive.com/1234")
        assertThat(folder.size()).contains(123L)
        assertThat(folder.description()).contains("This is a wild folder.")
        assertThat(folder.parentFolder()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(folder.drive()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(folder.permissions()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(folder.remoteCreatedAt()).contains(OffsetDateTime.parse("2022-02-02T00:00:00Z"))
        assertThat(folder.remoteUpdatedAt()).contains(OffsetDateTime.parse("2022-02-03T00:00:00Z"))
        assertThat(folder._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(folder.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(folder.remoteData().get()).containsExactly(JsonString.of("abc"))
    }
}
