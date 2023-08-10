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
@JsonDeserialize(builder = Dependent.Builder.class)
public final class Dependent {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> firstName;

    private final Optional<String> middleName;

    private final Optional<String> lastName;

    private final Optional<DependentRelationship> relationship;

    private final Optional<String> employee;

    private final Optional<OffsetDateTime> dateOfBirth;

    private final Optional<DependentGender> gender;

    private final Optional<String> phoneNumber;

    private final Optional<String> homeLocation;

    private final Optional<Boolean> isStudent;

    private final Optional<String> ssn;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Dependent(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> firstName,
            Optional<String> middleName,
            Optional<String> lastName,
            Optional<DependentRelationship> relationship,
            Optional<String> employee,
            Optional<OffsetDateTime> dateOfBirth,
            Optional<DependentGender> gender,
            Optional<String> phoneNumber,
            Optional<String> homeLocation,
            Optional<Boolean> isStudent,
            Optional<String> ssn,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.relationship = relationship;
        this.employee = employee;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.homeLocation = homeLocation;
        this.isStudent = isStudent;
        this.ssn = ssn;
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
     * @return The dependents's first name.
     */
    @JsonProperty("first_name")
    public Optional<String> getFirstName() {
        return firstName;
    }

    /**
     * @return The dependents's middle name.
     */
    @JsonProperty("middle_name")
    public Optional<String> getMiddleName() {
        return middleName;
    }

    /**
     * @return The dependents's last name.
     */
    @JsonProperty("last_name")
    public Optional<String> getLastName() {
        return lastName;
    }

    /**
     * @return The dependent's relationship to the employee.
     * <ul>
     * <li><code>CHILD</code> - CHILD</li>
     * <li><code>SPOUSE</code> - SPOUSE</li>
     * <li><code>DOMESTIC_PARTNER</code> - DOMESTIC_PARTNER</li>
     * </ul>
     */
    @JsonProperty("relationship")
    public Optional<DependentRelationship> getRelationship() {
        return relationship;
    }

    /**
     * @return The employee this person is a dependent of.
     */
    @JsonProperty("employee")
    public Optional<String> getEmployee() {
        return employee;
    }

    /**
     * @return The dependent's date of birth.
     */
    @JsonProperty("date_of_birth")
    public Optional<OffsetDateTime> getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @return The dependent's gender.
     * <ul>
     * <li><code>MALE</code> - MALE</li>
     * <li><code>FEMALE</code> - FEMALE</li>
     * <li><code>NON-BINARY</code> - NON-BINARY</li>
     * <li><code>OTHER</code> - OTHER</li>
     * <li><code>PREFER_NOT_TO_DISCLOSE</code> - PREFER_NOT_TO_DISCLOSE</li>
     * </ul>
     */
    @JsonProperty("gender")
    public Optional<DependentGender> getGender() {
        return gender;
    }

    /**
     * @return The dependent's phone number.
     */
    @JsonProperty("phone_number")
    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return The dependents's home address.
     */
    @JsonProperty("home_location")
    public Optional<String> getHomeLocation() {
        return homeLocation;
    }

    /**
     * @return Whether or not the dependent is a student
     */
    @JsonProperty("is_student")
    public Optional<Boolean> getIsStudent() {
        return isStudent;
    }

    /**
     * @return The dependents's social security number.
     */
    @JsonProperty("ssn")
    public Optional<String> getSsn() {
        return ssn;
    }

    /**
     * @return Indicates whether or not this object has been deleted by third party webhooks.
     */
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
        return other instanceof Dependent && equalTo((Dependent) other);
    }

    private boolean equalTo(Dependent other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && firstName.equals(other.firstName)
                && middleName.equals(other.middleName)
                && lastName.equals(other.lastName)
                && relationship.equals(other.relationship)
                && employee.equals(other.employee)
                && dateOfBirth.equals(other.dateOfBirth)
                && gender.equals(other.gender)
                && phoneNumber.equals(other.phoneNumber)
                && homeLocation.equals(other.homeLocation)
                && isStudent.equals(other.isStudent)
                && ssn.equals(other.ssn)
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
                this.firstName,
                this.middleName,
                this.lastName,
                this.relationship,
                this.employee,
                this.dateOfBirth,
                this.gender,
                this.phoneNumber,
                this.homeLocation,
                this.isStudent,
                this.ssn,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "Dependent{" + "id: " + id + ", remoteId: " + remoteId + ", firstName: " + firstName + ", middleName: "
                + middleName + ", lastName: " + lastName + ", relationship: " + relationship + ", employee: " + employee
                + ", dateOfBirth: " + dateOfBirth + ", gender: " + gender + ", phoneNumber: " + phoneNumber
                + ", homeLocation: " + homeLocation + ", isStudent: " + isStudent + ", ssn: " + ssn
                + ", remoteWasDeleted: " + remoteWasDeleted + ", modifiedAt: " + modifiedAt + ", fieldMappings: "
                + fieldMappings + ", remoteData: " + remoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> firstName = Optional.empty();

        private Optional<String> middleName = Optional.empty();

        private Optional<String> lastName = Optional.empty();

        private Optional<DependentRelationship> relationship = Optional.empty();

        private Optional<String> employee = Optional.empty();

        private Optional<OffsetDateTime> dateOfBirth = Optional.empty();

        private Optional<DependentGender> gender = Optional.empty();

        private Optional<String> phoneNumber = Optional.empty();

        private Optional<String> homeLocation = Optional.empty();

        private Optional<Boolean> isStudent = Optional.empty();

        private Optional<String> ssn = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Dependent other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            firstName(other.getFirstName());
            middleName(other.getMiddleName());
            lastName(other.getLastName());
            relationship(other.getRelationship());
            employee(other.getEmployee());
            dateOfBirth(other.getDateOfBirth());
            gender(other.getGender());
            phoneNumber(other.getPhoneNumber());
            homeLocation(other.getHomeLocation());
            isStudent(other.getIsStudent());
            ssn(other.getSsn());
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

        @JsonSetter(value = "first_name", nulls = Nulls.SKIP)
        public Builder firstName(Optional<String> firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = Optional.of(firstName);
            return this;
        }

        @JsonSetter(value = "middle_name", nulls = Nulls.SKIP)
        public Builder middleName(Optional<String> middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = Optional.of(middleName);
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

        @JsonSetter(value = "relationship", nulls = Nulls.SKIP)
        public Builder relationship(Optional<DependentRelationship> relationship) {
            this.relationship = relationship;
            return this;
        }

        public Builder relationship(DependentRelationship relationship) {
            this.relationship = Optional.of(relationship);
            return this;
        }

        @JsonSetter(value = "employee", nulls = Nulls.SKIP)
        public Builder employee(Optional<String> employee) {
            this.employee = employee;
            return this;
        }

        public Builder employee(String employee) {
            this.employee = Optional.of(employee);
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

        @JsonSetter(value = "gender", nulls = Nulls.SKIP)
        public Builder gender(Optional<DependentGender> gender) {
            this.gender = gender;
            return this;
        }

        public Builder gender(DependentGender gender) {
            this.gender = Optional.of(gender);
            return this;
        }

        @JsonSetter(value = "phone_number", nulls = Nulls.SKIP)
        public Builder phoneNumber(Optional<String> phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = Optional.of(phoneNumber);
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

        @JsonSetter(value = "is_student", nulls = Nulls.SKIP)
        public Builder isStudent(Optional<Boolean> isStudent) {
            this.isStudent = isStudent;
            return this;
        }

        public Builder isStudent(Boolean isStudent) {
            this.isStudent = Optional.of(isStudent);
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

        public Dependent build() {
            return new Dependent(
                    id,
                    remoteId,
                    firstName,
                    middleName,
                    lastName,
                    relationship,
                    employee,
                    dateOfBirth,
                    gender,
                    phoneNumber,
                    homeLocation,
                    isStudent,
                    ssn,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}