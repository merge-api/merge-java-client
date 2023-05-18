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

class EmployeeRetrieveParams
constructor(
    private val id: String,
    private val expand: List<Expand>?,
    private val includeRemoteData: Boolean?,
    private val includeSensitiveFields: Boolean?,
    private val remoteFields: RemoteFields?,
    private val showEnumOrigins: ShowEnumOrigins?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun id(): String = id

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun includeSensitiveFields(): Optional<Boolean> = Optional.ofNullable(includeSensitiveFields)

    fun remoteFields(): Optional<RemoteFields> = Optional.ofNullable(remoteFields)

    fun showEnumOrigins(): Optional<ShowEnumOrigins> = Optional.ofNullable(showEnumOrigins)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.includeSensitiveFields?.let {
            params.put("include_sensitive_fields", listOf(it.toString()))
        }
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

        return other is EmployeeRetrieveParams &&
            this.id == other.id &&
            this.expand == other.expand &&
            this.includeRemoteData == other.includeRemoteData &&
            this.includeSensitiveFields == other.includeSensitiveFields &&
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
            includeSensitiveFields,
            remoteFields,
            showEnumOrigins,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "EmployeeRetrieveParams{id=$id, expand=$expand, includeRemoteData=$includeRemoteData, includeSensitiveFields=$includeSensitiveFields, remoteFields=$remoteFields, showEnumOrigins=$showEnumOrigins, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var expand: List<Expand>? = null
        private var includeRemoteData: Boolean? = null
        private var includeSensitiveFields: Boolean? = null
        private var remoteFields: RemoteFields? = null
        private var showEnumOrigins: ShowEnumOrigins? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(employeeRetrieveParams: EmployeeRetrieveParams) = apply {
            this.id = employeeRetrieveParams.id
            this.expand = employeeRetrieveParams.expand
            this.includeRemoteData = employeeRetrieveParams.includeRemoteData
            this.includeSensitiveFields = employeeRetrieveParams.includeSensitiveFields
            this.remoteFields = employeeRetrieveParams.remoteFields
            this.showEnumOrigins = employeeRetrieveParams.showEnumOrigins
            additionalQueryParams(employeeRetrieveParams.additionalQueryParams)
            additionalHeaders(employeeRetrieveParams.additionalHeaders)
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
         * Whether to include sensitive fields (such as social security numbers) in the response.
         */
        fun includeSensitiveFields(includeSensitiveFields: Boolean) = apply {
            this.includeSensitiveFields = includeSensitiveFields
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

        fun build(): EmployeeRetrieveParams =
            EmployeeRetrieveParams(
                checkNotNull(id) { "`id` is required but was not set" },
                expand?.toUnmodifiable(),
                includeRemoteData,
                includeSensitiveFields,
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

            @JvmField val EMPLOYMENTS = Expand(JsonField.of("employments"))

            @JvmField val GROUPS = Expand(JsonField.of("groups"))

            @JvmField val HOME_LOCATION = Expand(JsonField.of("home_location"))

            @JvmField val MANAGER = Expand(JsonField.of("manager"))

            @JvmField val PAY_GROUP = Expand(JsonField.of("pay_group"))

            @JvmField val TEAM = Expand(JsonField.of("team"))

            @JvmField val WORK_LOCATION = Expand(JsonField.of("work_location"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            COMPANY,
            EMPLOYMENTS,
            GROUPS,
            HOME_LOCATION,
            MANAGER,
            PAY_GROUP,
            TEAM,
            WORK_LOCATION,
        }

        enum class Value {
            COMPANY,
            EMPLOYMENTS,
            GROUPS,
            HOME_LOCATION,
            MANAGER,
            PAY_GROUP,
            TEAM,
            WORK_LOCATION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                COMPANY -> Value.COMPANY
                EMPLOYMENTS -> Value.EMPLOYMENTS
                GROUPS -> Value.GROUPS
                HOME_LOCATION -> Value.HOME_LOCATION
                MANAGER -> Value.MANAGER
                PAY_GROUP -> Value.PAY_GROUP
                TEAM -> Value.TEAM
                WORK_LOCATION -> Value.WORK_LOCATION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                COMPANY -> Known.COMPANY
                EMPLOYMENTS -> Known.EMPLOYMENTS
                GROUPS -> Known.GROUPS
                HOME_LOCATION -> Known.HOME_LOCATION
                MANAGER -> Known.MANAGER
                PAY_GROUP -> Known.PAY_GROUP
                TEAM -> Known.TEAM
                WORK_LOCATION -> Known.WORK_LOCATION
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

            @JvmField val EMPLOYMENT_STATUS = RemoteFields(JsonField.of("employment_status"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY =
                RemoteFields(JsonField.of("employment_status,ethnicity"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_GENDER =
                RemoteFields(JsonField.of("employment_status,ethnicity,gender"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS =
                RemoteFields(JsonField.of("employment_status,ethnicity,gender,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS =
                RemoteFields(JsonField.of("employment_status,ethnicity,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_GENDER = RemoteFields(JsonField.of("employment_status,gender"))

            @JvmField
            val EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS =
                RemoteFields(JsonField.of("employment_status,gender,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_MARITAL_STATUS =
                RemoteFields(JsonField.of("employment_status,marital_status"))

            @JvmField val ETHNICITY = RemoteFields(JsonField.of("ethnicity"))

            @JvmField val ETHNICITY_GENDER = RemoteFields(JsonField.of("ethnicity,gender"))

            @JvmField
            val ETHNICITY_GENDER_MARITAL_STATUS =
                RemoteFields(JsonField.of("ethnicity,gender,marital_status"))

            @JvmField
            val ETHNICITY_MARITAL_STATUS = RemoteFields(JsonField.of("ethnicity,marital_status"))

            @JvmField val GENDER = RemoteFields(JsonField.of("gender"))

            @JvmField
            val GENDER_MARITAL_STATUS = RemoteFields(JsonField.of("gender,marital_status"))

            @JvmField val MARITAL_STATUS = RemoteFields(JsonField.of("marital_status"))

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            EMPLOYMENT_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS,
            EMPLOYMENT_STATUS_GENDER,
            EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_MARITAL_STATUS,
            ETHNICITY,
            ETHNICITY_GENDER,
            ETHNICITY_GENDER_MARITAL_STATUS,
            ETHNICITY_MARITAL_STATUS,
            GENDER,
            GENDER_MARITAL_STATUS,
            MARITAL_STATUS,
        }

        enum class Value {
            EMPLOYMENT_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS,
            EMPLOYMENT_STATUS_GENDER,
            EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_MARITAL_STATUS,
            ETHNICITY,
            ETHNICITY_GENDER,
            ETHNICITY_GENDER_MARITAL_STATUS,
            ETHNICITY_MARITAL_STATUS,
            GENDER,
            GENDER_MARITAL_STATUS,
            MARITAL_STATUS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMPLOYMENT_STATUS -> Value.EMPLOYMENT_STATUS
                EMPLOYMENT_STATUS_ETHNICITY -> Value.EMPLOYMENT_STATUS_ETHNICITY
                EMPLOYMENT_STATUS_ETHNICITY_GENDER -> Value.EMPLOYMENT_STATUS_ETHNICITY_GENDER
                EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS
                EMPLOYMENT_STATUS_GENDER -> Value.EMPLOYMENT_STATUS_GENDER
                EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_MARITAL_STATUS -> Value.EMPLOYMENT_STATUS_MARITAL_STATUS
                ETHNICITY -> Value.ETHNICITY
                ETHNICITY_GENDER -> Value.ETHNICITY_GENDER
                ETHNICITY_GENDER_MARITAL_STATUS -> Value.ETHNICITY_GENDER_MARITAL_STATUS
                ETHNICITY_MARITAL_STATUS -> Value.ETHNICITY_MARITAL_STATUS
                GENDER -> Value.GENDER
                GENDER_MARITAL_STATUS -> Value.GENDER_MARITAL_STATUS
                MARITAL_STATUS -> Value.MARITAL_STATUS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMPLOYMENT_STATUS -> Known.EMPLOYMENT_STATUS
                EMPLOYMENT_STATUS_ETHNICITY -> Known.EMPLOYMENT_STATUS_ETHNICITY
                EMPLOYMENT_STATUS_ETHNICITY_GENDER -> Known.EMPLOYMENT_STATUS_ETHNICITY_GENDER
                EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS
                EMPLOYMENT_STATUS_GENDER -> Known.EMPLOYMENT_STATUS_GENDER
                EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_MARITAL_STATUS -> Known.EMPLOYMENT_STATUS_MARITAL_STATUS
                ETHNICITY -> Known.ETHNICITY
                ETHNICITY_GENDER -> Known.ETHNICITY_GENDER
                ETHNICITY_GENDER_MARITAL_STATUS -> Known.ETHNICITY_GENDER_MARITAL_STATUS
                ETHNICITY_MARITAL_STATUS -> Known.ETHNICITY_MARITAL_STATUS
                GENDER -> Known.GENDER
                GENDER_MARITAL_STATUS -> Known.GENDER_MARITAL_STATUS
                MARITAL_STATUS -> Known.MARITAL_STATUS
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

            @JvmField val EMPLOYMENT_STATUS = ShowEnumOrigins(JsonField.of("employment_status"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY =
                ShowEnumOrigins(JsonField.of("employment_status,ethnicity"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_GENDER =
                ShowEnumOrigins(JsonField.of("employment_status,ethnicity,gender"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS =
                ShowEnumOrigins(JsonField.of("employment_status,ethnicity,gender,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS =
                ShowEnumOrigins(JsonField.of("employment_status,ethnicity,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_GENDER = ShowEnumOrigins(JsonField.of("employment_status,gender"))

            @JvmField
            val EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS =
                ShowEnumOrigins(JsonField.of("employment_status,gender,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_MARITAL_STATUS =
                ShowEnumOrigins(JsonField.of("employment_status,marital_status"))

            @JvmField val ETHNICITY = ShowEnumOrigins(JsonField.of("ethnicity"))

            @JvmField val ETHNICITY_GENDER = ShowEnumOrigins(JsonField.of("ethnicity,gender"))

            @JvmField
            val ETHNICITY_GENDER_MARITAL_STATUS =
                ShowEnumOrigins(JsonField.of("ethnicity,gender,marital_status"))

            @JvmField
            val ETHNICITY_MARITAL_STATUS = ShowEnumOrigins(JsonField.of("ethnicity,marital_status"))

            @JvmField val GENDER = ShowEnumOrigins(JsonField.of("gender"))

            @JvmField
            val GENDER_MARITAL_STATUS = ShowEnumOrigins(JsonField.of("gender,marital_status"))

            @JvmField val MARITAL_STATUS = ShowEnumOrigins(JsonField.of("marital_status"))

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            EMPLOYMENT_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS,
            EMPLOYMENT_STATUS_GENDER,
            EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_MARITAL_STATUS,
            ETHNICITY,
            ETHNICITY_GENDER,
            ETHNICITY_GENDER_MARITAL_STATUS,
            ETHNICITY_MARITAL_STATUS,
            GENDER,
            GENDER_MARITAL_STATUS,
            MARITAL_STATUS,
        }

        enum class Value {
            EMPLOYMENT_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS,
            EMPLOYMENT_STATUS_GENDER,
            EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_MARITAL_STATUS,
            ETHNICITY,
            ETHNICITY_GENDER,
            ETHNICITY_GENDER_MARITAL_STATUS,
            ETHNICITY_MARITAL_STATUS,
            GENDER,
            GENDER_MARITAL_STATUS,
            MARITAL_STATUS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMPLOYMENT_STATUS -> Value.EMPLOYMENT_STATUS
                EMPLOYMENT_STATUS_ETHNICITY -> Value.EMPLOYMENT_STATUS_ETHNICITY
                EMPLOYMENT_STATUS_ETHNICITY_GENDER -> Value.EMPLOYMENT_STATUS_ETHNICITY_GENDER
                EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS
                EMPLOYMENT_STATUS_GENDER -> Value.EMPLOYMENT_STATUS_GENDER
                EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_MARITAL_STATUS -> Value.EMPLOYMENT_STATUS_MARITAL_STATUS
                ETHNICITY -> Value.ETHNICITY
                ETHNICITY_GENDER -> Value.ETHNICITY_GENDER
                ETHNICITY_GENDER_MARITAL_STATUS -> Value.ETHNICITY_GENDER_MARITAL_STATUS
                ETHNICITY_MARITAL_STATUS -> Value.ETHNICITY_MARITAL_STATUS
                GENDER -> Value.GENDER
                GENDER_MARITAL_STATUS -> Value.GENDER_MARITAL_STATUS
                MARITAL_STATUS -> Value.MARITAL_STATUS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMPLOYMENT_STATUS -> Known.EMPLOYMENT_STATUS
                EMPLOYMENT_STATUS_ETHNICITY -> Known.EMPLOYMENT_STATUS_ETHNICITY
                EMPLOYMENT_STATUS_ETHNICITY_GENDER -> Known.EMPLOYMENT_STATUS_ETHNICITY_GENDER
                EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS
                EMPLOYMENT_STATUS_GENDER -> Known.EMPLOYMENT_STATUS_GENDER
                EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_MARITAL_STATUS -> Known.EMPLOYMENT_STATUS_MARITAL_STATUS
                ETHNICITY -> Known.ETHNICITY
                ETHNICITY_GENDER -> Known.ETHNICITY_GENDER
                ETHNICITY_GENDER_MARITAL_STATUS -> Known.ETHNICITY_GENDER_MARITAL_STATUS
                ETHNICITY_MARITAL_STATUS -> Known.ETHNICITY_MARITAL_STATUS
                GENDER -> Known.GENDER
                GENDER_MARITAL_STATUS -> Known.GENDER_MARITAL_STATUS
                MARITAL_STATUS -> Known.MARITAL_STATUS
                else -> throw MergeInvalidDataException("Unknown ShowEnumOrigins: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
