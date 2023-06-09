package dev.merge.api.models.marketing

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
 * # The Campaign Object
 *
 * ### Description
 *
 * The `Campaign` object is used to represent a marketing campaign in the remote system.
 *
 * ### Usage Example
 *
 * Fetch from the `GET /api/mktg/v1/campaigns` endpoint and view their unique opens.
 */
@JsonDeserialize(builder = Campaign.Builder::class)
@NoAutoDetect
class Campaign
private constructor(
    private val name: JsonField<String>,
    private val uniqueOpens: JsonField<Long>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val emailsSent: JsonField<Long>,
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

    /** The campaign's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The campaign's unique opens. */
    fun uniqueOpens(): Optional<Long> = Optional.ofNullable(uniqueOpens.getNullable("unique_opens"))

    /** When the campaign was created in the remote system. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** The campaign's number of emails sent. */
    fun emailsSent(): Optional<Long> = Optional.ofNullable(emailsSent.getNullable("emails_sent"))

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

    /** The campaign's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The campaign's unique opens. */
    @JsonProperty("unique_opens") @ExcludeMissing fun _uniqueOpens() = uniqueOpens

    /** When the campaign was created in the remote system. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** The campaign's number of emails sent. */
    @JsonProperty("emails_sent") @ExcludeMissing fun _emailsSent() = emailsSent

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

    fun validate(): Campaign = apply {
        if (!validated) {
            name()
            uniqueOpens()
            remoteCreatedAt()
            emailsSent()
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

        return other is Campaign &&
            this.name == other.name &&
            this.uniqueOpens == other.uniqueOpens &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.emailsSent == other.emailsSent &&
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
                    uniqueOpens,
                    remoteCreatedAt,
                    emailsSent,
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
        "Campaign{name=$name, uniqueOpens=$uniqueOpens, remoteCreatedAt=$remoteCreatedAt, emailsSent=$emailsSent, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var uniqueOpens: JsonField<Long> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var emailsSent: JsonField<Long> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(campaign: Campaign) = apply {
            this.name = campaign.name
            this.uniqueOpens = campaign.uniqueOpens
            this.remoteCreatedAt = campaign.remoteCreatedAt
            this.emailsSent = campaign.emailsSent
            this.remoteWasDeleted = campaign.remoteWasDeleted
            this.id = campaign.id
            this.remoteId = campaign.remoteId
            this.fieldMappings = campaign.fieldMappings
            this.modifiedAt = campaign.modifiedAt
            this.remoteData = campaign.remoteData
            additionalProperties(campaign.additionalProperties)
        }

        /** The campaign's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The campaign's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The campaign's unique opens. */
        fun uniqueOpens(uniqueOpens: Long) = uniqueOpens(JsonField.of(uniqueOpens))

        /** The campaign's unique opens. */
        @JsonProperty("unique_opens")
        @ExcludeMissing
        fun uniqueOpens(uniqueOpens: JsonField<Long>) = apply { this.uniqueOpens = uniqueOpens }

        /** When the campaign was created in the remote system. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the campaign was created in the remote system. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** The campaign's number of emails sent. */
        fun emailsSent(emailsSent: Long) = emailsSent(JsonField.of(emailsSent))

        /** The campaign's number of emails sent. */
        @JsonProperty("emails_sent")
        @ExcludeMissing
        fun emailsSent(emailsSent: JsonField<Long>) = apply { this.emailsSent = emailsSent }

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

        fun build(): Campaign =
            Campaign(
                name,
                uniqueOpens,
                remoteCreatedAt,
                emailsSent,
                remoteWasDeleted,
                id,
                remoteId,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }
}
