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
@JsonDeserialize(builder = AssociationType.Builder::class)
@NoAutoDetect
class AssociationType
private constructor(
    private val sourceObjectClass: JsonValue,
    private val targetObjectClasses: JsonField<List<AssociationSubType>>,
    private val remoteKeyName: JsonField<String>,
    private val displayName: JsonField<String>,
    private val cardinality: JsonField<CardinalityEnum>,
    private val isRequired: JsonField<Boolean>,
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun targetObjectClasses(): Optional<List<AssociationSubType>> =
        Optional.ofNullable(targetObjectClasses.getNullable("target_object_classes"))

    fun remoteKeyName(): Optional<String> =
        Optional.ofNullable(remoteKeyName.getNullable("remote_key_name"))

    fun displayName(): Optional<String> =
        Optional.ofNullable(displayName.getNullable("display_name"))

    /**
     * - `ONE_TO_ONE` - ONE_TO_ONE
     * - `MANY_TO_ONE` - MANY_TO_ONE
     * - `MANY_TO_MANY` - MANY_TO_MANY
     * - `ONE_TO_MANY` - ONE_TO_MANY
     */
    fun cardinality(): Optional<CardinalityEnum> =
        Optional.ofNullable(cardinality.getNullable("cardinality"))

    fun isRequired(): Optional<Boolean> = Optional.ofNullable(isRequired.getNullable("is_required"))

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    @JsonProperty("source_object_class")
    @ExcludeMissing
    fun _sourceObjectClass() = sourceObjectClass

    @JsonProperty("target_object_classes")
    @ExcludeMissing
    fun _targetObjectClasses() = targetObjectClasses

    @JsonProperty("remote_key_name") @ExcludeMissing fun _remoteKeyName() = remoteKeyName

    @JsonProperty("display_name") @ExcludeMissing fun _displayName() = displayName

    /**
     * - `ONE_TO_ONE` - ONE_TO_ONE
     * - `MANY_TO_ONE` - MANY_TO_ONE
     * - `MANY_TO_MANY` - MANY_TO_MANY
     * - `ONE_TO_MANY` - ONE_TO_MANY
     */
    @JsonProperty("cardinality") @ExcludeMissing fun _cardinality() = cardinality

    @JsonProperty("is_required") @ExcludeMissing fun _isRequired() = isRequired

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            targetObjectClasses().map { it.forEach { it.validate() } }
            remoteKeyName()
            displayName()
            cardinality()
            isRequired()
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

        return other is AssociationType &&
            this.sourceObjectClass == other.sourceObjectClass &&
            this.targetObjectClasses == other.targetObjectClasses &&
            this.remoteKeyName == other.remoteKeyName &&
            this.displayName == other.displayName &&
            this.cardinality == other.cardinality &&
            this.isRequired == other.isRequired &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.modifiedAt == other.modifiedAt &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    sourceObjectClass,
                    targetObjectClasses,
                    remoteKeyName,
                    displayName,
                    cardinality,
                    isRequired,
                    id,
                    remoteId,
                    modifiedAt,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "AssociationType{sourceObjectClass=$sourceObjectClass, targetObjectClasses=$targetObjectClasses, remoteKeyName=$remoteKeyName, displayName=$displayName, cardinality=$cardinality, isRequired=$isRequired, id=$id, remoteId=$remoteId, modifiedAt=$modifiedAt, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var sourceObjectClass: JsonValue = JsonMissing.of()
        private var targetObjectClasses: JsonField<List<AssociationSubType>> = JsonMissing.of()
        private var remoteKeyName: JsonField<String> = JsonMissing.of()
        private var displayName: JsonField<String> = JsonMissing.of()
        private var cardinality: JsonField<CardinalityEnum> = JsonMissing.of()
        private var isRequired: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(associationType: AssociationType) = apply {
            this.sourceObjectClass = associationType.sourceObjectClass
            this.targetObjectClasses = associationType.targetObjectClasses
            this.remoteKeyName = associationType.remoteKeyName
            this.displayName = associationType.displayName
            this.cardinality = associationType.cardinality
            this.isRequired = associationType.isRequired
            this.id = associationType.id
            this.remoteId = associationType.remoteId
            this.modifiedAt = associationType.modifiedAt
            additionalProperties(associationType.additionalProperties)
        }

        @JsonProperty("source_object_class")
        @ExcludeMissing
        fun sourceObjectClass(sourceObjectClass: JsonValue) = apply {
            this.sourceObjectClass = sourceObjectClass
        }

        fun targetObjectClasses(targetObjectClasses: List<AssociationSubType>) =
            targetObjectClasses(JsonField.of(targetObjectClasses))

        @JsonProperty("target_object_classes")
        @ExcludeMissing
        fun targetObjectClasses(targetObjectClasses: JsonField<List<AssociationSubType>>) = apply {
            this.targetObjectClasses = targetObjectClasses
        }

        fun remoteKeyName(remoteKeyName: String) = remoteKeyName(JsonField.of(remoteKeyName))

        @JsonProperty("remote_key_name")
        @ExcludeMissing
        fun remoteKeyName(remoteKeyName: JsonField<String>) = apply {
            this.remoteKeyName = remoteKeyName
        }

        fun displayName(displayName: String) = displayName(JsonField.of(displayName))

        @JsonProperty("display_name")
        @ExcludeMissing
        fun displayName(displayName: JsonField<String>) = apply { this.displayName = displayName }

        /**
         * - `ONE_TO_ONE` - ONE_TO_ONE
         * - `MANY_TO_ONE` - MANY_TO_ONE
         * - `MANY_TO_MANY` - MANY_TO_MANY
         * - `ONE_TO_MANY` - ONE_TO_MANY
         */
        fun cardinality(cardinality: CardinalityEnum) = cardinality(JsonField.of(cardinality))

        /**
         * - `ONE_TO_ONE` - ONE_TO_ONE
         * - `MANY_TO_ONE` - MANY_TO_ONE
         * - `MANY_TO_MANY` - MANY_TO_MANY
         * - `ONE_TO_MANY` - ONE_TO_MANY
         */
        @JsonProperty("cardinality")
        @ExcludeMissing
        fun cardinality(cardinality: JsonField<CardinalityEnum>) = apply {
            this.cardinality = cardinality
        }

        fun isRequired(isRequired: Boolean) = isRequired(JsonField.of(isRequired))

        @JsonProperty("is_required")
        @ExcludeMissing
        fun isRequired(isRequired: JsonField<Boolean>) = apply { this.isRequired = isRequired }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

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

        fun build(): AssociationType =
            AssociationType(
                sourceObjectClass,
                targetObjectClasses.map { it.toUnmodifiable() },
                remoteKeyName,
                displayName,
                cardinality,
                isRequired,
                id,
                remoteId,
                modifiedAt,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = AssociationSubType.Builder::class)
    @NoAutoDetect
    class AssociationSubType
    private constructor(
        private val id: JsonField<String>,
        private val originType: JsonField<String>,
        private val modifiedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

        fun originType(): Optional<String> =
            Optional.ofNullable(originType.getNullable("origin_type"))

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(): Optional<OffsetDateTime> =
            Optional.ofNullable(modifiedAt.getNullable("modified_at"))

        @JsonProperty("id") @ExcludeMissing fun _id() = id

        @JsonProperty("origin_type") @ExcludeMissing fun _originType() = originType

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                id()
                originType()
                modifiedAt()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AssociationSubType &&
                this.id == other.id &&
                this.originType == other.originType &&
                this.modifiedAt == other.modifiedAt &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        id,
                        originType,
                        modifiedAt,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "AssociationSubType{id=$id, originType=$originType, modifiedAt=$modifiedAt, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var id: JsonField<String> = JsonMissing.of()
            private var originType: JsonField<String> = JsonMissing.of()
            private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(associationSubType: AssociationSubType) = apply {
                this.id = associationSubType.id
                this.originType = associationSubType.originType
                this.modifiedAt = associationSubType.modifiedAt
                additionalProperties(associationSubType.additionalProperties)
            }

            fun id(id: String) = id(JsonField.of(id))

            @JsonProperty("id")
            @ExcludeMissing
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun originType(originType: String) = originType(JsonField.of(originType))

            @JsonProperty("origin_type")
            @ExcludeMissing
            fun originType(originType: JsonField<String>) = apply { this.originType = originType }

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

            fun build(): AssociationSubType =
                AssociationSubType(
                    id,
                    originType,
                    modifiedAt,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    class CardinalityEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CardinalityEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ONE_TO_ONE = CardinalityEnum(JsonField.of("ONE_TO_ONE"))

            @JvmField val MANY_TO_ONE = CardinalityEnum(JsonField.of("MANY_TO_ONE"))

            @JvmField val MANY_TO_MANY = CardinalityEnum(JsonField.of("MANY_TO_MANY"))

            @JvmField val ONE_TO_MANY = CardinalityEnum(JsonField.of("ONE_TO_MANY"))

            @JvmStatic fun of(value: String) = CardinalityEnum(JsonField.of(value))
        }

        enum class Known {
            ONE_TO_ONE,
            MANY_TO_ONE,
            MANY_TO_MANY,
            ONE_TO_MANY,
        }

        enum class Value {
            ONE_TO_ONE,
            MANY_TO_ONE,
            MANY_TO_MANY,
            ONE_TO_MANY,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ONE_TO_ONE -> Value.ONE_TO_ONE
                MANY_TO_ONE -> Value.MANY_TO_ONE
                MANY_TO_MANY -> Value.MANY_TO_MANY
                ONE_TO_MANY -> Value.ONE_TO_MANY
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ONE_TO_ONE -> Known.ONE_TO_ONE
                MANY_TO_ONE -> Known.MANY_TO_ONE
                MANY_TO_MANY -> Known.MANY_TO_MANY
                ONE_TO_MANY -> Known.ONE_TO_MANY
                else -> throw MergeInvalidDataException("Unknown CardinalityEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
