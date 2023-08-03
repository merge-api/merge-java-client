package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CustomObjectRequest.Builder.class)
public final class CustomObjectRequest {
    private final Map<String, JsonNode> fields;

    private CustomObjectRequest(Map<String, JsonNode> fields) {
        this.fields = fields;
    }

    @JsonProperty("fields")
    public Map<String, JsonNode> getFields() {
        return fields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CustomObjectRequest && equalTo((CustomObjectRequest) other);
    }

    private boolean equalTo(CustomObjectRequest other) {
        return fields.equals(other.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fields);
    }

    @Override
    public String toString() {
        return "CustomObjectRequest{" + "fields: " + fields + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Map<String, JsonNode> fields = new LinkedHashMap<>();

        private Builder() {}

        public Builder from(CustomObjectRequest other) {
            fields(other.getFields());
            return this;
        }

        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public Builder fields(Map<String, JsonNode> fields) {
            this.fields.clear();
            this.fields.putAll(fields);
            return this;
        }

        public Builder putAllFields(Map<String, JsonNode> fields) {
            this.fields.putAll(fields);
            return this;
        }

        public Builder fields(String key, JsonNode value) {
            this.fields.put(key, value);
            return this;
        }

        public CustomObjectRequest build() {
            return new CustomObjectRequest(fields);
        }
    }
}
