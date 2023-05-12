package dev.merge.api.models.ats

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
 * # The Offer Object
 *
 * ### Description
 *
 * The `Offer` object is used to represent an offer for a candidate's application specific to a job.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Offers` endpoint and filter by `ID` to show all offers.
 */
@JsonDeserialize(builder = Offer.Builder::class)
@NoAutoDetect
class Offer
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val application: JsonField<String>,
    private val creator: JsonField<String>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val closedAt: JsonField<OffsetDateTime>,
    private val sentAt: JsonField<OffsetDateTime>,
    private val startDate: JsonField<OffsetDateTime>,
    private val status: JsonField<OfferStatusEnum>,
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

    /** The application who is receiving the offer. */
    fun application(): Optional<String> =
        Optional.ofNullable(application.getNullable("application"))

    /** The user who created the offer. */
    fun creator(): Optional<String> = Optional.ofNullable(creator.getNullable("creator"))

    /** When the third party's offer was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /** When the offer was closed. */
    fun closedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(closedAt.getNullable("closed_at"))

    /** When the offer was sent. */
    fun sentAt(): Optional<OffsetDateTime> = Optional.ofNullable(sentAt.getNullable("sent_at"))

    /** The employment start date on the offer. */
    fun startDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(startDate.getNullable("start_date"))

    /**
     * - `DRAFT` - DRAFT
     * - `APPROVAL-SENT` - APPROVAL-SENT
     * - `APPROVED` - APPROVED
     * - `SENT` - SENT
     * - `SENT-MANUALLY` - SENT-MANUALLY
     * - `OPENED` - OPENED
     * - `DENIED` - DENIED
     * - `SIGNED` - SIGNED
     * - `DEPRECATED` - DEPRECATED
     */
    fun status(): Optional<OfferStatusEnum> = Optional.ofNullable(status.getNullable("status"))

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

    /** The application who is receiving the offer. */
    @JsonProperty("application") @ExcludeMissing fun _application() = application

    /** The user who created the offer. */
    @JsonProperty("creator") @ExcludeMissing fun _creator() = creator

    /** When the third party's offer was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /** When the offer was closed. */
    @JsonProperty("closed_at") @ExcludeMissing fun _closedAt() = closedAt

    /** When the offer was sent. */
    @JsonProperty("sent_at") @ExcludeMissing fun _sentAt() = sentAt

    /** The employment start date on the offer. */
    @JsonProperty("start_date") @ExcludeMissing fun _startDate() = startDate

    /**
     * - `DRAFT` - DRAFT
     * - `APPROVAL-SENT` - APPROVAL-SENT
     * - `APPROVED` - APPROVED
     * - `SENT` - SENT
     * - `SENT-MANUALLY` - SENT-MANUALLY
     * - `OPENED` - OPENED
     * - `DENIED` - DENIED
     * - `SIGNED` - SIGNED
     * - `DEPRECATED` - DEPRECATED
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

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
            application()
            creator()
            remoteCreatedAt()
            closedAt()
            sentAt()
            startDate()
            status()
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

        return other is Offer &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.application == other.application &&
            this.creator == other.creator &&
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.closedAt == other.closedAt &&
            this.sentAt == other.sentAt &&
            this.startDate == other.startDate &&
            this.status == other.status &&
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
                    application,
                    creator,
                    remoteCreatedAt,
                    closedAt,
                    sentAt,
                    startDate,
                    status,
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
        "Offer{id=$id, remoteId=$remoteId, application=$application, creator=$creator, remoteCreatedAt=$remoteCreatedAt, closedAt=$closedAt, sentAt=$sentAt, startDate=$startDate, status=$status, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var application: JsonField<String> = JsonMissing.of()
        private var creator: JsonField<String> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var closedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var sentAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var startDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var status: JsonField<OfferStatusEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(offer: Offer) = apply {
            this.id = offer.id
            this.remoteId = offer.remoteId
            this.application = offer.application
            this.creator = offer.creator
            this.remoteCreatedAt = offer.remoteCreatedAt
            this.closedAt = offer.closedAt
            this.sentAt = offer.sentAt
            this.startDate = offer.startDate
            this.status = offer.status
            this.remoteWasDeleted = offer.remoteWasDeleted
            this.fieldMappings = offer.fieldMappings
            this.modifiedAt = offer.modifiedAt
            this.remoteData = offer.remoteData
            additionalProperties(offer.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The application who is receiving the offer. */
        fun application(application: String) = application(JsonField.of(application))

        /** The application who is receiving the offer. */
        @JsonProperty("application")
        @ExcludeMissing
        fun application(application: JsonField<String>) = apply { this.application = application }

        /** The user who created the offer. */
        fun creator(creator: String) = creator(JsonField.of(creator))

        /** The user who created the offer. */
        @JsonProperty("creator")
        @ExcludeMissing
        fun creator(creator: JsonField<String>) = apply { this.creator = creator }

        /** When the third party's offer was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's offer was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /** When the offer was closed. */
        fun closedAt(closedAt: OffsetDateTime) = closedAt(JsonField.of(closedAt))

        /** When the offer was closed. */
        @JsonProperty("closed_at")
        @ExcludeMissing
        fun closedAt(closedAt: JsonField<OffsetDateTime>) = apply { this.closedAt = closedAt }

        /** When the offer was sent. */
        fun sentAt(sentAt: OffsetDateTime) = sentAt(JsonField.of(sentAt))

        /** When the offer was sent. */
        @JsonProperty("sent_at")
        @ExcludeMissing
        fun sentAt(sentAt: JsonField<OffsetDateTime>) = apply { this.sentAt = sentAt }

        /** The employment start date on the offer. */
        fun startDate(startDate: OffsetDateTime) = startDate(JsonField.of(startDate))

        /** The employment start date on the offer. */
        @JsonProperty("start_date")
        @ExcludeMissing
        fun startDate(startDate: JsonField<OffsetDateTime>) = apply { this.startDate = startDate }

        /**
         * - `DRAFT` - DRAFT
         * - `APPROVAL-SENT` - APPROVAL-SENT
         * - `APPROVED` - APPROVED
         * - `SENT` - SENT
         * - `SENT-MANUALLY` - SENT-MANUALLY
         * - `OPENED` - OPENED
         * - `DENIED` - DENIED
         * - `SIGNED` - SIGNED
         * - `DEPRECATED` - DEPRECATED
         */
        fun status(status: OfferStatusEnum) = status(JsonField.of(status))

        /**
         * - `DRAFT` - DRAFT
         * - `APPROVAL-SENT` - APPROVAL-SENT
         * - `APPROVED` - APPROVED
         * - `SENT` - SENT
         * - `SENT-MANUALLY` - SENT-MANUALLY
         * - `OPENED` - OPENED
         * - `DENIED` - DENIED
         * - `SIGNED` - SIGNED
         * - `DEPRECATED` - DEPRECATED
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<OfferStatusEnum>) = apply { this.status = status }

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

        fun build(): Offer =
            Offer(
                id,
                remoteId,
                application,
                creator,
                remoteCreatedAt,
                closedAt,
                sentAt,
                startDate,
                status,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class OfferStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OfferStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val DRAFT = OfferStatusEnum(JsonField.of("DRAFT"))

            @JvmField val APPROVAL_SENT = OfferStatusEnum(JsonField.of("APPROVAL-SENT"))

            @JvmField val APPROVED = OfferStatusEnum(JsonField.of("APPROVED"))

            @JvmField val SENT = OfferStatusEnum(JsonField.of("SENT"))

            @JvmField val SENT_MANUALLY = OfferStatusEnum(JsonField.of("SENT-MANUALLY"))

            @JvmField val OPENED = OfferStatusEnum(JsonField.of("OPENED"))

            @JvmField val DENIED = OfferStatusEnum(JsonField.of("DENIED"))

            @JvmField val SIGNED = OfferStatusEnum(JsonField.of("SIGNED"))

            @JvmField val DEPRECATED = OfferStatusEnum(JsonField.of("DEPRECATED"))

            @JvmStatic fun of(value: String) = OfferStatusEnum(JsonField.of(value))
        }

        enum class Known {
            DRAFT,
            APPROVAL_SENT,
            APPROVED,
            SENT,
            SENT_MANUALLY,
            OPENED,
            DENIED,
            SIGNED,
            DEPRECATED,
        }

        enum class Value {
            DRAFT,
            APPROVAL_SENT,
            APPROVED,
            SENT,
            SENT_MANUALLY,
            OPENED,
            DENIED,
            SIGNED,
            DEPRECATED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                DRAFT -> Value.DRAFT
                APPROVAL_SENT -> Value.APPROVAL_SENT
                APPROVED -> Value.APPROVED
                SENT -> Value.SENT
                SENT_MANUALLY -> Value.SENT_MANUALLY
                OPENED -> Value.OPENED
                DENIED -> Value.DENIED
                SIGNED -> Value.SIGNED
                DEPRECATED -> Value.DEPRECATED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                DRAFT -> Known.DRAFT
                APPROVAL_SENT -> Known.APPROVAL_SENT
                APPROVED -> Known.APPROVED
                SENT -> Known.SENT
                SENT_MANUALLY -> Known.SENT_MANUALLY
                OPENED -> Known.OPENED
                DENIED -> Known.DENIED
                SIGNED -> Known.SIGNED
                DEPRECATED -> Known.DEPRECATED
                else -> throw MergeInvalidDataException("Unknown OfferStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
