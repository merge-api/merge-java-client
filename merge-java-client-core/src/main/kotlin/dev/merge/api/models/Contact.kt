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
@JsonDeserialize(builder = Contact.Builder::class)
@NoAutoDetect
class Contact
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val name: JsonField<String>,
    private val isSupplier: JsonField<Boolean>,
    private val isCustomer: JsonField<Boolean>,
    private val emailAddress: JsonField<String>,
    private val taxNumber: JsonField<String>,
    private val status: JsonField<Status7d1Enum>,
    private val currency: JsonField<String>,
    private val remoteUpdatedAt: JsonField<OffsetDateTime>,
    private val company: JsonField<String>,
    private val addresses: JsonField<List<Address>>,
    private val phoneNumbers: JsonField<List<PhoneNumber>>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val phoneNumber: JsonField<String>,
    private val details: JsonField<String>,
    private val account: JsonField<String>,
    private val firstName: JsonField<String>,
    private val lastName: JsonField<String>,
    private val emailAddresses: JsonField<List<EmailAddress>>,
    private val lastActivityAt: JsonField<OffsetDateTime>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val remoteFields: JsonField<List<RemoteField>>,
    private val email: JsonField<String>,
    private val phone: JsonField<String>,
    private val state: JsonField<String>,
    private val country: JsonField<Country>,
    private val postalCode: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** The contact's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** Whether the contact is a supplier. */
    fun isSupplier(): Optional<Boolean> = Optional.ofNullable(isSupplier.getNullable("is_supplier"))

    /** Whether the contact is a customer. */
    fun isCustomer(): Optional<Boolean> = Optional.ofNullable(isCustomer.getNullable("is_customer"))

    /** The contact's email address. */
    fun emailAddress(): Optional<String> =
        Optional.ofNullable(emailAddress.getNullable("email_address"))

    /** The contact's tax number. */
    fun taxNumber(): Optional<String> = Optional.ofNullable(taxNumber.getNullable("tax_number"))

    /**
     * - `ACTIVE` - ACTIVE
     * - `ARCHIVED` - ARCHIVED
     */
    fun status(): Optional<Status7d1Enum> = Optional.ofNullable(status.getNullable("status"))

    /** The currency the contact's transactions are in. */
    fun currency(): Optional<String> = Optional.ofNullable(currency.getNullable("currency"))

    /** When the contact was last updated in the remote system. */
    fun remoteUpdatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteUpdatedAt.getNullable("remote_updated_at"))

    /** The company the contact belongs to. */
    fun company(): Optional<String> = Optional.ofNullable(company.getNullable("company"))

    /** `Address` object IDs for the given `Contacts` object. */
    fun addresses(): Optional<List<Address>> =
        Optional.ofNullable(addresses.getNullable("addresses"))

    /** `AccountingPhoneNumber` object for the given `Contacts` object. */
    fun phoneNumbers(): Optional<List<PhoneNumber>> =
        Optional.ofNullable(phoneNumbers.getNullable("phone_numbers"))

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    fun remoteWasDeleted(): Optional<Boolean> =
        Optional.ofNullable(remoteWasDeleted.getNullable("remote_was_deleted"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<RemoteData>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    /** The contact's phone number. */
    fun phoneNumber(): Optional<String> =
        Optional.ofNullable(phoneNumber.getNullable("phone_number"))

    /** The contact's details. */
    fun details(): Optional<String> = Optional.ofNullable(details.getNullable("details"))

    /** The contact's account. */
    fun account(): Optional<String> = Optional.ofNullable(account.getNullable("account"))

    /** The contact's first name. */
    fun firstName(): Optional<String> = Optional.ofNullable(firstName.getNullable("first_name"))

    /** The contact's last name. */
    fun lastName(): Optional<String> = Optional.ofNullable(lastName.getNullable("last_name"))

    fun emailAddresses(): Optional<List<EmailAddress>> =
        Optional.ofNullable(emailAddresses.getNullable("email_addresses"))

    /** When the contact's last activity occurred. */
    fun lastActivityAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(lastActivityAt.getNullable("last_activity_at"))

    /** When the contact was created in the remote system. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    fun remoteFields(): Optional<List<RemoteField>> =
        Optional.ofNullable(remoteFields.getNullable("remote_fields"))

    /** The contact's email. */
    fun email(): Optional<String> = Optional.ofNullable(email.getNullable("email"))

    /** The contact's phone. */
    fun phone(): Optional<String> = Optional.ofNullable(phone.getNullable("phone"))

    /** The contact's state. */
    fun state(): Optional<String> = Optional.ofNullable(state.getNullable("state"))

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

    /** The contact's postal code. */
    fun postalCode(): Optional<String> = Optional.ofNullable(postalCode.getNullable("postal_code"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    /** The contact's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** Whether the contact is a supplier. */
    @JsonProperty("is_supplier") @ExcludeMissing fun _isSupplier() = isSupplier

    /** Whether the contact is a customer. */
    @JsonProperty("is_customer") @ExcludeMissing fun _isCustomer() = isCustomer

    /** The contact's email address. */
    @JsonProperty("email_address") @ExcludeMissing fun _emailAddress() = emailAddress

    /** The contact's tax number. */
    @JsonProperty("tax_number") @ExcludeMissing fun _taxNumber() = taxNumber

    /**
     * - `ACTIVE` - ACTIVE
     * - `ARCHIVED` - ARCHIVED
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** The currency the contact's transactions are in. */
    @JsonProperty("currency") @ExcludeMissing fun _currency() = currency

    /** When the contact was last updated in the remote system. */
    @JsonProperty("remote_updated_at") @ExcludeMissing fun _remoteUpdatedAt() = remoteUpdatedAt

    /** The company the contact belongs to. */
    @JsonProperty("company") @ExcludeMissing fun _company() = company

    /** `Address` object IDs for the given `Contacts` object. */
    @JsonProperty("addresses") @ExcludeMissing fun _addresses() = addresses

    /** `AccountingPhoneNumber` object for the given `Contacts` object. */
    @JsonProperty("phone_numbers") @ExcludeMissing fun _phoneNumbers() = phoneNumbers

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    /** The contact's phone number. */
    @JsonProperty("phone_number") @ExcludeMissing fun _phoneNumber() = phoneNumber

    /** The contact's details. */
    @JsonProperty("details") @ExcludeMissing fun _details() = details

    /** The contact's account. */
    @JsonProperty("account") @ExcludeMissing fun _account() = account

    /** The contact's first name. */
    @JsonProperty("first_name") @ExcludeMissing fun _firstName() = firstName

    /** The contact's last name. */
    @JsonProperty("last_name") @ExcludeMissing fun _lastName() = lastName

    @JsonProperty("email_addresses") @ExcludeMissing fun _emailAddresses() = emailAddresses

    /** When the contact's last activity occurred. */
    @JsonProperty("last_activity_at") @ExcludeMissing fun _lastActivityAt() = lastActivityAt

    /** When the contact was created in the remote system. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    @JsonProperty("remote_fields") @ExcludeMissing fun _remoteFields() = remoteFields

    /** The contact's email. */
    @JsonProperty("email") @ExcludeMissing fun _email() = email

    /** The contact's phone. */
    @JsonProperty("phone") @ExcludeMissing fun _phone() = phone

    /** The contact's state. */
    @JsonProperty("state") @ExcludeMissing fun _state() = state

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

    /** The contact's postal code. */
    @JsonProperty("postal_code") @ExcludeMissing fun _postalCode() = postalCode

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Contact = apply {
        if (!validated) {
            id()
            remoteId()
            name()
            isSupplier()
            isCustomer()
            emailAddress()
            taxNumber()
            status()
            currency()
            remoteUpdatedAt()
            company()
            addresses().map { it.forEach { it.validate() } }
            phoneNumbers().map { it.forEach { it.validate() } }
            remoteWasDeleted()
            modifiedAt()
            remoteData().map { it.forEach { it.validate() } }
            phoneNumber()
            details()
            account()
            firstName()
            lastName()
            emailAddresses().map { it.forEach { it.validate() } }
            lastActivityAt()
            remoteCreatedAt()
            remoteFields().map { it.forEach { it.validate() } }
            email()
            phone()
            state()
            country()
            postalCode()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Contact &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.name == other.name &&
            this.isSupplier == other.isSupplier &&
            this.isCustomer == other.isCustomer &&
            this.emailAddress == other.emailAddress &&
            this.taxNumber == other.taxNumber &&
            this.status == other.status &&
            this.currency == other.currency &&
            this.remoteUpdatedAt == other.remoteUpdatedAt &&
            this.company == other.company &&
            this.addresses == other.addresses &&
            this.phoneNumbers == other.phoneNumbers &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.phoneNumber == other.phoneNumber &&
            this.details == other.details &&
            this.account == other.account &&
            this.firstName == other.firstName &&
            this.lastName == other.lastName &&
            this.emailAddresses == other.emailAddresses &&
            this.lastActivityAt == other.lastActivityAt &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
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
                    id,
                    remoteId,
                    name,
                    isSupplier,
                    isCustomer,
                    emailAddress,
                    taxNumber,
                    status,
                    currency,
                    remoteUpdatedAt,
                    company,
                    addresses,
                    phoneNumbers,
                    remoteWasDeleted,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    phoneNumber,
                    details,
                    account,
                    firstName,
                    lastName,
                    emailAddresses,
                    lastActivityAt,
                    remoteCreatedAt,
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
        "Contact{id=$id, remoteId=$remoteId, name=$name, isSupplier=$isSupplier, isCustomer=$isCustomer, emailAddress=$emailAddress, taxNumber=$taxNumber, status=$status, currency=$currency, remoteUpdatedAt=$remoteUpdatedAt, company=$company, addresses=$addresses, phoneNumbers=$phoneNumbers, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, phoneNumber=$phoneNumber, details=$details, account=$account, firstName=$firstName, lastName=$lastName, emailAddresses=$emailAddresses, lastActivityAt=$lastActivityAt, remoteCreatedAt=$remoteCreatedAt, remoteFields=$remoteFields, email=$email, phone=$phone, state=$state, country=$country, postalCode=$postalCode, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var isSupplier: JsonField<Boolean> = JsonMissing.of()
        private var isCustomer: JsonField<Boolean> = JsonMissing.of()
        private var emailAddress: JsonField<String> = JsonMissing.of()
        private var taxNumber: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status7d1Enum> = JsonMissing.of()
        private var currency: JsonField<String> = JsonMissing.of()
        private var remoteUpdatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var company: JsonField<String> = JsonMissing.of()
        private var addresses: JsonField<List<Address>> = JsonMissing.of()
        private var phoneNumbers: JsonField<List<PhoneNumber>> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var phoneNumber: JsonField<String> = JsonMissing.of()
        private var details: JsonField<String> = JsonMissing.of()
        private var account: JsonField<String> = JsonMissing.of()
        private var firstName: JsonField<String> = JsonMissing.of()
        private var lastName: JsonField<String> = JsonMissing.of()
        private var emailAddresses: JsonField<List<EmailAddress>> = JsonMissing.of()
        private var lastActivityAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteFields: JsonField<List<RemoteField>> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var phone: JsonField<String> = JsonMissing.of()
        private var state: JsonField<String> = JsonMissing.of()
        private var country: JsonField<Country> = JsonMissing.of()
        private var postalCode: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contact: Contact) = apply {
            this.id = contact.id
            this.remoteId = contact.remoteId
            this.name = contact.name
            this.isSupplier = contact.isSupplier
            this.isCustomer = contact.isCustomer
            this.emailAddress = contact.emailAddress
            this.taxNumber = contact.taxNumber
            this.status = contact.status
            this.currency = contact.currency
            this.remoteUpdatedAt = contact.remoteUpdatedAt
            this.company = contact.company
            this.addresses = contact.addresses
            this.phoneNumbers = contact.phoneNumbers
            this.remoteWasDeleted = contact.remoteWasDeleted
            this.fieldMappings = contact.fieldMappings
            this.modifiedAt = contact.modifiedAt
            this.remoteData = contact.remoteData
            this.phoneNumber = contact.phoneNumber
            this.details = contact.details
            this.account = contact.account
            this.firstName = contact.firstName
            this.lastName = contact.lastName
            this.emailAddresses = contact.emailAddresses
            this.lastActivityAt = contact.lastActivityAt
            this.remoteCreatedAt = contact.remoteCreatedAt
            this.remoteFields = contact.remoteFields
            this.email = contact.email
            this.phone = contact.phone
            this.state = contact.state
            this.country = contact.country
            this.postalCode = contact.postalCode
            additionalProperties(contact.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The contact's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The contact's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Whether the contact is a supplier. */
        fun isSupplier(isSupplier: Boolean) = isSupplier(JsonField.of(isSupplier))

        /** Whether the contact is a supplier. */
        @JsonProperty("is_supplier")
        @ExcludeMissing
        fun isSupplier(isSupplier: JsonField<Boolean>) = apply { this.isSupplier = isSupplier }

        /** Whether the contact is a customer. */
        fun isCustomer(isCustomer: Boolean) = isCustomer(JsonField.of(isCustomer))

        /** Whether the contact is a customer. */
        @JsonProperty("is_customer")
        @ExcludeMissing
        fun isCustomer(isCustomer: JsonField<Boolean>) = apply { this.isCustomer = isCustomer }

        /** The contact's email address. */
        fun emailAddress(emailAddress: String) = emailAddress(JsonField.of(emailAddress))

        /** The contact's email address. */
        @JsonProperty("email_address")
        @ExcludeMissing
        fun emailAddress(emailAddress: JsonField<String>) = apply {
            this.emailAddress = emailAddress
        }

        /** The contact's tax number. */
        fun taxNumber(taxNumber: String) = taxNumber(JsonField.of(taxNumber))

        /** The contact's tax number. */
        @JsonProperty("tax_number")
        @ExcludeMissing
        fun taxNumber(taxNumber: JsonField<String>) = apply { this.taxNumber = taxNumber }

        /**
         * - `ACTIVE` - ACTIVE
         * - `ARCHIVED` - ARCHIVED
         */
        fun status(status: Status7d1Enum) = status(JsonField.of(status))

        /**
         * - `ACTIVE` - ACTIVE
         * - `ARCHIVED` - ARCHIVED
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status7d1Enum>) = apply { this.status = status }

        /** The currency the contact's transactions are in. */
        fun currency(currency: String) = currency(JsonField.of(currency))

        /** The currency the contact's transactions are in. */
        @JsonProperty("currency")
        @ExcludeMissing
        fun currency(currency: JsonField<String>) = apply { this.currency = currency }

        /** When the contact was last updated in the remote system. */
        fun remoteUpdatedAt(remoteUpdatedAt: OffsetDateTime) =
            remoteUpdatedAt(JsonField.of(remoteUpdatedAt))

        /** When the contact was last updated in the remote system. */
        @JsonProperty("remote_updated_at")
        @ExcludeMissing
        fun remoteUpdatedAt(remoteUpdatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteUpdatedAt = remoteUpdatedAt
        }

        /** The company the contact belongs to. */
        fun company(company: String) = company(JsonField.of(company))

        /** The company the contact belongs to. */
        @JsonProperty("company")
        @ExcludeMissing
        fun company(company: JsonField<String>) = apply { this.company = company }

        /** `Address` object IDs for the given `Contacts` object. */
        fun addresses(addresses: List<Address>) = addresses(JsonField.of(addresses))

        /** `Address` object IDs for the given `Contacts` object. */
        @JsonProperty("addresses")
        @ExcludeMissing
        fun addresses(addresses: JsonField<List<Address>>) = apply { this.addresses = addresses }

        /** `AccountingPhoneNumber` object for the given `Contacts` object. */
        fun phoneNumbers(phoneNumbers: List<PhoneNumber>) = phoneNumbers(JsonField.of(phoneNumbers))

        /** `AccountingPhoneNumber` object for the given `Contacts` object. */
        @JsonProperty("phone_numbers")
        @ExcludeMissing
        fun phoneNumbers(phoneNumbers: JsonField<List<PhoneNumber>>) = apply {
            this.phoneNumbers = phoneNumbers
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

        /** The contact's phone number. */
        fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

        /** The contact's phone number. */
        @JsonProperty("phone_number")
        @ExcludeMissing
        fun phoneNumber(phoneNumber: JsonField<String>) = apply { this.phoneNumber = phoneNumber }

        /** The contact's details. */
        fun details(details: String) = details(JsonField.of(details))

        /** The contact's details. */
        @JsonProperty("details")
        @ExcludeMissing
        fun details(details: JsonField<String>) = apply { this.details = details }

        /** The contact's account. */
        fun account(account: String) = account(JsonField.of(account))

        /** The contact's account. */
        @JsonProperty("account")
        @ExcludeMissing
        fun account(account: JsonField<String>) = apply { this.account = account }

        /** The contact's first name. */
        fun firstName(firstName: String) = firstName(JsonField.of(firstName))

        /** The contact's first name. */
        @JsonProperty("first_name")
        @ExcludeMissing
        fun firstName(firstName: JsonField<String>) = apply { this.firstName = firstName }

        /** The contact's last name. */
        fun lastName(lastName: String) = lastName(JsonField.of(lastName))

        /** The contact's last name. */
        @JsonProperty("last_name")
        @ExcludeMissing
        fun lastName(lastName: JsonField<String>) = apply { this.lastName = lastName }

        fun emailAddresses(emailAddresses: List<EmailAddress>) =
            emailAddresses(JsonField.of(emailAddresses))

        @JsonProperty("email_addresses")
        @ExcludeMissing
        fun emailAddresses(emailAddresses: JsonField<List<EmailAddress>>) = apply {
            this.emailAddresses = emailAddresses
        }

        /** When the contact's last activity occurred. */
        fun lastActivityAt(lastActivityAt: OffsetDateTime) =
            lastActivityAt(JsonField.of(lastActivityAt))

        /** When the contact's last activity occurred. */
        @JsonProperty("last_activity_at")
        @ExcludeMissing
        fun lastActivityAt(lastActivityAt: JsonField<OffsetDateTime>) = apply {
            this.lastActivityAt = lastActivityAt
        }

        /** When the contact was created in the remote system. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the contact was created in the remote system. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        fun remoteFields(remoteFields: List<RemoteField>) = remoteFields(JsonField.of(remoteFields))

        @JsonProperty("remote_fields")
        @ExcludeMissing
        fun remoteFields(remoteFields: JsonField<List<RemoteField>>) = apply {
            this.remoteFields = remoteFields
        }

        /** The contact's email. */
        fun email(email: String) = email(JsonField.of(email))

        /** The contact's email. */
        @JsonProperty("email")
        @ExcludeMissing
        fun email(email: JsonField<String>) = apply { this.email = email }

        /** The contact's phone. */
        fun phone(phone: String) = phone(JsonField.of(phone))

        /** The contact's phone. */
        @JsonProperty("phone")
        @ExcludeMissing
        fun phone(phone: JsonField<String>) = apply { this.phone = phone }

        /** The contact's state. */
        fun state(state: String) = state(JsonField.of(state))

        /** The contact's state. */
        @JsonProperty("state")
        @ExcludeMissing
        fun state(state: JsonField<String>) = apply { this.state = state }

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

        /** The contact's postal code. */
        fun postalCode(postalCode: String) = postalCode(JsonField.of(postalCode))

        /** The contact's postal code. */
        @JsonProperty("postal_code")
        @ExcludeMissing
        fun postalCode(postalCode: JsonField<String>) = apply { this.postalCode = postalCode }

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

        fun build(): Contact =
            Contact(
                id,
                remoteId,
                name,
                isSupplier,
                isCustomer,
                emailAddress,
                taxNumber,
                status,
                currency,
                remoteUpdatedAt,
                company,
                addresses.map { it.toUnmodifiable() },
                phoneNumbers.map { it.toUnmodifiable() },
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                phoneNumber,
                details,
                account,
                firstName,
                lastName,
                emailAddresses.map { it.toUnmodifiable() },
                lastActivityAt,
                remoteCreatedAt,
                remoteFields.map { it.toUnmodifiable() },
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

        fun validate(): PhoneNumber = apply {
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

        fun validate(): EmailAddress = apply {
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

        fun validate(): RemoteField = apply {
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
