/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.hris.types;

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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FieldMappingApiInstanceRemoteField.Builder.class)
public final class FieldMappingApiInstanceRemoteField {
    private final Optional<String> remoteKeyName;

    private final Optional<Map<String, JsonNode>> schema;

    private final FieldMappingApiInstanceRemoteFieldRemoteEndpointInfo remoteEndpointInfo;

    private final Map<String, Object> additionalProperties;

    private FieldMappingApiInstanceRemoteField(
            Optional<String> remoteKeyName,
            Optional<Map<String, JsonNode>> schema,
            FieldMappingApiInstanceRemoteFieldRemoteEndpointInfo remoteEndpointInfo,
            Map<String, Object> additionalProperties) {
        this.remoteKeyName = remoteKeyName;
        this.schema = schema;
        this.remoteEndpointInfo = remoteEndpointInfo;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("remote_key_name")
    public Optional<String> getRemoteKeyName() {
        return remoteKeyName;
    }

    @JsonProperty("schema")
    public Optional<Map<String, JsonNode>> getSchema() {
        return schema;
    }

    @JsonProperty("remote_endpoint_info")
    public FieldMappingApiInstanceRemoteFieldRemoteEndpointInfo getRemoteEndpointInfo() {
        return remoteEndpointInfo;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FieldMappingApiInstanceRemoteField
                && equalTo((FieldMappingApiInstanceRemoteField) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FieldMappingApiInstanceRemoteField other) {
        return remoteKeyName.equals(other.remoteKeyName)
                && schema.equals(other.schema)
                && remoteEndpointInfo.equals(other.remoteEndpointInfo);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.remoteKeyName, this.schema, this.remoteEndpointInfo);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RemoteEndpointInfoStage builder() {
        return new Builder();
    }

    public interface RemoteEndpointInfoStage {
        _FinalStage remoteEndpointInfo(FieldMappingApiInstanceRemoteFieldRemoteEndpointInfo remoteEndpointInfo);

        Builder from(FieldMappingApiInstanceRemoteField other);
    }

    public interface _FinalStage {
        FieldMappingApiInstanceRemoteField build();

        _FinalStage remoteKeyName(Optional<String> remoteKeyName);

        _FinalStage remoteKeyName(String remoteKeyName);

        _FinalStage schema(Optional<Map<String, JsonNode>> schema);

        _FinalStage schema(Map<String, JsonNode> schema);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RemoteEndpointInfoStage, _FinalStage {
        private FieldMappingApiInstanceRemoteFieldRemoteEndpointInfo remoteEndpointInfo;

        private Optional<Map<String, JsonNode>> schema = Optional.empty();

        private Optional<String> remoteKeyName = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(FieldMappingApiInstanceRemoteField other) {
            remoteKeyName(other.getRemoteKeyName());
            schema(other.getSchema());
            remoteEndpointInfo(other.getRemoteEndpointInfo());
            return this;
        }

        @java.lang.Override
        @JsonSetter("remote_endpoint_info")
        public _FinalStage remoteEndpointInfo(FieldMappingApiInstanceRemoteFieldRemoteEndpointInfo remoteEndpointInfo) {
            this.remoteEndpointInfo = remoteEndpointInfo;
            return this;
        }

        @java.lang.Override
        public _FinalStage schema(Map<String, JsonNode> schema) {
            this.schema = Optional.of(schema);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "schema", nulls = Nulls.SKIP)
        public _FinalStage schema(Optional<Map<String, JsonNode>> schema) {
            this.schema = schema;
            return this;
        }

        @java.lang.Override
        public _FinalStage remoteKeyName(String remoteKeyName) {
            this.remoteKeyName = Optional.of(remoteKeyName);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "remote_key_name", nulls = Nulls.SKIP)
        public _FinalStage remoteKeyName(Optional<String> remoteKeyName) {
            this.remoteKeyName = remoteKeyName;
            return this;
        }

        @java.lang.Override
        public FieldMappingApiInstanceRemoteField build() {
            return new FieldMappingApiInstanceRemoteField(
                    remoteKeyName, schema, remoteEndpointInfo, additionalProperties);
        }
    }
}
