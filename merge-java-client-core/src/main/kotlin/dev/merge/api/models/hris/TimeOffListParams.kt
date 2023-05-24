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

class TimeOffListParams
constructor(
    private val approverId: String?,
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val employeeId: String?,
    private val expand: List<Expand>?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val pageSize: Long?,
    private val remoteFields: RemoteFields?,
    private val remoteId: String?,
    private val requestType: RequestType?,
    private val showEnumOrigins: ShowEnumOrigins?,
    private val status: Status?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun approverId(): Optional<String> = Optional.ofNullable(approverId)

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun employeeId(): Optional<String> = Optional.ofNullable(employeeId)

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun remoteFields(): Optional<RemoteFields> = Optional.ofNullable(remoteFields)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    fun requestType(): Optional<RequestType> = Optional.ofNullable(requestType)

    fun showEnumOrigins(): Optional<ShowEnumOrigins> = Optional.ofNullable(showEnumOrigins)

    fun status(): Optional<Status> = Optional.ofNullable(status)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.approverId?.let { params.put("approver_id", listOf(it.toString())) }
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.employeeId?.let { params.put("employee_id", listOf(it.toString())) }
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.remoteFields?.let { params.put("remote_fields", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
        this.requestType?.let { params.put("request_type", listOf(it.toString())) }
        this.showEnumOrigins?.let { params.put("show_enum_origins", listOf(it.toString())) }
        this.status?.let { params.put("status", listOf(it.toString())) }
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

        return other is TimeOffListParams &&
            this.approverId == other.approverId &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.employeeId == other.employeeId &&
            this.expand == other.expand &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.pageSize == other.pageSize &&
            this.remoteFields == other.remoteFields &&
            this.remoteId == other.remoteId &&
            this.requestType == other.requestType &&
            this.showEnumOrigins == other.showEnumOrigins &&
            this.status == other.status &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            approverId,
            createdAfter,
            createdBefore,
            cursor,
            employeeId,
            expand,
            includeDeletedData,
            includeRemoteData,
            modifiedAfter,
            modifiedBefore,
            pageSize,
            remoteFields,
            remoteId,
            requestType,
            showEnumOrigins,
            status,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "TimeOffListParams{approverId=$approverId, createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, employeeId=$employeeId, expand=$expand, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, pageSize=$pageSize, remoteFields=$remoteFields, remoteId=$remoteId, requestType=$requestType, showEnumOrigins=$showEnumOrigins, status=$status, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var approverId: String? = null
        private var createdAfter: OffsetDateTime? = null
        private var createdBefore: OffsetDateTime? = null
        private var cursor: String? = null
        private var employeeId: String? = null
        private var expand: List<Expand>? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var pageSize: Long? = null
        private var remoteFields: RemoteFields? = null
        private var remoteId: String? = null
        private var requestType: RequestType? = null
        private var showEnumOrigins: ShowEnumOrigins? = null
        private var status: Status? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(timeOffListParams: TimeOffListParams) = apply {
            this.approverId = timeOffListParams.approverId
            this.createdAfter = timeOffListParams.createdAfter
            this.createdBefore = timeOffListParams.createdBefore
            this.cursor = timeOffListParams.cursor
            this.employeeId = timeOffListParams.employeeId
            this.expand = timeOffListParams.expand
            this.includeDeletedData = timeOffListParams.includeDeletedData
            this.includeRemoteData = timeOffListParams.includeRemoteData
            this.modifiedAfter = timeOffListParams.modifiedAfter
            this.modifiedBefore = timeOffListParams.modifiedBefore
            this.pageSize = timeOffListParams.pageSize
            this.remoteFields = timeOffListParams.remoteFields
            this.remoteId = timeOffListParams.remoteId
            this.requestType = timeOffListParams.requestType
            this.showEnumOrigins = timeOffListParams.showEnumOrigins
            this.status = timeOffListParams.status
            additionalQueryParams(timeOffListParams.additionalQueryParams)
            additionalHeaders(timeOffListParams.additionalHeaders)
        }

        /** If provided, will only return time off for this approver. */
        fun approverId(approverId: String) = apply { this.approverId = approverId }

        /** If provided, will only return objects created after this datetime. */
        fun createdAfter(createdAfter: OffsetDateTime) = apply { this.createdAfter = createdAfter }

        /** If provided, will only return objects created before this datetime. */
        fun createdBefore(createdBefore: OffsetDateTime) = apply {
            this.createdBefore = createdBefore
        }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

        /** If provided, will only return time off for this employee. */
        fun employeeId(employeeId: String) = apply { this.employeeId = employeeId }

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

        /** Deprecated. Use show_enum_origins. */
        fun remoteFields(remoteFields: RemoteFields) = apply { this.remoteFields = remoteFields }

        /** The API provider's ID for the given object. */
        fun remoteId(remoteId: String) = apply { this.remoteId = remoteId }

        /**
         * If provided, will only return TimeOff with this request type. Options: ('VACATION',
         * 'SICK', 'PERSONAL', 'JURY_DUTY', 'VOLUNTEER', 'BEREAVEMENT')
         *
         * - `VACATION` - VACATION
         * - `SICK` - SICK
         * - `PERSONAL` - PERSONAL
         * - `JURY_DUTY` - JURY_DUTY
         * - `VOLUNTEER` - VOLUNTEER
         * - `BEREAVEMENT` - BEREAVEMENT
         */
        fun requestType(requestType: RequestType) = apply { this.requestType = requestType }

        /** Which fields should be returned in non-normalized form. */
        fun showEnumOrigins(showEnumOrigins: ShowEnumOrigins) = apply {
            this.showEnumOrigins = showEnumOrigins
        }

        /**
         * If provided, will only return TimeOff with this status. Options: ('REQUESTED',
         * 'APPROVED', 'DECLINED', 'CANCELLED', 'DELETED')
         *
         * - `REQUESTED` - REQUESTED
         * - `APPROVED` - APPROVED
         * - `DECLINED` - DECLINED
         * - `CANCELLED` - CANCELLED
         * - `DELETED` - DELETED
         */
        fun status(status: Status) = apply { this.status = status }

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

        fun build(): TimeOffListParams =
            TimeOffListParams(
                approverId,
                createdAfter,
                createdBefore,
                cursor,
                employeeId,
                expand?.toUnmodifiable(),
                includeDeletedData,
                includeRemoteData,
                modifiedAfter,
                modifiedBefore,
                pageSize,
                remoteFields,
                remoteId,
                requestType,
                showEnumOrigins,
                status,
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

            @JvmField val APPROVER = Expand(JsonField.of("approver"))

            @JvmField val EMPLOYEE = Expand(JsonField.of("employee"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            APPROVER,
            EMPLOYEE,
        }

        enum class Value {
            APPROVER,
            EMPLOYEE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                APPROVER -> Value.APPROVER
                EMPLOYEE -> Value.EMPLOYEE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                APPROVER -> Known.APPROVER
                EMPLOYEE -> Known.EMPLOYEE
                else -> throw MergeInvalidDataException("Unknown Expand: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
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

            @JvmField val REQUEST_TYPE = RemoteFields(JsonField.of("request_type"))

            @JvmField val REQUEST_TYPE_STATUS = RemoteFields(JsonField.of("request_type,status"))

            @JvmField
            val REQUEST_TYPE_STATUS_UNITS = RemoteFields(JsonField.of("request_type,status,units"))

            @JvmField val REQUEST_TYPE_UNITS = RemoteFields(JsonField.of("request_type,units"))

            @JvmField val STATUS = RemoteFields(JsonField.of("status"))

            @JvmField val STATUS_UNITS = RemoteFields(JsonField.of("status,units"))

            @JvmField val UNITS = RemoteFields(JsonField.of("units"))

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            REQUEST_TYPE,
            REQUEST_TYPE_STATUS,
            REQUEST_TYPE_STATUS_UNITS,
            REQUEST_TYPE_UNITS,
            STATUS,
            STATUS_UNITS,
            UNITS,
        }

        enum class Value {
            REQUEST_TYPE,
            REQUEST_TYPE_STATUS,
            REQUEST_TYPE_STATUS_UNITS,
            REQUEST_TYPE_UNITS,
            STATUS,
            STATUS_UNITS,
            UNITS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                REQUEST_TYPE -> Value.REQUEST_TYPE
                REQUEST_TYPE_STATUS -> Value.REQUEST_TYPE_STATUS
                REQUEST_TYPE_STATUS_UNITS -> Value.REQUEST_TYPE_STATUS_UNITS
                REQUEST_TYPE_UNITS -> Value.REQUEST_TYPE_UNITS
                STATUS -> Value.STATUS
                STATUS_UNITS -> Value.STATUS_UNITS
                UNITS -> Value.UNITS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                REQUEST_TYPE -> Known.REQUEST_TYPE
                REQUEST_TYPE_STATUS -> Known.REQUEST_TYPE_STATUS
                REQUEST_TYPE_STATUS_UNITS -> Known.REQUEST_TYPE_STATUS_UNITS
                REQUEST_TYPE_UNITS -> Known.REQUEST_TYPE_UNITS
                STATUS -> Known.STATUS
                STATUS_UNITS -> Known.STATUS_UNITS
                UNITS -> Known.UNITS
                else -> throw MergeInvalidDataException("Unknown RemoteFields: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class RequestType
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RequestType && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val BEREAVEMENT = RequestType(JsonField.of("BEREAVEMENT"))

            @JvmField val JURY_DUTY = RequestType(JsonField.of("JURY_DUTY"))

            @JvmField val PERSONAL = RequestType(JsonField.of("PERSONAL"))

            @JvmField val SICK = RequestType(JsonField.of("SICK"))

            @JvmField val VACATION = RequestType(JsonField.of("VACATION"))

            @JvmField val VOLUNTEER = RequestType(JsonField.of("VOLUNTEER"))

            @JvmStatic fun of(value: String) = RequestType(JsonField.of(value))
        }

        enum class Known {
            BEREAVEMENT,
            JURY_DUTY,
            PERSONAL,
            SICK,
            VACATION,
            VOLUNTEER,
        }

        enum class Value {
            BEREAVEMENT,
            JURY_DUTY,
            PERSONAL,
            SICK,
            VACATION,
            VOLUNTEER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                BEREAVEMENT -> Value.BEREAVEMENT
                JURY_DUTY -> Value.JURY_DUTY
                PERSONAL -> Value.PERSONAL
                SICK -> Value.SICK
                VACATION -> Value.VACATION
                VOLUNTEER -> Value.VOLUNTEER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                BEREAVEMENT -> Known.BEREAVEMENT
                JURY_DUTY -> Known.JURY_DUTY
                PERSONAL -> Known.PERSONAL
                SICK -> Known.SICK
                VACATION -> Known.VACATION
                VOLUNTEER -> Known.VOLUNTEER
                else -> throw MergeInvalidDataException("Unknown RequestType: $value")
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

            @JvmField val REQUEST_TYPE = ShowEnumOrigins(JsonField.of("request_type"))

            @JvmField val REQUEST_TYPE_STATUS = ShowEnumOrigins(JsonField.of("request_type,status"))

            @JvmField
            val REQUEST_TYPE_STATUS_UNITS =
                ShowEnumOrigins(JsonField.of("request_type,status,units"))

            @JvmField val REQUEST_TYPE_UNITS = ShowEnumOrigins(JsonField.of("request_type,units"))

            @JvmField val STATUS = ShowEnumOrigins(JsonField.of("status"))

            @JvmField val STATUS_UNITS = ShowEnumOrigins(JsonField.of("status,units"))

            @JvmField val UNITS = ShowEnumOrigins(JsonField.of("units"))

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            REQUEST_TYPE,
            REQUEST_TYPE_STATUS,
            REQUEST_TYPE_STATUS_UNITS,
            REQUEST_TYPE_UNITS,
            STATUS,
            STATUS_UNITS,
            UNITS,
        }

        enum class Value {
            REQUEST_TYPE,
            REQUEST_TYPE_STATUS,
            REQUEST_TYPE_STATUS_UNITS,
            REQUEST_TYPE_UNITS,
            STATUS,
            STATUS_UNITS,
            UNITS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                REQUEST_TYPE -> Value.REQUEST_TYPE
                REQUEST_TYPE_STATUS -> Value.REQUEST_TYPE_STATUS
                REQUEST_TYPE_STATUS_UNITS -> Value.REQUEST_TYPE_STATUS_UNITS
                REQUEST_TYPE_UNITS -> Value.REQUEST_TYPE_UNITS
                STATUS -> Value.STATUS
                STATUS_UNITS -> Value.STATUS_UNITS
                UNITS -> Value.UNITS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                REQUEST_TYPE -> Known.REQUEST_TYPE
                REQUEST_TYPE_STATUS -> Known.REQUEST_TYPE_STATUS
                REQUEST_TYPE_STATUS_UNITS -> Known.REQUEST_TYPE_STATUS_UNITS
                REQUEST_TYPE_UNITS -> Known.REQUEST_TYPE_UNITS
                STATUS -> Known.STATUS
                STATUS_UNITS -> Known.STATUS_UNITS
                UNITS -> Known.UNITS
                else -> throw MergeInvalidDataException("Unknown ShowEnumOrigins: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val APPROVED = Status(JsonField.of("APPROVED"))

            @JvmField val CANCELLED = Status(JsonField.of("CANCELLED"))

            @JvmField val DECLINED = Status(JsonField.of("DECLINED"))

            @JvmField val DELETED = Status(JsonField.of("DELETED"))

            @JvmField val REQUESTED = Status(JsonField.of("REQUESTED"))

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            APPROVED,
            CANCELLED,
            DECLINED,
            DELETED,
            REQUESTED,
        }

        enum class Value {
            APPROVED,
            CANCELLED,
            DECLINED,
            DELETED,
            REQUESTED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                APPROVED -> Value.APPROVED
                CANCELLED -> Value.CANCELLED
                DECLINED -> Value.DECLINED
                DELETED -> Value.DELETED
                REQUESTED -> Value.REQUESTED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                APPROVED -> Known.APPROVED
                CANCELLED -> Known.CANCELLED
                DECLINED -> Known.DECLINED
                DELETED -> Known.DELETED
                REQUESTED -> Known.REQUESTED
                else -> throw MergeInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
