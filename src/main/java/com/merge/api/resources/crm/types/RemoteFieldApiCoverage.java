/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = RemoteFieldApiCoverage.Deserializer.class)
public final class RemoteFieldApiCoverage {
    private final Object value;

    private final int type;

    private RemoteFieldApiCoverage(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((int) this.value);
        } else if (this.type == 1) {
            return visitor.visit((double) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteFieldApiCoverage && equalTo((RemoteFieldApiCoverage) other);
    }

    private boolean equalTo(RemoteFieldApiCoverage other) {
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

    public static RemoteFieldApiCoverage of(int value) {
        return new RemoteFieldApiCoverage(value, 0);
    }

    public static RemoteFieldApiCoverage of(double value) {
        return new RemoteFieldApiCoverage(value, 1);
    }

    public interface Visitor<T> {
        T visit(int value);

        T visit(double value);
    }

    static final class Deserializer extends StdDeserializer<RemoteFieldApiCoverage> {
        Deserializer() {
            super(RemoteFieldApiCoverage.class);
        }

        @java.lang.Override
        public RemoteFieldApiCoverage deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = p.readValueAs(Object.class);
            if (value instanceof Integer) {
                return of((Integer) value);
            }
            if (value instanceof Double) {
                return of((Double) value);
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
