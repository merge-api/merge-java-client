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
 * # The Opportunity Object
 *
 * ### Description
 *
 * The `Opportunity` object is used to represent a deal opportunity in a CRM system.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = Opportunity.Builder::class)
@NoAutoDetect
class Opportunity
private constructor(
    private val name: JsonField<String>,
    private val description: JsonField<String>,
    private val amount: JsonField<Long>,
    private val owner: JsonField<String>,
    private val account: JsonField<String>,
    private val stage: JsonField<String>,
    private val status: JsonField<OpportunityStatusEnum>,
    private val lastActivityAt: JsonField<OffsetDateTime>,
    private val closeDate: JsonField<OffsetDateTime>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
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

    /** The opportunity's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The opportunity's description. */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /** The opportunity's amount. */
    fun amount(): Optional<Long> = Optional.ofNullable(amount.getNullable("amount"))

    /** The opportunity's owner. */
    fun owner(): Optional<String> = Optional.ofNullable(owner.getNullable("owner"))

    /** The account of the opportunity. */
    fun account(): Optional<String> = Optional.ofNullable(account.getNullable("account"))

    /** The stage of the opportunity. */
    fun stage(): Optional<String> = Optional.ofNullable(stage.getNullable("stage"))

    /**
     * - `OPEN` - OPEN
     * - `WON` - WON
     * - `LOST` - LOST
     */
    fun status(): Optional<OpportunityStatusEnum> =
        Optional.ofNullable(status.getNullable("status"))

    /** When the opportunity's last activity occurred. */
    fun lastActivityAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(lastActivityAt.getNullable("last_activity_at"))

    /** When the opportunity was closed. */
    fun closeDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(closeDate.getNullable("close_date"))

    /** When the third party's opportunity was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

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

    /** The opportunity's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The opportunity's description. */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /** The opportunity's amount. */
    @JsonProperty("amount") @ExcludeMissing fun _amount() = amount

    /** The opportunity's owner. */
    @JsonProperty("owner") @ExcludeMissing fun _owner() = owner

    /** The account of the opportunity. */
    @JsonProperty("account") @ExcludeMissing fun _account() = account

    /** The stage of the opportunity. */
    @JsonProperty("stage") @ExcludeMissing fun _stage() = stage

    /**
     * - `OPEN` - OPEN
     * - `WON` - WON
     * - `LOST` - LOST
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** When the opportunity's last activity occurred. */
    @JsonProperty("last_activity_at") @ExcludeMissing fun _lastActivityAt() = lastActivityAt

    /** When the opportunity was closed. */
    @JsonProperty("close_date") @ExcludeMissing fun _closeDate() = closeDate

    /** When the third party's opportunity was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

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
            name()
            description()
            amount()
            owner()
            account()
            stage()
            status()
            lastActivityAt()
            closeDate()
            remoteCreatedAt()
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

        return other is Opportunity &&
            this.name == other.name &&
            this.description == other.description &&
            this.amount == other.amount &&
            this.owner == other.owner &&
            this.account == other.account &&
            this.stage == other.stage &&
            this.status == other.status &&
            this.lastActivityAt == other.lastActivityAt &&
            this.closeDate == other.closeDate &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
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
                    name,
                    description,
                    amount,
                    owner,
                    account,
                    stage,
                    status,
                    lastActivityAt,
                    closeDate,
                    remoteCreatedAt,
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
        "Opportunity{name=$name, description=$description, amount=$amount, owner=$owner, account=$account, stage=$stage, status=$status, lastActivityAt=$lastActivityAt, closeDate=$closeDate, remoteCreatedAt=$remoteCreatedAt, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, remoteFields=$remoteFields, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var amount: JsonField<Long> = JsonMissing.of()
        private var owner: JsonField<String> = JsonMissing.of()
        private var account: JsonField<String> = JsonMissing.of()
        private var stage: JsonField<String> = JsonMissing.of()
        private var status: JsonField<OpportunityStatusEnum> = JsonMissing.of()
        private var lastActivityAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var closeDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var remoteFields: JsonField<List<RemoteField>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(opportunity: Opportunity) = apply {
            this.name = opportunity.name
            this.description = opportunity.description
            this.amount = opportunity.amount
            this.owner = opportunity.owner
            this.account = opportunity.account
            this.stage = opportunity.stage
            this.status = opportunity.status
            this.lastActivityAt = opportunity.lastActivityAt
            this.closeDate = opportunity.closeDate
            this.remoteCreatedAt = opportunity.remoteCreatedAt
            this.remoteWasDeleted = opportunity.remoteWasDeleted
            this.id = opportunity.id
            this.remoteId = opportunity.remoteId
            this.fieldMappings = opportunity.fieldMappings
            this.modifiedAt = opportunity.modifiedAt
            this.remoteData = opportunity.remoteData
            this.remoteFields = opportunity.remoteFields
            additionalProperties(opportunity.additionalProperties)
        }

        /** The opportunity's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The opportunity's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The opportunity's description. */
        fun description(description: String) = description(JsonField.of(description))

        /** The opportunity's description. */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** The opportunity's amount. */
        fun amount(amount: Long) = amount(JsonField.of(amount))

        /** The opportunity's amount. */
        @JsonProperty("amount")
        @ExcludeMissing
        fun amount(amount: JsonField<Long>) = apply { this.amount = amount }

        /** The opportunity's owner. */
        fun owner(owner: String) = owner(JsonField.of(owner))

        /** The opportunity's owner. */
        @JsonProperty("owner")
        @ExcludeMissing
        fun owner(owner: JsonField<String>) = apply { this.owner = owner }

        /** The account of the opportunity. */
        fun account(account: String) = account(JsonField.of(account))

        /** The account of the opportunity. */
        @JsonProperty("account")
        @ExcludeMissing
        fun account(account: JsonField<String>) = apply { this.account = account }

        /** The stage of the opportunity. */
        fun stage(stage: String) = stage(JsonField.of(stage))

        /** The stage of the opportunity. */
        @JsonProperty("stage")
        @ExcludeMissing
        fun stage(stage: JsonField<String>) = apply { this.stage = stage }

        /**
         * - `OPEN` - OPEN
         * - `WON` - WON
         * - `LOST` - LOST
         */
        fun status(status: OpportunityStatusEnum) = status(JsonField.of(status))

        /**
         * - `OPEN` - OPEN
         * - `WON` - WON
         * - `LOST` - LOST
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<OpportunityStatusEnum>) = apply { this.status = status }

        /** When the opportunity's last activity occurred. */
        fun lastActivityAt(lastActivityAt: OffsetDateTime) =
            lastActivityAt(JsonField.of(lastActivityAt))

        /** When the opportunity's last activity occurred. */
        @JsonProperty("last_activity_at")
        @ExcludeMissing
        fun lastActivityAt(lastActivityAt: JsonField<OffsetDateTime>) = apply {
            this.lastActivityAt = lastActivityAt
        }

        /** When the opportunity was closed. */
        fun closeDate(closeDate: OffsetDateTime) = closeDate(JsonField.of(closeDate))

        /** When the opportunity was closed. */
        @JsonProperty("close_date")
        @ExcludeMissing
        fun closeDate(closeDate: JsonField<OffsetDateTime>) = apply { this.closeDate = closeDate }

        /** When the third party's opportunity was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's opportunity was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

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

        fun build(): Opportunity =
            Opportunity(
                name,
                description,
                amount,
                owner,
                account,
                stage,
                status,
                lastActivityAt,
                closeDate,
                remoteCreatedAt,
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

    class OpportunityStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OpportunityStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val OPEN = OpportunityStatusEnum(JsonField.of("OPEN"))

            @JvmField val WON = OpportunityStatusEnum(JsonField.of("WON"))

            @JvmField val LOST = OpportunityStatusEnum(JsonField.of("LOST"))

            @JvmStatic fun of(value: String) = OpportunityStatusEnum(JsonField.of(value))
        }

        enum class Known {
            OPEN,
            WON,
            LOST,
        }

        enum class Value {
            OPEN,
            WON,
            LOST,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                OPEN -> Value.OPEN
                WON -> Value.WON
                LOST -> Value.LOST
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                OPEN -> Known.OPEN
                WON -> Known.WON
                LOST -> Known.LOST
                else -> throw MergeInvalidDataException("Unknown OpportunityStatusEnum: $value")
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
