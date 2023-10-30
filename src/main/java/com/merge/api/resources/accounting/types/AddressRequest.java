package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AddressRequest.Builder.class)
public final class AddressRequest {
    private final Optional<AddressRequestType> type;

    private final Optional<String> street1;

    private final Optional<String> street2;

    private final Optional<String> city;

    private final Optional<String> countrySubdivision;

    private final Optional<AddressRequestCountry> country;

    private final Optional<String> zipCode;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private AddressRequest(
            Optional<AddressRequestType> type,
            Optional<String> street1,
            Optional<String> street2,
            Optional<String> city,
            Optional<String> countrySubdivision,
            Optional<AddressRequestCountry> country,
            Optional<String> zipCode,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.type = type;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.countrySubdivision = countrySubdivision;
        this.country = country;
        this.zipCode = zipCode;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
    }

    /**
     * @return The address type.
     * <ul>
     * <li><code>BILLING</code> - BILLING</li>
     * <li><code>SHIPPING</code> - SHIPPING</li>
     * </ul>
     */
    @JsonProperty("type")
    public Optional<AddressRequestType> getType() {
        return type;
    }

    /**
     * @return Line 1 of the address's street.
     */
    @JsonProperty("street_1")
    public Optional<String> getStreet1() {
        return street1;
    }

    /**
     * @return Line 2 of the address's street.
     */
    @JsonProperty("street_2")
    public Optional<String> getStreet2() {
        return street2;
    }

    /**
     * @return The address's city.
     */
    @JsonProperty("city")
    public Optional<String> getCity() {
        return city;
    }

    /**
     * @return The address's state or region.
     */
    @JsonProperty("country_subdivision")
    public Optional<String> getCountrySubdivision() {
        return countrySubdivision;
    }

    /**
     * @return The address's country.
     * <ul>
     * <li><code>AF</code> - Afghanistan</li>
     * <li><code>AX</code> - Åland Islands</li>
     * <li><code>AL</code> - Albania</li>
     * <li><code>DZ</code> - Algeria</li>
     * <li><code>AS</code> - American Samoa</li>
     * <li><code>AD</code> - Andorra</li>
     * <li><code>AO</code> - Angola</li>
     * <li><code>AI</code> - Anguilla</li>
     * <li><code>AQ</code> - Antarctica</li>
     * <li><code>AG</code> - Antigua and Barbuda</li>
     * <li><code>AR</code> - Argentina</li>
     * <li><code>AM</code> - Armenia</li>
     * <li><code>AW</code> - Aruba</li>
     * <li><code>AU</code> - Australia</li>
     * <li><code>AT</code> - Austria</li>
     * <li><code>AZ</code> - Azerbaijan</li>
     * <li><code>BS</code> - Bahamas</li>
     * <li><code>BH</code> - Bahrain</li>
     * <li><code>BD</code> - Bangladesh</li>
     * <li><code>BB</code> - Barbados</li>
     * <li><code>BY</code> - Belarus</li>
     * <li><code>BE</code> - Belgium</li>
     * <li><code>BZ</code> - Belize</li>
     * <li><code>BJ</code> - Benin</li>
     * <li><code>BM</code> - Bermuda</li>
     * <li><code>BT</code> - Bhutan</li>
     * <li><code>BO</code> - Bolivia</li>
     * <li><code>BQ</code> - Bonaire, Sint Eustatius and Saba</li>
     * <li><code>BA</code> - Bosnia and Herzegovina</li>
     * <li><code>BW</code> - Botswana</li>
     * <li><code>BV</code> - Bouvet Island</li>
     * <li><code>BR</code> - Brazil</li>
     * <li><code>IO</code> - British Indian Ocean Territory</li>
     * <li><code>BN</code> - Brunei</li>
     * <li><code>BG</code> - Bulgaria</li>
     * <li><code>BF</code> - Burkina Faso</li>
     * <li><code>BI</code> - Burundi</li>
     * <li><code>CV</code> - Cabo Verde</li>
     * <li><code>KH</code> - Cambodia</li>
     * <li><code>CM</code> - Cameroon</li>
     * <li><code>CA</code> - Canada</li>
     * <li><code>KY</code> - Cayman Islands</li>
     * <li><code>CF</code> - Central African Republic</li>
     * <li><code>TD</code> - Chad</li>
     * <li><code>CL</code> - Chile</li>
     * <li><code>CN</code> - China</li>
     * <li><code>CX</code> - Christmas Island</li>
     * <li><code>CC</code> - Cocos (Keeling) Islands</li>
     * <li><code>CO</code> - Colombia</li>
     * <li><code>KM</code> - Comoros</li>
     * <li><code>CG</code> - Congo</li>
     * <li><code>CD</code> - Congo (the Democratic Republic of the)</li>
     * <li><code>CK</code> - Cook Islands</li>
     * <li><code>CR</code> - Costa Rica</li>
     * <li><code>CI</code> - Côte d'Ivoire</li>
     * <li><code>HR</code> - Croatia</li>
     * <li><code>CU</code> - Cuba</li>
     * <li><code>CW</code> - Curaçao</li>
     * <li><code>CY</code> - Cyprus</li>
     * <li><code>CZ</code> - Czechia</li>
     * <li><code>DK</code> - Denmark</li>
     * <li><code>DJ</code> - Djibouti</li>
     * <li><code>DM</code> - Dominica</li>
     * <li><code>DO</code> - Dominican Republic</li>
     * <li><code>EC</code> - Ecuador</li>
     * <li><code>EG</code> - Egypt</li>
     * <li><code>SV</code> - El Salvador</li>
     * <li><code>GQ</code> - Equatorial Guinea</li>
     * <li><code>ER</code> - Eritrea</li>
     * <li><code>EE</code> - Estonia</li>
     * <li><code>SZ</code> - Eswatini</li>
     * <li><code>ET</code> - Ethiopia</li>
     * <li><code>FK</code> - Falkland Islands (Malvinas)</li>
     * <li><code>FO</code> - Faroe Islands</li>
     * <li><code>FJ</code> - Fiji</li>
     * <li><code>FI</code> - Finland</li>
     * <li><code>FR</code> - France</li>
     * <li><code>GF</code> - French Guiana</li>
     * <li><code>PF</code> - French Polynesia</li>
     * <li><code>TF</code> - French Southern Territories</li>
     * <li><code>GA</code> - Gabon</li>
     * <li><code>GM</code> - Gambia</li>
     * <li><code>GE</code> - Georgia</li>
     * <li><code>DE</code> - Germany</li>
     * <li><code>GH</code> - Ghana</li>
     * <li><code>GI</code> - Gibraltar</li>
     * <li><code>GR</code> - Greece</li>
     * <li><code>GL</code> - Greenland</li>
     * <li><code>GD</code> - Grenada</li>
     * <li><code>GP</code> - Guadeloupe</li>
     * <li><code>GU</code> - Guam</li>
     * <li><code>GT</code> - Guatemala</li>
     * <li><code>GG</code> - Guernsey</li>
     * <li><code>GN</code> - Guinea</li>
     * <li><code>GW</code> - Guinea-Bissau</li>
     * <li><code>GY</code> - Guyana</li>
     * <li><code>HT</code> - Haiti</li>
     * <li><code>HM</code> - Heard Island and McDonald Islands</li>
     * <li><code>VA</code> - Holy See</li>
     * <li><code>HN</code> - Honduras</li>
     * <li><code>HK</code> - Hong Kong</li>
     * <li><code>HU</code> - Hungary</li>
     * <li><code>IS</code> - Iceland</li>
     * <li><code>IN</code> - India</li>
     * <li><code>ID</code> - Indonesia</li>
     * <li><code>IR</code> - Iran</li>
     * <li><code>IQ</code> - Iraq</li>
     * <li><code>IE</code> - Ireland</li>
     * <li><code>IM</code> - Isle of Man</li>
     * <li><code>IL</code> - Israel</li>
     * <li><code>IT</code> - Italy</li>
     * <li><code>JM</code> - Jamaica</li>
     * <li><code>JP</code> - Japan</li>
     * <li><code>JE</code> - Jersey</li>
     * <li><code>JO</code> - Jordan</li>
     * <li><code>KZ</code> - Kazakhstan</li>
     * <li><code>KE</code> - Kenya</li>
     * <li><code>KI</code> - Kiribati</li>
     * <li><code>KW</code> - Kuwait</li>
     * <li><code>KG</code> - Kyrgyzstan</li>
     * <li><code>LA</code> - Laos</li>
     * <li><code>LV</code> - Latvia</li>
     * <li><code>LB</code> - Lebanon</li>
     * <li><code>LS</code> - Lesotho</li>
     * <li><code>LR</code> - Liberia</li>
     * <li><code>LY</code> - Libya</li>
     * <li><code>LI</code> - Liechtenstein</li>
     * <li><code>LT</code> - Lithuania</li>
     * <li><code>LU</code> - Luxembourg</li>
     * <li><code>MO</code> - Macao</li>
     * <li><code>MG</code> - Madagascar</li>
     * <li><code>MW</code> - Malawi</li>
     * <li><code>MY</code> - Malaysia</li>
     * <li><code>MV</code> - Maldives</li>
     * <li><code>ML</code> - Mali</li>
     * <li><code>MT</code> - Malta</li>
     * <li><code>MH</code> - Marshall Islands</li>
     * <li><code>MQ</code> - Martinique</li>
     * <li><code>MR</code> - Mauritania</li>
     * <li><code>MU</code> - Mauritius</li>
     * <li><code>YT</code> - Mayotte</li>
     * <li><code>MX</code> - Mexico</li>
     * <li><code>FM</code> - Micronesia (Federated States of)</li>
     * <li><code>MD</code> - Moldova</li>
     * <li><code>MC</code> - Monaco</li>
     * <li><code>MN</code> - Mongolia</li>
     * <li><code>ME</code> - Montenegro</li>
     * <li><code>MS</code> - Montserrat</li>
     * <li><code>MA</code> - Morocco</li>
     * <li><code>MZ</code> - Mozambique</li>
     * <li><code>MM</code> - Myanmar</li>
     * <li><code>NA</code> - Namibia</li>
     * <li><code>NR</code> - Nauru</li>
     * <li><code>NP</code> - Nepal</li>
     * <li><code>NL</code> - Netherlands</li>
     * <li><code>NC</code> - New Caledonia</li>
     * <li><code>NZ</code> - New Zealand</li>
     * <li><code>NI</code> - Nicaragua</li>
     * <li><code>NE</code> - Niger</li>
     * <li><code>NG</code> - Nigeria</li>
     * <li><code>NU</code> - Niue</li>
     * <li><code>NF</code> - Norfolk Island</li>
     * <li><code>KP</code> - North Korea</li>
     * <li><code>MK</code> - North Macedonia</li>
     * <li><code>MP</code> - Northern Mariana Islands</li>
     * <li><code>NO</code> - Norway</li>
     * <li><code>OM</code> - Oman</li>
     * <li><code>PK</code> - Pakistan</li>
     * <li><code>PW</code> - Palau</li>
     * <li><code>PS</code> - Palestine, State of</li>
     * <li><code>PA</code> - Panama</li>
     * <li><code>PG</code> - Papua New Guinea</li>
     * <li><code>PY</code> - Paraguay</li>
     * <li><code>PE</code> - Peru</li>
     * <li><code>PH</code> - Philippines</li>
     * <li><code>PN</code> - Pitcairn</li>
     * <li><code>PL</code> - Poland</li>
     * <li><code>PT</code> - Portugal</li>
     * <li><code>PR</code> - Puerto Rico</li>
     * <li><code>QA</code> - Qatar</li>
     * <li><code>RE</code> - Réunion</li>
     * <li><code>RO</code> - Romania</li>
     * <li><code>RU</code> - Russia</li>
     * <li><code>RW</code> - Rwanda</li>
     * <li><code>BL</code> - Saint Barthélemy</li>
     * <li><code>SH</code> - Saint Helena, Ascension and Tristan da Cunha</li>
     * <li><code>KN</code> - Saint Kitts and Nevis</li>
     * <li><code>LC</code> - Saint Lucia</li>
     * <li><code>MF</code> - Saint Martin (French part)</li>
     * <li><code>PM</code> - Saint Pierre and Miquelon</li>
     * <li><code>VC</code> - Saint Vincent and the Grenadines</li>
     * <li><code>WS</code> - Samoa</li>
     * <li><code>SM</code> - San Marino</li>
     * <li><code>ST</code> - Sao Tome and Principe</li>
     * <li><code>SA</code> - Saudi Arabia</li>
     * <li><code>SN</code> - Senegal</li>
     * <li><code>RS</code> - Serbia</li>
     * <li><code>SC</code> - Seychelles</li>
     * <li><code>SL</code> - Sierra Leone</li>
     * <li><code>SG</code> - Singapore</li>
     * <li><code>SX</code> - Sint Maarten (Dutch part)</li>
     * <li><code>SK</code> - Slovakia</li>
     * <li><code>SI</code> - Slovenia</li>
     * <li><code>SB</code> - Solomon Islands</li>
     * <li><code>SO</code> - Somalia</li>
     * <li><code>ZA</code> - South Africa</li>
     * <li><code>GS</code> - South Georgia and the South Sandwich Islands</li>
     * <li><code>KR</code> - South Korea</li>
     * <li><code>SS</code> - South Sudan</li>
     * <li><code>ES</code> - Spain</li>
     * <li><code>LK</code> - Sri Lanka</li>
     * <li><code>SD</code> - Sudan</li>
     * <li><code>SR</code> - Suriname</li>
     * <li><code>SJ</code> - Svalbard and Jan Mayen</li>
     * <li><code>SE</code> - Sweden</li>
     * <li><code>CH</code> - Switzerland</li>
     * <li><code>SY</code> - Syria</li>
     * <li><code>TW</code> - Taiwan</li>
     * <li><code>TJ</code> - Tajikistan</li>
     * <li><code>TZ</code> - Tanzania</li>
     * <li><code>TH</code> - Thailand</li>
     * <li><code>TL</code> - Timor-Leste</li>
     * <li><code>TG</code> - Togo</li>
     * <li><code>TK</code> - Tokelau</li>
     * <li><code>TO</code> - Tonga</li>
     * <li><code>TT</code> - Trinidad and Tobago</li>
     * <li><code>TN</code> - Tunisia</li>
     * <li><code>TR</code> - Turkey</li>
     * <li><code>TM</code> - Turkmenistan</li>
     * <li><code>TC</code> - Turks and Caicos Islands</li>
     * <li><code>TV</code> - Tuvalu</li>
     * <li><code>UG</code> - Uganda</li>
     * <li><code>UA</code> - Ukraine</li>
     * <li><code>AE</code> - United Arab Emirates</li>
     * <li><code>GB</code> - United Kingdom</li>
     * <li><code>UM</code> - United States Minor Outlying Islands</li>
     * <li><code>US</code> - United States of America</li>
     * <li><code>UY</code> - Uruguay</li>
     * <li><code>UZ</code> - Uzbekistan</li>
     * <li><code>VU</code> - Vanuatu</li>
     * <li><code>VE</code> - Venezuela</li>
     * <li><code>VN</code> - Vietnam</li>
     * <li><code>VG</code> - Virgin Islands (British)</li>
     * <li><code>VI</code> - Virgin Islands (U.S.)</li>
     * <li><code>WF</code> - Wallis and Futuna</li>
     * <li><code>EH</code> - Western Sahara</li>
     * <li><code>YE</code> - Yemen</li>
     * <li><code>ZM</code> - Zambia</li>
     * <li><code>ZW</code> - Zimbabwe</li>
     * </ul>
     */
    @JsonProperty("country")
    public Optional<AddressRequestCountry> getCountry() {
        return country;
    }

    /**
     * @return The address's zip code.
     */
    @JsonProperty("zip_code")
    public Optional<String> getZipCode() {
        return zipCode;
    }

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AddressRequest && equalTo((AddressRequest) other);
    }

    private boolean equalTo(AddressRequest other) {
        return type.equals(other.type)
                && street1.equals(other.street1)
                && street2.equals(other.street2)
                && city.equals(other.city)
                && countrySubdivision.equals(other.countrySubdivision)
                && country.equals(other.country)
                && zipCode.equals(other.zipCode)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.type,
                this.street1,
                this.street2,
                this.city,
                this.countrySubdivision,
                this.country,
                this.zipCode,
                this.integrationParams,
                this.linkedAccountParams);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<AddressRequestType> type = Optional.empty();

        private Optional<String> street1 = Optional.empty();

        private Optional<String> street2 = Optional.empty();

        private Optional<String> city = Optional.empty();

        private Optional<String> countrySubdivision = Optional.empty();

        private Optional<AddressRequestCountry> country = Optional.empty();

        private Optional<String> zipCode = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(AddressRequest other) {
            type(other.getType());
            street1(other.getStreet1());
            street2(other.getStreet2());
            city(other.getCity());
            countrySubdivision(other.getCountrySubdivision());
            country(other.getCountry());
            zipCode(other.getZipCode());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<AddressRequestType> type) {
            this.type = type;
            return this;
        }

        public Builder type(AddressRequestType type) {
            this.type = Optional.of(type);
            return this;
        }

        @JsonSetter(value = "street_1", nulls = Nulls.SKIP)
        public Builder street1(Optional<String> street1) {
            this.street1 = street1;
            return this;
        }

        public Builder street1(String street1) {
            this.street1 = Optional.of(street1);
            return this;
        }

        @JsonSetter(value = "street_2", nulls = Nulls.SKIP)
        public Builder street2(Optional<String> street2) {
            this.street2 = street2;
            return this;
        }

        public Builder street2(String street2) {
            this.street2 = Optional.of(street2);
            return this;
        }

        @JsonSetter(value = "city", nulls = Nulls.SKIP)
        public Builder city(Optional<String> city) {
            this.city = city;
            return this;
        }

        public Builder city(String city) {
            this.city = Optional.of(city);
            return this;
        }

        @JsonSetter(value = "country_subdivision", nulls = Nulls.SKIP)
        public Builder countrySubdivision(Optional<String> countrySubdivision) {
            this.countrySubdivision = countrySubdivision;
            return this;
        }

        public Builder countrySubdivision(String countrySubdivision) {
            this.countrySubdivision = Optional.of(countrySubdivision);
            return this;
        }

        @JsonSetter(value = "country", nulls = Nulls.SKIP)
        public Builder country(Optional<AddressRequestCountry> country) {
            this.country = country;
            return this;
        }

        public Builder country(AddressRequestCountry country) {
            this.country = Optional.of(country);
            return this;
        }

        @JsonSetter(value = "zip_code", nulls = Nulls.SKIP)
        public Builder zipCode(Optional<String> zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder zipCode(String zipCode) {
            this.zipCode = Optional.of(zipCode);
            return this;
        }

        @JsonSetter(value = "integration_params", nulls = Nulls.SKIP)
        public Builder integrationParams(Optional<Map<String, JsonNode>> integrationParams) {
            this.integrationParams = integrationParams;
            return this;
        }

        public Builder integrationParams(Map<String, JsonNode> integrationParams) {
            this.integrationParams = Optional.of(integrationParams);
            return this;
        }

        @JsonSetter(value = "linked_account_params", nulls = Nulls.SKIP)
        public Builder linkedAccountParams(Optional<Map<String, JsonNode>> linkedAccountParams) {
            this.linkedAccountParams = linkedAccountParams;
            return this;
        }

        public Builder linkedAccountParams(Map<String, JsonNode> linkedAccountParams) {
            this.linkedAccountParams = Optional.of(linkedAccountParams);
            return this;
        }

        public AddressRequest build() {
            return new AddressRequest(
                    type,
                    street1,
                    street2,
                    city,
                    countrySubdivision,
                    country,
                    zipCode,
                    integrationParams,
                    linkedAccountParams);
        }
    }
}
