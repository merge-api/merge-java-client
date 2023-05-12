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

class LinkTokenCreateParams
constructor(
    private val endUserEmailAddress: String,
    private val endUserOrganizationName: String,
    private val endUserOriginId: String,
    private val categories: List<CategoriesEnum>,
    private val integration: String?,
    private val linkExpiryMins: Long?,
    private val shouldCreateMagicLinkUrl: Boolean?,
    private val commonModels: List<CommonModelScopesBodyRequest>?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun endUserEmailAddress(): String = endUserEmailAddress

    fun endUserOrganizationName(): String = endUserOrganizationName

    fun endUserOriginId(): String = endUserOriginId

    fun categories(): List<CategoriesEnum> = categories

    fun integration(): Optional<String> = Optional.ofNullable(integration)

    fun linkExpiryMins(): Optional<Long> = Optional.ofNullable(linkExpiryMins)

    fun shouldCreateMagicLinkUrl(): Optional<Boolean> =
        Optional.ofNullable(shouldCreateMagicLinkUrl)

    fun commonModels(): Optional<List<CommonModelScopesBodyRequest>> =
        Optional.ofNullable(commonModels)

    @JvmSynthetic
    internal fun getBody(): LinkTokenCreateBody {
        return LinkTokenCreateBody(
            endUserEmailAddress,
            endUserOrganizationName,
            endUserOriginId,
            categories,
            integration,
            linkExpiryMins,
            shouldCreateMagicLinkUrl,
            commonModels,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = LinkTokenCreateBody.Builder::class)
    @NoAutoDetect
    class LinkTokenCreateBody
    internal constructor(
        private val endUserEmailAddress: String?,
        private val endUserOrganizationName: String?,
        private val endUserOriginId: String?,
        private val categories: List<CategoriesEnum>?,
        private val integration: String?,
        private val linkExpiryMins: Long?,
        private val shouldCreateMagicLinkUrl: Boolean?,
        private val commonModels: List<CommonModelScopesBodyRequest>?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * Your end user's email address. This is purely for identification purposes - setting this
         * value will not cause any emails to be sent.
         */
        @JsonProperty("end_user_email_address")
        fun endUserEmailAddress(): String? = endUserEmailAddress

        /** Your end user's organization. */
        @JsonProperty("end_user_organization_name")
        fun endUserOrganizationName(): String? = endUserOrganizationName

        /**
         * This unique identifier typically represents the ID for your end user in your product's
         * database. This value must be distinct from other Linked Accounts' unique identifiers.
         */
        @JsonProperty("end_user_origin_id") fun endUserOriginId(): String? = endUserOriginId

        /** The integration categories to show in Merge Link. */
        @JsonProperty("categories") fun categories(): List<CategoriesEnum>? = categories

        /**
         * The slug of a specific pre-selected integration for this linking flow token. For examples
         * of slugs, see https://www.merge.dev/docs/basics/integration-metadata/.
         */
        @JsonProperty("integration") fun integration(): String? = integration

        /**
         * An integer number of minutes between [30, 720 or 10080 if for a Magic Link URL] for how
         * long this token is valid. Defaults to 30.
         */
        @JsonProperty("link_expiry_mins") fun linkExpiryMins(): Long? = linkExpiryMins

        /**
         * Whether to generate a Magic Link URL. Defaults to false. For more information on Magic
         * Link, see https://merge.dev/blog/product/integrations,-fast.-say-hello-to-magic-link/.
         */
        @JsonProperty("should_create_magic_link_url")
        fun shouldCreateMagicLinkUrl(): Boolean? = shouldCreateMagicLinkUrl

        /**
         * An array of objects to specify the models and fields that will be disabled for a given
         * Linked Account. Each object uses model_id, enabled_actions, and disabled_fields to
         * specify the model, method, and fields that are scoped for a given Linked Account.
         */
        @JsonProperty("common_models")
        fun commonModels(): List<CommonModelScopesBodyRequest>? = commonModels

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LinkTokenCreateBody &&
                this.endUserEmailAddress == other.endUserEmailAddress &&
                this.endUserOrganizationName == other.endUserOrganizationName &&
                this.endUserOriginId == other.endUserOriginId &&
                this.categories == other.categories &&
                this.integration == other.integration &&
                this.linkExpiryMins == other.linkExpiryMins &&
                this.shouldCreateMagicLinkUrl == other.shouldCreateMagicLinkUrl &&
                this.commonModels == other.commonModels &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        endUserEmailAddress,
                        endUserOrganizationName,
                        endUserOriginId,
                        categories,
                        integration,
                        linkExpiryMins,
                        shouldCreateMagicLinkUrl,
                        commonModels,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "LinkTokenCreateBody{endUserEmailAddress=$endUserEmailAddress, endUserOrganizationName=$endUserOrganizationName, endUserOriginId=$endUserOriginId, categories=$categories, integration=$integration, linkExpiryMins=$linkExpiryMins, shouldCreateMagicLinkUrl=$shouldCreateMagicLinkUrl, commonModels=$commonModels, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var endUserEmailAddress: String? = null
            private var endUserOrganizationName: String? = null
            private var endUserOriginId: String? = null
            private var categories: List<CategoriesEnum>? = null
            private var integration: String? = null
            private var linkExpiryMins: Long? = null
            private var shouldCreateMagicLinkUrl: Boolean? = null
            private var commonModels: List<CommonModelScopesBodyRequest>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(linkTokenCreateBody: LinkTokenCreateBody) = apply {
                this.endUserEmailAddress = linkTokenCreateBody.endUserEmailAddress
                this.endUserOrganizationName = linkTokenCreateBody.endUserOrganizationName
                this.endUserOriginId = linkTokenCreateBody.endUserOriginId
                this.categories = linkTokenCreateBody.categories
                this.integration = linkTokenCreateBody.integration
                this.linkExpiryMins = linkTokenCreateBody.linkExpiryMins
                this.shouldCreateMagicLinkUrl = linkTokenCreateBody.shouldCreateMagicLinkUrl
                this.commonModels = linkTokenCreateBody.commonModels
                additionalProperties(linkTokenCreateBody.additionalProperties)
            }

            /**
             * Your end user's email address. This is purely for identification purposes - setting
             * this value will not cause any emails to be sent.
             */
            @JsonProperty("end_user_email_address")
            fun endUserEmailAddress(endUserEmailAddress: String) = apply {
                this.endUserEmailAddress = endUserEmailAddress
            }

            /** Your end user's organization. */
            @JsonProperty("end_user_organization_name")
            fun endUserOrganizationName(endUserOrganizationName: String) = apply {
                this.endUserOrganizationName = endUserOrganizationName
            }

            /**
             * This unique identifier typically represents the ID for your end user in your
             * product's database. This value must be distinct from other Linked Accounts' unique
             * identifiers.
             */
            @JsonProperty("end_user_origin_id")
            fun endUserOriginId(endUserOriginId: String) = apply {
                this.endUserOriginId = endUserOriginId
            }

            /** The integration categories to show in Merge Link. */
            @JsonProperty("categories")
            fun categories(categories: List<CategoriesEnum>) = apply {
                this.categories = categories
            }

            /**
             * The slug of a specific pre-selected integration for this linking flow token. For
             * examples of slugs, see https://www.merge.dev/docs/basics/integration-metadata/.
             */
            @JsonProperty("integration")
            fun integration(integration: String) = apply { this.integration = integration }

            /**
             * An integer number of minutes between [30, 720 or 10080 if for a Magic Link URL] for
             * how long this token is valid. Defaults to 30.
             */
            @JsonProperty("link_expiry_mins")
            fun linkExpiryMins(linkExpiryMins: Long) = apply {
                this.linkExpiryMins = linkExpiryMins
            }

            /**
             * Whether to generate a Magic Link URL. Defaults to false. For more information on
             * Magic Link, see
             * https://merge.dev/blog/product/integrations,-fast.-say-hello-to-magic-link/.
             */
            @JsonProperty("should_create_magic_link_url")
            fun shouldCreateMagicLinkUrl(shouldCreateMagicLinkUrl: Boolean) = apply {
                this.shouldCreateMagicLinkUrl = shouldCreateMagicLinkUrl
            }

            /**
             * An array of objects to specify the models and fields that will be disabled for a
             * given Linked Account. Each object uses model_id, enabled_actions, and disabled_fields
             * to specify the model, method, and fields that are scoped for a given Linked Account.
             */
            @JsonProperty("common_models")
            fun commonModels(commonModels: List<CommonModelScopesBodyRequest>) = apply {
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

            fun build(): LinkTokenCreateBody =
                LinkTokenCreateBody(
                    checkNotNull(endUserEmailAddress) {
                        "`endUserEmailAddress` is required but was not set"
                    },
                    checkNotNull(endUserOrganizationName) {
                        "`endUserOrganizationName` is required but was not set"
                    },
                    checkNotNull(endUserOriginId) {
                        "`endUserOriginId` is required but was not set"
                    },
                    checkNotNull(categories) { "`categories` is required but was not set" }
                        .toUnmodifiable(),
                    integration,
                    linkExpiryMins,
                    shouldCreateMagicLinkUrl,
                    commonModels?.toUnmodifiable(),
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

        return other is LinkTokenCreateParams &&
            this.endUserEmailAddress == other.endUserEmailAddress &&
            this.endUserOrganizationName == other.endUserOrganizationName &&
            this.endUserOriginId == other.endUserOriginId &&
            this.categories == other.categories &&
            this.integration == other.integration &&
            this.linkExpiryMins == other.linkExpiryMins &&
            this.shouldCreateMagicLinkUrl == other.shouldCreateMagicLinkUrl &&
            this.commonModels == other.commonModels &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            endUserEmailAddress,
            endUserOrganizationName,
            endUserOriginId,
            categories,
            integration,
            linkExpiryMins,
            shouldCreateMagicLinkUrl,
            commonModels,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "LinkTokenCreateParams{endUserEmailAddress=$endUserEmailAddress, endUserOrganizationName=$endUserOrganizationName, endUserOriginId=$endUserOriginId, categories=$categories, integration=$integration, linkExpiryMins=$linkExpiryMins, shouldCreateMagicLinkUrl=$shouldCreateMagicLinkUrl, commonModels=$commonModels, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var endUserEmailAddress: String? = null
        private var endUserOrganizationName: String? = null
        private var endUserOriginId: String? = null
        private var categories: List<CategoriesEnum>? = null
        private var integration: String? = null
        private var linkExpiryMins: Long? = null
        private var shouldCreateMagicLinkUrl: Boolean? = null
        private var commonModels: List<CommonModelScopesBodyRequest>? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(linkTokenCreateParams: LinkTokenCreateParams) = apply {
            this.endUserEmailAddress = linkTokenCreateParams.endUserEmailAddress
            this.endUserOrganizationName = linkTokenCreateParams.endUserOrganizationName
            this.endUserOriginId = linkTokenCreateParams.endUserOriginId
            this.categories = linkTokenCreateParams.categories
            this.integration = linkTokenCreateParams.integration
            this.linkExpiryMins = linkTokenCreateParams.linkExpiryMins
            this.shouldCreateMagicLinkUrl = linkTokenCreateParams.shouldCreateMagicLinkUrl
            this.commonModels = linkTokenCreateParams.commonModels
            additionalQueryParams(linkTokenCreateParams.additionalQueryParams)
            additionalHeaders(linkTokenCreateParams.additionalHeaders)
            additionalBodyProperties(linkTokenCreateParams.additionalBodyProperties)
        }

        /**
         * Your end user's email address. This is purely for identification purposes - setting this
         * value will not cause any emails to be sent.
         */
        fun endUserEmailAddress(endUserEmailAddress: String) = apply {
            this.endUserEmailAddress = endUserEmailAddress
        }

        /** Your end user's organization. */
        fun endUserOrganizationName(endUserOrganizationName: String) = apply {
            this.endUserOrganizationName = endUserOrganizationName
        }

        /**
         * This unique identifier typically represents the ID for your end user in your product's
         * database. This value must be distinct from other Linked Accounts' unique identifiers.
         */
        fun endUserOriginId(endUserOriginId: String) = apply {
            this.endUserOriginId = endUserOriginId
        }

        /** The integration categories to show in Merge Link. */
        fun categories(categories: List<CategoriesEnum>) = apply { this.categories = categories }

        /**
         * The slug of a specific pre-selected integration for this linking flow token. For examples
         * of slugs, see https://www.merge.dev/docs/basics/integration-metadata/.
         */
        fun integration(integration: String) = apply { this.integration = integration }

        /**
         * An integer number of minutes between [30, 720 or 10080 if for a Magic Link URL] for how
         * long this token is valid. Defaults to 30.
         */
        fun linkExpiryMins(linkExpiryMins: Long) = apply { this.linkExpiryMins = linkExpiryMins }

        /**
         * Whether to generate a Magic Link URL. Defaults to false. For more information on Magic
         * Link, see https://merge.dev/blog/product/integrations,-fast.-say-hello-to-magic-link/.
         */
        fun shouldCreateMagicLinkUrl(shouldCreateMagicLinkUrl: Boolean) = apply {
            this.shouldCreateMagicLinkUrl = shouldCreateMagicLinkUrl
        }

        /**
         * An array of objects to specify the models and fields that will be disabled for a given
         * Linked Account. Each object uses model_id, enabled_actions, and disabled_fields to
         * specify the model, method, and fields that are scoped for a given Linked Account.
         */
        fun commonModels(commonModels: List<CommonModelScopesBodyRequest>) = apply {
            this.commonModels = commonModels
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

        fun build(): LinkTokenCreateParams =
            LinkTokenCreateParams(
                checkNotNull(endUserEmailAddress) {
                    "`endUserEmailAddress` is required but was not set"
                },
                checkNotNull(endUserOrganizationName) {
                    "`endUserOrganizationName` is required but was not set"
                },
                checkNotNull(endUserOriginId) { "`endUserOriginId` is required but was not set" },
                checkNotNull(categories) { "`categories` is required but was not set" }
                    .toUnmodifiable(),
                integration,
                linkExpiryMins,
                shouldCreateMagicLinkUrl,
                commonModels?.toUnmodifiable(),
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    class CategoriesEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CategoriesEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val HRIS = CategoriesEnum(JsonField.of("hris"))

            @JvmField val ATS = CategoriesEnum(JsonField.of("ats"))

            @JvmField val ACCOUNTING = CategoriesEnum(JsonField.of("accounting"))

            @JvmField val TICKETING = CategoriesEnum(JsonField.of("ticketing"))

            @JvmField val CRM = CategoriesEnum(JsonField.of("crm"))

            @JvmField val MKTG = CategoriesEnum(JsonField.of("mktg"))

            @JvmField val FILESTORAGE = CategoriesEnum(JsonField.of("filestorage"))

            @JvmStatic fun of(value: String) = CategoriesEnum(JsonField.of(value))
        }

        enum class Known {
            HRIS,
            ATS,
            ACCOUNTING,
            TICKETING,
            CRM,
            MKTG,
            FILESTORAGE,
        }

        enum class Value {
            HRIS,
            ATS,
            ACCOUNTING,
            TICKETING,
            CRM,
            MKTG,
            FILESTORAGE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                HRIS -> Value.HRIS
                ATS -> Value.ATS
                ACCOUNTING -> Value.ACCOUNTING
                TICKETING -> Value.TICKETING
                CRM -> Value.CRM
                MKTG -> Value.MKTG
                FILESTORAGE -> Value.FILESTORAGE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                HRIS -> Known.HRIS
                ATS -> Known.ATS
                ACCOUNTING -> Known.ACCOUNTING
                TICKETING -> Known.TICKETING
                CRM -> Known.CRM
                MKTG -> Known.MKTG
                FILESTORAGE -> Known.FILESTORAGE
                else -> throw MergeInvalidDataException("Unknown CategoriesEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = CommonModelScopesBodyRequest.Builder::class)
    @NoAutoDetect
    class CommonModelScopesBodyRequest
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

            return other is CommonModelScopesBodyRequest &&
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
            "CommonModelScopesBodyRequest{modelId=$modelId, enabledActions=$enabledActions, disabledFields=$disabledFields, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var modelId: String? = null
            private var enabledActions: List<EnabledActionsEnum>? = null
            private var disabledFields: List<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(commonModelScopesBodyRequest: CommonModelScopesBodyRequest) = apply {
                this.modelId = commonModelScopesBodyRequest.modelId
                this.enabledActions = commonModelScopesBodyRequest.enabledActions
                this.disabledFields = commonModelScopesBodyRequest.disabledFields
                additionalProperties(commonModelScopesBodyRequest.additionalProperties)
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

            fun build(): CommonModelScopesBodyRequest =
                CommonModelScopesBodyRequest(
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
