/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Contact.Builder.class)
public final class Contact {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<String> name;

    private final Optional<Boolean> isSupplier;

    private final Optional<Boolean> isCustomer;

    private final Optional<String> emailAddress;

    private final Optional<String> taxNumber;

    private final Optional<ContactStatus> status;

    private final Optional<String> currency;

    private final Optional<OffsetDateTime> remoteUpdatedAt;

    private final Optional<String> company;

    private final Optional<List<Optional<ContactAddressesItem>>> addresses;

    private final Optional<List<AccountingPhoneNumber>> phoneNumbers;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private final Optional<List<RemoteField>> remoteFields;

    private final Map<String, Object> additionalProperties;

    private Contact(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<String> name,
            Optional<Boolean> isSupplier,
            Optional<Boolean> isCustomer,
            Optional<String> emailAddress,
            Optional<String> taxNumber,
            Optional<ContactStatus> status,
            Optional<String> currency,
            Optional<OffsetDateTime> remoteUpdatedAt,
            Optional<String> company,
            Optional<List<Optional<ContactAddressesItem>>> addresses,
            Optional<List<AccountingPhoneNumber>> phoneNumbers,
            Optional<Boolean> remoteWasDeleted,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData,
            Optional<List<RemoteField>> remoteFields,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.remoteId = remoteId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.name = name;
        this.isSupplier = isSupplier;
        this.isCustomer = isCustomer;
        this.emailAddress = emailAddress;
        this.taxNumber = taxNumber;
        this.status = status;
        this.currency = currency;
        this.remoteUpdatedAt = remoteUpdatedAt;
        this.company = company;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
        this.remoteWasDeleted = remoteWasDeleted;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
        this.remoteFields = remoteFields;
        this.additionalProperties = additionalProperties;
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
     * @return The datetime that this object was created by Merge.
     */
    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The datetime that this object was modified by Merge.
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    /**
     * @return The contact's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return Whether the contact is a supplier.
     */
    @JsonProperty("is_supplier")
    public Optional<Boolean> getIsSupplier() {
        return isSupplier;
    }

    /**
     * @return Whether the contact is a customer.
     */
    @JsonProperty("is_customer")
    public Optional<Boolean> getIsCustomer() {
        return isCustomer;
    }

    /**
     * @return The contact's email address.
     */
    @JsonProperty("email_address")
    public Optional<String> getEmailAddress() {
        return emailAddress;
    }

    /**
     * @return The contact's tax number.
     */
    @JsonProperty("tax_number")
    public Optional<String> getTaxNumber() {
        return taxNumber;
    }

    /**
     * @return The contact's status
     * <ul>
     * <li><code>ACTIVE</code> - ACTIVE</li>
     * <li><code>ARCHIVED</code> - ARCHIVED</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<ContactStatus> getStatus() {
        return status;
    }

    /**
     * @return The currency the contact's transactions are in.
     */
    @JsonProperty("currency")
    public Optional<String> getCurrency() {
        return currency;
    }

    /**
     * @return When the third party's contact was updated.
     */
    @JsonProperty("remote_updated_at")
    public Optional<OffsetDateTime> getRemoteUpdatedAt() {
        return remoteUpdatedAt;
    }

    /**
     * @return The company the contact belongs to.
     */
    @JsonProperty("company")
    public Optional<String> getCompany() {
        return company;
    }

    /**
     * @return <code>Address</code> object IDs for the given <code>Contacts</code> object.
     */
    @JsonProperty("addresses")
    public Optional<List<Optional<ContactAddressesItem>>> getAddresses() {
        return addresses;
    }

    /**
     * @return <code>AccountingPhoneNumber</code> object for the given <code>Contacts</code> object.
     */
    @JsonProperty("phone_numbers")
    public Optional<List<AccountingPhoneNumber>> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
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

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Contact && equalTo((Contact) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Contact other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && name.equals(other.name)
                && isSupplier.equals(other.isSupplier)
                && isCustomer.equals(other.isCustomer)
                && emailAddress.equals(other.emailAddress)
                && taxNumber.equals(other.taxNumber)
                && status.equals(other.status)
                && currency.equals(other.currency)
                && remoteUpdatedAt.equals(other.remoteUpdatedAt)
                && company.equals(other.company)
                && addresses.equals(other.addresses)
                && phoneNumbers.equals(other.phoneNumbers)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData)
                && remoteFields.equals(other.remoteFields);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.createdAt,
                this.modifiedAt,
                this.name,
                this.isSupplier,
                this.isCustomer,
                this.emailAddress,
                this.taxNumber,
                this.status,
                this.currency,
                this.remoteUpdatedAt,
                this.company,
                this.addresses,
                this.phoneNumbers,
                this.remoteWasDeleted,
                this.fieldMappings,
                this.remoteData,
                this.remoteFields);
    }

    @java.lang.Override
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

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<Boolean> isSupplier = Optional.empty();

        private Optional<Boolean> isCustomer = Optional.empty();

        private Optional<String> emailAddress = Optional.empty();

        private Optional<String> taxNumber = Optional.empty();

        private Optional<ContactStatus> status = Optional.empty();

        private Optional<String> currency = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedAt = Optional.empty();

        private Optional<String> company = Optional.empty();

        private Optional<List<Optional<ContactAddressesItem>>> addresses = Optional.empty();

        private Optional<List<AccountingPhoneNumber>> phoneNumbers = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Optional<List<RemoteField>> remoteFields = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Contact other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            name(other.getName());
            isSupplier(other.getIsSupplier());
            isCustomer(other.getIsCustomer());
            emailAddress(other.getEmailAddress());
            taxNumber(other.getTaxNumber());
            status(other.getStatus());
            currency(other.getCurrency());
            remoteUpdatedAt(other.getRemoteUpdatedAt());
            company(other.getCompany());
            addresses(other.getAddresses());
            phoneNumbers(other.getPhoneNumbers());
            remoteWasDeleted(other.getRemoteWasDeleted());
            fieldMappings(other.getFieldMappings());
            remoteData(other.getRemoteData());
            remoteFields(other.getRemoteFields());
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

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.of(createdAt);
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "is_supplier", nulls = Nulls.SKIP)
        public Builder isSupplier(Optional<Boolean> isSupplier) {
            this.isSupplier = isSupplier;
            return this;
        }

        public Builder isSupplier(Boolean isSupplier) {
            this.isSupplier = Optional.of(isSupplier);
            return this;
        }

        @JsonSetter(value = "is_customer", nulls = Nulls.SKIP)
        public Builder isCustomer(Optional<Boolean> isCustomer) {
            this.isCustomer = isCustomer;
            return this;
        }

        public Builder isCustomer(Boolean isCustomer) {
            this.isCustomer = Optional.of(isCustomer);
            return this;
        }

        @JsonSetter(value = "email_address", nulls = Nulls.SKIP)
        public Builder emailAddress(Optional<String> emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = Optional.of(emailAddress);
            return this;
        }

        @JsonSetter(value = "tax_number", nulls = Nulls.SKIP)
        public Builder taxNumber(Optional<String> taxNumber) {
            this.taxNumber = taxNumber;
            return this;
        }

        public Builder taxNumber(String taxNumber) {
            this.taxNumber = Optional.of(taxNumber);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<ContactStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(ContactStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "currency", nulls = Nulls.SKIP)
        public Builder currency(Optional<String> currency) {
            this.currency = currency;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = Optional.of(currency);
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

        @JsonSetter(value = "company", nulls = Nulls.SKIP)
        public Builder company(Optional<String> company) {
            this.company = company;
            return this;
        }

        public Builder company(String company) {
            this.company = Optional.of(company);
            return this;
        }

        @JsonSetter(value = "addresses", nulls = Nulls.SKIP)
        public Builder addresses(Optional<List<Optional<ContactAddressesItem>>> addresses) {
            this.addresses = addresses;
            return this;
        }

        public Builder addresses(List<Optional<ContactAddressesItem>> addresses) {
            this.addresses = Optional.of(addresses);
            return this;
        }

        @JsonSetter(value = "phone_numbers", nulls = Nulls.SKIP)
        public Builder phoneNumbers(Optional<List<AccountingPhoneNumber>> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public Builder phoneNumbers(List<AccountingPhoneNumber> phoneNumbers) {
            this.phoneNumbers = Optional.of(phoneNumbers);
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

        public Contact build() {
            return new Contact(
                    id,
                    remoteId,
                    createdAt,
                    modifiedAt,
                    name,
                    isSupplier,
                    isCustomer,
                    emailAddress,
                    taxNumber,
                    status,
                    currency,
                    remoteUpdatedAt,
                    company,
                    addresses,
                    phoneNumbers,
                    remoteWasDeleted,
                    fieldMappings,
                    remoteData,
                    remoteFields,
                    additionalProperties);
        }
    }
}
