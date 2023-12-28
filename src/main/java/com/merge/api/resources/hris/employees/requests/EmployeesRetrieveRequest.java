package com.merge.api.resources.hris.employees.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.hris.employees.types.EmployeesRetrieveRequestExpand;
import com.merge.api.resources.hris.employees.types.EmployeesRetrieveRequestRemoteFields;
import com.merge.api.resources.hris.employees.types.EmployeesRetrieveRequestShowEnumOrigins;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EmployeesRetrieveRequest.Builder.class)
public final class EmployeesRetrieveRequest {
    private final Optional<EmployeesRetrieveRequestExpand> expand;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<Boolean> includeSensitiveFields;

    private final Optional<EmployeesRetrieveRequestRemoteFields> remoteFields;

    private final Optional<EmployeesRetrieveRequestShowEnumOrigins> showEnumOrigins;

    private EmployeesRetrieveRequest(
            Optional<EmployeesRetrieveRequestExpand> expand,
            Optional<Boolean> includeRemoteData,
            Optional<Boolean> includeSensitiveFields,
            Optional<EmployeesRetrieveRequestRemoteFields> remoteFields,
            Optional<EmployeesRetrieveRequestShowEnumOrigins> showEnumOrigins) {
        this.expand = expand;
        this.includeRemoteData = includeRemoteData;
        this.includeSensitiveFields = includeSensitiveFields;
        this.remoteFields = remoteFields;
        this.showEnumOrigins = showEnumOrigins;
    }

    /**
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<EmployeesRetrieveRequestExpand> getExpand() {
        return expand;
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

    /**
     * @return Deprecated. Use show_enum_origins.
     */
    @JsonProperty("remote_fields")
    public Optional<EmployeesRetrieveRequestRemoteFields> getRemoteFields() {
        return remoteFields;
    }

    /**
     * @return Which fields should be returned in non-normalized form.
     */
    @JsonProperty("show_enum_origins")
    public Optional<EmployeesRetrieveRequestShowEnumOrigins> getShowEnumOrigins() {
        return showEnumOrigins;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmployeesRetrieveRequest && equalTo((EmployeesRetrieveRequest) other);
    }

    private boolean equalTo(EmployeesRetrieveRequest other) {
        return expand.equals(other.expand)
                && includeRemoteData.equals(other.includeRemoteData)
                && includeSensitiveFields.equals(other.includeSensitiveFields)
                && remoteFields.equals(other.remoteFields)
                && showEnumOrigins.equals(other.showEnumOrigins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.expand,
                this.includeRemoteData,
                this.includeSensitiveFields,
                this.remoteFields,
                this.showEnumOrigins);
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
        private Optional<EmployeesRetrieveRequestExpand> expand = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<Boolean> includeSensitiveFields = Optional.empty();

        private Optional<EmployeesRetrieveRequestRemoteFields> remoteFields = Optional.empty();

        private Optional<EmployeesRetrieveRequestShowEnumOrigins> showEnumOrigins = Optional.empty();

        private Builder() {}

        public Builder from(EmployeesRetrieveRequest other) {
            expand(other.getExpand());
            includeRemoteData(other.getIncludeRemoteData());
            includeSensitiveFields(other.getIncludeSensitiveFields());
            remoteFields(other.getRemoteFields());
            showEnumOrigins(other.getShowEnumOrigins());
            return this;
        }

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<EmployeesRetrieveRequestExpand> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(EmployeesRetrieveRequestExpand expand) {
            this.expand = Optional.of(expand);
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

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<EmployeesRetrieveRequestRemoteFields> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(EmployeesRetrieveRequestRemoteFields remoteFields) {
            this.remoteFields = Optional.of(remoteFields);
            return this;
        }

        @JsonSetter(value = "show_enum_origins", nulls = Nulls.SKIP)
        public Builder showEnumOrigins(Optional<EmployeesRetrieveRequestShowEnumOrigins> showEnumOrigins) {
            this.showEnumOrigins = showEnumOrigins;
            return this;
        }

        public Builder showEnumOrigins(EmployeesRetrieveRequestShowEnumOrigins showEnumOrigins) {
            this.showEnumOrigins = Optional.of(showEnumOrigins);
            return this;
        }

        public EmployeesRetrieveRequest build() {
            return new EmployeesRetrieveRequest(
                    expand, includeRemoteData, includeSensitiveFields, remoteFields, showEnumOrigins);
        }
    }
}
