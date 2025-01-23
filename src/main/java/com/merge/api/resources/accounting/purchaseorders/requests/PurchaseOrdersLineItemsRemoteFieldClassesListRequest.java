/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.accounting.purchaseorders.requests;

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
@JsonDeserialize(builder = PurchaseOrdersLineItemsRemoteFieldClassesListRequest.Builder.class)
public final class PurchaseOrdersLineItemsRemoteFieldClassesListRequest {
    private final Optional<String> cursor;

    private final Optional<Boolean> includeDeletedData;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<Boolean> includeShellData;

    private final Optional<Boolean> isCommonModelField;

    private final Optional<Integer> pageSize;

    private final Map<String, Object> additionalProperties;

    private PurchaseOrdersLineItemsRemoteFieldClassesListRequest(
            Optional<String> cursor,
            Optional<Boolean> includeDeletedData,
            Optional<Boolean> includeRemoteData,
            Optional<Boolean> includeShellData,
            Optional<Boolean> isCommonModelField,
            Optional<Integer> pageSize,
            Map<String, Object> additionalProperties) {
        this.cursor = cursor;
        this.includeDeletedData = includeDeletedData;
        this.includeRemoteData = includeRemoteData;
        this.includeShellData = includeShellData;
        this.isCommonModelField = isCommonModelField;
        this.pageSize = pageSize;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The pagination cursor value.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.
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
     * @return Whether to include shell records. Shell records are empty records (they may contain some metadata but all other fields are null).
     */
    @JsonProperty("include_shell_data")
    public Optional<Boolean> getIncludeShellData() {
        return includeShellData;
    }

    /**
     * @return If provided, will only return remote field classes with this is_common_model_field value
     */
    @JsonProperty("is_common_model_field")
    public Optional<Boolean> getIsCommonModelField() {
        return isCommonModelField;
    }

    /**
     * @return Number of results to return per page.
     */
    @JsonProperty("page_size")
    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PurchaseOrdersLineItemsRemoteFieldClassesListRequest
                && equalTo((PurchaseOrdersLineItemsRemoteFieldClassesListRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PurchaseOrdersLineItemsRemoteFieldClassesListRequest other) {
        return cursor.equals(other.cursor)
                && includeDeletedData.equals(other.includeDeletedData)
                && includeRemoteData.equals(other.includeRemoteData)
                && includeShellData.equals(other.includeShellData)
                && isCommonModelField.equals(other.isCommonModelField)
                && pageSize.equals(other.pageSize);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.cursor,
                this.includeDeletedData,
                this.includeRemoteData,
                this.includeShellData,
                this.isCommonModelField,
                this.pageSize);
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
        private Optional<String> cursor = Optional.empty();

        private Optional<Boolean> includeDeletedData = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<Boolean> includeShellData = Optional.empty();

        private Optional<Boolean> isCommonModelField = Optional.empty();

        private Optional<Integer> pageSize = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(PurchaseOrdersLineItemsRemoteFieldClassesListRequest other) {
            cursor(other.getCursor());
            includeDeletedData(other.getIncludeDeletedData());
            includeRemoteData(other.getIncludeRemoteData());
            includeShellData(other.getIncludeShellData());
            isCommonModelField(other.getIsCommonModelField());
            pageSize(other.getPageSize());
            return this;
        }

        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.ofNullable(cursor);
            return this;
        }

        @JsonSetter(value = "include_deleted_data", nulls = Nulls.SKIP)
        public Builder includeDeletedData(Optional<Boolean> includeDeletedData) {
            this.includeDeletedData = includeDeletedData;
            return this;
        }

        public Builder includeDeletedData(Boolean includeDeletedData) {
            this.includeDeletedData = Optional.ofNullable(includeDeletedData);
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

        @JsonSetter(value = "include_shell_data", nulls = Nulls.SKIP)
        public Builder includeShellData(Optional<Boolean> includeShellData) {
            this.includeShellData = includeShellData;
            return this;
        }

        public Builder includeShellData(Boolean includeShellData) {
            this.includeShellData = Optional.ofNullable(includeShellData);
            return this;
        }

        @JsonSetter(value = "is_common_model_field", nulls = Nulls.SKIP)
        public Builder isCommonModelField(Optional<Boolean> isCommonModelField) {
            this.isCommonModelField = isCommonModelField;
            return this;
        }

        public Builder isCommonModelField(Boolean isCommonModelField) {
            this.isCommonModelField = Optional.ofNullable(isCommonModelField);
            return this;
        }

        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.ofNullable(pageSize);
            return this;
        }

        public PurchaseOrdersLineItemsRemoteFieldClassesListRequest build() {
            return new PurchaseOrdersLineItemsRemoteFieldClassesListRequest(
                    cursor,
                    includeDeletedData,
                    includeRemoteData,
                    includeShellData,
                    isCommonModelField,
                    pageSize,
                    additionalProperties);
        }
    }
}
