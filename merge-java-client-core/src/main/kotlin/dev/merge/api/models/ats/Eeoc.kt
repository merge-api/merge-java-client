package dev.merge.api.models.ats

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
 * # The EEOC Object
 *
 * ### Description
 *
 * The `EEOC` object is used to represent the Equal Employment Opportunity Commission information
 * for a candidate (race, gender, veteran status, disability status).
 *
 * ### Usage Example
 *
 * Fetch from the `LIST EEOCs` endpoint and filter by `candidate` to show all EEOC information for a
 * candidate.
 */
@JsonDeserialize(builder = Eeoc.Builder::class)
@NoAutoDetect
class Eeoc
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val candidate: JsonField<String>,
    private val submittedAt: JsonField<OffsetDateTime>,
    private val race: JsonField<RaceEnum>,
    private val gender: JsonField<GenderEnum>,
    private val veteranStatus: JsonField<VeteranStatusEnum>,
    private val disabilityStatus: JsonField<DisabilityStatusEnum>,
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

    /** The candidate being represented. */
    fun candidate(): Optional<String> = Optional.ofNullable(candidate.getNullable("candidate"))

    /** When the information was submitted. */
    fun submittedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(submittedAt.getNullable("submitted_at"))

    /**
     * - `AMERICAN_INDIAN_OR_ALASKAN_NATIVE` - AMERICAN_INDIAN_OR_ALASKAN_NATIVE
     * - `ASIAN` - ASIAN
     * - `BLACK_OR_AFRICAN_AMERICAN` - BLACK_OR_AFRICAN_AMERICAN
     * - `HISPANIC_OR_LATINO` - HISPANIC_OR_LATINO
     * - `WHITE` - WHITE
     * - `NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER` - NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER
     * - `TWO_OR_MORE_RACES` - TWO_OR_MORE_RACES
     * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
     */
    fun race(): Optional<RaceEnum> = Optional.ofNullable(race.getNullable("race"))

    /**
     * - `MALE` - MALE
     * - `FEMALE` - FEMALE
     * - `NON-BINARY` - NON-BINARY
     * - `OTHER` - OTHER
     * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
     */
    fun gender(): Optional<GenderEnum> = Optional.ofNullable(gender.getNullable("gender"))

    /**
     * - `I_AM_NOT_A_PROTECTED_VETERAN` - I_AM_NOT_A_PROTECTED_VETERAN
     * - `I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN` -
     * I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN
     * - `I_DONT_WISH_TO_ANSWER` - I_DONT_WISH_TO_ANSWER
     */
    fun veteranStatus(): Optional<VeteranStatusEnum> =
        Optional.ofNullable(veteranStatus.getNullable("veteran_status"))

    /**
     * - `YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY` -
     * YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY
     * - `NO_I_DONT_HAVE_A_DISABILITY` - NO_I_DONT_HAVE_A_DISABILITY
     * - `I_DONT_WISH_TO_ANSWER` - I_DONT_WISH_TO_ANSWER
     */
    fun disabilityStatus(): Optional<DisabilityStatusEnum> =
        Optional.ofNullable(disabilityStatus.getNullable("disability_status"))

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

    /** The candidate being represented. */
    @JsonProperty("candidate") @ExcludeMissing fun _candidate() = candidate

    /** When the information was submitted. */
    @JsonProperty("submitted_at") @ExcludeMissing fun _submittedAt() = submittedAt

    /**
     * - `AMERICAN_INDIAN_OR_ALASKAN_NATIVE` - AMERICAN_INDIAN_OR_ALASKAN_NATIVE
     * - `ASIAN` - ASIAN
     * - `BLACK_OR_AFRICAN_AMERICAN` - BLACK_OR_AFRICAN_AMERICAN
     * - `HISPANIC_OR_LATINO` - HISPANIC_OR_LATINO
     * - `WHITE` - WHITE
     * - `NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER` - NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER
     * - `TWO_OR_MORE_RACES` - TWO_OR_MORE_RACES
     * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
     */
    @JsonProperty("race") @ExcludeMissing fun _race() = race

    /**
     * - `MALE` - MALE
     * - `FEMALE` - FEMALE
     * - `NON-BINARY` - NON-BINARY
     * - `OTHER` - OTHER
     * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
     */
    @JsonProperty("gender") @ExcludeMissing fun _gender() = gender

    /**
     * - `I_AM_NOT_A_PROTECTED_VETERAN` - I_AM_NOT_A_PROTECTED_VETERAN
     * - `I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN` -
     * I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN
     * - `I_DONT_WISH_TO_ANSWER` - I_DONT_WISH_TO_ANSWER
     */
    @JsonProperty("veteran_status") @ExcludeMissing fun _veteranStatus() = veteranStatus

    /**
     * - `YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY` -
     * YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY
     * - `NO_I_DONT_HAVE_A_DISABILITY` - NO_I_DONT_HAVE_A_DISABILITY
     * - `I_DONT_WISH_TO_ANSWER` - I_DONT_WISH_TO_ANSWER
     */
    @JsonProperty("disability_status") @ExcludeMissing fun _disabilityStatus() = disabilityStatus

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Eeoc = apply {
        if (!validated) {
            id()
            remoteId()
            candidate()
            submittedAt()
            race()
            gender()
            veteranStatus()
            disabilityStatus()
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

        return other is Eeoc &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.candidate == other.candidate &&
            this.submittedAt == other.submittedAt &&
            this.race == other.race &&
            this.gender == other.gender &&
            this.veteranStatus == other.veteranStatus &&
            this.disabilityStatus == other.disabilityStatus &&
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
                    candidate,
                    submittedAt,
                    race,
                    gender,
                    veteranStatus,
                    disabilityStatus,
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
        "Eeoc{id=$id, remoteId=$remoteId, candidate=$candidate, submittedAt=$submittedAt, race=$race, gender=$gender, veteranStatus=$veteranStatus, disabilityStatus=$disabilityStatus, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var candidate: JsonField<String> = JsonMissing.of()
        private var submittedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var race: JsonField<RaceEnum> = JsonMissing.of()
        private var gender: JsonField<GenderEnum> = JsonMissing.of()
        private var veteranStatus: JsonField<VeteranStatusEnum> = JsonMissing.of()
        private var disabilityStatus: JsonField<DisabilityStatusEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(eeoc: Eeoc) = apply {
            this.id = eeoc.id
            this.remoteId = eeoc.remoteId
            this.candidate = eeoc.candidate
            this.submittedAt = eeoc.submittedAt
            this.race = eeoc.race
            this.gender = eeoc.gender
            this.veteranStatus = eeoc.veteranStatus
            this.disabilityStatus = eeoc.disabilityStatus
            this.remoteWasDeleted = eeoc.remoteWasDeleted
            this.fieldMappings = eeoc.fieldMappings
            this.modifiedAt = eeoc.modifiedAt
            this.remoteData = eeoc.remoteData
            additionalProperties(eeoc.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The candidate being represented. */
        fun candidate(candidate: String) = candidate(JsonField.of(candidate))

        /** The candidate being represented. */
        @JsonProperty("candidate")
        @ExcludeMissing
        fun candidate(candidate: JsonField<String>) = apply { this.candidate = candidate }

        /** When the information was submitted. */
        fun submittedAt(submittedAt: OffsetDateTime) = submittedAt(JsonField.of(submittedAt))

        /** When the information was submitted. */
        @JsonProperty("submitted_at")
        @ExcludeMissing
        fun submittedAt(submittedAt: JsonField<OffsetDateTime>) = apply {
            this.submittedAt = submittedAt
        }

        /**
         * - `AMERICAN_INDIAN_OR_ALASKAN_NATIVE` - AMERICAN_INDIAN_OR_ALASKAN_NATIVE
         * - `ASIAN` - ASIAN
         * - `BLACK_OR_AFRICAN_AMERICAN` - BLACK_OR_AFRICAN_AMERICAN
         * - `HISPANIC_OR_LATINO` - HISPANIC_OR_LATINO
         * - `WHITE` - WHITE
         * - `NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER` - NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER
         * - `TWO_OR_MORE_RACES` - TWO_OR_MORE_RACES
         * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
         */
        fun race(race: RaceEnum) = race(JsonField.of(race))

        /**
         * - `AMERICAN_INDIAN_OR_ALASKAN_NATIVE` - AMERICAN_INDIAN_OR_ALASKAN_NATIVE
         * - `ASIAN` - ASIAN
         * - `BLACK_OR_AFRICAN_AMERICAN` - BLACK_OR_AFRICAN_AMERICAN
         * - `HISPANIC_OR_LATINO` - HISPANIC_OR_LATINO
         * - `WHITE` - WHITE
         * - `NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER` - NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER
         * - `TWO_OR_MORE_RACES` - TWO_OR_MORE_RACES
         * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
         */
        @JsonProperty("race")
        @ExcludeMissing
        fun race(race: JsonField<RaceEnum>) = apply { this.race = race }

        /**
         * - `MALE` - MALE
         * - `FEMALE` - FEMALE
         * - `NON-BINARY` - NON-BINARY
         * - `OTHER` - OTHER
         * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
         */
        fun gender(gender: GenderEnum) = gender(JsonField.of(gender))

        /**
         * - `MALE` - MALE
         * - `FEMALE` - FEMALE
         * - `NON-BINARY` - NON-BINARY
         * - `OTHER` - OTHER
         * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
         */
        @JsonProperty("gender")
        @ExcludeMissing
        fun gender(gender: JsonField<GenderEnum>) = apply { this.gender = gender }

        /**
         * - `I_AM_NOT_A_PROTECTED_VETERAN` - I_AM_NOT_A_PROTECTED_VETERAN
         * - `I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN` -
         * I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN
         * - `I_DONT_WISH_TO_ANSWER` - I_DONT_WISH_TO_ANSWER
         */
        fun veteranStatus(veteranStatus: VeteranStatusEnum) =
            veteranStatus(JsonField.of(veteranStatus))

        /**
         * - `I_AM_NOT_A_PROTECTED_VETERAN` - I_AM_NOT_A_PROTECTED_VETERAN
         * - `I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN` -
         * I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN
         * - `I_DONT_WISH_TO_ANSWER` - I_DONT_WISH_TO_ANSWER
         */
        @JsonProperty("veteran_status")
        @ExcludeMissing
        fun veteranStatus(veteranStatus: JsonField<VeteranStatusEnum>) = apply {
            this.veteranStatus = veteranStatus
        }

        /**
         * - `YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY` -
         * YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY
         * - `NO_I_DONT_HAVE_A_DISABILITY` - NO_I_DONT_HAVE_A_DISABILITY
         * - `I_DONT_WISH_TO_ANSWER` - I_DONT_WISH_TO_ANSWER
         */
        fun disabilityStatus(disabilityStatus: DisabilityStatusEnum) =
            disabilityStatus(JsonField.of(disabilityStatus))

        /**
         * - `YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY` -
         * YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY
         * - `NO_I_DONT_HAVE_A_DISABILITY` - NO_I_DONT_HAVE_A_DISABILITY
         * - `I_DONT_WISH_TO_ANSWER` - I_DONT_WISH_TO_ANSWER
         */
        @JsonProperty("disability_status")
        @ExcludeMissing
        fun disabilityStatus(disabilityStatus: JsonField<DisabilityStatusEnum>) = apply {
            this.disabilityStatus = disabilityStatus
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

        fun build(): Eeoc =
            Eeoc(
                id,
                remoteId,
                candidate,
                submittedAt,
                race,
                gender,
                veteranStatus,
                disabilityStatus,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class RaceEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RaceEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField
            val AMERICAN_INDIAN_OR_ALASKAN_NATIVE =
                RaceEnum(JsonField.of("AMERICAN_INDIAN_OR_ALASKAN_NATIVE"))

            @JvmField val ASIAN = RaceEnum(JsonField.of("ASIAN"))

            @JvmField
            val BLACK_OR_AFRICAN_AMERICAN = RaceEnum(JsonField.of("BLACK_OR_AFRICAN_AMERICAN"))

            @JvmField val HISPANIC_OR_LATINO = RaceEnum(JsonField.of("HISPANIC_OR_LATINO"))

            @JvmField val WHITE = RaceEnum(JsonField.of("WHITE"))

            @JvmField
            val NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER =
                RaceEnum(JsonField.of("NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER"))

            @JvmField val TWO_OR_MORE_RACES = RaceEnum(JsonField.of("TWO_OR_MORE_RACES"))

            @JvmField
            val DECLINE_TO_SELF_IDENTIFY = RaceEnum(JsonField.of("DECLINE_TO_SELF_IDENTIFY"))

            @JvmStatic fun of(value: String) = RaceEnum(JsonField.of(value))
        }

        enum class Known {
            AMERICAN_INDIAN_OR_ALASKAN_NATIVE,
            ASIAN,
            BLACK_OR_AFRICAN_AMERICAN,
            HISPANIC_OR_LATINO,
            WHITE,
            NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER,
            TWO_OR_MORE_RACES,
            DECLINE_TO_SELF_IDENTIFY,
        }

        enum class Value {
            AMERICAN_INDIAN_OR_ALASKAN_NATIVE,
            ASIAN,
            BLACK_OR_AFRICAN_AMERICAN,
            HISPANIC_OR_LATINO,
            WHITE,
            NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER,
            TWO_OR_MORE_RACES,
            DECLINE_TO_SELF_IDENTIFY,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                AMERICAN_INDIAN_OR_ALASKAN_NATIVE -> Value.AMERICAN_INDIAN_OR_ALASKAN_NATIVE
                ASIAN -> Value.ASIAN
                BLACK_OR_AFRICAN_AMERICAN -> Value.BLACK_OR_AFRICAN_AMERICAN
                HISPANIC_OR_LATINO -> Value.HISPANIC_OR_LATINO
                WHITE -> Value.WHITE
                NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER ->
                    Value.NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER
                TWO_OR_MORE_RACES -> Value.TWO_OR_MORE_RACES
                DECLINE_TO_SELF_IDENTIFY -> Value.DECLINE_TO_SELF_IDENTIFY
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                AMERICAN_INDIAN_OR_ALASKAN_NATIVE -> Known.AMERICAN_INDIAN_OR_ALASKAN_NATIVE
                ASIAN -> Known.ASIAN
                BLACK_OR_AFRICAN_AMERICAN -> Known.BLACK_OR_AFRICAN_AMERICAN
                HISPANIC_OR_LATINO -> Known.HISPANIC_OR_LATINO
                WHITE -> Known.WHITE
                NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER ->
                    Known.NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER
                TWO_OR_MORE_RACES -> Known.TWO_OR_MORE_RACES
                DECLINE_TO_SELF_IDENTIFY -> Known.DECLINE_TO_SELF_IDENTIFY
                else -> throw MergeInvalidDataException("Unknown RaceEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class GenderEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is GenderEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val MALE = GenderEnum(JsonField.of("MALE"))

            @JvmField val FEMALE = GenderEnum(JsonField.of("FEMALE"))

            @JvmField val NON_BINARY = GenderEnum(JsonField.of("NON-BINARY"))

            @JvmField val OTHER = GenderEnum(JsonField.of("OTHER"))

            @JvmField
            val DECLINE_TO_SELF_IDENTIFY = GenderEnum(JsonField.of("DECLINE_TO_SELF_IDENTIFY"))

            @JvmStatic fun of(value: String) = GenderEnum(JsonField.of(value))
        }

        enum class Known {
            MALE,
            FEMALE,
            NON_BINARY,
            OTHER,
            DECLINE_TO_SELF_IDENTIFY,
        }

        enum class Value {
            MALE,
            FEMALE,
            NON_BINARY,
            OTHER,
            DECLINE_TO_SELF_IDENTIFY,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                MALE -> Value.MALE
                FEMALE -> Value.FEMALE
                NON_BINARY -> Value.NON_BINARY
                OTHER -> Value.OTHER
                DECLINE_TO_SELF_IDENTIFY -> Value.DECLINE_TO_SELF_IDENTIFY
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                MALE -> Known.MALE
                FEMALE -> Known.FEMALE
                NON_BINARY -> Known.NON_BINARY
                OTHER -> Known.OTHER
                DECLINE_TO_SELF_IDENTIFY -> Known.DECLINE_TO_SELF_IDENTIFY
                else -> throw MergeInvalidDataException("Unknown GenderEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class VeteranStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is VeteranStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField
            val I_AM_NOT_A_PROTECTED_VETERAN =
                VeteranStatusEnum(JsonField.of("I_AM_NOT_A_PROTECTED_VETERAN"))

            @JvmField
            val I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN =
                VeteranStatusEnum(
                    JsonField.of(
                        "I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN"
                    )
                )

            @JvmField
            val I_DONT_WISH_TO_ANSWER = VeteranStatusEnum(JsonField.of("I_DONT_WISH_TO_ANSWER"))

            @JvmStatic fun of(value: String) = VeteranStatusEnum(JsonField.of(value))
        }

        enum class Known {
            I_AM_NOT_A_PROTECTED_VETERAN,
            I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN,
            I_DONT_WISH_TO_ANSWER,
        }

        enum class Value {
            I_AM_NOT_A_PROTECTED_VETERAN,
            I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN,
            I_DONT_WISH_TO_ANSWER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                I_AM_NOT_A_PROTECTED_VETERAN -> Value.I_AM_NOT_A_PROTECTED_VETERAN
                I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN ->
                    Value.I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN
                I_DONT_WISH_TO_ANSWER -> Value.I_DONT_WISH_TO_ANSWER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                I_AM_NOT_A_PROTECTED_VETERAN -> Known.I_AM_NOT_A_PROTECTED_VETERAN
                I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN ->
                    Known.I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN
                I_DONT_WISH_TO_ANSWER -> Known.I_DONT_WISH_TO_ANSWER
                else -> throw MergeInvalidDataException("Unknown VeteranStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class DisabilityStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DisabilityStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField
            val YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY =
                DisabilityStatusEnum(
                    JsonField.of("YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY")
                )

            @JvmField
            val NO_I_DONT_HAVE_A_DISABILITY =
                DisabilityStatusEnum(JsonField.of("NO_I_DONT_HAVE_A_DISABILITY"))

            @JvmField
            val I_DONT_WISH_TO_ANSWER = DisabilityStatusEnum(JsonField.of("I_DONT_WISH_TO_ANSWER"))

            @JvmStatic fun of(value: String) = DisabilityStatusEnum(JsonField.of(value))
        }

        enum class Known {
            YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY,
            NO_I_DONT_HAVE_A_DISABILITY,
            I_DONT_WISH_TO_ANSWER,
        }

        enum class Value {
            YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY,
            NO_I_DONT_HAVE_A_DISABILITY,
            I_DONT_WISH_TO_ANSWER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY ->
                    Value.YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY
                NO_I_DONT_HAVE_A_DISABILITY -> Value.NO_I_DONT_HAVE_A_DISABILITY
                I_DONT_WISH_TO_ANSWER -> Value.I_DONT_WISH_TO_ANSWER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY ->
                    Known.YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY
                NO_I_DONT_HAVE_A_DISABILITY -> Known.NO_I_DONT_HAVE_A_DISABILITY
                I_DONT_WISH_TO_ANSWER -> Known.I_DONT_WISH_TO_ANSWER
                else -> throw MergeInvalidDataException("Unknown DisabilityStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
