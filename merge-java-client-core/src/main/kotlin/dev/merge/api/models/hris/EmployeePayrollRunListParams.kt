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

class EmployeePayrollRunListParams
constructor(
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val employeeId: String?,
    private val endedAfter: OffsetDateTime?,
    private val endedBefore: OffsetDateTime?,
    private val expand: List<Expand>?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val pageSize: Long?,
    private val payrollRunId: String?,
    private val remoteId: String?,
    private val startedAfter: OffsetDateTime?,
    private val startedBefore: OffsetDateTime?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun employeeId(): Optional<String> = Optional.ofNullable(employeeId)

    fun endedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(endedAfter)

    fun endedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(endedBefore)

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun payrollRunId(): Optional<String> = Optional.ofNullable(payrollRunId)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    fun startedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(startedAfter)

    fun startedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(startedBefore)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.employeeId?.let { params.put("employee_id", listOf(it.toString())) }
        this.endedAfter?.let { params.put("ended_after", listOf(it.toString())) }
        this.endedBefore?.let { params.put("ended_before", listOf(it.toString())) }
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.payrollRunId?.let { params.put("payroll_run_id", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
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

        return other is EmployeePayrollRunListParams &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.employeeId == other.employeeId &&
            this.endedAfter == other.endedAfter &&
            this.endedBefore == other.endedBefore &&
            this.expand == other.expand &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.pageSize == other.pageSize &&
            this.payrollRunId == other.payrollRunId &&
            this.remoteId == other.remoteId &&
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
            employeeId,
            endedAfter,
            endedBefore,
            expand,
            includeDeletedData,
            includeRemoteData,
            modifiedAfter,
            modifiedBefore,
            pageSize,
            payrollRunId,
            remoteId,
            startedAfter,
            startedBefore,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "EmployeePayrollRunListParams{createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, employeeId=$employeeId, endedAfter=$endedAfter, endedBefore=$endedBefore, expand=$expand, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, pageSize=$pageSize, payrollRunId=$payrollRunId, remoteId=$remoteId, startedAfter=$startedAfter, startedBefore=$startedBefore, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var createdAfter: OffsetDateTime? = null
        private var createdBefore: OffsetDateTime? = null
        private var cursor: String? = null
        private var employeeId: String? = null
        private var endedAfter: OffsetDateTime? = null
        private var endedBefore: OffsetDateTime? = null
        private var expand: List<Expand>? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var pageSize: Long? = null
        private var payrollRunId: String? = null
        private var remoteId: String? = null
        private var startedAfter: OffsetDateTime? = null
        private var startedBefore: OffsetDateTime? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(employeePayrollRunListParams: EmployeePayrollRunListParams) = apply {
            this.createdAfter = employeePayrollRunListParams.createdAfter
            this.createdBefore = employeePayrollRunListParams.createdBefore
            this.cursor = employeePayrollRunListParams.cursor
            this.employeeId = employeePayrollRunListParams.employeeId
            this.endedAfter = employeePayrollRunListParams.endedAfter
            this.endedBefore = employeePayrollRunListParams.endedBefore
            this.expand = employeePayrollRunListParams.expand
            this.includeDeletedData = employeePayrollRunListParams.includeDeletedData
            this.includeRemoteData = employeePayrollRunListParams.includeRemoteData
            this.modifiedAfter = employeePayrollRunListParams.modifiedAfter
            this.modifiedBefore = employeePayrollRunListParams.modifiedBefore
            this.pageSize = employeePayrollRunListParams.pageSize
            this.payrollRunId = employeePayrollRunListParams.payrollRunId
            this.remoteId = employeePayrollRunListParams.remoteId
            this.startedAfter = employeePayrollRunListParams.startedAfter
            this.startedBefore = employeePayrollRunListParams.startedBefore
            additionalQueryParams(employeePayrollRunListParams.additionalQueryParams)
            additionalHeaders(employeePayrollRunListParams.additionalHeaders)
        }

        /** If provided, will only return objects created after this datetime. */
        fun createdAfter(createdAfter: OffsetDateTime) = apply { this.createdAfter = createdAfter }

        /** If provided, will only return objects created before this datetime. */
        fun createdBefore(createdBefore: OffsetDateTime) = apply {
            this.createdBefore = createdBefore
        }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

        /** If provided, will only return employee payroll runs for this employee. */
        fun employeeId(employeeId: String) = apply { this.employeeId = employeeId }

        /** If provided, will only return employee payroll runs ended after this datetime. */
        fun endedAfter(endedAfter: OffsetDateTime) = apply { this.endedAfter = endedAfter }

        /** If provided, will only return employee payroll runs ended before this datetime. */
        fun endedBefore(endedBefore: OffsetDateTime) = apply { this.endedBefore = endedBefore }

        /**
         * Which relations should be returned in expanded form. Multiple relation names should be
         * comma separated without spaces.
         */
        fun expand(expand: List<Expand>) = apply { this.expand = expand }

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

        /** If provided, will only return employee payroll runs for this employee. */
        fun payrollRunId(payrollRunId: String) = apply { this.payrollRunId = payrollRunId }

        /** The API provider's ID for the given object. */
        fun remoteId(remoteId: String) = apply { this.remoteId = remoteId }

        /** If provided, will only return employee payroll runs started after this datetime. */
        fun startedAfter(startedAfter: OffsetDateTime) = apply { this.startedAfter = startedAfter }

        /** If provided, will only return employee payroll runs started before this datetime. */
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

        fun build(): EmployeePayrollRunListParams =
            EmployeePayrollRunListParams(
                createdAfter,
                createdBefore,
                cursor,
                employeeId,
                endedAfter,
                endedBefore,
                expand?.toUnmodifiable(),
                includeDeletedData,
                includeRemoteData,
                modifiedAfter,
                modifiedBefore,
                pageSize,
                payrollRunId,
                remoteId,
                startedAfter,
                startedBefore,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }

    class Expand
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Expand && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val EMPLOYEE = Expand(JsonField.of("employee"))

            @JvmField val PAYROLL_RUN = Expand(JsonField.of("payroll_run"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            EMPLOYEE,
            PAYROLL_RUN,
        }

        enum class Value {
            EMPLOYEE,
            PAYROLL_RUN,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMPLOYEE -> Value.EMPLOYEE
                PAYROLL_RUN -> Value.PAYROLL_RUN
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMPLOYEE -> Known.EMPLOYEE
                PAYROLL_RUN -> Known.PAYROLL_RUN
                else -> throw MergeInvalidDataException("Unknown Expand: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
