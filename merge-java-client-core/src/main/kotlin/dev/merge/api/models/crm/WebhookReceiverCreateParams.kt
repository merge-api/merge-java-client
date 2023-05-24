package dev.merge.api.models.crm

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.models.*
import java.util.Objects
import java.util.Optional

class WebhookReceiverCreateParams
constructor(
    private val event: String,
    private val isActive: Boolean,
    private val key: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun event(): String = event

    fun isActive(): Boolean = isActive

    fun key(): Optional<String> = Optional.ofNullable(key)

    @JvmSynthetic
    internal fun getBody(): WebhookReceiverCreateBody {
        return WebhookReceiverCreateBody(
            event,
            isActive,
            key,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = WebhookReceiverCreateBody.Builder::class)
    @NoAutoDetect
    class WebhookReceiverCreateBody
    internal constructor(
        private val event: String?,
        private val isActive: Boolean?,
        private val key: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("event") fun event(): String? = event

        @JsonProperty("is_active") fun isActive(): Boolean? = isActive

        @JsonProperty("key") fun key(): String? = key

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is WebhookReceiverCreateBody &&
                this.event == other.event &&
                this.isActive == other.isActive &&
                this.key == other.key &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        event,
                        isActive,
                        key,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "WebhookReceiverCreateBody{event=$event, isActive=$isActive, key=$key, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var event: String? = null
            private var isActive: Boolean? = null
            private var key: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(webhookReceiverCreateBody: WebhookReceiverCreateBody) = apply {
                this.event = webhookReceiverCreateBody.event
                this.isActive = webhookReceiverCreateBody.isActive
                this.key = webhookReceiverCreateBody.key
                additionalProperties(webhookReceiverCreateBody.additionalProperties)
            }

            @JsonProperty("event") fun event(event: String) = apply { this.event = event }

            @JsonProperty("is_active")
            fun isActive(isActive: Boolean) = apply { this.isActive = isActive }

            @JsonProperty("key") fun key(key: String) = apply { this.key = key }

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

            fun build(): WebhookReceiverCreateBody =
                WebhookReceiverCreateBody(
                    checkNotNull(event) { "`event` is required but was not set" },
                    checkNotNull(isActive) { "`isActive` is required but was not set" },
                    key,
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

        return other is WebhookReceiverCreateParams &&
            this.event == other.event &&
            this.isActive == other.isActive &&
            this.key == other.key &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            event,
            isActive,
            key,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "WebhookReceiverCreateParams{event=$event, isActive=$isActive, key=$key, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var event: String? = null
        private var isActive: Boolean? = null
        private var key: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookReceiverCreateParams: WebhookReceiverCreateParams) = apply {
            this.event = webhookReceiverCreateParams.event
            this.isActive = webhookReceiverCreateParams.isActive
            this.key = webhookReceiverCreateParams.key
            additionalQueryParams(webhookReceiverCreateParams.additionalQueryParams)
            additionalHeaders(webhookReceiverCreateParams.additionalHeaders)
            additionalBodyProperties(webhookReceiverCreateParams.additionalBodyProperties)
        }

        fun event(event: String) = apply { this.event = event }

        fun isActive(isActive: Boolean) = apply { this.isActive = isActive }

        fun key(key: String) = apply { this.key = key }

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

        fun build(): WebhookReceiverCreateParams =
            WebhookReceiverCreateParams(
                checkNotNull(event) { "`event` is required but was not set" },
                checkNotNull(isActive) { "`isActive` is required but was not set" },
                key,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }
}
