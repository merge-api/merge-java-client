package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompanyTest {

    @Test
    fun createCompany() {
        val company =
            Company.builder()
                .id("1b998423-db0a-4037-a4cf-f79c60cb67b3")
                .remoteId("19202938")
                .legalName("Waystar Royco, Inc.")
                .displayName("Waystar Royco")
                .eins(listOf("string"))
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
        assertThat(company).isNotNull
        assertThat(company.id()).contains("1b998423-db0a-4037-a4cf-f79c60cb67b3")
        assertThat(company.remoteId()).contains("19202938")
        assertThat(company.legalName()).contains("Waystar Royco, Inc.")
        assertThat(company.displayName()).contains("Waystar Royco")
        assertThat(company.eins().get()).containsExactly("string")
        assertThat(company.remoteWasDeleted()).contains(true)
        assertThat(company._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(company.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(company.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
