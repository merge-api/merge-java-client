package dev.merge.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConditionSchemaTest {

    @Test
    fun createConditionSchema() {
        val conditionSchema =
            ConditionSchema.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .commonModel("string")
                .nativeName("string")
                .fieldName("string")
                .isUnique(true)
                .conditionType(ConditionSchema.ConditionTypeEnum.BOOLEAN)
                .operators(
                    listOf(
                        ConditionSchema.OperatorSchema.builder()
                            .operator("string")
                            .isUnique(true)
                            .build()
                    )
                )
                .build()
        assertThat(conditionSchema).isNotNull
        assertThat(conditionSchema.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(conditionSchema.commonModel()).contains("string")
        assertThat(conditionSchema.nativeName()).contains("string")
        assertThat(conditionSchema.fieldName()).contains("string")
        assertThat(conditionSchema.isUnique()).contains(true)
        assertThat(conditionSchema.conditionType())
            .isEqualTo(ConditionSchema.ConditionTypeEnum.BOOLEAN)
        assertThat(conditionSchema.operators())
            .containsExactly(
                ConditionSchema.OperatorSchema.builder().operator("string").isUnique(true).build()
            )
    }
}
