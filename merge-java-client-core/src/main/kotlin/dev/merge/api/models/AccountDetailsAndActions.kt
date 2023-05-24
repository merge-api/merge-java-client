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
 * # The LinkedAccount Object
 *
 * ### Description
 *
 * The `LinkedAccount` object is used to represent an end user's link with a specific integration.
 *
 * ### Usage Example
 *
 * View a list of your organization's `LinkedAccount` objects.
 */
@JsonDeserialize(builder = AccountDetailsAndActions.Builder::class)
@NoAutoDetect
class AccountDetailsAndActions
private constructor(
    private val id: JsonField<String>,
    private val category: JsonField<CategoryEnum>,
    private val status: JsonField<AccountDetailsAndActionsStatusEnum>,
    private val statusDetail: JsonField<String>,
    private val endUserOriginId: JsonField<String>,
    private val endUserOrganizationName: JsonField<String>,
    private val endUserEmailAddress: JsonField<String>,
    private val webhookListenerUrl: JsonField<String>,
    private val isDuplicate: JsonField<Boolean>,
    private val integration: JsonField<AccountDetailsAndActionsIntegration>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): String = id.getRequired("id")

    /**
     * - `hris` - hris
     * - `ats` - ats
     * - `accounting` - accounting
     * - `ticketing` - ticketing
     * - `crm` - crm
     * - `mktg` - mktg
     * - `filestorage` - filestorage
     */
    fun category(): Optional<CategoryEnum> = Optional.ofNullable(category.getNullable("category"))

    /**
     * - `COMPLETE` - COMPLETE
     * - `INCOMPLETE` - INCOMPLETE
     * - `RELINK_NEEDED` - RELINK_NEEDED
     */
    fun status(): AccountDetailsAndActionsStatusEnum = status.getRequired("status")

    fun statusDetail(): Optional<String> =
        Optional.ofNullable(statusDetail.getNullable("status_detail"))

    fun endUserOriginId(): Optional<String> =
        Optional.ofNullable(endUserOriginId.getNullable("end_user_origin_id"))

    fun endUserOrganizationName(): String =
        endUserOrganizationName.getRequired("end_user_organization_name")

    fun endUserEmailAddress(): String = endUserEmailAddress.getRequired("end_user_email_address")

    fun webhookListenerUrl(): String = webhookListenerUrl.getRequired("webhook_listener_url")

    /**
     * Whether a Production Linked Account's credentials match another existing Production Linked
     * Account. This field is `null` for Test Linked Accounts, incomplete Production Linked
     * Accounts, and ignored duplicate Production Linked Account sets.
     */
    fun isDuplicate(): Optional<Boolean> =
        Optional.ofNullable(isDuplicate.getNullable("is_duplicate"))

    fun integration(): Optional<AccountDetailsAndActionsIntegration> =
        Optional.ofNullable(integration.getNullable("integration"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /**
     * - `hris` - hris
     * - `ats` - ats
     * - `accounting` - accounting
     * - `ticketing` - ticketing
     * - `crm` - crm
     * - `mktg` - mktg
     * - `filestorage` - filestorage
     */
    @JsonProperty("category") @ExcludeMissing fun _category() = category

    /**
     * - `COMPLETE` - COMPLETE
     * - `INCOMPLETE` - INCOMPLETE
     * - `RELINK_NEEDED` - RELINK_NEEDED
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("status_detail") @ExcludeMissing fun _statusDetail() = statusDetail

    @JsonProperty("end_user_origin_id") @ExcludeMissing fun _endUserOriginId() = endUserOriginId

    @JsonProperty("end_user_organization_name")
    @ExcludeMissing
    fun _endUserOrganizationName() = endUserOrganizationName

    @JsonProperty("end_user_email_address")
    @ExcludeMissing
    fun _endUserEmailAddress() = endUserEmailAddress

    @JsonProperty("webhook_listener_url")
    @ExcludeMissing
    fun _webhookListenerUrl() = webhookListenerUrl

    /**
     * Whether a Production Linked Account's credentials match another existing Production Linked
     * Account. This field is `null` for Test Linked Accounts, incomplete Production Linked
     * Accounts, and ignored duplicate Production Linked Account sets.
     */
    @JsonProperty("is_duplicate") @ExcludeMissing fun _isDuplicate() = isDuplicate

    @JsonProperty("integration") @ExcludeMissing fun _integration() = integration

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): AccountDetailsAndActions = apply {
        if (!validated) {
            id()
            category()
            status()
            statusDetail()
            endUserOriginId()
            endUserOrganizationName()
            endUserEmailAddress()
            webhookListenerUrl()
            isDuplicate()
            integration().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountDetailsAndActions &&
            this.id == other.id &&
            this.category == other.category &&
            this.status == other.status &&
            this.statusDetail == other.statusDetail &&
            this.endUserOriginId == other.endUserOriginId &&
            this.endUserOrganizationName == other.endUserOrganizationName &&
            this.endUserEmailAddress == other.endUserEmailAddress &&
            this.webhookListenerUrl == other.webhookListenerUrl &&
            this.isDuplicate == other.isDuplicate &&
            this.integration == other.integration &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    category,
                    status,
                    statusDetail,
                    endUserOriginId,
                    endUserOrganizationName,
                    endUserEmailAddress,
                    webhookListenerUrl,
                    isDuplicate,
                    integration,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "AccountDetailsAndActions{id=$id, category=$category, status=$status, statusDetail=$statusDetail, endUserOriginId=$endUserOriginId, endUserOrganizationName=$endUserOrganizationName, endUserEmailAddress=$endUserEmailAddress, webhookListenerUrl=$webhookListenerUrl, isDuplicate=$isDuplicate, integration=$integration, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var category: JsonField<CategoryEnum> = JsonMissing.of()
        private var status: JsonField<AccountDetailsAndActionsStatusEnum> = JsonMissing.of()
        private var statusDetail: JsonField<String> = JsonMissing.of()
        private var endUserOriginId: JsonField<String> = JsonMissing.of()
        private var endUserOrganizationName: JsonField<String> = JsonMissing.of()
        private var endUserEmailAddress: JsonField<String> = JsonMissing.of()
        private var webhookListenerUrl: JsonField<String> = JsonMissing.of()
        private var isDuplicate: JsonField<Boolean> = JsonMissing.of()
        private var integration: JsonField<AccountDetailsAndActionsIntegration> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountDetailsAndActions: AccountDetailsAndActions) = apply {
            this.id = accountDetailsAndActions.id
            this.category = accountDetailsAndActions.category
            this.status = accountDetailsAndActions.status
            this.statusDetail = accountDetailsAndActions.statusDetail
            this.endUserOriginId = accountDetailsAndActions.endUserOriginId
            this.endUserOrganizationName = accountDetailsAndActions.endUserOrganizationName
            this.endUserEmailAddress = accountDetailsAndActions.endUserEmailAddress
            this.webhookListenerUrl = accountDetailsAndActions.webhookListenerUrl
            this.isDuplicate = accountDetailsAndActions.isDuplicate
            this.integration = accountDetailsAndActions.integration
            additionalProperties(accountDetailsAndActions.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * - `hris` - hris
         * - `ats` - ats
         * - `accounting` - accounting
         * - `ticketing` - ticketing
         * - `crm` - crm
         * - `mktg` - mktg
         * - `filestorage` - filestorage
         */
        fun category(category: CategoryEnum) = category(JsonField.of(category))

        /**
         * - `hris` - hris
         * - `ats` - ats
         * - `accounting` - accounting
         * - `ticketing` - ticketing
         * - `crm` - crm
         * - `mktg` - mktg
         * - `filestorage` - filestorage
         */
        @JsonProperty("category")
        @ExcludeMissing
        fun category(category: JsonField<CategoryEnum>) = apply { this.category = category }

        /**
         * - `COMPLETE` - COMPLETE
         * - `INCOMPLETE` - INCOMPLETE
         * - `RELINK_NEEDED` - RELINK_NEEDED
         */
        fun status(status: AccountDetailsAndActionsStatusEnum) = status(JsonField.of(status))

        /**
         * - `COMPLETE` - COMPLETE
         * - `INCOMPLETE` - INCOMPLETE
         * - `RELINK_NEEDED` - RELINK_NEEDED
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<AccountDetailsAndActionsStatusEnum>) = apply {
            this.status = status
        }

        fun statusDetail(statusDetail: String) = statusDetail(JsonField.of(statusDetail))

        @JsonProperty("status_detail")
        @ExcludeMissing
        fun statusDetail(statusDetail: JsonField<String>) = apply {
            this.statusDetail = statusDetail
        }

        fun endUserOriginId(endUserOriginId: String) =
            endUserOriginId(JsonField.of(endUserOriginId))

        @JsonProperty("end_user_origin_id")
        @ExcludeMissing
        fun endUserOriginId(endUserOriginId: JsonField<String>) = apply {
            this.endUserOriginId = endUserOriginId
        }

        fun endUserOrganizationName(endUserOrganizationName: String) =
            endUserOrganizationName(JsonField.of(endUserOrganizationName))

        @JsonProperty("end_user_organization_name")
        @ExcludeMissing
        fun endUserOrganizationName(endUserOrganizationName: JsonField<String>) = apply {
            this.endUserOrganizationName = endUserOrganizationName
        }

        fun endUserEmailAddress(endUserEmailAddress: String) =
            endUserEmailAddress(JsonField.of(endUserEmailAddress))

        @JsonProperty("end_user_email_address")
        @ExcludeMissing
        fun endUserEmailAddress(endUserEmailAddress: JsonField<String>) = apply {
            this.endUserEmailAddress = endUserEmailAddress
        }

        fun webhookListenerUrl(webhookListenerUrl: String) =
            webhookListenerUrl(JsonField.of(webhookListenerUrl))

        @JsonProperty("webhook_listener_url")
        @ExcludeMissing
        fun webhookListenerUrl(webhookListenerUrl: JsonField<String>) = apply {
            this.webhookListenerUrl = webhookListenerUrl
        }

        /**
         * Whether a Production Linked Account's credentials match another existing Production
         * Linked Account. This field is `null` for Test Linked Accounts, incomplete Production
         * Linked Accounts, and ignored duplicate Production Linked Account sets.
         */
        fun isDuplicate(isDuplicate: Boolean) = isDuplicate(JsonField.of(isDuplicate))

        /**
         * Whether a Production Linked Account's credentials match another existing Production
         * Linked Account. This field is `null` for Test Linked Accounts, incomplete Production
         * Linked Accounts, and ignored duplicate Production Linked Account sets.
         */
        @JsonProperty("is_duplicate")
        @ExcludeMissing
        fun isDuplicate(isDuplicate: JsonField<Boolean>) = apply { this.isDuplicate = isDuplicate }

        fun integration(integration: AccountDetailsAndActionsIntegration) =
            integration(JsonField.of(integration))

        @JsonProperty("integration")
        @ExcludeMissing
        fun integration(integration: JsonField<AccountDetailsAndActionsIntegration>) = apply {
            this.integration = integration
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

        fun build(): AccountDetailsAndActions =
            AccountDetailsAndActions(
                id,
                category,
                status,
                statusDetail,
                endUserOriginId,
                endUserOrganizationName,
                endUserEmailAddress,
                webhookListenerUrl,
                isDuplicate,
                integration,
                additionalProperties.toUnmodifiable(),
            )
    }

    class CategoryEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CategoryEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val HRIS = CategoryEnum(JsonField.of("hris"))

            @JvmField val ATS = CategoryEnum(JsonField.of("ats"))

            @JvmField val ACCOUNTING = CategoryEnum(JsonField.of("accounting"))

            @JvmField val TICKETING = CategoryEnum(JsonField.of("ticketing"))

            @JvmField val CRM = CategoryEnum(JsonField.of("crm"))

            @JvmField val MKTG = CategoryEnum(JsonField.of("mktg"))

            @JvmField val FILESTORAGE = CategoryEnum(JsonField.of("filestorage"))

            @JvmStatic fun of(value: String) = CategoryEnum(JsonField.of(value))
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
                else -> throw MergeInvalidDataException("Unknown CategoryEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class AccountDetailsAndActionsStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AccountDetailsAndActionsStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val COMPLETE = AccountDetailsAndActionsStatusEnum(JsonField.of("COMPLETE"))

            @JvmField
            val INCOMPLETE = AccountDetailsAndActionsStatusEnum(JsonField.of("INCOMPLETE"))

            @JvmField
            val RELINK_NEEDED = AccountDetailsAndActionsStatusEnum(JsonField.of("RELINK_NEEDED"))

            @JvmStatic
            fun of(value: String) = AccountDetailsAndActionsStatusEnum(JsonField.of(value))
        }

        enum class Known {
            COMPLETE,
            INCOMPLETE,
            RELINK_NEEDED,
        }

        enum class Value {
            COMPLETE,
            INCOMPLETE,
            RELINK_NEEDED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                COMPLETE -> Value.COMPLETE
                INCOMPLETE -> Value.INCOMPLETE
                RELINK_NEEDED -> Value.RELINK_NEEDED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                COMPLETE -> Known.COMPLETE
                INCOMPLETE -> Known.INCOMPLETE
                RELINK_NEEDED -> Known.RELINK_NEEDED
                else ->
                    throw MergeInvalidDataException(
                        "Unknown AccountDetailsAndActionsStatusEnum: $value"
                    )
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = AccountDetailsAndActionsIntegration.Builder::class)
    @NoAutoDetect
    class AccountDetailsAndActionsIntegration
    private constructor(
        private val name: JsonField<String>,
        private val categories: JsonField<List<CategoriesEnum>>,
        private val image: JsonField<String>,
        private val squareImage: JsonField<String>,
        private val color: JsonField<String>,
        private val slug: JsonField<String>,
        private val passthroughAvailable: JsonField<Boolean>,
        private val availableModelOperations: JsonField<List<ModelOperation>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun name(): String = name.getRequired("name")

        fun categories(): List<CategoriesEnum> = categories.getRequired("categories")

        fun image(): Optional<String> = Optional.ofNullable(image.getNullable("image"))

        fun squareImage(): Optional<String> =
            Optional.ofNullable(squareImage.getNullable("square_image"))

        fun color(): String = color.getRequired("color")

        fun slug(): String = slug.getRequired("slug")

        fun passthroughAvailable(): Boolean =
            passthroughAvailable.getRequired("passthrough_available")

        fun availableModelOperations(): Optional<List<ModelOperation>> =
            Optional.ofNullable(availableModelOperations.getNullable("available_model_operations"))

        @JsonProperty("name") @ExcludeMissing fun _name() = name

        @JsonProperty("categories") @ExcludeMissing fun _categories() = categories

        @JsonProperty("image") @ExcludeMissing fun _image() = image

        @JsonProperty("square_image") @ExcludeMissing fun _squareImage() = squareImage

        @JsonProperty("color") @ExcludeMissing fun _color() = color

        @JsonProperty("slug") @ExcludeMissing fun _slug() = slug

        @JsonProperty("passthrough_available")
        @ExcludeMissing
        fun _passthroughAvailable() = passthroughAvailable

        @JsonProperty("available_model_operations")
        @ExcludeMissing
        fun _availableModelOperations() = availableModelOperations

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): AccountDetailsAndActionsIntegration = apply {
            if (!validated) {
                name()
                categories()
                image()
                squareImage()
                color()
                slug()
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

            return other is AccountDetailsAndActionsIntegration &&
                this.name == other.name &&
                this.categories == other.categories &&
                this.image == other.image &&
                this.squareImage == other.squareImage &&
                this.color == other.color &&
                this.slug == other.slug &&
                this.passthroughAvailable == other.passthroughAvailable &&
                this.availableModelOperations == other.availableModelOperations &&
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
                        passthroughAvailable,
                        availableModelOperations,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "AccountDetailsAndActionsIntegration{name=$name, categories=$categories, image=$image, squareImage=$squareImage, color=$color, slug=$slug, passthroughAvailable=$passthroughAvailable, availableModelOperations=$availableModelOperations, additionalProperties=$additionalProperties}"

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
            private var passthroughAvailable: JsonField<Boolean> = JsonMissing.of()
            private var availableModelOperations: JsonField<List<ModelOperation>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                accountDetailsAndActionsIntegration: AccountDetailsAndActionsIntegration
            ) = apply {
                this.name = accountDetailsAndActionsIntegration.name
                this.categories = accountDetailsAndActionsIntegration.categories
                this.image = accountDetailsAndActionsIntegration.image
                this.squareImage = accountDetailsAndActionsIntegration.squareImage
                this.color = accountDetailsAndActionsIntegration.color
                this.slug = accountDetailsAndActionsIntegration.slug
                this.passthroughAvailable = accountDetailsAndActionsIntegration.passthroughAvailable
                this.availableModelOperations =
                    accountDetailsAndActionsIntegration.availableModelOperations
                additionalProperties(accountDetailsAndActionsIntegration.additionalProperties)
            }

            fun name(name: String) = name(JsonField.of(name))

            @JsonProperty("name")
            @ExcludeMissing
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun categories(categories: List<CategoriesEnum>) = categories(JsonField.of(categories))

            @JsonProperty("categories")
            @ExcludeMissing
            fun categories(categories: JsonField<List<CategoriesEnum>>) = apply {
                this.categories = categories
            }

            fun image(image: String) = image(JsonField.of(image))

            @JsonProperty("image")
            @ExcludeMissing
            fun image(image: JsonField<String>) = apply { this.image = image }

            fun squareImage(squareImage: String) = squareImage(JsonField.of(squareImage))

            @JsonProperty("square_image")
            @ExcludeMissing
            fun squareImage(squareImage: JsonField<String>) = apply {
                this.squareImage = squareImage
            }

            fun color(color: String) = color(JsonField.of(color))

            @JsonProperty("color")
            @ExcludeMissing
            fun color(color: JsonField<String>) = apply { this.color = color }

            fun slug(slug: String) = slug(JsonField.of(slug))

            @JsonProperty("slug")
            @ExcludeMissing
            fun slug(slug: JsonField<String>) = apply { this.slug = slug }

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
            fun availableModelOperations(
                availableModelOperations: JsonField<List<ModelOperation>>
            ) = apply { this.availableModelOperations = availableModelOperations }

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

            fun build(): AccountDetailsAndActionsIntegration =
                AccountDetailsAndActionsIntegration(
                    name,
                    categories.map { it.toUnmodifiable() },
                    image,
                    squareImage,
                    color,
                    slug,
                    passthroughAvailable,
                    availableModelOperations.map { it.toUnmodifiable() },
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

        /**
         * # The ModelOperation Object
         *
         * ### Description
         *
         * The `ModelOperation` object is used to represent the operations that are currently
         * supported for a given model.
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

            @JsonProperty("supported_fields")
            @ExcludeMissing
            fun _supportedFields() = supportedFields

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): ModelOperation = apply {
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
                fun requiredPostParameters(requiredPostParameters: JsonField<List<String>>) =
                    apply {
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

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
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
}
