package dev.merge.api.models.crm

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
 * # The User Object
 *
 * ### Description
 *
 * The `User` object is used to represent a user with a login to the CRM system.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = User.Builder::class)
@NoAutoDetect
class User
private constructor(
    private val name: JsonField<String>,
    private val email: JsonField<String>,
    private val isActive: JsonField<Boolean>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val remoteFields: JsonField<List<RemoteField>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The user's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The user's email address. */
    fun email(): Optional<String> = Optional.ofNullable(email.getNullable("email"))

    /** Whether or not the user is active. */
    fun isActive(): Optional<Boolean> = Optional.ofNullable(isActive.getNullable("is_active"))

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

    fun remoteFields(): Optional<List<RemoteField>> =
        Optional.ofNullable(remoteFields.getNullable("remote_fields"))

    /** The user's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The user's email address. */
    @JsonProperty("email") @ExcludeMissing fun _email() = email

    /** Whether or not the user is active. */
    @JsonProperty("is_active") @ExcludeMissing fun _isActive() = isActive

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonProperty("remote_fields") @ExcludeMissing fun _remoteFields() = remoteFields

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): User = apply {
        if (!validated) {
            name()
            email()
            isActive()
            remoteWasDeleted()
            id()
            remoteId()
            modifiedAt()
            remoteData().map { it.forEach { it.validate() } }
            remoteFields().map { it.forEach { it.validate() } }
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
            this.email == other.email &&
            this.isActive == other.isActive &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.remoteFields == other.remoteFields &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    name,
                    email,
                    isActive,
                    remoteWasDeleted,
                    id,
                    remoteId,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    remoteFields,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "User{name=$name, email=$email, isActive=$isActive, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, remoteFields=$remoteFields, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var isActive: JsonField<Boolean> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var remoteFields: JsonField<List<RemoteField>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(user: User) = apply {
            this.name = user.name
            this.email = user.email
            this.isActive = user.isActive
            this.remoteWasDeleted = user.remoteWasDeleted
            this.id = user.id
            this.remoteId = user.remoteId
            this.fieldMappings = user.fieldMappings
            this.modifiedAt = user.modifiedAt
            this.remoteData = user.remoteData
            this.remoteFields = user.remoteFields
            additionalProperties(user.additionalProperties)
        }

        /** The user's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The user's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The user's email address. */
        fun email(email: String) = email(JsonField.of(email))

        /** The user's email address. */
        @JsonProperty("email")
        @ExcludeMissing
        fun email(email: JsonField<String>) = apply { this.email = email }

        /** Whether or not the user is active. */
        fun isActive(isActive: Boolean) = isActive(JsonField.of(isActive))

        /** Whether or not the user is active. */
        @JsonProperty("is_active")
        @ExcludeMissing
        fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

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

        fun remoteFields(remoteFields: List<RemoteField>) = remoteFields(JsonField.of(remoteFields))

        @JsonProperty("remote_fields")
        @ExcludeMissing
        fun remoteFields(remoteFields: JsonField<List<RemoteField>>) = apply {
            this.remoteFields = remoteFields
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
                email,
                isActive,
                remoteWasDeleted,
                id,
                remoteId,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                remoteFields.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = RemoteField.Builder::class)
    @NoAutoDetect
    class RemoteField
    private constructor(
        private val remoteFieldClass: JsonField<RemoteFieldClass>,
        private val value: JsonValue,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun remoteFieldClass(): RemoteFieldClass =
            remoteFieldClass.getRequired("remote_field_class")

        @JsonProperty("remote_field_class")
        @ExcludeMissing
        fun _remoteFieldClass() = remoteFieldClass

        @JsonProperty("value") @ExcludeMissing fun _value() = value

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): RemoteField = apply {
            if (!validated) {
                remoteFieldClass().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RemoteField &&
                this.remoteFieldClass == other.remoteFieldClass &&
                this.value == other.value &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        remoteFieldClass,
                        value,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "RemoteField{remoteFieldClass=$remoteFieldClass, value=$value, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var remoteFieldClass: JsonField<RemoteFieldClass> = JsonMissing.of()
            private var value: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(remoteField: RemoteField) = apply {
                this.remoteFieldClass = remoteField.remoteFieldClass
                this.value = remoteField.value
                additionalProperties(remoteField.additionalProperties)
            }

            fun remoteFieldClass(remoteFieldClass: RemoteFieldClass) =
                remoteFieldClass(JsonField.of(remoteFieldClass))

            @JsonProperty("remote_field_class")
            @ExcludeMissing
            fun remoteFieldClass(remoteFieldClass: JsonField<RemoteFieldClass>) = apply {
                this.remoteFieldClass = remoteFieldClass
            }

            @JsonProperty("value")
            @ExcludeMissing
            fun value(value: JsonValue) = apply { this.value = value }

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

            fun build(): RemoteField =
                RemoteField(
                    remoteFieldClass,
                    value,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
