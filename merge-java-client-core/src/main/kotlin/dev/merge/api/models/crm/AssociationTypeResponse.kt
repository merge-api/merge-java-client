package dev.merge.api.models.crm

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
import dev.merge.api.models.*
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = AssociationTypeResponse.Builder::class)
@NoAutoDetect
class AssociationTypeResponse
private constructor(
    private val model: JsonField<AssociationType>,
    private val warnings: JsonField<List<ValidationWarning>>,
    private val errors: JsonField<List<ValidationError>>,
    private val logs: JsonField<List<DebugLog>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /**
     * # The AssociationType Object
     *
     * ### Description
     *
     * The `Association Type` object represents the relationship between two objects.
     *
     * ### Usage Example
     *
     * TODO
     */
    fun model(): AssociationType = model.getRequired("model")

    fun warnings(): List<ValidationWarning> = warnings.getRequired("warnings")

    fun errors(): List<ValidationError> = errors.getRequired("errors")

    fun logs(): Optional<List<DebugLog>> = Optional.ofNullable(logs.getNullable("logs"))

    /**
     * # The AssociationType Object
     *
     * ### Description
     *
     * The `Association Type` object represents the relationship between two objects.
     *
     * ### Usage Example
     *
     * TODO
     */
    @JsonProperty("model") @ExcludeMissing fun _model() = model

    @JsonProperty("warnings") @ExcludeMissing fun _warnings() = warnings

    @JsonProperty("errors") @ExcludeMissing fun _errors() = errors

    @JsonProperty("logs") @ExcludeMissing fun _logs() = logs

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): AssociationTypeResponse = apply {
        if (!validated) {
            model().validate()
            warnings().forEach { it.validate() }
            errors().forEach { it.validate() }
            logs().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AssociationTypeResponse &&
            this.model == other.model &&
            this.warnings == other.warnings &&
            this.errors == other.errors &&
            this.logs == other.logs &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    model,
                    warnings,
                    errors,
                    logs,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "AssociationTypeResponse{model=$model, warnings=$warnings, errors=$errors, logs=$logs, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var model: JsonField<AssociationType> = JsonMissing.of()
        private var warnings: JsonField<List<ValidationWarning>> = JsonMissing.of()
        private var errors: JsonField<List<ValidationError>> = JsonMissing.of()
        private var logs: JsonField<List<DebugLog>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(associationTypeResponse: AssociationTypeResponse) = apply {
            this.model = associationTypeResponse.model
            this.warnings = associationTypeResponse.warnings
            this.errors = associationTypeResponse.errors
            this.logs = associationTypeResponse.logs
            additionalProperties(associationTypeResponse.additionalProperties)
        }

        /**
         * # The AssociationType Object
         *
         * ### Description
         *
         * The `Association Type` object represents the relationship between two objects.
         *
         * ### Usage Example
         *
         * TODO
         */
        fun model(model: AssociationType) = model(JsonField.of(model))

        /**
         * # The AssociationType Object
         *
         * ### Description
         *
         * The `Association Type` object represents the relationship between two objects.
         *
         * ### Usage Example
         *
         * TODO
         */
        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<AssociationType>) = apply { this.model = model }

        fun warnings(warnings: List<ValidationWarning>) = warnings(JsonField.of(warnings))

        @JsonProperty("warnings")
        @ExcludeMissing
        fun warnings(warnings: JsonField<List<ValidationWarning>>) = apply {
            this.warnings = warnings
        }

        fun errors(errors: List<ValidationError>) = errors(JsonField.of(errors))

        @JsonProperty("errors")
        @ExcludeMissing
        fun errors(errors: JsonField<List<ValidationError>>) = apply { this.errors = errors }

        fun logs(logs: List<DebugLog>) = logs(JsonField.of(logs))

        @JsonProperty("logs")
        @ExcludeMissing
        fun logs(logs: JsonField<List<DebugLog>>) = apply { this.logs = logs }

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

        fun build(): AssociationTypeResponse =
            AssociationTypeResponse(
                model,
                warnings.map { it.toUnmodifiable() },
                errors.map { it.toUnmodifiable() },
                logs.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }
}
