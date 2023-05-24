package dev.merge.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = WebhookReceiver.Builder::class)
@NoAutoDetect
class WebhookReceiver
private constructor(
    private val event: JsonField<String>,
    private val isActive: JsonField<Boolean>,
    private val key: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun event(): String = event.getRequired("event")

    fun isActive(): Boolean = isActive.getRequired("is_active")

    fun key(): Optional<String> = Optional.ofNullable(key.getNullable("key"))

    @JsonProperty("event") @ExcludeMissing fun _event() = event

    @JsonProperty("is_active") @ExcludeMissing fun _isActive() = isActive

    @JsonProperty("key") @ExcludeMissing fun _key() = key

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): WebhookReceiver = apply {
        if (!validated) {
            event()
            isActive()
            key()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookReceiver &&
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
        "WebhookReceiver{event=$event, isActive=$isActive, key=$key, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var event: JsonField<String> = JsonMissing.of()
        private var isActive: JsonField<Boolean> = JsonMissing.of()
        private var key: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookReceiver: WebhookReceiver) = apply {
            this.event = webhookReceiver.event
            this.isActive = webhookReceiver.isActive
            this.key = webhookReceiver.key
            additionalProperties(webhookReceiver.additionalProperties)
        }

        fun event(event: String) = event(JsonField.of(event))

        @JsonProperty("event")
        @ExcludeMissing
        fun event(event: JsonField<String>) = apply { this.event = event }

        fun isActive(isActive: Boolean) = isActive(JsonField.of(isActive))

        @JsonProperty("is_active")
        @ExcludeMissing
        fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

        fun key(key: String) = key(JsonField.of(key))

        @JsonProperty("key")
        @ExcludeMissing
        fun key(key: JsonField<String>) = apply { this.key = key }

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

        fun build(): WebhookReceiver =
            WebhookReceiver(
                event,
                isActive,
                key,
                additionalProperties.toUnmodifiable(),
            )
    }
}
