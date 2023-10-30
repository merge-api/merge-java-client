package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ReportItem.Builder.class)
public final class ReportItem {
    private final Optional<String> remoteId;

    private final Optional<String> name;

    private final Optional<Double> value;

    private final Optional<List<Map<String, JsonNode>>> subItems;

    private final Optional<String> company;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private ReportItem(
            Optional<String> remoteId,
            Optional<String> name,
            Optional<Double> value,
            Optional<List<Map<String, JsonNode>>> subItems,
            Optional<String> company,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt) {
        this.remoteId = remoteId;
        this.name = name;
        this.value = value;
        this.subItems = subItems;
        this.company = company;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    /**
     * @return The report item's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The report item's value.
     */
    @JsonProperty("value")
    public Optional<Double> getValue() {
        return value;
    }

    @JsonProperty("sub_items")
    public Optional<List<Map<String, JsonNode>>> getSubItems() {
        return subItems;
    }

    /**
     * @return The company the report item belongs to.
     */
    @JsonProperty("company")
    public Optional<String> getCompany() {
        return company;
    }

    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return This is the datetime that this object was last updated by Merge
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ReportItem && equalTo((ReportItem) other);
    }

    private boolean equalTo(ReportItem other) {
        return remoteId.equals(other.remoteId)
                && name.equals(other.name)
                && value.equals(other.value)
                && subItems.equals(other.subItems)
                && company.equals(other.company)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.remoteId, this.name, this.value, this.subItems, this.company, this.createdAt, this.modifiedAt);
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
        private Optional<String> remoteId = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<Double> value = Optional.empty();

        private Optional<List<Map<String, JsonNode>>> subItems = Optional.empty();

        private Optional<String> company = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(ReportItem other) {
            remoteId(other.getRemoteId());
            name(other.getName());
            value(other.getValue());
            subItems(other.getSubItems());
            company(other.getCompany());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            return this;
        }

        @JsonSetter(value = "remote_id", nulls = Nulls.SKIP)
        public Builder remoteId(Optional<String> remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder remoteId(String remoteId) {
            this.remoteId = Optional.of(remoteId);
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "value", nulls = Nulls.SKIP)
        public Builder value(Optional<Double> value) {
            this.value = value;
            return this;
        }

        public Builder value(Double value) {
            this.value = Optional.of(value);
            return this;
        }

        @JsonSetter(value = "sub_items", nulls = Nulls.SKIP)
        public Builder subItems(Optional<List<Map<String, JsonNode>>> subItems) {
            this.subItems = subItems;
            return this;
        }

        public Builder subItems(List<Map<String, JsonNode>> subItems) {
            this.subItems = Optional.of(subItems);
            return this;
        }

        @JsonSetter(value = "company", nulls = Nulls.SKIP)
        public Builder company(Optional<String> company) {
            this.company = company;
            return this;
        }

        public Builder company(String company) {
            this.company = Optional.of(company);
            return this;
        }

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.of(createdAt);
            return this;
        }

        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.of(modifiedAt);
            return this;
        }

        public ReportItem build() {
            return new ReportItem(remoteId, name, value, subItems, company, createdAt, modifiedAt);
        }
    }
}
