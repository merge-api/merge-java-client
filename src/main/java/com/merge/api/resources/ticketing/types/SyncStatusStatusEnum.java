package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SyncStatusStatusEnum {
    SYNCING("SYNCING"),

    DONE("DONE"),

    FAILED("FAILED"),

    DISABLED("DISABLED"),

    PAUSED("PAUSED"),

    PARTIALLY_SYNCED("PARTIALLY_SYNCED");

    private final String value;

    SyncStatusStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
