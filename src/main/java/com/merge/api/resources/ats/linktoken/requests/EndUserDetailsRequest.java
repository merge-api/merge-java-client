package com.merge.api.resources.ats.linktoken.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.ats.types.CategoriesEnum;
import com.merge.api.resources.ats.types.CommonModelScopesBodyRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EndUserDetailsRequest.Builder.class)
public final class EndUserDetailsRequest {
    private final String endUserEmailAddress;

    private final String endUserOrganizationName;

    private final String endUserOriginId;

    private final List<CategoriesEnum> categories;

    private final Optional<String> integration;

    private final Optional<Integer> linkExpiryMins;

    private final Optional<Boolean> shouldCreateMagicLinkUrl;

    private final Optional<List<CommonModelScopesBodyRequest>> commonModels;

    private EndUserDetailsRequest(
            String endUserEmailAddress,
            String endUserOrganizationName,
            String endUserOriginId,
            List<CategoriesEnum> categories,
            Optional<String> integration,
            Optional<Integer> linkExpiryMins,
            Optional<Boolean> shouldCreateMagicLinkUrl,
            Optional<List<CommonModelScopesBodyRequest>> commonModels) {
        this.endUserEmailAddress = endUserEmailAddress;
        this.endUserOrganizationName = endUserOrganizationName;
        this.endUserOriginId = endUserOriginId;
        this.categories = categories;
        this.integration = integration;
        this.linkExpiryMins = linkExpiryMins;
        this.shouldCreateMagicLinkUrl = shouldCreateMagicLinkUrl;
        this.commonModels = commonModels;
    }

    /**
     * @return Your end user's email address. This is purely for identification purposes - setting this value will not cause any emails to be sent. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt; &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>&lt;= 100 characters</code>&lt;/span&gt;
     */
    @JsonProperty("end_user_email_address")
    public String getEndUserEmailAddress() {
        return endUserEmailAddress;
    }

    /**
     * @return Your end user's organization. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt; &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>&lt;= 100 characters</code>&lt;/span&gt;
     */
    @JsonProperty("end_user_organization_name")
    public String getEndUserOrganizationName() {
        return endUserOrganizationName;
    }

    /**
     * @return This unique identifier typically represents the ID for your end user in your product's database. This value must be distinct from other Linked Accounts' unique identifiers. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt; &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>&lt;= 100 characters</code>&lt;/span&gt;
     */
    @JsonProperty("end_user_origin_id")
    public String getEndUserOriginId() {
        return endUserOriginId;
    }

    /**
     * @return The integration categories to show in Merge Link.
     */
    @JsonProperty("categories")
    public List<CategoriesEnum> getCategories() {
        return categories;
    }

    /**
     * @return The slug of a specific pre-selected integration for this linking flow token. For examples of slugs, see https://www.merge.dev/docs/basics/integration-metadata/.
     */
    @JsonProperty("integration")
    public Optional<String> getIntegration() {
        return integration;
    }

    /**
     * @return An integer number of minutes between [30, 720 or 10080 if for a Magic Link URL] for how long this token is valid. Defaults to 30.
     */
    @JsonProperty("link_expiry_mins")
    public Optional<Integer> getLinkExpiryMins() {
        return linkExpiryMins;
    }

    /**
     * @return Whether to generate a Magic Link URL. Defaults to false. For more information on Magic Link, see https://merge.dev/blog/integrations-fast-say-hello-to-magic-link.
     */
    @JsonProperty("should_create_magic_link_url")
    public Optional<Boolean> getShouldCreateMagicLinkUrl() {
        return shouldCreateMagicLinkUrl;
    }

    /**
     * @return An array of objects to specify the models and fields that will be disabled for a given Linked Account. Each object uses model_id, enabled_actions, and disabled_fields to specify the model, method, and fields that are scoped for a given Linked Account.
     */
    @JsonProperty("common_models")
    public Optional<List<CommonModelScopesBodyRequest>> getCommonModels() {
        return commonModels;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EndUserDetailsRequest && equalTo((EndUserDetailsRequest) other);
    }

    private boolean equalTo(EndUserDetailsRequest other) {
        return endUserEmailAddress.equals(other.endUserEmailAddress)
                && endUserOrganizationName.equals(other.endUserOrganizationName)
                && endUserOriginId.equals(other.endUserOriginId)
                && categories.equals(other.categories)
                && integration.equals(other.integration)
                && linkExpiryMins.equals(other.linkExpiryMins)
                && shouldCreateMagicLinkUrl.equals(other.shouldCreateMagicLinkUrl)
                && commonModels.equals(other.commonModels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.endUserEmailAddress,
                this.endUserOrganizationName,
                this.endUserOriginId,
                this.categories,
                this.integration,
                this.linkExpiryMins,
                this.shouldCreateMagicLinkUrl,
                this.commonModels);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static EndUserEmailAddressStage builder() {
        return new Builder();
    }

    public interface EndUserEmailAddressStage {
        EndUserOrganizationNameStage endUserEmailAddress(String endUserEmailAddress);

        Builder from(EndUserDetailsRequest other);
    }

    public interface EndUserOrganizationNameStage {
        EndUserOriginIdStage endUserOrganizationName(String endUserOrganizationName);
    }

    public interface EndUserOriginIdStage {
        _FinalStage endUserOriginId(String endUserOriginId);
    }

    public interface _FinalStage {
        EndUserDetailsRequest build();

        _FinalStage categories(List<CategoriesEnum> categories);

        _FinalStage addCategories(CategoriesEnum categories);

        _FinalStage addAllCategories(List<CategoriesEnum> categories);

        _FinalStage integration(Optional<String> integration);

        _FinalStage integration(String integration);

        _FinalStage linkExpiryMins(Optional<Integer> linkExpiryMins);

        _FinalStage linkExpiryMins(Integer linkExpiryMins);

        _FinalStage shouldCreateMagicLinkUrl(Optional<Boolean> shouldCreateMagicLinkUrl);

        _FinalStage shouldCreateMagicLinkUrl(Boolean shouldCreateMagicLinkUrl);

        _FinalStage commonModels(Optional<List<CommonModelScopesBodyRequest>> commonModels);

        _FinalStage commonModels(List<CommonModelScopesBodyRequest> commonModels);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements EndUserEmailAddressStage, EndUserOrganizationNameStage, EndUserOriginIdStage, _FinalStage {
        private String endUserEmailAddress;

        private String endUserOrganizationName;

        private String endUserOriginId;

        private Optional<List<CommonModelScopesBodyRequest>> commonModels = Optional.empty();

        private Optional<Boolean> shouldCreateMagicLinkUrl = Optional.empty();

        private Optional<Integer> linkExpiryMins = Optional.empty();

        private Optional<String> integration = Optional.empty();

        private List<CategoriesEnum> categories = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(EndUserDetailsRequest other) {
            endUserEmailAddress(other.getEndUserEmailAddress());
            endUserOrganizationName(other.getEndUserOrganizationName());
            endUserOriginId(other.getEndUserOriginId());
            categories(other.getCategories());
            integration(other.getIntegration());
            linkExpiryMins(other.getLinkExpiryMins());
            shouldCreateMagicLinkUrl(other.getShouldCreateMagicLinkUrl());
            commonModels(other.getCommonModels());
            return this;
        }

        /**
         * <p>Your end user's email address. This is purely for identification purposes - setting this value will not cause any emails to be sent. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt; &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>&lt;= 100 characters</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("end_user_email_address")
        public EndUserOrganizationNameStage endUserEmailAddress(String endUserEmailAddress) {
            this.endUserEmailAddress = endUserEmailAddress;
            return this;
        }

        /**
         * <p>Your end user's organization. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt; &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>&lt;= 100 characters</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("end_user_organization_name")
        public EndUserOriginIdStage endUserOrganizationName(String endUserOrganizationName) {
            this.endUserOrganizationName = endUserOrganizationName;
            return this;
        }

        /**
         * <p>This unique identifier typically represents the ID for your end user in your product's database. This value must be distinct from other Linked Accounts' unique identifiers. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt; &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>&lt;= 100 characters</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("end_user_origin_id")
        public _FinalStage endUserOriginId(String endUserOriginId) {
            this.endUserOriginId = endUserOriginId;
            return this;
        }

        /**
         * <p>An array of objects to specify the models and fields that will be disabled for a given Linked Account. Each object uses model_id, enabled_actions, and disabled_fields to specify the model, method, and fields that are scoped for a given Linked Account.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage commonModels(List<CommonModelScopesBodyRequest> commonModels) {
            this.commonModels = Optional.of(commonModels);
            return this;
        }

        @Override
        @JsonSetter(value = "common_models", nulls = Nulls.SKIP)
        public _FinalStage commonModels(Optional<List<CommonModelScopesBodyRequest>> commonModels) {
            this.commonModels = commonModels;
            return this;
        }

        /**
         * <p>Whether to generate a Magic Link URL. Defaults to false. For more information on Magic Link, see https://merge.dev/blog/integrations-fast-say-hello-to-magic-link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage shouldCreateMagicLinkUrl(Boolean shouldCreateMagicLinkUrl) {
            this.shouldCreateMagicLinkUrl = Optional.of(shouldCreateMagicLinkUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "should_create_magic_link_url", nulls = Nulls.SKIP)
        public _FinalStage shouldCreateMagicLinkUrl(Optional<Boolean> shouldCreateMagicLinkUrl) {
            this.shouldCreateMagicLinkUrl = shouldCreateMagicLinkUrl;
            return this;
        }

        /**
         * <p>An integer number of minutes between [30, 720 or 10080 if for a Magic Link URL] for how long this token is valid. Defaults to 30.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage linkExpiryMins(Integer linkExpiryMins) {
            this.linkExpiryMins = Optional.of(linkExpiryMins);
            return this;
        }

        @Override
        @JsonSetter(value = "link_expiry_mins", nulls = Nulls.SKIP)
        public _FinalStage linkExpiryMins(Optional<Integer> linkExpiryMins) {
            this.linkExpiryMins = linkExpiryMins;
            return this;
        }

        /**
         * <p>The slug of a specific pre-selected integration for this linking flow token. For examples of slugs, see https://www.merge.dev/docs/basics/integration-metadata/.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage integration(String integration) {
            this.integration = Optional.of(integration);
            return this;
        }

        @Override
        @JsonSetter(value = "integration", nulls = Nulls.SKIP)
        public _FinalStage integration(Optional<String> integration) {
            this.integration = integration;
            return this;
        }

        /**
         * <p>The integration categories to show in Merge Link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllCategories(List<CategoriesEnum> categories) {
            this.categories.addAll(categories);
            return this;
        }

        /**
         * <p>The integration categories to show in Merge Link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addCategories(CategoriesEnum categories) {
            this.categories.add(categories);
            return this;
        }

        @Override
        @JsonSetter(value = "categories", nulls = Nulls.SKIP)
        public _FinalStage categories(List<CategoriesEnum> categories) {
            this.categories.clear();
            this.categories.addAll(categories);
            return this;
        }

        @Override
        public EndUserDetailsRequest build() {
            return new EndUserDetailsRequest(
                    endUserEmailAddress,
                    endUserOrganizationName,
                    endUserOriginId,
                    categories,
                    integration,
                    linkExpiryMins,
                    shouldCreateMagicLinkUrl,
                    commonModels);
        }
    }
}
