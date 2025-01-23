/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = RemoteFieldApi.Builder.class)
public final class RemoteFieldApi {
    private final Map<String, JsonNode> schema;

    private final String remoteKeyName;

    private final RemoteEndpointInfo remoteEndpointInfo;

    private final Optional<List<JsonNode>> exampleValues;

    private final Optional<AdvancedMetadata> advancedMetadata;

    private final Optional<RemoteFieldApiCoverage> coverage;

    private final Map<String, Object> additionalProperties;

    private RemoteFieldApi(
            Map<String, JsonNode> schema,
            String remoteKeyName,
            RemoteEndpointInfo remoteEndpointInfo,
            Optional<List<JsonNode>> exampleValues,
            Optional<AdvancedMetadata> advancedMetadata,
            Optional<RemoteFieldApiCoverage> coverage,
            Map<String, Object> additionalProperties) {
        this.schema = schema;
        this.remoteKeyName = remoteKeyName;
        this.remoteEndpointInfo = remoteEndpointInfo;
        this.exampleValues = exampleValues;
        this.advancedMetadata = advancedMetadata;
        this.coverage = coverage;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("schema")
    public Map<String, JsonNode> getSchema() {
        return schema;
    }

    @JsonProperty("remote_key_name")
    public String getRemoteKeyName() {
        return remoteKeyName;
    }

    @JsonProperty("remote_endpoint_info")
    public RemoteEndpointInfo getRemoteEndpointInfo() {
        return remoteEndpointInfo;
    }

    @JsonProperty("example_values")
    public Optional<List<JsonNode>> getExampleValues() {
        return exampleValues;
    }

    @JsonProperty("advanced_metadata")
    public Optional<AdvancedMetadata> getAdvancedMetadata() {
        return advancedMetadata;
    }

    @JsonProperty("coverage")
    public Optional<RemoteFieldApiCoverage> getCoverage() {
        return coverage;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteFieldApi && equalTo((RemoteFieldApi) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RemoteFieldApi other) {
        return schema.equals(other.schema)
                && remoteKeyName.equals(other.remoteKeyName)
                && remoteEndpointInfo.equals(other.remoteEndpointInfo)
                && exampleValues.equals(other.exampleValues)
                && advancedMetadata.equals(other.advancedMetadata)
                && coverage.equals(other.coverage);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.schema,
                this.remoteKeyName,
                this.remoteEndpointInfo,
                this.exampleValues,
                this.advancedMetadata,
                this.coverage);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RemoteKeyNameStage builder() {
        return new Builder();
    }

    public interface RemoteKeyNameStage {
        RemoteEndpointInfoStage remoteKeyName(@NotNull String remoteKeyName);

        Builder from(RemoteFieldApi other);
    }

    public interface RemoteEndpointInfoStage {
        _FinalStage remoteEndpointInfo(@NotNull RemoteEndpointInfo remoteEndpointInfo);
    }

    public interface _FinalStage {
        RemoteFieldApi build();

        _FinalStage schema(Map<String, JsonNode> schema);

        _FinalStage putAllSchema(Map<String, JsonNode> schema);

        _FinalStage schema(String key, JsonNode value);

        _FinalStage exampleValues(Optional<List<JsonNode>> exampleValues);

        _FinalStage exampleValues(List<JsonNode> exampleValues);

        _FinalStage advancedMetadata(Optional<AdvancedMetadata> advancedMetadata);

        _FinalStage advancedMetadata(AdvancedMetadata advancedMetadata);

        _FinalStage coverage(Optional<RemoteFieldApiCoverage> coverage);

        _FinalStage coverage(RemoteFieldApiCoverage coverage);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RemoteKeyNameStage, RemoteEndpointInfoStage, _FinalStage {
        private String remoteKeyName;

        private RemoteEndpointInfo remoteEndpointInfo;

        private Optional<RemoteFieldApiCoverage> coverage = Optional.empty();

        private Optional<AdvancedMetadata> advancedMetadata = Optional.empty();

        private Optional<List<JsonNode>> exampleValues = Optional.empty();

        private Map<String, JsonNode> schema = new LinkedHashMap<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(RemoteFieldApi other) {
            schema(other.getSchema());
            remoteKeyName(other.getRemoteKeyName());
            remoteEndpointInfo(other.getRemoteEndpointInfo());
            exampleValues(other.getExampleValues());
            advancedMetadata(other.getAdvancedMetadata());
            coverage(other.getCoverage());
            return this;
        }

        @java.lang.Override
        @JsonSetter("remote_key_name")
        public RemoteEndpointInfoStage remoteKeyName(@NotNull String remoteKeyName) {
            this.remoteKeyName = remoteKeyName;
            return this;
        }

        @java.lang.Override
        @JsonSetter("remote_endpoint_info")
        public _FinalStage remoteEndpointInfo(@NotNull RemoteEndpointInfo remoteEndpointInfo) {
            this.remoteEndpointInfo = remoteEndpointInfo;
            return this;
        }

        @java.lang.Override
        public _FinalStage coverage(RemoteFieldApiCoverage coverage) {
            this.coverage = Optional.ofNullable(coverage);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "coverage", nulls = Nulls.SKIP)
        public _FinalStage coverage(Optional<RemoteFieldApiCoverage> coverage) {
            this.coverage = coverage;
            return this;
        }

        @java.lang.Override
        public _FinalStage advancedMetadata(AdvancedMetadata advancedMetadata) {
            this.advancedMetadata = Optional.ofNullable(advancedMetadata);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "advanced_metadata", nulls = Nulls.SKIP)
        public _FinalStage advancedMetadata(Optional<AdvancedMetadata> advancedMetadata) {
            this.advancedMetadata = advancedMetadata;
            return this;
        }

        @java.lang.Override
        public _FinalStage exampleValues(List<JsonNode> exampleValues) {
            this.exampleValues = Optional.ofNullable(exampleValues);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "example_values", nulls = Nulls.SKIP)
        public _FinalStage exampleValues(Optional<List<JsonNode>> exampleValues) {
            this.exampleValues = exampleValues;
            return this;
        }

        @java.lang.Override
        public _FinalStage schema(String key, JsonNode value) {
            this.schema.put(key, value);
            return this;
        }

        @java.lang.Override
        public _FinalStage putAllSchema(Map<String, JsonNode> schema) {
            this.schema.putAll(schema);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "schema", nulls = Nulls.SKIP)
        public _FinalStage schema(Map<String, JsonNode> schema) {
            this.schema.clear();
            this.schema.putAll(schema);
            return this;
        }

        @java.lang.Override
        public RemoteFieldApi build() {
            return new RemoteFieldApi(
                    schema,
                    remoteKeyName,
                    remoteEndpointInfo,
                    exampleValues,
                    advancedMetadata,
                    coverage,
                    additionalProperties);
        }
    }
}
