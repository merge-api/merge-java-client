package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = VendorCredit.Builder.class)
public final class VendorCredit {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> number;

    private final Optional<OffsetDateTime> transactionDate;

    private final Optional<VendorCreditVendor> vendor;

    private final Optional<Double> totalAmount;

    private final Optional<VendorCreditCurrency> currency;

    private final Optional<String> exchangeRate;

    private final Optional<VendorCreditCompany> company;

    private final Optional<List<VendorCreditLine>> lines;

    private final Optional<List<Optional<VendorCreditTrackingCategoriesItem>>> trackingCategories;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<VendorCreditAccountingPeriod> accountingPeriod;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private VendorCredit(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> number,
            Optional<OffsetDateTime> transactionDate,
            Optional<VendorCreditVendor> vendor,
            Optional<Double> totalAmount,
            Optional<VendorCreditCurrency> currency,
            Optional<String> exchangeRate,
            Optional<VendorCreditCompany> company,
            Optional<List<VendorCreditLine>> lines,
            Optional<List<Optional<VendorCreditTrackingCategoriesItem>>> trackingCategories,
            Optional<Boolean> remoteWasDeleted,
            Optional<VendorCreditAccountingPeriod> accountingPeriod,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.number = number;
        this.transactionDate = transactionDate;
        this.vendor = vendor;
        this.totalAmount = totalAmount;
        this.currency = currency;
        this.exchangeRate = exchangeRate;
        this.company = company;
        this.lines = lines;
        this.trackingCategories = trackingCategories;
        this.remoteWasDeleted = remoteWasDeleted;
        this.accountingPeriod = accountingPeriod;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    /**
     * @return The vendor credit's number.
     */
    @JsonProperty("number")
    public Optional<String> getNumber() {
        return number;
    }

    /**
     * @return The vendor credit's transaction date.
     */
    @JsonProperty("transaction_date")
    public Optional<OffsetDateTime> getTransactionDate() {
        return transactionDate;
    }

    /**
     * @return The vendor that owes the gift or refund.
     */
    @JsonProperty("vendor")
    public Optional<VendorCreditVendor> getVendor() {
        return vendor;
    }

    /**
     * @return The vendor credit's total amount.
     */
    @JsonProperty("total_amount")
    public Optional<Double> getTotalAmount() {
        return totalAmount;
    }

    /**
     * @return The vendor credit's currency.
     * <ul>
     * <li><code>XUA</code> - ADB Unit of Account</li>
     * <li><code>AFN</code> - Afghan Afghani</li>
     * <li><code>AFA</code> - Afghan Afghani (1927–2002)</li>
     * <li><code>ALL</code> - Albanian Lek</li>
     * <li><code>ALK</code> - Albanian Lek (1946–1965)</li>
     * <li><code>DZD</code> - Algerian Dinar</li>
     * <li><code>ADP</code> - Andorran Peseta</li>
     * <li><code>AOA</code> - Angolan Kwanza</li>
     * <li><code>AOK</code> - Angolan Kwanza (1977–1991)</li>
     * <li><code>AON</code> - Angolan New Kwanza (1990–2000)</li>
     * <li><code>AOR</code> - Angolan Readjusted Kwanza (1995–1999)</li>
     * <li><code>ARA</code> - Argentine Austral</li>
     * <li><code>ARS</code> - Argentine Peso</li>
     * <li><code>ARM</code> - Argentine Peso (1881–1970)</li>
     * <li><code>ARP</code> - Argentine Peso (1983–1985)</li>
     * <li><code>ARL</code> - Argentine Peso Ley (1970–1983)</li>
     * <li><code>AMD</code> - Armenian Dram</li>
     * <li><code>AWG</code> - Aruban Florin</li>
     * <li><code>AUD</code> - Australian Dollar</li>
     * <li><code>ATS</code> - Austrian Schilling</li>
     * <li><code>AZN</code> - Azerbaijani Manat</li>
     * <li><code>AZM</code> - Azerbaijani Manat (1993–2006)</li>
     * <li><code>BSD</code> - Bahamian Dollar</li>
     * <li><code>BHD</code> - Bahraini Dinar</li>
     * <li><code>BDT</code> - Bangladeshi Taka</li>
     * <li><code>BBD</code> - Barbadian Dollar</li>
     * <li><code>BYN</code> - Belarusian Ruble</li>
     * <li><code>BYB</code> - Belarusian Ruble (1994–1999)</li>
     * <li><code>BYR</code> - Belarusian Ruble (2000–2016)</li>
     * <li><code>BEF</code> - Belgian Franc</li>
     * <li><code>BEC</code> - Belgian Franc (convertible)</li>
     * <li><code>BEL</code> - Belgian Franc (financial)</li>
     * <li><code>BZD</code> - Belize Dollar</li>
     * <li><code>BMD</code> - Bermudan Dollar</li>
     * <li><code>BTN</code> - Bhutanese Ngultrum</li>
     * <li><code>BOB</code> - Bolivian Boliviano</li>
     * <li><code>BOL</code> - Bolivian Boliviano (1863–1963)</li>
     * <li><code>BOV</code> - Bolivian Mvdol</li>
     * <li><code>BOP</code> - Bolivian Peso</li>
     * <li><code>BAM</code> - Bosnia-Herzegovina Convertible Mark</li>
     * <li><code>BAD</code> - Bosnia-Herzegovina Dinar (1992–1994)</li>
     * <li><code>BAN</code> - Bosnia-Herzegovina New Dinar (1994–1997)</li>
     * <li><code>BWP</code> - Botswanan Pula</li>
     * <li><code>BRC</code> - Brazilian Cruzado (1986–1989)</li>
     * <li><code>BRZ</code> - Brazilian Cruzeiro (1942–1967)</li>
     * <li><code>BRE</code> - Brazilian Cruzeiro (1990–1993)</li>
     * <li><code>BRR</code> - Brazilian Cruzeiro (1993–1994)</li>
     * <li><code>BRN</code> - Brazilian New Cruzado (1989–1990)</li>
     * <li><code>BRB</code> - Brazilian New Cruzeiro (1967–1986)</li>
     * <li><code>BRL</code> - Brazilian Real</li>
     * <li><code>GBP</code> - British Pound</li>
     * <li><code>BND</code> - Brunei Dollar</li>
     * <li><code>BGL</code> - Bulgarian Hard Lev</li>
     * <li><code>BGN</code> - Bulgarian Lev</li>
     * <li><code>BGO</code> - Bulgarian Lev (1879–1952)</li>
     * <li><code>BGM</code> - Bulgarian Socialist Lev</li>
     * <li><code>BUK</code> - Burmese Kyat</li>
     * <li><code>BIF</code> - Burundian Franc</li>
     * <li><code>XPF</code> - CFP Franc</li>
     * <li><code>KHR</code> - Cambodian Riel</li>
     * <li><code>CAD</code> - Canadian Dollar</li>
     * <li><code>CVE</code> - Cape Verdean Escudo</li>
     * <li><code>KYD</code> - Cayman Islands Dollar</li>
     * <li><code>XAF</code> - Central African CFA Franc</li>
     * <li><code>CLE</code> - Chilean Escudo</li>
     * <li><code>CLP</code> - Chilean Peso</li>
     * <li><code>CLF</code> - Chilean Unit of Account (UF)</li>
     * <li><code>CNX</code> - Chinese People’s Bank Dollar</li>
     * <li><code>CNY</code> - Chinese Yuan</li>
     * <li><code>CNH</code> - Chinese Yuan (offshore)</li>
     * <li><code>COP</code> - Colombian Peso</li>
     * <li><code>COU</code> - Colombian Real Value Unit</li>
     * <li><code>KMF</code> - Comorian Franc</li>
     * <li><code>CDF</code> - Congolese Franc</li>
     * <li><code>CRC</code> - Costa Rican Colón</li>
     * <li><code>HRD</code> - Croatian Dinar</li>
     * <li><code>HRK</code> - Croatian Kuna</li>
     * <li><code>CUC</code> - Cuban Convertible Peso</li>
     * <li><code>CUP</code> - Cuban Peso</li>
     * <li><code>CYP</code> - Cypriot Pound</li>
     * <li><code>CZK</code> - Czech Koruna</li>
     * <li><code>CSK</code> - Czechoslovak Hard Koruna</li>
     * <li><code>DKK</code> - Danish Krone</li>
     * <li><code>DJF</code> - Djiboutian Franc</li>
     * <li><code>DOP</code> - Dominican Peso</li>
     * <li><code>NLG</code> - Dutch Guilder</li>
     * <li><code>XCD</code> - East Caribbean Dollar</li>
     * <li><code>DDM</code> - East German Mark</li>
     * <li><code>ECS</code> - Ecuadorian Sucre</li>
     * <li><code>ECV</code> - Ecuadorian Unit of Constant Value</li>
     * <li><code>EGP</code> - Egyptian Pound</li>
     * <li><code>GQE</code> - Equatorial Guinean Ekwele</li>
     * <li><code>ERN</code> - Eritrean Nakfa</li>
     * <li><code>EEK</code> - Estonian Kroon</li>
     * <li><code>ETB</code> - Ethiopian Birr</li>
     * <li><code>EUR</code> - Euro</li>
     * <li><code>XBA</code> - European Composite Unit</li>
     * <li><code>XEU</code> - European Currency Unit</li>
     * <li><code>XBB</code> - European Monetary Unit</li>
     * <li><code>XBC</code> - European Unit of Account (XBC)</li>
     * <li><code>XBD</code> - European Unit of Account (XBD)</li>
     * <li><code>FKP</code> - Falkland Islands Pound</li>
     * <li><code>FJD</code> - Fijian Dollar</li>
     * <li><code>FIM</code> - Finnish Markka</li>
     * <li><code>FRF</code> - French Franc</li>
     * <li><code>XFO</code> - French Gold Franc</li>
     * <li><code>XFU</code> - French UIC-Franc</li>
     * <li><code>GMD</code> - Gambian Dalasi</li>
     * <li><code>GEK</code> - Georgian Kupon Larit</li>
     * <li><code>GEL</code> - Georgian Lari</li>
     * <li><code>DEM</code> - German Mark</li>
     * <li><code>GHS</code> - Ghanaian Cedi</li>
     * <li><code>GHC</code> - Ghanaian Cedi (1979–2007)</li>
     * <li><code>GIP</code> - Gibraltar Pound</li>
     * <li><code>XAU</code> - Gold</li>
     * <li><code>GRD</code> - Greek Drachma</li>
     * <li><code>GTQ</code> - Guatemalan Quetzal</li>
     * <li><code>GWP</code> - Guinea-Bissau Peso</li>
     * <li><code>GNF</code> - Guinean Franc</li>
     * <li><code>GNS</code> - Guinean Syli</li>
     * <li><code>GYD</code> - Guyanaese Dollar</li>
     * <li><code>HTG</code> - Haitian Gourde</li>
     * <li><code>HNL</code> - Honduran Lempira</li>
     * <li><code>HKD</code> - Hong Kong Dollar</li>
     * <li><code>HUF</code> - Hungarian Forint</li>
     * <li><code>IMP</code> - IMP</li>
     * <li><code>ISK</code> - Icelandic Króna</li>
     * <li><code>ISJ</code> - Icelandic Króna (1918–1981)</li>
     * <li><code>INR</code> - Indian Rupee</li>
     * <li><code>IDR</code> - Indonesian Rupiah</li>
     * <li><code>IRR</code> - Iranian Rial</li>
     * <li><code>IQD</code> - Iraqi Dinar</li>
     * <li><code>IEP</code> - Irish Pound</li>
     * <li><code>ILS</code> - Israeli New Shekel</li>
     * <li><code>ILP</code> - Israeli Pound</li>
     * <li><code>ILR</code> - Israeli Shekel (1980–1985)</li>
     * <li><code>ITL</code> - Italian Lira</li>
     * <li><code>JMD</code> - Jamaican Dollar</li>
     * <li><code>JPY</code> - Japanese Yen</li>
     * <li><code>JOD</code> - Jordanian Dinar</li>
     * <li><code>KZT</code> - Kazakhstani Tenge</li>
     * <li><code>KES</code> - Kenyan Shilling</li>
     * <li><code>KWD</code> - Kuwaiti Dinar</li>
     * <li><code>KGS</code> - Kyrgystani Som</li>
     * <li><code>LAK</code> - Laotian Kip</li>
     * <li><code>LVL</code> - Latvian Lats</li>
     * <li><code>LVR</code> - Latvian Ruble</li>
     * <li><code>LBP</code> - Lebanese Pound</li>
     * <li><code>LSL</code> - Lesotho Loti</li>
     * <li><code>LRD</code> - Liberian Dollar</li>
     * <li><code>LYD</code> - Libyan Dinar</li>
     * <li><code>LTL</code> - Lithuanian Litas</li>
     * <li><code>LTT</code> - Lithuanian Talonas</li>
     * <li><code>LUL</code> - Luxembourg Financial Franc</li>
     * <li><code>LUC</code> - Luxembourgian Convertible Franc</li>
     * <li><code>LUF</code> - Luxembourgian Franc</li>
     * <li><code>MOP</code> - Macanese Pataca</li>
     * <li><code>MKD</code> - Macedonian Denar</li>
     * <li><code>MKN</code> - Macedonian Denar (1992–1993)</li>
     * <li><code>MGA</code> - Malagasy Ariary</li>
     * <li><code>MGF</code> - Malagasy Franc</li>
     * <li><code>MWK</code> - Malawian Kwacha</li>
     * <li><code>MYR</code> - Malaysian Ringgit</li>
     * <li><code>MVR</code> - Maldivian Rufiyaa</li>
     * <li><code>MVP</code> - Maldivian Rupee (1947–1981)</li>
     * <li><code>MLF</code> - Malian Franc</li>
     * <li><code>MTL</code> - Maltese Lira</li>
     * <li><code>MTP</code> - Maltese Pound</li>
     * <li><code>MRU</code> - Mauritanian Ouguiya</li>
     * <li><code>MRO</code> - Mauritanian Ouguiya (1973–2017)</li>
     * <li><code>MUR</code> - Mauritian Rupee</li>
     * <li><code>MXV</code> - Mexican Investment Unit</li>
     * <li><code>MXN</code> - Mexican Peso</li>
     * <li><code>MXP</code> - Mexican Silver Peso (1861–1992)</li>
     * <li><code>MDC</code> - Moldovan Cupon</li>
     * <li><code>MDL</code> - Moldovan Leu</li>
     * <li><code>MCF</code> - Monegasque Franc</li>
     * <li><code>MNT</code> - Mongolian Tugrik</li>
     * <li><code>MAD</code> - Moroccan Dirham</li>
     * <li><code>MAF</code> - Moroccan Franc</li>
     * <li><code>MZE</code> - Mozambican Escudo</li>
     * <li><code>MZN</code> - Mozambican Metical</li>
     * <li><code>MZM</code> - Mozambican Metical (1980–2006)</li>
     * <li><code>MMK</code> - Myanmar Kyat</li>
     * <li><code>NAD</code> - Namibian Dollar</li>
     * <li><code>NPR</code> - Nepalese Rupee</li>
     * <li><code>ANG</code> - Netherlands Antillean Guilder</li>
     * <li><code>TWD</code> - New Taiwan Dollar</li>
     * <li><code>NZD</code> - New Zealand Dollar</li>
     * <li><code>NIO</code> - Nicaraguan Córdoba</li>
     * <li><code>NIC</code> - Nicaraguan Córdoba (1988–1991)</li>
     * <li><code>NGN</code> - Nigerian Naira</li>
     * <li><code>KPW</code> - North Korean Won</li>
     * <li><code>NOK</code> - Norwegian Krone</li>
     * <li><code>OMR</code> - Omani Rial</li>
     * <li><code>PKR</code> - Pakistani Rupee</li>
     * <li><code>XPD</code> - Palladium</li>
     * <li><code>PAB</code> - Panamanian Balboa</li>
     * <li><code>PGK</code> - Papua New Guinean Kina</li>
     * <li><code>PYG</code> - Paraguayan Guarani</li>
     * <li><code>PEI</code> - Peruvian Inti</li>
     * <li><code>PEN</code> - Peruvian Sol</li>
     * <li><code>PES</code> - Peruvian Sol (1863–1965)</li>
     * <li><code>PHP</code> - Philippine Peso</li>
     * <li><code>XPT</code> - Platinum</li>
     * <li><code>PLN</code> - Polish Zloty</li>
     * <li><code>PLZ</code> - Polish Zloty (1950–1995)</li>
     * <li><code>PTE</code> - Portuguese Escudo</li>
     * <li><code>GWE</code> - Portuguese Guinea Escudo</li>
     * <li><code>QAR</code> - Qatari Rial</li>
     * <li><code>XRE</code> - RINET Funds</li>
     * <li><code>RHD</code> - Rhodesian Dollar</li>
     * <li><code>RON</code> - Romanian Leu</li>
     * <li><code>ROL</code> - Romanian Leu (1952–2006)</li>
     * <li><code>RUB</code> - Russian Ruble</li>
     * <li><code>RUR</code> - Russian Ruble (1991–1998)</li>
     * <li><code>RWF</code> - Rwandan Franc</li>
     * <li><code>SVC</code> - Salvadoran Colón</li>
     * <li><code>WST</code> - Samoan Tala</li>
     * <li><code>SAR</code> - Saudi Riyal</li>
     * <li><code>RSD</code> - Serbian Dinar</li>
     * <li><code>CSD</code> - Serbian Dinar (2002–2006)</li>
     * <li><code>SCR</code> - Seychellois Rupee</li>
     * <li><code>SLL</code> - Sierra Leonean Leone</li>
     * <li><code>XAG</code> - Silver</li>
     * <li><code>SGD</code> - Singapore Dollar</li>
     * <li><code>SKK</code> - Slovak Koruna</li>
     * <li><code>SIT</code> - Slovenian Tolar</li>
     * <li><code>SBD</code> - Solomon Islands Dollar</li>
     * <li><code>SOS</code> - Somali Shilling</li>
     * <li><code>ZAR</code> - South African Rand</li>
     * <li><code>ZAL</code> - South African Rand (financial)</li>
     * <li><code>KRH</code> - South Korean Hwan (1953–1962)</li>
     * <li><code>KRW</code> - South Korean Won</li>
     * <li><code>KRO</code> - South Korean Won (1945–1953)</li>
     * <li><code>SSP</code> - South Sudanese Pound</li>
     * <li><code>SUR</code> - Soviet Rouble</li>
     * <li><code>ESP</code> - Spanish Peseta</li>
     * <li><code>ESA</code> - Spanish Peseta (A account)</li>
     * <li><code>ESB</code> - Spanish Peseta (convertible account)</li>
     * <li><code>XDR</code> - Special Drawing Rights</li>
     * <li><code>LKR</code> - Sri Lankan Rupee</li>
     * <li><code>SHP</code> - St. Helena Pound</li>
     * <li><code>XSU</code> - Sucre</li>
     * <li><code>SDD</code> - Sudanese Dinar (1992–2007)</li>
     * <li><code>SDG</code> - Sudanese Pound</li>
     * <li><code>SDP</code> - Sudanese Pound (1957–1998)</li>
     * <li><code>SRD</code> - Surinamese Dollar</li>
     * <li><code>SRG</code> - Surinamese Guilder</li>
     * <li><code>SZL</code> - Swazi Lilangeni</li>
     * <li><code>SEK</code> - Swedish Krona</li>
     * <li><code>CHF</code> - Swiss Franc</li>
     * <li><code>SYP</code> - Syrian Pound</li>
     * <li><code>STN</code> - São Tomé &amp; Príncipe Dobra</li>
     * <li><code>STD</code> - São Tomé &amp; Príncipe Dobra (1977–2017)</li>
     * <li><code>TVD</code> - TVD</li>
     * <li><code>TJR</code> - Tajikistani Ruble</li>
     * <li><code>TJS</code> - Tajikistani Somoni</li>
     * <li><code>TZS</code> - Tanzanian Shilling</li>
     * <li><code>XTS</code> - Testing Currency Code</li>
     * <li><code>THB</code> - Thai Baht</li>
     * <li><code>XXX</code> - The codes assigned for transactions where no currency is involved</li>
     * <li><code>TPE</code> - Timorese Escudo</li>
     * <li><code>TOP</code> - Tongan Paʻanga</li>
     * <li><code>TTD</code> - Trinidad &amp; Tobago Dollar</li>
     * <li><code>TND</code> - Tunisian Dinar</li>
     * <li><code>TRY</code> - Turkish Lira</li>
     * <li><code>TRL</code> - Turkish Lira (1922–2005)</li>
     * <li><code>TMT</code> - Turkmenistani Manat</li>
     * <li><code>TMM</code> - Turkmenistani Manat (1993–2009)</li>
     * <li><code>USD</code> - US Dollar</li>
     * <li><code>USN</code> - US Dollar (Next day)</li>
     * <li><code>USS</code> - US Dollar (Same day)</li>
     * <li><code>UGX</code> - Ugandan Shilling</li>
     * <li><code>UGS</code> - Ugandan Shilling (1966–1987)</li>
     * <li><code>UAH</code> - Ukrainian Hryvnia</li>
     * <li><code>UAK</code> - Ukrainian Karbovanets</li>
     * <li><code>AED</code> - United Arab Emirates Dirham</li>
     * <li><code>UYW</code> - Uruguayan Nominal Wage Index Unit</li>
     * <li><code>UYU</code> - Uruguayan Peso</li>
     * <li><code>UYP</code> - Uruguayan Peso (1975–1993)</li>
     * <li><code>UYI</code> - Uruguayan Peso (Indexed Units)</li>
     * <li><code>UZS</code> - Uzbekistani Som</li>
     * <li><code>VUV</code> - Vanuatu Vatu</li>
     * <li><code>VES</code> - Venezuelan Bolívar</li>
     * <li><code>VEB</code> - Venezuelan Bolívar (1871–2008)</li>
     * <li><code>VEF</code> - Venezuelan Bolívar (2008–2018)</li>
     * <li><code>VND</code> - Vietnamese Dong</li>
     * <li><code>VNN</code> - Vietnamese Dong (1978–1985)</li>
     * <li><code>CHE</code> - WIR Euro</li>
     * <li><code>CHW</code> - WIR Franc</li>
     * <li><code>XOF</code> - West African CFA Franc</li>
     * <li><code>YDD</code> - Yemeni Dinar</li>
     * <li><code>YER</code> - Yemeni Rial</li>
     * <li><code>YUN</code> - Yugoslavian Convertible Dinar (1990–1992)</li>
     * <li><code>YUD</code> - Yugoslavian Hard Dinar (1966–1990)</li>
     * <li><code>YUM</code> - Yugoslavian New Dinar (1994–2002)</li>
     * <li><code>YUR</code> - Yugoslavian Reformed Dinar (1992–1993)</li>
     * <li><code>ZWN</code> - ZWN</li>
     * <li><code>ZRN</code> - Zairean New Zaire (1993–1998)</li>
     * <li><code>ZRZ</code> - Zairean Zaire (1971–1993)</li>
     * <li><code>ZMW</code> - Zambian Kwacha</li>
     * <li><code>ZMK</code> - Zambian Kwacha (1968–2012)</li>
     * <li><code>ZWD</code> - Zimbabwean Dollar (1980–2008)</li>
     * <li><code>ZWR</code> - Zimbabwean Dollar (2008)</li>
     * <li><code>ZWL</code> - Zimbabwean Dollar (2009)</li>
     * </ul>
     */
    @JsonProperty("currency")
    public Optional<VendorCreditCurrency> getCurrency() {
        return currency;
    }

    /**
     * @return The vendor credit's exchange rate.
     */
    @JsonProperty("exchange_rate")
    public Optional<String> getExchangeRate() {
        return exchangeRate;
    }

    /**
     * @return The company the vendor credit belongs to.
     */
    @JsonProperty("company")
    public Optional<VendorCreditCompany> getCompany() {
        return company;
    }

    @JsonProperty("lines")
    public Optional<List<VendorCreditLine>> getLines() {
        return lines;
    }

    @JsonProperty("tracking_categories")
    public Optional<List<Optional<VendorCreditTrackingCategoriesItem>>> getTrackingCategories() {
        return trackingCategories;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    /**
     * @return The accounting period that the VendorCredit was generated in.
     */
    @JsonProperty("accounting_period")
    public Optional<VendorCreditAccountingPeriod> getAccountingPeriod() {
        return accountingPeriod;
    }

    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return This is the datetime that this object was last updated by Merge
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    @JsonProperty("field_mappings")
    public Optional<Map<String, JsonNode>> getFieldMappings() {
        return fieldMappings;
    }

    @JsonProperty("remote_data")
    public Optional<List<RemoteData>> getRemoteData() {
        return remoteData;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof VendorCredit && equalTo((VendorCredit) other);
    }

    private boolean equalTo(VendorCredit other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && number.equals(other.number)
                && transactionDate.equals(other.transactionDate)
                && vendor.equals(other.vendor)
                && totalAmount.equals(other.totalAmount)
                && currency.equals(other.currency)
                && exchangeRate.equals(other.exchangeRate)
                && company.equals(other.company)
                && lines.equals(other.lines)
                && trackingCategories.equals(other.trackingCategories)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && accountingPeriod.equals(other.accountingPeriod)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.number,
                this.transactionDate,
                this.vendor,
                this.totalAmount,
                this.currency,
                this.exchangeRate,
                this.company,
                this.lines,
                this.trackingCategories,
                this.remoteWasDeleted,
                this.accountingPeriod,
                this.createdAt,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> number = Optional.empty();

        private Optional<OffsetDateTime> transactionDate = Optional.empty();

        private Optional<VendorCreditVendor> vendor = Optional.empty();

        private Optional<Double> totalAmount = Optional.empty();

        private Optional<VendorCreditCurrency> currency = Optional.empty();

        private Optional<String> exchangeRate = Optional.empty();

        private Optional<VendorCreditCompany> company = Optional.empty();

        private Optional<List<VendorCreditLine>> lines = Optional.empty();

        private Optional<List<Optional<VendorCreditTrackingCategoriesItem>>> trackingCategories = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<VendorCreditAccountingPeriod> accountingPeriod = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(VendorCredit other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            number(other.getNumber());
            transactionDate(other.getTransactionDate());
            vendor(other.getVendor());
            totalAmount(other.getTotalAmount());
            currency(other.getCurrency());
            exchangeRate(other.getExchangeRate());
            company(other.getCompany());
            lines(other.getLines());
            trackingCategories(other.getTrackingCategories());
            remoteWasDeleted(other.getRemoteWasDeleted());
            accountingPeriod(other.getAccountingPeriod());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            fieldMappings(other.getFieldMappings());
            remoteData(other.getRemoteData());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "remote_id", nulls = Nulls.SKIP)
        public Builder remoteId(Optional<String> remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder remoteId(String remoteId) {
            this.remoteId = Optional.of(remoteId);
            return this;
        }

        @JsonSetter(value = "number", nulls = Nulls.SKIP)
        public Builder number(Optional<String> number) {
            this.number = number;
            return this;
        }

        public Builder number(String number) {
            this.number = Optional.of(number);
            return this;
        }

        @JsonSetter(value = "transaction_date", nulls = Nulls.SKIP)
        public Builder transactionDate(Optional<OffsetDateTime> transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public Builder transactionDate(OffsetDateTime transactionDate) {
            this.transactionDate = Optional.of(transactionDate);
            return this;
        }

        @JsonSetter(value = "vendor", nulls = Nulls.SKIP)
        public Builder vendor(Optional<VendorCreditVendor> vendor) {
            this.vendor = vendor;
            return this;
        }

        public Builder vendor(VendorCreditVendor vendor) {
            this.vendor = Optional.of(vendor);
            return this;
        }

        @JsonSetter(value = "total_amount", nulls = Nulls.SKIP)
        public Builder totalAmount(Optional<Double> totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder totalAmount(Double totalAmount) {
            this.totalAmount = Optional.of(totalAmount);
            return this;
        }

        @JsonSetter(value = "currency", nulls = Nulls.SKIP)
        public Builder currency(Optional<VendorCreditCurrency> currency) {
            this.currency = currency;
            return this;
        }

        public Builder currency(VendorCreditCurrency currency) {
            this.currency = Optional.of(currency);
            return this;
        }

        @JsonSetter(value = "exchange_rate", nulls = Nulls.SKIP)
        public Builder exchangeRate(Optional<String> exchangeRate) {
            this.exchangeRate = exchangeRate;
            return this;
        }

        public Builder exchangeRate(String exchangeRate) {
            this.exchangeRate = Optional.of(exchangeRate);
            return this;
        }

        @JsonSetter(value = "company", nulls = Nulls.SKIP)
        public Builder company(Optional<VendorCreditCompany> company) {
            this.company = company;
            return this;
        }

        public Builder company(VendorCreditCompany company) {
            this.company = Optional.of(company);
            return this;
        }

        @JsonSetter(value = "lines", nulls = Nulls.SKIP)
        public Builder lines(Optional<List<VendorCreditLine>> lines) {
            this.lines = lines;
            return this;
        }

        public Builder lines(List<VendorCreditLine> lines) {
            this.lines = Optional.of(lines);
            return this;
        }

        @JsonSetter(value = "tracking_categories", nulls = Nulls.SKIP)
        public Builder trackingCategories(
                Optional<List<Optional<VendorCreditTrackingCategoriesItem>>> trackingCategories) {
            this.trackingCategories = trackingCategories;
            return this;
        }

        public Builder trackingCategories(List<Optional<VendorCreditTrackingCategoriesItem>> trackingCategories) {
            this.trackingCategories = Optional.of(trackingCategories);
            return this;
        }

        @JsonSetter(value = "remote_was_deleted", nulls = Nulls.SKIP)
        public Builder remoteWasDeleted(Optional<Boolean> remoteWasDeleted) {
            this.remoteWasDeleted = remoteWasDeleted;
            return this;
        }

        public Builder remoteWasDeleted(Boolean remoteWasDeleted) {
            this.remoteWasDeleted = Optional.of(remoteWasDeleted);
            return this;
        }

        @JsonSetter(value = "accounting_period", nulls = Nulls.SKIP)
        public Builder accountingPeriod(Optional<VendorCreditAccountingPeriod> accountingPeriod) {
            this.accountingPeriod = accountingPeriod;
            return this;
        }

        public Builder accountingPeriod(VendorCreditAccountingPeriod accountingPeriod) {
            this.accountingPeriod = Optional.of(accountingPeriod);
            return this;
        }

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.of(createdAt);
            return this;
        }

        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.of(modifiedAt);
            return this;
        }

        @JsonSetter(value = "field_mappings", nulls = Nulls.SKIP)
        public Builder fieldMappings(Optional<Map<String, JsonNode>> fieldMappings) {
            this.fieldMappings = fieldMappings;
            return this;
        }

        public Builder fieldMappings(Map<String, JsonNode> fieldMappings) {
            this.fieldMappings = Optional.of(fieldMappings);
            return this;
        }

        @JsonSetter(value = "remote_data", nulls = Nulls.SKIP)
        public Builder remoteData(Optional<List<RemoteData>> remoteData) {
            this.remoteData = remoteData;
            return this;
        }

        public Builder remoteData(List<RemoteData> remoteData) {
            this.remoteData = Optional.of(remoteData);
            return this;
        }

        public VendorCredit build() {
            return new VendorCredit(
                    id,
                    remoteId,
                    number,
                    transactionDate,
                    vendor,
                    totalAmount,
                    currency,
                    exchangeRate,
                    company,
                    lines,
                    trackingCategories,
                    remoteWasDeleted,
                    accountingPeriod,
                    createdAt,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}
