package com.merge.api.resources.accounting.payments.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.accounting.types.PaymentsRetrieveRequestExpand;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PaymentsRetrieveRequest.Builder.class)
public final class PaymentsRetrieveRequest {
    private final Optional<PaymentsRetrieveRequestExpand> expand;

    private final Optional<Boolean> includeRemoteData;

    private PaymentsRetrieveRequest(
            Optional<PaymentsRetrieveRequestExpand> expand, Optional<Boolean> includeRemoteData) {
        this.expand = expand;
        this.includeRemoteData = includeRemoteData;
    }

    /**
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<PaymentsRetrieveRequestExpand> getExpand() {
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
        return other instanceof PaymentsRetrieveRequest && equalTo((PaymentsRetrieveRequest) other);
    }

    private boolean equalTo(PaymentsRetrieveRequest other) {
        return expand.equals(other.expand) && includeRemoteData.equals(other.includeRemoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.expand, this.includeRemoteData);
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
        private Optional<PaymentsRetrieveRequestExpand> expand = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Builder() {}

        public Builder from(PaymentsRetrieveRequest other) {
            expand(other.getExpand());
            includeRemoteData(other.getIncludeRemoteData());
            return this;
        }

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<PaymentsRetrieveRequestExpand> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(PaymentsRetrieveRequestExpand expand) {
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

        public PaymentsRetrieveRequest build() {
            return new PaymentsRetrieveRequest(expand, includeRemoteData);
        }
    }
}
