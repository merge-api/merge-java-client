package dev.merge.api.models.crm

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

class ContactCreateParams
constructor(
    private val model: ContactRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): ContactRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): ContactCreateBody {
        return ContactCreateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = ContactCreateBody.Builder::class)
    @NoAutoDetect
    class ContactCreateBody
    internal constructor(
        private val model: ContactRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Contact Object
         *
         * ### Description
         *
         * The `Contact` object is used to represent a contact in the remote system.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/mktg/v1/contact` endpoint and view their phone numbers.
         */
        @JsonProperty("model") fun model(): ContactRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ContactCreateBody &&
                this.model == other.model &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(model, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "ContactCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: ContactRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(contactCreateBody: ContactCreateBody) = apply {
                this.model = contactCreateBody.model
                additionalProperties(contactCreateBody.additionalProperties)
            }

            /**
             * # The Contact Object
             *
             * ### Description
             *
             * The `Contact` object is used to represent a contact in the remote system.
             *
             * ### Usage Example
             *
             * Fetch from the `GET /api/mktg/v1/contact` endpoint and view their phone numbers.
             */
            @JsonProperty("model") fun model(model: ContactRequest) = apply { this.model = model }

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

            fun build(): ContactCreateBody =
                ContactCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
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

        return other is ContactCreateParams &&
            this.model == other.model &&
            this.isDebugMode == other.isDebugMode &&
            this.runAsync == other.runAsync &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            isDebugMode,
            runAsync,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "ContactCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: ContactRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contactCreateParams: ContactCreateParams) = apply {
            this.model = contactCreateParams.model
            this.isDebugMode = contactCreateParams.isDebugMode
            this.runAsync = contactCreateParams.runAsync
            additionalQueryParams(contactCreateParams.additionalQueryParams)
            additionalHeaders(contactCreateParams.additionalHeaders)
            additionalBodyProperties(contactCreateParams.additionalBodyProperties)
        }

        /**
         * # The Contact Object
         *
         * ### Description
         *
         * The `Contact` object is used to represent a contact in the remote system.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/mktg/v1/contact` endpoint and view their phone numbers.
         */
        fun model(model: ContactRequest) = apply { this.model = model }

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

        fun build(): ContactCreateParams =
            ContactCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Contact Object
     *
     * ### Description
     *
     * The `Contact` object is used to represent a contact in the remote system.
     *
     * ### Usage Example
     *
     * Fetch from the `GET /api/mktg/v1/contact` endpoint and view their phone numbers.
     */
    @JsonDeserialize(builder = ContactRequest.Builder::class)
    @NoAutoDetect
    class ContactRequest
    private constructor(
        private val name: String?,
        private val isSupplier: Boolean?,
        private val isCustomer: Boolean?,
        private val emailAddress: String?,
        private val taxNumber: String?,
        private val status: Status7d1Enum?,
        private val currency: String?,
        private val company: String?,
        private val addresses: List<String>?,
        private val phoneNumbers: List<PhoneNumberRequest>?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val firstName: String?,
        private val lastName: String?,
        private val account: String?,
        private val emailAddresses: List<EmailAddressRequest>?,
        private val lastActivityAt: OffsetDateTime?,
        private val remoteFields: List<RemoteFieldRequest>?,
        private val email: String?,
        private val phone: String?,
        private val state: String?,
        private val country: Country?,
        private val postalCode: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The contact's name. */
        @JsonProperty("name") fun name(): String? = name

        /** Whether the contact is a supplier. */
        @JsonProperty("is_supplier") fun isSupplier(): Boolean? = isSupplier

        /** Whether the contact is a customer. */
        @JsonProperty("is_customer") fun isCustomer(): Boolean? = isCustomer

        /** The contact's email address. */
        @JsonProperty("email_address") fun emailAddress(): String? = emailAddress

        /** The contact's tax number. */
        @JsonProperty("tax_number") fun taxNumber(): String? = taxNumber

        /**
         * - `ACTIVE` - ACTIVE
         * - `ARCHIVED` - ARCHIVED
         */
        @JsonProperty("status") fun status(): Status7d1Enum? = status

        /** The currency the contact's transactions are in. */
        @JsonProperty("currency") fun currency(): String? = currency

        /** The company the contact belongs to. */
        @JsonProperty("company") fun company(): String? = company

        /** `Address` object IDs for the given `Contacts` object. */
        @JsonProperty("addresses") fun addresses(): List<String>? = addresses

        /** `AccountingPhoneNumber` object for the given `Contacts` object. */
        @JsonProperty("phone_numbers") fun phoneNumbers(): List<PhoneNumberRequest>? = phoneNumbers

        @JsonProperty("integration_params") fun integrationParams(): JsonValue? = integrationParams

        @JsonProperty("linked_account_params")
        fun linkedAccountParams(): JsonValue? = linkedAccountParams

        /** The contact's first name. */
        @JsonProperty("first_name") fun firstName(): String? = firstName

        /** The contact's last name. */
        @JsonProperty("last_name") fun lastName(): String? = lastName

        /** The contact's account. */
        @JsonProperty("account") fun account(): String? = account

        @JsonProperty("email_addresses")
        fun emailAddresses(): List<EmailAddressRequest>? = emailAddresses

        /** When the contact's last activity occurred. */
        @JsonProperty("last_activity_at") fun lastActivityAt(): OffsetDateTime? = lastActivityAt

        @JsonProperty("remote_fields") fun remoteFields(): List<RemoteFieldRequest>? = remoteFields

        /** The contact's email. */
        @JsonProperty("email") fun email(): String? = email

        /** The contact's phone. */
        @JsonProperty("phone") fun phone(): String? = phone

        /** The contact's state. */
        @JsonProperty("state") fun state(): String? = state

        /**
         * - `AF` - Afghanistan
         * - `AX` - Åland Islands
         * - `AL` - Albania
         * - `DZ` - Algeria
         * - `AS` - American Samoa
         * - `AD` - Andorra
         * - `AO` - Angola
         * - `AI` - Anguilla
         * - `AQ` - Antarctica
         * - `AG` - Antigua and Barbuda
         * - `AR` - Argentina
         * - `AM` - Armenia
         * - `AW` - Aruba
         * - `AU` - Australia
         * - `AT` - Austria
         * - `AZ` - Azerbaijan
         * - `BS` - Bahamas
         * - `BH` - Bahrain
         * - `BD` - Bangladesh
         * - `BB` - Barbados
         * - `BY` - Belarus
         * - `BE` - Belgium
         * - `BZ` - Belize
         * - `BJ` - Benin
         * - `BM` - Bermuda
         * - `BT` - Bhutan
         * - `BO` - Bolivia
         * - `BQ` - Bonaire, Sint Eustatius and Saba
         * - `BA` - Bosnia and Herzegovina
         * - `BW` - Botswana
         * - `BV` - Bouvet Island
         * - `BR` - Brazil
         * - `IO` - British Indian Ocean Territory
         * - `BN` - Brunei
         * - `BG` - Bulgaria
         * - `BF` - Burkina Faso
         * - `BI` - Burundi
         * - `CV` - Cabo Verde
         * - `KH` - Cambodia
         * - `CM` - Cameroon
         * - `CA` - Canada
         * - `KY` - Cayman Islands
         * - `CF` - Central African Republic
         * - `TD` - Chad
         * - `CL` - Chile
         * - `CN` - China
         * - `CX` - Christmas Island
         * - `CC` - Cocos (Keeling) Islands
         * - `CO` - Colombia
         * - `KM` - Comoros
         * - `CG` - Congo
         * - `CD` - Congo (the Democratic Republic of the)
         * - `CK` - Cook Islands
         * - `CR` - Costa Rica
         * - `CI` - Côte d'Ivoire
         * - `HR` - Croatia
         * - `CU` - Cuba
         * - `CW` - Curaçao
         * - `CY` - Cyprus
         * - `CZ` - Czechia
         * - `DK` - Denmark
         * - `DJ` - Djibouti
         * - `DM` - Dominica
         * - `DO` - Dominican Republic
         * - `EC` - Ecuador
         * - `EG` - Egypt
         * - `SV` - El Salvador
         * - `GQ` - Equatorial Guinea
         * - `ER` - Eritrea
         * - `EE` - Estonia
         * - `SZ` - Eswatini
         * - `ET` - Ethiopia
         * - `FK` - Falkland Islands (Malvinas)
         * - `FO` - Faroe Islands
         * - `FJ` - Fiji
         * - `FI` - Finland
         * - `FR` - France
         * - `GF` - French Guiana
         * - `PF` - French Polynesia
         * - `TF` - French Southern Territories
         * - `GA` - Gabon
         * - `GM` - Gambia
         * - `GE` - Georgia
         * - `DE` - Germany
         * - `GH` - Ghana
         * - `GI` - Gibraltar
         * - `GR` - Greece
         * - `GL` - Greenland
         * - `GD` - Grenada
         * - `GP` - Guadeloupe
         * - `GU` - Guam
         * - `GT` - Guatemala
         * - `GG` - Guernsey
         * - `GN` - Guinea
         * - `GW` - Guinea-Bissau
         * - `GY` - Guyana
         * - `HT` - Haiti
         * - `HM` - Heard Island and McDonald Islands
         * - `VA` - Holy See
         * - `HN` - Honduras
         * - `HK` - Hong Kong
         * - `HU` - Hungary
         * - `IS` - Iceland
         * - `IN` - India
         * - `ID` - Indonesia
         * - `IR` - Iran
         * - `IQ` - Iraq
         * - `IE` - Ireland
         * - `IM` - Isle of Man
         * - `IL` - Israel
         * - `IT` - Italy
         * - `JM` - Jamaica
         * - `JP` - Japan
         * - `JE` - Jersey
         * - `JO` - Jordan
         * - `KZ` - Kazakhstan
         * - `KE` - Kenya
         * - `KI` - Kiribati
         * - `KW` - Kuwait
         * - `KG` - Kyrgyzstan
         * - `LA` - Laos
         * - `LV` - Latvia
         * - `LB` - Lebanon
         * - `LS` - Lesotho
         * - `LR` - Liberia
         * - `LY` - Libya
         * - `LI` - Liechtenstein
         * - `LT` - Lithuania
         * - `LU` - Luxembourg
         * - `MO` - Macao
         * - `MG` - Madagascar
         * - `MW` - Malawi
         * - `MY` - Malaysia
         * - `MV` - Maldives
         * - `ML` - Mali
         * - `MT` - Malta
         * - `MH` - Marshall Islands
         * - `MQ` - Martinique
         * - `MR` - Mauritania
         * - `MU` - Mauritius
         * - `YT` - Mayotte
         * - `MX` - Mexico
         * - `FM` - Micronesia (Federated States of)
         * - `MD` - Moldova
         * - `MC` - Monaco
         * - `MN` - Mongolia
         * - `ME` - Montenegro
         * - `MS` - Montserrat
         * - `MA` - Morocco
         * - `MZ` - Mozambique
         * - `MM` - Myanmar
         * - `NA` - Namibia
         * - `NR` - Nauru
         * - `NP` - Nepal
         * - `NL` - Netherlands
         * - `NC` - New Caledonia
         * - `NZ` - New Zealand
         * - `NI` - Nicaragua
         * - `NE` - Niger
         * - `NG` - Nigeria
         * - `NU` - Niue
         * - `NF` - Norfolk Island
         * - `KP` - North Korea
         * - `MK` - North Macedonia
         * - `MP` - Northern Mariana Islands
         * - `NO` - Norway
         * - `OM` - Oman
         * - `PK` - Pakistan
         * - `PW` - Palau
         * - `PS` - Palestine, State of
         * - `PA` - Panama
         * - `PG` - Papua New Guinea
         * - `PY` - Paraguay
         * - `PE` - Peru
         * - `PH` - Philippines
         * - `PN` - Pitcairn
         * - `PL` - Poland
         * - `PT` - Portugal
         * - `PR` - Puerto Rico
         * - `QA` - Qatar
         * - `RE` - Réunion
         * - `RO` - Romania
         * - `RU` - Russia
         * - `RW` - Rwanda
         * - `BL` - Saint Barthélemy
         * - `SH` - Saint Helena, Ascension and Tristan da Cunha
         * - `KN` - Saint Kitts and Nevis
         * - `LC` - Saint Lucia
         * - `MF` - Saint Martin (French part)
         * - `PM` - Saint Pierre and Miquelon
         * - `VC` - Saint Vincent and the Grenadines
         * - `WS` - Samoa
         * - `SM` - San Marino
         * - `ST` - Sao Tome and Principe
         * - `SA` - Saudi Arabia
         * - `SN` - Senegal
         * - `RS` - Serbia
         * - `SC` - Seychelles
         * - `SL` - Sierra Leone
         * - `SG` - Singapore
         * - `SX` - Sint Maarten (Dutch part)
         * - `SK` - Slovakia
         * - `SI` - Slovenia
         * - `SB` - Solomon Islands
         * - `SO` - Somalia
         * - `ZA` - South Africa
         * - `GS` - South Georgia and the South Sandwich Islands
         * - `KR` - South Korea
         * - `SS` - South Sudan
         * - `ES` - Spain
         * - `LK` - Sri Lanka
         * - `SD` - Sudan
         * - `SR` - Suriname
         * - `SJ` - Svalbard and Jan Mayen
         * - `SE` - Sweden
         * - `CH` - Switzerland
         * - `SY` - Syria
         * - `TW` - Taiwan
         * - `TJ` - Tajikistan
         * - `TZ` - Tanzania
         * - `TH` - Thailand
         * - `TL` - Timor-Leste
         * - `TG` - Togo
         * - `TK` - Tokelau
         * - `TO` - Tonga
         * - `TT` - Trinidad and Tobago
         * - `TN` - Tunisia
         * - `TR` - Turkey
         * - `TM` - Turkmenistan
         * - `TC` - Turks and Caicos Islands
         * - `TV` - Tuvalu
         * - `UG` - Uganda
         * - `UA` - Ukraine
         * - `AE` - United Arab Emirates
         * - `GB` - United Kingdom
         * - `UM` - United States Minor Outlying Islands
         * - `US` - United States of America
         * - `UY` - Uruguay
         * - `UZ` - Uzbekistan
         * - `VU` - Vanuatu
         * - `VE` - Venezuela
         * - `VN` - Vietnam
         * - `VG` - Virgin Islands (British)
         * - `VI` - Virgin Islands (U.S.)
         * - `WF` - Wallis and Futuna
         * - `EH` - Western Sahara
         * - `YE` - Yemen
         * - `ZM` - Zambia
         * - `ZW` - Zimbabwe
         */
        @JsonProperty("country") fun country(): Country? = country

        /** The contact's postal code. */
        @JsonProperty("postal_code") fun postalCode(): String? = postalCode

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ContactRequest &&
                this.name == other.name &&
                this.isSupplier == other.isSupplier &&
                this.isCustomer == other.isCustomer &&
                this.emailAddress == other.emailAddress &&
                this.taxNumber == other.taxNumber &&
                this.status == other.status &&
                this.currency == other.currency &&
                this.company == other.company &&
                this.addresses == other.addresses &&
                this.phoneNumbers == other.phoneNumbers &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.firstName == other.firstName &&
                this.lastName == other.lastName &&
                this.account == other.account &&
                this.emailAddresses == other.emailAddresses &&
                this.lastActivityAt == other.lastActivityAt &&
                this.remoteFields == other.remoteFields &&
                this.email == other.email &&
                this.phone == other.phone &&
                this.state == other.state &&
                this.country == other.country &&
                this.postalCode == other.postalCode &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        name,
                        isSupplier,
                        isCustomer,
                        emailAddress,
                        taxNumber,
                        status,
                        currency,
                        company,
                        addresses,
                        phoneNumbers,
                        integrationParams,
                        linkedAccountParams,
                        firstName,
                        lastName,
                        account,
                        emailAddresses,
                        lastActivityAt,
                        remoteFields,
                        email,
                        phone,
                        state,
                        country,
                        postalCode,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ContactRequest{name=$name, isSupplier=$isSupplier, isCustomer=$isCustomer, emailAddress=$emailAddress, taxNumber=$taxNumber, status=$status, currency=$currency, company=$company, addresses=$addresses, phoneNumbers=$phoneNumbers, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, firstName=$firstName, lastName=$lastName, account=$account, emailAddresses=$emailAddresses, lastActivityAt=$lastActivityAt, remoteFields=$remoteFields, email=$email, phone=$phone, state=$state, country=$country, postalCode=$postalCode, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var isSupplier: Boolean? = null
            private var isCustomer: Boolean? = null
            private var emailAddress: String? = null
            private var taxNumber: String? = null
            private var status: Status7d1Enum? = null
            private var currency: String? = null
            private var company: String? = null
            private var addresses: List<String>? = null
            private var phoneNumbers: List<PhoneNumberRequest>? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var firstName: String? = null
            private var lastName: String? = null
            private var account: String? = null
            private var emailAddresses: List<EmailAddressRequest>? = null
            private var lastActivityAt: OffsetDateTime? = null
            private var remoteFields: List<RemoteFieldRequest>? = null
            private var email: String? = null
            private var phone: String? = null
            private var state: String? = null
            private var country: Country? = null
            private var postalCode: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(contactRequest: ContactRequest) = apply {
                this.name = contactRequest.name
                this.isSupplier = contactRequest.isSupplier
                this.isCustomer = contactRequest.isCustomer
                this.emailAddress = contactRequest.emailAddress
                this.taxNumber = contactRequest.taxNumber
                this.status = contactRequest.status
                this.currency = contactRequest.currency
                this.company = contactRequest.company
                this.addresses = contactRequest.addresses
                this.phoneNumbers = contactRequest.phoneNumbers
                this.integrationParams = contactRequest.integrationParams
                this.linkedAccountParams = contactRequest.linkedAccountParams
                this.firstName = contactRequest.firstName
                this.lastName = contactRequest.lastName
                this.account = contactRequest.account
                this.emailAddresses = contactRequest.emailAddresses
                this.lastActivityAt = contactRequest.lastActivityAt
                this.remoteFields = contactRequest.remoteFields
                this.email = contactRequest.email
                this.phone = contactRequest.phone
                this.state = contactRequest.state
                this.country = contactRequest.country
                this.postalCode = contactRequest.postalCode
                additionalProperties(contactRequest.additionalProperties)
            }

            /** The contact's name. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /** Whether the contact is a supplier. */
            @JsonProperty("is_supplier")
            fun isSupplier(isSupplier: Boolean) = apply { this.isSupplier = isSupplier }

            /** Whether the contact is a customer. */
            @JsonProperty("is_customer")
            fun isCustomer(isCustomer: Boolean) = apply { this.isCustomer = isCustomer }

            /** The contact's email address. */
            @JsonProperty("email_address")
            fun emailAddress(emailAddress: String) = apply { this.emailAddress = emailAddress }

            /** The contact's tax number. */
            @JsonProperty("tax_number")
            fun taxNumber(taxNumber: String) = apply { this.taxNumber = taxNumber }

            /**
             * - `ACTIVE` - ACTIVE
             * - `ARCHIVED` - ARCHIVED
             */
            @JsonProperty("status")
            fun status(status: Status7d1Enum) = apply { this.status = status }

            /** The currency the contact's transactions are in. */
            @JsonProperty("currency")
            fun currency(currency: String) = apply { this.currency = currency }

            /** The company the contact belongs to. */
            @JsonProperty("company") fun company(company: String) = apply { this.company = company }

            /** `Address` object IDs for the given `Contacts` object. */
            @JsonProperty("addresses")
            fun addresses(addresses: List<String>) = apply { this.addresses = addresses }

            /** `AccountingPhoneNumber` object for the given `Contacts` object. */
            @JsonProperty("phone_numbers")
            fun phoneNumbers(phoneNumbers: List<PhoneNumberRequest>) = apply {
                this.phoneNumbers = phoneNumbers
            }

            @JsonProperty("integration_params")
            fun integrationParams(integrationParams: JsonValue) = apply {
                this.integrationParams = integrationParams
            }

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                this.linkedAccountParams = linkedAccountParams
            }

            /** The contact's first name. */
            @JsonProperty("first_name")
            fun firstName(firstName: String) = apply { this.firstName = firstName }

            /** The contact's last name. */
            @JsonProperty("last_name")
            fun lastName(lastName: String) = apply { this.lastName = lastName }

            /** The contact's account. */
            @JsonProperty("account") fun account(account: String) = apply { this.account = account }

            @JsonProperty("email_addresses")
            fun emailAddresses(emailAddresses: List<EmailAddressRequest>) = apply {
                this.emailAddresses = emailAddresses
            }

            /** When the contact's last activity occurred. */
            @JsonProperty("last_activity_at")
            fun lastActivityAt(lastActivityAt: OffsetDateTime) = apply {
                this.lastActivityAt = lastActivityAt
            }

            @JsonProperty("remote_fields")
            fun remoteFields(remoteFields: List<RemoteFieldRequest>) = apply {
                this.remoteFields = remoteFields
            }

            /** The contact's email. */
            @JsonProperty("email") fun email(email: String) = apply { this.email = email }

            /** The contact's phone. */
            @JsonProperty("phone") fun phone(phone: String) = apply { this.phone = phone }

            /** The contact's state. */
            @JsonProperty("state") fun state(state: String) = apply { this.state = state }

            /**
             * - `AF` - Afghanistan
             * - `AX` - Åland Islands
             * - `AL` - Albania
             * - `DZ` - Algeria
             * - `AS` - American Samoa
             * - `AD` - Andorra
             * - `AO` - Angola
             * - `AI` - Anguilla
             * - `AQ` - Antarctica
             * - `AG` - Antigua and Barbuda
             * - `AR` - Argentina
             * - `AM` - Armenia
             * - `AW` - Aruba
             * - `AU` - Australia
             * - `AT` - Austria
             * - `AZ` - Azerbaijan
             * - `BS` - Bahamas
             * - `BH` - Bahrain
             * - `BD` - Bangladesh
             * - `BB` - Barbados
             * - `BY` - Belarus
             * - `BE` - Belgium
             * - `BZ` - Belize
             * - `BJ` - Benin
             * - `BM` - Bermuda
             * - `BT` - Bhutan
             * - `BO` - Bolivia
             * - `BQ` - Bonaire, Sint Eustatius and Saba
             * - `BA` - Bosnia and Herzegovina
             * - `BW` - Botswana
             * - `BV` - Bouvet Island
             * - `BR` - Brazil
             * - `IO` - British Indian Ocean Territory
             * - `BN` - Brunei
             * - `BG` - Bulgaria
             * - `BF` - Burkina Faso
             * - `BI` - Burundi
             * - `CV` - Cabo Verde
             * - `KH` - Cambodia
             * - `CM` - Cameroon
             * - `CA` - Canada
             * - `KY` - Cayman Islands
             * - `CF` - Central African Republic
             * - `TD` - Chad
             * - `CL` - Chile
             * - `CN` - China
             * - `CX` - Christmas Island
             * - `CC` - Cocos (Keeling) Islands
             * - `CO` - Colombia
             * - `KM` - Comoros
             * - `CG` - Congo
             * - `CD` - Congo (the Democratic Republic of the)
             * - `CK` - Cook Islands
             * - `CR` - Costa Rica
             * - `CI` - Côte d'Ivoire
             * - `HR` - Croatia
             * - `CU` - Cuba
             * - `CW` - Curaçao
             * - `CY` - Cyprus
             * - `CZ` - Czechia
             * - `DK` - Denmark
             * - `DJ` - Djibouti
             * - `DM` - Dominica
             * - `DO` - Dominican Republic
             * - `EC` - Ecuador
             * - `EG` - Egypt
             * - `SV` - El Salvador
             * - `GQ` - Equatorial Guinea
             * - `ER` - Eritrea
             * - `EE` - Estonia
             * - `SZ` - Eswatini
             * - `ET` - Ethiopia
             * - `FK` - Falkland Islands (Malvinas)
             * - `FO` - Faroe Islands
             * - `FJ` - Fiji
             * - `FI` - Finland
             * - `FR` - France
             * - `GF` - French Guiana
             * - `PF` - French Polynesia
             * - `TF` - French Southern Territories
             * - `GA` - Gabon
             * - `GM` - Gambia
             * - `GE` - Georgia
             * - `DE` - Germany
             * - `GH` - Ghana
             * - `GI` - Gibraltar
             * - `GR` - Greece
             * - `GL` - Greenland
             * - `GD` - Grenada
             * - `GP` - Guadeloupe
             * - `GU` - Guam
             * - `GT` - Guatemala
             * - `GG` - Guernsey
             * - `GN` - Guinea
             * - `GW` - Guinea-Bissau
             * - `GY` - Guyana
             * - `HT` - Haiti
             * - `HM` - Heard Island and McDonald Islands
             * - `VA` - Holy See
             * - `HN` - Honduras
             * - `HK` - Hong Kong
             * - `HU` - Hungary
             * - `IS` - Iceland
             * - `IN` - India
             * - `ID` - Indonesia
             * - `IR` - Iran
             * - `IQ` - Iraq
             * - `IE` - Ireland
             * - `IM` - Isle of Man
             * - `IL` - Israel
             * - `IT` - Italy
             * - `JM` - Jamaica
             * - `JP` - Japan
             * - `JE` - Jersey
             * - `JO` - Jordan
             * - `KZ` - Kazakhstan
             * - `KE` - Kenya
             * - `KI` - Kiribati
             * - `KW` - Kuwait
             * - `KG` - Kyrgyzstan
             * - `LA` - Laos
             * - `LV` - Latvia
             * - `LB` - Lebanon
             * - `LS` - Lesotho
             * - `LR` - Liberia
             * - `LY` - Libya
             * - `LI` - Liechtenstein
             * - `LT` - Lithuania
             * - `LU` - Luxembourg
             * - `MO` - Macao
             * - `MG` - Madagascar
             * - `MW` - Malawi
             * - `MY` - Malaysia
             * - `MV` - Maldives
             * - `ML` - Mali
             * - `MT` - Malta
             * - `MH` - Marshall Islands
             * - `MQ` - Martinique
             * - `MR` - Mauritania
             * - `MU` - Mauritius
             * - `YT` - Mayotte
             * - `MX` - Mexico
             * - `FM` - Micronesia (Federated States of)
             * - `MD` - Moldova
             * - `MC` - Monaco
             * - `MN` - Mongolia
             * - `ME` - Montenegro
             * - `MS` - Montserrat
             * - `MA` - Morocco
             * - `MZ` - Mozambique
             * - `MM` - Myanmar
             * - `NA` - Namibia
             * - `NR` - Nauru
             * - `NP` - Nepal
             * - `NL` - Netherlands
             * - `NC` - New Caledonia
             * - `NZ` - New Zealand
             * - `NI` - Nicaragua
             * - `NE` - Niger
             * - `NG` - Nigeria
             * - `NU` - Niue
             * - `NF` - Norfolk Island
             * - `KP` - North Korea
             * - `MK` - North Macedonia
             * - `MP` - Northern Mariana Islands
             * - `NO` - Norway
             * - `OM` - Oman
             * - `PK` - Pakistan
             * - `PW` - Palau
             * - `PS` - Palestine, State of
             * - `PA` - Panama
             * - `PG` - Papua New Guinea
             * - `PY` - Paraguay
             * - `PE` - Peru
             * - `PH` - Philippines
             * - `PN` - Pitcairn
             * - `PL` - Poland
             * - `PT` - Portugal
             * - `PR` - Puerto Rico
             * - `QA` - Qatar
             * - `RE` - Réunion
             * - `RO` - Romania
             * - `RU` - Russia
             * - `RW` - Rwanda
             * - `BL` - Saint Barthélemy
             * - `SH` - Saint Helena, Ascension and Tristan da Cunha
             * - `KN` - Saint Kitts and Nevis
             * - `LC` - Saint Lucia
             * - `MF` - Saint Martin (French part)
             * - `PM` - Saint Pierre and Miquelon
             * - `VC` - Saint Vincent and the Grenadines
             * - `WS` - Samoa
             * - `SM` - San Marino
             * - `ST` - Sao Tome and Principe
             * - `SA` - Saudi Arabia
             * - `SN` - Senegal
             * - `RS` - Serbia
             * - `SC` - Seychelles
             * - `SL` - Sierra Leone
             * - `SG` - Singapore
             * - `SX` - Sint Maarten (Dutch part)
             * - `SK` - Slovakia
             * - `SI` - Slovenia
             * - `SB` - Solomon Islands
             * - `SO` - Somalia
             * - `ZA` - South Africa
             * - `GS` - South Georgia and the South Sandwich Islands
             * - `KR` - South Korea
             * - `SS` - South Sudan
             * - `ES` - Spain
             * - `LK` - Sri Lanka
             * - `SD` - Sudan
             * - `SR` - Suriname
             * - `SJ` - Svalbard and Jan Mayen
             * - `SE` - Sweden
             * - `CH` - Switzerland
             * - `SY` - Syria
             * - `TW` - Taiwan
             * - `TJ` - Tajikistan
             * - `TZ` - Tanzania
             * - `TH` - Thailand
             * - `TL` - Timor-Leste
             * - `TG` - Togo
             * - `TK` - Tokelau
             * - `TO` - Tonga
             * - `TT` - Trinidad and Tobago
             * - `TN` - Tunisia
             * - `TR` - Turkey
             * - `TM` - Turkmenistan
             * - `TC` - Turks and Caicos Islands
             * - `TV` - Tuvalu
             * - `UG` - Uganda
             * - `UA` - Ukraine
             * - `AE` - United Arab Emirates
             * - `GB` - United Kingdom
             * - `UM` - United States Minor Outlying Islands
             * - `US` - United States of America
             * - `UY` - Uruguay
             * - `UZ` - Uzbekistan
             * - `VU` - Vanuatu
             * - `VE` - Venezuela
             * - `VN` - Vietnam
             * - `VG` - Virgin Islands (British)
             * - `VI` - Virgin Islands (U.S.)
             * - `WF` - Wallis and Futuna
             * - `EH` - Western Sahara
             * - `YE` - Yemen
             * - `ZM` - Zambia
             * - `ZW` - Zimbabwe
             */
            @JsonProperty("country")
            fun country(country: Country) = apply { this.country = country }

            /** The contact's postal code. */
            @JsonProperty("postal_code")
            fun postalCode(postalCode: String) = apply { this.postalCode = postalCode }

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

            fun build(): ContactRequest =
                ContactRequest(
                    name,
                    isSupplier,
                    isCustomer,
                    emailAddress,
                    taxNumber,
                    status,
                    currency,
                    company,
                    addresses?.toUnmodifiable(),
                    phoneNumbers?.toUnmodifiable(),
                    integrationParams,
                    linkedAccountParams,
                    firstName,
                    lastName,
                    account,
                    emailAddresses?.toUnmodifiable(),
                    lastActivityAt,
                    remoteFields?.toUnmodifiable(),
                    email,
                    phone,
                    state,
                    country,
                    postalCode,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class Status7d1Enum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Status7d1Enum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val ACTIVE = Status7d1Enum(JsonField.of("ACTIVE"))

                @JvmField val ARCHIVED = Status7d1Enum(JsonField.of("ARCHIVED"))

                @JvmStatic fun of(value: String) = Status7d1Enum(JsonField.of(value))
            }

            enum class Known {
                ACTIVE,
                ARCHIVED,
            }

            enum class Value {
                ACTIVE,
                ARCHIVED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    ACTIVE -> Value.ACTIVE
                    ARCHIVED -> Value.ARCHIVED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    ACTIVE -> Known.ACTIVE
                    ARCHIVED -> Known.ARCHIVED
                    else -> throw MergeInvalidDataException("Unknown Status7d1Enum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
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

        @JsonDeserialize(builder = RemoteFieldRequest.Builder::class)
        @NoAutoDetect
        class RemoteFieldRequest
        private constructor(
            private val remoteFieldClass: String?,
            private val value: JsonValue?,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var hashCode: Int = 0

            @JsonProperty("remote_field_class") fun remoteFieldClass(): String? = remoteFieldClass

            @JsonProperty("value") fun value(): JsonValue? = value

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RemoteFieldRequest &&
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
                "RemoteFieldRequest{remoteFieldClass=$remoteFieldClass, value=$value, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var remoteFieldClass: String? = null
                private var value: JsonValue? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(remoteFieldRequest: RemoteFieldRequest) = apply {
                    this.remoteFieldClass = remoteFieldRequest.remoteFieldClass
                    this.value = remoteFieldRequest.value
                    additionalProperties(remoteFieldRequest.additionalProperties)
                }

                @JsonProperty("remote_field_class")
                fun remoteFieldClass(remoteFieldClass: String) = apply {
                    this.remoteFieldClass = remoteFieldClass
                }

                @JsonProperty("value") fun value(value: JsonValue) = apply { this.value = value }

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

                fun build(): RemoteFieldRequest =
                    RemoteFieldRequest(
                        checkNotNull(remoteFieldClass) {
                            "`remoteFieldClass` is required but was not set"
                        },
                        value,
                        additionalProperties.toUnmodifiable(),
                    )
            }
        }
    }
}
