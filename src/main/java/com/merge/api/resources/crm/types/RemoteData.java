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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = RemoteData.Builder.class)
public final class RemoteData {
    private final String path;

    private final Optional<JsonNode> data;

    private final Map<String, Object> additionalProperties;

    private RemoteData(String path, Optional<JsonNode> data, Map<String, Object> additionalProperties) {
        this.path = path;
        this.data = data;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The third-party API path that is being called.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("data")
    public Optional<JsonNode> getData() {
        return data;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteData && equalTo((RemoteData) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RemoteData other) {
        return path.equals(other.path) && data.equals(other.data);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.path, this.data);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PathStage builder() {
        return new Builder();
    }

    public interface PathStage {
        _FinalStage path(@NotNull String path);

        Builder from(RemoteData other);
    }

    public interface _FinalStage {
        RemoteData build();

        _FinalStage data(Optional<JsonNode> data);

        _FinalStage data(JsonNode data);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PathStage, _FinalStage {
        private String path;

        private Optional<JsonNode> data = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(RemoteData other) {
            path(other.getPath());
            data(other.getData());
            return this;
        }

        /**
         * <p>The third-party API path that is being called.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("path")
        public _FinalStage path(@NotNull String path) {
            this.path = path;
            return this;
        }

        @java.lang.Override
        public _FinalStage data(JsonNode data) {
            this.data = Optional.ofNullable(data);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public _FinalStage data(Optional<JsonNode> data) {
            this.data = data;
            return this;
        }

        @java.lang.Override
        public RemoteData build() {
            return new RemoteData(path, data, additionalProperties);
        }
    }
}
