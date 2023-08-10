package com.merge.api.resources.hris.types;

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
    @Override
    public String toString() {
        return this.value;
    }
}
