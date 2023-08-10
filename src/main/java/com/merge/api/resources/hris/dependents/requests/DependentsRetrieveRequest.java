package com.merge.api.resources.hris.dependents.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DependentsRetrieveRequest.Builder.class)
public final class DependentsRetrieveRequest {
    private final Optional<Boolean> includeRemoteData;

    private final Optional<Boolean> includeSensitiveFields;

    private DependentsRetrieveRequest(Optional<Boolean> includeRemoteData, Optional<Boolean> includeSensitiveFields) {
        this.includeRemoteData = includeRemoteData;
        this.includeSensitiveFields = includeSensitiveFields;
    }

    /**
     * @return Whether to include the original data Merge fetched from the third-party to produce these models.
     */
    @JsonProperty("include_remote_data")
    public Optional<Boolean> getIncludeRemoteData() {
        return includeRemoteData;
    }

    /**
     * @return Whether to include sensitive fields (such as social security numbers) in the response.
     */
    @JsonProperty("include_sensitive_fields")
    public Optional<Boolean> getIncludeSensitiveFields() {
        return includeSensitiveFields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DependentsRetrieveRequest && equalTo((DependentsRetrieveRequest) other);
    }

    private boolean equalTo(DependentsRetrieveRequest other) {
        return includeRemoteData.equals(other.includeRemoteData)
                && includeSensitiveFields.equals(other.includeSensitiveFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.includeRemoteData, this.includeSensitiveFields);
    }

    @Override
    public String toString() {
        return "DependentsRetrieveRequest{" + "includeRemoteData: " + includeRemoteData + ", includeSensitiveFields: "
                + includeSensitiveFields + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<Boolean> includeSensitiveFields = Optional.empty();

        private Builder() {}

        public Builder from(DependentsRetrieveRequest other) {
            includeRemoteData(other.getIncludeRemoteData());
            includeSensitiveFields(other.getIncludeSensitiveFields());
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

        @JsonSetter(value = "include_sensitive_fields", nulls = Nulls.SKIP)
        public Builder includeSensitiveFields(Optional<Boolean> includeSensitiveFields) {
            this.includeSensitiveFields = includeSensitiveFields;
            return this;
        }

        public Builder includeSensitiveFields(Boolean includeSensitiveFields) {
            this.includeSensitiveFields = Optional.of(includeSensitiveFields);
            return this;
        }

        public DependentsRetrieveRequest build() {
            return new DependentsRetrieveRequest(includeRemoteData, includeSensitiveFields);
        }
    }
}
