package com.merge.api.resources.ats.applications.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ApplicationsMetaPostRetrieveRequest.Builder.class)
public final class ApplicationsMetaPostRetrieveRequest {
    private final Optional<String> applicationRemoteTemplateId;

    private ApplicationsMetaPostRetrieveRequest(Optional<String> applicationRemoteTemplateId) {
        this.applicationRemoteTemplateId = applicationRemoteTemplateId;
    }

    /**
     * @return The template ID associated with the nested application in the request.
     */
    @JsonProperty("application_remote_template_id")
    public Optional<String> getApplicationRemoteTemplateId() {
        return applicationRemoteTemplateId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ApplicationsMetaPostRetrieveRequest
                && equalTo((ApplicationsMetaPostRetrieveRequest) other);
    }

    private boolean equalTo(ApplicationsMetaPostRetrieveRequest other) {
        return applicationRemoteTemplateId.equals(other.applicationRemoteTemplateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.applicationRemoteTemplateId);
    }

    @Override
    public String toString() {
        return "ApplicationsMetaPostRetrieveRequest{" + "applicationRemoteTemplateId: " + applicationRemoteTemplateId
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> applicationRemoteTemplateId = Optional.empty();

        private Builder() {}

        public Builder from(ApplicationsMetaPostRetrieveRequest other) {
            applicationRemoteTemplateId(other.getApplicationRemoteTemplateId());
            return this;
        }

        @JsonSetter(value = "application_remote_template_id", nulls = Nulls.SKIP)
        public Builder applicationRemoteTemplateId(Optional<String> applicationRemoteTemplateId) {
            this.applicationRemoteTemplateId = applicationRemoteTemplateId;
            return this;
        }

        public Builder applicationRemoteTemplateId(String applicationRemoteTemplateId) {
            this.applicationRemoteTemplateId = Optional.of(applicationRemoteTemplateId);
            return this;
        }

        public ApplicationsMetaPostRetrieveRequest build() {
            return new ApplicationsMetaPostRetrieveRequest(applicationRemoteTemplateId);
        }
    }
}
