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
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

class CandidateCreateParams
constructor(
    private val model: CandidateRequest,
    private val remoteUserId: String,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): CandidateRequest = model

    fun remoteUserId(): String = remoteUserId

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): CandidateCreateBody {
        return CandidateCreateBody(
            model,
            remoteUserId,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.isDebugMode?.let { params.put("is_debug_mode", listOf(it.toString())) }
        this.runAsync?.let { params.put("run_async", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = CandidateCreateBody.Builder::class)
    @NoAutoDetect
    class CandidateCreateBody
    internal constructor(
        private val model: CandidateRequest?,
        private val remoteUserId: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Candidate Object
         *
         * ### Description
         *
         * The `Candidate` object is used to represent profile information about a given Candidate.
         * Because it is specific to a Candidate, this information stays constant across
         * applications.
         *
         * ### Usage Example
         *
         * Fetch from the `LIST Candidates` endpoint and filter by `ID` to show all candidates.
         */
        @JsonProperty("model") fun model(): CandidateRequest? = model

        @JsonProperty("remote_user_id") fun remoteUserId(): String? = remoteUserId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CandidateCreateBody &&
                this.model == other.model &&
                this.remoteUserId == other.remoteUserId &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        model,
                        remoteUserId,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CandidateCreateBody{model=$model, remoteUserId=$remoteUserId, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: CandidateRequest? = null
            private var remoteUserId: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(candidateCreateBody: CandidateCreateBody) = apply {
                this.model = candidateCreateBody.model
                this.remoteUserId = candidateCreateBody.remoteUserId
                additionalProperties(candidateCreateBody.additionalProperties)
            }

            /**
             * # The Candidate Object
             *
             * ### Description
             *
             * The `Candidate` object is used to represent profile information about a given
             * Candidate. Because it is specific to a Candidate, this information stays constant
             * across applications.
             *
             * ### Usage Example
             *
             * Fetch from the `LIST Candidates` endpoint and filter by `ID` to show all candidates.
             */
            @JsonProperty("model") fun model(model: CandidateRequest) = apply { this.model = model }

            @JsonProperty("remote_user_id")
            fun remoteUserId(remoteUserId: String) = apply { this.remoteUserId = remoteUserId }

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

            fun build(): CandidateCreateBody =
                CandidateCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    checkNotNull(remoteUserId) { "`remoteUserId` is required but was not set" },
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

        return other is CandidateCreateParams &&
            this.model == other.model &&
            this.remoteUserId == other.remoteUserId &&
            this.isDebugMode == other.isDebugMode &&
            this.runAsync == other.runAsync &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            remoteUserId,
            isDebugMode,
            runAsync,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "CandidateCreateParams{model=$model, remoteUserId=$remoteUserId, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: CandidateRequest? = null
        private var remoteUserId: String? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(candidateCreateParams: CandidateCreateParams) = apply {
            this.model = candidateCreateParams.model
            this.remoteUserId = candidateCreateParams.remoteUserId
            this.isDebugMode = candidateCreateParams.isDebugMode
            this.runAsync = candidateCreateParams.runAsync
            additionalQueryParams(candidateCreateParams.additionalQueryParams)
            additionalHeaders(candidateCreateParams.additionalHeaders)
            additionalBodyProperties(candidateCreateParams.additionalBodyProperties)
        }

        /**
         * # The Candidate Object
         *
         * ### Description
         *
         * The `Candidate` object is used to represent profile information about a given Candidate.
         * Because it is specific to a Candidate, this information stays constant across
         * applications.
         *
         * ### Usage Example
         *
         * Fetch from the `LIST Candidates` endpoint and filter by `ID` to show all candidates.
         */
        fun model(model: CandidateRequest) = apply { this.model = model }

        fun remoteUserId(remoteUserId: String) = apply { this.remoteUserId = remoteUserId }

        /** Whether to include debug fields (such as log file links) in the response. */
        fun isDebugMode(isDebugMode: Boolean) = apply { this.isDebugMode = isDebugMode }

        /** Whether or not third-party updates should be run asynchronously. */
        fun runAsync(runAsync: Boolean) = apply { this.runAsync = runAsync }

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

        fun build(): CandidateCreateParams =
            CandidateCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                checkNotNull(remoteUserId) { "`remoteUserId` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Candidate Object
     *
     * ### Description
     *
     * The `Candidate` object is used to represent profile information about a given Candidate.
     * Because it is specific to a Candidate, this information stays constant across applications.
     *
     * ### Usage Example
     *
     * Fetch from the `LIST Candidates` endpoint and filter by `ID` to show all candidates.
     */
    @JsonDeserialize(builder = CandidateRequest.Builder::class)
    @NoAutoDetect
    class CandidateRequest
    private constructor(
        private val firstName: String?,
        private val lastName: String?,
        private val company: String?,
        private val title: String?,
        private val lastInteractionAt: OffsetDateTime?,
        private val isPrivate: Boolean?,
        private val canEmail: Boolean?,
        private val locations: List<String>?,
        private val phoneNumbers: List<PhoneNumberRequest>?,
        private val emailAddresses: List<EmailAddressRequest>?,
        private val urls: List<UrlRequest>?,
        private val tags: List<String>?,
        private val applications: List<String>?,
        private val attachments: List<String>?,
        private val remoteTemplateId: String?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The candidate's first name. */
        @JsonProperty("first_name") fun firstName(): String? = firstName

        /** The candidate's last name. */
        @JsonProperty("last_name") fun lastName(): String? = lastName

        /** The candidate's current company. */
        @JsonProperty("company") fun company(): String? = company

        /** The candidate's current title. */
        @JsonProperty("title") fun title(): String? = title

        /** When the most recent interaction with the candidate occurred. */
        @JsonProperty("last_interaction_at")
        fun lastInteractionAt(): OffsetDateTime? = lastInteractionAt

        /** Whether or not the candidate is private. */
        @JsonProperty("is_private") fun isPrivate(): Boolean? = isPrivate

        /** Whether or not the candidate can be emailed. */
        @JsonProperty("can_email") fun canEmail(): Boolean? = canEmail

        /** The candidate's locations. */
        @JsonProperty("locations") fun locations(): List<String>? = locations

        @JsonProperty("phone_numbers") fun phoneNumbers(): List<PhoneNumberRequest>? = phoneNumbers

        @JsonProperty("email_addresses")
        fun emailAddresses(): List<EmailAddressRequest>? = emailAddresses

        @JsonProperty("urls") fun urls(): List<UrlRequest>? = urls

        /** Array of `Tag` names as strings. */
        @JsonProperty("tags") fun tags(): List<String>? = tags

        /** Array of `Application` object IDs. */
        @JsonProperty("applications") fun applications(): List<String>? = applications

        /** Array of `Attachment` object IDs. */
        @JsonProperty("attachments") fun attachments(): List<String>? = attachments

        @JsonProperty("remote_template_id") fun remoteTemplateId(): String? = remoteTemplateId

        @JsonProperty("integration_params") fun integrationParams(): JsonValue? = integrationParams

        @JsonProperty("linked_account_params")
        fun linkedAccountParams(): JsonValue? = linkedAccountParams

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CandidateRequest &&
                this.firstName == other.firstName &&
                this.lastName == other.lastName &&
                this.company == other.company &&
                this.title == other.title &&
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
                this.remoteTemplateId == other.remoteTemplateId &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        firstName,
                        lastName,
                        company,
                        title,
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
                        remoteTemplateId,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CandidateRequest{firstName=$firstName, lastName=$lastName, company=$company, title=$title, lastInteractionAt=$lastInteractionAt, isPrivate=$isPrivate, canEmail=$canEmail, locations=$locations, phoneNumbers=$phoneNumbers, emailAddresses=$emailAddresses, urls=$urls, tags=$tags, applications=$applications, attachments=$attachments, remoteTemplateId=$remoteTemplateId, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var firstName: String? = null
            private var lastName: String? = null
            private var company: String? = null
            private var title: String? = null
            private var lastInteractionAt: OffsetDateTime? = null
            private var isPrivate: Boolean? = null
            private var canEmail: Boolean? = null
            private var locations: List<String>? = null
            private var phoneNumbers: List<PhoneNumberRequest>? = null
            private var emailAddresses: List<EmailAddressRequest>? = null
            private var urls: List<UrlRequest>? = null
            private var tags: List<String>? = null
            private var applications: List<String>? = null
            private var attachments: List<String>? = null
            private var remoteTemplateId: String? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(candidateRequest: CandidateRequest) = apply {
                this.firstName = candidateRequest.firstName
                this.lastName = candidateRequest.lastName
                this.company = candidateRequest.company
                this.title = candidateRequest.title
                this.lastInteractionAt = candidateRequest.lastInteractionAt
                this.isPrivate = candidateRequest.isPrivate
                this.canEmail = candidateRequest.canEmail
                this.locations = candidateRequest.locations
                this.phoneNumbers = candidateRequest.phoneNumbers
                this.emailAddresses = candidateRequest.emailAddresses
                this.urls = candidateRequest.urls
                this.tags = candidateRequest.tags
                this.applications = candidateRequest.applications
                this.attachments = candidateRequest.attachments
                this.remoteTemplateId = candidateRequest.remoteTemplateId
                this.integrationParams = candidateRequest.integrationParams
                this.linkedAccountParams = candidateRequest.linkedAccountParams
                additionalProperties(candidateRequest.additionalProperties)
            }

            /** The candidate's first name. */
            @JsonProperty("first_name")
            fun firstName(firstName: String) = apply { this.firstName = firstName }

            /** The candidate's last name. */
            @JsonProperty("last_name")
            fun lastName(lastName: String) = apply { this.lastName = lastName }

            /** The candidate's current company. */
            @JsonProperty("company") fun company(company: String) = apply { this.company = company }

            /** The candidate's current title. */
            @JsonProperty("title") fun title(title: String) = apply { this.title = title }

            /** When the most recent interaction with the candidate occurred. */
            @JsonProperty("last_interaction_at")
            fun lastInteractionAt(lastInteractionAt: OffsetDateTime) = apply {
                this.lastInteractionAt = lastInteractionAt
            }

            /** Whether or not the candidate is private. */
            @JsonProperty("is_private")
            fun isPrivate(isPrivate: Boolean) = apply { this.isPrivate = isPrivate }

            /** Whether or not the candidate can be emailed. */
            @JsonProperty("can_email")
            fun canEmail(canEmail: Boolean) = apply { this.canEmail = canEmail }

            /** The candidate's locations. */
            @JsonProperty("locations")
            fun locations(locations: List<String>) = apply { this.locations = locations }

            @JsonProperty("phone_numbers")
            fun phoneNumbers(phoneNumbers: List<PhoneNumberRequest>) = apply {
                this.phoneNumbers = phoneNumbers
            }

            @JsonProperty("email_addresses")
            fun emailAddresses(emailAddresses: List<EmailAddressRequest>) = apply {
                this.emailAddresses = emailAddresses
            }

            @JsonProperty("urls") fun urls(urls: List<UrlRequest>) = apply { this.urls = urls }

            /** Array of `Tag` names as strings. */
            @JsonProperty("tags") fun tags(tags: List<String>) = apply { this.tags = tags }

            /** Array of `Application` object IDs. */
            @JsonProperty("applications")
            fun applications(applications: List<String>) = apply {
                this.applications = applications
            }

            /** Array of `Attachment` object IDs. */
            @JsonProperty("attachments")
            fun attachments(attachments: List<String>) = apply { this.attachments = attachments }

            @JsonProperty("remote_template_id")
            fun remoteTemplateId(remoteTemplateId: String) = apply {
                this.remoteTemplateId = remoteTemplateId
            }

            @JsonProperty("integration_params")
            fun integrationParams(integrationParams: JsonValue) = apply {
                this.integrationParams = integrationParams
            }

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                this.linkedAccountParams = linkedAccountParams
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

            fun build(): CandidateRequest =
                CandidateRequest(
                    firstName,
                    lastName,
                    company,
                    title,
                    lastInteractionAt,
                    isPrivate,
                    canEmail,
                    locations?.toUnmodifiable(),
                    phoneNumbers?.toUnmodifiable(),
                    emailAddresses?.toUnmodifiable(),
                    urls?.toUnmodifiable(),
                    tags?.toUnmodifiable(),
                    applications?.toUnmodifiable(),
                    attachments?.toUnmodifiable(),
                    remoteTemplateId,
                    integrationParams,
                    linkedAccountParams,
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
        @JsonDeserialize(builder = PhoneNumberRequest.Builder::class)
        @NoAutoDetect
        class PhoneNumberRequest
        private constructor(
            private val value: String?,
            private val phoneNumberType: PhoneNumberTypeEnum?,
            private val integrationParams: JsonValue?,
            private val linkedAccountParams: JsonValue?,
            private val phoneNumber: String?,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var hashCode: Int = 0

            /** The phone number. */
            @JsonProperty("value") fun value(): String? = value

            /**
             * - `HOME` - HOME
             * - `WORK` - WORK
             * - `MOBILE` - MOBILE
             * - `SKYPE` - SKYPE
             * - `OTHER` - OTHER
             */
            @JsonProperty("phone_number_type")
            fun phoneNumberType(): PhoneNumberTypeEnum? = phoneNumberType

            @JsonProperty("integration_params")
            fun integrationParams(): JsonValue? = integrationParams

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(): JsonValue? = linkedAccountParams

            /** The phone number. */
            @JsonProperty("phone_number") fun phoneNumber(): String? = phoneNumber

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is PhoneNumberRequest &&
                    this.value == other.value &&
                    this.phoneNumberType == other.phoneNumberType &&
                    this.integrationParams == other.integrationParams &&
                    this.linkedAccountParams == other.linkedAccountParams &&
                    this.phoneNumber == other.phoneNumber &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            value,
                            phoneNumberType,
                            integrationParams,
                            linkedAccountParams,
                            phoneNumber,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "PhoneNumberRequest{value=$value, phoneNumberType=$phoneNumberType, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, phoneNumber=$phoneNumber, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var value: String? = null
                private var phoneNumberType: PhoneNumberTypeEnum? = null
                private var integrationParams: JsonValue? = null
                private var linkedAccountParams: JsonValue? = null
                private var phoneNumber: String? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(phoneNumberRequest: PhoneNumberRequest) = apply {
                    this.value = phoneNumberRequest.value
                    this.phoneNumberType = phoneNumberRequest.phoneNumberType
                    this.integrationParams = phoneNumberRequest.integrationParams
                    this.linkedAccountParams = phoneNumberRequest.linkedAccountParams
                    this.phoneNumber = phoneNumberRequest.phoneNumber
                    additionalProperties(phoneNumberRequest.additionalProperties)
                }

                /** The phone number. */
                @JsonProperty("value") fun value(value: String) = apply { this.value = value }

                /**
                 * - `HOME` - HOME
                 * - `WORK` - WORK
                 * - `MOBILE` - MOBILE
                 * - `SKYPE` - SKYPE
                 * - `OTHER` - OTHER
                 */
                @JsonProperty("phone_number_type")
                fun phoneNumberType(phoneNumberType: PhoneNumberTypeEnum) = apply {
                    this.phoneNumberType = phoneNumberType
                }

                @JsonProperty("integration_params")
                fun integrationParams(integrationParams: JsonValue) = apply {
                    this.integrationParams = integrationParams
                }

                @JsonProperty("linked_account_params")
                fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                    this.linkedAccountParams = linkedAccountParams
                }

                /** The phone number. */
                @JsonProperty("phone_number")
                fun phoneNumber(phoneNumber: String) = apply { this.phoneNumber = phoneNumber }

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

                fun build(): PhoneNumberRequest =
                    PhoneNumberRequest(
                        value,
                        phoneNumberType,
                        integrationParams,
                        linkedAccountParams,
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
                        else ->
                            throw MergeInvalidDataException("Unknown PhoneNumberTypeEnum: $value")
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
        @JsonDeserialize(builder = EmailAddressRequest.Builder::class)
        @NoAutoDetect
        class EmailAddressRequest
        private constructor(
            private val value: String?,
            private val emailAddressType: EmailAddressTypeEnum?,
            private val integrationParams: JsonValue?,
            private val linkedAccountParams: JsonValue?,
            private val emailAddress: String?,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var hashCode: Int = 0

            /** The email address. */
            @JsonProperty("value") fun value(): String? = value

            /**
             * - `PERSONAL` - PERSONAL
             * - `WORK` - WORK
             * - `OTHER` - OTHER
             */
            @JsonProperty("email_address_type")
            fun emailAddressType(): EmailAddressTypeEnum? = emailAddressType

            @JsonProperty("integration_params")
            fun integrationParams(): JsonValue? = integrationParams

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(): JsonValue? = linkedAccountParams

            /** The email address. */
            @JsonProperty("email_address") fun emailAddress(): String? = emailAddress

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EmailAddressRequest &&
                    this.value == other.value &&
                    this.emailAddressType == other.emailAddressType &&
                    this.integrationParams == other.integrationParams &&
                    this.linkedAccountParams == other.linkedAccountParams &&
                    this.emailAddress == other.emailAddress &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            value,
                            emailAddressType,
                            integrationParams,
                            linkedAccountParams,
                            emailAddress,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "EmailAddressRequest{value=$value, emailAddressType=$emailAddressType, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, emailAddress=$emailAddress, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var value: String? = null
                private var emailAddressType: EmailAddressTypeEnum? = null
                private var integrationParams: JsonValue? = null
                private var linkedAccountParams: JsonValue? = null
                private var emailAddress: String? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(emailAddressRequest: EmailAddressRequest) = apply {
                    this.value = emailAddressRequest.value
                    this.emailAddressType = emailAddressRequest.emailAddressType
                    this.integrationParams = emailAddressRequest.integrationParams
                    this.linkedAccountParams = emailAddressRequest.linkedAccountParams
                    this.emailAddress = emailAddressRequest.emailAddress
                    additionalProperties(emailAddressRequest.additionalProperties)
                }

                /** The email address. */
                @JsonProperty("value") fun value(value: String) = apply { this.value = value }

                /**
                 * - `PERSONAL` - PERSONAL
                 * - `WORK` - WORK
                 * - `OTHER` - OTHER
                 */
                @JsonProperty("email_address_type")
                fun emailAddressType(emailAddressType: EmailAddressTypeEnum) = apply {
                    this.emailAddressType = emailAddressType
                }

                @JsonProperty("integration_params")
                fun integrationParams(integrationParams: JsonValue) = apply {
                    this.integrationParams = integrationParams
                }

                @JsonProperty("linked_account_params")
                fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                    this.linkedAccountParams = linkedAccountParams
                }

                /** The email address. */
                @JsonProperty("email_address")
                fun emailAddress(emailAddress: String) = apply { this.emailAddress = emailAddress }

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

                fun build(): EmailAddressRequest =
                    EmailAddressRequest(
                        value,
                        emailAddressType,
                        integrationParams,
                        linkedAccountParams,
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
                        else ->
                            throw MergeInvalidDataException("Unknown EmailAddressTypeEnum: $value")
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
        @JsonDeserialize(builder = UrlRequest.Builder::class)
        @NoAutoDetect
        class UrlRequest
        private constructor(
            private val value: String?,
            private val urlType: UrlTypeEnum?,
            private val integrationParams: JsonValue?,
            private val linkedAccountParams: JsonValue?,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var hashCode: Int = 0

            /** The site's url. */
            @JsonProperty("value") fun value(): String? = value

            /**
             * - `PERSONAL` - PERSONAL
             * - `COMPANY` - COMPANY
             * - `PORTFOLIO` - PORTFOLIO
             * - `BLOG` - BLOG
             * - `SOCIAL_MEDIA` - SOCIAL_MEDIA
             * - `OTHER` - OTHER
             * - `JOB_POSTING` - JOB_POSTING
             */
            @JsonProperty("url_type") fun urlType(): UrlTypeEnum? = urlType

            @JsonProperty("integration_params")
            fun integrationParams(): JsonValue? = integrationParams

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(): JsonValue? = linkedAccountParams

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UrlRequest &&
                    this.value == other.value &&
                    this.urlType == other.urlType &&
                    this.integrationParams == other.integrationParams &&
                    this.linkedAccountParams == other.linkedAccountParams &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            value,
                            urlType,
                            integrationParams,
                            linkedAccountParams,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "UrlRequest{value=$value, urlType=$urlType, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var value: String? = null
                private var urlType: UrlTypeEnum? = null
                private var integrationParams: JsonValue? = null
                private var linkedAccountParams: JsonValue? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(urlRequest: UrlRequest) = apply {
                    this.value = urlRequest.value
                    this.urlType = urlRequest.urlType
                    this.integrationParams = urlRequest.integrationParams
                    this.linkedAccountParams = urlRequest.linkedAccountParams
                    additionalProperties(urlRequest.additionalProperties)
                }

                /** The site's url. */
                @JsonProperty("value") fun value(value: String) = apply { this.value = value }

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
                fun urlType(urlType: UrlTypeEnum) = apply { this.urlType = urlType }

                @JsonProperty("integration_params")
                fun integrationParams(integrationParams: JsonValue) = apply {
                    this.integrationParams = integrationParams
                }

                @JsonProperty("linked_account_params")
                fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                    this.linkedAccountParams = linkedAccountParams
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

                fun build(): UrlRequest =
                    UrlRequest(
                        value,
                        urlType,
                        integrationParams,
                        linkedAccountParams,
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
}
