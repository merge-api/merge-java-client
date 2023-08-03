package com.merge.api.resources.crm.types;

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
@JsonDeserialize(builder = Lead.Builder.class)
public final class Lead {
    private final Optional<String> owner;

    private final Optional<String> leadSource;

    private final Optional<String> title;

    private final Optional<String> company;

    private final Optional<String> firstName;

    private final Optional<String> lastName;

    private final Optional<List<Address>> addresses;

    private final Optional<List<EmailAddress>> emailAddresses;

    private final Optional<List<PhoneNumber>> phoneNumbers;

    private final Optional<OffsetDateTime> remoteUpdatedAt;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<OffsetDateTime> convertedDate;

    private final Optional<String> convertedContact;

    private final Optional<String> convertedAccount;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private final Optional<List<RemoteField>> remoteFields;

    private Lead(
            Optional<String> owner,
            Optional<String> leadSource,
            Optional<String> title,
            Optional<String> company,
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<List<Address>> addresses,
            Optional<List<EmailAddress>> emailAddresses,
            Optional<List<PhoneNumber>> phoneNumbers,
            Optional<OffsetDateTime> remoteUpdatedAt,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<OffsetDateTime> convertedDate,
            Optional<String> convertedContact,
            Optional<String> convertedAccount,
            Optional<Boolean> remoteWasDeleted,
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData,
            Optional<List<RemoteField>> remoteFields) {
        this.owner = owner;
        this.leadSource = leadSource;
        this.title = title;
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
        this.emailAddresses = emailAddresses;
        this.phoneNumbers = phoneNumbers;
        this.remoteUpdatedAt = remoteUpdatedAt;
        this.remoteCreatedAt = remoteCreatedAt;
        this.convertedDate = convertedDate;
        this.convertedContact = convertedContact;
        this.convertedAccount = convertedAccount;
        this.remoteWasDeleted = remoteWasDeleted;
        this.id = id;
        this.remoteId = remoteId;
        this.modifiedAt = modifiedAt;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
        this.remoteFields = remoteFields;
    }

    /**
     * @return The lead's owner.
     */
    @JsonProperty("owner")
    public Optional<String> getOwner() {
        return owner;
    }

    /**
     * @return The lead's source.
     */
    @JsonProperty("lead_source")
    public Optional<String> getLeadSource() {
        return leadSource;
    }

    /**
     * @return The lead's title.
     */
    @JsonProperty("title")
    public Optional<String> getTitle() {
        return title;
    }

    /**
     * @return The lead's company.
     */
    @JsonProperty("company")
    public Optional<String> getCompany() {
        return company;
    }

    /**
     * @return The lead's first name.
     */
    @JsonProperty("first_name")
    public Optional<String> getFirstName() {
        return firstName;
    }

    /**
     * @return The lead's last name.
     */
    @JsonProperty("last_name")
    public Optional<String> getLastName() {
        return lastName;
    }

    @JsonProperty("addresses")
    public Optional<List<Address>> getAddresses() {
        return addresses;
    }

    @JsonProperty("email_addresses")
    public Optional<List<EmailAddress>> getEmailAddresses() {
        return emailAddresses;
    }

    @JsonProperty("phone_numbers")
    public Optional<List<PhoneNumber>> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * @return When the third party's lead was updated.
     */
    @JsonProperty("remote_updated_at")
    public Optional<OffsetDateTime> getRemoteUpdatedAt() {
        return remoteUpdatedAt;
    }

    /**
     * @return When the third party's lead was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return When the lead was converted.
     */
    @JsonProperty("converted_date")
    public Optional<OffsetDateTime> getConvertedDate() {
        return convertedDate;
    }

    /**
     * @return The contact of the converted lead.
     */
    @JsonProperty("converted_contact")
    public Optional<String> getConvertedContact() {
        return convertedContact;
    }

    /**
     * @return The account of the converted lead.
     */
    @JsonProperty("converted_account")
    public Optional<String> getConvertedAccount() {
        return convertedAccount;
    }

    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
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

    @JsonProperty("remote_fields")
    public Optional<List<RemoteField>> getRemoteFields() {
        return remoteFields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Lead && equalTo((Lead) other);
    }

    private boolean equalTo(Lead other) {
        return owner.equals(other.owner)
                && leadSource.equals(other.leadSource)
                && title.equals(other.title)
                && company.equals(other.company)
                && firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
                && addresses.equals(other.addresses)
                && emailAddresses.equals(other.emailAddresses)
                && phoneNumbers.equals(other.phoneNumbers)
                && remoteUpdatedAt.equals(other.remoteUpdatedAt)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && convertedDate.equals(other.convertedDate)
                && convertedContact.equals(other.convertedContact)
                && convertedAccount.equals(other.convertedAccount)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData)
                && remoteFields.equals(other.remoteFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.owner,
                this.leadSource,
                this.title,
                this.company,
                this.firstName,
                this.lastName,
                this.addresses,
                this.emailAddresses,
                this.phoneNumbers,
                this.remoteUpdatedAt,
                this.remoteCreatedAt,
                this.convertedDate,
                this.convertedContact,
                this.convertedAccount,
                this.remoteWasDeleted,
                this.id,
                this.remoteId,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData,
                this.remoteFields);
    }

    @Override
    public String toString() {
        return "Lead{" + "owner: " + owner + ", leadSource: " + leadSource + ", title: " + title + ", company: "
                + company + ", firstName: " + firstName + ", lastName: " + lastName + ", addresses: " + addresses
                + ", emailAddresses: " + emailAddresses + ", phoneNumbers: " + phoneNumbers + ", remoteUpdatedAt: "
                + remoteUpdatedAt + ", remoteCreatedAt: " + remoteCreatedAt + ", convertedDate: " + convertedDate
                + ", convertedContact: " + convertedContact + ", convertedAccount: " + convertedAccount
                + ", remoteWasDeleted: " + remoteWasDeleted + ", id: " + id + ", remoteId: " + remoteId
                + ", modifiedAt: " + modifiedAt + ", fieldMappings: " + fieldMappings + ", remoteData: " + remoteData
                + ", remoteFields: " + remoteFields + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> owner = Optional.empty();

        private Optional<String> leadSource = Optional.empty();

        private Optional<String> title = Optional.empty();

        private Optional<String> company = Optional.empty();

        private Optional<String> firstName = Optional.empty();

        private Optional<String> lastName = Optional.empty();

        private Optional<List<Address>> addresses = Optional.empty();

        private Optional<List<EmailAddress>> emailAddresses = Optional.empty();

        private Optional<List<PhoneNumber>> phoneNumbers = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedAt = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<OffsetDateTime> convertedDate = Optional.empty();

        private Optional<String> convertedContact = Optional.empty();

        private Optional<String> convertedAccount = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Optional<List<RemoteField>> remoteFields = Optional.empty();

        private Builder() {}

        public Builder from(Lead other) {
            owner(other.getOwner());
            leadSource(other.getLeadSource());
            title(other.getTitle());
            company(other.getCompany());
            firstName(other.getFirstName());
            lastName(other.getLastName());
            addresses(other.getAddresses());
            emailAddresses(other.getEmailAddresses());
            phoneNumbers(other.getPhoneNumbers());
            remoteUpdatedAt(other.getRemoteUpdatedAt());
            remoteCreatedAt(other.getRemoteCreatedAt());
            convertedDate(other.getConvertedDate());
            convertedContact(other.getConvertedContact());
            convertedAccount(other.getConvertedAccount());
            remoteWasDeleted(other.getRemoteWasDeleted());
            id(other.getId());
            remoteId(other.getRemoteId());
            modifiedAt(other.getModifiedAt());
            fieldMappings(other.getFieldMappings());
            remoteData(other.getRemoteData());
            remoteFields(other.getRemoteFields());
            return this;
        }

        @JsonSetter(value = "owner", nulls = Nulls.SKIP)
        public Builder owner(Optional<String> owner) {
            this.owner = owner;
            return this;
        }

        public Builder owner(String owner) {
            this.owner = Optional.of(owner);
            return this;
        }

        @JsonSetter(value = "lead_source", nulls = Nulls.SKIP)
        public Builder leadSource(Optional<String> leadSource) {
            this.leadSource = leadSource;
            return this;
        }

        public Builder leadSource(String leadSource) {
            this.leadSource = Optional.of(leadSource);
            return this;
        }

        @JsonSetter(value = "title", nulls = Nulls.SKIP)
        public Builder title(Optional<String> title) {
            this.title = title;
            return this;
        }

        public Builder title(String title) {
            this.title = Optional.of(title);
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

        @JsonSetter(value = "addresses", nulls = Nulls.SKIP)
        public Builder addresses(Optional<List<Address>> addresses) {
            this.addresses = addresses;
            return this;
        }

        public Builder addresses(List<Address> addresses) {
            this.addresses = Optional.of(addresses);
            return this;
        }

        @JsonSetter(value = "email_addresses", nulls = Nulls.SKIP)
        public Builder emailAddresses(Optional<List<EmailAddress>> emailAddresses) {
            this.emailAddresses = emailAddresses;
            return this;
        }

        public Builder emailAddresses(List<EmailAddress> emailAddresses) {
            this.emailAddresses = Optional.of(emailAddresses);
            return this;
        }

        @JsonSetter(value = "phone_numbers", nulls = Nulls.SKIP)
        public Builder phoneNumbers(Optional<List<PhoneNumber>> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public Builder phoneNumbers(List<PhoneNumber> phoneNumbers) {
            this.phoneNumbers = Optional.of(phoneNumbers);
            return this;
        }

        @JsonSetter(value = "remote_updated_at", nulls = Nulls.SKIP)
        public Builder remoteUpdatedAt(Optional<OffsetDateTime> remoteUpdatedAt) {
            this.remoteUpdatedAt = remoteUpdatedAt;
            return this;
        }

        public Builder remoteUpdatedAt(OffsetDateTime remoteUpdatedAt) {
            this.remoteUpdatedAt = Optional.of(remoteUpdatedAt);
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

        @JsonSetter(value = "converted_date", nulls = Nulls.SKIP)
        public Builder convertedDate(Optional<OffsetDateTime> convertedDate) {
            this.convertedDate = convertedDate;
            return this;
        }

        public Builder convertedDate(OffsetDateTime convertedDate) {
            this.convertedDate = Optional.of(convertedDate);
            return this;
        }

        @JsonSetter(value = "converted_contact", nulls = Nulls.SKIP)
        public Builder convertedContact(Optional<String> convertedContact) {
            this.convertedContact = convertedContact;
            return this;
        }

        public Builder convertedContact(String convertedContact) {
            this.convertedContact = Optional.of(convertedContact);
            return this;
        }

        @JsonSetter(value = "converted_account", nulls = Nulls.SKIP)
        public Builder convertedAccount(Optional<String> convertedAccount) {
            this.convertedAccount = convertedAccount;
            return this;
        }

        public Builder convertedAccount(String convertedAccount) {
            this.convertedAccount = Optional.of(convertedAccount);
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

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<List<RemoteField>> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(List<RemoteField> remoteFields) {
            this.remoteFields = Optional.of(remoteFields);
            return this;
        }

        public Lead build() {
            return new Lead(
                    owner,
                    leadSource,
                    title,
                    company,
                    firstName,
                    lastName,
                    addresses,
                    emailAddresses,
                    phoneNumbers,
                    remoteUpdatedAt,
                    remoteCreatedAt,
                    convertedDate,
                    convertedContact,
                    convertedAccount,
                    remoteWasDeleted,
                    id,
                    remoteId,
                    modifiedAt,
                    fieldMappings,
                    remoteData,
                    remoteFields);
        }
    }
}
