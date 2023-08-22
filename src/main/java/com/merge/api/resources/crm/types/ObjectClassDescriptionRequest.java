package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ObjectClassDescriptionRequest.Builder.class)
public final class ObjectClassDescriptionRequest {
    private final String id;

    private final OriginTypeEnum originType;

    private ObjectClassDescriptionRequest(String id, OriginTypeEnum originType) {
        this.id = id;
        this.originType = originType;
    }

    /**
     * @return &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("origin_type")
    public OriginTypeEnum getOriginType() {
        return originType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ObjectClassDescriptionRequest && equalTo((ObjectClassDescriptionRequest) other);
    }

    private boolean equalTo(ObjectClassDescriptionRequest other) {
        return id.equals(other.id) && originType.equals(other.originType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.originType);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        OriginTypeStage id(String id);

        Builder from(ObjectClassDescriptionRequest other);
    }

    public interface OriginTypeStage {
        _FinalStage originType(OriginTypeEnum originType);
    }

    public interface _FinalStage {
        ObjectClassDescriptionRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, OriginTypeStage, _FinalStage {
        private String id;

        private OriginTypeEnum originType;

        private Builder() {}

        @Override
        public Builder from(ObjectClassDescriptionRequest other) {
            id(other.getId());
            originType(other.getOriginType());
            return this;
        }

        /**
         * <p>&lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public OriginTypeStage id(String id) {
            this.id = id;
            return this;
        }

        @Override
        @JsonSetter("origin_type")
        public _FinalStage originType(OriginTypeEnum originType) {
            this.originType = originType;
            return this;
        }

        @Override
        public ObjectClassDescriptionRequest build() {
            return new ObjectClassDescriptionRequest(id, originType);
        }
    }
}
