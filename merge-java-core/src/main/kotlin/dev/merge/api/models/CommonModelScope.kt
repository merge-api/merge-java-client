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

@JsonDeserialize(builder = CommonModelScope.Builder::class)
@NoAutoDetect
class CommonModelScope
private constructor(
    private val organizationLevelScopes: JsonField<CommonModelScopeData>,
    private val scopeOverrides: JsonField<List<CommonModelScopeData>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun organizationLevelScopes(): Optional<CommonModelScopeData> =
        Optional.ofNullable(organizationLevelScopes.getNullable("organization_level_scopes"))

    fun scopeOverrides(): List<CommonModelScopeData> = scopeOverrides.getRequired("scope_overrides")

    @JsonProperty("organization_level_scopes")
    @ExcludeMissing
    fun _organizationLevelScopes() = organizationLevelScopes

    @JsonProperty("scope_overrides") @ExcludeMissing fun _scopeOverrides() = scopeOverrides

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            organizationLevelScopes().map { it.validate() }
            scopeOverrides().forEach { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommonModelScope &&
            this.organizationLevelScopes == other.organizationLevelScopes &&
            this.scopeOverrides == other.scopeOverrides &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    organizationLevelScopes,
                    scopeOverrides,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "CommonModelScope{organizationLevelScopes=$organizationLevelScopes, scopeOverrides=$scopeOverrides, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var organizationLevelScopes: JsonField<CommonModelScopeData> = JsonMissing.of()
        private var scopeOverrides: JsonField<List<CommonModelScopeData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(commonModelScope: CommonModelScope) = apply {
            this.organizationLevelScopes = commonModelScope.organizationLevelScopes
            this.scopeOverrides = commonModelScope.scopeOverrides
            additionalProperties(commonModelScope.additionalProperties)
        }

        fun organizationLevelScopes(organizationLevelScopes: CommonModelScopeData) =
            organizationLevelScopes(JsonField.of(organizationLevelScopes))

        @JsonProperty("organization_level_scopes")
        @ExcludeMissing
        fun organizationLevelScopes(organizationLevelScopes: JsonField<CommonModelScopeData>) =
            apply {
                this.organizationLevelScopes = organizationLevelScopes
            }

        fun scopeOverrides(scopeOverrides: List<CommonModelScopeData>) =
            scopeOverrides(JsonField.of(scopeOverrides))

        @JsonProperty("scope_overrides")
        @ExcludeMissing
        fun scopeOverrides(scopeOverrides: JsonField<List<CommonModelScopeData>>) = apply {
            this.scopeOverrides = scopeOverrides
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

        fun build(): CommonModelScope =
            CommonModelScope(
                organizationLevelScopes,
                scopeOverrides.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = CommonModelScopeData.Builder::class)
    @NoAutoDetect
    class CommonModelScopeData
    private constructor(
        private val commonModels: JsonField<List<CommonModelScopesDisabledModels>>,
        private val linkedAccountId: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun commonModels(): List<CommonModelScopesDisabledModels> =
            commonModels.getRequired("common_models")

        fun linkedAccountId(): Optional<String> =
            Optional.ofNullable(linkedAccountId.getNullable("linked_account_id"))

        @JsonProperty("common_models") @ExcludeMissing fun _commonModels() = commonModels

        @JsonProperty("linked_account_id") @ExcludeMissing fun _linkedAccountId() = linkedAccountId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                commonModels().forEach { it.validate() }
                linkedAccountId()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CommonModelScopeData &&
                this.commonModels == other.commonModels &&
                this.linkedAccountId == other.linkedAccountId &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        commonModels,
                        linkedAccountId,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CommonModelScopeData{commonModels=$commonModels, linkedAccountId=$linkedAccountId, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var commonModels: JsonField<List<CommonModelScopesDisabledModels>> =
                JsonMissing.of()
            private var linkedAccountId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(commonModelScopeData: CommonModelScopeData) = apply {
                this.commonModels = commonModelScopeData.commonModels
                this.linkedAccountId = commonModelScopeData.linkedAccountId
                additionalProperties(commonModelScopeData.additionalProperties)
            }

            fun commonModels(commonModels: List<CommonModelScopesDisabledModels>) =
                commonModels(JsonField.of(commonModels))

            @JsonProperty("common_models")
            @ExcludeMissing
            fun commonModels(commonModels: JsonField<List<CommonModelScopesDisabledModels>>) =
                apply {
                    this.commonModels = commonModels
                }

            fun linkedAccountId(linkedAccountId: String) =
                linkedAccountId(JsonField.of(linkedAccountId))

            @JsonProperty("linked_account_id")
            @ExcludeMissing
            fun linkedAccountId(linkedAccountId: JsonField<String>) = apply {
                this.linkedAccountId = linkedAccountId
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

            fun build(): CommonModelScopeData =
                CommonModelScopeData(
                    commonModels.map { it.toUnmodifiable() },
                    linkedAccountId,
                    additionalProperties.toUnmodifiable(),
                )
        }

        @JsonDeserialize(builder = CommonModelScopesDisabledModels.Builder::class)
        @NoAutoDetect
        class CommonModelScopesDisabledModels
        private constructor(
            private val modelName: JsonField<String>,
            private val modelId: JsonField<String>,
            private val enabledActions:
                JsonField<List<CommonModelScopesDisabledModelsEnabledActionsEnum>>,
            private val isDisabled: JsonField<Boolean>,
            private val disabledFields: JsonField<List<String>>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            fun modelName(): String = modelName.getRequired("model_name")

            fun modelId(): String = modelId.getRequired("model_id")

            fun enabledActions(): List<CommonModelScopesDisabledModelsEnabledActionsEnum> =
                enabledActions.getRequired("enabled_actions")

            fun isDisabled(): Boolean = isDisabled.getRequired("is_disabled")

            fun disabledFields(): List<String> = disabledFields.getRequired("disabled_fields")

            @JsonProperty("model_name") @ExcludeMissing fun _modelName() = modelName

            @JsonProperty("model_id") @ExcludeMissing fun _modelId() = modelId

            @JsonProperty("enabled_actions") @ExcludeMissing fun _enabledActions() = enabledActions

            @JsonProperty("is_disabled") @ExcludeMissing fun _isDisabled() = isDisabled

            @JsonProperty("disabled_fields") @ExcludeMissing fun _disabledFields() = disabledFields

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate() = apply {
                if (!validated) {
                    modelName()
                    modelId()
                    enabledActions()
                    isDisabled()
                    disabledFields()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CommonModelScopesDisabledModels &&
                    this.modelName == other.modelName &&
                    this.modelId == other.modelId &&
                    this.enabledActions == other.enabledActions &&
                    this.isDisabled == other.isDisabled &&
                    this.disabledFields == other.disabledFields &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            modelName,
                            modelId,
                            enabledActions,
                            isDisabled,
                            disabledFields,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "CommonModelScopesDisabledModels{modelName=$modelName, modelId=$modelId, enabledActions=$enabledActions, isDisabled=$isDisabled, disabledFields=$disabledFields, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var modelName: JsonField<String> = JsonMissing.of()
                private var modelId: JsonField<String> = JsonMissing.of()
                private var enabledActions:
                    JsonField<List<CommonModelScopesDisabledModelsEnabledActionsEnum>> =
                    JsonMissing.of()
                private var isDisabled: JsonField<Boolean> = JsonMissing.of()
                private var disabledFields: JsonField<List<String>> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(
                    commonModelScopesDisabledModels: CommonModelScopesDisabledModels
                ) = apply {
                    this.modelName = commonModelScopesDisabledModels.modelName
                    this.modelId = commonModelScopesDisabledModels.modelId
                    this.enabledActions = commonModelScopesDisabledModels.enabledActions
                    this.isDisabled = commonModelScopesDisabledModels.isDisabled
                    this.disabledFields = commonModelScopesDisabledModels.disabledFields
                    additionalProperties(commonModelScopesDisabledModels.additionalProperties)
                }

                fun modelName(modelName: String) = modelName(JsonField.of(modelName))

                @JsonProperty("model_name")
                @ExcludeMissing
                fun modelName(modelName: JsonField<String>) = apply { this.modelName = modelName }

                fun modelId(modelId: String) = modelId(JsonField.of(modelId))

                @JsonProperty("model_id")
                @ExcludeMissing
                fun modelId(modelId: JsonField<String>) = apply { this.modelId = modelId }

                fun enabledActions(
                    enabledActions: List<CommonModelScopesDisabledModelsEnabledActionsEnum>
                ) = enabledActions(JsonField.of(enabledActions))

                @JsonProperty("enabled_actions")
                @ExcludeMissing
                fun enabledActions(
                    enabledActions:
                        JsonField<List<CommonModelScopesDisabledModelsEnabledActionsEnum>>
                ) = apply { this.enabledActions = enabledActions }

                fun isDisabled(isDisabled: Boolean) = isDisabled(JsonField.of(isDisabled))

                @JsonProperty("is_disabled")
                @ExcludeMissing
                fun isDisabled(isDisabled: JsonField<Boolean>) = apply {
                    this.isDisabled = isDisabled
                }

                fun disabledFields(disabledFields: List<String>) =
                    disabledFields(JsonField.of(disabledFields))

                @JsonProperty("disabled_fields")
                @ExcludeMissing
                fun disabledFields(disabledFields: JsonField<List<String>>) = apply {
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

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): CommonModelScopesDisabledModels =
                    CommonModelScopesDisabledModels(
                        modelName,
                        modelId,
                        enabledActions.map { it.toUnmodifiable() },
                        isDisabled,
                        disabledFields.map { it.toUnmodifiable() },
                        additionalProperties.toUnmodifiable(),
                    )
            }

            class CommonModelScopesDisabledModelsEnabledActionsEnum
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is CommonModelScopesDisabledModelsEnabledActionsEnum &&
                        this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    @JvmField
                    val ENABLED_ACTION_READ =
                        CommonModelScopesDisabledModelsEnabledActionsEnum(
                            JsonField.of("ENABLED_ACTION_READ")
                        )

                    @JvmField
                    val ENABLED_ACTION_WRITE =
                        CommonModelScopesDisabledModelsEnabledActionsEnum(
                            JsonField.of("ENABLED_ACTION_WRITE")
                        )

                    @JvmStatic
                    fun of(value: String) =
                        CommonModelScopesDisabledModelsEnabledActionsEnum(JsonField.of(value))
                }

                enum class Known {
                    ENABLED_ACTION_READ,
                    ENABLED_ACTION_WRITE,
                }

                enum class Value {
                    ENABLED_ACTION_READ,
                    ENABLED_ACTION_WRITE,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        ENABLED_ACTION_READ -> Value.ENABLED_ACTION_READ
                        ENABLED_ACTION_WRITE -> Value.ENABLED_ACTION_WRITE
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        ENABLED_ACTION_READ -> Known.ENABLED_ACTION_READ
                        ENABLED_ACTION_WRITE -> Known.ENABLED_ACTION_WRITE
                        else ->
                            throw MergeInvalidDataException(
                                "Unknown CommonModelScopesDisabledModelsEnabledActionsEnum: $value"
                            )
                    }

                fun asString(): String = _value().asStringOrThrow()
            }
        }
    }
}
