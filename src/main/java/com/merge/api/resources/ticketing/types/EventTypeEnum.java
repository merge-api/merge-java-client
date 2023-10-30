package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EventTypeEnum {
    CREATED_REMOTE_PRODUCTION_API_KEY("CREATED_REMOTE_PRODUCTION_API_KEY"),

    DELETED_REMOTE_PRODUCTION_API_KEY("DELETED_REMOTE_PRODUCTION_API_KEY"),

    CREATED_TEST_API_KEY("CREATED_TEST_API_KEY"),

    DELETED_TEST_API_KEY("DELETED_TEST_API_KEY"),

    REGENERATED_PRODUCTION_API_KEY("REGENERATED_PRODUCTION_API_KEY"),

    INVITED_USER("INVITED_USER"),

    TWO_FACTOR_AUTH_ENABLED("TWO_FACTOR_AUTH_ENABLED"),

    TWO_FACTOR_AUTH_DISABLED("TWO_FACTOR_AUTH_DISABLED"),

    DELETED_LINKED_ACCOUNT("DELETED_LINKED_ACCOUNT"),

    CREATED_DESTINATION("CREATED_DESTINATION"),

    DELETED_DESTINATION("DELETED_DESTINATION"),

    CHANGED_SCOPES("CHANGED_SCOPES"),

    CHANGED_PERSONAL_INFORMATION("CHANGED_PERSONAL_INFORMATION"),

    CHANGED_ORGANIZATION_SETTINGS("CHANGED_ORGANIZATION_SETTINGS"),

    ENABLED_INTEGRATION("ENABLED_INTEGRATION"),

    DISABLED_INTEGRATION("DISABLED_INTEGRATION"),

    ENABLED_CATEGORY("ENABLED_CATEGORY"),

    DISABLED_CATEGORY("DISABLED_CATEGORY"),

    CHANGED_PASSWORD("CHANGED_PASSWORD"),

    RESET_PASSWORD("RESET_PASSWORD"),

    ENABLED_REDACT_UNMAPPED_DATA_FOR_ORGANIZATION("ENABLED_REDACT_UNMAPPED_DATA_FOR_ORGANIZATION"),

    ENABLED_REDACT_UNMAPPED_DATA_FOR_LINKED_ACCOUNT("ENABLED_REDACT_UNMAPPED_DATA_FOR_LINKED_ACCOUNT"),

    DISABLED_REDACT_UNMAPPED_DATA_FOR_ORGANIZATION("DISABLED_REDACT_UNMAPPED_DATA_FOR_ORGANIZATION"),

    DISABLED_REDACT_UNMAPPED_DATA_FOR_LINKED_ACCOUNT("DISABLED_REDACT_UNMAPPED_DATA_FOR_LINKED_ACCOUNT");

    private final String value;

    EventTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
