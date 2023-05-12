package dev.merge.api.models

import dev.merge.api.core.JsonString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LinkedAccountSelectiveSyncConfigurationTest {

    @Test
    fun createLinkedAccountSelectiveSyncConfiguration() {
        val linkedAccountSelectiveSyncConfiguration =
            LinkedAccountSelectiveSyncConfiguration.builder()
                .linkedAccountConditions(
                    listOf(
                        LinkedAccountSelectiveSyncConfiguration.LinkedAccountCondition.builder()
                            .conditionSchemaId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .commonModel("string")
                            .nativeName("string")
                            .operator("string")
                            .value(JsonString.of("abc"))
                            .fieldName("string")
                            .build()
                    )
                )
                .build()
        assertThat(linkedAccountSelectiveSyncConfiguration).isNotNull
        assertThat(linkedAccountSelectiveSyncConfiguration.linkedAccountConditions().get())
            .containsExactly(
                LinkedAccountSelectiveSyncConfiguration.LinkedAccountCondition.builder()
                    .conditionSchemaId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .commonModel("string")
                    .nativeName("string")
                    .operator("string")
                    .value(JsonString.of("abc"))
                    .fieldName("string")
                    .build()
            )
    }
}
