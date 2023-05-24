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

@JsonDeserialize(builder = AccountDetail.Builder::class)
@NoAutoDetect
class AccountDetail
private constructor(
    private val id: JsonField<String>,
    private val integration: JsonField<String>,
    private val integrationSlug: JsonField<String>,
    private val category: JsonField<CategoryEnum>,
    private val endUserOriginId: JsonField<String>,
    private val endUserOrganizationName: JsonField<String>,
    private val endUserEmailAddress: JsonField<String>,
    private val status: JsonField<String>,
    private val webhookListenerUrl: JsonField<String>,
    private val isDuplicate: JsonField<Boolean>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    fun integration(): Optional<String> =
        Optional.ofNullable(integration.getNullable("integration"))

    fun integrationSlug(): Optional<String> =
        Optional.ofNullable(integrationSlug.getNullable("integration_slug"))

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

    fun endUserOriginId(): Optional<String> =
        Optional.ofNullable(endUserOriginId.getNullable("end_user_origin_id"))

    fun endUserOrganizationName(): Optional<String> =
        Optional.ofNullable(endUserOrganizationName.getNullable("end_user_organization_name"))

    fun endUserEmailAddress(): Optional<String> =
        Optional.ofNullable(endUserEmailAddress.getNullable("end_user_email_address"))

    fun status(): Optional<String> = Optional.ofNullable(status.getNullable("status"))

    fun webhookListenerUrl(): Optional<String> =
        Optional.ofNullable(webhookListenerUrl.getNullable("webhook_listener_url"))

    /**
     * Whether a Production Linked Account's credentials match another existing Production Linked
     * Account. This field is `null` for Test Linked Accounts, incomplete Production Linked
     * Accounts, and ignored duplicate Production Linked Account sets.
     */
    fun isDuplicate(): Optional<Boolean> =
        Optional.ofNullable(isDuplicate.getNullable("is_duplicate"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("integration") @ExcludeMissing fun _integration() = integration

    @JsonProperty("integration_slug") @ExcludeMissing fun _integrationSlug() = integrationSlug

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

    @JsonProperty("end_user_origin_id") @ExcludeMissing fun _endUserOriginId() = endUserOriginId

    @JsonProperty("end_user_organization_name")
    @ExcludeMissing
    fun _endUserOrganizationName() = endUserOrganizationName

    @JsonProperty("end_user_email_address")
    @ExcludeMissing
    fun _endUserEmailAddress() = endUserEmailAddress

    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("webhook_listener_url")
    @ExcludeMissing
    fun _webhookListenerUrl() = webhookListenerUrl

    /**
     * Whether a Production Linked Account's credentials match another existing Production Linked
     * Account. This field is `null` for Test Linked Accounts, incomplete Production Linked
     * Accounts, and ignored duplicate Production Linked Account sets.
     */
    @JsonProperty("is_duplicate") @ExcludeMissing fun _isDuplicate() = isDuplicate

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): AccountDetail = apply {
        if (!validated) {
            id()
            integration()
            integrationSlug()
            category()
            endUserOriginId()
            endUserOrganizationName()
            endUserEmailAddress()
            status()
            webhookListenerUrl()
            isDuplicate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountDetail &&
            this.id == other.id &&
            this.integration == other.integration &&
            this.integrationSlug == other.integrationSlug &&
            this.category == other.category &&
            this.endUserOriginId == other.endUserOriginId &&
            this.endUserOrganizationName == other.endUserOrganizationName &&
            this.endUserEmailAddress == other.endUserEmailAddress &&
            this.status == other.status &&
            this.webhookListenerUrl == other.webhookListenerUrl &&
            this.isDuplicate == other.isDuplicate &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    integration,
                    integrationSlug,
                    category,
                    endUserOriginId,
                    endUserOrganizationName,
                    endUserEmailAddress,
                    status,
                    webhookListenerUrl,
                    isDuplicate,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "AccountDetail{id=$id, integration=$integration, integrationSlug=$integrationSlug, category=$category, endUserOriginId=$endUserOriginId, endUserOrganizationName=$endUserOrganizationName, endUserEmailAddress=$endUserEmailAddress, status=$status, webhookListenerUrl=$webhookListenerUrl, isDuplicate=$isDuplicate, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var integration: JsonField<String> = JsonMissing.of()
        private var integrationSlug: JsonField<String> = JsonMissing.of()
        private var category: JsonField<CategoryEnum> = JsonMissing.of()
        private var endUserOriginId: JsonField<String> = JsonMissing.of()
        private var endUserOrganizationName: JsonField<String> = JsonMissing.of()
        private var endUserEmailAddress: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var webhookListenerUrl: JsonField<String> = JsonMissing.of()
        private var isDuplicate: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountDetail: AccountDetail) = apply {
            this.id = accountDetail.id
            this.integration = accountDetail.integration
            this.integrationSlug = accountDetail.integrationSlug
            this.category = accountDetail.category
            this.endUserOriginId = accountDetail.endUserOriginId
            this.endUserOrganizationName = accountDetail.endUserOrganizationName
            this.endUserEmailAddress = accountDetail.endUserEmailAddress
            this.status = accountDetail.status
            this.webhookListenerUrl = accountDetail.webhookListenerUrl
            this.isDuplicate = accountDetail.isDuplicate
            additionalProperties(accountDetail.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun integration(integration: String) = integration(JsonField.of(integration))

        @JsonProperty("integration")
        @ExcludeMissing
        fun integration(integration: JsonField<String>) = apply { this.integration = integration }

        fun integrationSlug(integrationSlug: String) =
            integrationSlug(JsonField.of(integrationSlug))

        @JsonProperty("integration_slug")
        @ExcludeMissing
        fun integrationSlug(integrationSlug: JsonField<String>) = apply {
            this.integrationSlug = integrationSlug
        }

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

        fun status(status: String) = status(JsonField.of(status))

        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<String>) = apply { this.status = status }

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

        fun build(): AccountDetail =
            AccountDetail(
                id,
                integration,
                integrationSlug,
                category,
                endUserOriginId,
                endUserOrganizationName,
                endUserEmailAddress,
                status,
                webhookListenerUrl,
                isDuplicate,
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
}
