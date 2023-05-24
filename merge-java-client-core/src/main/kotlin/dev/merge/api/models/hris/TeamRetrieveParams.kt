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

class TeamRetrieveParams
constructor(
    private val id: String,
    private val expand: List<Expand>?,
    private val includeRemoteData: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun id(): String = id

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
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

        return other is TeamRetrieveParams &&
            this.id == other.id &&
            this.expand == other.expand &&
            this.includeRemoteData == other.includeRemoteData &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            id,
            expand,
            includeRemoteData,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "TeamRetrieveParams{id=$id, expand=$expand, includeRemoteData=$includeRemoteData, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var expand: List<Expand>? = null
        private var includeRemoteData: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(teamRetrieveParams: TeamRetrieveParams) = apply {
            this.id = teamRetrieveParams.id
            this.expand = teamRetrieveParams.expand
            this.includeRemoteData = teamRetrieveParams.includeRemoteData
            additionalQueryParams(teamRetrieveParams.additionalQueryParams)
            additionalHeaders(teamRetrieveParams.additionalHeaders)
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

        fun build(): TeamRetrieveParams =
            TeamRetrieveParams(
                checkNotNull(id) { "`id` is required but was not set" },
                expand?.toUnmodifiable(),
                includeRemoteData,
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

            @JvmField val PARENT_TEAM = Expand(JsonField.of("parent_team"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            PARENT_TEAM,
        }

        enum class Value {
            PARENT_TEAM,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                PARENT_TEAM -> Value.PARENT_TEAM
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                PARENT_TEAM -> Known.PARENT_TEAM
                else -> throw MergeInvalidDataException("Unknown Expand: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
