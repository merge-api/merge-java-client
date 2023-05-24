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
 * # The Engagement Type Object
 *
 * ### Description
 *
 * The `Engagement Type` object is used to represent an interaction activity. A given `Engagement`
 * typically has an `Engagement Type` object represented in the engagement_type field.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = EngagementType.Builder::class)
@NoAutoDetect
class EngagementType
private constructor(
    private val activityType: JsonField<ActivityTypeEnum>,
    private val name: JsonField<String>,
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteFields: JsonField<List<RemoteField>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /**
     * - `CALL` - CALL
     * - `MEETING` - MEETING
     * - `EMAIL` - EMAIL
     */
    fun activityType(): Optional<ActivityTypeEnum> =
        Optional.ofNullable(activityType.getNullable("activity_type"))

    /** The engagement type's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteFields(): Optional<List<RemoteField>> =
        Optional.ofNullable(remoteFields.getNullable("remote_fields"))

    /**
     * - `CALL` - CALL
     * - `MEETING` - MEETING
     * - `EMAIL` - EMAIL
     */
    @JsonProperty("activity_type") @ExcludeMissing fun _activityType() = activityType

    /** The engagement type's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_fields") @ExcludeMissing fun _remoteFields() = remoteFields

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): EngagementType = apply {
        if (!validated) {
            activityType()
            name()
            id()
            remoteId()
            modifiedAt()
            remoteFields().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EngagementType &&
            this.activityType == other.activityType &&
            this.name == other.name &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteFields == other.remoteFields &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    activityType,
                    name,
                    id,
                    remoteId,
                    modifiedAt,
                    remoteFields,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "EngagementType{activityType=$activityType, name=$name, id=$id, remoteId=$remoteId, modifiedAt=$modifiedAt, remoteFields=$remoteFields, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var activityType: JsonField<ActivityTypeEnum> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteFields: JsonField<List<RemoteField>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(engagementType: EngagementType) = apply {
            this.activityType = engagementType.activityType
            this.name = engagementType.name
            this.id = engagementType.id
            this.remoteId = engagementType.remoteId
            this.modifiedAt = engagementType.modifiedAt
            this.remoteFields = engagementType.remoteFields
            additionalProperties(engagementType.additionalProperties)
        }

        /**
         * - `CALL` - CALL
         * - `MEETING` - MEETING
         * - `EMAIL` - EMAIL
         */
        fun activityType(activityType: ActivityTypeEnum) = activityType(JsonField.of(activityType))

        /**
         * - `CALL` - CALL
         * - `MEETING` - MEETING
         * - `EMAIL` - EMAIL
         */
        @JsonProperty("activity_type")
        @ExcludeMissing
        fun activityType(activityType: JsonField<ActivityTypeEnum>) = apply {
            this.activityType = activityType
        }

        /** The engagement type's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The engagement type's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

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

        fun remoteFields(remoteFields: List<RemoteField>) = remoteFields(JsonField.of(remoteFields))

        @JsonProperty("remote_fields")
        @ExcludeMissing
        fun remoteFields(remoteFields: JsonField<List<RemoteField>>) = apply {
            this.remoteFields = remoteFields
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

        fun build(): EngagementType =
            EngagementType(
                activityType,
                name,
                id,
                remoteId,
                modifiedAt,
                remoteFields.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class ActivityTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ActivityTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val CALL = ActivityTypeEnum(JsonField.of("CALL"))

            @JvmField val MEETING = ActivityTypeEnum(JsonField.of("MEETING"))

            @JvmField val EMAIL = ActivityTypeEnum(JsonField.of("EMAIL"))

            @JvmStatic fun of(value: String) = ActivityTypeEnum(JsonField.of(value))
        }

        enum class Known {
            CALL,
            MEETING,
            EMAIL,
        }

        enum class Value {
            CALL,
            MEETING,
            EMAIL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CALL -> Value.CALL
                MEETING -> Value.MEETING
                EMAIL -> Value.EMAIL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CALL -> Known.CALL
                MEETING -> Known.MEETING
                EMAIL -> Known.EMAIL
                else -> throw MergeInvalidDataException("Unknown ActivityTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = RemoteField.Builder::class)
    @NoAutoDetect
    class RemoteField
    private constructor(
        private val remoteFieldClass: JsonField<RemoteFieldClass>,
        private val value: JsonValue,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun remoteFieldClass(): RemoteFieldClass =
            remoteFieldClass.getRequired("remote_field_class")

        @JsonProperty("remote_field_class")
        @ExcludeMissing
        fun _remoteFieldClass() = remoteFieldClass

        @JsonProperty("value") @ExcludeMissing fun _value() = value

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): RemoteField = apply {
            if (!validated) {
                remoteFieldClass().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RemoteField &&
                this.remoteFieldClass == other.remoteFieldClass &&
                this.value == other.value &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        remoteFieldClass,
                        value,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "RemoteField{remoteFieldClass=$remoteFieldClass, value=$value, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var remoteFieldClass: JsonField<RemoteFieldClass> = JsonMissing.of()
            private var value: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(remoteField: RemoteField) = apply {
                this.remoteFieldClass = remoteField.remoteFieldClass
                this.value = remoteField.value
                additionalProperties(remoteField.additionalProperties)
            }

            fun remoteFieldClass(remoteFieldClass: RemoteFieldClass) =
                remoteFieldClass(JsonField.of(remoteFieldClass))

            @JsonProperty("remote_field_class")
            @ExcludeMissing
            fun remoteFieldClass(remoteFieldClass: JsonField<RemoteFieldClass>) = apply {
                this.remoteFieldClass = remoteFieldClass
            }

            @JsonProperty("value")
            @ExcludeMissing
            fun value(value: JsonValue) = apply { this.value = value }

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

            fun build(): RemoteField =
                RemoteField(
                    remoteFieldClass,
                    value,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
