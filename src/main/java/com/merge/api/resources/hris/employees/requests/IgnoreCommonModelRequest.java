package com.merge.api.resources.hris.employees.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.hris.types.IgnoreCommonModelRequestReason;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = IgnoreCommonModelRequest.Builder.class)
public final class IgnoreCommonModelRequest {
    private final IgnoreCommonModelRequestReason reason;

    private final Optional<String> message;

    private IgnoreCommonModelRequest(IgnoreCommonModelRequestReason reason, Optional<String> message) {
        this.reason = reason;
        this.message = message;
    }

    @JsonProperty("reason")
    public IgnoreCommonModelRequestReason getReason() {
        return reason;
    }

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
        return ObjectMappers.stringify(this);
    }

    public static ReasonStage builder() {
        return new Builder();
    }

    public interface ReasonStage {
        _FinalStage reason(IgnoreCommonModelRequestReason reason);

        Builder from(IgnoreCommonModelRequest other);
    }

    public interface _FinalStage {
        IgnoreCommonModelRequest build();

        _FinalStage message(Optional<String> message);

        _FinalStage message(String message);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ReasonStage, _FinalStage {
        private IgnoreCommonModelRequestReason reason;

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
        public _FinalStage reason(IgnoreCommonModelRequestReason reason) {
            this.reason = reason;
            return this;
        }

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
