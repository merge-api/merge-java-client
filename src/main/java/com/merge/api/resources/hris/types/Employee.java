package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Employee.Builder.class)
public final class Employee {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> employeeNumber;

    private final Optional<EmployeeCompany> company;

    private final Optional<String> firstName;

    private final Optional<String> lastName;

    private final Optional<String> preferredName;

    private final Optional<String> displayFullName;

    private final Optional<String> username;

    private final Optional<List<Optional<EmployeeGroupsItem>>> groups;

    private final Optional<String> workEmail;

    private final Optional<String> personalEmail;

    private final Optional<String> mobilePhoneNumber;

    private final Optional<List<Optional<EmployeeEmploymentsItem>>> employments;

    private final Optional<EmployeeHomeLocation> homeLocation;

    private final Optional<EmployeeWorkLocation> workLocation;

    private final Optional<EmployeeManager> manager;

    private final Optional<EmployeeTeam> team;

    private final Optional<EmployeePayGroup> payGroup;

    private final Optional<String> ssn;

    private final Optional<EmployeeGender> gender;

    private final Optional<EmployeeEthnicity> ethnicity;

    private final Optional<EmployeeMaritalStatus> maritalStatus;

    private final Optional<OffsetDateTime> dateOfBirth;

    private final Optional<OffsetDateTime> hireDate;

    private final Optional<OffsetDateTime> startDate;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<EmployeeEmploymentStatus> employmentStatus;

    private final Optional<OffsetDateTime> terminationDate;

    private final Optional<String> avatar;

    private final Optional<Map<String, JsonNode>> customFields;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Employee(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> employeeNumber,
            Optional<EmployeeCompany> company,
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<String> preferredName,
            Optional<String> displayFullName,
            Optional<String> username,
            Optional<List<Optional<EmployeeGroupsItem>>> groups,
            Optional<String> workEmail,
            Optional<String> personalEmail,
            Optional<String> mobilePhoneNumber,
            Optional<List<Optional<EmployeeEmploymentsItem>>> employments,
            Optional<EmployeeHomeLocation> homeLocation,
            Optional<EmployeeWorkLocation> workLocation,
            Optional<EmployeeManager> manager,
            Optional<EmployeeTeam> team,
            Optional<EmployeePayGroup> payGroup,
            Optional<String> ssn,
            Optional<EmployeeGender> gender,
            Optional<EmployeeEthnicity> ethnicity,
            Optional<EmployeeMaritalStatus> maritalStatus,
            Optional<OffsetDateTime> dateOfBirth,
            Optional<OffsetDateTime> hireDate,
            Optional<OffsetDateTime> startDate,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<EmployeeEmploymentStatus> employmentStatus,
            Optional<OffsetDateTime> terminationDate,
            Optional<String> avatar,
            Optional<Map<String, JsonNode>> customFields,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.employeeNumber = employeeNumber;
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
        this.preferredName = preferredName;
        this.displayFullName = displayFullName;
        this.username = username;
        this.groups = groups;
        this.workEmail = workEmail;
        this.personalEmail = personalEmail;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.employments = employments;
        this.homeLocation = homeLocation;
        this.workLocation = workLocation;
        this.manager = manager;
        this.team = team;
        this.payGroup = payGroup;
        this.ssn = ssn;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.maritalStatus = maritalStatus;
        this.dateOfBirth = dateOfBirth;
        this.hireDate = hireDate;
        this.startDate = startDate;
        this.remoteCreatedAt = remoteCreatedAt;
        this.employmentStatus = employmentStatus;
        this.terminationDate = terminationDate;
        this.avatar = avatar;
        this.customFields = customFields;
        this.remoteWasDeleted = remoteWasDeleted;
        this.modifiedAt = modifiedAt;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    /**
     * @return The employee's number that appears in the third-party integration's UI.
     */
    @JsonProperty("employee_number")
    public Optional<String> getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * @return The ID of the employee's company.
     */
    @JsonProperty("company")
    public Optional<EmployeeCompany> getCompany() {
        return company;
    }

    /**
     * @return The employee's first name.
     */
    @JsonProperty("first_name")
    public Optional<String> getFirstName() {
        return firstName;
    }

    /**
     * @return The employee's last name.
     */
    @JsonProperty("last_name")
    public Optional<String> getLastName() {
        return lastName;
    }

    /**
     * @return The employee's preferred first name.
     */
    @JsonProperty("preferred_name")
    public Optional<String> getPreferredName() {
        return preferredName;
    }

    /**
     * @return The employee's full name, to use for display purposes. If a preferred first name is available, the full name will include the preferred first name.
     */
    @JsonProperty("display_full_name")
    public Optional<String> getDisplayFullName() {
        return displayFullName;
    }

    /**
     * @return The employee's username that appears in the remote UI.
     */
    @JsonProperty("username")
    public Optional<String> getUsername() {
        return username;
    }

    @JsonProperty("groups")
    public Optional<List<Optional<EmployeeGroupsItem>>> getGroups() {
        return groups;
    }

    /**
     * @return The employee's work email.
     */
    @JsonProperty("work_email")
    public Optional<String> getWorkEmail() {
        return workEmail;
    }

    /**
     * @return The employee's personal email.
     */
    @JsonProperty("personal_email")
    public Optional<String> getPersonalEmail() {
        return personalEmail;
    }

    /**
     * @return The employee's mobile phone number.
     */
    @JsonProperty("mobile_phone_number")
    public Optional<String> getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    /**
     * @return Array of <code>Employment</code> IDs for this Employee.
     */
    @JsonProperty("employments")
    public Optional<List<Optional<EmployeeEmploymentsItem>>> getEmployments() {
        return employments;
    }

    /**
     * @return The employee's home address.
     */
    @JsonProperty("home_location")
    public Optional<EmployeeHomeLocation> getHomeLocation() {
        return homeLocation;
    }

    /**
     * @return The employee's work address.
     */
    @JsonProperty("work_location")
    public Optional<EmployeeWorkLocation> getWorkLocation() {
        return workLocation;
    }

    /**
     * @return The employee ID of the employee's manager.
     */
    @JsonProperty("manager")
    public Optional<EmployeeManager> getManager() {
        return manager;
    }

    /**
     * @return The employee's team.
     */
    @JsonProperty("team")
    public Optional<EmployeeTeam> getTeam() {
        return team;
    }

    /**
     * @return The employee's pay group
     */
    @JsonProperty("pay_group")
    public Optional<EmployeePayGroup> getPayGroup() {
        return payGroup;
    }

    /**
     * @return The employee's social security number.
     */
    @JsonProperty("ssn")
    public Optional<String> getSsn() {
        return ssn;
    }

    /**
     * @return The employee's gender.
     * <ul>
     * <li><code>MALE</code> - MALE</li>
     * <li><code>FEMALE</code> - FEMALE</li>
     * <li><code>NON-BINARY</code> - NON-BINARY</li>
     * <li><code>OTHER</code> - OTHER</li>
     * <li><code>PREFER_NOT_TO_DISCLOSE</code> - PREFER_NOT_TO_DISCLOSE</li>
     * </ul>
     */
    @JsonProperty("gender")
    public Optional<EmployeeGender> getGender() {
        return gender;
    }

    /**
     * @return The employee's ethnicity.
     * <ul>
     * <li><code>AMERICAN_INDIAN_OR_ALASKA_NATIVE</code> - AMERICAN_INDIAN_OR_ALASKA_NATIVE</li>
     * <li><code>ASIAN_OR_INDIAN_SUBCONTINENT</code> - ASIAN_OR_INDIAN_SUBCONTINENT</li>
     * <li><code>BLACK_OR_AFRICAN_AMERICAN</code> - BLACK_OR_AFRICAN_AMERICAN</li>
     * <li><code>HISPANIC_OR_LATINO</code> - HISPANIC_OR_LATINO</li>
     * <li><code>NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER</code> - NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER</li>
     * <li><code>TWO_OR_MORE_RACES</code> - TWO_OR_MORE_RACES</li>
     * <li><code>WHITE</code> - WHITE</li>
     * <li><code>PREFER_NOT_TO_DISCLOSE</code> - PREFER_NOT_TO_DISCLOSE</li>
     * </ul>
     */
    @JsonProperty("ethnicity")
    public Optional<EmployeeEthnicity> getEthnicity() {
        return ethnicity;
    }

    /**
     * @return The employee's filing status as related to marital status.
     * <ul>
     * <li><code>SINGLE</code> - SINGLE</li>
     * <li><code>MARRIED_FILING_JOINTLY</code> - MARRIED_FILING_JOINTLY</li>
     * <li><code>MARRIED_FILING_SEPARATELY</code> - MARRIED_FILING_SEPARATELY</li>
     * <li><code>HEAD_OF_HOUSEHOLD</code> - HEAD_OF_HOUSEHOLD</li>
     * <li><code>QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD</code> - QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD</li>
     * </ul>
     */
    @JsonProperty("marital_status")
    public Optional<EmployeeMaritalStatus> getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @return The employee's date of birth.
     */
    @JsonProperty("date_of_birth")
    public Optional<OffsetDateTime> getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @return The date that the employee was hired, usually the day that an offer letter is signed. If an employee has multiple hire dates from previous employments, this represents the most recent hire date. Note: If you're looking for the employee's start date, refer to the start_date field.
     */
    @JsonProperty("hire_date")
    public Optional<OffsetDateTime> getHireDate() {
        return hireDate;
    }

    /**
     * @return The date that the employee started working. If an employee was rehired, the most recent start date will be returned.
     */
    @JsonProperty("start_date")
    public Optional<OffsetDateTime> getStartDate() {
        return startDate;
    }

    /**
     * @return When the third party's employee was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return The employment status of the employee.
     * <ul>
     * <li><code>ACTIVE</code> - ACTIVE</li>
     * <li><code>PENDING</code> - PENDING</li>
     * <li><code>INACTIVE</code> - INACTIVE</li>
     * </ul>
     */
    @JsonProperty("employment_status")
    public Optional<EmployeeEmploymentStatus> getEmploymentStatus() {
        return employmentStatus;
    }

    /**
     * @return The employee's termination date.
     */
    @JsonProperty("termination_date")
    public Optional<OffsetDateTime> getTerminationDate() {
        return terminationDate;
    }

    /**
     * @return The URL of the employee's avatar image.
     */
    @JsonProperty("avatar")
    public Optional<String> getAvatar() {
        return avatar;
    }

    /**
     * @return Custom fields configured for a given model.
     */
    @JsonProperty("custom_fields")
    public Optional<Map<String, JsonNode>> getCustomFields() {
        return customFields;
    }

    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    /**
     * @return This is the datetime that this object was last updated by Merge
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    @JsonProperty("field_mappings")
    public Optional<Map<String, JsonNode>> getFieldMappings() {
        return fieldMappings;
    }

    @JsonProperty("remote_data")
    public Optional<List<RemoteData>> getRemoteData() {
        return remoteData;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Employee && equalTo((Employee) other);
    }

    private boolean equalTo(Employee other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && employeeNumber.equals(other.employeeNumber)
                && company.equals(other.company)
                && firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
                && preferredName.equals(other.preferredName)
                && displayFullName.equals(other.displayFullName)
                && username.equals(other.username)
                && groups.equals(other.groups)
                && workEmail.equals(other.workEmail)
                && personalEmail.equals(other.personalEmail)
                && mobilePhoneNumber.equals(other.mobilePhoneNumber)
                && employments.equals(other.employments)
                && homeLocation.equals(other.homeLocation)
                && workLocation.equals(other.workLocation)
                && manager.equals(other.manager)
                && team.equals(other.team)
                && payGroup.equals(other.payGroup)
                && ssn.equals(other.ssn)
                && gender.equals(other.gender)
                && ethnicity.equals(other.ethnicity)
                && maritalStatus.equals(other.maritalStatus)
                && dateOfBirth.equals(other.dateOfBirth)
                && hireDate.equals(other.hireDate)
                && startDate.equals(other.startDate)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && employmentStatus.equals(other.employmentStatus)
                && terminationDate.equals(other.terminationDate)
                && avatar.equals(other.avatar)
                && customFields.equals(other.customFields)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.employeeNumber,
                this.company,
                this.firstName,
                this.lastName,
                this.preferredName,
                this.displayFullName,
                this.username,
                this.groups,
                this.workEmail,
                this.personalEmail,
                this.mobilePhoneNumber,
                this.employments,
                this.homeLocation,
                this.workLocation,
                this.manager,
                this.team,
                this.payGroup,
                this.ssn,
                this.gender,
                this.ethnicity,
                this.maritalStatus,
                this.dateOfBirth,
                this.hireDate,
                this.startDate,
                this.remoteCreatedAt,
                this.employmentStatus,
                this.terminationDate,
                this.avatar,
                this.customFields,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> employeeNumber = Optional.empty();

        private Optional<EmployeeCompany> company = Optional.empty();

        private Optional<String> firstName = Optional.empty();

        private Optional<String> lastName = Optional.empty();

        private Optional<String> preferredName = Optional.empty();

        private Optional<String> displayFullName = Optional.empty();

        private Optional<String> username = Optional.empty();

        private Optional<List<Optional<EmployeeGroupsItem>>> groups = Optional.empty();

        private Optional<String> workEmail = Optional.empty();

        private Optional<String> personalEmail = Optional.empty();

        private Optional<String> mobilePhoneNumber = Optional.empty();

        private Optional<List<Optional<EmployeeEmploymentsItem>>> employments = Optional.empty();

        private Optional<EmployeeHomeLocation> homeLocation = Optional.empty();

        private Optional<EmployeeWorkLocation> workLocation = Optional.empty();

        private Optional<EmployeeManager> manager = Optional.empty();

        private Optional<EmployeeTeam> team = Optional.empty();

        private Optional<EmployeePayGroup> payGroup = Optional.empty();

        private Optional<String> ssn = Optional.empty();

        private Optional<EmployeeGender> gender = Optional.empty();

        private Optional<EmployeeEthnicity> ethnicity = Optional.empty();

        private Optional<EmployeeMaritalStatus> maritalStatus = Optional.empty();

        private Optional<OffsetDateTime> dateOfBirth = Optional.empty();

        private Optional<OffsetDateTime> hireDate = Optional.empty();

        private Optional<OffsetDateTime> startDate = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<EmployeeEmploymentStatus> employmentStatus = Optional.empty();

        private Optional<OffsetDateTime> terminationDate = Optional.empty();

        private Optional<String> avatar = Optional.empty();

        private Optional<Map<String, JsonNode>> customFields = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Employee other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            employeeNumber(other.getEmployeeNumber());
            company(other.getCompany());
            firstName(other.getFirstName());
            lastName(other.getLastName());
            preferredName(other.getPreferredName());
            displayFullName(other.getDisplayFullName());
            username(other.getUsername());
            groups(other.getGroups());
            workEmail(other.getWorkEmail());
            personalEmail(other.getPersonalEmail());
            mobilePhoneNumber(other.getMobilePhoneNumber());
            employments(other.getEmployments());
            homeLocation(other.getHomeLocation());
            workLocation(other.getWorkLocation());
            manager(other.getManager());
            team(other.getTeam());
            payGroup(other.getPayGroup());
            ssn(other.getSsn());
            gender(other.getGender());
            ethnicity(other.getEthnicity());
            maritalStatus(other.getMaritalStatus());
            dateOfBirth(other.getDateOfBirth());
            hireDate(other.getHireDate());
            startDate(other.getStartDate());
            remoteCreatedAt(other.getRemoteCreatedAt());
            employmentStatus(other.getEmploymentStatus());
            terminationDate(other.getTerminationDate());
            avatar(other.getAvatar());
            customFields(other.getCustomFields());
            remoteWasDeleted(other.getRemoteWasDeleted());
            modifiedAt(other.getModifiedAt());
            fieldMappings(other.getFieldMappings());
            remoteData(other.getRemoteData());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "remote_id", nulls = Nulls.SKIP)
        public Builder remoteId(Optional<String> remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder remoteId(String remoteId) {
            this.remoteId = Optional.of(remoteId);
            return this;
        }

        @JsonSetter(value = "employee_number", nulls = Nulls.SKIP)
        public Builder employeeNumber(Optional<String> employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder employeeNumber(String employeeNumber) {
            this.employeeNumber = Optional.of(employeeNumber);
            return this;
        }

        @JsonSetter(value = "company", nulls = Nulls.SKIP)
        public Builder company(Optional<EmployeeCompany> company) {
            this.company = company;
            return this;
        }

        public Builder company(EmployeeCompany company) {
            this.company = Optional.of(company);
            return this;
        }

        @JsonSetter(value = "first_name", nulls = Nulls.SKIP)
        public Builder firstName(Optional<String> firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = Optional.of(firstName);
            return this;
        }

        @JsonSetter(value = "last_name", nulls = Nulls.SKIP)
        public Builder lastName(Optional<String> lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = Optional.of(lastName);
            return this;
        }

        @JsonSetter(value = "preferred_name", nulls = Nulls.SKIP)
        public Builder preferredName(Optional<String> preferredName) {
            this.preferredName = preferredName;
            return this;
        }

        public Builder preferredName(String preferredName) {
            this.preferredName = Optional.of(preferredName);
            return this;
        }

        @JsonSetter(value = "display_full_name", nulls = Nulls.SKIP)
        public Builder displayFullName(Optional<String> displayFullName) {
            this.displayFullName = displayFullName;
            return this;
        }

        public Builder displayFullName(String displayFullName) {
            this.displayFullName = Optional.of(displayFullName);
            return this;
        }

        @JsonSetter(value = "username", nulls = Nulls.SKIP)
        public Builder username(Optional<String> username) {
            this.username = username;
            return this;
        }

        public Builder username(String username) {
            this.username = Optional.of(username);
            return this;
        }

        @JsonSetter(value = "groups", nulls = Nulls.SKIP)
        public Builder groups(Optional<List<Optional<EmployeeGroupsItem>>> groups) {
            this.groups = groups;
            return this;
        }

        public Builder groups(List<Optional<EmployeeGroupsItem>> groups) {
            this.groups = Optional.of(groups);
            return this;
        }

        @JsonSetter(value = "work_email", nulls = Nulls.SKIP)
        public Builder workEmail(Optional<String> workEmail) {
            this.workEmail = workEmail;
            return this;
        }

        public Builder workEmail(String workEmail) {
            this.workEmail = Optional.of(workEmail);
            return this;
        }

        @JsonSetter(value = "personal_email", nulls = Nulls.SKIP)
        public Builder personalEmail(Optional<String> personalEmail) {
            this.personalEmail = personalEmail;
            return this;
        }

        public Builder personalEmail(String personalEmail) {
            this.personalEmail = Optional.of(personalEmail);
            return this;
        }

        @JsonSetter(value = "mobile_phone_number", nulls = Nulls.SKIP)
        public Builder mobilePhoneNumber(Optional<String> mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber;
            return this;
        }

        public Builder mobilePhoneNumber(String mobilePhoneNumber) {
            this.mobilePhoneNumber = Optional.of(mobilePhoneNumber);
            return this;
        }

        @JsonSetter(value = "employments", nulls = Nulls.SKIP)
        public Builder employments(Optional<List<Optional<EmployeeEmploymentsItem>>> employments) {
            this.employments = employments;
            return this;
        }

        public Builder employments(List<Optional<EmployeeEmploymentsItem>> employments) {
            this.employments = Optional.of(employments);
            return this;
        }

        @JsonSetter(value = "home_location", nulls = Nulls.SKIP)
        public Builder homeLocation(Optional<EmployeeHomeLocation> homeLocation) {
            this.homeLocation = homeLocation;
            return this;
        }

        public Builder homeLocation(EmployeeHomeLocation homeLocation) {
            this.homeLocation = Optional.of(homeLocation);
            return this;
        }

        @JsonSetter(value = "work_location", nulls = Nulls.SKIP)
        public Builder workLocation(Optional<EmployeeWorkLocation> workLocation) {
            this.workLocation = workLocation;
            return this;
        }

        public Builder workLocation(EmployeeWorkLocation workLocation) {
            this.workLocation = Optional.of(workLocation);
            return this;
        }

        @JsonSetter(value = "manager", nulls = Nulls.SKIP)
        public Builder manager(Optional<EmployeeManager> manager) {
            this.manager = manager;
            return this;
        }

        public Builder manager(EmployeeManager manager) {
            this.manager = Optional.of(manager);
            return this;
        }

        @JsonSetter(value = "team", nulls = Nulls.SKIP)
        public Builder team(Optional<EmployeeTeam> team) {
            this.team = team;
            return this;
        }

        public Builder team(EmployeeTeam team) {
            this.team = Optional.of(team);
            return this;
        }

        @JsonSetter(value = "pay_group", nulls = Nulls.SKIP)
        public Builder payGroup(Optional<EmployeePayGroup> payGroup) {
            this.payGroup = payGroup;
            return this;
        }

        public Builder payGroup(EmployeePayGroup payGroup) {
            this.payGroup = Optional.of(payGroup);
            return this;
        }

        @JsonSetter(value = "ssn", nulls = Nulls.SKIP)
        public Builder ssn(Optional<String> ssn) {
            this.ssn = ssn;
            return this;
        }

        public Builder ssn(String ssn) {
            this.ssn = Optional.of(ssn);
            return this;
        }

        @JsonSetter(value = "gender", nulls = Nulls.SKIP)
        public Builder gender(Optional<EmployeeGender> gender) {
            this.gender = gender;
            return this;
        }

        public Builder gender(EmployeeGender gender) {
            this.gender = Optional.of(gender);
            return this;
        }

        @JsonSetter(value = "ethnicity", nulls = Nulls.SKIP)
        public Builder ethnicity(Optional<EmployeeEthnicity> ethnicity) {
            this.ethnicity = ethnicity;
            return this;
        }

        public Builder ethnicity(EmployeeEthnicity ethnicity) {
            this.ethnicity = Optional.of(ethnicity);
            return this;
        }

        @JsonSetter(value = "marital_status", nulls = Nulls.SKIP)
        public Builder maritalStatus(Optional<EmployeeMaritalStatus> maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder maritalStatus(EmployeeMaritalStatus maritalStatus) {
            this.maritalStatus = Optional.of(maritalStatus);
            return this;
        }

        @JsonSetter(value = "date_of_birth", nulls = Nulls.SKIP)
        public Builder dateOfBirth(Optional<OffsetDateTime> dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder dateOfBirth(OffsetDateTime dateOfBirth) {
            this.dateOfBirth = Optional.of(dateOfBirth);
            return this;
        }

        @JsonSetter(value = "hire_date", nulls = Nulls.SKIP)
        public Builder hireDate(Optional<OffsetDateTime> hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        public Builder hireDate(OffsetDateTime hireDate) {
            this.hireDate = Optional.of(hireDate);
            return this;
        }

        @JsonSetter(value = "start_date", nulls = Nulls.SKIP)
        public Builder startDate(Optional<OffsetDateTime> startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder startDate(OffsetDateTime startDate) {
            this.startDate = Optional.of(startDate);
            return this;
        }

        @JsonSetter(value = "remote_created_at", nulls = Nulls.SKIP)
        public Builder remoteCreatedAt(Optional<OffsetDateTime> remoteCreatedAt) {
            this.remoteCreatedAt = remoteCreatedAt;
            return this;
        }

        public Builder remoteCreatedAt(OffsetDateTime remoteCreatedAt) {
            this.remoteCreatedAt = Optional.of(remoteCreatedAt);
            return this;
        }

        @JsonSetter(value = "employment_status", nulls = Nulls.SKIP)
        public Builder employmentStatus(Optional<EmployeeEmploymentStatus> employmentStatus) {
            this.employmentStatus = employmentStatus;
            return this;
        }

        public Builder employmentStatus(EmployeeEmploymentStatus employmentStatus) {
            this.employmentStatus = Optional.of(employmentStatus);
            return this;
        }

        @JsonSetter(value = "termination_date", nulls = Nulls.SKIP)
        public Builder terminationDate(Optional<OffsetDateTime> terminationDate) {
            this.terminationDate = terminationDate;
            return this;
        }

        public Builder terminationDate(OffsetDateTime terminationDate) {
            this.terminationDate = Optional.of(terminationDate);
            return this;
        }

        @JsonSetter(value = "avatar", nulls = Nulls.SKIP)
        public Builder avatar(Optional<String> avatar) {
            this.avatar = avatar;
            return this;
        }

        public Builder avatar(String avatar) {
            this.avatar = Optional.of(avatar);
            return this;
        }

        @JsonSetter(value = "custom_fields", nulls = Nulls.SKIP)
        public Builder customFields(Optional<Map<String, JsonNode>> customFields) {
            this.customFields = customFields;
            return this;
        }

        public Builder customFields(Map<String, JsonNode> customFields) {
            this.customFields = Optional.of(customFields);
            return this;
        }

        @JsonSetter(value = "remote_was_deleted", nulls = Nulls.SKIP)
        public Builder remoteWasDeleted(Optional<Boolean> remoteWasDeleted) {
            this.remoteWasDeleted = remoteWasDeleted;
            return this;
        }

        public Builder remoteWasDeleted(Boolean remoteWasDeleted) {
            this.remoteWasDeleted = Optional.of(remoteWasDeleted);
            return this;
        }

        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.of(modifiedAt);
            return this;
        }

        @JsonSetter(value = "field_mappings", nulls = Nulls.SKIP)
        public Builder fieldMappings(Optional<Map<String, JsonNode>> fieldMappings) {
            this.fieldMappings = fieldMappings;
            return this;
        }

        public Builder fieldMappings(Map<String, JsonNode> fieldMappings) {
            this.fieldMappings = Optional.of(fieldMappings);
            return this;
        }

        @JsonSetter(value = "remote_data", nulls = Nulls.SKIP)
        public Builder remoteData(Optional<List<RemoteData>> remoteData) {
            this.remoteData = remoteData;
            return this;
        }

        public Builder remoteData(List<RemoteData> remoteData) {
            this.remoteData = Optional.of(remoteData);
            return this;
        }

        public Employee build() {
            return new Employee(
                    id,
                    remoteId,
                    employeeNumber,
                    company,
                    firstName,
                    lastName,
                    preferredName,
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
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}
