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
 * # The Scorecard Object
 *
 * ### Description
 *
 * The `Scorecard` object is used to represent an interviewer's candidate recommendation based on a
 * particular interview.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Scorecards` endpoint and filter by `application` to show all scorecard for
 * an applicant.
 */
@JsonDeserialize(builder = Scorecard.Builder::class)
@NoAutoDetect
class Scorecard
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val application: JsonField<String>,
    private val interview: JsonField<String>,
    private val interviewer: JsonField<String>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val submittedAt: JsonField<OffsetDateTime>,
    private val overallRecommendation: JsonField<OverallRecommendationEnum>,
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

    /** The application being scored. */
    fun application(): Optional<String> =
        Optional.ofNullable(application.getNullable("application"))

    /** The interview being scored. */
    fun interview(): Optional<String> = Optional.ofNullable(interview.getNullable("interview"))

    /** The interviewer doing the scoring. */
    fun interviewer(): Optional<String> =
        Optional.ofNullable(interviewer.getNullable("interviewer"))

    /** When the third party's scorecard was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** When the scorecard was submitted. */
    fun submittedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(submittedAt.getNullable("submitted_at"))

    /**
     * - `DEFINITELY_NO` - DEFINITELY_NO
     * - `NO` - NO
     * - `YES` - YES
     * - `STRONG_YES` - STRONG_YES
     * - `NO_DECISION` - NO_DECISION
     */
    fun overallRecommendation(): Optional<OverallRecommendationEnum> =
        Optional.ofNullable(overallRecommendation.getNullable("overall_recommendation"))

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

    /** The application being scored. */
    @JsonProperty("application") @ExcludeMissing fun _application() = application

    /** The interview being scored. */
    @JsonProperty("interview") @ExcludeMissing fun _interview() = interview

    /** The interviewer doing the scoring. */
    @JsonProperty("interviewer") @ExcludeMissing fun _interviewer() = interviewer

    /** When the third party's scorecard was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** When the scorecard was submitted. */
    @JsonProperty("submitted_at") @ExcludeMissing fun _submittedAt() = submittedAt

    /**
     * - `DEFINITELY_NO` - DEFINITELY_NO
     * - `NO` - NO
     * - `YES` - YES
     * - `STRONG_YES` - STRONG_YES
     * - `NO_DECISION` - NO_DECISION
     */
    @JsonProperty("overall_recommendation")
    @ExcludeMissing
    fun _overallRecommendation() = overallRecommendation

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Scorecard = apply {
        if (!validated) {
            id()
            remoteId()
            application()
            interview()
            interviewer()
            remoteCreatedAt()
            submittedAt()
            overallRecommendation()
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

        return other is Scorecard &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.application == other.application &&
            this.interview == other.interview &&
            this.interviewer == other.interviewer &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.submittedAt == other.submittedAt &&
            this.overallRecommendation == other.overallRecommendation &&
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
                    application,
                    interview,
                    interviewer,
                    remoteCreatedAt,
                    submittedAt,
                    overallRecommendation,
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
        "Scorecard{id=$id, remoteId=$remoteId, application=$application, interview=$interview, interviewer=$interviewer, remoteCreatedAt=$remoteCreatedAt, submittedAt=$submittedAt, overallRecommendation=$overallRecommendation, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var application: JsonField<String> = JsonMissing.of()
        private var interview: JsonField<String> = JsonMissing.of()
        private var interviewer: JsonField<String> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var submittedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var overallRecommendation: JsonField<OverallRecommendationEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(scorecard: Scorecard) = apply {
            this.id = scorecard.id
            this.remoteId = scorecard.remoteId
            this.application = scorecard.application
            this.interview = scorecard.interview
            this.interviewer = scorecard.interviewer
            this.remoteCreatedAt = scorecard.remoteCreatedAt
            this.submittedAt = scorecard.submittedAt
            this.overallRecommendation = scorecard.overallRecommendation
            this.remoteWasDeleted = scorecard.remoteWasDeleted
            this.fieldMappings = scorecard.fieldMappings
            this.modifiedAt = scorecard.modifiedAt
            this.remoteData = scorecard.remoteData
            additionalProperties(scorecard.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The application being scored. */
        fun application(application: String) = application(JsonField.of(application))

        /** The application being scored. */
        @JsonProperty("application")
        @ExcludeMissing
        fun application(application: JsonField<String>) = apply { this.application = application }

        /** The interview being scored. */
        fun interview(interview: String) = interview(JsonField.of(interview))

        /** The interview being scored. */
        @JsonProperty("interview")
        @ExcludeMissing
        fun interview(interview: JsonField<String>) = apply { this.interview = interview }

        /** The interviewer doing the scoring. */
        fun interviewer(interviewer: String) = interviewer(JsonField.of(interviewer))

        /** The interviewer doing the scoring. */
        @JsonProperty("interviewer")
        @ExcludeMissing
        fun interviewer(interviewer: JsonField<String>) = apply { this.interviewer = interviewer }

        /** When the third party's scorecard was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's scorecard was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** When the scorecard was submitted. */
        fun submittedAt(submittedAt: OffsetDateTime) = submittedAt(JsonField.of(submittedAt))

        /** When the scorecard was submitted. */
        @JsonProperty("submitted_at")
        @ExcludeMissing
        fun submittedAt(submittedAt: JsonField<OffsetDateTime>) = apply {
            this.submittedAt = submittedAt
        }

        /**
         * - `DEFINITELY_NO` - DEFINITELY_NO
         * - `NO` - NO
         * - `YES` - YES
         * - `STRONG_YES` - STRONG_YES
         * - `NO_DECISION` - NO_DECISION
         */
        fun overallRecommendation(overallRecommendation: OverallRecommendationEnum) =
            overallRecommendation(JsonField.of(overallRecommendation))

        /**
         * - `DEFINITELY_NO` - DEFINITELY_NO
         * - `NO` - NO
         * - `YES` - YES
         * - `STRONG_YES` - STRONG_YES
         * - `NO_DECISION` - NO_DECISION
         */
        @JsonProperty("overall_recommendation")
        @ExcludeMissing
        fun overallRecommendation(overallRecommendation: JsonField<OverallRecommendationEnum>) =
            apply {
                this.overallRecommendation = overallRecommendation
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

        fun build(): Scorecard =
            Scorecard(
                id,
                remoteId,
                application,
                interview,
                interviewer,
                remoteCreatedAt,
                submittedAt,
                overallRecommendation,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class OverallRecommendationEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OverallRecommendationEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val DEFINITELY_NO = OverallRecommendationEnum(JsonField.of("DEFINITELY_NO"))

            @JvmField val NO = OverallRecommendationEnum(JsonField.of("NO"))

            @JvmField val YES = OverallRecommendationEnum(JsonField.of("YES"))

            @JvmField val STRONG_YES = OverallRecommendationEnum(JsonField.of("STRONG_YES"))

            @JvmField val NO_DECISION = OverallRecommendationEnum(JsonField.of("NO_DECISION"))

            @JvmStatic fun of(value: String) = OverallRecommendationEnum(JsonField.of(value))
        }

        enum class Known {
            DEFINITELY_NO,
            NO,
            YES,
            STRONG_YES,
            NO_DECISION,
        }

        enum class Value {
            DEFINITELY_NO,
            NO,
            YES,
            STRONG_YES,
            NO_DECISION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                DEFINITELY_NO -> Value.DEFINITELY_NO
                NO -> Value.NO
                YES -> Value.YES
                STRONG_YES -> Value.STRONG_YES
                NO_DECISION -> Value.NO_DECISION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                DEFINITELY_NO -> Known.DEFINITELY_NO
                NO -> Known.NO
                YES -> Known.YES
                STRONG_YES -> Known.STRONG_YES
                NO_DECISION -> Known.NO_DECISION
                else -> throw MergeInvalidDataException("Unknown OverallRecommendationEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
