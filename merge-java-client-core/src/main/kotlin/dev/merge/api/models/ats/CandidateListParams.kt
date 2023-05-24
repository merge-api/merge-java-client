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

class CandidateListParams
constructor(
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val emailAddresses: String?,
    private val expand: List<Expand>?,
    private val firstName: String?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val lastName: String?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val pageSize: Long?,
    private val remoteId: String?,
    private val tags: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun emailAddresses(): Optional<String> = Optional.ofNullable(emailAddresses)

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun firstName(): Optional<String> = Optional.ofNullable(firstName)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun lastName(): Optional<String> = Optional.ofNullable(lastName)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    fun tags(): Optional<String> = Optional.ofNullable(tags)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.emailAddresses?.let { params.put("email_addresses", listOf(it.toString())) }
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.firstName?.let { params.put("first_name", listOf(it.toString())) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.lastName?.let { params.put("last_name", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
        this.tags?.let { params.put("tags", listOf(it.toString())) }
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

        return other is CandidateListParams &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.emailAddresses == other.emailAddresses &&
            this.expand == other.expand &&
            this.firstName == other.firstName &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.lastName == other.lastName &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.pageSize == other.pageSize &&
            this.remoteId == other.remoteId &&
            this.tags == other.tags &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            createdAfter,
            createdBefore,
            cursor,
            emailAddresses,
            expand,
            firstName,
            includeDeletedData,
            includeRemoteData,
            lastName,
            modifiedAfter,
            modifiedBefore,
            pageSize,
            remoteId,
            tags,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "CandidateListParams{createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, emailAddresses=$emailAddresses, expand=$expand, firstName=$firstName, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, lastName=$lastName, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, pageSize=$pageSize, remoteId=$remoteId, tags=$tags, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var createdAfter: OffsetDateTime? = null
        private var createdBefore: OffsetDateTime? = null
        private var cursor: String? = null
        private var emailAddresses: String? = null
        private var expand: List<Expand>? = null
        private var firstName: String? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var lastName: String? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var pageSize: Long? = null
        private var remoteId: String? = null
        private var tags: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(candidateListParams: CandidateListParams) = apply {
            this.createdAfter = candidateListParams.createdAfter
            this.createdBefore = candidateListParams.createdBefore
            this.cursor = candidateListParams.cursor
            this.emailAddresses = candidateListParams.emailAddresses
            this.expand = candidateListParams.expand
            this.firstName = candidateListParams.firstName
            this.includeDeletedData = candidateListParams.includeDeletedData
            this.includeRemoteData = candidateListParams.includeRemoteData
            this.lastName = candidateListParams.lastName
            this.modifiedAfter = candidateListParams.modifiedAfter
            this.modifiedBefore = candidateListParams.modifiedBefore
            this.pageSize = candidateListParams.pageSize
            this.remoteId = candidateListParams.remoteId
            this.tags = candidateListParams.tags
            additionalQueryParams(candidateListParams.additionalQueryParams)
            additionalHeaders(candidateListParams.additionalHeaders)
        }

        /** If provided, will only return objects created after this datetime. */
        fun createdAfter(createdAfter: OffsetDateTime) = apply { this.createdAfter = createdAfter }

        /** If provided, will only return objects created before this datetime. */
        fun createdBefore(createdBefore: OffsetDateTime) = apply {
            this.createdBefore = createdBefore
        }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

        /**
         * If provided, will only return candidates with these email addresses; multiple addresses
         * can be separated by commas.
         */
        fun emailAddresses(emailAddresses: String) = apply { this.emailAddresses = emailAddresses }

        /**
         * Which relations should be returned in expanded form. Multiple relation names should be
         * comma separated without spaces.
         */
        fun expand(expand: List<Expand>) = apply { this.expand = expand }

        /** If provided, will only return candidates with this first name. */
        fun firstName(firstName: String) = apply { this.firstName = firstName }

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

        /** If provided, will only return candidates with this last name. */
        fun lastName(lastName: String) = apply { this.lastName = lastName }

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

        /** The API provider's ID for the given object. */
        fun remoteId(remoteId: String) = apply { this.remoteId = remoteId }

        /**
         * If provided, will only return candidates with these tags; multiple tags can be separated
         * by commas.
         */
        fun tags(tags: String) = apply { this.tags = tags }

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

        fun build(): CandidateListParams =
            CandidateListParams(
                createdAfter,
                createdBefore,
                cursor,
                emailAddresses,
                expand?.toUnmodifiable(),
                firstName,
                includeDeletedData,
                includeRemoteData,
                lastName,
                modifiedAfter,
                modifiedBefore,
                pageSize,
                remoteId,
                tags,
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

            @JvmField val APPLICATIONS = Expand(JsonField.of("applications"))

            @JvmField val ATTACHMENTS = Expand(JsonField.of("attachments"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            APPLICATIONS,
            ATTACHMENTS,
        }

        enum class Value {
            APPLICATIONS,
            ATTACHMENTS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                APPLICATIONS -> Value.APPLICATIONS
                ATTACHMENTS -> Value.ATTACHMENTS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                APPLICATIONS -> Known.APPLICATIONS
                ATTACHMENTS -> Known.ATTACHMENTS
                else -> throw MergeInvalidDataException("Unknown Expand: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
