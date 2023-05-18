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

@JsonDeserialize(builder = RemoteFieldClass.Builder::class)
@NoAutoDetect
class RemoteFieldClass
private constructor(
    private val id: JsonField<String>,
    private val displayName: JsonField<String>,
    private val remoteKeyName: JsonField<String>,
    private val description: JsonField<String>,
    private val isCustom: JsonField<Boolean>,
    private val isRequired: JsonField<Boolean>,
    private val fieldType: JsonField<FieldTypeEnum>,
    private val fieldFormat: JsonField<FieldFormatEnum>,
    private val fieldChoices: JsonField<List<String>>,
    private val itemSchema: JsonField<ItemSchema>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    fun displayName(): Optional<String> =
        Optional.ofNullable(displayName.getNullable("display_name"))

    fun remoteKeyName(): Optional<String> =
        Optional.ofNullable(remoteKeyName.getNullable("remote_key_name"))

    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    fun isCustom(): Optional<Boolean> = Optional.ofNullable(isCustom.getNullable("is_custom"))

    fun isRequired(): Optional<Boolean> = Optional.ofNullable(isRequired.getNullable("is_required"))

    /**
     * - `string` - string
     * - `number` - number
     * - `date` - date
     * - `datetime` - datetime
     * - `bool` - bool
     * - `list` - list
     */
    fun fieldType(): Optional<FieldTypeEnum> =
        Optional.ofNullable(fieldType.getNullable("field_type"))

    /**
     * - `string` - string
     * - `number` - number
     * - `date` - date
     * - `datetime` - datetime
     * - `bool` - bool
     * - `list` - list
     */
    fun fieldFormat(): Optional<FieldFormatEnum> =
        Optional.ofNullable(fieldFormat.getNullable("field_format"))

    fun fieldChoices(): Optional<List<String>> =
        Optional.ofNullable(fieldChoices.getNullable("field_choices"))

    fun itemSchema(): Optional<ItemSchema> =
        Optional.ofNullable(itemSchema.getNullable("item_schema"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("display_name") @ExcludeMissing fun _displayName() = displayName

    @JsonProperty("remote_key_name") @ExcludeMissing fun _remoteKeyName() = remoteKeyName

    @JsonProperty("description") @ExcludeMissing fun _description() = description

    @JsonProperty("is_custom") @ExcludeMissing fun _isCustom() = isCustom

    @JsonProperty("is_required") @ExcludeMissing fun _isRequired() = isRequired

    /**
     * - `string` - string
     * - `number` - number
     * - `date` - date
     * - `datetime` - datetime
     * - `bool` - bool
     * - `list` - list
     */
    @JsonProperty("field_type") @ExcludeMissing fun _fieldType() = fieldType

    /**
     * - `string` - string
     * - `number` - number
     * - `date` - date
     * - `datetime` - datetime
     * - `bool` - bool
     * - `list` - list
     */
    @JsonProperty("field_format") @ExcludeMissing fun _fieldFormat() = fieldFormat

    @JsonProperty("field_choices") @ExcludeMissing fun _fieldChoices() = fieldChoices

    @JsonProperty("item_schema") @ExcludeMissing fun _itemSchema() = itemSchema

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): RemoteFieldClass = apply {
        if (!validated) {
            id()
            displayName()
            remoteKeyName()
            description()
            isCustom()
            isRequired()
            fieldType()
            fieldFormat()
            fieldChoices()
            itemSchema().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RemoteFieldClass &&
            this.id == other.id &&
            this.displayName == other.displayName &&
            this.remoteKeyName == other.remoteKeyName &&
            this.description == other.description &&
            this.isCustom == other.isCustom &&
            this.isRequired == other.isRequired &&
            this.fieldType == other.fieldType &&
            this.fieldFormat == other.fieldFormat &&
            this.fieldChoices == other.fieldChoices &&
            this.itemSchema == other.itemSchema &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    displayName,
                    remoteKeyName,
                    description,
                    isCustom,
                    isRequired,
                    fieldType,
                    fieldFormat,
                    fieldChoices,
                    itemSchema,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "RemoteFieldClass{id=$id, displayName=$displayName, remoteKeyName=$remoteKeyName, description=$description, isCustom=$isCustom, isRequired=$isRequired, fieldType=$fieldType, fieldFormat=$fieldFormat, fieldChoices=$fieldChoices, itemSchema=$itemSchema, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var displayName: JsonField<String> = JsonMissing.of()
        private var remoteKeyName: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var isCustom: JsonField<Boolean> = JsonMissing.of()
        private var isRequired: JsonField<Boolean> = JsonMissing.of()
        private var fieldType: JsonField<FieldTypeEnum> = JsonMissing.of()
        private var fieldFormat: JsonField<FieldFormatEnum> = JsonMissing.of()
        private var fieldChoices: JsonField<List<String>> = JsonMissing.of()
        private var itemSchema: JsonField<ItemSchema> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(remoteFieldClass: RemoteFieldClass) = apply {
            this.id = remoteFieldClass.id
            this.displayName = remoteFieldClass.displayName
            this.remoteKeyName = remoteFieldClass.remoteKeyName
            this.description = remoteFieldClass.description
            this.isCustom = remoteFieldClass.isCustom
            this.isRequired = remoteFieldClass.isRequired
            this.fieldType = remoteFieldClass.fieldType
            this.fieldFormat = remoteFieldClass.fieldFormat
            this.fieldChoices = remoteFieldClass.fieldChoices
            this.itemSchema = remoteFieldClass.itemSchema
            additionalProperties(remoteFieldClass.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun displayName(displayName: String) = displayName(JsonField.of(displayName))

        @JsonProperty("display_name")
        @ExcludeMissing
        fun displayName(displayName: JsonField<String>) = apply { this.displayName = displayName }

        fun remoteKeyName(remoteKeyName: String) = remoteKeyName(JsonField.of(remoteKeyName))

        @JsonProperty("remote_key_name")
        @ExcludeMissing
        fun remoteKeyName(remoteKeyName: JsonField<String>) = apply {
            this.remoteKeyName = remoteKeyName
        }

        fun description(description: String) = description(JsonField.of(description))

        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        fun isCustom(isCustom: Boolean) = isCustom(JsonField.of(isCustom))

        @JsonProperty("is_custom")
        @ExcludeMissing
        fun isCustom(isCustom: JsonField<Boolean>) = apply { this.isCustom = isCustom }

        fun isRequired(isRequired: Boolean) = isRequired(JsonField.of(isRequired))

        @JsonProperty("is_required")
        @ExcludeMissing
        fun isRequired(isRequired: JsonField<Boolean>) = apply { this.isRequired = isRequired }

        /**
         * - `string` - string
         * - `number` - number
         * - `date` - date
         * - `datetime` - datetime
         * - `bool` - bool
         * - `list` - list
         */
        fun fieldType(fieldType: FieldTypeEnum) = fieldType(JsonField.of(fieldType))

        /**
         * - `string` - string
         * - `number` - number
         * - `date` - date
         * - `datetime` - datetime
         * - `bool` - bool
         * - `list` - list
         */
        @JsonProperty("field_type")
        @ExcludeMissing
        fun fieldType(fieldType: JsonField<FieldTypeEnum>) = apply { this.fieldType = fieldType }

        /**
         * - `string` - string
         * - `number` - number
         * - `date` - date
         * - `datetime` - datetime
         * - `bool` - bool
         * - `list` - list
         */
        fun fieldFormat(fieldFormat: FieldFormatEnum) = fieldFormat(JsonField.of(fieldFormat))

        /**
         * - `string` - string
         * - `number` - number
         * - `date` - date
         * - `datetime` - datetime
         * - `bool` - bool
         * - `list` - list
         */
        @JsonProperty("field_format")
        @ExcludeMissing
        fun fieldFormat(fieldFormat: JsonField<FieldFormatEnum>) = apply {
            this.fieldFormat = fieldFormat
        }

        fun fieldChoices(fieldChoices: List<String>) = fieldChoices(JsonField.of(fieldChoices))

        @JsonProperty("field_choices")
        @ExcludeMissing
        fun fieldChoices(fieldChoices: JsonField<List<String>>) = apply {
            this.fieldChoices = fieldChoices
        }

        fun itemSchema(itemSchema: ItemSchema) = itemSchema(JsonField.of(itemSchema))

        @JsonProperty("item_schema")
        @ExcludeMissing
        fun itemSchema(itemSchema: JsonField<ItemSchema>) = apply { this.itemSchema = itemSchema }

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

        fun build(): RemoteFieldClass =
            RemoteFieldClass(
                id,
                displayName,
                remoteKeyName,
                description,
                isCustom,
                isRequired,
                fieldType,
                fieldFormat,
                fieldChoices.map { it.toUnmodifiable() },
                itemSchema,
                additionalProperties.toUnmodifiable(),
            )
    }

    class FieldTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FieldTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val STRING = FieldTypeEnum(JsonField.of("string"))

            @JvmField val NUMBER = FieldTypeEnum(JsonField.of("number"))

            @JvmField val DATE = FieldTypeEnum(JsonField.of("date"))

            @JvmField val DATETIME = FieldTypeEnum(JsonField.of("datetime"))

            @JvmField val BOOL = FieldTypeEnum(JsonField.of("bool"))

            @JvmField val LIST = FieldTypeEnum(JsonField.of("list"))

            @JvmStatic fun of(value: String) = FieldTypeEnum(JsonField.of(value))
        }

        enum class Known {
            STRING,
            NUMBER,
            DATE,
            DATETIME,
            BOOL,
            LIST,
        }

        enum class Value {
            STRING,
            NUMBER,
            DATE,
            DATETIME,
            BOOL,
            LIST,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STRING -> Value.STRING
                NUMBER -> Value.NUMBER
                DATE -> Value.DATE
                DATETIME -> Value.DATETIME
                BOOL -> Value.BOOL
                LIST -> Value.LIST
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STRING -> Known.STRING
                NUMBER -> Known.NUMBER
                DATE -> Known.DATE
                DATETIME -> Known.DATETIME
                BOOL -> Known.BOOL
                LIST -> Known.LIST
                else -> throw MergeInvalidDataException("Unknown FieldTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class FieldFormatEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FieldFormatEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val STRING = FieldFormatEnum(JsonField.of("string"))

            @JvmField val NUMBER = FieldFormatEnum(JsonField.of("number"))

            @JvmField val DATE = FieldFormatEnum(JsonField.of("date"))

            @JvmField val DATETIME = FieldFormatEnum(JsonField.of("datetime"))

            @JvmField val BOOL = FieldFormatEnum(JsonField.of("bool"))

            @JvmField val LIST = FieldFormatEnum(JsonField.of("list"))

            @JvmStatic fun of(value: String) = FieldFormatEnum(JsonField.of(value))
        }

        enum class Known {
            STRING,
            NUMBER,
            DATE,
            DATETIME,
            BOOL,
            LIST,
        }

        enum class Value {
            STRING,
            NUMBER,
            DATE,
            DATETIME,
            BOOL,
            LIST,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STRING -> Value.STRING
                NUMBER -> Value.NUMBER
                DATE -> Value.DATE
                DATETIME -> Value.DATETIME
                BOOL -> Value.BOOL
                LIST -> Value.LIST
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STRING -> Known.STRING
                NUMBER -> Known.NUMBER
                DATE -> Known.DATE
                DATETIME -> Known.DATETIME
                BOOL -> Known.BOOL
                LIST -> Known.LIST
                else -> throw MergeInvalidDataException("Unknown FieldFormatEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = ItemSchema.Builder::class)
    @NoAutoDetect
    class ItemSchema
    private constructor(
        private val itemType: JsonValue,
        private val itemFormat: JsonValue,
        private val itemChoices: JsonField<List<String>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun itemChoices(): Optional<List<String>> =
            Optional.ofNullable(itemChoices.getNullable("item_choices"))

        @JsonProperty("item_type") @ExcludeMissing fun _itemType() = itemType

        @JsonProperty("item_format") @ExcludeMissing fun _itemFormat() = itemFormat

        @JsonProperty("item_choices") @ExcludeMissing fun _itemChoices() = itemChoices

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): ItemSchema = apply {
            if (!validated) {
                itemChoices()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ItemSchema &&
                this.itemType == other.itemType &&
                this.itemFormat == other.itemFormat &&
                this.itemChoices == other.itemChoices &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        itemType,
                        itemFormat,
                        itemChoices,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ItemSchema{itemType=$itemType, itemFormat=$itemFormat, itemChoices=$itemChoices, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var itemType: JsonValue = JsonMissing.of()
            private var itemFormat: JsonValue = JsonMissing.of()
            private var itemChoices: JsonField<List<String>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(itemSchema: ItemSchema) = apply {
                this.itemType = itemSchema.itemType
                this.itemFormat = itemSchema.itemFormat
                this.itemChoices = itemSchema.itemChoices
                additionalProperties(itemSchema.additionalProperties)
            }

            @JsonProperty("item_type")
            @ExcludeMissing
            fun itemType(itemType: JsonValue) = apply { this.itemType = itemType }

            @JsonProperty("item_format")
            @ExcludeMissing
            fun itemFormat(itemFormat: JsonValue) = apply { this.itemFormat = itemFormat }

            fun itemChoices(itemChoices: List<String>) = itemChoices(JsonField.of(itemChoices))

            @JsonProperty("item_choices")
            @ExcludeMissing
            fun itemChoices(itemChoices: JsonField<List<String>>) = apply {
                this.itemChoices = itemChoices
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

            fun build(): ItemSchema =
                ItemSchema(
                    itemType,
                    itemFormat,
                    itemChoices.map { it.toUnmodifiable() },
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
