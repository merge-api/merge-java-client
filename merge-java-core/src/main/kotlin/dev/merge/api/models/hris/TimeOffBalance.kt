package dev.merge.api.models.hris

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
 * # The TimeOffBalance Object
 *
 * ### Description
 *
 * The `TimeOffBalance` object is used to represent current balances for an employee's Time Off
 * plan.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST TimeOffBalances` endpoint and filter by `ID` to show all time off balances.
 */
@JsonDeserialize(builder = TimeOffBalance.Builder::class)
@NoAutoDetect
class TimeOffBalance
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val employee: JsonField<String>,
    private val balance: JsonField<Double>,
    private val used: JsonField<Double>,
    private val policyType: JsonField<PolicyTypeEnum>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** The employee the balance belongs to. */
    fun employee(): Optional<String> = Optional.ofNullable(employee.getNullable("employee"))

    /** The current remaining PTO balance, always measured in terms of hours. */
    fun balance(): Optional<Double> = Optional.ofNullable(balance.getNullable("balance"))

    /** The amount of PTO used in terms of hours. */
    fun used(): Optional<Double> = Optional.ofNullable(used.getNullable("used"))

    /**
     * - `VACATION` - VACATION
     * - `SICK` - SICK
     * - `PERSONAL` - PERSONAL
     * - `JURY_DUTY` - JURY_DUTY
     * - `VOLUNTEER` - VOLUNTEER
     * - `BEREAVEMENT` - BEREAVEMENT
     */
    fun policyType(): Optional<PolicyTypeEnum> =
        Optional.ofNullable(policyType.getNullable("policy_type"))

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    fun remoteWasDeleted(): Optional<Boolean> =
        Optional.ofNullable(remoteWasDeleted.getNullable("remote_was_deleted"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<RemoteData>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    /** The employee the balance belongs to. */
    @JsonProperty("employee") @ExcludeMissing fun _employee() = employee

    /** The current remaining PTO balance, always measured in terms of hours. */
    @JsonProperty("balance") @ExcludeMissing fun _balance() = balance

    /** The amount of PTO used in terms of hours. */
    @JsonProperty("used") @ExcludeMissing fun _used() = used

    /**
     * - `VACATION` - VACATION
     * - `SICK` - SICK
     * - `PERSONAL` - PERSONAL
     * - `JURY_DUTY` - JURY_DUTY
     * - `VOLUNTEER` - VOLUNTEER
     * - `BEREAVEMENT` - BEREAVEMENT
     */
    @JsonProperty("policy_type") @ExcludeMissing fun _policyType() = policyType

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): TimeOffBalance = apply {
        if (!validated) {
            id()
            remoteId()
            employee()
            balance()
            used()
            policyType()
            remoteWasDeleted()
            modifiedAt()
            remoteData().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TimeOffBalance &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.employee == other.employee &&
            this.balance == other.balance &&
            this.used == other.used &&
            this.policyType == other.policyType &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    remoteId,
                    employee,
                    balance,
                    used,
                    policyType,
                    remoteWasDeleted,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "TimeOffBalance{id=$id, remoteId=$remoteId, employee=$employee, balance=$balance, used=$used, policyType=$policyType, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var employee: JsonField<String> = JsonMissing.of()
        private var balance: JsonField<Double> = JsonMissing.of()
        private var used: JsonField<Double> = JsonMissing.of()
        private var policyType: JsonField<PolicyTypeEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(timeOffBalance: TimeOffBalance) = apply {
            this.id = timeOffBalance.id
            this.remoteId = timeOffBalance.remoteId
            this.employee = timeOffBalance.employee
            this.balance = timeOffBalance.balance
            this.used = timeOffBalance.used
            this.policyType = timeOffBalance.policyType
            this.remoteWasDeleted = timeOffBalance.remoteWasDeleted
            this.fieldMappings = timeOffBalance.fieldMappings
            this.modifiedAt = timeOffBalance.modifiedAt
            this.remoteData = timeOffBalance.remoteData
            additionalProperties(timeOffBalance.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The employee the balance belongs to. */
        fun employee(employee: String) = employee(JsonField.of(employee))

        /** The employee the balance belongs to. */
        @JsonProperty("employee")
        @ExcludeMissing
        fun employee(employee: JsonField<String>) = apply { this.employee = employee }

        /** The current remaining PTO balance, always measured in terms of hours. */
        fun balance(balance: Double) = balance(JsonField.of(balance))

        /** The current remaining PTO balance, always measured in terms of hours. */
        @JsonProperty("balance")
        @ExcludeMissing
        fun balance(balance: JsonField<Double>) = apply { this.balance = balance }

        /** The amount of PTO used in terms of hours. */
        fun used(used: Double) = used(JsonField.of(used))

        /** The amount of PTO used in terms of hours. */
        @JsonProperty("used")
        @ExcludeMissing
        fun used(used: JsonField<Double>) = apply { this.used = used }

        /**
         * - `VACATION` - VACATION
         * - `SICK` - SICK
         * - `PERSONAL` - PERSONAL
         * - `JURY_DUTY` - JURY_DUTY
         * - `VOLUNTEER` - VOLUNTEER
         * - `BEREAVEMENT` - BEREAVEMENT
         */
        fun policyType(policyType: PolicyTypeEnum) = policyType(JsonField.of(policyType))

        /**
         * - `VACATION` - VACATION
         * - `SICK` - SICK
         * - `PERSONAL` - PERSONAL
         * - `JURY_DUTY` - JURY_DUTY
         * - `VOLUNTEER` - VOLUNTEER
         * - `BEREAVEMENT` - BEREAVEMENT
         */
        @JsonProperty("policy_type")
        @ExcludeMissing
        fun policyType(policyType: JsonField<PolicyTypeEnum>) = apply {
            this.policyType = policyType
        }

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        @JsonProperty("remote_was_deleted")
        @ExcludeMissing
        fun remoteWasDeleted(remoteWasDeleted: JsonField<Boolean>) = apply {
            this.remoteWasDeleted = remoteWasDeleted
        }

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

        fun build(): TimeOffBalance =
            TimeOffBalance(
                id,
                remoteId,
                employee,
                balance,
                used,
                policyType,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class PolicyTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PolicyTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val VACATION = PolicyTypeEnum(JsonField.of("VACATION"))

            @JvmField val SICK = PolicyTypeEnum(JsonField.of("SICK"))

            @JvmField val PERSONAL = PolicyTypeEnum(JsonField.of("PERSONAL"))

            @JvmField val JURY_DUTY = PolicyTypeEnum(JsonField.of("JURY_DUTY"))

            @JvmField val VOLUNTEER = PolicyTypeEnum(JsonField.of("VOLUNTEER"))

            @JvmField val BEREAVEMENT = PolicyTypeEnum(JsonField.of("BEREAVEMENT"))

            @JvmStatic fun of(value: String) = PolicyTypeEnum(JsonField.of(value))
        }

        enum class Known {
            VACATION,
            SICK,
            PERSONAL,
            JURY_DUTY,
            VOLUNTEER,
            BEREAVEMENT,
        }

        enum class Value {
            VACATION,
            SICK,
            PERSONAL,
            JURY_DUTY,
            VOLUNTEER,
            BEREAVEMENT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                VACATION -> Value.VACATION
                SICK -> Value.SICK
                PERSONAL -> Value.PERSONAL
                JURY_DUTY -> Value.JURY_DUTY
                VOLUNTEER -> Value.VOLUNTEER
                BEREAVEMENT -> Value.BEREAVEMENT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                VACATION -> Known.VACATION
                SICK -> Known.SICK
                PERSONAL -> Known.PERSONAL
                JURY_DUTY -> Known.JURY_DUTY
                VOLUNTEER -> Known.VOLUNTEER
                BEREAVEMENT -> Known.BEREAVEMENT
                else -> throw MergeInvalidDataException("Unknown PolicyTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
