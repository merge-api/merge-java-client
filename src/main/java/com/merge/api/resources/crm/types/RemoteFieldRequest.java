package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RemoteFieldRequest.Builder.class)
public final class RemoteFieldRequest {
    private final RemoteFieldRequestRemoteFieldClass remoteFieldClass;

    private final Optional<Map<String, JsonNode>> value;

    private RemoteFieldRequest(
            RemoteFieldRequestRemoteFieldClass remoteFieldClass, Optional<Map<String, JsonNode>> value) {
        this.remoteFieldClass = remoteFieldClass;
        this.value = value;
    }

    @JsonProperty("remote_field_class")
    public RemoteFieldRequestRemoteFieldClass getRemoteFieldClass() {
        return remoteFieldClass;
    }

    @JsonProperty("value")
    public Optional<Map<String, JsonNode>> getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteFieldRequest && equalTo((RemoteFieldRequest) other);
    }

    private boolean equalTo(RemoteFieldRequest other) {
        return remoteFieldClass.equals(other.remoteFieldClass) && value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.remoteFieldClass, this.value);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RemoteFieldClassStage builder() {
        return new Builder();
    }

    public interface RemoteFieldClassStage {
        _FinalStage remoteFieldClass(RemoteFieldRequestRemoteFieldClass remoteFieldClass);

        Builder from(RemoteFieldRequest other);
    }

    public interface _FinalStage {
        RemoteFieldRequest build();

        _FinalStage value(Optional<Map<String, JsonNode>> value);

        _FinalStage value(Map<String, JsonNode> value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RemoteFieldClassStage, _FinalStage {
        private RemoteFieldRequestRemoteFieldClass remoteFieldClass;

        private Optional<Map<String, JsonNode>> value = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(RemoteFieldRequest other) {
            remoteFieldClass(other.getRemoteFieldClass());
            value(other.getValue());
            return this;
        }

        @Override
        @JsonSetter("remote_field_class")
        public _FinalStage remoteFieldClass(RemoteFieldRequestRemoteFieldClass remoteFieldClass) {
            this.remoteFieldClass = remoteFieldClass;
            return this;
        }

        @Override
        public _FinalStage value(Map<String, JsonNode> value) {
            this.value = Optional.of(value);
            return this;
        }

        @Override
        @JsonSetter(value = "value", nulls = Nulls.SKIP)
        public _FinalStage value(Optional<Map<String, JsonNode>> value) {
            this.value = value;
            return this;
        }

        @Override
        public RemoteFieldRequest build() {
            return new RemoteFieldRequest(remoteFieldClass, value);
        }
    }
}
