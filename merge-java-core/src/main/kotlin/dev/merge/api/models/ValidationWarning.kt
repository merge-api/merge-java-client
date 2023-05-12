package dev.merge.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = ValidationWarning.Builder::class)
@NoAutoDetect
class ValidationWarning
private constructor(
    private val source: JsonField<ValidationProblemSource>,
    private val title: JsonField<String>,
    private val detail: JsonField<String>,
    private val problemType: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun source(): Optional<ValidationProblemSource> =
        Optional.ofNullable(source.getNullable("source"))

    fun title(): String = title.getRequired("title")

    fun detail(): String = detail.getRequired("detail")

    fun problemType(): String = problemType.getRequired("problem_type")

    @JsonProperty("source") @ExcludeMissing fun _source() = source

    @JsonProperty("title") @ExcludeMissing fun _title() = title

    @JsonProperty("detail") @ExcludeMissing fun _detail() = detail

    @JsonProperty("problem_type") @ExcludeMissing fun _problemType() = problemType

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            source().map { it.validate() }
            title()
            detail()
            problemType()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ValidationWarning &&
            this.source == other.source &&
            this.title == other.title &&
            this.detail == other.detail &&
            this.problemType == other.problemType &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    source,
                    title,
                    detail,
                    problemType,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ValidationWarning{source=$source, title=$title, detail=$detail, problemType=$problemType, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var source: JsonField<ValidationProblemSource> = JsonMissing.of()
        private var title: JsonField<String> = JsonMissing.of()
        private var detail: JsonField<String> = JsonMissing.of()
        private var problemType: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(validationWarning: ValidationWarning) = apply {
            this.source = validationWarning.source
            this.title = validationWarning.title
            this.detail = validationWarning.detail
            this.problemType = validationWarning.problemType
            additionalProperties(validationWarning.additionalProperties)
        }

        fun source(source: ValidationProblemSource) = source(JsonField.of(source))

        @JsonProperty("source")
        @ExcludeMissing
        fun source(source: JsonField<ValidationProblemSource>) = apply { this.source = source }

        fun title(title: String) = title(JsonField.of(title))

        @JsonProperty("title")
        @ExcludeMissing
        fun title(title: JsonField<String>) = apply { this.title = title }

        fun detail(detail: String) = detail(JsonField.of(detail))

        @JsonProperty("detail")
        @ExcludeMissing
        fun detail(detail: JsonField<String>) = apply { this.detail = detail }

        fun problemType(problemType: String) = problemType(JsonField.of(problemType))

        @JsonProperty("problem_type")
        @ExcludeMissing
        fun problemType(problemType: JsonField<String>) = apply { this.problemType = problemType }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): ValidationWarning =
            ValidationWarning(
                source,
                title,
                detail,
                problemType,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = ValidationProblemSource.Builder::class)
    @NoAutoDetect
    class ValidationProblemSource
    private constructor(
        private val pointer: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun pointer(): String = pointer.getRequired("pointer")

        @JsonProperty("pointer") @ExcludeMissing fun _pointer() = pointer

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                pointer()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ValidationProblemSource &&
                this.pointer == other.pointer &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(pointer, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "ValidationProblemSource{pointer=$pointer, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var pointer: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(validationProblemSource: ValidationProblemSource) = apply {
                this.pointer = validationProblemSource.pointer
                additionalProperties(validationProblemSource.additionalProperties)
            }

            fun pointer(pointer: String) = pointer(JsonField.of(pointer))

            @JsonProperty("pointer")
            @ExcludeMissing
            fun pointer(pointer: JsonField<String>) = apply { this.pointer = pointer }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): ValidationProblemSource =
                ValidationProblemSource(pointer, additionalProperties.toUnmodifiable())
        }
    }
}
