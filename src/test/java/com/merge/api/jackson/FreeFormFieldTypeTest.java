package com.merge.api.jackson;

import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.core.ObjectMappers;
import com.merge.api.hris.types.Employee;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public final class FreeFormFieldTypeTest {

    @Test
    public void fieldMappingsDeserializesToNeutralMap() throws Exception {
        String json = "{\"id\":\"e-1\",\"field_mappings\":{"
                + "\"organization_defined_targets\":{\"custom_key\":\"custom_value\"},"
                + "\"linked_account_defined_targets\":{}}}";

        Employee employee = ObjectMappers.JSON_MAPPER.readValue(json, Employee.class);

        Optional<Map<String, Object>> fieldMappings = employee.getFieldMappings();
        assertTrue(fieldMappings.isPresent());

        Object orgTargets = fieldMappings.get().get("organization_defined_targets");
        assertTrue(orgTargets instanceof Map);

        @SuppressWarnings("unchecked")
        Object customValue = ((Map<String, Object>) orgTargets).get("custom_key");
        assertEquals("custom_value", customValue);
        assertTrue(customValue instanceof String);
    }

    @Test
    public void fieldMappingsSurvivesRoundTrip() throws Exception {
        String json = "{\"field_mappings\":{\"a\":{\"b\":\"c\"}}}";

        Employee employee = ObjectMappers.JSON_MAPPER.readValue(json, Employee.class);
        String serialized = ObjectMappers.JSON_MAPPER.writeValueAsString(employee);
        Employee reparsed = ObjectMappers.JSON_MAPPER.readValue(serialized, Employee.class);

        assertEquals(employee.getFieldMappings(), reparsed.getFieldMappings());
    }
}
