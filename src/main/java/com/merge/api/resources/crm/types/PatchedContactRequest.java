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
@JsonDeserialize(builder = PatchedContactRequest.Builder.class)
public final class PatchedContactRequest {
    private final Optional<String> firstName;

    private final Optional<String> lastName;

    private final Optional<String> account;

    private final Optional<List<AddressRequest>> addresses;

    private final Optional<List<EmailAddressRequest>> emailAddresses;

    private final Optional<List<PhoneNumberRequest>> phoneNumbers;

    private final Optional<OffsetDateTime> lastActivityAt;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private final Optional<List<RemoteFieldRequest>> remoteFields;

    private PatchedContactRequest(
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<String> account,
            Optional<List<AddressRequest>> addresses,
            Optional<List<EmailAddressRequest>> emailAddresses,
            Optional<List<PhoneNumberRequest>> phoneNumbers,
            Optional<OffsetDateTime> lastActivityAt,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams,
            Optional<List<RemoteFieldRequest>> remoteFields) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.addresses = addresses;
        this.emailAddresses = emailAddresses;
        this.phoneNumbers = phoneNumbers;
        this.lastActivityAt = lastActivityAt;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
        this.remoteFields = remoteFields;
    }

    /**
     * @return The contact's first name.
     */
    @JsonProperty("first_name")
    public Optional<String> getFirstName() {
        return firstName;
    }

    /**
     * @return The contact's last name.
     */
    @JsonProperty("last_name")
    public Optional<String> getLastName() {
        return lastName;
    }

    /**
     * @return The contact's account.
     */
    @JsonProperty("account")
    public Optional<String> getAccount() {
        return account;
    }

    @JsonProperty("addresses")
    public Optional<List<AddressRequest>> getAddresses() {
        return addresses;
    }

    @JsonProperty("email_addresses")
    public Optional<List<EmailAddressRequest>> getEmailAddresses() {
        return emailAddresses;
    }

    @JsonProperty("phone_numbers")
    public Optional<List<PhoneNumberRequest>> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * @return When the contact's last activity occurred.
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
        return other instanceof PatchedContactRequest && equalTo((PatchedContactRequest) other);
    }

    private boolean equalTo(PatchedContactRequest other) {
        return firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
                && account.equals(other.account)
                && addresses.equals(other.addresses)
                && emailAddresses.equals(other.emailAddresses)
                && phoneNumbers.equals(other.phoneNumbers)
                && lastActivityAt.equals(other.lastActivityAt)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams)
                && remoteFields.equals(other.remoteFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.firstName,
                this.lastName,
                this.account,
                this.addresses,
                this.emailAddresses,
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
        private Optional<String> firstName = Optional.empty();

        private Optional<String> lastName = Optional.empty();

        private Optional<String> account = Optional.empty();

        private Optional<List<AddressRequest>> addresses = Optional.empty();

        private Optional<List<EmailAddressRequest>> emailAddresses = Optional.empty();

        private Optional<List<PhoneNumberRequest>> phoneNumbers = Optional.empty();

        private Optional<OffsetDateTime> lastActivityAt = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Optional<List<RemoteFieldRequest>> remoteFields = Optional.empty();

        private Builder() {}

        public Builder from(PatchedContactRequest other) {
            firstName(other.getFirstName());
            lastName(other.getLastName());
            account(other.getAccount());
            addresses(other.getAddresses());
            emailAddresses(other.getEmailAddresses());
            phoneNumbers(other.getPhoneNumbers());
            lastActivityAt(other.getLastActivityAt());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            remoteFields(other.getRemoteFields());
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

        @JsonSetter(value = "account", nulls = Nulls.SKIP)
        public Builder account(Optional<String> account) {
            this.account = account;
            return this;
        }

        public Builder account(String account) {
            this.account = Optional.of(account);
            return this;
        }

        @JsonSetter(value = "addresses", nulls = Nulls.SKIP)
        public Builder addresses(Optional<List<AddressRequest>> addresses) {
            this.addresses = addresses;
            return this;
        }

        public Builder addresses(List<AddressRequest> addresses) {
            this.addresses = Optional.of(addresses);
            return this;
        }

        @JsonSetter(value = "email_addresses", nulls = Nulls.SKIP)
        public Builder emailAddresses(Optional<List<EmailAddressRequest>> emailAddresses) {
            this.emailAddresses = emailAddresses;
            return this;
        }

        public Builder emailAddresses(List<EmailAddressRequest> emailAddresses) {
            this.emailAddresses = Optional.of(emailAddresses);
            return this;
        }

        @JsonSetter(value = "phone_numbers", nulls = Nulls.SKIP)
        public Builder phoneNumbers(Optional<List<PhoneNumberRequest>> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public Builder phoneNumbers(List<PhoneNumberRequest> phoneNumbers) {
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

        public PatchedContactRequest build() {
            return new PatchedContactRequest(
                    firstName,
                    lastName,
                    account,
                    addresses,
                    emailAddresses,
                    phoneNumbers,
                    lastActivityAt,
                    integrationParams,
                    linkedAccountParams,
                    remoteFields);
        }
    }
}
