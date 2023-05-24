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

@JsonDeserialize(builder = LinkToken.Builder::class)
@NoAutoDetect
class LinkToken
private constructor(
    private val linkToken: JsonField<String>,
    private val integrationName: JsonField<String>,
    private val magicLinkUrl: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun linkToken(): String = linkToken.getRequired("link_token")

    fun integrationName(): Optional<String> =
        Optional.ofNullable(integrationName.getNullable("integration_name"))

    fun magicLinkUrl(): Optional<String> =
        Optional.ofNullable(magicLinkUrl.getNullable("magic_link_url"))

    @JsonProperty("link_token") @ExcludeMissing fun _linkToken() = linkToken

    @JsonProperty("integration_name") @ExcludeMissing fun _integrationName() = integrationName

    @JsonProperty("magic_link_url") @ExcludeMissing fun _magicLinkUrl() = magicLinkUrl

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): LinkToken = apply {
        if (!validated) {
            linkToken()
            integrationName()
            magicLinkUrl()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is LinkToken &&
            this.linkToken == other.linkToken &&
            this.integrationName == other.integrationName &&
            this.magicLinkUrl == other.magicLinkUrl &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    linkToken,
                    integrationName,
                    magicLinkUrl,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "LinkToken{linkToken=$linkToken, integrationName=$integrationName, magicLinkUrl=$magicLinkUrl, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var linkToken: JsonField<String> = JsonMissing.of()
        private var integrationName: JsonField<String> = JsonMissing.of()
        private var magicLinkUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(linkToken: LinkToken) = apply {
            this.linkToken = linkToken.linkToken
            this.integrationName = linkToken.integrationName
            this.magicLinkUrl = linkToken.magicLinkUrl
            additionalProperties(linkToken.additionalProperties)
        }

        fun linkToken(linkToken: String) = linkToken(JsonField.of(linkToken))

        @JsonProperty("link_token")
        @ExcludeMissing
        fun linkToken(linkToken: JsonField<String>) = apply { this.linkToken = linkToken }

        fun integrationName(integrationName: String) =
            integrationName(JsonField.of(integrationName))

        @JsonProperty("integration_name")
        @ExcludeMissing
        fun integrationName(integrationName: JsonField<String>) = apply {
            this.integrationName = integrationName
        }

        fun magicLinkUrl(magicLinkUrl: String) = magicLinkUrl(JsonField.of(magicLinkUrl))

        @JsonProperty("magic_link_url")
        @ExcludeMissing
        fun magicLinkUrl(magicLinkUrl: JsonField<String>) = apply {
            this.magicLinkUrl = magicLinkUrl
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

        fun build(): LinkToken =
            LinkToken(
                linkToken,
                integrationName,
                magicLinkUrl,
                additionalProperties.toUnmodifiable(),
            )
    }
}
