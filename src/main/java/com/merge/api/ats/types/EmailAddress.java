/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = EmailAddress.Builder.class)
public final class EmailAddress {
    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<String> value;

    private final Optional<EmailAddressEmailAddressType> emailAddressType;

    private final Optional<Boolean> remoteWasDeleted;

    private final Map<String, Object> additionalProperties;

    private EmailAddress(
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<String> value,
            Optional<EmailAddressEmailAddressType> emailAddressType,
            Optional<Boolean> remoteWasDeleted,
            Map<String, Object> additionalProperties) {
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.value = value;
        this.emailAddressType = emailAddressType;
        this.remoteWasDeleted = remoteWasDeleted;
        this.additionalProperties = additionalProperties;
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

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
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
                && value.equals(other.value)
                && emailAddressType.equals(other.emailAddressType)
                && remoteWasDeleted.equals(other.remoteWasDeleted);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.createdAt, this.modifiedAt, this.value, this.emailAddressType, this.remoteWasDeleted);
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

        private Optional<String> value = Optional.empty();

        private Optional<EmailAddressEmailAddressType> emailAddressType = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(EmailAddress other) {
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            value(other.getValue());
            emailAddressType(other.getEmailAddressType());
            remoteWasDeleted(other.getRemoteWasDeleted());
            return this;
        }

        /**
         * <p>The datetime that this object was created by Merge.</p>
         */
        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        /**
         * <p>The datetime that this object was modified by Merge.</p>
         */
        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.ofNullable(modifiedAt);
            return this;
        }

        /**
         * <p>The email address.</p>
         */
        @JsonSetter(value = "value", nulls = Nulls.SKIP)
        public Builder value(Optional<String> value) {
            this.value = value;
            return this;
        }

        public Builder value(String value) {
            this.value = Optional.ofNullable(value);
            return this;
        }

        /**
         * <p>The type of email address.</p>
         * <ul>
         * <li><code>PERSONAL</code> - PERSONAL</li>
         * <li><code>WORK</code> - WORK</li>
         * <li><code>OTHER</code> - OTHER</li>
         * </ul>
         */
        @JsonSetter(value = "email_address_type", nulls = Nulls.SKIP)
        public Builder emailAddressType(Optional<EmailAddressEmailAddressType> emailAddressType) {
            this.emailAddressType = emailAddressType;
            return this;
        }

        public Builder emailAddressType(EmailAddressEmailAddressType emailAddressType) {
            this.emailAddressType = Optional.ofNullable(emailAddressType);
            return this;
        }

        /**
         * <p>Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.</p>
         */
        @JsonSetter(value = "remote_was_deleted", nulls = Nulls.SKIP)
        public Builder remoteWasDeleted(Optional<Boolean> remoteWasDeleted) {
            this.remoteWasDeleted = remoteWasDeleted;
            return this;
        }

        public Builder remoteWasDeleted(Boolean remoteWasDeleted) {
            this.remoteWasDeleted = Optional.ofNullable(remoteWasDeleted);
            return this;
        }

        public EmailAddress build() {
            return new EmailAddress(
                    createdAt, modifiedAt, value, emailAddressType, remoteWasDeleted, additionalProperties);
        }
    }
}
