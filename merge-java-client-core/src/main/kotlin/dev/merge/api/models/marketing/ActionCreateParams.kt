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

class ActionCreateParams
constructor(
    private val model: ActionRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): ActionRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): ActionCreateBody {
        return ActionCreateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = ActionCreateBody.Builder::class)
    @NoAutoDetect
    class ActionCreateBody
    internal constructor(
        private val model: ActionRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Action Object
         *
         * ### Description
         *
         * The `Action` object is used to represent an action executed within an automation.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/mktg/v1/actions` endpoint and view their types.
         */
        @JsonProperty("model") fun model(): ActionRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ActionCreateBody &&
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
            "ActionCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: ActionRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(actionCreateBody: ActionCreateBody) = apply {
                this.model = actionCreateBody.model
                additionalProperties(actionCreateBody.additionalProperties)
            }

            /**
             * # The Action Object
             *
             * ### Description
             *
             * The `Action` object is used to represent an action executed within an automation.
             *
             * ### Usage Example
             *
             * Fetch from the `GET /api/mktg/v1/actions` endpoint and view their types.
             */
            @JsonProperty("model") fun model(model: ActionRequest) = apply { this.model = model }

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

            fun build(): ActionCreateBody =
                ActionCreateBody(
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

        return other is ActionCreateParams &&
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
        "ActionCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: ActionRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(actionCreateParams: ActionCreateParams) = apply {
            this.model = actionCreateParams.model
            this.isDebugMode = actionCreateParams.isDebugMode
            this.runAsync = actionCreateParams.runAsync
            additionalQueryParams(actionCreateParams.additionalQueryParams)
            additionalHeaders(actionCreateParams.additionalHeaders)
            additionalBodyProperties(actionCreateParams.additionalBodyProperties)
        }

        /**
         * # The Action Object
         *
         * ### Description
         *
         * The `Action` object is used to represent an action executed within an automation.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/mktg/v1/actions` endpoint and view their types.
         */
        fun model(model: ActionRequest) = apply { this.model = model }

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

        fun build(): ActionCreateParams =
            ActionCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Action Object
     *
     * ### Description
     *
     * The `Action` object is used to represent an action executed within an automation.
     *
     * ### Usage Example
     *
     * Fetch from the `GET /api/mktg/v1/actions` endpoint and view their types.
     */
    @JsonDeserialize(builder = ActionRequest.Builder::class)
    @NoAutoDetect
    class ActionRequest
    private constructor(
        private val name: String?,
        private val emails: List<String>?,
        private val messages: List<String>?,
        private val type: TypeEnum?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The action's name. */
        @JsonProperty("name") fun name(): String? = name

        /** The marketing emails sent by this action. */
        @JsonProperty("emails") fun emails(): List<String>? = emails

        /** The messages sent by this action. */
        @JsonProperty("messages") fun messages(): List<String>? = messages

        /**
         * - `EMAIL` - EMAIL
         * - `MESSAGE` - MESSAGE
         */
        @JsonProperty("type") fun type(): TypeEnum? = type

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

            return other is ActionRequest &&
                this.name == other.name &&
                this.emails == other.emails &&
                this.messages == other.messages &&
                this.type == other.type &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        name,
                        emails,
                        messages,
                        type,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ActionRequest{name=$name, emails=$emails, messages=$messages, type=$type, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var emails: List<String>? = null
            private var messages: List<String>? = null
            private var type: TypeEnum? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(actionRequest: ActionRequest) = apply {
                this.name = actionRequest.name
                this.emails = actionRequest.emails
                this.messages = actionRequest.messages
                this.type = actionRequest.type
                this.integrationParams = actionRequest.integrationParams
                this.linkedAccountParams = actionRequest.linkedAccountParams
                additionalProperties(actionRequest.additionalProperties)
            }

            /** The action's name. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /** The marketing emails sent by this action. */
            @JsonProperty("emails")
            fun emails(emails: List<String>) = apply { this.emails = emails }

            /** The messages sent by this action. */
            @JsonProperty("messages")
            fun messages(messages: List<String>) = apply { this.messages = messages }

            /**
             * - `EMAIL` - EMAIL
             * - `MESSAGE` - MESSAGE
             */
            @JsonProperty("type") fun type(type: TypeEnum) = apply { this.type = type }

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

            fun build(): ActionRequest =
                ActionRequest(
                    name,
                    checkNotNull(emails) { "`emails` is required but was not set" }
                        .toUnmodifiable(),
                    checkNotNull(messages) { "`messages` is required but was not set" }
                        .toUnmodifiable(),
                    type,
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
