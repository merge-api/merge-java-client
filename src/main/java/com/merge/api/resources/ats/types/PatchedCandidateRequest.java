package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PatchedCandidateRequest.Builder.class)
public final class PatchedCandidateRequest {
    private final Optional<String> firstName;

    private final Optional<String> lastName;

    private final Optional<String> company;

    private final Optional<String> title;

    private final Optional<OffsetDateTime> lastInteractionAt;

    private final Optional<Boolean> isPrivate;

    private final Optional<Boolean> canEmail;

    private final Optional<List<Optional<String>>> locations;

    private final Optional<List<PhoneNumberRequest>> phoneNumbers;

    private final Optional<List<EmailAddressRequest>> emailAddresses;

    private final Optional<List<UrlRequest>> urls;

    private final Optional<List<Optional<String>>> tags;

    private final Optional<List<Optional<String>>> applications;

    private final Optional<List<Optional<String>>> attachments;

    private final Optional<String> remoteTemplateId;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private PatchedCandidateRequest(
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<String> company,
            Optional<String> title,
            Optional<OffsetDateTime> lastInteractionAt,
            Optional<Boolean> isPrivate,
            Optional<Boolean> canEmail,
            Optional<List<Optional<String>>> locations,
            Optional<List<PhoneNumberRequest>> phoneNumbers,
            Optional<List<EmailAddressRequest>> emailAddresses,
            Optional<List<UrlRequest>> urls,
            Optional<List<Optional<String>>> tags,
            Optional<List<Optional<String>>> applications,
            Optional<List<Optional<String>>> attachments,
            Optional<String> remoteTemplateId,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.title = title;
        this.lastInteractionAt = lastInteractionAt;
        this.isPrivate = isPrivate;
        this.canEmail = canEmail;
        this.locations = locations;
        this.phoneNumbers = phoneNumbers;
        this.emailAddresses = emailAddresses;
        this.urls = urls;
        this.tags = tags;
        this.applications = applications;
        this.attachments = attachments;
        this.remoteTemplateId = remoteTemplateId;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
    }

    /**
     * @return The candidate's first name.
     */
    @JsonProperty("first_name")
    public Optional<String> getFirstName() {
        return firstName;
    }

    /**
     * @return The candidate's last name.
     */
    @JsonProperty("last_name")
    public Optional<String> getLastName() {
        return lastName;
    }

    /**
     * @return The candidate's current company.
     */
    @JsonProperty("company")
    public Optional<String> getCompany() {
        return company;
    }

    /**
     * @return The candidate's current title.
     */
    @JsonProperty("title")
    public Optional<String> getTitle() {
        return title;
    }

    /**
     * @return When the most recent interaction with the candidate occurred.
     */
    @JsonProperty("last_interaction_at")
    public Optional<OffsetDateTime> getLastInteractionAt() {
        return lastInteractionAt;
    }

    /**
     * @return Whether or not the candidate is private.
     */
    @JsonProperty("is_private")
    public Optional<Boolean> getIsPrivate() {
        return isPrivate;
    }

    /**
     * @return Whether or not the candidate can be emailed.
     */
    @JsonProperty("can_email")
    public Optional<Boolean> getCanEmail() {
        return canEmail;
    }

    /**
     * @return The candidate's locations.
     */
    @JsonProperty("locations")
    public Optional<List<Optional<String>>> getLocations() {
        return locations;
    }

    @JsonProperty("phone_numbers")
    public Optional<List<PhoneNumberRequest>> getPhoneNumbers() {
        return phoneNumbers;
    }

    @JsonProperty("email_addresses")
    public Optional<List<EmailAddressRequest>> getEmailAddresses() {
        return emailAddresses;
    }

    @JsonProperty("urls")
    public Optional<List<UrlRequest>> getUrls() {
        return urls;
    }

    /**
     * @return Array of <code>Tag</code> names as strings.
     */
    @JsonProperty("tags")
    public Optional<List<Optional<String>>> getTags() {
        return tags;
    }

    /**
     * @return Array of <code>Application</code> object IDs.
     */
    @JsonProperty("applications")
    public Optional<List<Optional<String>>> getApplications() {
        return applications;
    }

    /**
     * @return Array of <code>Attachment</code> object IDs.
     */
    @JsonProperty("attachments")
    public Optional<List<Optional<String>>> getAttachments() {
        return attachments;
    }

    /**
     * @return &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("remote_template_id")
    public Optional<String> getRemoteTemplateId() {
        return remoteTemplateId;
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
        return other instanceof PatchedCandidateRequest && equalTo((PatchedCandidateRequest) other);
    }

    private boolean equalTo(PatchedCandidateRequest other) {
        return firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
                && company.equals(other.company)
                && title.equals(other.title)
                && lastInteractionAt.equals(other.lastInteractionAt)
                && isPrivate.equals(other.isPrivate)
                && canEmail.equals(other.canEmail)
                && locations.equals(other.locations)
                && phoneNumbers.equals(other.phoneNumbers)
                && emailAddresses.equals(other.emailAddresses)
                && urls.equals(other.urls)
                && tags.equals(other.tags)
                && applications.equals(other.applications)
                && attachments.equals(other.attachments)
                && remoteTemplateId.equals(other.remoteTemplateId)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.firstName,
                this.lastName,
                this.company,
                this.title,
                this.lastInteractionAt,
                this.isPrivate,
                this.canEmail,
                this.locations,
                this.phoneNumbers,
                this.emailAddresses,
                this.urls,
                this.tags,
                this.applications,
                this.attachments,
                this.remoteTemplateId,
                this.integrationParams,
                this.linkedAccountParams);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> firstName = Optional.empty();

        private Optional<String> lastName = Optional.empty();

        private Optional<String> company = Optional.empty();

        private Optional<String> title = Optional.empty();

        private Optional<OffsetDateTime> lastInteractionAt = Optional.empty();

        private Optional<Boolean> isPrivate = Optional.empty();

        private Optional<Boolean> canEmail = Optional.empty();

        private Optional<List<Optional<String>>> locations = Optional.empty();

        private Optional<List<PhoneNumberRequest>> phoneNumbers = Optional.empty();

        private Optional<List<EmailAddressRequest>> emailAddresses = Optional.empty();

        private Optional<List<UrlRequest>> urls = Optional.empty();

        private Optional<List<Optional<String>>> tags = Optional.empty();

        private Optional<List<Optional<String>>> applications = Optional.empty();

        private Optional<List<Optional<String>>> attachments = Optional.empty();

        private Optional<String> remoteTemplateId = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(PatchedCandidateRequest other) {
            firstName(other.getFirstName());
            lastName(other.getLastName());
            company(other.getCompany());
            title(other.getTitle());
            lastInteractionAt(other.getLastInteractionAt());
            isPrivate(other.getIsPrivate());
            canEmail(other.getCanEmail());
            locations(other.getLocations());
            phoneNumbers(other.getPhoneNumbers());
            emailAddresses(other.getEmailAddresses());
            urls(other.getUrls());
            tags(other.getTags());
            applications(other.getApplications());
            attachments(other.getAttachments());
            remoteTemplateId(other.getRemoteTemplateId());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            return this;
        }

        @JsonSetter(value = "first_name", nulls = Nulls.SKIP)
        public Builder firstName(Optional<String> firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = Optional.of(firstName);
            return this;
        }

        @JsonSetter(value = "last_name", nulls = Nulls.SKIP)
        public Builder lastName(Optional<String> lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = Optional.of(lastName);
            return this;
        }

        @JsonSetter(value = "company", nulls = Nulls.SKIP)
        public Builder company(Optional<String> company) {
            this.company = company;
            return this;
        }

        public Builder company(String company) {
            this.company = Optional.of(company);
            return this;
        }

        @JsonSetter(value = "title", nulls = Nulls.SKIP)
        public Builder title(Optional<String> title) {
            this.title = title;
            return this;
        }

        public Builder title(String title) {
            this.title = Optional.of(title);
            return this;
        }

        @JsonSetter(value = "last_interaction_at", nulls = Nulls.SKIP)
        public Builder lastInteractionAt(Optional<OffsetDateTime> lastInteractionAt) {
            this.lastInteractionAt = lastInteractionAt;
            return this;
        }

        public Builder lastInteractionAt(OffsetDateTime lastInteractionAt) {
            this.lastInteractionAt = Optional.of(lastInteractionAt);
            return this;
        }

        @JsonSetter(value = "is_private", nulls = Nulls.SKIP)
        public Builder isPrivate(Optional<Boolean> isPrivate) {
            this.isPrivate = isPrivate;
            return this;
        }

        public Builder isPrivate(Boolean isPrivate) {
            this.isPrivate = Optional.of(isPrivate);
            return this;
        }

        @JsonSetter(value = "can_email", nulls = Nulls.SKIP)
        public Builder canEmail(Optional<Boolean> canEmail) {
            this.canEmail = canEmail;
            return this;
        }

        public Builder canEmail(Boolean canEmail) {
            this.canEmail = Optional.of(canEmail);
            return this;
        }

        @JsonSetter(value = "locations", nulls = Nulls.SKIP)
        public Builder locations(Optional<List<Optional<String>>> locations) {
            this.locations = locations;
            return this;
        }

        public Builder locations(List<Optional<String>> locations) {
            this.locations = Optional.of(locations);
            return this;
        }

        @JsonSetter(value = "phone_numbers", nulls = Nulls.SKIP)
        public Builder phoneNumbers(Optional<List<PhoneNumberRequest>> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public Builder phoneNumbers(List<PhoneNumberRequest> phoneNumbers) {
            this.phoneNumbers = Optional.of(phoneNumbers);
            return this;
        }

        @JsonSetter(value = "email_addresses", nulls = Nulls.SKIP)
        public Builder emailAddresses(Optional<List<EmailAddressRequest>> emailAddresses) {
            this.emailAddresses = emailAddresses;
            return this;
        }

        public Builder emailAddresses(List<EmailAddressRequest> emailAddresses) {
            this.emailAddresses = Optional.of(emailAddresses);
            return this;
        }

        @JsonSetter(value = "urls", nulls = Nulls.SKIP)
        public Builder urls(Optional<List<UrlRequest>> urls) {
            this.urls = urls;
            return this;
        }

        public Builder urls(List<UrlRequest> urls) {
            this.urls = Optional.of(urls);
            return this;
        }

        @JsonSetter(value = "tags", nulls = Nulls.SKIP)
        public Builder tags(Optional<List<Optional<String>>> tags) {
            this.tags = tags;
            return this;
        }

        public Builder tags(List<Optional<String>> tags) {
            this.tags = Optional.of(tags);
            return this;
        }

        @JsonSetter(value = "applications", nulls = Nulls.SKIP)
        public Builder applications(Optional<List<Optional<String>>> applications) {
            this.applications = applications;
            return this;
        }

        public Builder applications(List<Optional<String>> applications) {
            this.applications = Optional.of(applications);
            return this;
        }

        @JsonSetter(value = "attachments", nulls = Nulls.SKIP)
        public Builder attachments(Optional<List<Optional<String>>> attachments) {
            this.attachments = attachments;
            return this;
        }

        public Builder attachments(List<Optional<String>> attachments) {
            this.attachments = Optional.of(attachments);
            return this;
        }

        @JsonSetter(value = "remote_template_id", nulls = Nulls.SKIP)
        public Builder remoteTemplateId(Optional<String> remoteTemplateId) {
            this.remoteTemplateId = remoteTemplateId;
            return this;
        }

        public Builder remoteTemplateId(String remoteTemplateId) {
            this.remoteTemplateId = Optional.of(remoteTemplateId);
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

        public PatchedCandidateRequest build() {
            return new PatchedCandidateRequest(
                    firstName,
                    lastName,
                    company,
                    title,
                    lastInteractionAt,
                    isPrivate,
                    canEmail,
                    locations,
                    phoneNumbers,
                    emailAddresses,
                    urls,
                    tags,
                    applications,
                    attachments,
                    remoteTemplateId,
                    integrationParams,
                    linkedAccountParams);
        }
    }
}
