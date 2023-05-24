package dev.merge.api.models.ticketing

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
 * # The Comment Object
 *
 * ### Description
 *
 * The `Comment` object is used to represent a comment on a ticket.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = Comment.Builder::class)
@NoAutoDetect
class Comment
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val user: JsonField<String>,
    private val contact: JsonField<String>,
    private val body: JsonField<String>,
    private val htmlBody: JsonField<String>,
    private val ticket: JsonField<String>,
    private val isPrivate: JsonField<Boolean>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
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

    /** The author of the Comment, if the author is a User. */
    fun user(): Optional<String> = Optional.ofNullable(user.getNullable("user"))

    /** The author of the Comment, if the author is a Contact. */
    fun contact(): Optional<String> = Optional.ofNullable(contact.getNullable("contact"))

    /** The comment's text body. */
    fun body(): Optional<String> = Optional.ofNullable(body.getNullable("body"))

    /** The comment's text body formatted as html. */
    fun htmlBody(): Optional<String> = Optional.ofNullable(htmlBody.getNullable("html_body"))

    /** The ticket associated with the comment. */
    fun ticket(): Optional<String> = Optional.ofNullable(ticket.getNullable("ticket"))

    /** Whether or not the comment is internal. */
    fun isPrivate(): Optional<Boolean> = Optional.ofNullable(isPrivate.getNullable("is_private"))

    /** When the third party's comment was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

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

    /** The author of the Comment, if the author is a User. */
    @JsonProperty("user") @ExcludeMissing fun _user() = user

    /** The author of the Comment, if the author is a Contact. */
    @JsonProperty("contact") @ExcludeMissing fun _contact() = contact

    /** The comment's text body. */
    @JsonProperty("body") @ExcludeMissing fun _body() = body

    /** The comment's text body formatted as html. */
    @JsonProperty("html_body") @ExcludeMissing fun _htmlBody() = htmlBody

    /** The ticket associated with the comment. */
    @JsonProperty("ticket") @ExcludeMissing fun _ticket() = ticket

    /** Whether or not the comment is internal. */
    @JsonProperty("is_private") @ExcludeMissing fun _isPrivate() = isPrivate

    /** When the third party's comment was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Comment = apply {
        if (!validated) {
            id()
            remoteId()
            user()
            contact()
            body()
            htmlBody()
            ticket()
            isPrivate()
            remoteCreatedAt()
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

        return other is Comment &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.user == other.user &&
            this.contact == other.contact &&
            this.body == other.body &&
            this.htmlBody == other.htmlBody &&
            this.ticket == other.ticket &&
            this.isPrivate == other.isPrivate &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
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
                    user,
                    contact,
                    body,
                    htmlBody,
                    ticket,
                    isPrivate,
                    remoteCreatedAt,
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
        "Comment{id=$id, remoteId=$remoteId, user=$user, contact=$contact, body=$body, htmlBody=$htmlBody, ticket=$ticket, isPrivate=$isPrivate, remoteCreatedAt=$remoteCreatedAt, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var user: JsonField<String> = JsonMissing.of()
        private var contact: JsonField<String> = JsonMissing.of()
        private var body: JsonField<String> = JsonMissing.of()
        private var htmlBody: JsonField<String> = JsonMissing.of()
        private var ticket: JsonField<String> = JsonMissing.of()
        private var isPrivate: JsonField<Boolean> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(comment: Comment) = apply {
            this.id = comment.id
            this.remoteId = comment.remoteId
            this.user = comment.user
            this.contact = comment.contact
            this.body = comment.body
            this.htmlBody = comment.htmlBody
            this.ticket = comment.ticket
            this.isPrivate = comment.isPrivate
            this.remoteCreatedAt = comment.remoteCreatedAt
            this.remoteWasDeleted = comment.remoteWasDeleted
            this.fieldMappings = comment.fieldMappings
            this.modifiedAt = comment.modifiedAt
            this.remoteData = comment.remoteData
            additionalProperties(comment.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The author of the Comment, if the author is a User. */
        fun user(user: String) = user(JsonField.of(user))

        /** The author of the Comment, if the author is a User. */
        @JsonProperty("user")
        @ExcludeMissing
        fun user(user: JsonField<String>) = apply { this.user = user }

        /** The author of the Comment, if the author is a Contact. */
        fun contact(contact: String) = contact(JsonField.of(contact))

        /** The author of the Comment, if the author is a Contact. */
        @JsonProperty("contact")
        @ExcludeMissing
        fun contact(contact: JsonField<String>) = apply { this.contact = contact }

        /** The comment's text body. */
        fun body(body: String) = body(JsonField.of(body))

        /** The comment's text body. */
        @JsonProperty("body")
        @ExcludeMissing
        fun body(body: JsonField<String>) = apply { this.body = body }

        /** The comment's text body formatted as html. */
        fun htmlBody(htmlBody: String) = htmlBody(JsonField.of(htmlBody))

        /** The comment's text body formatted as html. */
        @JsonProperty("html_body")
        @ExcludeMissing
        fun htmlBody(htmlBody: JsonField<String>) = apply { this.htmlBody = htmlBody }

        /** The ticket associated with the comment. */
        fun ticket(ticket: String) = ticket(JsonField.of(ticket))

        /** The ticket associated with the comment. */
        @JsonProperty("ticket")
        @ExcludeMissing
        fun ticket(ticket: JsonField<String>) = apply { this.ticket = ticket }

        /** Whether or not the comment is internal. */
        fun isPrivate(isPrivate: Boolean) = isPrivate(JsonField.of(isPrivate))

        /** Whether or not the comment is internal. */
        @JsonProperty("is_private")
        @ExcludeMissing
        fun isPrivate(isPrivate: JsonField<Boolean>) = apply { this.isPrivate = isPrivate }

        /** When the third party's comment was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's comment was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
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

        fun build(): Comment =
            Comment(
                id,
                remoteId,
                user,
                contact,
                body,
                htmlBody,
                ticket,
                isPrivate,
                remoteCreatedAt,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }
}
