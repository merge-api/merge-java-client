package com.merge.api.resources.filestorage.selectivesync.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.resources.filestorage.types.LinkedAccountSelectiveSyncConfigurationRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LinkedAccountSelectiveSyncConfigurationListRequest.Builder.class)
public final class LinkedAccountSelectiveSyncConfigurationListRequest {
    private final List<LinkedAccountSelectiveSyncConfigurationRequest> syncConfigurations;

    private LinkedAccountSelectiveSyncConfigurationListRequest(
            List<LinkedAccountSelectiveSyncConfigurationRequest> syncConfigurations) {
        this.syncConfigurations = syncConfigurations;
    }

    /**
     * @return The selective syncs associated with a linked account.
     */
    @JsonProperty("sync_configurations")
    public List<LinkedAccountSelectiveSyncConfigurationRequest> getSyncConfigurations() {
        return syncConfigurations;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LinkedAccountSelectiveSyncConfigurationListRequest
                && equalTo((LinkedAccountSelectiveSyncConfigurationListRequest) other);
    }

    private boolean equalTo(LinkedAccountSelectiveSyncConfigurationListRequest other) {
        return syncConfigurations.equals(other.syncConfigurations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.syncConfigurations);
    }

    @Override
    public String toString() {
        return "LinkedAccountSelectiveSyncConfigurationListRequest{" + "syncConfigurations: " + syncConfigurations
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<LinkedAccountSelectiveSyncConfigurationRequest> syncConfigurations = new ArrayList<>();

        private Builder() {}

        public Builder from(LinkedAccountSelectiveSyncConfigurationListRequest other) {
            syncConfigurations(other.getSyncConfigurations());
            return this;
        }

        @JsonSetter(value = "sync_configurations", nulls = Nulls.SKIP)
        public Builder syncConfigurations(List<LinkedAccountSelectiveSyncConfigurationRequest> syncConfigurations) {
            this.syncConfigurations.clear();
            this.syncConfigurations.addAll(syncConfigurations);
            return this;
        }

        public Builder addSyncConfigurations(LinkedAccountSelectiveSyncConfigurationRequest syncConfigurations) {
            this.syncConfigurations.add(syncConfigurations);
            return this;
        }

        public Builder addAllSyncConfigurations(
                List<LinkedAccountSelectiveSyncConfigurationRequest> syncConfigurations) {
            this.syncConfigurations.addAll(syncConfigurations);
            return this;
        }

        public LinkedAccountSelectiveSyncConfigurationListRequest build() {
            return new LinkedAccountSelectiveSyncConfigurationListRequest(syncConfigurations);
        }
    }
}
