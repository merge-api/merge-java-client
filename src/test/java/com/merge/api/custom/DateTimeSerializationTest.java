package com.merge.api.custom;

import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.core.ObjectMappers;
import com.merge.api.hris.types.Employee;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;

public final class DateTimeSerializationTest {

    @Test
    public void utcDatetimeSerializesWithZuluOffset() throws Exception {
        Employee employee =
                ObjectMappers.JSON_MAPPER.readValue("{\"modified_at\":\"2026-01-15T09:30:00Z\"}", Employee.class);

        assertTrue(employee.getModifiedAt().isPresent());
        String serialized = ObjectMappers.JSON_MAPPER.writeValueAsString(employee);
        assertTrue(serialized.contains("\"modified_at\":\"2026-01-15T09:30:00Z\""), serialized);
    }

    @Test
    public void datetimeRoundTripPreservesInstant() throws Exception {
        Employee employee =
                ObjectMappers.JSON_MAPPER.readValue("{\"modified_at\":\"2026-01-15T09:30:00-05:00\"}", Employee.class);

        OffsetDateTime modifiedAt = employee.getModifiedAt().get();
        assertEquals(OffsetDateTime.parse("2026-01-15T09:30:00-05:00").toInstant(), modifiedAt.toInstant());
    }
}
