package com.merge.api.resources.filestorage.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AsyncPassthroughReciept.Builder.class)
public final class AsyncPassthroughReciept {
    private final String asyncPassthroughReceiptId;

    private AsyncPassthroughReciept(String asyncPassthroughReceiptId) {
        this.asyncPassthroughReceiptId = asyncPassthroughReceiptId;
    }

    @JsonProperty("async_passthrough_receipt_id")
    public String getAsyncPassthroughReceiptId() {
        return asyncPassthroughReceiptId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AsyncPassthroughReciept && equalTo((AsyncPassthroughReciept) other);
    }

    private boolean equalTo(AsyncPassthroughReciept other) {
        return asyncPassthroughReceiptId.equals(other.asyncPassthroughReceiptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.asyncPassthroughReceiptId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static AsyncPassthroughReceiptIdStage builder() {
        return new Builder();
    }

    public interface AsyncPassthroughReceiptIdStage {
        _FinalStage asyncPassthroughReceiptId(String asyncPassthroughReceiptId);

        Builder from(AsyncPassthroughReciept other);
    }

    public interface _FinalStage {
        AsyncPassthroughReciept build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements AsyncPassthroughReceiptIdStage, _FinalStage {
        private String asyncPassthroughReceiptId;

        private Builder() {}

        @Override
        public Builder from(AsyncPassthroughReciept other) {
            asyncPassthroughReceiptId(other.getAsyncPassthroughReceiptId());
            return this;
        }

        @Override
        @JsonSetter("async_passthrough_receipt_id")
        public _FinalStage asyncPassthroughReceiptId(String asyncPassthroughReceiptId) {
            this.asyncPassthroughReceiptId = asyncPassthroughReceiptId;
            return this;
        }

        @Override
        public AsyncPassthroughReciept build() {
            return new AsyncPassthroughReciept(asyncPassthroughReceiptId);
        }
    }
}
