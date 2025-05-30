/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

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
@JsonDeserialize(builder = RemoteKey.Builder.class)
public final class RemoteKey {
    private final String name;

    private final String key;

    private final Map<String, Object> additionalProperties;

    private RemoteKey(String name, String key, Map<String, Object> additionalProperties) {
        this.name = name;
        this.key = key;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteKey && equalTo((RemoteKey) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RemoteKey other) {
        return name.equals(other.name) && key.equals(other.key);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.name, this.key);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        KeyStage name(@NotNull String name);

        Builder from(RemoteKey other);
    }

    public interface KeyStage {
        _FinalStage key(@NotNull String key);
    }

    public interface _FinalStage {
        RemoteKey build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, KeyStage, _FinalStage {
        private String name;

        private String key;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(RemoteKey other) {
            name(other.getName());
            key(other.getKey());
            return this;
        }

        @java.lang.Override
        @JsonSetter("name")
        public KeyStage name(@NotNull String name) {
            this.name = name;
            return this;
        }

        @java.lang.Override
        @JsonSetter("key")
        public _FinalStage key(@NotNull String key) {
            this.key = key;
            return this;
        }

        @java.lang.Override
        public RemoteKey build() {
            return new RemoteKey(name, key, additionalProperties);
        }
    }
}
