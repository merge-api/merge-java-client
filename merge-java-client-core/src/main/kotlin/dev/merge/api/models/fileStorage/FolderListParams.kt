package dev.merge.api.models.fileStorage

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

class FolderListParams
constructor(
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val driveId: String?,
    private val expand: List<Expand>?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val name: String?,
    private val pageSize: Long?,
    private val parentFolderId: String?,
    private val remoteId: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun driveId(): Optional<String> = Optional.ofNullable(driveId)

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun name(): Optional<String> = Optional.ofNullable(name)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun parentFolderId(): Optional<String> = Optional.ofNullable(parentFolderId)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.driveId?.let { params.put("drive_id", listOf(it.toString())) }
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.name?.let { params.put("name", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.parentFolderId?.let { params.put("parent_folder_id", listOf(it.toString())) }
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

        return other is FolderListParams &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.driveId == other.driveId &&
            this.expand == other.expand &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.name == other.name &&
            this.pageSize == other.pageSize &&
            this.parentFolderId == other.parentFolderId &&
            this.remoteId == other.remoteId &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            createdAfter,
            createdBefore,
            cursor,
            driveId,
            expand,
            includeDeletedData,
            includeRemoteData,
            modifiedAfter,
            modifiedBefore,
            name,
            pageSize,
            parentFolderId,
            remoteId,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "FolderListParams{createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, driveId=$driveId, expand=$expand, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, name=$name, pageSize=$pageSize, parentFolderId=$parentFolderId, remoteId=$remoteId, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var createdAfter: OffsetDateTime? = null
        private var createdBefore: OffsetDateTime? = null
        private var cursor: String? = null
        private var driveId: String? = null
        private var expand: List<Expand>? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var name: String? = null
        private var pageSize: Long? = null
        private var parentFolderId: String? = null
        private var remoteId: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(folderListParams: FolderListParams) = apply {
            this.createdAfter = folderListParams.createdAfter
            this.createdBefore = folderListParams.createdBefore
            this.cursor = folderListParams.cursor
            this.driveId = folderListParams.driveId
            this.expand = folderListParams.expand
            this.includeDeletedData = folderListParams.includeDeletedData
            this.includeRemoteData = folderListParams.includeRemoteData
            this.modifiedAfter = folderListParams.modifiedAfter
            this.modifiedBefore = folderListParams.modifiedBefore
            this.name = folderListParams.name
            this.pageSize = folderListParams.pageSize
            this.parentFolderId = folderListParams.parentFolderId
            this.remoteId = folderListParams.remoteId
            additionalQueryParams(folderListParams.additionalQueryParams)
            additionalHeaders(folderListParams.additionalHeaders)
        }

        /** If provided, will only return objects created after this datetime. */
        fun createdAfter(createdAfter: OffsetDateTime) = apply { this.createdAfter = createdAfter }

        /** If provided, will only return objects created before this datetime. */
        fun createdBefore(createdBefore: OffsetDateTime) = apply {
            this.createdBefore = createdBefore
        }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

        /** If provided, will only return folders in this drive. */
        fun driveId(driveId: String) = apply { this.driveId = driveId }

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

        /** If provided, will only return folders with this name. This performs an exact match. */
        fun name(name: String) = apply { this.name = name }

        /** Number of results to return per page. */
        fun pageSize(pageSize: Long) = apply { this.pageSize = pageSize }

        /**
         * If provided, will only return folders in this parent folder. If null, will return folders
         * in root directory.
         */
        fun parentFolderId(parentFolderId: String) = apply { this.parentFolderId = parentFolderId }

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

        fun build(): FolderListParams =
            FolderListParams(
                createdAfter,
                createdBefore,
                cursor,
                driveId,
                expand?.toUnmodifiable(),
                includeDeletedData,
                includeRemoteData,
                modifiedAfter,
                modifiedBefore,
                name,
                pageSize,
                parentFolderId,
                remoteId,
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

            @JvmField val DRIVE = Expand(JsonField.of("drive"))

            @JvmField val PARENT_FOLDER = Expand(JsonField.of("parent_folder"))

            @JvmField val PERMISSIONS = Expand(JsonField.of("permissions"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            DRIVE,
            PARENT_FOLDER,
            PERMISSIONS,
        }

        enum class Value {
            DRIVE,
            PARENT_FOLDER,
            PERMISSIONS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                DRIVE -> Value.DRIVE
                PARENT_FOLDER -> Value.PARENT_FOLDER
                PERMISSIONS -> Value.PERMISSIONS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                DRIVE -> Known.DRIVE
                PARENT_FOLDER -> Known.PARENT_FOLDER
                PERMISSIONS -> Known.PERMISSIONS
                else -> throw MergeInvalidDataException("Unknown Expand: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
