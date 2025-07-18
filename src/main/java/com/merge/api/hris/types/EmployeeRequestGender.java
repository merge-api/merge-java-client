/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.merge.api.core.ObjectMappers;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = EmployeeRequestGender.Deserializer.class)
public final class EmployeeRequestGender {
    private final Object value;

    private final int type;

    private EmployeeRequestGender(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    @SuppressWarnings("unchecked")
    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((GenderEnum) this.value);
        } else if (this.type == 1) {
            return visitor.visit((String) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmployeeRequestGender && equalTo((EmployeeRequestGender) other);
    }

    private boolean equalTo(EmployeeRequestGender other) {
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

    public static EmployeeRequestGender of(GenderEnum value) {
        return new EmployeeRequestGender(value, 0);
    }

    public static EmployeeRequestGender of(String value) {
        return new EmployeeRequestGender(value, 1);
    }

    public interface Visitor<T> {
        T visit(GenderEnum value);

        T visit(String value);
    }

    static final class Deserializer extends StdDeserializer<EmployeeRequestGender> {
        Deserializer() {
            super(EmployeeRequestGender.class);
        }

        @java.lang.Override
        public EmployeeRequestGender deserialize(JsonParser p, DeserializationContext context) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, GenderEnum.class));
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
