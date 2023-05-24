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
 * # The PayrollRun Object
 *
 * ### Description
 *
 * The `PayrollRun` object is used to represent a group of pay statements for a specific pay
 * schedule.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST PayrollRuns` endpoint and filter by `ID` to show all payroll runs.
 */
@JsonDeserialize(builder = PayrollRun.Builder::class)
@NoAutoDetect
class PayrollRun
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val runState: JsonField<RunStateEnum>,
    private val runType: JsonField<RunTypeEnum>,
    private val startDate: JsonField<OffsetDateTime>,
    private val endDate: JsonField<OffsetDateTime>,
    private val checkDate: JsonField<OffsetDateTime>,
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

    /**
     * - `PAID` - PAID
     * - `DRAFT` - DRAFT
     * - `APPROVED` - APPROVED
     * - `FAILED` - FAILED
     * - `CLOSED` - CLOSED
     */
    fun runState(): Optional<RunStateEnum> = Optional.ofNullable(runState.getNullable("run_state"))

    /**
     * - `REGULAR` - REGULAR
     * - `OFF_CYCLE` - OFF_CYCLE
     * - `CORRECTION` - CORRECTION
     * - `TERMINATION` - TERMINATION
     * - `SIGN_ON_BONUS` - SIGN_ON_BONUS
     */
    fun runType(): Optional<RunTypeEnum> = Optional.ofNullable(runType.getNullable("run_type"))

    /** The day and time the payroll run started. */
    fun startDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(startDate.getNullable("start_date"))

    /** The day and time the payroll run ended. */
    fun endDate(): Optional<OffsetDateTime> = Optional.ofNullable(endDate.getNullable("end_date"))

    /** The day and time the payroll run was checked. */
    fun checkDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(checkDate.getNullable("check_date"))

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

    /**
     * - `PAID` - PAID
     * - `DRAFT` - DRAFT
     * - `APPROVED` - APPROVED
     * - `FAILED` - FAILED
     * - `CLOSED` - CLOSED
     */
    @JsonProperty("run_state") @ExcludeMissing fun _runState() = runState

    /**
     * - `REGULAR` - REGULAR
     * - `OFF_CYCLE` - OFF_CYCLE
     * - `CORRECTION` - CORRECTION
     * - `TERMINATION` - TERMINATION
     * - `SIGN_ON_BONUS` - SIGN_ON_BONUS
     */
    @JsonProperty("run_type") @ExcludeMissing fun _runType() = runType

    /** The day and time the payroll run started. */
    @JsonProperty("start_date") @ExcludeMissing fun _startDate() = startDate

    /** The day and time the payroll run ended. */
    @JsonProperty("end_date") @ExcludeMissing fun _endDate() = endDate

    /** The day and time the payroll run was checked. */
    @JsonProperty("check_date") @ExcludeMissing fun _checkDate() = checkDate

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): PayrollRun = apply {
        if (!validated) {
            id()
            remoteId()
            runState()
            runType()
            startDate()
            endDate()
            checkDate()
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

        return other is PayrollRun &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.runState == other.runState &&
            this.runType == other.runType &&
            this.startDate == other.startDate &&
            this.endDate == other.endDate &&
            this.checkDate == other.checkDate &&
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
                    runState,
                    runType,
                    startDate,
                    endDate,
                    checkDate,
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
        "PayrollRun{id=$id, remoteId=$remoteId, runState=$runState, runType=$runType, startDate=$startDate, endDate=$endDate, checkDate=$checkDate, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var runState: JsonField<RunStateEnum> = JsonMissing.of()
        private var runType: JsonField<RunTypeEnum> = JsonMissing.of()
        private var startDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var endDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var checkDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(payrollRun: PayrollRun) = apply {
            this.id = payrollRun.id
            this.remoteId = payrollRun.remoteId
            this.runState = payrollRun.runState
            this.runType = payrollRun.runType
            this.startDate = payrollRun.startDate
            this.endDate = payrollRun.endDate
            this.checkDate = payrollRun.checkDate
            this.remoteWasDeleted = payrollRun.remoteWasDeleted
            this.fieldMappings = payrollRun.fieldMappings
            this.modifiedAt = payrollRun.modifiedAt
            this.remoteData = payrollRun.remoteData
            additionalProperties(payrollRun.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /**
         * - `PAID` - PAID
         * - `DRAFT` - DRAFT
         * - `APPROVED` - APPROVED
         * - `FAILED` - FAILED
         * - `CLOSED` - CLOSED
         */
        fun runState(runState: RunStateEnum) = runState(JsonField.of(runState))

        /**
         * - `PAID` - PAID
         * - `DRAFT` - DRAFT
         * - `APPROVED` - APPROVED
         * - `FAILED` - FAILED
         * - `CLOSED` - CLOSED
         */
        @JsonProperty("run_state")
        @ExcludeMissing
        fun runState(runState: JsonField<RunStateEnum>) = apply { this.runState = runState }

        /**
         * - `REGULAR` - REGULAR
         * - `OFF_CYCLE` - OFF_CYCLE
         * - `CORRECTION` - CORRECTION
         * - `TERMINATION` - TERMINATION
         * - `SIGN_ON_BONUS` - SIGN_ON_BONUS
         */
        fun runType(runType: RunTypeEnum) = runType(JsonField.of(runType))

        /**
         * - `REGULAR` - REGULAR
         * - `OFF_CYCLE` - OFF_CYCLE
         * - `CORRECTION` - CORRECTION
         * - `TERMINATION` - TERMINATION
         * - `SIGN_ON_BONUS` - SIGN_ON_BONUS
         */
        @JsonProperty("run_type")
        @ExcludeMissing
        fun runType(runType: JsonField<RunTypeEnum>) = apply { this.runType = runType }

        /** The day and time the payroll run started. */
        fun startDate(startDate: OffsetDateTime) = startDate(JsonField.of(startDate))

        /** The day and time the payroll run started. */
        @JsonProperty("start_date")
        @ExcludeMissing
        fun startDate(startDate: JsonField<OffsetDateTime>) = apply { this.startDate = startDate }

        /** The day and time the payroll run ended. */
        fun endDate(endDate: OffsetDateTime) = endDate(JsonField.of(endDate))

        /** The day and time the payroll run ended. */
        @JsonProperty("end_date")
        @ExcludeMissing
        fun endDate(endDate: JsonField<OffsetDateTime>) = apply { this.endDate = endDate }

        /** The day and time the payroll run was checked. */
        fun checkDate(checkDate: OffsetDateTime) = checkDate(JsonField.of(checkDate))

        /** The day and time the payroll run was checked. */
        @JsonProperty("check_date")
        @ExcludeMissing
        fun checkDate(checkDate: JsonField<OffsetDateTime>) = apply { this.checkDate = checkDate }

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

        fun build(): PayrollRun =
            PayrollRun(
                id,
                remoteId,
                runState,
                runType,
                startDate,
                endDate,
                checkDate,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class RunStateEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RunStateEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val PAID = RunStateEnum(JsonField.of("PAID"))

            @JvmField val DRAFT = RunStateEnum(JsonField.of("DRAFT"))

            @JvmField val APPROVED = RunStateEnum(JsonField.of("APPROVED"))

            @JvmField val FAILED = RunStateEnum(JsonField.of("FAILED"))

            @JvmField val CLOSED = RunStateEnum(JsonField.of("CLOSED"))

            @JvmStatic fun of(value: String) = RunStateEnum(JsonField.of(value))
        }

        enum class Known {
            PAID,
            DRAFT,
            APPROVED,
            FAILED,
            CLOSED,
        }

        enum class Value {
            PAID,
            DRAFT,
            APPROVED,
            FAILED,
            CLOSED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                PAID -> Value.PAID
                DRAFT -> Value.DRAFT
                APPROVED -> Value.APPROVED
                FAILED -> Value.FAILED
                CLOSED -> Value.CLOSED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                PAID -> Known.PAID
                DRAFT -> Known.DRAFT
                APPROVED -> Known.APPROVED
                FAILED -> Known.FAILED
                CLOSED -> Known.CLOSED
                else -> throw MergeInvalidDataException("Unknown RunStateEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class RunTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RunTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val REGULAR = RunTypeEnum(JsonField.of("REGULAR"))

            @JvmField val OFF_CYCLE = RunTypeEnum(JsonField.of("OFF_CYCLE"))

            @JvmField val CORRECTION = RunTypeEnum(JsonField.of("CORRECTION"))

            @JvmField val TERMINATION = RunTypeEnum(JsonField.of("TERMINATION"))

            @JvmField val SIGN_ON_BONUS = RunTypeEnum(JsonField.of("SIGN_ON_BONUS"))

            @JvmStatic fun of(value: String) = RunTypeEnum(JsonField.of(value))
        }

        enum class Known {
            REGULAR,
            OFF_CYCLE,
            CORRECTION,
            TERMINATION,
            SIGN_ON_BONUS,
        }

        enum class Value {
            REGULAR,
            OFF_CYCLE,
            CORRECTION,
            TERMINATION,
            SIGN_ON_BONUS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                REGULAR -> Value.REGULAR
                OFF_CYCLE -> Value.OFF_CYCLE
                CORRECTION -> Value.CORRECTION
                TERMINATION -> Value.TERMINATION
                SIGN_ON_BONUS -> Value.SIGN_ON_BONUS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                REGULAR -> Known.REGULAR
                OFF_CYCLE -> Known.OFF_CYCLE
                CORRECTION -> Known.CORRECTION
                TERMINATION -> Known.TERMINATION
                SIGN_ON_BONUS -> Known.SIGN_ON_BONUS
                else -> throw MergeInvalidDataException("Unknown RunTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
