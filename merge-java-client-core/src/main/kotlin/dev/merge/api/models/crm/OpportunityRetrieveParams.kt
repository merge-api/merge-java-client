package dev.merge.api.models.crm

import com.fasterxml.jackson.annotation.JsonCreator
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.util.Objects
import java.util.Optional

class OpportunityRetrieveParams
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

        return other is OpportunityRetrieveParams &&
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
        "OpportunityRetrieveParams{id=$id, expand=$expand, includeRemoteData=$includeRemoteData, includeRemoteFields=$includeRemoteFields, remoteFields=$remoteFields, showEnumOrigins=$showEnumOrigins, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

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
        internal fun from(opportunityRetrieveParams: OpportunityRetrieveParams) = apply {
            this.id = opportunityRetrieveParams.id
            this.expand = opportunityRetrieveParams.expand
            this.includeRemoteData = opportunityRetrieveParams.includeRemoteData
            this.includeRemoteFields = opportunityRetrieveParams.includeRemoteFields
            this.remoteFields = opportunityRetrieveParams.remoteFields
            this.showEnumOrigins = opportunityRetrieveParams.showEnumOrigins
            additionalQueryParams(opportunityRetrieveParams.additionalQueryParams)
            additionalHeaders(opportunityRetrieveParams.additionalHeaders)
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

        fun build(): OpportunityRetrieveParams =
            OpportunityRetrieveParams(
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

            @JvmField val OWNER = Expand(JsonField.of("owner"))

            @JvmField val STAGE = Expand(JsonField.of("stage"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            ACCOUNT,
            OWNER,
            STAGE,
        }

        enum class Value {
            ACCOUNT,
            OWNER,
            STAGE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ACCOUNT -> Value.ACCOUNT
                OWNER -> Value.OWNER
                STAGE -> Value.STAGE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ACCOUNT -> Known.ACCOUNT
                OWNER -> Known.OWNER
                STAGE -> Known.STAGE
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

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            STATUS,
        }

        enum class Value {
            STATUS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STATUS -> Value.STATUS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STATUS -> Known.STATUS
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

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            STATUS,
        }

        enum class Value {
            STATUS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STATUS -> Value.STATUS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STATUS -> Known.STATUS
                else -> throw MergeInvalidDataException("Unknown ShowEnumOrigins: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
