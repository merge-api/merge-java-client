package dev.merge.api.models

import com.fasterxml.jackson.annotation.JsonCreator
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.errors.MergeInvalidDataException

class Country
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Country && this.value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()

    companion object {

        @JvmField val AF = Country(JsonField.of("AF"))

        @JvmField val AX = Country(JsonField.of("AX"))

        @JvmField val AL = Country(JsonField.of("AL"))

        @JvmField val DZ = Country(JsonField.of("DZ"))

        @JvmField val AS = Country(JsonField.of("AS"))

        @JvmField val AD = Country(JsonField.of("AD"))

        @JvmField val AO = Country(JsonField.of("AO"))

        @JvmField val AI = Country(JsonField.of("AI"))

        @JvmField val AQ = Country(JsonField.of("AQ"))

        @JvmField val AG = Country(JsonField.of("AG"))

        @JvmField val AR = Country(JsonField.of("AR"))

        @JvmField val AM = Country(JsonField.of("AM"))

        @JvmField val AW = Country(JsonField.of("AW"))

        @JvmField val AU = Country(JsonField.of("AU"))

        @JvmField val AT = Country(JsonField.of("AT"))

        @JvmField val AZ = Country(JsonField.of("AZ"))

        @JvmField val BS = Country(JsonField.of("BS"))

        @JvmField val BH = Country(JsonField.of("BH"))

        @JvmField val BD = Country(JsonField.of("BD"))

        @JvmField val BB = Country(JsonField.of("BB"))

        @JvmField val BY = Country(JsonField.of("BY"))

        @JvmField val BE = Country(JsonField.of("BE"))

        @JvmField val BZ = Country(JsonField.of("BZ"))

        @JvmField val BJ = Country(JsonField.of("BJ"))

        @JvmField val BM = Country(JsonField.of("BM"))

        @JvmField val BT = Country(JsonField.of("BT"))

        @JvmField val BO = Country(JsonField.of("BO"))

        @JvmField val BQ = Country(JsonField.of("BQ"))

        @JvmField val BA = Country(JsonField.of("BA"))

        @JvmField val BW = Country(JsonField.of("BW"))

        @JvmField val BV = Country(JsonField.of("BV"))

        @JvmField val BR = Country(JsonField.of("BR"))

        @JvmField val IO = Country(JsonField.of("IO"))

        @JvmField val BN = Country(JsonField.of("BN"))

        @JvmField val BG = Country(JsonField.of("BG"))

        @JvmField val BF = Country(JsonField.of("BF"))

        @JvmField val BI = Country(JsonField.of("BI"))

        @JvmField val CV = Country(JsonField.of("CV"))

        @JvmField val KH = Country(JsonField.of("KH"))

        @JvmField val CM = Country(JsonField.of("CM"))

        @JvmField val CA = Country(JsonField.of("CA"))

        @JvmField val KY = Country(JsonField.of("KY"))

        @JvmField val CF = Country(JsonField.of("CF"))

        @JvmField val TD = Country(JsonField.of("TD"))

        @JvmField val CL = Country(JsonField.of("CL"))

        @JvmField val CN = Country(JsonField.of("CN"))

        @JvmField val CX = Country(JsonField.of("CX"))

        @JvmField val CC = Country(JsonField.of("CC"))

        @JvmField val CO = Country(JsonField.of("CO"))

        @JvmField val KM = Country(JsonField.of("KM"))

        @JvmField val CG = Country(JsonField.of("CG"))

        @JvmField val CD = Country(JsonField.of("CD"))

        @JvmField val CK = Country(JsonField.of("CK"))

        @JvmField val CR = Country(JsonField.of("CR"))

        @JvmField val CI = Country(JsonField.of("CI"))

        @JvmField val HR = Country(JsonField.of("HR"))

        @JvmField val CU = Country(JsonField.of("CU"))

        @JvmField val CW = Country(JsonField.of("CW"))

        @JvmField val CY = Country(JsonField.of("CY"))

        @JvmField val CZ = Country(JsonField.of("CZ"))

        @JvmField val DK = Country(JsonField.of("DK"))

        @JvmField val DJ = Country(JsonField.of("DJ"))

        @JvmField val DM = Country(JsonField.of("DM"))

        @JvmField val DO = Country(JsonField.of("DO"))

        @JvmField val EC = Country(JsonField.of("EC"))

        @JvmField val EG = Country(JsonField.of("EG"))

        @JvmField val SV = Country(JsonField.of("SV"))

        @JvmField val GQ = Country(JsonField.of("GQ"))

        @JvmField val ER = Country(JsonField.of("ER"))

        @JvmField val EE = Country(JsonField.of("EE"))

        @JvmField val SZ = Country(JsonField.of("SZ"))

        @JvmField val ET = Country(JsonField.of("ET"))

        @JvmField val FK = Country(JsonField.of("FK"))

        @JvmField val FO = Country(JsonField.of("FO"))

        @JvmField val FJ = Country(JsonField.of("FJ"))

        @JvmField val FI = Country(JsonField.of("FI"))

        @JvmField val FR = Country(JsonField.of("FR"))

        @JvmField val GF = Country(JsonField.of("GF"))

        @JvmField val PF = Country(JsonField.of("PF"))

        @JvmField val TF = Country(JsonField.of("TF"))

        @JvmField val GA = Country(JsonField.of("GA"))

        @JvmField val GM = Country(JsonField.of("GM"))

        @JvmField val GE = Country(JsonField.of("GE"))

        @JvmField val DE = Country(JsonField.of("DE"))

        @JvmField val GH = Country(JsonField.of("GH"))

        @JvmField val GI = Country(JsonField.of("GI"))

        @JvmField val GR = Country(JsonField.of("GR"))

        @JvmField val GL = Country(JsonField.of("GL"))

        @JvmField val GD = Country(JsonField.of("GD"))

        @JvmField val GP = Country(JsonField.of("GP"))

        @JvmField val GU = Country(JsonField.of("GU"))

        @JvmField val GT = Country(JsonField.of("GT"))

        @JvmField val GG = Country(JsonField.of("GG"))

        @JvmField val GN = Country(JsonField.of("GN"))

        @JvmField val GW = Country(JsonField.of("GW"))

        @JvmField val GY = Country(JsonField.of("GY"))

        @JvmField val HT = Country(JsonField.of("HT"))

        @JvmField val HM = Country(JsonField.of("HM"))

        @JvmField val VA = Country(JsonField.of("VA"))

        @JvmField val HN = Country(JsonField.of("HN"))

        @JvmField val HK = Country(JsonField.of("HK"))

        @JvmField val HU = Country(JsonField.of("HU"))

        @JvmField val IS = Country(JsonField.of("IS"))

        @JvmField val IN = Country(JsonField.of("IN"))

        @JvmField val ID = Country(JsonField.of("ID"))

        @JvmField val IR = Country(JsonField.of("IR"))

        @JvmField val IQ = Country(JsonField.of("IQ"))

        @JvmField val IE = Country(JsonField.of("IE"))

        @JvmField val IM = Country(JsonField.of("IM"))

        @JvmField val IL = Country(JsonField.of("IL"))

        @JvmField val IT = Country(JsonField.of("IT"))

        @JvmField val JM = Country(JsonField.of("JM"))

        @JvmField val JP = Country(JsonField.of("JP"))

        @JvmField val JE = Country(JsonField.of("JE"))

        @JvmField val JO = Country(JsonField.of("JO"))

        @JvmField val KZ = Country(JsonField.of("KZ"))

        @JvmField val KE = Country(JsonField.of("KE"))

        @JvmField val KI = Country(JsonField.of("KI"))

        @JvmField val KW = Country(JsonField.of("KW"))

        @JvmField val KG = Country(JsonField.of("KG"))

        @JvmField val LA = Country(JsonField.of("LA"))

        @JvmField val LV = Country(JsonField.of("LV"))

        @JvmField val LB = Country(JsonField.of("LB"))

        @JvmField val LS = Country(JsonField.of("LS"))

        @JvmField val LR = Country(JsonField.of("LR"))

        @JvmField val LY = Country(JsonField.of("LY"))

        @JvmField val LI = Country(JsonField.of("LI"))

        @JvmField val LT = Country(JsonField.of("LT"))

        @JvmField val LU = Country(JsonField.of("LU"))

        @JvmField val MO = Country(JsonField.of("MO"))

        @JvmField val MG = Country(JsonField.of("MG"))

        @JvmField val MW = Country(JsonField.of("MW"))

        @JvmField val MY = Country(JsonField.of("MY"))

        @JvmField val MV = Country(JsonField.of("MV"))

        @JvmField val ML = Country(JsonField.of("ML"))

        @JvmField val MT = Country(JsonField.of("MT"))

        @JvmField val MH = Country(JsonField.of("MH"))

        @JvmField val MQ = Country(JsonField.of("MQ"))

        @JvmField val MR = Country(JsonField.of("MR"))

        @JvmField val MU = Country(JsonField.of("MU"))

        @JvmField val YT = Country(JsonField.of("YT"))

        @JvmField val MX = Country(JsonField.of("MX"))

        @JvmField val FM = Country(JsonField.of("FM"))

        @JvmField val MD = Country(JsonField.of("MD"))

        @JvmField val MC = Country(JsonField.of("MC"))

        @JvmField val MN = Country(JsonField.of("MN"))

        @JvmField val ME = Country(JsonField.of("ME"))

        @JvmField val MS = Country(JsonField.of("MS"))

        @JvmField val MA = Country(JsonField.of("MA"))

        @JvmField val MZ = Country(JsonField.of("MZ"))

        @JvmField val MM = Country(JsonField.of("MM"))

        @JvmField val NA = Country(JsonField.of("NA"))

        @JvmField val NR = Country(JsonField.of("NR"))

        @JvmField val NP = Country(JsonField.of("NP"))

        @JvmField val NL = Country(JsonField.of("NL"))

        @JvmField val NC = Country(JsonField.of("NC"))

        @JvmField val NZ = Country(JsonField.of("NZ"))

        @JvmField val NI = Country(JsonField.of("NI"))

        @JvmField val NE = Country(JsonField.of("NE"))

        @JvmField val NG = Country(JsonField.of("NG"))

        @JvmField val NU = Country(JsonField.of("NU"))

        @JvmField val NF = Country(JsonField.of("NF"))

        @JvmField val KP = Country(JsonField.of("KP"))

        @JvmField val MK = Country(JsonField.of("MK"))

        @JvmField val MP = Country(JsonField.of("MP"))

        @JvmField val NO = Country(JsonField.of("NO"))

        @JvmField val OM = Country(JsonField.of("OM"))

        @JvmField val PK = Country(JsonField.of("PK"))

        @JvmField val PW = Country(JsonField.of("PW"))

        @JvmField val PS = Country(JsonField.of("PS"))

        @JvmField val PA = Country(JsonField.of("PA"))

        @JvmField val PG = Country(JsonField.of("PG"))

        @JvmField val PY = Country(JsonField.of("PY"))

        @JvmField val PE = Country(JsonField.of("PE"))

        @JvmField val PH = Country(JsonField.of("PH"))

        @JvmField val PN = Country(JsonField.of("PN"))

        @JvmField val PL = Country(JsonField.of("PL"))

        @JvmField val PT = Country(JsonField.of("PT"))

        @JvmField val PR = Country(JsonField.of("PR"))

        @JvmField val QA = Country(JsonField.of("QA"))

        @JvmField val RE = Country(JsonField.of("RE"))

        @JvmField val RO = Country(JsonField.of("RO"))

        @JvmField val RU = Country(JsonField.of("RU"))

        @JvmField val RW = Country(JsonField.of("RW"))

        @JvmField val BL = Country(JsonField.of("BL"))

        @JvmField val SH = Country(JsonField.of("SH"))

        @JvmField val KN = Country(JsonField.of("KN"))

        @JvmField val LC = Country(JsonField.of("LC"))

        @JvmField val MF = Country(JsonField.of("MF"))

        @JvmField val PM = Country(JsonField.of("PM"))

        @JvmField val VC = Country(JsonField.of("VC"))

        @JvmField val WS = Country(JsonField.of("WS"))

        @JvmField val SM = Country(JsonField.of("SM"))

        @JvmField val ST = Country(JsonField.of("ST"))

        @JvmField val SA = Country(JsonField.of("SA"))

        @JvmField val SN = Country(JsonField.of("SN"))

        @JvmField val RS = Country(JsonField.of("RS"))

        @JvmField val SC = Country(JsonField.of("SC"))

        @JvmField val SL = Country(JsonField.of("SL"))

        @JvmField val SG = Country(JsonField.of("SG"))

        @JvmField val SX = Country(JsonField.of("SX"))

        @JvmField val SK = Country(JsonField.of("SK"))

        @JvmField val SI = Country(JsonField.of("SI"))

        @JvmField val SB = Country(JsonField.of("SB"))

        @JvmField val SO = Country(JsonField.of("SO"))

        @JvmField val ZA = Country(JsonField.of("ZA"))

        @JvmField val GS = Country(JsonField.of("GS"))

        @JvmField val KR = Country(JsonField.of("KR"))

        @JvmField val SS = Country(JsonField.of("SS"))

        @JvmField val ES = Country(JsonField.of("ES"))

        @JvmField val LK = Country(JsonField.of("LK"))

        @JvmField val SD = Country(JsonField.of("SD"))

        @JvmField val SR = Country(JsonField.of("SR"))

        @JvmField val SJ = Country(JsonField.of("SJ"))

        @JvmField val SE = Country(JsonField.of("SE"))

        @JvmField val CH = Country(JsonField.of("CH"))

        @JvmField val SY = Country(JsonField.of("SY"))

        @JvmField val TW = Country(JsonField.of("TW"))

        @JvmField val TJ = Country(JsonField.of("TJ"))

        @JvmField val TZ = Country(JsonField.of("TZ"))

        @JvmField val TH = Country(JsonField.of("TH"))

        @JvmField val TL = Country(JsonField.of("TL"))

        @JvmField val TG = Country(JsonField.of("TG"))

        @JvmField val TK = Country(JsonField.of("TK"))

        @JvmField val TO = Country(JsonField.of("TO"))

        @JvmField val TT = Country(JsonField.of("TT"))

        @JvmField val TN = Country(JsonField.of("TN"))

        @JvmField val TR = Country(JsonField.of("TR"))

        @JvmField val TM = Country(JsonField.of("TM"))

        @JvmField val TC = Country(JsonField.of("TC"))

        @JvmField val TV = Country(JsonField.of("TV"))

        @JvmField val UG = Country(JsonField.of("UG"))

        @JvmField val UA = Country(JsonField.of("UA"))

        @JvmField val AE = Country(JsonField.of("AE"))

        @JvmField val GB = Country(JsonField.of("GB"))

        @JvmField val UM = Country(JsonField.of("UM"))

        @JvmField val US = Country(JsonField.of("US"))

        @JvmField val UY = Country(JsonField.of("UY"))

        @JvmField val UZ = Country(JsonField.of("UZ"))

        @JvmField val VU = Country(JsonField.of("VU"))

        @JvmField val VE = Country(JsonField.of("VE"))

        @JvmField val VN = Country(JsonField.of("VN"))

        @JvmField val VG = Country(JsonField.of("VG"))

        @JvmField val VI = Country(JsonField.of("VI"))

        @JvmField val WF = Country(JsonField.of("WF"))

        @JvmField val EH = Country(JsonField.of("EH"))

        @JvmField val YE = Country(JsonField.of("YE"))

        @JvmField val ZM = Country(JsonField.of("ZM"))

        @JvmField val ZW = Country(JsonField.of("ZW"))

        @JvmStatic fun of(value: String) = Country(JsonField.of(value))
    }

    enum class Known {
        AF,
        AX,
        AL,
        DZ,
        AS,
        AD,
        AO,
        AI,
        AQ,
        AG,
        AR,
        AM,
        AW,
        AU,
        AT,
        AZ,
        BS,
        BH,
        BD,
        BB,
        BY,
        BE,
        BZ,
        BJ,
        BM,
        BT,
        BO,
        BQ,
        BA,
        BW,
        BV,
        BR,
        IO,
        BN,
        BG,
        BF,
        BI,
        CV,
        KH,
        CM,
        CA,
        KY,
        CF,
        TD,
        CL,
        CN,
        CX,
        CC,
        CO,
        KM,
        CG,
        CD,
        CK,
        CR,
        CI,
        HR,
        CU,
        CW,
        CY,
        CZ,
        DK,
        DJ,
        DM,
        DO,
        EC,
        EG,
        SV,
        GQ,
        ER,
        EE,
        SZ,
        ET,
        FK,
        FO,
        FJ,
        FI,
        FR,
        GF,
        PF,
        TF,
        GA,
        GM,
        GE,
        DE,
        GH,
        GI,
        GR,
        GL,
        GD,
        GP,
        GU,
        GT,
        GG,
        GN,
        GW,
        GY,
        HT,
        HM,
        VA,
        HN,
        HK,
        HU,
        IS,
        IN,
        ID,
        IR,
        IQ,
        IE,
        IM,
        IL,
        IT,
        JM,
        JP,
        JE,
        JO,
        KZ,
        KE,
        KI,
        KW,
        KG,
        LA,
        LV,
        LB,
        LS,
        LR,
        LY,
        LI,
        LT,
        LU,
        MO,
        MG,
        MW,
        MY,
        MV,
        ML,
        MT,
        MH,
        MQ,
        MR,
        MU,
        YT,
        MX,
        FM,
        MD,
        MC,
        MN,
        ME,
        MS,
        MA,
        MZ,
        MM,
        NA,
        NR,
        NP,
        NL,
        NC,
        NZ,
        NI,
        NE,
        NG,
        NU,
        NF,
        KP,
        MK,
        MP,
        NO,
        OM,
        PK,
        PW,
        PS,
        PA,
        PG,
        PY,
        PE,
        PH,
        PN,
        PL,
        PT,
        PR,
        QA,
        RE,
        RO,
        RU,
        RW,
        BL,
        SH,
        KN,
        LC,
        MF,
        PM,
        VC,
        WS,
        SM,
        ST,
        SA,
        SN,
        RS,
        SC,
        SL,
        SG,
        SX,
        SK,
        SI,
        SB,
        SO,
        ZA,
        GS,
        KR,
        SS,
        ES,
        LK,
        SD,
        SR,
        SJ,
        SE,
        CH,
        SY,
        TW,
        TJ,
        TZ,
        TH,
        TL,
        TG,
        TK,
        TO,
        TT,
        TN,
        TR,
        TM,
        TC,
        TV,
        UG,
        UA,
        AE,
        GB,
        UM,
        US,
        UY,
        UZ,
        VU,
        VE,
        VN,
        VG,
        VI,
        WF,
        EH,
        YE,
        ZM,
        ZW,
    }

    enum class Value {
        AF,
        AX,
        AL,
        DZ,
        AS,
        AD,
        AO,
        AI,
        AQ,
        AG,
        AR,
        AM,
        AW,
        AU,
        AT,
        AZ,
        BS,
        BH,
        BD,
        BB,
        BY,
        BE,
        BZ,
        BJ,
        BM,
        BT,
        BO,
        BQ,
        BA,
        BW,
        BV,
        BR,
        IO,
        BN,
        BG,
        BF,
        BI,
        CV,
        KH,
        CM,
        CA,
        KY,
        CF,
        TD,
        CL,
        CN,
        CX,
        CC,
        CO,
        KM,
        CG,
        CD,
        CK,
        CR,
        CI,
        HR,
        CU,
        CW,
        CY,
        CZ,
        DK,
        DJ,
        DM,
        DO,
        EC,
        EG,
        SV,
        GQ,
        ER,
        EE,
        SZ,
        ET,
        FK,
        FO,
        FJ,
        FI,
        FR,
        GF,
        PF,
        TF,
        GA,
        GM,
        GE,
        DE,
        GH,
        GI,
        GR,
        GL,
        GD,
        GP,
        GU,
        GT,
        GG,
        GN,
        GW,
        GY,
        HT,
        HM,
        VA,
        HN,
        HK,
        HU,
        IS,
        IN,
        ID,
        IR,
        IQ,
        IE,
        IM,
        IL,
        IT,
        JM,
        JP,
        JE,
        JO,
        KZ,
        KE,
        KI,
        KW,
        KG,
        LA,
        LV,
        LB,
        LS,
        LR,
        LY,
        LI,
        LT,
        LU,
        MO,
        MG,
        MW,
        MY,
        MV,
        ML,
        MT,
        MH,
        MQ,
        MR,
        MU,
        YT,
        MX,
        FM,
        MD,
        MC,
        MN,
        ME,
        MS,
        MA,
        MZ,
        MM,
        NA,
        NR,
        NP,
        NL,
        NC,
        NZ,
        NI,
        NE,
        NG,
        NU,
        NF,
        KP,
        MK,
        MP,
        NO,
        OM,
        PK,
        PW,
        PS,
        PA,
        PG,
        PY,
        PE,
        PH,
        PN,
        PL,
        PT,
        PR,
        QA,
        RE,
        RO,
        RU,
        RW,
        BL,
        SH,
        KN,
        LC,
        MF,
        PM,
        VC,
        WS,
        SM,
        ST,
        SA,
        SN,
        RS,
        SC,
        SL,
        SG,
        SX,
        SK,
        SI,
        SB,
        SO,
        ZA,
        GS,
        KR,
        SS,
        ES,
        LK,
        SD,
        SR,
        SJ,
        SE,
        CH,
        SY,
        TW,
        TJ,
        TZ,
        TH,
        TL,
        TG,
        TK,
        TO,
        TT,
        TN,
        TR,
        TM,
        TC,
        TV,
        UG,
        UA,
        AE,
        GB,
        UM,
        US,
        UY,
        UZ,
        VU,
        VE,
        VN,
        VG,
        VI,
        WF,
        EH,
        YE,
        ZM,
        ZW,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            AF -> Value.AF
            AX -> Value.AX
            AL -> Value.AL
            DZ -> Value.DZ
            AS -> Value.AS
            AD -> Value.AD
            AO -> Value.AO
            AI -> Value.AI
            AQ -> Value.AQ
            AG -> Value.AG
            AR -> Value.AR
            AM -> Value.AM
            AW -> Value.AW
            AU -> Value.AU
            AT -> Value.AT
            AZ -> Value.AZ
            BS -> Value.BS
            BH -> Value.BH
            BD -> Value.BD
            BB -> Value.BB
            BY -> Value.BY
            BE -> Value.BE
            BZ -> Value.BZ
            BJ -> Value.BJ
            BM -> Value.BM
            BT -> Value.BT
            BO -> Value.BO
            BQ -> Value.BQ
            BA -> Value.BA
            BW -> Value.BW
            BV -> Value.BV
            BR -> Value.BR
            IO -> Value.IO
            BN -> Value.BN
            BG -> Value.BG
            BF -> Value.BF
            BI -> Value.BI
            CV -> Value.CV
            KH -> Value.KH
            CM -> Value.CM
            CA -> Value.CA
            KY -> Value.KY
            CF -> Value.CF
            TD -> Value.TD
            CL -> Value.CL
            CN -> Value.CN
            CX -> Value.CX
            CC -> Value.CC
            CO -> Value.CO
            KM -> Value.KM
            CG -> Value.CG
            CD -> Value.CD
            CK -> Value.CK
            CR -> Value.CR
            CI -> Value.CI
            HR -> Value.HR
            CU -> Value.CU
            CW -> Value.CW
            CY -> Value.CY
            CZ -> Value.CZ
            DK -> Value.DK
            DJ -> Value.DJ
            DM -> Value.DM
            DO -> Value.DO
            EC -> Value.EC
            EG -> Value.EG
            SV -> Value.SV
            GQ -> Value.GQ
            ER -> Value.ER
            EE -> Value.EE
            SZ -> Value.SZ
            ET -> Value.ET
            FK -> Value.FK
            FO -> Value.FO
            FJ -> Value.FJ
            FI -> Value.FI
            FR -> Value.FR
            GF -> Value.GF
            PF -> Value.PF
            TF -> Value.TF
            GA -> Value.GA
            GM -> Value.GM
            GE -> Value.GE
            DE -> Value.DE
            GH -> Value.GH
            GI -> Value.GI
            GR -> Value.GR
            GL -> Value.GL
            GD -> Value.GD
            GP -> Value.GP
            GU -> Value.GU
            GT -> Value.GT
            GG -> Value.GG
            GN -> Value.GN
            GW -> Value.GW
            GY -> Value.GY
            HT -> Value.HT
            HM -> Value.HM
            VA -> Value.VA
            HN -> Value.HN
            HK -> Value.HK
            HU -> Value.HU
            IS -> Value.IS
            IN -> Value.IN
            ID -> Value.ID
            IR -> Value.IR
            IQ -> Value.IQ
            IE -> Value.IE
            IM -> Value.IM
            IL -> Value.IL
            IT -> Value.IT
            JM -> Value.JM
            JP -> Value.JP
            JE -> Value.JE
            JO -> Value.JO
            KZ -> Value.KZ
            KE -> Value.KE
            KI -> Value.KI
            KW -> Value.KW
            KG -> Value.KG
            LA -> Value.LA
            LV -> Value.LV
            LB -> Value.LB
            LS -> Value.LS
            LR -> Value.LR
            LY -> Value.LY
            LI -> Value.LI
            LT -> Value.LT
            LU -> Value.LU
            MO -> Value.MO
            MG -> Value.MG
            MW -> Value.MW
            MY -> Value.MY
            MV -> Value.MV
            ML -> Value.ML
            MT -> Value.MT
            MH -> Value.MH
            MQ -> Value.MQ
            MR -> Value.MR
            MU -> Value.MU
            YT -> Value.YT
            MX -> Value.MX
            FM -> Value.FM
            MD -> Value.MD
            MC -> Value.MC
            MN -> Value.MN
            ME -> Value.ME
            MS -> Value.MS
            MA -> Value.MA
            MZ -> Value.MZ
            MM -> Value.MM
            NA -> Value.NA
            NR -> Value.NR
            NP -> Value.NP
            NL -> Value.NL
            NC -> Value.NC
            NZ -> Value.NZ
            NI -> Value.NI
            NE -> Value.NE
            NG -> Value.NG
            NU -> Value.NU
            NF -> Value.NF
            KP -> Value.KP
            MK -> Value.MK
            MP -> Value.MP
            NO -> Value.NO
            OM -> Value.OM
            PK -> Value.PK
            PW -> Value.PW
            PS -> Value.PS
            PA -> Value.PA
            PG -> Value.PG
            PY -> Value.PY
            PE -> Value.PE
            PH -> Value.PH
            PN -> Value.PN
            PL -> Value.PL
            PT -> Value.PT
            PR -> Value.PR
            QA -> Value.QA
            RE -> Value.RE
            RO -> Value.RO
            RU -> Value.RU
            RW -> Value.RW
            BL -> Value.BL
            SH -> Value.SH
            KN -> Value.KN
            LC -> Value.LC
            MF -> Value.MF
            PM -> Value.PM
            VC -> Value.VC
            WS -> Value.WS
            SM -> Value.SM
            ST -> Value.ST
            SA -> Value.SA
            SN -> Value.SN
            RS -> Value.RS
            SC -> Value.SC
            SL -> Value.SL
            SG -> Value.SG
            SX -> Value.SX
            SK -> Value.SK
            SI -> Value.SI
            SB -> Value.SB
            SO -> Value.SO
            ZA -> Value.ZA
            GS -> Value.GS
            KR -> Value.KR
            SS -> Value.SS
            ES -> Value.ES
            LK -> Value.LK
            SD -> Value.SD
            SR -> Value.SR
            SJ -> Value.SJ
            SE -> Value.SE
            CH -> Value.CH
            SY -> Value.SY
            TW -> Value.TW
            TJ -> Value.TJ
            TZ -> Value.TZ
            TH -> Value.TH
            TL -> Value.TL
            TG -> Value.TG
            TK -> Value.TK
            TO -> Value.TO
            TT -> Value.TT
            TN -> Value.TN
            TR -> Value.TR
            TM -> Value.TM
            TC -> Value.TC
            TV -> Value.TV
            UG -> Value.UG
            UA -> Value.UA
            AE -> Value.AE
            GB -> Value.GB
            UM -> Value.UM
            US -> Value.US
            UY -> Value.UY
            UZ -> Value.UZ
            VU -> Value.VU
            VE -> Value.VE
            VN -> Value.VN
            VG -> Value.VG
            VI -> Value.VI
            WF -> Value.WF
            EH -> Value.EH
            YE -> Value.YE
            ZM -> Value.ZM
            ZW -> Value.ZW
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            AF -> Known.AF
            AX -> Known.AX
            AL -> Known.AL
            DZ -> Known.DZ
            AS -> Known.AS
            AD -> Known.AD
            AO -> Known.AO
            AI -> Known.AI
            AQ -> Known.AQ
            AG -> Known.AG
            AR -> Known.AR
            AM -> Known.AM
            AW -> Known.AW
            AU -> Known.AU
            AT -> Known.AT
            AZ -> Known.AZ
            BS -> Known.BS
            BH -> Known.BH
            BD -> Known.BD
            BB -> Known.BB
            BY -> Known.BY
            BE -> Known.BE
            BZ -> Known.BZ
            BJ -> Known.BJ
            BM -> Known.BM
            BT -> Known.BT
            BO -> Known.BO
            BQ -> Known.BQ
            BA -> Known.BA
            BW -> Known.BW
            BV -> Known.BV
            BR -> Known.BR
            IO -> Known.IO
            BN -> Known.BN
            BG -> Known.BG
            BF -> Known.BF
            BI -> Known.BI
            CV -> Known.CV
            KH -> Known.KH
            CM -> Known.CM
            CA -> Known.CA
            KY -> Known.KY
            CF -> Known.CF
            TD -> Known.TD
            CL -> Known.CL
            CN -> Known.CN
            CX -> Known.CX
            CC -> Known.CC
            CO -> Known.CO
            KM -> Known.KM
            CG -> Known.CG
            CD -> Known.CD
            CK -> Known.CK
            CR -> Known.CR
            CI -> Known.CI
            HR -> Known.HR
            CU -> Known.CU
            CW -> Known.CW
            CY -> Known.CY
            CZ -> Known.CZ
            DK -> Known.DK
            DJ -> Known.DJ
            DM -> Known.DM
            DO -> Known.DO
            EC -> Known.EC
            EG -> Known.EG
            SV -> Known.SV
            GQ -> Known.GQ
            ER -> Known.ER
            EE -> Known.EE
            SZ -> Known.SZ
            ET -> Known.ET
            FK -> Known.FK
            FO -> Known.FO
            FJ -> Known.FJ
            FI -> Known.FI
            FR -> Known.FR
            GF -> Known.GF
            PF -> Known.PF
            TF -> Known.TF
            GA -> Known.GA
            GM -> Known.GM
            GE -> Known.GE
            DE -> Known.DE
            GH -> Known.GH
            GI -> Known.GI
            GR -> Known.GR
            GL -> Known.GL
            GD -> Known.GD
            GP -> Known.GP
            GU -> Known.GU
            GT -> Known.GT
            GG -> Known.GG
            GN -> Known.GN
            GW -> Known.GW
            GY -> Known.GY
            HT -> Known.HT
            HM -> Known.HM
            VA -> Known.VA
            HN -> Known.HN
            HK -> Known.HK
            HU -> Known.HU
            IS -> Known.IS
            IN -> Known.IN
            ID -> Known.ID
            IR -> Known.IR
            IQ -> Known.IQ
            IE -> Known.IE
            IM -> Known.IM
            IL -> Known.IL
            IT -> Known.IT
            JM -> Known.JM
            JP -> Known.JP
            JE -> Known.JE
            JO -> Known.JO
            KZ -> Known.KZ
            KE -> Known.KE
            KI -> Known.KI
            KW -> Known.KW
            KG -> Known.KG
            LA -> Known.LA
            LV -> Known.LV
            LB -> Known.LB
            LS -> Known.LS
            LR -> Known.LR
            LY -> Known.LY
            LI -> Known.LI
            LT -> Known.LT
            LU -> Known.LU
            MO -> Known.MO
            MG -> Known.MG
            MW -> Known.MW
            MY -> Known.MY
            MV -> Known.MV
            ML -> Known.ML
            MT -> Known.MT
            MH -> Known.MH
            MQ -> Known.MQ
            MR -> Known.MR
            MU -> Known.MU
            YT -> Known.YT
            MX -> Known.MX
            FM -> Known.FM
            MD -> Known.MD
            MC -> Known.MC
            MN -> Known.MN
            ME -> Known.ME
            MS -> Known.MS
            MA -> Known.MA
            MZ -> Known.MZ
            MM -> Known.MM
            NA -> Known.NA
            NR -> Known.NR
            NP -> Known.NP
            NL -> Known.NL
            NC -> Known.NC
            NZ -> Known.NZ
            NI -> Known.NI
            NE -> Known.NE
            NG -> Known.NG
            NU -> Known.NU
            NF -> Known.NF
            KP -> Known.KP
            MK -> Known.MK
            MP -> Known.MP
            NO -> Known.NO
            OM -> Known.OM
            PK -> Known.PK
            PW -> Known.PW
            PS -> Known.PS
            PA -> Known.PA
            PG -> Known.PG
            PY -> Known.PY
            PE -> Known.PE
            PH -> Known.PH
            PN -> Known.PN
            PL -> Known.PL
            PT -> Known.PT
            PR -> Known.PR
            QA -> Known.QA
            RE -> Known.RE
            RO -> Known.RO
            RU -> Known.RU
            RW -> Known.RW
            BL -> Known.BL
            SH -> Known.SH
            KN -> Known.KN
            LC -> Known.LC
            MF -> Known.MF
            PM -> Known.PM
            VC -> Known.VC
            WS -> Known.WS
            SM -> Known.SM
            ST -> Known.ST
            SA -> Known.SA
            SN -> Known.SN
            RS -> Known.RS
            SC -> Known.SC
            SL -> Known.SL
            SG -> Known.SG
            SX -> Known.SX
            SK -> Known.SK
            SI -> Known.SI
            SB -> Known.SB
            SO -> Known.SO
            ZA -> Known.ZA
            GS -> Known.GS
            KR -> Known.KR
            SS -> Known.SS
            ES -> Known.ES
            LK -> Known.LK
            SD -> Known.SD
            SR -> Known.SR
            SJ -> Known.SJ
            SE -> Known.SE
            CH -> Known.CH
            SY -> Known.SY
            TW -> Known.TW
            TJ -> Known.TJ
            TZ -> Known.TZ
            TH -> Known.TH
            TL -> Known.TL
            TG -> Known.TG
            TK -> Known.TK
            TO -> Known.TO
            TT -> Known.TT
            TN -> Known.TN
            TR -> Known.TR
            TM -> Known.TM
            TC -> Known.TC
            TV -> Known.TV
            UG -> Known.UG
            UA -> Known.UA
            AE -> Known.AE
            GB -> Known.GB
            UM -> Known.UM
            US -> Known.US
            UY -> Known.UY
            UZ -> Known.UZ
            VU -> Known.VU
            VE -> Known.VE
            VN -> Known.VN
            VG -> Known.VG
            VI -> Known.VI
            WF -> Known.WF
            EH -> Known.EH
            YE -> Known.YE
            ZM -> Known.ZM
            ZW -> Known.ZW
            else -> throw MergeInvalidDataException("Unknown Country: $value")
        }

    fun asString(): String = _value().asStringOrThrow()
}
