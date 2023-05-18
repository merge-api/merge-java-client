package dev.merge.api.models.marketing

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
 * # The User Object
 *
 * ### Description
 *
 * The `User` object is used to represent a user in the remote system.
 *
 * ### Usage Example
 *
 * Fetch from the `GET /api/mktg/v1/users` endpoint and view their email addresses.
 */
@JsonDeserialize(builder = User.Builder::class)
@NoAutoDetect
class User
private constructor(
    private val name: JsonField<String>,
    private val username: JsonField<String>,
    private val email: JsonField<String>,
    private val role: JsonField<RoleEnum>,
    private val timezone: JsonField<String>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The user's full name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The user's username. */
    fun username(): Optional<String> = Optional.ofNullable(username.getNullable("username"))

    /** The user's email. */
    fun email(): Optional<String> = Optional.ofNullable(email.getNullable("email"))

    /**
     * - `ADMIN` - ADMIN
     * - `MANAGER` - MANAGER
     * - `CONTRIBUTOR` - CONTRIBUTOR
     * - `VIEWER` - VIEWER
     */
    fun role(): Optional<RoleEnum> = Optional.ofNullable(role.getNullable("role"))

    /** The user's timezone. */
    fun timezone(): Optional<String> = Optional.ofNullable(timezone.getNullable("timezone"))

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    fun remoteWasDeleted(): Optional<Boolean> =
        Optional.ofNullable(remoteWasDeleted.getNullable("remote_was_deleted"))

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<RemoteData>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    /** The user's full name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The user's username. */
    @JsonProperty("username") @ExcludeMissing fun _username() = username

    /** The user's email. */
    @JsonProperty("email") @ExcludeMissing fun _email() = email

    /**
     * - `ADMIN` - ADMIN
     * - `MANAGER` - MANAGER
     * - `CONTRIBUTOR` - CONTRIBUTOR
     * - `VIEWER` - VIEWER
     */
    @JsonProperty("role") @ExcludeMissing fun _role() = role

    /** The user's timezone. */
    @JsonProperty("timezone") @ExcludeMissing fun _timezone() = timezone

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): User = apply {
        if (!validated) {
            name()
            username()
            email()
            role()
            timezone()
            remoteWasDeleted()
            id()
            remoteId()
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

        return other is User &&
            this.name == other.name &&
            this.username == other.username &&
            this.email == other.email &&
            this.role == other.role &&
            this.timezone == other.timezone &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    name,
                    username,
                    email,
                    role,
                    timezone,
                    remoteWasDeleted,
                    id,
                    remoteId,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "User{name=$name, username=$username, email=$email, role=$role, timezone=$timezone, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var username: JsonField<String> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var role: JsonField<RoleEnum> = JsonMissing.of()
        private var timezone: JsonField<String> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(user: User) = apply {
            this.name = user.name
            this.username = user.username
            this.email = user.email
            this.role = user.role
            this.timezone = user.timezone
            this.remoteWasDeleted = user.remoteWasDeleted
            this.id = user.id
            this.remoteId = user.remoteId
            this.fieldMappings = user.fieldMappings
            this.modifiedAt = user.modifiedAt
            this.remoteData = user.remoteData
            additionalProperties(user.additionalProperties)
        }

        /** The user's full name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The user's full name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The user's username. */
        fun username(username: String) = username(JsonField.of(username))

        /** The user's username. */
        @JsonProperty("username")
        @ExcludeMissing
        fun username(username: JsonField<String>) = apply { this.username = username }

        /** The user's email. */
        fun email(email: String) = email(JsonField.of(email))

        /** The user's email. */
        @JsonProperty("email")
        @ExcludeMissing
        fun email(email: JsonField<String>) = apply { this.email = email }

        /**
         * - `ADMIN` - ADMIN
         * - `MANAGER` - MANAGER
         * - `CONTRIBUTOR` - CONTRIBUTOR
         * - `VIEWER` - VIEWER
         */
        fun role(role: RoleEnum) = role(JsonField.of(role))

        /**
         * - `ADMIN` - ADMIN
         * - `MANAGER` - MANAGER
         * - `CONTRIBUTOR` - CONTRIBUTOR
         * - `VIEWER` - VIEWER
         */
        @JsonProperty("role")
        @ExcludeMissing
        fun role(role: JsonField<RoleEnum>) = apply { this.role = role }

        /** The user's timezone. */
        fun timezone(timezone: String) = timezone(JsonField.of(timezone))

        /** The user's timezone. */
        @JsonProperty("timezone")
        @ExcludeMissing
        fun timezone(timezone: JsonField<String>) = apply { this.timezone = timezone }

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        @JsonProperty("remote_was_deleted")
        @ExcludeMissing
        fun remoteWasDeleted(remoteWasDeleted: JsonField<Boolean>) = apply {
            this.remoteWasDeleted = remoteWasDeleted
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

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

        fun build(): User =
            User(
                name,
                username,
                email,
                role,
                timezone,
                remoteWasDeleted,
                id,
                remoteId,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class RoleEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RoleEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ADMIN = RoleEnum(JsonField.of("ADMIN"))

            @JvmField val MANAGER = RoleEnum(JsonField.of("MANAGER"))

            @JvmField val CONTRIBUTOR = RoleEnum(JsonField.of("CONTRIBUTOR"))

            @JvmField val VIEWER = RoleEnum(JsonField.of("VIEWER"))

            @JvmStatic fun of(value: String) = RoleEnum(JsonField.of(value))
        }

        enum class Known {
            ADMIN,
            MANAGER,
            CONTRIBUTOR,
            VIEWER,
        }

        enum class Value {
            ADMIN,
            MANAGER,
            CONTRIBUTOR,
            VIEWER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ADMIN -> Value.ADMIN
                MANAGER -> Value.MANAGER
                CONTRIBUTOR -> Value.CONTRIBUTOR
                VIEWER -> Value.VIEWER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ADMIN -> Known.ADMIN
                MANAGER -> Known.MANAGER
                CONTRIBUTOR -> Known.CONTRIBUTOR
                VIEWER -> Known.VIEWER
                else -> throw MergeInvalidDataException("Unknown RoleEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
