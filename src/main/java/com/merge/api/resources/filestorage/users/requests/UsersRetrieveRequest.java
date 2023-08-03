package com.merge.api.resources.filestorage.users.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UsersRetrieveRequest.Builder.class)
public final class UsersRetrieveRequest {
    private final Optional<Boolean> includeRemoteData;

    private UsersRetrieveRequest(Optional<Boolean> includeRemoteData) {
        this.includeRemoteData = includeRemoteData;
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
        return other instanceof UsersRetrieveRequest && equalTo((UsersRetrieveRequest) other);
    }

    private boolean equalTo(UsersRetrieveRequest other) {
        return includeRemoteData.equals(other.includeRemoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.includeRemoteData);
    }

    @Override
    public String toString() {
        return "UsersRetrieveRequest{" + "includeRemoteData: " + includeRemoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Builder() {}

        public Builder from(UsersRetrieveRequest other) {
            includeRemoteData(other.getIncludeRemoteData());
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

        public UsersRetrieveRequest build() {
            return new UsersRetrieveRequest(includeRemoteData);
        }
    }
}
