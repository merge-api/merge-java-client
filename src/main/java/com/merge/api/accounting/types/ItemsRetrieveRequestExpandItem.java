/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class ItemsRetrieveRequestExpandItem {
    public static final ItemsRetrieveRequestExpandItem PURCHASE_ACCOUNT =
            new ItemsRetrieveRequestExpandItem(Value.PURCHASE_ACCOUNT, "purchase_account");

    public static final ItemsRetrieveRequestExpandItem SALES_TAX_RATE =
            new ItemsRetrieveRequestExpandItem(Value.SALES_TAX_RATE, "sales_tax_rate");

    public static final ItemsRetrieveRequestExpandItem PURCHASE_TAX_RATE =
            new ItemsRetrieveRequestExpandItem(Value.PURCHASE_TAX_RATE, "purchase_tax_rate");

    public static final ItemsRetrieveRequestExpandItem SALES_ACCOUNT =
            new ItemsRetrieveRequestExpandItem(Value.SALES_ACCOUNT, "sales_account");

    public static final ItemsRetrieveRequestExpandItem COMPANY =
            new ItemsRetrieveRequestExpandItem(Value.COMPANY, "company");

    private final Value value;

    private final String string;

    ItemsRetrieveRequestExpandItem(Value value, String string) {
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
        return (this == other)
                || (other instanceof ItemsRetrieveRequestExpandItem
                        && this.string.equals(((ItemsRetrieveRequestExpandItem) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case PURCHASE_ACCOUNT:
                return visitor.visitPurchaseAccount();
            case SALES_TAX_RATE:
                return visitor.visitSalesTaxRate();
            case PURCHASE_TAX_RATE:
                return visitor.visitPurchaseTaxRate();
            case SALES_ACCOUNT:
                return visitor.visitSalesAccount();
            case COMPANY:
                return visitor.visitCompany();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ItemsRetrieveRequestExpandItem valueOf(String value) {
        switch (value) {
            case "purchase_account":
                return PURCHASE_ACCOUNT;
            case "sales_tax_rate":
                return SALES_TAX_RATE;
            case "purchase_tax_rate":
                return PURCHASE_TAX_RATE;
            case "sales_account":
                return SALES_ACCOUNT;
            case "company":
                return COMPANY;
            default:
                return new ItemsRetrieveRequestExpandItem(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        COMPANY,

        PURCHASE_ACCOUNT,

        PURCHASE_TAX_RATE,

        SALES_ACCOUNT,

        SALES_TAX_RATE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitCompany();

        T visitPurchaseAccount();

        T visitPurchaseTaxRate();

        T visitSalesAccount();

        T visitSalesTaxRate();

        T visitUnknown(String unknownType);
    }
}
