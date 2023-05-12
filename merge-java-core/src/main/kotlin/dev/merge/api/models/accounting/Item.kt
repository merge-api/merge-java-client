package dev.merge.api.models.accounting

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
 * # The Item Object
 *
 * ### Description
 *
 * The `Item` object refers to the goods involved in a transaction.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Items` endpoint and view a company's items.
 */
@JsonDeserialize(builder = Item.Builder::class)
@NoAutoDetect
class Item
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val name: JsonField<String>,
    private val status: JsonField<Status7d1Enum>,
    private val unitPrice: JsonField<Double>,
    private val purchasePrice: JsonField<Double>,
    private val purchaseAccount: JsonField<String>,
    private val salesAccount: JsonField<String>,
    private val company: JsonField<String>,
    private val remoteUpdatedAt: JsonField<OffsetDateTime>,
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

    /** The item's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /**
     * - `ACTIVE` - ACTIVE
     * - `ARCHIVED` - ARCHIVED
     */
    fun status(): Optional<Status7d1Enum> = Optional.ofNullable(status.getNullable("status"))

    /** The item's unit price. */
    fun unitPrice(): Optional<Double> = Optional.ofNullable(unitPrice.getNullable("unit_price"))

    /** The price at which the item is purchased from a vendor. */
    fun purchasePrice(): Optional<Double> =
        Optional.ofNullable(purchasePrice.getNullable("purchase_price"))

    /** References the default account used to record a purchase of the item. */
    fun purchaseAccount(): Optional<String> =
        Optional.ofNullable(purchaseAccount.getNullable("purchase_account"))

    /** References the default account used to record a sale. */
    fun salesAccount(): Optional<String> =
        Optional.ofNullable(salesAccount.getNullable("sales_account"))

    /** The company the item belongs to. */
    fun company(): Optional<String> = Optional.ofNullable(company.getNullable("company"))

    /** When the third party's item note was updated. */
    fun remoteUpdatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteUpdatedAt.getNullable("remote_updated_at"))

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

    /** The item's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /**
     * - `ACTIVE` - ACTIVE
     * - `ARCHIVED` - ARCHIVED
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** The item's unit price. */
    @JsonProperty("unit_price") @ExcludeMissing fun _unitPrice() = unitPrice

    /** The price at which the item is purchased from a vendor. */
    @JsonProperty("purchase_price") @ExcludeMissing fun _purchasePrice() = purchasePrice

    /** References the default account used to record a purchase of the item. */
    @JsonProperty("purchase_account") @ExcludeMissing fun _purchaseAccount() = purchaseAccount

    /** References the default account used to record a sale. */
    @JsonProperty("sales_account") @ExcludeMissing fun _salesAccount() = salesAccount

    /** The company the item belongs to. */
    @JsonProperty("company") @ExcludeMissing fun _company() = company

    /** When the third party's item note was updated. */
    @JsonProperty("remote_updated_at") @ExcludeMissing fun _remoteUpdatedAt() = remoteUpdatedAt

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
            name()
            status()
            unitPrice()
            purchasePrice()
            purchaseAccount()
            salesAccount()
            company()
            remoteUpdatedAt()
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

        return other is Item &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.name == other.name &&
            this.status == other.status &&
            this.unitPrice == other.unitPrice &&
            this.purchasePrice == other.purchasePrice &&
            this.purchaseAccount == other.purchaseAccount &&
            this.salesAccount == other.salesAccount &&
            this.company == other.company &&
            this.remoteUpdatedAt == other.remoteUpdatedAt &&
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
                    name,
                    status,
                    unitPrice,
                    purchasePrice,
                    purchaseAccount,
                    salesAccount,
                    company,
                    remoteUpdatedAt,
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
        "Item{id=$id, remoteId=$remoteId, name=$name, status=$status, unitPrice=$unitPrice, purchasePrice=$purchasePrice, purchaseAccount=$purchaseAccount, salesAccount=$salesAccount, company=$company, remoteUpdatedAt=$remoteUpdatedAt, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status7d1Enum> = JsonMissing.of()
        private var unitPrice: JsonField<Double> = JsonMissing.of()
        private var purchasePrice: JsonField<Double> = JsonMissing.of()
        private var purchaseAccount: JsonField<String> = JsonMissing.of()
        private var salesAccount: JsonField<String> = JsonMissing.of()
        private var company: JsonField<String> = JsonMissing.of()
        private var remoteUpdatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(item: Item) = apply {
            this.id = item.id
            this.remoteId = item.remoteId
            this.name = item.name
            this.status = item.status
            this.unitPrice = item.unitPrice
            this.purchasePrice = item.purchasePrice
            this.purchaseAccount = item.purchaseAccount
            this.salesAccount = item.salesAccount
            this.company = item.company
            this.remoteUpdatedAt = item.remoteUpdatedAt
            this.remoteWasDeleted = item.remoteWasDeleted
            this.fieldMappings = item.fieldMappings
            this.modifiedAt = item.modifiedAt
            this.remoteData = item.remoteData
            additionalProperties(item.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The item's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The item's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * - `ACTIVE` - ACTIVE
         * - `ARCHIVED` - ARCHIVED
         */
        fun status(status: Status7d1Enum) = status(JsonField.of(status))

        /**
         * - `ACTIVE` - ACTIVE
         * - `ARCHIVED` - ARCHIVED
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status7d1Enum>) = apply { this.status = status }

        /** The item's unit price. */
        fun unitPrice(unitPrice: Double) = unitPrice(JsonField.of(unitPrice))

        /** The item's unit price. */
        @JsonProperty("unit_price")
        @ExcludeMissing
        fun unitPrice(unitPrice: JsonField<Double>) = apply { this.unitPrice = unitPrice }

        /** The price at which the item is purchased from a vendor. */
        fun purchasePrice(purchasePrice: Double) = purchasePrice(JsonField.of(purchasePrice))

        /** The price at which the item is purchased from a vendor. */
        @JsonProperty("purchase_price")
        @ExcludeMissing
        fun purchasePrice(purchasePrice: JsonField<Double>) = apply {
            this.purchasePrice = purchasePrice
        }

        /** References the default account used to record a purchase of the item. */
        fun purchaseAccount(purchaseAccount: String) =
            purchaseAccount(JsonField.of(purchaseAccount))

        /** References the default account used to record a purchase of the item. */
        @JsonProperty("purchase_account")
        @ExcludeMissing
        fun purchaseAccount(purchaseAccount: JsonField<String>) = apply {
            this.purchaseAccount = purchaseAccount
        }

        /** References the default account used to record a sale. */
        fun salesAccount(salesAccount: String) = salesAccount(JsonField.of(salesAccount))

        /** References the default account used to record a sale. */
        @JsonProperty("sales_account")
        @ExcludeMissing
        fun salesAccount(salesAccount: JsonField<String>) = apply {
            this.salesAccount = salesAccount
        }

        /** The company the item belongs to. */
        fun company(company: String) = company(JsonField.of(company))

        /** The company the item belongs to. */
        @JsonProperty("company")
        @ExcludeMissing
        fun company(company: JsonField<String>) = apply { this.company = company }

        /** When the third party's item note was updated. */
        fun remoteUpdatedAt(remoteUpdatedAt: OffsetDateTime) =
            remoteUpdatedAt(JsonField.of(remoteUpdatedAt))

        /** When the third party's item note was updated. */
        @JsonProperty("remote_updated_at")
        @ExcludeMissing
        fun remoteUpdatedAt(remoteUpdatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteUpdatedAt = remoteUpdatedAt
        }

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

        fun build(): Item =
            Item(
                id,
                remoteId,
                name,
                status,
                unitPrice,
                purchasePrice,
                purchaseAccount,
                salesAccount,
                company,
                remoteUpdatedAt,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class Status7d1Enum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status7d1Enum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ACTIVE = Status7d1Enum(JsonField.of("ACTIVE"))

            @JvmField val ARCHIVED = Status7d1Enum(JsonField.of("ARCHIVED"))

            @JvmStatic fun of(value: String) = Status7d1Enum(JsonField.of(value))
        }

        enum class Known {
            ACTIVE,
            ARCHIVED,
        }

        enum class Value {
            ACTIVE,
            ARCHIVED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ACTIVE -> Value.ACTIVE
                ARCHIVED -> Value.ARCHIVED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ACTIVE -> Known.ACTIVE
                ARCHIVED -> Known.ARCHIVED
                else -> throw MergeInvalidDataException("Unknown Status7d1Enum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
