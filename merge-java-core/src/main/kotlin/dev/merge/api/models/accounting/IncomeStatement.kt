package dev.merge.api.models.accounting

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
 * # The IncomeStatement Object
 *
 * ### Description
 *
 * The `IncomeStatement` object is used to represent a company’s income, the cost of sales,
 * operating expenses, and other non-operating expenses. The object also includes other important
 * values like gross profit, gross operating profit, and net income. This represents a period of
 * time (month, quarter, or year).
 *
 * ### Usage Example
 *
 * Fetch from the `GET IncomeStatement` endpoint and view a company's income statement for a given
 * period.
 */
@JsonDeserialize(builder = IncomeStatement.Builder::class)
@NoAutoDetect
class IncomeStatement
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val name: JsonField<String>,
    private val currency: JsonField<CurrencyEnum>,
    private val company: JsonField<String>,
    private val startPeriod: JsonField<OffsetDateTime>,
    private val endPeriod: JsonField<OffsetDateTime>,
    private val income: JsonField<List<ReportItem>>,
    private val costOfSales: JsonField<List<ReportItem>>,
    private val grossProfit: JsonField<Double>,
    private val operatingExpenses: JsonField<List<ReportItem>>,
    private val netOperatingIncome: JsonField<Double>,
    private val nonOperatingExpenses: JsonField<List<ReportItem>>,
    private val netIncome: JsonField<Double>,
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

    /** The income statement's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /**
     * - `XUA` - ADB Unit of Account
     * - `AFN` - Afghan Afghani
     * - `AFA` - Afghan Afghani (1927–2002)
     * - `ALL` - Albanian Lek
     * - `ALK` - Albanian Lek (1946–1965)
     * - `DZD` - Algerian Dinar
     * - `ADP` - Andorran Peseta
     * - `AOA` - Angolan Kwanza
     * - `AOK` - Angolan Kwanza (1977–1991)
     * - `AON` - Angolan New Kwanza (1990–2000)
     * - `AOR` - Angolan Readjusted Kwanza (1995–1999)
     * - `ARA` - Argentine Austral
     * - `ARS` - Argentine Peso
     * - `ARM` - Argentine Peso (1881–1970)
     * - `ARP` - Argentine Peso (1983–1985)
     * - `ARL` - Argentine Peso Ley (1970–1983)
     * - `AMD` - Armenian Dram
     * - `AWG` - Aruban Florin
     * - `AUD` - Australian Dollar
     * - `ATS` - Austrian Schilling
     * - `AZN` - Azerbaijani Manat
     * - `AZM` - Azerbaijani Manat (1993–2006)
     * - `BSD` - Bahamian Dollar
     * - `BHD` - Bahraini Dinar
     * - `BDT` - Bangladeshi Taka
     * - `BBD` - Barbadian Dollar
     * - `BYN` - Belarusian Ruble
     * - `BYB` - Belarusian Ruble (1994–1999)
     * - `BYR` - Belarusian Ruble (2000–2016)
     * - `BEF` - Belgian Franc
     * - `BEC` - Belgian Franc (convertible)
     * - `BEL` - Belgian Franc (financial)
     * - `BZD` - Belize Dollar
     * - `BMD` - Bermudan Dollar
     * - `BTN` - Bhutanese Ngultrum
     * - `BOB` - Bolivian Boliviano
     * - `BOL` - Bolivian Boliviano (1863–1963)
     * - `BOV` - Bolivian Mvdol
     * - `BOP` - Bolivian Peso
     * - `BAM` - Bosnia-Herzegovina Convertible Mark
     * - `BAD` - Bosnia-Herzegovina Dinar (1992–1994)
     * - `BAN` - Bosnia-Herzegovina New Dinar (1994–1997)
     * - `BWP` - Botswanan Pula
     * - `BRC` - Brazilian Cruzado (1986–1989)
     * - `BRZ` - Brazilian Cruzeiro (1942–1967)
     * - `BRE` - Brazilian Cruzeiro (1990–1993)
     * - `BRR` - Brazilian Cruzeiro (1993–1994)
     * - `BRN` - Brazilian New Cruzado (1989–1990)
     * - `BRB` - Brazilian New Cruzeiro (1967–1986)
     * - `BRL` - Brazilian Real
     * - `GBP` - British Pound
     * - `BND` - Brunei Dollar
     * - `BGL` - Bulgarian Hard Lev
     * - `BGN` - Bulgarian Lev
     * - `BGO` - Bulgarian Lev (1879–1952)
     * - `BGM` - Bulgarian Socialist Lev
     * - `BUK` - Burmese Kyat
     * - `BIF` - Burundian Franc
     * - `XPF` - CFP Franc
     * - `KHR` - Cambodian Riel
     * - `CAD` - Canadian Dollar
     * - `CVE` - Cape Verdean Escudo
     * - `KYD` - Cayman Islands Dollar
     * - `XAF` - Central African CFA Franc
     * - `CLE` - Chilean Escudo
     * - `CLP` - Chilean Peso
     * - `CLF` - Chilean Unit of Account (UF)
     * - `CNX` - Chinese People’s Bank Dollar
     * - `CNY` - Chinese Yuan
     * - `CNH` - Chinese Yuan (offshore)
     * - `COP` - Colombian Peso
     * - `COU` - Colombian Real Value Unit
     * - `KMF` - Comorian Franc
     * - `CDF` - Congolese Franc
     * - `CRC` - Costa Rican Colón
     * - `HRD` - Croatian Dinar
     * - `HRK` - Croatian Kuna
     * - `CUC` - Cuban Convertible Peso
     * - `CUP` - Cuban Peso
     * - `CYP` - Cypriot Pound
     * - `CZK` - Czech Koruna
     * - `CSK` - Czechoslovak Hard Koruna
     * - `DKK` - Danish Krone
     * - `DJF` - Djiboutian Franc
     * - `DOP` - Dominican Peso
     * - `NLG` - Dutch Guilder
     * - `XCD` - East Caribbean Dollar
     * - `DDM` - East German Mark
     * - `ECS` - Ecuadorian Sucre
     * - `ECV` - Ecuadorian Unit of Constant Value
     * - `EGP` - Egyptian Pound
     * - `GQE` - Equatorial Guinean Ekwele
     * - `ERN` - Eritrean Nakfa
     * - `EEK` - Estonian Kroon
     * - `ETB` - Ethiopian Birr
     * - `EUR` - Euro
     * - `XBA` - European Composite Unit
     * - `XEU` - European Currency Unit
     * - `XBB` - European Monetary Unit
     * - `XBC` - European Unit of Account (XBC)
     * - `XBD` - European Unit of Account (XBD)
     * - `FKP` - Falkland Islands Pound
     * - `FJD` - Fijian Dollar
     * - `FIM` - Finnish Markka
     * - `FRF` - French Franc
     * - `XFO` - French Gold Franc
     * - `XFU` - French UIC-Franc
     * - `GMD` - Gambian Dalasi
     * - `GEK` - Georgian Kupon Larit
     * - `GEL` - Georgian Lari
     * - `DEM` - German Mark
     * - `GHS` - Ghanaian Cedi
     * - `GHC` - Ghanaian Cedi (1979–2007)
     * - `GIP` - Gibraltar Pound
     * - `XAU` - Gold
     * - `GRD` - Greek Drachma
     * - `GTQ` - Guatemalan Quetzal
     * - `GWP` - Guinea-Bissau Peso
     * - `GNF` - Guinean Franc
     * - `GNS` - Guinean Syli
     * - `GYD` - Guyanaese Dollar
     * - `HTG` - Haitian Gourde
     * - `HNL` - Honduran Lempira
     * - `HKD` - Hong Kong Dollar
     * - `HUF` - Hungarian Forint
     * - `IMP` - IMP
     * - `ISK` - Icelandic Króna
     * - `ISJ` - Icelandic Króna (1918–1981)
     * - `INR` - Indian Rupee
     * - `IDR` - Indonesian Rupiah
     * - `IRR` - Iranian Rial
     * - `IQD` - Iraqi Dinar
     * - `IEP` - Irish Pound
     * - `ILS` - Israeli New Shekel
     * - `ILP` - Israeli Pound
     * - `ILR` - Israeli Shekel (1980–1985)
     * - `ITL` - Italian Lira
     * - `JMD` - Jamaican Dollar
     * - `JPY` - Japanese Yen
     * - `JOD` - Jordanian Dinar
     * - `KZT` - Kazakhstani Tenge
     * - `KES` - Kenyan Shilling
     * - `KWD` - Kuwaiti Dinar
     * - `KGS` - Kyrgystani Som
     * - `LAK` - Laotian Kip
     * - `LVL` - Latvian Lats
     * - `LVR` - Latvian Ruble
     * - `LBP` - Lebanese Pound
     * - `LSL` - Lesotho Loti
     * - `LRD` - Liberian Dollar
     * - `LYD` - Libyan Dinar
     * - `LTL` - Lithuanian Litas
     * - `LTT` - Lithuanian Talonas
     * - `LUL` - Luxembourg Financial Franc
     * - `LUC` - Luxembourgian Convertible Franc
     * - `LUF` - Luxembourgian Franc
     * - `MOP` - Macanese Pataca
     * - `MKD` - Macedonian Denar
     * - `MKN` - Macedonian Denar (1992–1993)
     * - `MGA` - Malagasy Ariary
     * - `MGF` - Malagasy Franc
     * - `MWK` - Malawian Kwacha
     * - `MYR` - Malaysian Ringgit
     * - `MVR` - Maldivian Rufiyaa
     * - `MVP` - Maldivian Rupee (1947–1981)
     * - `MLF` - Malian Franc
     * - `MTL` - Maltese Lira
     * - `MTP` - Maltese Pound
     * - `MRU` - Mauritanian Ouguiya
     * - `MRO` - Mauritanian Ouguiya (1973–2017)
     * - `MUR` - Mauritian Rupee
     * - `MXV` - Mexican Investment Unit
     * - `MXN` - Mexican Peso
     * - `MXP` - Mexican Silver Peso (1861–1992)
     * - `MDC` - Moldovan Cupon
     * - `MDL` - Moldovan Leu
     * - `MCF` - Monegasque Franc
     * - `MNT` - Mongolian Tugrik
     * - `MAD` - Moroccan Dirham
     * - `MAF` - Moroccan Franc
     * - `MZE` - Mozambican Escudo
     * - `MZN` - Mozambican Metical
     * - `MZM` - Mozambican Metical (1980–2006)
     * - `MMK` - Myanmar Kyat
     * - `NAD` - Namibian Dollar
     * - `NPR` - Nepalese Rupee
     * - `ANG` - Netherlands Antillean Guilder
     * - `TWD` - New Taiwan Dollar
     * - `NZD` - New Zealand Dollar
     * - `NIO` - Nicaraguan Córdoba
     * - `NIC` - Nicaraguan Córdoba (1988–1991)
     * - `NGN` - Nigerian Naira
     * - `KPW` - North Korean Won
     * - `NOK` - Norwegian Krone
     * - `OMR` - Omani Rial
     * - `PKR` - Pakistani Rupee
     * - `XPD` - Palladium
     * - `PAB` - Panamanian Balboa
     * - `PGK` - Papua New Guinean Kina
     * - `PYG` - Paraguayan Guarani
     * - `PEI` - Peruvian Inti
     * - `PEN` - Peruvian Sol
     * - `PES` - Peruvian Sol (1863–1965)
     * - `PHP` - Philippine Peso
     * - `XPT` - Platinum
     * - `PLN` - Polish Zloty
     * - `PLZ` - Polish Zloty (1950–1995)
     * - `PTE` - Portuguese Escudo
     * - `GWE` - Portuguese Guinea Escudo
     * - `QAR` - Qatari Rial
     * - `XRE` - RINET Funds
     * - `RHD` - Rhodesian Dollar
     * - `RON` - Romanian Leu
     * - `ROL` - Romanian Leu (1952–2006)
     * - `RUB` - Russian Ruble
     * - `RUR` - Russian Ruble (1991–1998)
     * - `RWF` - Rwandan Franc
     * - `SVC` - Salvadoran Colón
     * - `WST` - Samoan Tala
     * - `SAR` - Saudi Riyal
     * - `RSD` - Serbian Dinar
     * - `CSD` - Serbian Dinar (2002–2006)
     * - `SCR` - Seychellois Rupee
     * - `SLL` - Sierra Leonean Leone
     * - `XAG` - Silver
     * - `SGD` - Singapore Dollar
     * - `SKK` - Slovak Koruna
     * - `SIT` - Slovenian Tolar
     * - `SBD` - Solomon Islands Dollar
     * - `SOS` - Somali Shilling
     * - `ZAR` - South African Rand
     * - `ZAL` - South African Rand (financial)
     * - `KRH` - South Korean Hwan (1953–1962)
     * - `KRW` - South Korean Won
     * - `KRO` - South Korean Won (1945–1953)
     * - `SSP` - South Sudanese Pound
     * - `SUR` - Soviet Rouble
     * - `ESP` - Spanish Peseta
     * - `ESA` - Spanish Peseta (A account)
     * - `ESB` - Spanish Peseta (convertible account)
     * - `XDR` - Special Drawing Rights
     * - `LKR` - Sri Lankan Rupee
     * - `SHP` - St. Helena Pound
     * - `XSU` - Sucre
     * - `SDD` - Sudanese Dinar (1992–2007)
     * - `SDG` - Sudanese Pound
     * - `SDP` - Sudanese Pound (1957–1998)
     * - `SRD` - Surinamese Dollar
     * - `SRG` - Surinamese Guilder
     * - `SZL` - Swazi Lilangeni
     * - `SEK` - Swedish Krona
     * - `CHF` - Swiss Franc
     * - `SYP` - Syrian Pound
     * - `STN` - São Tomé & Príncipe Dobra
     * - `STD` - São Tomé & Príncipe Dobra (1977–2017)
     * - `TVD` - TVD
     * - `TJR` - Tajikistani Ruble
     * - `TJS` - Tajikistani Somoni
     * - `TZS` - Tanzanian Shilling
     * - `XTS` - Testing Currency Code
     * - `THB` - Thai Baht
     * - `XXX` - The codes assigned for transactions where no currency is involved
     * - `TPE` - Timorese Escudo
     * - `TOP` - Tongan Paʻanga
     * - `TTD` - Trinidad & Tobago Dollar
     * - `TND` - Tunisian Dinar
     * - `TRY` - Turkish Lira
     * - `TRL` - Turkish Lira (1922–2005)
     * - `TMT` - Turkmenistani Manat
     * - `TMM` - Turkmenistani Manat (1993–2009)
     * - `USD` - US Dollar
     * - `USN` - US Dollar (Next day)
     * - `USS` - US Dollar (Same day)
     * - `UGX` - Ugandan Shilling
     * - `UGS` - Ugandan Shilling (1966–1987)
     * - `UAH` - Ukrainian Hryvnia
     * - `UAK` - Ukrainian Karbovanets
     * - `AED` - United Arab Emirates Dirham
     * - `UYW` - Uruguayan Nominal Wage Index Unit
     * - `UYU` - Uruguayan Peso
     * - `UYP` - Uruguayan Peso (1975–1993)
     * - `UYI` - Uruguayan Peso (Indexed Units)
     * - `UZS` - Uzbekistani Som
     * - `VUV` - Vanuatu Vatu
     * - `VES` - Venezuelan Bolívar
     * - `VEB` - Venezuelan Bolívar (1871–2008)
     * - `VEF` - Venezuelan Bolívar (2008–2018)
     * - `VND` - Vietnamese Dong
     * - `VNN` - Vietnamese Dong (1978–1985)
     * - `CHE` - WIR Euro
     * - `CHW` - WIR Franc
     * - `XOF` - West African CFA Franc
     * - `YDD` - Yemeni Dinar
     * - `YER` - Yemeni Rial
     * - `YUN` - Yugoslavian Convertible Dinar (1990–1992)
     * - `YUD` - Yugoslavian Hard Dinar (1966–1990)
     * - `YUM` - Yugoslavian New Dinar (1994–2002)
     * - `YUR` - Yugoslavian Reformed Dinar (1992–1993)
     * - `ZWN` - ZWN
     * - `ZRN` - Zairean New Zaire (1993–1998)
     * - `ZRZ` - Zairean Zaire (1971–1993)
     * - `ZMW` - Zambian Kwacha
     * - `ZMK` - Zambian Kwacha (1968–2012)
     * - `ZWD` - Zimbabwean Dollar (1980–2008)
     * - `ZWR` - Zimbabwean Dollar (2008)
     * - `ZWL` - Zimbabwean Dollar (2009)
     */
    fun currency(): Optional<CurrencyEnum> = Optional.ofNullable(currency.getNullable("currency"))

    /** The company the income statement belongs to. */
    fun company(): Optional<String> = Optional.ofNullable(company.getNullable("company"))

    /** The income statement's start period. */
    fun startPeriod(): Optional<OffsetDateTime> =
        Optional.ofNullable(startPeriod.getNullable("start_period"))

    /** The income statement's end period. */
    fun endPeriod(): Optional<OffsetDateTime> =
        Optional.ofNullable(endPeriod.getNullable("end_period"))

    fun income(): Optional<List<ReportItem>> = Optional.ofNullable(income.getNullable("income"))

    fun costOfSales(): Optional<List<ReportItem>> =
        Optional.ofNullable(costOfSales.getNullable("cost_of_sales"))

    /** The revenue minus the cost of sale. */
    fun grossProfit(): Optional<Double> =
        Optional.ofNullable(grossProfit.getNullable("gross_profit"))

    fun operatingExpenses(): Optional<List<ReportItem>> =
        Optional.ofNullable(operatingExpenses.getNullable("operating_expenses"))

    /** The revenue minus the operating expenses. */
    fun netOperatingIncome(): Optional<Double> =
        Optional.ofNullable(netOperatingIncome.getNullable("net_operating_income"))

    fun nonOperatingExpenses(): Optional<List<ReportItem>> =
        Optional.ofNullable(nonOperatingExpenses.getNullable("non_operating_expenses"))

    /** The gross profit minus the total expenses. */
    fun netIncome(): Optional<Double> = Optional.ofNullable(netIncome.getNullable("net_income"))

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

    /** The income statement's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /**
     * - `XUA` - ADB Unit of Account
     * - `AFN` - Afghan Afghani
     * - `AFA` - Afghan Afghani (1927–2002)
     * - `ALL` - Albanian Lek
     * - `ALK` - Albanian Lek (1946–1965)
     * - `DZD` - Algerian Dinar
     * - `ADP` - Andorran Peseta
     * - `AOA` - Angolan Kwanza
     * - `AOK` - Angolan Kwanza (1977–1991)
     * - `AON` - Angolan New Kwanza (1990–2000)
     * - `AOR` - Angolan Readjusted Kwanza (1995–1999)
     * - `ARA` - Argentine Austral
     * - `ARS` - Argentine Peso
     * - `ARM` - Argentine Peso (1881–1970)
     * - `ARP` - Argentine Peso (1983–1985)
     * - `ARL` - Argentine Peso Ley (1970–1983)
     * - `AMD` - Armenian Dram
     * - `AWG` - Aruban Florin
     * - `AUD` - Australian Dollar
     * - `ATS` - Austrian Schilling
     * - `AZN` - Azerbaijani Manat
     * - `AZM` - Azerbaijani Manat (1993–2006)
     * - `BSD` - Bahamian Dollar
     * - `BHD` - Bahraini Dinar
     * - `BDT` - Bangladeshi Taka
     * - `BBD` - Barbadian Dollar
     * - `BYN` - Belarusian Ruble
     * - `BYB` - Belarusian Ruble (1994–1999)
     * - `BYR` - Belarusian Ruble (2000–2016)
     * - `BEF` - Belgian Franc
     * - `BEC` - Belgian Franc (convertible)
     * - `BEL` - Belgian Franc (financial)
     * - `BZD` - Belize Dollar
     * - `BMD` - Bermudan Dollar
     * - `BTN` - Bhutanese Ngultrum
     * - `BOB` - Bolivian Boliviano
     * - `BOL` - Bolivian Boliviano (1863–1963)
     * - `BOV` - Bolivian Mvdol
     * - `BOP` - Bolivian Peso
     * - `BAM` - Bosnia-Herzegovina Convertible Mark
     * - `BAD` - Bosnia-Herzegovina Dinar (1992–1994)
     * - `BAN` - Bosnia-Herzegovina New Dinar (1994–1997)
     * - `BWP` - Botswanan Pula
     * - `BRC` - Brazilian Cruzado (1986–1989)
     * - `BRZ` - Brazilian Cruzeiro (1942–1967)
     * - `BRE` - Brazilian Cruzeiro (1990–1993)
     * - `BRR` - Brazilian Cruzeiro (1993–1994)
     * - `BRN` - Brazilian New Cruzado (1989–1990)
     * - `BRB` - Brazilian New Cruzeiro (1967–1986)
     * - `BRL` - Brazilian Real
     * - `GBP` - British Pound
     * - `BND` - Brunei Dollar
     * - `BGL` - Bulgarian Hard Lev
     * - `BGN` - Bulgarian Lev
     * - `BGO` - Bulgarian Lev (1879–1952)
     * - `BGM` - Bulgarian Socialist Lev
     * - `BUK` - Burmese Kyat
     * - `BIF` - Burundian Franc
     * - `XPF` - CFP Franc
     * - `KHR` - Cambodian Riel
     * - `CAD` - Canadian Dollar
     * - `CVE` - Cape Verdean Escudo
     * - `KYD` - Cayman Islands Dollar
     * - `XAF` - Central African CFA Franc
     * - `CLE` - Chilean Escudo
     * - `CLP` - Chilean Peso
     * - `CLF` - Chilean Unit of Account (UF)
     * - `CNX` - Chinese People’s Bank Dollar
     * - `CNY` - Chinese Yuan
     * - `CNH` - Chinese Yuan (offshore)
     * - `COP` - Colombian Peso
     * - `COU` - Colombian Real Value Unit
     * - `KMF` - Comorian Franc
     * - `CDF` - Congolese Franc
     * - `CRC` - Costa Rican Colón
     * - `HRD` - Croatian Dinar
     * - `HRK` - Croatian Kuna
     * - `CUC` - Cuban Convertible Peso
     * - `CUP` - Cuban Peso
     * - `CYP` - Cypriot Pound
     * - `CZK` - Czech Koruna
     * - `CSK` - Czechoslovak Hard Koruna
     * - `DKK` - Danish Krone
     * - `DJF` - Djiboutian Franc
     * - `DOP` - Dominican Peso
     * - `NLG` - Dutch Guilder
     * - `XCD` - East Caribbean Dollar
     * - `DDM` - East German Mark
     * - `ECS` - Ecuadorian Sucre
     * - `ECV` - Ecuadorian Unit of Constant Value
     * - `EGP` - Egyptian Pound
     * - `GQE` - Equatorial Guinean Ekwele
     * - `ERN` - Eritrean Nakfa
     * - `EEK` - Estonian Kroon
     * - `ETB` - Ethiopian Birr
     * - `EUR` - Euro
     * - `XBA` - European Composite Unit
     * - `XEU` - European Currency Unit
     * - `XBB` - European Monetary Unit
     * - `XBC` - European Unit of Account (XBC)
     * - `XBD` - European Unit of Account (XBD)
     * - `FKP` - Falkland Islands Pound
     * - `FJD` - Fijian Dollar
     * - `FIM` - Finnish Markka
     * - `FRF` - French Franc
     * - `XFO` - French Gold Franc
     * - `XFU` - French UIC-Franc
     * - `GMD` - Gambian Dalasi
     * - `GEK` - Georgian Kupon Larit
     * - `GEL` - Georgian Lari
     * - `DEM` - German Mark
     * - `GHS` - Ghanaian Cedi
     * - `GHC` - Ghanaian Cedi (1979–2007)
     * - `GIP` - Gibraltar Pound
     * - `XAU` - Gold
     * - `GRD` - Greek Drachma
     * - `GTQ` - Guatemalan Quetzal
     * - `GWP` - Guinea-Bissau Peso
     * - `GNF` - Guinean Franc
     * - `GNS` - Guinean Syli
     * - `GYD` - Guyanaese Dollar
     * - `HTG` - Haitian Gourde
     * - `HNL` - Honduran Lempira
     * - `HKD` - Hong Kong Dollar
     * - `HUF` - Hungarian Forint
     * - `IMP` - IMP
     * - `ISK` - Icelandic Króna
     * - `ISJ` - Icelandic Króna (1918–1981)
     * - `INR` - Indian Rupee
     * - `IDR` - Indonesian Rupiah
     * - `IRR` - Iranian Rial
     * - `IQD` - Iraqi Dinar
     * - `IEP` - Irish Pound
     * - `ILS` - Israeli New Shekel
     * - `ILP` - Israeli Pound
     * - `ILR` - Israeli Shekel (1980–1985)
     * - `ITL` - Italian Lira
     * - `JMD` - Jamaican Dollar
     * - `JPY` - Japanese Yen
     * - `JOD` - Jordanian Dinar
     * - `KZT` - Kazakhstani Tenge
     * - `KES` - Kenyan Shilling
     * - `KWD` - Kuwaiti Dinar
     * - `KGS` - Kyrgystani Som
     * - `LAK` - Laotian Kip
     * - `LVL` - Latvian Lats
     * - `LVR` - Latvian Ruble
     * - `LBP` - Lebanese Pound
     * - `LSL` - Lesotho Loti
     * - `LRD` - Liberian Dollar
     * - `LYD` - Libyan Dinar
     * - `LTL` - Lithuanian Litas
     * - `LTT` - Lithuanian Talonas
     * - `LUL` - Luxembourg Financial Franc
     * - `LUC` - Luxembourgian Convertible Franc
     * - `LUF` - Luxembourgian Franc
     * - `MOP` - Macanese Pataca
     * - `MKD` - Macedonian Denar
     * - `MKN` - Macedonian Denar (1992–1993)
     * - `MGA` - Malagasy Ariary
     * - `MGF` - Malagasy Franc
     * - `MWK` - Malawian Kwacha
     * - `MYR` - Malaysian Ringgit
     * - `MVR` - Maldivian Rufiyaa
     * - `MVP` - Maldivian Rupee (1947–1981)
     * - `MLF` - Malian Franc
     * - `MTL` - Maltese Lira
     * - `MTP` - Maltese Pound
     * - `MRU` - Mauritanian Ouguiya
     * - `MRO` - Mauritanian Ouguiya (1973–2017)
     * - `MUR` - Mauritian Rupee
     * - `MXV` - Mexican Investment Unit
     * - `MXN` - Mexican Peso
     * - `MXP` - Mexican Silver Peso (1861–1992)
     * - `MDC` - Moldovan Cupon
     * - `MDL` - Moldovan Leu
     * - `MCF` - Monegasque Franc
     * - `MNT` - Mongolian Tugrik
     * - `MAD` - Moroccan Dirham
     * - `MAF` - Moroccan Franc
     * - `MZE` - Mozambican Escudo
     * - `MZN` - Mozambican Metical
     * - `MZM` - Mozambican Metical (1980–2006)
     * - `MMK` - Myanmar Kyat
     * - `NAD` - Namibian Dollar
     * - `NPR` - Nepalese Rupee
     * - `ANG` - Netherlands Antillean Guilder
     * - `TWD` - New Taiwan Dollar
     * - `NZD` - New Zealand Dollar
     * - `NIO` - Nicaraguan Córdoba
     * - `NIC` - Nicaraguan Córdoba (1988–1991)
     * - `NGN` - Nigerian Naira
     * - `KPW` - North Korean Won
     * - `NOK` - Norwegian Krone
     * - `OMR` - Omani Rial
     * - `PKR` - Pakistani Rupee
     * - `XPD` - Palladium
     * - `PAB` - Panamanian Balboa
     * - `PGK` - Papua New Guinean Kina
     * - `PYG` - Paraguayan Guarani
     * - `PEI` - Peruvian Inti
     * - `PEN` - Peruvian Sol
     * - `PES` - Peruvian Sol (1863–1965)
     * - `PHP` - Philippine Peso
     * - `XPT` - Platinum
     * - `PLN` - Polish Zloty
     * - `PLZ` - Polish Zloty (1950–1995)
     * - `PTE` - Portuguese Escudo
     * - `GWE` - Portuguese Guinea Escudo
     * - `QAR` - Qatari Rial
     * - `XRE` - RINET Funds
     * - `RHD` - Rhodesian Dollar
     * - `RON` - Romanian Leu
     * - `ROL` - Romanian Leu (1952–2006)
     * - `RUB` - Russian Ruble
     * - `RUR` - Russian Ruble (1991–1998)
     * - `RWF` - Rwandan Franc
     * - `SVC` - Salvadoran Colón
     * - `WST` - Samoan Tala
     * - `SAR` - Saudi Riyal
     * - `RSD` - Serbian Dinar
     * - `CSD` - Serbian Dinar (2002–2006)
     * - `SCR` - Seychellois Rupee
     * - `SLL` - Sierra Leonean Leone
     * - `XAG` - Silver
     * - `SGD` - Singapore Dollar
     * - `SKK` - Slovak Koruna
     * - `SIT` - Slovenian Tolar
     * - `SBD` - Solomon Islands Dollar
     * - `SOS` - Somali Shilling
     * - `ZAR` - South African Rand
     * - `ZAL` - South African Rand (financial)
     * - `KRH` - South Korean Hwan (1953–1962)
     * - `KRW` - South Korean Won
     * - `KRO` - South Korean Won (1945–1953)
     * - `SSP` - South Sudanese Pound
     * - `SUR` - Soviet Rouble
     * - `ESP` - Spanish Peseta
     * - `ESA` - Spanish Peseta (A account)
     * - `ESB` - Spanish Peseta (convertible account)
     * - `XDR` - Special Drawing Rights
     * - `LKR` - Sri Lankan Rupee
     * - `SHP` - St. Helena Pound
     * - `XSU` - Sucre
     * - `SDD` - Sudanese Dinar (1992–2007)
     * - `SDG` - Sudanese Pound
     * - `SDP` - Sudanese Pound (1957–1998)
     * - `SRD` - Surinamese Dollar
     * - `SRG` - Surinamese Guilder
     * - `SZL` - Swazi Lilangeni
     * - `SEK` - Swedish Krona
     * - `CHF` - Swiss Franc
     * - `SYP` - Syrian Pound
     * - `STN` - São Tomé & Príncipe Dobra
     * - `STD` - São Tomé & Príncipe Dobra (1977–2017)
     * - `TVD` - TVD
     * - `TJR` - Tajikistani Ruble
     * - `TJS` - Tajikistani Somoni
     * - `TZS` - Tanzanian Shilling
     * - `XTS` - Testing Currency Code
     * - `THB` - Thai Baht
     * - `XXX` - The codes assigned for transactions where no currency is involved
     * - `TPE` - Timorese Escudo
     * - `TOP` - Tongan Paʻanga
     * - `TTD` - Trinidad & Tobago Dollar
     * - `TND` - Tunisian Dinar
     * - `TRY` - Turkish Lira
     * - `TRL` - Turkish Lira (1922–2005)
     * - `TMT` - Turkmenistani Manat
     * - `TMM` - Turkmenistani Manat (1993–2009)
     * - `USD` - US Dollar
     * - `USN` - US Dollar (Next day)
     * - `USS` - US Dollar (Same day)
     * - `UGX` - Ugandan Shilling
     * - `UGS` - Ugandan Shilling (1966–1987)
     * - `UAH` - Ukrainian Hryvnia
     * - `UAK` - Ukrainian Karbovanets
     * - `AED` - United Arab Emirates Dirham
     * - `UYW` - Uruguayan Nominal Wage Index Unit
     * - `UYU` - Uruguayan Peso
     * - `UYP` - Uruguayan Peso (1975–1993)
     * - `UYI` - Uruguayan Peso (Indexed Units)
     * - `UZS` - Uzbekistani Som
     * - `VUV` - Vanuatu Vatu
     * - `VES` - Venezuelan Bolívar
     * - `VEB` - Venezuelan Bolívar (1871–2008)
     * - `VEF` - Venezuelan Bolívar (2008–2018)
     * - `VND` - Vietnamese Dong
     * - `VNN` - Vietnamese Dong (1978–1985)
     * - `CHE` - WIR Euro
     * - `CHW` - WIR Franc
     * - `XOF` - West African CFA Franc
     * - `YDD` - Yemeni Dinar
     * - `YER` - Yemeni Rial
     * - `YUN` - Yugoslavian Convertible Dinar (1990–1992)
     * - `YUD` - Yugoslavian Hard Dinar (1966–1990)
     * - `YUM` - Yugoslavian New Dinar (1994–2002)
     * - `YUR` - Yugoslavian Reformed Dinar (1992–1993)
     * - `ZWN` - ZWN
     * - `ZRN` - Zairean New Zaire (1993–1998)
     * - `ZRZ` - Zairean Zaire (1971–1993)
     * - `ZMW` - Zambian Kwacha
     * - `ZMK` - Zambian Kwacha (1968–2012)
     * - `ZWD` - Zimbabwean Dollar (1980–2008)
     * - `ZWR` - Zimbabwean Dollar (2008)
     * - `ZWL` - Zimbabwean Dollar (2009)
     */
    @JsonProperty("currency") @ExcludeMissing fun _currency() = currency

    /** The company the income statement belongs to. */
    @JsonProperty("company") @ExcludeMissing fun _company() = company

    /** The income statement's start period. */
    @JsonProperty("start_period") @ExcludeMissing fun _startPeriod() = startPeriod

    /** The income statement's end period. */
    @JsonProperty("end_period") @ExcludeMissing fun _endPeriod() = endPeriod

    @JsonProperty("income") @ExcludeMissing fun _income() = income

    @JsonProperty("cost_of_sales") @ExcludeMissing fun _costOfSales() = costOfSales

    /** The revenue minus the cost of sale. */
    @JsonProperty("gross_profit") @ExcludeMissing fun _grossProfit() = grossProfit

    @JsonProperty("operating_expenses") @ExcludeMissing fun _operatingExpenses() = operatingExpenses

    /** The revenue minus the operating expenses. */
    @JsonProperty("net_operating_income")
    @ExcludeMissing
    fun _netOperatingIncome() = netOperatingIncome

    @JsonProperty("non_operating_expenses")
    @ExcludeMissing
    fun _nonOperatingExpenses() = nonOperatingExpenses

    /** The gross profit minus the total expenses. */
    @JsonProperty("net_income") @ExcludeMissing fun _netIncome() = netIncome

    /** Indicates whether or not this object has been deleted by third party webhooks. */
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
            name()
            currency()
            company()
            startPeriod()
            endPeriod()
            income().map { it.forEach { it.validate() } }
            costOfSales().map { it.forEach { it.validate() } }
            grossProfit()
            operatingExpenses().map { it.forEach { it.validate() } }
            netOperatingIncome()
            nonOperatingExpenses().map { it.forEach { it.validate() } }
            netIncome()
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

        return other is IncomeStatement &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.name == other.name &&
            this.currency == other.currency &&
            this.company == other.company &&
            this.startPeriod == other.startPeriod &&
            this.endPeriod == other.endPeriod &&
            this.income == other.income &&
            this.costOfSales == other.costOfSales &&
            this.grossProfit == other.grossProfit &&
            this.operatingExpenses == other.operatingExpenses &&
            this.netOperatingIncome == other.netOperatingIncome &&
            this.nonOperatingExpenses == other.nonOperatingExpenses &&
            this.netIncome == other.netIncome &&
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
                    currency,
                    company,
                    startPeriod,
                    endPeriod,
                    income,
                    costOfSales,
                    grossProfit,
                    operatingExpenses,
                    netOperatingIncome,
                    nonOperatingExpenses,
                    netIncome,
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
        "IncomeStatement{id=$id, remoteId=$remoteId, name=$name, currency=$currency, company=$company, startPeriod=$startPeriod, endPeriod=$endPeriod, income=$income, costOfSales=$costOfSales, grossProfit=$grossProfit, operatingExpenses=$operatingExpenses, netOperatingIncome=$netOperatingIncome, nonOperatingExpenses=$nonOperatingExpenses, netIncome=$netIncome, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var currency: JsonField<CurrencyEnum> = JsonMissing.of()
        private var company: JsonField<String> = JsonMissing.of()
        private var startPeriod: JsonField<OffsetDateTime> = JsonMissing.of()
        private var endPeriod: JsonField<OffsetDateTime> = JsonMissing.of()
        private var income: JsonField<List<ReportItem>> = JsonMissing.of()
        private var costOfSales: JsonField<List<ReportItem>> = JsonMissing.of()
        private var grossProfit: JsonField<Double> = JsonMissing.of()
        private var operatingExpenses: JsonField<List<ReportItem>> = JsonMissing.of()
        private var netOperatingIncome: JsonField<Double> = JsonMissing.of()
        private var nonOperatingExpenses: JsonField<List<ReportItem>> = JsonMissing.of()
        private var netIncome: JsonField<Double> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(incomeStatement: IncomeStatement) = apply {
            this.id = incomeStatement.id
            this.remoteId = incomeStatement.remoteId
            this.name = incomeStatement.name
            this.currency = incomeStatement.currency
            this.company = incomeStatement.company
            this.startPeriod = incomeStatement.startPeriod
            this.endPeriod = incomeStatement.endPeriod
            this.income = incomeStatement.income
            this.costOfSales = incomeStatement.costOfSales
            this.grossProfit = incomeStatement.grossProfit
            this.operatingExpenses = incomeStatement.operatingExpenses
            this.netOperatingIncome = incomeStatement.netOperatingIncome
            this.nonOperatingExpenses = incomeStatement.nonOperatingExpenses
            this.netIncome = incomeStatement.netIncome
            this.remoteWasDeleted = incomeStatement.remoteWasDeleted
            this.fieldMappings = incomeStatement.fieldMappings
            this.modifiedAt = incomeStatement.modifiedAt
            this.remoteData = incomeStatement.remoteData
            additionalProperties(incomeStatement.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The income statement's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The income statement's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * - `XUA` - ADB Unit of Account
         * - `AFN` - Afghan Afghani
         * - `AFA` - Afghan Afghani (1927–2002)
         * - `ALL` - Albanian Lek
         * - `ALK` - Albanian Lek (1946–1965)
         * - `DZD` - Algerian Dinar
         * - `ADP` - Andorran Peseta
         * - `AOA` - Angolan Kwanza
         * - `AOK` - Angolan Kwanza (1977–1991)
         * - `AON` - Angolan New Kwanza (1990–2000)
         * - `AOR` - Angolan Readjusted Kwanza (1995–1999)
         * - `ARA` - Argentine Austral
         * - `ARS` - Argentine Peso
         * - `ARM` - Argentine Peso (1881–1970)
         * - `ARP` - Argentine Peso (1983–1985)
         * - `ARL` - Argentine Peso Ley (1970–1983)
         * - `AMD` - Armenian Dram
         * - `AWG` - Aruban Florin
         * - `AUD` - Australian Dollar
         * - `ATS` - Austrian Schilling
         * - `AZN` - Azerbaijani Manat
         * - `AZM` - Azerbaijani Manat (1993–2006)
         * - `BSD` - Bahamian Dollar
         * - `BHD` - Bahraini Dinar
         * - `BDT` - Bangladeshi Taka
         * - `BBD` - Barbadian Dollar
         * - `BYN` - Belarusian Ruble
         * - `BYB` - Belarusian Ruble (1994–1999)
         * - `BYR` - Belarusian Ruble (2000–2016)
         * - `BEF` - Belgian Franc
         * - `BEC` - Belgian Franc (convertible)
         * - `BEL` - Belgian Franc (financial)
         * - `BZD` - Belize Dollar
         * - `BMD` - Bermudan Dollar
         * - `BTN` - Bhutanese Ngultrum
         * - `BOB` - Bolivian Boliviano
         * - `BOL` - Bolivian Boliviano (1863–1963)
         * - `BOV` - Bolivian Mvdol
         * - `BOP` - Bolivian Peso
         * - `BAM` - Bosnia-Herzegovina Convertible Mark
         * - `BAD` - Bosnia-Herzegovina Dinar (1992–1994)
         * - `BAN` - Bosnia-Herzegovina New Dinar (1994–1997)
         * - `BWP` - Botswanan Pula
         * - `BRC` - Brazilian Cruzado (1986–1989)
         * - `BRZ` - Brazilian Cruzeiro (1942–1967)
         * - `BRE` - Brazilian Cruzeiro (1990–1993)
         * - `BRR` - Brazilian Cruzeiro (1993–1994)
         * - `BRN` - Brazilian New Cruzado (1989–1990)
         * - `BRB` - Brazilian New Cruzeiro (1967–1986)
         * - `BRL` - Brazilian Real
         * - `GBP` - British Pound
         * - `BND` - Brunei Dollar
         * - `BGL` - Bulgarian Hard Lev
         * - `BGN` - Bulgarian Lev
         * - `BGO` - Bulgarian Lev (1879–1952)
         * - `BGM` - Bulgarian Socialist Lev
         * - `BUK` - Burmese Kyat
         * - `BIF` - Burundian Franc
         * - `XPF` - CFP Franc
         * - `KHR` - Cambodian Riel
         * - `CAD` - Canadian Dollar
         * - `CVE` - Cape Verdean Escudo
         * - `KYD` - Cayman Islands Dollar
         * - `XAF` - Central African CFA Franc
         * - `CLE` - Chilean Escudo
         * - `CLP` - Chilean Peso
         * - `CLF` - Chilean Unit of Account (UF)
         * - `CNX` - Chinese People’s Bank Dollar
         * - `CNY` - Chinese Yuan
         * - `CNH` - Chinese Yuan (offshore)
         * - `COP` - Colombian Peso
         * - `COU` - Colombian Real Value Unit
         * - `KMF` - Comorian Franc
         * - `CDF` - Congolese Franc
         * - `CRC` - Costa Rican Colón
         * - `HRD` - Croatian Dinar
         * - `HRK` - Croatian Kuna
         * - `CUC` - Cuban Convertible Peso
         * - `CUP` - Cuban Peso
         * - `CYP` - Cypriot Pound
         * - `CZK` - Czech Koruna
         * - `CSK` - Czechoslovak Hard Koruna
         * - `DKK` - Danish Krone
         * - `DJF` - Djiboutian Franc
         * - `DOP` - Dominican Peso
         * - `NLG` - Dutch Guilder
         * - `XCD` - East Caribbean Dollar
         * - `DDM` - East German Mark
         * - `ECS` - Ecuadorian Sucre
         * - `ECV` - Ecuadorian Unit of Constant Value
         * - `EGP` - Egyptian Pound
         * - `GQE` - Equatorial Guinean Ekwele
         * - `ERN` - Eritrean Nakfa
         * - `EEK` - Estonian Kroon
         * - `ETB` - Ethiopian Birr
         * - `EUR` - Euro
         * - `XBA` - European Composite Unit
         * - `XEU` - European Currency Unit
         * - `XBB` - European Monetary Unit
         * - `XBC` - European Unit of Account (XBC)
         * - `XBD` - European Unit of Account (XBD)
         * - `FKP` - Falkland Islands Pound
         * - `FJD` - Fijian Dollar
         * - `FIM` - Finnish Markka
         * - `FRF` - French Franc
         * - `XFO` - French Gold Franc
         * - `XFU` - French UIC-Franc
         * - `GMD` - Gambian Dalasi
         * - `GEK` - Georgian Kupon Larit
         * - `GEL` - Georgian Lari
         * - `DEM` - German Mark
         * - `GHS` - Ghanaian Cedi
         * - `GHC` - Ghanaian Cedi (1979–2007)
         * - `GIP` - Gibraltar Pound
         * - `XAU` - Gold
         * - `GRD` - Greek Drachma
         * - `GTQ` - Guatemalan Quetzal
         * - `GWP` - Guinea-Bissau Peso
         * - `GNF` - Guinean Franc
         * - `GNS` - Guinean Syli
         * - `GYD` - Guyanaese Dollar
         * - `HTG` - Haitian Gourde
         * - `HNL` - Honduran Lempira
         * - `HKD` - Hong Kong Dollar
         * - `HUF` - Hungarian Forint
         * - `IMP` - IMP
         * - `ISK` - Icelandic Króna
         * - `ISJ` - Icelandic Króna (1918–1981)
         * - `INR` - Indian Rupee
         * - `IDR` - Indonesian Rupiah
         * - `IRR` - Iranian Rial
         * - `IQD` - Iraqi Dinar
         * - `IEP` - Irish Pound
         * - `ILS` - Israeli New Shekel
         * - `ILP` - Israeli Pound
         * - `ILR` - Israeli Shekel (1980–1985)
         * - `ITL` - Italian Lira
         * - `JMD` - Jamaican Dollar
         * - `JPY` - Japanese Yen
         * - `JOD` - Jordanian Dinar
         * - `KZT` - Kazakhstani Tenge
         * - `KES` - Kenyan Shilling
         * - `KWD` - Kuwaiti Dinar
         * - `KGS` - Kyrgystani Som
         * - `LAK` - Laotian Kip
         * - `LVL` - Latvian Lats
         * - `LVR` - Latvian Ruble
         * - `LBP` - Lebanese Pound
         * - `LSL` - Lesotho Loti
         * - `LRD` - Liberian Dollar
         * - `LYD` - Libyan Dinar
         * - `LTL` - Lithuanian Litas
         * - `LTT` - Lithuanian Talonas
         * - `LUL` - Luxembourg Financial Franc
         * - `LUC` - Luxembourgian Convertible Franc
         * - `LUF` - Luxembourgian Franc
         * - `MOP` - Macanese Pataca
         * - `MKD` - Macedonian Denar
         * - `MKN` - Macedonian Denar (1992–1993)
         * - `MGA` - Malagasy Ariary
         * - `MGF` - Malagasy Franc
         * - `MWK` - Malawian Kwacha
         * - `MYR` - Malaysian Ringgit
         * - `MVR` - Maldivian Rufiyaa
         * - `MVP` - Maldivian Rupee (1947–1981)
         * - `MLF` - Malian Franc
         * - `MTL` - Maltese Lira
         * - `MTP` - Maltese Pound
         * - `MRU` - Mauritanian Ouguiya
         * - `MRO` - Mauritanian Ouguiya (1973–2017)
         * - `MUR` - Mauritian Rupee
         * - `MXV` - Mexican Investment Unit
         * - `MXN` - Mexican Peso
         * - `MXP` - Mexican Silver Peso (1861–1992)
         * - `MDC` - Moldovan Cupon
         * - `MDL` - Moldovan Leu
         * - `MCF` - Monegasque Franc
         * - `MNT` - Mongolian Tugrik
         * - `MAD` - Moroccan Dirham
         * - `MAF` - Moroccan Franc
         * - `MZE` - Mozambican Escudo
         * - `MZN` - Mozambican Metical
         * - `MZM` - Mozambican Metical (1980–2006)
         * - `MMK` - Myanmar Kyat
         * - `NAD` - Namibian Dollar
         * - `NPR` - Nepalese Rupee
         * - `ANG` - Netherlands Antillean Guilder
         * - `TWD` - New Taiwan Dollar
         * - `NZD` - New Zealand Dollar
         * - `NIO` - Nicaraguan Córdoba
         * - `NIC` - Nicaraguan Córdoba (1988–1991)
         * - `NGN` - Nigerian Naira
         * - `KPW` - North Korean Won
         * - `NOK` - Norwegian Krone
         * - `OMR` - Omani Rial
         * - `PKR` - Pakistani Rupee
         * - `XPD` - Palladium
         * - `PAB` - Panamanian Balboa
         * - `PGK` - Papua New Guinean Kina
         * - `PYG` - Paraguayan Guarani
         * - `PEI` - Peruvian Inti
         * - `PEN` - Peruvian Sol
         * - `PES` - Peruvian Sol (1863–1965)
         * - `PHP` - Philippine Peso
         * - `XPT` - Platinum
         * - `PLN` - Polish Zloty
         * - `PLZ` - Polish Zloty (1950–1995)
         * - `PTE` - Portuguese Escudo
         * - `GWE` - Portuguese Guinea Escudo
         * - `QAR` - Qatari Rial
         * - `XRE` - RINET Funds
         * - `RHD` - Rhodesian Dollar
         * - `RON` - Romanian Leu
         * - `ROL` - Romanian Leu (1952–2006)
         * - `RUB` - Russian Ruble
         * - `RUR` - Russian Ruble (1991–1998)
         * - `RWF` - Rwandan Franc
         * - `SVC` - Salvadoran Colón
         * - `WST` - Samoan Tala
         * - `SAR` - Saudi Riyal
         * - `RSD` - Serbian Dinar
         * - `CSD` - Serbian Dinar (2002–2006)
         * - `SCR` - Seychellois Rupee
         * - `SLL` - Sierra Leonean Leone
         * - `XAG` - Silver
         * - `SGD` - Singapore Dollar
         * - `SKK` - Slovak Koruna
         * - `SIT` - Slovenian Tolar
         * - `SBD` - Solomon Islands Dollar
         * - `SOS` - Somali Shilling
         * - `ZAR` - South African Rand
         * - `ZAL` - South African Rand (financial)
         * - `KRH` - South Korean Hwan (1953–1962)
         * - `KRW` - South Korean Won
         * - `KRO` - South Korean Won (1945–1953)
         * - `SSP` - South Sudanese Pound
         * - `SUR` - Soviet Rouble
         * - `ESP` - Spanish Peseta
         * - `ESA` - Spanish Peseta (A account)
         * - `ESB` - Spanish Peseta (convertible account)
         * - `XDR` - Special Drawing Rights
         * - `LKR` - Sri Lankan Rupee
         * - `SHP` - St. Helena Pound
         * - `XSU` - Sucre
         * - `SDD` - Sudanese Dinar (1992–2007)
         * - `SDG` - Sudanese Pound
         * - `SDP` - Sudanese Pound (1957–1998)
         * - `SRD` - Surinamese Dollar
         * - `SRG` - Surinamese Guilder
         * - `SZL` - Swazi Lilangeni
         * - `SEK` - Swedish Krona
         * - `CHF` - Swiss Franc
         * - `SYP` - Syrian Pound
         * - `STN` - São Tomé & Príncipe Dobra
         * - `STD` - São Tomé & Príncipe Dobra (1977–2017)
         * - `TVD` - TVD
         * - `TJR` - Tajikistani Ruble
         * - `TJS` - Tajikistani Somoni
         * - `TZS` - Tanzanian Shilling
         * - `XTS` - Testing Currency Code
         * - `THB` - Thai Baht
         * - `XXX` - The codes assigned for transactions where no currency is involved
         * - `TPE` - Timorese Escudo
         * - `TOP` - Tongan Paʻanga
         * - `TTD` - Trinidad & Tobago Dollar
         * - `TND` - Tunisian Dinar
         * - `TRY` - Turkish Lira
         * - `TRL` - Turkish Lira (1922–2005)
         * - `TMT` - Turkmenistani Manat
         * - `TMM` - Turkmenistani Manat (1993–2009)
         * - `USD` - US Dollar
         * - `USN` - US Dollar (Next day)
         * - `USS` - US Dollar (Same day)
         * - `UGX` - Ugandan Shilling
         * - `UGS` - Ugandan Shilling (1966–1987)
         * - `UAH` - Ukrainian Hryvnia
         * - `UAK` - Ukrainian Karbovanets
         * - `AED` - United Arab Emirates Dirham
         * - `UYW` - Uruguayan Nominal Wage Index Unit
         * - `UYU` - Uruguayan Peso
         * - `UYP` - Uruguayan Peso (1975–1993)
         * - `UYI` - Uruguayan Peso (Indexed Units)
         * - `UZS` - Uzbekistani Som
         * - `VUV` - Vanuatu Vatu
         * - `VES` - Venezuelan Bolívar
         * - `VEB` - Venezuelan Bolívar (1871–2008)
         * - `VEF` - Venezuelan Bolívar (2008–2018)
         * - `VND` - Vietnamese Dong
         * - `VNN` - Vietnamese Dong (1978–1985)
         * - `CHE` - WIR Euro
         * - `CHW` - WIR Franc
         * - `XOF` - West African CFA Franc
         * - `YDD` - Yemeni Dinar
         * - `YER` - Yemeni Rial
         * - `YUN` - Yugoslavian Convertible Dinar (1990–1992)
         * - `YUD` - Yugoslavian Hard Dinar (1966–1990)
         * - `YUM` - Yugoslavian New Dinar (1994–2002)
         * - `YUR` - Yugoslavian Reformed Dinar (1992–1993)
         * - `ZWN` - ZWN
         * - `ZRN` - Zairean New Zaire (1993–1998)
         * - `ZRZ` - Zairean Zaire (1971–1993)
         * - `ZMW` - Zambian Kwacha
         * - `ZMK` - Zambian Kwacha (1968–2012)
         * - `ZWD` - Zimbabwean Dollar (1980–2008)
         * - `ZWR` - Zimbabwean Dollar (2008)
         * - `ZWL` - Zimbabwean Dollar (2009)
         */
        fun currency(currency: CurrencyEnum) = currency(JsonField.of(currency))

        /**
         * - `XUA` - ADB Unit of Account
         * - `AFN` - Afghan Afghani
         * - `AFA` - Afghan Afghani (1927–2002)
         * - `ALL` - Albanian Lek
         * - `ALK` - Albanian Lek (1946–1965)
         * - `DZD` - Algerian Dinar
         * - `ADP` - Andorran Peseta
         * - `AOA` - Angolan Kwanza
         * - `AOK` - Angolan Kwanza (1977–1991)
         * - `AON` - Angolan New Kwanza (1990–2000)
         * - `AOR` - Angolan Readjusted Kwanza (1995–1999)
         * - `ARA` - Argentine Austral
         * - `ARS` - Argentine Peso
         * - `ARM` - Argentine Peso (1881–1970)
         * - `ARP` - Argentine Peso (1983–1985)
         * - `ARL` - Argentine Peso Ley (1970–1983)
         * - `AMD` - Armenian Dram
         * - `AWG` - Aruban Florin
         * - `AUD` - Australian Dollar
         * - `ATS` - Austrian Schilling
         * - `AZN` - Azerbaijani Manat
         * - `AZM` - Azerbaijani Manat (1993–2006)
         * - `BSD` - Bahamian Dollar
         * - `BHD` - Bahraini Dinar
         * - `BDT` - Bangladeshi Taka
         * - `BBD` - Barbadian Dollar
         * - `BYN` - Belarusian Ruble
         * - `BYB` - Belarusian Ruble (1994–1999)
         * - `BYR` - Belarusian Ruble (2000–2016)
         * - `BEF` - Belgian Franc
         * - `BEC` - Belgian Franc (convertible)
         * - `BEL` - Belgian Franc (financial)
         * - `BZD` - Belize Dollar
         * - `BMD` - Bermudan Dollar
         * - `BTN` - Bhutanese Ngultrum
         * - `BOB` - Bolivian Boliviano
         * - `BOL` - Bolivian Boliviano (1863–1963)
         * - `BOV` - Bolivian Mvdol
         * - `BOP` - Bolivian Peso
         * - `BAM` - Bosnia-Herzegovina Convertible Mark
         * - `BAD` - Bosnia-Herzegovina Dinar (1992–1994)
         * - `BAN` - Bosnia-Herzegovina New Dinar (1994–1997)
         * - `BWP` - Botswanan Pula
         * - `BRC` - Brazilian Cruzado (1986–1989)
         * - `BRZ` - Brazilian Cruzeiro (1942–1967)
         * - `BRE` - Brazilian Cruzeiro (1990–1993)
         * - `BRR` - Brazilian Cruzeiro (1993–1994)
         * - `BRN` - Brazilian New Cruzado (1989–1990)
         * - `BRB` - Brazilian New Cruzeiro (1967–1986)
         * - `BRL` - Brazilian Real
         * - `GBP` - British Pound
         * - `BND` - Brunei Dollar
         * - `BGL` - Bulgarian Hard Lev
         * - `BGN` - Bulgarian Lev
         * - `BGO` - Bulgarian Lev (1879–1952)
         * - `BGM` - Bulgarian Socialist Lev
         * - `BUK` - Burmese Kyat
         * - `BIF` - Burundian Franc
         * - `XPF` - CFP Franc
         * - `KHR` - Cambodian Riel
         * - `CAD` - Canadian Dollar
         * - `CVE` - Cape Verdean Escudo
         * - `KYD` - Cayman Islands Dollar
         * - `XAF` - Central African CFA Franc
         * - `CLE` - Chilean Escudo
         * - `CLP` - Chilean Peso
         * - `CLF` - Chilean Unit of Account (UF)
         * - `CNX` - Chinese People’s Bank Dollar
         * - `CNY` - Chinese Yuan
         * - `CNH` - Chinese Yuan (offshore)
         * - `COP` - Colombian Peso
         * - `COU` - Colombian Real Value Unit
         * - `KMF` - Comorian Franc
         * - `CDF` - Congolese Franc
         * - `CRC` - Costa Rican Colón
         * - `HRD` - Croatian Dinar
         * - `HRK` - Croatian Kuna
         * - `CUC` - Cuban Convertible Peso
         * - `CUP` - Cuban Peso
         * - `CYP` - Cypriot Pound
         * - `CZK` - Czech Koruna
         * - `CSK` - Czechoslovak Hard Koruna
         * - `DKK` - Danish Krone
         * - `DJF` - Djiboutian Franc
         * - `DOP` - Dominican Peso
         * - `NLG` - Dutch Guilder
         * - `XCD` - East Caribbean Dollar
         * - `DDM` - East German Mark
         * - `ECS` - Ecuadorian Sucre
         * - `ECV` - Ecuadorian Unit of Constant Value
         * - `EGP` - Egyptian Pound
         * - `GQE` - Equatorial Guinean Ekwele
         * - `ERN` - Eritrean Nakfa
         * - `EEK` - Estonian Kroon
         * - `ETB` - Ethiopian Birr
         * - `EUR` - Euro
         * - `XBA` - European Composite Unit
         * - `XEU` - European Currency Unit
         * - `XBB` - European Monetary Unit
         * - `XBC` - European Unit of Account (XBC)
         * - `XBD` - European Unit of Account (XBD)
         * - `FKP` - Falkland Islands Pound
         * - `FJD` - Fijian Dollar
         * - `FIM` - Finnish Markka
         * - `FRF` - French Franc
         * - `XFO` - French Gold Franc
         * - `XFU` - French UIC-Franc
         * - `GMD` - Gambian Dalasi
         * - `GEK` - Georgian Kupon Larit
         * - `GEL` - Georgian Lari
         * - `DEM` - German Mark
         * - `GHS` - Ghanaian Cedi
         * - `GHC` - Ghanaian Cedi (1979–2007)
         * - `GIP` - Gibraltar Pound
         * - `XAU` - Gold
         * - `GRD` - Greek Drachma
         * - `GTQ` - Guatemalan Quetzal
         * - `GWP` - Guinea-Bissau Peso
         * - `GNF` - Guinean Franc
         * - `GNS` - Guinean Syli
         * - `GYD` - Guyanaese Dollar
         * - `HTG` - Haitian Gourde
         * - `HNL` - Honduran Lempira
         * - `HKD` - Hong Kong Dollar
         * - `HUF` - Hungarian Forint
         * - `IMP` - IMP
         * - `ISK` - Icelandic Króna
         * - `ISJ` - Icelandic Króna (1918–1981)
         * - `INR` - Indian Rupee
         * - `IDR` - Indonesian Rupiah
         * - `IRR` - Iranian Rial
         * - `IQD` - Iraqi Dinar
         * - `IEP` - Irish Pound
         * - `ILS` - Israeli New Shekel
         * - `ILP` - Israeli Pound
         * - `ILR` - Israeli Shekel (1980–1985)
         * - `ITL` - Italian Lira
         * - `JMD` - Jamaican Dollar
         * - `JPY` - Japanese Yen
         * - `JOD` - Jordanian Dinar
         * - `KZT` - Kazakhstani Tenge
         * - `KES` - Kenyan Shilling
         * - `KWD` - Kuwaiti Dinar
         * - `KGS` - Kyrgystani Som
         * - `LAK` - Laotian Kip
         * - `LVL` - Latvian Lats
         * - `LVR` - Latvian Ruble
         * - `LBP` - Lebanese Pound
         * - `LSL` - Lesotho Loti
         * - `LRD` - Liberian Dollar
         * - `LYD` - Libyan Dinar
         * - `LTL` - Lithuanian Litas
         * - `LTT` - Lithuanian Talonas
         * - `LUL` - Luxembourg Financial Franc
         * - `LUC` - Luxembourgian Convertible Franc
         * - `LUF` - Luxembourgian Franc
         * - `MOP` - Macanese Pataca
         * - `MKD` - Macedonian Denar
         * - `MKN` - Macedonian Denar (1992–1993)
         * - `MGA` - Malagasy Ariary
         * - `MGF` - Malagasy Franc
         * - `MWK` - Malawian Kwacha
         * - `MYR` - Malaysian Ringgit
         * - `MVR` - Maldivian Rufiyaa
         * - `MVP` - Maldivian Rupee (1947–1981)
         * - `MLF` - Malian Franc
         * - `MTL` - Maltese Lira
         * - `MTP` - Maltese Pound
         * - `MRU` - Mauritanian Ouguiya
         * - `MRO` - Mauritanian Ouguiya (1973–2017)
         * - `MUR` - Mauritian Rupee
         * - `MXV` - Mexican Investment Unit
         * - `MXN` - Mexican Peso
         * - `MXP` - Mexican Silver Peso (1861–1992)
         * - `MDC` - Moldovan Cupon
         * - `MDL` - Moldovan Leu
         * - `MCF` - Monegasque Franc
         * - `MNT` - Mongolian Tugrik
         * - `MAD` - Moroccan Dirham
         * - `MAF` - Moroccan Franc
         * - `MZE` - Mozambican Escudo
         * - `MZN` - Mozambican Metical
         * - `MZM` - Mozambican Metical (1980–2006)
         * - `MMK` - Myanmar Kyat
         * - `NAD` - Namibian Dollar
         * - `NPR` - Nepalese Rupee
         * - `ANG` - Netherlands Antillean Guilder
         * - `TWD` - New Taiwan Dollar
         * - `NZD` - New Zealand Dollar
         * - `NIO` - Nicaraguan Córdoba
         * - `NIC` - Nicaraguan Córdoba (1988–1991)
         * - `NGN` - Nigerian Naira
         * - `KPW` - North Korean Won
         * - `NOK` - Norwegian Krone
         * - `OMR` - Omani Rial
         * - `PKR` - Pakistani Rupee
         * - `XPD` - Palladium
         * - `PAB` - Panamanian Balboa
         * - `PGK` - Papua New Guinean Kina
         * - `PYG` - Paraguayan Guarani
         * - `PEI` - Peruvian Inti
         * - `PEN` - Peruvian Sol
         * - `PES` - Peruvian Sol (1863–1965)
         * - `PHP` - Philippine Peso
         * - `XPT` - Platinum
         * - `PLN` - Polish Zloty
         * - `PLZ` - Polish Zloty (1950–1995)
         * - `PTE` - Portuguese Escudo
         * - `GWE` - Portuguese Guinea Escudo
         * - `QAR` - Qatari Rial
         * - `XRE` - RINET Funds
         * - `RHD` - Rhodesian Dollar
         * - `RON` - Romanian Leu
         * - `ROL` - Romanian Leu (1952–2006)
         * - `RUB` - Russian Ruble
         * - `RUR` - Russian Ruble (1991–1998)
         * - `RWF` - Rwandan Franc
         * - `SVC` - Salvadoran Colón
         * - `WST` - Samoan Tala
         * - `SAR` - Saudi Riyal
         * - `RSD` - Serbian Dinar
         * - `CSD` - Serbian Dinar (2002–2006)
         * - `SCR` - Seychellois Rupee
         * - `SLL` - Sierra Leonean Leone
         * - `XAG` - Silver
         * - `SGD` - Singapore Dollar
         * - `SKK` - Slovak Koruna
         * - `SIT` - Slovenian Tolar
         * - `SBD` - Solomon Islands Dollar
         * - `SOS` - Somali Shilling
         * - `ZAR` - South African Rand
         * - `ZAL` - South African Rand (financial)
         * - `KRH` - South Korean Hwan (1953–1962)
         * - `KRW` - South Korean Won
         * - `KRO` - South Korean Won (1945–1953)
         * - `SSP` - South Sudanese Pound
         * - `SUR` - Soviet Rouble
         * - `ESP` - Spanish Peseta
         * - `ESA` - Spanish Peseta (A account)
         * - `ESB` - Spanish Peseta (convertible account)
         * - `XDR` - Special Drawing Rights
         * - `LKR` - Sri Lankan Rupee
         * - `SHP` - St. Helena Pound
         * - `XSU` - Sucre
         * - `SDD` - Sudanese Dinar (1992–2007)
         * - `SDG` - Sudanese Pound
         * - `SDP` - Sudanese Pound (1957–1998)
         * - `SRD` - Surinamese Dollar
         * - `SRG` - Surinamese Guilder
         * - `SZL` - Swazi Lilangeni
         * - `SEK` - Swedish Krona
         * - `CHF` - Swiss Franc
         * - `SYP` - Syrian Pound
         * - `STN` - São Tomé & Príncipe Dobra
         * - `STD` - São Tomé & Príncipe Dobra (1977–2017)
         * - `TVD` - TVD
         * - `TJR` - Tajikistani Ruble
         * - `TJS` - Tajikistani Somoni
         * - `TZS` - Tanzanian Shilling
         * - `XTS` - Testing Currency Code
         * - `THB` - Thai Baht
         * - `XXX` - The codes assigned for transactions where no currency is involved
         * - `TPE` - Timorese Escudo
         * - `TOP` - Tongan Paʻanga
         * - `TTD` - Trinidad & Tobago Dollar
         * - `TND` - Tunisian Dinar
         * - `TRY` - Turkish Lira
         * - `TRL` - Turkish Lira (1922–2005)
         * - `TMT` - Turkmenistani Manat
         * - `TMM` - Turkmenistani Manat (1993–2009)
         * - `USD` - US Dollar
         * - `USN` - US Dollar (Next day)
         * - `USS` - US Dollar (Same day)
         * - `UGX` - Ugandan Shilling
         * - `UGS` - Ugandan Shilling (1966–1987)
         * - `UAH` - Ukrainian Hryvnia
         * - `UAK` - Ukrainian Karbovanets
         * - `AED` - United Arab Emirates Dirham
         * - `UYW` - Uruguayan Nominal Wage Index Unit
         * - `UYU` - Uruguayan Peso
         * - `UYP` - Uruguayan Peso (1975–1993)
         * - `UYI` - Uruguayan Peso (Indexed Units)
         * - `UZS` - Uzbekistani Som
         * - `VUV` - Vanuatu Vatu
         * - `VES` - Venezuelan Bolívar
         * - `VEB` - Venezuelan Bolívar (1871–2008)
         * - `VEF` - Venezuelan Bolívar (2008–2018)
         * - `VND` - Vietnamese Dong
         * - `VNN` - Vietnamese Dong (1978–1985)
         * - `CHE` - WIR Euro
         * - `CHW` - WIR Franc
         * - `XOF` - West African CFA Franc
         * - `YDD` - Yemeni Dinar
         * - `YER` - Yemeni Rial
         * - `YUN` - Yugoslavian Convertible Dinar (1990–1992)
         * - `YUD` - Yugoslavian Hard Dinar (1966–1990)
         * - `YUM` - Yugoslavian New Dinar (1994–2002)
         * - `YUR` - Yugoslavian Reformed Dinar (1992–1993)
         * - `ZWN` - ZWN
         * - `ZRN` - Zairean New Zaire (1993–1998)
         * - `ZRZ` - Zairean Zaire (1971–1993)
         * - `ZMW` - Zambian Kwacha
         * - `ZMK` - Zambian Kwacha (1968–2012)
         * - `ZWD` - Zimbabwean Dollar (1980–2008)
         * - `ZWR` - Zimbabwean Dollar (2008)
         * - `ZWL` - Zimbabwean Dollar (2009)
         */
        @JsonProperty("currency")
        @ExcludeMissing
        fun currency(currency: JsonField<CurrencyEnum>) = apply { this.currency = currency }

        /** The company the income statement belongs to. */
        fun company(company: String) = company(JsonField.of(company))

        /** The company the income statement belongs to. */
        @JsonProperty("company")
        @ExcludeMissing
        fun company(company: JsonField<String>) = apply { this.company = company }

        /** The income statement's start period. */
        fun startPeriod(startPeriod: OffsetDateTime) = startPeriod(JsonField.of(startPeriod))

        /** The income statement's start period. */
        @JsonProperty("start_period")
        @ExcludeMissing
        fun startPeriod(startPeriod: JsonField<OffsetDateTime>) = apply {
            this.startPeriod = startPeriod
        }

        /** The income statement's end period. */
        fun endPeriod(endPeriod: OffsetDateTime) = endPeriod(JsonField.of(endPeriod))

        /** The income statement's end period. */
        @JsonProperty("end_period")
        @ExcludeMissing
        fun endPeriod(endPeriod: JsonField<OffsetDateTime>) = apply { this.endPeriod = endPeriod }

        fun income(income: List<ReportItem>) = income(JsonField.of(income))

        @JsonProperty("income")
        @ExcludeMissing
        fun income(income: JsonField<List<ReportItem>>) = apply { this.income = income }

        fun costOfSales(costOfSales: List<ReportItem>) = costOfSales(JsonField.of(costOfSales))

        @JsonProperty("cost_of_sales")
        @ExcludeMissing
        fun costOfSales(costOfSales: JsonField<List<ReportItem>>) = apply {
            this.costOfSales = costOfSales
        }

        /** The revenue minus the cost of sale. */
        fun grossProfit(grossProfit: Double) = grossProfit(JsonField.of(grossProfit))

        /** The revenue minus the cost of sale. */
        @JsonProperty("gross_profit")
        @ExcludeMissing
        fun grossProfit(grossProfit: JsonField<Double>) = apply { this.grossProfit = grossProfit }

        fun operatingExpenses(operatingExpenses: List<ReportItem>) =
            operatingExpenses(JsonField.of(operatingExpenses))

        @JsonProperty("operating_expenses")
        @ExcludeMissing
        fun operatingExpenses(operatingExpenses: JsonField<List<ReportItem>>) = apply {
            this.operatingExpenses = operatingExpenses
        }

        /** The revenue minus the operating expenses. */
        fun netOperatingIncome(netOperatingIncome: Double) =
            netOperatingIncome(JsonField.of(netOperatingIncome))

        /** The revenue minus the operating expenses. */
        @JsonProperty("net_operating_income")
        @ExcludeMissing
        fun netOperatingIncome(netOperatingIncome: JsonField<Double>) = apply {
            this.netOperatingIncome = netOperatingIncome
        }

        fun nonOperatingExpenses(nonOperatingExpenses: List<ReportItem>) =
            nonOperatingExpenses(JsonField.of(nonOperatingExpenses))

        @JsonProperty("non_operating_expenses")
        @ExcludeMissing
        fun nonOperatingExpenses(nonOperatingExpenses: JsonField<List<ReportItem>>) = apply {
            this.nonOperatingExpenses = nonOperatingExpenses
        }

        /** The gross profit minus the total expenses. */
        fun netIncome(netIncome: Double) = netIncome(JsonField.of(netIncome))

        /** The gross profit minus the total expenses. */
        @JsonProperty("net_income")
        @ExcludeMissing
        fun netIncome(netIncome: JsonField<Double>) = apply { this.netIncome = netIncome }

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

        fun build(): IncomeStatement =
            IncomeStatement(
                id,
                remoteId,
                name,
                currency,
                company,
                startPeriod,
                endPeriod,
                income.map { it.toUnmodifiable() },
                costOfSales.map { it.toUnmodifiable() },
                grossProfit,
                operatingExpenses.map { it.toUnmodifiable() },
                netOperatingIncome,
                nonOperatingExpenses.map { it.toUnmodifiable() },
                netIncome,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class CurrencyEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CurrencyEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val XUA = CurrencyEnum(JsonField.of("XUA"))

            @JvmField val AFN = CurrencyEnum(JsonField.of("AFN"))

            @JvmField val AFA = CurrencyEnum(JsonField.of("AFA"))

            @JvmField val ALL = CurrencyEnum(JsonField.of("ALL"))

            @JvmField val ALK = CurrencyEnum(JsonField.of("ALK"))

            @JvmField val DZD = CurrencyEnum(JsonField.of("DZD"))

            @JvmField val ADP = CurrencyEnum(JsonField.of("ADP"))

            @JvmField val AOA = CurrencyEnum(JsonField.of("AOA"))

            @JvmField val AOK = CurrencyEnum(JsonField.of("AOK"))

            @JvmField val AON = CurrencyEnum(JsonField.of("AON"))

            @JvmField val AOR = CurrencyEnum(JsonField.of("AOR"))

            @JvmField val ARA = CurrencyEnum(JsonField.of("ARA"))

            @JvmField val ARS = CurrencyEnum(JsonField.of("ARS"))

            @JvmField val ARM = CurrencyEnum(JsonField.of("ARM"))

            @JvmField val ARP = CurrencyEnum(JsonField.of("ARP"))

            @JvmField val ARL = CurrencyEnum(JsonField.of("ARL"))

            @JvmField val AMD = CurrencyEnum(JsonField.of("AMD"))

            @JvmField val AWG = CurrencyEnum(JsonField.of("AWG"))

            @JvmField val AUD = CurrencyEnum(JsonField.of("AUD"))

            @JvmField val ATS = CurrencyEnum(JsonField.of("ATS"))

            @JvmField val AZN = CurrencyEnum(JsonField.of("AZN"))

            @JvmField val AZM = CurrencyEnum(JsonField.of("AZM"))

            @JvmField val BSD = CurrencyEnum(JsonField.of("BSD"))

            @JvmField val BHD = CurrencyEnum(JsonField.of("BHD"))

            @JvmField val BDT = CurrencyEnum(JsonField.of("BDT"))

            @JvmField val BBD = CurrencyEnum(JsonField.of("BBD"))

            @JvmField val BYN = CurrencyEnum(JsonField.of("BYN"))

            @JvmField val BYB = CurrencyEnum(JsonField.of("BYB"))

            @JvmField val BYR = CurrencyEnum(JsonField.of("BYR"))

            @JvmField val BEF = CurrencyEnum(JsonField.of("BEF"))

            @JvmField val BEC = CurrencyEnum(JsonField.of("BEC"))

            @JvmField val BEL = CurrencyEnum(JsonField.of("BEL"))

            @JvmField val BZD = CurrencyEnum(JsonField.of("BZD"))

            @JvmField val BMD = CurrencyEnum(JsonField.of("BMD"))

            @JvmField val BTN = CurrencyEnum(JsonField.of("BTN"))

            @JvmField val BOB = CurrencyEnum(JsonField.of("BOB"))

            @JvmField val BOL = CurrencyEnum(JsonField.of("BOL"))

            @JvmField val BOV = CurrencyEnum(JsonField.of("BOV"))

            @JvmField val BOP = CurrencyEnum(JsonField.of("BOP"))

            @JvmField val BAM = CurrencyEnum(JsonField.of("BAM"))

            @JvmField val BAD = CurrencyEnum(JsonField.of("BAD"))

            @JvmField val BAN = CurrencyEnum(JsonField.of("BAN"))

            @JvmField val BWP = CurrencyEnum(JsonField.of("BWP"))

            @JvmField val BRC = CurrencyEnum(JsonField.of("BRC"))

            @JvmField val BRZ = CurrencyEnum(JsonField.of("BRZ"))

            @JvmField val BRE = CurrencyEnum(JsonField.of("BRE"))

            @JvmField val BRR = CurrencyEnum(JsonField.of("BRR"))

            @JvmField val BRN = CurrencyEnum(JsonField.of("BRN"))

            @JvmField val BRB = CurrencyEnum(JsonField.of("BRB"))

            @JvmField val BRL = CurrencyEnum(JsonField.of("BRL"))

            @JvmField val GBP = CurrencyEnum(JsonField.of("GBP"))

            @JvmField val BND = CurrencyEnum(JsonField.of("BND"))

            @JvmField val BGL = CurrencyEnum(JsonField.of("BGL"))

            @JvmField val BGN = CurrencyEnum(JsonField.of("BGN"))

            @JvmField val BGO = CurrencyEnum(JsonField.of("BGO"))

            @JvmField val BGM = CurrencyEnum(JsonField.of("BGM"))

            @JvmField val BUK = CurrencyEnum(JsonField.of("BUK"))

            @JvmField val BIF = CurrencyEnum(JsonField.of("BIF"))

            @JvmField val XPF = CurrencyEnum(JsonField.of("XPF"))

            @JvmField val KHR = CurrencyEnum(JsonField.of("KHR"))

            @JvmField val CAD = CurrencyEnum(JsonField.of("CAD"))

            @JvmField val CVE = CurrencyEnum(JsonField.of("CVE"))

            @JvmField val KYD = CurrencyEnum(JsonField.of("KYD"))

            @JvmField val XAF = CurrencyEnum(JsonField.of("XAF"))

            @JvmField val CLE = CurrencyEnum(JsonField.of("CLE"))

            @JvmField val CLP = CurrencyEnum(JsonField.of("CLP"))

            @JvmField val CLF = CurrencyEnum(JsonField.of("CLF"))

            @JvmField val CNX = CurrencyEnum(JsonField.of("CNX"))

            @JvmField val CNY = CurrencyEnum(JsonField.of("CNY"))

            @JvmField val CNH = CurrencyEnum(JsonField.of("CNH"))

            @JvmField val COP = CurrencyEnum(JsonField.of("COP"))

            @JvmField val COU = CurrencyEnum(JsonField.of("COU"))

            @JvmField val KMF = CurrencyEnum(JsonField.of("KMF"))

            @JvmField val CDF = CurrencyEnum(JsonField.of("CDF"))

            @JvmField val CRC = CurrencyEnum(JsonField.of("CRC"))

            @JvmField val HRD = CurrencyEnum(JsonField.of("HRD"))

            @JvmField val HRK = CurrencyEnum(JsonField.of("HRK"))

            @JvmField val CUC = CurrencyEnum(JsonField.of("CUC"))

            @JvmField val CUP = CurrencyEnum(JsonField.of("CUP"))

            @JvmField val CYP = CurrencyEnum(JsonField.of("CYP"))

            @JvmField val CZK = CurrencyEnum(JsonField.of("CZK"))

            @JvmField val CSK = CurrencyEnum(JsonField.of("CSK"))

            @JvmField val DKK = CurrencyEnum(JsonField.of("DKK"))

            @JvmField val DJF = CurrencyEnum(JsonField.of("DJF"))

            @JvmField val DOP = CurrencyEnum(JsonField.of("DOP"))

            @JvmField val NLG = CurrencyEnum(JsonField.of("NLG"))

            @JvmField val XCD = CurrencyEnum(JsonField.of("XCD"))

            @JvmField val DDM = CurrencyEnum(JsonField.of("DDM"))

            @JvmField val ECS = CurrencyEnum(JsonField.of("ECS"))

            @JvmField val ECV = CurrencyEnum(JsonField.of("ECV"))

            @JvmField val EGP = CurrencyEnum(JsonField.of("EGP"))

            @JvmField val GQE = CurrencyEnum(JsonField.of("GQE"))

            @JvmField val ERN = CurrencyEnum(JsonField.of("ERN"))

            @JvmField val EEK = CurrencyEnum(JsonField.of("EEK"))

            @JvmField val ETB = CurrencyEnum(JsonField.of("ETB"))

            @JvmField val EUR = CurrencyEnum(JsonField.of("EUR"))

            @JvmField val XBA = CurrencyEnum(JsonField.of("XBA"))

            @JvmField val XEU = CurrencyEnum(JsonField.of("XEU"))

            @JvmField val XBB = CurrencyEnum(JsonField.of("XBB"))

            @JvmField val XBC = CurrencyEnum(JsonField.of("XBC"))

            @JvmField val XBD = CurrencyEnum(JsonField.of("XBD"))

            @JvmField val FKP = CurrencyEnum(JsonField.of("FKP"))

            @JvmField val FJD = CurrencyEnum(JsonField.of("FJD"))

            @JvmField val FIM = CurrencyEnum(JsonField.of("FIM"))

            @JvmField val FRF = CurrencyEnum(JsonField.of("FRF"))

            @JvmField val XFO = CurrencyEnum(JsonField.of("XFO"))

            @JvmField val XFU = CurrencyEnum(JsonField.of("XFU"))

            @JvmField val GMD = CurrencyEnum(JsonField.of("GMD"))

            @JvmField val GEK = CurrencyEnum(JsonField.of("GEK"))

            @JvmField val GEL = CurrencyEnum(JsonField.of("GEL"))

            @JvmField val DEM = CurrencyEnum(JsonField.of("DEM"))

            @JvmField val GHS = CurrencyEnum(JsonField.of("GHS"))

            @JvmField val GHC = CurrencyEnum(JsonField.of("GHC"))

            @JvmField val GIP = CurrencyEnum(JsonField.of("GIP"))

            @JvmField val XAU = CurrencyEnum(JsonField.of("XAU"))

            @JvmField val GRD = CurrencyEnum(JsonField.of("GRD"))

            @JvmField val GTQ = CurrencyEnum(JsonField.of("GTQ"))

            @JvmField val GWP = CurrencyEnum(JsonField.of("GWP"))

            @JvmField val GNF = CurrencyEnum(JsonField.of("GNF"))

            @JvmField val GNS = CurrencyEnum(JsonField.of("GNS"))

            @JvmField val GYD = CurrencyEnum(JsonField.of("GYD"))

            @JvmField val HTG = CurrencyEnum(JsonField.of("HTG"))

            @JvmField val HNL = CurrencyEnum(JsonField.of("HNL"))

            @JvmField val HKD = CurrencyEnum(JsonField.of("HKD"))

            @JvmField val HUF = CurrencyEnum(JsonField.of("HUF"))

            @JvmField val IMP = CurrencyEnum(JsonField.of("IMP"))

            @JvmField val ISK = CurrencyEnum(JsonField.of("ISK"))

            @JvmField val ISJ = CurrencyEnum(JsonField.of("ISJ"))

            @JvmField val INR = CurrencyEnum(JsonField.of("INR"))

            @JvmField val IDR = CurrencyEnum(JsonField.of("IDR"))

            @JvmField val IRR = CurrencyEnum(JsonField.of("IRR"))

            @JvmField val IQD = CurrencyEnum(JsonField.of("IQD"))

            @JvmField val IEP = CurrencyEnum(JsonField.of("IEP"))

            @JvmField val ILS = CurrencyEnum(JsonField.of("ILS"))

            @JvmField val ILP = CurrencyEnum(JsonField.of("ILP"))

            @JvmField val ILR = CurrencyEnum(JsonField.of("ILR"))

            @JvmField val ITL = CurrencyEnum(JsonField.of("ITL"))

            @JvmField val JMD = CurrencyEnum(JsonField.of("JMD"))

            @JvmField val JPY = CurrencyEnum(JsonField.of("JPY"))

            @JvmField val JOD = CurrencyEnum(JsonField.of("JOD"))

            @JvmField val KZT = CurrencyEnum(JsonField.of("KZT"))

            @JvmField val KES = CurrencyEnum(JsonField.of("KES"))

            @JvmField val KWD = CurrencyEnum(JsonField.of("KWD"))

            @JvmField val KGS = CurrencyEnum(JsonField.of("KGS"))

            @JvmField val LAK = CurrencyEnum(JsonField.of("LAK"))

            @JvmField val LVL = CurrencyEnum(JsonField.of("LVL"))

            @JvmField val LVR = CurrencyEnum(JsonField.of("LVR"))

            @JvmField val LBP = CurrencyEnum(JsonField.of("LBP"))

            @JvmField val LSL = CurrencyEnum(JsonField.of("LSL"))

            @JvmField val LRD = CurrencyEnum(JsonField.of("LRD"))

            @JvmField val LYD = CurrencyEnum(JsonField.of("LYD"))

            @JvmField val LTL = CurrencyEnum(JsonField.of("LTL"))

            @JvmField val LTT = CurrencyEnum(JsonField.of("LTT"))

            @JvmField val LUL = CurrencyEnum(JsonField.of("LUL"))

            @JvmField val LUC = CurrencyEnum(JsonField.of("LUC"))

            @JvmField val LUF = CurrencyEnum(JsonField.of("LUF"))

            @JvmField val MOP = CurrencyEnum(JsonField.of("MOP"))

            @JvmField val MKD = CurrencyEnum(JsonField.of("MKD"))

            @JvmField val MKN = CurrencyEnum(JsonField.of("MKN"))

            @JvmField val MGA = CurrencyEnum(JsonField.of("MGA"))

            @JvmField val MGF = CurrencyEnum(JsonField.of("MGF"))

            @JvmField val MWK = CurrencyEnum(JsonField.of("MWK"))

            @JvmField val MYR = CurrencyEnum(JsonField.of("MYR"))

            @JvmField val MVR = CurrencyEnum(JsonField.of("MVR"))

            @JvmField val MVP = CurrencyEnum(JsonField.of("MVP"))

            @JvmField val MLF = CurrencyEnum(JsonField.of("MLF"))

            @JvmField val MTL = CurrencyEnum(JsonField.of("MTL"))

            @JvmField val MTP = CurrencyEnum(JsonField.of("MTP"))

            @JvmField val MRU = CurrencyEnum(JsonField.of("MRU"))

            @JvmField val MRO = CurrencyEnum(JsonField.of("MRO"))

            @JvmField val MUR = CurrencyEnum(JsonField.of("MUR"))

            @JvmField val MXV = CurrencyEnum(JsonField.of("MXV"))

            @JvmField val MXN = CurrencyEnum(JsonField.of("MXN"))

            @JvmField val MXP = CurrencyEnum(JsonField.of("MXP"))

            @JvmField val MDC = CurrencyEnum(JsonField.of("MDC"))

            @JvmField val MDL = CurrencyEnum(JsonField.of("MDL"))

            @JvmField val MCF = CurrencyEnum(JsonField.of("MCF"))

            @JvmField val MNT = CurrencyEnum(JsonField.of("MNT"))

            @JvmField val MAD = CurrencyEnum(JsonField.of("MAD"))

            @JvmField val MAF = CurrencyEnum(JsonField.of("MAF"))

            @JvmField val MZE = CurrencyEnum(JsonField.of("MZE"))

            @JvmField val MZN = CurrencyEnum(JsonField.of("MZN"))

            @JvmField val MZM = CurrencyEnum(JsonField.of("MZM"))

            @JvmField val MMK = CurrencyEnum(JsonField.of("MMK"))

            @JvmField val NAD = CurrencyEnum(JsonField.of("NAD"))

            @JvmField val NPR = CurrencyEnum(JsonField.of("NPR"))

            @JvmField val ANG = CurrencyEnum(JsonField.of("ANG"))

            @JvmField val TWD = CurrencyEnum(JsonField.of("TWD"))

            @JvmField val NZD = CurrencyEnum(JsonField.of("NZD"))

            @JvmField val NIO = CurrencyEnum(JsonField.of("NIO"))

            @JvmField val NIC = CurrencyEnum(JsonField.of("NIC"))

            @JvmField val NGN = CurrencyEnum(JsonField.of("NGN"))

            @JvmField val KPW = CurrencyEnum(JsonField.of("KPW"))

            @JvmField val NOK = CurrencyEnum(JsonField.of("NOK"))

            @JvmField val OMR = CurrencyEnum(JsonField.of("OMR"))

            @JvmField val PKR = CurrencyEnum(JsonField.of("PKR"))

            @JvmField val XPD = CurrencyEnum(JsonField.of("XPD"))

            @JvmField val PAB = CurrencyEnum(JsonField.of("PAB"))

            @JvmField val PGK = CurrencyEnum(JsonField.of("PGK"))

            @JvmField val PYG = CurrencyEnum(JsonField.of("PYG"))

            @JvmField val PEI = CurrencyEnum(JsonField.of("PEI"))

            @JvmField val PEN = CurrencyEnum(JsonField.of("PEN"))

            @JvmField val PES = CurrencyEnum(JsonField.of("PES"))

            @JvmField val PHP = CurrencyEnum(JsonField.of("PHP"))

            @JvmField val XPT = CurrencyEnum(JsonField.of("XPT"))

            @JvmField val PLN = CurrencyEnum(JsonField.of("PLN"))

            @JvmField val PLZ = CurrencyEnum(JsonField.of("PLZ"))

            @JvmField val PTE = CurrencyEnum(JsonField.of("PTE"))

            @JvmField val GWE = CurrencyEnum(JsonField.of("GWE"))

            @JvmField val QAR = CurrencyEnum(JsonField.of("QAR"))

            @JvmField val XRE = CurrencyEnum(JsonField.of("XRE"))

            @JvmField val RHD = CurrencyEnum(JsonField.of("RHD"))

            @JvmField val RON = CurrencyEnum(JsonField.of("RON"))

            @JvmField val ROL = CurrencyEnum(JsonField.of("ROL"))

            @JvmField val RUB = CurrencyEnum(JsonField.of("RUB"))

            @JvmField val RUR = CurrencyEnum(JsonField.of("RUR"))

            @JvmField val RWF = CurrencyEnum(JsonField.of("RWF"))

            @JvmField val SVC = CurrencyEnum(JsonField.of("SVC"))

            @JvmField val WST = CurrencyEnum(JsonField.of("WST"))

            @JvmField val SAR = CurrencyEnum(JsonField.of("SAR"))

            @JvmField val RSD = CurrencyEnum(JsonField.of("RSD"))

            @JvmField val CSD = CurrencyEnum(JsonField.of("CSD"))

            @JvmField val SCR = CurrencyEnum(JsonField.of("SCR"))

            @JvmField val SLL = CurrencyEnum(JsonField.of("SLL"))

            @JvmField val XAG = CurrencyEnum(JsonField.of("XAG"))

            @JvmField val SGD = CurrencyEnum(JsonField.of("SGD"))

            @JvmField val SKK = CurrencyEnum(JsonField.of("SKK"))

            @JvmField val SIT = CurrencyEnum(JsonField.of("SIT"))

            @JvmField val SBD = CurrencyEnum(JsonField.of("SBD"))

            @JvmField val SOS = CurrencyEnum(JsonField.of("SOS"))

            @JvmField val ZAR = CurrencyEnum(JsonField.of("ZAR"))

            @JvmField val ZAL = CurrencyEnum(JsonField.of("ZAL"))

            @JvmField val KRH = CurrencyEnum(JsonField.of("KRH"))

            @JvmField val KRW = CurrencyEnum(JsonField.of("KRW"))

            @JvmField val KRO = CurrencyEnum(JsonField.of("KRO"))

            @JvmField val SSP = CurrencyEnum(JsonField.of("SSP"))

            @JvmField val SUR = CurrencyEnum(JsonField.of("SUR"))

            @JvmField val ESP = CurrencyEnum(JsonField.of("ESP"))

            @JvmField val ESA = CurrencyEnum(JsonField.of("ESA"))

            @JvmField val ESB = CurrencyEnum(JsonField.of("ESB"))

            @JvmField val XDR = CurrencyEnum(JsonField.of("XDR"))

            @JvmField val LKR = CurrencyEnum(JsonField.of("LKR"))

            @JvmField val SHP = CurrencyEnum(JsonField.of("SHP"))

            @JvmField val XSU = CurrencyEnum(JsonField.of("XSU"))

            @JvmField val SDD = CurrencyEnum(JsonField.of("SDD"))

            @JvmField val SDG = CurrencyEnum(JsonField.of("SDG"))

            @JvmField val SDP = CurrencyEnum(JsonField.of("SDP"))

            @JvmField val SRD = CurrencyEnum(JsonField.of("SRD"))

            @JvmField val SRG = CurrencyEnum(JsonField.of("SRG"))

            @JvmField val SZL = CurrencyEnum(JsonField.of("SZL"))

            @JvmField val SEK = CurrencyEnum(JsonField.of("SEK"))

            @JvmField val CHF = CurrencyEnum(JsonField.of("CHF"))

            @JvmField val SYP = CurrencyEnum(JsonField.of("SYP"))

            @JvmField val STN = CurrencyEnum(JsonField.of("STN"))

            @JvmField val STD = CurrencyEnum(JsonField.of("STD"))

            @JvmField val TVD = CurrencyEnum(JsonField.of("TVD"))

            @JvmField val TJR = CurrencyEnum(JsonField.of("TJR"))

            @JvmField val TJS = CurrencyEnum(JsonField.of("TJS"))

            @JvmField val TZS = CurrencyEnum(JsonField.of("TZS"))

            @JvmField val XTS = CurrencyEnum(JsonField.of("XTS"))

            @JvmField val THB = CurrencyEnum(JsonField.of("THB"))

            @JvmField val XXX = CurrencyEnum(JsonField.of("XXX"))

            @JvmField val TPE = CurrencyEnum(JsonField.of("TPE"))

            @JvmField val TOP = CurrencyEnum(JsonField.of("TOP"))

            @JvmField val TTD = CurrencyEnum(JsonField.of("TTD"))

            @JvmField val TND = CurrencyEnum(JsonField.of("TND"))

            @JvmField val TRY = CurrencyEnum(JsonField.of("TRY"))

            @JvmField val TRL = CurrencyEnum(JsonField.of("TRL"))

            @JvmField val TMT = CurrencyEnum(JsonField.of("TMT"))

            @JvmField val TMM = CurrencyEnum(JsonField.of("TMM"))

            @JvmField val USD = CurrencyEnum(JsonField.of("USD"))

            @JvmField val USN = CurrencyEnum(JsonField.of("USN"))

            @JvmField val USS = CurrencyEnum(JsonField.of("USS"))

            @JvmField val UGX = CurrencyEnum(JsonField.of("UGX"))

            @JvmField val UGS = CurrencyEnum(JsonField.of("UGS"))

            @JvmField val UAH = CurrencyEnum(JsonField.of("UAH"))

            @JvmField val UAK = CurrencyEnum(JsonField.of("UAK"))

            @JvmField val AED = CurrencyEnum(JsonField.of("AED"))

            @JvmField val UYW = CurrencyEnum(JsonField.of("UYW"))

            @JvmField val UYU = CurrencyEnum(JsonField.of("UYU"))

            @JvmField val UYP = CurrencyEnum(JsonField.of("UYP"))

            @JvmField val UYI = CurrencyEnum(JsonField.of("UYI"))

            @JvmField val UZS = CurrencyEnum(JsonField.of("UZS"))

            @JvmField val VUV = CurrencyEnum(JsonField.of("VUV"))

            @JvmField val VES = CurrencyEnum(JsonField.of("VES"))

            @JvmField val VEB = CurrencyEnum(JsonField.of("VEB"))

            @JvmField val VEF = CurrencyEnum(JsonField.of("VEF"))

            @JvmField val VND = CurrencyEnum(JsonField.of("VND"))

            @JvmField val VNN = CurrencyEnum(JsonField.of("VNN"))

            @JvmField val CHE = CurrencyEnum(JsonField.of("CHE"))

            @JvmField val CHW = CurrencyEnum(JsonField.of("CHW"))

            @JvmField val XOF = CurrencyEnum(JsonField.of("XOF"))

            @JvmField val YDD = CurrencyEnum(JsonField.of("YDD"))

            @JvmField val YER = CurrencyEnum(JsonField.of("YER"))

            @JvmField val YUN = CurrencyEnum(JsonField.of("YUN"))

            @JvmField val YUD = CurrencyEnum(JsonField.of("YUD"))

            @JvmField val YUM = CurrencyEnum(JsonField.of("YUM"))

            @JvmField val YUR = CurrencyEnum(JsonField.of("YUR"))

            @JvmField val ZWN = CurrencyEnum(JsonField.of("ZWN"))

            @JvmField val ZRN = CurrencyEnum(JsonField.of("ZRN"))

            @JvmField val ZRZ = CurrencyEnum(JsonField.of("ZRZ"))

            @JvmField val ZMW = CurrencyEnum(JsonField.of("ZMW"))

            @JvmField val ZMK = CurrencyEnum(JsonField.of("ZMK"))

            @JvmField val ZWD = CurrencyEnum(JsonField.of("ZWD"))

            @JvmField val ZWR = CurrencyEnum(JsonField.of("ZWR"))

            @JvmField val ZWL = CurrencyEnum(JsonField.of("ZWL"))

            @JvmStatic fun of(value: String) = CurrencyEnum(JsonField.of(value))
        }

        enum class Known {
            XUA,
            AFN,
            AFA,
            ALL,
            ALK,
            DZD,
            ADP,
            AOA,
            AOK,
            AON,
            AOR,
            ARA,
            ARS,
            ARM,
            ARP,
            ARL,
            AMD,
            AWG,
            AUD,
            ATS,
            AZN,
            AZM,
            BSD,
            BHD,
            BDT,
            BBD,
            BYN,
            BYB,
            BYR,
            BEF,
            BEC,
            BEL,
            BZD,
            BMD,
            BTN,
            BOB,
            BOL,
            BOV,
            BOP,
            BAM,
            BAD,
            BAN,
            BWP,
            BRC,
            BRZ,
            BRE,
            BRR,
            BRN,
            BRB,
            BRL,
            GBP,
            BND,
            BGL,
            BGN,
            BGO,
            BGM,
            BUK,
            BIF,
            XPF,
            KHR,
            CAD,
            CVE,
            KYD,
            XAF,
            CLE,
            CLP,
            CLF,
            CNX,
            CNY,
            CNH,
            COP,
            COU,
            KMF,
            CDF,
            CRC,
            HRD,
            HRK,
            CUC,
            CUP,
            CYP,
            CZK,
            CSK,
            DKK,
            DJF,
            DOP,
            NLG,
            XCD,
            DDM,
            ECS,
            ECV,
            EGP,
            GQE,
            ERN,
            EEK,
            ETB,
            EUR,
            XBA,
            XEU,
            XBB,
            XBC,
            XBD,
            FKP,
            FJD,
            FIM,
            FRF,
            XFO,
            XFU,
            GMD,
            GEK,
            GEL,
            DEM,
            GHS,
            GHC,
            GIP,
            XAU,
            GRD,
            GTQ,
            GWP,
            GNF,
            GNS,
            GYD,
            HTG,
            HNL,
            HKD,
            HUF,
            IMP,
            ISK,
            ISJ,
            INR,
            IDR,
            IRR,
            IQD,
            IEP,
            ILS,
            ILP,
            ILR,
            ITL,
            JMD,
            JPY,
            JOD,
            KZT,
            KES,
            KWD,
            KGS,
            LAK,
            LVL,
            LVR,
            LBP,
            LSL,
            LRD,
            LYD,
            LTL,
            LTT,
            LUL,
            LUC,
            LUF,
            MOP,
            MKD,
            MKN,
            MGA,
            MGF,
            MWK,
            MYR,
            MVR,
            MVP,
            MLF,
            MTL,
            MTP,
            MRU,
            MRO,
            MUR,
            MXV,
            MXN,
            MXP,
            MDC,
            MDL,
            MCF,
            MNT,
            MAD,
            MAF,
            MZE,
            MZN,
            MZM,
            MMK,
            NAD,
            NPR,
            ANG,
            TWD,
            NZD,
            NIO,
            NIC,
            NGN,
            KPW,
            NOK,
            OMR,
            PKR,
            XPD,
            PAB,
            PGK,
            PYG,
            PEI,
            PEN,
            PES,
            PHP,
            XPT,
            PLN,
            PLZ,
            PTE,
            GWE,
            QAR,
            XRE,
            RHD,
            RON,
            ROL,
            RUB,
            RUR,
            RWF,
            SVC,
            WST,
            SAR,
            RSD,
            CSD,
            SCR,
            SLL,
            XAG,
            SGD,
            SKK,
            SIT,
            SBD,
            SOS,
            ZAR,
            ZAL,
            KRH,
            KRW,
            KRO,
            SSP,
            SUR,
            ESP,
            ESA,
            ESB,
            XDR,
            LKR,
            SHP,
            XSU,
            SDD,
            SDG,
            SDP,
            SRD,
            SRG,
            SZL,
            SEK,
            CHF,
            SYP,
            STN,
            STD,
            TVD,
            TJR,
            TJS,
            TZS,
            XTS,
            THB,
            XXX,
            TPE,
            TOP,
            TTD,
            TND,
            TRY,
            TRL,
            TMT,
            TMM,
            USD,
            USN,
            USS,
            UGX,
            UGS,
            UAH,
            UAK,
            AED,
            UYW,
            UYU,
            UYP,
            UYI,
            UZS,
            VUV,
            VES,
            VEB,
            VEF,
            VND,
            VNN,
            CHE,
            CHW,
            XOF,
            YDD,
            YER,
            YUN,
            YUD,
            YUM,
            YUR,
            ZWN,
            ZRN,
            ZRZ,
            ZMW,
            ZMK,
            ZWD,
            ZWR,
            ZWL,
        }

        enum class Value {
            XUA,
            AFN,
            AFA,
            ALL,
            ALK,
            DZD,
            ADP,
            AOA,
            AOK,
            AON,
            AOR,
            ARA,
            ARS,
            ARM,
            ARP,
            ARL,
            AMD,
            AWG,
            AUD,
            ATS,
            AZN,
            AZM,
            BSD,
            BHD,
            BDT,
            BBD,
            BYN,
            BYB,
            BYR,
            BEF,
            BEC,
            BEL,
            BZD,
            BMD,
            BTN,
            BOB,
            BOL,
            BOV,
            BOP,
            BAM,
            BAD,
            BAN,
            BWP,
            BRC,
            BRZ,
            BRE,
            BRR,
            BRN,
            BRB,
            BRL,
            GBP,
            BND,
            BGL,
            BGN,
            BGO,
            BGM,
            BUK,
            BIF,
            XPF,
            KHR,
            CAD,
            CVE,
            KYD,
            XAF,
            CLE,
            CLP,
            CLF,
            CNX,
            CNY,
            CNH,
            COP,
            COU,
            KMF,
            CDF,
            CRC,
            HRD,
            HRK,
            CUC,
            CUP,
            CYP,
            CZK,
            CSK,
            DKK,
            DJF,
            DOP,
            NLG,
            XCD,
            DDM,
            ECS,
            ECV,
            EGP,
            GQE,
            ERN,
            EEK,
            ETB,
            EUR,
            XBA,
            XEU,
            XBB,
            XBC,
            XBD,
            FKP,
            FJD,
            FIM,
            FRF,
            XFO,
            XFU,
            GMD,
            GEK,
            GEL,
            DEM,
            GHS,
            GHC,
            GIP,
            XAU,
            GRD,
            GTQ,
            GWP,
            GNF,
            GNS,
            GYD,
            HTG,
            HNL,
            HKD,
            HUF,
            IMP,
            ISK,
            ISJ,
            INR,
            IDR,
            IRR,
            IQD,
            IEP,
            ILS,
            ILP,
            ILR,
            ITL,
            JMD,
            JPY,
            JOD,
            KZT,
            KES,
            KWD,
            KGS,
            LAK,
            LVL,
            LVR,
            LBP,
            LSL,
            LRD,
            LYD,
            LTL,
            LTT,
            LUL,
            LUC,
            LUF,
            MOP,
            MKD,
            MKN,
            MGA,
            MGF,
            MWK,
            MYR,
            MVR,
            MVP,
            MLF,
            MTL,
            MTP,
            MRU,
            MRO,
            MUR,
            MXV,
            MXN,
            MXP,
            MDC,
            MDL,
            MCF,
            MNT,
            MAD,
            MAF,
            MZE,
            MZN,
            MZM,
            MMK,
            NAD,
            NPR,
            ANG,
            TWD,
            NZD,
            NIO,
            NIC,
            NGN,
            KPW,
            NOK,
            OMR,
            PKR,
            XPD,
            PAB,
            PGK,
            PYG,
            PEI,
            PEN,
            PES,
            PHP,
            XPT,
            PLN,
            PLZ,
            PTE,
            GWE,
            QAR,
            XRE,
            RHD,
            RON,
            ROL,
            RUB,
            RUR,
            RWF,
            SVC,
            WST,
            SAR,
            RSD,
            CSD,
            SCR,
            SLL,
            XAG,
            SGD,
            SKK,
            SIT,
            SBD,
            SOS,
            ZAR,
            ZAL,
            KRH,
            KRW,
            KRO,
            SSP,
            SUR,
            ESP,
            ESA,
            ESB,
            XDR,
            LKR,
            SHP,
            XSU,
            SDD,
            SDG,
            SDP,
            SRD,
            SRG,
            SZL,
            SEK,
            CHF,
            SYP,
            STN,
            STD,
            TVD,
            TJR,
            TJS,
            TZS,
            XTS,
            THB,
            XXX,
            TPE,
            TOP,
            TTD,
            TND,
            TRY,
            TRL,
            TMT,
            TMM,
            USD,
            USN,
            USS,
            UGX,
            UGS,
            UAH,
            UAK,
            AED,
            UYW,
            UYU,
            UYP,
            UYI,
            UZS,
            VUV,
            VES,
            VEB,
            VEF,
            VND,
            VNN,
            CHE,
            CHW,
            XOF,
            YDD,
            YER,
            YUN,
            YUD,
            YUM,
            YUR,
            ZWN,
            ZRN,
            ZRZ,
            ZMW,
            ZMK,
            ZWD,
            ZWR,
            ZWL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                XUA -> Value.XUA
                AFN -> Value.AFN
                AFA -> Value.AFA
                ALL -> Value.ALL
                ALK -> Value.ALK
                DZD -> Value.DZD
                ADP -> Value.ADP
                AOA -> Value.AOA
                AOK -> Value.AOK
                AON -> Value.AON
                AOR -> Value.AOR
                ARA -> Value.ARA
                ARS -> Value.ARS
                ARM -> Value.ARM
                ARP -> Value.ARP
                ARL -> Value.ARL
                AMD -> Value.AMD
                AWG -> Value.AWG
                AUD -> Value.AUD
                ATS -> Value.ATS
                AZN -> Value.AZN
                AZM -> Value.AZM
                BSD -> Value.BSD
                BHD -> Value.BHD
                BDT -> Value.BDT
                BBD -> Value.BBD
                BYN -> Value.BYN
                BYB -> Value.BYB
                BYR -> Value.BYR
                BEF -> Value.BEF
                BEC -> Value.BEC
                BEL -> Value.BEL
                BZD -> Value.BZD
                BMD -> Value.BMD
                BTN -> Value.BTN
                BOB -> Value.BOB
                BOL -> Value.BOL
                BOV -> Value.BOV
                BOP -> Value.BOP
                BAM -> Value.BAM
                BAD -> Value.BAD
                BAN -> Value.BAN
                BWP -> Value.BWP
                BRC -> Value.BRC
                BRZ -> Value.BRZ
                BRE -> Value.BRE
                BRR -> Value.BRR
                BRN -> Value.BRN
                BRB -> Value.BRB
                BRL -> Value.BRL
                GBP -> Value.GBP
                BND -> Value.BND
                BGL -> Value.BGL
                BGN -> Value.BGN
                BGO -> Value.BGO
                BGM -> Value.BGM
                BUK -> Value.BUK
                BIF -> Value.BIF
                XPF -> Value.XPF
                KHR -> Value.KHR
                CAD -> Value.CAD
                CVE -> Value.CVE
                KYD -> Value.KYD
                XAF -> Value.XAF
                CLE -> Value.CLE
                CLP -> Value.CLP
                CLF -> Value.CLF
                CNX -> Value.CNX
                CNY -> Value.CNY
                CNH -> Value.CNH
                COP -> Value.COP
                COU -> Value.COU
                KMF -> Value.KMF
                CDF -> Value.CDF
                CRC -> Value.CRC
                HRD -> Value.HRD
                HRK -> Value.HRK
                CUC -> Value.CUC
                CUP -> Value.CUP
                CYP -> Value.CYP
                CZK -> Value.CZK
                CSK -> Value.CSK
                DKK -> Value.DKK
                DJF -> Value.DJF
                DOP -> Value.DOP
                NLG -> Value.NLG
                XCD -> Value.XCD
                DDM -> Value.DDM
                ECS -> Value.ECS
                ECV -> Value.ECV
                EGP -> Value.EGP
                GQE -> Value.GQE
                ERN -> Value.ERN
                EEK -> Value.EEK
                ETB -> Value.ETB
                EUR -> Value.EUR
                XBA -> Value.XBA
                XEU -> Value.XEU
                XBB -> Value.XBB
                XBC -> Value.XBC
                XBD -> Value.XBD
                FKP -> Value.FKP
                FJD -> Value.FJD
                FIM -> Value.FIM
                FRF -> Value.FRF
                XFO -> Value.XFO
                XFU -> Value.XFU
                GMD -> Value.GMD
                GEK -> Value.GEK
                GEL -> Value.GEL
                DEM -> Value.DEM
                GHS -> Value.GHS
                GHC -> Value.GHC
                GIP -> Value.GIP
                XAU -> Value.XAU
                GRD -> Value.GRD
                GTQ -> Value.GTQ
                GWP -> Value.GWP
                GNF -> Value.GNF
                GNS -> Value.GNS
                GYD -> Value.GYD
                HTG -> Value.HTG
                HNL -> Value.HNL
                HKD -> Value.HKD
                HUF -> Value.HUF
                IMP -> Value.IMP
                ISK -> Value.ISK
                ISJ -> Value.ISJ
                INR -> Value.INR
                IDR -> Value.IDR
                IRR -> Value.IRR
                IQD -> Value.IQD
                IEP -> Value.IEP
                ILS -> Value.ILS
                ILP -> Value.ILP
                ILR -> Value.ILR
                ITL -> Value.ITL
                JMD -> Value.JMD
                JPY -> Value.JPY
                JOD -> Value.JOD
                KZT -> Value.KZT
                KES -> Value.KES
                KWD -> Value.KWD
                KGS -> Value.KGS
                LAK -> Value.LAK
                LVL -> Value.LVL
                LVR -> Value.LVR
                LBP -> Value.LBP
                LSL -> Value.LSL
                LRD -> Value.LRD
                LYD -> Value.LYD
                LTL -> Value.LTL
                LTT -> Value.LTT
                LUL -> Value.LUL
                LUC -> Value.LUC
                LUF -> Value.LUF
                MOP -> Value.MOP
                MKD -> Value.MKD
                MKN -> Value.MKN
                MGA -> Value.MGA
                MGF -> Value.MGF
                MWK -> Value.MWK
                MYR -> Value.MYR
                MVR -> Value.MVR
                MVP -> Value.MVP
                MLF -> Value.MLF
                MTL -> Value.MTL
                MTP -> Value.MTP
                MRU -> Value.MRU
                MRO -> Value.MRO
                MUR -> Value.MUR
                MXV -> Value.MXV
                MXN -> Value.MXN
                MXP -> Value.MXP
                MDC -> Value.MDC
                MDL -> Value.MDL
                MCF -> Value.MCF
                MNT -> Value.MNT
                MAD -> Value.MAD
                MAF -> Value.MAF
                MZE -> Value.MZE
                MZN -> Value.MZN
                MZM -> Value.MZM
                MMK -> Value.MMK
                NAD -> Value.NAD
                NPR -> Value.NPR
                ANG -> Value.ANG
                TWD -> Value.TWD
                NZD -> Value.NZD
                NIO -> Value.NIO
                NIC -> Value.NIC
                NGN -> Value.NGN
                KPW -> Value.KPW
                NOK -> Value.NOK
                OMR -> Value.OMR
                PKR -> Value.PKR
                XPD -> Value.XPD
                PAB -> Value.PAB
                PGK -> Value.PGK
                PYG -> Value.PYG
                PEI -> Value.PEI
                PEN -> Value.PEN
                PES -> Value.PES
                PHP -> Value.PHP
                XPT -> Value.XPT
                PLN -> Value.PLN
                PLZ -> Value.PLZ
                PTE -> Value.PTE
                GWE -> Value.GWE
                QAR -> Value.QAR
                XRE -> Value.XRE
                RHD -> Value.RHD
                RON -> Value.RON
                ROL -> Value.ROL
                RUB -> Value.RUB
                RUR -> Value.RUR
                RWF -> Value.RWF
                SVC -> Value.SVC
                WST -> Value.WST
                SAR -> Value.SAR
                RSD -> Value.RSD
                CSD -> Value.CSD
                SCR -> Value.SCR
                SLL -> Value.SLL
                XAG -> Value.XAG
                SGD -> Value.SGD
                SKK -> Value.SKK
                SIT -> Value.SIT
                SBD -> Value.SBD
                SOS -> Value.SOS
                ZAR -> Value.ZAR
                ZAL -> Value.ZAL
                KRH -> Value.KRH
                KRW -> Value.KRW
                KRO -> Value.KRO
                SSP -> Value.SSP
                SUR -> Value.SUR
                ESP -> Value.ESP
                ESA -> Value.ESA
                ESB -> Value.ESB
                XDR -> Value.XDR
                LKR -> Value.LKR
                SHP -> Value.SHP
                XSU -> Value.XSU
                SDD -> Value.SDD
                SDG -> Value.SDG
                SDP -> Value.SDP
                SRD -> Value.SRD
                SRG -> Value.SRG
                SZL -> Value.SZL
                SEK -> Value.SEK
                CHF -> Value.CHF
                SYP -> Value.SYP
                STN -> Value.STN
                STD -> Value.STD
                TVD -> Value.TVD
                TJR -> Value.TJR
                TJS -> Value.TJS
                TZS -> Value.TZS
                XTS -> Value.XTS
                THB -> Value.THB
                XXX -> Value.XXX
                TPE -> Value.TPE
                TOP -> Value.TOP
                TTD -> Value.TTD
                TND -> Value.TND
                TRY -> Value.TRY
                TRL -> Value.TRL
                TMT -> Value.TMT
                TMM -> Value.TMM
                USD -> Value.USD
                USN -> Value.USN
                USS -> Value.USS
                UGX -> Value.UGX
                UGS -> Value.UGS
                UAH -> Value.UAH
                UAK -> Value.UAK
                AED -> Value.AED
                UYW -> Value.UYW
                UYU -> Value.UYU
                UYP -> Value.UYP
                UYI -> Value.UYI
                UZS -> Value.UZS
                VUV -> Value.VUV
                VES -> Value.VES
                VEB -> Value.VEB
                VEF -> Value.VEF
                VND -> Value.VND
                VNN -> Value.VNN
                CHE -> Value.CHE
                CHW -> Value.CHW
                XOF -> Value.XOF
                YDD -> Value.YDD
                YER -> Value.YER
                YUN -> Value.YUN
                YUD -> Value.YUD
                YUM -> Value.YUM
                YUR -> Value.YUR
                ZWN -> Value.ZWN
                ZRN -> Value.ZRN
                ZRZ -> Value.ZRZ
                ZMW -> Value.ZMW
                ZMK -> Value.ZMK
                ZWD -> Value.ZWD
                ZWR -> Value.ZWR
                ZWL -> Value.ZWL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                XUA -> Known.XUA
                AFN -> Known.AFN
                AFA -> Known.AFA
                ALL -> Known.ALL
                ALK -> Known.ALK
                DZD -> Known.DZD
                ADP -> Known.ADP
                AOA -> Known.AOA
                AOK -> Known.AOK
                AON -> Known.AON
                AOR -> Known.AOR
                ARA -> Known.ARA
                ARS -> Known.ARS
                ARM -> Known.ARM
                ARP -> Known.ARP
                ARL -> Known.ARL
                AMD -> Known.AMD
                AWG -> Known.AWG
                AUD -> Known.AUD
                ATS -> Known.ATS
                AZN -> Known.AZN
                AZM -> Known.AZM
                BSD -> Known.BSD
                BHD -> Known.BHD
                BDT -> Known.BDT
                BBD -> Known.BBD
                BYN -> Known.BYN
                BYB -> Known.BYB
                BYR -> Known.BYR
                BEF -> Known.BEF
                BEC -> Known.BEC
                BEL -> Known.BEL
                BZD -> Known.BZD
                BMD -> Known.BMD
                BTN -> Known.BTN
                BOB -> Known.BOB
                BOL -> Known.BOL
                BOV -> Known.BOV
                BOP -> Known.BOP
                BAM -> Known.BAM
                BAD -> Known.BAD
                BAN -> Known.BAN
                BWP -> Known.BWP
                BRC -> Known.BRC
                BRZ -> Known.BRZ
                BRE -> Known.BRE
                BRR -> Known.BRR
                BRN -> Known.BRN
                BRB -> Known.BRB
                BRL -> Known.BRL
                GBP -> Known.GBP
                BND -> Known.BND
                BGL -> Known.BGL
                BGN -> Known.BGN
                BGO -> Known.BGO
                BGM -> Known.BGM
                BUK -> Known.BUK
                BIF -> Known.BIF
                XPF -> Known.XPF
                KHR -> Known.KHR
                CAD -> Known.CAD
                CVE -> Known.CVE
                KYD -> Known.KYD
                XAF -> Known.XAF
                CLE -> Known.CLE
                CLP -> Known.CLP
                CLF -> Known.CLF
                CNX -> Known.CNX
                CNY -> Known.CNY
                CNH -> Known.CNH
                COP -> Known.COP
                COU -> Known.COU
                KMF -> Known.KMF
                CDF -> Known.CDF
                CRC -> Known.CRC
                HRD -> Known.HRD
                HRK -> Known.HRK
                CUC -> Known.CUC
                CUP -> Known.CUP
                CYP -> Known.CYP
                CZK -> Known.CZK
                CSK -> Known.CSK
                DKK -> Known.DKK
                DJF -> Known.DJF
                DOP -> Known.DOP
                NLG -> Known.NLG
                XCD -> Known.XCD
                DDM -> Known.DDM
                ECS -> Known.ECS
                ECV -> Known.ECV
                EGP -> Known.EGP
                GQE -> Known.GQE
                ERN -> Known.ERN
                EEK -> Known.EEK
                ETB -> Known.ETB
                EUR -> Known.EUR
                XBA -> Known.XBA
                XEU -> Known.XEU
                XBB -> Known.XBB
                XBC -> Known.XBC
                XBD -> Known.XBD
                FKP -> Known.FKP
                FJD -> Known.FJD
                FIM -> Known.FIM
                FRF -> Known.FRF
                XFO -> Known.XFO
                XFU -> Known.XFU
                GMD -> Known.GMD
                GEK -> Known.GEK
                GEL -> Known.GEL
                DEM -> Known.DEM
                GHS -> Known.GHS
                GHC -> Known.GHC
                GIP -> Known.GIP
                XAU -> Known.XAU
                GRD -> Known.GRD
                GTQ -> Known.GTQ
                GWP -> Known.GWP
                GNF -> Known.GNF
                GNS -> Known.GNS
                GYD -> Known.GYD
                HTG -> Known.HTG
                HNL -> Known.HNL
                HKD -> Known.HKD
                HUF -> Known.HUF
                IMP -> Known.IMP
                ISK -> Known.ISK
                ISJ -> Known.ISJ
                INR -> Known.INR
                IDR -> Known.IDR
                IRR -> Known.IRR
                IQD -> Known.IQD
                IEP -> Known.IEP
                ILS -> Known.ILS
                ILP -> Known.ILP
                ILR -> Known.ILR
                ITL -> Known.ITL
                JMD -> Known.JMD
                JPY -> Known.JPY
                JOD -> Known.JOD
                KZT -> Known.KZT
                KES -> Known.KES
                KWD -> Known.KWD
                KGS -> Known.KGS
                LAK -> Known.LAK
                LVL -> Known.LVL
                LVR -> Known.LVR
                LBP -> Known.LBP
                LSL -> Known.LSL
                LRD -> Known.LRD
                LYD -> Known.LYD
                LTL -> Known.LTL
                LTT -> Known.LTT
                LUL -> Known.LUL
                LUC -> Known.LUC
                LUF -> Known.LUF
                MOP -> Known.MOP
                MKD -> Known.MKD
                MKN -> Known.MKN
                MGA -> Known.MGA
                MGF -> Known.MGF
                MWK -> Known.MWK
                MYR -> Known.MYR
                MVR -> Known.MVR
                MVP -> Known.MVP
                MLF -> Known.MLF
                MTL -> Known.MTL
                MTP -> Known.MTP
                MRU -> Known.MRU
                MRO -> Known.MRO
                MUR -> Known.MUR
                MXV -> Known.MXV
                MXN -> Known.MXN
                MXP -> Known.MXP
                MDC -> Known.MDC
                MDL -> Known.MDL
                MCF -> Known.MCF
                MNT -> Known.MNT
                MAD -> Known.MAD
                MAF -> Known.MAF
                MZE -> Known.MZE
                MZN -> Known.MZN
                MZM -> Known.MZM
                MMK -> Known.MMK
                NAD -> Known.NAD
                NPR -> Known.NPR
                ANG -> Known.ANG
                TWD -> Known.TWD
                NZD -> Known.NZD
                NIO -> Known.NIO
                NIC -> Known.NIC
                NGN -> Known.NGN
                KPW -> Known.KPW
                NOK -> Known.NOK
                OMR -> Known.OMR
                PKR -> Known.PKR
                XPD -> Known.XPD
                PAB -> Known.PAB
                PGK -> Known.PGK
                PYG -> Known.PYG
                PEI -> Known.PEI
                PEN -> Known.PEN
                PES -> Known.PES
                PHP -> Known.PHP
                XPT -> Known.XPT
                PLN -> Known.PLN
                PLZ -> Known.PLZ
                PTE -> Known.PTE
                GWE -> Known.GWE
                QAR -> Known.QAR
                XRE -> Known.XRE
                RHD -> Known.RHD
                RON -> Known.RON
                ROL -> Known.ROL
                RUB -> Known.RUB
                RUR -> Known.RUR
                RWF -> Known.RWF
                SVC -> Known.SVC
                WST -> Known.WST
                SAR -> Known.SAR
                RSD -> Known.RSD
                CSD -> Known.CSD
                SCR -> Known.SCR
                SLL -> Known.SLL
                XAG -> Known.XAG
                SGD -> Known.SGD
                SKK -> Known.SKK
                SIT -> Known.SIT
                SBD -> Known.SBD
                SOS -> Known.SOS
                ZAR -> Known.ZAR
                ZAL -> Known.ZAL
                KRH -> Known.KRH
                KRW -> Known.KRW
                KRO -> Known.KRO
                SSP -> Known.SSP
                SUR -> Known.SUR
                ESP -> Known.ESP
                ESA -> Known.ESA
                ESB -> Known.ESB
                XDR -> Known.XDR
                LKR -> Known.LKR
                SHP -> Known.SHP
                XSU -> Known.XSU
                SDD -> Known.SDD
                SDG -> Known.SDG
                SDP -> Known.SDP
                SRD -> Known.SRD
                SRG -> Known.SRG
                SZL -> Known.SZL
                SEK -> Known.SEK
                CHF -> Known.CHF
                SYP -> Known.SYP
                STN -> Known.STN
                STD -> Known.STD
                TVD -> Known.TVD
                TJR -> Known.TJR
                TJS -> Known.TJS
                TZS -> Known.TZS
                XTS -> Known.XTS
                THB -> Known.THB
                XXX -> Known.XXX
                TPE -> Known.TPE
                TOP -> Known.TOP
                TTD -> Known.TTD
                TND -> Known.TND
                TRY -> Known.TRY
                TRL -> Known.TRL
                TMT -> Known.TMT
                TMM -> Known.TMM
                USD -> Known.USD
                USN -> Known.USN
                USS -> Known.USS
                UGX -> Known.UGX
                UGS -> Known.UGS
                UAH -> Known.UAH
                UAK -> Known.UAK
                AED -> Known.AED
                UYW -> Known.UYW
                UYU -> Known.UYU
                UYP -> Known.UYP
                UYI -> Known.UYI
                UZS -> Known.UZS
                VUV -> Known.VUV
                VES -> Known.VES
                VEB -> Known.VEB
                VEF -> Known.VEF
                VND -> Known.VND
                VNN -> Known.VNN
                CHE -> Known.CHE
                CHW -> Known.CHW
                XOF -> Known.XOF
                YDD -> Known.YDD
                YER -> Known.YER
                YUN -> Known.YUN
                YUD -> Known.YUD
                YUM -> Known.YUM
                YUR -> Known.YUR
                ZWN -> Known.ZWN
                ZRN -> Known.ZRN
                ZRZ -> Known.ZRZ
                ZMW -> Known.ZMW
                ZMK -> Known.ZMK
                ZWD -> Known.ZWD
                ZWR -> Known.ZWR
                ZWL -> Known.ZWL
                else -> throw MergeInvalidDataException("Unknown CurrencyEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /**
     * # The ReportItem Object
     *
     * ### Description
     *
     * The `ReportItem` object is used to represent a report item for a Balance Sheet, Cash Flow
     * Statement or Profit and Loss Report.
     *
     * ### Usage Example
     *
     * Fetch from the `GET BalanceSheet` endpoint and view the balance sheet's report items.
     */
    @JsonDeserialize(builder = ReportItem.Builder::class)
    @NoAutoDetect
    class ReportItem
    private constructor(
        private val remoteId: JsonField<String>,
        private val name: JsonField<String>,
        private val value: JsonField<Double>,
        private val subItems: JsonField<List<SubItem>>,
        private val company: JsonField<String>,
        private val modifiedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** The third-party API ID of the matching object. */
        fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

        /** The report item's name. */
        fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

        /** The report item's value. */
        fun value(): Optional<Double> = Optional.ofNullable(value.getNullable("value"))

        fun subItems(): Optional<List<SubItem>> =
            Optional.ofNullable(subItems.getNullable("sub_items"))

        /** The company the report item belongs to. */
        fun company(): Optional<String> = Optional.ofNullable(company.getNullable("company"))

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(): Optional<OffsetDateTime> =
            Optional.ofNullable(modifiedAt.getNullable("modified_at"))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

        /** The report item's name. */
        @JsonProperty("name") @ExcludeMissing fun _name() = name

        /** The report item's value. */
        @JsonProperty("value") @ExcludeMissing fun _value() = value

        @JsonProperty("sub_items") @ExcludeMissing fun _subItems() = subItems

        /** The company the report item belongs to. */
        @JsonProperty("company") @ExcludeMissing fun _company() = company

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                remoteId()
                name()
                value()
                subItems().map { it.forEach { it.validate() } }
                company()
                modifiedAt()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ReportItem &&
                this.remoteId == other.remoteId &&
                this.name == other.name &&
                this.value == other.value &&
                this.subItems == other.subItems &&
                this.company == other.company &&
                this.modifiedAt == other.modifiedAt &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        remoteId,
                        name,
                        value,
                        subItems,
                        company,
                        modifiedAt,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ReportItem{remoteId=$remoteId, name=$name, value=$value, subItems=$subItems, company=$company, modifiedAt=$modifiedAt, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var remoteId: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var value: JsonField<Double> = JsonMissing.of()
            private var subItems: JsonField<List<SubItem>> = JsonMissing.of()
            private var company: JsonField<String> = JsonMissing.of()
            private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(reportItem: ReportItem) = apply {
                this.remoteId = reportItem.remoteId
                this.name = reportItem.name
                this.value = reportItem.value
                this.subItems = reportItem.subItems
                this.company = reportItem.company
                this.modifiedAt = reportItem.modifiedAt
                additionalProperties(reportItem.additionalProperties)
            }

            /** The third-party API ID of the matching object. */
            fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

            /** The third-party API ID of the matching object. */
            @JsonProperty("remote_id")
            @ExcludeMissing
            fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

            /** The report item's name. */
            fun name(name: String) = name(JsonField.of(name))

            /** The report item's name. */
            @JsonProperty("name")
            @ExcludeMissing
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The report item's value. */
            fun value(value: Double) = value(JsonField.of(value))

            /** The report item's value. */
            @JsonProperty("value")
            @ExcludeMissing
            fun value(value: JsonField<Double>) = apply { this.value = value }

            fun subItems(subItems: List<SubItem>) = subItems(JsonField.of(subItems))

            @JsonProperty("sub_items")
            @ExcludeMissing
            fun subItems(subItems: JsonField<List<SubItem>>) = apply { this.subItems = subItems }

            /** The company the report item belongs to. */
            fun company(company: String) = company(JsonField.of(company))

            /** The company the report item belongs to. */
            @JsonProperty("company")
            @ExcludeMissing
            fun company(company: JsonField<String>) = apply { this.company = company }

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

            fun build(): ReportItem =
                ReportItem(
                    remoteId,
                    name,
                    value,
                    subItems.map { it.toUnmodifiable() },
                    company,
                    modifiedAt,
                    additionalProperties.toUnmodifiable(),
                )
        }

        @JsonDeserialize(builder = SubItem.Builder::class)
        @NoAutoDetect
        class SubItem
        private constructor(
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate() = apply {
                if (!validated) {
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is SubItem && this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode = Objects.hash(additionalProperties)
                }
                return hashCode
            }

            override fun toString() = "SubItem{additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(subItem: SubItem) = apply {
                    additionalProperties(subItem.additionalProperties)
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

                fun build(): SubItem = SubItem(additionalProperties.toUnmodifiable())
            }
        }
    }
}
