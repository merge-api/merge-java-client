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
 * # The Automation Object
 *
 * ### Description
 *
 * The `Automation` object is used to represent an automation, workflow or custom event in the
 * remote system.
 *
 * ### Usage Example
 *
 * Fetch from the `GET /api/mktg/v1/automations` endpoint and view their automation_trigger
 * configurations.
 */
@JsonDeserialize(builder = Automation.Builder::class)
@NoAutoDetect
class Automation
private constructor(
    private val name: JsonField<String>,
    private val triggerType: JsonField<TriggerTypeEnum>,
    private val startDate: JsonField<OffsetDateTime>,
    private val endDate: JsonField<OffsetDateTime>,
    private val description: JsonField<String>,
    private val status: JsonField<String>,
    private val automationTrigger: JsonValue,
    private val actions: JsonField<List<String>>,
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

    /** The automation's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /**
     * - `TRIGGER_EVENT` - TRIGGER_EVENT
     * - `RECURRENCE` - RECURRENCE
     */
    fun triggerType(): Optional<TriggerTypeEnum> =
        Optional.ofNullable(triggerType.getNullable("trigger_type"))

    /** The automation's start date. */
    fun startDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(startDate.getNullable("start_date"))

    /** The automation's end date. */
    fun endDate(): Optional<OffsetDateTime> = Optional.ofNullable(endDate.getNullable("end_date"))

    /** The automation’s description. */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /** The automation's status. */
    fun status(): Optional<String> = Optional.ofNullable(status.getNullable("status"))

    /** The actions performed by this automation. */
    fun actions(): List<String> = actions.getRequired("actions")

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

    /** The automation's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /**
     * - `TRIGGER_EVENT` - TRIGGER_EVENT
     * - `RECURRENCE` - RECURRENCE
     */
    @JsonProperty("trigger_type") @ExcludeMissing fun _triggerType() = triggerType

    /** The automation's start date. */
    @JsonProperty("start_date") @ExcludeMissing fun _startDate() = startDate

    /** The automation's end date. */
    @JsonProperty("end_date") @ExcludeMissing fun _endDate() = endDate

    /** The automation’s description. */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /** The automation's status. */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** The trigger configuraton for the automation. */
    @JsonProperty("automation_trigger") @ExcludeMissing fun _automationTrigger() = automationTrigger

    /** The actions performed by this automation. */
    @JsonProperty("actions") @ExcludeMissing fun _actions() = actions

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
            triggerType()
            startDate()
            endDate()
            description()
            status()
            actions()
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

        return other is Automation &&
            this.name == other.name &&
            this.triggerType == other.triggerType &&
            this.startDate == other.startDate &&
            this.endDate == other.endDate &&
            this.description == other.description &&
            this.status == other.status &&
            this.automationTrigger == other.automationTrigger &&
            this.actions == other.actions &&
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
                    triggerType,
                    startDate,
                    endDate,
                    description,
                    status,
                    automationTrigger,
                    actions,
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
        "Automation{name=$name, triggerType=$triggerType, startDate=$startDate, endDate=$endDate, description=$description, status=$status, automationTrigger=$automationTrigger, actions=$actions, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var triggerType: JsonField<TriggerTypeEnum> = JsonMissing.of()
        private var startDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var endDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var automationTrigger: JsonValue = JsonMissing.of()
        private var actions: JsonField<List<String>> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<JsonValue>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(automation: Automation) = apply {
            this.name = automation.name
            this.triggerType = automation.triggerType
            this.startDate = automation.startDate
            this.endDate = automation.endDate
            this.description = automation.description
            this.status = automation.status
            this.automationTrigger = automation.automationTrigger
            this.actions = automation.actions
            this.remoteWasDeleted = automation.remoteWasDeleted
            this.id = automation.id
            this.remoteId = automation.remoteId
            this.fieldMappings = automation.fieldMappings
            this.modifiedAt = automation.modifiedAt
            this.remoteData = automation.remoteData
            additionalProperties(automation.additionalProperties)
        }

        /** The automation's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The automation's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * - `TRIGGER_EVENT` - TRIGGER_EVENT
         * - `RECURRENCE` - RECURRENCE
         */
        fun triggerType(triggerType: TriggerTypeEnum) = triggerType(JsonField.of(triggerType))

        /**
         * - `TRIGGER_EVENT` - TRIGGER_EVENT
         * - `RECURRENCE` - RECURRENCE
         */
        @JsonProperty("trigger_type")
        @ExcludeMissing
        fun triggerType(triggerType: JsonField<TriggerTypeEnum>) = apply {
            this.triggerType = triggerType
        }

        /** The automation's start date. */
        fun startDate(startDate: OffsetDateTime) = startDate(JsonField.of(startDate))

        /** The automation's start date. */
        @JsonProperty("start_date")
        @ExcludeMissing
        fun startDate(startDate: JsonField<OffsetDateTime>) = apply { this.startDate = startDate }

        /** The automation's end date. */
        fun endDate(endDate: OffsetDateTime) = endDate(JsonField.of(endDate))

        /** The automation's end date. */
        @JsonProperty("end_date")
        @ExcludeMissing
        fun endDate(endDate: JsonField<OffsetDateTime>) = apply { this.endDate = endDate }

        /** The automation’s description. */
        fun description(description: String) = description(JsonField.of(description))

        /** The automation’s description. */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** The automation's status. */
        fun status(status: String) = status(JsonField.of(status))

        /** The automation's status. */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** The trigger configuraton for the automation. */
        @JsonProperty("automation_trigger")
        @ExcludeMissing
        fun automationTrigger(automationTrigger: JsonValue) = apply {
            this.automationTrigger = automationTrigger
        }

        /** The actions performed by this automation. */
        fun actions(actions: List<String>) = actions(JsonField.of(actions))

        /** The actions performed by this automation. */
        @JsonProperty("actions")
        @ExcludeMissing
        fun actions(actions: JsonField<List<String>>) = apply { this.actions = actions }

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

        fun build(): Automation =
            Automation(
                name,
                triggerType,
                startDate,
                endDate,
                description,
                status,
                automationTrigger,
                actions.map { it.toUnmodifiable() },
                remoteWasDeleted,
                id,
                remoteId,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class TriggerTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TriggerTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val TRIGGER_EVENT = TriggerTypeEnum(JsonField.of("TRIGGER_EVENT"))

            @JvmField val RECURRENCE = TriggerTypeEnum(JsonField.of("RECURRENCE"))

            @JvmStatic fun of(value: String) = TriggerTypeEnum(JsonField.of(value))
        }

        enum class Known {
            TRIGGER_EVENT,
            RECURRENCE,
        }

        enum class Value {
            TRIGGER_EVENT,
            RECURRENCE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TRIGGER_EVENT -> Value.TRIGGER_EVENT
                RECURRENCE -> Value.RECURRENCE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                TRIGGER_EVENT -> Known.TRIGGER_EVENT
                RECURRENCE -> Known.RECURRENCE
                else -> throw MergeInvalidDataException("Unknown TriggerTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
