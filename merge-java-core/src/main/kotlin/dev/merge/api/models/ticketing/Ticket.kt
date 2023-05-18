package dev.merge.api.models.ticketing

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

/**
 * # The Ticket Object
 *
 * ### Description
 *
 * The `Ticket` object is used to represent a ticket or a task within a system.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = Ticket.Builder::class)
@NoAutoDetect
class Ticket
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val name: JsonField<String>,
    private val assignees: JsonField<List<String>>,
    private val creator: JsonField<String>,
    private val dueDate: JsonField<OffsetDateTime>,
    private val status: JsonField<TicketStatusEnum>,
    private val description: JsonField<String>,
    private val project: JsonField<String>,
    private val collections: JsonField<List<String>>,
    private val ticketType: JsonField<String>,
    private val account: JsonField<String>,
    private val contact: JsonField<String>,
    private val parentTicket: JsonField<String>,
    private val attachments: JsonField<List<String>>,
    private val tags: JsonField<List<String>>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val remoteUpdatedAt: JsonField<OffsetDateTime>,
    private val completedAt: JsonField<OffsetDateTime>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val ticketUrl: JsonField<String>,
    private val priority: JsonField<PriorityEnum>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val remoteFields: JsonField<List<RemoteField>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** The ticket's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    fun assignees(): Optional<List<String>> =
        Optional.ofNullable(assignees.getNullable("assignees"))

    /** The user who created this ticket. */
    fun creator(): Optional<String> = Optional.ofNullable(creator.getNullable("creator"))

    /** The ticket's due date. */
    fun dueDate(): Optional<OffsetDateTime> = Optional.ofNullable(dueDate.getNullable("due_date"))

    /**
     * - `OPEN` - OPEN
     * - `CLOSED` - CLOSED
     * - `IN_PROGRESS` - IN_PROGRESS
     * - `ON_HOLD` - ON_HOLD
     */
    fun status(): Optional<TicketStatusEnum> = Optional.ofNullable(status.getNullable("status"))

    /**
     * The ticket’s description. HTML version of description is mapped if supported by the
     * third-party platform.
     */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /** The project the ticket belongs to. */
    fun project(): Optional<String> = Optional.ofNullable(project.getNullable("project"))

    fun collections(): Optional<List<String>> =
        Optional.ofNullable(collections.getNullable("collections"))

    /** The ticket's type. */
    fun ticketType(): Optional<String> = Optional.ofNullable(ticketType.getNullable("ticket_type"))

    /** The account associated with the ticket. */
    fun account(): Optional<String> = Optional.ofNullable(account.getNullable("account"))

    /** The contact associated with the ticket. */
    fun contact(): Optional<String> = Optional.ofNullable(contact.getNullable("contact"))

    /** The ticket's parent ticket. */
    fun parentTicket(): Optional<String> =
        Optional.ofNullable(parentTicket.getNullable("parent_ticket"))

    fun attachments(): Optional<List<String>> =
        Optional.ofNullable(attachments.getNullable("attachments"))

    fun tags(): Optional<List<String>> = Optional.ofNullable(tags.getNullable("tags"))

    /** When the third party's ticket was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** When the third party's ticket was updated. */
    fun remoteUpdatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteUpdatedAt.getNullable("remote_updated_at"))

    /** When the ticket was completed. */
    fun completedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(completedAt.getNullable("completed_at"))

    fun remoteWasDeleted(): Optional<Boolean> =
        Optional.ofNullable(remoteWasDeleted.getNullable("remote_was_deleted"))

    /** The 3rd party url of the Ticket. */
    fun ticketUrl(): Optional<String> = Optional.ofNullable(ticketUrl.getNullable("ticket_url"))

    /**
     * - `URGENT` - URGENT
     * - `HIGH` - HIGH
     * - `NORMAL` - NORMAL
     * - `LOW` - LOW
     */
    fun priority(): Optional<PriorityEnum> = Optional.ofNullable(priority.getNullable("priority"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<RemoteData>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    fun remoteFields(): Optional<List<RemoteField>> =
        Optional.ofNullable(remoteFields.getNullable("remote_fields"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    /** The ticket's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    @JsonProperty("assignees") @ExcludeMissing fun _assignees() = assignees

    /** The user who created this ticket. */
    @JsonProperty("creator") @ExcludeMissing fun _creator() = creator

    /** The ticket's due date. */
    @JsonProperty("due_date") @ExcludeMissing fun _dueDate() = dueDate

    /**
     * - `OPEN` - OPEN
     * - `CLOSED` - CLOSED
     * - `IN_PROGRESS` - IN_PROGRESS
     * - `ON_HOLD` - ON_HOLD
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /**
     * The ticket’s description. HTML version of description is mapped if supported by the
     * third-party platform.
     */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /** The project the ticket belongs to. */
    @JsonProperty("project") @ExcludeMissing fun _project() = project

    @JsonProperty("collections") @ExcludeMissing fun _collections() = collections

    /** The ticket's type. */
    @JsonProperty("ticket_type") @ExcludeMissing fun _ticketType() = ticketType

    /** The account associated with the ticket. */
    @JsonProperty("account") @ExcludeMissing fun _account() = account

    /** The contact associated with the ticket. */
    @JsonProperty("contact") @ExcludeMissing fun _contact() = contact

    /** The ticket's parent ticket. */
    @JsonProperty("parent_ticket") @ExcludeMissing fun _parentTicket() = parentTicket

    @JsonProperty("attachments") @ExcludeMissing fun _attachments() = attachments

    @JsonProperty("tags") @ExcludeMissing fun _tags() = tags

    /** When the third party's ticket was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** When the third party's ticket was updated. */
    @JsonProperty("remote_updated_at") @ExcludeMissing fun _remoteUpdatedAt() = remoteUpdatedAt

    /** When the ticket was completed. */
    @JsonProperty("completed_at") @ExcludeMissing fun _completedAt() = completedAt

    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    /** The 3rd party url of the Ticket. */
    @JsonProperty("ticket_url") @ExcludeMissing fun _ticketUrl() = ticketUrl

    /**
     * - `URGENT` - URGENT
     * - `HIGH` - HIGH
     * - `NORMAL` - NORMAL
     * - `LOW` - LOW
     */
    @JsonProperty("priority") @ExcludeMissing fun _priority() = priority

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonProperty("remote_fields") @ExcludeMissing fun _remoteFields() = remoteFields

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Ticket = apply {
        if (!validated) {
            id()
            remoteId()
            name()
            assignees()
            creator()
            dueDate()
            status()
            description()
            project()
            collections()
            ticketType()
            account()
            contact()
            parentTicket()
            attachments()
            tags()
            remoteCreatedAt()
            remoteUpdatedAt()
            completedAt()
            remoteWasDeleted()
            ticketUrl()
            priority()
            modifiedAt()
            remoteData().map { it.forEach { it.validate() } }
            remoteFields().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Ticket &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.name == other.name &&
            this.assignees == other.assignees &&
            this.creator == other.creator &&
            this.dueDate == other.dueDate &&
            this.status == other.status &&
            this.description == other.description &&
            this.project == other.project &&
            this.collections == other.collections &&
            this.ticketType == other.ticketType &&
            this.account == other.account &&
            this.contact == other.contact &&
            this.parentTicket == other.parentTicket &&
            this.attachments == other.attachments &&
            this.tags == other.tags &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.remoteUpdatedAt == other.remoteUpdatedAt &&
            this.completedAt == other.completedAt &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.ticketUrl == other.ticketUrl &&
            this.priority == other.priority &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.remoteFields == other.remoteFields &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    remoteId,
                    name,
                    assignees,
                    creator,
                    dueDate,
                    status,
                    description,
                    project,
                    collections,
                    ticketType,
                    account,
                    contact,
                    parentTicket,
                    attachments,
                    tags,
                    remoteCreatedAt,
                    remoteUpdatedAt,
                    completedAt,
                    remoteWasDeleted,
                    ticketUrl,
                    priority,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    remoteFields,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Ticket{id=$id, remoteId=$remoteId, name=$name, assignees=$assignees, creator=$creator, dueDate=$dueDate, status=$status, description=$description, project=$project, collections=$collections, ticketType=$ticketType, account=$account, contact=$contact, parentTicket=$parentTicket, attachments=$attachments, tags=$tags, remoteCreatedAt=$remoteCreatedAt, remoteUpdatedAt=$remoteUpdatedAt, completedAt=$completedAt, remoteWasDeleted=$remoteWasDeleted, ticketUrl=$ticketUrl, priority=$priority, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, remoteFields=$remoteFields, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var assignees: JsonField<List<String>> = JsonMissing.of()
        private var creator: JsonField<String> = JsonMissing.of()
        private var dueDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var status: JsonField<TicketStatusEnum> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var project: JsonField<String> = JsonMissing.of()
        private var collections: JsonField<List<String>> = JsonMissing.of()
        private var ticketType: JsonField<String> = JsonMissing.of()
        private var account: JsonField<String> = JsonMissing.of()
        private var contact: JsonField<String> = JsonMissing.of()
        private var parentTicket: JsonField<String> = JsonMissing.of()
        private var attachments: JsonField<List<String>> = JsonMissing.of()
        private var tags: JsonField<List<String>> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteUpdatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var completedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var ticketUrl: JsonField<String> = JsonMissing.of()
        private var priority: JsonField<PriorityEnum> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var remoteFields: JsonField<List<RemoteField>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(ticket: Ticket) = apply {
            this.id = ticket.id
            this.remoteId = ticket.remoteId
            this.name = ticket.name
            this.assignees = ticket.assignees
            this.creator = ticket.creator
            this.dueDate = ticket.dueDate
            this.status = ticket.status
            this.description = ticket.description
            this.project = ticket.project
            this.collections = ticket.collections
            this.ticketType = ticket.ticketType
            this.account = ticket.account
            this.contact = ticket.contact
            this.parentTicket = ticket.parentTicket
            this.attachments = ticket.attachments
            this.tags = ticket.tags
            this.remoteCreatedAt = ticket.remoteCreatedAt
            this.remoteUpdatedAt = ticket.remoteUpdatedAt
            this.completedAt = ticket.completedAt
            this.remoteWasDeleted = ticket.remoteWasDeleted
            this.ticketUrl = ticket.ticketUrl
            this.priority = ticket.priority
            this.fieldMappings = ticket.fieldMappings
            this.modifiedAt = ticket.modifiedAt
            this.remoteData = ticket.remoteData
            this.remoteFields = ticket.remoteFields
            additionalProperties(ticket.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The ticket's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The ticket's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun assignees(assignees: List<String>) = assignees(JsonField.of(assignees))

        @JsonProperty("assignees")
        @ExcludeMissing
        fun assignees(assignees: JsonField<List<String>>) = apply { this.assignees = assignees }

        /** The user who created this ticket. */
        fun creator(creator: String) = creator(JsonField.of(creator))

        /** The user who created this ticket. */
        @JsonProperty("creator")
        @ExcludeMissing
        fun creator(creator: JsonField<String>) = apply { this.creator = creator }

        /** The ticket's due date. */
        fun dueDate(dueDate: OffsetDateTime) = dueDate(JsonField.of(dueDate))

        /** The ticket's due date. */
        @JsonProperty("due_date")
        @ExcludeMissing
        fun dueDate(dueDate: JsonField<OffsetDateTime>) = apply { this.dueDate = dueDate }

        /**
         * - `OPEN` - OPEN
         * - `CLOSED` - CLOSED
         * - `IN_PROGRESS` - IN_PROGRESS
         * - `ON_HOLD` - ON_HOLD
         */
        fun status(status: TicketStatusEnum) = status(JsonField.of(status))

        /**
         * - `OPEN` - OPEN
         * - `CLOSED` - CLOSED
         * - `IN_PROGRESS` - IN_PROGRESS
         * - `ON_HOLD` - ON_HOLD
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<TicketStatusEnum>) = apply { this.status = status }

        /**
         * The ticket’s description. HTML version of description is mapped if supported by the
         * third-party platform.
         */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * The ticket’s description. HTML version of description is mapped if supported by the
         * third-party platform.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** The project the ticket belongs to. */
        fun project(project: String) = project(JsonField.of(project))

        /** The project the ticket belongs to. */
        @JsonProperty("project")
        @ExcludeMissing
        fun project(project: JsonField<String>) = apply { this.project = project }

        fun collections(collections: List<String>) = collections(JsonField.of(collections))

        @JsonProperty("collections")
        @ExcludeMissing
        fun collections(collections: JsonField<List<String>>) = apply {
            this.collections = collections
        }

        /** The ticket's type. */
        fun ticketType(ticketType: String) = ticketType(JsonField.of(ticketType))

        /** The ticket's type. */
        @JsonProperty("ticket_type")
        @ExcludeMissing
        fun ticketType(ticketType: JsonField<String>) = apply { this.ticketType = ticketType }

        /** The account associated with the ticket. */
        fun account(account: String) = account(JsonField.of(account))

        /** The account associated with the ticket. */
        @JsonProperty("account")
        @ExcludeMissing
        fun account(account: JsonField<String>) = apply { this.account = account }

        /** The contact associated with the ticket. */
        fun contact(contact: String) = contact(JsonField.of(contact))

        /** The contact associated with the ticket. */
        @JsonProperty("contact")
        @ExcludeMissing
        fun contact(contact: JsonField<String>) = apply { this.contact = contact }

        /** The ticket's parent ticket. */
        fun parentTicket(parentTicket: String) = parentTicket(JsonField.of(parentTicket))

        /** The ticket's parent ticket. */
        @JsonProperty("parent_ticket")
        @ExcludeMissing
        fun parentTicket(parentTicket: JsonField<String>) = apply {
            this.parentTicket = parentTicket
        }

        fun attachments(attachments: List<String>) = attachments(JsonField.of(attachments))

        @JsonProperty("attachments")
        @ExcludeMissing
        fun attachments(attachments: JsonField<List<String>>) = apply {
            this.attachments = attachments
        }

        fun tags(tags: List<String>) = tags(JsonField.of(tags))

        @JsonProperty("tags")
        @ExcludeMissing
        fun tags(tags: JsonField<List<String>>) = apply { this.tags = tags }

        /** When the third party's ticket was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's ticket was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** When the third party's ticket was updated. */
        fun remoteUpdatedAt(remoteUpdatedAt: OffsetDateTime) =
            remoteUpdatedAt(JsonField.of(remoteUpdatedAt))

        /** When the third party's ticket was updated. */
        @JsonProperty("remote_updated_at")
        @ExcludeMissing
        fun remoteUpdatedAt(remoteUpdatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteUpdatedAt = remoteUpdatedAt
        }

        /** When the ticket was completed. */
        fun completedAt(completedAt: OffsetDateTime) = completedAt(JsonField.of(completedAt))

        /** When the ticket was completed. */
        @JsonProperty("completed_at")
        @ExcludeMissing
        fun completedAt(completedAt: JsonField<OffsetDateTime>) = apply {
            this.completedAt = completedAt
        }

        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

        @JsonProperty("remote_was_deleted")
        @ExcludeMissing
        fun remoteWasDeleted(remoteWasDeleted: JsonField<Boolean>) = apply {
            this.remoteWasDeleted = remoteWasDeleted
        }

        /** The 3rd party url of the Ticket. */
        fun ticketUrl(ticketUrl: String) = ticketUrl(JsonField.of(ticketUrl))

        /** The 3rd party url of the Ticket. */
        @JsonProperty("ticket_url")
        @ExcludeMissing
        fun ticketUrl(ticketUrl: JsonField<String>) = apply { this.ticketUrl = ticketUrl }

        /**
         * - `URGENT` - URGENT
         * - `HIGH` - HIGH
         * - `NORMAL` - NORMAL
         * - `LOW` - LOW
         */
        fun priority(priority: PriorityEnum) = priority(JsonField.of(priority))

        /**
         * - `URGENT` - URGENT
         * - `HIGH` - HIGH
         * - `NORMAL` - NORMAL
         * - `LOW` - LOW
         */
        @JsonProperty("priority")
        @ExcludeMissing
        fun priority(priority: JsonField<PriorityEnum>) = apply { this.priority = priority }

        @JsonProperty("field_mappings")
        @ExcludeMissing
        fun fieldMappings(fieldMappings: JsonValue) = apply { this.fieldMappings = fieldMappings }

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at")
        @ExcludeMissing
        fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
            this.modifiedAt = modifiedAt
        }

        fun remoteData(remoteData: List<RemoteData>) = remoteData(JsonField.of(remoteData))

        @JsonProperty("remote_data")
        @ExcludeMissing
        fun remoteData(remoteData: JsonField<List<RemoteData>>) = apply {
            this.remoteData = remoteData
        }

        fun remoteFields(remoteFields: List<RemoteField>) = remoteFields(JsonField.of(remoteFields))

        @JsonProperty("remote_fields")
        @ExcludeMissing
        fun remoteFields(remoteFields: JsonField<List<RemoteField>>) = apply {
            this.remoteFields = remoteFields
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): Ticket =
            Ticket(
                id,
                remoteId,
                name,
                assignees.map { it.toUnmodifiable() },
                creator,
                dueDate,
                status,
                description,
                project,
                collections.map { it.toUnmodifiable() },
                ticketType,
                account,
                contact,
                parentTicket,
                attachments.map { it.toUnmodifiable() },
                tags.map { it.toUnmodifiable() },
                remoteCreatedAt,
                remoteUpdatedAt,
                completedAt,
                remoteWasDeleted,
                ticketUrl,
                priority,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                remoteFields.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class TicketStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TicketStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val OPEN = TicketStatusEnum(JsonField.of("OPEN"))

            @JvmField val CLOSED = TicketStatusEnum(JsonField.of("CLOSED"))

            @JvmField val IN_PROGRESS = TicketStatusEnum(JsonField.of("IN_PROGRESS"))

            @JvmField val ON_HOLD = TicketStatusEnum(JsonField.of("ON_HOLD"))

            @JvmStatic fun of(value: String) = TicketStatusEnum(JsonField.of(value))
        }

        enum class Known {
            OPEN,
            CLOSED,
            IN_PROGRESS,
            ON_HOLD,
        }

        enum class Value {
            OPEN,
            CLOSED,
            IN_PROGRESS,
            ON_HOLD,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                OPEN -> Value.OPEN
                CLOSED -> Value.CLOSED
                IN_PROGRESS -> Value.IN_PROGRESS
                ON_HOLD -> Value.ON_HOLD
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                OPEN -> Known.OPEN
                CLOSED -> Known.CLOSED
                IN_PROGRESS -> Known.IN_PROGRESS
                ON_HOLD -> Known.ON_HOLD
                else -> throw MergeInvalidDataException("Unknown TicketStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class PriorityEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PriorityEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val URGENT = PriorityEnum(JsonField.of("URGENT"))

            @JvmField val HIGH = PriorityEnum(JsonField.of("HIGH"))

            @JvmField val NORMAL = PriorityEnum(JsonField.of("NORMAL"))

            @JvmField val LOW = PriorityEnum(JsonField.of("LOW"))

            @JvmStatic fun of(value: String) = PriorityEnum(JsonField.of(value))
        }

        enum class Known {
            URGENT,
            HIGH,
            NORMAL,
            LOW,
        }

        enum class Value {
            URGENT,
            HIGH,
            NORMAL,
            LOW,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                URGENT -> Value.URGENT
                HIGH -> Value.HIGH
                NORMAL -> Value.NORMAL
                LOW -> Value.LOW
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                URGENT -> Known.URGENT
                HIGH -> Known.HIGH
                NORMAL -> Known.NORMAL
                LOW -> Known.LOW
                else -> throw MergeInvalidDataException("Unknown PriorityEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = RemoteField.Builder::class)
    @NoAutoDetect
    class RemoteField
    private constructor(
        private val remoteFieldClass: JsonField<RemoteFieldClass>,
        private val value: JsonValue,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun remoteFieldClass(): RemoteFieldClass =
            remoteFieldClass.getRequired("remote_field_class")

        @JsonProperty("remote_field_class")
        @ExcludeMissing
        fun _remoteFieldClass() = remoteFieldClass

        @JsonProperty("value") @ExcludeMissing fun _value() = value

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): RemoteField = apply {
            if (!validated) {
                remoteFieldClass().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RemoteField &&
                this.remoteFieldClass == other.remoteFieldClass &&
                this.value == other.value &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        remoteFieldClass,
                        value,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "RemoteField{remoteFieldClass=$remoteFieldClass, value=$value, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var remoteFieldClass: JsonField<RemoteFieldClass> = JsonMissing.of()
            private var value: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(remoteField: RemoteField) = apply {
                this.remoteFieldClass = remoteField.remoteFieldClass
                this.value = remoteField.value
                additionalProperties(remoteField.additionalProperties)
            }

            fun remoteFieldClass(remoteFieldClass: RemoteFieldClass) =
                remoteFieldClass(JsonField.of(remoteFieldClass))

            @JsonProperty("remote_field_class")
            @ExcludeMissing
            fun remoteFieldClass(remoteFieldClass: JsonField<RemoteFieldClass>) = apply {
                this.remoteFieldClass = remoteFieldClass
            }

            @JsonProperty("value")
            @ExcludeMissing
            fun value(value: JsonValue) = apply { this.value = value }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): RemoteField =
                RemoteField(
                    remoteFieldClass,
                    value,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
