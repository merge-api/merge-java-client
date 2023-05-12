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
 * # The EmployeePayrollRun Object
 *
 * ### Description
 *
 * The `EmployeePayrollRun` object is used to represent an employee's pay statement for a specific
 * payroll run.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST EmployeePayrollRun` endpoint and filter by `ID` to show all employee payroll
 * runs.
 */
@JsonDeserialize(builder = EmployeePayrollRun.Builder::class)
@NoAutoDetect
class EmployeePayrollRun
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val employee: JsonField<String>,
    private val payrollRun: JsonField<String>,
    private val grossPay: JsonField<Double>,
    private val netPay: JsonField<Double>,
    private val startDate: JsonField<OffsetDateTime>,
    private val endDate: JsonField<OffsetDateTime>,
    private val checkDate: JsonField<OffsetDateTime>,
    private val earnings: JsonField<List<Earning>>,
    private val deductions: JsonField<List<Deduction>>,
    private val taxes: JsonField<List<Tax>>,
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

    /** The employee whose payroll is being run. */
    fun employee(): Optional<String> = Optional.ofNullable(employee.getNullable("employee"))

    /** The payroll being run. */
    fun payrollRun(): Optional<String> = Optional.ofNullable(payrollRun.getNullable("payroll_run"))

    /**
     * The total earnings throughout a given period for an employee before any deductions are made.
     */
    fun grossPay(): Optional<Double> = Optional.ofNullable(grossPay.getNullable("gross_pay"))

    /** The take-home pay throughout a given period for an employee after deductions are made. */
    fun netPay(): Optional<Double> = Optional.ofNullable(netPay.getNullable("net_pay"))

    /** The day and time the payroll run started. */
    fun startDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(startDate.getNullable("start_date"))

    /** The day and time the payroll run ended. */
    fun endDate(): Optional<OffsetDateTime> = Optional.ofNullable(endDate.getNullable("end_date"))

    /** The day and time the payroll run was checked. */
    fun checkDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(checkDate.getNullable("check_date"))

    fun earnings(): Optional<List<Earning>> = Optional.ofNullable(earnings.getNullable("earnings"))

    fun deductions(): Optional<List<Deduction>> =
        Optional.ofNullable(deductions.getNullable("deductions"))

    fun taxes(): Optional<List<Tax>> = Optional.ofNullable(taxes.getNullable("taxes"))

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

    /** The employee whose payroll is being run. */
    @JsonProperty("employee") @ExcludeMissing fun _employee() = employee

    /** The payroll being run. */
    @JsonProperty("payroll_run") @ExcludeMissing fun _payrollRun() = payrollRun

    /**
     * The total earnings throughout a given period for an employee before any deductions are made.
     */
    @JsonProperty("gross_pay") @ExcludeMissing fun _grossPay() = grossPay

    /** The take-home pay throughout a given period for an employee after deductions are made. */
    @JsonProperty("net_pay") @ExcludeMissing fun _netPay() = netPay

    /** The day and time the payroll run started. */
    @JsonProperty("start_date") @ExcludeMissing fun _startDate() = startDate

    /** The day and time the payroll run ended. */
    @JsonProperty("end_date") @ExcludeMissing fun _endDate() = endDate

    /** The day and time the payroll run was checked. */
    @JsonProperty("check_date") @ExcludeMissing fun _checkDate() = checkDate

    @JsonProperty("earnings") @ExcludeMissing fun _earnings() = earnings

    @JsonProperty("deductions") @ExcludeMissing fun _deductions() = deductions

    @JsonProperty("taxes") @ExcludeMissing fun _taxes() = taxes

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
            payrollRun()
            grossPay()
            netPay()
            startDate()
            endDate()
            checkDate()
            earnings().map { it.forEach { it.validate() } }
            deductions().map { it.forEach { it.validate() } }
            taxes().map { it.forEach { it.validate() } }
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

        return other is EmployeePayrollRun &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.employee == other.employee &&
            this.payrollRun == other.payrollRun &&
            this.grossPay == other.grossPay &&
            this.netPay == other.netPay &&
            this.startDate == other.startDate &&
            this.endDate == other.endDate &&
            this.checkDate == other.checkDate &&
            this.earnings == other.earnings &&
            this.deductions == other.deductions &&
            this.taxes == other.taxes &&
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
                    payrollRun,
                    grossPay,
                    netPay,
                    startDate,
                    endDate,
                    checkDate,
                    earnings,
                    deductions,
                    taxes,
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
        "EmployeePayrollRun{id=$id, remoteId=$remoteId, employee=$employee, payrollRun=$payrollRun, grossPay=$grossPay, netPay=$netPay, startDate=$startDate, endDate=$endDate, checkDate=$checkDate, earnings=$earnings, deductions=$deductions, taxes=$taxes, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var employee: JsonField<String> = JsonMissing.of()
        private var payrollRun: JsonField<String> = JsonMissing.of()
        private var grossPay: JsonField<Double> = JsonMissing.of()
        private var netPay: JsonField<Double> = JsonMissing.of()
        private var startDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var endDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var checkDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var earnings: JsonField<List<Earning>> = JsonMissing.of()
        private var deductions: JsonField<List<Deduction>> = JsonMissing.of()
        private var taxes: JsonField<List<Tax>> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(employeePayrollRun: EmployeePayrollRun) = apply {
            this.id = employeePayrollRun.id
            this.remoteId = employeePayrollRun.remoteId
            this.employee = employeePayrollRun.employee
            this.payrollRun = employeePayrollRun.payrollRun
            this.grossPay = employeePayrollRun.grossPay
            this.netPay = employeePayrollRun.netPay
            this.startDate = employeePayrollRun.startDate
            this.endDate = employeePayrollRun.endDate
            this.checkDate = employeePayrollRun.checkDate
            this.earnings = employeePayrollRun.earnings
            this.deductions = employeePayrollRun.deductions
            this.taxes = employeePayrollRun.taxes
            this.remoteWasDeleted = employeePayrollRun.remoteWasDeleted
            this.fieldMappings = employeePayrollRun.fieldMappings
            this.modifiedAt = employeePayrollRun.modifiedAt
            this.remoteData = employeePayrollRun.remoteData
            additionalProperties(employeePayrollRun.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The employee whose payroll is being run. */
        fun employee(employee: String) = employee(JsonField.of(employee))

        /** The employee whose payroll is being run. */
        @JsonProperty("employee")
        @ExcludeMissing
        fun employee(employee: JsonField<String>) = apply { this.employee = employee }

        /** The payroll being run. */
        fun payrollRun(payrollRun: String) = payrollRun(JsonField.of(payrollRun))

        /** The payroll being run. */
        @JsonProperty("payroll_run")
        @ExcludeMissing
        fun payrollRun(payrollRun: JsonField<String>) = apply { this.payrollRun = payrollRun }

        /**
         * The total earnings throughout a given period for an employee before any deductions are
         * made.
         */
        fun grossPay(grossPay: Double) = grossPay(JsonField.of(grossPay))

        /**
         * The total earnings throughout a given period for an employee before any deductions are
         * made.
         */
        @JsonProperty("gross_pay")
        @ExcludeMissing
        fun grossPay(grossPay: JsonField<Double>) = apply { this.grossPay = grossPay }

        /**
         * The take-home pay throughout a given period for an employee after deductions are made.
         */
        fun netPay(netPay: Double) = netPay(JsonField.of(netPay))

        /**
         * The take-home pay throughout a given period for an employee after deductions are made.
         */
        @JsonProperty("net_pay")
        @ExcludeMissing
        fun netPay(netPay: JsonField<Double>) = apply { this.netPay = netPay }

        /** The day and time the payroll run started. */
        fun startDate(startDate: OffsetDateTime) = startDate(JsonField.of(startDate))

        /** The day and time the payroll run started. */
        @JsonProperty("start_date")
        @ExcludeMissing
        fun startDate(startDate: JsonField<OffsetDateTime>) = apply { this.startDate = startDate }

        /** The day and time the payroll run ended. */
        fun endDate(endDate: OffsetDateTime) = endDate(JsonField.of(endDate))

        /** The day and time the payroll run ended. */
        @JsonProperty("end_date")
        @ExcludeMissing
        fun endDate(endDate: JsonField<OffsetDateTime>) = apply { this.endDate = endDate }

        /** The day and time the payroll run was checked. */
        fun checkDate(checkDate: OffsetDateTime) = checkDate(JsonField.of(checkDate))

        /** The day and time the payroll run was checked. */
        @JsonProperty("check_date")
        @ExcludeMissing
        fun checkDate(checkDate: JsonField<OffsetDateTime>) = apply { this.checkDate = checkDate }

        fun earnings(earnings: List<Earning>) = earnings(JsonField.of(earnings))

        @JsonProperty("earnings")
        @ExcludeMissing
        fun earnings(earnings: JsonField<List<Earning>>) = apply { this.earnings = earnings }

        fun deductions(deductions: List<Deduction>) = deductions(JsonField.of(deductions))

        @JsonProperty("deductions")
        @ExcludeMissing
        fun deductions(deductions: JsonField<List<Deduction>>) = apply {
            this.deductions = deductions
        }

        fun taxes(taxes: List<Tax>) = taxes(JsonField.of(taxes))

        @JsonProperty("taxes")
        @ExcludeMissing
        fun taxes(taxes: JsonField<List<Tax>>) = apply { this.taxes = taxes }

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

        fun build(): EmployeePayrollRun =
            EmployeePayrollRun(
                id,
                remoteId,
                employee,
                payrollRun,
                grossPay,
                netPay,
                startDate,
                endDate,
                checkDate,
                earnings.map { it.toUnmodifiable() },
                deductions.map { it.toUnmodifiable() },
                taxes.map { it.toUnmodifiable() },
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Earning Object
     *
     * ### Description
     *
     * The `Earning` object is used to represent an array of different compensations that an
     * employee receives within specific wage categories.
     *
     * ### Usage Example
     *
     * Fetch from the `LIST Earnings` endpoint and filter by `ID` to show all earnings.
     */
    @JsonDeserialize(builder = Earning.Builder::class)
    @NoAutoDetect
    class Earning
    private constructor(
        private val id: JsonField<String>,
        private val remoteId: JsonField<String>,
        private val employeePayrollRun: JsonField<String>,
        private val amount: JsonField<Double>,
        private val type: JsonField<EarningTypeEnum>,
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

        fun employeePayrollRun(): Optional<String> =
            Optional.ofNullable(employeePayrollRun.getNullable("employee_payroll_run"))

        /** The amount earned. */
        fun amount(): Optional<Double> = Optional.ofNullable(amount.getNullable("amount"))

        /**
         * - `SALARY` - SALARY
         * - `REIMBURSEMENT` - REIMBURSEMENT
         * - `OVERTIME` - OVERTIME
         * - `BONUS` - BONUS
         */
        fun type(): Optional<EarningTypeEnum> = Optional.ofNullable(type.getNullable("type"))

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

        @JsonProperty("employee_payroll_run")
        @ExcludeMissing
        fun _employeePayrollRun() = employeePayrollRun

        /** The amount earned. */
        @JsonProperty("amount") @ExcludeMissing fun _amount() = amount

        /**
         * - `SALARY` - SALARY
         * - `REIMBURSEMENT` - REIMBURSEMENT
         * - `OVERTIME` - OVERTIME
         * - `BONUS` - BONUS
         */
        @JsonProperty("type") @ExcludeMissing fun _type() = type

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        @JsonProperty("remote_was_deleted")
        @ExcludeMissing
        fun _remoteWasDeleted() = remoteWasDeleted

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
                employeePayrollRun()
                amount()
                type()
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

            return other is Earning &&
                this.id == other.id &&
                this.remoteId == other.remoteId &&
                this.employeePayrollRun == other.employeePayrollRun &&
                this.amount == other.amount &&
                this.type == other.type &&
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
                        employeePayrollRun,
                        amount,
                        type,
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
            "Earning{id=$id, remoteId=$remoteId, employeePayrollRun=$employeePayrollRun, amount=$amount, type=$type, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var id: JsonField<String> = JsonMissing.of()
            private var remoteId: JsonField<String> = JsonMissing.of()
            private var employeePayrollRun: JsonField<String> = JsonMissing.of()
            private var amount: JsonField<Double> = JsonMissing.of()
            private var type: JsonField<EarningTypeEnum> = JsonMissing.of()
            private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
            private var fieldMappings: JsonValue = JsonMissing.of()
            private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(earning: Earning) = apply {
                this.id = earning.id
                this.remoteId = earning.remoteId
                this.employeePayrollRun = earning.employeePayrollRun
                this.amount = earning.amount
                this.type = earning.type
                this.remoteWasDeleted = earning.remoteWasDeleted
                this.fieldMappings = earning.fieldMappings
                this.modifiedAt = earning.modifiedAt
                this.remoteData = earning.remoteData
                additionalProperties(earning.additionalProperties)
            }

            fun id(id: String) = id(JsonField.of(id))

            @JsonProperty("id")
            @ExcludeMissing
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The third-party API ID of the matching object. */
            fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

            /** The third-party API ID of the matching object. */
            @JsonProperty("remote_id")
            @ExcludeMissing
            fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

            fun employeePayrollRun(employeePayrollRun: String) =
                employeePayrollRun(JsonField.of(employeePayrollRun))

            @JsonProperty("employee_payroll_run")
            @ExcludeMissing
            fun employeePayrollRun(employeePayrollRun: JsonField<String>) = apply {
                this.employeePayrollRun = employeePayrollRun
            }

            /** The amount earned. */
            fun amount(amount: Double) = amount(JsonField.of(amount))

            /** The amount earned. */
            @JsonProperty("amount")
            @ExcludeMissing
            fun amount(amount: JsonField<Double>) = apply { this.amount = amount }

            /**
             * - `SALARY` - SALARY
             * - `REIMBURSEMENT` - REIMBURSEMENT
             * - `OVERTIME` - OVERTIME
             * - `BONUS` - BONUS
             */
            fun type(type: EarningTypeEnum) = type(JsonField.of(type))

            /**
             * - `SALARY` - SALARY
             * - `REIMBURSEMENT` - REIMBURSEMENT
             * - `OVERTIME` - OVERTIME
             * - `BONUS` - BONUS
             */
            @JsonProperty("type")
            @ExcludeMissing
            fun type(type: JsonField<EarningTypeEnum>) = apply { this.type = type }

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
            fun fieldMappings(fieldMappings: JsonValue) = apply {
                this.fieldMappings = fieldMappings
            }

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

            fun build(): Earning =
                Earning(
                    id,
                    remoteId,
                    employeePayrollRun,
                    amount,
                    type,
                    remoteWasDeleted,
                    fieldMappings,
                    modifiedAt,
                    remoteData.map { it.toUnmodifiable() },
                    additionalProperties.toUnmodifiable(),
                )
        }

        class EarningTypeEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EarningTypeEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val SALARY = EarningTypeEnum(JsonField.of("SALARY"))

                @JvmField val REIMBURSEMENT = EarningTypeEnum(JsonField.of("REIMBURSEMENT"))

                @JvmField val OVERTIME = EarningTypeEnum(JsonField.of("OVERTIME"))

                @JvmField val BONUS = EarningTypeEnum(JsonField.of("BONUS"))

                @JvmStatic fun of(value: String) = EarningTypeEnum(JsonField.of(value))
            }

            enum class Known {
                SALARY,
                REIMBURSEMENT,
                OVERTIME,
                BONUS,
            }

            enum class Value {
                SALARY,
                REIMBURSEMENT,
                OVERTIME,
                BONUS,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    SALARY -> Value.SALARY
                    REIMBURSEMENT -> Value.REIMBURSEMENT
                    OVERTIME -> Value.OVERTIME
                    BONUS -> Value.BONUS
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    SALARY -> Known.SALARY
                    REIMBURSEMENT -> Known.REIMBURSEMENT
                    OVERTIME -> Known.OVERTIME
                    BONUS -> Known.BONUS
                    else -> throw MergeInvalidDataException("Unknown EarningTypeEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }

    /**
     * # The Deduction Object
     *
     * ### Description
     *
     * The `Deduction` object is used to represent an array of the wages withheld from total
     * earnings for the purpose of paying taxes.
     *
     * ### Usage Example
     *
     * Fetch from the `LIST Deductions` endpoint and filter by `ID` to show all deductions.
     */
    @JsonDeserialize(builder = Deduction.Builder::class)
    @NoAutoDetect
    class Deduction
    private constructor(
        private val id: JsonField<String>,
        private val remoteId: JsonField<String>,
        private val employeePayrollRun: JsonField<String>,
        private val name: JsonField<String>,
        private val employeeDeduction: JsonField<Double>,
        private val companyDeduction: JsonField<Double>,
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

        fun employeePayrollRun(): Optional<String> =
            Optional.ofNullable(employeePayrollRun.getNullable("employee_payroll_run"))

        /** The deduction's name. */
        fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

        /** The amount of money that is withheld from an employee's gross pay by the employee. */
        fun employeeDeduction(): Optional<Double> =
            Optional.ofNullable(employeeDeduction.getNullable("employee_deduction"))

        /** The amount of money that is withheld on behalf of an employee by the company. */
        fun companyDeduction(): Optional<Double> =
            Optional.ofNullable(companyDeduction.getNullable("company_deduction"))

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

        @JsonProperty("employee_payroll_run")
        @ExcludeMissing
        fun _employeePayrollRun() = employeePayrollRun

        /** The deduction's name. */
        @JsonProperty("name") @ExcludeMissing fun _name() = name

        /** The amount of money that is withheld from an employee's gross pay by the employee. */
        @JsonProperty("employee_deduction")
        @ExcludeMissing
        fun _employeeDeduction() = employeeDeduction

        /** The amount of money that is withheld on behalf of an employee by the company. */
        @JsonProperty("company_deduction")
        @ExcludeMissing
        fun _companyDeduction() = companyDeduction

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        @JsonProperty("remote_was_deleted")
        @ExcludeMissing
        fun _remoteWasDeleted() = remoteWasDeleted

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
                employeePayrollRun()
                name()
                employeeDeduction()
                companyDeduction()
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

            return other is Deduction &&
                this.id == other.id &&
                this.remoteId == other.remoteId &&
                this.employeePayrollRun == other.employeePayrollRun &&
                this.name == other.name &&
                this.employeeDeduction == other.employeeDeduction &&
                this.companyDeduction == other.companyDeduction &&
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
                        employeePayrollRun,
                        name,
                        employeeDeduction,
                        companyDeduction,
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
            "Deduction{id=$id, remoteId=$remoteId, employeePayrollRun=$employeePayrollRun, name=$name, employeeDeduction=$employeeDeduction, companyDeduction=$companyDeduction, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var id: JsonField<String> = JsonMissing.of()
            private var remoteId: JsonField<String> = JsonMissing.of()
            private var employeePayrollRun: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var employeeDeduction: JsonField<Double> = JsonMissing.of()
            private var companyDeduction: JsonField<Double> = JsonMissing.of()
            private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
            private var fieldMappings: JsonValue = JsonMissing.of()
            private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(deduction: Deduction) = apply {
                this.id = deduction.id
                this.remoteId = deduction.remoteId
                this.employeePayrollRun = deduction.employeePayrollRun
                this.name = deduction.name
                this.employeeDeduction = deduction.employeeDeduction
                this.companyDeduction = deduction.companyDeduction
                this.remoteWasDeleted = deduction.remoteWasDeleted
                this.fieldMappings = deduction.fieldMappings
                this.modifiedAt = deduction.modifiedAt
                this.remoteData = deduction.remoteData
                additionalProperties(deduction.additionalProperties)
            }

            fun id(id: String) = id(JsonField.of(id))

            @JsonProperty("id")
            @ExcludeMissing
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The third-party API ID of the matching object. */
            fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

            /** The third-party API ID of the matching object. */
            @JsonProperty("remote_id")
            @ExcludeMissing
            fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

            fun employeePayrollRun(employeePayrollRun: String) =
                employeePayrollRun(JsonField.of(employeePayrollRun))

            @JsonProperty("employee_payroll_run")
            @ExcludeMissing
            fun employeePayrollRun(employeePayrollRun: JsonField<String>) = apply {
                this.employeePayrollRun = employeePayrollRun
            }

            /** The deduction's name. */
            fun name(name: String) = name(JsonField.of(name))

            /** The deduction's name. */
            @JsonProperty("name")
            @ExcludeMissing
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * The amount of money that is withheld from an employee's gross pay by the employee.
             */
            fun employeeDeduction(employeeDeduction: Double) =
                employeeDeduction(JsonField.of(employeeDeduction))

            /**
             * The amount of money that is withheld from an employee's gross pay by the employee.
             */
            @JsonProperty("employee_deduction")
            @ExcludeMissing
            fun employeeDeduction(employeeDeduction: JsonField<Double>) = apply {
                this.employeeDeduction = employeeDeduction
            }

            /** The amount of money that is withheld on behalf of an employee by the company. */
            fun companyDeduction(companyDeduction: Double) =
                companyDeduction(JsonField.of(companyDeduction))

            /** The amount of money that is withheld on behalf of an employee by the company. */
            @JsonProperty("company_deduction")
            @ExcludeMissing
            fun companyDeduction(companyDeduction: JsonField<Double>) = apply {
                this.companyDeduction = companyDeduction
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
            fun fieldMappings(fieldMappings: JsonValue) = apply {
                this.fieldMappings = fieldMappings
            }

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

            fun build(): Deduction =
                Deduction(
                    id,
                    remoteId,
                    employeePayrollRun,
                    name,
                    employeeDeduction,
                    companyDeduction,
                    remoteWasDeleted,
                    fieldMappings,
                    modifiedAt,
                    remoteData.map { it.toUnmodifiable() },
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    /**
     * # The Tax Object
     *
     * ### Description
     *
     * The `Tax` object is used to represent an array of the tax deductions for a given employee's
     * payroll run.
     *
     * ### Usage Example
     *
     * Fetch from the `LIST Taxes` endpoint and filter by `ID` to show all taxes.
     */
    @JsonDeserialize(builder = Tax.Builder::class)
    @NoAutoDetect
    class Tax
    private constructor(
        private val id: JsonField<String>,
        private val remoteId: JsonField<String>,
        private val employeePayrollRun: JsonField<String>,
        private val name: JsonField<String>,
        private val amount: JsonField<Double>,
        private val employerTax: JsonField<Boolean>,
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

        fun employeePayrollRun(): Optional<String> =
            Optional.ofNullable(employeePayrollRun.getNullable("employee_payroll_run"))

        /** The tax's name. */
        fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

        /** The tax amount. */
        fun amount(): Optional<Double> = Optional.ofNullable(amount.getNullable("amount"))

        /** Whether or not the employer is responsible for paying the tax. */
        fun employerTax(): Optional<Boolean> =
            Optional.ofNullable(employerTax.getNullable("employer_tax"))

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

        @JsonProperty("employee_payroll_run")
        @ExcludeMissing
        fun _employeePayrollRun() = employeePayrollRun

        /** The tax's name. */
        @JsonProperty("name") @ExcludeMissing fun _name() = name

        /** The tax amount. */
        @JsonProperty("amount") @ExcludeMissing fun _amount() = amount

        /** Whether or not the employer is responsible for paying the tax. */
        @JsonProperty("employer_tax") @ExcludeMissing fun _employerTax() = employerTax

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        @JsonProperty("remote_was_deleted")
        @ExcludeMissing
        fun _remoteWasDeleted() = remoteWasDeleted

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
                employeePayrollRun()
                name()
                amount()
                employerTax()
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

            return other is Tax &&
                this.id == other.id &&
                this.remoteId == other.remoteId &&
                this.employeePayrollRun == other.employeePayrollRun &&
                this.name == other.name &&
                this.amount == other.amount &&
                this.employerTax == other.employerTax &&
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
                        employeePayrollRun,
                        name,
                        amount,
                        employerTax,
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
            "Tax{id=$id, remoteId=$remoteId, employeePayrollRun=$employeePayrollRun, name=$name, amount=$amount, employerTax=$employerTax, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var id: JsonField<String> = JsonMissing.of()
            private var remoteId: JsonField<String> = JsonMissing.of()
            private var employeePayrollRun: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var amount: JsonField<Double> = JsonMissing.of()
            private var employerTax: JsonField<Boolean> = JsonMissing.of()
            private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
            private var fieldMappings: JsonValue = JsonMissing.of()
            private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(tax: Tax) = apply {
                this.id = tax.id
                this.remoteId = tax.remoteId
                this.employeePayrollRun = tax.employeePayrollRun
                this.name = tax.name
                this.amount = tax.amount
                this.employerTax = tax.employerTax
                this.remoteWasDeleted = tax.remoteWasDeleted
                this.fieldMappings = tax.fieldMappings
                this.modifiedAt = tax.modifiedAt
                this.remoteData = tax.remoteData
                additionalProperties(tax.additionalProperties)
            }

            fun id(id: String) = id(JsonField.of(id))

            @JsonProperty("id")
            @ExcludeMissing
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The third-party API ID of the matching object. */
            fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

            /** The third-party API ID of the matching object. */
            @JsonProperty("remote_id")
            @ExcludeMissing
            fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

            fun employeePayrollRun(employeePayrollRun: String) =
                employeePayrollRun(JsonField.of(employeePayrollRun))

            @JsonProperty("employee_payroll_run")
            @ExcludeMissing
            fun employeePayrollRun(employeePayrollRun: JsonField<String>) = apply {
                this.employeePayrollRun = employeePayrollRun
            }

            /** The tax's name. */
            fun name(name: String) = name(JsonField.of(name))

            /** The tax's name. */
            @JsonProperty("name")
            @ExcludeMissing
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The tax amount. */
            fun amount(amount: Double) = amount(JsonField.of(amount))

            /** The tax amount. */
            @JsonProperty("amount")
            @ExcludeMissing
            fun amount(amount: JsonField<Double>) = apply { this.amount = amount }

            /** Whether or not the employer is responsible for paying the tax. */
            fun employerTax(employerTax: Boolean) = employerTax(JsonField.of(employerTax))

            /** Whether or not the employer is responsible for paying the tax. */
            @JsonProperty("employer_tax")
            @ExcludeMissing
            fun employerTax(employerTax: JsonField<Boolean>) = apply {
                this.employerTax = employerTax
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
            fun fieldMappings(fieldMappings: JsonValue) = apply {
                this.fieldMappings = fieldMappings
            }

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

            fun build(): Tax =
                Tax(
                    id,
                    remoteId,
                    employeePayrollRun,
                    name,
                    amount,
                    employerTax,
                    remoteWasDeleted,
                    fieldMappings,
                    modifiedAt,
                    remoteData.map { it.toUnmodifiable() },
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
