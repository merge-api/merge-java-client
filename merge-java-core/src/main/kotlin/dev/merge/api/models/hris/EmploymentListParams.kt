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

class EmploymentListParams
constructor(
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val employeeId: String?,
    private val expand: List<Expand>?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val orderBy: OrderBy?,
    private val pageSize: Long?,
    private val remoteFields: RemoteFields?,
    private val remoteId: String?,
    private val showEnumOrigins: ShowEnumOrigins?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun employeeId(): Optional<String> = Optional.ofNullable(employeeId)

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun orderBy(): Optional<OrderBy> = Optional.ofNullable(orderBy)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun remoteFields(): Optional<RemoteFields> = Optional.ofNullable(remoteFields)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    fun showEnumOrigins(): Optional<ShowEnumOrigins> = Optional.ofNullable(showEnumOrigins)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.employeeId?.let { params.put("employee_id", listOf(it.toString())) }
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.orderBy?.let { params.put("order_by", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.remoteFields?.let { params.put("remote_fields", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
        this.showEnumOrigins?.let { params.put("show_enum_origins", listOf(it.toString())) }
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

        return other is EmploymentListParams &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.employeeId == other.employeeId &&
            this.expand == other.expand &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.orderBy == other.orderBy &&
            this.pageSize == other.pageSize &&
            this.remoteFields == other.remoteFields &&
            this.remoteId == other.remoteId &&
            this.showEnumOrigins == other.showEnumOrigins &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            createdAfter,
            createdBefore,
            cursor,
            employeeId,
            expand,
            includeDeletedData,
            includeRemoteData,
            modifiedAfter,
            modifiedBefore,
            orderBy,
            pageSize,
            remoteFields,
            remoteId,
            showEnumOrigins,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "EmploymentListParams{createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, employeeId=$employeeId, expand=$expand, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, orderBy=$orderBy, pageSize=$pageSize, remoteFields=$remoteFields, remoteId=$remoteId, showEnumOrigins=$showEnumOrigins, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

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
        private var expand: List<Expand>? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var orderBy: OrderBy? = null
        private var pageSize: Long? = null
        private var remoteFields: RemoteFields? = null
        private var remoteId: String? = null
        private var showEnumOrigins: ShowEnumOrigins? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(employmentListParams: EmploymentListParams) = apply {
            this.createdAfter = employmentListParams.createdAfter
            this.createdBefore = employmentListParams.createdBefore
            this.cursor = employmentListParams.cursor
            this.employeeId = employmentListParams.employeeId
            this.expand = employmentListParams.expand
            this.includeDeletedData = employmentListParams.includeDeletedData
            this.includeRemoteData = employmentListParams.includeRemoteData
            this.modifiedAfter = employmentListParams.modifiedAfter
            this.modifiedBefore = employmentListParams.modifiedBefore
            this.orderBy = employmentListParams.orderBy
            this.pageSize = employmentListParams.pageSize
            this.remoteFields = employmentListParams.remoteFields
            this.remoteId = employmentListParams.remoteId
            this.showEnumOrigins = employmentListParams.showEnumOrigins
            additionalQueryParams(employmentListParams.additionalQueryParams)
            additionalHeaders(employmentListParams.additionalHeaders)
        }

        /** If provided, will only return objects created after this datetime. */
        fun createdAfter(createdAfter: OffsetDateTime) = apply { this.createdAfter = createdAfter }

        /** If provided, will only return objects created before this datetime. */
        fun createdBefore(createdBefore: OffsetDateTime) = apply {
            this.createdBefore = createdBefore
        }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

        /** If provided, will only return employments for this employee. */
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

        /** Overrides the default ordering for this endpoint. */
        fun orderBy(orderBy: OrderBy) = apply { this.orderBy = orderBy }

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

        fun build(): EmploymentListParams =
            EmploymentListParams(
                createdAfter,
                createdBefore,
                cursor,
                employeeId,
                expand?.toUnmodifiable(),
                includeDeletedData,
                includeRemoteData,
                modifiedAfter,
                modifiedBefore,
                orderBy,
                pageSize,
                remoteFields,
                remoteId,
                showEnumOrigins,
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

            @JvmField val PAY_GROUP = Expand(JsonField.of("pay_group"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            EMPLOYEE,
            PAY_GROUP,
        }

        enum class Value {
            EMPLOYEE,
            PAY_GROUP,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMPLOYEE -> Value.EMPLOYEE
                PAY_GROUP -> Value.PAY_GROUP
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMPLOYEE -> Known.EMPLOYEE
                PAY_GROUP -> Known.PAY_GROUP
                else -> throw MergeInvalidDataException("Unknown Expand: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class OrderBy
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OrderBy && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val EFFECTIVE_DATE_DESC = OrderBy(JsonField.of("-effective_date"))

            @JvmField val EFFECTIVE_DATE = OrderBy(JsonField.of("effective_date"))

            @JvmStatic fun of(value: String) = OrderBy(JsonField.of(value))
        }

        enum class Known {
            EFFECTIVE_DATE_DESC,
            EFFECTIVE_DATE,
        }

        enum class Value {
            EFFECTIVE_DATE_DESC,
            EFFECTIVE_DATE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EFFECTIVE_DATE_DESC -> Value.EFFECTIVE_DATE_DESC
                EFFECTIVE_DATE -> Value.EFFECTIVE_DATE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EFFECTIVE_DATE_DESC -> Known.EFFECTIVE_DATE_DESC
                EFFECTIVE_DATE -> Known.EFFECTIVE_DATE
                else -> throw MergeInvalidDataException("Unknown OrderBy: $value")
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

            @JvmField val EMPLOYMENT_TYPE = RemoteFields(JsonField.of("employment_type"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS =
                RemoteFields(JsonField.of("employment_type,flsa_status"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY =
                RemoteFields(JsonField.of("employment_type,flsa_status,pay_frequency"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD =
                RemoteFields(JsonField.of("employment_type,flsa_status,pay_frequency,pay_period"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD =
                RemoteFields(JsonField.of("employment_type,flsa_status,pay_period"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_FREQUENCY =
                RemoteFields(JsonField.of("employment_type,pay_frequency"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD =
                RemoteFields(JsonField.of("employment_type,pay_frequency,pay_period"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_PERIOD =
                RemoteFields(JsonField.of("employment_type,pay_period"))

            @JvmField val FLSA_STATUS = RemoteFields(JsonField.of("flsa_status"))

            @JvmField
            val FLSA_STATUS_PAY_FREQUENCY = RemoteFields(JsonField.of("flsa_status,pay_frequency"))

            @JvmField
            val FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD =
                RemoteFields(JsonField.of("flsa_status,pay_frequency,pay_period"))

            @JvmField
            val FLSA_STATUS_PAY_PERIOD = RemoteFields(JsonField.of("flsa_status,pay_period"))

            @JvmField val PAY_FREQUENCY = RemoteFields(JsonField.of("pay_frequency"))

            @JvmField
            val PAY_FREQUENCY_PAY_PERIOD = RemoteFields(JsonField.of("pay_frequency,pay_period"))

            @JvmField val PAY_PERIOD = RemoteFields(JsonField.of("pay_period"))

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            EMPLOYMENT_TYPE,
            EMPLOYMENT_TYPE_FLSA_STATUS,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_PERIOD,
            FLSA_STATUS,
            FLSA_STATUS_PAY_FREQUENCY,
            FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            FLSA_STATUS_PAY_PERIOD,
            PAY_FREQUENCY,
            PAY_FREQUENCY_PAY_PERIOD,
            PAY_PERIOD,
        }

        enum class Value {
            EMPLOYMENT_TYPE,
            EMPLOYMENT_TYPE_FLSA_STATUS,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_PERIOD,
            FLSA_STATUS,
            FLSA_STATUS_PAY_FREQUENCY,
            FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            FLSA_STATUS_PAY_PERIOD,
            PAY_FREQUENCY,
            PAY_FREQUENCY_PAY_PERIOD,
            PAY_PERIOD,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMPLOYMENT_TYPE -> Value.EMPLOYMENT_TYPE
                EMPLOYMENT_TYPE_FLSA_STATUS -> Value.EMPLOYMENT_TYPE_FLSA_STATUS
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_FREQUENCY -> Value.EMPLOYMENT_TYPE_PAY_FREQUENCY
                EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_PERIOD -> Value.EMPLOYMENT_TYPE_PAY_PERIOD
                FLSA_STATUS -> Value.FLSA_STATUS
                FLSA_STATUS_PAY_FREQUENCY -> Value.FLSA_STATUS_PAY_FREQUENCY
                FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD -> Value.FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                FLSA_STATUS_PAY_PERIOD -> Value.FLSA_STATUS_PAY_PERIOD
                PAY_FREQUENCY -> Value.PAY_FREQUENCY
                PAY_FREQUENCY_PAY_PERIOD -> Value.PAY_FREQUENCY_PAY_PERIOD
                PAY_PERIOD -> Value.PAY_PERIOD
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMPLOYMENT_TYPE -> Known.EMPLOYMENT_TYPE
                EMPLOYMENT_TYPE_FLSA_STATUS -> Known.EMPLOYMENT_TYPE_FLSA_STATUS
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_FREQUENCY -> Known.EMPLOYMENT_TYPE_PAY_FREQUENCY
                EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_PERIOD -> Known.EMPLOYMENT_TYPE_PAY_PERIOD
                FLSA_STATUS -> Known.FLSA_STATUS
                FLSA_STATUS_PAY_FREQUENCY -> Known.FLSA_STATUS_PAY_FREQUENCY
                FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD -> Known.FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                FLSA_STATUS_PAY_PERIOD -> Known.FLSA_STATUS_PAY_PERIOD
                PAY_FREQUENCY -> Known.PAY_FREQUENCY
                PAY_FREQUENCY_PAY_PERIOD -> Known.PAY_FREQUENCY_PAY_PERIOD
                PAY_PERIOD -> Known.PAY_PERIOD
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

            @JvmField val EMPLOYMENT_TYPE = ShowEnumOrigins(JsonField.of("employment_type"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS =
                ShowEnumOrigins(JsonField.of("employment_type,flsa_status"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY =
                ShowEnumOrigins(JsonField.of("employment_type,flsa_status,pay_frequency"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD =
                ShowEnumOrigins(
                    JsonField.of("employment_type,flsa_status,pay_frequency,pay_period")
                )

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD =
                ShowEnumOrigins(JsonField.of("employment_type,flsa_status,pay_period"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_FREQUENCY =
                ShowEnumOrigins(JsonField.of("employment_type,pay_frequency"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD =
                ShowEnumOrigins(JsonField.of("employment_type,pay_frequency,pay_period"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_PERIOD =
                ShowEnumOrigins(JsonField.of("employment_type,pay_period"))

            @JvmField val FLSA_STATUS = ShowEnumOrigins(JsonField.of("flsa_status"))

            @JvmField
            val FLSA_STATUS_PAY_FREQUENCY =
                ShowEnumOrigins(JsonField.of("flsa_status,pay_frequency"))

            @JvmField
            val FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD =
                ShowEnumOrigins(JsonField.of("flsa_status,pay_frequency,pay_period"))

            @JvmField
            val FLSA_STATUS_PAY_PERIOD = ShowEnumOrigins(JsonField.of("flsa_status,pay_period"))

            @JvmField val PAY_FREQUENCY = ShowEnumOrigins(JsonField.of("pay_frequency"))

            @JvmField
            val PAY_FREQUENCY_PAY_PERIOD = ShowEnumOrigins(JsonField.of("pay_frequency,pay_period"))

            @JvmField val PAY_PERIOD = ShowEnumOrigins(JsonField.of("pay_period"))

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            EMPLOYMENT_TYPE,
            EMPLOYMENT_TYPE_FLSA_STATUS,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_PERIOD,
            FLSA_STATUS,
            FLSA_STATUS_PAY_FREQUENCY,
            FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            FLSA_STATUS_PAY_PERIOD,
            PAY_FREQUENCY,
            PAY_FREQUENCY_PAY_PERIOD,
            PAY_PERIOD,
        }

        enum class Value {
            EMPLOYMENT_TYPE,
            EMPLOYMENT_TYPE_FLSA_STATUS,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_PERIOD,
            FLSA_STATUS,
            FLSA_STATUS_PAY_FREQUENCY,
            FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            FLSA_STATUS_PAY_PERIOD,
            PAY_FREQUENCY,
            PAY_FREQUENCY_PAY_PERIOD,
            PAY_PERIOD,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMPLOYMENT_TYPE -> Value.EMPLOYMENT_TYPE
                EMPLOYMENT_TYPE_FLSA_STATUS -> Value.EMPLOYMENT_TYPE_FLSA_STATUS
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_FREQUENCY -> Value.EMPLOYMENT_TYPE_PAY_FREQUENCY
                EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_PERIOD -> Value.EMPLOYMENT_TYPE_PAY_PERIOD
                FLSA_STATUS -> Value.FLSA_STATUS
                FLSA_STATUS_PAY_FREQUENCY -> Value.FLSA_STATUS_PAY_FREQUENCY
                FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD -> Value.FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                FLSA_STATUS_PAY_PERIOD -> Value.FLSA_STATUS_PAY_PERIOD
                PAY_FREQUENCY -> Value.PAY_FREQUENCY
                PAY_FREQUENCY_PAY_PERIOD -> Value.PAY_FREQUENCY_PAY_PERIOD
                PAY_PERIOD -> Value.PAY_PERIOD
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMPLOYMENT_TYPE -> Known.EMPLOYMENT_TYPE
                EMPLOYMENT_TYPE_FLSA_STATUS -> Known.EMPLOYMENT_TYPE_FLSA_STATUS
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_FREQUENCY -> Known.EMPLOYMENT_TYPE_PAY_FREQUENCY
                EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_PERIOD -> Known.EMPLOYMENT_TYPE_PAY_PERIOD
                FLSA_STATUS -> Known.FLSA_STATUS
                FLSA_STATUS_PAY_FREQUENCY -> Known.FLSA_STATUS_PAY_FREQUENCY
                FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD -> Known.FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                FLSA_STATUS_PAY_PERIOD -> Known.FLSA_STATUS_PAY_PERIOD
                PAY_FREQUENCY -> Known.PAY_FREQUENCY
                PAY_FREQUENCY_PAY_PERIOD -> Known.PAY_FREQUENCY_PAY_PERIOD
                PAY_PERIOD -> Known.PAY_PERIOD
                else -> throw MergeInvalidDataException("Unknown ShowEnumOrigins: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
