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
 * # The Engagement Object
 *
 * ### Description
 *
 * The `Engagement` object is used to represent an interaction noted in a CRM system.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = Engagement.Builder::class)
@NoAutoDetect
class Engagement
private constructor(
    private val owner: JsonField<String>,
    private val content: JsonField<String>,
    private val subject: JsonField<String>,
    private val direction: JsonField<DirectionEnum>,
    private val engagementType: JsonField<String>,
    private val startTime: JsonField<OffsetDateTime>,
    private val endTime: JsonField<OffsetDateTime>,
    private val account: JsonField<String>,
    private val contacts: JsonField<List<String>>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val remoteFields: JsonField<List<RemoteField>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The engagement's owner. */
    fun owner(): Optional<String> = Optional.ofNullable(owner.getNullable("owner"))

    /** The engagement's content. */
    fun content(): Optional<String> = Optional.ofNullable(content.getNullable("content"))

    /** The engagement's subject. */
    fun subject(): Optional<String> = Optional.ofNullable(subject.getNullable("subject"))

    /**
     * - `INBOUND` - INBOUND
     * - `OUTBOUND` - OUTBOUND
     */
    fun direction(): Optional<DirectionEnum> =
        Optional.ofNullable(direction.getNullable("direction"))

    /** The engagement type of the engagement. */
    fun engagementType(): Optional<String> =
        Optional.ofNullable(engagementType.getNullable("engagement_type"))

    /** The time at which the engagement started. */
    fun startTime(): Optional<OffsetDateTime> =
        Optional.ofNullable(startTime.getNullable("start_time"))

    /** The time at which the engagement ended. */
    fun endTime(): Optional<OffsetDateTime> = Optional.ofNullable(endTime.getNullable("end_time"))

    /** The account of the engagement. */
    fun account(): Optional<String> = Optional.ofNullable(account.getNullable("account"))

    fun contacts(): Optional<List<String>> = Optional.ofNullable(contacts.getNullable("contacts"))

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    fun remoteWasDeleted(): Optional<Boolean> =
        Optional.ofNullable(remoteWasDeleted.getNullable("remote_was_deleted"))

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<RemoteData>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    fun remoteFields(): Optional<List<RemoteField>> =
        Optional.ofNullable(remoteFields.getNullable("remote_fields"))

    /** The engagement's owner. */
    @JsonProperty("owner") @ExcludeMissing fun _owner() = owner

    /** The engagement's content. */
    @JsonProperty("content") @ExcludeMissing fun _content() = content

    /** The engagement's subject. */
    @JsonProperty("subject") @ExcludeMissing fun _subject() = subject

    /**
     * - `INBOUND` - INBOUND
     * - `OUTBOUND` - OUTBOUND
     */
    @JsonProperty("direction") @ExcludeMissing fun _direction() = direction

    /** The engagement type of the engagement. */
    @JsonProperty("engagement_type") @ExcludeMissing fun _engagementType() = engagementType

    /** The time at which the engagement started. */
    @JsonProperty("start_time") @ExcludeMissing fun _startTime() = startTime

    /** The time at which the engagement ended. */
    @JsonProperty("end_time") @ExcludeMissing fun _endTime() = endTime

    /** The account of the engagement. */
    @JsonProperty("account") @ExcludeMissing fun _account() = account

    @JsonProperty("contacts") @ExcludeMissing fun _contacts() = contacts

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonProperty("remote_fields") @ExcludeMissing fun _remoteFields() = remoteFields

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            owner()
            content()
            subject()
            direction()
            engagementType()
            startTime()
            endTime()
            account()
            contacts()
            remoteWasDeleted()
            id()
            remoteId()
            modifiedAt()
            remoteData().map { it.forEach { it.validate() } }
            remoteFields().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Engagement &&
            this.owner == other.owner &&
            this.content == other.content &&
            this.subject == other.subject &&
            this.direction == other.direction &&
            this.engagementType == other.engagementType &&
            this.startTime == other.startTime &&
            this.endTime == other.endTime &&
            this.account == other.account &&
            this.contacts == other.contacts &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.remoteFields == other.remoteFields &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    owner,
                    content,
                    subject,
                    direction,
                    engagementType,
                    startTime,
                    endTime,
                    account,
                    contacts,
                    remoteWasDeleted,
                    id,
                    remoteId,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    remoteFields,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Engagement{owner=$owner, content=$content, subject=$subject, direction=$direction, engagementType=$engagementType, startTime=$startTime, endTime=$endTime, account=$account, contacts=$contacts, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, remoteFields=$remoteFields, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var owner: JsonField<String> = JsonMissing.of()
        private var content: JsonField<String> = JsonMissing.of()
        private var subject: JsonField<String> = JsonMissing.of()
        private var direction: JsonField<DirectionEnum> = JsonMissing.of()
        private var engagementType: JsonField<String> = JsonMissing.of()
        private var startTime: JsonField<OffsetDateTime> = JsonMissing.of()
        private var endTime: JsonField<OffsetDateTime> = JsonMissing.of()
        private var account: JsonField<String> = JsonMissing.of()
        private var contacts: JsonField<List<String>> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var remoteFields: JsonField<List<RemoteField>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(engagement: Engagement) = apply {
            this.owner = engagement.owner
            this.content = engagement.content
            this.subject = engagement.subject
            this.direction = engagement.direction
            this.engagementType = engagement.engagementType
            this.startTime = engagement.startTime
            this.endTime = engagement.endTime
            this.account = engagement.account
            this.contacts = engagement.contacts
            this.remoteWasDeleted = engagement.remoteWasDeleted
            this.id = engagement.id
            this.remoteId = engagement.remoteId
            this.fieldMappings = engagement.fieldMappings
            this.modifiedAt = engagement.modifiedAt
            this.remoteData = engagement.remoteData
            this.remoteFields = engagement.remoteFields
            additionalProperties(engagement.additionalProperties)
        }

        /** The engagement's owner. */
        fun owner(owner: String) = owner(JsonField.of(owner))

        /** The engagement's owner. */
        @JsonProperty("owner")
        @ExcludeMissing
        fun owner(owner: JsonField<String>) = apply { this.owner = owner }

        /** The engagement's content. */
        fun content(content: String) = content(JsonField.of(content))

        /** The engagement's content. */
        @JsonProperty("content")
        @ExcludeMissing
        fun content(content: JsonField<String>) = apply { this.content = content }

        /** The engagement's subject. */
        fun subject(subject: String) = subject(JsonField.of(subject))

        /** The engagement's subject. */
        @JsonProperty("subject")
        @ExcludeMissing
        fun subject(subject: JsonField<String>) = apply { this.subject = subject }

        /**
         * - `INBOUND` - INBOUND
         * - `OUTBOUND` - OUTBOUND
         */
        fun direction(direction: DirectionEnum) = direction(JsonField.of(direction))

        /**
         * - `INBOUND` - INBOUND
         * - `OUTBOUND` - OUTBOUND
         */
        @JsonProperty("direction")
        @ExcludeMissing
        fun direction(direction: JsonField<DirectionEnum>) = apply { this.direction = direction }

        /** The engagement type of the engagement. */
        fun engagementType(engagementType: String) = engagementType(JsonField.of(engagementType))

        /** The engagement type of the engagement. */
        @JsonProperty("engagement_type")
        @ExcludeMissing
        fun engagementType(engagementType: JsonField<String>) = apply {
            this.engagementType = engagementType
        }

        /** The time at which the engagement started. */
        fun startTime(startTime: OffsetDateTime) = startTime(JsonField.of(startTime))

        /** The time at which the engagement started. */
        @JsonProperty("start_time")
        @ExcludeMissing
        fun startTime(startTime: JsonField<OffsetDateTime>) = apply { this.startTime = startTime }

        /** The time at which the engagement ended. */
        fun endTime(endTime: OffsetDateTime) = endTime(JsonField.of(endTime))

        /** The time at which the engagement ended. */
        @JsonProperty("end_time")
        @ExcludeMissing
        fun endTime(endTime: JsonField<OffsetDateTime>) = apply { this.endTime = endTime }

        /** The account of the engagement. */
        fun account(account: String) = account(JsonField.of(account))

        /** The account of the engagement. */
        @JsonProperty("account")
        @ExcludeMissing
        fun account(account: JsonField<String>) = apply { this.account = account }

        fun contacts(contacts: List<String>) = contacts(JsonField.of(contacts))

        @JsonProperty("contacts")
        @ExcludeMissing
        fun contacts(contacts: JsonField<List<String>>) = apply { this.contacts = contacts }

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        @JsonProperty("remote_was_deleted")
        @ExcludeMissing
        fun remoteWasDeleted(remoteWasDeleted: JsonField<Boolean>) = apply {
            this.remoteWasDeleted = remoteWasDeleted
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        @JsonProperty("field_mappings")
        @ExcludeMissing
        fun fieldMappings(fieldMappings: JsonValue) = apply { this.fieldMappings = fieldMappings }

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at")
        @ExcludeMissing
        fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
            this.modifiedAt = modifiedAt
        }

        fun remoteData(remoteData: List<RemoteData>) = remoteData(JsonField.of(remoteData))

        @JsonProperty("remote_data")
        @ExcludeMissing
        fun remoteData(remoteData: JsonField<List<RemoteData>>) = apply {
            this.remoteData = remoteData
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

        fun build(): Engagement =
            Engagement(
                owner,
                content,
                subject,
                direction,
                engagementType,
                startTime,
                endTime,
                account,
                contacts.map { it.toUnmodifiable() },
                remoteWasDeleted,
                id,
                remoteId,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                remoteFields.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class DirectionEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DirectionEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val INBOUND = DirectionEnum(JsonField.of("INBOUND"))

            @JvmField val OUTBOUND = DirectionEnum(JsonField.of("OUTBOUND"))

            @JvmStatic fun of(value: String) = DirectionEnum(JsonField.of(value))
        }

        enum class Known {
            INBOUND,
            OUTBOUND,
        }

        enum class Value {
            INBOUND,
            OUTBOUND,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                INBOUND -> Value.INBOUND
                OUTBOUND -> Value.OUTBOUND
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                INBOUND -> Known.INBOUND
                OUTBOUND -> Known.OUTBOUND
                else -> throw MergeInvalidDataException("Unknown DirectionEnum: $value")
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

        fun validate() = apply {
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
