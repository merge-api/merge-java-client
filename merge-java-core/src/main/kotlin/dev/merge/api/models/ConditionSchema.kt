package dev.merge.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = ConditionSchema.Builder::class)
@NoAutoDetect
class ConditionSchema
private constructor(
    private val id: JsonField<String>,
    private val commonModel: JsonField<String>,
    private val nativeName: JsonField<String>,
    private val fieldName: JsonField<String>,
    private val isUnique: JsonField<Boolean>,
    private val conditionType: JsonField<ConditionTypeEnum>,
    private val operators: JsonField<List<OperatorSchema>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /**
     * The ID of the condition schema. This ID is used when updating selective syncs for a linked
     * account.
     */
    fun id(): String = id.getRequired("id")

    /** The common model for which a condition schema is defined. */
    fun commonModel(): Optional<String> =
        Optional.ofNullable(commonModel.getNullable("common_model"))

    /** User-facing _native condition_ name. e.g. "Skip Manager". */
    fun nativeName(): Optional<String> = Optional.ofNullable(nativeName.getNullable("native_name"))

    /**
     * The name of the field on the common model that this condition corresponds to, if they
     * conceptually match. e.g. "location_type".
     */
    fun fieldName(): Optional<String> = Optional.ofNullable(fieldName.getNullable("field_name"))

    /**
     * Whether this condition can only be applied once. If false, the condition can be AND'd
     * together multiple times.
     */
    fun isUnique(): Optional<Boolean> = Optional.ofNullable(isUnique.getNullable("is_unique"))

    /**
     * - `BOOLEAN` - BOOLEAN
     * - `DATE` - DATE
     * - `DATE_TIME` - DATE_TIME
     * - `INTEGER` - INTEGER
     * - `FLOAT` - FLOAT
     * - `STRING` - STRING
     * - `LIST_OF_STRINGS` - LIST_OF_STRINGS
     */
    fun conditionType(): ConditionTypeEnum = conditionType.getRequired("condition_type")

    /** The schemas for the operators that can be used on a condition. */
    fun operators(): List<OperatorSchema> = operators.getRequired("operators")

    /**
     * The ID of the condition schema. This ID is used when updating selective syncs for a linked
     * account.
     */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The common model for which a condition schema is defined. */
    @JsonProperty("common_model") @ExcludeMissing fun _commonModel() = commonModel

    /** User-facing _native condition_ name. e.g. "Skip Manager". */
    @JsonProperty("native_name") @ExcludeMissing fun _nativeName() = nativeName

    /**
     * The name of the field on the common model that this condition corresponds to, if they
     * conceptually match. e.g. "location_type".
     */
    @JsonProperty("field_name") @ExcludeMissing fun _fieldName() = fieldName

    /**
     * Whether this condition can only be applied once. If false, the condition can be AND'd
     * together multiple times.
     */
    @JsonProperty("is_unique") @ExcludeMissing fun _isUnique() = isUnique

    /**
     * - `BOOLEAN` - BOOLEAN
     * - `DATE` - DATE
     * - `DATE_TIME` - DATE_TIME
     * - `INTEGER` - INTEGER
     * - `FLOAT` - FLOAT
     * - `STRING` - STRING
     * - `LIST_OF_STRINGS` - LIST_OF_STRINGS
     */
    @JsonProperty("condition_type") @ExcludeMissing fun _conditionType() = conditionType

    /** The schemas for the operators that can be used on a condition. */
    @JsonProperty("operators") @ExcludeMissing fun _operators() = operators

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            id()
            commonModel()
            nativeName()
            fieldName()
            isUnique()
            conditionType()
            operators().forEach { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ConditionSchema &&
            this.id == other.id &&
            this.commonModel == other.commonModel &&
            this.nativeName == other.nativeName &&
            this.fieldName == other.fieldName &&
            this.isUnique == other.isUnique &&
            this.conditionType == other.conditionType &&
            this.operators == other.operators &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    commonModel,
                    nativeName,
                    fieldName,
                    isUnique,
                    conditionType,
                    operators,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ConditionSchema{id=$id, commonModel=$commonModel, nativeName=$nativeName, fieldName=$fieldName, isUnique=$isUnique, conditionType=$conditionType, operators=$operators, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var commonModel: JsonField<String> = JsonMissing.of()
        private var nativeName: JsonField<String> = JsonMissing.of()
        private var fieldName: JsonField<String> = JsonMissing.of()
        private var isUnique: JsonField<Boolean> = JsonMissing.of()
        private var conditionType: JsonField<ConditionTypeEnum> = JsonMissing.of()
        private var operators: JsonField<List<OperatorSchema>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(conditionSchema: ConditionSchema) = apply {
            this.id = conditionSchema.id
            this.commonModel = conditionSchema.commonModel
            this.nativeName = conditionSchema.nativeName
            this.fieldName = conditionSchema.fieldName
            this.isUnique = conditionSchema.isUnique
            this.conditionType = conditionSchema.conditionType
            this.operators = conditionSchema.operators
            additionalProperties(conditionSchema.additionalProperties)
        }

        /**
         * The ID of the condition schema. This ID is used when updating selective syncs for a
         * linked account.
         */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * The ID of the condition schema. This ID is used when updating selective syncs for a
         * linked account.
         */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The common model for which a condition schema is defined. */
        fun commonModel(commonModel: String) = commonModel(JsonField.of(commonModel))

        /** The common model for which a condition schema is defined. */
        @JsonProperty("common_model")
        @ExcludeMissing
        fun commonModel(commonModel: JsonField<String>) = apply { this.commonModel = commonModel }

        /** User-facing _native condition_ name. e.g. "Skip Manager". */
        fun nativeName(nativeName: String) = nativeName(JsonField.of(nativeName))

        /** User-facing _native condition_ name. e.g. "Skip Manager". */
        @JsonProperty("native_name")
        @ExcludeMissing
        fun nativeName(nativeName: JsonField<String>) = apply { this.nativeName = nativeName }

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

        /**
         * Whether this condition can only be applied once. If false, the condition can be AND'd
         * together multiple times.
         */
        fun isUnique(isUnique: Boolean) = isUnique(JsonField.of(isUnique))

        /**
         * Whether this condition can only be applied once. If false, the condition can be AND'd
         * together multiple times.
         */
        @JsonProperty("is_unique")
        @ExcludeMissing
        fun isUnique(isUnique: JsonField<Boolean>) = apply { this.isUnique = isUnique }

        /**
         * - `BOOLEAN` - BOOLEAN
         * - `DATE` - DATE
         * - `DATE_TIME` - DATE_TIME
         * - `INTEGER` - INTEGER
         * - `FLOAT` - FLOAT
         * - `STRING` - STRING
         * - `LIST_OF_STRINGS` - LIST_OF_STRINGS
         */
        fun conditionType(conditionType: ConditionTypeEnum) =
            conditionType(JsonField.of(conditionType))

        /**
         * - `BOOLEAN` - BOOLEAN
         * - `DATE` - DATE
         * - `DATE_TIME` - DATE_TIME
         * - `INTEGER` - INTEGER
         * - `FLOAT` - FLOAT
         * - `STRING` - STRING
         * - `LIST_OF_STRINGS` - LIST_OF_STRINGS
         */
        @JsonProperty("condition_type")
        @ExcludeMissing
        fun conditionType(conditionType: JsonField<ConditionTypeEnum>) = apply {
            this.conditionType = conditionType
        }

        /** The schemas for the operators that can be used on a condition. */
        fun operators(operators: List<OperatorSchema>) = operators(JsonField.of(operators))

        /** The schemas for the operators that can be used on a condition. */
        @JsonProperty("operators")
        @ExcludeMissing
        fun operators(operators: JsonField<List<OperatorSchema>>) = apply {
            this.operators = operators
        }

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

        fun build(): ConditionSchema =
            ConditionSchema(
                id,
                commonModel,
                nativeName,
                fieldName,
                isUnique,
                conditionType,
                operators.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class ConditionTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ConditionTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val BOOLEAN = ConditionTypeEnum(JsonField.of("BOOLEAN"))

            @JvmField val DATE = ConditionTypeEnum(JsonField.of("DATE"))

            @JvmField val DATE_TIME = ConditionTypeEnum(JsonField.of("DATE_TIME"))

            @JvmField val INTEGER = ConditionTypeEnum(JsonField.of("INTEGER"))

            @JvmField val FLOAT = ConditionTypeEnum(JsonField.of("FLOAT"))

            @JvmField val STRING = ConditionTypeEnum(JsonField.of("STRING"))

            @JvmField val LIST_OF_STRINGS = ConditionTypeEnum(JsonField.of("LIST_OF_STRINGS"))

            @JvmStatic fun of(value: String) = ConditionTypeEnum(JsonField.of(value))
        }

        enum class Known {
            BOOLEAN,
            DATE,
            DATE_TIME,
            INTEGER,
            FLOAT,
            STRING,
            LIST_OF_STRINGS,
        }

        enum class Value {
            BOOLEAN,
            DATE,
            DATE_TIME,
            INTEGER,
            FLOAT,
            STRING,
            LIST_OF_STRINGS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                BOOLEAN -> Value.BOOLEAN
                DATE -> Value.DATE
                DATE_TIME -> Value.DATE_TIME
                INTEGER -> Value.INTEGER
                FLOAT -> Value.FLOAT
                STRING -> Value.STRING
                LIST_OF_STRINGS -> Value.LIST_OF_STRINGS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                BOOLEAN -> Known.BOOLEAN
                DATE -> Known.DATE
                DATE_TIME -> Known.DATE_TIME
                INTEGER -> Known.INTEGER
                FLOAT -> Known.FLOAT
                STRING -> Known.STRING
                LIST_OF_STRINGS -> Known.LIST_OF_STRINGS
                else -> throw MergeInvalidDataException("Unknown ConditionTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = OperatorSchema.Builder::class)
    @NoAutoDetect
    class OperatorSchema
    private constructor(
        private val operator: JsonField<String>,
        private val isUnique: JsonField<Boolean>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** The operator for which an operator schema is defined. */
        fun operator(): Optional<String> = Optional.ofNullable(operator.getNullable("operator"))

        /** Whether the operator can be repeated multiple times. */
        fun isUnique(): Optional<Boolean> = Optional.ofNullable(isUnique.getNullable("is_unique"))

        /** The operator for which an operator schema is defined. */
        @JsonProperty("operator") @ExcludeMissing fun _operator() = operator

        /** Whether the operator can be repeated multiple times. */
        @JsonProperty("is_unique") @ExcludeMissing fun _isUnique() = isUnique

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                operator()
                isUnique()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OperatorSchema &&
                this.operator == other.operator &&
                this.isUnique == other.isUnique &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        operator,
                        isUnique,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "OperatorSchema{operator=$operator, isUnique=$isUnique, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var operator: JsonField<String> = JsonMissing.of()
            private var isUnique: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(operatorSchema: OperatorSchema) = apply {
                this.operator = operatorSchema.operator
                this.isUnique = operatorSchema.isUnique
                additionalProperties(operatorSchema.additionalProperties)
            }

            /** The operator for which an operator schema is defined. */
            fun operator(operator: String) = operator(JsonField.of(operator))

            /** The operator for which an operator schema is defined. */
            @JsonProperty("operator")
            @ExcludeMissing
            fun operator(operator: JsonField<String>) = apply { this.operator = operator }

            /** Whether the operator can be repeated multiple times. */
            fun isUnique(isUnique: Boolean) = isUnique(JsonField.of(isUnique))

            /** Whether the operator can be repeated multiple times. */
            @JsonProperty("is_unique")
            @ExcludeMissing
            fun isUnique(isUnique: JsonField<Boolean>) = apply { this.isUnique = isUnique }

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

            fun build(): OperatorSchema =
                OperatorSchema(
                    operator,
                    isUnique,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
