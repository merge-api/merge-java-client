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
 * # The Benefit Object
 *
 * ### Description
 *
 * The `Benefit` object is used to represent a benefit that an employee has enrolled in.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Benefits` endpoint and filter by `ID` to show all benefits.
 */
@JsonDeserialize(builder = Benefit.Builder::class)
@NoAutoDetect
class Benefit
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val employee: JsonField<String>,
    private val providerName: JsonField<String>,
    private val benefitPlanType: JsonField<String>,
    private val employeeContribution: JsonField<Double>,
    private val companyContribution: JsonField<Double>,
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

    /** The employee on the plan. */
    fun employee(): Optional<String> = Optional.ofNullable(employee.getNullable("employee"))

    /** The name of the benefit provider. */
    fun providerName(): Optional<String> =
        Optional.ofNullable(providerName.getNullable("provider_name"))

    /** The type of benefit plan */
    fun benefitPlanType(): Optional<String> =
        Optional.ofNullable(benefitPlanType.getNullable("benefit_plan_type"))

    /** The employee's contribution. */
    fun employeeContribution(): Optional<Double> =
        Optional.ofNullable(employeeContribution.getNullable("employee_contribution"))

    /** The company's contribution. */
    fun companyContribution(): Optional<Double> =
        Optional.ofNullable(companyContribution.getNullable("company_contribution"))

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

    /** The employee on the plan. */
    @JsonProperty("employee") @ExcludeMissing fun _employee() = employee

    /** The name of the benefit provider. */
    @JsonProperty("provider_name") @ExcludeMissing fun _providerName() = providerName

    /** The type of benefit plan */
    @JsonProperty("benefit_plan_type") @ExcludeMissing fun _benefitPlanType() = benefitPlanType

    /** The employee's contribution. */
    @JsonProperty("employee_contribution")
    @ExcludeMissing
    fun _employeeContribution() = employeeContribution

    /** The company's contribution. */
    @JsonProperty("company_contribution")
    @ExcludeMissing
    fun _companyContribution() = companyContribution

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
            providerName()
            benefitPlanType()
            employeeContribution()
            companyContribution()
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

        return other is Benefit &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.employee == other.employee &&
            this.providerName == other.providerName &&
            this.benefitPlanType == other.benefitPlanType &&
            this.employeeContribution == other.employeeContribution &&
            this.companyContribution == other.companyContribution &&
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
                    providerName,
                    benefitPlanType,
                    employeeContribution,
                    companyContribution,
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
        "Benefit{id=$id, remoteId=$remoteId, employee=$employee, providerName=$providerName, benefitPlanType=$benefitPlanType, employeeContribution=$employeeContribution, companyContribution=$companyContribution, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var employee: JsonField<String> = JsonMissing.of()
        private var providerName: JsonField<String> = JsonMissing.of()
        private var benefitPlanType: JsonField<String> = JsonMissing.of()
        private var employeeContribution: JsonField<Double> = JsonMissing.of()
        private var companyContribution: JsonField<Double> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(benefit: Benefit) = apply {
            this.id = benefit.id
            this.remoteId = benefit.remoteId
            this.employee = benefit.employee
            this.providerName = benefit.providerName
            this.benefitPlanType = benefit.benefitPlanType
            this.employeeContribution = benefit.employeeContribution
            this.companyContribution = benefit.companyContribution
            this.remoteWasDeleted = benefit.remoteWasDeleted
            this.fieldMappings = benefit.fieldMappings
            this.modifiedAt = benefit.modifiedAt
            this.remoteData = benefit.remoteData
            additionalProperties(benefit.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The employee on the plan. */
        fun employee(employee: String) = employee(JsonField.of(employee))

        /** The employee on the plan. */
        @JsonProperty("employee")
        @ExcludeMissing
        fun employee(employee: JsonField<String>) = apply { this.employee = employee }

        /** The name of the benefit provider. */
        fun providerName(providerName: String) = providerName(JsonField.of(providerName))

        /** The name of the benefit provider. */
        @JsonProperty("provider_name")
        @ExcludeMissing
        fun providerName(providerName: JsonField<String>) = apply {
            this.providerName = providerName
        }

        /** The type of benefit plan */
        fun benefitPlanType(benefitPlanType: String) =
            benefitPlanType(JsonField.of(benefitPlanType))

        /** The type of benefit plan */
        @JsonProperty("benefit_plan_type")
        @ExcludeMissing
        fun benefitPlanType(benefitPlanType: JsonField<String>) = apply {
            this.benefitPlanType = benefitPlanType
        }

        /** The employee's contribution. */
        fun employeeContribution(employeeContribution: Double) =
            employeeContribution(JsonField.of(employeeContribution))

        /** The employee's contribution. */
        @JsonProperty("employee_contribution")
        @ExcludeMissing
        fun employeeContribution(employeeContribution: JsonField<Double>) = apply {
            this.employeeContribution = employeeContribution
        }

        /** The company's contribution. */
        fun companyContribution(companyContribution: Double) =
            companyContribution(JsonField.of(companyContribution))

        /** The company's contribution. */
        @JsonProperty("company_contribution")
        @ExcludeMissing
        fun companyContribution(companyContribution: JsonField<Double>) = apply {
            this.companyContribution = companyContribution
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

        fun build(): Benefit =
            Benefit(
                id,
                remoteId,
                employee,
                providerName,
                benefitPlanType,
                employeeContribution,
                companyContribution,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }
}
