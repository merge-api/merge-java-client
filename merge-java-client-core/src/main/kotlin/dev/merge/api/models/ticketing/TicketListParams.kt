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

class TicketListParams
constructor(
    private val accountId: String?,
    private val assigneeIds: String?,
    private val collectionIds: String?,
    private val completedAfter: OffsetDateTime?,
    private val completedBefore: OffsetDateTime?,
    private val contactId: String?,
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val dueAfter: OffsetDateTime?,
    private val dueBefore: OffsetDateTime?,
    private val expand: List<Expand>?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val includeRemoteFields: Boolean?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val pageSize: Long?,
    private val parentTicketId: String?,
    private val priority: Priority?,
    private val projectId: String?,
    private val remoteCreatedAfter: OffsetDateTime?,
    private val remoteCreatedBefore: OffsetDateTime?,
    private val remoteFields: RemoteFields?,
    private val remoteId: String?,
    private val remoteUpdatedAfter: OffsetDateTime?,
    private val remoteUpdatedBefore: OffsetDateTime?,
    private val showEnumOrigins: ShowEnumOrigins?,
    private val status: Status?,
    private val tags: String?,
    private val ticketType: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun accountId(): Optional<String> = Optional.ofNullable(accountId)

    fun assigneeIds(): Optional<String> = Optional.ofNullable(assigneeIds)

    fun collectionIds(): Optional<String> = Optional.ofNullable(collectionIds)

    fun completedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(completedAfter)

    fun completedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(completedBefore)

    fun contactId(): Optional<String> = Optional.ofNullable(contactId)

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun dueAfter(): Optional<OffsetDateTime> = Optional.ofNullable(dueAfter)

    fun dueBefore(): Optional<OffsetDateTime> = Optional.ofNullable(dueBefore)

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun includeRemoteFields(): Optional<Boolean> = Optional.ofNullable(includeRemoteFields)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun parentTicketId(): Optional<String> = Optional.ofNullable(parentTicketId)

    fun priority(): Optional<Priority> = Optional.ofNullable(priority)

    fun projectId(): Optional<String> = Optional.ofNullable(projectId)

    fun remoteCreatedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(remoteCreatedAfter)

    fun remoteCreatedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(remoteCreatedBefore)

    fun remoteFields(): Optional<RemoteFields> = Optional.ofNullable(remoteFields)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    fun remoteUpdatedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(remoteUpdatedAfter)

    fun remoteUpdatedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(remoteUpdatedBefore)

    fun showEnumOrigins(): Optional<ShowEnumOrigins> = Optional.ofNullable(showEnumOrigins)

    fun status(): Optional<Status> = Optional.ofNullable(status)

    fun tags(): Optional<String> = Optional.ofNullable(tags)

    fun ticketType(): Optional<String> = Optional.ofNullable(ticketType)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.accountId?.let { params.put("account_id", listOf(it.toString())) }
        this.assigneeIds?.let { params.put("assignee_ids", listOf(it.toString())) }
        this.collectionIds?.let { params.put("collection_ids", listOf(it.toString())) }
        this.completedAfter?.let { params.put("completed_after", listOf(it.toString())) }
        this.completedBefore?.let { params.put("completed_before", listOf(it.toString())) }
        this.contactId?.let { params.put("contact_id", listOf(it.toString())) }
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.dueAfter?.let { params.put("due_after", listOf(it.toString())) }
        this.dueBefore?.let { params.put("due_before", listOf(it.toString())) }
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.includeRemoteFields?.let { params.put("include_remote_fields", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.parentTicketId?.let { params.put("parent_ticket_id", listOf(it.toString())) }
        this.priority?.let { params.put("priority", listOf(it.toString())) }
        this.projectId?.let { params.put("project_id", listOf(it.toString())) }
        this.remoteCreatedAfter?.let { params.put("remote_created_after", listOf(it.toString())) }
        this.remoteCreatedBefore?.let { params.put("remote_created_before", listOf(it.toString())) }
        this.remoteFields?.let { params.put("remote_fields", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
        this.remoteUpdatedAfter?.let { params.put("remote_updated_after", listOf(it.toString())) }
        this.remoteUpdatedBefore?.let { params.put("remote_updated_before", listOf(it.toString())) }
        this.showEnumOrigins?.let { params.put("show_enum_origins", listOf(it.toString())) }
        this.status?.let { params.put("status", listOf(it.toString())) }
        this.tags?.let { params.put("tags", listOf(it.toString())) }
        this.ticketType?.let { params.put("ticket_type", listOf(it.toString())) }
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

        return other is TicketListParams &&
            this.accountId == other.accountId &&
            this.assigneeIds == other.assigneeIds &&
            this.collectionIds == other.collectionIds &&
            this.completedAfter == other.completedAfter &&
            this.completedBefore == other.completedBefore &&
            this.contactId == other.contactId &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.dueAfter == other.dueAfter &&
            this.dueBefore == other.dueBefore &&
            this.expand == other.expand &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.includeRemoteFields == other.includeRemoteFields &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.pageSize == other.pageSize &&
            this.parentTicketId == other.parentTicketId &&
            this.priority == other.priority &&
            this.projectId == other.projectId &&
            this.remoteCreatedAfter == other.remoteCreatedAfter &&
            this.remoteCreatedBefore == other.remoteCreatedBefore &&
            this.remoteFields == other.remoteFields &&
            this.remoteId == other.remoteId &&
            this.remoteUpdatedAfter == other.remoteUpdatedAfter &&
            this.remoteUpdatedBefore == other.remoteUpdatedBefore &&
            this.showEnumOrigins == other.showEnumOrigins &&
            this.status == other.status &&
            this.tags == other.tags &&
            this.ticketType == other.ticketType &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            accountId,
            assigneeIds,
            collectionIds,
            completedAfter,
            completedBefore,
            contactId,
            createdAfter,
            createdBefore,
            cursor,
            dueAfter,
            dueBefore,
            expand,
            includeDeletedData,
            includeRemoteData,
            includeRemoteFields,
            modifiedAfter,
            modifiedBefore,
            pageSize,
            parentTicketId,
            priority,
            projectId,
            remoteCreatedAfter,
            remoteCreatedBefore,
            remoteFields,
            remoteId,
            remoteUpdatedAfter,
            remoteUpdatedBefore,
            showEnumOrigins,
            status,
            tags,
            ticketType,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "TicketListParams{accountId=$accountId, assigneeIds=$assigneeIds, collectionIds=$collectionIds, completedAfter=$completedAfter, completedBefore=$completedBefore, contactId=$contactId, createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, dueAfter=$dueAfter, dueBefore=$dueBefore, expand=$expand, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, includeRemoteFields=$includeRemoteFields, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, pageSize=$pageSize, parentTicketId=$parentTicketId, priority=$priority, projectId=$projectId, remoteCreatedAfter=$remoteCreatedAfter, remoteCreatedBefore=$remoteCreatedBefore, remoteFields=$remoteFields, remoteId=$remoteId, remoteUpdatedAfter=$remoteUpdatedAfter, remoteUpdatedBefore=$remoteUpdatedBefore, showEnumOrigins=$showEnumOrigins, status=$status, tags=$tags, ticketType=$ticketType, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var accountId: String? = null
        private var assigneeIds: String? = null
        private var collectionIds: String? = null
        private var completedAfter: OffsetDateTime? = null
        private var completedBefore: OffsetDateTime? = null
        private var contactId: String? = null
        private var createdAfter: OffsetDateTime? = null
        private var createdBefore: OffsetDateTime? = null
        private var cursor: String? = null
        private var dueAfter: OffsetDateTime? = null
        private var dueBefore: OffsetDateTime? = null
        private var expand: List<Expand>? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var includeRemoteFields: Boolean? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var pageSize: Long? = null
        private var parentTicketId: String? = null
        private var priority: Priority? = null
        private var projectId: String? = null
        private var remoteCreatedAfter: OffsetDateTime? = null
        private var remoteCreatedBefore: OffsetDateTime? = null
        private var remoteFields: RemoteFields? = null
        private var remoteId: String? = null
        private var remoteUpdatedAfter: OffsetDateTime? = null
        private var remoteUpdatedBefore: OffsetDateTime? = null
        private var showEnumOrigins: ShowEnumOrigins? = null
        private var status: Status? = null
        private var tags: String? = null
        private var ticketType: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(ticketListParams: TicketListParams) = apply {
            this.accountId = ticketListParams.accountId
            this.assigneeIds = ticketListParams.assigneeIds
            this.collectionIds = ticketListParams.collectionIds
            this.completedAfter = ticketListParams.completedAfter
            this.completedBefore = ticketListParams.completedBefore
            this.contactId = ticketListParams.contactId
            this.createdAfter = ticketListParams.createdAfter
            this.createdBefore = ticketListParams.createdBefore
            this.cursor = ticketListParams.cursor
            this.dueAfter = ticketListParams.dueAfter
            this.dueBefore = ticketListParams.dueBefore
            this.expand = ticketListParams.expand
            this.includeDeletedData = ticketListParams.includeDeletedData
            this.includeRemoteData = ticketListParams.includeRemoteData
            this.includeRemoteFields = ticketListParams.includeRemoteFields
            this.modifiedAfter = ticketListParams.modifiedAfter
            this.modifiedBefore = ticketListParams.modifiedBefore
            this.pageSize = ticketListParams.pageSize
            this.parentTicketId = ticketListParams.parentTicketId
            this.priority = ticketListParams.priority
            this.projectId = ticketListParams.projectId
            this.remoteCreatedAfter = ticketListParams.remoteCreatedAfter
            this.remoteCreatedBefore = ticketListParams.remoteCreatedBefore
            this.remoteFields = ticketListParams.remoteFields
            this.remoteId = ticketListParams.remoteId
            this.remoteUpdatedAfter = ticketListParams.remoteUpdatedAfter
            this.remoteUpdatedBefore = ticketListParams.remoteUpdatedBefore
            this.showEnumOrigins = ticketListParams.showEnumOrigins
            this.status = ticketListParams.status
            this.tags = ticketListParams.tags
            this.ticketType = ticketListParams.ticketType
            additionalQueryParams(ticketListParams.additionalQueryParams)
            additionalHeaders(ticketListParams.additionalHeaders)
        }

        /** If provided, will only return tickets for this account. */
        fun accountId(accountId: String) = apply { this.accountId = accountId }

        /**
         * If provided, will only return tickets assigned to the assignee_ids; multiple assignee_ids
         * can be separated by commas.
         */
        fun assigneeIds(assigneeIds: String) = apply { this.assigneeIds = assigneeIds }

        /**
         * If provided, will only return tickets assigned to the collection_ids; multiple
         * collection_ids can be separated by commas.
         */
        fun collectionIds(collectionIds: String) = apply { this.collectionIds = collectionIds }

        /** If provided, will only return tickets completed after this datetime. */
        fun completedAfter(completedAfter: OffsetDateTime) = apply {
            this.completedAfter = completedAfter
        }

        /** If provided, will only return tickets completed before this datetime. */
        fun completedBefore(completedBefore: OffsetDateTime) = apply {
            this.completedBefore = completedBefore
        }

        /** If provided, will only return tickets for this contact. */
        fun contactId(contactId: String) = apply { this.contactId = contactId }

        /** If provided, will only return objects created after this datetime. */
        fun createdAfter(createdAfter: OffsetDateTime) = apply { this.createdAfter = createdAfter }

        /** If provided, will only return objects created before this datetime. */
        fun createdBefore(createdBefore: OffsetDateTime) = apply {
            this.createdBefore = createdBefore
        }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

        /** If provided, will only return tickets due after this datetime. */
        fun dueAfter(dueAfter: OffsetDateTime) = apply { this.dueAfter = dueAfter }

        /** If provided, will only return tickets due before this datetime. */
        fun dueBefore(dueBefore: OffsetDateTime) = apply { this.dueBefore = dueBefore }

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

        /** If provided, will only return sub tickets of the parent_ticket_id. */
        fun parentTicketId(parentTicketId: String) = apply { this.parentTicketId = parentTicketId }

        /**
         * If provided, will only return tickets of this priority.
         *
         * - `URGENT` - URGENT
         * - `HIGH` - HIGH
         * - `NORMAL` - NORMAL
         * - `LOW` - LOW
         */
        fun priority(priority: Priority) = apply { this.priority = priority }

        /** If provided, will only return tickets for this project. */
        fun projectId(projectId: String) = apply { this.projectId = projectId }

        /**
         * If provided, will only return tickets created in the third party platform after this
         * datetime.
         */
        fun remoteCreatedAfter(remoteCreatedAfter: OffsetDateTime) = apply {
            this.remoteCreatedAfter = remoteCreatedAfter
        }

        /**
         * If provided, will only return tickets created in the third party platform before this
         * datetime.
         */
        fun remoteCreatedBefore(remoteCreatedBefore: OffsetDateTime) = apply {
            this.remoteCreatedBefore = remoteCreatedBefore
        }

        /** Deprecated. Use show_enum_origins. */
        fun remoteFields(remoteFields: RemoteFields) = apply { this.remoteFields = remoteFields }

        /** The API provider's ID for the given object. */
        fun remoteId(remoteId: String) = apply { this.remoteId = remoteId }

        /**
         * If provided, will only return tickets updated in the third party platform after this
         * datetime.
         */
        fun remoteUpdatedAfter(remoteUpdatedAfter: OffsetDateTime) = apply {
            this.remoteUpdatedAfter = remoteUpdatedAfter
        }

        /**
         * If provided, will only return tickets updated in the third party platform before this
         * datetime.
         */
        fun remoteUpdatedBefore(remoteUpdatedBefore: OffsetDateTime) = apply {
            this.remoteUpdatedBefore = remoteUpdatedBefore
        }

        /** Which fields should be returned in non-normalized form. */
        fun showEnumOrigins(showEnumOrigins: ShowEnumOrigins) = apply {
            this.showEnumOrigins = showEnumOrigins
        }

        /**
         * If provided, will only return tickets of this status.
         *
         * - `OPEN` - OPEN
         * - `CLOSED` - CLOSED
         * - `IN_PROGRESS` - IN_PROGRESS
         * - `ON_HOLD` - ON_HOLD
         */
        fun status(status: Status) = apply { this.status = status }

        /**
         * If provided, will only return tickets matching the tags; multiple tags can be separated
         * by commas.
         */
        fun tags(tags: String) = apply { this.tags = tags }

        /** If provided, will only return tickets of this type. */
        fun ticketType(ticketType: String) = apply { this.ticketType = ticketType }

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

        fun build(): TicketListParams =
            TicketListParams(
                accountId,
                assigneeIds,
                collectionIds,
                completedAfter,
                completedBefore,
                contactId,
                createdAfter,
                createdBefore,
                cursor,
                dueAfter,
                dueBefore,
                expand?.toUnmodifiable(),
                includeDeletedData,
                includeRemoteData,
                includeRemoteFields,
                modifiedAfter,
                modifiedBefore,
                pageSize,
                parentTicketId,
                priority,
                projectId,
                remoteCreatedAfter,
                remoteCreatedBefore,
                remoteFields,
                remoteId,
                remoteUpdatedAfter,
                remoteUpdatedBefore,
                showEnumOrigins,
                status,
                tags,
                ticketType,
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

            @JvmField val ACCOUNT = Expand(JsonField.of("account"))

            @JvmField val ASSIGNEES = Expand(JsonField.of("assignees"))

            @JvmField val ATTACHMENTS = Expand(JsonField.of("attachments"))

            @JvmField val COLLECTIONS = Expand(JsonField.of("collections"))

            @JvmField val CONTACT = Expand(JsonField.of("contact"))

            @JvmField val CREATOR = Expand(JsonField.of("creator"))

            @JvmField val PARENT_TICKET = Expand(JsonField.of("parent_ticket"))

            @JvmField val PROJECT = Expand(JsonField.of("project"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            ACCOUNT,
            ASSIGNEES,
            ATTACHMENTS,
            COLLECTIONS,
            CONTACT,
            CREATOR,
            PARENT_TICKET,
            PROJECT,
        }

        enum class Value {
            ACCOUNT,
            ASSIGNEES,
            ATTACHMENTS,
            COLLECTIONS,
            CONTACT,
            CREATOR,
            PARENT_TICKET,
            PROJECT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ACCOUNT -> Value.ACCOUNT
                ASSIGNEES -> Value.ASSIGNEES
                ATTACHMENTS -> Value.ATTACHMENTS
                COLLECTIONS -> Value.COLLECTIONS
                CONTACT -> Value.CONTACT
                CREATOR -> Value.CREATOR
                PARENT_TICKET -> Value.PARENT_TICKET
                PROJECT -> Value.PROJECT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ACCOUNT -> Known.ACCOUNT
                ASSIGNEES -> Known.ASSIGNEES
                ATTACHMENTS -> Known.ATTACHMENTS
                COLLECTIONS -> Known.COLLECTIONS
                CONTACT -> Known.CONTACT
                CREATOR -> Known.CREATOR
                PARENT_TICKET -> Known.PARENT_TICKET
                PROJECT -> Known.PROJECT
                else -> throw MergeInvalidDataException("Unknown Expand: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Priority
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Priority && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val HIGH = Priority(JsonField.of("HIGH"))

            @JvmField val LOW = Priority(JsonField.of("LOW"))

            @JvmField val NORMAL = Priority(JsonField.of("NORMAL"))

            @JvmField val URGENT = Priority(JsonField.of("URGENT"))

            @JvmStatic fun of(value: String) = Priority(JsonField.of(value))
        }

        enum class Known {
            HIGH,
            LOW,
            NORMAL,
            URGENT,
        }

        enum class Value {
            HIGH,
            LOW,
            NORMAL,
            URGENT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                HIGH -> Value.HIGH
                LOW -> Value.LOW
                NORMAL -> Value.NORMAL
                URGENT -> Value.URGENT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                HIGH -> Known.HIGH
                LOW -> Known.LOW
                NORMAL -> Known.NORMAL
                URGENT -> Known.URGENT
                else -> throw MergeInvalidDataException("Unknown Priority: $value")
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

            @JvmField val PRIORITY = RemoteFields(JsonField.of("priority"))

            @JvmField val PRIORITY_STATUS = RemoteFields(JsonField.of("priority,status"))

            @JvmField
            val PRIORITY_STATUS_TICKET_TYPE =
                RemoteFields(JsonField.of("priority,status,ticket_type"))

            @JvmField val PRIORITY_TICKET_TYPE = RemoteFields(JsonField.of("priority,ticket_type"))

            @JvmField val STATUS = RemoteFields(JsonField.of("status"))

            @JvmField val STATUS_TICKET_TYPE = RemoteFields(JsonField.of("status,ticket_type"))

            @JvmField val TICKET_TYPE = RemoteFields(JsonField.of("ticket_type"))

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            PRIORITY,
            PRIORITY_STATUS,
            PRIORITY_STATUS_TICKET_TYPE,
            PRIORITY_TICKET_TYPE,
            STATUS,
            STATUS_TICKET_TYPE,
            TICKET_TYPE,
        }

        enum class Value {
            PRIORITY,
            PRIORITY_STATUS,
            PRIORITY_STATUS_TICKET_TYPE,
            PRIORITY_TICKET_TYPE,
            STATUS,
            STATUS_TICKET_TYPE,
            TICKET_TYPE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                PRIORITY -> Value.PRIORITY
                PRIORITY_STATUS -> Value.PRIORITY_STATUS
                PRIORITY_STATUS_TICKET_TYPE -> Value.PRIORITY_STATUS_TICKET_TYPE
                PRIORITY_TICKET_TYPE -> Value.PRIORITY_TICKET_TYPE
                STATUS -> Value.STATUS
                STATUS_TICKET_TYPE -> Value.STATUS_TICKET_TYPE
                TICKET_TYPE -> Value.TICKET_TYPE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                PRIORITY -> Known.PRIORITY
                PRIORITY_STATUS -> Known.PRIORITY_STATUS
                PRIORITY_STATUS_TICKET_TYPE -> Known.PRIORITY_STATUS_TICKET_TYPE
                PRIORITY_TICKET_TYPE -> Known.PRIORITY_TICKET_TYPE
                STATUS -> Known.STATUS
                STATUS_TICKET_TYPE -> Known.STATUS_TICKET_TYPE
                TICKET_TYPE -> Known.TICKET_TYPE
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

            @JvmField val PRIORITY = ShowEnumOrigins(JsonField.of("priority"))

            @JvmField val PRIORITY_STATUS = ShowEnumOrigins(JsonField.of("priority,status"))

            @JvmField
            val PRIORITY_STATUS_TICKET_TYPE =
                ShowEnumOrigins(JsonField.of("priority,status,ticket_type"))

            @JvmField
            val PRIORITY_TICKET_TYPE = ShowEnumOrigins(JsonField.of("priority,ticket_type"))

            @JvmField val STATUS = ShowEnumOrigins(JsonField.of("status"))

            @JvmField val STATUS_TICKET_TYPE = ShowEnumOrigins(JsonField.of("status,ticket_type"))

            @JvmField val TICKET_TYPE = ShowEnumOrigins(JsonField.of("ticket_type"))

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            PRIORITY,
            PRIORITY_STATUS,
            PRIORITY_STATUS_TICKET_TYPE,
            PRIORITY_TICKET_TYPE,
            STATUS,
            STATUS_TICKET_TYPE,
            TICKET_TYPE,
        }

        enum class Value {
            PRIORITY,
            PRIORITY_STATUS,
            PRIORITY_STATUS_TICKET_TYPE,
            PRIORITY_TICKET_TYPE,
            STATUS,
            STATUS_TICKET_TYPE,
            TICKET_TYPE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                PRIORITY -> Value.PRIORITY
                PRIORITY_STATUS -> Value.PRIORITY_STATUS
                PRIORITY_STATUS_TICKET_TYPE -> Value.PRIORITY_STATUS_TICKET_TYPE
                PRIORITY_TICKET_TYPE -> Value.PRIORITY_TICKET_TYPE
                STATUS -> Value.STATUS
                STATUS_TICKET_TYPE -> Value.STATUS_TICKET_TYPE
                TICKET_TYPE -> Value.TICKET_TYPE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                PRIORITY -> Known.PRIORITY
                PRIORITY_STATUS -> Known.PRIORITY_STATUS
                PRIORITY_STATUS_TICKET_TYPE -> Known.PRIORITY_STATUS_TICKET_TYPE
                PRIORITY_TICKET_TYPE -> Known.PRIORITY_TICKET_TYPE
                STATUS -> Known.STATUS
                STATUS_TICKET_TYPE -> Known.STATUS_TICKET_TYPE
                TICKET_TYPE -> Known.TICKET_TYPE
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

            @JvmField val CLOSED = Status(JsonField.of("CLOSED"))

            @JvmField val IN_PROGRESS = Status(JsonField.of("IN_PROGRESS"))

            @JvmField val ON_HOLD = Status(JsonField.of("ON_HOLD"))

            @JvmField val OPEN = Status(JsonField.of("OPEN"))

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            CLOSED,
            IN_PROGRESS,
            ON_HOLD,
            OPEN,
        }

        enum class Value {
            CLOSED,
            IN_PROGRESS,
            ON_HOLD,
            OPEN,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CLOSED -> Value.CLOSED
                IN_PROGRESS -> Value.IN_PROGRESS
                ON_HOLD -> Value.ON_HOLD
                OPEN -> Value.OPEN
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CLOSED -> Known.CLOSED
                IN_PROGRESS -> Known.IN_PROGRESS
                ON_HOLD -> Known.ON_HOLD
                OPEN -> Known.OPEN
                else -> throw MergeInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
