package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UrlRequest.Builder.class)
public final class UrlRequest {
    private final Optional<String> value;

    private final Optional<UrlRequestUrlType> urlType;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private UrlRequest(
            Optional<String> value,
            Optional<UrlRequestUrlType> urlType,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.value = value;
        this.urlType = urlType;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
    }

    /**
     * @return The site's url.
     */
    @JsonProperty("value")
    public Optional<String> getValue() {
        return value;
    }

    /**
     * @return The type of site.
     * <ul>
     * <li><code>PERSONAL</code> - PERSONAL</li>
     * <li><code>COMPANY</code> - COMPANY</li>
     * <li><code>PORTFOLIO</code> - PORTFOLIO</li>
     * <li><code>BLOG</code> - BLOG</li>
     * <li><code>SOCIAL_MEDIA</code> - SOCIAL_MEDIA</li>
     * <li><code>OTHER</code> - OTHER</li>
     * <li><code>JOB_POSTING</code> - JOB_POSTING</li>
     * </ul>
     */
    @JsonProperty("url_type")
    public Optional<UrlRequestUrlType> getUrlType() {
        return urlType;
    }

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UrlRequest && equalTo((UrlRequest) other);
    }

    private boolean equalTo(UrlRequest other) {
        return value.equals(other.value)
                && urlType.equals(other.urlType)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.urlType, this.integrationParams, this.linkedAccountParams);
    }

    @Override
    public String toString() {
        return "UrlRequest{" + "value: " + value + ", urlType: " + urlType + ", integrationParams: " + integrationParams
                + ", linkedAccountParams: " + linkedAccountParams + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> value = Optional.empty();

        private Optional<UrlRequestUrlType> urlType = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(UrlRequest other) {
            value(other.getValue());
            urlType(other.getUrlType());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            return this;
        }

        @JsonSetter(value = "value", nulls = Nulls.SKIP)
        public Builder value(Optional<String> value) {
            this.value = value;
            return this;
        }

        public Builder value(String value) {
            this.value = Optional.of(value);
            return this;
        }

        @JsonSetter(value = "url_type", nulls = Nulls.SKIP)
        public Builder urlType(Optional<UrlRequestUrlType> urlType) {
            this.urlType = urlType;
            return this;
        }

        public Builder urlType(UrlRequestUrlType urlType) {
            this.urlType = Optional.of(urlType);
            return this;
        }

        @JsonSetter(value = "integration_params", nulls = Nulls.SKIP)
        public Builder integrationParams(Optional<Map<String, JsonNode>> integrationParams) {
            this.integrationParams = integrationParams;
            return this;
        }

        public Builder integrationParams(Map<String, JsonNode> integrationParams) {
            this.integrationParams = Optional.of(integrationParams);
            return this;
        }

        @JsonSetter(value = "linked_account_params", nulls = Nulls.SKIP)
        public Builder linkedAccountParams(Optional<Map<String, JsonNode>> linkedAccountParams) {
            this.linkedAccountParams = linkedAccountParams;
            return this;
        }

        public Builder linkedAccountParams(Map<String, JsonNode> linkedAccountParams) {
            this.linkedAccountParams = Optional.of(linkedAccountParams);
            return this;
        }

        public UrlRequest build() {
            return new UrlRequest(value, urlType, integrationParams, linkedAccountParams);
        }
    }
}