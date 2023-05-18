package dev.merge.api.models.hris

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
 * # The Company Object
 *
 * ### Description
 *
 * The `Company` object is used to represent a company within the HRIS / Payroll system.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Companies` endpoint and filter by `ID` to show all companies.
 */
@JsonDeserialize(builder = Company.Builder::class)
@NoAutoDetect
class Company
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val legalName: JsonField<String>,
    private val displayName: JsonField<String>,
    private val eins: JsonField<List<String>>,
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

    /** The company's legal name. */
    fun legalName(): Optional<String> = Optional.ofNullable(legalName.getNullable("legal_name"))

    /** The company's display name. */
    fun displayName(): Optional<String> =
        Optional.ofNullable(displayName.getNullable("display_name"))

    /** The company's Employer Identification Numbers. */
    fun eins(): Optional<List<String>> = Optional.ofNullable(eins.getNullable("eins"))

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

    /** The company's legal name. */
    @JsonProperty("legal_name") @ExcludeMissing fun _legalName() = legalName

    /** The company's display name. */
    @JsonProperty("display_name") @ExcludeMissing fun _displayName() = displayName

    /** The company's Employer Identification Numbers. */
    @JsonProperty("eins") @ExcludeMissing fun _eins() = eins

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Company = apply {
        if (!validated) {
            id()
            remoteId()
            legalName()
            displayName()
            eins()
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

        return other is Company &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.legalName == other.legalName &&
            this.displayName == other.displayName &&
            this.eins == other.eins &&
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
                    legalName,
                    displayName,
                    eins,
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
        "Company{id=$id, remoteId=$remoteId, legalName=$legalName, displayName=$displayName, eins=$eins, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var legalName: JsonField<String> = JsonMissing.of()
        private var displayName: JsonField<String> = JsonMissing.of()
        private var eins: JsonField<List<String>> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(company: Company) = apply {
            this.id = company.id
            this.remoteId = company.remoteId
            this.legalName = company.legalName
            this.displayName = company.displayName
            this.eins = company.eins
            this.remoteWasDeleted = company.remoteWasDeleted
            this.fieldMappings = company.fieldMappings
            this.modifiedAt = company.modifiedAt
            this.remoteData = company.remoteData
            additionalProperties(company.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The company's legal name. */
        fun legalName(legalName: String) = legalName(JsonField.of(legalName))

        /** The company's legal name. */
        @JsonProperty("legal_name")
        @ExcludeMissing
        fun legalName(legalName: JsonField<String>) = apply { this.legalName = legalName }

        /** The company's display name. */
        fun displayName(displayName: String) = displayName(JsonField.of(displayName))

        /** The company's display name. */
        @JsonProperty("display_name")
        @ExcludeMissing
        fun displayName(displayName: JsonField<String>) = apply { this.displayName = displayName }

        /** The company's Employer Identification Numbers. */
        fun eins(eins: List<String>) = eins(JsonField.of(eins))

        /** The company's Employer Identification Numbers. */
        @JsonProperty("eins")
        @ExcludeMissing
        fun eins(eins: JsonField<List<String>>) = apply { this.eins = eins }

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

        fun build(): Company =
            Company(
                id,
                remoteId,
                legalName,
                displayName,
                eins.map { it.toUnmodifiable() },
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }
}
