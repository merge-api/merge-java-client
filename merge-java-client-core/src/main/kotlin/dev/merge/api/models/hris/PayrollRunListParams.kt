package dev.merge.api.models.hris

import com.fasterxml.jackson.annotation.JsonCreator
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

class PayrollRunListParams
constructor(
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val endedAfter: OffsetDateTime?,
    private val endedBefore: OffsetDateTime?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val pageSize: Long?,
    private val remoteFields: RemoteFields?,
    private val remoteId: String?,
    private val runType: RunType?,
    private val showEnumOrigins: ShowEnumOrigins?,
    private val startedAfter: OffsetDateTime?,
    private val startedBefore: OffsetDateTime?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun endedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(endedAfter)

    fun endedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(endedBefore)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun remoteFields(): Optional<RemoteFields> = Optional.ofNullable(remoteFields)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    fun runType(): Optional<RunType> = Optional.ofNullable(runType)

    fun showEnumOrigins(): Optional<ShowEnumOrigins> = Optional.ofNullable(showEnumOrigins)

    fun startedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(startedAfter)

    fun startedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(startedBefore)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.endedAfter?.let { params.put("ended_after", listOf(it.toString())) }
        this.endedBefore?.let { params.put("ended_before", listOf(it.toString())) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.remoteFields?.let { params.put("remote_fields", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
        this.runType?.let { params.put("run_type", listOf(it.toString())) }
        this.showEnumOrigins?.let { params.put("show_enum_origins", listOf(it.toString())) }
        this.startedAfter?.let { params.put("started_after", listOf(it.toString())) }
        this.startedBefore?.let { params.put("started_before", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PayrollRunListParams &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.endedAfter == other.endedAfter &&
            this.endedBefore == other.endedBefore &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.pageSize == other.pageSize &&
            this.remoteFields == other.remoteFields &&
            this.remoteId == other.remoteId &&
            this.runType == other.runType &&
            this.showEnumOrigins == other.showEnumOrigins &&
            this.startedAfter == other.startedAfter &&
            this.startedBefore == other.startedBefore &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            createdAfter,
            createdBefore,
            cursor,
            endedAfter,
            endedBefore,
            includeDeletedData,
            includeRemoteData,
            modifiedAfter,
            modifiedBefore,
            pageSize,
            remoteFields,
            remoteId,
            runType,
            showEnumOrigins,
            startedAfter,
            startedBefore,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "PayrollRunListParams{createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, endedAfter=$endedAfter, endedBefore=$endedBefore, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, pageSize=$pageSize, remoteFields=$remoteFields, remoteId=$remoteId, runType=$runType, showEnumOrigins=$showEnumOrigins, startedAfter=$startedAfter, startedBefore=$startedBefore, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var createdAfter: OffsetDateTime? = null
        private var createdBefore: OffsetDateTime? = null
        private var cursor: String? = null
        private var endedAfter: OffsetDateTime? = null
        private var endedBefore: OffsetDateTime? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var pageSize: Long? = null
        private var remoteFields: RemoteFields? = null
        private var remoteId: String? = null
        private var runType: RunType? = null
        private var showEnumOrigins: ShowEnumOrigins? = null
        private var startedAfter: OffsetDateTime? = null
        private var startedBefore: OffsetDateTime? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(payrollRunListParams: PayrollRunListParams) = apply {
            this.createdAfter = payrollRunListParams.createdAfter
            this.createdBefore = payrollRunListParams.createdBefore
            this.cursor = payrollRunListParams.cursor
            this.endedAfter = payrollRunListParams.endedAfter
            this.endedBefore = payrollRunListParams.endedBefore
            this.includeDeletedData = payrollRunListParams.includeDeletedData
            this.includeRemoteData = payrollRunListParams.includeRemoteData
            this.modifiedAfter = payrollRunListParams.modifiedAfter
            this.modifiedBefore = payrollRunListParams.modifiedBefore
            this.pageSize = payrollRunListParams.pageSize
            this.remoteFields = payrollRunListParams.remoteFields
            this.remoteId = payrollRunListParams.remoteId
            this.runType = payrollRunListParams.runType
            this.showEnumOrigins = payrollRunListParams.showEnumOrigins
            this.startedAfter = payrollRunListParams.startedAfter
            this.startedBefore = payrollRunListParams.startedBefore
            additionalQueryParams(payrollRunListParams.additionalQueryParams)
            additionalHeaders(payrollRunListParams.additionalHeaders)
        }

        /** If provided, will only return objects created after this datetime. */
        fun createdAfter(createdAfter: OffsetDateTime) = apply { this.createdAfter = createdAfter }

        /** If provided, will only return objects created before this datetime. */
        fun createdBefore(createdBefore: OffsetDateTime) = apply {
            this.createdBefore = createdBefore
        }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

        /** If provided, will only return payroll runs ended after this datetime. */
        fun endedAfter(endedAfter: OffsetDateTime) = apply { this.endedAfter = endedAfter }

        /** If provided, will only return payroll runs ended before this datetime. */
        fun endedBefore(endedBefore: OffsetDateTime) = apply { this.endedBefore = endedBefore }

        /** Whether to include data that was marked as deleted by third party webhooks. */
        fun includeDeletedData(includeDeletedData: Boolean) = apply {
            this.includeDeletedData = includeDeletedData
        }

        /**
         * Whether to include the original data Merge fetched from the third-party to produce these
         * models.
         */
        fun includeRemoteData(includeRemoteData: Boolean) = apply {
            this.includeRemoteData = includeRemoteData
        }

        /** If provided, only objects synced by Merge after this date time will be returned. */
        fun modifiedAfter(modifiedAfter: OffsetDateTime) = apply {
            this.modifiedAfter = modifiedAfter
        }

        /** If provided, only objects synced by Merge before this date time will be returned. */
        fun modifiedBefore(modifiedBefore: OffsetDateTime) = apply {
            this.modifiedBefore = modifiedBefore
        }

        /** Number of results to return per page. */
        fun pageSize(pageSize: Long) = apply { this.pageSize = pageSize }

        /** Deprecated. Use show_enum_origins. */
        fun remoteFields(remoteFields: RemoteFields) = apply { this.remoteFields = remoteFields }

        /** The API provider's ID for the given object. */
        fun remoteId(remoteId: String) = apply { this.remoteId = remoteId }

        /**
         * If provided, will only return PayrollRun's with this status. Options: ('REGULAR',
         * 'OFF_CYCLE', 'CORRECTION', 'TERMINATION', 'SIGN_ON_BONUS')
         *
         * - `REGULAR` - REGULAR
         * - `OFF_CYCLE` - OFF_CYCLE
         * - `CORRECTION` - CORRECTION
         * - `TERMINATION` - TERMINATION
         * - `SIGN_ON_BONUS` - SIGN_ON_BONUS
         */
        fun runType(runType: RunType) = apply { this.runType = runType }

        /** Which fields should be returned in non-normalized form. */
        fun showEnumOrigins(showEnumOrigins: ShowEnumOrigins) = apply {
            this.showEnumOrigins = showEnumOrigins
        }

        /** If provided, will only return payroll runs started after this datetime. */
        fun startedAfter(startedAfter: OffsetDateTime) = apply { this.startedAfter = startedAfter }

        /** If provided, will only return payroll runs started before this datetime. */
        fun startedBefore(startedBefore: OffsetDateTime) = apply {
            this.startedBefore = startedBefore
        }

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

        fun build(): PayrollRunListParams =
            PayrollRunListParams(
                createdAfter,
                createdBefore,
                cursor,
                endedAfter,
                endedBefore,
                includeDeletedData,
                includeRemoteData,
                modifiedAfter,
                modifiedBefore,
                pageSize,
                remoteFields,
                remoteId,
                runType,
                showEnumOrigins,
                startedAfter,
                startedBefore,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }

    class RemoteFields
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RemoteFields && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val RUN_STATE = RemoteFields(JsonField.of("run_state"))

            @JvmField val RUN_STATE_RUN_TYPE = RemoteFields(JsonField.of("run_state,run_type"))

            @JvmField val RUN_TYPE = RemoteFields(JsonField.of("run_type"))

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            RUN_STATE,
            RUN_STATE_RUN_TYPE,
            RUN_TYPE,
        }

        enum class Value {
            RUN_STATE,
            RUN_STATE_RUN_TYPE,
            RUN_TYPE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                RUN_STATE -> Value.RUN_STATE
                RUN_STATE_RUN_TYPE -> Value.RUN_STATE_RUN_TYPE
                RUN_TYPE -> Value.RUN_TYPE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                RUN_STATE -> Known.RUN_STATE
                RUN_STATE_RUN_TYPE -> Known.RUN_STATE_RUN_TYPE
                RUN_TYPE -> Known.RUN_TYPE
                else -> throw MergeInvalidDataException("Unknown RemoteFields: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class RunType
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RunType && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val CORRECTION = RunType(JsonField.of("CORRECTION"))

            @JvmField val OFF_CYCLE = RunType(JsonField.of("OFF_CYCLE"))

            @JvmField val REGULAR = RunType(JsonField.of("REGULAR"))

            @JvmField val SIGN_ON_BONUS = RunType(JsonField.of("SIGN_ON_BONUS"))

            @JvmField val TERMINATION = RunType(JsonField.of("TERMINATION"))

            @JvmStatic fun of(value: String) = RunType(JsonField.of(value))
        }

        enum class Known {
            CORRECTION,
            OFF_CYCLE,
            REGULAR,
            SIGN_ON_BONUS,
            TERMINATION,
        }

        enum class Value {
            CORRECTION,
            OFF_CYCLE,
            REGULAR,
            SIGN_ON_BONUS,
            TERMINATION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CORRECTION -> Value.CORRECTION
                OFF_CYCLE -> Value.OFF_CYCLE
                REGULAR -> Value.REGULAR
                SIGN_ON_BONUS -> Value.SIGN_ON_BONUS
                TERMINATION -> Value.TERMINATION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CORRECTION -> Known.CORRECTION
                OFF_CYCLE -> Known.OFF_CYCLE
                REGULAR -> Known.REGULAR
                SIGN_ON_BONUS -> Known.SIGN_ON_BONUS
                TERMINATION -> Known.TERMINATION
                else -> throw MergeInvalidDataException("Unknown RunType: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class ShowEnumOrigins
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ShowEnumOrigins && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val RUN_STATE = ShowEnumOrigins(JsonField.of("run_state"))

            @JvmField val RUN_STATE_RUN_TYPE = ShowEnumOrigins(JsonField.of("run_state,run_type"))

            @JvmField val RUN_TYPE = ShowEnumOrigins(JsonField.of("run_type"))

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            RUN_STATE,
            RUN_STATE_RUN_TYPE,
            RUN_TYPE,
        }

        enum class Value {
            RUN_STATE,
            RUN_STATE_RUN_TYPE,
            RUN_TYPE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                RUN_STATE -> Value.RUN_STATE
                RUN_STATE_RUN_TYPE -> Value.RUN_STATE_RUN_TYPE
                RUN_TYPE -> Value.RUN_TYPE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                RUN_STATE -> Known.RUN_STATE
                RUN_STATE_RUN_TYPE -> Known.RUN_STATE_RUN_TYPE
                RUN_TYPE -> Known.RUN_TYPE
                else -> throw MergeInvalidDataException("Unknown ShowEnumOrigins: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
