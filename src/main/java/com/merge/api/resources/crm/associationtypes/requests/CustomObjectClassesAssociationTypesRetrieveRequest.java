/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.crm.associationtypes.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CustomObjectClassesAssociationTypesRetrieveRequest.Builder.class)
public final class CustomObjectClassesAssociationTypesRetrieveRequest {
    private final Optional<String> expand;

    private final Optional<Boolean> includeRemoteData;

    private final Map<String, Object> additionalProperties;

    private CustomObjectClassesAssociationTypesRetrieveRequest(
            Optional<String> expand, Optional<Boolean> includeRemoteData, Map<String, Object> additionalProperties) {
        this.expand = expand;
        this.includeRemoteData = includeRemoteData;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<String> getExpand() {
        return expand;
    }

    /**
     * @return Whether to include the original data Merge fetched from the third-party to produce these models.
     */
    @JsonProperty("include_remote_data")
    public Optional<Boolean> getIncludeRemoteData() {
        return includeRemoteData;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CustomObjectClassesAssociationTypesRetrieveRequest
                && equalTo((CustomObjectClassesAssociationTypesRetrieveRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CustomObjectClassesAssociationTypesRetrieveRequest other) {
        return expand.equals(other.expand) && includeRemoteData.equals(other.includeRemoteData);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.expand, this.includeRemoteData);
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
        private Optional<String> expand = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CustomObjectClassesAssociationTypesRetrieveRequest other) {
            expand(other.getExpand());
            includeRemoteData(other.getIncludeRemoteData());
            return this;
        }

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<String> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(String expand) {
            this.expand = Optional.ofNullable(expand);
            return this;
        }

        @JsonSetter(value = "include_remote_data", nulls = Nulls.SKIP)
        public Builder includeRemoteData(Optional<Boolean> includeRemoteData) {
            this.includeRemoteData = includeRemoteData;
            return this;
        }

        public Builder includeRemoteData(Boolean includeRemoteData) {
            this.includeRemoteData = Optional.ofNullable(includeRemoteData);
            return this;
        }

        public CustomObjectClassesAssociationTypesRetrieveRequest build() {
            return new CustomObjectClassesAssociationTypesRetrieveRequest(
                    expand, includeRemoteData, additionalProperties);
        }
    }
}
