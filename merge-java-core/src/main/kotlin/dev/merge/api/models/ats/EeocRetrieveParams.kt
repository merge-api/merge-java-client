package dev.merge.api.models.ats

import com.fasterxml.jackson.annotation.JsonCreator
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.util.Objects
import java.util.Optional

class EeocRetrieveParams
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

        return other is EeocRetrieveParams &&
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
        "EeocRetrieveParams{id=$id, expand=$expand, includeRemoteData=$includeRemoteData, remoteFields=$remoteFields, showEnumOrigins=$showEnumOrigins, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

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
        internal fun from(eeocRetrieveParams: EeocRetrieveParams) = apply {
            this.id = eeocRetrieveParams.id
            this.expand = eeocRetrieveParams.expand
            this.includeRemoteData = eeocRetrieveParams.includeRemoteData
            this.remoteFields = eeocRetrieveParams.remoteFields
            this.showEnumOrigins = eeocRetrieveParams.showEnumOrigins
            additionalQueryParams(eeocRetrieveParams.additionalQueryParams)
            additionalHeaders(eeocRetrieveParams.additionalHeaders)
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

        fun build(): EeocRetrieveParams =
            EeocRetrieveParams(
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

            @JvmField val CANDIDATE = Expand(JsonField.of("candidate"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            CANDIDATE,
        }

        enum class Value {
            CANDIDATE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CANDIDATE -> Value.CANDIDATE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CANDIDATE -> Known.CANDIDATE
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

            @JvmField val DISABILITY_STATUS = RemoteFields(JsonField.of("disability_status"))

            @JvmField
            val DISABILITY_STATUS_GENDER = RemoteFields(JsonField.of("disability_status,gender"))

            @JvmField
            val DISABILITY_STATUS_GENDER_RACE =
                RemoteFields(JsonField.of("disability_status,gender,race"))

            @JvmField
            val DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS =
                RemoteFields(JsonField.of("disability_status,gender,race,veteran_status"))

            @JvmField
            val DISABILITY_STATUS_GENDER_VETERAN_STATUS =
                RemoteFields(JsonField.of("disability_status,gender,veteran_status"))

            @JvmField
            val DISABILITY_STATUS_RACE = RemoteFields(JsonField.of("disability_status,race"))

            @JvmField
            val DISABILITY_STATUS_RACE_VETERAN_STATUS =
                RemoteFields(JsonField.of("disability_status,race,veteran_status"))

            @JvmField
            val DISABILITY_STATUS_VETERAN_STATUS =
                RemoteFields(JsonField.of("disability_status,veteran_status"))

            @JvmField val GENDER = RemoteFields(JsonField.of("gender"))

            @JvmField val GENDER_RACE = RemoteFields(JsonField.of("gender,race"))

            @JvmField
            val GENDER_RACE_VETERAN_STATUS =
                RemoteFields(JsonField.of("gender,race,veteran_status"))

            @JvmField
            val GENDER_VETERAN_STATUS = RemoteFields(JsonField.of("gender,veteran_status"))

            @JvmField val RACE = RemoteFields(JsonField.of("race"))

            @JvmField val RACE_VETERAN_STATUS = RemoteFields(JsonField.of("race,veteran_status"))

            @JvmField val VETERAN_STATUS = RemoteFields(JsonField.of("veteran_status"))

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            DISABILITY_STATUS,
            DISABILITY_STATUS_GENDER,
            DISABILITY_STATUS_GENDER_RACE,
            DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS,
            DISABILITY_STATUS_GENDER_VETERAN_STATUS,
            DISABILITY_STATUS_RACE,
            DISABILITY_STATUS_RACE_VETERAN_STATUS,
            DISABILITY_STATUS_VETERAN_STATUS,
            GENDER,
            GENDER_RACE,
            GENDER_RACE_VETERAN_STATUS,
            GENDER_VETERAN_STATUS,
            RACE,
            RACE_VETERAN_STATUS,
            VETERAN_STATUS,
        }

        enum class Value {
            DISABILITY_STATUS,
            DISABILITY_STATUS_GENDER,
            DISABILITY_STATUS_GENDER_RACE,
            DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS,
            DISABILITY_STATUS_GENDER_VETERAN_STATUS,
            DISABILITY_STATUS_RACE,
            DISABILITY_STATUS_RACE_VETERAN_STATUS,
            DISABILITY_STATUS_VETERAN_STATUS,
            GENDER,
            GENDER_RACE,
            GENDER_RACE_VETERAN_STATUS,
            GENDER_VETERAN_STATUS,
            RACE,
            RACE_VETERAN_STATUS,
            VETERAN_STATUS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                DISABILITY_STATUS -> Value.DISABILITY_STATUS
                DISABILITY_STATUS_GENDER -> Value.DISABILITY_STATUS_GENDER
                DISABILITY_STATUS_GENDER_RACE -> Value.DISABILITY_STATUS_GENDER_RACE
                DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS ->
                    Value.DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS
                DISABILITY_STATUS_GENDER_VETERAN_STATUS ->
                    Value.DISABILITY_STATUS_GENDER_VETERAN_STATUS
                DISABILITY_STATUS_RACE -> Value.DISABILITY_STATUS_RACE
                DISABILITY_STATUS_RACE_VETERAN_STATUS -> Value.DISABILITY_STATUS_RACE_VETERAN_STATUS
                DISABILITY_STATUS_VETERAN_STATUS -> Value.DISABILITY_STATUS_VETERAN_STATUS
                GENDER -> Value.GENDER
                GENDER_RACE -> Value.GENDER_RACE
                GENDER_RACE_VETERAN_STATUS -> Value.GENDER_RACE_VETERAN_STATUS
                GENDER_VETERAN_STATUS -> Value.GENDER_VETERAN_STATUS
                RACE -> Value.RACE
                RACE_VETERAN_STATUS -> Value.RACE_VETERAN_STATUS
                VETERAN_STATUS -> Value.VETERAN_STATUS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                DISABILITY_STATUS -> Known.DISABILITY_STATUS
                DISABILITY_STATUS_GENDER -> Known.DISABILITY_STATUS_GENDER
                DISABILITY_STATUS_GENDER_RACE -> Known.DISABILITY_STATUS_GENDER_RACE
                DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS ->
                    Known.DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS
                DISABILITY_STATUS_GENDER_VETERAN_STATUS ->
                    Known.DISABILITY_STATUS_GENDER_VETERAN_STATUS
                DISABILITY_STATUS_RACE -> Known.DISABILITY_STATUS_RACE
                DISABILITY_STATUS_RACE_VETERAN_STATUS -> Known.DISABILITY_STATUS_RACE_VETERAN_STATUS
                DISABILITY_STATUS_VETERAN_STATUS -> Known.DISABILITY_STATUS_VETERAN_STATUS
                GENDER -> Known.GENDER
                GENDER_RACE -> Known.GENDER_RACE
                GENDER_RACE_VETERAN_STATUS -> Known.GENDER_RACE_VETERAN_STATUS
                GENDER_VETERAN_STATUS -> Known.GENDER_VETERAN_STATUS
                RACE -> Known.RACE
                RACE_VETERAN_STATUS -> Known.RACE_VETERAN_STATUS
                VETERAN_STATUS -> Known.VETERAN_STATUS
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

            @JvmField val DISABILITY_STATUS = ShowEnumOrigins(JsonField.of("disability_status"))

            @JvmField
            val DISABILITY_STATUS_GENDER = ShowEnumOrigins(JsonField.of("disability_status,gender"))

            @JvmField
            val DISABILITY_STATUS_GENDER_RACE =
                ShowEnumOrigins(JsonField.of("disability_status,gender,race"))

            @JvmField
            val DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS =
                ShowEnumOrigins(JsonField.of("disability_status,gender,race,veteran_status"))

            @JvmField
            val DISABILITY_STATUS_GENDER_VETERAN_STATUS =
                ShowEnumOrigins(JsonField.of("disability_status,gender,veteran_status"))

            @JvmField
            val DISABILITY_STATUS_RACE = ShowEnumOrigins(JsonField.of("disability_status,race"))

            @JvmField
            val DISABILITY_STATUS_RACE_VETERAN_STATUS =
                ShowEnumOrigins(JsonField.of("disability_status,race,veteran_status"))

            @JvmField
            val DISABILITY_STATUS_VETERAN_STATUS =
                ShowEnumOrigins(JsonField.of("disability_status,veteran_status"))

            @JvmField val GENDER = ShowEnumOrigins(JsonField.of("gender"))

            @JvmField val GENDER_RACE = ShowEnumOrigins(JsonField.of("gender,race"))

            @JvmField
            val GENDER_RACE_VETERAN_STATUS =
                ShowEnumOrigins(JsonField.of("gender,race,veteran_status"))

            @JvmField
            val GENDER_VETERAN_STATUS = ShowEnumOrigins(JsonField.of("gender,veteran_status"))

            @JvmField val RACE = ShowEnumOrigins(JsonField.of("race"))

            @JvmField val RACE_VETERAN_STATUS = ShowEnumOrigins(JsonField.of("race,veteran_status"))

            @JvmField val VETERAN_STATUS = ShowEnumOrigins(JsonField.of("veteran_status"))

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            DISABILITY_STATUS,
            DISABILITY_STATUS_GENDER,
            DISABILITY_STATUS_GENDER_RACE,
            DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS,
            DISABILITY_STATUS_GENDER_VETERAN_STATUS,
            DISABILITY_STATUS_RACE,
            DISABILITY_STATUS_RACE_VETERAN_STATUS,
            DISABILITY_STATUS_VETERAN_STATUS,
            GENDER,
            GENDER_RACE,
            GENDER_RACE_VETERAN_STATUS,
            GENDER_VETERAN_STATUS,
            RACE,
            RACE_VETERAN_STATUS,
            VETERAN_STATUS,
        }

        enum class Value {
            DISABILITY_STATUS,
            DISABILITY_STATUS_GENDER,
            DISABILITY_STATUS_GENDER_RACE,
            DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS,
            DISABILITY_STATUS_GENDER_VETERAN_STATUS,
            DISABILITY_STATUS_RACE,
            DISABILITY_STATUS_RACE_VETERAN_STATUS,
            DISABILITY_STATUS_VETERAN_STATUS,
            GENDER,
            GENDER_RACE,
            GENDER_RACE_VETERAN_STATUS,
            GENDER_VETERAN_STATUS,
            RACE,
            RACE_VETERAN_STATUS,
            VETERAN_STATUS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                DISABILITY_STATUS -> Value.DISABILITY_STATUS
                DISABILITY_STATUS_GENDER -> Value.DISABILITY_STATUS_GENDER
                DISABILITY_STATUS_GENDER_RACE -> Value.DISABILITY_STATUS_GENDER_RACE
                DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS ->
                    Value.DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS
                DISABILITY_STATUS_GENDER_VETERAN_STATUS ->
                    Value.DISABILITY_STATUS_GENDER_VETERAN_STATUS
                DISABILITY_STATUS_RACE -> Value.DISABILITY_STATUS_RACE
                DISABILITY_STATUS_RACE_VETERAN_STATUS -> Value.DISABILITY_STATUS_RACE_VETERAN_STATUS
                DISABILITY_STATUS_VETERAN_STATUS -> Value.DISABILITY_STATUS_VETERAN_STATUS
                GENDER -> Value.GENDER
                GENDER_RACE -> Value.GENDER_RACE
                GENDER_RACE_VETERAN_STATUS -> Value.GENDER_RACE_VETERAN_STATUS
                GENDER_VETERAN_STATUS -> Value.GENDER_VETERAN_STATUS
                RACE -> Value.RACE
                RACE_VETERAN_STATUS -> Value.RACE_VETERAN_STATUS
                VETERAN_STATUS -> Value.VETERAN_STATUS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                DISABILITY_STATUS -> Known.DISABILITY_STATUS
                DISABILITY_STATUS_GENDER -> Known.DISABILITY_STATUS_GENDER
                DISABILITY_STATUS_GENDER_RACE -> Known.DISABILITY_STATUS_GENDER_RACE
                DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS ->
                    Known.DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS
                DISABILITY_STATUS_GENDER_VETERAN_STATUS ->
                    Known.DISABILITY_STATUS_GENDER_VETERAN_STATUS
                DISABILITY_STATUS_RACE -> Known.DISABILITY_STATUS_RACE
                DISABILITY_STATUS_RACE_VETERAN_STATUS -> Known.DISABILITY_STATUS_RACE_VETERAN_STATUS
                DISABILITY_STATUS_VETERAN_STATUS -> Known.DISABILITY_STATUS_VETERAN_STATUS
                GENDER -> Known.GENDER
                GENDER_RACE -> Known.GENDER_RACE
                GENDER_RACE_VETERAN_STATUS -> Known.GENDER_RACE_VETERAN_STATUS
                GENDER_VETERAN_STATUS -> Known.GENDER_VETERAN_STATUS
                RACE -> Known.RACE
                RACE_VETERAN_STATUS -> Known.RACE_VETERAN_STATUS
                VETERAN_STATUS -> Known.VETERAN_STATUS
                else -> throw MergeInvalidDataException("Unknown ShowEnumOrigins: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
