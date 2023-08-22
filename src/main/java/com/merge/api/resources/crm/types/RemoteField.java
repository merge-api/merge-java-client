package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RemoteField.Builder.class)
public final class RemoteField {
    private final RemoteFieldRemoteFieldClass remoteFieldClass;

    private final Optional<JsonNode> value;

    private RemoteField(RemoteFieldRemoteFieldClass remoteFieldClass, Optional<JsonNode> value) {
        this.remoteFieldClass = remoteFieldClass;
        this.value = value;
    }

    @JsonProperty("remote_field_class")
    public RemoteFieldRemoteFieldClass getRemoteFieldClass() {
        return remoteFieldClass;
    }

    @JsonProperty("value")
    public Optional<JsonNode> getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteField && equalTo((RemoteField) other);
    }

    private boolean equalTo(RemoteField other) {
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
        _FinalStage remoteFieldClass(RemoteFieldRemoteFieldClass remoteFieldClass);

        Builder from(RemoteField other);
    }

    public interface _FinalStage {
        RemoteField build();

        _FinalStage value(Optional<JsonNode> value);

        _FinalStage value(JsonNode value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RemoteFieldClassStage, _FinalStage {
        private RemoteFieldRemoteFieldClass remoteFieldClass;

        private Optional<JsonNode> value = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(RemoteField other) {
            remoteFieldClass(other.getRemoteFieldClass());
            value(other.getValue());
            return this;
        }

        @Override
        @JsonSetter("remote_field_class")
        public _FinalStage remoteFieldClass(RemoteFieldRemoteFieldClass remoteFieldClass) {
            this.remoteFieldClass = remoteFieldClass;
            return this;
        }

        @Override
        public _FinalStage value(JsonNode value) {
            this.value = Optional.of(value);
            return this;
        }

        @Override
        @JsonSetter(value = "value", nulls = Nulls.SKIP)
        public _FinalStage value(Optional<JsonNode> value) {
            this.value = value;
            return this;
        }

        @Override
        public RemoteField build() {
            return new RemoteField(remoteFieldClass, value);
        }
    }
}
