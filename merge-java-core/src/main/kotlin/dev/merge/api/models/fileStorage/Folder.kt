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
 * # The Folder Object
 *
 * ### Description
 *
 * The `Folder` object is used to represent a collection of files and/or folders in the workspace.
 * Could be within a drive, if it exsts.
 *
 * ### Usage Example
 *
 * Fetch from the `GET /api/filestorage/v1/folders` endpoint and view their folders.
 */
@JsonDeserialize(builder = Folder.Builder::class)
@NoAutoDetect
class Folder
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val name: JsonField<String>,
    private val folderUrl: JsonField<String>,
    private val size: JsonField<Long>,
    private val description: JsonField<String>,
    private val parentFolder: JsonField<String>,
    private val drive: JsonField<String>,
    private val permissions: JsonField<List<String>>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val remoteUpdatedAt: JsonField<OffsetDateTime>,
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

    /** The folder's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The URL to access the folder. */
    fun folderUrl(): Optional<String> = Optional.ofNullable(folderUrl.getNullable("folder_url"))

    /** The folder's size, in bytes. */
    fun size(): Optional<Long> = Optional.ofNullable(size.getNullable("size"))

    /** The folder's description. */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /** The folder that the folder belongs to. */
    fun parentFolder(): Optional<String> =
        Optional.ofNullable(parentFolder.getNullable("parent_folder"))

    /** The drive that the folder belongs to. */
    fun drive(): Optional<String> = Optional.ofNullable(drive.getNullable("drive"))

    /**
     * The Permission object is used to represent a user's or group's access to a File or Folder.
     * Permissions are unexpanded by default. Use the query param `expand=permissions` to see more
     * details under `GET /folders`.
     */
    fun permissions(): List<String> = permissions.getRequired("permissions")

    /** When the third party's folder was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** When the third party's folder was updated. */
    fun remoteUpdatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteUpdatedAt.getNullable("remote_updated_at"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<JsonValue>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    /** The folder's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The URL to access the folder. */
    @JsonProperty("folder_url") @ExcludeMissing fun _folderUrl() = folderUrl

    /** The folder's size, in bytes. */
    @JsonProperty("size") @ExcludeMissing fun _size() = size

    /** The folder's description. */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /** The folder that the folder belongs to. */
    @JsonProperty("parent_folder") @ExcludeMissing fun _parentFolder() = parentFolder

    /** The drive that the folder belongs to. */
    @JsonProperty("drive") @ExcludeMissing fun _drive() = drive

    /**
     * The Permission object is used to represent a user's or group's access to a File or Folder.
     * Permissions are unexpanded by default. Use the query param `expand=permissions` to see more
     * details under `GET /folders`.
     */
    @JsonProperty("permissions") @ExcludeMissing fun _permissions() = permissions

    /** When the third party's folder was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** When the third party's folder was updated. */
    @JsonProperty("remote_updated_at") @ExcludeMissing fun _remoteUpdatedAt() = remoteUpdatedAt

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
            folderUrl()
            size()
            description()
            parentFolder()
            drive()
            permissions()
            remoteCreatedAt()
            remoteUpdatedAt()
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

        return other is Folder &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.name == other.name &&
            this.folderUrl == other.folderUrl &&
            this.size == other.size &&
            this.description == other.description &&
            this.parentFolder == other.parentFolder &&
            this.drive == other.drive &&
            this.permissions == other.permissions &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.remoteUpdatedAt == other.remoteUpdatedAt &&
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
                    folderUrl,
                    size,
                    description,
                    parentFolder,
                    drive,
                    permissions,
                    remoteCreatedAt,
                    remoteUpdatedAt,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Folder{id=$id, remoteId=$remoteId, name=$name, folderUrl=$folderUrl, size=$size, description=$description, parentFolder=$parentFolder, drive=$drive, permissions=$permissions, remoteCreatedAt=$remoteCreatedAt, remoteUpdatedAt=$remoteUpdatedAt, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var folderUrl: JsonField<String> = JsonMissing.of()
        private var size: JsonField<Long> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var parentFolder: JsonField<String> = JsonMissing.of()
        private var drive: JsonField<String> = JsonMissing.of()
        private var permissions: JsonField<List<String>> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteUpdatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<JsonValue>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(folder: Folder) = apply {
            this.id = folder.id
            this.remoteId = folder.remoteId
            this.name = folder.name
            this.folderUrl = folder.folderUrl
            this.size = folder.size
            this.description = folder.description
            this.parentFolder = folder.parentFolder
            this.drive = folder.drive
            this.permissions = folder.permissions
            this.remoteCreatedAt = folder.remoteCreatedAt
            this.remoteUpdatedAt = folder.remoteUpdatedAt
            this.fieldMappings = folder.fieldMappings
            this.modifiedAt = folder.modifiedAt
            this.remoteData = folder.remoteData
            additionalProperties(folder.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The folder's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The folder's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The URL to access the folder. */
        fun folderUrl(folderUrl: String) = folderUrl(JsonField.of(folderUrl))

        /** The URL to access the folder. */
        @JsonProperty("folder_url")
        @ExcludeMissing
        fun folderUrl(folderUrl: JsonField<String>) = apply { this.folderUrl = folderUrl }

        /** The folder's size, in bytes. */
        fun size(size: Long) = size(JsonField.of(size))

        /** The folder's size, in bytes. */
        @JsonProperty("size")
        @ExcludeMissing
        fun size(size: JsonField<Long>) = apply { this.size = size }

        /** The folder's description. */
        fun description(description: String) = description(JsonField.of(description))

        /** The folder's description. */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** The folder that the folder belongs to. */
        fun parentFolder(parentFolder: String) = parentFolder(JsonField.of(parentFolder))

        /** The folder that the folder belongs to. */
        @JsonProperty("parent_folder")
        @ExcludeMissing
        fun parentFolder(parentFolder: JsonField<String>) = apply {
            this.parentFolder = parentFolder
        }

        /** The drive that the folder belongs to. */
        fun drive(drive: String) = drive(JsonField.of(drive))

        /** The drive that the folder belongs to. */
        @JsonProperty("drive")
        @ExcludeMissing
        fun drive(drive: JsonField<String>) = apply { this.drive = drive }

        /**
         * The Permission object is used to represent a user's or group's access to a File or
         * Folder. Permissions are unexpanded by default. Use the query param `expand=permissions`
         * to see more details under `GET /folders`.
         */
        fun permissions(permissions: List<String>) = permissions(JsonField.of(permissions))

        /**
         * The Permission object is used to represent a user's or group's access to a File or
         * Folder. Permissions are unexpanded by default. Use the query param `expand=permissions`
         * to see more details under `GET /folders`.
         */
        @JsonProperty("permissions")
        @ExcludeMissing
        fun permissions(permissions: JsonField<List<String>>) = apply {
            this.permissions = permissions
        }

        /** When the third party's folder was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's folder was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** When the third party's folder was updated. */
        fun remoteUpdatedAt(remoteUpdatedAt: OffsetDateTime) =
            remoteUpdatedAt(JsonField.of(remoteUpdatedAt))

        /** When the third party's folder was updated. */
        @JsonProperty("remote_updated_at")
        @ExcludeMissing
        fun remoteUpdatedAt(remoteUpdatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteUpdatedAt = remoteUpdatedAt
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

        fun build(): Folder =
            Folder(
                id,
                remoteId,
                name,
                folderUrl,
                size,
                description,
                parentFolder,
                drive,
                permissions.map { it.toUnmodifiable() },
                remoteCreatedAt,
                remoteUpdatedAt,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }
}
