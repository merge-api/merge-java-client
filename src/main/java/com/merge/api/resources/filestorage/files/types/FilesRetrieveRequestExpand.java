package com.merge.api.resources.filestorage.files.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FilesRetrieveRequestExpand {
    DRIVE("drive"),

    FOLDER("folder"),

    FOLDER_DRIVE("folder,drive"),

    PERMISSIONS("permissions"),

    PERMISSIONS_DRIVE("permissions,drive"),

    PERMISSIONS_FOLDER("permissions,folder"),

    PERMISSIONS_FOLDER_DRIVE("permissions,folder,drive");

    private final String value;

    FilesRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
