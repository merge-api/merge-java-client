package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TrackingCategoryTest {

    @Test
    fun createTrackingCategory() {
        val trackingCategory =
            TrackingCategory.builder()
                .name("Marketing Department")
                .status(TrackingCategory.Status7d1Enum.ACTIVE)
                .categoryType(TrackingCategory.CategoryTypeEnum.CLASS)
                .parentCategory("d25d609b-945f-4762-b55a-1c8fb220c43c")
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                .remoteWasDeleted(true)
                .id("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
                .remoteId("948201")
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
        assertThat(trackingCategory).isNotNull
        assertThat(trackingCategory.name()).contains("Marketing Department")
        assertThat(trackingCategory.status()).contains(TrackingCategory.Status7d1Enum.ACTIVE)
        assertThat(trackingCategory.categoryType())
            .contains(TrackingCategory.CategoryTypeEnum.CLASS)
        assertThat(trackingCategory.parentCategory())
            .contains("d25d609b-945f-4762-b55a-1c8fb220c43c")
        assertThat(trackingCategory.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(trackingCategory.remoteWasDeleted()).contains(true)
        assertThat(trackingCategory.id()).contains("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
        assertThat(trackingCategory.remoteId()).contains("948201")
        assertThat(trackingCategory._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(trackingCategory.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(trackingCategory.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
