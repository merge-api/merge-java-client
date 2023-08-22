package com.merge.api.resources.filestorage.generatekey.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GenerateRemoteKeyRequest.Builder.class)
public final class GenerateRemoteKeyRequest {
    private final String name;

    private GenerateRemoteKeyRequest(String name) {
        this.name = name;
    }

    /**
     * @return &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GenerateRemoteKeyRequest && equalTo((GenerateRemoteKeyRequest) other);
    }

    private boolean equalTo(GenerateRemoteKeyRequest other) {
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(String name);

        Builder from(GenerateRemoteKeyRequest other);
    }

    public interface _FinalStage {
        GenerateRemoteKeyRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Builder() {}

        @Override
        public Builder from(GenerateRemoteKeyRequest other) {
            name(other.getName());
            return this;
        }

        /**
         * <p>&lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public GenerateRemoteKeyRequest build() {
            return new GenerateRemoteKeyRequest(name);
        }
    }
}
