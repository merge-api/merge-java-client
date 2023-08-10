package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TaxRate.Builder.class)
public final class TaxRate {
    private final Optional<String> description;

    private final Optional<Double> totalTaxRate;

    private final Optional<Double> effectiveTaxRate;

    private final Optional<TaxRateCompany> company;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private TaxRate(
            Optional<String> description,
            Optional<Double> totalTaxRate,
            Optional<Double> effectiveTaxRate,
            Optional<TaxRateCompany> company,
            Optional<Boolean> remoteWasDeleted,
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.description = description;
        this.totalTaxRate = totalTaxRate;
        this.effectiveTaxRate = effectiveTaxRate;
        this.company = company;
        this.remoteWasDeleted = remoteWasDeleted;
        this.id = id;
        this.remoteId = remoteId;
        this.modifiedAt = modifiedAt;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
    }

    /**
     * @return The tax rate's description.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The tax rate's total tax rate.
     */
    @JsonProperty("total_tax_rate")
    public Optional<Double> getTotalTaxRate() {
        return totalTaxRate;
    }

    /**
     * @return The tax rate's effective tax rate.
     */
    @JsonProperty("effective_tax_rate")
    public Optional<Double> getEffectiveTaxRate() {
        return effectiveTaxRate;
    }

    /**
     * @return The company the tax rate belongs to.
     */
    @JsonProperty("company")
    public Optional<TaxRateCompany> getCompany() {
        return company;
    }

    /**
     * @return Indicates whether or not this object has been deleted by third party webhooks.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    /**
     * @return This is the datetime that this object was last updated by Merge
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    @JsonProperty("field_mappings")
    public Optional<Map<String, JsonNode>> getFieldMappings() {
        return fieldMappings;
    }

    @JsonProperty("remote_data")
    public Optional<List<RemoteData>> getRemoteData() {
        return remoteData;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TaxRate && equalTo((TaxRate) other);
    }

    private boolean equalTo(TaxRate other) {
        return description.equals(other.description)
                && totalTaxRate.equals(other.totalTaxRate)
                && effectiveTaxRate.equals(other.effectiveTaxRate)
                && company.equals(other.company)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.description,
                this.totalTaxRate,
                this.effectiveTaxRate,
                this.company,
                this.remoteWasDeleted,
                this.id,
                this.remoteId,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "TaxRate{" + "description: " + description + ", totalTaxRate: " + totalTaxRate + ", effectiveTaxRate: "
                + effectiveTaxRate + ", company: " + company + ", remoteWasDeleted: " + remoteWasDeleted + ", id: " + id
                + ", remoteId: " + remoteId + ", modifiedAt: " + modifiedAt + ", fieldMappings: " + fieldMappings
                + ", remoteData: " + remoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> description = Optional.empty();

        private Optional<Double> totalTaxRate = Optional.empty();

        private Optional<Double> effectiveTaxRate = Optional.empty();

        private Optional<TaxRateCompany> company = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(TaxRate other) {
            description(other.getDescription());
            totalTaxRate(other.getTotalTaxRate());
            effectiveTaxRate(other.getEffectiveTaxRate());
            company(other.getCompany());
            remoteWasDeleted(other.getRemoteWasDeleted());
            id(other.getId());
            remoteId(other.getRemoteId());
            modifiedAt(other.getModifiedAt());
            fieldMappings(other.getFieldMappings());
            remoteData(other.getRemoteData());
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @JsonSetter(value = "total_tax_rate", nulls = Nulls.SKIP)
        public Builder totalTaxRate(Optional<Double> totalTaxRate) {
            this.totalTaxRate = totalTaxRate;
            return this;
        }

        public Builder totalTaxRate(Double totalTaxRate) {
            this.totalTaxRate = Optional.of(totalTaxRate);
            return this;
        }

        @JsonSetter(value = "effective_tax_rate", nulls = Nulls.SKIP)
        public Builder effectiveTaxRate(Optional<Double> effectiveTaxRate) {
            this.effectiveTaxRate = effectiveTaxRate;
            return this;
        }

        public Builder effectiveTaxRate(Double effectiveTaxRate) {
            this.effectiveTaxRate = Optional.of(effectiveTaxRate);
            return this;
        }

        @JsonSetter(value = "company", nulls = Nulls.SKIP)
        public Builder company(Optional<TaxRateCompany> company) {
            this.company = company;
            return this;
        }

        public Builder company(TaxRateCompany company) {
            this.company = Optional.of(company);
            return this;
        }

        @JsonSetter(value = "remote_was_deleted", nulls = Nulls.SKIP)
        public Builder remoteWasDeleted(Optional<Boolean> remoteWasDeleted) {
            this.remoteWasDeleted = remoteWasDeleted;
            return this;
        }

        public Builder remoteWasDeleted(Boolean remoteWasDeleted) {
            this.remoteWasDeleted = Optional.of(remoteWasDeleted);
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
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

        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.of(modifiedAt);
            return this;
        }

        @JsonSetter(value = "field_mappings", nulls = Nulls.SKIP)
        public Builder fieldMappings(Optional<Map<String, JsonNode>> fieldMappings) {
            this.fieldMappings = fieldMappings;
            return this;
        }

        public Builder fieldMappings(Map<String, JsonNode> fieldMappings) {
            this.fieldMappings = Optional.of(fieldMappings);
            return this;
        }

        @JsonSetter(value = "remote_data", nulls = Nulls.SKIP)
        public Builder remoteData(Optional<List<RemoteData>> remoteData) {
            this.remoteData = remoteData;
            return this;
        }

        public Builder remoteData(List<RemoteData> remoteData) {
            this.remoteData = Optional.of(remoteData);
            return this;
        }

        public TaxRate build() {
            return new TaxRate(
                    description,
                    totalTaxRate,
                    effectiveTaxRate,
                    company,
                    remoteWasDeleted,
                    id,
                    remoteId,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}
