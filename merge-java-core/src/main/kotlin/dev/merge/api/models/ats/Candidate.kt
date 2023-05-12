package dev.merge.api.models.ats

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
 * # The Candidate Object
 *
 * ### Description
 *
 * The `Candidate` object is used to represent profile information about a given Candidate. Because
 * it is specific to a Candidate, this information stays constant across applications.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Candidates` endpoint and filter by `ID` to show all candidates.
 */
@JsonDeserialize(builder = Candidate.Builder::class)
@NoAutoDetect
class Candidate
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val firstName: JsonField<String>,
    private val lastName: JsonField<String>,
    private val company: JsonField<String>,
    private val title: JsonField<String>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val remoteUpdatedAt: JsonField<OffsetDateTime>,
    private val lastInteractionAt: JsonField<OffsetDateTime>,
    private val isPrivate: JsonField<Boolean>,
    private val canEmail: JsonField<Boolean>,
    private val locations: JsonField<List<String>>,
    private val phoneNumbers: JsonField<List<PhoneNumber>>,
    private val emailAddresses: JsonField<List<EmailAddress>>,
    private val urls: JsonField<List<Url>>,
    private val tags: JsonField<List<String>>,
    private val applications: JsonField<List<String>>,
    private val attachments: JsonField<List<String>>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** The candidate's first name. */
    fun firstName(): Optional<String> = Optional.ofNullable(firstName.getNullable("first_name"))

    /** The candidate's last name. */
    fun lastName(): Optional<String> = Optional.ofNullable(lastName.getNullable("last_name"))

    /** The candidate's current company. */
    fun company(): Optional<String> = Optional.ofNullable(company.getNullable("company"))

    /** The candidate's current title. */
    fun title(): Optional<String> = Optional.ofNullable(title.getNullable("title"))

    /** When the third party's candidate was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** When the third party's candidate was updated. */
    fun remoteUpdatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteUpdatedAt.getNullable("remote_updated_at"))

    /** When the most recent interaction with the candidate occurred. */
    fun lastInteractionAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(lastInteractionAt.getNullable("last_interaction_at"))

    /** Whether or not the candidate is private. */
    fun isPrivate(): Optional<Boolean> = Optional.ofNullable(isPrivate.getNullable("is_private"))

    /** Whether or not the candidate can be emailed. */
    fun canEmail(): Optional<Boolean> = Optional.ofNullable(canEmail.getNullable("can_email"))

    /** The candidate's locations. */
    fun locations(): Optional<List<String>> =
        Optional.ofNullable(locations.getNullable("locations"))

    fun phoneNumbers(): Optional<List<PhoneNumber>> =
        Optional.ofNullable(phoneNumbers.getNullable("phone_numbers"))

    fun emailAddresses(): Optional<List<EmailAddress>> =
        Optional.ofNullable(emailAddresses.getNullable("email_addresses"))

    fun urls(): Optional<List<Url>> = Optional.ofNullable(urls.getNullable("urls"))

    /** Array of `Tag` names as strings. */
    fun tags(): Optional<List<String>> = Optional.ofNullable(tags.getNullable("tags"))

    /** Array of `Application` object IDs. */
    fun applications(): Optional<List<String>> =
        Optional.ofNullable(applications.getNullable("applications"))

    /** Array of `Attachment` object IDs. */
    fun attachments(): Optional<List<String>> =
        Optional.ofNullable(attachments.getNullable("attachments"))

    fun remoteWasDeleted(): Optional<Boolean> =
        Optional.ofNullable(remoteWasDeleted.getNullable("remote_was_deleted"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<RemoteData>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    /** The candidate's first name. */
    @JsonProperty("first_name") @ExcludeMissing fun _firstName() = firstName

    /** The candidate's last name. */
    @JsonProperty("last_name") @ExcludeMissing fun _lastName() = lastName

    /** The candidate's current company. */
    @JsonProperty("company") @ExcludeMissing fun _company() = company

    /** The candidate's current title. */
    @JsonProperty("title") @ExcludeMissing fun _title() = title

    /** When the third party's candidate was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** When the third party's candidate was updated. */
    @JsonProperty("remote_updated_at") @ExcludeMissing fun _remoteUpdatedAt() = remoteUpdatedAt

    /** When the most recent interaction with the candidate occurred. */
    @JsonProperty("last_interaction_at")
    @ExcludeMissing
    fun _lastInteractionAt() = lastInteractionAt

    /** Whether or not the candidate is private. */
    @JsonProperty("is_private") @ExcludeMissing fun _isPrivate() = isPrivate

    /** Whether or not the candidate can be emailed. */
    @JsonProperty("can_email") @ExcludeMissing fun _canEmail() = canEmail

    /** The candidate's locations. */
    @JsonProperty("locations") @ExcludeMissing fun _locations() = locations

    @JsonProperty("phone_numbers") @ExcludeMissing fun _phoneNumbers() = phoneNumbers

    @JsonProperty("email_addresses") @ExcludeMissing fun _emailAddresses() = emailAddresses

    @JsonProperty("urls") @ExcludeMissing fun _urls() = urls

    /** Array of `Tag` names as strings. */
    @JsonProperty("tags") @ExcludeMissing fun _tags() = tags

    /** Array of `Application` object IDs. */
    @JsonProperty("applications") @ExcludeMissing fun _applications() = applications

    /** Array of `Attachment` object IDs. */
    @JsonProperty("attachments") @ExcludeMissing fun _attachments() = attachments

    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            id()
            remoteId()
            firstName()
            lastName()
            company()
            title()
            remoteCreatedAt()
            remoteUpdatedAt()
            lastInteractionAt()
            isPrivate()
            canEmail()
            locations()
            phoneNumbers().map { it.forEach { it.validate() } }
            emailAddresses().map { it.forEach { it.validate() } }
            urls().map { it.forEach { it.validate() } }
            tags()
            applications()
            attachments()
            remoteWasDeleted()
            modifiedAt()
            remoteData().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Candidate &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.firstName == other.firstName &&
            this.lastName == other.lastName &&
            this.company == other.company &&
            this.title == other.title &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.remoteUpdatedAt == other.remoteUpdatedAt &&
            this.lastInteractionAt == other.lastInteractionAt &&
            this.isPrivate == other.isPrivate &&
            this.canEmail == other.canEmail &&
            this.locations == other.locations &&
            this.phoneNumbers == other.phoneNumbers &&
            this.emailAddresses == other.emailAddresses &&
            this.urls == other.urls &&
            this.tags == other.tags &&
            this.applications == other.applications &&
            this.attachments == other.attachments &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    remoteId,
                    firstName,
                    lastName,
                    company,
                    title,
                    remoteCreatedAt,
                    remoteUpdatedAt,
                    lastInteractionAt,
                    isPrivate,
                    canEmail,
                    locations,
                    phoneNumbers,
                    emailAddresses,
                    urls,
                    tags,
                    applications,
                    attachments,
                    remoteWasDeleted,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Candidate{id=$id, remoteId=$remoteId, firstName=$firstName, lastName=$lastName, company=$company, title=$title, remoteCreatedAt=$remoteCreatedAt, remoteUpdatedAt=$remoteUpdatedAt, lastInteractionAt=$lastInteractionAt, isPrivate=$isPrivate, canEmail=$canEmail, locations=$locations, phoneNumbers=$phoneNumbers, emailAddresses=$emailAddresses, urls=$urls, tags=$tags, applications=$applications, attachments=$attachments, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var firstName: JsonField<String> = JsonMissing.of()
        private var lastName: JsonField<String> = JsonMissing.of()
        private var company: JsonField<String> = JsonMissing.of()
        private var title: JsonField<String> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteUpdatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var lastInteractionAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var isPrivate: JsonField<Boolean> = JsonMissing.of()
        private var canEmail: JsonField<Boolean> = JsonMissing.of()
        private var locations: JsonField<List<String>> = JsonMissing.of()
        private var phoneNumbers: JsonField<List<PhoneNumber>> = JsonMissing.of()
        private var emailAddresses: JsonField<List<EmailAddress>> = JsonMissing.of()
        private var urls: JsonField<List<Url>> = JsonMissing.of()
        private var tags: JsonField<List<String>> = JsonMissing.of()
        private var applications: JsonField<List<String>> = JsonMissing.of()
        private var attachments: JsonField<List<String>> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(candidate: Candidate) = apply {
            this.id = candidate.id
            this.remoteId = candidate.remoteId
            this.firstName = candidate.firstName
            this.lastName = candidate.lastName
            this.company = candidate.company
            this.title = candidate.title
            this.remoteCreatedAt = candidate.remoteCreatedAt
            this.remoteUpdatedAt = candidate.remoteUpdatedAt
            this.lastInteractionAt = candidate.lastInteractionAt
            this.isPrivate = candidate.isPrivate
            this.canEmail = candidate.canEmail
            this.locations = candidate.locations
            this.phoneNumbers = candidate.phoneNumbers
            this.emailAddresses = candidate.emailAddresses
            this.urls = candidate.urls
            this.tags = candidate.tags
            this.applications = candidate.applications
            this.attachments = candidate.attachments
            this.remoteWasDeleted = candidate.remoteWasDeleted
            this.fieldMappings = candidate.fieldMappings
            this.modifiedAt = candidate.modifiedAt
            this.remoteData = candidate.remoteData
            additionalProperties(candidate.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The candidate's first name. */
        fun firstName(firstName: String) = firstName(JsonField.of(firstName))

        /** The candidate's first name. */
        @JsonProperty("first_name")
        @ExcludeMissing
        fun firstName(firstName: JsonField<String>) = apply { this.firstName = firstName }

        /** The candidate's last name. */
        fun lastName(lastName: String) = lastName(JsonField.of(lastName))

        /** The candidate's last name. */
        @JsonProperty("last_name")
        @ExcludeMissing
        fun lastName(lastName: JsonField<String>) = apply { this.lastName = lastName }

        /** The candidate's current company. */
        fun company(company: String) = company(JsonField.of(company))

        /** The candidate's current company. */
        @JsonProperty("company")
        @ExcludeMissing
        fun company(company: JsonField<String>) = apply { this.company = company }

        /** The candidate's current title. */
        fun title(title: String) = title(JsonField.of(title))

        /** The candidate's current title. */
        @JsonProperty("title")
        @ExcludeMissing
        fun title(title: JsonField<String>) = apply { this.title = title }

        /** When the third party's candidate was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's candidate was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** When the third party's candidate was updated. */
        fun remoteUpdatedAt(remoteUpdatedAt: OffsetDateTime) =
            remoteUpdatedAt(JsonField.of(remoteUpdatedAt))

        /** When the third party's candidate was updated. */
        @JsonProperty("remote_updated_at")
        @ExcludeMissing
        fun remoteUpdatedAt(remoteUpdatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteUpdatedAt = remoteUpdatedAt
        }

        /** When the most recent interaction with the candidate occurred. */
        fun lastInteractionAt(lastInteractionAt: OffsetDateTime) =
            lastInteractionAt(JsonField.of(lastInteractionAt))

        /** When the most recent interaction with the candidate occurred. */
        @JsonProperty("last_interaction_at")
        @ExcludeMissing
        fun lastInteractionAt(lastInteractionAt: JsonField<OffsetDateTime>) = apply {
            this.lastInteractionAt = lastInteractionAt
        }

        /** Whether or not the candidate is private. */
        fun isPrivate(isPrivate: Boolean) = isPrivate(JsonField.of(isPrivate))

        /** Whether or not the candidate is private. */
        @JsonProperty("is_private")
        @ExcludeMissing
        fun isPrivate(isPrivate: JsonField<Boolean>) = apply { this.isPrivate = isPrivate }

        /** Whether or not the candidate can be emailed. */
        fun canEmail(canEmail: Boolean) = canEmail(JsonField.of(canEmail))

        /** Whether or not the candidate can be emailed. */
        @JsonProperty("can_email")
        @ExcludeMissing
        fun canEmail(canEmail: JsonField<Boolean>) = apply { this.canEmail = canEmail }

        /** The candidate's locations. */
        fun locations(locations: List<String>) = locations(JsonField.of(locations))

        /** The candidate's locations. */
        @JsonProperty("locations")
        @ExcludeMissing
        fun locations(locations: JsonField<List<String>>) = apply { this.locations = locations }

        fun phoneNumbers(phoneNumbers: List<PhoneNumber>) = phoneNumbers(JsonField.of(phoneNumbers))

        @JsonProperty("phone_numbers")
        @ExcludeMissing
        fun phoneNumbers(phoneNumbers: JsonField<List<PhoneNumber>>) = apply {
            this.phoneNumbers = phoneNumbers
        }

        fun emailAddresses(emailAddresses: List<EmailAddress>) =
            emailAddresses(JsonField.of(emailAddresses))

        @JsonProperty("email_addresses")
        @ExcludeMissing
        fun emailAddresses(emailAddresses: JsonField<List<EmailAddress>>) = apply {
            this.emailAddresses = emailAddresses
        }

        fun urls(urls: List<Url>) = urls(JsonField.of(urls))

        @JsonProperty("urls")
        @ExcludeMissing
        fun urls(urls: JsonField<List<Url>>) = apply { this.urls = urls }

        /** Array of `Tag` names as strings. */
        fun tags(tags: List<String>) = tags(JsonField.of(tags))

        /** Array of `Tag` names as strings. */
        @JsonProperty("tags")
        @ExcludeMissing
        fun tags(tags: JsonField<List<String>>) = apply { this.tags = tags }

        /** Array of `Application` object IDs. */
        fun applications(applications: List<String>) = applications(JsonField.of(applications))

        /** Array of `Application` object IDs. */
        @JsonProperty("applications")
        @ExcludeMissing
        fun applications(applications: JsonField<List<String>>) = apply {
            this.applications = applications
        }

        /** Array of `Attachment` object IDs. */
        fun attachments(attachments: List<String>) = attachments(JsonField.of(attachments))

        /** Array of `Attachment` object IDs. */
        @JsonProperty("attachments")
        @ExcludeMissing
        fun attachments(attachments: JsonField<List<String>>) = apply {
            this.attachments = attachments
        }

        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

        @JsonProperty("remote_was_deleted")
        @ExcludeMissing
        fun remoteWasDeleted(remoteWasDeleted: JsonField<Boolean>) = apply {
            this.remoteWasDeleted = remoteWasDeleted
        }

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

        fun build(): Candidate =
            Candidate(
                id,
                remoteId,
                firstName,
                lastName,
                company,
                title,
                remoteCreatedAt,
                remoteUpdatedAt,
                lastInteractionAt,
                isPrivate,
                canEmail,
                locations.map { it.toUnmodifiable() },
                phoneNumbers.map { it.toUnmodifiable() },
                emailAddresses.map { it.toUnmodifiable() },
                urls.map { it.toUnmodifiable() },
                tags.map { it.toUnmodifiable() },
                applications.map { it.toUnmodifiable() },
                attachments.map { it.toUnmodifiable() },
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
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
     * # The Url Object
     *
     * ### Description
     *
     * The `Url` object is used to represent hyperlinks associated with the parent model.
     *
     * ### Usage Example
     *
     * Fetch from the `GET Candidate` endpoint and view their website urls.
     */
    @JsonDeserialize(builder = Url.Builder::class)
    @NoAutoDetect
    class Url
    private constructor(
        private val value: JsonField<String>,
        private val urlType: JsonField<UrlTypeEnum>,
        private val modifiedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** The site's url. */
        fun value(): Optional<String> = Optional.ofNullable(value.getNullable("value"))

        /**
         * - `PERSONAL` - PERSONAL
         * - `COMPANY` - COMPANY
         * - `PORTFOLIO` - PORTFOLIO
         * - `BLOG` - BLOG
         * - `SOCIAL_MEDIA` - SOCIAL_MEDIA
         * - `OTHER` - OTHER
         * - `JOB_POSTING` - JOB_POSTING
         */
        fun urlType(): Optional<UrlTypeEnum> = Optional.ofNullable(urlType.getNullable("url_type"))

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(): Optional<OffsetDateTime> =
            Optional.ofNullable(modifiedAt.getNullable("modified_at"))

        /** The site's url. */
        @JsonProperty("value") @ExcludeMissing fun _value() = value

        /**
         * - `PERSONAL` - PERSONAL
         * - `COMPANY` - COMPANY
         * - `PORTFOLIO` - PORTFOLIO
         * - `BLOG` - BLOG
         * - `SOCIAL_MEDIA` - SOCIAL_MEDIA
         * - `OTHER` - OTHER
         * - `JOB_POSTING` - JOB_POSTING
         */
        @JsonProperty("url_type") @ExcludeMissing fun _urlType() = urlType

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                value()
                urlType()
                modifiedAt()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Url &&
                this.value == other.value &&
                this.urlType == other.urlType &&
                this.modifiedAt == other.modifiedAt &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        value,
                        urlType,
                        modifiedAt,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Url{value=$value, urlType=$urlType, modifiedAt=$modifiedAt, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var value: JsonField<String> = JsonMissing.of()
            private var urlType: JsonField<UrlTypeEnum> = JsonMissing.of()
            private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(url: Url) = apply {
                this.value = url.value
                this.urlType = url.urlType
                this.modifiedAt = url.modifiedAt
                additionalProperties(url.additionalProperties)
            }

            /** The site's url. */
            fun value(value: String) = value(JsonField.of(value))

            /** The site's url. */
            @JsonProperty("value")
            @ExcludeMissing
            fun value(value: JsonField<String>) = apply { this.value = value }

            /**
             * - `PERSONAL` - PERSONAL
             * - `COMPANY` - COMPANY
             * - `PORTFOLIO` - PORTFOLIO
             * - `BLOG` - BLOG
             * - `SOCIAL_MEDIA` - SOCIAL_MEDIA
             * - `OTHER` - OTHER
             * - `JOB_POSTING` - JOB_POSTING
             */
            fun urlType(urlType: UrlTypeEnum) = urlType(JsonField.of(urlType))

            /**
             * - `PERSONAL` - PERSONAL
             * - `COMPANY` - COMPANY
             * - `PORTFOLIO` - PORTFOLIO
             * - `BLOG` - BLOG
             * - `SOCIAL_MEDIA` - SOCIAL_MEDIA
             * - `OTHER` - OTHER
             * - `JOB_POSTING` - JOB_POSTING
             */
            @JsonProperty("url_type")
            @ExcludeMissing
            fun urlType(urlType: JsonField<UrlTypeEnum>) = apply { this.urlType = urlType }

            /** This is the datetime that this object was last updated by Merge */
            fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

            /** This is the datetime that this object was last updated by Merge */
            @JsonProperty("modified_at")
            @ExcludeMissing
            fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
                this.modifiedAt = modifiedAt
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

            fun build(): Url =
                Url(
                    value,
                    urlType,
                    modifiedAt,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class UrlTypeEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UrlTypeEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val PERSONAL = UrlTypeEnum(JsonField.of("PERSONAL"))

                @JvmField val COMPANY = UrlTypeEnum(JsonField.of("COMPANY"))

                @JvmField val PORTFOLIO = UrlTypeEnum(JsonField.of("PORTFOLIO"))

                @JvmField val BLOG = UrlTypeEnum(JsonField.of("BLOG"))

                @JvmField val SOCIAL_MEDIA = UrlTypeEnum(JsonField.of("SOCIAL_MEDIA"))

                @JvmField val OTHER = UrlTypeEnum(JsonField.of("OTHER"))

                @JvmField val JOB_POSTING = UrlTypeEnum(JsonField.of("JOB_POSTING"))

                @JvmStatic fun of(value: String) = UrlTypeEnum(JsonField.of(value))
            }

            enum class Known {
                PERSONAL,
                COMPANY,
                PORTFOLIO,
                BLOG,
                SOCIAL_MEDIA,
                OTHER,
                JOB_POSTING,
            }

            enum class Value {
                PERSONAL,
                COMPANY,
                PORTFOLIO,
                BLOG,
                SOCIAL_MEDIA,
                OTHER,
                JOB_POSTING,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    PERSONAL -> Value.PERSONAL
                    COMPANY -> Value.COMPANY
                    PORTFOLIO -> Value.PORTFOLIO
                    BLOG -> Value.BLOG
                    SOCIAL_MEDIA -> Value.SOCIAL_MEDIA
                    OTHER -> Value.OTHER
                    JOB_POSTING -> Value.JOB_POSTING
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    PERSONAL -> Known.PERSONAL
                    COMPANY -> Known.COMPANY
                    PORTFOLIO -> Known.PORTFOLIO
                    BLOG -> Known.BLOG
                    SOCIAL_MEDIA -> Known.SOCIAL_MEDIA
                    OTHER -> Known.OTHER
                    JOB_POSTING -> Known.JOB_POSTING
                    else -> throw MergeInvalidDataException("Unknown UrlTypeEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
