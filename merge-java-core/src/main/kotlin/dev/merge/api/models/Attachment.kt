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
 * # The Attachment Object
 *
 * ### Description
 *
 * The `Attachment` object is used to represent an attachment for a ticket.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = Attachment.Builder::class)
@NoAutoDetect
class Attachment
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val fileName: JsonField<String>,
    private val fileUrl: JsonField<String>,
    private val candidate: JsonField<String>,
    private val attachmentType: JsonField<AttachmentTypeEnum>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val ticket: JsonField<String>,
    private val contentType: JsonField<String>,
    private val uploadedBy: JsonField<String>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /**
     * The attachment's name. It is required to include the file extension in the attachment's name.
     */
    fun fileName(): Optional<String> = Optional.ofNullable(fileName.getNullable("file_name"))

    /** The attachment's url. It is required to include the file extension in the file's URL. */
    fun fileUrl(): Optional<String> = Optional.ofNullable(fileUrl.getNullable("file_url"))

    fun candidate(): Optional<String> = Optional.ofNullable(candidate.getNullable("candidate"))

    /**
     * - `RESUME` - RESUME
     * - `COVER_LETTER` - COVER_LETTER
     * - `OFFER_LETTER` - OFFER_LETTER
     * - `OTHER` - OTHER
     */
    fun attachmentType(): Optional<AttachmentTypeEnum> =
        Optional.ofNullable(attachmentType.getNullable("attachment_type"))

    fun remoteWasDeleted(): Optional<Boolean> =
        Optional.ofNullable(remoteWasDeleted.getNullable("remote_was_deleted"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<RemoteData>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    /** The ticket associated with the attachment. */
    fun ticket(): Optional<String> = Optional.ofNullable(ticket.getNullable("ticket"))

    /** The attachment's file format. */
    fun contentType(): Optional<String> =
        Optional.ofNullable(contentType.getNullable("content_type"))

    /** The user who uploaded the attachment. */
    fun uploadedBy(): Optional<String> = Optional.ofNullable(uploadedBy.getNullable("uploaded_by"))

    /** When the third party's attachment was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    /**
     * The attachment's name. It is required to include the file extension in the attachment's name.
     */
    @JsonProperty("file_name") @ExcludeMissing fun _fileName() = fileName

    /** The attachment's url. It is required to include the file extension in the file's URL. */
    @JsonProperty("file_url") @ExcludeMissing fun _fileUrl() = fileUrl

    @JsonProperty("candidate") @ExcludeMissing fun _candidate() = candidate

    /**
     * - `RESUME` - RESUME
     * - `COVER_LETTER` - COVER_LETTER
     * - `OFFER_LETTER` - OFFER_LETTER
     * - `OTHER` - OTHER
     */
    @JsonProperty("attachment_type") @ExcludeMissing fun _attachmentType() = attachmentType

    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    /** The ticket associated with the attachment. */
    @JsonProperty("ticket") @ExcludeMissing fun _ticket() = ticket

    /** The attachment's file format. */
    @JsonProperty("content_type") @ExcludeMissing fun _contentType() = contentType

    /** The user who uploaded the attachment. */
    @JsonProperty("uploaded_by") @ExcludeMissing fun _uploadedBy() = uploadedBy

    /** When the third party's attachment was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Attachment = apply {
        if (!validated) {
            id()
            remoteId()
            fileName()
            fileUrl()
            candidate()
            attachmentType()
            remoteWasDeleted()
            modifiedAt()
            remoteData().map { it.forEach { it.validate() } }
            ticket()
            contentType()
            uploadedBy()
            remoteCreatedAt()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Attachment &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.fileName == other.fileName &&
            this.fileUrl == other.fileUrl &&
            this.candidate == other.candidate &&
            this.attachmentType == other.attachmentType &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.ticket == other.ticket &&
            this.contentType == other.contentType &&
            this.uploadedBy == other.uploadedBy &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    remoteId,
                    fileName,
                    fileUrl,
                    candidate,
                    attachmentType,
                    remoteWasDeleted,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    ticket,
                    contentType,
                    uploadedBy,
                    remoteCreatedAt,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Attachment{id=$id, remoteId=$remoteId, fileName=$fileName, fileUrl=$fileUrl, candidate=$candidate, attachmentType=$attachmentType, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, ticket=$ticket, contentType=$contentType, uploadedBy=$uploadedBy, remoteCreatedAt=$remoteCreatedAt, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fileName: JsonField<String> = JsonMissing.of()
        private var fileUrl: JsonField<String> = JsonMissing.of()
        private var candidate: JsonField<String> = JsonMissing.of()
        private var attachmentType: JsonField<AttachmentTypeEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var ticket: JsonField<String> = JsonMissing.of()
        private var contentType: JsonField<String> = JsonMissing.of()
        private var uploadedBy: JsonField<String> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(attachment: Attachment) = apply {
            this.id = attachment.id
            this.remoteId = attachment.remoteId
            this.fileName = attachment.fileName
            this.fileUrl = attachment.fileUrl
            this.candidate = attachment.candidate
            this.attachmentType = attachment.attachmentType
            this.remoteWasDeleted = attachment.remoteWasDeleted
            this.fieldMappings = attachment.fieldMappings
            this.modifiedAt = attachment.modifiedAt
            this.remoteData = attachment.remoteData
            this.ticket = attachment.ticket
            this.contentType = attachment.contentType
            this.uploadedBy = attachment.uploadedBy
            this.remoteCreatedAt = attachment.remoteCreatedAt
            additionalProperties(attachment.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /**
         * The attachment's name. It is required to include the file extension in the attachment's
         * name.
         */
        fun fileName(fileName: String) = fileName(JsonField.of(fileName))

        /**
         * The attachment's name. It is required to include the file extension in the attachment's
         * name.
         */
        @JsonProperty("file_name")
        @ExcludeMissing
        fun fileName(fileName: JsonField<String>) = apply { this.fileName = fileName }

        /** The attachment's url. It is required to include the file extension in the file's URL. */
        fun fileUrl(fileUrl: String) = fileUrl(JsonField.of(fileUrl))

        /** The attachment's url. It is required to include the file extension in the file's URL. */
        @JsonProperty("file_url")
        @ExcludeMissing
        fun fileUrl(fileUrl: JsonField<String>) = apply { this.fileUrl = fileUrl }

        fun candidate(candidate: String) = candidate(JsonField.of(candidate))

        @JsonProperty("candidate")
        @ExcludeMissing
        fun candidate(candidate: JsonField<String>) = apply { this.candidate = candidate }

        /**
         * - `RESUME` - RESUME
         * - `COVER_LETTER` - COVER_LETTER
         * - `OFFER_LETTER` - OFFER_LETTER
         * - `OTHER` - OTHER
         */
        fun attachmentType(attachmentType: AttachmentTypeEnum) =
            attachmentType(JsonField.of(attachmentType))

        /**
         * - `RESUME` - RESUME
         * - `COVER_LETTER` - COVER_LETTER
         * - `OFFER_LETTER` - OFFER_LETTER
         * - `OTHER` - OTHER
         */
        @JsonProperty("attachment_type")
        @ExcludeMissing
        fun attachmentType(attachmentType: JsonField<AttachmentTypeEnum>) = apply {
            this.attachmentType = attachmentType
        }

        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

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

        /** The ticket associated with the attachment. */
        fun ticket(ticket: String) = ticket(JsonField.of(ticket))

        /** The ticket associated with the attachment. */
        @JsonProperty("ticket")
        @ExcludeMissing
        fun ticket(ticket: JsonField<String>) = apply { this.ticket = ticket }

        /** The attachment's file format. */
        fun contentType(contentType: String) = contentType(JsonField.of(contentType))

        /** The attachment's file format. */
        @JsonProperty("content_type")
        @ExcludeMissing
        fun contentType(contentType: JsonField<String>) = apply { this.contentType = contentType }

        /** The user who uploaded the attachment. */
        fun uploadedBy(uploadedBy: String) = uploadedBy(JsonField.of(uploadedBy))

        /** The user who uploaded the attachment. */
        @JsonProperty("uploaded_by")
        @ExcludeMissing
        fun uploadedBy(uploadedBy: JsonField<String>) = apply { this.uploadedBy = uploadedBy }

        /** When the third party's attachment was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's attachment was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
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

        fun build(): Attachment =
            Attachment(
                id,
                remoteId,
                fileName,
                fileUrl,
                candidate,
                attachmentType,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                ticket,
                contentType,
                uploadedBy,
                remoteCreatedAt,
                additionalProperties.toUnmodifiable(),
            )
    }

    class AttachmentTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AttachmentTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val RESUME = AttachmentTypeEnum(JsonField.of("RESUME"))

            @JvmField val COVER_LETTER = AttachmentTypeEnum(JsonField.of("COVER_LETTER"))

            @JvmField val OFFER_LETTER = AttachmentTypeEnum(JsonField.of("OFFER_LETTER"))

            @JvmField val OTHER = AttachmentTypeEnum(JsonField.of("OTHER"))

            @JvmStatic fun of(value: String) = AttachmentTypeEnum(JsonField.of(value))
        }

        enum class Known {
            RESUME,
            COVER_LETTER,
            OFFER_LETTER,
            OTHER,
        }

        enum class Value {
            RESUME,
            COVER_LETTER,
            OFFER_LETTER,
            OTHER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                RESUME -> Value.RESUME
                COVER_LETTER -> Value.COVER_LETTER
                OFFER_LETTER -> Value.OFFER_LETTER
                OTHER -> Value.OTHER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                RESUME -> Known.RESUME
                COVER_LETTER -> Known.COVER_LETTER
                OFFER_LETTER -> Known.OFFER_LETTER
                OTHER -> Known.OTHER
                else -> throw MergeInvalidDataException("Unknown AttachmentTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
