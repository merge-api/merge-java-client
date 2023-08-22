package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PhoneNumberRequest.Builder.class)
public final class PhoneNumberRequest {
    private final Optional<String> value;

    private final Optional<PhoneNumberRequestPhoneNumberType> phoneNumberType;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private PhoneNumberRequest(
            Optional<String> value,
            Optional<PhoneNumberRequestPhoneNumberType> phoneNumberType,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.value = value;
        this.phoneNumberType = phoneNumberType;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
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
    public Optional<PhoneNumberRequestPhoneNumberType> getPhoneNumberType() {
        return phoneNumberType;
    }

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PhoneNumberRequest && equalTo((PhoneNumberRequest) other);
    }

    private boolean equalTo(PhoneNumberRequest other) {
        return value.equals(other.value)
                && phoneNumberType.equals(other.phoneNumberType)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.phoneNumberType, this.integrationParams, this.linkedAccountParams);
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

        private Optional<PhoneNumberRequestPhoneNumberType> phoneNumberType = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(PhoneNumberRequest other) {
            value(other.getValue());
            phoneNumberType(other.getPhoneNumberType());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
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
        public Builder phoneNumberType(Optional<PhoneNumberRequestPhoneNumberType> phoneNumberType) {
            this.phoneNumberType = phoneNumberType;
            return this;
        }

        public Builder phoneNumberType(PhoneNumberRequestPhoneNumberType phoneNumberType) {
            this.phoneNumberType = Optional.of(phoneNumberType);
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

        public PhoneNumberRequest build() {
            return new PhoneNumberRequest(value, phoneNumberType, integrationParams, linkedAccountParams);
        }
    }
}
