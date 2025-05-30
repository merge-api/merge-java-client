/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BenefitPlanTypeEnum {
    MEDICAL("MEDICAL"),

    HEALTH_SAVINGS("HEALTH_SAVINGS"),

    INSURANCE("INSURANCE"),

    RETIREMENT("RETIREMENT"),

    OTHER("OTHER");

    private final String value;

    BenefitPlanTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
