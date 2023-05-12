package dev.merge.api.models.crm

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
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

/**
 * # The Custom Object Class Object
 *
 * ### Description
 *
 * The `Custom Object Class` object is used to represent a Custom Object Schema in the remote
 * system.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = CustomObjectClass.Builder::class)
@NoAutoDetect
class CustomObjectClass
private constructor(
    private val name: JsonField<String>,
    private val description: JsonField<String>,
    private val labels: JsonField<Labels>,
    private val fields: JsonField<List<RemoteFieldClassForCustomObjectClass>>,
    private val associationTypes: JsonField<List<JsonValue>>,
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    fun labels(): Optional<Labels> = Optional.ofNullable(labels.getNullable("labels"))

    fun fields(): Optional<List<RemoteFieldClassForCustomObjectClass>> =
        Optional.ofNullable(fields.getNullable("fields"))

    fun associationTypes(): Optional<List<JsonValue>> =
        Optional.ofNullable(associationTypes.getNullable("association_types"))

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    @JsonProperty("name") @ExcludeMissing fun _name() = name

    @JsonProperty("description") @ExcludeMissing fun _description() = description

    @JsonProperty("labels") @ExcludeMissing fun _labels() = labels

    @JsonProperty("fields") @ExcludeMissing fun _fields() = fields

    @JsonProperty("association_types") @ExcludeMissing fun _associationTypes() = associationTypes

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            name()
            description()
            labels().map { it.validate() }
            fields().map { it.forEach { it.validate() } }
            associationTypes()
            id()
            remoteId()
            modifiedAt()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CustomObjectClass &&
            this.name == other.name &&
            this.description == other.description &&
            this.labels == other.labels &&
            this.fields == other.fields &&
            this.associationTypes == other.associationTypes &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.modifiedAt == other.modifiedAt &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    name,
                    description,
                    labels,
                    fields,
                    associationTypes,
                    id,
                    remoteId,
                    modifiedAt,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "CustomObjectClass{name=$name, description=$description, labels=$labels, fields=$fields, associationTypes=$associationTypes, id=$id, remoteId=$remoteId, modifiedAt=$modifiedAt, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var labels: JsonField<Labels> = JsonMissing.of()
        private var fields: JsonField<List<RemoteFieldClassForCustomObjectClass>> = JsonMissing.of()
        private var associationTypes: JsonField<List<JsonValue>> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(customObjectClass: CustomObjectClass) = apply {
            this.name = customObjectClass.name
            this.description = customObjectClass.description
            this.labels = customObjectClass.labels
            this.fields = customObjectClass.fields
            this.associationTypes = customObjectClass.associationTypes
            this.id = customObjectClass.id
            this.remoteId = customObjectClass.remoteId
            this.modifiedAt = customObjectClass.modifiedAt
            additionalProperties(customObjectClass.additionalProperties)
        }

        fun name(name: String) = name(JsonField.of(name))

        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun description(description: String) = description(JsonField.of(description))

        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        fun labels(labels: Labels) = labels(JsonField.of(labels))

        @JsonProperty("labels")
        @ExcludeMissing
        fun labels(labels: JsonField<Labels>) = apply { this.labels = labels }

        fun fields(fields: List<RemoteFieldClassForCustomObjectClass>) =
            fields(JsonField.of(fields))

        @JsonProperty("fields")
        @ExcludeMissing
        fun fields(fields: JsonField<List<RemoteFieldClassForCustomObjectClass>>) = apply {
            this.fields = fields
        }

        fun associationTypes(associationTypes: List<JsonValue>) =
            associationTypes(JsonField.of(associationTypes))

        @JsonProperty("association_types")
        @ExcludeMissing
        fun associationTypes(associationTypes: JsonField<List<JsonValue>>) = apply {
            this.associationTypes = associationTypes
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

        @JsonProperty("modified_at")
        @ExcludeMissing
        fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
            this.modifiedAt = modifiedAt
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

        fun build(): CustomObjectClass =
            CustomObjectClass(
                name,
                description,
                labels,
                fields.map { it.toUnmodifiable() },
                associationTypes.map { it.toUnmodifiable() },
                id,
                remoteId,
                modifiedAt,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = Labels.Builder::class)
    @NoAutoDetect
    class Labels
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Labels && this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(additionalProperties)
            }
            return hashCode
        }

        override fun toString() = "Labels{additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(labels: Labels) = apply {
                additionalProperties(labels.additionalProperties)
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

            fun build(): Labels = Labels(additionalProperties.toUnmodifiable())
        }
    }

    @JsonDeserialize(builder = RemoteFieldClassForCustomObjectClass.Builder::class)
    @NoAutoDetect
    class RemoteFieldClassForCustomObjectClass
    private constructor(
        private val displayName: JsonField<String>,
        private val remoteKeyName: JsonField<String>,
        private val description: JsonField<String>,
        private val isRequired: JsonField<Boolean>,
        private val fieldType: JsonField<FieldTypeEnum>,
        private val fieldFormat: JsonField<FieldFormatEnum>,
        private val fieldChoices: JsonField<List<String>>,
        private val itemSchema: JsonField<ItemSchema>,
        private val modifiedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun displayName(): Optional<String> =
            Optional.ofNullable(displayName.getNullable("display_name"))

        fun remoteKeyName(): Optional<String> =
            Optional.ofNullable(remoteKeyName.getNullable("remote_key_name"))

        fun description(): Optional<String> =
            Optional.ofNullable(description.getNullable("description"))

        fun isRequired(): Optional<Boolean> =
            Optional.ofNullable(isRequired.getNullable("is_required"))

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

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(): Optional<OffsetDateTime> =
            Optional.ofNullable(modifiedAt.getNullable("modified_at"))

        @JsonProperty("display_name") @ExcludeMissing fun _displayName() = displayName

        @JsonProperty("remote_key_name") @ExcludeMissing fun _remoteKeyName() = remoteKeyName

        @JsonProperty("description") @ExcludeMissing fun _description() = description

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

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                displayName()
                remoteKeyName()
                description()
                isRequired()
                fieldType()
                fieldFormat()
                fieldChoices()
                itemSchema().map { it.validate() }
                modifiedAt()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RemoteFieldClassForCustomObjectClass &&
                this.displayName == other.displayName &&
                this.remoteKeyName == other.remoteKeyName &&
                this.description == other.description &&
                this.isRequired == other.isRequired &&
                this.fieldType == other.fieldType &&
                this.fieldFormat == other.fieldFormat &&
                this.fieldChoices == other.fieldChoices &&
                this.itemSchema == other.itemSchema &&
                this.modifiedAt == other.modifiedAt &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        displayName,
                        remoteKeyName,
                        description,
                        isRequired,
                        fieldType,
                        fieldFormat,
                        fieldChoices,
                        itemSchema,
                        modifiedAt,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "RemoteFieldClassForCustomObjectClass{displayName=$displayName, remoteKeyName=$remoteKeyName, description=$description, isRequired=$isRequired, fieldType=$fieldType, fieldFormat=$fieldFormat, fieldChoices=$fieldChoices, itemSchema=$itemSchema, modifiedAt=$modifiedAt, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var displayName: JsonField<String> = JsonMissing.of()
            private var remoteKeyName: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var isRequired: JsonField<Boolean> = JsonMissing.of()
            private var fieldType: JsonField<FieldTypeEnum> = JsonMissing.of()
            private var fieldFormat: JsonField<FieldFormatEnum> = JsonMissing.of()
            private var fieldChoices: JsonField<List<String>> = JsonMissing.of()
            private var itemSchema: JsonField<ItemSchema> = JsonMissing.of()
            private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                remoteFieldClassForCustomObjectClass: RemoteFieldClassForCustomObjectClass
            ) = apply {
                this.displayName = remoteFieldClassForCustomObjectClass.displayName
                this.remoteKeyName = remoteFieldClassForCustomObjectClass.remoteKeyName
                this.description = remoteFieldClassForCustomObjectClass.description
                this.isRequired = remoteFieldClassForCustomObjectClass.isRequired
                this.fieldType = remoteFieldClassForCustomObjectClass.fieldType
                this.fieldFormat = remoteFieldClassForCustomObjectClass.fieldFormat
                this.fieldChoices = remoteFieldClassForCustomObjectClass.fieldChoices
                this.itemSchema = remoteFieldClassForCustomObjectClass.itemSchema
                this.modifiedAt = remoteFieldClassForCustomObjectClass.modifiedAt
                additionalProperties(remoteFieldClassForCustomObjectClass.additionalProperties)
            }

            fun displayName(displayName: String) = displayName(JsonField.of(displayName))

            @JsonProperty("display_name")
            @ExcludeMissing
            fun displayName(displayName: JsonField<String>) = apply {
                this.displayName = displayName
            }

            fun remoteKeyName(remoteKeyName: String) = remoteKeyName(JsonField.of(remoteKeyName))

            @JsonProperty("remote_key_name")
            @ExcludeMissing
            fun remoteKeyName(remoteKeyName: JsonField<String>) = apply {
                this.remoteKeyName = remoteKeyName
            }

            fun description(description: String) = description(JsonField.of(description))

            @JsonProperty("description")
            @ExcludeMissing
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

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
            fun fieldType(fieldType: JsonField<FieldTypeEnum>) = apply {
                this.fieldType = fieldType
            }

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
            fun itemSchema(itemSchema: JsonField<ItemSchema>) = apply {
                this.itemSchema = itemSchema
            }

            /** This is the datetime that this object was last updated by Merge */
            fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

            /** This is the datetime that this object was last updated by Merge */
            @JsonProperty("modified_at")
            @ExcludeMissing
            fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
                this.modifiedAt = modifiedAt
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

            fun build(): RemoteFieldClassForCustomObjectClass =
                RemoteFieldClassForCustomObjectClass(
                    displayName,
                    remoteKeyName,
                    description,
                    isRequired,
                    fieldType,
                    fieldFormat,
                    fieldChoices.map { it.toUnmodifiable() },
                    itemSchema,
                    modifiedAt,
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
            private val itemType: JsonField<String>,
            private val itemFormat: JsonField<String>,
            private val itemChoices: JsonField<List<String>>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            fun itemType(): Optional<String> =
                Optional.ofNullable(itemType.getNullable("item_type"))

            fun itemFormat(): Optional<String> =
                Optional.ofNullable(itemFormat.getNullable("item_format"))

            fun itemChoices(): Optional<List<String>> =
                Optional.ofNullable(itemChoices.getNullable("item_choices"))

            @JsonProperty("item_type") @ExcludeMissing fun _itemType() = itemType

            @JsonProperty("item_format") @ExcludeMissing fun _itemFormat() = itemFormat

            @JsonProperty("item_choices") @ExcludeMissing fun _itemChoices() = itemChoices

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate() = apply {
                if (!validated) {
                    itemType()
                    itemFormat()
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

                private var itemType: JsonField<String> = JsonMissing.of()
                private var itemFormat: JsonField<String> = JsonMissing.of()
                private var itemChoices: JsonField<List<String>> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(itemSchema: ItemSchema) = apply {
                    this.itemType = itemSchema.itemType
                    this.itemFormat = itemSchema.itemFormat
                    this.itemChoices = itemSchema.itemChoices
                    additionalProperties(itemSchema.additionalProperties)
                }

                fun itemType(itemType: String) = itemType(JsonField.of(itemType))

                @JsonProperty("item_type")
                @ExcludeMissing
                fun itemType(itemType: JsonField<String>) = apply { this.itemType = itemType }

                fun itemFormat(itemFormat: String) = itemFormat(JsonField.of(itemFormat))

                @JsonProperty("item_format")
                @ExcludeMissing
                fun itemFormat(itemFormat: JsonField<String>) = apply {
                    this.itemFormat = itemFormat
                }

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

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
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
}
