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
 * # The Activity Object
 *
 * ### Description
 *
 * The `Activity` object is used to represent an activity for a candidate performed by a user.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Activities` endpoint and filter by `ID` to show all activities.
 */
@JsonDeserialize(builder = Activity.Builder::class)
@NoAutoDetect
class Activity
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val user: JsonField<String>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val activityType: JsonField<ActivityTypeEnum>,
    private val subject: JsonField<String>,
    private val body: JsonField<String>,
    private val visibility: JsonField<VisibilityEnum>,
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

    /** The user that performed the action. */
    fun user(): Optional<String> = Optional.ofNullable(user.getNullable("user"))

    /** When the third party's activity was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /**
     * - `CALL` - CALL
     * - `MEETING` - MEETING
     * - `EMAIL` - EMAIL
     */
    fun activityType(): Optional<ActivityTypeEnum> =
        Optional.ofNullable(activityType.getNullable("activity_type"))

    /** The activity's subject. */
    fun subject(): Optional<String> = Optional.ofNullable(subject.getNullable("subject"))

    /** The activity's body. */
    fun body(): Optional<String> = Optional.ofNullable(body.getNullable("body"))

    /**
     * - `ADMIN_ONLY` - ADMIN_ONLY
     * - `PUBLIC` - PUBLIC
     * - `PRIVATE` - PRIVATE
     */
    fun visibility(): Optional<VisibilityEnum> =
        Optional.ofNullable(visibility.getNullable("visibility"))

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

    /** The user that performed the action. */
    @JsonProperty("user") @ExcludeMissing fun _user() = user

    /** When the third party's activity was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /**
     * - `CALL` - CALL
     * - `MEETING` - MEETING
     * - `EMAIL` - EMAIL
     */
    @JsonProperty("activity_type") @ExcludeMissing fun _activityType() = activityType

    /** The activity's subject. */
    @JsonProperty("subject") @ExcludeMissing fun _subject() = subject

    /** The activity's body. */
    @JsonProperty("body") @ExcludeMissing fun _body() = body

    /**
     * - `ADMIN_ONLY` - ADMIN_ONLY
     * - `PUBLIC` - PUBLIC
     * - `PRIVATE` - PRIVATE
     */
    @JsonProperty("visibility") @ExcludeMissing fun _visibility() = visibility

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
            user()
            remoteCreatedAt()
            activityType()
            subject()
            body()
            visibility()
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

        return other is Activity &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.user == other.user &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.activityType == other.activityType &&
            this.subject == other.subject &&
            this.body == other.body &&
            this.visibility == other.visibility &&
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
                    user,
                    remoteCreatedAt,
                    activityType,
                    subject,
                    body,
                    visibility,
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
        "Activity{id=$id, remoteId=$remoteId, user=$user, remoteCreatedAt=$remoteCreatedAt, activityType=$activityType, subject=$subject, body=$body, visibility=$visibility, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var user: JsonField<String> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var activityType: JsonField<ActivityTypeEnum> = JsonMissing.of()
        private var subject: JsonField<String> = JsonMissing.of()
        private var body: JsonField<String> = JsonMissing.of()
        private var visibility: JsonField<VisibilityEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(activity: Activity) = apply {
            this.id = activity.id
            this.remoteId = activity.remoteId
            this.user = activity.user
            this.remoteCreatedAt = activity.remoteCreatedAt
            this.activityType = activity.activityType
            this.subject = activity.subject
            this.body = activity.body
            this.visibility = activity.visibility
            this.remoteWasDeleted = activity.remoteWasDeleted
            this.fieldMappings = activity.fieldMappings
            this.modifiedAt = activity.modifiedAt
            this.remoteData = activity.remoteData
            additionalProperties(activity.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The user that performed the action. */
        fun user(user: String) = user(JsonField.of(user))

        /** The user that performed the action. */
        @JsonProperty("user")
        @ExcludeMissing
        fun user(user: JsonField<String>) = apply { this.user = user }

        /** When the third party's activity was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's activity was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /**
         * - `CALL` - CALL
         * - `MEETING` - MEETING
         * - `EMAIL` - EMAIL
         */
        fun activityType(activityType: ActivityTypeEnum) = activityType(JsonField.of(activityType))

        /**
         * - `CALL` - CALL
         * - `MEETING` - MEETING
         * - `EMAIL` - EMAIL
         */
        @JsonProperty("activity_type")
        @ExcludeMissing
        fun activityType(activityType: JsonField<ActivityTypeEnum>) = apply {
            this.activityType = activityType
        }

        /** The activity's subject. */
        fun subject(subject: String) = subject(JsonField.of(subject))

        /** The activity's subject. */
        @JsonProperty("subject")
        @ExcludeMissing
        fun subject(subject: JsonField<String>) = apply { this.subject = subject }

        /** The activity's body. */
        fun body(body: String) = body(JsonField.of(body))

        /** The activity's body. */
        @JsonProperty("body")
        @ExcludeMissing
        fun body(body: JsonField<String>) = apply { this.body = body }

        /**
         * - `ADMIN_ONLY` - ADMIN_ONLY
         * - `PUBLIC` - PUBLIC
         * - `PRIVATE` - PRIVATE
         */
        fun visibility(visibility: VisibilityEnum) = visibility(JsonField.of(visibility))

        /**
         * - `ADMIN_ONLY` - ADMIN_ONLY
         * - `PUBLIC` - PUBLIC
         * - `PRIVATE` - PRIVATE
         */
        @JsonProperty("visibility")
        @ExcludeMissing
        fun visibility(visibility: JsonField<VisibilityEnum>) = apply {
            this.visibility = visibility
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

        fun build(): Activity =
            Activity(
                id,
                remoteId,
                user,
                remoteCreatedAt,
                activityType,
                subject,
                body,
                visibility,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class ActivityTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ActivityTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val CALL = ActivityTypeEnum(JsonField.of("CALL"))

            @JvmField val MEETING = ActivityTypeEnum(JsonField.of("MEETING"))

            @JvmField val EMAIL = ActivityTypeEnum(JsonField.of("EMAIL"))

            @JvmStatic fun of(value: String) = ActivityTypeEnum(JsonField.of(value))
        }

        enum class Known {
            CALL,
            MEETING,
            EMAIL,
        }

        enum class Value {
            CALL,
            MEETING,
            EMAIL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CALL -> Value.CALL
                MEETING -> Value.MEETING
                EMAIL -> Value.EMAIL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CALL -> Known.CALL
                MEETING -> Known.MEETING
                EMAIL -> Known.EMAIL
                else -> throw MergeInvalidDataException("Unknown ActivityTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class VisibilityEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is VisibilityEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ADMIN_ONLY = VisibilityEnum(JsonField.of("ADMIN_ONLY"))

            @JvmField val PUBLIC = VisibilityEnum(JsonField.of("PUBLIC"))

            @JvmField val PRIVATE = VisibilityEnum(JsonField.of("PRIVATE"))

            @JvmStatic fun of(value: String) = VisibilityEnum(JsonField.of(value))
        }

        enum class Known {
            ADMIN_ONLY,
            PUBLIC,
            PRIVATE,
        }

        enum class Value {
            ADMIN_ONLY,
            PUBLIC,
            PRIVATE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ADMIN_ONLY -> Value.ADMIN_ONLY
                PUBLIC -> Value.PUBLIC
                PRIVATE -> Value.PRIVATE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ADMIN_ONLY -> Known.ADMIN_ONLY
                PUBLIC -> Known.PUBLIC
                PRIVATE -> Known.PRIVATE
                else -> throw MergeInvalidDataException("Unknown VisibilityEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
