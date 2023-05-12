package dev.merge.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidationErrorTest {

    @Test
    fun createValidationError() {
        val validationError =
            ValidationError.builder()
                .source(ValidationError.ValidationProblemSource.builder().pointer("string").build())
                .title("Missing Required Field")
                .detail("custom_fields is a required field on model.")
                .problemType("MISSING_REQUIRED_FIELD")
                .build()
        assertThat(validationError).isNotNull
        assertThat(validationError.source())
            .contains(ValidationError.ValidationProblemSource.builder().pointer("string").build())
        assertThat(validationError.title()).isEqualTo("Missing Required Field")
        assertThat(validationError.detail())
            .isEqualTo("custom_fields is a required field on model.")
        assertThat(validationError.problemType()).isEqualTo("MISSING_REQUIRED_FIELD")
    }
}
