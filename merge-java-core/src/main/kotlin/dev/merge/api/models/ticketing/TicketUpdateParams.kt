package dev.merge.api.models.ticketing

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

class TicketUpdateParams
constructor(
    private val id: String,
    private val model: PatchedTicketRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun id(): String = id

    fun model(): PatchedTicketRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): TicketUpdateBody {
        return TicketUpdateBody(model, additionalBodyProperties)
    }

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.isDebugMode?.let { params.put("is_debug_mode", listOf(it.toString())) }
        this.runAsync?.let { params.put("run_async", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> id
            else -> ""
        }
    }

    @JsonDeserialize(builder = TicketUpdateBody.Builder::class)
    @NoAutoDetect
    class TicketUpdateBody
    internal constructor(
        private val model: PatchedTicketRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

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
        @JsonProperty("model") fun model(): PatchedTicketRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TicketUpdateBody &&
                this.model == other.model &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(model, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "TicketUpdateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: PatchedTicketRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(ticketUpdateBody: TicketUpdateBody) = apply {
                this.model = ticketUpdateBody.model
                additionalProperties(ticketUpdateBody.additionalProperties)
            }

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
            @JsonProperty("model")
            fun model(model: PatchedTicketRequest) = apply { this.model = model }

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

            fun build(): TicketUpdateBody =
                TicketUpdateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    additionalProperties.toUnmodifiable()
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TicketUpdateParams &&
            this.id == other.id &&
            this.model == other.model &&
            this.isDebugMode == other.isDebugMode &&
            this.runAsync == other.runAsync &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            id,
            model,
            isDebugMode,
            runAsync,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "TicketUpdateParams{id=$id, model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var model: PatchedTicketRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(ticketUpdateParams: TicketUpdateParams) = apply {
            this.id = ticketUpdateParams.id
            this.model = ticketUpdateParams.model
            this.isDebugMode = ticketUpdateParams.isDebugMode
            this.runAsync = ticketUpdateParams.runAsync
            additionalQueryParams(ticketUpdateParams.additionalQueryParams)
            additionalHeaders(ticketUpdateParams.additionalHeaders)
            additionalBodyProperties(ticketUpdateParams.additionalBodyProperties)
        }

        fun id(id: String) = apply { this.id = id }

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
        fun model(model: PatchedTicketRequest) = apply { this.model = model }

        /** Whether to include debug fields (such as log file links) in the response. */
        fun isDebugMode(isDebugMode: Boolean) = apply { this.isDebugMode = isDebugMode }

        /** Whether or not third-party updates should be run asynchronously. */
        fun runAsync(runAsync: Boolean) = apply { this.runAsync = runAsync }

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

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): TicketUpdateParams =
            TicketUpdateParams(
                checkNotNull(id) { "`id` is required but was not set" },
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

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
    @JsonDeserialize(builder = PatchedTicketRequest.Builder::class)
    @NoAutoDetect
    class PatchedTicketRequest
    private constructor(
        private val name: String?,
        private val assignees: List<String>?,
        private val creator: String?,
        private val dueDate: OffsetDateTime?,
        private val status: TicketStatusEnum?,
        private val description: String?,
        private val project: String?,
        private val collections: List<String>?,
        private val ticketType: String?,
        private val account: String?,
        private val contact: String?,
        private val parentTicket: String?,
        private val tags: List<String>?,
        private val completedAt: OffsetDateTime?,
        private val ticketUrl: String?,
        private val priority: PriorityEnum?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The ticket's name. */
        @JsonProperty("name") fun name(): String? = name

        @JsonProperty("assignees") fun assignees(): List<String>? = assignees

        /** The user who created this ticket. */
        @JsonProperty("creator") fun creator(): String? = creator

        /** The ticket's due date. */
        @JsonProperty("due_date") fun dueDate(): OffsetDateTime? = dueDate

        /**
         * - `OPEN` - OPEN
         * - `CLOSED` - CLOSED
         * - `IN_PROGRESS` - IN_PROGRESS
         * - `ON_HOLD` - ON_HOLD
         */
        @JsonProperty("status") fun status(): TicketStatusEnum? = status

        /**
         * The ticket’s description. HTML version of description is mapped if supported by the
         * third-party platform.
         */
        @JsonProperty("description") fun description(): String? = description

        /** The project the ticket belongs to. */
        @JsonProperty("project") fun project(): String? = project

        @JsonProperty("collections") fun collections(): List<String>? = collections

        /** The ticket's type. */
        @JsonProperty("ticket_type") fun ticketType(): String? = ticketType

        /** The account associated with the ticket. */
        @JsonProperty("account") fun account(): String? = account

        /** The contact associated with the ticket. */
        @JsonProperty("contact") fun contact(): String? = contact

        /** The ticket's parent ticket. */
        @JsonProperty("parent_ticket") fun parentTicket(): String? = parentTicket

        @JsonProperty("tags") fun tags(): List<String>? = tags

        /** When the ticket was completed. */
        @JsonProperty("completed_at") fun completedAt(): OffsetDateTime? = completedAt

        /** The 3rd party url of the Ticket. */
        @JsonProperty("ticket_url") fun ticketUrl(): String? = ticketUrl

        /**
         * - `URGENT` - URGENT
         * - `HIGH` - HIGH
         * - `NORMAL` - NORMAL
         * - `LOW` - LOW
         */
        @JsonProperty("priority") fun priority(): PriorityEnum? = priority

        @JsonProperty("integration_params") fun integrationParams(): JsonValue? = integrationParams

        @JsonProperty("linked_account_params")
        fun linkedAccountParams(): JsonValue? = linkedAccountParams

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PatchedTicketRequest &&
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
                this.tags == other.tags &&
                this.completedAt == other.completedAt &&
                this.ticketUrl == other.ticketUrl &&
                this.priority == other.priority &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
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
                        tags,
                        completedAt,
                        ticketUrl,
                        priority,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "PatchedTicketRequest{name=$name, assignees=$assignees, creator=$creator, dueDate=$dueDate, status=$status, description=$description, project=$project, collections=$collections, ticketType=$ticketType, account=$account, contact=$contact, parentTicket=$parentTicket, tags=$tags, completedAt=$completedAt, ticketUrl=$ticketUrl, priority=$priority, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var assignees: List<String>? = null
            private var creator: String? = null
            private var dueDate: OffsetDateTime? = null
            private var status: TicketStatusEnum? = null
            private var description: String? = null
            private var project: String? = null
            private var collections: List<String>? = null
            private var ticketType: String? = null
            private var account: String? = null
            private var contact: String? = null
            private var parentTicket: String? = null
            private var tags: List<String>? = null
            private var completedAt: OffsetDateTime? = null
            private var ticketUrl: String? = null
            private var priority: PriorityEnum? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(patchedTicketRequest: PatchedTicketRequest) = apply {
                this.name = patchedTicketRequest.name
                this.assignees = patchedTicketRequest.assignees
                this.creator = patchedTicketRequest.creator
                this.dueDate = patchedTicketRequest.dueDate
                this.status = patchedTicketRequest.status
                this.description = patchedTicketRequest.description
                this.project = patchedTicketRequest.project
                this.collections = patchedTicketRequest.collections
                this.ticketType = patchedTicketRequest.ticketType
                this.account = patchedTicketRequest.account
                this.contact = patchedTicketRequest.contact
                this.parentTicket = patchedTicketRequest.parentTicket
                this.tags = patchedTicketRequest.tags
                this.completedAt = patchedTicketRequest.completedAt
                this.ticketUrl = patchedTicketRequest.ticketUrl
                this.priority = patchedTicketRequest.priority
                this.integrationParams = patchedTicketRequest.integrationParams
                this.linkedAccountParams = patchedTicketRequest.linkedAccountParams
                additionalProperties(patchedTicketRequest.additionalProperties)
            }

            /** The ticket's name. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            @JsonProperty("assignees")
            fun assignees(assignees: List<String>) = apply { this.assignees = assignees }

            /** The user who created this ticket. */
            @JsonProperty("creator") fun creator(creator: String) = apply { this.creator = creator }

            /** The ticket's due date. */
            @JsonProperty("due_date")
            fun dueDate(dueDate: OffsetDateTime) = apply { this.dueDate = dueDate }

            /**
             * - `OPEN` - OPEN
             * - `CLOSED` - CLOSED
             * - `IN_PROGRESS` - IN_PROGRESS
             * - `ON_HOLD` - ON_HOLD
             */
            @JsonProperty("status")
            fun status(status: TicketStatusEnum) = apply { this.status = status }

            /**
             * The ticket’s description. HTML version of description is mapped if supported by the
             * third-party platform.
             */
            @JsonProperty("description")
            fun description(description: String) = apply { this.description = description }

            /** The project the ticket belongs to. */
            @JsonProperty("project") fun project(project: String) = apply { this.project = project }

            @JsonProperty("collections")
            fun collections(collections: List<String>) = apply { this.collections = collections }

            /** The ticket's type. */
            @JsonProperty("ticket_type")
            fun ticketType(ticketType: String) = apply { this.ticketType = ticketType }

            /** The account associated with the ticket. */
            @JsonProperty("account") fun account(account: String) = apply { this.account = account }

            /** The contact associated with the ticket. */
            @JsonProperty("contact") fun contact(contact: String) = apply { this.contact = contact }

            /** The ticket's parent ticket. */
            @JsonProperty("parent_ticket")
            fun parentTicket(parentTicket: String) = apply { this.parentTicket = parentTicket }

            @JsonProperty("tags") fun tags(tags: List<String>) = apply { this.tags = tags }

            /** When the ticket was completed. */
            @JsonProperty("completed_at")
            fun completedAt(completedAt: OffsetDateTime) = apply { this.completedAt = completedAt }

            /** The 3rd party url of the Ticket. */
            @JsonProperty("ticket_url")
            fun ticketUrl(ticketUrl: String) = apply { this.ticketUrl = ticketUrl }

            /**
             * - `URGENT` - URGENT
             * - `HIGH` - HIGH
             * - `NORMAL` - NORMAL
             * - `LOW` - LOW
             */
            @JsonProperty("priority")
            fun priority(priority: PriorityEnum) = apply { this.priority = priority }

            @JsonProperty("integration_params")
            fun integrationParams(integrationParams: JsonValue) = apply {
                this.integrationParams = integrationParams
            }

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                this.linkedAccountParams = linkedAccountParams
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

            fun build(): PatchedTicketRequest =
                PatchedTicketRequest(
                    name,
                    assignees?.toUnmodifiable(),
                    creator,
                    dueDate,
                    status,
                    description,
                    project,
                    collections?.toUnmodifiable(),
                    ticketType,
                    account,
                    contact,
                    parentTicket,
                    tags?.toUnmodifiable(),
                    completedAt,
                    ticketUrl,
                    priority,
                    integrationParams,
                    linkedAccountParams,
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
    }
}
