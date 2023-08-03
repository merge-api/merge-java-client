package com.merge.api.resources.ats.types;

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
@JsonDeserialize(builder = PhoneNumber.Builder.class)
public final class PhoneNumber {
    private final Optional<String> value;

    private final Optional<PhoneNumberPhoneNumberType> phoneNumberType;

    private final Optional<OffsetDateTime> modifiedAt;

    private PhoneNumber(
            Optional<String> value,
            Optional<PhoneNumberPhoneNumberType> phoneNumberType,
            Optional<OffsetDateTime> modifiedAt) {
        this.value = value;
        this.phoneNumberType = phoneNumberType;
        this.modifiedAt = modifiedAt;
    }

    /**
     * @return The phone number.
     */
    @JsonProperty("value")
    public Optional<String> getValue() {
        return value;
    }

    /**
     * @return The type of phone number.
     * <ul>
     * <li><code>HOME</code> - HOME</li>
     * <li><code>WORK</code> - WORK</li>
     * <li><code>MOBILE</code> - MOBILE</li>
     * <li><code>SKYPE</code> - SKYPE</li>
     * <li><code>OTHER</code> - OTHER</li>
     * </ul>
     */
    @JsonProperty("phone_number_type")
    public Optional<PhoneNumberPhoneNumberType> getPhoneNumberType() {
        return phoneNumberType;
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
        return other instanceof PhoneNumber && equalTo((PhoneNumber) other);
    }

    private boolean equalTo(PhoneNumber other) {
        return value.equals(other.value)
                && phoneNumberType.equals(other.phoneNumberType)
                && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.phoneNumberType, this.modifiedAt);
    }

    @Override
    public String toString() {
        return "PhoneNumber{" + "value: " + value + ", phoneNumberType: " + phoneNumberType + ", modifiedAt: "
                + modifiedAt + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> value = Optional.empty();

        private Optional<PhoneNumberPhoneNumberType> phoneNumberType = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(PhoneNumber other) {
            value(other.getValue());
            phoneNumberType(other.getPhoneNumberType());
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

        @JsonSetter(value = "phone_number_type", nulls = Nulls.SKIP)
        public Builder phoneNumberType(Optional<PhoneNumberPhoneNumberType> phoneNumberType) {
            this.phoneNumberType = phoneNumberType;
            return this;
        }

        public Builder phoneNumberType(PhoneNumberPhoneNumberType phoneNumberType) {
            this.phoneNumberType = Optional.of(phoneNumberType);
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

        public PhoneNumber build() {
            return new PhoneNumber(value, phoneNumberType, modifiedAt);
        }
    }
}
