package com.merge.api.resources.hris.payrollruns.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.resources.hris.types.PayrollRunsRetrieveRequestRemoteFields;
import com.merge.api.resources.hris.types.PayrollRunsRetrieveRequestShowEnumOrigins;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PayrollRunsRetrieveRequest.Builder.class)
public final class PayrollRunsRetrieveRequest {
    private final Optional<Boolean> includeRemoteData;

    private final Optional<PayrollRunsRetrieveRequestRemoteFields> remoteFields;

    private final Optional<PayrollRunsRetrieveRequestShowEnumOrigins> showEnumOrigins;

    private PayrollRunsRetrieveRequest(
            Optional<Boolean> includeRemoteData,
            Optional<PayrollRunsRetrieveRequestRemoteFields> remoteFields,
            Optional<PayrollRunsRetrieveRequestShowEnumOrigins> showEnumOrigins) {
        this.includeRemoteData = includeRemoteData;
        this.remoteFields = remoteFields;
        this.showEnumOrigins = showEnumOrigins;
    }

    /**
     * @return Whether to include the original data Merge fetched from the third-party to produce these models.
     */
    @JsonProperty("include_remote_data")
    public Optional<Boolean> getIncludeRemoteData() {
        return includeRemoteData;
    }

    /**
     * @return Deprecated. Use show_enum_origins.
     */
    @JsonProperty("remote_fields")
    public Optional<PayrollRunsRetrieveRequestRemoteFields> getRemoteFields() {
        return remoteFields;
    }

    /**
     * @return Which fields should be returned in non-normalized form.
     */
    @JsonProperty("show_enum_origins")
    public Optional<PayrollRunsRetrieveRequestShowEnumOrigins> getShowEnumOrigins() {
        return showEnumOrigins;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PayrollRunsRetrieveRequest && equalTo((PayrollRunsRetrieveRequest) other);
    }

    private boolean equalTo(PayrollRunsRetrieveRequest other) {
        return includeRemoteData.equals(other.includeRemoteData)
                && remoteFields.equals(other.remoteFields)
                && showEnumOrigins.equals(other.showEnumOrigins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.includeRemoteData, this.remoteFields, this.showEnumOrigins);
    }

    @Override
    public String toString() {
        return "PayrollRunsRetrieveRequest{" + "includeRemoteData: " + includeRemoteData + ", remoteFields: "
                + remoteFields + ", showEnumOrigins: " + showEnumOrigins + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<PayrollRunsRetrieveRequestRemoteFields> remoteFields = Optional.empty();

        private Optional<PayrollRunsRetrieveRequestShowEnumOrigins> showEnumOrigins = Optional.empty();

        private Builder() {}

        public Builder from(PayrollRunsRetrieveRequest other) {
            includeRemoteData(other.getIncludeRemoteData());
            remoteFields(other.getRemoteFields());
            showEnumOrigins(other.getShowEnumOrigins());
            return this;
        }

        @JsonSetter(value = "include_remote_data", nulls = Nulls.SKIP)
        public Builder includeRemoteData(Optional<Boolean> includeRemoteData) {
            this.includeRemoteData = includeRemoteData;
            return this;
        }

        public Builder includeRemoteData(Boolean includeRemoteData) {
            this.includeRemoteData = Optional.of(includeRemoteData);
            return this;
        }

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<PayrollRunsRetrieveRequestRemoteFields> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(PayrollRunsRetrieveRequestRemoteFields remoteFields) {
            this.remoteFields = Optional.of(remoteFields);
            return this;
        }

        @JsonSetter(value = "show_enum_origins", nulls = Nulls.SKIP)
        public Builder showEnumOrigins(Optional<PayrollRunsRetrieveRequestShowEnumOrigins> showEnumOrigins) {
            this.showEnumOrigins = showEnumOrigins;
            return this;
        }

        public Builder showEnumOrigins(PayrollRunsRetrieveRequestShowEnumOrigins showEnumOrigins) {
            this.showEnumOrigins = Optional.of(showEnumOrigins);
            return this;
        }

        public PayrollRunsRetrieveRequest build() {
            return new PayrollRunsRetrieveRequest(includeRemoteData, remoteFields, showEnumOrigins);
        }
    }
}
