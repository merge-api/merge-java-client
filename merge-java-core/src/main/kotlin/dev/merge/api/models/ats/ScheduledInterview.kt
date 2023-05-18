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
 * # The ScheduledInterview Object
 *
 * ### Description
 *
 * The `ScheduledInterview` object is used to represent a scheduled interview for a given
 * candidate’s application to a job. An `Application` can have multiple `ScheduledInterview`s
 * depending on the particular hiring process.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST ScheduledInterviews` endpoint and filter by `interviewers` to show all
 * office locations.
 */
@JsonDeserialize(builder = ScheduledInterview.Builder::class)
@NoAutoDetect
class ScheduledInterview
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val application: JsonField<String>,
    private val jobInterviewStage: JsonField<String>,
    private val organizer: JsonField<String>,
    private val interviewers: JsonField<List<String>>,
    private val location: JsonField<String>,
    private val startAt: JsonField<OffsetDateTime>,
    private val endAt: JsonField<OffsetDateTime>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val remoteUpdatedAt: JsonField<OffsetDateTime>,
    private val status: JsonField<ScheduledInterviewStatusEnum>,
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

    /** The application being interviewed. */
    fun application(): Optional<String> =
        Optional.ofNullable(application.getNullable("application"))

    /** The stage of the interview. */
    fun jobInterviewStage(): Optional<String> =
        Optional.ofNullable(jobInterviewStage.getNullable("job_interview_stage"))

    /** The user organizing the interview. */
    fun organizer(): Optional<String> = Optional.ofNullable(organizer.getNullable("organizer"))

    /** Array of `RemoteUser` IDs. */
    fun interviewers(): Optional<List<String>> =
        Optional.ofNullable(interviewers.getNullable("interviewers"))

    /** The interview's location. */
    fun location(): Optional<String> = Optional.ofNullable(location.getNullable("location"))

    /** When the interview was started. */
    fun startAt(): Optional<OffsetDateTime> = Optional.ofNullable(startAt.getNullable("start_at"))

    /** When the interview was ended. */
    fun endAt(): Optional<OffsetDateTime> = Optional.ofNullable(endAt.getNullable("end_at"))

    /** When the third party's interview was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** When the third party's interview was updated. */
    fun remoteUpdatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteUpdatedAt.getNullable("remote_updated_at"))

    /**
     * - `SCHEDULED` - SCHEDULED
     * - `AWAITING_FEEDBACK` - AWAITING_FEEDBACK
     * - `COMPLETE` - COMPLETE
     */
    fun status(): Optional<ScheduledInterviewStatusEnum> =
        Optional.ofNullable(status.getNullable("status"))

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

    /** The application being interviewed. */
    @JsonProperty("application") @ExcludeMissing fun _application() = application

    /** The stage of the interview. */
    @JsonProperty("job_interview_stage")
    @ExcludeMissing
    fun _jobInterviewStage() = jobInterviewStage

    /** The user organizing the interview. */
    @JsonProperty("organizer") @ExcludeMissing fun _organizer() = organizer

    /** Array of `RemoteUser` IDs. */
    @JsonProperty("interviewers") @ExcludeMissing fun _interviewers() = interviewers

    /** The interview's location. */
    @JsonProperty("location") @ExcludeMissing fun _location() = location

    /** When the interview was started. */
    @JsonProperty("start_at") @ExcludeMissing fun _startAt() = startAt

    /** When the interview was ended. */
    @JsonProperty("end_at") @ExcludeMissing fun _endAt() = endAt

    /** When the third party's interview was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** When the third party's interview was updated. */
    @JsonProperty("remote_updated_at") @ExcludeMissing fun _remoteUpdatedAt() = remoteUpdatedAt

    /**
     * - `SCHEDULED` - SCHEDULED
     * - `AWAITING_FEEDBACK` - AWAITING_FEEDBACK
     * - `COMPLETE` - COMPLETE
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ScheduledInterview = apply {
        if (!validated) {
            id()
            remoteId()
            application()
            jobInterviewStage()
            organizer()
            interviewers()
            location()
            startAt()
            endAt()
            remoteCreatedAt()
            remoteUpdatedAt()
            status()
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

        return other is ScheduledInterview &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.application == other.application &&
            this.jobInterviewStage == other.jobInterviewStage &&
            this.organizer == other.organizer &&
            this.interviewers == other.interviewers &&
            this.location == other.location &&
            this.startAt == other.startAt &&
            this.endAt == other.endAt &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.remoteUpdatedAt == other.remoteUpdatedAt &&
            this.status == other.status &&
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
                    jobInterviewStage,
                    organizer,
                    interviewers,
                    location,
                    startAt,
                    endAt,
                    remoteCreatedAt,
                    remoteUpdatedAt,
                    status,
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
        "ScheduledInterview{id=$id, remoteId=$remoteId, application=$application, jobInterviewStage=$jobInterviewStage, organizer=$organizer, interviewers=$interviewers, location=$location, startAt=$startAt, endAt=$endAt, remoteCreatedAt=$remoteCreatedAt, remoteUpdatedAt=$remoteUpdatedAt, status=$status, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var application: JsonField<String> = JsonMissing.of()
        private var jobInterviewStage: JsonField<String> = JsonMissing.of()
        private var organizer: JsonField<String> = JsonMissing.of()
        private var interviewers: JsonField<List<String>> = JsonMissing.of()
        private var location: JsonField<String> = JsonMissing.of()
        private var startAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var endAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteUpdatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var status: JsonField<ScheduledInterviewStatusEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(scheduledInterview: ScheduledInterview) = apply {
            this.id = scheduledInterview.id
            this.remoteId = scheduledInterview.remoteId
            this.application = scheduledInterview.application
            this.jobInterviewStage = scheduledInterview.jobInterviewStage
            this.organizer = scheduledInterview.organizer
            this.interviewers = scheduledInterview.interviewers
            this.location = scheduledInterview.location
            this.startAt = scheduledInterview.startAt
            this.endAt = scheduledInterview.endAt
            this.remoteCreatedAt = scheduledInterview.remoteCreatedAt
            this.remoteUpdatedAt = scheduledInterview.remoteUpdatedAt
            this.status = scheduledInterview.status
            this.remoteWasDeleted = scheduledInterview.remoteWasDeleted
            this.fieldMappings = scheduledInterview.fieldMappings
            this.modifiedAt = scheduledInterview.modifiedAt
            this.remoteData = scheduledInterview.remoteData
            additionalProperties(scheduledInterview.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The application being interviewed. */
        fun application(application: String) = application(JsonField.of(application))

        /** The application being interviewed. */
        @JsonProperty("application")
        @ExcludeMissing
        fun application(application: JsonField<String>) = apply { this.application = application }

        /** The stage of the interview. */
        fun jobInterviewStage(jobInterviewStage: String) =
            jobInterviewStage(JsonField.of(jobInterviewStage))

        /** The stage of the interview. */
        @JsonProperty("job_interview_stage")
        @ExcludeMissing
        fun jobInterviewStage(jobInterviewStage: JsonField<String>) = apply {
            this.jobInterviewStage = jobInterviewStage
        }

        /** The user organizing the interview. */
        fun organizer(organizer: String) = organizer(JsonField.of(organizer))

        /** The user organizing the interview. */
        @JsonProperty("organizer")
        @ExcludeMissing
        fun organizer(organizer: JsonField<String>) = apply { this.organizer = organizer }

        /** Array of `RemoteUser` IDs. */
        fun interviewers(interviewers: List<String>) = interviewers(JsonField.of(interviewers))

        /** Array of `RemoteUser` IDs. */
        @JsonProperty("interviewers")
        @ExcludeMissing
        fun interviewers(interviewers: JsonField<List<String>>) = apply {
            this.interviewers = interviewers
        }

        /** The interview's location. */
        fun location(location: String) = location(JsonField.of(location))

        /** The interview's location. */
        @JsonProperty("location")
        @ExcludeMissing
        fun location(location: JsonField<String>) = apply { this.location = location }

        /** When the interview was started. */
        fun startAt(startAt: OffsetDateTime) = startAt(JsonField.of(startAt))

        /** When the interview was started. */
        @JsonProperty("start_at")
        @ExcludeMissing
        fun startAt(startAt: JsonField<OffsetDateTime>) = apply { this.startAt = startAt }

        /** When the interview was ended. */
        fun endAt(endAt: OffsetDateTime) = endAt(JsonField.of(endAt))

        /** When the interview was ended. */
        @JsonProperty("end_at")
        @ExcludeMissing
        fun endAt(endAt: JsonField<OffsetDateTime>) = apply { this.endAt = endAt }

        /** When the third party's interview was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's interview was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** When the third party's interview was updated. */
        fun remoteUpdatedAt(remoteUpdatedAt: OffsetDateTime) =
            remoteUpdatedAt(JsonField.of(remoteUpdatedAt))

        /** When the third party's interview was updated. */
        @JsonProperty("remote_updated_at")
        @ExcludeMissing
        fun remoteUpdatedAt(remoteUpdatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteUpdatedAt = remoteUpdatedAt
        }

        /**
         * - `SCHEDULED` - SCHEDULED
         * - `AWAITING_FEEDBACK` - AWAITING_FEEDBACK
         * - `COMPLETE` - COMPLETE
         */
        fun status(status: ScheduledInterviewStatusEnum) = status(JsonField.of(status))

        /**
         * - `SCHEDULED` - SCHEDULED
         * - `AWAITING_FEEDBACK` - AWAITING_FEEDBACK
         * - `COMPLETE` - COMPLETE
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<ScheduledInterviewStatusEnum>) = apply { this.status = status }

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

        fun build(): ScheduledInterview =
            ScheduledInterview(
                id,
                remoteId,
                application,
                jobInterviewStage,
                organizer,
                interviewers.map { it.toUnmodifiable() },
                location,
                startAt,
                endAt,
                remoteCreatedAt,
                remoteUpdatedAt,
                status,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class ScheduledInterviewStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ScheduledInterviewStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val SCHEDULED = ScheduledInterviewStatusEnum(JsonField.of("SCHEDULED"))

            @JvmField
            val AWAITING_FEEDBACK = ScheduledInterviewStatusEnum(JsonField.of("AWAITING_FEEDBACK"))

            @JvmField val COMPLETE = ScheduledInterviewStatusEnum(JsonField.of("COMPLETE"))

            @JvmStatic fun of(value: String) = ScheduledInterviewStatusEnum(JsonField.of(value))
        }

        enum class Known {
            SCHEDULED,
            AWAITING_FEEDBACK,
            COMPLETE,
        }

        enum class Value {
            SCHEDULED,
            AWAITING_FEEDBACK,
            COMPLETE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SCHEDULED -> Value.SCHEDULED
                AWAITING_FEEDBACK -> Value.AWAITING_FEEDBACK
                COMPLETE -> Value.COMPLETE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SCHEDULED -> Known.SCHEDULED
                AWAITING_FEEDBACK -> Known.AWAITING_FEEDBACK
                COMPLETE -> Known.COMPLETE
                else ->
                    throw MergeInvalidDataException("Unknown ScheduledInterviewStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
