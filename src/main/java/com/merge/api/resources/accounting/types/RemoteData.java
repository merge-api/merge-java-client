package com.merge.api.resources.accounting.types;

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
@JsonDeserialize(builder = RemoteData.Builder.class)
public final class RemoteData {
    private final String path;

    private final Optional<Map<String, JsonNode>> data;

    private RemoteData(String path, Optional<Map<String, JsonNode>> data) {
        this.path = path;
        this.data = data;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("data")
    public Optional<Map<String, JsonNode>> getData() {
        return data;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteData && equalTo((RemoteData) other);
    }

    private boolean equalTo(RemoteData other) {
        return path.equals(other.path) && data.equals(other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.path, this.data);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PathStage builder() {
        return new Builder();
    }

    public interface PathStage {
        _FinalStage path(String path);

        Builder from(RemoteData other);
    }

    public interface _FinalStage {
        RemoteData build();

        _FinalStage data(Optional<Map<String, JsonNode>> data);

        _FinalStage data(Map<String, JsonNode> data);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PathStage, _FinalStage {
        private String path;

        private Optional<Map<String, JsonNode>> data = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(RemoteData other) {
            path(other.getPath());
            data(other.getData());
            return this;
        }

        @Override
        @JsonSetter("path")
        public _FinalStage path(String path) {
            this.path = path;
            return this;
        }

        @Override
        public _FinalStage data(Map<String, JsonNode> data) {
            this.data = Optional.of(data);
            return this;
        }

        @Override
        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public _FinalStage data(Optional<Map<String, JsonNode>> data) {
            this.data = data;
            return this;
        }

        @Override
        public RemoteData build() {
            return new RemoteData(path, data);
        }
    }
}
