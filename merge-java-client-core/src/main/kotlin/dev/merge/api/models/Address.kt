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
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

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
@JsonDeserialize(builder = Address.Builder::class)
@NoAutoDetect
class Address
private constructor(
    private val type: JsonField<AddressTypeEnum>,
    private val street1: JsonField<String>,
    private val street2: JsonField<String>,
    private val city: JsonField<String>,
    private val state: JsonField<String>,
    private val countrySubdivision: JsonField<String>,
    private val country: JsonField<Country>,
    private val zipCode: JsonField<String>,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val postalCode: JsonField<String>,
    private val addressType: JsonField<AddressTypeEnum>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /**
     * - `BILLING` - BILLING
     * - `SHIPPING` - SHIPPING
     */
    fun type(): Optional<AddressTypeEnum> = Optional.ofNullable(type.getNullable("type"))

    /** Line 1 of the address's street. */
    fun street1(): Optional<String> = Optional.ofNullable(street1.getNullable("street_1"))

    /** Line 2 of the address's street. */
    fun street2(): Optional<String> = Optional.ofNullable(street2.getNullable("street_2"))

    /** The address's city. */
    fun city(): Optional<String> = Optional.ofNullable(city.getNullable("city"))

    /** The address's state. */
    fun state(): Optional<String> = Optional.ofNullable(state.getNullable("state"))

    /** The address's state or region. */
    fun countrySubdivision(): Optional<String> =
        Optional.ofNullable(countrySubdivision.getNullable("country_subdivision"))

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
    fun country(): Optional<Country> = Optional.ofNullable(country.getNullable("country"))

    /** The address's zip code. */
    fun zipCode(): Optional<String> = Optional.ofNullable(zipCode.getNullable("zip_code"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    /** The address's postal code. */
    fun postalCode(): Optional<String> = Optional.ofNullable(postalCode.getNullable("postal_code"))

    /**
     * - `BILLING` - BILLING
     * - `SHIPPING` - SHIPPING
     */
    fun addressType(): Optional<AddressTypeEnum> =
        Optional.ofNullable(addressType.getNullable("address_type"))

    /**
     * - `BILLING` - BILLING
     * - `SHIPPING` - SHIPPING
     */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** Line 1 of the address's street. */
    @JsonProperty("street_1") @ExcludeMissing fun _street1() = street1

    /** Line 2 of the address's street. */
    @JsonProperty("street_2") @ExcludeMissing fun _street2() = street2

    /** The address's city. */
    @JsonProperty("city") @ExcludeMissing fun _city() = city

    /** The address's state. */
    @JsonProperty("state") @ExcludeMissing fun _state() = state

    /** The address's state or region. */
    @JsonProperty("country_subdivision")
    @ExcludeMissing
    fun _countrySubdivision() = countrySubdivision

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
    @JsonProperty("country") @ExcludeMissing fun _country() = country

    /** The address's zip code. */
    @JsonProperty("zip_code") @ExcludeMissing fun _zipCode() = zipCode

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    /** The address's postal code. */
    @JsonProperty("postal_code") @ExcludeMissing fun _postalCode() = postalCode

    /**
     * - `BILLING` - BILLING
     * - `SHIPPING` - SHIPPING
     */
    @JsonProperty("address_type") @ExcludeMissing fun _addressType() = addressType

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Address = apply {
        if (!validated) {
            type()
            street1()
            street2()
            city()
            state()
            countrySubdivision()
            country()
            zipCode()
            modifiedAt()
            postalCode()
            addressType()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Address &&
            this.type == other.type &&
            this.street1 == other.street1 &&
            this.street2 == other.street2 &&
            this.city == other.city &&
            this.state == other.state &&
            this.countrySubdivision == other.countrySubdivision &&
            this.country == other.country &&
            this.zipCode == other.zipCode &&
            this.modifiedAt == other.modifiedAt &&
            this.postalCode == other.postalCode &&
            this.addressType == other.addressType &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    type,
                    street1,
                    street2,
                    city,
                    state,
                    countrySubdivision,
                    country,
                    zipCode,
                    modifiedAt,
                    postalCode,
                    addressType,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Address{type=$type, street1=$street1, street2=$street2, city=$city, state=$state, countrySubdivision=$countrySubdivision, country=$country, zipCode=$zipCode, modifiedAt=$modifiedAt, postalCode=$postalCode, addressType=$addressType, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<AddressTypeEnum> = JsonMissing.of()
        private var street1: JsonField<String> = JsonMissing.of()
        private var street2: JsonField<String> = JsonMissing.of()
        private var city: JsonField<String> = JsonMissing.of()
        private var state: JsonField<String> = JsonMissing.of()
        private var countrySubdivision: JsonField<String> = JsonMissing.of()
        private var country: JsonField<Country> = JsonMissing.of()
        private var zipCode: JsonField<String> = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var postalCode: JsonField<String> = JsonMissing.of()
        private var addressType: JsonField<AddressTypeEnum> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(address: Address) = apply {
            this.type = address.type
            this.street1 = address.street1
            this.street2 = address.street2
            this.city = address.city
            this.state = address.state
            this.countrySubdivision = address.countrySubdivision
            this.country = address.country
            this.zipCode = address.zipCode
            this.modifiedAt = address.modifiedAt
            this.postalCode = address.postalCode
            this.addressType = address.addressType
            additionalProperties(address.additionalProperties)
        }

        /**
         * - `BILLING` - BILLING
         * - `SHIPPING` - SHIPPING
         */
        fun type(type: AddressTypeEnum) = type(JsonField.of(type))

        /**
         * - `BILLING` - BILLING
         * - `SHIPPING` - SHIPPING
         */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<AddressTypeEnum>) = apply { this.type = type }

        /** Line 1 of the address's street. */
        fun street1(street1: String) = street1(JsonField.of(street1))

        /** Line 1 of the address's street. */
        @JsonProperty("street_1")
        @ExcludeMissing
        fun street1(street1: JsonField<String>) = apply { this.street1 = street1 }

        /** Line 2 of the address's street. */
        fun street2(street2: String) = street2(JsonField.of(street2))

        /** Line 2 of the address's street. */
        @JsonProperty("street_2")
        @ExcludeMissing
        fun street2(street2: JsonField<String>) = apply { this.street2 = street2 }

        /** The address's city. */
        fun city(city: String) = city(JsonField.of(city))

        /** The address's city. */
        @JsonProperty("city")
        @ExcludeMissing
        fun city(city: JsonField<String>) = apply { this.city = city }

        /** The address's state. */
        fun state(state: String) = state(JsonField.of(state))

        /** The address's state. */
        @JsonProperty("state")
        @ExcludeMissing
        fun state(state: JsonField<String>) = apply { this.state = state }

        /** The address's state or region. */
        fun countrySubdivision(countrySubdivision: String) =
            countrySubdivision(JsonField.of(countrySubdivision))

        /** The address's state or region. */
        @JsonProperty("country_subdivision")
        @ExcludeMissing
        fun countrySubdivision(countrySubdivision: JsonField<String>) = apply {
            this.countrySubdivision = countrySubdivision
        }

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
        fun country(country: Country) = country(JsonField.of(country))

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
        @ExcludeMissing
        fun country(country: JsonField<Country>) = apply { this.country = country }

        /** The address's zip code. */
        fun zipCode(zipCode: String) = zipCode(JsonField.of(zipCode))

        /** The address's zip code. */
        @JsonProperty("zip_code")
        @ExcludeMissing
        fun zipCode(zipCode: JsonField<String>) = apply { this.zipCode = zipCode }

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at")
        @ExcludeMissing
        fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
            this.modifiedAt = modifiedAt
        }

        /** The address's postal code. */
        fun postalCode(postalCode: String) = postalCode(JsonField.of(postalCode))

        /** The address's postal code. */
        @JsonProperty("postal_code")
        @ExcludeMissing
        fun postalCode(postalCode: JsonField<String>) = apply { this.postalCode = postalCode }

        /**
         * - `BILLING` - BILLING
         * - `SHIPPING` - SHIPPING
         */
        fun addressType(addressType: AddressTypeEnum) = addressType(JsonField.of(addressType))

        /**
         * - `BILLING` - BILLING
         * - `SHIPPING` - SHIPPING
         */
        @JsonProperty("address_type")
        @ExcludeMissing
        fun addressType(addressType: JsonField<AddressTypeEnum>) = apply {
            this.addressType = addressType
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

        fun build(): Address =
            Address(
                type,
                street1,
                street2,
                city,
                state,
                countrySubdivision,
                country,
                zipCode,
                modifiedAt,
                postalCode,
                addressType,
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
