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
 * # The Employment Object
 *
 * ### Description
 *
 * The `Employment` object is used to represent a job position at a company.
 *
 * Please note: When there is a change in pay or title, integrations with historical data will
 * create new Employment objects while integrations without historical data will update existing
 * ones.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Employments` endpoint and filter by `ID` to show all employees.
 */
@JsonDeserialize(builder = Employment.Builder::class)
@NoAutoDetect
class Employment
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val employee: JsonField<String>,
    private val jobTitle: JsonField<String>,
    private val payRate: JsonField<Double>,
    private val payPeriod: JsonField<PayPeriodEnum>,
    private val payFrequency: JsonField<PayFrequencyEnum>,
    private val payCurrency: JsonField<PayCurrencyEnum>,
    private val payGroup: JsonField<String>,
    private val flsaStatus: JsonField<FlsaStatusEnum>,
    private val effectiveDate: JsonField<OffsetDateTime>,
    private val employmentType: JsonField<EmploymentTypeEnum>,
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

    /** The employee holding this position. */
    fun employee(): Optional<String> = Optional.ofNullable(employee.getNullable("employee"))

    /** The position's title. */
    fun jobTitle(): Optional<String> = Optional.ofNullable(jobTitle.getNullable("job_title"))

    /** The position's pay rate in dollars. */
    fun payRate(): Optional<Double> = Optional.ofNullable(payRate.getNullable("pay_rate"))

    /**
     * - `HOUR` - HOUR
     * - `DAY` - DAY
     * - `WEEK` - WEEK
     * - `EVERY_TWO_WEEKS` - EVERY_TWO_WEEKS
     * - `SEMIMONTHLY` - SEMIMONTHLY
     * - `MONTH` - MONTH
     * - `QUARTER` - QUARTER
     * - `EVERY_SIX_MONTHS` - EVERY_SIX_MONTHS
     * - `YEAR` - YEAR
     */
    fun payPeriod(): Optional<PayPeriodEnum> =
        Optional.ofNullable(payPeriod.getNullable("pay_period"))

    /**
     * - `WEEKLY` - WEEKLY
     * - `BIWEEKLY` - BIWEEKLY
     * - `MONTHLY` - MONTHLY
     * - `QUARTERLY` - QUARTERLY
     * - `SEMIANNUALLY` - SEMIANNUALLY
     * - `ANNUALLY` - ANNUALLY
     * - `THIRTEEN-MONTHLY` - THIRTEEN-MONTHLY
     * - `PRO_RATA` - PRO_RATA
     * - `SEMIMONTHLY` - SEMIMONTHLY
     */
    fun payFrequency(): Optional<PayFrequencyEnum> =
        Optional.ofNullable(payFrequency.getNullable("pay_frequency"))

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
    fun payCurrency(): Optional<PayCurrencyEnum> =
        Optional.ofNullable(payCurrency.getNullable("pay_currency"))

    /** The employment's pay group */
    fun payGroup(): Optional<String> = Optional.ofNullable(payGroup.getNullable("pay_group"))

    /**
     * - `EXEMPT` - EXEMPT
     * - `SALARIED_NONEXEMPT` - SALARIED_NONEXEMPT
     * - `NONEXEMPT` - NONEXEMPT
     * - `OWNER` - OWNER
     */
    fun flsaStatus(): Optional<FlsaStatusEnum> =
        Optional.ofNullable(flsaStatus.getNullable("flsa_status"))

    /** The position's effective date. */
    fun effectiveDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(effectiveDate.getNullable("effective_date"))

    /**
     * - `FULL_TIME` - FULL_TIME
     * - `PART_TIME` - PART_TIME
     * - `INTERN` - INTERN
     * - `CONTRACTOR` - CONTRACTOR
     * - `FREELANCE` - FREELANCE
     */
    fun employmentType(): Optional<EmploymentTypeEnum> =
        Optional.ofNullable(employmentType.getNullable("employment_type"))

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

    /** The employee holding this position. */
    @JsonProperty("employee") @ExcludeMissing fun _employee() = employee

    /** The position's title. */
    @JsonProperty("job_title") @ExcludeMissing fun _jobTitle() = jobTitle

    /** The position's pay rate in dollars. */
    @JsonProperty("pay_rate") @ExcludeMissing fun _payRate() = payRate

    /**
     * - `HOUR` - HOUR
     * - `DAY` - DAY
     * - `WEEK` - WEEK
     * - `EVERY_TWO_WEEKS` - EVERY_TWO_WEEKS
     * - `SEMIMONTHLY` - SEMIMONTHLY
     * - `MONTH` - MONTH
     * - `QUARTER` - QUARTER
     * - `EVERY_SIX_MONTHS` - EVERY_SIX_MONTHS
     * - `YEAR` - YEAR
     */
    @JsonProperty("pay_period") @ExcludeMissing fun _payPeriod() = payPeriod

    /**
     * - `WEEKLY` - WEEKLY
     * - `BIWEEKLY` - BIWEEKLY
     * - `MONTHLY` - MONTHLY
     * - `QUARTERLY` - QUARTERLY
     * - `SEMIANNUALLY` - SEMIANNUALLY
     * - `ANNUALLY` - ANNUALLY
     * - `THIRTEEN-MONTHLY` - THIRTEEN-MONTHLY
     * - `PRO_RATA` - PRO_RATA
     * - `SEMIMONTHLY` - SEMIMONTHLY
     */
    @JsonProperty("pay_frequency") @ExcludeMissing fun _payFrequency() = payFrequency

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
    @JsonProperty("pay_currency") @ExcludeMissing fun _payCurrency() = payCurrency

    /** The employment's pay group */
    @JsonProperty("pay_group") @ExcludeMissing fun _payGroup() = payGroup

    /**
     * - `EXEMPT` - EXEMPT
     * - `SALARIED_NONEXEMPT` - SALARIED_NONEXEMPT
     * - `NONEXEMPT` - NONEXEMPT
     * - `OWNER` - OWNER
     */
    @JsonProperty("flsa_status") @ExcludeMissing fun _flsaStatus() = flsaStatus

    /** The position's effective date. */
    @JsonProperty("effective_date") @ExcludeMissing fun _effectiveDate() = effectiveDate

    /**
     * - `FULL_TIME` - FULL_TIME
     * - `PART_TIME` - PART_TIME
     * - `INTERN` - INTERN
     * - `CONTRACTOR` - CONTRACTOR
     * - `FREELANCE` - FREELANCE
     */
    @JsonProperty("employment_type") @ExcludeMissing fun _employmentType() = employmentType

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
            employee()
            jobTitle()
            payRate()
            payPeriod()
            payFrequency()
            payCurrency()
            payGroup()
            flsaStatus()
            effectiveDate()
            employmentType()
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

        return other is Employment &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.employee == other.employee &&
            this.jobTitle == other.jobTitle &&
            this.payRate == other.payRate &&
            this.payPeriod == other.payPeriod &&
            this.payFrequency == other.payFrequency &&
            this.payCurrency == other.payCurrency &&
            this.payGroup == other.payGroup &&
            this.flsaStatus == other.flsaStatus &&
            this.effectiveDate == other.effectiveDate &&
            this.employmentType == other.employmentType &&
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
                    employee,
                    jobTitle,
                    payRate,
                    payPeriod,
                    payFrequency,
                    payCurrency,
                    payGroup,
                    flsaStatus,
                    effectiveDate,
                    employmentType,
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
        "Employment{id=$id, remoteId=$remoteId, employee=$employee, jobTitle=$jobTitle, payRate=$payRate, payPeriod=$payPeriod, payFrequency=$payFrequency, payCurrency=$payCurrency, payGroup=$payGroup, flsaStatus=$flsaStatus, effectiveDate=$effectiveDate, employmentType=$employmentType, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var employee: JsonField<String> = JsonMissing.of()
        private var jobTitle: JsonField<String> = JsonMissing.of()
        private var payRate: JsonField<Double> = JsonMissing.of()
        private var payPeriod: JsonField<PayPeriodEnum> = JsonMissing.of()
        private var payFrequency: JsonField<PayFrequencyEnum> = JsonMissing.of()
        private var payCurrency: JsonField<PayCurrencyEnum> = JsonMissing.of()
        private var payGroup: JsonField<String> = JsonMissing.of()
        private var flsaStatus: JsonField<FlsaStatusEnum> = JsonMissing.of()
        private var effectiveDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var employmentType: JsonField<EmploymentTypeEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(employment: Employment) = apply {
            this.id = employment.id
            this.remoteId = employment.remoteId
            this.employee = employment.employee
            this.jobTitle = employment.jobTitle
            this.payRate = employment.payRate
            this.payPeriod = employment.payPeriod
            this.payFrequency = employment.payFrequency
            this.payCurrency = employment.payCurrency
            this.payGroup = employment.payGroup
            this.flsaStatus = employment.flsaStatus
            this.effectiveDate = employment.effectiveDate
            this.employmentType = employment.employmentType
            this.remoteWasDeleted = employment.remoteWasDeleted
            this.fieldMappings = employment.fieldMappings
            this.modifiedAt = employment.modifiedAt
            this.remoteData = employment.remoteData
            additionalProperties(employment.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The employee holding this position. */
        fun employee(employee: String) = employee(JsonField.of(employee))

        /** The employee holding this position. */
        @JsonProperty("employee")
        @ExcludeMissing
        fun employee(employee: JsonField<String>) = apply { this.employee = employee }

        /** The position's title. */
        fun jobTitle(jobTitle: String) = jobTitle(JsonField.of(jobTitle))

        /** The position's title. */
        @JsonProperty("job_title")
        @ExcludeMissing
        fun jobTitle(jobTitle: JsonField<String>) = apply { this.jobTitle = jobTitle }

        /** The position's pay rate in dollars. */
        fun payRate(payRate: Double) = payRate(JsonField.of(payRate))

        /** The position's pay rate in dollars. */
        @JsonProperty("pay_rate")
        @ExcludeMissing
        fun payRate(payRate: JsonField<Double>) = apply { this.payRate = payRate }

        /**
         * - `HOUR` - HOUR
         * - `DAY` - DAY
         * - `WEEK` - WEEK
         * - `EVERY_TWO_WEEKS` - EVERY_TWO_WEEKS
         * - `SEMIMONTHLY` - SEMIMONTHLY
         * - `MONTH` - MONTH
         * - `QUARTER` - QUARTER
         * - `EVERY_SIX_MONTHS` - EVERY_SIX_MONTHS
         * - `YEAR` - YEAR
         */
        fun payPeriod(payPeriod: PayPeriodEnum) = payPeriod(JsonField.of(payPeriod))

        /**
         * - `HOUR` - HOUR
         * - `DAY` - DAY
         * - `WEEK` - WEEK
         * - `EVERY_TWO_WEEKS` - EVERY_TWO_WEEKS
         * - `SEMIMONTHLY` - SEMIMONTHLY
         * - `MONTH` - MONTH
         * - `QUARTER` - QUARTER
         * - `EVERY_SIX_MONTHS` - EVERY_SIX_MONTHS
         * - `YEAR` - YEAR
         */
        @JsonProperty("pay_period")
        @ExcludeMissing
        fun payPeriod(payPeriod: JsonField<PayPeriodEnum>) = apply { this.payPeriod = payPeriod }

        /**
         * - `WEEKLY` - WEEKLY
         * - `BIWEEKLY` - BIWEEKLY
         * - `MONTHLY` - MONTHLY
         * - `QUARTERLY` - QUARTERLY
         * - `SEMIANNUALLY` - SEMIANNUALLY
         * - `ANNUALLY` - ANNUALLY
         * - `THIRTEEN-MONTHLY` - THIRTEEN-MONTHLY
         * - `PRO_RATA` - PRO_RATA
         * - `SEMIMONTHLY` - SEMIMONTHLY
         */
        fun payFrequency(payFrequency: PayFrequencyEnum) = payFrequency(JsonField.of(payFrequency))

        /**
         * - `WEEKLY` - WEEKLY
         * - `BIWEEKLY` - BIWEEKLY
         * - `MONTHLY` - MONTHLY
         * - `QUARTERLY` - QUARTERLY
         * - `SEMIANNUALLY` - SEMIANNUALLY
         * - `ANNUALLY` - ANNUALLY
         * - `THIRTEEN-MONTHLY` - THIRTEEN-MONTHLY
         * - `PRO_RATA` - PRO_RATA
         * - `SEMIMONTHLY` - SEMIMONTHLY
         */
        @JsonProperty("pay_frequency")
        @ExcludeMissing
        fun payFrequency(payFrequency: JsonField<PayFrequencyEnum>) = apply {
            this.payFrequency = payFrequency
        }

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
        fun payCurrency(payCurrency: PayCurrencyEnum) = payCurrency(JsonField.of(payCurrency))

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
        @JsonProperty("pay_currency")
        @ExcludeMissing
        fun payCurrency(payCurrency: JsonField<PayCurrencyEnum>) = apply {
            this.payCurrency = payCurrency
        }

        /** The employment's pay group */
        fun payGroup(payGroup: String) = payGroup(JsonField.of(payGroup))

        /** The employment's pay group */
        @JsonProperty("pay_group")
        @ExcludeMissing
        fun payGroup(payGroup: JsonField<String>) = apply { this.payGroup = payGroup }

        /**
         * - `EXEMPT` - EXEMPT
         * - `SALARIED_NONEXEMPT` - SALARIED_NONEXEMPT
         * - `NONEXEMPT` - NONEXEMPT
         * - `OWNER` - OWNER
         */
        fun flsaStatus(flsaStatus: FlsaStatusEnum) = flsaStatus(JsonField.of(flsaStatus))

        /**
         * - `EXEMPT` - EXEMPT
         * - `SALARIED_NONEXEMPT` - SALARIED_NONEXEMPT
         * - `NONEXEMPT` - NONEXEMPT
         * - `OWNER` - OWNER
         */
        @JsonProperty("flsa_status")
        @ExcludeMissing
        fun flsaStatus(flsaStatus: JsonField<FlsaStatusEnum>) = apply {
            this.flsaStatus = flsaStatus
        }

        /** The position's effective date. */
        fun effectiveDate(effectiveDate: OffsetDateTime) =
            effectiveDate(JsonField.of(effectiveDate))

        /** The position's effective date. */
        @JsonProperty("effective_date")
        @ExcludeMissing
        fun effectiveDate(effectiveDate: JsonField<OffsetDateTime>) = apply {
            this.effectiveDate = effectiveDate
        }

        /**
         * - `FULL_TIME` - FULL_TIME
         * - `PART_TIME` - PART_TIME
         * - `INTERN` - INTERN
         * - `CONTRACTOR` - CONTRACTOR
         * - `FREELANCE` - FREELANCE
         */
        fun employmentType(employmentType: EmploymentTypeEnum) =
            employmentType(JsonField.of(employmentType))

        /**
         * - `FULL_TIME` - FULL_TIME
         * - `PART_TIME` - PART_TIME
         * - `INTERN` - INTERN
         * - `CONTRACTOR` - CONTRACTOR
         * - `FREELANCE` - FREELANCE
         */
        @JsonProperty("employment_type")
        @ExcludeMissing
        fun employmentType(employmentType: JsonField<EmploymentTypeEnum>) = apply {
            this.employmentType = employmentType
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

        fun build(): Employment =
            Employment(
                id,
                remoteId,
                employee,
                jobTitle,
                payRate,
                payPeriod,
                payFrequency,
                payCurrency,
                payGroup,
                flsaStatus,
                effectiveDate,
                employmentType,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class PayPeriodEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PayPeriodEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val HOUR = PayPeriodEnum(JsonField.of("HOUR"))

            @JvmField val DAY = PayPeriodEnum(JsonField.of("DAY"))

            @JvmField val WEEK = PayPeriodEnum(JsonField.of("WEEK"))

            @JvmField val EVERY_TWO_WEEKS = PayPeriodEnum(JsonField.of("EVERY_TWO_WEEKS"))

            @JvmField val SEMIMONTHLY = PayPeriodEnum(JsonField.of("SEMIMONTHLY"))

            @JvmField val MONTH = PayPeriodEnum(JsonField.of("MONTH"))

            @JvmField val QUARTER = PayPeriodEnum(JsonField.of("QUARTER"))

            @JvmField val EVERY_SIX_MONTHS = PayPeriodEnum(JsonField.of("EVERY_SIX_MONTHS"))

            @JvmField val YEAR = PayPeriodEnum(JsonField.of("YEAR"))

            @JvmStatic fun of(value: String) = PayPeriodEnum(JsonField.of(value))
        }

        enum class Known {
            HOUR,
            DAY,
            WEEK,
            EVERY_TWO_WEEKS,
            SEMIMONTHLY,
            MONTH,
            QUARTER,
            EVERY_SIX_MONTHS,
            YEAR,
        }

        enum class Value {
            HOUR,
            DAY,
            WEEK,
            EVERY_TWO_WEEKS,
            SEMIMONTHLY,
            MONTH,
            QUARTER,
            EVERY_SIX_MONTHS,
            YEAR,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                HOUR -> Value.HOUR
                DAY -> Value.DAY
                WEEK -> Value.WEEK
                EVERY_TWO_WEEKS -> Value.EVERY_TWO_WEEKS
                SEMIMONTHLY -> Value.SEMIMONTHLY
                MONTH -> Value.MONTH
                QUARTER -> Value.QUARTER
                EVERY_SIX_MONTHS -> Value.EVERY_SIX_MONTHS
                YEAR -> Value.YEAR
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                HOUR -> Known.HOUR
                DAY -> Known.DAY
                WEEK -> Known.WEEK
                EVERY_TWO_WEEKS -> Known.EVERY_TWO_WEEKS
                SEMIMONTHLY -> Known.SEMIMONTHLY
                MONTH -> Known.MONTH
                QUARTER -> Known.QUARTER
                EVERY_SIX_MONTHS -> Known.EVERY_SIX_MONTHS
                YEAR -> Known.YEAR
                else -> throw MergeInvalidDataException("Unknown PayPeriodEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class PayFrequencyEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PayFrequencyEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val WEEKLY = PayFrequencyEnum(JsonField.of("WEEKLY"))

            @JvmField val BIWEEKLY = PayFrequencyEnum(JsonField.of("BIWEEKLY"))

            @JvmField val MONTHLY = PayFrequencyEnum(JsonField.of("MONTHLY"))

            @JvmField val QUARTERLY = PayFrequencyEnum(JsonField.of("QUARTERLY"))

            @JvmField val SEMIANNUALLY = PayFrequencyEnum(JsonField.of("SEMIANNUALLY"))

            @JvmField val ANNUALLY = PayFrequencyEnum(JsonField.of("ANNUALLY"))

            @JvmField val THIRTEEN_MONTHLY = PayFrequencyEnum(JsonField.of("THIRTEEN-MONTHLY"))

            @JvmField val PRO_RATA = PayFrequencyEnum(JsonField.of("PRO_RATA"))

            @JvmField val SEMIMONTHLY = PayFrequencyEnum(JsonField.of("SEMIMONTHLY"))

            @JvmStatic fun of(value: String) = PayFrequencyEnum(JsonField.of(value))
        }

        enum class Known {
            WEEKLY,
            BIWEEKLY,
            MONTHLY,
            QUARTERLY,
            SEMIANNUALLY,
            ANNUALLY,
            THIRTEEN_MONTHLY,
            PRO_RATA,
            SEMIMONTHLY,
        }

        enum class Value {
            WEEKLY,
            BIWEEKLY,
            MONTHLY,
            QUARTERLY,
            SEMIANNUALLY,
            ANNUALLY,
            THIRTEEN_MONTHLY,
            PRO_RATA,
            SEMIMONTHLY,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                WEEKLY -> Value.WEEKLY
                BIWEEKLY -> Value.BIWEEKLY
                MONTHLY -> Value.MONTHLY
                QUARTERLY -> Value.QUARTERLY
                SEMIANNUALLY -> Value.SEMIANNUALLY
                ANNUALLY -> Value.ANNUALLY
                THIRTEEN_MONTHLY -> Value.THIRTEEN_MONTHLY
                PRO_RATA -> Value.PRO_RATA
                SEMIMONTHLY -> Value.SEMIMONTHLY
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                WEEKLY -> Known.WEEKLY
                BIWEEKLY -> Known.BIWEEKLY
                MONTHLY -> Known.MONTHLY
                QUARTERLY -> Known.QUARTERLY
                SEMIANNUALLY -> Known.SEMIANNUALLY
                ANNUALLY -> Known.ANNUALLY
                THIRTEEN_MONTHLY -> Known.THIRTEEN_MONTHLY
                PRO_RATA -> Known.PRO_RATA
                SEMIMONTHLY -> Known.SEMIMONTHLY
                else -> throw MergeInvalidDataException("Unknown PayFrequencyEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class PayCurrencyEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PayCurrencyEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val XUA = PayCurrencyEnum(JsonField.of("XUA"))

            @JvmField val AFN = PayCurrencyEnum(JsonField.of("AFN"))

            @JvmField val AFA = PayCurrencyEnum(JsonField.of("AFA"))

            @JvmField val ALL = PayCurrencyEnum(JsonField.of("ALL"))

            @JvmField val ALK = PayCurrencyEnum(JsonField.of("ALK"))

            @JvmField val DZD = PayCurrencyEnum(JsonField.of("DZD"))

            @JvmField val ADP = PayCurrencyEnum(JsonField.of("ADP"))

            @JvmField val AOA = PayCurrencyEnum(JsonField.of("AOA"))

            @JvmField val AOK = PayCurrencyEnum(JsonField.of("AOK"))

            @JvmField val AON = PayCurrencyEnum(JsonField.of("AON"))

            @JvmField val AOR = PayCurrencyEnum(JsonField.of("AOR"))

            @JvmField val ARA = PayCurrencyEnum(JsonField.of("ARA"))

            @JvmField val ARS = PayCurrencyEnum(JsonField.of("ARS"))

            @JvmField val ARM = PayCurrencyEnum(JsonField.of("ARM"))

            @JvmField val ARP = PayCurrencyEnum(JsonField.of("ARP"))

            @JvmField val ARL = PayCurrencyEnum(JsonField.of("ARL"))

            @JvmField val AMD = PayCurrencyEnum(JsonField.of("AMD"))

            @JvmField val AWG = PayCurrencyEnum(JsonField.of("AWG"))

            @JvmField val AUD = PayCurrencyEnum(JsonField.of("AUD"))

            @JvmField val ATS = PayCurrencyEnum(JsonField.of("ATS"))

            @JvmField val AZN = PayCurrencyEnum(JsonField.of("AZN"))

            @JvmField val AZM = PayCurrencyEnum(JsonField.of("AZM"))

            @JvmField val BSD = PayCurrencyEnum(JsonField.of("BSD"))

            @JvmField val BHD = PayCurrencyEnum(JsonField.of("BHD"))

            @JvmField val BDT = PayCurrencyEnum(JsonField.of("BDT"))

            @JvmField val BBD = PayCurrencyEnum(JsonField.of("BBD"))

            @JvmField val BYN = PayCurrencyEnum(JsonField.of("BYN"))

            @JvmField val BYB = PayCurrencyEnum(JsonField.of("BYB"))

            @JvmField val BYR = PayCurrencyEnum(JsonField.of("BYR"))

            @JvmField val BEF = PayCurrencyEnum(JsonField.of("BEF"))

            @JvmField val BEC = PayCurrencyEnum(JsonField.of("BEC"))

            @JvmField val BEL = PayCurrencyEnum(JsonField.of("BEL"))

            @JvmField val BZD = PayCurrencyEnum(JsonField.of("BZD"))

            @JvmField val BMD = PayCurrencyEnum(JsonField.of("BMD"))

            @JvmField val BTN = PayCurrencyEnum(JsonField.of("BTN"))

            @JvmField val BOB = PayCurrencyEnum(JsonField.of("BOB"))

            @JvmField val BOL = PayCurrencyEnum(JsonField.of("BOL"))

            @JvmField val BOV = PayCurrencyEnum(JsonField.of("BOV"))

            @JvmField val BOP = PayCurrencyEnum(JsonField.of("BOP"))

            @JvmField val BAM = PayCurrencyEnum(JsonField.of("BAM"))

            @JvmField val BAD = PayCurrencyEnum(JsonField.of("BAD"))

            @JvmField val BAN = PayCurrencyEnum(JsonField.of("BAN"))

            @JvmField val BWP = PayCurrencyEnum(JsonField.of("BWP"))

            @JvmField val BRC = PayCurrencyEnum(JsonField.of("BRC"))

            @JvmField val BRZ = PayCurrencyEnum(JsonField.of("BRZ"))

            @JvmField val BRE = PayCurrencyEnum(JsonField.of("BRE"))

            @JvmField val BRR = PayCurrencyEnum(JsonField.of("BRR"))

            @JvmField val BRN = PayCurrencyEnum(JsonField.of("BRN"))

            @JvmField val BRB = PayCurrencyEnum(JsonField.of("BRB"))

            @JvmField val BRL = PayCurrencyEnum(JsonField.of("BRL"))

            @JvmField val GBP = PayCurrencyEnum(JsonField.of("GBP"))

            @JvmField val BND = PayCurrencyEnum(JsonField.of("BND"))

            @JvmField val BGL = PayCurrencyEnum(JsonField.of("BGL"))

            @JvmField val BGN = PayCurrencyEnum(JsonField.of("BGN"))

            @JvmField val BGO = PayCurrencyEnum(JsonField.of("BGO"))

            @JvmField val BGM = PayCurrencyEnum(JsonField.of("BGM"))

            @JvmField val BUK = PayCurrencyEnum(JsonField.of("BUK"))

            @JvmField val BIF = PayCurrencyEnum(JsonField.of("BIF"))

            @JvmField val XPF = PayCurrencyEnum(JsonField.of("XPF"))

            @JvmField val KHR = PayCurrencyEnum(JsonField.of("KHR"))

            @JvmField val CAD = PayCurrencyEnum(JsonField.of("CAD"))

            @JvmField val CVE = PayCurrencyEnum(JsonField.of("CVE"))

            @JvmField val KYD = PayCurrencyEnum(JsonField.of("KYD"))

            @JvmField val XAF = PayCurrencyEnum(JsonField.of("XAF"))

            @JvmField val CLE = PayCurrencyEnum(JsonField.of("CLE"))

            @JvmField val CLP = PayCurrencyEnum(JsonField.of("CLP"))

            @JvmField val CLF = PayCurrencyEnum(JsonField.of("CLF"))

            @JvmField val CNX = PayCurrencyEnum(JsonField.of("CNX"))

            @JvmField val CNY = PayCurrencyEnum(JsonField.of("CNY"))

            @JvmField val CNH = PayCurrencyEnum(JsonField.of("CNH"))

            @JvmField val COP = PayCurrencyEnum(JsonField.of("COP"))

            @JvmField val COU = PayCurrencyEnum(JsonField.of("COU"))

            @JvmField val KMF = PayCurrencyEnum(JsonField.of("KMF"))

            @JvmField val CDF = PayCurrencyEnum(JsonField.of("CDF"))

            @JvmField val CRC = PayCurrencyEnum(JsonField.of("CRC"))

            @JvmField val HRD = PayCurrencyEnum(JsonField.of("HRD"))

            @JvmField val HRK = PayCurrencyEnum(JsonField.of("HRK"))

            @JvmField val CUC = PayCurrencyEnum(JsonField.of("CUC"))

            @JvmField val CUP = PayCurrencyEnum(JsonField.of("CUP"))

            @JvmField val CYP = PayCurrencyEnum(JsonField.of("CYP"))

            @JvmField val CZK = PayCurrencyEnum(JsonField.of("CZK"))

            @JvmField val CSK = PayCurrencyEnum(JsonField.of("CSK"))

            @JvmField val DKK = PayCurrencyEnum(JsonField.of("DKK"))

            @JvmField val DJF = PayCurrencyEnum(JsonField.of("DJF"))

            @JvmField val DOP = PayCurrencyEnum(JsonField.of("DOP"))

            @JvmField val NLG = PayCurrencyEnum(JsonField.of("NLG"))

            @JvmField val XCD = PayCurrencyEnum(JsonField.of("XCD"))

            @JvmField val DDM = PayCurrencyEnum(JsonField.of("DDM"))

            @JvmField val ECS = PayCurrencyEnum(JsonField.of("ECS"))

            @JvmField val ECV = PayCurrencyEnum(JsonField.of("ECV"))

            @JvmField val EGP = PayCurrencyEnum(JsonField.of("EGP"))

            @JvmField val GQE = PayCurrencyEnum(JsonField.of("GQE"))

            @JvmField val ERN = PayCurrencyEnum(JsonField.of("ERN"))

            @JvmField val EEK = PayCurrencyEnum(JsonField.of("EEK"))

            @JvmField val ETB = PayCurrencyEnum(JsonField.of("ETB"))

            @JvmField val EUR = PayCurrencyEnum(JsonField.of("EUR"))

            @JvmField val XBA = PayCurrencyEnum(JsonField.of("XBA"))

            @JvmField val XEU = PayCurrencyEnum(JsonField.of("XEU"))

            @JvmField val XBB = PayCurrencyEnum(JsonField.of("XBB"))

            @JvmField val XBC = PayCurrencyEnum(JsonField.of("XBC"))

            @JvmField val XBD = PayCurrencyEnum(JsonField.of("XBD"))

            @JvmField val FKP = PayCurrencyEnum(JsonField.of("FKP"))

            @JvmField val FJD = PayCurrencyEnum(JsonField.of("FJD"))

            @JvmField val FIM = PayCurrencyEnum(JsonField.of("FIM"))

            @JvmField val FRF = PayCurrencyEnum(JsonField.of("FRF"))

            @JvmField val XFO = PayCurrencyEnum(JsonField.of("XFO"))

            @JvmField val XFU = PayCurrencyEnum(JsonField.of("XFU"))

            @JvmField val GMD = PayCurrencyEnum(JsonField.of("GMD"))

            @JvmField val GEK = PayCurrencyEnum(JsonField.of("GEK"))

            @JvmField val GEL = PayCurrencyEnum(JsonField.of("GEL"))

            @JvmField val DEM = PayCurrencyEnum(JsonField.of("DEM"))

            @JvmField val GHS = PayCurrencyEnum(JsonField.of("GHS"))

            @JvmField val GHC = PayCurrencyEnum(JsonField.of("GHC"))

            @JvmField val GIP = PayCurrencyEnum(JsonField.of("GIP"))

            @JvmField val XAU = PayCurrencyEnum(JsonField.of("XAU"))

            @JvmField val GRD = PayCurrencyEnum(JsonField.of("GRD"))

            @JvmField val GTQ = PayCurrencyEnum(JsonField.of("GTQ"))

            @JvmField val GWP = PayCurrencyEnum(JsonField.of("GWP"))

            @JvmField val GNF = PayCurrencyEnum(JsonField.of("GNF"))

            @JvmField val GNS = PayCurrencyEnum(JsonField.of("GNS"))

            @JvmField val GYD = PayCurrencyEnum(JsonField.of("GYD"))

            @JvmField val HTG = PayCurrencyEnum(JsonField.of("HTG"))

            @JvmField val HNL = PayCurrencyEnum(JsonField.of("HNL"))

            @JvmField val HKD = PayCurrencyEnum(JsonField.of("HKD"))

            @JvmField val HUF = PayCurrencyEnum(JsonField.of("HUF"))

            @JvmField val IMP = PayCurrencyEnum(JsonField.of("IMP"))

            @JvmField val ISK = PayCurrencyEnum(JsonField.of("ISK"))

            @JvmField val ISJ = PayCurrencyEnum(JsonField.of("ISJ"))

            @JvmField val INR = PayCurrencyEnum(JsonField.of("INR"))

            @JvmField val IDR = PayCurrencyEnum(JsonField.of("IDR"))

            @JvmField val IRR = PayCurrencyEnum(JsonField.of("IRR"))

            @JvmField val IQD = PayCurrencyEnum(JsonField.of("IQD"))

            @JvmField val IEP = PayCurrencyEnum(JsonField.of("IEP"))

            @JvmField val ILS = PayCurrencyEnum(JsonField.of("ILS"))

            @JvmField val ILP = PayCurrencyEnum(JsonField.of("ILP"))

            @JvmField val ILR = PayCurrencyEnum(JsonField.of("ILR"))

            @JvmField val ITL = PayCurrencyEnum(JsonField.of("ITL"))

            @JvmField val JMD = PayCurrencyEnum(JsonField.of("JMD"))

            @JvmField val JPY = PayCurrencyEnum(JsonField.of("JPY"))

            @JvmField val JOD = PayCurrencyEnum(JsonField.of("JOD"))

            @JvmField val KZT = PayCurrencyEnum(JsonField.of("KZT"))

            @JvmField val KES = PayCurrencyEnum(JsonField.of("KES"))

            @JvmField val KWD = PayCurrencyEnum(JsonField.of("KWD"))

            @JvmField val KGS = PayCurrencyEnum(JsonField.of("KGS"))

            @JvmField val LAK = PayCurrencyEnum(JsonField.of("LAK"))

            @JvmField val LVL = PayCurrencyEnum(JsonField.of("LVL"))

            @JvmField val LVR = PayCurrencyEnum(JsonField.of("LVR"))

            @JvmField val LBP = PayCurrencyEnum(JsonField.of("LBP"))

            @JvmField val LSL = PayCurrencyEnum(JsonField.of("LSL"))

            @JvmField val LRD = PayCurrencyEnum(JsonField.of("LRD"))

            @JvmField val LYD = PayCurrencyEnum(JsonField.of("LYD"))

            @JvmField val LTL = PayCurrencyEnum(JsonField.of("LTL"))

            @JvmField val LTT = PayCurrencyEnum(JsonField.of("LTT"))

            @JvmField val LUL = PayCurrencyEnum(JsonField.of("LUL"))

            @JvmField val LUC = PayCurrencyEnum(JsonField.of("LUC"))

            @JvmField val LUF = PayCurrencyEnum(JsonField.of("LUF"))

            @JvmField val MOP = PayCurrencyEnum(JsonField.of("MOP"))

            @JvmField val MKD = PayCurrencyEnum(JsonField.of("MKD"))

            @JvmField val MKN = PayCurrencyEnum(JsonField.of("MKN"))

            @JvmField val MGA = PayCurrencyEnum(JsonField.of("MGA"))

            @JvmField val MGF = PayCurrencyEnum(JsonField.of("MGF"))

            @JvmField val MWK = PayCurrencyEnum(JsonField.of("MWK"))

            @JvmField val MYR = PayCurrencyEnum(JsonField.of("MYR"))

            @JvmField val MVR = PayCurrencyEnum(JsonField.of("MVR"))

            @JvmField val MVP = PayCurrencyEnum(JsonField.of("MVP"))

            @JvmField val MLF = PayCurrencyEnum(JsonField.of("MLF"))

            @JvmField val MTL = PayCurrencyEnum(JsonField.of("MTL"))

            @JvmField val MTP = PayCurrencyEnum(JsonField.of("MTP"))

            @JvmField val MRU = PayCurrencyEnum(JsonField.of("MRU"))

            @JvmField val MRO = PayCurrencyEnum(JsonField.of("MRO"))

            @JvmField val MUR = PayCurrencyEnum(JsonField.of("MUR"))

            @JvmField val MXV = PayCurrencyEnum(JsonField.of("MXV"))

            @JvmField val MXN = PayCurrencyEnum(JsonField.of("MXN"))

            @JvmField val MXP = PayCurrencyEnum(JsonField.of("MXP"))

            @JvmField val MDC = PayCurrencyEnum(JsonField.of("MDC"))

            @JvmField val MDL = PayCurrencyEnum(JsonField.of("MDL"))

            @JvmField val MCF = PayCurrencyEnum(JsonField.of("MCF"))

            @JvmField val MNT = PayCurrencyEnum(JsonField.of("MNT"))

            @JvmField val MAD = PayCurrencyEnum(JsonField.of("MAD"))

            @JvmField val MAF = PayCurrencyEnum(JsonField.of("MAF"))

            @JvmField val MZE = PayCurrencyEnum(JsonField.of("MZE"))

            @JvmField val MZN = PayCurrencyEnum(JsonField.of("MZN"))

            @JvmField val MZM = PayCurrencyEnum(JsonField.of("MZM"))

            @JvmField val MMK = PayCurrencyEnum(JsonField.of("MMK"))

            @JvmField val NAD = PayCurrencyEnum(JsonField.of("NAD"))

            @JvmField val NPR = PayCurrencyEnum(JsonField.of("NPR"))

            @JvmField val ANG = PayCurrencyEnum(JsonField.of("ANG"))

            @JvmField val TWD = PayCurrencyEnum(JsonField.of("TWD"))

            @JvmField val NZD = PayCurrencyEnum(JsonField.of("NZD"))

            @JvmField val NIO = PayCurrencyEnum(JsonField.of("NIO"))

            @JvmField val NIC = PayCurrencyEnum(JsonField.of("NIC"))

            @JvmField val NGN = PayCurrencyEnum(JsonField.of("NGN"))

            @JvmField val KPW = PayCurrencyEnum(JsonField.of("KPW"))

            @JvmField val NOK = PayCurrencyEnum(JsonField.of("NOK"))

            @JvmField val OMR = PayCurrencyEnum(JsonField.of("OMR"))

            @JvmField val PKR = PayCurrencyEnum(JsonField.of("PKR"))

            @JvmField val XPD = PayCurrencyEnum(JsonField.of("XPD"))

            @JvmField val PAB = PayCurrencyEnum(JsonField.of("PAB"))

            @JvmField val PGK = PayCurrencyEnum(JsonField.of("PGK"))

            @JvmField val PYG = PayCurrencyEnum(JsonField.of("PYG"))

            @JvmField val PEI = PayCurrencyEnum(JsonField.of("PEI"))

            @JvmField val PEN = PayCurrencyEnum(JsonField.of("PEN"))

            @JvmField val PES = PayCurrencyEnum(JsonField.of("PES"))

            @JvmField val PHP = PayCurrencyEnum(JsonField.of("PHP"))

            @JvmField val XPT = PayCurrencyEnum(JsonField.of("XPT"))

            @JvmField val PLN = PayCurrencyEnum(JsonField.of("PLN"))

            @JvmField val PLZ = PayCurrencyEnum(JsonField.of("PLZ"))

            @JvmField val PTE = PayCurrencyEnum(JsonField.of("PTE"))

            @JvmField val GWE = PayCurrencyEnum(JsonField.of("GWE"))

            @JvmField val QAR = PayCurrencyEnum(JsonField.of("QAR"))

            @JvmField val XRE = PayCurrencyEnum(JsonField.of("XRE"))

            @JvmField val RHD = PayCurrencyEnum(JsonField.of("RHD"))

            @JvmField val RON = PayCurrencyEnum(JsonField.of("RON"))

            @JvmField val ROL = PayCurrencyEnum(JsonField.of("ROL"))

            @JvmField val RUB = PayCurrencyEnum(JsonField.of("RUB"))

            @JvmField val RUR = PayCurrencyEnum(JsonField.of("RUR"))

            @JvmField val RWF = PayCurrencyEnum(JsonField.of("RWF"))

            @JvmField val SVC = PayCurrencyEnum(JsonField.of("SVC"))

            @JvmField val WST = PayCurrencyEnum(JsonField.of("WST"))

            @JvmField val SAR = PayCurrencyEnum(JsonField.of("SAR"))

            @JvmField val RSD = PayCurrencyEnum(JsonField.of("RSD"))

            @JvmField val CSD = PayCurrencyEnum(JsonField.of("CSD"))

            @JvmField val SCR = PayCurrencyEnum(JsonField.of("SCR"))

            @JvmField val SLL = PayCurrencyEnum(JsonField.of("SLL"))

            @JvmField val XAG = PayCurrencyEnum(JsonField.of("XAG"))

            @JvmField val SGD = PayCurrencyEnum(JsonField.of("SGD"))

            @JvmField val SKK = PayCurrencyEnum(JsonField.of("SKK"))

            @JvmField val SIT = PayCurrencyEnum(JsonField.of("SIT"))

            @JvmField val SBD = PayCurrencyEnum(JsonField.of("SBD"))

            @JvmField val SOS = PayCurrencyEnum(JsonField.of("SOS"))

            @JvmField val ZAR = PayCurrencyEnum(JsonField.of("ZAR"))

            @JvmField val ZAL = PayCurrencyEnum(JsonField.of("ZAL"))

            @JvmField val KRH = PayCurrencyEnum(JsonField.of("KRH"))

            @JvmField val KRW = PayCurrencyEnum(JsonField.of("KRW"))

            @JvmField val KRO = PayCurrencyEnum(JsonField.of("KRO"))

            @JvmField val SSP = PayCurrencyEnum(JsonField.of("SSP"))

            @JvmField val SUR = PayCurrencyEnum(JsonField.of("SUR"))

            @JvmField val ESP = PayCurrencyEnum(JsonField.of("ESP"))

            @JvmField val ESA = PayCurrencyEnum(JsonField.of("ESA"))

            @JvmField val ESB = PayCurrencyEnum(JsonField.of("ESB"))

            @JvmField val XDR = PayCurrencyEnum(JsonField.of("XDR"))

            @JvmField val LKR = PayCurrencyEnum(JsonField.of("LKR"))

            @JvmField val SHP = PayCurrencyEnum(JsonField.of("SHP"))

            @JvmField val XSU = PayCurrencyEnum(JsonField.of("XSU"))

            @JvmField val SDD = PayCurrencyEnum(JsonField.of("SDD"))

            @JvmField val SDG = PayCurrencyEnum(JsonField.of("SDG"))

            @JvmField val SDP = PayCurrencyEnum(JsonField.of("SDP"))

            @JvmField val SRD = PayCurrencyEnum(JsonField.of("SRD"))

            @JvmField val SRG = PayCurrencyEnum(JsonField.of("SRG"))

            @JvmField val SZL = PayCurrencyEnum(JsonField.of("SZL"))

            @JvmField val SEK = PayCurrencyEnum(JsonField.of("SEK"))

            @JvmField val CHF = PayCurrencyEnum(JsonField.of("CHF"))

            @JvmField val SYP = PayCurrencyEnum(JsonField.of("SYP"))

            @JvmField val STN = PayCurrencyEnum(JsonField.of("STN"))

            @JvmField val STD = PayCurrencyEnum(JsonField.of("STD"))

            @JvmField val TVD = PayCurrencyEnum(JsonField.of("TVD"))

            @JvmField val TJR = PayCurrencyEnum(JsonField.of("TJR"))

            @JvmField val TJS = PayCurrencyEnum(JsonField.of("TJS"))

            @JvmField val TZS = PayCurrencyEnum(JsonField.of("TZS"))

            @JvmField val XTS = PayCurrencyEnum(JsonField.of("XTS"))

            @JvmField val THB = PayCurrencyEnum(JsonField.of("THB"))

            @JvmField val XXX = PayCurrencyEnum(JsonField.of("XXX"))

            @JvmField val TPE = PayCurrencyEnum(JsonField.of("TPE"))

            @JvmField val TOP = PayCurrencyEnum(JsonField.of("TOP"))

            @JvmField val TTD = PayCurrencyEnum(JsonField.of("TTD"))

            @JvmField val TND = PayCurrencyEnum(JsonField.of("TND"))

            @JvmField val TRY = PayCurrencyEnum(JsonField.of("TRY"))

            @JvmField val TRL = PayCurrencyEnum(JsonField.of("TRL"))

            @JvmField val TMT = PayCurrencyEnum(JsonField.of("TMT"))

            @JvmField val TMM = PayCurrencyEnum(JsonField.of("TMM"))

            @JvmField val USD = PayCurrencyEnum(JsonField.of("USD"))

            @JvmField val USN = PayCurrencyEnum(JsonField.of("USN"))

            @JvmField val USS = PayCurrencyEnum(JsonField.of("USS"))

            @JvmField val UGX = PayCurrencyEnum(JsonField.of("UGX"))

            @JvmField val UGS = PayCurrencyEnum(JsonField.of("UGS"))

            @JvmField val UAH = PayCurrencyEnum(JsonField.of("UAH"))

            @JvmField val UAK = PayCurrencyEnum(JsonField.of("UAK"))

            @JvmField val AED = PayCurrencyEnum(JsonField.of("AED"))

            @JvmField val UYW = PayCurrencyEnum(JsonField.of("UYW"))

            @JvmField val UYU = PayCurrencyEnum(JsonField.of("UYU"))

            @JvmField val UYP = PayCurrencyEnum(JsonField.of("UYP"))

            @JvmField val UYI = PayCurrencyEnum(JsonField.of("UYI"))

            @JvmField val UZS = PayCurrencyEnum(JsonField.of("UZS"))

            @JvmField val VUV = PayCurrencyEnum(JsonField.of("VUV"))

            @JvmField val VES = PayCurrencyEnum(JsonField.of("VES"))

            @JvmField val VEB = PayCurrencyEnum(JsonField.of("VEB"))

            @JvmField val VEF = PayCurrencyEnum(JsonField.of("VEF"))

            @JvmField val VND = PayCurrencyEnum(JsonField.of("VND"))

            @JvmField val VNN = PayCurrencyEnum(JsonField.of("VNN"))

            @JvmField val CHE = PayCurrencyEnum(JsonField.of("CHE"))

            @JvmField val CHW = PayCurrencyEnum(JsonField.of("CHW"))

            @JvmField val XOF = PayCurrencyEnum(JsonField.of("XOF"))

            @JvmField val YDD = PayCurrencyEnum(JsonField.of("YDD"))

            @JvmField val YER = PayCurrencyEnum(JsonField.of("YER"))

            @JvmField val YUN = PayCurrencyEnum(JsonField.of("YUN"))

            @JvmField val YUD = PayCurrencyEnum(JsonField.of("YUD"))

            @JvmField val YUM = PayCurrencyEnum(JsonField.of("YUM"))

            @JvmField val YUR = PayCurrencyEnum(JsonField.of("YUR"))

            @JvmField val ZWN = PayCurrencyEnum(JsonField.of("ZWN"))

            @JvmField val ZRN = PayCurrencyEnum(JsonField.of("ZRN"))

            @JvmField val ZRZ = PayCurrencyEnum(JsonField.of("ZRZ"))

            @JvmField val ZMW = PayCurrencyEnum(JsonField.of("ZMW"))

            @JvmField val ZMK = PayCurrencyEnum(JsonField.of("ZMK"))

            @JvmField val ZWD = PayCurrencyEnum(JsonField.of("ZWD"))

            @JvmField val ZWR = PayCurrencyEnum(JsonField.of("ZWR"))

            @JvmField val ZWL = PayCurrencyEnum(JsonField.of("ZWL"))

            @JvmStatic fun of(value: String) = PayCurrencyEnum(JsonField.of(value))
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
                else -> throw MergeInvalidDataException("Unknown PayCurrencyEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class FlsaStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FlsaStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val EXEMPT = FlsaStatusEnum(JsonField.of("EXEMPT"))

            @JvmField val SALARIED_NONEXEMPT = FlsaStatusEnum(JsonField.of("SALARIED_NONEXEMPT"))

            @JvmField val NONEXEMPT = FlsaStatusEnum(JsonField.of("NONEXEMPT"))

            @JvmField val OWNER = FlsaStatusEnum(JsonField.of("OWNER"))

            @JvmStatic fun of(value: String) = FlsaStatusEnum(JsonField.of(value))
        }

        enum class Known {
            EXEMPT,
            SALARIED_NONEXEMPT,
            NONEXEMPT,
            OWNER,
        }

        enum class Value {
            EXEMPT,
            SALARIED_NONEXEMPT,
            NONEXEMPT,
            OWNER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EXEMPT -> Value.EXEMPT
                SALARIED_NONEXEMPT -> Value.SALARIED_NONEXEMPT
                NONEXEMPT -> Value.NONEXEMPT
                OWNER -> Value.OWNER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EXEMPT -> Known.EXEMPT
                SALARIED_NONEXEMPT -> Known.SALARIED_NONEXEMPT
                NONEXEMPT -> Known.NONEXEMPT
                OWNER -> Known.OWNER
                else -> throw MergeInvalidDataException("Unknown FlsaStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class EmploymentTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EmploymentTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val FULL_TIME = EmploymentTypeEnum(JsonField.of("FULL_TIME"))

            @JvmField val PART_TIME = EmploymentTypeEnum(JsonField.of("PART_TIME"))

            @JvmField val INTERN = EmploymentTypeEnum(JsonField.of("INTERN"))

            @JvmField val CONTRACTOR = EmploymentTypeEnum(JsonField.of("CONTRACTOR"))

            @JvmField val FREELANCE = EmploymentTypeEnum(JsonField.of("FREELANCE"))

            @JvmStatic fun of(value: String) = EmploymentTypeEnum(JsonField.of(value))
        }

        enum class Known {
            FULL_TIME,
            PART_TIME,
            INTERN,
            CONTRACTOR,
            FREELANCE,
        }

        enum class Value {
            FULL_TIME,
            PART_TIME,
            INTERN,
            CONTRACTOR,
            FREELANCE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FULL_TIME -> Value.FULL_TIME
                PART_TIME -> Value.PART_TIME
                INTERN -> Value.INTERN
                CONTRACTOR -> Value.CONTRACTOR
                FREELANCE -> Value.FREELANCE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FULL_TIME -> Known.FULL_TIME
                PART_TIME -> Known.PART_TIME
                INTERN -> Known.INTERN
                CONTRACTOR -> Known.CONTRACTOR
                FREELANCE -> Known.FREELANCE
                else -> throw MergeInvalidDataException("Unknown EmploymentTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
