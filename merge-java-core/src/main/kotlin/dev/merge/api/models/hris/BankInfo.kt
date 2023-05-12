package dev.merge.api.models.hris

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
 * # The BankInfo Object
 *
 * ### Description
 *
 * The `BankInfo` object is used to represent the Bank Account information for an Employee.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST BankInfo` endpoint and filter by `ID` to show all bank information.
 */
@JsonDeserialize(builder = BankInfo.Builder::class)
@NoAutoDetect
class BankInfo
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val employee: JsonField<String>,
    private val accountNumber: JsonField<String>,
    private val routingNumber: JsonField<String>,
    private val bankName: JsonField<String>,
    private val accountType: JsonField<AccountTypeEnum>,
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

    /** The employee with this bank account. */
    fun employee(): Optional<String> = Optional.ofNullable(employee.getNullable("employee"))

    /** The account number. */
    fun accountNumber(): Optional<String> =
        Optional.ofNullable(accountNumber.getNullable("account_number"))

    /** The routing number. */
    fun routingNumber(): Optional<String> =
        Optional.ofNullable(routingNumber.getNullable("routing_number"))

    /** The bank name. */
    fun bankName(): Optional<String> = Optional.ofNullable(bankName.getNullable("bank_name"))

    /**
     * - `SAVINGS` - SAVINGS
     * - `CHECKING` - CHECKING
     */
    fun accountType(): Optional<AccountTypeEnum> =
        Optional.ofNullable(accountType.getNullable("account_type"))

    /** When the matching bank object was created in the third party system. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

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

    /** The employee with this bank account. */
    @JsonProperty("employee") @ExcludeMissing fun _employee() = employee

    /** The account number. */
    @JsonProperty("account_number") @ExcludeMissing fun _accountNumber() = accountNumber

    /** The routing number. */
    @JsonProperty("routing_number") @ExcludeMissing fun _routingNumber() = routingNumber

    /** The bank name. */
    @JsonProperty("bank_name") @ExcludeMissing fun _bankName() = bankName

    /**
     * - `SAVINGS` - SAVINGS
     * - `CHECKING` - CHECKING
     */
    @JsonProperty("account_type") @ExcludeMissing fun _accountType() = accountType

    /** When the matching bank object was created in the third party system. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

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
            employee()
            accountNumber()
            routingNumber()
            bankName()
            accountType()
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

        return other is BankInfo &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.employee == other.employee &&
            this.accountNumber == other.accountNumber &&
            this.routingNumber == other.routingNumber &&
            this.bankName == other.bankName &&
            this.accountType == other.accountType &&
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
                    employee,
                    accountNumber,
                    routingNumber,
                    bankName,
                    accountType,
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
        "BankInfo{id=$id, remoteId=$remoteId, employee=$employee, accountNumber=$accountNumber, routingNumber=$routingNumber, bankName=$bankName, accountType=$accountType, remoteCreatedAt=$remoteCreatedAt, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var employee: JsonField<String> = JsonMissing.of()
        private var accountNumber: JsonField<String> = JsonMissing.of()
        private var routingNumber: JsonField<String> = JsonMissing.of()
        private var bankName: JsonField<String> = JsonMissing.of()
        private var accountType: JsonField<AccountTypeEnum> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(bankInfo: BankInfo) = apply {
            this.id = bankInfo.id
            this.remoteId = bankInfo.remoteId
            this.employee = bankInfo.employee
            this.accountNumber = bankInfo.accountNumber
            this.routingNumber = bankInfo.routingNumber
            this.bankName = bankInfo.bankName
            this.accountType = bankInfo.accountType
            this.remoteCreatedAt = bankInfo.remoteCreatedAt
            this.remoteWasDeleted = bankInfo.remoteWasDeleted
            this.fieldMappings = bankInfo.fieldMappings
            this.modifiedAt = bankInfo.modifiedAt
            this.remoteData = bankInfo.remoteData
            additionalProperties(bankInfo.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The employee with this bank account. */
        fun employee(employee: String) = employee(JsonField.of(employee))

        /** The employee with this bank account. */
        @JsonProperty("employee")
        @ExcludeMissing
        fun employee(employee: JsonField<String>) = apply { this.employee = employee }

        /** The account number. */
        fun accountNumber(accountNumber: String) = accountNumber(JsonField.of(accountNumber))

        /** The account number. */
        @JsonProperty("account_number")
        @ExcludeMissing
        fun accountNumber(accountNumber: JsonField<String>) = apply {
            this.accountNumber = accountNumber
        }

        /** The routing number. */
        fun routingNumber(routingNumber: String) = routingNumber(JsonField.of(routingNumber))

        /** The routing number. */
        @JsonProperty("routing_number")
        @ExcludeMissing
        fun routingNumber(routingNumber: JsonField<String>) = apply {
            this.routingNumber = routingNumber
        }

        /** The bank name. */
        fun bankName(bankName: String) = bankName(JsonField.of(bankName))

        /** The bank name. */
        @JsonProperty("bank_name")
        @ExcludeMissing
        fun bankName(bankName: JsonField<String>) = apply { this.bankName = bankName }

        /**
         * - `SAVINGS` - SAVINGS
         * - `CHECKING` - CHECKING
         */
        fun accountType(accountType: AccountTypeEnum) = accountType(JsonField.of(accountType))

        /**
         * - `SAVINGS` - SAVINGS
         * - `CHECKING` - CHECKING
         */
        @JsonProperty("account_type")
        @ExcludeMissing
        fun accountType(accountType: JsonField<AccountTypeEnum>) = apply {
            this.accountType = accountType
        }

        /** When the matching bank object was created in the third party system. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the matching bank object was created in the third party system. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
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

        fun build(): BankInfo =
            BankInfo(
                id,
                remoteId,
                employee,
                accountNumber,
                routingNumber,
                bankName,
                accountType,
                remoteCreatedAt,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class AccountTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AccountTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val SAVINGS = AccountTypeEnum(JsonField.of("SAVINGS"))

            @JvmField val CHECKING = AccountTypeEnum(JsonField.of("CHECKING"))

            @JvmStatic fun of(value: String) = AccountTypeEnum(JsonField.of(value))
        }

        enum class Known {
            SAVINGS,
            CHECKING,
        }

        enum class Value {
            SAVINGS,
            CHECKING,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SAVINGS -> Value.SAVINGS
                CHECKING -> Value.CHECKING
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SAVINGS -> Known.SAVINGS
                CHECKING -> Known.CHECKING
                else -> throw MergeInvalidDataException("Unknown AccountTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
