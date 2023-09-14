package com.merge.api.resources.filestorage.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.merge.api.core.ObjectMappers;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(using = FolderRequestPermissions.Deserializer.class)
public final class FolderRequestPermissions {
    private final Object value;

    private final int type;

    private FolderRequestPermissions(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((String) this.value);
        } else if (this.type == 1) {
            return visitor.visit((JsonNode) this.value);
        } else if (this.type == 2) {
            return visitor.visit((List<FolderRequestPermissionsItem>) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FolderRequestPermissions && equalTo((FolderRequestPermissions) other);
    }

    private boolean equalTo(FolderRequestPermissions other) {
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

    public static FolderRequestPermissions of(String value) {
        return new FolderRequestPermissions(value, 0);
    }

    public static FolderRequestPermissions of(JsonNode value) {
        return new FolderRequestPermissions(value, 1);
    }

    public static FolderRequestPermissions of(List<FolderRequestPermissionsItem> value) {
        return new FolderRequestPermissions(value, 2);
    }

    public interface Visitor<T> {
        T visit(String value);

        T visit(JsonNode value);

        T visit(List<FolderRequestPermissionsItem> value);
    }

    static final class Deserializer extends StdDeserializer<FolderRequestPermissions> {
        Deserializer() {
            super(FolderRequestPermissions.class);
        }

        @Override
        public FolderRequestPermissions deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, String.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, JsonNode.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(
                        value, new TypeReference<List<FolderRequestPermissionsItem>>() {}));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}