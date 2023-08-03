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
@JsonDeserialize(builder = LinkToken.Builder.class)
public final class LinkToken {
    private final String linkToken;

    private final Optional<String> integrationName;

    private final Optional<String> magicLinkUrl;

    private LinkToken(String linkToken, Optional<String> integrationName, Optional<String> magicLinkUrl) {
        this.linkToken = linkToken;
        this.integrationName = integrationName;
        this.magicLinkUrl = magicLinkUrl;
    }

    @JsonProperty("link_token")
    public String getLinkToken() {
        return linkToken;
    }

    @JsonProperty("integration_name")
    public Optional<String> getIntegrationName() {
        return integrationName;
    }

    @JsonProperty("magic_link_url")
    public Optional<String> getMagicLinkUrl() {
        return magicLinkUrl;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LinkToken && equalTo((LinkToken) other);
    }

    private boolean equalTo(LinkToken other) {
        return linkToken.equals(other.linkToken)
                && integrationName.equals(other.integrationName)
                && magicLinkUrl.equals(other.magicLinkUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.linkToken, this.integrationName, this.magicLinkUrl);
    }

    @Override
    public String toString() {
        return "LinkToken{" + "linkToken: " + linkToken + ", integrationName: " + integrationName + ", magicLinkUrl: "
                + magicLinkUrl + "}";
    }

    public static LinkTokenStage builder() {
        return new Builder();
    }

    public interface LinkTokenStage {
        _FinalStage linkToken(String linkToken);

        Builder from(LinkToken other);
    }

    public interface _FinalStage {
        LinkToken build();

        _FinalStage integrationName(Optional<String> integrationName);

        _FinalStage integrationName(String integrationName);

        _FinalStage magicLinkUrl(Optional<String> magicLinkUrl);

        _FinalStage magicLinkUrl(String magicLinkUrl);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LinkTokenStage, _FinalStage {
        private String linkToken;

        private Optional<String> magicLinkUrl = Optional.empty();

        private Optional<String> integrationName = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(LinkToken other) {
            linkToken(other.getLinkToken());
            integrationName(other.getIntegrationName());
            magicLinkUrl(other.getMagicLinkUrl());
            return this;
        }

        @Override
        @JsonSetter("link_token")
        public _FinalStage linkToken(String linkToken) {
            this.linkToken = linkToken;
            return this;
        }

        @Override
        public _FinalStage magicLinkUrl(String magicLinkUrl) {
            this.magicLinkUrl = Optional.of(magicLinkUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "magic_link_url", nulls = Nulls.SKIP)
        public _FinalStage magicLinkUrl(Optional<String> magicLinkUrl) {
            this.magicLinkUrl = magicLinkUrl;
            return this;
        }

        @Override
        public _FinalStage integrationName(String integrationName) {
            this.integrationName = Optional.of(integrationName);
            return this;
        }

        @Override
        @JsonSetter(value = "integration_name", nulls = Nulls.SKIP)
        public _FinalStage integrationName(Optional<String> integrationName) {
            this.integrationName = integrationName;
            return this;
        }

        @Override
        public LinkToken build() {
            return new LinkToken(linkToken, integrationName, magicLinkUrl);
        }
    }
}
