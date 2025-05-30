/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = AccountDetailsAndActionsIntegration.Builder.class)
public final class AccountDetailsAndActionsIntegration {
    private final String name;

    private final List<CategoriesEnum> categories;

    private final Optional<String> image;

    private final Optional<String> squareImage;

    private final String color;

    private final String slug;

    private final boolean passthroughAvailable;

    private final Optional<List<ModelOperation>> availableModelOperations;

    private final Map<String, Object> additionalProperties;

    private AccountDetailsAndActionsIntegration(
            String name,
            List<CategoriesEnum> categories,
            Optional<String> image,
            Optional<String> squareImage,
            String color,
            String slug,
            boolean passthroughAvailable,
            Optional<List<ModelOperation>> availableModelOperations,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.categories = categories;
        this.image = image;
        this.squareImage = squareImage;
        this.color = color;
        this.slug = slug;
        this.passthroughAvailable = passthroughAvailable;
        this.availableModelOperations = availableModelOperations;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("categories")
    public List<CategoriesEnum> getCategories() {
        return categories;
    }

    @JsonProperty("image")
    public Optional<String> getImage() {
        return image;
    }

    @JsonProperty("square_image")
    public Optional<String> getSquareImage() {
        return squareImage;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("passthrough_available")
    public boolean getPassthroughAvailable() {
        return passthroughAvailable;
    }

    @JsonProperty("available_model_operations")
    public Optional<List<ModelOperation>> getAvailableModelOperations() {
        return availableModelOperations;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AccountDetailsAndActionsIntegration
                && equalTo((AccountDetailsAndActionsIntegration) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(AccountDetailsAndActionsIntegration other) {
        return name.equals(other.name)
                && categories.equals(other.categories)
                && image.equals(other.image)
                && squareImage.equals(other.squareImage)
                && color.equals(other.color)
                && slug.equals(other.slug)
                && passthroughAvailable == other.passthroughAvailable
                && availableModelOperations.equals(other.availableModelOperations);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.name,
                this.categories,
                this.image,
                this.squareImage,
                this.color,
                this.slug,
                this.passthroughAvailable,
                this.availableModelOperations);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        ColorStage name(@NotNull String name);

        Builder from(AccountDetailsAndActionsIntegration other);
    }

    public interface ColorStage {
        SlugStage color(@NotNull String color);
    }

    public interface SlugStage {
        PassthroughAvailableStage slug(@NotNull String slug);
    }

    public interface PassthroughAvailableStage {
        _FinalStage passthroughAvailable(boolean passthroughAvailable);
    }

    public interface _FinalStage {
        AccountDetailsAndActionsIntegration build();

        _FinalStage categories(List<CategoriesEnum> categories);

        _FinalStage addCategories(CategoriesEnum categories);

        _FinalStage addAllCategories(List<CategoriesEnum> categories);

        _FinalStage image(Optional<String> image);

        _FinalStage image(String image);

        _FinalStage squareImage(Optional<String> squareImage);

        _FinalStage squareImage(String squareImage);

        _FinalStage availableModelOperations(Optional<List<ModelOperation>> availableModelOperations);

        _FinalStage availableModelOperations(List<ModelOperation> availableModelOperations);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements NameStage, ColorStage, SlugStage, PassthroughAvailableStage, _FinalStage {
        private String name;

        private String color;

        private String slug;

        private boolean passthroughAvailable;

        private Optional<List<ModelOperation>> availableModelOperations = Optional.empty();

        private Optional<String> squareImage = Optional.empty();

        private Optional<String> image = Optional.empty();

        private List<CategoriesEnum> categories = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(AccountDetailsAndActionsIntegration other) {
            name(other.getName());
            categories(other.getCategories());
            image(other.getImage());
            squareImage(other.getSquareImage());
            color(other.getColor());
            slug(other.getSlug());
            passthroughAvailable(other.getPassthroughAvailable());
            availableModelOperations(other.getAvailableModelOperations());
            return this;
        }

        @java.lang.Override
        @JsonSetter("name")
        public ColorStage name(@NotNull String name) {
            this.name = name;
            return this;
        }

        @java.lang.Override
        @JsonSetter("color")
        public SlugStage color(@NotNull String color) {
            this.color = color;
            return this;
        }

        @java.lang.Override
        @JsonSetter("slug")
        public PassthroughAvailableStage slug(@NotNull String slug) {
            this.slug = slug;
            return this;
        }

        @java.lang.Override
        @JsonSetter("passthrough_available")
        public _FinalStage passthroughAvailable(boolean passthroughAvailable) {
            this.passthroughAvailable = passthroughAvailable;
            return this;
        }

        @java.lang.Override
        public _FinalStage availableModelOperations(List<ModelOperation> availableModelOperations) {
            this.availableModelOperations = Optional.ofNullable(availableModelOperations);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "available_model_operations", nulls = Nulls.SKIP)
        public _FinalStage availableModelOperations(Optional<List<ModelOperation>> availableModelOperations) {
            this.availableModelOperations = availableModelOperations;
            return this;
        }

        @java.lang.Override
        public _FinalStage squareImage(String squareImage) {
            this.squareImage = Optional.ofNullable(squareImage);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "square_image", nulls = Nulls.SKIP)
        public _FinalStage squareImage(Optional<String> squareImage) {
            this.squareImage = squareImage;
            return this;
        }

        @java.lang.Override
        public _FinalStage image(String image) {
            this.image = Optional.ofNullable(image);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "image", nulls = Nulls.SKIP)
        public _FinalStage image(Optional<String> image) {
            this.image = image;
            return this;
        }

        @java.lang.Override
        public _FinalStage addAllCategories(List<CategoriesEnum> categories) {
            this.categories.addAll(categories);
            return this;
        }

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
        public AccountDetailsAndActionsIntegration build() {
            return new AccountDetailsAndActionsIntegration(
                    name,
                    categories,
                    image,
                    squareImage,
                    color,
                    slug,
                    passthroughAvailable,
                    availableModelOperations,
                    additionalProperties);
        }
    }
}
