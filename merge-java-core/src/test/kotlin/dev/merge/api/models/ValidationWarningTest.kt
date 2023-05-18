package dev.merge.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidationWarningTest {

    @Test
    fun createValidationWarning() {
        val validationWarning =
            ValidationWarning.builder()
                .source(
                    ValidationWarning.ValidationProblemSource.builder().pointer("string").build()
                )
                .title("Unrecognized Field")
                .detail("An unrecognized field, age, was passed in with request data.")
                .problemType("UNRECOGNIZED_FIELD")
                .build()
        assertThat(validationWarning).isNotNull
        assertThat(validationWarning.source())
            .contains(ValidationWarning.ValidationProblemSource.builder().pointer("string").build())
        assertThat(validationWarning.title()).isEqualTo("Unrecognized Field")
        assertThat(validationWarning.detail())
            .isEqualTo("An unrecognized field, age, was passed in with request data.")
        assertThat(validationWarning.problemType()).isEqualTo("UNRECOGNIZED_FIELD")
    }
}
