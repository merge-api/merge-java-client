package dev.merge.api.models.hris

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

class EmployeeCreateParams
constructor(
    private val model: EmployeeRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): EmployeeRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): EmployeeCreateBody {
        return EmployeeCreateBody(model, additionalBodyProperties)
    }

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.isDebugMode?.let { params.put("is_debug_mode", listOf(it.toString())) }
        this.runAsync?.let { params.put("run_async", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = EmployeeCreateBody.Builder::class)
    @NoAutoDetect
    class EmployeeCreateBody
    internal constructor(
        private val model: EmployeeRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Employee Object
         *
         * ### Description
         *
         * The `Employee` object is used to represent any person who has been employed by a company.
         *
         * ### Usage Example
         *
         * Fetch from the `LIST Employee` endpoint and filter by `ID` to show all employees.
         */
        @JsonProperty("model") fun model(): EmployeeRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EmployeeCreateBody &&
                this.model == other.model &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(model, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "EmployeeCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: EmployeeRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(employeeCreateBody: EmployeeCreateBody) = apply {
                this.model = employeeCreateBody.model
                additionalProperties(employeeCreateBody.additionalProperties)
            }

            /**
             * # The Employee Object
             *
             * ### Description
             *
             * The `Employee` object is used to represent any person who has been employed by a
             * company.
             *
             * ### Usage Example
             *
             * Fetch from the `LIST Employee` endpoint and filter by `ID` to show all employees.
             */
            @JsonProperty("model") fun model(model: EmployeeRequest) = apply { this.model = model }

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

            fun build(): EmployeeCreateBody =
                EmployeeCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    additionalProperties.toUnmodifiable()
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EmployeeCreateParams &&
            this.model == other.model &&
            this.isDebugMode == other.isDebugMode &&
            this.runAsync == other.runAsync &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            isDebugMode,
            runAsync,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "EmployeeCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: EmployeeRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(employeeCreateParams: EmployeeCreateParams) = apply {
            this.model = employeeCreateParams.model
            this.isDebugMode = employeeCreateParams.isDebugMode
            this.runAsync = employeeCreateParams.runAsync
            additionalQueryParams(employeeCreateParams.additionalQueryParams)
            additionalHeaders(employeeCreateParams.additionalHeaders)
            additionalBodyProperties(employeeCreateParams.additionalBodyProperties)
        }

        /**
         * # The Employee Object
         *
         * ### Description
         *
         * The `Employee` object is used to represent any person who has been employed by a company.
         *
         * ### Usage Example
         *
         * Fetch from the `LIST Employee` endpoint and filter by `ID` to show all employees.
         */
        fun model(model: EmployeeRequest) = apply { this.model = model }

        /** Whether to include debug fields (such as log file links) in the response. */
        fun isDebugMode(isDebugMode: Boolean) = apply { this.isDebugMode = isDebugMode }

        /** Whether or not third-party updates should be run asynchronously. */
        fun runAsync(runAsync: Boolean) = apply { this.runAsync = runAsync }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): EmployeeCreateParams =
            EmployeeCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Employee Object
     *
     * ### Description
     *
     * The `Employee` object is used to represent any person who has been employed by a company.
     *
     * ### Usage Example
     *
     * Fetch from the `LIST Employee` endpoint and filter by `ID` to show all employees.
     */
    @JsonDeserialize(builder = EmployeeRequest.Builder::class)
    @NoAutoDetect
    class EmployeeRequest
    private constructor(
        private val employeeNumber: String?,
        private val company: String?,
        private val firstName: String?,
        private val lastName: String?,
        private val displayFullName: String?,
        private val username: String?,
        private val groups: List<String>?,
        private val workEmail: String?,
        private val personalEmail: String?,
        private val mobilePhoneNumber: String?,
        private val employments: List<String>?,
        private val homeLocation: String?,
        private val workLocation: String?,
        private val manager: String?,
        private val team: String?,
        private val payGroup: String?,
        private val ssn: String?,
        private val gender: GenderEnum?,
        private val ethnicity: EthnicityEnum?,
        private val maritalStatus: MaritalStatusEnum?,
        private val dateOfBirth: OffsetDateTime?,
        private val hireDate: OffsetDateTime?,
        private val startDate: OffsetDateTime?,
        private val employmentStatus: EmploymentStatusEnum?,
        private val terminationDate: OffsetDateTime?,
        private val avatar: String?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The employee's number that appears in the third-party integration's UI. */
        @JsonProperty("employee_number") fun employeeNumber(): String? = employeeNumber

        /** The ID of the employee's company. */
        @JsonProperty("company") fun company(): String? = company

        /** The employee's first name. */
        @JsonProperty("first_name") fun firstName(): String? = firstName

        /** The employee's last name. */
        @JsonProperty("last_name") fun lastName(): String? = lastName

        /**
         * The employee's full name, to use for display purposes. If a preferred first name is
         * available, the full name will include the preferred first name.
         */
        @JsonProperty("display_full_name") fun displayFullName(): String? = displayFullName

        /** The employee's username that appears in the remote UI. */
        @JsonProperty("username") fun username(): String? = username

        @JsonProperty("groups") fun groups(): List<String>? = groups

        /** The employee's work email. */
        @JsonProperty("work_email") fun workEmail(): String? = workEmail

        /** The employee's personal email. */
        @JsonProperty("personal_email") fun personalEmail(): String? = personalEmail

        /** The employee's mobile phone number. */
        @JsonProperty("mobile_phone_number") fun mobilePhoneNumber(): String? = mobilePhoneNumber

        /** Array of `Employment` IDs for this Employee. */
        @JsonProperty("employments") fun employments(): List<String>? = employments

        /** The employee's home address. */
        @JsonProperty("home_location") fun homeLocation(): String? = homeLocation

        /** The employee's work address. */
        @JsonProperty("work_location") fun workLocation(): String? = workLocation

        /** The employee ID of the employee's manager. */
        @JsonProperty("manager") fun manager(): String? = manager

        /** The employee's team. */
        @JsonProperty("team") fun team(): String? = team

        /** The employee's pay group */
        @JsonProperty("pay_group") fun payGroup(): String? = payGroup

        /** The employee's social security number. */
        @JsonProperty("ssn") fun ssn(): String? = ssn

        /**
         * - `MALE` - MALE
         * - `FEMALE` - FEMALE
         * - `NON-BINARY` - NON-BINARY
         * - `OTHER` - OTHER
         * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
         */
        @JsonProperty("gender") fun gender(): GenderEnum? = gender

        /**
         * - `AMERICAN_INDIAN_OR_ALASKA_NATIVE` - AMERICAN_INDIAN_OR_ALASKA_NATIVE
         * - `ASIAN_OR_INDIAN_SUBCONTINENT` - ASIAN_OR_INDIAN_SUBCONTINENT
         * - `BLACK_OR_AFRICAN_AMERICAN` - BLACK_OR_AFRICAN_AMERICAN
         * - `HISPANIC_OR_LATINO` - HISPANIC_OR_LATINO
         * - `NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER` - NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER
         * - `TWO_OR_MORE_RACES` - TWO_OR_MORE_RACES
         * - `WHITE` - WHITE
         * - `PREFER_NOT_TO_DISCLOSE` - PREFER_NOT_TO_DISCLOSE
         */
        @JsonProperty("ethnicity") fun ethnicity(): EthnicityEnum? = ethnicity

        /**
         * - `SINGLE` - SINGLE
         * - `MARRIED_FILING_JOINTLY` - MARRIED_FILING_JOINTLY
         * - `MARRIED_FILING_SEPARATELY` - MARRIED_FILING_SEPARATELY
         * - `HEAD_OF_HOUSEHOLD` - HEAD_OF_HOUSEHOLD
         * - `QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD` -
         * QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD
         */
        @JsonProperty("marital_status") fun maritalStatus(): MaritalStatusEnum? = maritalStatus

        /** The employee's date of birth. */
        @JsonProperty("date_of_birth") fun dateOfBirth(): OffsetDateTime? = dateOfBirth

        /**
         * The date that the employee was hired, usually the day that an offer letter is signed. If
         * an employee has multiple hire dates from previous employments, this represents the most
         * recent hire date. Note: If you're looking for the employee's start date, refer to the
         * start_date field.
         */
        @JsonProperty("hire_date") fun hireDate(): OffsetDateTime? = hireDate

        /**
         * The date that the employee started working. If an employee was rehired, the most recent
         * start date will be returned.
         */
        @JsonProperty("start_date") fun startDate(): OffsetDateTime? = startDate

        /**
         * - `ACTIVE` - ACTIVE
         * - `PENDING` - PENDING
         * - `INACTIVE` - INACTIVE
         */
        @JsonProperty("employment_status")
        fun employmentStatus(): EmploymentStatusEnum? = employmentStatus

        /** The employee's termination date. */
        @JsonProperty("termination_date") fun terminationDate(): OffsetDateTime? = terminationDate

        /** The URL of the employee's avatar image. */
        @JsonProperty("avatar") fun avatar(): String? = avatar

        @JsonProperty("integration_params") fun integrationParams(): JsonValue? = integrationParams

        @JsonProperty("linked_account_params")
        fun linkedAccountParams(): JsonValue? = linkedAccountParams

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EmployeeRequest &&
                this.employeeNumber == other.employeeNumber &&
                this.company == other.company &&
                this.firstName == other.firstName &&
                this.lastName == other.lastName &&
                this.displayFullName == other.displayFullName &&
                this.username == other.username &&
                this.groups == other.groups &&
                this.workEmail == other.workEmail &&
                this.personalEmail == other.personalEmail &&
                this.mobilePhoneNumber == other.mobilePhoneNumber &&
                this.employments == other.employments &&
                this.homeLocation == other.homeLocation &&
                this.workLocation == other.workLocation &&
                this.manager == other.manager &&
                this.team == other.team &&
                this.payGroup == other.payGroup &&
                this.ssn == other.ssn &&
                this.gender == other.gender &&
                this.ethnicity == other.ethnicity &&
                this.maritalStatus == other.maritalStatus &&
                this.dateOfBirth == other.dateOfBirth &&
                this.hireDate == other.hireDate &&
                this.startDate == other.startDate &&
                this.employmentStatus == other.employmentStatus &&
                this.terminationDate == other.terminationDate &&
                this.avatar == other.avatar &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        employeeNumber,
                        company,
                        firstName,
                        lastName,
                        displayFullName,
                        username,
                        groups,
                        workEmail,
                        personalEmail,
                        mobilePhoneNumber,
                        employments,
                        homeLocation,
                        workLocation,
                        manager,
                        team,
                        payGroup,
                        ssn,
                        gender,
                        ethnicity,
                        maritalStatus,
                        dateOfBirth,
                        hireDate,
                        startDate,
                        employmentStatus,
                        terminationDate,
                        avatar,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "EmployeeRequest{employeeNumber=$employeeNumber, company=$company, firstName=$firstName, lastName=$lastName, displayFullName=$displayFullName, username=$username, groups=$groups, workEmail=$workEmail, personalEmail=$personalEmail, mobilePhoneNumber=$mobilePhoneNumber, employments=$employments, homeLocation=$homeLocation, workLocation=$workLocation, manager=$manager, team=$team, payGroup=$payGroup, ssn=$ssn, gender=$gender, ethnicity=$ethnicity, maritalStatus=$maritalStatus, dateOfBirth=$dateOfBirth, hireDate=$hireDate, startDate=$startDate, employmentStatus=$employmentStatus, terminationDate=$terminationDate, avatar=$avatar, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var employeeNumber: String? = null
            private var company: String? = null
            private var firstName: String? = null
            private var lastName: String? = null
            private var displayFullName: String? = null
            private var username: String? = null
            private var groups: List<String>? = null
            private var workEmail: String? = null
            private var personalEmail: String? = null
            private var mobilePhoneNumber: String? = null
            private var employments: List<String>? = null
            private var homeLocation: String? = null
            private var workLocation: String? = null
            private var manager: String? = null
            private var team: String? = null
            private var payGroup: String? = null
            private var ssn: String? = null
            private var gender: GenderEnum? = null
            private var ethnicity: EthnicityEnum? = null
            private var maritalStatus: MaritalStatusEnum? = null
            private var dateOfBirth: OffsetDateTime? = null
            private var hireDate: OffsetDateTime? = null
            private var startDate: OffsetDateTime? = null
            private var employmentStatus: EmploymentStatusEnum? = null
            private var terminationDate: OffsetDateTime? = null
            private var avatar: String? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(employeeRequest: EmployeeRequest) = apply {
                this.employeeNumber = employeeRequest.employeeNumber
                this.company = employeeRequest.company
                this.firstName = employeeRequest.firstName
                this.lastName = employeeRequest.lastName
                this.displayFullName = employeeRequest.displayFullName
                this.username = employeeRequest.username
                this.groups = employeeRequest.groups
                this.workEmail = employeeRequest.workEmail
                this.personalEmail = employeeRequest.personalEmail
                this.mobilePhoneNumber = employeeRequest.mobilePhoneNumber
                this.employments = employeeRequest.employments
                this.homeLocation = employeeRequest.homeLocation
                this.workLocation = employeeRequest.workLocation
                this.manager = employeeRequest.manager
                this.team = employeeRequest.team
                this.payGroup = employeeRequest.payGroup
                this.ssn = employeeRequest.ssn
                this.gender = employeeRequest.gender
                this.ethnicity = employeeRequest.ethnicity
                this.maritalStatus = employeeRequest.maritalStatus
                this.dateOfBirth = employeeRequest.dateOfBirth
                this.hireDate = employeeRequest.hireDate
                this.startDate = employeeRequest.startDate
                this.employmentStatus = employeeRequest.employmentStatus
                this.terminationDate = employeeRequest.terminationDate
                this.avatar = employeeRequest.avatar
                this.integrationParams = employeeRequest.integrationParams
                this.linkedAccountParams = employeeRequest.linkedAccountParams
                additionalProperties(employeeRequest.additionalProperties)
            }

            /** The employee's number that appears in the third-party integration's UI. */
            @JsonProperty("employee_number")
            fun employeeNumber(employeeNumber: String) = apply {
                this.employeeNumber = employeeNumber
            }

            /** The ID of the employee's company. */
            @JsonProperty("company") fun company(company: String) = apply { this.company = company }

            /** The employee's first name. */
            @JsonProperty("first_name")
            fun firstName(firstName: String) = apply { this.firstName = firstName }

            /** The employee's last name. */
            @JsonProperty("last_name")
            fun lastName(lastName: String) = apply { this.lastName = lastName }

            /**
             * The employee's full name, to use for display purposes. If a preferred first name is
             * available, the full name will include the preferred first name.
             */
            @JsonProperty("display_full_name")
            fun displayFullName(displayFullName: String) = apply {
                this.displayFullName = displayFullName
            }

            /** The employee's username that appears in the remote UI. */
            @JsonProperty("username")
            fun username(username: String) = apply { this.username = username }

            @JsonProperty("groups")
            fun groups(groups: List<String>) = apply { this.groups = groups }

            /** The employee's work email. */
            @JsonProperty("work_email")
            fun workEmail(workEmail: String) = apply { this.workEmail = workEmail }

            /** The employee's personal email. */
            @JsonProperty("personal_email")
            fun personalEmail(personalEmail: String) = apply { this.personalEmail = personalEmail }

            /** The employee's mobile phone number. */
            @JsonProperty("mobile_phone_number")
            fun mobilePhoneNumber(mobilePhoneNumber: String) = apply {
                this.mobilePhoneNumber = mobilePhoneNumber
            }

            /** Array of `Employment` IDs for this Employee. */
            @JsonProperty("employments")
            fun employments(employments: List<String>) = apply { this.employments = employments }

            /** The employee's home address. */
            @JsonProperty("home_location")
            fun homeLocation(homeLocation: String) = apply { this.homeLocation = homeLocation }

            /** The employee's work address. */
            @JsonProperty("work_location")
            fun workLocation(workLocation: String) = apply { this.workLocation = workLocation }

            /** The employee ID of the employee's manager. */
            @JsonProperty("manager") fun manager(manager: String) = apply { this.manager = manager }

            /** The employee's team. */
            @JsonProperty("team") fun team(team: String) = apply { this.team = team }

            /** The employee's pay group */
            @JsonProperty("pay_group")
            fun payGroup(payGroup: String) = apply { this.payGroup = payGroup }

            /** The employee's social security number. */
            @JsonProperty("ssn") fun ssn(ssn: String) = apply { this.ssn = ssn }

            /**
             * - `MALE` - MALE
             * - `FEMALE` - FEMALE
             * - `NON-BINARY` - NON-BINARY
             * - `OTHER` - OTHER
             * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
             */
            @JsonProperty("gender") fun gender(gender: GenderEnum) = apply { this.gender = gender }

            /**
             * - `AMERICAN_INDIAN_OR_ALASKA_NATIVE` - AMERICAN_INDIAN_OR_ALASKA_NATIVE
             * - `ASIAN_OR_INDIAN_SUBCONTINENT` - ASIAN_OR_INDIAN_SUBCONTINENT
             * - `BLACK_OR_AFRICAN_AMERICAN` - BLACK_OR_AFRICAN_AMERICAN
             * - `HISPANIC_OR_LATINO` - HISPANIC_OR_LATINO
             * - `NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER` -
             * NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER
             * - `TWO_OR_MORE_RACES` - TWO_OR_MORE_RACES
             * - `WHITE` - WHITE
             * - `PREFER_NOT_TO_DISCLOSE` - PREFER_NOT_TO_DISCLOSE
             */
            @JsonProperty("ethnicity")
            fun ethnicity(ethnicity: EthnicityEnum) = apply { this.ethnicity = ethnicity }

            /**
             * - `SINGLE` - SINGLE
             * - `MARRIED_FILING_JOINTLY` - MARRIED_FILING_JOINTLY
             * - `MARRIED_FILING_SEPARATELY` - MARRIED_FILING_SEPARATELY
             * - `HEAD_OF_HOUSEHOLD` - HEAD_OF_HOUSEHOLD
             * - `QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD` -
             * QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD
             */
            @JsonProperty("marital_status")
            fun maritalStatus(maritalStatus: MaritalStatusEnum) = apply {
                this.maritalStatus = maritalStatus
            }

            /** The employee's date of birth. */
            @JsonProperty("date_of_birth")
            fun dateOfBirth(dateOfBirth: OffsetDateTime) = apply { this.dateOfBirth = dateOfBirth }

            /**
             * The date that the employee was hired, usually the day that an offer letter is signed.
             * If an employee has multiple hire dates from previous employments, this represents the
             * most recent hire date. Note: If you're looking for the employee's start date, refer
             * to the start_date field.
             */
            @JsonProperty("hire_date")
            fun hireDate(hireDate: OffsetDateTime) = apply { this.hireDate = hireDate }

            /**
             * The date that the employee started working. If an employee was rehired, the most
             * recent start date will be returned.
             */
            @JsonProperty("start_date")
            fun startDate(startDate: OffsetDateTime) = apply { this.startDate = startDate }

            /**
             * - `ACTIVE` - ACTIVE
             * - `PENDING` - PENDING
             * - `INACTIVE` - INACTIVE
             */
            @JsonProperty("employment_status")
            fun employmentStatus(employmentStatus: EmploymentStatusEnum) = apply {
                this.employmentStatus = employmentStatus
            }

            /** The employee's termination date. */
            @JsonProperty("termination_date")
            fun terminationDate(terminationDate: OffsetDateTime) = apply {
                this.terminationDate = terminationDate
            }

            /** The URL of the employee's avatar image. */
            @JsonProperty("avatar") fun avatar(avatar: String) = apply { this.avatar = avatar }

            @JsonProperty("integration_params")
            fun integrationParams(integrationParams: JsonValue) = apply {
                this.integrationParams = integrationParams
            }

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                this.linkedAccountParams = linkedAccountParams
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

            fun build(): EmployeeRequest =
                EmployeeRequest(
                    employeeNumber,
                    company,
                    firstName,
                    lastName,
                    displayFullName,
                    username,
                    groups?.toUnmodifiable(),
                    workEmail,
                    personalEmail,
                    mobilePhoneNumber,
                    employments?.toUnmodifiable(),
                    homeLocation,
                    workLocation,
                    manager,
                    team,
                    payGroup,
                    ssn,
                    gender,
                    ethnicity,
                    maritalStatus,
                    dateOfBirth,
                    hireDate,
                    startDate,
                    employmentStatus,
                    terminationDate,
                    avatar,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class GenderEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is GenderEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val MALE = GenderEnum(JsonField.of("MALE"))

                @JvmField val FEMALE = GenderEnum(JsonField.of("FEMALE"))

                @JvmField val NON_BINARY = GenderEnum(JsonField.of("NON-BINARY"))

                @JvmField val OTHER = GenderEnum(JsonField.of("OTHER"))

                @JvmField
                val DECLINE_TO_SELF_IDENTIFY = GenderEnum(JsonField.of("DECLINE_TO_SELF_IDENTIFY"))

                @JvmStatic fun of(value: String) = GenderEnum(JsonField.of(value))
            }

            enum class Known {
                MALE,
                FEMALE,
                NON_BINARY,
                OTHER,
                DECLINE_TO_SELF_IDENTIFY,
            }

            enum class Value {
                MALE,
                FEMALE,
                NON_BINARY,
                OTHER,
                DECLINE_TO_SELF_IDENTIFY,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    MALE -> Value.MALE
                    FEMALE -> Value.FEMALE
                    NON_BINARY -> Value.NON_BINARY
                    OTHER -> Value.OTHER
                    DECLINE_TO_SELF_IDENTIFY -> Value.DECLINE_TO_SELF_IDENTIFY
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    MALE -> Known.MALE
                    FEMALE -> Known.FEMALE
                    NON_BINARY -> Known.NON_BINARY
                    OTHER -> Known.OTHER
                    DECLINE_TO_SELF_IDENTIFY -> Known.DECLINE_TO_SELF_IDENTIFY
                    else -> throw MergeInvalidDataException("Unknown GenderEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }

        class EthnicityEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EthnicityEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField
                val AMERICAN_INDIAN_OR_ALASKA_NATIVE =
                    EthnicityEnum(JsonField.of("AMERICAN_INDIAN_OR_ALASKA_NATIVE"))

                @JvmField
                val ASIAN_OR_INDIAN_SUBCONTINENT =
                    EthnicityEnum(JsonField.of("ASIAN_OR_INDIAN_SUBCONTINENT"))

                @JvmField
                val BLACK_OR_AFRICAN_AMERICAN =
                    EthnicityEnum(JsonField.of("BLACK_OR_AFRICAN_AMERICAN"))

                @JvmField val HISPANIC_OR_LATINO = EthnicityEnum(JsonField.of("HISPANIC_OR_LATINO"))

                @JvmField
                val NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER =
                    EthnicityEnum(JsonField.of("NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER"))

                @JvmField val TWO_OR_MORE_RACES = EthnicityEnum(JsonField.of("TWO_OR_MORE_RACES"))

                @JvmField val WHITE = EthnicityEnum(JsonField.of("WHITE"))

                @JvmField
                val PREFER_NOT_TO_DISCLOSE = EthnicityEnum(JsonField.of("PREFER_NOT_TO_DISCLOSE"))

                @JvmStatic fun of(value: String) = EthnicityEnum(JsonField.of(value))
            }

            enum class Known {
                AMERICAN_INDIAN_OR_ALASKA_NATIVE,
                ASIAN_OR_INDIAN_SUBCONTINENT,
                BLACK_OR_AFRICAN_AMERICAN,
                HISPANIC_OR_LATINO,
                NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER,
                TWO_OR_MORE_RACES,
                WHITE,
                PREFER_NOT_TO_DISCLOSE,
            }

            enum class Value {
                AMERICAN_INDIAN_OR_ALASKA_NATIVE,
                ASIAN_OR_INDIAN_SUBCONTINENT,
                BLACK_OR_AFRICAN_AMERICAN,
                HISPANIC_OR_LATINO,
                NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER,
                TWO_OR_MORE_RACES,
                WHITE,
                PREFER_NOT_TO_DISCLOSE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    AMERICAN_INDIAN_OR_ALASKA_NATIVE -> Value.AMERICAN_INDIAN_OR_ALASKA_NATIVE
                    ASIAN_OR_INDIAN_SUBCONTINENT -> Value.ASIAN_OR_INDIAN_SUBCONTINENT
                    BLACK_OR_AFRICAN_AMERICAN -> Value.BLACK_OR_AFRICAN_AMERICAN
                    HISPANIC_OR_LATINO -> Value.HISPANIC_OR_LATINO
                    NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER ->
                        Value.NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER
                    TWO_OR_MORE_RACES -> Value.TWO_OR_MORE_RACES
                    WHITE -> Value.WHITE
                    PREFER_NOT_TO_DISCLOSE -> Value.PREFER_NOT_TO_DISCLOSE
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    AMERICAN_INDIAN_OR_ALASKA_NATIVE -> Known.AMERICAN_INDIAN_OR_ALASKA_NATIVE
                    ASIAN_OR_INDIAN_SUBCONTINENT -> Known.ASIAN_OR_INDIAN_SUBCONTINENT
                    BLACK_OR_AFRICAN_AMERICAN -> Known.BLACK_OR_AFRICAN_AMERICAN
                    HISPANIC_OR_LATINO -> Known.HISPANIC_OR_LATINO
                    NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER ->
                        Known.NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER
                    TWO_OR_MORE_RACES -> Known.TWO_OR_MORE_RACES
                    WHITE -> Known.WHITE
                    PREFER_NOT_TO_DISCLOSE -> Known.PREFER_NOT_TO_DISCLOSE
                    else -> throw MergeInvalidDataException("Unknown EthnicityEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }

        class MaritalStatusEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is MaritalStatusEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val SINGLE = MaritalStatusEnum(JsonField.of("SINGLE"))

                @JvmField
                val MARRIED_FILING_JOINTLY =
                    MaritalStatusEnum(JsonField.of("MARRIED_FILING_JOINTLY"))

                @JvmField
                val MARRIED_FILING_SEPARATELY =
                    MaritalStatusEnum(JsonField.of("MARRIED_FILING_SEPARATELY"))

                @JvmField
                val HEAD_OF_HOUSEHOLD = MaritalStatusEnum(JsonField.of("HEAD_OF_HOUSEHOLD"))

                @JvmField
                val QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD =
                    MaritalStatusEnum(
                        JsonField.of("QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD")
                    )

                @JvmStatic fun of(value: String) = MaritalStatusEnum(JsonField.of(value))
            }

            enum class Known {
                SINGLE,
                MARRIED_FILING_JOINTLY,
                MARRIED_FILING_SEPARATELY,
                HEAD_OF_HOUSEHOLD,
                QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD,
            }

            enum class Value {
                SINGLE,
                MARRIED_FILING_JOINTLY,
                MARRIED_FILING_SEPARATELY,
                HEAD_OF_HOUSEHOLD,
                QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    SINGLE -> Value.SINGLE
                    MARRIED_FILING_JOINTLY -> Value.MARRIED_FILING_JOINTLY
                    MARRIED_FILING_SEPARATELY -> Value.MARRIED_FILING_SEPARATELY
                    HEAD_OF_HOUSEHOLD -> Value.HEAD_OF_HOUSEHOLD
                    QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD ->
                        Value.QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    SINGLE -> Known.SINGLE
                    MARRIED_FILING_JOINTLY -> Known.MARRIED_FILING_JOINTLY
                    MARRIED_FILING_SEPARATELY -> Known.MARRIED_FILING_SEPARATELY
                    HEAD_OF_HOUSEHOLD -> Known.HEAD_OF_HOUSEHOLD
                    QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD ->
                        Known.QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD
                    else -> throw MergeInvalidDataException("Unknown MaritalStatusEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }

        class EmploymentStatusEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EmploymentStatusEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val ACTIVE = EmploymentStatusEnum(JsonField.of("ACTIVE"))

                @JvmField val PENDING = EmploymentStatusEnum(JsonField.of("PENDING"))

                @JvmField val INACTIVE = EmploymentStatusEnum(JsonField.of("INACTIVE"))

                @JvmStatic fun of(value: String) = EmploymentStatusEnum(JsonField.of(value))
            }

            enum class Known {
                ACTIVE,
                PENDING,
                INACTIVE,
            }

            enum class Value {
                ACTIVE,
                PENDING,
                INACTIVE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    ACTIVE -> Value.ACTIVE
                    PENDING -> Value.PENDING
                    INACTIVE -> Value.INACTIVE
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    ACTIVE -> Known.ACTIVE
                    PENDING -> Known.PENDING
                    INACTIVE -> Known.INACTIVE
                    else -> throw MergeInvalidDataException("Unknown EmploymentStatusEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
