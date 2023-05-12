package dev.merge.api.models.ats

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

/**
 * # The Application Object
 *
 * ### Description
 *
 * The Application Object is used to represent a candidate's journey through a particular Job's
 * recruiting process. If a Candidate applies for multiple Jobs, there will be a separate
 * Application for each Job if the third-party integration allows it.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Applications` endpoint and filter by `ID` to show all applications.
 */
@JsonDeserialize(builder = Application.Builder::class)
@NoAutoDetect
class Application
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val candidate: JsonField<String>,
    private val job: JsonField<String>,
    private val appliedAt: JsonField<OffsetDateTime>,
    private val rejectedAt: JsonField<OffsetDateTime>,
    private val source: JsonField<String>,
    private val creditedTo: JsonField<String>,
    private val currentStage: JsonField<String>,
    private val rejectReason: JsonField<String>,
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

    /** The candidate applying. */
    fun candidate(): Optional<String> = Optional.ofNullable(candidate.getNullable("candidate"))

    /** The job being applied for. */
    fun job(): Optional<String> = Optional.ofNullable(job.getNullable("job"))

    /** When the application was submitted. */
    fun appliedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(appliedAt.getNullable("applied_at"))

    /** When the application was rejected. */
    fun rejectedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(rejectedAt.getNullable("rejected_at"))

    /** The application's source. */
    fun source(): Optional<String> = Optional.ofNullable(source.getNullable("source"))

    /** The user credited for this application. */
    fun creditedTo(): Optional<String> = Optional.ofNullable(creditedTo.getNullable("credited_to"))

    /** The application's current stage. */
    fun currentStage(): Optional<String> =
        Optional.ofNullable(currentStage.getNullable("current_stage"))

    /** The application's reason for rejection. */
    fun rejectReason(): Optional<String> =
        Optional.ofNullable(rejectReason.getNullable("reject_reason"))

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

    /** The candidate applying. */
    @JsonProperty("candidate") @ExcludeMissing fun _candidate() = candidate

    /** The job being applied for. */
    @JsonProperty("job") @ExcludeMissing fun _job() = job

    /** When the application was submitted. */
    @JsonProperty("applied_at") @ExcludeMissing fun _appliedAt() = appliedAt

    /** When the application was rejected. */
    @JsonProperty("rejected_at") @ExcludeMissing fun _rejectedAt() = rejectedAt

    /** The application's source. */
    @JsonProperty("source") @ExcludeMissing fun _source() = source

    /** The user credited for this application. */
    @JsonProperty("credited_to") @ExcludeMissing fun _creditedTo() = creditedTo

    /** The application's current stage. */
    @JsonProperty("current_stage") @ExcludeMissing fun _currentStage() = currentStage

    /** The application's reason for rejection. */
    @JsonProperty("reject_reason") @ExcludeMissing fun _rejectReason() = rejectReason

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
            candidate()
            job()
            appliedAt()
            rejectedAt()
            source()
            creditedTo()
            currentStage()
            rejectReason()
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

        return other is Application &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.candidate == other.candidate &&
            this.job == other.job &&
            this.appliedAt == other.appliedAt &&
            this.rejectedAt == other.rejectedAt &&
            this.source == other.source &&
            this.creditedTo == other.creditedTo &&
            this.currentStage == other.currentStage &&
            this.rejectReason == other.rejectReason &&
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
                    job,
                    appliedAt,
                    rejectedAt,
                    source,
                    creditedTo,
                    currentStage,
                    rejectReason,
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
        "Application{id=$id, remoteId=$remoteId, candidate=$candidate, job=$job, appliedAt=$appliedAt, rejectedAt=$rejectedAt, source=$source, creditedTo=$creditedTo, currentStage=$currentStage, rejectReason=$rejectReason, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var candidate: JsonField<String> = JsonMissing.of()
        private var job: JsonField<String> = JsonMissing.of()
        private var appliedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var rejectedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var source: JsonField<String> = JsonMissing.of()
        private var creditedTo: JsonField<String> = JsonMissing.of()
        private var currentStage: JsonField<String> = JsonMissing.of()
        private var rejectReason: JsonField<String> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(application: Application) = apply {
            this.id = application.id
            this.remoteId = application.remoteId
            this.candidate = application.candidate
            this.job = application.job
            this.appliedAt = application.appliedAt
            this.rejectedAt = application.rejectedAt
            this.source = application.source
            this.creditedTo = application.creditedTo
            this.currentStage = application.currentStage
            this.rejectReason = application.rejectReason
            this.remoteWasDeleted = application.remoteWasDeleted
            this.fieldMappings = application.fieldMappings
            this.modifiedAt = application.modifiedAt
            this.remoteData = application.remoteData
            additionalProperties(application.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The candidate applying. */
        fun candidate(candidate: String) = candidate(JsonField.of(candidate))

        /** The candidate applying. */
        @JsonProperty("candidate")
        @ExcludeMissing
        fun candidate(candidate: JsonField<String>) = apply { this.candidate = candidate }

        /** The job being applied for. */
        fun job(job: String) = job(JsonField.of(job))

        /** The job being applied for. */
        @JsonProperty("job")
        @ExcludeMissing
        fun job(job: JsonField<String>) = apply { this.job = job }

        /** When the application was submitted. */
        fun appliedAt(appliedAt: OffsetDateTime) = appliedAt(JsonField.of(appliedAt))

        /** When the application was submitted. */
        @JsonProperty("applied_at")
        @ExcludeMissing
        fun appliedAt(appliedAt: JsonField<OffsetDateTime>) = apply { this.appliedAt = appliedAt }

        /** When the application was rejected. */
        fun rejectedAt(rejectedAt: OffsetDateTime) = rejectedAt(JsonField.of(rejectedAt))

        /** When the application was rejected. */
        @JsonProperty("rejected_at")
        @ExcludeMissing
        fun rejectedAt(rejectedAt: JsonField<OffsetDateTime>) = apply {
            this.rejectedAt = rejectedAt
        }

        /** The application's source. */
        fun source(source: String) = source(JsonField.of(source))

        /** The application's source. */
        @JsonProperty("source")
        @ExcludeMissing
        fun source(source: JsonField<String>) = apply { this.source = source }

        /** The user credited for this application. */
        fun creditedTo(creditedTo: String) = creditedTo(JsonField.of(creditedTo))

        /** The user credited for this application. */
        @JsonProperty("credited_to")
        @ExcludeMissing
        fun creditedTo(creditedTo: JsonField<String>) = apply { this.creditedTo = creditedTo }

        /** The application's current stage. */
        fun currentStage(currentStage: String) = currentStage(JsonField.of(currentStage))

        /** The application's current stage. */
        @JsonProperty("current_stage")
        @ExcludeMissing
        fun currentStage(currentStage: JsonField<String>) = apply {
            this.currentStage = currentStage
        }

        /** The application's reason for rejection. */
        fun rejectReason(rejectReason: String) = rejectReason(JsonField.of(rejectReason))

        /** The application's reason for rejection. */
        @JsonProperty("reject_reason")
        @ExcludeMissing
        fun rejectReason(rejectReason: JsonField<String>) = apply {
            this.rejectReason = rejectReason
        }

        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

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

        fun build(): Application =
            Application(
                id,
                remoteId,
                candidate,
                job,
                appliedAt,
                rejectedAt,
                source,
                creditedTo,
                currentStage,
                rejectReason,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }
}
