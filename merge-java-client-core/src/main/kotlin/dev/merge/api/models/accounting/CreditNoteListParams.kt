package dev.merge.api.models.accounting

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

class CreditNoteListParams
constructor(
    private val companyId: String?,
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val expand: List<Expand>?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val pageSize: Long?,
    private val remoteFields: RemoteFields?,
    private val remoteId: String?,
    private val showEnumOrigins: ShowEnumOrigins?,
    private val transactionDateAfter: OffsetDateTime?,
    private val transactionDateBefore: OffsetDateTime?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun companyId(): Optional<String> = Optional.ofNullable(companyId)

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun remoteFields(): Optional<RemoteFields> = Optional.ofNullable(remoteFields)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    fun showEnumOrigins(): Optional<ShowEnumOrigins> = Optional.ofNullable(showEnumOrigins)

    fun transactionDateAfter(): Optional<OffsetDateTime> = Optional.ofNullable(transactionDateAfter)

    fun transactionDateBefore(): Optional<OffsetDateTime> =
        Optional.ofNullable(transactionDateBefore)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.companyId?.let { params.put("company_id", listOf(it.toString())) }
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.remoteFields?.let { params.put("remote_fields", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
        this.showEnumOrigins?.let { params.put("show_enum_origins", listOf(it.toString())) }
        this.transactionDateAfter?.let {
            params.put("transaction_date_after", listOf(it.toString()))
        }
        this.transactionDateBefore?.let {
            params.put("transaction_date_before", listOf(it.toString()))
        }
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

        return other is CreditNoteListParams &&
            this.companyId == other.companyId &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.expand == other.expand &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.pageSize == other.pageSize &&
            this.remoteFields == other.remoteFields &&
            this.remoteId == other.remoteId &&
            this.showEnumOrigins == other.showEnumOrigins &&
            this.transactionDateAfter == other.transactionDateAfter &&
            this.transactionDateBefore == other.transactionDateBefore &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            companyId,
            createdAfter,
            createdBefore,
            cursor,
            expand,
            includeDeletedData,
            includeRemoteData,
            modifiedAfter,
            modifiedBefore,
            pageSize,
            remoteFields,
            remoteId,
            showEnumOrigins,
            transactionDateAfter,
            transactionDateBefore,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "CreditNoteListParams{companyId=$companyId, createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, expand=$expand, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, pageSize=$pageSize, remoteFields=$remoteFields, remoteId=$remoteId, showEnumOrigins=$showEnumOrigins, transactionDateAfter=$transactionDateAfter, transactionDateBefore=$transactionDateBefore, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var companyId: String? = null
        private var createdAfter: OffsetDateTime? = null
        private var createdBefore: OffsetDateTime? = null
        private var cursor: String? = null
        private var expand: List<Expand>? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var pageSize: Long? = null
        private var remoteFields: RemoteFields? = null
        private var remoteId: String? = null
        private var showEnumOrigins: ShowEnumOrigins? = null
        private var transactionDateAfter: OffsetDateTime? = null
        private var transactionDateBefore: OffsetDateTime? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(creditNoteListParams: CreditNoteListParams) = apply {
            this.companyId = creditNoteListParams.companyId
            this.createdAfter = creditNoteListParams.createdAfter
            this.createdBefore = creditNoteListParams.createdBefore
            this.cursor = creditNoteListParams.cursor
            this.expand = creditNoteListParams.expand
            this.includeDeletedData = creditNoteListParams.includeDeletedData
            this.includeRemoteData = creditNoteListParams.includeRemoteData
            this.modifiedAfter = creditNoteListParams.modifiedAfter
            this.modifiedBefore = creditNoteListParams.modifiedBefore
            this.pageSize = creditNoteListParams.pageSize
            this.remoteFields = creditNoteListParams.remoteFields
            this.remoteId = creditNoteListParams.remoteId
            this.showEnumOrigins = creditNoteListParams.showEnumOrigins
            this.transactionDateAfter = creditNoteListParams.transactionDateAfter
            this.transactionDateBefore = creditNoteListParams.transactionDateBefore
            additionalQueryParams(creditNoteListParams.additionalQueryParams)
            additionalHeaders(creditNoteListParams.additionalHeaders)
        }

        /** If provided, will only return credit notes for this company. */
        fun companyId(companyId: String) = apply { this.companyId = companyId }

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

        /** If provided, will only return objects created after this datetime. */
        fun transactionDateAfter(transactionDateAfter: OffsetDateTime) = apply {
            this.transactionDateAfter = transactionDateAfter
        }

        /** If provided, will only return objects created before this datetime. */
        fun transactionDateBefore(transactionDateBefore: OffsetDateTime) = apply {
            this.transactionDateBefore = transactionDateBefore
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

        fun build(): CreditNoteListParams =
            CreditNoteListParams(
                companyId,
                createdAfter,
                createdBefore,
                cursor,
                expand?.toUnmodifiable(),
                includeDeletedData,
                includeRemoteData,
                modifiedAfter,
                modifiedBefore,
                pageSize,
                remoteFields,
                remoteId,
                showEnumOrigins,
                transactionDateAfter,
                transactionDateBefore,
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

            @JvmField val LINE_ITEMS = Expand(JsonField.of("line_items"))

            @JvmField val PAYMENTS = Expand(JsonField.of("payments"))

            @JvmField val TRACKING_CATEGORIES = Expand(JsonField.of("tracking_categories"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            LINE_ITEMS,
            PAYMENTS,
            TRACKING_CATEGORIES,
        }

        enum class Value {
            LINE_ITEMS,
            PAYMENTS,
            TRACKING_CATEGORIES,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                LINE_ITEMS -> Value.LINE_ITEMS
                PAYMENTS -> Value.PAYMENTS
                TRACKING_CATEGORIES -> Value.TRACKING_CATEGORIES
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                LINE_ITEMS -> Known.LINE_ITEMS
                PAYMENTS -> Known.PAYMENTS
                TRACKING_CATEGORIES -> Known.TRACKING_CATEGORIES
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

            @JvmField val STATUS_TYPE = RemoteFields(JsonField.of("status,type"))

            @JvmField val TYPE = RemoteFields(JsonField.of("type"))

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            STATUS,
            STATUS_TYPE,
            TYPE,
        }

        enum class Value {
            STATUS,
            STATUS_TYPE,
            TYPE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STATUS -> Value.STATUS
                STATUS_TYPE -> Value.STATUS_TYPE
                TYPE -> Value.TYPE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STATUS -> Known.STATUS
                STATUS_TYPE -> Known.STATUS_TYPE
                TYPE -> Known.TYPE
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

            @JvmField val STATUS_TYPE = ShowEnumOrigins(JsonField.of("status,type"))

            @JvmField val TYPE = ShowEnumOrigins(JsonField.of("type"))

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            STATUS,
            STATUS_TYPE,
            TYPE,
        }

        enum class Value {
            STATUS,
            STATUS_TYPE,
            TYPE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STATUS -> Value.STATUS
                STATUS_TYPE -> Value.STATUS_TYPE
                TYPE -> Value.TYPE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STATUS -> Known.STATUS
                STATUS_TYPE -> Known.STATUS_TYPE
                TYPE -> Known.TYPE
                else -> throw MergeInvalidDataException("Unknown ShowEnumOrigins: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
