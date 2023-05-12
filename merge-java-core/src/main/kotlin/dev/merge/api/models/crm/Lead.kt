package dev.merge.api.models.crm

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
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

/**
 * # The Lead Object
 *
 * ### Description
 *
 * The `Lead` object is used to represent an individual who is a potential customer.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = Lead.Builder::class)
@NoAutoDetect
class Lead
private constructor(
    private val owner: JsonField<String>,
    private val leadSource: JsonField<String>,
    private val title: JsonField<String>,
    private val company: JsonField<String>,
    private val firstName: JsonField<String>,
    private val lastName: JsonField<String>,
    private val addresses: JsonField<List<Address>>,
    private val emailAddresses: JsonField<List<EmailAddress>>,
    private val phoneNumbers: JsonField<List<PhoneNumber>>,
    private val remoteUpdatedAt: JsonField<OffsetDateTime>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val convertedDate: JsonField<OffsetDateTime>,
    private val convertedContact: JsonField<String>,
    private val convertedAccount: JsonField<String>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val remoteFields: JsonField<List<RemoteField>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The lead's owner. */
    fun owner(): Optional<String> = Optional.ofNullable(owner.getNullable("owner"))

    /** The lead's source. */
    fun leadSource(): Optional<String> = Optional.ofNullable(leadSource.getNullable("lead_source"))

    /** The lead's title. */
    fun title(): Optional<String> = Optional.ofNullable(title.getNullable("title"))

    /** The lead's company. */
    fun company(): Optional<String> = Optional.ofNullable(company.getNullable("company"))

    /** The lead's first name. */
    fun firstName(): Optional<String> = Optional.ofNullable(firstName.getNullable("first_name"))

    /** The lead's last name. */
    fun lastName(): Optional<String> = Optional.ofNullable(lastName.getNullable("last_name"))

    fun addresses(): Optional<List<Address>> =
        Optional.ofNullable(addresses.getNullable("addresses"))

    fun emailAddresses(): Optional<List<EmailAddress>> =
        Optional.ofNullable(emailAddresses.getNullable("email_addresses"))

    fun phoneNumbers(): Optional<List<PhoneNumber>> =
        Optional.ofNullable(phoneNumbers.getNullable("phone_numbers"))

    /** When the third party's lead was updated. */
    fun remoteUpdatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteUpdatedAt.getNullable("remote_updated_at"))

    /** When the third party's lead was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** When the lead was converted. */
    fun convertedDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(convertedDate.getNullable("converted_date"))

    /** The contact of the converted lead. */
    fun convertedContact(): Optional<String> =
        Optional.ofNullable(convertedContact.getNullable("converted_contact"))

    /** The account of the converted lead. */
    fun convertedAccount(): Optional<String> =
        Optional.ofNullable(convertedAccount.getNullable("converted_account"))

    fun remoteWasDeleted(): Optional<Boolean> =
        Optional.ofNullable(remoteWasDeleted.getNullable("remote_was_deleted"))

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<RemoteData>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    fun remoteFields(): Optional<List<RemoteField>> =
        Optional.ofNullable(remoteFields.getNullable("remote_fields"))

    /** The lead's owner. */
    @JsonProperty("owner") @ExcludeMissing fun _owner() = owner

    /** The lead's source. */
    @JsonProperty("lead_source") @ExcludeMissing fun _leadSource() = leadSource

    /** The lead's title. */
    @JsonProperty("title") @ExcludeMissing fun _title() = title

    /** The lead's company. */
    @JsonProperty("company") @ExcludeMissing fun _company() = company

    /** The lead's first name. */
    @JsonProperty("first_name") @ExcludeMissing fun _firstName() = firstName

    /** The lead's last name. */
    @JsonProperty("last_name") @ExcludeMissing fun _lastName() = lastName

    @JsonProperty("addresses") @ExcludeMissing fun _addresses() = addresses

    @JsonProperty("email_addresses") @ExcludeMissing fun _emailAddresses() = emailAddresses

    @JsonProperty("phone_numbers") @ExcludeMissing fun _phoneNumbers() = phoneNumbers

    /** When the third party's lead was updated. */
    @JsonProperty("remote_updated_at") @ExcludeMissing fun _remoteUpdatedAt() = remoteUpdatedAt

    /** When the third party's lead was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** When the lead was converted. */
    @JsonProperty("converted_date") @ExcludeMissing fun _convertedDate() = convertedDate

    /** The contact of the converted lead. */
    @JsonProperty("converted_contact") @ExcludeMissing fun _convertedContact() = convertedContact

    /** The account of the converted lead. */
    @JsonProperty("converted_account") @ExcludeMissing fun _convertedAccount() = convertedAccount

    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonProperty("remote_fields") @ExcludeMissing fun _remoteFields() = remoteFields

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            owner()
            leadSource()
            title()
            company()
            firstName()
            lastName()
            addresses().map { it.forEach { it.validate() } }
            emailAddresses().map { it.forEach { it.validate() } }
            phoneNumbers().map { it.forEach { it.validate() } }
            remoteUpdatedAt()
            remoteCreatedAt()
            convertedDate()
            convertedContact()
            convertedAccount()
            remoteWasDeleted()
            id()
            remoteId()
            modifiedAt()
            remoteData().map { it.forEach { it.validate() } }
            remoteFields().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Lead &&
            this.owner == other.owner &&
            this.leadSource == other.leadSource &&
            this.title == other.title &&
            this.company == other.company &&
            this.firstName == other.firstName &&
            this.lastName == other.lastName &&
            this.addresses == other.addresses &&
            this.emailAddresses == other.emailAddresses &&
            this.phoneNumbers == other.phoneNumbers &&
            this.remoteUpdatedAt == other.remoteUpdatedAt &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.convertedDate == other.convertedDate &&
            this.convertedContact == other.convertedContact &&
            this.convertedAccount == other.convertedAccount &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.remoteFields == other.remoteFields &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    owner,
                    leadSource,
                    title,
                    company,
                    firstName,
                    lastName,
                    addresses,
                    emailAddresses,
                    phoneNumbers,
                    remoteUpdatedAt,
                    remoteCreatedAt,
                    convertedDate,
                    convertedContact,
                    convertedAccount,
                    remoteWasDeleted,
                    id,
                    remoteId,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    remoteFields,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Lead{owner=$owner, leadSource=$leadSource, title=$title, company=$company, firstName=$firstName, lastName=$lastName, addresses=$addresses, emailAddresses=$emailAddresses, phoneNumbers=$phoneNumbers, remoteUpdatedAt=$remoteUpdatedAt, remoteCreatedAt=$remoteCreatedAt, convertedDate=$convertedDate, convertedContact=$convertedContact, convertedAccount=$convertedAccount, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, remoteFields=$remoteFields, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var owner: JsonField<String> = JsonMissing.of()
        private var leadSource: JsonField<String> = JsonMissing.of()
        private var title: JsonField<String> = JsonMissing.of()
        private var company: JsonField<String> = JsonMissing.of()
        private var firstName: JsonField<String> = JsonMissing.of()
        private var lastName: JsonField<String> = JsonMissing.of()
        private var addresses: JsonField<List<Address>> = JsonMissing.of()
        private var emailAddresses: JsonField<List<EmailAddress>> = JsonMissing.of()
        private var phoneNumbers: JsonField<List<PhoneNumber>> = JsonMissing.of()
        private var remoteUpdatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var convertedDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var convertedContact: JsonField<String> = JsonMissing.of()
        private var convertedAccount: JsonField<String> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var remoteFields: JsonField<List<RemoteField>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(lead: Lead) = apply {
            this.owner = lead.owner
            this.leadSource = lead.leadSource
            this.title = lead.title
            this.company = lead.company
            this.firstName = lead.firstName
            this.lastName = lead.lastName
            this.addresses = lead.addresses
            this.emailAddresses = lead.emailAddresses
            this.phoneNumbers = lead.phoneNumbers
            this.remoteUpdatedAt = lead.remoteUpdatedAt
            this.remoteCreatedAt = lead.remoteCreatedAt
            this.convertedDate = lead.convertedDate
            this.convertedContact = lead.convertedContact
            this.convertedAccount = lead.convertedAccount
            this.remoteWasDeleted = lead.remoteWasDeleted
            this.id = lead.id
            this.remoteId = lead.remoteId
            this.fieldMappings = lead.fieldMappings
            this.modifiedAt = lead.modifiedAt
            this.remoteData = lead.remoteData
            this.remoteFields = lead.remoteFields
            additionalProperties(lead.additionalProperties)
        }

        /** The lead's owner. */
        fun owner(owner: String) = owner(JsonField.of(owner))

        /** The lead's owner. */
        @JsonProperty("owner")
        @ExcludeMissing
        fun owner(owner: JsonField<String>) = apply { this.owner = owner }

        /** The lead's source. */
        fun leadSource(leadSource: String) = leadSource(JsonField.of(leadSource))

        /** The lead's source. */
        @JsonProperty("lead_source")
        @ExcludeMissing
        fun leadSource(leadSource: JsonField<String>) = apply { this.leadSource = leadSource }

        /** The lead's title. */
        fun title(title: String) = title(JsonField.of(title))

        /** The lead's title. */
        @JsonProperty("title")
        @ExcludeMissing
        fun title(title: JsonField<String>) = apply { this.title = title }

        /** The lead's company. */
        fun company(company: String) = company(JsonField.of(company))

        /** The lead's company. */
        @JsonProperty("company")
        @ExcludeMissing
        fun company(company: JsonField<String>) = apply { this.company = company }

        /** The lead's first name. */
        fun firstName(firstName: String) = firstName(JsonField.of(firstName))

        /** The lead's first name. */
        @JsonProperty("first_name")
        @ExcludeMissing
        fun firstName(firstName: JsonField<String>) = apply { this.firstName = firstName }

        /** The lead's last name. */
        fun lastName(lastName: String) = lastName(JsonField.of(lastName))

        /** The lead's last name. */
        @JsonProperty("last_name")
        @ExcludeMissing
        fun lastName(lastName: JsonField<String>) = apply { this.lastName = lastName }

        fun addresses(addresses: List<Address>) = addresses(JsonField.of(addresses))

        @JsonProperty("addresses")
        @ExcludeMissing
        fun addresses(addresses: JsonField<List<Address>>) = apply { this.addresses = addresses }

        fun emailAddresses(emailAddresses: List<EmailAddress>) =
            emailAddresses(JsonField.of(emailAddresses))

        @JsonProperty("email_addresses")
        @ExcludeMissing
        fun emailAddresses(emailAddresses: JsonField<List<EmailAddress>>) = apply {
            this.emailAddresses = emailAddresses
        }

        fun phoneNumbers(phoneNumbers: List<PhoneNumber>) = phoneNumbers(JsonField.of(phoneNumbers))

        @JsonProperty("phone_numbers")
        @ExcludeMissing
        fun phoneNumbers(phoneNumbers: JsonField<List<PhoneNumber>>) = apply {
            this.phoneNumbers = phoneNumbers
        }

        /** When the third party's lead was updated. */
        fun remoteUpdatedAt(remoteUpdatedAt: OffsetDateTime) =
            remoteUpdatedAt(JsonField.of(remoteUpdatedAt))

        /** When the third party's lead was updated. */
        @JsonProperty("remote_updated_at")
        @ExcludeMissing
        fun remoteUpdatedAt(remoteUpdatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteUpdatedAt = remoteUpdatedAt
        }

        /** When the third party's lead was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's lead was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** When the lead was converted. */
        fun convertedDate(convertedDate: OffsetDateTime) =
            convertedDate(JsonField.of(convertedDate))

        /** When the lead was converted. */
        @JsonProperty("converted_date")
        @ExcludeMissing
        fun convertedDate(convertedDate: JsonField<OffsetDateTime>) = apply {
            this.convertedDate = convertedDate
        }

        /** The contact of the converted lead. */
        fun convertedContact(convertedContact: String) =
            convertedContact(JsonField.of(convertedContact))

        /** The contact of the converted lead. */
        @JsonProperty("converted_contact")
        @ExcludeMissing
        fun convertedContact(convertedContact: JsonField<String>) = apply {
            this.convertedContact = convertedContact
        }

        /** The account of the converted lead. */
        fun convertedAccount(convertedAccount: String) =
            convertedAccount(JsonField.of(convertedAccount))

        /** The account of the converted lead. */
        @JsonProperty("converted_account")
        @ExcludeMissing
        fun convertedAccount(convertedAccount: JsonField<String>) = apply {
            this.convertedAccount = convertedAccount
        }

        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

        @JsonProperty("remote_was_deleted")
        @ExcludeMissing
        fun remoteWasDeleted(remoteWasDeleted: JsonField<Boolean>) = apply {
            this.remoteWasDeleted = remoteWasDeleted
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        @JsonProperty("field_mappings")
        @ExcludeMissing
        fun fieldMappings(fieldMappings: JsonValue) = apply { this.fieldMappings = fieldMappings }

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at")
        @ExcludeMissing
        fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
            this.modifiedAt = modifiedAt
        }

        fun remoteData(remoteData: List<RemoteData>) = remoteData(JsonField.of(remoteData))

        @JsonProperty("remote_data")
        @ExcludeMissing
        fun remoteData(remoteData: JsonField<List<RemoteData>>) = apply {
            this.remoteData = remoteData
        }

        fun remoteFields(remoteFields: List<RemoteField>) = remoteFields(JsonField.of(remoteFields))

        @JsonProperty("remote_fields")
        @ExcludeMissing
        fun remoteFields(remoteFields: JsonField<List<RemoteField>>) = apply {
            this.remoteFields = remoteFields
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

        fun build(): Lead =
            Lead(
                owner,
                leadSource,
                title,
                company,
                firstName,
                lastName,
                addresses.map { it.toUnmodifiable() },
                emailAddresses.map { it.toUnmodifiable() },
                phoneNumbers.map { it.toUnmodifiable() },
                remoteUpdatedAt,
                remoteCreatedAt,
                convertedDate,
                convertedContact,
                convertedAccount,
                remoteWasDeleted,
                id,
                remoteId,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                remoteFields.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    /**
     * # The EmailAddress Object
     *
     * ### Description
     *
     * The `EmailAddress` object is used to represent an entity's email address.
     *
     * ### Usage Example
     *
     * Fetch from the `GET Contact` endpoint and view their email addresses.
     */
    @JsonDeserialize(builder = EmailAddress.Builder::class)
    @NoAutoDetect
    class EmailAddress
    private constructor(
        private val value: JsonField<String>,
        private val emailAddressType: JsonField<EmailAddressTypeEnum>,
        private val modifiedAt: JsonField<OffsetDateTime>,
        private val emailAddress: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** The email address. */
        fun value(): Optional<String> = Optional.ofNullable(value.getNullable("value"))

        /**
         * - `PERSONAL` - PERSONAL
         * - `WORK` - WORK
         * - `OTHER` - OTHER
         */
        fun emailAddressType(): Optional<EmailAddressTypeEnum> =
            Optional.ofNullable(emailAddressType.getNullable("email_address_type"))

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(): Optional<OffsetDateTime> =
            Optional.ofNullable(modifiedAt.getNullable("modified_at"))

        /** The email address. */
        fun emailAddress(): Optional<String> =
            Optional.ofNullable(emailAddress.getNullable("email_address"))

        /** The email address. */
        @JsonProperty("value") @ExcludeMissing fun _value() = value

        /**
         * - `PERSONAL` - PERSONAL
         * - `WORK` - WORK
         * - `OTHER` - OTHER
         */
        @JsonProperty("email_address_type")
        @ExcludeMissing
        fun _emailAddressType() = emailAddressType

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

        /** The email address. */
        @JsonProperty("email_address") @ExcludeMissing fun _emailAddress() = emailAddress

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                value()
                emailAddressType()
                modifiedAt()
                emailAddress()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EmailAddress &&
                this.value == other.value &&
                this.emailAddressType == other.emailAddressType &&
                this.modifiedAt == other.modifiedAt &&
                this.emailAddress == other.emailAddress &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        value,
                        emailAddressType,
                        modifiedAt,
                        emailAddress,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "EmailAddress{value=$value, emailAddressType=$emailAddressType, modifiedAt=$modifiedAt, emailAddress=$emailAddress, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var value: JsonField<String> = JsonMissing.of()
            private var emailAddressType: JsonField<EmailAddressTypeEnum> = JsonMissing.of()
            private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var emailAddress: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(emailAddress: EmailAddress) = apply {
                this.value = emailAddress.value
                this.emailAddressType = emailAddress.emailAddressType
                this.modifiedAt = emailAddress.modifiedAt
                this.emailAddress = emailAddress.emailAddress
                additionalProperties(emailAddress.additionalProperties)
            }

            /** The email address. */
            fun value(value: String) = value(JsonField.of(value))

            /** The email address. */
            @JsonProperty("value")
            @ExcludeMissing
            fun value(value: JsonField<String>) = apply { this.value = value }

            /**
             * - `PERSONAL` - PERSONAL
             * - `WORK` - WORK
             * - `OTHER` - OTHER
             */
            fun emailAddressType(emailAddressType: EmailAddressTypeEnum) =
                emailAddressType(JsonField.of(emailAddressType))

            /**
             * - `PERSONAL` - PERSONAL
             * - `WORK` - WORK
             * - `OTHER` - OTHER
             */
            @JsonProperty("email_address_type")
            @ExcludeMissing
            fun emailAddressType(emailAddressType: JsonField<EmailAddressTypeEnum>) = apply {
                this.emailAddressType = emailAddressType
            }

            /** This is the datetime that this object was last updated by Merge */
            fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

            /** This is the datetime that this object was last updated by Merge */
            @JsonProperty("modified_at")
            @ExcludeMissing
            fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
                this.modifiedAt = modifiedAt
            }

            /** The email address. */
            fun emailAddress(emailAddress: String) = emailAddress(JsonField.of(emailAddress))

            /** The email address. */
            @JsonProperty("email_address")
            @ExcludeMissing
            fun emailAddress(emailAddress: JsonField<String>) = apply {
                this.emailAddress = emailAddress
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

            fun build(): EmailAddress =
                EmailAddress(
                    value,
                    emailAddressType,
                    modifiedAt,
                    emailAddress,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class EmailAddressTypeEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EmailAddressTypeEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val PERSONAL = EmailAddressTypeEnum(JsonField.of("PERSONAL"))

                @JvmField val WORK = EmailAddressTypeEnum(JsonField.of("WORK"))

                @JvmField val OTHER = EmailAddressTypeEnum(JsonField.of("OTHER"))

                @JvmStatic fun of(value: String) = EmailAddressTypeEnum(JsonField.of(value))
            }

            enum class Known {
                PERSONAL,
                WORK,
                OTHER,
            }

            enum class Value {
                PERSONAL,
                WORK,
                OTHER,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    PERSONAL -> Value.PERSONAL
                    WORK -> Value.WORK
                    OTHER -> Value.OTHER
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    PERSONAL -> Known.PERSONAL
                    WORK -> Known.WORK
                    OTHER -> Known.OTHER
                    else -> throw MergeInvalidDataException("Unknown EmailAddressTypeEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }

    /**
     * # The PhoneNumber Object
     *
     * ### Description
     *
     * The `PhoneNumber` object is used to represent an entity's phone number.
     *
     * ### Usage Example
     *
     * Fetch from the `GET Contact` endpoint and view their phone numbers.
     */
    @JsonDeserialize(builder = PhoneNumber.Builder::class)
    @NoAutoDetect
    class PhoneNumber
    private constructor(
        private val value: JsonField<String>,
        private val phoneNumberType: JsonField<PhoneNumberTypeEnum>,
        private val modifiedAt: JsonField<OffsetDateTime>,
        private val phoneNumber: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** The phone number. */
        fun value(): Optional<String> = Optional.ofNullable(value.getNullable("value"))

        /**
         * - `HOME` - HOME
         * - `WORK` - WORK
         * - `MOBILE` - MOBILE
         * - `SKYPE` - SKYPE
         * - `OTHER` - OTHER
         */
        fun phoneNumberType(): Optional<PhoneNumberTypeEnum> =
            Optional.ofNullable(phoneNumberType.getNullable("phone_number_type"))

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(): Optional<OffsetDateTime> =
            Optional.ofNullable(modifiedAt.getNullable("modified_at"))

        /** The phone number. */
        fun phoneNumber(): Optional<String> =
            Optional.ofNullable(phoneNumber.getNullable("phone_number"))

        /** The phone number. */
        @JsonProperty("value") @ExcludeMissing fun _value() = value

        /**
         * - `HOME` - HOME
         * - `WORK` - WORK
         * - `MOBILE` - MOBILE
         * - `SKYPE` - SKYPE
         * - `OTHER` - OTHER
         */
        @JsonProperty("phone_number_type") @ExcludeMissing fun _phoneNumberType() = phoneNumberType

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

        /** The phone number. */
        @JsonProperty("phone_number") @ExcludeMissing fun _phoneNumber() = phoneNumber

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                value()
                phoneNumberType()
                modifiedAt()
                phoneNumber()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PhoneNumber &&
                this.value == other.value &&
                this.phoneNumberType == other.phoneNumberType &&
                this.modifiedAt == other.modifiedAt &&
                this.phoneNumber == other.phoneNumber &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        value,
                        phoneNumberType,
                        modifiedAt,
                        phoneNumber,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "PhoneNumber{value=$value, phoneNumberType=$phoneNumberType, modifiedAt=$modifiedAt, phoneNumber=$phoneNumber, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var value: JsonField<String> = JsonMissing.of()
            private var phoneNumberType: JsonField<PhoneNumberTypeEnum> = JsonMissing.of()
            private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var phoneNumber: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(phoneNumber: PhoneNumber) = apply {
                this.value = phoneNumber.value
                this.phoneNumberType = phoneNumber.phoneNumberType
                this.modifiedAt = phoneNumber.modifiedAt
                this.phoneNumber = phoneNumber.phoneNumber
                additionalProperties(phoneNumber.additionalProperties)
            }

            /** The phone number. */
            fun value(value: String) = value(JsonField.of(value))

            /** The phone number. */
            @JsonProperty("value")
            @ExcludeMissing
            fun value(value: JsonField<String>) = apply { this.value = value }

            /**
             * - `HOME` - HOME
             * - `WORK` - WORK
             * - `MOBILE` - MOBILE
             * - `SKYPE` - SKYPE
             * - `OTHER` - OTHER
             */
            fun phoneNumberType(phoneNumberType: PhoneNumberTypeEnum) =
                phoneNumberType(JsonField.of(phoneNumberType))

            /**
             * - `HOME` - HOME
             * - `WORK` - WORK
             * - `MOBILE` - MOBILE
             * - `SKYPE` - SKYPE
             * - `OTHER` - OTHER
             */
            @JsonProperty("phone_number_type")
            @ExcludeMissing
            fun phoneNumberType(phoneNumberType: JsonField<PhoneNumberTypeEnum>) = apply {
                this.phoneNumberType = phoneNumberType
            }

            /** This is the datetime that this object was last updated by Merge */
            fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

            /** This is the datetime that this object was last updated by Merge */
            @JsonProperty("modified_at")
            @ExcludeMissing
            fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
                this.modifiedAt = modifiedAt
            }

            /** The phone number. */
            fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

            /** The phone number. */
            @JsonProperty("phone_number")
            @ExcludeMissing
            fun phoneNumber(phoneNumber: JsonField<String>) = apply {
                this.phoneNumber = phoneNumber
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

            fun build(): PhoneNumber =
                PhoneNumber(
                    value,
                    phoneNumberType,
                    modifiedAt,
                    phoneNumber,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class PhoneNumberTypeEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is PhoneNumberTypeEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val HOME = PhoneNumberTypeEnum(JsonField.of("HOME"))

                @JvmField val WORK = PhoneNumberTypeEnum(JsonField.of("WORK"))

                @JvmField val MOBILE = PhoneNumberTypeEnum(JsonField.of("MOBILE"))

                @JvmField val SKYPE = PhoneNumberTypeEnum(JsonField.of("SKYPE"))

                @JvmField val OTHER = PhoneNumberTypeEnum(JsonField.of("OTHER"))

                @JvmStatic fun of(value: String) = PhoneNumberTypeEnum(JsonField.of(value))
            }

            enum class Known {
                HOME,
                WORK,
                MOBILE,
                SKYPE,
                OTHER,
            }

            enum class Value {
                HOME,
                WORK,
                MOBILE,
                SKYPE,
                OTHER,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    HOME -> Value.HOME
                    WORK -> Value.WORK
                    MOBILE -> Value.MOBILE
                    SKYPE -> Value.SKYPE
                    OTHER -> Value.OTHER
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    HOME -> Known.HOME
                    WORK -> Known.WORK
                    MOBILE -> Known.MOBILE
                    SKYPE -> Known.SKYPE
                    OTHER -> Known.OTHER
                    else -> throw MergeInvalidDataException("Unknown PhoneNumberTypeEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }

    @JsonDeserialize(builder = RemoteField.Builder::class)
    @NoAutoDetect
    class RemoteField
    private constructor(
        private val remoteFieldClass: JsonField<RemoteFieldClass>,
        private val value: JsonValue,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun remoteFieldClass(): RemoteFieldClass =
            remoteFieldClass.getRequired("remote_field_class")

        @JsonProperty("remote_field_class")
        @ExcludeMissing
        fun _remoteFieldClass() = remoteFieldClass

        @JsonProperty("value") @ExcludeMissing fun _value() = value

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                remoteFieldClass().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RemoteField &&
                this.remoteFieldClass == other.remoteFieldClass &&
                this.value == other.value &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        remoteFieldClass,
                        value,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "RemoteField{remoteFieldClass=$remoteFieldClass, value=$value, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var remoteFieldClass: JsonField<RemoteFieldClass> = JsonMissing.of()
            private var value: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(remoteField: RemoteField) = apply {
                this.remoteFieldClass = remoteField.remoteFieldClass
                this.value = remoteField.value
                additionalProperties(remoteField.additionalProperties)
            }

            fun remoteFieldClass(remoteFieldClass: RemoteFieldClass) =
                remoteFieldClass(JsonField.of(remoteFieldClass))

            @JsonProperty("remote_field_class")
            @ExcludeMissing
            fun remoteFieldClass(remoteFieldClass: JsonField<RemoteFieldClass>) = apply {
                this.remoteFieldClass = remoteFieldClass
            }

            @JsonProperty("value")
            @ExcludeMissing
            fun value(value: JsonValue) = apply { this.value = value }

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

            fun build(): RemoteField =
                RemoteField(
                    remoteFieldClass,
                    value,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
