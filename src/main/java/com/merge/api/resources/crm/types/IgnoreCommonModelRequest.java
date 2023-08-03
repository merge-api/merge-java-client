package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = IgnoreCommonModelRequest.Builder.class)
public final class IgnoreCommonModelRequest {
    private final ReasonEnum reason;

    private final Optional<String> message;

    private IgnoreCommonModelRequest(ReasonEnum reason, Optional<String> message) {
        this.reason = reason;
        this.message = message;
    }

    @JsonProperty("reason")
    public ReasonEnum getReason() {
        return reason;
    }

    /**
     * @return &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt; &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>&lt;= 256 characters</code>&lt;/span&gt;
     */
    @JsonProperty("message")
    public Optional<String> getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof IgnoreCommonModelRequest && equalTo((IgnoreCommonModelRequest) other);
    }

    private boolean equalTo(IgnoreCommonModelRequest other) {
        return reason.equals(other.reason) && message.equals(other.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.reason, this.message);
    }

    @Override
    public String toString() {
        return "IgnoreCommonModelRequest{" + "reason: " + reason + ", message: " + message + "}";
    }

    public static ReasonStage builder() {
        return new Builder();
    }

    public interface ReasonStage {
        _FinalStage reason(ReasonEnum reason);

        Builder from(IgnoreCommonModelRequest other);
    }

    public interface _FinalStage {
        IgnoreCommonModelRequest build();

        _FinalStage message(Optional<String> message);

        _FinalStage message(String message);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ReasonStage, _FinalStage {
        private ReasonEnum reason;

        private Optional<String> message = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(IgnoreCommonModelRequest other) {
            reason(other.getReason());
            message(other.getMessage());
            return this;
        }

        @Override
        @JsonSetter("reason")
        public _FinalStage reason(ReasonEnum reason) {
            this.reason = reason;
            return this;
        }

        /**
         * <p>&lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt; &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>&lt;= 256 characters</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage message(String message) {
            this.message = Optional.of(message);
            return this;
        }

        @Override
        @JsonSetter(value = "message", nulls = Nulls.SKIP)
        public _FinalStage message(Optional<String> message) {
            this.message = message;
            return this;
        }

        @Override
        public IgnoreCommonModelRequest build() {
            return new IgnoreCommonModelRequest(reason, message);
        }
    }
}
