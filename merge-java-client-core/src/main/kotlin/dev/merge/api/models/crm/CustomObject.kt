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
 * # The CustomObject Object
 *
 * ### Description
 *
 * The `Custom Object` record refers to an instance of a Custom Object Class.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = CustomObject.Builder::class)
@NoAutoDetect
class CustomObject
private constructor(
    private val objectClass: JsonField<String>,
    private val fields: JsonValue,
    private val remoteId: JsonField<String>,
    private val id: JsonField<String>,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteFields: JsonField<List<RemoteField>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun objectClass(): Optional<String> =
        Optional.ofNullable(objectClass.getNullable("object_class"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteFields(): Optional<List<RemoteField>> =
        Optional.ofNullable(remoteFields.getNullable("remote_fields"))

    @JsonProperty("object_class") @ExcludeMissing fun _objectClass() = objectClass

    @JsonProperty("fields") @ExcludeMissing fun _fields() = fields

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_fields") @ExcludeMissing fun _remoteFields() = remoteFields

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): CustomObject = apply {
        if (!validated) {
            objectClass()
            remoteId()
            id()
            modifiedAt()
            remoteFields().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CustomObject &&
            this.objectClass == other.objectClass &&
            this.fields == other.fields &&
            this.remoteId == other.remoteId &&
            this.id == other.id &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteFields == other.remoteFields &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    objectClass,
                    fields,
                    remoteId,
                    id,
                    modifiedAt,
                    remoteFields,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "CustomObject{objectClass=$objectClass, fields=$fields, remoteId=$remoteId, id=$id, modifiedAt=$modifiedAt, remoteFields=$remoteFields, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var objectClass: JsonField<String> = JsonMissing.of()
        private var fields: JsonValue = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteFields: JsonField<List<RemoteField>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(customObject: CustomObject) = apply {
            this.objectClass = customObject.objectClass
            this.fields = customObject.fields
            this.remoteId = customObject.remoteId
            this.id = customObject.id
            this.modifiedAt = customObject.modifiedAt
            this.remoteFields = customObject.remoteFields
            additionalProperties(customObject.additionalProperties)
        }

        fun objectClass(objectClass: String) = objectClass(JsonField.of(objectClass))

        @JsonProperty("object_class")
        @ExcludeMissing
        fun objectClass(objectClass: JsonField<String>) = apply { this.objectClass = objectClass }

        @JsonProperty("fields")
        @ExcludeMissing
        fun fields(fields: JsonValue) = apply { this.fields = fields }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at")
        @ExcludeMissing
        fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
            this.modifiedAt = modifiedAt
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

        fun build(): CustomObject =
            CustomObject(
                objectClass,
                fields,
                remoteId,
                id,
                modifiedAt,
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
