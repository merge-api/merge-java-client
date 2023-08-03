package com.merge.api.resources.filestorage.webhookreceivers.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = WebhookReceiverRequest.Builder.class)
public final class WebhookReceiverRequest {
    private final String event;

    private final boolean isActive;

    private final Optional<String> key;

    private WebhookReceiverRequest(String event, boolean isActive, Optional<String> key) {
        this.event = event;
        this.isActive = isActive;
        this.key = key;
    }

    /**
     * @return &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("event")
    public String getEvent() {
        return event;
    }

    @JsonProperty("is_active")
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * @return &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("key")
    public Optional<String> getKey() {
        return key;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof WebhookReceiverRequest && equalTo((WebhookReceiverRequest) other);
    }

    private boolean equalTo(WebhookReceiverRequest other) {
        return event.equals(other.event) && isActive == other.isActive && key.equals(other.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.event, this.isActive, this.key);
    }

    @Override
    public String toString() {
        return "WebhookReceiverRequest{" + "event: " + event + ", isActive: " + isActive + ", key: " + key + "}";
    }

    public static EventStage builder() {
        return new Builder();
    }

    public interface EventStage {
        IsActiveStage event(String event);

        Builder from(WebhookReceiverRequest other);
    }

    public interface IsActiveStage {
        _FinalStage isActive(boolean isActive);
    }

    public interface _FinalStage {
        WebhookReceiverRequest build();

        _FinalStage key(Optional<String> key);

        _FinalStage key(String key);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements EventStage, IsActiveStage, _FinalStage {
        private String event;

        private boolean isActive;

        private Optional<String> key = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(WebhookReceiverRequest other) {
            event(other.getEvent());
            isActive(other.getIsActive());
            key(other.getKey());
            return this;
        }

        /**
         * <p>&lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("event")
        public IsActiveStage event(String event) {
            this.event = event;
            return this;
        }

        @Override
        @JsonSetter("is_active")
        public _FinalStage isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        /**
         * <p>&lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage key(String key) {
            this.key = Optional.of(key);
            return this;
        }

        @Override
        @JsonSetter(value = "key", nulls = Nulls.SKIP)
        public _FinalStage key(Optional<String> key) {
            this.key = key;
            return this;
        }

        @Override
        public WebhookReceiverRequest build() {
            return new WebhookReceiverRequest(event, isActive, key);
        }
    }
}
