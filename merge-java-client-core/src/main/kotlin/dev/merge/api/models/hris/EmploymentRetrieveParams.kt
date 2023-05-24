package dev.merge.api.models.hris

import com.fasterxml.jackson.annotation.JsonCreator
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.util.Objects
import java.util.Optional

class EmploymentRetrieveParams
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

        return other is EmploymentRetrieveParams &&
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
        "EmploymentRetrieveParams{id=$id, expand=$expand, includeRemoteData=$includeRemoteData, remoteFields=$remoteFields, showEnumOrigins=$showEnumOrigins, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

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
        internal fun from(employmentRetrieveParams: EmploymentRetrieveParams) = apply {
            this.id = employmentRetrieveParams.id
            this.expand = employmentRetrieveParams.expand
            this.includeRemoteData = employmentRetrieveParams.includeRemoteData
            this.remoteFields = employmentRetrieveParams.remoteFields
            this.showEnumOrigins = employmentRetrieveParams.showEnumOrigins
            additionalQueryParams(employmentRetrieveParams.additionalQueryParams)
            additionalHeaders(employmentRetrieveParams.additionalHeaders)
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

        fun build(): EmploymentRetrieveParams =
            EmploymentRetrieveParams(
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

            @JvmField val EMPLOYEE = Expand(JsonField.of("employee"))

            @JvmField val PAY_GROUP = Expand(JsonField.of("pay_group"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            EMPLOYEE,
            PAY_GROUP,
        }

        enum class Value {
            EMPLOYEE,
            PAY_GROUP,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMPLOYEE -> Value.EMPLOYEE
                PAY_GROUP -> Value.PAY_GROUP
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMPLOYEE -> Known.EMPLOYEE
                PAY_GROUP -> Known.PAY_GROUP
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

            @JvmField val EMPLOYMENT_TYPE = RemoteFields(JsonField.of("employment_type"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS =
                RemoteFields(JsonField.of("employment_type,flsa_status"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY =
                RemoteFields(JsonField.of("employment_type,flsa_status,pay_frequency"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD =
                RemoteFields(JsonField.of("employment_type,flsa_status,pay_frequency,pay_period"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD =
                RemoteFields(JsonField.of("employment_type,flsa_status,pay_period"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_FREQUENCY =
                RemoteFields(JsonField.of("employment_type,pay_frequency"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD =
                RemoteFields(JsonField.of("employment_type,pay_frequency,pay_period"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_PERIOD =
                RemoteFields(JsonField.of("employment_type,pay_period"))

            @JvmField val FLSA_STATUS = RemoteFields(JsonField.of("flsa_status"))

            @JvmField
            val FLSA_STATUS_PAY_FREQUENCY = RemoteFields(JsonField.of("flsa_status,pay_frequency"))

            @JvmField
            val FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD =
                RemoteFields(JsonField.of("flsa_status,pay_frequency,pay_period"))

            @JvmField
            val FLSA_STATUS_PAY_PERIOD = RemoteFields(JsonField.of("flsa_status,pay_period"))

            @JvmField val PAY_FREQUENCY = RemoteFields(JsonField.of("pay_frequency"))

            @JvmField
            val PAY_FREQUENCY_PAY_PERIOD = RemoteFields(JsonField.of("pay_frequency,pay_period"))

            @JvmField val PAY_PERIOD = RemoteFields(JsonField.of("pay_period"))

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            EMPLOYMENT_TYPE,
            EMPLOYMENT_TYPE_FLSA_STATUS,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_PERIOD,
            FLSA_STATUS,
            FLSA_STATUS_PAY_FREQUENCY,
            FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            FLSA_STATUS_PAY_PERIOD,
            PAY_FREQUENCY,
            PAY_FREQUENCY_PAY_PERIOD,
            PAY_PERIOD,
        }

        enum class Value {
            EMPLOYMENT_TYPE,
            EMPLOYMENT_TYPE_FLSA_STATUS,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_PERIOD,
            FLSA_STATUS,
            FLSA_STATUS_PAY_FREQUENCY,
            FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            FLSA_STATUS_PAY_PERIOD,
            PAY_FREQUENCY,
            PAY_FREQUENCY_PAY_PERIOD,
            PAY_PERIOD,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMPLOYMENT_TYPE -> Value.EMPLOYMENT_TYPE
                EMPLOYMENT_TYPE_FLSA_STATUS -> Value.EMPLOYMENT_TYPE_FLSA_STATUS
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_FREQUENCY -> Value.EMPLOYMENT_TYPE_PAY_FREQUENCY
                EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_PERIOD -> Value.EMPLOYMENT_TYPE_PAY_PERIOD
                FLSA_STATUS -> Value.FLSA_STATUS
                FLSA_STATUS_PAY_FREQUENCY -> Value.FLSA_STATUS_PAY_FREQUENCY
                FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD -> Value.FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                FLSA_STATUS_PAY_PERIOD -> Value.FLSA_STATUS_PAY_PERIOD
                PAY_FREQUENCY -> Value.PAY_FREQUENCY
                PAY_FREQUENCY_PAY_PERIOD -> Value.PAY_FREQUENCY_PAY_PERIOD
                PAY_PERIOD -> Value.PAY_PERIOD
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMPLOYMENT_TYPE -> Known.EMPLOYMENT_TYPE
                EMPLOYMENT_TYPE_FLSA_STATUS -> Known.EMPLOYMENT_TYPE_FLSA_STATUS
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_FREQUENCY -> Known.EMPLOYMENT_TYPE_PAY_FREQUENCY
                EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_PERIOD -> Known.EMPLOYMENT_TYPE_PAY_PERIOD
                FLSA_STATUS -> Known.FLSA_STATUS
                FLSA_STATUS_PAY_FREQUENCY -> Known.FLSA_STATUS_PAY_FREQUENCY
                FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD -> Known.FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                FLSA_STATUS_PAY_PERIOD -> Known.FLSA_STATUS_PAY_PERIOD
                PAY_FREQUENCY -> Known.PAY_FREQUENCY
                PAY_FREQUENCY_PAY_PERIOD -> Known.PAY_FREQUENCY_PAY_PERIOD
                PAY_PERIOD -> Known.PAY_PERIOD
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

            @JvmField val EMPLOYMENT_TYPE = ShowEnumOrigins(JsonField.of("employment_type"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS =
                ShowEnumOrigins(JsonField.of("employment_type,flsa_status"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY =
                ShowEnumOrigins(JsonField.of("employment_type,flsa_status,pay_frequency"))

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD =
                ShowEnumOrigins(
                    JsonField.of("employment_type,flsa_status,pay_frequency,pay_period")
                )

            @JvmField
            val EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD =
                ShowEnumOrigins(JsonField.of("employment_type,flsa_status,pay_period"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_FREQUENCY =
                ShowEnumOrigins(JsonField.of("employment_type,pay_frequency"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD =
                ShowEnumOrigins(JsonField.of("employment_type,pay_frequency,pay_period"))

            @JvmField
            val EMPLOYMENT_TYPE_PAY_PERIOD =
                ShowEnumOrigins(JsonField.of("employment_type,pay_period"))

            @JvmField val FLSA_STATUS = ShowEnumOrigins(JsonField.of("flsa_status"))

            @JvmField
            val FLSA_STATUS_PAY_FREQUENCY =
                ShowEnumOrigins(JsonField.of("flsa_status,pay_frequency"))

            @JvmField
            val FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD =
                ShowEnumOrigins(JsonField.of("flsa_status,pay_frequency,pay_period"))

            @JvmField
            val FLSA_STATUS_PAY_PERIOD = ShowEnumOrigins(JsonField.of("flsa_status,pay_period"))

            @JvmField val PAY_FREQUENCY = ShowEnumOrigins(JsonField.of("pay_frequency"))

            @JvmField
            val PAY_FREQUENCY_PAY_PERIOD = ShowEnumOrigins(JsonField.of("pay_frequency,pay_period"))

            @JvmField val PAY_PERIOD = ShowEnumOrigins(JsonField.of("pay_period"))

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            EMPLOYMENT_TYPE,
            EMPLOYMENT_TYPE_FLSA_STATUS,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_PERIOD,
            FLSA_STATUS,
            FLSA_STATUS_PAY_FREQUENCY,
            FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            FLSA_STATUS_PAY_PERIOD,
            PAY_FREQUENCY,
            PAY_FREQUENCY_PAY_PERIOD,
            PAY_PERIOD,
        }

        enum class Value {
            EMPLOYMENT_TYPE,
            EMPLOYMENT_TYPE_FLSA_STATUS,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_FREQUENCY,
            EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD,
            EMPLOYMENT_TYPE_PAY_PERIOD,
            FLSA_STATUS,
            FLSA_STATUS_PAY_FREQUENCY,
            FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD,
            FLSA_STATUS_PAY_PERIOD,
            PAY_FREQUENCY,
            PAY_FREQUENCY_PAY_PERIOD,
            PAY_PERIOD,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMPLOYMENT_TYPE -> Value.EMPLOYMENT_TYPE
                EMPLOYMENT_TYPE_FLSA_STATUS -> Value.EMPLOYMENT_TYPE_FLSA_STATUS
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_FREQUENCY -> Value.EMPLOYMENT_TYPE_PAY_FREQUENCY
                EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD ->
                    Value.EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_PERIOD -> Value.EMPLOYMENT_TYPE_PAY_PERIOD
                FLSA_STATUS -> Value.FLSA_STATUS
                FLSA_STATUS_PAY_FREQUENCY -> Value.FLSA_STATUS_PAY_FREQUENCY
                FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD -> Value.FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                FLSA_STATUS_PAY_PERIOD -> Value.FLSA_STATUS_PAY_PERIOD
                PAY_FREQUENCY -> Value.PAY_FREQUENCY
                PAY_FREQUENCY_PAY_PERIOD -> Value.PAY_FREQUENCY_PAY_PERIOD
                PAY_PERIOD -> Value.PAY_PERIOD
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMPLOYMENT_TYPE -> Known.EMPLOYMENT_TYPE
                EMPLOYMENT_TYPE_FLSA_STATUS -> Known.EMPLOYMENT_TYPE_FLSA_STATUS
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_FLSA_STATUS_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_FREQUENCY -> Known.EMPLOYMENT_TYPE_PAY_FREQUENCY
                EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD ->
                    Known.EMPLOYMENT_TYPE_PAY_FREQUENCY_PAY_PERIOD
                EMPLOYMENT_TYPE_PAY_PERIOD -> Known.EMPLOYMENT_TYPE_PAY_PERIOD
                FLSA_STATUS -> Known.FLSA_STATUS
                FLSA_STATUS_PAY_FREQUENCY -> Known.FLSA_STATUS_PAY_FREQUENCY
                FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD -> Known.FLSA_STATUS_PAY_FREQUENCY_PAY_PERIOD
                FLSA_STATUS_PAY_PERIOD -> Known.FLSA_STATUS_PAY_PERIOD
                PAY_FREQUENCY -> Known.PAY_FREQUENCY
                PAY_FREQUENCY_PAY_PERIOD -> Known.PAY_FREQUENCY_PAY_PERIOD
                PAY_PERIOD -> Known.PAY_PERIOD
                else -> throw MergeInvalidDataException("Unknown ShowEnumOrigins: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
