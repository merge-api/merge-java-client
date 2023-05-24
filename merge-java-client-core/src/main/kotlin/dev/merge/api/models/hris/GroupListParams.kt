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

class GroupListParams
constructor(
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val pageSize: Long?,
    private val remoteFields: RemoteFields?,
    private val remoteId: String?,
    private val showEnumOrigins: ShowEnumOrigins?,
    private val types: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun remoteFields(): Optional<RemoteFields> = Optional.ofNullable(remoteFields)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    fun showEnumOrigins(): Optional<ShowEnumOrigins> = Optional.ofNullable(showEnumOrigins)

    fun types(): Optional<String> = Optional.ofNullable(types)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.remoteFields?.let { params.put("remote_fields", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
        this.showEnumOrigins?.let { params.put("show_enum_origins", listOf(it.toString())) }
        this.types?.let { params.put("types", listOf(it.toString())) }
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

        return other is GroupListParams &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.pageSize == other.pageSize &&
            this.remoteFields == other.remoteFields &&
            this.remoteId == other.remoteId &&
            this.showEnumOrigins == other.showEnumOrigins &&
            this.types == other.types &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            createdAfter,
            createdBefore,
            cursor,
            includeDeletedData,
            includeRemoteData,
            modifiedAfter,
            modifiedBefore,
            pageSize,
            remoteFields,
            remoteId,
            showEnumOrigins,
            types,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "GroupListParams{createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, pageSize=$pageSize, remoteFields=$remoteFields, remoteId=$remoteId, showEnumOrigins=$showEnumOrigins, types=$types, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var createdAfter: OffsetDateTime? = null
        private var createdBefore: OffsetDateTime? = null
        private var cursor: String? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var pageSize: Long? = null
        private var remoteFields: RemoteFields? = null
        private var remoteId: String? = null
        private var showEnumOrigins: ShowEnumOrigins? = null
        private var types: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(groupListParams: GroupListParams) = apply {
            this.createdAfter = groupListParams.createdAfter
            this.createdBefore = groupListParams.createdBefore
            this.cursor = groupListParams.cursor
            this.includeDeletedData = groupListParams.includeDeletedData
            this.includeRemoteData = groupListParams.includeRemoteData
            this.modifiedAfter = groupListParams.modifiedAfter
            this.modifiedBefore = groupListParams.modifiedBefore
            this.pageSize = groupListParams.pageSize
            this.remoteFields = groupListParams.remoteFields
            this.remoteId = groupListParams.remoteId
            this.showEnumOrigins = groupListParams.showEnumOrigins
            this.types = groupListParams.types
            additionalQueryParams(groupListParams.additionalQueryParams)
            additionalHeaders(groupListParams.additionalHeaders)
        }

        /** If provided, will only return objects created after this datetime. */
        fun createdAfter(createdAfter: OffsetDateTime) = apply { this.createdAfter = createdAfter }

        /** If provided, will only return objects created before this datetime. */
        fun createdBefore(createdBefore: OffsetDateTime) = apply {
            this.createdBefore = createdBefore
        }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

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

        /**
         * If provided, will only return groups of these types. Multiple values can be separated by
         * commas.
         */
        fun types(types: String) = apply { this.types = types }

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

        fun build(): GroupListParams =
            GroupListParams(
                createdAfter,
                createdBefore,
                cursor,
                includeDeletedData,
                includeRemoteData,
                modifiedAfter,
                modifiedBefore,
                pageSize,
                remoteFields,
                remoteId,
                showEnumOrigins,
                types,
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

            @JvmField val TYPE = RemoteFields(JsonField.of("type"))

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            TYPE,
        }

        enum class Value {
            TYPE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TYPE -> Value.TYPE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
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

            @JvmField val TYPE = ShowEnumOrigins(JsonField.of("type"))

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            TYPE,
        }

        enum class Value {
            TYPE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TYPE -> Value.TYPE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                TYPE -> Known.TYPE
                else -> throw MergeInvalidDataException("Unknown ShowEnumOrigins: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
