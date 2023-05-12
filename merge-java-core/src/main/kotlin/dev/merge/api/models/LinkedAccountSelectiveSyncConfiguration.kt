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

@JsonDeserialize(builder = LinkedAccountSelectiveSyncConfiguration.Builder::class)
@NoAutoDetect
class LinkedAccountSelectiveSyncConfiguration
private constructor(
    private val linkedAccountConditions: JsonField<List<LinkedAccountCondition>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The conditions belonging to a selective sync. */
    fun linkedAccountConditions(): Optional<List<LinkedAccountCondition>> =
        Optional.ofNullable(linkedAccountConditions.getNullable("linked_account_conditions"))

    /** The conditions belonging to a selective sync. */
    @JsonProperty("linked_account_conditions")
    @ExcludeMissing
    fun _linkedAccountConditions() = linkedAccountConditions

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            linkedAccountConditions().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is LinkedAccountSelectiveSyncConfiguration &&
            this.linkedAccountConditions == other.linkedAccountConditions &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = Objects.hash(linkedAccountConditions, additionalProperties)
        }
        return hashCode
    }

    override fun toString() =
        "LinkedAccountSelectiveSyncConfiguration{linkedAccountConditions=$linkedAccountConditions, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var linkedAccountConditions: JsonField<List<LinkedAccountCondition>> =
            JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            linkedAccountSelectiveSyncConfiguration: LinkedAccountSelectiveSyncConfiguration
        ) = apply {
            this.linkedAccountConditions =
                linkedAccountSelectiveSyncConfiguration.linkedAccountConditions
            additionalProperties(linkedAccountSelectiveSyncConfiguration.additionalProperties)
        }

        /** The conditions belonging to a selective sync. */
        fun linkedAccountConditions(linkedAccountConditions: List<LinkedAccountCondition>) =
            linkedAccountConditions(JsonField.of(linkedAccountConditions))

        /** The conditions belonging to a selective sync. */
        @JsonProperty("linked_account_conditions")
        @ExcludeMissing
        fun linkedAccountConditions(
            linkedAccountConditions: JsonField<List<LinkedAccountCondition>>
        ) = apply { this.linkedAccountConditions = linkedAccountConditions }

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

        fun build(): LinkedAccountSelectiveSyncConfiguration =
            LinkedAccountSelectiveSyncConfiguration(
                linkedAccountConditions.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable()
            )
    }

    @JsonDeserialize(builder = LinkedAccountCondition.Builder::class)
    @NoAutoDetect
    class LinkedAccountCondition
    private constructor(
        private val conditionSchemaId: JsonField<String>,
        private val commonModel: JsonField<String>,
        private val nativeName: JsonField<String>,
        private val operator: JsonField<String>,
        private val value: JsonValue,
        private val fieldName: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** The ID indicating which condition schema to use for a specific condition. */
        fun conditionSchemaId(): String = conditionSchemaId.getRequired("condition_schema_id")

        /** The common model for a specific condition. */
        fun commonModel(): Optional<String> =
            Optional.ofNullable(commonModel.getNullable("common_model"))

        /** User-facing _native condition_ name. e.g. "Skip Manager". */
        fun nativeName(): Optional<String> =
            Optional.ofNullable(nativeName.getNullable("native_name"))

        /** The operator for a specific condition. */
        fun operator(): String = operator.getRequired("operator")

        /**
         * The name of the field on the common model that this condition corresponds to, if they
         * conceptually match. e.g. "location_type".
         */
        fun fieldName(): Optional<String> = Optional.ofNullable(fieldName.getNullable("field_name"))

        /** The ID indicating which condition schema to use for a specific condition. */
        @JsonProperty("condition_schema_id")
        @ExcludeMissing
        fun _conditionSchemaId() = conditionSchemaId

        /** The common model for a specific condition. */
        @JsonProperty("common_model") @ExcludeMissing fun _commonModel() = commonModel

        /** User-facing _native condition_ name. e.g. "Skip Manager". */
        @JsonProperty("native_name") @ExcludeMissing fun _nativeName() = nativeName

        /** The operator for a specific condition. */
        @JsonProperty("operator") @ExcludeMissing fun _operator() = operator

        /** The value for a condition. */
        @JsonProperty("value") @ExcludeMissing fun _value() = value

        /**
         * The name of the field on the common model that this condition corresponds to, if they
         * conceptually match. e.g. "location_type".
         */
        @JsonProperty("field_name") @ExcludeMissing fun _fieldName() = fieldName

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                conditionSchemaId()
                commonModel()
                nativeName()
                operator()
                fieldName()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LinkedAccountCondition &&
                this.conditionSchemaId == other.conditionSchemaId &&
                this.commonModel == other.commonModel &&
                this.nativeName == other.nativeName &&
                this.operator == other.operator &&
                this.value == other.value &&
                this.fieldName == other.fieldName &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        conditionSchemaId,
                        commonModel,
                        nativeName,
                        operator,
                        value,
                        fieldName,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "LinkedAccountCondition{conditionSchemaId=$conditionSchemaId, commonModel=$commonModel, nativeName=$nativeName, operator=$operator, value=$value, fieldName=$fieldName, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var conditionSchemaId: JsonField<String> = JsonMissing.of()
            private var commonModel: JsonField<String> = JsonMissing.of()
            private var nativeName: JsonField<String> = JsonMissing.of()
            private var operator: JsonField<String> = JsonMissing.of()
            private var value: JsonValue = JsonMissing.of()
            private var fieldName: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(linkedAccountCondition: LinkedAccountCondition) = apply {
                this.conditionSchemaId = linkedAccountCondition.conditionSchemaId
                this.commonModel = linkedAccountCondition.commonModel
                this.nativeName = linkedAccountCondition.nativeName
                this.operator = linkedAccountCondition.operator
                this.value = linkedAccountCondition.value
                this.fieldName = linkedAccountCondition.fieldName
                additionalProperties(linkedAccountCondition.additionalProperties)
            }

            /** The ID indicating which condition schema to use for a specific condition. */
            fun conditionSchemaId(conditionSchemaId: String) =
                conditionSchemaId(JsonField.of(conditionSchemaId))

            /** The ID indicating which condition schema to use for a specific condition. */
            @JsonProperty("condition_schema_id")
            @ExcludeMissing
            fun conditionSchemaId(conditionSchemaId: JsonField<String>) = apply {
                this.conditionSchemaId = conditionSchemaId
            }

            /** The common model for a specific condition. */
            fun commonModel(commonModel: String) = commonModel(JsonField.of(commonModel))

            /** The common model for a specific condition. */
            @JsonProperty("common_model")
            @ExcludeMissing
            fun commonModel(commonModel: JsonField<String>) = apply {
                this.commonModel = commonModel
            }

            /** User-facing _native condition_ name. e.g. "Skip Manager". */
            fun nativeName(nativeName: String) = nativeName(JsonField.of(nativeName))

            /** User-facing _native condition_ name. e.g. "Skip Manager". */
            @JsonProperty("native_name")
            @ExcludeMissing
            fun nativeName(nativeName: JsonField<String>) = apply { this.nativeName = nativeName }

            /** The operator for a specific condition. */
            fun operator(operator: String) = operator(JsonField.of(operator))

            /** The operator for a specific condition. */
            @JsonProperty("operator")
            @ExcludeMissing
            fun operator(operator: JsonField<String>) = apply { this.operator = operator }

            /** The value for a condition. */
            @JsonProperty("value")
            @ExcludeMissing
            fun value(value: JsonValue) = apply { this.value = value }

            /**
             * The name of the field on the common model that this condition corresponds to, if they
             * conceptually match. e.g. "location_type".
             */
            fun fieldName(fieldName: String) = fieldName(JsonField.of(fieldName))

            /**
             * The name of the field on the common model that this condition corresponds to, if they
             * conceptually match. e.g. "location_type".
             */
            @JsonProperty("field_name")
            @ExcludeMissing
            fun fieldName(fieldName: JsonField<String>) = apply { this.fieldName = fieldName }

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

            fun build(): LinkedAccountCondition =
                LinkedAccountCondition(
                    conditionSchemaId,
                    commonModel,
                    nativeName,
                    operator,
                    value,
                    fieldName,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
