package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EmailAddress.Builder.class)
public final class EmailAddress {
    private final Optional<String> emailAddress;

    private final Optional<String> emailAddressType;

    private final Optional<OffsetDateTime> modifiedAt;

    private EmailAddress(
            Optional<String> emailAddress, Optional<String> emailAddressType, Optional<OffsetDateTime> modifiedAt) {
        this.emailAddress = emailAddress;
        this.emailAddressType = emailAddressType;
        this.modifiedAt = modifiedAt;
    }

    /**
     * @return The email address.
     */
    @JsonProperty("email_address")
    public Optional<String> getEmailAddress() {
        return emailAddress;
    }

    /**
     * @return The email address's type.
     */
    @JsonProperty("email_address_type")
    public Optional<String> getEmailAddressType() {
        return emailAddressType;
    }

    /**
     * @return This is the datetime that this object was last updated by Merge
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmailAddress && equalTo((EmailAddress) other);
    }

    private boolean equalTo(EmailAddress other) {
        return emailAddress.equals(other.emailAddress)
                && emailAddressType.equals(other.emailAddressType)
                && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.emailAddress, this.emailAddressType, this.modifiedAt);
    }

    @Override
    public String toString() {
        return "EmailAddress{" + "emailAddress: " + emailAddress + ", emailAddressType: " + emailAddressType
                + ", modifiedAt: " + modifiedAt + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> emailAddress = Optional.empty();

        private Optional<String> emailAddressType = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(EmailAddress other) {
            emailAddress(other.getEmailAddress());
            emailAddressType(other.getEmailAddressType());
            modifiedAt(other.getModifiedAt());
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

        @JsonSetter(value = "email_address_type", nulls = Nulls.SKIP)
        public Builder emailAddressType(Optional<String> emailAddressType) {
            this.emailAddressType = emailAddressType;
            return this;
        }

        public Builder emailAddressType(String emailAddressType) {
            this.emailAddressType = Optional.of(emailAddressType);
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

        public EmailAddress build() {
            return new EmailAddress(emailAddress, emailAddressType, modifiedAt);
        }
    }
}
