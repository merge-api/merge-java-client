package dev.merge.api.models.crm

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssociationTypeTest {

    @Test
    fun createAssociationType() {
        val associationType =
            AssociationType.builder()
                .sourceObjectClass(
                    JsonValue.from(
                        mapOf(
                            "id" to "ff1ff4cb-a66b-47dc-8e2a-50388049e602",
                            "origin_type" to "CUSTOM_OBJECT"
                        )
                    )
                )
                .targetObjectClasses(
                    listOf(
                        AssociationType.AssociationSubType.builder()
                            .id("string")
                            .originType("string")
                            .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                )
                .remoteKeyName("order_to_opportunity")
                .displayName("Order to Opportunity")
                .cardinality(AssociationType.CardinalityEnum.ONE_TO_ONE)
                .isRequired(true)
                .id("5bb73c32-3c6c-4757-ab7d-7d3540a1be31")
                .remoteId("93")
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .build()
        assertThat(associationType).isNotNull
        assertThat(associationType._sourceObjectClass())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "id" to "ff1ff4cb-a66b-47dc-8e2a-50388049e602",
                        "origin_type" to "CUSTOM_OBJECT"
                    )
                )
            )
        assertThat(associationType.targetObjectClasses().get())
            .containsExactly(
                AssociationType.AssociationSubType.builder()
                    .id("string")
                    .originType("string")
                    .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(associationType.remoteKeyName()).contains("order_to_opportunity")
        assertThat(associationType.displayName()).contains("Order to Opportunity")
        assertThat(associationType.cardinality())
            .contains(AssociationType.CardinalityEnum.ONE_TO_ONE)
        assertThat(associationType.isRequired()).contains(true)
        assertThat(associationType.id()).contains("5bb73c32-3c6c-4757-ab7d-7d3540a1be31")
        assertThat(associationType.remoteId()).contains("93")
        assertThat(associationType.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
    }
}
