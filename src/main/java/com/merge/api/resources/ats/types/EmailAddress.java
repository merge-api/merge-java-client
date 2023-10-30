package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EmailAddress.Builder.class)
public final class EmailAddress {
    private final Optional<String> value;

    private final Optional<EmailAddressEmailAddressType> emailAddressType;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private EmailAddress(
            Optional<String> value,
            Optional<EmailAddressEmailAddressType> emailAddressType,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt) {
        this.value = value;
        this.emailAddressType = emailAddressType;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    /**
     * @return The email address.
     */
    @JsonProperty("value")
    public Optional<String> getValue() {
        return value;
    }

    /**
     * @return The type of email address.
     * <ul>
     * <li><code>PERSONAL</code> - PERSONAL</li>
     * <li><code>WORK</code> - WORK</li>
     * <li><code>OTHER</code> - OTHER</li>
     * </ul>
     */
    @JsonProperty("email_address_type")
    public Optional<EmailAddressEmailAddressType> getEmailAddressType() {
        return emailAddressType;
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmailAddress && equalTo((EmailAddress) other);
    }

    private boolean equalTo(EmailAddress other) {
        return value.equals(other.value)
                && emailAddressType.equals(other.emailAddressType)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.emailAddressType, this.createdAt, this.modifiedAt);
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
        private Optional<String> value = Optional.empty();

        private Optional<EmailAddressEmailAddressType> emailAddressType = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(EmailAddress other) {
            value(other.getValue());
            emailAddressType(other.getEmailAddressType());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            return this;
        }

        @JsonSetter(value = "value", nulls = Nulls.SKIP)
        public Builder value(Optional<String> value) {
            this.value = value;
            return this;
        }

        public Builder value(String value) {
            this.value = Optional.of(value);
            return this;
        }

        @JsonSetter(value = "email_address_type", nulls = Nulls.SKIP)
        public Builder emailAddressType(Optional<EmailAddressEmailAddressType> emailAddressType) {
            this.emailAddressType = emailAddressType;
            return this;
        }

        public Builder emailAddressType(EmailAddressEmailAddressType emailAddressType) {
            this.emailAddressType = Optional.of(emailAddressType);
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

        public EmailAddress build() {
            return new EmailAddress(value, emailAddressType, createdAt, modifiedAt);
        }
    }
}
