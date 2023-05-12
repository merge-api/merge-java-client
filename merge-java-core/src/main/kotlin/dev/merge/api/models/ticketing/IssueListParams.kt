package dev.merge.api.models.ticketing

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

class IssueListParams
constructor(
    private val accountToken: String?,
    private val cursor: String?,
    private val endDate: String?,
    private val endUserOrganizationName: String?,
    private val firstIncidentTimeAfter: OffsetDateTime?,
    private val firstIncidentTimeBefore: OffsetDateTime?,
    private val includeMuted: String?,
    private val integrationName: String?,
    private val lastIncidentTimeAfter: OffsetDateTime?,
    private val lastIncidentTimeBefore: OffsetDateTime?,
    private val pageSize: Long?,
    private val startDate: String?,
    private val status: Status?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun accountToken(): Optional<String> = Optional.ofNullable(accountToken)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun endDate(): Optional<String> = Optional.ofNullable(endDate)

    fun endUserOrganizationName(): Optional<String> = Optional.ofNullable(endUserOrganizationName)

    fun firstIncidentTimeAfter(): Optional<OffsetDateTime> =
        Optional.ofNullable(firstIncidentTimeAfter)

    fun firstIncidentTimeBefore(): Optional<OffsetDateTime> =
        Optional.ofNullable(firstIncidentTimeBefore)

    fun includeMuted(): Optional<String> = Optional.ofNullable(includeMuted)

    fun integrationName(): Optional<String> = Optional.ofNullable(integrationName)

    fun lastIncidentTimeAfter(): Optional<OffsetDateTime> =
        Optional.ofNullable(lastIncidentTimeAfter)

    fun lastIncidentTimeBefore(): Optional<OffsetDateTime> =
        Optional.ofNullable(lastIncidentTimeBefore)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun startDate(): Optional<String> = Optional.ofNullable(startDate)

    fun status(): Optional<Status> = Optional.ofNullable(status)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.accountToken?.let { params.put("account_token", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.endDate?.let { params.put("end_date", listOf(it.toString())) }
        this.endUserOrganizationName?.let {
            params.put("end_user_organization_name", listOf(it.toString()))
        }
        this.firstIncidentTimeAfter?.let {
            params.put("first_incident_time_after", listOf(it.toString()))
        }
        this.firstIncidentTimeBefore?.let {
            params.put("first_incident_time_before", listOf(it.toString()))
        }
        this.includeMuted?.let { params.put("include_muted", listOf(it.toString())) }
        this.integrationName?.let { params.put("integration_name", listOf(it.toString())) }
        this.lastIncidentTimeAfter?.let {
            params.put("last_incident_time_after", listOf(it.toString()))
        }
        this.lastIncidentTimeBefore?.let {
            params.put("last_incident_time_before", listOf(it.toString()))
        }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.startDate?.let { params.put("start_date", listOf(it.toString())) }
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

        return other is IssueListParams &&
            this.accountToken == other.accountToken &&
            this.cursor == other.cursor &&
            this.endDate == other.endDate &&
            this.endUserOrganizationName == other.endUserOrganizationName &&
            this.firstIncidentTimeAfter == other.firstIncidentTimeAfter &&
            this.firstIncidentTimeBefore == other.firstIncidentTimeBefore &&
            this.includeMuted == other.includeMuted &&
            this.integrationName == other.integrationName &&
            this.lastIncidentTimeAfter == other.lastIncidentTimeAfter &&
            this.lastIncidentTimeBefore == other.lastIncidentTimeBefore &&
            this.pageSize == other.pageSize &&
            this.startDate == other.startDate &&
            this.status == other.status &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            accountToken,
            cursor,
            endDate,
            endUserOrganizationName,
            firstIncidentTimeAfter,
            firstIncidentTimeBefore,
            includeMuted,
            integrationName,
            lastIncidentTimeAfter,
            lastIncidentTimeBefore,
            pageSize,
            startDate,
            status,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "IssueListParams{accountToken=$accountToken, cursor=$cursor, endDate=$endDate, endUserOrganizationName=$endUserOrganizationName, firstIncidentTimeAfter=$firstIncidentTimeAfter, firstIncidentTimeBefore=$firstIncidentTimeBefore, includeMuted=$includeMuted, integrationName=$integrationName, lastIncidentTimeAfter=$lastIncidentTimeAfter, lastIncidentTimeBefore=$lastIncidentTimeBefore, pageSize=$pageSize, startDate=$startDate, status=$status, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var accountToken: String? = null
        private var cursor: String? = null
        private var endDate: String? = null
        private var endUserOrganizationName: String? = null
        private var firstIncidentTimeAfter: OffsetDateTime? = null
        private var firstIncidentTimeBefore: OffsetDateTime? = null
        private var includeMuted: String? = null
        private var integrationName: String? = null
        private var lastIncidentTimeAfter: OffsetDateTime? = null
        private var lastIncidentTimeBefore: OffsetDateTime? = null
        private var pageSize: Long? = null
        private var startDate: String? = null
        private var status: Status? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(issueListParams: IssueListParams) = apply {
            this.accountToken = issueListParams.accountToken
            this.cursor = issueListParams.cursor
            this.endDate = issueListParams.endDate
            this.endUserOrganizationName = issueListParams.endUserOrganizationName
            this.firstIncidentTimeAfter = issueListParams.firstIncidentTimeAfter
            this.firstIncidentTimeBefore = issueListParams.firstIncidentTimeBefore
            this.includeMuted = issueListParams.includeMuted
            this.integrationName = issueListParams.integrationName
            this.lastIncidentTimeAfter = issueListParams.lastIncidentTimeAfter
            this.lastIncidentTimeBefore = issueListParams.lastIncidentTimeBefore
            this.pageSize = issueListParams.pageSize
            this.startDate = issueListParams.startDate
            this.status = issueListParams.status
            additionalQueryParams(issueListParams.additionalQueryParams)
            additionalHeaders(issueListParams.additionalHeaders)
        }

        fun accountToken(accountToken: String) = apply { this.accountToken = accountToken }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

        /**
         * If included, will only include issues whose most recent action occurred before this time
         */
        fun endDate(endDate: String) = apply { this.endDate = endDate }

        fun endUserOrganizationName(endUserOrganizationName: String) = apply {
            this.endUserOrganizationName = endUserOrganizationName
        }

        /**
         * If provided, will only return issues whose first incident time was after this datetime.
         */
        fun firstIncidentTimeAfter(firstIncidentTimeAfter: OffsetDateTime) = apply {
            this.firstIncidentTimeAfter = firstIncidentTimeAfter
        }

        /**
         * If provided, will only return issues whose first incident time was before this datetime.
         */
        fun firstIncidentTimeBefore(firstIncidentTimeBefore: OffsetDateTime) = apply {
            this.firstIncidentTimeBefore = firstIncidentTimeBefore
        }

        /** If True, will include muted issues */
        fun includeMuted(includeMuted: String) = apply { this.includeMuted = includeMuted }

        fun integrationName(integrationName: String) = apply {
            this.integrationName = integrationName
        }

        /**
         * If provided, will only return issues whose first incident time was after this datetime.
         */
        fun lastIncidentTimeAfter(lastIncidentTimeAfter: OffsetDateTime) = apply {
            this.lastIncidentTimeAfter = lastIncidentTimeAfter
        }

        /**
         * If provided, will only return issues whose first incident time was before this datetime.
         */
        fun lastIncidentTimeBefore(lastIncidentTimeBefore: OffsetDateTime) = apply {
            this.lastIncidentTimeBefore = lastIncidentTimeBefore
        }

        /** Number of results to return per page. */
        fun pageSize(pageSize: Long) = apply { this.pageSize = pageSize }

        /**
         * If included, will only include issues whose most recent action occurred after this time
         */
        fun startDate(startDate: String) = apply { this.startDate = startDate }

        /**
         * - `ONGOING` - ONGOING
         * - `RESOLVED` - RESOLVED
         *
         * - `ONGOING` - ONGOING
         * - `RESOLVED` - RESOLVED
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

        fun build(): IssueListParams =
            IssueListParams(
                accountToken,
                cursor,
                endDate,
                endUserOrganizationName,
                firstIncidentTimeAfter,
                firstIncidentTimeBefore,
                includeMuted,
                integrationName,
                lastIncidentTimeAfter,
                lastIncidentTimeBefore,
                pageSize,
                startDate,
                status,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
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

            @JvmField val ONGOING = Status(JsonField.of("ONGOING"))

            @JvmField val RESOLVED = Status(JsonField.of("RESOLVED"))

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            ONGOING,
            RESOLVED,
        }

        enum class Value {
            ONGOING,
            RESOLVED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ONGOING -> Value.ONGOING
                RESOLVED -> Value.RESOLVED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ONGOING -> Known.ONGOING
                RESOLVED -> Known.RESOLVED
                else -> throw MergeInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
