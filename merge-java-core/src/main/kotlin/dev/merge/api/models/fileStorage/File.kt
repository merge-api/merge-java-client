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
 * # The File Object
 *
 * ### Description
 *
 * The `File` object is used to represent a file in the workspace. The Object typically exists under
 * a folder or drive, if it exists.
 *
 * ### Usage Example
 *
 * Fetch from the `GET /api/filestorage/v1/files` endpoint and view their files.
 */
@JsonDeserialize(builder = File.Builder::class)
@NoAutoDetect
class File
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val name: JsonField<String>,
    private val fileUrl: JsonField<String>,
    private val fileThumbnailUrl: JsonField<String>,
    private val size: JsonField<Long>,
    private val mimeType: JsonField<String>,
    private val description: JsonField<String>,
    private val folder: JsonField<String>,
    private val permissions: JsonField<List<String>>,
    private val drive: JsonField<String>,
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

    /** The file's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The URL to access the file. */
    fun fileUrl(): Optional<String> = Optional.ofNullable(fileUrl.getNullable("file_url"))

    /** The URL that produces a thumbnail preview of the file. Typically an image. */
    fun fileThumbnailUrl(): Optional<String> =
        Optional.ofNullable(fileThumbnailUrl.getNullable("file_thumbnail_url"))

    /** The file's size, in bytes. */
    fun size(): Optional<Long> = Optional.ofNullable(size.getNullable("size"))

    /** The file's mime type. */
    fun mimeType(): Optional<String> = Optional.ofNullable(mimeType.getNullable("mime_type"))

    /** The file's description. */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /** The folder that the file belongs to. */
    fun folder(): Optional<String> = Optional.ofNullable(folder.getNullable("folder"))

    /**
     * The Permission object is used to represent a user's or group's access to a File or Folder.
     * Permissions are unexpanded by default. Use the query param `expand=permissions` to see more
     * details under `GET /files`.
     */
    fun permissions(): List<String> = permissions.getRequired("permissions")

    /** The drive that the file belongs to. */
    fun drive(): Optional<String> = Optional.ofNullable(drive.getNullable("drive"))

    /** When the third party's file was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** When the third party's file was updated. */
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

    /** The file's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The URL to access the file. */
    @JsonProperty("file_url") @ExcludeMissing fun _fileUrl() = fileUrl

    /** The URL that produces a thumbnail preview of the file. Typically an image. */
    @JsonProperty("file_thumbnail_url") @ExcludeMissing fun _fileThumbnailUrl() = fileThumbnailUrl

    /** The file's size, in bytes. */
    @JsonProperty("size") @ExcludeMissing fun _size() = size

    /** The file's mime type. */
    @JsonProperty("mime_type") @ExcludeMissing fun _mimeType() = mimeType

    /** The file's description. */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /** The folder that the file belongs to. */
    @JsonProperty("folder") @ExcludeMissing fun _folder() = folder

    /**
     * The Permission object is used to represent a user's or group's access to a File or Folder.
     * Permissions are unexpanded by default. Use the query param `expand=permissions` to see more
     * details under `GET /files`.
     */
    @JsonProperty("permissions") @ExcludeMissing fun _permissions() = permissions

    /** The drive that the file belongs to. */
    @JsonProperty("drive") @ExcludeMissing fun _drive() = drive

    /** When the third party's file was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** When the third party's file was updated. */
    @JsonProperty("remote_updated_at") @ExcludeMissing fun _remoteUpdatedAt() = remoteUpdatedAt

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): File = apply {
        if (!validated) {
            id()
            remoteId()
            name()
            fileUrl()
            fileThumbnailUrl()
            size()
            mimeType()
            description()
            folder()
            permissions()
            drive()
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

        return other is File &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.name == other.name &&
            this.fileUrl == other.fileUrl &&
            this.fileThumbnailUrl == other.fileThumbnailUrl &&
            this.size == other.size &&
            this.mimeType == other.mimeType &&
            this.description == other.description &&
            this.folder == other.folder &&
            this.permissions == other.permissions &&
            this.drive == other.drive &&
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
                    fileUrl,
                    fileThumbnailUrl,
                    size,
                    mimeType,
                    description,
                    folder,
                    permissions,
                    drive,
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
        "File{id=$id, remoteId=$remoteId, name=$name, fileUrl=$fileUrl, fileThumbnailUrl=$fileThumbnailUrl, size=$size, mimeType=$mimeType, description=$description, folder=$folder, permissions=$permissions, drive=$drive, remoteCreatedAt=$remoteCreatedAt, remoteUpdatedAt=$remoteUpdatedAt, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var fileUrl: JsonField<String> = JsonMissing.of()
        private var fileThumbnailUrl: JsonField<String> = JsonMissing.of()
        private var size: JsonField<Long> = JsonMissing.of()
        private var mimeType: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var folder: JsonField<String> = JsonMissing.of()
        private var permissions: JsonField<List<String>> = JsonMissing.of()
        private var drive: JsonField<String> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteUpdatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<JsonValue>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(file: File) = apply {
            this.id = file.id
            this.remoteId = file.remoteId
            this.name = file.name
            this.fileUrl = file.fileUrl
            this.fileThumbnailUrl = file.fileThumbnailUrl
            this.size = file.size
            this.mimeType = file.mimeType
            this.description = file.description
            this.folder = file.folder
            this.permissions = file.permissions
            this.drive = file.drive
            this.remoteCreatedAt = file.remoteCreatedAt
            this.remoteUpdatedAt = file.remoteUpdatedAt
            this.fieldMappings = file.fieldMappings
            this.modifiedAt = file.modifiedAt
            this.remoteData = file.remoteData
            additionalProperties(file.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The file's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The file's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The URL to access the file. */
        fun fileUrl(fileUrl: String) = fileUrl(JsonField.of(fileUrl))

        /** The URL to access the file. */
        @JsonProperty("file_url")
        @ExcludeMissing
        fun fileUrl(fileUrl: JsonField<String>) = apply { this.fileUrl = fileUrl }

        /** The URL that produces a thumbnail preview of the file. Typically an image. */
        fun fileThumbnailUrl(fileThumbnailUrl: String) =
            fileThumbnailUrl(JsonField.of(fileThumbnailUrl))

        /** The URL that produces a thumbnail preview of the file. Typically an image. */
        @JsonProperty("file_thumbnail_url")
        @ExcludeMissing
        fun fileThumbnailUrl(fileThumbnailUrl: JsonField<String>) = apply {
            this.fileThumbnailUrl = fileThumbnailUrl
        }

        /** The file's size, in bytes. */
        fun size(size: Long) = size(JsonField.of(size))

        /** The file's size, in bytes. */
        @JsonProperty("size")
        @ExcludeMissing
        fun size(size: JsonField<Long>) = apply { this.size = size }

        /** The file's mime type. */
        fun mimeType(mimeType: String) = mimeType(JsonField.of(mimeType))

        /** The file's mime type. */
        @JsonProperty("mime_type")
        @ExcludeMissing
        fun mimeType(mimeType: JsonField<String>) = apply { this.mimeType = mimeType }

        /** The file's description. */
        fun description(description: String) = description(JsonField.of(description))

        /** The file's description. */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** The folder that the file belongs to. */
        fun folder(folder: String) = folder(JsonField.of(folder))

        /** The folder that the file belongs to. */
        @JsonProperty("folder")
        @ExcludeMissing
        fun folder(folder: JsonField<String>) = apply { this.folder = folder }

        /**
         * The Permission object is used to represent a user's or group's access to a File or
         * Folder. Permissions are unexpanded by default. Use the query param `expand=permissions`
         * to see more details under `GET /files`.
         */
        fun permissions(permissions: List<String>) = permissions(JsonField.of(permissions))

        /**
         * The Permission object is used to represent a user's or group's access to a File or
         * Folder. Permissions are unexpanded by default. Use the query param `expand=permissions`
         * to see more details under `GET /files`.
         */
        @JsonProperty("permissions")
        @ExcludeMissing
        fun permissions(permissions: JsonField<List<String>>) = apply {
            this.permissions = permissions
        }

        /** The drive that the file belongs to. */
        fun drive(drive: String) = drive(JsonField.of(drive))

        /** The drive that the file belongs to. */
        @JsonProperty("drive")
        @ExcludeMissing
        fun drive(drive: JsonField<String>) = apply { this.drive = drive }

        /** When the third party's file was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's file was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** When the third party's file was updated. */
        fun remoteUpdatedAt(remoteUpdatedAt: OffsetDateTime) =
            remoteUpdatedAt(JsonField.of(remoteUpdatedAt))

        /** When the third party's file was updated. */
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

        fun build(): File =
            File(
                id,
                remoteId,
                name,
                fileUrl,
                fileThumbnailUrl,
                size,
                mimeType,
                description,
                folder,
                permissions.map { it.toUnmodifiable() },
                drive,
                remoteCreatedAt,
                remoteUpdatedAt,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }
}
