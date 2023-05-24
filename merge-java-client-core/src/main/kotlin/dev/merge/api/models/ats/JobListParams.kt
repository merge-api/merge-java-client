package dev.merge.api.models.ats

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

class JobListParams
constructor(
    private val code: String?,
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val expand: List<Expand>?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val offices: String?,
    private val pageSize: Long?,
    private val remoteFields: RemoteFields?,
    private val remoteId: String?,
    private val showEnumOrigins: ShowEnumOrigins?,
    private val status: Status?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun code(): Optional<String> = Optional.ofNullable(code)

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun offices(): Optional<String> = Optional.ofNullable(offices)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun remoteFields(): Optional<RemoteFields> = Optional.ofNullable(remoteFields)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    fun showEnumOrigins(): Optional<ShowEnumOrigins> = Optional.ofNullable(showEnumOrigins)

    fun status(): Optional<Status> = Optional.ofNullable(status)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.code?.let { params.put("code", listOf(it.toString())) }
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.offices?.let { params.put("offices", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.remoteFields?.let { params.put("remote_fields", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
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

        return other is JobListParams &&
            this.code == other.code &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.expand == other.expand &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.offices == other.offices &&
            this.pageSize == other.pageSize &&
            this.remoteFields == other.remoteFields &&
            this.remoteId == other.remoteId &&
            this.showEnumOrigins == other.showEnumOrigins &&
            this.status == other.status &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            code,
            createdAfter,
            createdBefore,
            cursor,
            expand,
            includeDeletedData,
            includeRemoteData,
            modifiedAfter,
            modifiedBefore,
            offices,
            pageSize,
            remoteFields,
            remoteId,
            showEnumOrigins,
            status,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "JobListParams{code=$code, createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, expand=$expand, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, offices=$offices, pageSize=$pageSize, remoteFields=$remoteFields, remoteId=$remoteId, showEnumOrigins=$showEnumOrigins, status=$status, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var code: String? = null
        private var createdAfter: OffsetDateTime? = null
        private var createdBefore: OffsetDateTime? = null
        private var cursor: String? = null
        private var expand: List<Expand>? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var offices: String? = null
        private var pageSize: Long? = null
        private var remoteFields: RemoteFields? = null
        private var remoteId: String? = null
        private var showEnumOrigins: ShowEnumOrigins? = null
        private var status: Status? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(jobListParams: JobListParams) = apply {
            this.code = jobListParams.code
            this.createdAfter = jobListParams.createdAfter
            this.createdBefore = jobListParams.createdBefore
            this.cursor = jobListParams.cursor
            this.expand = jobListParams.expand
            this.includeDeletedData = jobListParams.includeDeletedData
            this.includeRemoteData = jobListParams.includeRemoteData
            this.modifiedAfter = jobListParams.modifiedAfter
            this.modifiedBefore = jobListParams.modifiedBefore
            this.offices = jobListParams.offices
            this.pageSize = jobListParams.pageSize
            this.remoteFields = jobListParams.remoteFields
            this.remoteId = jobListParams.remoteId
            this.showEnumOrigins = jobListParams.showEnumOrigins
            this.status = jobListParams.status
            additionalQueryParams(jobListParams.additionalQueryParams)
            additionalHeaders(jobListParams.additionalHeaders)
        }

        /** If provided, will only return jobs with this code. */
        fun code(code: String) = apply { this.code = code }

        /** If provided, will only return objects created after this datetime. */
        fun createdAfter(createdAfter: OffsetDateTime) = apply { this.createdAfter = createdAfter }

        /** If provided, will only return objects created before this datetime. */
        fun createdBefore(createdBefore: OffsetDateTime) = apply {
            this.createdBefore = createdBefore
        }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

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

        /**
         * If provided, will only return jobs for this office; multiple offices can be separated by
         * commas.
         */
        fun offices(offices: String) = apply { this.offices = offices }

        /** Number of results to return per page. */
        fun pageSize(pageSize: Long) = apply { this.pageSize = pageSize }

        /** Deprecated. Use show_enum_origins. */
        fun remoteFields(remoteFields: RemoteFields) = apply { this.remoteFields = remoteFields }

        /** The API provider's ID for the given object. */
        fun remoteId(remoteId: String) = apply { this.remoteId = remoteId }

        /** Which fields should be returned in non-normalized form. */
        fun showEnumOrigins(showEnumOrigins: ShowEnumOrigins) = apply {
            this.showEnumOrigins = showEnumOrigins
        }

        /**
         * If provided, will only return jobs with this status. Options: ('OPEN', 'CLOSED', 'DRAFT',
         * 'ARCHIVED', 'PENDING')
         *
         * - `OPEN` - OPEN
         * - `CLOSED` - CLOSED
         * - `DRAFT` - DRAFT
         * - `ARCHIVED` - ARCHIVED
         * - `PENDING` - PENDING
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

        fun build(): JobListParams =
            JobListParams(
                code,
                createdAfter,
                createdBefore,
                cursor,
                expand?.toUnmodifiable(),
                includeDeletedData,
                includeRemoteData,
                modifiedAfter,
                modifiedBefore,
                offices,
                pageSize,
                remoteFields,
                remoteId,
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

            @JvmField val DEPARTMENTS = Expand(JsonField.of("departments"))

            @JvmField val HIRING_MANAGERS = Expand(JsonField.of("hiring_managers"))

            @JvmField val OFFICES = Expand(JsonField.of("offices"))

            @JvmField val RECRUITERS = Expand(JsonField.of("recruiters"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            DEPARTMENTS,
            HIRING_MANAGERS,
            OFFICES,
            RECRUITERS,
        }

        enum class Value {
            DEPARTMENTS,
            HIRING_MANAGERS,
            OFFICES,
            RECRUITERS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                DEPARTMENTS -> Value.DEPARTMENTS
                HIRING_MANAGERS -> Value.HIRING_MANAGERS
                OFFICES -> Value.OFFICES
                RECRUITERS -> Value.RECRUITERS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                DEPARTMENTS -> Known.DEPARTMENTS
                HIRING_MANAGERS -> Known.HIRING_MANAGERS
                OFFICES -> Known.OFFICES
                RECRUITERS -> Known.RECRUITERS
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

            @JvmField val STATUS = RemoteFields(JsonField.of("status"))

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            STATUS,
        }

        enum class Value {
            STATUS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STATUS -> Value.STATUS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STATUS -> Known.STATUS
                else -> throw MergeInvalidDataException("Unknown RemoteFields: $value")
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

            @JvmField val STATUS = ShowEnumOrigins(JsonField.of("status"))

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            STATUS,
        }

        enum class Value {
            STATUS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STATUS -> Value.STATUS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STATUS -> Known.STATUS
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

            @JvmField val ARCHIVED = Status(JsonField.of("ARCHIVED"))

            @JvmField val CLOSED = Status(JsonField.of("CLOSED"))

            @JvmField val DRAFT = Status(JsonField.of("DRAFT"))

            @JvmField val OPEN = Status(JsonField.of("OPEN"))

            @JvmField val PENDING = Status(JsonField.of("PENDING"))

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            ARCHIVED,
            CLOSED,
            DRAFT,
            OPEN,
            PENDING,
        }

        enum class Value {
            ARCHIVED,
            CLOSED,
            DRAFT,
            OPEN,
            PENDING,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ARCHIVED -> Value.ARCHIVED
                CLOSED -> Value.CLOSED
                DRAFT -> Value.DRAFT
                OPEN -> Value.OPEN
                PENDING -> Value.PENDING
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ARCHIVED -> Known.ARCHIVED
                CLOSED -> Known.CLOSED
                DRAFT -> Known.DRAFT
                OPEN -> Known.OPEN
                PENDING -> Known.PENDING
                else -> throw MergeInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
