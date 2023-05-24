package dev.merge.api.models.ats

import com.fasterxml.jackson.annotation.JsonCreator
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

class ApplicationListParams
constructor(
    private val candidateId: String?,
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val creditedToId: String?,
    private val currentStageId: String?,
    private val cursor: String?,
    private val expand: List<Expand>?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val jobId: String?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val pageSize: Long?,
    private val rejectReasonId: String?,
    private val remoteId: String?,
    private val source: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun candidateId(): Optional<String> = Optional.ofNullable(candidateId)

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun creditedToId(): Optional<String> = Optional.ofNullable(creditedToId)

    fun currentStageId(): Optional<String> = Optional.ofNullable(currentStageId)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun jobId(): Optional<String> = Optional.ofNullable(jobId)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun rejectReasonId(): Optional<String> = Optional.ofNullable(rejectReasonId)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    fun source(): Optional<String> = Optional.ofNullable(source)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.candidateId?.let { params.put("candidate_id", listOf(it.toString())) }
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.creditedToId?.let { params.put("credited_to_id", listOf(it.toString())) }
        this.currentStageId?.let { params.put("current_stage_id", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.jobId?.let { params.put("job_id", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.rejectReasonId?.let { params.put("reject_reason_id", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
        this.source?.let { params.put("source", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ApplicationListParams &&
            this.candidateId == other.candidateId &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.creditedToId == other.creditedToId &&
            this.currentStageId == other.currentStageId &&
            this.cursor == other.cursor &&
            this.expand == other.expand &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.jobId == other.jobId &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.pageSize == other.pageSize &&
            this.rejectReasonId == other.rejectReasonId &&
            this.remoteId == other.remoteId &&
            this.source == other.source &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            candidateId,
            createdAfter,
            createdBefore,
            creditedToId,
            currentStageId,
            cursor,
            expand,
            includeDeletedData,
            includeRemoteData,
            jobId,
            modifiedAfter,
            modifiedBefore,
            pageSize,
            rejectReasonId,
            remoteId,
            source,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "ApplicationListParams{candidateId=$candidateId, createdAfter=$createdAfter, createdBefore=$createdBefore, creditedToId=$creditedToId, currentStageId=$currentStageId, cursor=$cursor, expand=$expand, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, jobId=$jobId, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, pageSize=$pageSize, rejectReasonId=$rejectReasonId, remoteId=$remoteId, source=$source, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var candidateId: String? = null
        private var createdAfter: OffsetDateTime? = null
        private var createdBefore: OffsetDateTime? = null
        private var creditedToId: String? = null
        private var currentStageId: String? = null
        private var cursor: String? = null
        private var expand: List<Expand>? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var jobId: String? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var pageSize: Long? = null
        private var rejectReasonId: String? = null
        private var remoteId: String? = null
        private var source: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(applicationListParams: ApplicationListParams) = apply {
            this.candidateId = applicationListParams.candidateId
            this.createdAfter = applicationListParams.createdAfter
            this.createdBefore = applicationListParams.createdBefore
            this.creditedToId = applicationListParams.creditedToId
            this.currentStageId = applicationListParams.currentStageId
            this.cursor = applicationListParams.cursor
            this.expand = applicationListParams.expand
            this.includeDeletedData = applicationListParams.includeDeletedData
            this.includeRemoteData = applicationListParams.includeRemoteData
            this.jobId = applicationListParams.jobId
            this.modifiedAfter = applicationListParams.modifiedAfter
            this.modifiedBefore = applicationListParams.modifiedBefore
            this.pageSize = applicationListParams.pageSize
            this.rejectReasonId = applicationListParams.rejectReasonId
            this.remoteId = applicationListParams.remoteId
            this.source = applicationListParams.source
            additionalQueryParams(applicationListParams.additionalQueryParams)
            additionalHeaders(applicationListParams.additionalHeaders)
        }

        /** If provided, will only return applications for this candidate. */
        fun candidateId(candidateId: String) = apply { this.candidateId = candidateId }

        /** If provided, will only return objects created after this datetime. */
        fun createdAfter(createdAfter: OffsetDateTime) = apply { this.createdAfter = createdAfter }

        /** If provided, will only return objects created before this datetime. */
        fun createdBefore(createdBefore: OffsetDateTime) = apply {
            this.createdBefore = createdBefore
        }

        /** If provided, will only return applications credited to this user. */
        fun creditedToId(creditedToId: String) = apply { this.creditedToId = creditedToId }

        /** If provided, will only return applications at this interview stage. */
        fun currentStageId(currentStageId: String) = apply { this.currentStageId = currentStageId }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

        /**
         * Which relations should be returned in expanded form. Multiple relation names should be
         * comma separated without spaces.
         */
        fun expand(expand: List<Expand>) = apply { this.expand = expand }

        /** Whether to include data that was marked as deleted by third party webhooks. */
        fun includeDeletedData(includeDeletedData: Boolean) = apply {
            this.includeDeletedData = includeDeletedData
        }

        /**
         * Whether to include the original data Merge fetched from the third-party to produce these
         * models.
         */
        fun includeRemoteData(includeRemoteData: Boolean) = apply {
            this.includeRemoteData = includeRemoteData
        }

        /** If provided, will only return applications for this job. */
        fun jobId(jobId: String) = apply { this.jobId = jobId }

        /** If provided, only objects synced by Merge after this date time will be returned. */
        fun modifiedAfter(modifiedAfter: OffsetDateTime) = apply {
            this.modifiedAfter = modifiedAfter
        }

        /** If provided, only objects synced by Merge before this date time will be returned. */
        fun modifiedBefore(modifiedBefore: OffsetDateTime) = apply {
            this.modifiedBefore = modifiedBefore
        }

        /** Number of results to return per page. */
        fun pageSize(pageSize: Long) = apply { this.pageSize = pageSize }

        /** If provided, will only return applications with this reject reason. */
        fun rejectReasonId(rejectReasonId: String) = apply { this.rejectReasonId = rejectReasonId }

        /** The API provider's ID for the given object. */
        fun remoteId(remoteId: String) = apply { this.remoteId = remoteId }

        /** If provided, will only return applications with this source. */
        fun source(source: String) = apply { this.source = source }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun build(): ApplicationListParams =
            ApplicationListParams(
                candidateId,
                createdAfter,
                createdBefore,
                creditedToId,
                currentStageId,
                cursor,
                expand?.toUnmodifiable(),
                includeDeletedData,
                includeRemoteData,
                jobId,
                modifiedAfter,
                modifiedBefore,
                pageSize,
                rejectReasonId,
                remoteId,
                source,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }

    class Expand
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Expand && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val CANDIDATE = Expand(JsonField.of("candidate"))

            @JvmField val CREDITED_TO = Expand(JsonField.of("credited_to"))

            @JvmField val CURRENT_STAGE = Expand(JsonField.of("current_stage"))

            @JvmField val JOB = Expand(JsonField.of("job"))

            @JvmField val REJECT_REASON = Expand(JsonField.of("reject_reason"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            CANDIDATE,
            CREDITED_TO,
            CURRENT_STAGE,
            JOB,
            REJECT_REASON,
        }

        enum class Value {
            CANDIDATE,
            CREDITED_TO,
            CURRENT_STAGE,
            JOB,
            REJECT_REASON,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CANDIDATE -> Value.CANDIDATE
                CREDITED_TO -> Value.CREDITED_TO
                CURRENT_STAGE -> Value.CURRENT_STAGE
                JOB -> Value.JOB
                REJECT_REASON -> Value.REJECT_REASON
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CANDIDATE -> Known.CANDIDATE
                CREDITED_TO -> Known.CREDITED_TO
                CURRENT_STAGE -> Known.CURRENT_STAGE
                JOB -> Known.JOB
                REJECT_REASON -> Known.REJECT_REASON
                else -> throw MergeInvalidDataException("Unknown Expand: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
