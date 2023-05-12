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
@JsonDeserialize(builder = Employee.Builder::class)
@NoAutoDetect
class Employee
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val employeeNumber: JsonField<String>,
    private val company: JsonField<String>,
    private val firstName: JsonField<String>,
    private val lastName: JsonField<String>,
    private val displayFullName: JsonField<String>,
    private val username: JsonField<String>,
    private val groups: JsonField<List<String>>,
    private val workEmail: JsonField<String>,
    private val personalEmail: JsonField<String>,
    private val mobilePhoneNumber: JsonField<String>,
    private val employments: JsonField<List<String>>,
    private val homeLocation: JsonField<String>,
    private val workLocation: JsonField<String>,
    private val manager: JsonField<String>,
    private val team: JsonField<String>,
    private val payGroup: JsonField<String>,
    private val ssn: JsonField<String>,
    private val gender: JsonField<GenderEnum>,
    private val ethnicity: JsonField<EthnicityEnum>,
    private val maritalStatus: JsonField<MaritalStatusEnum>,
    private val dateOfBirth: JsonField<OffsetDateTime>,
    private val hireDate: JsonField<OffsetDateTime>,
    private val startDate: JsonField<OffsetDateTime>,
    private val remoteCreatedAt: JsonField<OffsetDateTime>,
    private val employmentStatus: JsonField<EmploymentStatusEnum>,
    private val terminationDate: JsonField<OffsetDateTime>,
    private val avatar: JsonField<String>,
    private val customFields: JsonValue,
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

    /** The employee's number that appears in the third-party integration's UI. */
    fun employeeNumber(): Optional<String> =
        Optional.ofNullable(employeeNumber.getNullable("employee_number"))

    /** The ID of the employee's company. */
    fun company(): Optional<String> = Optional.ofNullable(company.getNullable("company"))

    /** The employee's first name. */
    fun firstName(): Optional<String> = Optional.ofNullable(firstName.getNullable("first_name"))

    /** The employee's last name. */
    fun lastName(): Optional<String> = Optional.ofNullable(lastName.getNullable("last_name"))

    /**
     * The employee's full name, to use for display purposes. If a preferred first name is
     * available, the full name will include the preferred first name.
     */
    fun displayFullName(): Optional<String> =
        Optional.ofNullable(displayFullName.getNullable("display_full_name"))

    /** The employee's username that appears in the remote UI. */
    fun username(): Optional<String> = Optional.ofNullable(username.getNullable("username"))

    fun groups(): Optional<List<String>> = Optional.ofNullable(groups.getNullable("groups"))

    /** The employee's work email. */
    fun workEmail(): Optional<String> = Optional.ofNullable(workEmail.getNullable("work_email"))

    /** The employee's personal email. */
    fun personalEmail(): Optional<String> =
        Optional.ofNullable(personalEmail.getNullable("personal_email"))

    /** The employee's mobile phone number. */
    fun mobilePhoneNumber(): Optional<String> =
        Optional.ofNullable(mobilePhoneNumber.getNullable("mobile_phone_number"))

    /** Array of `Employment` IDs for this Employee. */
    fun employments(): Optional<List<String>> =
        Optional.ofNullable(employments.getNullable("employments"))

    /** The employee's home address. */
    fun homeLocation(): Optional<String> =
        Optional.ofNullable(homeLocation.getNullable("home_location"))

    /** The employee's work address. */
    fun workLocation(): Optional<String> =
        Optional.ofNullable(workLocation.getNullable("work_location"))

    /** The employee ID of the employee's manager. */
    fun manager(): Optional<String> = Optional.ofNullable(manager.getNullable("manager"))

    /** The employee's team. */
    fun team(): Optional<String> = Optional.ofNullable(team.getNullable("team"))

    /** The employee's pay group */
    fun payGroup(): Optional<String> = Optional.ofNullable(payGroup.getNullable("pay_group"))

    /** The employee's social security number. */
    fun ssn(): Optional<String> = Optional.ofNullable(ssn.getNullable("ssn"))

    /**
     * - `MALE` - MALE
     * - `FEMALE` - FEMALE
     * - `NON-BINARY` - NON-BINARY
     * - `OTHER` - OTHER
     * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
     */
    fun gender(): Optional<GenderEnum> = Optional.ofNullable(gender.getNullable("gender"))

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
    fun ethnicity(): Optional<EthnicityEnum> =
        Optional.ofNullable(ethnicity.getNullable("ethnicity"))

    /**
     * - `SINGLE` - SINGLE
     * - `MARRIED_FILING_JOINTLY` - MARRIED_FILING_JOINTLY
     * - `MARRIED_FILING_SEPARATELY` - MARRIED_FILING_SEPARATELY
     * - `HEAD_OF_HOUSEHOLD` - HEAD_OF_HOUSEHOLD
     * - `QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD` -
     * QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD
     */
    fun maritalStatus(): Optional<MaritalStatusEnum> =
        Optional.ofNullable(maritalStatus.getNullable("marital_status"))

    /** The employee's date of birth. */
    fun dateOfBirth(): Optional<OffsetDateTime> =
        Optional.ofNullable(dateOfBirth.getNullable("date_of_birth"))

    /**
     * The date that the employee was hired, usually the day that an offer letter is signed. If an
     * employee has multiple hire dates from previous employments, this represents the most recent
     * hire date. Note: If you're looking for the employee's start date, refer to the start_date
     * field.
     */
    fun hireDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(hireDate.getNullable("hire_date"))

    /**
     * The date that the employee started working. If an employee was rehired, the most recent start
     * date will be returned.
     */
    fun startDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(startDate.getNullable("start_date"))

    /** When the third party's employee was created. */
    fun remoteCreatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(remoteCreatedAt.getNullable("remote_created_at"))

    /**
     * - `ACTIVE` - ACTIVE
     * - `PENDING` - PENDING
     * - `INACTIVE` - INACTIVE
     */
    fun employmentStatus(): Optional<EmploymentStatusEnum> =
        Optional.ofNullable(employmentStatus.getNullable("employment_status"))

    /** The employee's termination date. */
    fun terminationDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(terminationDate.getNullable("termination_date"))

    /** The URL of the employee's avatar image. */
    fun avatar(): Optional<String> = Optional.ofNullable(avatar.getNullable("avatar"))

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

    /** The employee's number that appears in the third-party integration's UI. */
    @JsonProperty("employee_number") @ExcludeMissing fun _employeeNumber() = employeeNumber

    /** The ID of the employee's company. */
    @JsonProperty("company") @ExcludeMissing fun _company() = company

    /** The employee's first name. */
    @JsonProperty("first_name") @ExcludeMissing fun _firstName() = firstName

    /** The employee's last name. */
    @JsonProperty("last_name") @ExcludeMissing fun _lastName() = lastName

    /**
     * The employee's full name, to use for display purposes. If a preferred first name is
     * available, the full name will include the preferred first name.
     */
    @JsonProperty("display_full_name") @ExcludeMissing fun _displayFullName() = displayFullName

    /** The employee's username that appears in the remote UI. */
    @JsonProperty("username") @ExcludeMissing fun _username() = username

    @JsonProperty("groups") @ExcludeMissing fun _groups() = groups

    /** The employee's work email. */
    @JsonProperty("work_email") @ExcludeMissing fun _workEmail() = workEmail

    /** The employee's personal email. */
    @JsonProperty("personal_email") @ExcludeMissing fun _personalEmail() = personalEmail

    /** The employee's mobile phone number. */
    @JsonProperty("mobile_phone_number")
    @ExcludeMissing
    fun _mobilePhoneNumber() = mobilePhoneNumber

    /** Array of `Employment` IDs for this Employee. */
    @JsonProperty("employments") @ExcludeMissing fun _employments() = employments

    /** The employee's home address. */
    @JsonProperty("home_location") @ExcludeMissing fun _homeLocation() = homeLocation

    /** The employee's work address. */
    @JsonProperty("work_location") @ExcludeMissing fun _workLocation() = workLocation

    /** The employee ID of the employee's manager. */
    @JsonProperty("manager") @ExcludeMissing fun _manager() = manager

    /** The employee's team. */
    @JsonProperty("team") @ExcludeMissing fun _team() = team

    /** The employee's pay group */
    @JsonProperty("pay_group") @ExcludeMissing fun _payGroup() = payGroup

    /** The employee's social security number. */
    @JsonProperty("ssn") @ExcludeMissing fun _ssn() = ssn

    /**
     * - `MALE` - MALE
     * - `FEMALE` - FEMALE
     * - `NON-BINARY` - NON-BINARY
     * - `OTHER` - OTHER
     * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
     */
    @JsonProperty("gender") @ExcludeMissing fun _gender() = gender

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
    @JsonProperty("ethnicity") @ExcludeMissing fun _ethnicity() = ethnicity

    /**
     * - `SINGLE` - SINGLE
     * - `MARRIED_FILING_JOINTLY` - MARRIED_FILING_JOINTLY
     * - `MARRIED_FILING_SEPARATELY` - MARRIED_FILING_SEPARATELY
     * - `HEAD_OF_HOUSEHOLD` - HEAD_OF_HOUSEHOLD
     * - `QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD` -
     * QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD
     */
    @JsonProperty("marital_status") @ExcludeMissing fun _maritalStatus() = maritalStatus

    /** The employee's date of birth. */
    @JsonProperty("date_of_birth") @ExcludeMissing fun _dateOfBirth() = dateOfBirth

    /**
     * The date that the employee was hired, usually the day that an offer letter is signed. If an
     * employee has multiple hire dates from previous employments, this represents the most recent
     * hire date. Note: If you're looking for the employee's start date, refer to the start_date
     * field.
     */
    @JsonProperty("hire_date") @ExcludeMissing fun _hireDate() = hireDate

    /**
     * The date that the employee started working. If an employee was rehired, the most recent start
     * date will be returned.
     */
    @JsonProperty("start_date") @ExcludeMissing fun _startDate() = startDate

    /** When the third party's employee was created. */
    @JsonProperty("remote_created_at") @ExcludeMissing fun _remoteCreatedAt() = remoteCreatedAt

    /**
     * - `ACTIVE` - ACTIVE
     * - `PENDING` - PENDING
     * - `INACTIVE` - INACTIVE
     */
    @JsonProperty("employment_status") @ExcludeMissing fun _employmentStatus() = employmentStatus

    /** The employee's termination date. */
    @JsonProperty("termination_date") @ExcludeMissing fun _terminationDate() = terminationDate

    /** The URL of the employee's avatar image. */
    @JsonProperty("avatar") @ExcludeMissing fun _avatar() = avatar

    /** Custom fields configured for a given model. */
    @JsonProperty("custom_fields") @ExcludeMissing fun _customFields() = customFields

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
            employeeNumber()
            company()
            firstName()
            lastName()
            displayFullName()
            username()
            groups()
            workEmail()
            personalEmail()
            mobilePhoneNumber()
            employments()
            homeLocation()
            workLocation()
            manager()
            team()
            payGroup()
            ssn()
            gender()
            ethnicity()
            maritalStatus()
            dateOfBirth()
            hireDate()
            startDate()
            remoteCreatedAt()
            employmentStatus()
            terminationDate()
            avatar()
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

        return other is Employee &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
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
            this.remoteCreatedAt == other.remoteCreatedAt &&
            this.employmentStatus == other.employmentStatus &&
            this.terminationDate == other.terminationDate &&
            this.avatar == other.avatar &&
            this.customFields == other.customFields &&
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
                    remoteCreatedAt,
                    employmentStatus,
                    terminationDate,
                    avatar,
                    customFields,
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
        "Employee{id=$id, remoteId=$remoteId, employeeNumber=$employeeNumber, company=$company, firstName=$firstName, lastName=$lastName, displayFullName=$displayFullName, username=$username, groups=$groups, workEmail=$workEmail, personalEmail=$personalEmail, mobilePhoneNumber=$mobilePhoneNumber, employments=$employments, homeLocation=$homeLocation, workLocation=$workLocation, manager=$manager, team=$team, payGroup=$payGroup, ssn=$ssn, gender=$gender, ethnicity=$ethnicity, maritalStatus=$maritalStatus, dateOfBirth=$dateOfBirth, hireDate=$hireDate, startDate=$startDate, remoteCreatedAt=$remoteCreatedAt, employmentStatus=$employmentStatus, terminationDate=$terminationDate, avatar=$avatar, customFields=$customFields, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var employeeNumber: JsonField<String> = JsonMissing.of()
        private var company: JsonField<String> = JsonMissing.of()
        private var firstName: JsonField<String> = JsonMissing.of()
        private var lastName: JsonField<String> = JsonMissing.of()
        private var displayFullName: JsonField<String> = JsonMissing.of()
        private var username: JsonField<String> = JsonMissing.of()
        private var groups: JsonField<List<String>> = JsonMissing.of()
        private var workEmail: JsonField<String> = JsonMissing.of()
        private var personalEmail: JsonField<String> = JsonMissing.of()
        private var mobilePhoneNumber: JsonField<String> = JsonMissing.of()
        private var employments: JsonField<List<String>> = JsonMissing.of()
        private var homeLocation: JsonField<String> = JsonMissing.of()
        private var workLocation: JsonField<String> = JsonMissing.of()
        private var manager: JsonField<String> = JsonMissing.of()
        private var team: JsonField<String> = JsonMissing.of()
        private var payGroup: JsonField<String> = JsonMissing.of()
        private var ssn: JsonField<String> = JsonMissing.of()
        private var gender: JsonField<GenderEnum> = JsonMissing.of()
        private var ethnicity: JsonField<EthnicityEnum> = JsonMissing.of()
        private var maritalStatus: JsonField<MaritalStatusEnum> = JsonMissing.of()
        private var dateOfBirth: JsonField<OffsetDateTime> = JsonMissing.of()
        private var hireDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var startDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var employmentStatus: JsonField<EmploymentStatusEnum> = JsonMissing.of()
        private var terminationDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var avatar: JsonField<String> = JsonMissing.of()
        private var customFields: JsonValue = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(employee: Employee) = apply {
            this.id = employee.id
            this.remoteId = employee.remoteId
            this.employeeNumber = employee.employeeNumber
            this.company = employee.company
            this.firstName = employee.firstName
            this.lastName = employee.lastName
            this.displayFullName = employee.displayFullName
            this.username = employee.username
            this.groups = employee.groups
            this.workEmail = employee.workEmail
            this.personalEmail = employee.personalEmail
            this.mobilePhoneNumber = employee.mobilePhoneNumber
            this.employments = employee.employments
            this.homeLocation = employee.homeLocation
            this.workLocation = employee.workLocation
            this.manager = employee.manager
            this.team = employee.team
            this.payGroup = employee.payGroup
            this.ssn = employee.ssn
            this.gender = employee.gender
            this.ethnicity = employee.ethnicity
            this.maritalStatus = employee.maritalStatus
            this.dateOfBirth = employee.dateOfBirth
            this.hireDate = employee.hireDate
            this.startDate = employee.startDate
            this.remoteCreatedAt = employee.remoteCreatedAt
            this.employmentStatus = employee.employmentStatus
            this.terminationDate = employee.terminationDate
            this.avatar = employee.avatar
            this.customFields = employee.customFields
            this.remoteWasDeleted = employee.remoteWasDeleted
            this.fieldMappings = employee.fieldMappings
            this.modifiedAt = employee.modifiedAt
            this.remoteData = employee.remoteData
            additionalProperties(employee.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The employee's number that appears in the third-party integration's UI. */
        fun employeeNumber(employeeNumber: String) = employeeNumber(JsonField.of(employeeNumber))

        /** The employee's number that appears in the third-party integration's UI. */
        @JsonProperty("employee_number")
        @ExcludeMissing
        fun employeeNumber(employeeNumber: JsonField<String>) = apply {
            this.employeeNumber = employeeNumber
        }

        /** The ID of the employee's company. */
        fun company(company: String) = company(JsonField.of(company))

        /** The ID of the employee's company. */
        @JsonProperty("company")
        @ExcludeMissing
        fun company(company: JsonField<String>) = apply { this.company = company }

        /** The employee's first name. */
        fun firstName(firstName: String) = firstName(JsonField.of(firstName))

        /** The employee's first name. */
        @JsonProperty("first_name")
        @ExcludeMissing
        fun firstName(firstName: JsonField<String>) = apply { this.firstName = firstName }

        /** The employee's last name. */
        fun lastName(lastName: String) = lastName(JsonField.of(lastName))

        /** The employee's last name. */
        @JsonProperty("last_name")
        @ExcludeMissing
        fun lastName(lastName: JsonField<String>) = apply { this.lastName = lastName }

        /**
         * The employee's full name, to use for display purposes. If a preferred first name is
         * available, the full name will include the preferred first name.
         */
        fun displayFullName(displayFullName: String) =
            displayFullName(JsonField.of(displayFullName))

        /**
         * The employee's full name, to use for display purposes. If a preferred first name is
         * available, the full name will include the preferred first name.
         */
        @JsonProperty("display_full_name")
        @ExcludeMissing
        fun displayFullName(displayFullName: JsonField<String>) = apply {
            this.displayFullName = displayFullName
        }

        /** The employee's username that appears in the remote UI. */
        fun username(username: String) = username(JsonField.of(username))

        /** The employee's username that appears in the remote UI. */
        @JsonProperty("username")
        @ExcludeMissing
        fun username(username: JsonField<String>) = apply { this.username = username }

        fun groups(groups: List<String>) = groups(JsonField.of(groups))

        @JsonProperty("groups")
        @ExcludeMissing
        fun groups(groups: JsonField<List<String>>) = apply { this.groups = groups }

        /** The employee's work email. */
        fun workEmail(workEmail: String) = workEmail(JsonField.of(workEmail))

        /** The employee's work email. */
        @JsonProperty("work_email")
        @ExcludeMissing
        fun workEmail(workEmail: JsonField<String>) = apply { this.workEmail = workEmail }

        /** The employee's personal email. */
        fun personalEmail(personalEmail: String) = personalEmail(JsonField.of(personalEmail))

        /** The employee's personal email. */
        @JsonProperty("personal_email")
        @ExcludeMissing
        fun personalEmail(personalEmail: JsonField<String>) = apply {
            this.personalEmail = personalEmail
        }

        /** The employee's mobile phone number. */
        fun mobilePhoneNumber(mobilePhoneNumber: String) =
            mobilePhoneNumber(JsonField.of(mobilePhoneNumber))

        /** The employee's mobile phone number. */
        @JsonProperty("mobile_phone_number")
        @ExcludeMissing
        fun mobilePhoneNumber(mobilePhoneNumber: JsonField<String>) = apply {
            this.mobilePhoneNumber = mobilePhoneNumber
        }

        /** Array of `Employment` IDs for this Employee. */
        fun employments(employments: List<String>) = employments(JsonField.of(employments))

        /** Array of `Employment` IDs for this Employee. */
        @JsonProperty("employments")
        @ExcludeMissing
        fun employments(employments: JsonField<List<String>>) = apply {
            this.employments = employments
        }

        /** The employee's home address. */
        fun homeLocation(homeLocation: String) = homeLocation(JsonField.of(homeLocation))

        /** The employee's home address. */
        @JsonProperty("home_location")
        @ExcludeMissing
        fun homeLocation(homeLocation: JsonField<String>) = apply {
            this.homeLocation = homeLocation
        }

        /** The employee's work address. */
        fun workLocation(workLocation: String) = workLocation(JsonField.of(workLocation))

        /** The employee's work address. */
        @JsonProperty("work_location")
        @ExcludeMissing
        fun workLocation(workLocation: JsonField<String>) = apply {
            this.workLocation = workLocation
        }

        /** The employee ID of the employee's manager. */
        fun manager(manager: String) = manager(JsonField.of(manager))

        /** The employee ID of the employee's manager. */
        @JsonProperty("manager")
        @ExcludeMissing
        fun manager(manager: JsonField<String>) = apply { this.manager = manager }

        /** The employee's team. */
        fun team(team: String) = team(JsonField.of(team))

        /** The employee's team. */
        @JsonProperty("team")
        @ExcludeMissing
        fun team(team: JsonField<String>) = apply { this.team = team }

        /** The employee's pay group */
        fun payGroup(payGroup: String) = payGroup(JsonField.of(payGroup))

        /** The employee's pay group */
        @JsonProperty("pay_group")
        @ExcludeMissing
        fun payGroup(payGroup: JsonField<String>) = apply { this.payGroup = payGroup }

        /** The employee's social security number. */
        fun ssn(ssn: String) = ssn(JsonField.of(ssn))

        /** The employee's social security number. */
        @JsonProperty("ssn")
        @ExcludeMissing
        fun ssn(ssn: JsonField<String>) = apply { this.ssn = ssn }

        /**
         * - `MALE` - MALE
         * - `FEMALE` - FEMALE
         * - `NON-BINARY` - NON-BINARY
         * - `OTHER` - OTHER
         * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
         */
        fun gender(gender: GenderEnum) = gender(JsonField.of(gender))

        /**
         * - `MALE` - MALE
         * - `FEMALE` - FEMALE
         * - `NON-BINARY` - NON-BINARY
         * - `OTHER` - OTHER
         * - `DECLINE_TO_SELF_IDENTIFY` - DECLINE_TO_SELF_IDENTIFY
         */
        @JsonProperty("gender")
        @ExcludeMissing
        fun gender(gender: JsonField<GenderEnum>) = apply { this.gender = gender }

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
        fun ethnicity(ethnicity: EthnicityEnum) = ethnicity(JsonField.of(ethnicity))

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
        @JsonProperty("ethnicity")
        @ExcludeMissing
        fun ethnicity(ethnicity: JsonField<EthnicityEnum>) = apply { this.ethnicity = ethnicity }

        /**
         * - `SINGLE` - SINGLE
         * - `MARRIED_FILING_JOINTLY` - MARRIED_FILING_JOINTLY
         * - `MARRIED_FILING_SEPARATELY` - MARRIED_FILING_SEPARATELY
         * - `HEAD_OF_HOUSEHOLD` - HEAD_OF_HOUSEHOLD
         * - `QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD` -
         * QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD
         */
        fun maritalStatus(maritalStatus: MaritalStatusEnum) =
            maritalStatus(JsonField.of(maritalStatus))

        /**
         * - `SINGLE` - SINGLE
         * - `MARRIED_FILING_JOINTLY` - MARRIED_FILING_JOINTLY
         * - `MARRIED_FILING_SEPARATELY` - MARRIED_FILING_SEPARATELY
         * - `HEAD_OF_HOUSEHOLD` - HEAD_OF_HOUSEHOLD
         * - `QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD` -
         * QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD
         */
        @JsonProperty("marital_status")
        @ExcludeMissing
        fun maritalStatus(maritalStatus: JsonField<MaritalStatusEnum>) = apply {
            this.maritalStatus = maritalStatus
        }

        /** The employee's date of birth. */
        fun dateOfBirth(dateOfBirth: OffsetDateTime) = dateOfBirth(JsonField.of(dateOfBirth))

        /** The employee's date of birth. */
        @JsonProperty("date_of_birth")
        @ExcludeMissing
        fun dateOfBirth(dateOfBirth: JsonField<OffsetDateTime>) = apply {
            this.dateOfBirth = dateOfBirth
        }

        /**
         * The date that the employee was hired, usually the day that an offer letter is signed. If
         * an employee has multiple hire dates from previous employments, this represents the most
         * recent hire date. Note: If you're looking for the employee's start date, refer to the
         * start_date field.
         */
        fun hireDate(hireDate: OffsetDateTime) = hireDate(JsonField.of(hireDate))

        /**
         * The date that the employee was hired, usually the day that an offer letter is signed. If
         * an employee has multiple hire dates from previous employments, this represents the most
         * recent hire date. Note: If you're looking for the employee's start date, refer to the
         * start_date field.
         */
        @JsonProperty("hire_date")
        @ExcludeMissing
        fun hireDate(hireDate: JsonField<OffsetDateTime>) = apply { this.hireDate = hireDate }

        /**
         * The date that the employee started working. If an employee was rehired, the most recent
         * start date will be returned.
         */
        fun startDate(startDate: OffsetDateTime) = startDate(JsonField.of(startDate))

        /**
         * The date that the employee started working. If an employee was rehired, the most recent
         * start date will be returned.
         */
        @JsonProperty("start_date")
        @ExcludeMissing
        fun startDate(startDate: JsonField<OffsetDateTime>) = apply { this.startDate = startDate }

        /** When the third party's employee was created. */
        fun remoteCreatedAt(remoteCreatedAt: OffsetDateTime) =
            remoteCreatedAt(JsonField.of(remoteCreatedAt))

        /** When the third party's employee was created. */
        @JsonProperty("remote_created_at")
        @ExcludeMissing
        fun remoteCreatedAt(remoteCreatedAt: JsonField<OffsetDateTime>) = apply {
            this.remoteCreatedAt = remoteCreatedAt
        }

        /**
         * - `ACTIVE` - ACTIVE
         * - `PENDING` - PENDING
         * - `INACTIVE` - INACTIVE
         */
        fun employmentStatus(employmentStatus: EmploymentStatusEnum) =
            employmentStatus(JsonField.of(employmentStatus))

        /**
         * - `ACTIVE` - ACTIVE
         * - `PENDING` - PENDING
         * - `INACTIVE` - INACTIVE
         */
        @JsonProperty("employment_status")
        @ExcludeMissing
        fun employmentStatus(employmentStatus: JsonField<EmploymentStatusEnum>) = apply {
            this.employmentStatus = employmentStatus
        }

        /** The employee's termination date. */
        fun terminationDate(terminationDate: OffsetDateTime) =
            terminationDate(JsonField.of(terminationDate))

        /** The employee's termination date. */
        @JsonProperty("termination_date")
        @ExcludeMissing
        fun terminationDate(terminationDate: JsonField<OffsetDateTime>) = apply {
            this.terminationDate = terminationDate
        }

        /** The URL of the employee's avatar image. */
        fun avatar(avatar: String) = avatar(JsonField.of(avatar))

        /** The URL of the employee's avatar image. */
        @JsonProperty("avatar")
        @ExcludeMissing
        fun avatar(avatar: JsonField<String>) = apply { this.avatar = avatar }

        /** Custom fields configured for a given model. */
        @JsonProperty("custom_fields")
        @ExcludeMissing
        fun customFields(customFields: JsonValue) = apply { this.customFields = customFields }

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

        fun build(): Employee =
            Employee(
                id,
                remoteId,
                employeeNumber,
                company,
                firstName,
                lastName,
                displayFullName,
                username,
                groups.map { it.toUnmodifiable() },
                workEmail,
                personalEmail,
                mobilePhoneNumber,
                employments.map { it.toUnmodifiable() },
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
                remoteCreatedAt,
                employmentStatus,
                terminationDate,
                avatar,
                customFields,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
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
            val BLACK_OR_AFRICAN_AMERICAN = EthnicityEnum(JsonField.of("BLACK_OR_AFRICAN_AMERICAN"))

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
            val MARRIED_FILING_JOINTLY = MaritalStatusEnum(JsonField.of("MARRIED_FILING_JOINTLY"))

            @JvmField
            val MARRIED_FILING_SEPARATELY =
                MaritalStatusEnum(JsonField.of("MARRIED_FILING_SEPARATELY"))

            @JvmField val HEAD_OF_HOUSEHOLD = MaritalStatusEnum(JsonField.of("HEAD_OF_HOUSEHOLD"))

            @JvmField
            val QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD =
                MaritalStatusEnum(JsonField.of("QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD"))

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
