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

/**
 * # The RemoteUser Object
 *
 * ### Description
 *
 * The `RemoteUser` object is used to represent a user with a login to the ATS system.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST RemoteUsers` endpoint to show all users for a third party.
 */
@JsonDeserialize(builder = RemoteUser.Builder::class)
@NoAutoDetect
class RemoteUser
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val firstName: JsonField<String>,
    private val lastName: JsonField<String>,
    private val email: JsonField<String>,
    private val disabled: JsonField<Boolean>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val accessRole: JsonField<AccessRoleEnum>,
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

    /** The user's first name. */
    fun firstName(): Optional<String> = Optional.ofNullable(firstName.getNullable("first_name"))

    /** The user's last name. */
    fun lastName(): Optional<String> = Optional.ofNullable(lastName.getNullable("last_name"))

    /** The user's email. */
    fun email(): Optional<String> = Optional.ofNullable(email.getNullable("email"))

    /** Whether the user's account had been disabled. */
    fun disabled(): Optional<Boolean> = Optional.ofNullable(disabled.getNullable("disabled"))

    /** When the third party's user was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /**
     * - `SUPER_ADMIN` - SUPER_ADMIN
     * - `ADMIN` - ADMIN
     * - `TEAM_MEMBER` - TEAM_MEMBER
     * - `LIMITED_TEAM_MEMBER` - LIMITED_TEAM_MEMBER
     * - `INTERVIEWER` - INTERVIEWER
     */
    fun accessRole(): Optional<AccessRoleEnum> =
        Optional.ofNullable(accessRole.getNullable("access_role"))

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

    /** The user's first name. */
    @JsonProperty("first_name") @ExcludeMissing fun _firstName() = firstName

    /** The user's last name. */
    @JsonProperty("last_name") @ExcludeMissing fun _lastName() = lastName

    /** The user's email. */
    @JsonProperty("email") @ExcludeMissing fun _email() = email

    /** Whether the user's account had been disabled. */
    @JsonProperty("disabled") @ExcludeMissing fun _disabled() = disabled

    /** When the third party's user was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /**
     * - `SUPER_ADMIN` - SUPER_ADMIN
     * - `ADMIN` - ADMIN
     * - `TEAM_MEMBER` - TEAM_MEMBER
     * - `LIMITED_TEAM_MEMBER` - LIMITED_TEAM_MEMBER
     * - `INTERVIEWER` - INTERVIEWER
     */
    @JsonProperty("access_role") @ExcludeMissing fun _accessRole() = accessRole

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
            firstName()
            lastName()
            email()
            disabled()
            remoteCreatedAt()
            accessRole()
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

        return other is RemoteUser &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.firstName == other.firstName &&
            this.lastName == other.lastName &&
            this.email == other.email &&
            this.disabled == other.disabled &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.accessRole == other.accessRole &&
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
                    firstName,
                    lastName,
                    email,
                    disabled,
                    remoteCreatedAt,
                    accessRole,
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
        "RemoteUser{id=$id, remoteId=$remoteId, firstName=$firstName, lastName=$lastName, email=$email, disabled=$disabled, remoteCreatedAt=$remoteCreatedAt, accessRole=$accessRole, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var firstName: JsonField<String> = JsonMissing.of()
        private var lastName: JsonField<String> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var disabled: JsonField<Boolean> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var accessRole: JsonField<AccessRoleEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(remoteUser: RemoteUser) = apply {
            this.id = remoteUser.id
            this.remoteId = remoteUser.remoteId
            this.firstName = remoteUser.firstName
            this.lastName = remoteUser.lastName
            this.email = remoteUser.email
            this.disabled = remoteUser.disabled
            this.remoteCreatedAt = remoteUser.remoteCreatedAt
            this.accessRole = remoteUser.accessRole
            this.remoteWasDeleted = remoteUser.remoteWasDeleted
            this.fieldMappings = remoteUser.fieldMappings
            this.modifiedAt = remoteUser.modifiedAt
            this.remoteData = remoteUser.remoteData
            additionalProperties(remoteUser.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The user's first name. */
        fun firstName(firstName: String) = firstName(JsonField.of(firstName))

        /** The user's first name. */
        @JsonProperty("first_name")
        @ExcludeMissing
        fun firstName(firstName: JsonField<String>) = apply { this.firstName = firstName }

        /** The user's last name. */
        fun lastName(lastName: String) = lastName(JsonField.of(lastName))

        /** The user's last name. */
        @JsonProperty("last_name")
        @ExcludeMissing
        fun lastName(lastName: JsonField<String>) = apply { this.lastName = lastName }

        /** The user's email. */
        fun email(email: String) = email(JsonField.of(email))

        /** The user's email. */
        @JsonProperty("email")
        @ExcludeMissing
        fun email(email: JsonField<String>) = apply { this.email = email }

        /** Whether the user's account had been disabled. */
        fun disabled(disabled: Boolean) = disabled(JsonField.of(disabled))

        /** Whether the user's account had been disabled. */
        @JsonProperty("disabled")
        @ExcludeMissing
        fun disabled(disabled: JsonField<Boolean>) = apply { this.disabled = disabled }

        /** When the third party's user was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's user was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /**
         * - `SUPER_ADMIN` - SUPER_ADMIN
         * - `ADMIN` - ADMIN
         * - `TEAM_MEMBER` - TEAM_MEMBER
         * - `LIMITED_TEAM_MEMBER` - LIMITED_TEAM_MEMBER
         * - `INTERVIEWER` - INTERVIEWER
         */
        fun accessRole(accessRole: AccessRoleEnum) = accessRole(JsonField.of(accessRole))

        /**
         * - `SUPER_ADMIN` - SUPER_ADMIN
         * - `ADMIN` - ADMIN
         * - `TEAM_MEMBER` - TEAM_MEMBER
         * - `LIMITED_TEAM_MEMBER` - LIMITED_TEAM_MEMBER
         * - `INTERVIEWER` - INTERVIEWER
         */
        @JsonProperty("access_role")
        @ExcludeMissing
        fun accessRole(accessRole: JsonField<AccessRoleEnum>) = apply {
            this.accessRole = accessRole
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

        fun build(): RemoteUser =
            RemoteUser(
                id,
                remoteId,
                firstName,
                lastName,
                email,
                disabled,
                remoteCreatedAt,
                accessRole,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class AccessRoleEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AccessRoleEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val SUPER_ADMIN = AccessRoleEnum(JsonField.of("SUPER_ADMIN"))

            @JvmField val ADMIN = AccessRoleEnum(JsonField.of("ADMIN"))

            @JvmField val TEAM_MEMBER = AccessRoleEnum(JsonField.of("TEAM_MEMBER"))

            @JvmField val LIMITED_TEAM_MEMBER = AccessRoleEnum(JsonField.of("LIMITED_TEAM_MEMBER"))

            @JvmField val INTERVIEWER = AccessRoleEnum(JsonField.of("INTERVIEWER"))

            @JvmStatic fun of(value: String) = AccessRoleEnum(JsonField.of(value))
        }

        enum class Known {
            SUPER_ADMIN,
            ADMIN,
            TEAM_MEMBER,
            LIMITED_TEAM_MEMBER,
            INTERVIEWER,
        }

        enum class Value {
            SUPER_ADMIN,
            ADMIN,
            TEAM_MEMBER,
            LIMITED_TEAM_MEMBER,
            INTERVIEWER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SUPER_ADMIN -> Value.SUPER_ADMIN
                ADMIN -> Value.ADMIN
                TEAM_MEMBER -> Value.TEAM_MEMBER
                LIMITED_TEAM_MEMBER -> Value.LIMITED_TEAM_MEMBER
                INTERVIEWER -> Value.INTERVIEWER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SUPER_ADMIN -> Known.SUPER_ADMIN
                ADMIN -> Known.ADMIN
                TEAM_MEMBER -> Known.TEAM_MEMBER
                LIMITED_TEAM_MEMBER -> Known.LIMITED_TEAM_MEMBER
                INTERVIEWER -> Known.INTERVIEWER
                else -> throw MergeInvalidDataException("Unknown AccessRoleEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
