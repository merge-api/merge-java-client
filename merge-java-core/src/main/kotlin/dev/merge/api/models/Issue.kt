package dev.merge.api.models

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
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = Issue.Builder::class)
@NoAutoDetect
class Issue
private constructor(
    private val id: JsonField<String>,
    private val status: JsonField<IssueStatusEnum>,
    private val errorDescription: JsonField<String>,
    private val endUser: JsonField<String>,
    private val firstIncidentTime: JsonField<OffsetDateTime>,
    private val lastIncidentTime: JsonField<OffsetDateTime>,
    private val isMuted: JsonField<Boolean>,
    private val errorDetails: JsonField<List<String>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /**
     * - `ONGOING` - ONGOING
     * - `RESOLVED` - RESOLVED
     */
    fun status(): Optional<IssueStatusEnum> = Optional.ofNullable(status.getNullable("status"))

    fun errorDescription(): String = errorDescription.getRequired("error_description")

    fun endUser(): Optional<String> = Optional.ofNullable(endUser.getNullable("end_user"))

    fun firstIncidentTime(): Optional<OffsetDateTime> =
        Optional.ofNullable(firstIncidentTime.getNullable("first_incident_time"))

    fun lastIncidentTime(): Optional<OffsetDateTime> =
        Optional.ofNullable(lastIncidentTime.getNullable("last_incident_time"))

    fun isMuted(): Optional<Boolean> = Optional.ofNullable(isMuted.getNullable("is_muted"))

    fun errorDetails(): Optional<List<String>> =
        Optional.ofNullable(errorDetails.getNullable("error_details"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /**
     * - `ONGOING` - ONGOING
     * - `RESOLVED` - RESOLVED
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("error_description") @ExcludeMissing fun _errorDescription() = errorDescription

    @JsonProperty("end_user") @ExcludeMissing fun _endUser() = endUser

    @JsonProperty("first_incident_time")
    @ExcludeMissing
    fun _firstIncidentTime() = firstIncidentTime

    @JsonProperty("last_incident_time") @ExcludeMissing fun _lastIncidentTime() = lastIncidentTime

    @JsonProperty("is_muted") @ExcludeMissing fun _isMuted() = isMuted

    @JsonProperty("error_details") @ExcludeMissing fun _errorDetails() = errorDetails

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Issue = apply {
        if (!validated) {
            id()
            status()
            errorDescription()
            endUser()
            firstIncidentTime()
            lastIncidentTime()
            isMuted()
            errorDetails()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Issue &&
            this.id == other.id &&
            this.status == other.status &&
            this.errorDescription == other.errorDescription &&
            this.endUser == other.endUser &&
            this.firstIncidentTime == other.firstIncidentTime &&
            this.lastIncidentTime == other.lastIncidentTime &&
            this.isMuted == other.isMuted &&
            this.errorDetails == other.errorDetails &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    status,
                    errorDescription,
                    endUser,
                    firstIncidentTime,
                    lastIncidentTime,
                    isMuted,
                    errorDetails,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Issue{id=$id, status=$status, errorDescription=$errorDescription, endUser=$endUser, firstIncidentTime=$firstIncidentTime, lastIncidentTime=$lastIncidentTime, isMuted=$isMuted, errorDetails=$errorDetails, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var status: JsonField<IssueStatusEnum> = JsonMissing.of()
        private var errorDescription: JsonField<String> = JsonMissing.of()
        private var endUser: JsonField<String> = JsonMissing.of()
        private var firstIncidentTime: JsonField<OffsetDateTime> = JsonMissing.of()
        private var lastIncidentTime: JsonField<OffsetDateTime> = JsonMissing.of()
        private var isMuted: JsonField<Boolean> = JsonMissing.of()
        private var errorDetails: JsonField<List<String>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(issue: Issue) = apply {
            this.id = issue.id
            this.status = issue.status
            this.errorDescription = issue.errorDescription
            this.endUser = issue.endUser
            this.firstIncidentTime = issue.firstIncidentTime
            this.lastIncidentTime = issue.lastIncidentTime
            this.isMuted = issue.isMuted
            this.errorDetails = issue.errorDetails
            additionalProperties(issue.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * - `ONGOING` - ONGOING
         * - `RESOLVED` - RESOLVED
         */
        fun status(status: IssueStatusEnum) = status(JsonField.of(status))

        /**
         * - `ONGOING` - ONGOING
         * - `RESOLVED` - RESOLVED
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<IssueStatusEnum>) = apply { this.status = status }

        fun errorDescription(errorDescription: String) =
            errorDescription(JsonField.of(errorDescription))

        @JsonProperty("error_description")
        @ExcludeMissing
        fun errorDescription(errorDescription: JsonField<String>) = apply {
            this.errorDescription = errorDescription
        }

        fun endUser(endUser: String) = endUser(JsonField.of(endUser))

        @JsonProperty("end_user")
        @ExcludeMissing
        fun endUser(endUser: JsonField<String>) = apply { this.endUser = endUser }

        fun firstIncidentTime(firstIncidentTime: OffsetDateTime) =
            firstIncidentTime(JsonField.of(firstIncidentTime))

        @JsonProperty("first_incident_time")
        @ExcludeMissing
        fun firstIncidentTime(firstIncidentTime: JsonField<OffsetDateTime>) = apply {
            this.firstIncidentTime = firstIncidentTime
        }

        fun lastIncidentTime(lastIncidentTime: OffsetDateTime) =
            lastIncidentTime(JsonField.of(lastIncidentTime))

        @JsonProperty("last_incident_time")
        @ExcludeMissing
        fun lastIncidentTime(lastIncidentTime: JsonField<OffsetDateTime>) = apply {
            this.lastIncidentTime = lastIncidentTime
        }

        fun isMuted(isMuted: Boolean) = isMuted(JsonField.of(isMuted))

        @JsonProperty("is_muted")
        @ExcludeMissing
        fun isMuted(isMuted: JsonField<Boolean>) = apply { this.isMuted = isMuted }

        fun errorDetails(errorDetails: List<String>) = errorDetails(JsonField.of(errorDetails))

        @JsonProperty("error_details")
        @ExcludeMissing
        fun errorDetails(errorDetails: JsonField<List<String>>) = apply {
            this.errorDetails = errorDetails
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

        fun build(): Issue =
            Issue(
                id,
                status,
                errorDescription,
                endUser,
                firstIncidentTime,
                lastIncidentTime,
                isMuted,
                errorDetails.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class IssueStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is IssueStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ONGOING = IssueStatusEnum(JsonField.of("ONGOING"))

            @JvmField val RESOLVED = IssueStatusEnum(JsonField.of("RESOLVED"))

            @JvmStatic fun of(value: String) = IssueStatusEnum(JsonField.of(value))
        }

        enum class Known {
            ONGOING,
            RESOLVED,
        }

        enum class Value {
            ONGOING,
            RESOLVED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ONGOING -> Value.ONGOING
                RESOLVED -> Value.RESOLVED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ONGOING -> Known.ONGOING
                RESOLVED -> Known.RESOLVED
                else -> throw MergeInvalidDataException("Unknown IssueStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
