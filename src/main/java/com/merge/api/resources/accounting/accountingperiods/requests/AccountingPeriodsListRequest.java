package com.merge.api.resources.accounting.accountingperiods.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AccountingPeriodsListRequest.Builder.class)
public final class AccountingPeriodsListRequest {
    private final Optional<String> cursor;

    private final Optional<Boolean> includeDeletedData;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<Integer> pageSize;

    private AccountingPeriodsListRequest(
            Optional<String> cursor,
            Optional<Boolean> includeDeletedData,
            Optional<Boolean> includeRemoteData,
            Optional<Integer> pageSize) {
        this.cursor = cursor;
        this.includeDeletedData = includeDeletedData;
        this.includeRemoteData = includeRemoteData;
        this.pageSize = pageSize;
    }

    /**
     * @return The pagination cursor value.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    /**
     * @return Whether to include data that was marked as deleted by third party webhooks.
     */
    @JsonProperty("include_deleted_data")
    public Optional<Boolean> getIncludeDeletedData() {
        return includeDeletedData;
    }

    /**
     * @return Whether to include the original data Merge fetched from the third-party to produce these models.
     */
    @JsonProperty("include_remote_data")
    public Optional<Boolean> getIncludeRemoteData() {
        return includeRemoteData;
    }

    /**
     * @return Number of results to return per page.
     */
    @JsonProperty("page_size")
    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AccountingPeriodsListRequest && equalTo((AccountingPeriodsListRequest) other);
    }

    private boolean equalTo(AccountingPeriodsListRequest other) {
        return cursor.equals(other.cursor)
                && includeDeletedData.equals(other.includeDeletedData)
                && includeRemoteData.equals(other.includeRemoteData)
                && pageSize.equals(other.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cursor, this.includeDeletedData, this.includeRemoteData, this.pageSize);
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
        private Optional<String> cursor = Optional.empty();

        private Optional<Boolean> includeDeletedData = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<Integer> pageSize = Optional.empty();

        private Builder() {}

        public Builder from(AccountingPeriodsListRequest other) {
            cursor(other.getCursor());
            includeDeletedData(other.getIncludeDeletedData());
            includeRemoteData(other.getIncludeRemoteData());
            pageSize(other.getPageSize());
            return this;
        }

        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.of(cursor);
            return this;
        }

        @JsonSetter(value = "include_deleted_data", nulls = Nulls.SKIP)
        public Builder includeDeletedData(Optional<Boolean> includeDeletedData) {
            this.includeDeletedData = includeDeletedData;
            return this;
        }

        public Builder includeDeletedData(Boolean includeDeletedData) {
            this.includeDeletedData = Optional.of(includeDeletedData);
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

        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.of(pageSize);
            return this;
        }

        public AccountingPeriodsListRequest build() {
            return new AccountingPeriodsListRequest(cursor, includeDeletedData, includeRemoteData, pageSize);
        }
    }
}
