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

/**
 * # The RemoteKey Object
 *
 * ### Description
 *
 * The `RemoteKey` object is used to represent a request for a new remote key.
 *
 * ### Usage Example
 *
 * Post a `GenerateRemoteKey` to receive a new `RemoteKey`.
 */
@JsonDeserialize(builder = RemoteKey.Builder::class)
@NoAutoDetect
class RemoteKey
private constructor(
    private val name: JsonField<String>,
    private val key: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun name(): String = name.getRequired("name")

    fun key(): String = key.getRequired("key")

    @JsonProperty("name") @ExcludeMissing fun _name() = name

    @JsonProperty("key") @ExcludeMissing fun _key() = key

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): RemoteKey = apply {
        if (!validated) {
            name()
            key()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RemoteKey &&
            this.name == other.name &&
            this.key == other.key &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    name,
                    key,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "RemoteKey{name=$name, key=$key, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var key: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(remoteKey: RemoteKey) = apply {
            this.name = remoteKey.name
            this.key = remoteKey.key
            additionalProperties(remoteKey.additionalProperties)
        }

        fun name(name: String) = name(JsonField.of(name))

        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

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

        fun build(): RemoteKey =
            RemoteKey(
                name,
                key,
                additionalProperties.toUnmodifiable(),
            )
    }
}
