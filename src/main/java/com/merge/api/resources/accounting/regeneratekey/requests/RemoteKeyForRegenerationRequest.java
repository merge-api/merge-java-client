/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.accounting.regeneratekey.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = RemoteKeyForRegenerationRequest.Builder.class)
public final class RemoteKeyForRegenerationRequest {
    private final String name;

    private final Map<String, Object> additionalProperties;

    private RemoteKeyForRegenerationRequest(String name, Map<String, Object> additionalProperties) {
        this.name = name;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The name of the remote key
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteKeyForRegenerationRequest && equalTo((RemoteKeyForRegenerationRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RemoteKeyForRegenerationRequest other) {
        return name.equals(other.name);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(@NotNull String name);

        Builder from(RemoteKeyForRegenerationRequest other);
    }

    public interface _FinalStage {
        RemoteKeyForRegenerationRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(RemoteKeyForRegenerationRequest other) {
            name(other.getName());
            return this;
        }

        /**
         * <p>The name of the remote key</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("name")
        public _FinalStage name(@NotNull String name) {
            this.name = name;
            return this;
        }

        @java.lang.Override
        public RemoteKeyForRegenerationRequest build() {
            return new RemoteKeyForRegenerationRequest(name, additionalProperties);
        }
    }
}
