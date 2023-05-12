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

@JsonDeserialize(builder = RemoteData.Builder::class)
@NoAutoDetect
class RemoteData
private constructor(
    private val path: JsonField<String>,
    private val data: JsonValue,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun path(): String = path.getRequired("path")

    @JsonProperty("path") @ExcludeMissing fun _path() = path

    @JsonProperty("data") @ExcludeMissing fun _data() = data

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            path()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RemoteData &&
            this.path == other.path &&
            this.data == other.data &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    path,
                    data,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "RemoteData{path=$path, data=$data, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var path: JsonField<String> = JsonMissing.of()
        private var data: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(remoteData: RemoteData) = apply {
            this.path = remoteData.path
            this.data = remoteData.data
            additionalProperties(remoteData.additionalProperties)
        }

        fun path(path: String) = path(JsonField.of(path))

        @JsonProperty("path")
        @ExcludeMissing
        fun path(path: JsonField<String>) = apply { this.path = path }

        @JsonProperty("data") @ExcludeMissing fun data(data: JsonValue) = apply { this.data = data }

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

        fun build(): RemoteData =
            RemoteData(
                path,
                data,
                additionalProperties.toUnmodifiable(),
            )
    }
}
