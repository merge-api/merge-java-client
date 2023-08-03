package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Url.Builder.class)
public final class Url {
    private final Optional<String> value;

    private final Optional<UrlUrlType> urlType;

    private final Optional<OffsetDateTime> modifiedAt;

    private Url(Optional<String> value, Optional<UrlUrlType> urlType, Optional<OffsetDateTime> modifiedAt) {
        this.value = value;
        this.urlType = urlType;
        this.modifiedAt = modifiedAt;
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
    public Optional<UrlUrlType> getUrlType() {
        return urlType;
    }

    /**
     * @return This is the datetime that this object was last updated by Merge
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Url && equalTo((Url) other);
    }

    private boolean equalTo(Url other) {
        return value.equals(other.value) && urlType.equals(other.urlType) && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.urlType, this.modifiedAt);
    }

    @Override
    public String toString() {
        return "Url{" + "value: " + value + ", urlType: " + urlType + ", modifiedAt: " + modifiedAt + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> value = Optional.empty();

        private Optional<UrlUrlType> urlType = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(Url other) {
            value(other.getValue());
            urlType(other.getUrlType());
            modifiedAt(other.getModifiedAt());
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
        public Builder urlType(Optional<UrlUrlType> urlType) {
            this.urlType = urlType;
            return this;
        }

        public Builder urlType(UrlUrlType urlType) {
            this.urlType = Optional.of(urlType);
            return this;
        }

        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.of(modifiedAt);
            return this;
        }

        public Url build() {
            return new Url(value, urlType, modifiedAt);
        }
    }
}
