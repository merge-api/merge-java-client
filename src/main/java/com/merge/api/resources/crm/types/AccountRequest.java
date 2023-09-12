package com.merge.api.resources.crm.types;

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
@JsonDeserialize(builder = AccountRequest.Builder.class)
public final class AccountRequest {
    private final Optional<AccountRequestOwner> owner;

    private final Optional<String> name;

    private final Optional<String> description;

    private final Optional<String> industry;

    private final Optional<String> website;

    private final Optional<Integer> numberOfEmployees;

    private final Optional<List<Address>> addresses;

    private final Optional<List<PhoneNumber>> phoneNumbers;

    private final Optional<OffsetDateTime> lastActivityAt;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private final Optional<List<RemoteFieldRequest>> remoteFields;

    private AccountRequest(
            Optional<AccountRequestOwner> owner,
            Optional<String> name,
            Optional<String> description,
            Optional<String> industry,
            Optional<String> website,
            Optional<Integer> numberOfEmployees,
            Optional<List<Address>> addresses,
            Optional<List<PhoneNumber>> phoneNumbers,
            Optional<OffsetDateTime> lastActivityAt,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams,
            Optional<List<RemoteFieldRequest>> remoteFields) {
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.industry = industry;
        this.website = website;
        this.numberOfEmployees = numberOfEmployees;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
        this.lastActivityAt = lastActivityAt;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
        this.remoteFields = remoteFields;
    }

    /**
     * @return The account's owner.
     */
    @JsonProperty("owner")
    public Optional<AccountRequestOwner> getOwner() {
        return owner;
    }

    /**
     * @return The account's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The account's description.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The account's industry.
     */
    @JsonProperty("industry")
    public Optional<String> getIndustry() {
        return industry;
    }

    /**
     * @return The account's website.
     */
    @JsonProperty("website")
    public Optional<String> getWebsite() {
        return website;
    }

    /**
     * @return The account's number of employees.
     */
    @JsonProperty("number_of_employees")
    public Optional<Integer> getNumberOfEmployees() {
        return numberOfEmployees;
    }

    @JsonProperty("addresses")
    public Optional<List<Address>> getAddresses() {
        return addresses;
    }

    @JsonProperty("phone_numbers")
    public Optional<List<PhoneNumber>> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * @return The last date (either most recent or furthest in the future) of when an activity occurs in an account.
     */
    @JsonProperty("last_activity_at")
    public Optional<OffsetDateTime> getLastActivityAt() {
        return lastActivityAt;
    }

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @JsonProperty("remote_fields")
    public Optional<List<RemoteFieldRequest>> getRemoteFields() {
        return remoteFields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AccountRequest && equalTo((AccountRequest) other);
    }

    private boolean equalTo(AccountRequest other) {
        return owner.equals(other.owner)
                && name.equals(other.name)
                && description.equals(other.description)
                && industry.equals(other.industry)
                && website.equals(other.website)
                && numberOfEmployees.equals(other.numberOfEmployees)
                && addresses.equals(other.addresses)
                && phoneNumbers.equals(other.phoneNumbers)
                && lastActivityAt.equals(other.lastActivityAt)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams)
                && remoteFields.equals(other.remoteFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.owner,
                this.name,
                this.description,
                this.industry,
                this.website,
                this.numberOfEmployees,
                this.addresses,
                this.phoneNumbers,
                this.lastActivityAt,
                this.integrationParams,
                this.linkedAccountParams,
                this.remoteFields);
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
        private Optional<AccountRequestOwner> owner = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> industry = Optional.empty();

        private Optional<String> website = Optional.empty();

        private Optional<Integer> numberOfEmployees = Optional.empty();

        private Optional<List<Address>> addresses = Optional.empty();

        private Optional<List<PhoneNumber>> phoneNumbers = Optional.empty();

        private Optional<OffsetDateTime> lastActivityAt = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Optional<List<RemoteFieldRequest>> remoteFields = Optional.empty();

        private Builder() {}

        public Builder from(AccountRequest other) {
            owner(other.getOwner());
            name(other.getName());
            description(other.getDescription());
            industry(other.getIndustry());
            website(other.getWebsite());
            numberOfEmployees(other.getNumberOfEmployees());
            addresses(other.getAddresses());
            phoneNumbers(other.getPhoneNumbers());
            lastActivityAt(other.getLastActivityAt());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            remoteFields(other.getRemoteFields());
            return this;
        }

        @JsonSetter(value = "owner", nulls = Nulls.SKIP)
        public Builder owner(Optional<AccountRequestOwner> owner) {
            this.owner = owner;
            return this;
        }

        public Builder owner(AccountRequestOwner owner) {
            this.owner = Optional.of(owner);
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

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @JsonSetter(value = "industry", nulls = Nulls.SKIP)
        public Builder industry(Optional<String> industry) {
            this.industry = industry;
            return this;
        }

        public Builder industry(String industry) {
            this.industry = Optional.of(industry);
            return this;
        }

        @JsonSetter(value = "website", nulls = Nulls.SKIP)
        public Builder website(Optional<String> website) {
            this.website = website;
            return this;
        }

        public Builder website(String website) {
            this.website = Optional.of(website);
            return this;
        }

        @JsonSetter(value = "number_of_employees", nulls = Nulls.SKIP)
        public Builder numberOfEmployees(Optional<Integer> numberOfEmployees) {
            this.numberOfEmployees = numberOfEmployees;
            return this;
        }

        public Builder numberOfEmployees(Integer numberOfEmployees) {
            this.numberOfEmployees = Optional.of(numberOfEmployees);
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

        @JsonSetter(value = "phone_numbers", nulls = Nulls.SKIP)
        public Builder phoneNumbers(Optional<List<PhoneNumber>> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public Builder phoneNumbers(List<PhoneNumber> phoneNumbers) {
            this.phoneNumbers = Optional.of(phoneNumbers);
            return this;
        }

        @JsonSetter(value = "last_activity_at", nulls = Nulls.SKIP)
        public Builder lastActivityAt(Optional<OffsetDateTime> lastActivityAt) {
            this.lastActivityAt = lastActivityAt;
            return this;
        }

        public Builder lastActivityAt(OffsetDateTime lastActivityAt) {
            this.lastActivityAt = Optional.of(lastActivityAt);
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

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<List<RemoteFieldRequest>> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(List<RemoteFieldRequest> remoteFields) {
            this.remoteFields = Optional.of(remoteFields);
            return this;
        }

        public AccountRequest build() {
            return new AccountRequest(
                    owner,
                    name,
                    description,
                    industry,
                    website,
                    numberOfEmployees,
                    addresses,
                    phoneNumbers,
                    lastActivityAt,
                    integrationParams,
                    linkedAccountParams,
                    remoteFields);
        }
    }
}
