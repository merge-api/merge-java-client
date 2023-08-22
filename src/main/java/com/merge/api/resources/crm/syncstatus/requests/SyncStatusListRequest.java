package com.merge.api.resources.crm.syncstatus.requests;

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
@JsonDeserialize(builder = SyncStatusListRequest.Builder.class)
public final class SyncStatusListRequest {
    private final Optional<String> cursor;

    private final Optional<Integer> pageSize;

    private SyncStatusListRequest(Optional<String> cursor, Optional<Integer> pageSize) {
        this.cursor = cursor;
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
     * @return Number of results to return per page.
     */
    @JsonProperty("page_size")
    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SyncStatusListRequest && equalTo((SyncStatusListRequest) other);
    }

    private boolean equalTo(SyncStatusListRequest other) {
        return cursor.equals(other.cursor) && pageSize.equals(other.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cursor, this.pageSize);
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

        private Optional<Integer> pageSize = Optional.empty();

        private Builder() {}

        public Builder from(SyncStatusListRequest other) {
            cursor(other.getCursor());
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

        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.of(pageSize);
            return this;
        }

        public SyncStatusListRequest build() {
            return new SyncStatusListRequest(cursor, pageSize);
        }
    }
}
