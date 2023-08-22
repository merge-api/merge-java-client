package com.merge.api.resources.ticketing.types;

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
@JsonDeserialize(builder = Collection.Builder.class)
public final class Collection {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> name;

    private final Optional<String> description;

    private final Optional<CollectionCollectionType> collectionType;

    private final Optional<CollectionParentCollection> parentCollection;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<CollectionAccessLevel> accessLevel;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Collection(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> name,
            Optional<String> description,
            Optional<CollectionCollectionType> collectionType,
            Optional<CollectionParentCollection> parentCollection,
            Optional<Boolean> remoteWasDeleted,
            Optional<CollectionAccessLevel> accessLevel,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.name = name;
        this.description = description;
        this.collectionType = collectionType;
        this.parentCollection = parentCollection;
        this.remoteWasDeleted = remoteWasDeleted;
        this.accessLevel = accessLevel;
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
     * @return The collection's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The collection's description.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The collection's type.
     * <ul>
     * <li><code>LIST</code> - LIST</li>
     * <li><code>PROJECT</code> - PROJECT</li>
     * </ul>
     */
    @JsonProperty("collection_type")
    public Optional<CollectionCollectionType> getCollectionType() {
        return collectionType;
    }

    /**
     * @return The parent collection for this collection.
     */
    @JsonProperty("parent_collection")
    public Optional<CollectionParentCollection> getParentCollection() {
        return parentCollection;
    }

    /**
     * @return Indicates whether or not this object has been deleted by third party webhooks.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    /**
     * @return The level of access a User has to the Collection and its sub-objects.
     * <ul>
     * <li><code>PRIVATE</code> - PRIVATE</li>
     * <li><code>COMPANY</code> - COMPANY</li>
     * <li><code>PUBLIC</code> - PUBLIC</li>
     * </ul>
     */
    @JsonProperty("access_level")
    public Optional<CollectionAccessLevel> getAccessLevel() {
        return accessLevel;
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
        return other instanceof Collection && equalTo((Collection) other);
    }

    private boolean equalTo(Collection other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && name.equals(other.name)
                && description.equals(other.description)
                && collectionType.equals(other.collectionType)
                && parentCollection.equals(other.parentCollection)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && accessLevel.equals(other.accessLevel)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.name,
                this.description,
                this.collectionType,
                this.parentCollection,
                this.remoteWasDeleted,
                this.accessLevel,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<CollectionCollectionType> collectionType = Optional.empty();

        private Optional<CollectionParentCollection> parentCollection = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<CollectionAccessLevel> accessLevel = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Collection other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            name(other.getName());
            description(other.getDescription());
            collectionType(other.getCollectionType());
            parentCollection(other.getParentCollection());
            remoteWasDeleted(other.getRemoteWasDeleted());
            accessLevel(other.getAccessLevel());
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @JsonSetter(value = "collection_type", nulls = Nulls.SKIP)
        public Builder collectionType(Optional<CollectionCollectionType> collectionType) {
            this.collectionType = collectionType;
            return this;
        }

        public Builder collectionType(CollectionCollectionType collectionType) {
            this.collectionType = Optional.of(collectionType);
            return this;
        }

        @JsonSetter(value = "parent_collection", nulls = Nulls.SKIP)
        public Builder parentCollection(Optional<CollectionParentCollection> parentCollection) {
            this.parentCollection = parentCollection;
            return this;
        }

        public Builder parentCollection(CollectionParentCollection parentCollection) {
            this.parentCollection = Optional.of(parentCollection);
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

        @JsonSetter(value = "access_level", nulls = Nulls.SKIP)
        public Builder accessLevel(Optional<CollectionAccessLevel> accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        public Builder accessLevel(CollectionAccessLevel accessLevel) {
            this.accessLevel = Optional.of(accessLevel);
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

        public Collection build() {
            return new Collection(
                    id,
                    remoteId,
                    name,
                    description,
                    collectionType,
                    parentCollection,
                    remoteWasDeleted,
                    accessLevel,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}
