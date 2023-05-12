package dev.merge.api.models.marketing

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
 * # The Action Object
 *
 * ### Description
 *
 * The `Action` object is used to represent an action executed within an automation.
 *
 * ### Usage Example
 *
 * Fetch from the `GET /api/mktg/v1/actions` endpoint and view their types.
 */
@JsonDeserialize(builder = Action.Builder::class)
@NoAutoDetect
class Action
private constructor(
    private val name: JsonField<String>,
    private val emails: JsonField<List<String>>,
    private val messages: JsonField<List<String>>,
    private val type: JsonField<TypeEnum>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<JsonValue>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The action's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The marketing emails sent by this action. */
    fun emails(): List<String> = emails.getRequired("emails")

    /** The messages sent by this action. */
    fun messages(): List<String> = messages.getRequired("messages")

    /**
     * - `EMAIL` - EMAIL
     * - `MESSAGE` - MESSAGE
     */
    fun type(): Optional<TypeEnum> = Optional.ofNullable(type.getNullable("type"))

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    fun remoteWasDeleted(): Optional<Boolean> =
        Optional.ofNullable(remoteWasDeleted.getNullable("remote_was_deleted"))

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<JsonValue>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    /** The action's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The marketing emails sent by this action. */
    @JsonProperty("emails") @ExcludeMissing fun _emails() = emails

    /** The messages sent by this action. */
    @JsonProperty("messages") @ExcludeMissing fun _messages() = messages

    /**
     * - `EMAIL` - EMAIL
     * - `MESSAGE` - MESSAGE
     */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            name()
            emails()
            messages()
            type()
            remoteWasDeleted()
            id()
            remoteId()
            modifiedAt()
            remoteData()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Action &&
            this.name == other.name &&
            this.emails == other.emails &&
            this.messages == other.messages &&
            this.type == other.type &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    name,
                    emails,
                    messages,
                    type,
                    remoteWasDeleted,
                    id,
                    remoteId,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Action{name=$name, emails=$emails, messages=$messages, type=$type, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var emails: JsonField<List<String>> = JsonMissing.of()
        private var messages: JsonField<List<String>> = JsonMissing.of()
        private var type: JsonField<TypeEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<JsonValue>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(action: Action) = apply {
            this.name = action.name
            this.emails = action.emails
            this.messages = action.messages
            this.type = action.type
            this.remoteWasDeleted = action.remoteWasDeleted
            this.id = action.id
            this.remoteId = action.remoteId
            this.fieldMappings = action.fieldMappings
            this.modifiedAt = action.modifiedAt
            this.remoteData = action.remoteData
            additionalProperties(action.additionalProperties)
        }

        /** The action's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The action's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The marketing emails sent by this action. */
        fun emails(emails: List<String>) = emails(JsonField.of(emails))

        /** The marketing emails sent by this action. */
        @JsonProperty("emails")
        @ExcludeMissing
        fun emails(emails: JsonField<List<String>>) = apply { this.emails = emails }

        /** The messages sent by this action. */
        fun messages(messages: List<String>) = messages(JsonField.of(messages))

        /** The messages sent by this action. */
        @JsonProperty("messages")
        @ExcludeMissing
        fun messages(messages: JsonField<List<String>>) = apply { this.messages = messages }

        /**
         * - `EMAIL` - EMAIL
         * - `MESSAGE` - MESSAGE
         */
        fun type(type: TypeEnum) = type(JsonField.of(type))

        /**
         * - `EMAIL` - EMAIL
         * - `MESSAGE` - MESSAGE
         */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<TypeEnum>) = apply { this.type = type }

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

        fun remoteData(remoteData: List<JsonValue>) = remoteData(JsonField.of(remoteData))

        @JsonProperty("remote_data")
        @ExcludeMissing
        fun remoteData(remoteData: JsonField<List<JsonValue>>) = apply {
            this.remoteData = remoteData
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

        fun build(): Action =
            Action(
                name,
                emails.map { it.toUnmodifiable() },
                messages.map { it.toUnmodifiable() },
                type,
                remoteWasDeleted,
                id,
                remoteId,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class TypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val EMAIL = TypeEnum(JsonField.of("EMAIL"))

            @JvmField val MESSAGE = TypeEnum(JsonField.of("MESSAGE"))

            @JvmStatic fun of(value: String) = TypeEnum(JsonField.of(value))
        }

        enum class Known {
            EMAIL,
            MESSAGE,
        }

        enum class Value {
            EMAIL,
            MESSAGE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMAIL -> Value.EMAIL
                MESSAGE -> Value.MESSAGE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMAIL -> Known.EMAIL
                MESSAGE -> Known.MESSAGE
                else -> throw MergeInvalidDataException("Unknown TypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
