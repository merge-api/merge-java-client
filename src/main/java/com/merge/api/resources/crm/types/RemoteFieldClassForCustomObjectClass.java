package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RemoteFieldClassForCustomObjectClass.Builder.class)
public final class RemoteFieldClassForCustomObjectClass {
    private final Optional<String> displayName;

    private final Optional<String> remoteKeyName;

    private final Optional<String> description;

    private final Optional<Boolean> isRequired;

    private final Optional<RemoteFieldClassForCustomObjectClassFieldType> fieldType;

    private final Optional<RemoteFieldClassForCustomObjectClassFieldFormat> fieldFormat;

    private final Optional<List<Optional<String>>> fieldChoices;

    private final Optional<RemoteFieldClassForCustomObjectClassItemSchema> itemSchema;

    private final Optional<OffsetDateTime> modifiedAt;

    private RemoteFieldClassForCustomObjectClass(
            Optional<String> displayName,
            Optional<String> remoteKeyName,
            Optional<String> description,
            Optional<Boolean> isRequired,
            Optional<RemoteFieldClassForCustomObjectClassFieldType> fieldType,
            Optional<RemoteFieldClassForCustomObjectClassFieldFormat> fieldFormat,
            Optional<List<Optional<String>>> fieldChoices,
            Optional<RemoteFieldClassForCustomObjectClassItemSchema> itemSchema,
            Optional<OffsetDateTime> modifiedAt) {
        this.displayName = displayName;
        this.remoteKeyName = remoteKeyName;
        this.description = description;
        this.isRequired = isRequired;
        this.fieldType = fieldType;
        this.fieldFormat = fieldFormat;
        this.fieldChoices = fieldChoices;
        this.itemSchema = itemSchema;
        this.modifiedAt = modifiedAt;
    }

    @JsonProperty("display_name")
    public Optional<String> getDisplayName() {
        return displayName;
    }

    @JsonProperty("remote_key_name")
    public Optional<String> getRemoteKeyName() {
        return remoteKeyName;
    }

    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @JsonProperty("is_required")
    public Optional<Boolean> getIsRequired() {
        return isRequired;
    }

    @JsonProperty("field_type")
    public Optional<RemoteFieldClassForCustomObjectClassFieldType> getFieldType() {
        return fieldType;
    }

    @JsonProperty("field_format")
    public Optional<RemoteFieldClassForCustomObjectClassFieldFormat> getFieldFormat() {
        return fieldFormat;
    }

    @JsonProperty("field_choices")
    public Optional<List<Optional<String>>> getFieldChoices() {
        return fieldChoices;
    }

    @JsonProperty("item_schema")
    public Optional<RemoteFieldClassForCustomObjectClassItemSchema> getItemSchema() {
        return itemSchema;
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
        return other instanceof RemoteFieldClassForCustomObjectClass
                && equalTo((RemoteFieldClassForCustomObjectClass) other);
    }

    private boolean equalTo(RemoteFieldClassForCustomObjectClass other) {
        return displayName.equals(other.displayName)
                && remoteKeyName.equals(other.remoteKeyName)
                && description.equals(other.description)
                && isRequired.equals(other.isRequired)
                && fieldType.equals(other.fieldType)
                && fieldFormat.equals(other.fieldFormat)
                && fieldChoices.equals(other.fieldChoices)
                && itemSchema.equals(other.itemSchema)
                && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.displayName,
                this.remoteKeyName,
                this.description,
                this.isRequired,
                this.fieldType,
                this.fieldFormat,
                this.fieldChoices,
                this.itemSchema,
                this.modifiedAt);
    }

    @Override
    public String toString() {
        return "RemoteFieldClassForCustomObjectClass{" + "displayName: " + displayName + ", remoteKeyName: "
                + remoteKeyName + ", description: " + description + ", isRequired: " + isRequired + ", fieldType: "
                + fieldType + ", fieldFormat: " + fieldFormat + ", fieldChoices: " + fieldChoices + ", itemSchema: "
                + itemSchema + ", modifiedAt: " + modifiedAt + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> displayName = Optional.empty();

        private Optional<String> remoteKeyName = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<Boolean> isRequired = Optional.empty();

        private Optional<RemoteFieldClassForCustomObjectClassFieldType> fieldType = Optional.empty();

        private Optional<RemoteFieldClassForCustomObjectClassFieldFormat> fieldFormat = Optional.empty();

        private Optional<List<Optional<String>>> fieldChoices = Optional.empty();

        private Optional<RemoteFieldClassForCustomObjectClassItemSchema> itemSchema = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(RemoteFieldClassForCustomObjectClass other) {
            displayName(other.getDisplayName());
            remoteKeyName(other.getRemoteKeyName());
            description(other.getDescription());
            isRequired(other.getIsRequired());
            fieldType(other.getFieldType());
            fieldFormat(other.getFieldFormat());
            fieldChoices(other.getFieldChoices());
            itemSchema(other.getItemSchema());
            modifiedAt(other.getModifiedAt());
            return this;
        }

        @JsonSetter(value = "display_name", nulls = Nulls.SKIP)
        public Builder displayName(Optional<String> displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder displayName(String displayName) {
            this.displayName = Optional.of(displayName);
            return this;
        }

        @JsonSetter(value = "remote_key_name", nulls = Nulls.SKIP)
        public Builder remoteKeyName(Optional<String> remoteKeyName) {
            this.remoteKeyName = remoteKeyName;
            return this;
        }

        public Builder remoteKeyName(String remoteKeyName) {
            this.remoteKeyName = Optional.of(remoteKeyName);
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

        @JsonSetter(value = "is_required", nulls = Nulls.SKIP)
        public Builder isRequired(Optional<Boolean> isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        public Builder isRequired(Boolean isRequired) {
            this.isRequired = Optional.of(isRequired);
            return this;
        }

        @JsonSetter(value = "field_type", nulls = Nulls.SKIP)
        public Builder fieldType(Optional<RemoteFieldClassForCustomObjectClassFieldType> fieldType) {
            this.fieldType = fieldType;
            return this;
        }

        public Builder fieldType(RemoteFieldClassForCustomObjectClassFieldType fieldType) {
            this.fieldType = Optional.of(fieldType);
            return this;
        }

        @JsonSetter(value = "field_format", nulls = Nulls.SKIP)
        public Builder fieldFormat(Optional<RemoteFieldClassForCustomObjectClassFieldFormat> fieldFormat) {
            this.fieldFormat = fieldFormat;
            return this;
        }

        public Builder fieldFormat(RemoteFieldClassForCustomObjectClassFieldFormat fieldFormat) {
            this.fieldFormat = Optional.of(fieldFormat);
            return this;
        }

        @JsonSetter(value = "field_choices", nulls = Nulls.SKIP)
        public Builder fieldChoices(Optional<List<Optional<String>>> fieldChoices) {
            this.fieldChoices = fieldChoices;
            return this;
        }

        public Builder fieldChoices(List<Optional<String>> fieldChoices) {
            this.fieldChoices = Optional.of(fieldChoices);
            return this;
        }

        @JsonSetter(value = "item_schema", nulls = Nulls.SKIP)
        public Builder itemSchema(Optional<RemoteFieldClassForCustomObjectClassItemSchema> itemSchema) {
            this.itemSchema = itemSchema;
            return this;
        }

        public Builder itemSchema(RemoteFieldClassForCustomObjectClassItemSchema itemSchema) {
            this.itemSchema = Optional.of(itemSchema);
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

        public RemoteFieldClassForCustomObjectClass build() {
            return new RemoteFieldClassForCustomObjectClass(
                    displayName,
                    remoteKeyName,
                    description,
                    isRequired,
                    fieldType,
                    fieldFormat,
                    fieldChoices,
                    itemSchema,
                    modifiedAt);
        }
    }
}
