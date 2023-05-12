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
 * # The Marketing Email Object
 *
 * ### Description
 *
 * The `MarketingEmail` object is used to represent a marketing email in the remote system.
 *
 * ### Usage Example
 *
 * Fetch from the `GET /api/mktg/v1/emails` endpoint and view their html_body properties.
 */
@JsonDeserialize(builder = Email.Builder::class)
@NoAutoDetect
class Email
private constructor(
    private val name: JsonField<String>,
    private val subject: JsonField<String>,
    private val body: JsonField<String>,
    private val htmlBody: JsonField<String>,
    private val fromName: JsonField<String>,
    private val fromEmail: JsonField<String>,
    private val preview: JsonField<String>,
    private val replyTo: JsonField<String>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val remoteUpdatedAt: JsonField<OffsetDateTime>,
    private val status: JsonField<MarketingEmailStatusEnum>,
    private val sendDate: JsonField<OffsetDateTime>,
    private val template: JsonField<String>,
    private val campaigns: JsonField<List<String>>,
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

    /** The marketing email's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The marketing email's subject. */
    fun subject(): Optional<String> = Optional.ofNullable(subject.getNullable("subject"))

    /** The marketing email's body. */
    fun body(): Optional<String> = Optional.ofNullable(body.getNullable("body"))

    /** The marketing email's html body. */
    fun htmlBody(): Optional<String> = Optional.ofNullable(htmlBody.getNullable("html_body"))

    /** The marketing email's from name. */
    fun fromName(): Optional<String> = Optional.ofNullable(fromName.getNullable("from_name"))

    /** The marketing email's from email. */
    fun fromEmail(): Optional<String> = Optional.ofNullable(fromEmail.getNullable("from_email"))

    /** The marketing email's preview. */
    fun preview(): Optional<String> = Optional.ofNullable(preview.getNullable("preview"))

    /** The marketing email's reply-to. */
    fun replyTo(): Optional<String> = Optional.ofNullable(replyTo.getNullable("reply_to"))

    /** When the marketing email was created in the remote system. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** When the marketing email was last updated in the remote system. */
    fun remoteUpdatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteUpdatedAt.getNullable("remote_updated_at"))

    /**
     * - `DRAFT` - DRAFT
     * - `QUEUED` - QUEUED
     * - `SENT` - SENT
     */
    fun status(): Optional<MarketingEmailStatusEnum> =
        Optional.ofNullable(status.getNullable("status"))

    /** When the marketing email was sent. */
    fun sendDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(sendDate.getNullable("send_date"))

    /** The marketing email's template. */
    fun template(): Optional<String> = Optional.ofNullable(template.getNullable("template"))

    /** The campaigns receiving this marketing email. */
    fun campaigns(): List<String> = campaigns.getRequired("campaigns")

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

    /** The marketing email's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The marketing email's subject. */
    @JsonProperty("subject") @ExcludeMissing fun _subject() = subject

    /** The marketing email's body. */
    @JsonProperty("body") @ExcludeMissing fun _body() = body

    /** The marketing email's html body. */
    @JsonProperty("html_body") @ExcludeMissing fun _htmlBody() = htmlBody

    /** The marketing email's from name. */
    @JsonProperty("from_name") @ExcludeMissing fun _fromName() = fromName

    /** The marketing email's from email. */
    @JsonProperty("from_email") @ExcludeMissing fun _fromEmail() = fromEmail

    /** The marketing email's preview. */
    @JsonProperty("preview") @ExcludeMissing fun _preview() = preview

    /** The marketing email's reply-to. */
    @JsonProperty("reply_to") @ExcludeMissing fun _replyTo() = replyTo

    /** When the marketing email was created in the remote system. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** When the marketing email was last updated in the remote system. */
    @JsonProperty("remote_updated_at") @ExcludeMissing fun _remoteUpdatedAt() = remoteUpdatedAt

    /**
     * - `DRAFT` - DRAFT
     * - `QUEUED` - QUEUED
     * - `SENT` - SENT
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** When the marketing email was sent. */
    @JsonProperty("send_date") @ExcludeMissing fun _sendDate() = sendDate

    /** The marketing email's template. */
    @JsonProperty("template") @ExcludeMissing fun _template() = template

    /** The campaigns receiving this marketing email. */
    @JsonProperty("campaigns") @ExcludeMissing fun _campaigns() = campaigns

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

    fun validate() = apply {
        if (!validated) {
            name()
            subject()
            body()
            htmlBody()
            fromName()
            fromEmail()
            preview()
            replyTo()
            remoteCreatedAt()
            remoteUpdatedAt()
            status()
            sendDate()
            template()
            campaigns()
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

        return other is Email &&
            this.name == other.name &&
            this.subject == other.subject &&
            this.body == other.body &&
            this.htmlBody == other.htmlBody &&
            this.fromName == other.fromName &&
            this.fromEmail == other.fromEmail &&
            this.preview == other.preview &&
            this.replyTo == other.replyTo &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.remoteUpdatedAt == other.remoteUpdatedAt &&
            this.status == other.status &&
            this.sendDate == other.sendDate &&
            this.template == other.template &&
            this.campaigns == other.campaigns &&
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
                    subject,
                    body,
                    htmlBody,
                    fromName,
                    fromEmail,
                    preview,
                    replyTo,
                    remoteCreatedAt,
                    remoteUpdatedAt,
                    status,
                    sendDate,
                    template,
                    campaigns,
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
        "Email{name=$name, subject=$subject, body=$body, htmlBody=$htmlBody, fromName=$fromName, fromEmail=$fromEmail, preview=$preview, replyTo=$replyTo, remoteCreatedAt=$remoteCreatedAt, remoteUpdatedAt=$remoteUpdatedAt, status=$status, sendDate=$sendDate, template=$template, campaigns=$campaigns, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var subject: JsonField<String> = JsonMissing.of()
        private var body: JsonField<String> = JsonMissing.of()
        private var htmlBody: JsonField<String> = JsonMissing.of()
        private var fromName: JsonField<String> = JsonMissing.of()
        private var fromEmail: JsonField<String> = JsonMissing.of()
        private var preview: JsonField<String> = JsonMissing.of()
        private var replyTo: JsonField<String> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteUpdatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var status: JsonField<MarketingEmailStatusEnum> = JsonMissing.of()
        private var sendDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var template: JsonField<String> = JsonMissing.of()
        private var campaigns: JsonField<List<String>> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(email: Email) = apply {
            this.name = email.name
            this.subject = email.subject
            this.body = email.body
            this.htmlBody = email.htmlBody
            this.fromName = email.fromName
            this.fromEmail = email.fromEmail
            this.preview = email.preview
            this.replyTo = email.replyTo
            this.remoteCreatedAt = email.remoteCreatedAt
            this.remoteUpdatedAt = email.remoteUpdatedAt
            this.status = email.status
            this.sendDate = email.sendDate
            this.template = email.template
            this.campaigns = email.campaigns
            this.remoteWasDeleted = email.remoteWasDeleted
            this.id = email.id
            this.remoteId = email.remoteId
            this.fieldMappings = email.fieldMappings
            this.modifiedAt = email.modifiedAt
            this.remoteData = email.remoteData
            additionalProperties(email.additionalProperties)
        }

        /** The marketing email's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The marketing email's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The marketing email's subject. */
        fun subject(subject: String) = subject(JsonField.of(subject))

        /** The marketing email's subject. */
        @JsonProperty("subject")
        @ExcludeMissing
        fun subject(subject: JsonField<String>) = apply { this.subject = subject }

        /** The marketing email's body. */
        fun body(body: String) = body(JsonField.of(body))

        /** The marketing email's body. */
        @JsonProperty("body")
        @ExcludeMissing
        fun body(body: JsonField<String>) = apply { this.body = body }

        /** The marketing email's html body. */
        fun htmlBody(htmlBody: String) = htmlBody(JsonField.of(htmlBody))

        /** The marketing email's html body. */
        @JsonProperty("html_body")
        @ExcludeMissing
        fun htmlBody(htmlBody: JsonField<String>) = apply { this.htmlBody = htmlBody }

        /** The marketing email's from name. */
        fun fromName(fromName: String) = fromName(JsonField.of(fromName))

        /** The marketing email's from name. */
        @JsonProperty("from_name")
        @ExcludeMissing
        fun fromName(fromName: JsonField<String>) = apply { this.fromName = fromName }

        /** The marketing email's from email. */
        fun fromEmail(fromEmail: String) = fromEmail(JsonField.of(fromEmail))

        /** The marketing email's from email. */
        @JsonProperty("from_email")
        @ExcludeMissing
        fun fromEmail(fromEmail: JsonField<String>) = apply { this.fromEmail = fromEmail }

        /** The marketing email's preview. */
        fun preview(preview: String) = preview(JsonField.of(preview))

        /** The marketing email's preview. */
        @JsonProperty("preview")
        @ExcludeMissing
        fun preview(preview: JsonField<String>) = apply { this.preview = preview }

        /** The marketing email's reply-to. */
        fun replyTo(replyTo: String) = replyTo(JsonField.of(replyTo))

        /** The marketing email's reply-to. */
        @JsonProperty("reply_to")
        @ExcludeMissing
        fun replyTo(replyTo: JsonField<String>) = apply { this.replyTo = replyTo }

        /** When the marketing email was created in the remote system. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the marketing email was created in the remote system. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** When the marketing email was last updated in the remote system. */
        fun remoteUpdatedAt(remoteUpdatedAt: OffsetDateTime) =
            remoteUpdatedAt(JsonField.of(remoteUpdatedAt))

        /** When the marketing email was last updated in the remote system. */
        @JsonProperty("remote_updated_at")
        @ExcludeMissing
        fun remoteUpdatedAt(remoteUpdatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteUpdatedAt = remoteUpdatedAt
        }

        /**
         * - `DRAFT` - DRAFT
         * - `QUEUED` - QUEUED
         * - `SENT` - SENT
         */
        fun status(status: MarketingEmailStatusEnum) = status(JsonField.of(status))

        /**
         * - `DRAFT` - DRAFT
         * - `QUEUED` - QUEUED
         * - `SENT` - SENT
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<MarketingEmailStatusEnum>) = apply { this.status = status }

        /** When the marketing email was sent. */
        fun sendDate(sendDate: OffsetDateTime) = sendDate(JsonField.of(sendDate))

        /** When the marketing email was sent. */
        @JsonProperty("send_date")
        @ExcludeMissing
        fun sendDate(sendDate: JsonField<OffsetDateTime>) = apply { this.sendDate = sendDate }

        /** The marketing email's template. */
        fun template(template: String) = template(JsonField.of(template))

        /** The marketing email's template. */
        @JsonProperty("template")
        @ExcludeMissing
        fun template(template: JsonField<String>) = apply { this.template = template }

        /** The campaigns receiving this marketing email. */
        fun campaigns(campaigns: List<String>) = campaigns(JsonField.of(campaigns))

        /** The campaigns receiving this marketing email. */
        @JsonProperty("campaigns")
        @ExcludeMissing
        fun campaigns(campaigns: JsonField<List<String>>) = apply { this.campaigns = campaigns }

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

        fun build(): Email =
            Email(
                name,
                subject,
                body,
                htmlBody,
                fromName,
                fromEmail,
                preview,
                replyTo,
                remoteCreatedAt,
                remoteUpdatedAt,
                status,
                sendDate,
                template,
                campaigns.map { it.toUnmodifiable() },
                remoteWasDeleted,
                id,
                remoteId,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class MarketingEmailStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MarketingEmailStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val DRAFT = MarketingEmailStatusEnum(JsonField.of("DRAFT"))

            @JvmField val QUEUED = MarketingEmailStatusEnum(JsonField.of("QUEUED"))

            @JvmField val SENT = MarketingEmailStatusEnum(JsonField.of("SENT"))

            @JvmStatic fun of(value: String) = MarketingEmailStatusEnum(JsonField.of(value))
        }

        enum class Known {
            DRAFT,
            QUEUED,
            SENT,
        }

        enum class Value {
            DRAFT,
            QUEUED,
            SENT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                DRAFT -> Value.DRAFT
                QUEUED -> Value.QUEUED
                SENT -> Value.SENT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                DRAFT -> Known.DRAFT
                QUEUED -> Known.QUEUED
                SENT -> Known.SENT
                else -> throw MergeInvalidDataException("Unknown MarketingEmailStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
