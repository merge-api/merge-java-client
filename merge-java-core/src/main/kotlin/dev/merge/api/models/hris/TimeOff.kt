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
 * # The TimeOff Object
 *
 * ### Description
 *
 * The `TimeOff` object is used to represent all employees' Time Off entries.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST TimeOffs` endpoint and filter by `ID` to show all time off requests.
 */
@JsonDeserialize(builder = TimeOff.Builder::class)
@NoAutoDetect
class TimeOff
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val employee: JsonField<String>,
    private val approver: JsonField<String>,
    private val status: JsonField<TimeOffStatusEnum>,
    private val employeeNote: JsonField<String>,
    private val units: JsonField<UnitsEnum>,
    private val amount: JsonField<Double>,
    private val requestType: JsonField<RequestTypeEnum>,
    private val startTime: JsonField<OffsetDateTime>,
    private val endTime: JsonField<OffsetDateTime>,
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

    /** The employee requesting time off. */
    fun employee(): Optional<String> = Optional.ofNullable(employee.getNullable("employee"))

    /** The Merge ID of the employee with the ability to approve the time off request. */
    fun approver(): Optional<String> = Optional.ofNullable(approver.getNullable("approver"))

    /**
     * - `REQUESTED` - REQUESTED
     * - `APPROVED` - APPROVED
     * - `DECLINED` - DECLINED
     * - `CANCELLED` - CANCELLED
     * - `DELETED` - DELETED
     */
    fun status(): Optional<TimeOffStatusEnum> = Optional.ofNullable(status.getNullable("status"))

    /** The employee note for this time off request. */
    fun employeeNote(): Optional<String> =
        Optional.ofNullable(employeeNote.getNullable("employee_note"))

    /**
     * - `HOURS` - HOURS
     * - `DAYS` - DAYS
     */
    fun units(): Optional<UnitsEnum> = Optional.ofNullable(units.getNullable("units"))

    /** The time off quantity measured by the prescribed “units”. */
    fun amount(): Optional<Double> = Optional.ofNullable(amount.getNullable("amount"))

    /**
     * - `VACATION` - VACATION
     * - `SICK` - SICK
     * - `PERSONAL` - PERSONAL
     * - `JURY_DUTY` - JURY_DUTY
     * - `VOLUNTEER` - VOLUNTEER
     * - `BEREAVEMENT` - BEREAVEMENT
     */
    fun requestType(): Optional<RequestTypeEnum> =
        Optional.ofNullable(requestType.getNullable("request_type"))

    /** The day and time of the start of the time requested off. */
    fun startTime(): Optional<OffsetDateTime> =
        Optional.ofNullable(startTime.getNullable("start_time"))

    /** The day and time of the end of the time requested off. */
    fun endTime(): Optional<OffsetDateTime> = Optional.ofNullable(endTime.getNullable("end_time"))

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

    /** The employee requesting time off. */
    @JsonProperty("employee") @ExcludeMissing fun _employee() = employee

    /** The Merge ID of the employee with the ability to approve the time off request. */
    @JsonProperty("approver") @ExcludeMissing fun _approver() = approver

    /**
     * - `REQUESTED` - REQUESTED
     * - `APPROVED` - APPROVED
     * - `DECLINED` - DECLINED
     * - `CANCELLED` - CANCELLED
     * - `DELETED` - DELETED
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** The employee note for this time off request. */
    @JsonProperty("employee_note") @ExcludeMissing fun _employeeNote() = employeeNote

    /**
     * - `HOURS` - HOURS
     * - `DAYS` - DAYS
     */
    @JsonProperty("units") @ExcludeMissing fun _units() = units

    /** The time off quantity measured by the prescribed “units”. */
    @JsonProperty("amount") @ExcludeMissing fun _amount() = amount

    /**
     * - `VACATION` - VACATION
     * - `SICK` - SICK
     * - `PERSONAL` - PERSONAL
     * - `JURY_DUTY` - JURY_DUTY
     * - `VOLUNTEER` - VOLUNTEER
     * - `BEREAVEMENT` - BEREAVEMENT
     */
    @JsonProperty("request_type") @ExcludeMissing fun _requestType() = requestType

    /** The day and time of the start of the time requested off. */
    @JsonProperty("start_time") @ExcludeMissing fun _startTime() = startTime

    /** The day and time of the end of the time requested off. */
    @JsonProperty("end_time") @ExcludeMissing fun _endTime() = endTime

    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            id()
            remoteId()
            employee()
            approver()
            status()
            employeeNote()
            units()
            amount()
            requestType()
            startTime()
            endTime()
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

        return other is TimeOff &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.employee == other.employee &&
            this.approver == other.approver &&
            this.status == other.status &&
            this.employeeNote == other.employeeNote &&
            this.units == other.units &&
            this.amount == other.amount &&
            this.requestType == other.requestType &&
            this.startTime == other.startTime &&
            this.endTime == other.endTime &&
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
                    approver,
                    status,
                    employeeNote,
                    units,
                    amount,
                    requestType,
                    startTime,
                    endTime,
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
        "TimeOff{id=$id, remoteId=$remoteId, employee=$employee, approver=$approver, status=$status, employeeNote=$employeeNote, units=$units, amount=$amount, requestType=$requestType, startTime=$startTime, endTime=$endTime, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var employee: JsonField<String> = JsonMissing.of()
        private var approver: JsonField<String> = JsonMissing.of()
        private var status: JsonField<TimeOffStatusEnum> = JsonMissing.of()
        private var employeeNote: JsonField<String> = JsonMissing.of()
        private var units: JsonField<UnitsEnum> = JsonMissing.of()
        private var amount: JsonField<Double> = JsonMissing.of()
        private var requestType: JsonField<RequestTypeEnum> = JsonMissing.of()
        private var startTime: JsonField<OffsetDateTime> = JsonMissing.of()
        private var endTime: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(timeOff: TimeOff) = apply {
            this.id = timeOff.id
            this.remoteId = timeOff.remoteId
            this.employee = timeOff.employee
            this.approver = timeOff.approver
            this.status = timeOff.status
            this.employeeNote = timeOff.employeeNote
            this.units = timeOff.units
            this.amount = timeOff.amount
            this.requestType = timeOff.requestType
            this.startTime = timeOff.startTime
            this.endTime = timeOff.endTime
            this.remoteWasDeleted = timeOff.remoteWasDeleted
            this.fieldMappings = timeOff.fieldMappings
            this.modifiedAt = timeOff.modifiedAt
            this.remoteData = timeOff.remoteData
            additionalProperties(timeOff.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The employee requesting time off. */
        fun employee(employee: String) = employee(JsonField.of(employee))

        /** The employee requesting time off. */
        @JsonProperty("employee")
        @ExcludeMissing
        fun employee(employee: JsonField<String>) = apply { this.employee = employee }

        /** The Merge ID of the employee with the ability to approve the time off request. */
        fun approver(approver: String) = approver(JsonField.of(approver))

        /** The Merge ID of the employee with the ability to approve the time off request. */
        @JsonProperty("approver")
        @ExcludeMissing
        fun approver(approver: JsonField<String>) = apply { this.approver = approver }

        /**
         * - `REQUESTED` - REQUESTED
         * - `APPROVED` - APPROVED
         * - `DECLINED` - DECLINED
         * - `CANCELLED` - CANCELLED
         * - `DELETED` - DELETED
         */
        fun status(status: TimeOffStatusEnum) = status(JsonField.of(status))

        /**
         * - `REQUESTED` - REQUESTED
         * - `APPROVED` - APPROVED
         * - `DECLINED` - DECLINED
         * - `CANCELLED` - CANCELLED
         * - `DELETED` - DELETED
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<TimeOffStatusEnum>) = apply { this.status = status }

        /** The employee note for this time off request. */
        fun employeeNote(employeeNote: String) = employeeNote(JsonField.of(employeeNote))

        /** The employee note for this time off request. */
        @JsonProperty("employee_note")
        @ExcludeMissing
        fun employeeNote(employeeNote: JsonField<String>) = apply {
            this.employeeNote = employeeNote
        }

        /**
         * - `HOURS` - HOURS
         * - `DAYS` - DAYS
         */
        fun units(units: UnitsEnum) = units(JsonField.of(units))

        /**
         * - `HOURS` - HOURS
         * - `DAYS` - DAYS
         */
        @JsonProperty("units")
        @ExcludeMissing
        fun units(units: JsonField<UnitsEnum>) = apply { this.units = units }

        /** The time off quantity measured by the prescribed “units”. */
        fun amount(amount: Double) = amount(JsonField.of(amount))

        /** The time off quantity measured by the prescribed “units”. */
        @JsonProperty("amount")
        @ExcludeMissing
        fun amount(amount: JsonField<Double>) = apply { this.amount = amount }

        /**
         * - `VACATION` - VACATION
         * - `SICK` - SICK
         * - `PERSONAL` - PERSONAL
         * - `JURY_DUTY` - JURY_DUTY
         * - `VOLUNTEER` - VOLUNTEER
         * - `BEREAVEMENT` - BEREAVEMENT
         */
        fun requestType(requestType: RequestTypeEnum) = requestType(JsonField.of(requestType))

        /**
         * - `VACATION` - VACATION
         * - `SICK` - SICK
         * - `PERSONAL` - PERSONAL
         * - `JURY_DUTY` - JURY_DUTY
         * - `VOLUNTEER` - VOLUNTEER
         * - `BEREAVEMENT` - BEREAVEMENT
         */
        @JsonProperty("request_type")
        @ExcludeMissing
        fun requestType(requestType: JsonField<RequestTypeEnum>) = apply {
            this.requestType = requestType
        }

        /** The day and time of the start of the time requested off. */
        fun startTime(startTime: OffsetDateTime) = startTime(JsonField.of(startTime))

        /** The day and time of the start of the time requested off. */
        @JsonProperty("start_time")
        @ExcludeMissing
        fun startTime(startTime: JsonField<OffsetDateTime>) = apply { this.startTime = startTime }

        /** The day and time of the end of the time requested off. */
        fun endTime(endTime: OffsetDateTime) = endTime(JsonField.of(endTime))

        /** The day and time of the end of the time requested off. */
        @JsonProperty("end_time")
        @ExcludeMissing
        fun endTime(endTime: JsonField<OffsetDateTime>) = apply { this.endTime = endTime }

        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

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

        fun build(): TimeOff =
            TimeOff(
                id,
                remoteId,
                employee,
                approver,
                status,
                employeeNote,
                units,
                amount,
                requestType,
                startTime,
                endTime,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class TimeOffStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TimeOffStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val REQUESTED = TimeOffStatusEnum(JsonField.of("REQUESTED"))

            @JvmField val APPROVED = TimeOffStatusEnum(JsonField.of("APPROVED"))

            @JvmField val DECLINED = TimeOffStatusEnum(JsonField.of("DECLINED"))

            @JvmField val CANCELLED = TimeOffStatusEnum(JsonField.of("CANCELLED"))

            @JvmField val DELETED = TimeOffStatusEnum(JsonField.of("DELETED"))

            @JvmStatic fun of(value: String) = TimeOffStatusEnum(JsonField.of(value))
        }

        enum class Known {
            REQUESTED,
            APPROVED,
            DECLINED,
            CANCELLED,
            DELETED,
        }

        enum class Value {
            REQUESTED,
            APPROVED,
            DECLINED,
            CANCELLED,
            DELETED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                REQUESTED -> Value.REQUESTED
                APPROVED -> Value.APPROVED
                DECLINED -> Value.DECLINED
                CANCELLED -> Value.CANCELLED
                DELETED -> Value.DELETED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                REQUESTED -> Known.REQUESTED
                APPROVED -> Known.APPROVED
                DECLINED -> Known.DECLINED
                CANCELLED -> Known.CANCELLED
                DELETED -> Known.DELETED
                else -> throw MergeInvalidDataException("Unknown TimeOffStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class UnitsEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UnitsEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val HOURS = UnitsEnum(JsonField.of("HOURS"))

            @JvmField val DAYS = UnitsEnum(JsonField.of("DAYS"))

            @JvmStatic fun of(value: String) = UnitsEnum(JsonField.of(value))
        }

        enum class Known {
            HOURS,
            DAYS,
        }

        enum class Value {
            HOURS,
            DAYS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                HOURS -> Value.HOURS
                DAYS -> Value.DAYS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                HOURS -> Known.HOURS
                DAYS -> Known.DAYS
                else -> throw MergeInvalidDataException("Unknown UnitsEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class RequestTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RequestTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val VACATION = RequestTypeEnum(JsonField.of("VACATION"))

            @JvmField val SICK = RequestTypeEnum(JsonField.of("SICK"))

            @JvmField val PERSONAL = RequestTypeEnum(JsonField.of("PERSONAL"))

            @JvmField val JURY_DUTY = RequestTypeEnum(JsonField.of("JURY_DUTY"))

            @JvmField val VOLUNTEER = RequestTypeEnum(JsonField.of("VOLUNTEER"))

            @JvmField val BEREAVEMENT = RequestTypeEnum(JsonField.of("BEREAVEMENT"))

            @JvmStatic fun of(value: String) = RequestTypeEnum(JsonField.of(value))
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
                else -> throw MergeInvalidDataException("Unknown RequestTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
