package dev.merge.api.models.hris

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
 * # The Location Object
 *
 * ### Description
 *
 * The `Location` object is used to represent an address that can be associated with an employee.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Locations` endpoint and filter by `ID` to show all office locations.
 */
@JsonDeserialize(builder = Location.Builder::class)
@NoAutoDetect
class Location
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val name: JsonField<String>,
    private val phoneNumber: JsonField<String>,
    private val street1: JsonField<String>,
    private val street2: JsonField<String>,
    private val city: JsonField<String>,
    private val state: JsonField<String>,
    private val zipCode: JsonField<String>,
    private val country: JsonField<Country>,
    private val locationType: JsonField<LocationTypeEnum>,
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

    /** The location's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The location's phone number. */
    fun phoneNumber(): Optional<String> =
        Optional.ofNullable(phoneNumber.getNullable("phone_number"))

    /** Line 1 of the location's street address. */
    fun street1(): Optional<String> = Optional.ofNullable(street1.getNullable("street_1"))

    /** Line 2 of the location's street address. */
    fun street2(): Optional<String> = Optional.ofNullable(street2.getNullable("street_2"))

    /** The location's city. */
    fun city(): Optional<String> = Optional.ofNullable(city.getNullable("city"))

    /** The location's state. Represents a region if outside of the US. */
    fun state(): Optional<String> = Optional.ofNullable(state.getNullable("state"))

    /** The location's zip code or postal code. */
    fun zipCode(): Optional<String> = Optional.ofNullable(zipCode.getNullable("zip_code"))

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

    /**
     * - `HOME` - HOME
     * - `WORK` - WORK
     */
    fun locationType(): Optional<LocationTypeEnum> =
        Optional.ofNullable(locationType.getNullable("location_type"))

    /** Indicates whether or not this object has been deleted by third party webhooks. */
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

    /** The location's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The location's phone number. */
    @JsonProperty("phone_number") @ExcludeMissing fun _phoneNumber() = phoneNumber

    /** Line 1 of the location's street address. */
    @JsonProperty("street_1") @ExcludeMissing fun _street1() = street1

    /** Line 2 of the location's street address. */
    @JsonProperty("street_2") @ExcludeMissing fun _street2() = street2

    /** The location's city. */
    @JsonProperty("city") @ExcludeMissing fun _city() = city

    /** The location's state. Represents a region if outside of the US. */
    @JsonProperty("state") @ExcludeMissing fun _state() = state

    /** The location's zip code or postal code. */
    @JsonProperty("zip_code") @ExcludeMissing fun _zipCode() = zipCode

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

    /**
     * - `HOME` - HOME
     * - `WORK` - WORK
     */
    @JsonProperty("location_type") @ExcludeMissing fun _locationType() = locationType

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Location = apply {
        if (!validated) {
            id()
            remoteId()
            name()
            phoneNumber()
            street1()
            street2()
            city()
            state()
            zipCode()
            country()
            locationType()
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

        return other is Location &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.name == other.name &&
            this.phoneNumber == other.phoneNumber &&
            this.street1 == other.street1 &&
            this.street2 == other.street2 &&
            this.city == other.city &&
            this.state == other.state &&
            this.zipCode == other.zipCode &&
            this.country == other.country &&
            this.locationType == other.locationType &&
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
                    name,
                    phoneNumber,
                    street1,
                    street2,
                    city,
                    state,
                    zipCode,
                    country,
                    locationType,
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
        "Location{id=$id, remoteId=$remoteId, name=$name, phoneNumber=$phoneNumber, street1=$street1, street2=$street2, city=$city, state=$state, zipCode=$zipCode, country=$country, locationType=$locationType, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var phoneNumber: JsonField<String> = JsonMissing.of()
        private var street1: JsonField<String> = JsonMissing.of()
        private var street2: JsonField<String> = JsonMissing.of()
        private var city: JsonField<String> = JsonMissing.of()
        private var state: JsonField<String> = JsonMissing.of()
        private var zipCode: JsonField<String> = JsonMissing.of()
        private var country: JsonField<Country> = JsonMissing.of()
        private var locationType: JsonField<LocationTypeEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(location: Location) = apply {
            this.id = location.id
            this.remoteId = location.remoteId
            this.name = location.name
            this.phoneNumber = location.phoneNumber
            this.street1 = location.street1
            this.street2 = location.street2
            this.city = location.city
            this.state = location.state
            this.zipCode = location.zipCode
            this.country = location.country
            this.locationType = location.locationType
            this.remoteWasDeleted = location.remoteWasDeleted
            this.fieldMappings = location.fieldMappings
            this.modifiedAt = location.modifiedAt
            this.remoteData = location.remoteData
            additionalProperties(location.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The location's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The location's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The location's phone number. */
        fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

        /** The location's phone number. */
        @JsonProperty("phone_number")
        @ExcludeMissing
        fun phoneNumber(phoneNumber: JsonField<String>) = apply { this.phoneNumber = phoneNumber }

        /** Line 1 of the location's street address. */
        fun street1(street1: String) = street1(JsonField.of(street1))

        /** Line 1 of the location's street address. */
        @JsonProperty("street_1")
        @ExcludeMissing
        fun street1(street1: JsonField<String>) = apply { this.street1 = street1 }

        /** Line 2 of the location's street address. */
        fun street2(street2: String) = street2(JsonField.of(street2))

        /** Line 2 of the location's street address. */
        @JsonProperty("street_2")
        @ExcludeMissing
        fun street2(street2: JsonField<String>) = apply { this.street2 = street2 }

        /** The location's city. */
        fun city(city: String) = city(JsonField.of(city))

        /** The location's city. */
        @JsonProperty("city")
        @ExcludeMissing
        fun city(city: JsonField<String>) = apply { this.city = city }

        /** The location's state. Represents a region if outside of the US. */
        fun state(state: String) = state(JsonField.of(state))

        /** The location's state. Represents a region if outside of the US. */
        @JsonProperty("state")
        @ExcludeMissing
        fun state(state: JsonField<String>) = apply { this.state = state }

        /** The location's zip code or postal code. */
        fun zipCode(zipCode: String) = zipCode(JsonField.of(zipCode))

        /** The location's zip code or postal code. */
        @JsonProperty("zip_code")
        @ExcludeMissing
        fun zipCode(zipCode: JsonField<String>) = apply { this.zipCode = zipCode }

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

        /**
         * - `HOME` - HOME
         * - `WORK` - WORK
         */
        fun locationType(locationType: LocationTypeEnum) = locationType(JsonField.of(locationType))

        /**
         * - `HOME` - HOME
         * - `WORK` - WORK
         */
        @JsonProperty("location_type")
        @ExcludeMissing
        fun locationType(locationType: JsonField<LocationTypeEnum>) = apply {
            this.locationType = locationType
        }

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

        /** Indicates whether or not this object has been deleted by third party webhooks. */
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

        fun build(): Location =
            Location(
                id,
                remoteId,
                name,
                phoneNumber,
                street1,
                street2,
                city,
                state,
                zipCode,
                country,
                locationType,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class LocationTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LocationTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val HOME = LocationTypeEnum(JsonField.of("HOME"))

            @JvmField val WORK = LocationTypeEnum(JsonField.of("WORK"))

            @JvmStatic fun of(value: String) = LocationTypeEnum(JsonField.of(value))
        }

        enum class Known {
            HOME,
            WORK,
        }

        enum class Value {
            HOME,
            WORK,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                HOME -> Value.HOME
                WORK -> Value.WORK
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                HOME -> Known.HOME
                WORK -> Known.WORK
                else -> throw MergeInvalidDataException("Unknown LocationTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
