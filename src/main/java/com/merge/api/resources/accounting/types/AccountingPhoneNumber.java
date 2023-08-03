package com.merge.api.resources.accounting.types;

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
@JsonDeserialize(builder = AccountingPhoneNumber.Builder.class)
public final class AccountingPhoneNumber {
    private final Optional<String> number;

    private final Optional<String> type;

    private final Optional<OffsetDateTime> modifiedAt;

    private AccountingPhoneNumber(Optional<String> number, Optional<String> type, Optional<OffsetDateTime> modifiedAt) {
        this.number = number;
        this.type = type;
        this.modifiedAt = modifiedAt;
    }

    /**
     * @return The phone number.
     */
    @JsonProperty("number")
    public Optional<String> getNumber() {
        return number;
    }

    /**
     * @return The phone number's type.
     */
    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
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
        return other instanceof AccountingPhoneNumber && equalTo((AccountingPhoneNumber) other);
    }

    private boolean equalTo(AccountingPhoneNumber other) {
        return number.equals(other.number) && type.equals(other.type) && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number, this.type, this.modifiedAt);
    }

    @Override
    public String toString() {
        return "AccountingPhoneNumber{" + "number: " + number + ", type: " + type + ", modifiedAt: " + modifiedAt + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> number = Optional.empty();

        private Optional<String> type = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(AccountingPhoneNumber other) {
            number(other.getNumber());
            type(other.getType());
            modifiedAt(other.getModifiedAt());
            return this;
        }

        @JsonSetter(value = "number", nulls = Nulls.SKIP)
        public Builder number(Optional<String> number) {
            this.number = number;
            return this;
        }

        public Builder number(String number) {
            this.number = Optional.of(number);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<String> type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = Optional.of(type);
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

        public AccountingPhoneNumber build() {
            return new AccountingPhoneNumber(number, type, modifiedAt);
        }
    }
}
