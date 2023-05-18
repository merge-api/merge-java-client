package dev.merge.api.models.accounting

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
 * # The TaxRate Object
 *
 * ### Description
 *
 * The `TaxRate` object is used to represent a tax rate.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST TaxRates` endpoint and view tax rates relevant to a company.
 */
@JsonDeserialize(builder = TaxRate.Builder::class)
@NoAutoDetect
class TaxRate
private constructor(
    private val description: JsonField<String>,
    private val totalTaxRate: JsonField<Double>,
    private val effectiveTaxRate: JsonField<Double>,
    private val company: JsonField<String>,
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

    /** The tax rate's description. */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /** The tax rate's total tax rate. */
    fun totalTaxRate(): Optional<Double> =
        Optional.ofNullable(totalTaxRate.getNullable("total_tax_rate"))

    /** The tax rate's effective tax rate. */
    fun effectiveTaxRate(): Optional<Double> =
        Optional.ofNullable(effectiveTaxRate.getNullable("effective_tax_rate"))

    /** The company the tax rate belongs to. */
    fun company(): Optional<String> = Optional.ofNullable(company.getNullable("company"))

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

    /** The tax rate's description. */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /** The tax rate's total tax rate. */
    @JsonProperty("total_tax_rate") @ExcludeMissing fun _totalTaxRate() = totalTaxRate

    /** The tax rate's effective tax rate. */
    @JsonProperty("effective_tax_rate") @ExcludeMissing fun _effectiveTaxRate() = effectiveTaxRate

    /** The company the tax rate belongs to. */
    @JsonProperty("company") @ExcludeMissing fun _company() = company

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

    fun validate(): TaxRate = apply {
        if (!validated) {
            description()
            totalTaxRate()
            effectiveTaxRate()
            company()
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

        return other is TaxRate &&
            this.description == other.description &&
            this.totalTaxRate == other.totalTaxRate &&
            this.effectiveTaxRate == other.effectiveTaxRate &&
            this.company == other.company &&
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
                    description,
                    totalTaxRate,
                    effectiveTaxRate,
                    company,
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
        "TaxRate{description=$description, totalTaxRate=$totalTaxRate, effectiveTaxRate=$effectiveTaxRate, company=$company, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var description: JsonField<String> = JsonMissing.of()
        private var totalTaxRate: JsonField<Double> = JsonMissing.of()
        private var effectiveTaxRate: JsonField<Double> = JsonMissing.of()
        private var company: JsonField<String> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(taxRate: TaxRate) = apply {
            this.description = taxRate.description
            this.totalTaxRate = taxRate.totalTaxRate
            this.effectiveTaxRate = taxRate.effectiveTaxRate
            this.company = taxRate.company
            this.remoteWasDeleted = taxRate.remoteWasDeleted
            this.id = taxRate.id
            this.remoteId = taxRate.remoteId
            this.fieldMappings = taxRate.fieldMappings
            this.modifiedAt = taxRate.modifiedAt
            this.remoteData = taxRate.remoteData
            additionalProperties(taxRate.additionalProperties)
        }

        /** The tax rate's description. */
        fun description(description: String) = description(JsonField.of(description))

        /** The tax rate's description. */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** The tax rate's total tax rate. */
        fun totalTaxRate(totalTaxRate: Double) = totalTaxRate(JsonField.of(totalTaxRate))

        /** The tax rate's total tax rate. */
        @JsonProperty("total_tax_rate")
        @ExcludeMissing
        fun totalTaxRate(totalTaxRate: JsonField<Double>) = apply {
            this.totalTaxRate = totalTaxRate
        }

        /** The tax rate's effective tax rate. */
        fun effectiveTaxRate(effectiveTaxRate: Double) =
            effectiveTaxRate(JsonField.of(effectiveTaxRate))

        /** The tax rate's effective tax rate. */
        @JsonProperty("effective_tax_rate")
        @ExcludeMissing
        fun effectiveTaxRate(effectiveTaxRate: JsonField<Double>) = apply {
            this.effectiveTaxRate = effectiveTaxRate
        }

        /** The company the tax rate belongs to. */
        fun company(company: String) = company(JsonField.of(company))

        /** The company the tax rate belongs to. */
        @JsonProperty("company")
        @ExcludeMissing
        fun company(company: JsonField<String>) = apply { this.company = company }

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

        fun build(): TaxRate =
            TaxRate(
                description,
                totalTaxRate,
                effectiveTaxRate,
                company,
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
