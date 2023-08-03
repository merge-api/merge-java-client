package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EmployeeRequest.Builder.class)
public final class EmployeeRequest {
    private final Optional<String> employeeNumber;

    private final Optional<String> company;

    private final Optional<String> firstName;

    private final Optional<String> lastName;

    private final Optional<String> displayFullName;

    private final Optional<String> username;

    private final Optional<List<Optional<String>>> groups;

    private final Optional<String> workEmail;

    private final Optional<String> personalEmail;

    private final Optional<String> mobilePhoneNumber;

    private final Optional<List<Optional<String>>> employments;

    private final Optional<String> homeLocation;

    private final Optional<String> workLocation;

    private final Optional<String> manager;

    private final Optional<String> team;

    private final Optional<String> payGroup;

    private final Optional<String> ssn;

    private final Optional<EmployeeRequestGender> gender;

    private final Optional<EmployeeRequestEthnicity> ethnicity;

    private final Optional<EmployeeRequestMaritalStatus> maritalStatus;

    private final Optional<OffsetDateTime> dateOfBirth;

    private final Optional<OffsetDateTime> hireDate;

    private final Optional<OffsetDateTime> startDate;

    private final Optional<EmployeeRequestEmploymentStatus> employmentStatus;

    private final Optional<OffsetDateTime> terminationDate;

    private final Optional<String> avatar;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private EmployeeRequest(
            Optional<String> employeeNumber,
            Optional<String> company,
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<String> displayFullName,
            Optional<String> username,
            Optional<List<Optional<String>>> groups,
            Optional<String> workEmail,
            Optional<String> personalEmail,
            Optional<String> mobilePhoneNumber,
            Optional<List<Optional<String>>> employments,
            Optional<String> homeLocation,
            Optional<String> workLocation,
            Optional<String> manager,
            Optional<String> team,
            Optional<String> payGroup,
            Optional<String> ssn,
            Optional<EmployeeRequestGender> gender,
            Optional<EmployeeRequestEthnicity> ethnicity,
            Optional<EmployeeRequestMaritalStatus> maritalStatus,
            Optional<OffsetDateTime> dateOfBirth,
            Optional<OffsetDateTime> hireDate,
            Optional<OffsetDateTime> startDate,
            Optional<EmployeeRequestEmploymentStatus> employmentStatus,
            Optional<OffsetDateTime> terminationDate,
            Optional<String> avatar,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.employeeNumber = employeeNumber;
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
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
        this.employmentStatus = employmentStatus;
        this.terminationDate = terminationDate;
        this.avatar = avatar;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
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
    public Optional<String> getCompany() {
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
    public Optional<List<Optional<String>>> getGroups() {
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
    public Optional<List<Optional<String>>> getEmployments() {
        return employments;
    }

    /**
     * @return The employee's home address.
     */
    @JsonProperty("home_location")
    public Optional<String> getHomeLocation() {
        return homeLocation;
    }

    /**
     * @return The employee's work address.
     */
    @JsonProperty("work_location")
    public Optional<String> getWorkLocation() {
        return workLocation;
    }

    /**
     * @return The employee ID of the employee's manager.
     */
    @JsonProperty("manager")
    public Optional<String> getManager() {
        return manager;
    }

    /**
     * @return The employee's team.
     */
    @JsonProperty("team")
    public Optional<String> getTeam() {
        return team;
    }

    /**
     * @return The employee's pay group
     */
    @JsonProperty("pay_group")
    public Optional<String> getPayGroup() {
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
    public Optional<EmployeeRequestGender> getGender() {
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
    public Optional<EmployeeRequestEthnicity> getEthnicity() {
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
    public Optional<EmployeeRequestMaritalStatus> getMaritalStatus() {
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
     * @return The employment status of the employee.
     * <ul>
     * <li><code>ACTIVE</code> - ACTIVE</li>
     * <li><code>PENDING</code> - PENDING</li>
     * <li><code>INACTIVE</code> - INACTIVE</li>
     * </ul>
     */
    @JsonProperty("employment_status")
    public Optional<EmployeeRequestEmploymentStatus> getEmploymentStatus() {
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

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmployeeRequest && equalTo((EmployeeRequest) other);
    }

    private boolean equalTo(EmployeeRequest other) {
        return employeeNumber.equals(other.employeeNumber)
                && company.equals(other.company)
                && firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
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
                && employmentStatus.equals(other.employmentStatus)
                && terminationDate.equals(other.terminationDate)
                && avatar.equals(other.avatar)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.employeeNumber,
                this.company,
                this.firstName,
                this.lastName,
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
                this.employmentStatus,
                this.terminationDate,
                this.avatar,
                this.integrationParams,
                this.linkedAccountParams);
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" + "employeeNumber: " + employeeNumber + ", company: " + company + ", firstName: "
                + firstName + ", lastName: " + lastName + ", displayFullName: " + displayFullName + ", username: "
                + username + ", groups: " + groups + ", workEmail: " + workEmail + ", personalEmail: " + personalEmail
                + ", mobilePhoneNumber: " + mobilePhoneNumber + ", employments: " + employments + ", homeLocation: "
                + homeLocation + ", workLocation: " + workLocation + ", manager: " + manager + ", team: " + team
                + ", payGroup: " + payGroup + ", ssn: " + ssn + ", gender: " + gender + ", ethnicity: " + ethnicity
                + ", maritalStatus: " + maritalStatus + ", dateOfBirth: " + dateOfBirth + ", hireDate: " + hireDate
                + ", startDate: " + startDate + ", employmentStatus: " + employmentStatus + ", terminationDate: "
                + terminationDate + ", avatar: " + avatar + ", integrationParams: " + integrationParams
                + ", linkedAccountParams: " + linkedAccountParams + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> employeeNumber = Optional.empty();

        private Optional<String> company = Optional.empty();

        private Optional<String> firstName = Optional.empty();

        private Optional<String> lastName = Optional.empty();

        private Optional<String> displayFullName = Optional.empty();

        private Optional<String> username = Optional.empty();

        private Optional<List<Optional<String>>> groups = Optional.empty();

        private Optional<String> workEmail = Optional.empty();

        private Optional<String> personalEmail = Optional.empty();

        private Optional<String> mobilePhoneNumber = Optional.empty();

        private Optional<List<Optional<String>>> employments = Optional.empty();

        private Optional<String> homeLocation = Optional.empty();

        private Optional<String> workLocation = Optional.empty();

        private Optional<String> manager = Optional.empty();

        private Optional<String> team = Optional.empty();

        private Optional<String> payGroup = Optional.empty();

        private Optional<String> ssn = Optional.empty();

        private Optional<EmployeeRequestGender> gender = Optional.empty();

        private Optional<EmployeeRequestEthnicity> ethnicity = Optional.empty();

        private Optional<EmployeeRequestMaritalStatus> maritalStatus = Optional.empty();

        private Optional<OffsetDateTime> dateOfBirth = Optional.empty();

        private Optional<OffsetDateTime> hireDate = Optional.empty();

        private Optional<OffsetDateTime> startDate = Optional.empty();

        private Optional<EmployeeRequestEmploymentStatus> employmentStatus = Optional.empty();

        private Optional<OffsetDateTime> terminationDate = Optional.empty();

        private Optional<String> avatar = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(EmployeeRequest other) {
            employeeNumber(other.getEmployeeNumber());
            company(other.getCompany());
            firstName(other.getFirstName());
            lastName(other.getLastName());
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
            employmentStatus(other.getEmploymentStatus());
            terminationDate(other.getTerminationDate());
            avatar(other.getAvatar());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
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
        public Builder company(Optional<String> company) {
            this.company = company;
            return this;
        }

        public Builder company(String company) {
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
        public Builder groups(Optional<List<Optional<String>>> groups) {
            this.groups = groups;
            return this;
        }

        public Builder groups(List<Optional<String>> groups) {
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
        public Builder employments(Optional<List<Optional<String>>> employments) {
            this.employments = employments;
            return this;
        }

        public Builder employments(List<Optional<String>> employments) {
            this.employments = Optional.of(employments);
            return this;
        }

        @JsonSetter(value = "home_location", nulls = Nulls.SKIP)
        public Builder homeLocation(Optional<String> homeLocation) {
            this.homeLocation = homeLocation;
            return this;
        }

        public Builder homeLocation(String homeLocation) {
            this.homeLocation = Optional.of(homeLocation);
            return this;
        }

        @JsonSetter(value = "work_location", nulls = Nulls.SKIP)
        public Builder workLocation(Optional<String> workLocation) {
            this.workLocation = workLocation;
            return this;
        }

        public Builder workLocation(String workLocation) {
            this.workLocation = Optional.of(workLocation);
            return this;
        }

        @JsonSetter(value = "manager", nulls = Nulls.SKIP)
        public Builder manager(Optional<String> manager) {
            this.manager = manager;
            return this;
        }

        public Builder manager(String manager) {
            this.manager = Optional.of(manager);
            return this;
        }

        @JsonSetter(value = "team", nulls = Nulls.SKIP)
        public Builder team(Optional<String> team) {
            this.team = team;
            return this;
        }

        public Builder team(String team) {
            this.team = Optional.of(team);
            return this;
        }

        @JsonSetter(value = "pay_group", nulls = Nulls.SKIP)
        public Builder payGroup(Optional<String> payGroup) {
            this.payGroup = payGroup;
            return this;
        }

        public Builder payGroup(String payGroup) {
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
        public Builder gender(Optional<EmployeeRequestGender> gender) {
            this.gender = gender;
            return this;
        }

        public Builder gender(EmployeeRequestGender gender) {
            this.gender = Optional.of(gender);
            return this;
        }

        @JsonSetter(value = "ethnicity", nulls = Nulls.SKIP)
        public Builder ethnicity(Optional<EmployeeRequestEthnicity> ethnicity) {
            this.ethnicity = ethnicity;
            return this;
        }

        public Builder ethnicity(EmployeeRequestEthnicity ethnicity) {
            this.ethnicity = Optional.of(ethnicity);
            return this;
        }

        @JsonSetter(value = "marital_status", nulls = Nulls.SKIP)
        public Builder maritalStatus(Optional<EmployeeRequestMaritalStatus> maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder maritalStatus(EmployeeRequestMaritalStatus maritalStatus) {
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

        @JsonSetter(value = "employment_status", nulls = Nulls.SKIP)
        public Builder employmentStatus(Optional<EmployeeRequestEmploymentStatus> employmentStatus) {
            this.employmentStatus = employmentStatus;
            return this;
        }

        public Builder employmentStatus(EmployeeRequestEmploymentStatus employmentStatus) {
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

        @JsonSetter(value = "integration_params", nulls = Nulls.SKIP)
        public Builder integrationParams(Optional<Map<String, JsonNode>> integrationParams) {
            this.integrationParams = integrationParams;
            return this;
        }

        public Builder integrationParams(Map<String, JsonNode> integrationParams) {
            this.integrationParams = Optional.of(integrationParams);
            return this;
        }

        @JsonSetter(value = "linked_account_params", nulls = Nulls.SKIP)
        public Builder linkedAccountParams(Optional<Map<String, JsonNode>> linkedAccountParams) {
            this.linkedAccountParams = linkedAccountParams;
            return this;
        }

        public Builder linkedAccountParams(Map<String, JsonNode> linkedAccountParams) {
            this.linkedAccountParams = Optional.of(linkedAccountParams);
            return this;
        }

        public EmployeeRequest build() {
            return new EmployeeRequest(
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
                    linkedAccountParams);
        }
    }
}