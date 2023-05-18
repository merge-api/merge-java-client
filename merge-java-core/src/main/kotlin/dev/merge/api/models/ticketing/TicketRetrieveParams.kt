package dev.merge.api.models.ticketing

import com.fasterxml.jackson.annotation.JsonCreator
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.util.Objects
import java.util.Optional

class TicketRetrieveParams
constructor(
    private val id: String,
    private val expand: List<Expand>?,
    private val includeRemoteData: Boolean?,
    private val includeRemoteFields: Boolean?,
    private val remoteFields: RemoteFields?,
    private val showEnumOrigins: ShowEnumOrigins?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun id(): String = id

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun includeRemoteFields(): Optional<Boolean> = Optional.ofNullable(includeRemoteFields)

    fun remoteFields(): Optional<RemoteFields> = Optional.ofNullable(remoteFields)

    fun showEnumOrigins(): Optional<ShowEnumOrigins> = Optional.ofNullable(showEnumOrigins)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.includeRemoteFields?.let { params.put("include_remote_fields", listOf(it.toString())) }
        this.remoteFields?.let { params.put("remote_fields", listOf(it.toString())) }
        this.showEnumOrigins?.let { params.put("show_enum_origins", listOf(it.toString())) }
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

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TicketRetrieveParams &&
            this.id == other.id &&
            this.expand == other.expand &&
            this.includeRemoteData == other.includeRemoteData &&
            this.includeRemoteFields == other.includeRemoteFields &&
            this.remoteFields == other.remoteFields &&
            this.showEnumOrigins == other.showEnumOrigins &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            id,
            expand,
            includeRemoteData,
            includeRemoteFields,
            remoteFields,
            showEnumOrigins,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "TicketRetrieveParams{id=$id, expand=$expand, includeRemoteData=$includeRemoteData, includeRemoteFields=$includeRemoteFields, remoteFields=$remoteFields, showEnumOrigins=$showEnumOrigins, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var expand: List<Expand>? = null
        private var includeRemoteData: Boolean? = null
        private var includeRemoteFields: Boolean? = null
        private var remoteFields: RemoteFields? = null
        private var showEnumOrigins: ShowEnumOrigins? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(ticketRetrieveParams: TicketRetrieveParams) = apply {
            this.id = ticketRetrieveParams.id
            this.expand = ticketRetrieveParams.expand
            this.includeRemoteData = ticketRetrieveParams.includeRemoteData
            this.includeRemoteFields = ticketRetrieveParams.includeRemoteFields
            this.remoteFields = ticketRetrieveParams.remoteFields
            this.showEnumOrigins = ticketRetrieveParams.showEnumOrigins
            additionalQueryParams(ticketRetrieveParams.additionalQueryParams)
            additionalHeaders(ticketRetrieveParams.additionalHeaders)
        }

        fun id(id: String) = apply { this.id = id }

        /**
         * Which relations should be returned in expanded form. Multiple relation names should be
         * comma separated without spaces.
         */
        fun expand(expand: List<Expand>) = apply { this.expand = expand }

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

        /** Deprecated. Use show_enum_origins. */
        fun remoteFields(remoteFields: RemoteFields) = apply { this.remoteFields = remoteFields }

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

        fun build(): TicketRetrieveParams =
            TicketRetrieveParams(
                checkNotNull(id) { "`id` is required but was not set" },
                expand?.toUnmodifiable(),
                includeRemoteData,
                includeRemoteFields,
                remoteFields,
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
}
