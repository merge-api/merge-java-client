package dev.merge.api.models.fileStorage

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DriveTest {

    @Test
    fun createDrive() {
        val drive =
            Drive.builder()
                .id("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
                .remoteId("2039349")
                .name("Documents")
                .remoteCreatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .driveUrl("https://drive.com/drives/2039349")
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
        assertThat(drive).isNotNull
        assertThat(drive.id()).contains("fba1fbc6-67c0-4cb2-a176-7896acd2ffd5")
        assertThat(drive.remoteId()).contains("2039349")
        assertThat(drive.name()).contains("Documents")
        assertThat(drive.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(drive.driveUrl()).contains("https://drive.com/drives/2039349")
        assertThat(drive._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(drive.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(drive.remoteData().get()).containsExactly(JsonString.of("abc"))
    }
}
