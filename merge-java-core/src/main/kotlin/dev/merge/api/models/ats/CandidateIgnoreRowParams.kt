package dev.merge.api.models.ats

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
import java.util.Objects
import java.util.Optional

class CandidateIgnoreRowParams
constructor(
    private val modelId: String,
    private val reason: ReasonEnum,
    private val message: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun modelId(): String = modelId

    fun reason(): ReasonEnum = reason

    fun message(): Optional<String> = Optional.ofNullable(message)

    @JvmSynthetic
    internal fun getBody(): CandidateIgnoreRowBody {
        return CandidateIgnoreRowBody(
            reason,
            message,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> modelId
            else -> ""
        }
    }

    @JsonDeserialize(builder = CandidateIgnoreRowBody.Builder::class)
    @NoAutoDetect
    class CandidateIgnoreRowBody
    internal constructor(
        private val reason: ReasonEnum?,
        private val message: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * - `GENERAL_CUSTOMER_REQUEST` - GENERAL_CUSTOMER_REQUEST
         * - `GDPR` - GDPR
         * - `OTHER` - OTHER
         */
        @JsonProperty("reason") fun reason(): ReasonEnum? = reason

        @JsonProperty("message") fun message(): String? = message

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CandidateIgnoreRowBody &&
                this.reason == other.reason &&
                this.message == other.message &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        reason,
                        message,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CandidateIgnoreRowBody{reason=$reason, message=$message, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var reason: ReasonEnum? = null
            private var message: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(candidateIgnoreRowBody: CandidateIgnoreRowBody) = apply {
                this.reason = candidateIgnoreRowBody.reason
                this.message = candidateIgnoreRowBody.message
                additionalProperties(candidateIgnoreRowBody.additionalProperties)
            }

            /**
             * - `GENERAL_CUSTOMER_REQUEST` - GENERAL_CUSTOMER_REQUEST
             * - `GDPR` - GDPR
             * - `OTHER` - OTHER
             */
            @JsonProperty("reason") fun reason(reason: ReasonEnum) = apply { this.reason = reason }

            @JsonProperty("message") fun message(message: String) = apply { this.message = message }

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

            fun build(): CandidateIgnoreRowBody =
                CandidateIgnoreRowBody(
                    checkNotNull(reason) { "`reason` is required but was not set" },
                    message,
                    additionalProperties.toUnmodifiable(),
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

        return other is CandidateIgnoreRowParams &&
            this.modelId == other.modelId &&
            this.reason == other.reason &&
            this.message == other.message &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            modelId,
            reason,
            message,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "CandidateIgnoreRowParams{modelId=$modelId, reason=$reason, message=$message, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var modelId: String? = null
        private var reason: ReasonEnum? = null
        private var message: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(candidateIgnoreRowParams: CandidateIgnoreRowParams) = apply {
            this.modelId = candidateIgnoreRowParams.modelId
            this.reason = candidateIgnoreRowParams.reason
            this.message = candidateIgnoreRowParams.message
            additionalQueryParams(candidateIgnoreRowParams.additionalQueryParams)
            additionalHeaders(candidateIgnoreRowParams.additionalHeaders)
            additionalBodyProperties(candidateIgnoreRowParams.additionalBodyProperties)
        }

        fun modelId(modelId: String) = apply { this.modelId = modelId }

        /**
         * - `GENERAL_CUSTOMER_REQUEST` - GENERAL_CUSTOMER_REQUEST
         * - `GDPR` - GDPR
         * - `OTHER` - OTHER
         */
        fun reason(reason: ReasonEnum) = apply { this.reason = reason }

        fun message(message: String) = apply { this.message = message }

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

        fun build(): CandidateIgnoreRowParams =
            CandidateIgnoreRowParams(
                checkNotNull(modelId) { "`modelId` is required but was not set" },
                checkNotNull(reason) { "`reason` is required but was not set" },
                message,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    class ReasonEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ReasonEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField
            val GENERAL_CUSTOMER_REQUEST = ReasonEnum(JsonField.of("GENERAL_CUSTOMER_REQUEST"))

            @JvmField val GDPR = ReasonEnum(JsonField.of("GDPR"))

            @JvmField val OTHER = ReasonEnum(JsonField.of("OTHER"))

            @JvmStatic fun of(value: String) = ReasonEnum(JsonField.of(value))
        }

        enum class Known {
            GENERAL_CUSTOMER_REQUEST,
            GDPR,
            OTHER,
        }

        enum class Value {
            GENERAL_CUSTOMER_REQUEST,
            GDPR,
            OTHER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                GENERAL_CUSTOMER_REQUEST -> Value.GENERAL_CUSTOMER_REQUEST
                GDPR -> Value.GDPR
                OTHER -> Value.OTHER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                GENERAL_CUSTOMER_REQUEST -> Known.GENERAL_CUSTOMER_REQUEST
                GDPR -> Known.GDPR
                OTHER -> Known.OTHER
                else -> throw MergeInvalidDataException("Unknown ReasonEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
