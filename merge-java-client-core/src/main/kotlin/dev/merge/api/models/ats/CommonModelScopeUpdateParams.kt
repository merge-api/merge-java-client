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

class CommonModelScopeUpdateParams
constructor(
    private val commonModels: List<CommonModelScopesPostInnerDeserializerRequest>,
    private val linkedAccountId: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun commonModels(): List<CommonModelScopesPostInnerDeserializerRequest> = commonModels

    fun linkedAccountId(): Optional<String> = Optional.ofNullable(linkedAccountId)

    @JvmSynthetic
    internal fun getBody(): CommonModelScopeUpdateBody {
        return CommonModelScopeUpdateBody(commonModels, additionalBodyProperties)
    }

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.linkedAccountId?.let { params.put("linked_account_id", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = CommonModelScopeUpdateBody.Builder::class)
    @NoAutoDetect
    class CommonModelScopeUpdateBody
    internal constructor(
        private val commonModels: List<CommonModelScopesPostInnerDeserializerRequest>?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The common model scopes to update. */
        @JsonProperty("common_models")
        fun commonModels(): List<CommonModelScopesPostInnerDeserializerRequest>? = commonModels

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CommonModelScopeUpdateBody &&
                this.commonModels == other.commonModels &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(commonModels, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "CommonModelScopeUpdateBody{commonModels=$commonModels, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var commonModels: List<CommonModelScopesPostInnerDeserializerRequest>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(commonModelScopeUpdateBody: CommonModelScopeUpdateBody) = apply {
                this.commonModels = commonModelScopeUpdateBody.commonModels
                additionalProperties(commonModelScopeUpdateBody.additionalProperties)
            }

            /** The common model scopes to update. */
            @JsonProperty("common_models")
            fun commonModels(commonModels: List<CommonModelScopesPostInnerDeserializerRequest>) =
                apply {
                    this.commonModels = commonModels
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

            fun build(): CommonModelScopeUpdateBody =
                CommonModelScopeUpdateBody(
                    checkNotNull(commonModels) { "`commonModels` is required but was not set" }
                        .toUnmodifiable(),
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

        return other is CommonModelScopeUpdateParams &&
            this.commonModels == other.commonModels &&
            this.linkedAccountId == other.linkedAccountId &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            commonModels,
            linkedAccountId,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "CommonModelScopeUpdateParams{commonModels=$commonModels, linkedAccountId=$linkedAccountId, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var commonModels: List<CommonModelScopesPostInnerDeserializerRequest>? = null
        private var linkedAccountId: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(commonModelScopeUpdateParams: CommonModelScopeUpdateParams) = apply {
            this.commonModels = commonModelScopeUpdateParams.commonModels
            this.linkedAccountId = commonModelScopeUpdateParams.linkedAccountId
            additionalQueryParams(commonModelScopeUpdateParams.additionalQueryParams)
            additionalHeaders(commonModelScopeUpdateParams.additionalHeaders)
            additionalBodyProperties(commonModelScopeUpdateParams.additionalBodyProperties)
        }

        /** The common model scopes to update. */
        fun commonModels(commonModels: List<CommonModelScopesPostInnerDeserializerRequest>) =
            apply {
                this.commonModels = commonModels
            }

        /** ID of specific linked account to fetch */
        fun linkedAccountId(linkedAccountId: String) = apply {
            this.linkedAccountId = linkedAccountId
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

        fun build(): CommonModelScopeUpdateParams =
            CommonModelScopeUpdateParams(
                checkNotNull(commonModels) { "`commonModels` is required but was not set" }
                    .toUnmodifiable(),
                linkedAccountId,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = CommonModelScopesPostInnerDeserializerRequest.Builder::class)
    @NoAutoDetect
    class CommonModelScopesPostInnerDeserializerRequest
    private constructor(
        private val modelId: String?,
        private val enabledActions: List<EnabledActionsEnum>?,
        private val disabledFields: List<String>?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("model_id") fun modelId(): String? = modelId

        @JsonProperty("enabled_actions")
        fun enabledActions(): List<EnabledActionsEnum>? = enabledActions

        @JsonProperty("disabled_fields") fun disabledFields(): List<String>? = disabledFields

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CommonModelScopesPostInnerDeserializerRequest &&
                this.modelId == other.modelId &&
                this.enabledActions == other.enabledActions &&
                this.disabledFields == other.disabledFields &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        modelId,
                        enabledActions,
                        disabledFields,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CommonModelScopesPostInnerDeserializerRequest{modelId=$modelId, enabledActions=$enabledActions, disabledFields=$disabledFields, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var modelId: String? = null
            private var enabledActions: List<EnabledActionsEnum>? = null
            private var disabledFields: List<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                commonModelScopesPostInnerDeserializerRequest:
                    CommonModelScopesPostInnerDeserializerRequest
            ) = apply {
                this.modelId = commonModelScopesPostInnerDeserializerRequest.modelId
                this.enabledActions = commonModelScopesPostInnerDeserializerRequest.enabledActions
                this.disabledFields = commonModelScopesPostInnerDeserializerRequest.disabledFields
                additionalProperties(
                    commonModelScopesPostInnerDeserializerRequest.additionalProperties
                )
            }

            @JsonProperty("model_id")
            fun modelId(modelId: String) = apply { this.modelId = modelId }

            @JsonProperty("enabled_actions")
            fun enabledActions(enabledActions: List<EnabledActionsEnum>) = apply {
                this.enabledActions = enabledActions
            }

            @JsonProperty("disabled_fields")
            fun disabledFields(disabledFields: List<String>) = apply {
                this.disabledFields = disabledFields
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

            fun build(): CommonModelScopesPostInnerDeserializerRequest =
                CommonModelScopesPostInnerDeserializerRequest(
                    checkNotNull(modelId) { "`modelId` is required but was not set" },
                    checkNotNull(enabledActions) { "`enabledActions` is required but was not set" }
                        .toUnmodifiable(),
                    checkNotNull(disabledFields) { "`disabledFields` is required but was not set" }
                        .toUnmodifiable(),
                    additionalProperties.toUnmodifiable(),
                )
        }

        class EnabledActionsEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EnabledActionsEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val READ = EnabledActionsEnum(JsonField.of("READ"))

                @JvmField val WRITE = EnabledActionsEnum(JsonField.of("WRITE"))

                @JvmStatic fun of(value: String) = EnabledActionsEnum(JsonField.of(value))
            }

            enum class Known {
                READ,
                WRITE,
            }

            enum class Value {
                READ,
                WRITE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    READ -> Value.READ
                    WRITE -> Value.WRITE
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    READ -> Known.READ
                    WRITE -> Known.WRITE
                    else -> throw MergeInvalidDataException("Unknown EnabledActionsEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
