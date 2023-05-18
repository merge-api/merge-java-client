package dev.merge.api.models.marketing

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

class TemplateCreateParams
constructor(
    private val model: TemplateRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): TemplateRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): TemplateCreateBody {
        return TemplateCreateBody(model, additionalBodyProperties)
    }

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.isDebugMode?.let { params.put("is_debug_mode", listOf(it.toString())) }
        this.runAsync?.let { params.put("run_async", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = TemplateCreateBody.Builder::class)
    @NoAutoDetect
    class TemplateCreateBody
    internal constructor(
        private val model: TemplateRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Template Object
         *
         * ### Description
         *
         * The `Template` object is used to represent a template for a marketing asset in the remote
         * system.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/mktg/v1/templates` endpoint and view their content properties.
         */
        @JsonProperty("model") fun model(): TemplateRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TemplateCreateBody &&
                this.model == other.model &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(model, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "TemplateCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: TemplateRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(templateCreateBody: TemplateCreateBody) = apply {
                this.model = templateCreateBody.model
                additionalProperties(templateCreateBody.additionalProperties)
            }

            /**
             * # The Template Object
             *
             * ### Description
             *
             * The `Template` object is used to represent a template for a marketing asset in the
             * remote system.
             *
             * ### Usage Example
             *
             * Fetch from the `GET /api/mktg/v1/templates` endpoint and view their content
             * properties.
             */
            @JsonProperty("model") fun model(model: TemplateRequest) = apply { this.model = model }

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

            fun build(): TemplateCreateBody =
                TemplateCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    additionalProperties.toUnmodifiable()
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

        return other is TemplateCreateParams &&
            this.model == other.model &&
            this.isDebugMode == other.isDebugMode &&
            this.runAsync == other.runAsync &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            isDebugMode,
            runAsync,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "TemplateCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: TemplateRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateCreateParams: TemplateCreateParams) = apply {
            this.model = templateCreateParams.model
            this.isDebugMode = templateCreateParams.isDebugMode
            this.runAsync = templateCreateParams.runAsync
            additionalQueryParams(templateCreateParams.additionalQueryParams)
            additionalHeaders(templateCreateParams.additionalHeaders)
            additionalBodyProperties(templateCreateParams.additionalBodyProperties)
        }

        /**
         * # The Template Object
         *
         * ### Description
         *
         * The `Template` object is used to represent a template for a marketing asset in the remote
         * system.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/mktg/v1/templates` endpoint and view their content properties.
         */
        fun model(model: TemplateRequest) = apply { this.model = model }

        /** Whether to include debug fields (such as log file links) in the response. */
        fun isDebugMode(isDebugMode: Boolean) = apply { this.isDebugMode = isDebugMode }

        /** Whether or not third-party updates should be run asynchronously. */
        fun runAsync(runAsync: Boolean) = apply { this.runAsync = runAsync }

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

        fun build(): TemplateCreateParams =
            TemplateCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Template Object
     *
     * ### Description
     *
     * The `Template` object is used to represent a template for a marketing asset in the remote
     * system.
     *
     * ### Usage Example
     *
     * Fetch from the `GET /api/mktg/v1/templates` endpoint and view their content properties.
     */
    @JsonDeserialize(builder = TemplateRequest.Builder::class)
    @NoAutoDetect
    class TemplateRequest
    private constructor(
        private val name: String?,
        private val type: TypeEnum?,
        private val contents: String?,
        private val owner: String?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The template's name. */
        @JsonProperty("name") fun name(): String? = name

        /**
         * - `EMAIL` - EMAIL
         * - `MESSAGE` - MESSAGE
         */
        @JsonProperty("type") fun type(): TypeEnum? = type

        /** The template contents. */
        @JsonProperty("contents") fun contents(): String? = contents

        /** The template's owner. */
        @JsonProperty("owner") fun owner(): String? = owner

        @JsonProperty("integration_params") fun integrationParams(): JsonValue? = integrationParams

        @JsonProperty("linked_account_params")
        fun linkedAccountParams(): JsonValue? = linkedAccountParams

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TemplateRequest &&
                this.name == other.name &&
                this.type == other.type &&
                this.contents == other.contents &&
                this.owner == other.owner &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        name,
                        type,
                        contents,
                        owner,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "TemplateRequest{name=$name, type=$type, contents=$contents, owner=$owner, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var type: TypeEnum? = null
            private var contents: String? = null
            private var owner: String? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(templateRequest: TemplateRequest) = apply {
                this.name = templateRequest.name
                this.type = templateRequest.type
                this.contents = templateRequest.contents
                this.owner = templateRequest.owner
                this.integrationParams = templateRequest.integrationParams
                this.linkedAccountParams = templateRequest.linkedAccountParams
                additionalProperties(templateRequest.additionalProperties)
            }

            /** The template's name. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /**
             * - `EMAIL` - EMAIL
             * - `MESSAGE` - MESSAGE
             */
            @JsonProperty("type") fun type(type: TypeEnum) = apply { this.type = type }

            /** The template contents. */
            @JsonProperty("contents")
            fun contents(contents: String) = apply { this.contents = contents }

            /** The template's owner. */
            @JsonProperty("owner") fun owner(owner: String) = apply { this.owner = owner }

            @JsonProperty("integration_params")
            fun integrationParams(integrationParams: JsonValue) = apply {
                this.integrationParams = integrationParams
            }

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                this.linkedAccountParams = linkedAccountParams
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

            fun build(): TemplateRequest =
                TemplateRequest(
                    name,
                    type,
                    contents,
                    owner,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class TypeEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is TypeEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val EMAIL = TypeEnum(JsonField.of("EMAIL"))

                @JvmField val MESSAGE = TypeEnum(JsonField.of("MESSAGE"))

                @JvmStatic fun of(value: String) = TypeEnum(JsonField.of(value))
            }

            enum class Known {
                EMAIL,
                MESSAGE,
            }

            enum class Value {
                EMAIL,
                MESSAGE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    EMAIL -> Value.EMAIL
                    MESSAGE -> Value.MESSAGE
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    EMAIL -> Known.EMAIL
                    MESSAGE -> Known.MESSAGE
                    else -> throw MergeInvalidDataException("Unknown TypeEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
