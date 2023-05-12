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

class LeadCreateParams
constructor(
    private val model: LeadRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): LeadRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): LeadCreateBody {
        return LeadCreateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = LeadCreateBody.Builder::class)
    @NoAutoDetect
    class LeadCreateBody
    internal constructor(
        private val model: LeadRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

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
        @JsonProperty("model") fun model(): LeadRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LeadCreateBody &&
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
            "LeadCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: LeadRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(leadCreateBody: LeadCreateBody) = apply {
                this.model = leadCreateBody.model
                additionalProperties(leadCreateBody.additionalProperties)
            }

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
            @JsonProperty("model") fun model(model: LeadRequest) = apply { this.model = model }

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

            fun build(): LeadCreateBody =
                LeadCreateBody(
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

        return other is LeadCreateParams &&
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
        "LeadCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: LeadRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(leadCreateParams: LeadCreateParams) = apply {
            this.model = leadCreateParams.model
            this.isDebugMode = leadCreateParams.isDebugMode
            this.runAsync = leadCreateParams.runAsync
            additionalQueryParams(leadCreateParams.additionalQueryParams)
            additionalHeaders(leadCreateParams.additionalHeaders)
            additionalBodyProperties(leadCreateParams.additionalBodyProperties)
        }

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
        fun model(model: LeadRequest) = apply { this.model = model }

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

        fun build(): LeadCreateParams =
            LeadCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

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
    @JsonDeserialize(builder = LeadRequest.Builder::class)
    @NoAutoDetect
    class LeadRequest
    private constructor(
        private val owner: String?,
        private val leadSource: String?,
        private val title: String?,
        private val company: String?,
        private val firstName: String?,
        private val lastName: String?,
        private val addresses: List<AddressRequest>?,
        private val emailAddresses: List<EmailAddressRequest>?,
        private val phoneNumbers: List<PhoneNumberRequest>?,
        private val convertedDate: OffsetDateTime?,
        private val convertedContact: String?,
        private val convertedAccount: String?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The lead's owner. */
        @JsonProperty("owner") fun owner(): String? = owner

        /** The lead's source. */
        @JsonProperty("lead_source") fun leadSource(): String? = leadSource

        /** The lead's title. */
        @JsonProperty("title") fun title(): String? = title

        /** The lead's company. */
        @JsonProperty("company") fun company(): String? = company

        /** The lead's first name. */
        @JsonProperty("first_name") fun firstName(): String? = firstName

        /** The lead's last name. */
        @JsonProperty("last_name") fun lastName(): String? = lastName

        @JsonProperty("addresses") fun addresses(): List<AddressRequest>? = addresses

        @JsonProperty("email_addresses")
        fun emailAddresses(): List<EmailAddressRequest>? = emailAddresses

        @JsonProperty("phone_numbers") fun phoneNumbers(): List<PhoneNumberRequest>? = phoneNumbers

        /** When the lead was converted. */
        @JsonProperty("converted_date") fun convertedDate(): OffsetDateTime? = convertedDate

        /** The contact of the converted lead. */
        @JsonProperty("converted_contact") fun convertedContact(): String? = convertedContact

        /** The account of the converted lead. */
        @JsonProperty("converted_account") fun convertedAccount(): String? = convertedAccount

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

            return other is LeadRequest &&
                this.owner == other.owner &&
                this.leadSource == other.leadSource &&
                this.title == other.title &&
                this.company == other.company &&
                this.firstName == other.firstName &&
                this.lastName == other.lastName &&
                this.addresses == other.addresses &&
                this.emailAddresses == other.emailAddresses &&
                this.phoneNumbers == other.phoneNumbers &&
                this.convertedDate == other.convertedDate &&
                this.convertedContact == other.convertedContact &&
                this.convertedAccount == other.convertedAccount &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
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
                        convertedDate,
                        convertedContact,
                        convertedAccount,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "LeadRequest{owner=$owner, leadSource=$leadSource, title=$title, company=$company, firstName=$firstName, lastName=$lastName, addresses=$addresses, emailAddresses=$emailAddresses, phoneNumbers=$phoneNumbers, convertedDate=$convertedDate, convertedContact=$convertedContact, convertedAccount=$convertedAccount, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var owner: String? = null
            private var leadSource: String? = null
            private var title: String? = null
            private var company: String? = null
            private var firstName: String? = null
            private var lastName: String? = null
            private var addresses: List<AddressRequest>? = null
            private var emailAddresses: List<EmailAddressRequest>? = null
            private var phoneNumbers: List<PhoneNumberRequest>? = null
            private var convertedDate: OffsetDateTime? = null
            private var convertedContact: String? = null
            private var convertedAccount: String? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(leadRequest: LeadRequest) = apply {
                this.owner = leadRequest.owner
                this.leadSource = leadRequest.leadSource
                this.title = leadRequest.title
                this.company = leadRequest.company
                this.firstName = leadRequest.firstName
                this.lastName = leadRequest.lastName
                this.addresses = leadRequest.addresses
                this.emailAddresses = leadRequest.emailAddresses
                this.phoneNumbers = leadRequest.phoneNumbers
                this.convertedDate = leadRequest.convertedDate
                this.convertedContact = leadRequest.convertedContact
                this.convertedAccount = leadRequest.convertedAccount
                this.integrationParams = leadRequest.integrationParams
                this.linkedAccountParams = leadRequest.linkedAccountParams
                additionalProperties(leadRequest.additionalProperties)
            }

            /** The lead's owner. */
            @JsonProperty("owner") fun owner(owner: String) = apply { this.owner = owner }

            /** The lead's source. */
            @JsonProperty("lead_source")
            fun leadSource(leadSource: String) = apply { this.leadSource = leadSource }

            /** The lead's title. */
            @JsonProperty("title") fun title(title: String) = apply { this.title = title }

            /** The lead's company. */
            @JsonProperty("company") fun company(company: String) = apply { this.company = company }

            /** The lead's first name. */
            @JsonProperty("first_name")
            fun firstName(firstName: String) = apply { this.firstName = firstName }

            /** The lead's last name. */
            @JsonProperty("last_name")
            fun lastName(lastName: String) = apply { this.lastName = lastName }

            @JsonProperty("addresses")
            fun addresses(addresses: List<AddressRequest>) = apply { this.addresses = addresses }

            @JsonProperty("email_addresses")
            fun emailAddresses(emailAddresses: List<EmailAddressRequest>) = apply {
                this.emailAddresses = emailAddresses
            }

            @JsonProperty("phone_numbers")
            fun phoneNumbers(phoneNumbers: List<PhoneNumberRequest>) = apply {
                this.phoneNumbers = phoneNumbers
            }

            /** When the lead was converted. */
            @JsonProperty("converted_date")
            fun convertedDate(convertedDate: OffsetDateTime) = apply {
                this.convertedDate = convertedDate
            }

            /** The contact of the converted lead. */
            @JsonProperty("converted_contact")
            fun convertedContact(convertedContact: String) = apply {
                this.convertedContact = convertedContact
            }

            /** The account of the converted lead. */
            @JsonProperty("converted_account")
            fun convertedAccount(convertedAccount: String) = apply {
                this.convertedAccount = convertedAccount
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

            fun build(): LeadRequest =
                LeadRequest(
                    owner,
                    leadSource,
                    title,
                    company,
                    firstName,
                    lastName,
                    addresses?.toUnmodifiable(),
                    emailAddresses?.toUnmodifiable(),
                    phoneNumbers?.toUnmodifiable(),
                    convertedDate,
                    convertedContact,
                    convertedAccount,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }

        /**
         * # The Address Object
         *
         * ### Description
         *
         * The `Address` object is used to represent an entity's address.
         *
         * ### Usage Example
         *
         * TODO
         */
        @JsonDeserialize(builder = AddressRequest.Builder::class)
        @NoAutoDetect
        class AddressRequest
        private constructor(
            private val street1: String?,
            private val street2: String?,
            private val city: String?,
            private val state: String?,
            private val postalCode: String?,
            private val country: Country?,
            private val addressType: AddressTypeEnum?,
            private val integrationParams: JsonValue?,
            private val linkedAccountParams: JsonValue?,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var hashCode: Int = 0

            /** Line 1 of the address's street. */
            @JsonProperty("street_1") fun street1(): String? = street1

            /** Line 2 of the address's street. */
            @JsonProperty("street_2") fun street2(): String? = street2

            /** The address's city. */
            @JsonProperty("city") fun city(): String? = city

            /** The address's state. */
            @JsonProperty("state") fun state(): String? = state

            /** The address's postal code. */
            @JsonProperty("postal_code") fun postalCode(): String? = postalCode

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

            /**
             * - `BILLING` - BILLING
             * - `SHIPPING` - SHIPPING
             */
            @JsonProperty("address_type") fun addressType(): AddressTypeEnum? = addressType

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

                return other is AddressRequest &&
                    this.street1 == other.street1 &&
                    this.street2 == other.street2 &&
                    this.city == other.city &&
                    this.state == other.state &&
                    this.postalCode == other.postalCode &&
                    this.country == other.country &&
                    this.addressType == other.addressType &&
                    this.integrationParams == other.integrationParams &&
                    this.linkedAccountParams == other.linkedAccountParams &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            street1,
                            street2,
                            city,
                            state,
                            postalCode,
                            country,
                            addressType,
                            integrationParams,
                            linkedAccountParams,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "AddressRequest{street1=$street1, street2=$street2, city=$city, state=$state, postalCode=$postalCode, country=$country, addressType=$addressType, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var street1: String? = null
                private var street2: String? = null
                private var city: String? = null
                private var state: String? = null
                private var postalCode: String? = null
                private var country: Country? = null
                private var addressType: AddressTypeEnum? = null
                private var integrationParams: JsonValue? = null
                private var linkedAccountParams: JsonValue? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(addressRequest: AddressRequest) = apply {
                    this.street1 = addressRequest.street1
                    this.street2 = addressRequest.street2
                    this.city = addressRequest.city
                    this.state = addressRequest.state
                    this.postalCode = addressRequest.postalCode
                    this.country = addressRequest.country
                    this.addressType = addressRequest.addressType
                    this.integrationParams = addressRequest.integrationParams
                    this.linkedAccountParams = addressRequest.linkedAccountParams
                    additionalProperties(addressRequest.additionalProperties)
                }

                /** Line 1 of the address's street. */
                @JsonProperty("street_1")
                fun street1(street1: String) = apply { this.street1 = street1 }

                /** Line 2 of the address's street. */
                @JsonProperty("street_2")
                fun street2(street2: String) = apply { this.street2 = street2 }

                /** The address's city. */
                @JsonProperty("city") fun city(city: String) = apply { this.city = city }

                /** The address's state. */
                @JsonProperty("state") fun state(state: String) = apply { this.state = state }

                /** The address's postal code. */
                @JsonProperty("postal_code")
                fun postalCode(postalCode: String) = apply { this.postalCode = postalCode }

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

                /**
                 * - `BILLING` - BILLING
                 * - `SHIPPING` - SHIPPING
                 */
                @JsonProperty("address_type")
                fun addressType(addressType: AddressTypeEnum) = apply {
                    this.addressType = addressType
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

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): AddressRequest =
                    AddressRequest(
                        street1,
                        street2,
                        city,
                        state,
                        postalCode,
                        country,
                        addressType,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties.toUnmodifiable(),
                    )
            }

            class AddressTypeEnum
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is AddressTypeEnum && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    @JvmField val BILLING = AddressTypeEnum(JsonField.of("BILLING"))

                    @JvmField val SHIPPING = AddressTypeEnum(JsonField.of("SHIPPING"))

                    @JvmStatic fun of(value: String) = AddressTypeEnum(JsonField.of(value))
                }

                enum class Known {
                    BILLING,
                    SHIPPING,
                }

                enum class Value {
                    BILLING,
                    SHIPPING,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        BILLING -> Value.BILLING
                        SHIPPING -> Value.SHIPPING
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        BILLING -> Known.BILLING
                        SHIPPING -> Known.SHIPPING
                        else -> throw MergeInvalidDataException("Unknown AddressTypeEnum: $value")
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
    }
}
