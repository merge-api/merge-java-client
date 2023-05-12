package dev.merge.api.models.accounting

import com.fasterxml.jackson.annotation.JsonCreator
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.util.Objects
import java.util.Optional

class InvoiceRetrieveParams
constructor(
    private val id: String,
    private val expand: List<Expand>?,
    private val includeRemoteData: Boolean?,
    private val remoteFields: RemoteFields?,
    private val showEnumOrigins: ShowEnumOrigins?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun id(): String = id

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun remoteFields(): Optional<RemoteFields> = Optional.ofNullable(remoteFields)

    fun showEnumOrigins(): Optional<ShowEnumOrigins> = Optional.ofNullable(showEnumOrigins)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
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

        return other is InvoiceRetrieveParams &&
            this.id == other.id &&
            this.expand == other.expand &&
            this.includeRemoteData == other.includeRemoteData &&
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
            remoteFields,
            showEnumOrigins,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "InvoiceRetrieveParams{id=$id, expand=$expand, includeRemoteData=$includeRemoteData, remoteFields=$remoteFields, showEnumOrigins=$showEnumOrigins, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var expand: List<Expand>? = null
        private var includeRemoteData: Boolean? = null
        private var remoteFields: RemoteFields? = null
        private var showEnumOrigins: ShowEnumOrigins? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(invoiceRetrieveParams: InvoiceRetrieveParams) = apply {
            this.id = invoiceRetrieveParams.id
            this.expand = invoiceRetrieveParams.expand
            this.includeRemoteData = invoiceRetrieveParams.includeRemoteData
            this.remoteFields = invoiceRetrieveParams.remoteFields
            this.showEnumOrigins = invoiceRetrieveParams.showEnumOrigins
            additionalQueryParams(invoiceRetrieveParams.additionalQueryParams)
            additionalHeaders(invoiceRetrieveParams.additionalHeaders)
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

        fun build(): InvoiceRetrieveParams =
            InvoiceRetrieveParams(
                checkNotNull(id) { "`id` is required but was not set" },
                expand?.toUnmodifiable(),
                includeRemoteData,
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

            @JvmField val COMPANY = Expand(JsonField.of("company"))

            @JvmField val CONTACT = Expand(JsonField.of("contact"))

            @JvmField val LINE_ITEMS = Expand(JsonField.of("line_items"))

            @JvmField val PAYMENTS = Expand(JsonField.of("payments"))

            @JvmField val TRACKING_CATEGORIES = Expand(JsonField.of("tracking_categories"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            COMPANY,
            CONTACT,
            LINE_ITEMS,
            PAYMENTS,
            TRACKING_CATEGORIES,
        }

        enum class Value {
            COMPANY,
            CONTACT,
            LINE_ITEMS,
            PAYMENTS,
            TRACKING_CATEGORIES,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                COMPANY -> Value.COMPANY
                CONTACT -> Value.CONTACT
                LINE_ITEMS -> Value.LINE_ITEMS
                PAYMENTS -> Value.PAYMENTS
                TRACKING_CATEGORIES -> Value.TRACKING_CATEGORIES
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                COMPANY -> Known.COMPANY
                CONTACT -> Known.CONTACT
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
