/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.hris.linktoken.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.hris.types.CategoriesEnum;
import com.merge.api.resources.hris.types.CommonModelScopesBodyRequest;
import com.merge.api.resources.hris.types.IndividualCommonModelScopeDeserializerRequest;
import com.merge.api.resources.hris.types.LanguageEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private final Optional<Boolean> hideAdminMagicLink;

    private final Optional<List<CommonModelScopesBodyRequest>> commonModels;

    private final Optional<Map<String, Optional<List<IndividualCommonModelScopeDeserializerRequest>>>>
            categoryCommonModelScopes;

    private final Optional<LanguageEnum> language;

    private final Optional<Boolean> areSyncsDisabled;

    private final Optional<Map<String, JsonNode>> integrationSpecificConfig;

    private final Map<String, Object> additionalProperties;

    private EndUserDetailsRequest(
            String endUserEmailAddress,
            String endUserOrganizationName,
            String endUserOriginId,
            List<CategoriesEnum> categories,
            Optional<String> integration,
            Optional<Integer> linkExpiryMins,
            Optional<Boolean> shouldCreateMagicLinkUrl,
            Optional<Boolean> hideAdminMagicLink,
            Optional<List<CommonModelScopesBodyRequest>> commonModels,
            Optional<Map<String, Optional<List<IndividualCommonModelScopeDeserializerRequest>>>>
                    categoryCommonModelScopes,
            Optional<LanguageEnum> language,
            Optional<Boolean> areSyncsDisabled,
            Optional<Map<String, JsonNode>> integrationSpecificConfig,
            Map<String, Object> additionalProperties) {
        this.endUserEmailAddress = endUserEmailAddress;
        this.endUserOrganizationName = endUserOrganizationName;
        this.endUserOriginId = endUserOriginId;
        this.categories = categories;
        this.integration = integration;
        this.linkExpiryMins = linkExpiryMins;
        this.shouldCreateMagicLinkUrl = shouldCreateMagicLinkUrl;
        this.hideAdminMagicLink = hideAdminMagicLink;
        this.commonModels = commonModels;
        this.categoryCommonModelScopes = categoryCommonModelScopes;
        this.language = language;
        this.areSyncsDisabled = areSyncsDisabled;
        this.integrationSpecificConfig = integrationSpecificConfig;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Your end user's email address. This is purely for identification purposes - setting this value will not cause any emails to be sent.
     */
    @JsonProperty("end_user_email_address")
    public String getEndUserEmailAddress() {
        return endUserEmailAddress;
    }

    /**
     * @return Your end user's organization.
     */
    @JsonProperty("end_user_organization_name")
    public String getEndUserOrganizationName() {
        return endUserOrganizationName;
    }

    /**
     * @return This unique identifier typically represents the ID for your end user in your product's database. This value must be distinct from other Linked Accounts' unique identifiers.
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
     * @return The slug of a specific pre-selected integration for this linking flow token. For examples of slugs, see https://docs.merge.dev/guides/merge-link/single-integration/.
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
     * @return Whether to generate a Magic Link URL on the Admin Needed screen during the linking flow. Defaults to false. For more information on Magic Link, see https://merge.dev/blog/integrations-fast-say-hello-to-magic-link.
     */
    @JsonProperty("hide_admin_magic_link")
    public Optional<Boolean> getHideAdminMagicLink() {
        return hideAdminMagicLink;
    }

    /**
     * @return An array of objects to specify the models and fields that will be disabled for a given Linked Account. Each object uses model_id, enabled_actions, and disabled_fields to specify the model, method, and fields that are scoped for a given Linked Account.
     */
    @JsonProperty("common_models")
    public Optional<List<CommonModelScopesBodyRequest>> getCommonModels() {
        return commonModels;
    }

    /**
     * @return When creating a Link Token, you can set permissions for Common Models that will apply to the account that is going to be linked. Any model or field not specified in link token payload will default to existing settings.
     */
    @JsonProperty("category_common_model_scopes")
    public Optional<Map<String, Optional<List<IndividualCommonModelScopeDeserializerRequest>>>>
            getCategoryCommonModelScopes() {
        return categoryCommonModelScopes;
    }

    /**
     * @return The following subset of IETF language tags can be used to configure localization.
     * <ul>
     * <li><code>en</code> - en</li>
     * <li><code>de</code> - de</li>
     * </ul>
     */
    @JsonProperty("language")
    public Optional<LanguageEnum> getLanguage() {
        return language;
    }

    /**
     * @return The boolean that indicates whether initial, periodic, and force syncs will be disabled.
     */
    @JsonProperty("are_syncs_disabled")
    public Optional<Boolean> getAreSyncsDisabled() {
        return areSyncsDisabled;
    }

    /**
     * @return A JSON object containing integration-specific configuration options.
     */
    @JsonProperty("integration_specific_config")
    public Optional<Map<String, JsonNode>> getIntegrationSpecificConfig() {
        return integrationSpecificConfig;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EndUserDetailsRequest && equalTo((EndUserDetailsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(EndUserDetailsRequest other) {
        return endUserEmailAddress.equals(other.endUserEmailAddress)
                && endUserOrganizationName.equals(other.endUserOrganizationName)
                && endUserOriginId.equals(other.endUserOriginId)
                && categories.equals(other.categories)
                && integration.equals(other.integration)
                && linkExpiryMins.equals(other.linkExpiryMins)
                && shouldCreateMagicLinkUrl.equals(other.shouldCreateMagicLinkUrl)
                && hideAdminMagicLink.equals(other.hideAdminMagicLink)
                && commonModels.equals(other.commonModels)
                && categoryCommonModelScopes.equals(other.categoryCommonModelScopes)
                && language.equals(other.language)
                && areSyncsDisabled.equals(other.areSyncsDisabled)
                && integrationSpecificConfig.equals(other.integrationSpecificConfig);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.endUserEmailAddress,
                this.endUserOrganizationName,
                this.endUserOriginId,
                this.categories,
                this.integration,
                this.linkExpiryMins,
                this.shouldCreateMagicLinkUrl,
                this.hideAdminMagicLink,
                this.commonModels,
                this.categoryCommonModelScopes,
                this.language,
                this.areSyncsDisabled,
                this.integrationSpecificConfig);
    }

    @java.lang.Override
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

        _FinalStage hideAdminMagicLink(Optional<Boolean> hideAdminMagicLink);

        _FinalStage hideAdminMagicLink(Boolean hideAdminMagicLink);

        _FinalStage commonModels(Optional<List<CommonModelScopesBodyRequest>> commonModels);

        _FinalStage commonModels(List<CommonModelScopesBodyRequest> commonModels);

        _FinalStage categoryCommonModelScopes(
                Optional<Map<String, Optional<List<IndividualCommonModelScopeDeserializerRequest>>>>
                        categoryCommonModelScopes);

        _FinalStage categoryCommonModelScopes(
                Map<String, Optional<List<IndividualCommonModelScopeDeserializerRequest>>> categoryCommonModelScopes);

        _FinalStage language(Optional<LanguageEnum> language);

        _FinalStage language(LanguageEnum language);

        _FinalStage areSyncsDisabled(Optional<Boolean> areSyncsDisabled);

        _FinalStage areSyncsDisabled(Boolean areSyncsDisabled);

        _FinalStage integrationSpecificConfig(Optional<Map<String, JsonNode>> integrationSpecificConfig);

        _FinalStage integrationSpecificConfig(Map<String, JsonNode> integrationSpecificConfig);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements EndUserEmailAddressStage, EndUserOrganizationNameStage, EndUserOriginIdStage, _FinalStage {
        private String endUserEmailAddress;

        private String endUserOrganizationName;

        private String endUserOriginId;

        private Optional<Map<String, JsonNode>> integrationSpecificConfig = Optional.empty();

        private Optional<Boolean> areSyncsDisabled = Optional.empty();

        private Optional<LanguageEnum> language = Optional.empty();

        private Optional<Map<String, Optional<List<IndividualCommonModelScopeDeserializerRequest>>>>
                categoryCommonModelScopes = Optional.empty();

        private Optional<List<CommonModelScopesBodyRequest>> commonModels = Optional.empty();

        private Optional<Boolean> hideAdminMagicLink = Optional.empty();

        private Optional<Boolean> shouldCreateMagicLinkUrl = Optional.empty();

        private Optional<Integer> linkExpiryMins = Optional.empty();

        private Optional<String> integration = Optional.empty();

        private List<CategoriesEnum> categories = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(EndUserDetailsRequest other) {
            endUserEmailAddress(other.getEndUserEmailAddress());
            endUserOrganizationName(other.getEndUserOrganizationName());
            endUserOriginId(other.getEndUserOriginId());
            categories(other.getCategories());
            integration(other.getIntegration());
            linkExpiryMins(other.getLinkExpiryMins());
            shouldCreateMagicLinkUrl(other.getShouldCreateMagicLinkUrl());
            hideAdminMagicLink(other.getHideAdminMagicLink());
            commonModels(other.getCommonModels());
            categoryCommonModelScopes(other.getCategoryCommonModelScopes());
            language(other.getLanguage());
            areSyncsDisabled(other.getAreSyncsDisabled());
            integrationSpecificConfig(other.getIntegrationSpecificConfig());
            return this;
        }

        /**
         * <p>Your end user's email address. This is purely for identification purposes - setting this value will not cause any emails to be sent.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("end_user_email_address")
        public EndUserOrganizationNameStage endUserEmailAddress(String endUserEmailAddress) {
            this.endUserEmailAddress = endUserEmailAddress;
            return this;
        }

        /**
         * <p>Your end user's organization.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("end_user_organization_name")
        public EndUserOriginIdStage endUserOrganizationName(String endUserOrganizationName) {
            this.endUserOrganizationName = endUserOrganizationName;
            return this;
        }

        /**
         * <p>This unique identifier typically represents the ID for your end user in your product's database. This value must be distinct from other Linked Accounts' unique identifiers.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("end_user_origin_id")
        public _FinalStage endUserOriginId(String endUserOriginId) {
            this.endUserOriginId = endUserOriginId;
            return this;
        }

        /**
         * <p>A JSON object containing integration-specific configuration options.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage integrationSpecificConfig(Map<String, JsonNode> integrationSpecificConfig) {
            this.integrationSpecificConfig = Optional.of(integrationSpecificConfig);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "integration_specific_config", nulls = Nulls.SKIP)
        public _FinalStage integrationSpecificConfig(Optional<Map<String, JsonNode>> integrationSpecificConfig) {
            this.integrationSpecificConfig = integrationSpecificConfig;
            return this;
        }

        /**
         * <p>The boolean that indicates whether initial, periodic, and force syncs will be disabled.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage areSyncsDisabled(Boolean areSyncsDisabled) {
            this.areSyncsDisabled = Optional.of(areSyncsDisabled);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "are_syncs_disabled", nulls = Nulls.SKIP)
        public _FinalStage areSyncsDisabled(Optional<Boolean> areSyncsDisabled) {
            this.areSyncsDisabled = areSyncsDisabled;
            return this;
        }

        /**
         * <p>The following subset of IETF language tags can be used to configure localization.</p>
         * <ul>
         * <li><code>en</code> - en</li>
         * <li><code>de</code> - de</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage language(LanguageEnum language) {
            this.language = Optional.of(language);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "language", nulls = Nulls.SKIP)
        public _FinalStage language(Optional<LanguageEnum> language) {
            this.language = language;
            return this;
        }

        /**
         * <p>When creating a Link Token, you can set permissions for Common Models that will apply to the account that is going to be linked. Any model or field not specified in link token payload will default to existing settings.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage categoryCommonModelScopes(
                Map<String, Optional<List<IndividualCommonModelScopeDeserializerRequest>>> categoryCommonModelScopes) {
            this.categoryCommonModelScopes = Optional.of(categoryCommonModelScopes);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "category_common_model_scopes", nulls = Nulls.SKIP)
        public _FinalStage categoryCommonModelScopes(
                Optional<Map<String, Optional<List<IndividualCommonModelScopeDeserializerRequest>>>>
                        categoryCommonModelScopes) {
            this.categoryCommonModelScopes = categoryCommonModelScopes;
            return this;
        }

        /**
         * <p>An array of objects to specify the models and fields that will be disabled for a given Linked Account. Each object uses model_id, enabled_actions, and disabled_fields to specify the model, method, and fields that are scoped for a given Linked Account.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage commonModels(List<CommonModelScopesBodyRequest> commonModels) {
            this.commonModels = Optional.of(commonModels);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "common_models", nulls = Nulls.SKIP)
        public _FinalStage commonModels(Optional<List<CommonModelScopesBodyRequest>> commonModels) {
            this.commonModels = commonModels;
            return this;
        }

        /**
         * <p>Whether to generate a Magic Link URL on the Admin Needed screen during the linking flow. Defaults to false. For more information on Magic Link, see https://merge.dev/blog/integrations-fast-say-hello-to-magic-link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage hideAdminMagicLink(Boolean hideAdminMagicLink) {
            this.hideAdminMagicLink = Optional.of(hideAdminMagicLink);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "hide_admin_magic_link", nulls = Nulls.SKIP)
        public _FinalStage hideAdminMagicLink(Optional<Boolean> hideAdminMagicLink) {
            this.hideAdminMagicLink = hideAdminMagicLink;
            return this;
        }

        /**
         * <p>Whether to generate a Magic Link URL. Defaults to false. For more information on Magic Link, see https://merge.dev/blog/integrations-fast-say-hello-to-magic-link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage shouldCreateMagicLinkUrl(Boolean shouldCreateMagicLinkUrl) {
            this.shouldCreateMagicLinkUrl = Optional.of(shouldCreateMagicLinkUrl);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "should_create_magic_link_url", nulls = Nulls.SKIP)
        public _FinalStage shouldCreateMagicLinkUrl(Optional<Boolean> shouldCreateMagicLinkUrl) {
            this.shouldCreateMagicLinkUrl = shouldCreateMagicLinkUrl;
            return this;
        }

        /**
         * <p>An integer number of minutes between [30, 720 or 10080 if for a Magic Link URL] for how long this token is valid. Defaults to 30.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage linkExpiryMins(Integer linkExpiryMins) {
            this.linkExpiryMins = Optional.of(linkExpiryMins);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "link_expiry_mins", nulls = Nulls.SKIP)
        public _FinalStage linkExpiryMins(Optional<Integer> linkExpiryMins) {
            this.linkExpiryMins = linkExpiryMins;
            return this;
        }

        /**
         * <p>The slug of a specific pre-selected integration for this linking flow token. For examples of slugs, see https://docs.merge.dev/guides/merge-link/single-integration/.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage integration(String integration) {
            this.integration = Optional.of(integration);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "integration", nulls = Nulls.SKIP)
        public _FinalStage integration(Optional<String> integration) {
            this.integration = integration;
            return this;
        }

        /**
         * <p>The integration categories to show in Merge Link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllCategories(List<CategoriesEnum> categories) {
            this.categories.addAll(categories);
            return this;
        }

        /**
         * <p>The integration categories to show in Merge Link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addCategories(CategoriesEnum categories) {
            this.categories.add(categories);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "categories", nulls = Nulls.SKIP)
        public _FinalStage categories(List<CategoriesEnum> categories) {
            this.categories.clear();
            this.categories.addAll(categories);
            return this;
        }

        @java.lang.Override
        public EndUserDetailsRequest build() {
            return new EndUserDetailsRequest(
                    endUserEmailAddress,
                    endUserOrganizationName,
                    endUserOriginId,
                    categories,
                    integration,
                    linkExpiryMins,
                    shouldCreateMagicLinkUrl,
                    hideAdminMagicLink,
                    commonModels,
                    categoryCommonModelScopes,
                    language,
                    areSyncsDisabled,
                    integrationSpecificConfig,
                    additionalProperties);
        }
    }
}
