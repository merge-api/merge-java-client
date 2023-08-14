package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.merge.api.core.ObjectMappers;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = RemoteFieldClassFieldType.Deserializer.class)
public final class RemoteFieldClassFieldType {
    private final Object value;

    private final int type;

    private RemoteFieldClassFieldType(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((FieldTypeEnum) this.value);
        } else if (this.type == 1) {
            return visitor.visit((String) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteFieldClassFieldType && equalTo((RemoteFieldClassFieldType) other);
    }

    private boolean equalTo(RemoteFieldClassFieldType other) {
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public static RemoteFieldClassFieldType of(FieldTypeEnum value) {
        return new RemoteFieldClassFieldType(value, 0);
    }

    public static RemoteFieldClassFieldType of(String value) {
        return new RemoteFieldClassFieldType(value, 1);
    }

    public interface Visitor<T> {
        T visit(FieldTypeEnum value);

        T visit(String value);
    }

    static final class Deserializer extends StdDeserializer<RemoteFieldClassFieldType> {
        Deserializer() {
            super(RemoteFieldClassFieldType.class);
        }

        @Override
        public RemoteFieldClassFieldType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, FieldTypeEnum.class));
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
