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

/**
 * # The AvailableActions Object
 *
 * ### Description
 *
 * The `Activity` object is used to see all available model/operation combinations for an
 * integration.
 *
 * ### Usage Example
 *
 * Fetch all the actions available for the `Zenefits` integration.
 */
@JsonDeserialize(builder = AvailableAction.Builder::class)
@NoAutoDetect
class AvailableAction
private constructor(
    private val integration: JsonField<AccountIntegration>,
    private val passthroughAvailable: JsonField<Boolean>,
    private val availableModelOperations: JsonField<List<ModelOperation>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun integration(): AccountIntegration = integration.getRequired("integration")

    fun passthroughAvailable(): Boolean = passthroughAvailable.getRequired("passthrough_available")

    fun availableModelOperations(): Optional<List<ModelOperation>> =
        Optional.ofNullable(availableModelOperations.getNullable("available_model_operations"))

    @JsonProperty("integration") @ExcludeMissing fun _integration() = integration

    @JsonProperty("passthrough_available")
    @ExcludeMissing
    fun _passthroughAvailable() = passthroughAvailable

    @JsonProperty("available_model_operations")
    @ExcludeMissing
    fun _availableModelOperations() = availableModelOperations

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            integration().validate()
            passthroughAvailable()
            availableModelOperations().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AvailableAction &&
            this.integration == other.integration &&
            this.passthroughAvailable == other.passthroughAvailable &&
            this.availableModelOperations == other.availableModelOperations &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    integration,
                    passthroughAvailable,
                    availableModelOperations,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "AvailableAction{integration=$integration, passthroughAvailable=$passthroughAvailable, availableModelOperations=$availableModelOperations, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var integration: JsonField<AccountIntegration> = JsonMissing.of()
        private var passthroughAvailable: JsonField<Boolean> = JsonMissing.of()
        private var availableModelOperations: JsonField<List<ModelOperation>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(availableAction: AvailableAction) = apply {
            this.integration = availableAction.integration
            this.passthroughAvailable = availableAction.passthroughAvailable
            this.availableModelOperations = availableAction.availableModelOperations
            additionalProperties(availableAction.additionalProperties)
        }

        fun integration(integration: AccountIntegration) = integration(JsonField.of(integration))

        @JsonProperty("integration")
        @ExcludeMissing
        fun integration(integration: JsonField<AccountIntegration>) = apply {
            this.integration = integration
        }

        fun passthroughAvailable(passthroughAvailable: Boolean) =
            passthroughAvailable(JsonField.of(passthroughAvailable))

        @JsonProperty("passthrough_available")
        @ExcludeMissing
        fun passthroughAvailable(passthroughAvailable: JsonField<Boolean>) = apply {
            this.passthroughAvailable = passthroughAvailable
        }

        fun availableModelOperations(availableModelOperations: List<ModelOperation>) =
            availableModelOperations(JsonField.of(availableModelOperations))

        @JsonProperty("available_model_operations")
        @ExcludeMissing
        fun availableModelOperations(availableModelOperations: JsonField<List<ModelOperation>>) =
            apply {
                this.availableModelOperations = availableModelOperations
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

        fun build(): AvailableAction =
            AvailableAction(
                integration,
                passthroughAvailable,
                availableModelOperations.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = AccountIntegration.Builder::class)
    @NoAutoDetect
    class AccountIntegration
    private constructor(
        private val name: JsonField<String>,
        private val categories: JsonField<List<CategoriesEnum>>,
        private val image: JsonField<String>,
        private val squareImage: JsonField<String>,
        private val color: JsonField<String>,
        private val slug: JsonField<String>,
        private val isInBeta: JsonField<Boolean>,
        private val apiEndpointsToDocumentationUrls: JsonValue,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** Company name. */
        fun name(): String = name.getRequired("name")

        /**
         * Category or categories this integration belongs to. Multiple categories should be comma
         * separated, i.e. [ats, hris].
         */
        fun categories(): Optional<List<CategoriesEnum>> =
            Optional.ofNullable(categories.getNullable("categories"))

        /** Company logo in rectangular shape. <b>Upload an image with a clear background.</b> */
        fun image(): Optional<String> = Optional.ofNullable(image.getNullable("image"))

        /** Company logo in square shape. <b>Upload an image with a white background.</b> */
        fun squareImage(): Optional<String> =
            Optional.ofNullable(squareImage.getNullable("square_image"))

        /**
         * The color of this integration used for buttons and text throughout the app and landing
         * pages. <b>Choose a darker, saturated color.</b>
         */
        fun color(): Optional<String> = Optional.ofNullable(color.getNullable("color"))

        fun slug(): Optional<String> = Optional.ofNullable(slug.getNullable("slug"))

        /**
         * If checked, this integration will not appear in the linking flow, and will appear
         * elsewhere with a Beta tag.
         */
        fun isInBeta(): Optional<Boolean> = Optional.ofNullable(isInBeta.getNullable("is_in_beta"))

        /** Company name. */
        @JsonProperty("name") @ExcludeMissing fun _name() = name

        /**
         * Category or categories this integration belongs to. Multiple categories should be comma
         * separated, i.e. [ats, hris].
         */
        @JsonProperty("categories") @ExcludeMissing fun _categories() = categories

        /** Company logo in rectangular shape. <b>Upload an image with a clear background.</b> */
        @JsonProperty("image") @ExcludeMissing fun _image() = image

        /** Company logo in square shape. <b>Upload an image with a white background.</b> */
        @JsonProperty("square_image") @ExcludeMissing fun _squareImage() = squareImage

        /**
         * The color of this integration used for buttons and text throughout the app and landing
         * pages. <b>Choose a darker, saturated color.</b>
         */
        @JsonProperty("color") @ExcludeMissing fun _color() = color

        @JsonProperty("slug") @ExcludeMissing fun _slug() = slug

        /**
         * If checked, this integration will not appear in the linking flow, and will appear
         * elsewhere with a Beta tag.
         */
        @JsonProperty("is_in_beta") @ExcludeMissing fun _isInBeta() = isInBeta

        /**
         * Mapping of API endpoints to documentation urls for support. Example: {'GET':
         * [['/common-model-scopes',
         * 'https://docs.merge.dev/accounting/common-model-scopes/#common_model_scopes_retrieve'],['/common-model-actions',
         * 'https://docs.merge.dev/accounting/common-model-actions/#common_model_actions_retrieve']],
         * 'POST': []}
         */
        @JsonProperty("api_endpoints_to_documentation_urls")
        @ExcludeMissing
        fun _apiEndpointsToDocumentationUrls() = apiEndpointsToDocumentationUrls

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                name()
                categories()
                image()
                squareImage()
                color()
                slug()
                isInBeta()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AccountIntegration &&
                this.name == other.name &&
                this.categories == other.categories &&
                this.image == other.image &&
                this.squareImage == other.squareImage &&
                this.color == other.color &&
                this.slug == other.slug &&
                this.isInBeta == other.isInBeta &&
                this.apiEndpointsToDocumentationUrls == other.apiEndpointsToDocumentationUrls &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        name,
                        categories,
                        image,
                        squareImage,
                        color,
                        slug,
                        isInBeta,
                        apiEndpointsToDocumentationUrls,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "AccountIntegration{name=$name, categories=$categories, image=$image, squareImage=$squareImage, color=$color, slug=$slug, isInBeta=$isInBeta, apiEndpointsToDocumentationUrls=$apiEndpointsToDocumentationUrls, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: JsonField<String> = JsonMissing.of()
            private var categories: JsonField<List<CategoriesEnum>> = JsonMissing.of()
            private var image: JsonField<String> = JsonMissing.of()
            private var squareImage: JsonField<String> = JsonMissing.of()
            private var color: JsonField<String> = JsonMissing.of()
            private var slug: JsonField<String> = JsonMissing.of()
            private var isInBeta: JsonField<Boolean> = JsonMissing.of()
            private var apiEndpointsToDocumentationUrls: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(accountIntegration: AccountIntegration) = apply {
                this.name = accountIntegration.name
                this.categories = accountIntegration.categories
                this.image = accountIntegration.image
                this.squareImage = accountIntegration.squareImage
                this.color = accountIntegration.color
                this.slug = accountIntegration.slug
                this.isInBeta = accountIntegration.isInBeta
                this.apiEndpointsToDocumentationUrls =
                    accountIntegration.apiEndpointsToDocumentationUrls
                additionalProperties(accountIntegration.additionalProperties)
            }

            /** Company name. */
            fun name(name: String) = name(JsonField.of(name))

            /** Company name. */
            @JsonProperty("name")
            @ExcludeMissing
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * Category or categories this integration belongs to. Multiple categories should be
             * comma separated, i.e. [ats, hris].
             */
            fun categories(categories: List<CategoriesEnum>) = categories(JsonField.of(categories))

            /**
             * Category or categories this integration belongs to. Multiple categories should be
             * comma separated, i.e. [ats, hris].
             */
            @JsonProperty("categories")
            @ExcludeMissing
            fun categories(categories: JsonField<List<CategoriesEnum>>) = apply {
                this.categories = categories
            }

            /**
             * Company logo in rectangular shape. <b>Upload an image with a clear background.</b>
             */
            fun image(image: String) = image(JsonField.of(image))

            /**
             * Company logo in rectangular shape. <b>Upload an image with a clear background.</b>
             */
            @JsonProperty("image")
            @ExcludeMissing
            fun image(image: JsonField<String>) = apply { this.image = image }

            /** Company logo in square shape. <b>Upload an image with a white background.</b> */
            fun squareImage(squareImage: String) = squareImage(JsonField.of(squareImage))

            /** Company logo in square shape. <b>Upload an image with a white background.</b> */
            @JsonProperty("square_image")
            @ExcludeMissing
            fun squareImage(squareImage: JsonField<String>) = apply {
                this.squareImage = squareImage
            }

            /**
             * The color of this integration used for buttons and text throughout the app and
             * landing pages. <b>Choose a darker, saturated color.</b>
             */
            fun color(color: String) = color(JsonField.of(color))

            /**
             * The color of this integration used for buttons and text throughout the app and
             * landing pages. <b>Choose a darker, saturated color.</b>
             */
            @JsonProperty("color")
            @ExcludeMissing
            fun color(color: JsonField<String>) = apply { this.color = color }

            fun slug(slug: String) = slug(JsonField.of(slug))

            @JsonProperty("slug")
            @ExcludeMissing
            fun slug(slug: JsonField<String>) = apply { this.slug = slug }

            /**
             * If checked, this integration will not appear in the linking flow, and will appear
             * elsewhere with a Beta tag.
             */
            fun isInBeta(isInBeta: Boolean) = isInBeta(JsonField.of(isInBeta))

            /**
             * If checked, this integration will not appear in the linking flow, and will appear
             * elsewhere with a Beta tag.
             */
            @JsonProperty("is_in_beta")
            @ExcludeMissing
            fun isInBeta(isInBeta: JsonField<Boolean>) = apply { this.isInBeta = isInBeta }

            /**
             * Mapping of API endpoints to documentation urls for support. Example: {'GET':
             * [['/common-model-scopes',
             * 'https://docs.merge.dev/accounting/common-model-scopes/#common_model_scopes_retrieve'],['/common-model-actions',
             * 'https://docs.merge.dev/accounting/common-model-actions/#common_model_actions_retrieve']],
             * 'POST': []}
             */
            @JsonProperty("api_endpoints_to_documentation_urls")
            @ExcludeMissing
            fun apiEndpointsToDocumentationUrls(apiEndpointsToDocumentationUrls: JsonValue) =
                apply {
                    this.apiEndpointsToDocumentationUrls = apiEndpointsToDocumentationUrls
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

            fun build(): AccountIntegration =
                AccountIntegration(
                    name,
                    categories.map { it.toUnmodifiable() },
                    image,
                    squareImage,
                    color,
                    slug,
                    isInBeta,
                    apiEndpointsToDocumentationUrls,
                    additionalProperties.toUnmodifiable(),
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
    }

    /**
     * # The ModelOperation Object
     *
     * ### Description
     *
     * The `ModelOperation` object is used to represent the operations that are currently supported
     * for a given model.
     *
     * ### Usage Example
     *
     * View what operations are supported for the `Candidate` endpoint.
     */
    @JsonDeserialize(builder = ModelOperation.Builder::class)
    @NoAutoDetect
    class ModelOperation
    private constructor(
        private val modelName: JsonField<String>,
        private val availableOperations: JsonField<List<String>>,
        private val requiredPostParameters: JsonField<List<String>>,
        private val supportedFields: JsonField<List<String>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun modelName(): String = modelName.getRequired("model_name")

        fun availableOperations(): List<String> =
            availableOperations.getRequired("available_operations")

        fun requiredPostParameters(): List<String> =
            requiredPostParameters.getRequired("required_post_parameters")

        fun supportedFields(): List<String> = supportedFields.getRequired("supported_fields")

        @JsonProperty("model_name") @ExcludeMissing fun _modelName() = modelName

        @JsonProperty("available_operations")
        @ExcludeMissing
        fun _availableOperations() = availableOperations

        @JsonProperty("required_post_parameters")
        @ExcludeMissing
        fun _requiredPostParameters() = requiredPostParameters

        @JsonProperty("supported_fields") @ExcludeMissing fun _supportedFields() = supportedFields

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                modelName()
                availableOperations()
                requiredPostParameters()
                supportedFields()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ModelOperation &&
                this.modelName == other.modelName &&
                this.availableOperations == other.availableOperations &&
                this.requiredPostParameters == other.requiredPostParameters &&
                this.supportedFields == other.supportedFields &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        modelName,
                        availableOperations,
                        requiredPostParameters,
                        supportedFields,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ModelOperation{modelName=$modelName, availableOperations=$availableOperations, requiredPostParameters=$requiredPostParameters, supportedFields=$supportedFields, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var modelName: JsonField<String> = JsonMissing.of()
            private var availableOperations: JsonField<List<String>> = JsonMissing.of()
            private var requiredPostParameters: JsonField<List<String>> = JsonMissing.of()
            private var supportedFields: JsonField<List<String>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(modelOperation: ModelOperation) = apply {
                this.modelName = modelOperation.modelName
                this.availableOperations = modelOperation.availableOperations
                this.requiredPostParameters = modelOperation.requiredPostParameters
                this.supportedFields = modelOperation.supportedFields
                additionalProperties(modelOperation.additionalProperties)
            }

            fun modelName(modelName: String) = modelName(JsonField.of(modelName))

            @JsonProperty("model_name")
            @ExcludeMissing
            fun modelName(modelName: JsonField<String>) = apply { this.modelName = modelName }

            fun availableOperations(availableOperations: List<String>) =
                availableOperations(JsonField.of(availableOperations))

            @JsonProperty("available_operations")
            @ExcludeMissing
            fun availableOperations(availableOperations: JsonField<List<String>>) = apply {
                this.availableOperations = availableOperations
            }

            fun requiredPostParameters(requiredPostParameters: List<String>) =
                requiredPostParameters(JsonField.of(requiredPostParameters))

            @JsonProperty("required_post_parameters")
            @ExcludeMissing
            fun requiredPostParameters(requiredPostParameters: JsonField<List<String>>) = apply {
                this.requiredPostParameters = requiredPostParameters
            }

            fun supportedFields(supportedFields: List<String>) =
                supportedFields(JsonField.of(supportedFields))

            @JsonProperty("supported_fields")
            @ExcludeMissing
            fun supportedFields(supportedFields: JsonField<List<String>>) = apply {
                this.supportedFields = supportedFields
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

            fun build(): ModelOperation =
                ModelOperation(
                    modelName,
                    availableOperations.map { it.toUnmodifiable() },
                    requiredPostParameters.map { it.toUnmodifiable() },
                    supportedFields.map { it.toUnmodifiable() },
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
