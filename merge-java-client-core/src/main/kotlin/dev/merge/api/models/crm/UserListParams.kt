package dev.merge.api.models.crm

import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

class UserListParams
constructor(
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val includeRemoteFields: Boolean?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val pageSize: Long?,
    private val remoteId: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun includeRemoteFields(): Optional<Boolean> = Optional.ofNullable(includeRemoteFields)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.includeRemoteFields?.let { params.put("include_remote_fields", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
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

        return other is UserListParams &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.includeRemoteFields == other.includeRemoteFields &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.pageSize == other.pageSize &&
            this.remoteId == other.remoteId &&
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
            includeRemoteFields,
            modifiedAfter,
            modifiedBefore,
            pageSize,
            remoteId,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "UserListParams{createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, includeRemoteFields=$includeRemoteFields, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, pageSize=$pageSize, remoteId=$remoteId, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

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
        private var includeRemoteFields: Boolean? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var pageSize: Long? = null
        private var remoteId: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(userListParams: UserListParams) = apply {
            this.createdAfter = userListParams.createdAfter
            this.createdBefore = userListParams.createdBefore
            this.cursor = userListParams.cursor
            this.includeDeletedData = userListParams.includeDeletedData
            this.includeRemoteData = userListParams.includeRemoteData
            this.includeRemoteFields = userListParams.includeRemoteFields
            this.modifiedAfter = userListParams.modifiedAfter
            this.modifiedBefore = userListParams.modifiedBefore
            this.pageSize = userListParams.pageSize
            this.remoteId = userListParams.remoteId
            additionalQueryParams(userListParams.additionalQueryParams)
            additionalHeaders(userListParams.additionalHeaders)
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

        /**
         * Whether to include all remote fields, including fields that Merge did not map to common
         * models, in a normalized format.
         */
        fun includeRemoteFields(includeRemoteFields: Boolean) = apply {
            this.includeRemoteFields = includeRemoteFields
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

        /** The API provider's ID for the given object. */
        fun remoteId(remoteId: String) = apply { this.remoteId = remoteId }

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

        fun build(): UserListParams =
            UserListParams(
                createdAfter,
                createdBefore,
                cursor,
                includeDeletedData,
                includeRemoteData,
                includeRemoteFields,
                modifiedAfter,
                modifiedBefore,
                pageSize,
                remoteId,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }
}
