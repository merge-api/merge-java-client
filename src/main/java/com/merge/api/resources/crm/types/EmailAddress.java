/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EmailAddress.Builder.class)
public final class EmailAddress {
    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<String> emailAddress;

    private final Optional<String> emailAddressType;

    private final Map<String, Object> additionalProperties;

    private EmailAddress(
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<String> emailAddress,
            Optional<String> emailAddressType,
            Map<String, Object> additionalProperties) {
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.emailAddress = emailAddress;
        this.emailAddressType = emailAddressType;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return This is the datetime that this object was last updated by Merge
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
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

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmailAddress && equalTo((EmailAddress) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(EmailAddress other) {
        return createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && emailAddress.equals(other.emailAddress)
                && emailAddressType.equals(other.emailAddressType);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.createdAt, this.modifiedAt, this.emailAddress, this.emailAddressType);
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
        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<String> emailAddress = Optional.empty();

        private Optional<String> emailAddressType = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(EmailAddress other) {
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            emailAddress(other.getEmailAddress());
            emailAddressType(other.getEmailAddressType());
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

        public EmailAddress build() {
            return new EmailAddress(createdAt, modifiedAt, emailAddress, emailAddressType, additionalProperties);
        }
    }
}
