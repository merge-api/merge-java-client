/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ticketing.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class CategoryEnum {
    public static final CategoryEnum HRIS = new CategoryEnum(Value.HRIS, "hris");

    public static final CategoryEnum TICKETING = new CategoryEnum(Value.TICKETING, "ticketing");

    public static final CategoryEnum CRM = new CategoryEnum(Value.CRM, "crm");

    public static final CategoryEnum FILESTORAGE = new CategoryEnum(Value.FILESTORAGE, "filestorage");

    public static final CategoryEnum ACCOUNTING = new CategoryEnum(Value.ACCOUNTING, "accounting");

    public static final CategoryEnum MKTG = new CategoryEnum(Value.MKTG, "mktg");

    public static final CategoryEnum ATS = new CategoryEnum(Value.ATS, "ats");

    private final Value value;

    private final String string;

    CategoryEnum(Value value, String string) {
        this.value = value;
        this.string = string;
    }

    public Value getEnumValue() {
        return value;
    }

    @java.lang.Override
    @JsonValue
    public String toString() {
        return this.string;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        return (this == other) || (other instanceof CategoryEnum && this.string.equals(((CategoryEnum) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case HRIS:
                return visitor.visitHris();
            case TICKETING:
                return visitor.visitTicketing();
            case CRM:
                return visitor.visitCrm();
            case FILESTORAGE:
                return visitor.visitFilestorage();
            case ACCOUNTING:
                return visitor.visitAccounting();
            case MKTG:
                return visitor.visitMktg();
            case ATS:
                return visitor.visitAts();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CategoryEnum valueOf(String value) {
        switch (value) {
            case "hris":
                return HRIS;
            case "ticketing":
                return TICKETING;
            case "crm":
                return CRM;
            case "filestorage":
                return FILESTORAGE;
            case "accounting":
                return ACCOUNTING;
            case "mktg":
                return MKTG;
            case "ats":
                return ATS;
            default:
                return new CategoryEnum(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        HRIS,

        ATS,

        ACCOUNTING,

        TICKETING,

        CRM,

        MKTG,

        FILESTORAGE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitHris();

        T visitAts();

        T visitAccounting();

        T visitTicketing();

        T visitCrm();

        T visitMktg();

        T visitFilestorage();

        T visitUnknown(String unknownType);
    }
}
