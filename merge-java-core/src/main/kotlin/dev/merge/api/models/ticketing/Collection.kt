package dev.merge.api.models.ticketing

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
 * # The Collection Object
 *
 * ### Description
 *
 * The `Collection` object is used to represent collections of tickets. Collections may include
 * other collections as sub collections.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = Collection.Builder::class)
@NoAutoDetect
class Collection
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val name: JsonField<String>,
    private val description: JsonField<String>,
    private val collectionType: JsonField<CollectionTypeEnum>,
    private val parentCollection: JsonField<String>,
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

    /** The collection's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The collection's description. */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /**
     * - `LIST` - LIST
     * - `PROJECT` - PROJECT
     */
    fun collectionType(): Optional<CollectionTypeEnum> =
        Optional.ofNullable(collectionType.getNullable("collection_type"))

    /** The parent collection for this collection. */
    fun parentCollection(): Optional<String> =
        Optional.ofNullable(parentCollection.getNullable("parent_collection"))

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

    /** The collection's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The collection's description. */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /**
     * - `LIST` - LIST
     * - `PROJECT` - PROJECT
     */
    @JsonProperty("collection_type") @ExcludeMissing fun _collectionType() = collectionType

    /** The parent collection for this collection. */
    @JsonProperty("parent_collection") @ExcludeMissing fun _parentCollection() = parentCollection

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
            collectionType()
            parentCollection()
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

        return other is Collection &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.name == other.name &&
            this.description == other.description &&
            this.collectionType == other.collectionType &&
            this.parentCollection == other.parentCollection &&
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
                    collectionType,
                    parentCollection,
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
        "Collection{id=$id, remoteId=$remoteId, name=$name, description=$description, collectionType=$collectionType, parentCollection=$parentCollection, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var collectionType: JsonField<CollectionTypeEnum> = JsonMissing.of()
        private var parentCollection: JsonField<String> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(collection: Collection) = apply {
            this.id = collection.id
            this.remoteId = collection.remoteId
            this.name = collection.name
            this.description = collection.description
            this.collectionType = collection.collectionType
            this.parentCollection = collection.parentCollection
            this.remoteWasDeleted = collection.remoteWasDeleted
            this.fieldMappings = collection.fieldMappings
            this.modifiedAt = collection.modifiedAt
            this.remoteData = collection.remoteData
            additionalProperties(collection.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The collection's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The collection's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The collection's description. */
        fun description(description: String) = description(JsonField.of(description))

        /** The collection's description. */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /**
         * - `LIST` - LIST
         * - `PROJECT` - PROJECT
         */
        fun collectionType(collectionType: CollectionTypeEnum) =
            collectionType(JsonField.of(collectionType))

        /**
         * - `LIST` - LIST
         * - `PROJECT` - PROJECT
         */
        @JsonProperty("collection_type")
        @ExcludeMissing
        fun collectionType(collectionType: JsonField<CollectionTypeEnum>) = apply {
            this.collectionType = collectionType
        }

        /** The parent collection for this collection. */
        fun parentCollection(parentCollection: String) =
            parentCollection(JsonField.of(parentCollection))

        /** The parent collection for this collection. */
        @JsonProperty("parent_collection")
        @ExcludeMissing
        fun parentCollection(parentCollection: JsonField<String>) = apply {
            this.parentCollection = parentCollection
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

        fun build(): Collection =
            Collection(
                id,
                remoteId,
                name,
                description,
                collectionType,
                parentCollection,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class CollectionTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CollectionTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val LIST = CollectionTypeEnum(JsonField.of("LIST"))

            @JvmField val PROJECT = CollectionTypeEnum(JsonField.of("PROJECT"))

            @JvmStatic fun of(value: String) = CollectionTypeEnum(JsonField.of(value))
        }

        enum class Known {
            LIST,
            PROJECT,
        }

        enum class Value {
            LIST,
            PROJECT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                LIST -> Value.LIST
                PROJECT -> Value.PROJECT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                LIST -> Known.LIST
                PROJECT -> Known.PROJECT
                else -> throw MergeInvalidDataException("Unknown CollectionTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
