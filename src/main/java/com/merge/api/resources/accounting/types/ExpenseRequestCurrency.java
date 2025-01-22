/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.merge.api.core.ObjectMappers;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = ExpenseRequestCurrency.Deserializer.class)
public final class ExpenseRequestCurrency {
    private final Object value;

    private final int type;

    private ExpenseRequestCurrency(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((TransactionCurrencyEnum) this.value);
        } else if (this.type == 1) {
            return visitor.visit((String) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ExpenseRequestCurrency && equalTo((ExpenseRequestCurrency) other);
    }

    private boolean equalTo(ExpenseRequestCurrency other) {
        return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @java.lang.Override
    public String toString() {
        return this.value.toString();
    }

    public static ExpenseRequestCurrency of(TransactionCurrencyEnum value) {
        return new ExpenseRequestCurrency(value, 0);
    }

    public static ExpenseRequestCurrency of(String value) {
        return new ExpenseRequestCurrency(value, 1);
    }

    public interface Visitor<T> {
        T visit(TransactionCurrencyEnum value);

        T visit(String value);
    }

    static final class Deserializer extends StdDeserializer<ExpenseRequestCurrency> {
        Deserializer() {
            super(ExpenseRequestCurrency.class);
        }

        @java.lang.Override
        public ExpenseRequestCurrency deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, TransactionCurrencyEnum.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, String.class));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
