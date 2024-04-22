/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ats.offers.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.ats.offers.types.OffersRetrieveRequestExpand;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = OffersRetrieveRequest.Builder.class)
public final class OffersRetrieveRequest {
    private final Optional<OffersRetrieveRequestExpand> expand;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<String> remoteFields;

    private final Optional<String> showEnumOrigins;

    private final Map<String, Object> additionalProperties;

    private OffersRetrieveRequest(
            Optional<OffersRetrieveRequestExpand> expand,
            Optional<Boolean> includeRemoteData,
            Optional<String> remoteFields,
            Optional<String> showEnumOrigins,
            Map<String, Object> additionalProperties) {
        this.expand = expand;
        this.includeRemoteData = includeRemoteData;
        this.remoteFields = remoteFields;
        this.showEnumOrigins = showEnumOrigins;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<OffersRetrieveRequestExpand> getExpand() {
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
     * @return Deprecated. Use show_enum_origins.
     */
    @JsonProperty("remote_fields")
    public Optional<String> getRemoteFields() {
        return remoteFields;
    }

    /**
     * @return A comma separated list of enum field names for which you'd like the original values to be returned, instead of Merge's normalized enum values. <a href="https://help.merge.dev/en/articles/8950958-show_enum_origins-query-parameter">Learn more</a>
     */
    @JsonProperty("show_enum_origins")
    public Optional<String> getShowEnumOrigins() {
        return showEnumOrigins;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OffersRetrieveRequest && equalTo((OffersRetrieveRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(OffersRetrieveRequest other) {
        return expand.equals(other.expand)
                && includeRemoteData.equals(other.includeRemoteData)
                && remoteFields.equals(other.remoteFields)
                && showEnumOrigins.equals(other.showEnumOrigins);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.expand, this.includeRemoteData, this.remoteFields, this.showEnumOrigins);
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
        private Optional<OffersRetrieveRequestExpand> expand = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<String> remoteFields = Optional.empty();

        private Optional<String> showEnumOrigins = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(OffersRetrieveRequest other) {
            expand(other.getExpand());
            includeRemoteData(other.getIncludeRemoteData());
            remoteFields(other.getRemoteFields());
            showEnumOrigins(other.getShowEnumOrigins());
            return this;
        }

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<OffersRetrieveRequestExpand> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(OffersRetrieveRequestExpand expand) {
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

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<String> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(String remoteFields) {
            this.remoteFields = Optional.of(remoteFields);
            return this;
        }

        @JsonSetter(value = "show_enum_origins", nulls = Nulls.SKIP)
        public Builder showEnumOrigins(Optional<String> showEnumOrigins) {
            this.showEnumOrigins = showEnumOrigins;
            return this;
        }

        public Builder showEnumOrigins(String showEnumOrigins) {
            this.showEnumOrigins = Optional.of(showEnumOrigins);
            return this;
        }

        public OffersRetrieveRequest build() {
            return new OffersRetrieveRequest(
                    expand, includeRemoteData, remoteFields, showEnumOrigins, additionalProperties);
        }
    }
}
