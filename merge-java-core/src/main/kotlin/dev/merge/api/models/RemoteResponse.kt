package dev.merge.api.models

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
import java.util.Objects
import java.util.Optional

/**
 * # The RemoteResponse Object
 *
 * ### Description
 *
 * The `RemoteResponse` object is used to represent information returned from a third-party
 * endpoint.
 *
 * ### Usage Example
 *
 * View the `RemoteResponse` returned from your `DataPassthrough`.
 */
@JsonDeserialize(builder = RemoteResponse.Builder::class)
@NoAutoDetect
class RemoteResponse
private constructor(
    private val method: JsonField<String>,
    private val path: JsonField<String>,
    private val status: JsonField<Long>,
    private val response: JsonValue,
    private val responseHeaders: JsonValue,
    private val responseType: JsonField<ResponseTypeEnum>,
    private val headers: JsonValue,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun method(): String = method.getRequired("method")

    fun path(): String = path.getRequired("path")

    fun status(): Long = status.getRequired("status")

    /**
     * - `JSON` - JSON
     * - `BASE64_GZIP` - BASE64_GZIP
     */
    fun responseType(): Optional<ResponseTypeEnum> =
        Optional.ofNullable(responseType.getNullable("response_type"))

    @JsonProperty("method") @ExcludeMissing fun _method() = method

    @JsonProperty("path") @ExcludeMissing fun _path() = path

    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("response") @ExcludeMissing fun _response() = response

    @JsonProperty("response_headers") @ExcludeMissing fun _responseHeaders() = responseHeaders

    /**
     * - `JSON` - JSON
     * - `BASE64_GZIP` - BASE64_GZIP
     */
    @JsonProperty("response_type") @ExcludeMissing fun _responseType() = responseType

    @JsonProperty("headers") @ExcludeMissing fun _headers() = headers

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            method()
            path()
            status()
            responseType()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RemoteResponse &&
            this.method == other.method &&
            this.path == other.path &&
            this.status == other.status &&
            this.response == other.response &&
            this.responseHeaders == other.responseHeaders &&
            this.responseType == other.responseType &&
            this.headers == other.headers &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    method,
                    path,
                    status,
                    response,
                    responseHeaders,
                    responseType,
                    headers,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "RemoteResponse{method=$method, path=$path, status=$status, response=$response, responseHeaders=$responseHeaders, responseType=$responseType, headers=$headers, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var method: JsonField<String> = JsonMissing.of()
        private var path: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Long> = JsonMissing.of()
        private var response: JsonValue = JsonMissing.of()
        private var responseHeaders: JsonValue = JsonMissing.of()
        private var responseType: JsonField<ResponseTypeEnum> = JsonMissing.of()
        private var headers: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(remoteResponse: RemoteResponse) = apply {
            this.method = remoteResponse.method
            this.path = remoteResponse.path
            this.status = remoteResponse.status
            this.response = remoteResponse.response
            this.responseHeaders = remoteResponse.responseHeaders
            this.responseType = remoteResponse.responseType
            this.headers = remoteResponse.headers
            additionalProperties(remoteResponse.additionalProperties)
        }

        fun method(method: String) = method(JsonField.of(method))

        @JsonProperty("method")
        @ExcludeMissing
        fun method(method: JsonField<String>) = apply { this.method = method }

        fun path(path: String) = path(JsonField.of(path))

        @JsonProperty("path")
        @ExcludeMissing
        fun path(path: JsonField<String>) = apply { this.path = path }

        fun status(status: Long) = status(JsonField.of(status))

        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Long>) = apply { this.status = status }

        @JsonProperty("response")
        @ExcludeMissing
        fun response(response: JsonValue) = apply { this.response = response }

        @JsonProperty("response_headers")
        @ExcludeMissing
        fun responseHeaders(responseHeaders: JsonValue) = apply {
            this.responseHeaders = responseHeaders
        }

        /**
         * - `JSON` - JSON
         * - `BASE64_GZIP` - BASE64_GZIP
         */
        fun responseType(responseType: ResponseTypeEnum) = responseType(JsonField.of(responseType))

        /**
         * - `JSON` - JSON
         * - `BASE64_GZIP` - BASE64_GZIP
         */
        @JsonProperty("response_type")
        @ExcludeMissing
        fun responseType(responseType: JsonField<ResponseTypeEnum>) = apply {
            this.responseType = responseType
        }

        @JsonProperty("headers")
        @ExcludeMissing
        fun headers(headers: JsonValue) = apply { this.headers = headers }

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

        fun build(): RemoteResponse =
            RemoteResponse(
                method,
                path,
                status,
                response,
                responseHeaders,
                responseType,
                headers,
                additionalProperties.toUnmodifiable(),
            )
    }

    class ResponseTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val JSON = ResponseTypeEnum(JsonField.of("JSON"))

            @JvmField val BASE64_GZIP = ResponseTypeEnum(JsonField.of("BASE64_GZIP"))

            @JvmStatic fun of(value: String) = ResponseTypeEnum(JsonField.of(value))
        }

        enum class Known {
            JSON,
            BASE64_GZIP,
        }

        enum class Value {
            JSON,
            BASE64_GZIP,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                JSON -> Value.JSON
                BASE64_GZIP -> Value.BASE64_GZIP
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                JSON -> Known.JSON
                BASE64_GZIP -> Known.BASE64_GZIP
                else -> throw MergeInvalidDataException("Unknown ResponseTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
