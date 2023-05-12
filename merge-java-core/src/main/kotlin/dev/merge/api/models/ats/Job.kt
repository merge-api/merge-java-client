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
 * # The Job Object
 *
 * ### Description
 *
 * The `Job` object can be used to track any jobs that are currently or will be open/closed for
 * applications.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Jobs` endpoint to show all job postings.
 */
@JsonDeserialize(builder = Job.Builder::class)
@NoAutoDetect
class Job
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val name: JsonField<String>,
    private val description: JsonField<String>,
    private val code: JsonField<String>,
    private val status: JsonField<JobStatusEnum>,
    private val jobPostingUrls: JsonField<List<Url>>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val remoteUpdatedAt: JsonField<OffsetDateTime>,
    private val confidential: JsonField<Boolean>,
    private val departments: JsonField<List<String>>,
    private val offices: JsonField<List<String>>,
    private val hiringManagers: JsonField<List<String>>,
    private val recruiters: JsonField<List<String>>,
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

    /** The job's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The job's description. */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /**
     * The job's code. Typically an additional identifier used to reference the particular job that
     * is displayed on the ATS.
     */
    fun code(): Optional<String> = Optional.ofNullable(code.getNullable("code"))

    /**
     * - `OPEN` - OPEN
     * - `CLOSED` - CLOSED
     * - `DRAFT` - DRAFT
     * - `ARCHIVED` - ARCHIVED
     * - `PENDING` - PENDING
     */
    fun status(): Optional<JobStatusEnum> = Optional.ofNullable(status.getNullable("status"))

    fun jobPostingUrls(): Optional<List<Url>> =
        Optional.ofNullable(jobPostingUrls.getNullable("job_posting_urls"))

    /** When the third party's job was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** When the third party's job was updated. */
    fun remoteUpdatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteUpdatedAt.getNullable("remote_updated_at"))

    /** Whether the job is confidential. */
    fun confidential(): Optional<Boolean> =
        Optional.ofNullable(confidential.getNullable("confidential"))

    /** IDs of `Department` objects for this `Job`. */
    fun departments(): Optional<List<String>> =
        Optional.ofNullable(departments.getNullable("departments"))

    /** IDs of `Office` objects for this `Job`. */
    fun offices(): Optional<List<String>> = Optional.ofNullable(offices.getNullable("offices"))

    /** IDs of `RemoteUser` objects that serve as hiring managers for this `Job`. */
    fun hiringManagers(): Optional<List<String>> =
        Optional.ofNullable(hiringManagers.getNullable("hiring_managers"))

    /** IDs of `RemoteUser` objects that serve as recruiters for this `Job`. */
    fun recruiters(): Optional<List<String>> =
        Optional.ofNullable(recruiters.getNullable("recruiters"))

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

    /** The job's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The job's description. */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /**
     * The job's code. Typically an additional identifier used to reference the particular job that
     * is displayed on the ATS.
     */
    @JsonProperty("code") @ExcludeMissing fun _code() = code

    /**
     * - `OPEN` - OPEN
     * - `CLOSED` - CLOSED
     * - `DRAFT` - DRAFT
     * - `ARCHIVED` - ARCHIVED
     * - `PENDING` - PENDING
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("job_posting_urls") @ExcludeMissing fun _jobPostingUrls() = jobPostingUrls

    /** When the third party's job was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** When the third party's job was updated. */
    @JsonProperty("remote_updated_at") @ExcludeMissing fun _remoteUpdatedAt() = remoteUpdatedAt

    /** Whether the job is confidential. */
    @JsonProperty("confidential") @ExcludeMissing fun _confidential() = confidential

    /** IDs of `Department` objects for this `Job`. */
    @JsonProperty("departments") @ExcludeMissing fun _departments() = departments

    /** IDs of `Office` objects for this `Job`. */
    @JsonProperty("offices") @ExcludeMissing fun _offices() = offices

    /** IDs of `RemoteUser` objects that serve as hiring managers for this `Job`. */
    @JsonProperty("hiring_managers") @ExcludeMissing fun _hiringManagers() = hiringManagers

    /** IDs of `RemoteUser` objects that serve as recruiters for this `Job`. */
    @JsonProperty("recruiters") @ExcludeMissing fun _recruiters() = recruiters

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
            description()
            code()
            status()
            jobPostingUrls().map { it.forEach { it.validate() } }
            remoteCreatedAt()
            remoteUpdatedAt()
            confidential()
            departments()
            offices()
            hiringManagers()
            recruiters()
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

        return other is Job &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.name == other.name &&
            this.description == other.description &&
            this.code == other.code &&
            this.status == other.status &&
            this.jobPostingUrls == other.jobPostingUrls &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.remoteUpdatedAt == other.remoteUpdatedAt &&
            this.confidential == other.confidential &&
            this.departments == other.departments &&
            this.offices == other.offices &&
            this.hiringManagers == other.hiringManagers &&
            this.recruiters == other.recruiters &&
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
                    description,
                    code,
                    status,
                    jobPostingUrls,
                    remoteCreatedAt,
                    remoteUpdatedAt,
                    confidential,
                    departments,
                    offices,
                    hiringManagers,
                    recruiters,
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
        "Job{id=$id, remoteId=$remoteId, name=$name, description=$description, code=$code, status=$status, jobPostingUrls=$jobPostingUrls, remoteCreatedAt=$remoteCreatedAt, remoteUpdatedAt=$remoteUpdatedAt, confidential=$confidential, departments=$departments, offices=$offices, hiringManagers=$hiringManagers, recruiters=$recruiters, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var code: JsonField<String> = JsonMissing.of()
        private var status: JsonField<JobStatusEnum> = JsonMissing.of()
        private var jobPostingUrls: JsonField<List<Url>> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteUpdatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var confidential: JsonField<Boolean> = JsonMissing.of()
        private var departments: JsonField<List<String>> = JsonMissing.of()
        private var offices: JsonField<List<String>> = JsonMissing.of()
        private var hiringManagers: JsonField<List<String>> = JsonMissing.of()
        private var recruiters: JsonField<List<String>> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(job: Job) = apply {
            this.id = job.id
            this.remoteId = job.remoteId
            this.name = job.name
            this.description = job.description
            this.code = job.code
            this.status = job.status
            this.jobPostingUrls = job.jobPostingUrls
            this.remoteCreatedAt = job.remoteCreatedAt
            this.remoteUpdatedAt = job.remoteUpdatedAt
            this.confidential = job.confidential
            this.departments = job.departments
            this.offices = job.offices
            this.hiringManagers = job.hiringManagers
            this.recruiters = job.recruiters
            this.remoteWasDeleted = job.remoteWasDeleted
            this.fieldMappings = job.fieldMappings
            this.modifiedAt = job.modifiedAt
            this.remoteData = job.remoteData
            additionalProperties(job.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The job's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The job's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The job's description. */
        fun description(description: String) = description(JsonField.of(description))

        /** The job's description. */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /**
         * The job's code. Typically an additional identifier used to reference the particular job
         * that is displayed on the ATS.
         */
        fun code(code: String) = code(JsonField.of(code))

        /**
         * The job's code. Typically an additional identifier used to reference the particular job
         * that is displayed on the ATS.
         */
        @JsonProperty("code")
        @ExcludeMissing
        fun code(code: JsonField<String>) = apply { this.code = code }

        /**
         * - `OPEN` - OPEN
         * - `CLOSED` - CLOSED
         * - `DRAFT` - DRAFT
         * - `ARCHIVED` - ARCHIVED
         * - `PENDING` - PENDING
         */
        fun status(status: JobStatusEnum) = status(JsonField.of(status))

        /**
         * - `OPEN` - OPEN
         * - `CLOSED` - CLOSED
         * - `DRAFT` - DRAFT
         * - `ARCHIVED` - ARCHIVED
         * - `PENDING` - PENDING
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<JobStatusEnum>) = apply { this.status = status }

        fun jobPostingUrls(jobPostingUrls: List<Url>) = jobPostingUrls(JsonField.of(jobPostingUrls))

        @JsonProperty("job_posting_urls")
        @ExcludeMissing
        fun jobPostingUrls(jobPostingUrls: JsonField<List<Url>>) = apply {
            this.jobPostingUrls = jobPostingUrls
        }

        /** When the third party's job was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's job was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** When the third party's job was updated. */
        fun remoteUpdatedAt(remoteUpdatedAt: OffsetDateTime) =
            remoteUpdatedAt(JsonField.of(remoteUpdatedAt))

        /** When the third party's job was updated. */
        @JsonProperty("remote_updated_at")
        @ExcludeMissing
        fun remoteUpdatedAt(remoteUpdatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteUpdatedAt = remoteUpdatedAt
        }

        /** Whether the job is confidential. */
        fun confidential(confidential: Boolean) = confidential(JsonField.of(confidential))

        /** Whether the job is confidential. */
        @JsonProperty("confidential")
        @ExcludeMissing
        fun confidential(confidential: JsonField<Boolean>) = apply {
            this.confidential = confidential
        }

        /** IDs of `Department` objects for this `Job`. */
        fun departments(departments: List<String>) = departments(JsonField.of(departments))

        /** IDs of `Department` objects for this `Job`. */
        @JsonProperty("departments")
        @ExcludeMissing
        fun departments(departments: JsonField<List<String>>) = apply {
            this.departments = departments
        }

        /** IDs of `Office` objects for this `Job`. */
        fun offices(offices: List<String>) = offices(JsonField.of(offices))

        /** IDs of `Office` objects for this `Job`. */
        @JsonProperty("offices")
        @ExcludeMissing
        fun offices(offices: JsonField<List<String>>) = apply { this.offices = offices }

        /** IDs of `RemoteUser` objects that serve as hiring managers for this `Job`. */
        fun hiringManagers(hiringManagers: List<String>) =
            hiringManagers(JsonField.of(hiringManagers))

        /** IDs of `RemoteUser` objects that serve as hiring managers for this `Job`. */
        @JsonProperty("hiring_managers")
        @ExcludeMissing
        fun hiringManagers(hiringManagers: JsonField<List<String>>) = apply {
            this.hiringManagers = hiringManagers
        }

        /** IDs of `RemoteUser` objects that serve as recruiters for this `Job`. */
        fun recruiters(recruiters: List<String>) = recruiters(JsonField.of(recruiters))

        /** IDs of `RemoteUser` objects that serve as recruiters for this `Job`. */
        @JsonProperty("recruiters")
        @ExcludeMissing
        fun recruiters(recruiters: JsonField<List<String>>) = apply { this.recruiters = recruiters }

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

        fun build(): Job =
            Job(
                id,
                remoteId,
                name,
                description,
                code,
                status,
                jobPostingUrls.map { it.toUnmodifiable() },
                remoteCreatedAt,
                remoteUpdatedAt,
                confidential,
                departments.map { it.toUnmodifiable() },
                offices.map { it.toUnmodifiable() },
                hiringManagers.map { it.toUnmodifiable() },
                recruiters.map { it.toUnmodifiable() },
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class JobStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is JobStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val OPEN = JobStatusEnum(JsonField.of("OPEN"))

            @JvmField val CLOSED = JobStatusEnum(JsonField.of("CLOSED"))

            @JvmField val DRAFT = JobStatusEnum(JsonField.of("DRAFT"))

            @JvmField val ARCHIVED = JobStatusEnum(JsonField.of("ARCHIVED"))

            @JvmField val PENDING = JobStatusEnum(JsonField.of("PENDING"))

            @JvmStatic fun of(value: String) = JobStatusEnum(JsonField.of(value))
        }

        enum class Known {
            OPEN,
            CLOSED,
            DRAFT,
            ARCHIVED,
            PENDING,
        }

        enum class Value {
            OPEN,
            CLOSED,
            DRAFT,
            ARCHIVED,
            PENDING,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                OPEN -> Value.OPEN
                CLOSED -> Value.CLOSED
                DRAFT -> Value.DRAFT
                ARCHIVED -> Value.ARCHIVED
                PENDING -> Value.PENDING
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                OPEN -> Known.OPEN
                CLOSED -> Known.CLOSED
                DRAFT -> Known.DRAFT
                ARCHIVED -> Known.ARCHIVED
                PENDING -> Known.PENDING
                else -> throw MergeInvalidDataException("Unknown JobStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /**
     * # The Url Object
     *
     * ### Description
     *
     * The `Url` object is used to represent hyperlinks associated with the parent model.
     *
     * ### Usage Example
     *
     * Fetch from the `GET Candidate` endpoint and view their website urls.
     */
    @JsonDeserialize(builder = Url.Builder::class)
    @NoAutoDetect
    class Url
    private constructor(
        private val value: JsonField<String>,
        private val urlType: JsonField<UrlTypeEnum>,
        private val modifiedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** The site's url. */
        fun value(): Optional<String> = Optional.ofNullable(value.getNullable("value"))

        /**
         * - `PERSONAL` - PERSONAL
         * - `COMPANY` - COMPANY
         * - `PORTFOLIO` - PORTFOLIO
         * - `BLOG` - BLOG
         * - `SOCIAL_MEDIA` - SOCIAL_MEDIA
         * - `OTHER` - OTHER
         * - `JOB_POSTING` - JOB_POSTING
         */
        fun urlType(): Optional<UrlTypeEnum> = Optional.ofNullable(urlType.getNullable("url_type"))

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(): Optional<OffsetDateTime> =
            Optional.ofNullable(modifiedAt.getNullable("modified_at"))

        /** The site's url. */
        @JsonProperty("value") @ExcludeMissing fun _value() = value

        /**
         * - `PERSONAL` - PERSONAL
         * - `COMPANY` - COMPANY
         * - `PORTFOLIO` - PORTFOLIO
         * - `BLOG` - BLOG
         * - `SOCIAL_MEDIA` - SOCIAL_MEDIA
         * - `OTHER` - OTHER
         * - `JOB_POSTING` - JOB_POSTING
         */
        @JsonProperty("url_type") @ExcludeMissing fun _urlType() = urlType

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                value()
                urlType()
                modifiedAt()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Url &&
                this.value == other.value &&
                this.urlType == other.urlType &&
                this.modifiedAt == other.modifiedAt &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        value,
                        urlType,
                        modifiedAt,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Url{value=$value, urlType=$urlType, modifiedAt=$modifiedAt, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var value: JsonField<String> = JsonMissing.of()
            private var urlType: JsonField<UrlTypeEnum> = JsonMissing.of()
            private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(url: Url) = apply {
                this.value = url.value
                this.urlType = url.urlType
                this.modifiedAt = url.modifiedAt
                additionalProperties(url.additionalProperties)
            }

            /** The site's url. */
            fun value(value: String) = value(JsonField.of(value))

            /** The site's url. */
            @JsonProperty("value")
            @ExcludeMissing
            fun value(value: JsonField<String>) = apply { this.value = value }

            /**
             * - `PERSONAL` - PERSONAL
             * - `COMPANY` - COMPANY
             * - `PORTFOLIO` - PORTFOLIO
             * - `BLOG` - BLOG
             * - `SOCIAL_MEDIA` - SOCIAL_MEDIA
             * - `OTHER` - OTHER
             * - `JOB_POSTING` - JOB_POSTING
             */
            fun urlType(urlType: UrlTypeEnum) = urlType(JsonField.of(urlType))

            /**
             * - `PERSONAL` - PERSONAL
             * - `COMPANY` - COMPANY
             * - `PORTFOLIO` - PORTFOLIO
             * - `BLOG` - BLOG
             * - `SOCIAL_MEDIA` - SOCIAL_MEDIA
             * - `OTHER` - OTHER
             * - `JOB_POSTING` - JOB_POSTING
             */
            @JsonProperty("url_type")
            @ExcludeMissing
            fun urlType(urlType: JsonField<UrlTypeEnum>) = apply { this.urlType = urlType }

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

            fun build(): Url =
                Url(
                    value,
                    urlType,
                    modifiedAt,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class UrlTypeEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UrlTypeEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val PERSONAL = UrlTypeEnum(JsonField.of("PERSONAL"))

                @JvmField val COMPANY = UrlTypeEnum(JsonField.of("COMPANY"))

                @JvmField val PORTFOLIO = UrlTypeEnum(JsonField.of("PORTFOLIO"))

                @JvmField val BLOG = UrlTypeEnum(JsonField.of("BLOG"))

                @JvmField val SOCIAL_MEDIA = UrlTypeEnum(JsonField.of("SOCIAL_MEDIA"))

                @JvmField val OTHER = UrlTypeEnum(JsonField.of("OTHER"))

                @JvmField val JOB_POSTING = UrlTypeEnum(JsonField.of("JOB_POSTING"))

                @JvmStatic fun of(value: String) = UrlTypeEnum(JsonField.of(value))
            }

            enum class Known {
                PERSONAL,
                COMPANY,
                PORTFOLIO,
                BLOG,
                SOCIAL_MEDIA,
                OTHER,
                JOB_POSTING,
            }

            enum class Value {
                PERSONAL,
                COMPANY,
                PORTFOLIO,
                BLOG,
                SOCIAL_MEDIA,
                OTHER,
                JOB_POSTING,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    PERSONAL -> Value.PERSONAL
                    COMPANY -> Value.COMPANY
                    PORTFOLIO -> Value.PORTFOLIO
                    BLOG -> Value.BLOG
                    SOCIAL_MEDIA -> Value.SOCIAL_MEDIA
                    OTHER -> Value.OTHER
                    JOB_POSTING -> Value.JOB_POSTING
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    PERSONAL -> Known.PERSONAL
                    COMPANY -> Known.COMPANY
                    PORTFOLIO -> Known.PORTFOLIO
                    BLOG -> Known.BLOG
                    SOCIAL_MEDIA -> Known.SOCIAL_MEDIA
                    OTHER -> Known.OTHER
                    JOB_POSTING -> Known.JOB_POSTING
                    else -> throw MergeInvalidDataException("Unknown UrlTypeEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
