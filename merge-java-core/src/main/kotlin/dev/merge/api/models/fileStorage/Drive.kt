package dev.merge.api.models.fileStorage

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
 * # The Drive Object
 *
 * ### Description
 *
 * The `Drive` object is used to represent a drive that contains the folders and files in the user's
 * workspace.
 *
 * ### Usage Example
 *
 * Fetch from the `GET /api/filestorage/v1/drives` endpoint and view their drives.
 */
@JsonDeserialize(builder = Drive.Builder::class)
@NoAutoDetect
class Drive
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val name: JsonField<String>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val driveUrl: JsonField<String>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<JsonValue>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** The drive's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** When the third party's drive was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** The drive's url. */
    fun driveUrl(): Optional<String> = Optional.ofNullable(driveUrl.getNullable("drive_url"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<JsonValue>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    /** The drive's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** When the third party's drive was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** The drive's url. */
    @JsonProperty("drive_url") @ExcludeMissing fun _driveUrl() = driveUrl

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Drive = apply {
        if (!validated) {
            id()
            remoteId()
            name()
            remoteCreatedAt()
            driveUrl()
            modifiedAt()
            remoteData()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Drive &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.name == other.name &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.driveUrl == other.driveUrl &&
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
                    remoteCreatedAt,
                    driveUrl,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Drive{id=$id, remoteId=$remoteId, name=$name, remoteCreatedAt=$remoteCreatedAt, driveUrl=$driveUrl, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var driveUrl: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<JsonValue>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(drive: Drive) = apply {
            this.id = drive.id
            this.remoteId = drive.remoteId
            this.name = drive.name
            this.remoteCreatedAt = drive.remoteCreatedAt
            this.driveUrl = drive.driveUrl
            this.fieldMappings = drive.fieldMappings
            this.modifiedAt = drive.modifiedAt
            this.remoteData = drive.remoteData
            additionalProperties(drive.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The drive's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The drive's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** When the third party's drive was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's drive was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** The drive's url. */
        fun driveUrl(driveUrl: String) = driveUrl(JsonField.of(driveUrl))

        /** The drive's url. */
        @JsonProperty("drive_url")
        @ExcludeMissing
        fun driveUrl(driveUrl: JsonField<String>) = apply { this.driveUrl = driveUrl }

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

        fun remoteData(remoteData: List<JsonValue>) = remoteData(JsonField.of(remoteData))

        @JsonProperty("remote_data")
        @ExcludeMissing
        fun remoteData(remoteData: JsonField<List<JsonValue>>) = apply {
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

        fun build(): Drive =
            Drive(
                id,
                remoteId,
                name,
                remoteCreatedAt,
                driveUrl,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }
}
