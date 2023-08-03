package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RemoteKey.Builder.class)
public final class RemoteKey {
    private final String name;

    private final String key;

    private RemoteKey(String name, String key) {
        this.name = name;
        this.key = key;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteKey && equalTo((RemoteKey) other);
    }

    private boolean equalTo(RemoteKey other) {
        return name.equals(other.name) && key.equals(other.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.key);
    }

    @Override
    public String toString() {
        return "RemoteKey{" + "name: " + name + ", key: " + key + "}";
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        KeyStage name(String name);

        Builder from(RemoteKey other);
    }

    public interface KeyStage {
        _FinalStage key(String key);
    }

    public interface _FinalStage {
        RemoteKey build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, KeyStage, _FinalStage {
        private String name;

        private String key;

        private Builder() {}

        @Override
        public Builder from(RemoteKey other) {
            name(other.getName());
            key(other.getKey());
            return this;
        }

        @Override
        @JsonSetter("name")
        public KeyStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("key")
        public _FinalStage key(String key) {
            this.key = key;
            return this;
        }

        @Override
        public RemoteKey build() {
            return new RemoteKey(name, key);
        }
    }
}
