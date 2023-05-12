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
import java.util.Objects
import java.util.Optional

class PassthroughRequestSendParams
constructor(
    private val method: MethodEnum,
    private val path: String,
    private val baseUrlOverride: String?,
    private val data: String?,
    private val multipartFormData: List<MultipartFormFieldRequest>?,
    private val headers: JsonValue?,
    private val requestFormat: RequestFormatEnum?,
    private val normalizeResponse: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun method(): MethodEnum = method

    fun path(): String = path

    fun baseUrlOverride(): Optional<String> = Optional.ofNullable(baseUrlOverride)

    fun data(): Optional<String> = Optional.ofNullable(data)

    fun multipartFormData(): Optional<List<MultipartFormFieldRequest>> =
        Optional.ofNullable(multipartFormData)

    fun headers(): Optional<JsonValue> = Optional.ofNullable(headers)

    fun requestFormat(): Optional<RequestFormatEnum> = Optional.ofNullable(requestFormat)

    fun normalizeResponse(): Optional<Boolean> = Optional.ofNullable(normalizeResponse)

    @JvmSynthetic
    internal fun getBody(): PassthroughRequestSendBody {
        return PassthroughRequestSendBody(
            method,
            path,
            baseUrlOverride,
            data,
            multipartFormData,
            headers,
            requestFormat,
            normalizeResponse,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    /**
     * # The DataPassthrough Object
     *
     * ### Description
     *
     * The `DataPassthrough` object is used to send information to an otherwise-unsupported
     * third-party endpoint.
     *
     * ### Usage Example
     *
     * Create a `DataPassthrough` to get team hierarchies from your Rippling integration.
     */
    @JsonDeserialize(builder = PassthroughRequestSendBody.Builder::class)
    @NoAutoDetect
    class PassthroughRequestSendBody
    internal constructor(
        private val method: MethodEnum?,
        private val path: String?,
        private val baseUrlOverride: String?,
        private val data: String?,
        private val multipartFormData: List<MultipartFormFieldRequest>?,
        private val headers: JsonValue?,
        private val requestFormat: RequestFormatEnum?,
        private val normalizeResponse: Boolean?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * - `GET` - GET
         * - `OPTIONS` - OPTIONS
         * - `HEAD` - HEAD
         * - `POST` - POST
         * - `PUT` - PUT
         * - `PATCH` - PATCH
         * - `DELETE` - DELETE
         */
        @JsonProperty("method") fun method(): MethodEnum? = method

        @JsonProperty("path") fun path(): String? = path

        @JsonProperty("base_url_override") fun baseUrlOverride(): String? = baseUrlOverride

        @JsonProperty("data") fun data(): String? = data

        /**
         * Pass an array of `MultipartFormField` objects in here instead of using the `data` param
         * if `request_format` is set to `MULTIPART`.
         */
        @JsonProperty("multipart_form_data")
        fun multipartFormData(): List<MultipartFormFieldRequest>? = multipartFormData

        /**
         * The headers to use for the request (Merge will handle the account's authorization
         * headers). `Content-Type` header is required for passthrough. Choose content type
         * corresponding to expected format of receiving server.
         */
        @JsonProperty("headers") fun headers(): JsonValue? = headers

        /**
         * - `JSON` - JSON
         * - `XML` - XML
         * - `MULTIPART` - MULTIPART
         */
        @JsonProperty("request_format") fun requestFormat(): RequestFormatEnum? = requestFormat

        /**
         * Optional. If true, the response will always be an object of the form `{"type": T,
         * "value": ...}` where `T` will be one of `string, boolean, number, null, array, object`.
         */
        @JsonProperty("normalize_response") fun normalizeResponse(): Boolean? = normalizeResponse

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PassthroughRequestSendBody &&
                this.method == other.method &&
                this.path == other.path &&
                this.baseUrlOverride == other.baseUrlOverride &&
                this.data == other.data &&
                this.multipartFormData == other.multipartFormData &&
                this.headers == other.headers &&
                this.requestFormat == other.requestFormat &&
                this.normalizeResponse == other.normalizeResponse &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        method,
                        path,
                        baseUrlOverride,
                        data,
                        multipartFormData,
                        headers,
                        requestFormat,
                        normalizeResponse,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "PassthroughRequestSendBody{method=$method, path=$path, baseUrlOverride=$baseUrlOverride, data=$data, multipartFormData=$multipartFormData, headers=$headers, requestFormat=$requestFormat, normalizeResponse=$normalizeResponse, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var method: MethodEnum? = null
            private var path: String? = null
            private var baseUrlOverride: String? = null
            private var data: String? = null
            private var multipartFormData: List<MultipartFormFieldRequest>? = null
            private var headers: JsonValue? = null
            private var requestFormat: RequestFormatEnum? = null
            private var normalizeResponse: Boolean? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(passthroughRequestSendBody: PassthroughRequestSendBody) = apply {
                this.method = passthroughRequestSendBody.method
                this.path = passthroughRequestSendBody.path
                this.baseUrlOverride = passthroughRequestSendBody.baseUrlOverride
                this.data = passthroughRequestSendBody.data
                this.multipartFormData = passthroughRequestSendBody.multipartFormData
                this.headers = passthroughRequestSendBody.headers
                this.requestFormat = passthroughRequestSendBody.requestFormat
                this.normalizeResponse = passthroughRequestSendBody.normalizeResponse
                additionalProperties(passthroughRequestSendBody.additionalProperties)
            }

            /**
             * - `GET` - GET
             * - `OPTIONS` - OPTIONS
             * - `HEAD` - HEAD
             * - `POST` - POST
             * - `PUT` - PUT
             * - `PATCH` - PATCH
             * - `DELETE` - DELETE
             */
            @JsonProperty("method") fun method(method: MethodEnum) = apply { this.method = method }

            @JsonProperty("path") fun path(path: String) = apply { this.path = path }

            @JsonProperty("base_url_override")
            fun baseUrlOverride(baseUrlOverride: String) = apply {
                this.baseUrlOverride = baseUrlOverride
            }

            @JsonProperty("data") fun data(data: String) = apply { this.data = data }

            /**
             * Pass an array of `MultipartFormField` objects in here instead of using the `data`
             * param if `request_format` is set to `MULTIPART`.
             */
            @JsonProperty("multipart_form_data")
            fun multipartFormData(multipartFormData: List<MultipartFormFieldRequest>) = apply {
                this.multipartFormData = multipartFormData
            }

            /**
             * The headers to use for the request (Merge will handle the account's authorization
             * headers). `Content-Type` header is required for passthrough. Choose content type
             * corresponding to expected format of receiving server.
             */
            @JsonProperty("headers")
            fun headers(headers: JsonValue) = apply { this.headers = headers }

            /**
             * - `JSON` - JSON
             * - `XML` - XML
             * - `MULTIPART` - MULTIPART
             */
            @JsonProperty("request_format")
            fun requestFormat(requestFormat: RequestFormatEnum) = apply {
                this.requestFormat = requestFormat
            }

            /**
             * Optional. If true, the response will always be an object of the form `{"type": T,
             * "value": ...}` where `T` will be one of `string, boolean, number, null, array,
             * object`.
             */
            @JsonProperty("normalize_response")
            fun normalizeResponse(normalizeResponse: Boolean) = apply {
                this.normalizeResponse = normalizeResponse
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

            fun build(): PassthroughRequestSendBody =
                PassthroughRequestSendBody(
                    checkNotNull(method) { "`method` is required but was not set" },
                    checkNotNull(path) { "`path` is required but was not set" },
                    baseUrlOverride,
                    data,
                    multipartFormData?.toUnmodifiable(),
                    headers,
                    requestFormat,
                    normalizeResponse,
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

        return other is PassthroughRequestSendParams &&
            this.method == other.method &&
            this.path == other.path &&
            this.baseUrlOverride == other.baseUrlOverride &&
            this.data == other.data &&
            this.multipartFormData == other.multipartFormData &&
            this.headers == other.headers &&
            this.requestFormat == other.requestFormat &&
            this.normalizeResponse == other.normalizeResponse &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            method,
            path,
            baseUrlOverride,
            data,
            multipartFormData,
            headers,
            requestFormat,
            normalizeResponse,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "PassthroughRequestSendParams{method=$method, path=$path, baseUrlOverride=$baseUrlOverride, data=$data, multipartFormData=$multipartFormData, headers=$headers, requestFormat=$requestFormat, normalizeResponse=$normalizeResponse, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var method: MethodEnum? = null
        private var path: String? = null
        private var baseUrlOverride: String? = null
        private var data: String? = null
        private var multipartFormData: List<MultipartFormFieldRequest>? = null
        private var headers: JsonValue? = null
        private var requestFormat: RequestFormatEnum? = null
        private var normalizeResponse: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(passthroughRequestSendParams: PassthroughRequestSendParams) = apply {
            this.method = passthroughRequestSendParams.method
            this.path = passthroughRequestSendParams.path
            this.baseUrlOverride = passthroughRequestSendParams.baseUrlOverride
            this.data = passthroughRequestSendParams.data
            this.multipartFormData = passthroughRequestSendParams.multipartFormData
            this.headers = passthroughRequestSendParams.headers
            this.requestFormat = passthroughRequestSendParams.requestFormat
            this.normalizeResponse = passthroughRequestSendParams.normalizeResponse
            additionalQueryParams(passthroughRequestSendParams.additionalQueryParams)
            additionalHeaders(passthroughRequestSendParams.additionalHeaders)
            additionalBodyProperties(passthroughRequestSendParams.additionalBodyProperties)
        }

        /**
         * - `GET` - GET
         * - `OPTIONS` - OPTIONS
         * - `HEAD` - HEAD
         * - `POST` - POST
         * - `PUT` - PUT
         * - `PATCH` - PATCH
         * - `DELETE` - DELETE
         */
        fun method(method: MethodEnum) = apply { this.method = method }

        fun path(path: String) = apply { this.path = path }

        fun baseUrlOverride(baseUrlOverride: String) = apply {
            this.baseUrlOverride = baseUrlOverride
        }

        fun data(data: String) = apply { this.data = data }

        /**
         * Pass an array of `MultipartFormField` objects in here instead of using the `data` param
         * if `request_format` is set to `MULTIPART`.
         */
        fun multipartFormData(multipartFormData: List<MultipartFormFieldRequest>) = apply {
            this.multipartFormData = multipartFormData
        }

        /**
         * The headers to use for the request (Merge will handle the account's authorization
         * headers). `Content-Type` header is required for passthrough. Choose content type
         * corresponding to expected format of receiving server.
         */
        fun headers(headers: JsonValue) = apply { this.headers = headers }

        /**
         * - `JSON` - JSON
         * - `XML` - XML
         * - `MULTIPART` - MULTIPART
         */
        fun requestFormat(requestFormat: RequestFormatEnum) = apply {
            this.requestFormat = requestFormat
        }

        /**
         * Optional. If true, the response will always be an object of the form `{"type": T,
         * "value": ...}` where `T` will be one of `string, boolean, number, null, array, object`.
         */
        fun normalizeResponse(normalizeResponse: Boolean) = apply {
            this.normalizeResponse = normalizeResponse
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

        fun build(): PassthroughRequestSendParams =
            PassthroughRequestSendParams(
                checkNotNull(method) { "`method` is required but was not set" },
                checkNotNull(path) { "`path` is required but was not set" },
                baseUrlOverride,
                data,
                multipartFormData?.toUnmodifiable(),
                headers,
                requestFormat,
                normalizeResponse,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    class MethodEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MethodEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val GET = MethodEnum(JsonField.of("GET"))

            @JvmField val OPTIONS = MethodEnum(JsonField.of("OPTIONS"))

            @JvmField val HEAD = MethodEnum(JsonField.of("HEAD"))

            @JvmField val POST = MethodEnum(JsonField.of("POST"))

            @JvmField val PUT = MethodEnum(JsonField.of("PUT"))

            @JvmField val PATCH = MethodEnum(JsonField.of("PATCH"))

            @JvmField val DELETE = MethodEnum(JsonField.of("DELETE"))

            @JvmStatic fun of(value: String) = MethodEnum(JsonField.of(value))
        }

        enum class Known {
            GET,
            OPTIONS,
            HEAD,
            POST,
            PUT,
            PATCH,
            DELETE,
        }

        enum class Value {
            GET,
            OPTIONS,
            HEAD,
            POST,
            PUT,
            PATCH,
            DELETE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                GET -> Value.GET
                OPTIONS -> Value.OPTIONS
                HEAD -> Value.HEAD
                POST -> Value.POST
                PUT -> Value.PUT
                PATCH -> Value.PATCH
                DELETE -> Value.DELETE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                GET -> Known.GET
                OPTIONS -> Known.OPTIONS
                HEAD -> Known.HEAD
                POST -> Known.POST
                PUT -> Known.PUT
                PATCH -> Known.PATCH
                DELETE -> Known.DELETE
                else -> throw MergeInvalidDataException("Unknown MethodEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /**
     * # The MultipartFormField Object
     *
     * ### Description
     *
     * The `MultipartFormField` object is used to represent fields in an HTTP request using
     * `multipart/form-data`.
     *
     * ### Usage Example
     *
     * Create a `MultipartFormField` to define a multipart form entry.
     */
    @JsonDeserialize(builder = MultipartFormFieldRequest.Builder::class)
    @NoAutoDetect
    class MultipartFormFieldRequest
    private constructor(
        private val name: String?,
        private val data: String?,
        private val encoding: EncodingEnum?,
        private val fileName: String?,
        private val contentType: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The name of the form field */
        @JsonProperty("name") fun name(): String? = name

        /** The data for the form field. */
        @JsonProperty("data") fun data(): String? = data

        /**
         * - `RAW` - RAW
         * - `BASE64` - BASE64
         * - `GZIP_BASE64` - GZIP_BASE64
         */
        @JsonProperty("encoding") fun encoding(): EncodingEnum? = encoding

        /** The file name of the form field, if the field is for a file. */
        @JsonProperty("file_name") fun fileName(): String? = fileName

        /** The MIME type of the file, if the field is for a file. */
        @JsonProperty("content_type") fun contentType(): String? = contentType

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MultipartFormFieldRequest &&
                this.name == other.name &&
                this.data == other.data &&
                this.encoding == other.encoding &&
                this.fileName == other.fileName &&
                this.contentType == other.contentType &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        name,
                        data,
                        encoding,
                        fileName,
                        contentType,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "MultipartFormFieldRequest{name=$name, data=$data, encoding=$encoding, fileName=$fileName, contentType=$contentType, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var data: String? = null
            private var encoding: EncodingEnum? = null
            private var fileName: String? = null
            private var contentType: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(multipartFormFieldRequest: MultipartFormFieldRequest) = apply {
                this.name = multipartFormFieldRequest.name
                this.data = multipartFormFieldRequest.data
                this.encoding = multipartFormFieldRequest.encoding
                this.fileName = multipartFormFieldRequest.fileName
                this.contentType = multipartFormFieldRequest.contentType
                additionalProperties(multipartFormFieldRequest.additionalProperties)
            }

            /** The name of the form field */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /** The data for the form field. */
            @JsonProperty("data") fun data(data: String) = apply { this.data = data }

            /**
             * - `RAW` - RAW
             * - `BASE64` - BASE64
             * - `GZIP_BASE64` - GZIP_BASE64
             */
            @JsonProperty("encoding")
            fun encoding(encoding: EncodingEnum) = apply { this.encoding = encoding }

            /** The file name of the form field, if the field is for a file. */
            @JsonProperty("file_name")
            fun fileName(fileName: String) = apply { this.fileName = fileName }

            /** The MIME type of the file, if the field is for a file. */
            @JsonProperty("content_type")
            fun contentType(contentType: String) = apply { this.contentType = contentType }

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

            fun build(): MultipartFormFieldRequest =
                MultipartFormFieldRequest(
                    checkNotNull(name) { "`name` is required but was not set" },
                    checkNotNull(data) { "`data` is required but was not set" },
                    encoding,
                    fileName,
                    contentType,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class EncodingEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EncodingEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val RAW = EncodingEnum(JsonField.of("RAW"))

                @JvmField val BASE64 = EncodingEnum(JsonField.of("BASE64"))

                @JvmField val GZIP_BASE64 = EncodingEnum(JsonField.of("GZIP_BASE64"))

                @JvmStatic fun of(value: String) = EncodingEnum(JsonField.of(value))
            }

            enum class Known {
                RAW,
                BASE64,
                GZIP_BASE64,
            }

            enum class Value {
                RAW,
                BASE64,
                GZIP_BASE64,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    RAW -> Value.RAW
                    BASE64 -> Value.BASE64
                    GZIP_BASE64 -> Value.GZIP_BASE64
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    RAW -> Known.RAW
                    BASE64 -> Known.BASE64
                    GZIP_BASE64 -> Known.GZIP_BASE64
                    else -> throw MergeInvalidDataException("Unknown EncodingEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }

    class RequestFormatEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RequestFormatEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val JSON = RequestFormatEnum(JsonField.of("JSON"))

            @JvmField val XML = RequestFormatEnum(JsonField.of("XML"))

            @JvmField val MULTIPART = RequestFormatEnum(JsonField.of("MULTIPART"))

            @JvmStatic fun of(value: String) = RequestFormatEnum(JsonField.of(value))
        }

        enum class Known {
            JSON,
            XML,
            MULTIPART,
        }

        enum class Value {
            JSON,
            XML,
            MULTIPART,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                JSON -> Value.JSON
                XML -> Value.XML
                MULTIPART -> Value.MULTIPART
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                JSON -> Known.JSON
                XML -> Known.XML
                MULTIPART -> Known.MULTIPART
                else -> throw MergeInvalidDataException("Unknown RequestFormatEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
