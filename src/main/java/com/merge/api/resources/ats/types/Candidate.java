package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Candidate.Builder.class)
public final class Candidate {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> firstName;

    private final Optional<String> lastName;

    private final Optional<String> company;

    private final Optional<String> title;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<OffsetDateTime> remoteUpdatedAt;

    private final Optional<OffsetDateTime> lastInteractionAt;

    private final Optional<Boolean> isPrivate;

    private final Optional<Boolean> canEmail;

    private final Optional<List<Optional<String>>> locations;

    private final Optional<List<PhoneNumber>> phoneNumbers;

    private final Optional<List<EmailAddress>> emailAddresses;

    private final Optional<List<Url>> urls;

    private final Optional<List<Optional<String>>> tags;

    private final Optional<List<Optional<String>>> applications;

    private final Optional<List<Optional<String>>> attachments;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Candidate(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<String> company,
            Optional<String> title,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<OffsetDateTime> remoteUpdatedAt,
            Optional<OffsetDateTime> lastInteractionAt,
            Optional<Boolean> isPrivate,
            Optional<Boolean> canEmail,
            Optional<List<Optional<String>>> locations,
            Optional<List<PhoneNumber>> phoneNumbers,
            Optional<List<EmailAddress>> emailAddresses,
            Optional<List<Url>> urls,
            Optional<List<Optional<String>>> tags,
            Optional<List<Optional<String>>> applications,
            Optional<List<Optional<String>>> attachments,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.title = title;
        this.remoteCreatedAt = remoteCreatedAt;
        this.remoteUpdatedAt = remoteUpdatedAt;
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
        this.remoteWasDeleted = remoteWasDeleted;
        this.modifiedAt = modifiedAt;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
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
     * @return When the third party's candidate was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return When the third party's candidate was updated.
     */
    @JsonProperty("remote_updated_at")
    public Optional<OffsetDateTime> getRemoteUpdatedAt() {
        return remoteUpdatedAt;
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
    public Optional<List<PhoneNumber>> getPhoneNumbers() {
        return phoneNumbers;
    }

    @JsonProperty("email_addresses")
    public Optional<List<EmailAddress>> getEmailAddresses() {
        return emailAddresses;
    }

    @JsonProperty("urls")
    public Optional<List<Url>> getUrls() {
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

    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    /**
     * @return This is the datetime that this object was last updated by Merge
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    @JsonProperty("field_mappings")
    public Optional<Map<String, JsonNode>> getFieldMappings() {
        return fieldMappings;
    }

    @JsonProperty("remote_data")
    public Optional<List<RemoteData>> getRemoteData() {
        return remoteData;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Candidate && equalTo((Candidate) other);
    }

    private boolean equalTo(Candidate other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
                && company.equals(other.company)
                && title.equals(other.title)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && remoteUpdatedAt.equals(other.remoteUpdatedAt)
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
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.firstName,
                this.lastName,
                this.company,
                this.title,
                this.remoteCreatedAt,
                this.remoteUpdatedAt,
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
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "Candidate{" + "id: " + id + ", remoteId: " + remoteId + ", firstName: " + firstName + ", lastName: "
                + lastName + ", company: " + company + ", title: " + title + ", remoteCreatedAt: " + remoteCreatedAt
                + ", remoteUpdatedAt: " + remoteUpdatedAt + ", lastInteractionAt: " + lastInteractionAt
                + ", isPrivate: " + isPrivate + ", canEmail: " + canEmail + ", locations: " + locations
                + ", phoneNumbers: " + phoneNumbers + ", emailAddresses: " + emailAddresses + ", urls: " + urls
                + ", tags: " + tags + ", applications: " + applications + ", attachments: " + attachments
                + ", remoteWasDeleted: " + remoteWasDeleted + ", modifiedAt: " + modifiedAt + ", fieldMappings: "
                + fieldMappings + ", remoteData: " + remoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> firstName = Optional.empty();

        private Optional<String> lastName = Optional.empty();

        private Optional<String> company = Optional.empty();

        private Optional<String> title = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedAt = Optional.empty();

        private Optional<OffsetDateTime> lastInteractionAt = Optional.empty();

        private Optional<Boolean> isPrivate = Optional.empty();

        private Optional<Boolean> canEmail = Optional.empty();

        private Optional<List<Optional<String>>> locations = Optional.empty();

        private Optional<List<PhoneNumber>> phoneNumbers = Optional.empty();

        private Optional<List<EmailAddress>> emailAddresses = Optional.empty();

        private Optional<List<Url>> urls = Optional.empty();

        private Optional<List<Optional<String>>> tags = Optional.empty();

        private Optional<List<Optional<String>>> applications = Optional.empty();

        private Optional<List<Optional<String>>> attachments = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Candidate other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            firstName(other.getFirstName());
            lastName(other.getLastName());
            company(other.getCompany());
            title(other.getTitle());
            remoteCreatedAt(other.getRemoteCreatedAt());
            remoteUpdatedAt(other.getRemoteUpdatedAt());
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
            remoteWasDeleted(other.getRemoteWasDeleted());
            modifiedAt(other.getModifiedAt());
            fieldMappings(other.getFieldMappings());
            remoteData(other.getRemoteData());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "remote_id", nulls = Nulls.SKIP)
        public Builder remoteId(Optional<String> remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder remoteId(String remoteId) {
            this.remoteId = Optional.of(remoteId);
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

        @JsonSetter(value = "remote_created_at", nulls = Nulls.SKIP)
        public Builder remoteCreatedAt(Optional<OffsetDateTime> remoteCreatedAt) {
            this.remoteCreatedAt = remoteCreatedAt;
            return this;
        }

        public Builder remoteCreatedAt(OffsetDateTime remoteCreatedAt) {
            this.remoteCreatedAt = Optional.of(remoteCreatedAt);
            return this;
        }

        @JsonSetter(value = "remote_updated_at", nulls = Nulls.SKIP)
        public Builder remoteUpdatedAt(Optional<OffsetDateTime> remoteUpdatedAt) {
            this.remoteUpdatedAt = remoteUpdatedAt;
            return this;
        }

        public Builder remoteUpdatedAt(OffsetDateTime remoteUpdatedAt) {
            this.remoteUpdatedAt = Optional.of(remoteUpdatedAt);
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
        public Builder phoneNumbers(Optional<List<PhoneNumber>> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public Builder phoneNumbers(List<PhoneNumber> phoneNumbers) {
            this.phoneNumbers = Optional.of(phoneNumbers);
            return this;
        }

        @JsonSetter(value = "email_addresses", nulls = Nulls.SKIP)
        public Builder emailAddresses(Optional<List<EmailAddress>> emailAddresses) {
            this.emailAddresses = emailAddresses;
            return this;
        }

        public Builder emailAddresses(List<EmailAddress> emailAddresses) {
            this.emailAddresses = Optional.of(emailAddresses);
            return this;
        }

        @JsonSetter(value = "urls", nulls = Nulls.SKIP)
        public Builder urls(Optional<List<Url>> urls) {
            this.urls = urls;
            return this;
        }

        public Builder urls(List<Url> urls) {
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

        @JsonSetter(value = "remote_was_deleted", nulls = Nulls.SKIP)
        public Builder remoteWasDeleted(Optional<Boolean> remoteWasDeleted) {
            this.remoteWasDeleted = remoteWasDeleted;
            return this;
        }

        public Builder remoteWasDeleted(Boolean remoteWasDeleted) {
            this.remoteWasDeleted = Optional.of(remoteWasDeleted);
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

        @JsonSetter(value = "field_mappings", nulls = Nulls.SKIP)
        public Builder fieldMappings(Optional<Map<String, JsonNode>> fieldMappings) {
            this.fieldMappings = fieldMappings;
            return this;
        }

        public Builder fieldMappings(Map<String, JsonNode> fieldMappings) {
            this.fieldMappings = Optional.of(fieldMappings);
            return this;
        }

        @JsonSetter(value = "remote_data", nulls = Nulls.SKIP)
        public Builder remoteData(Optional<List<RemoteData>> remoteData) {
            this.remoteData = remoteData;
            return this;
        }

        public Builder remoteData(List<RemoteData> remoteData) {
            this.remoteData = Optional.of(remoteData);
            return this;
        }

        public Candidate build() {
            return new Candidate(
                    id,
                    remoteId,
                    firstName,
                    lastName,
                    company,
                    title,
                    remoteCreatedAt,
                    remoteUpdatedAt,
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
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}
