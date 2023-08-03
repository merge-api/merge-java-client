package com.merge.api.resources.accounting.vendorcredits.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.resources.accounting.types.VendorCreditsRetrieveRequestExpand;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = VendorCreditsRetrieveRequest.Builder.class)
public final class VendorCreditsRetrieveRequest {
    private final Optional<VendorCreditsRetrieveRequestExpand> expand;

    private final Optional<Boolean> includeRemoteData;

    private VendorCreditsRetrieveRequest(
            Optional<VendorCreditsRetrieveRequestExpand> expand, Optional<Boolean> includeRemoteData) {
        this.expand = expand;
        this.includeRemoteData = includeRemoteData;
    }

    /**
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<VendorCreditsRetrieveRequestExpand> getExpand() {
        return expand;
    }

    /**
     * @return Whether to include the original data Merge fetched from the third-party to produce these models.
     */
    @JsonProperty("include_remote_data")
    public Optional<Boolean> getIncludeRemoteData() {
        return includeRemoteData;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof VendorCreditsRetrieveRequest && equalTo((VendorCreditsRetrieveRequest) other);
    }

    private boolean equalTo(VendorCreditsRetrieveRequest other) {
        return expand.equals(other.expand) && includeRemoteData.equals(other.includeRemoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.expand, this.includeRemoteData);
    }

    @Override
    public String toString() {
        return "VendorCreditsRetrieveRequest{" + "expand: " + expand + ", includeRemoteData: " + includeRemoteData
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<VendorCreditsRetrieveRequestExpand> expand = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Builder() {}

        public Builder from(VendorCreditsRetrieveRequest other) {
            expand(other.getExpand());
            includeRemoteData(other.getIncludeRemoteData());
            return this;
        }

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<VendorCreditsRetrieveRequestExpand> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(VendorCreditsRetrieveRequestExpand expand) {
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

        public VendorCreditsRetrieveRequest build() {
            return new VendorCreditsRetrieveRequest(expand, includeRemoteData);
        }
    }
}
