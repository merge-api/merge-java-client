package dev.merge.api.models.hris

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

class TimeOffCreateParams
constructor(
    private val model: TimeOffRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): TimeOffRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): TimeOffCreateBody {
        return TimeOffCreateBody(model, additionalBodyProperties)
    }

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.isDebugMode?.let { params.put("is_debug_mode", listOf(it.toString())) }
        this.runAsync?.let { params.put("run_async", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = TimeOffCreateBody.Builder::class)
    @NoAutoDetect
    class TimeOffCreateBody
    internal constructor(
        private val model: TimeOffRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

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
        @JsonProperty("model") fun model(): TimeOffRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TimeOffCreateBody &&
                this.model == other.model &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(model, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "TimeOffCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: TimeOffRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(timeOffCreateBody: TimeOffCreateBody) = apply {
                this.model = timeOffCreateBody.model
                additionalProperties(timeOffCreateBody.additionalProperties)
            }

            /**
             * # The TimeOff Object
             *
             * ### Description
             *
             * The `TimeOff` object is used to represent all employees' Time Off entries.
             *
             * ### Usage Example
             *
             * Fetch from the `LIST TimeOffs` endpoint and filter by `ID` to show all time off
             * requests.
             */
            @JsonProperty("model") fun model(model: TimeOffRequest) = apply { this.model = model }

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

            fun build(): TimeOffCreateBody =
                TimeOffCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    additionalProperties.toUnmodifiable()
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TimeOffCreateParams &&
            this.model == other.model &&
            this.isDebugMode == other.isDebugMode &&
            this.runAsync == other.runAsync &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            isDebugMode,
            runAsync,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "TimeOffCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: TimeOffRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(timeOffCreateParams: TimeOffCreateParams) = apply {
            this.model = timeOffCreateParams.model
            this.isDebugMode = timeOffCreateParams.isDebugMode
            this.runAsync = timeOffCreateParams.runAsync
            additionalQueryParams(timeOffCreateParams.additionalQueryParams)
            additionalHeaders(timeOffCreateParams.additionalHeaders)
            additionalBodyProperties(timeOffCreateParams.additionalBodyProperties)
        }

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
        fun model(model: TimeOffRequest) = apply { this.model = model }

        /** Whether to include debug fields (such as log file links) in the response. */
        fun isDebugMode(isDebugMode: Boolean) = apply { this.isDebugMode = isDebugMode }

        /** Whether or not third-party updates should be run asynchronously. */
        fun runAsync(runAsync: Boolean) = apply { this.runAsync = runAsync }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): TimeOffCreateParams =
            TimeOffCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

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
    @JsonDeserialize(builder = TimeOffRequest.Builder::class)
    @NoAutoDetect
    class TimeOffRequest
    private constructor(
        private val employee: String?,
        private val approver: String?,
        private val status: TimeOffStatusEnum?,
        private val employeeNote: String?,
        private val units: UnitsEnum?,
        private val amount: Double?,
        private val requestType: RequestTypeEnum?,
        private val startTime: OffsetDateTime?,
        private val endTime: OffsetDateTime?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The employee requesting time off. */
        @JsonProperty("employee") fun employee(): String? = employee

        /** The Merge ID of the employee with the ability to approve the time off request. */
        @JsonProperty("approver") fun approver(): String? = approver

        /**
         * - `REQUESTED` - REQUESTED
         * - `APPROVED` - APPROVED
         * - `DECLINED` - DECLINED
         * - `CANCELLED` - CANCELLED
         * - `DELETED` - DELETED
         */
        @JsonProperty("status") fun status(): TimeOffStatusEnum? = status

        /** The employee note for this time off request. */
        @JsonProperty("employee_note") fun employeeNote(): String? = employeeNote

        /**
         * - `HOURS` - HOURS
         * - `DAYS` - DAYS
         */
        @JsonProperty("units") fun units(): UnitsEnum? = units

        /** The time off quantity measured by the prescribed “units”. */
        @JsonProperty("amount") fun amount(): Double? = amount

        /**
         * - `VACATION` - VACATION
         * - `SICK` - SICK
         * - `PERSONAL` - PERSONAL
         * - `JURY_DUTY` - JURY_DUTY
         * - `VOLUNTEER` - VOLUNTEER
         * - `BEREAVEMENT` - BEREAVEMENT
         */
        @JsonProperty("request_type") fun requestType(): RequestTypeEnum? = requestType

        /** The day and time of the start of the time requested off. */
        @JsonProperty("start_time") fun startTime(): OffsetDateTime? = startTime

        /** The day and time of the end of the time requested off. */
        @JsonProperty("end_time") fun endTime(): OffsetDateTime? = endTime

        @JsonProperty("integration_params") fun integrationParams(): JsonValue? = integrationParams

        @JsonProperty("linked_account_params")
        fun linkedAccountParams(): JsonValue? = linkedAccountParams

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TimeOffRequest &&
                this.employee == other.employee &&
                this.approver == other.approver &&
                this.status == other.status &&
                this.employeeNote == other.employeeNote &&
                this.units == other.units &&
                this.amount == other.amount &&
                this.requestType == other.requestType &&
                this.startTime == other.startTime &&
                this.endTime == other.endTime &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        employee,
                        approver,
                        status,
                        employeeNote,
                        units,
                        amount,
                        requestType,
                        startTime,
                        endTime,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "TimeOffRequest{employee=$employee, approver=$approver, status=$status, employeeNote=$employeeNote, units=$units, amount=$amount, requestType=$requestType, startTime=$startTime, endTime=$endTime, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var employee: String? = null
            private var approver: String? = null
            private var status: TimeOffStatusEnum? = null
            private var employeeNote: String? = null
            private var units: UnitsEnum? = null
            private var amount: Double? = null
            private var requestType: RequestTypeEnum? = null
            private var startTime: OffsetDateTime? = null
            private var endTime: OffsetDateTime? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(timeOffRequest: TimeOffRequest) = apply {
                this.employee = timeOffRequest.employee
                this.approver = timeOffRequest.approver
                this.status = timeOffRequest.status
                this.employeeNote = timeOffRequest.employeeNote
                this.units = timeOffRequest.units
                this.amount = timeOffRequest.amount
                this.requestType = timeOffRequest.requestType
                this.startTime = timeOffRequest.startTime
                this.endTime = timeOffRequest.endTime
                this.integrationParams = timeOffRequest.integrationParams
                this.linkedAccountParams = timeOffRequest.linkedAccountParams
                additionalProperties(timeOffRequest.additionalProperties)
            }

            /** The employee requesting time off. */
            @JsonProperty("employee")
            fun employee(employee: String) = apply { this.employee = employee }

            /** The Merge ID of the employee with the ability to approve the time off request. */
            @JsonProperty("approver")
            fun approver(approver: String) = apply { this.approver = approver }

            /**
             * - `REQUESTED` - REQUESTED
             * - `APPROVED` - APPROVED
             * - `DECLINED` - DECLINED
             * - `CANCELLED` - CANCELLED
             * - `DELETED` - DELETED
             */
            @JsonProperty("status")
            fun status(status: TimeOffStatusEnum) = apply { this.status = status }

            /** The employee note for this time off request. */
            @JsonProperty("employee_note")
            fun employeeNote(employeeNote: String) = apply { this.employeeNote = employeeNote }

            /**
             * - `HOURS` - HOURS
             * - `DAYS` - DAYS
             */
            @JsonProperty("units") fun units(units: UnitsEnum) = apply { this.units = units }

            /** The time off quantity measured by the prescribed “units”. */
            @JsonProperty("amount") fun amount(amount: Double) = apply { this.amount = amount }

            /**
             * - `VACATION` - VACATION
             * - `SICK` - SICK
             * - `PERSONAL` - PERSONAL
             * - `JURY_DUTY` - JURY_DUTY
             * - `VOLUNTEER` - VOLUNTEER
             * - `BEREAVEMENT` - BEREAVEMENT
             */
            @JsonProperty("request_type")
            fun requestType(requestType: RequestTypeEnum) = apply { this.requestType = requestType }

            /** The day and time of the start of the time requested off. */
            @JsonProperty("start_time")
            fun startTime(startTime: OffsetDateTime) = apply { this.startTime = startTime }

            /** The day and time of the end of the time requested off. */
            @JsonProperty("end_time")
            fun endTime(endTime: OffsetDateTime) = apply { this.endTime = endTime }

            @JsonProperty("integration_params")
            fun integrationParams(integrationParams: JsonValue) = apply {
                this.integrationParams = integrationParams
            }

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                this.linkedAccountParams = linkedAccountParams
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

            fun build(): TimeOffRequest =
                TimeOffRequest(
                    employee,
                    approver,
                    status,
                    employeeNote,
                    units,
                    amount,
                    requestType,
                    startTime,
                    endTime,
                    integrationParams,
                    linkedAccountParams,
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
}
