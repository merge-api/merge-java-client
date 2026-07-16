package com.merge.api.custom;

import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.accounting.types.RoleEnum;
import com.merge.api.ats.types.SyncStatus;
import com.merge.api.core.ObjectMappers;
import org.junit.jupiter.api.Test;

public final class EnumForwardCompatTest {

    @Test
    public void knownValueDeserializesToConstant() throws Exception {
        RoleEnum role = ObjectMappers.JSON_MAPPER.readValue("\"ADMIN\"", RoleEnum.class);
        assertEquals(RoleEnum.Value.ADMIN, role.getEnumValue());
        assertEquals("ADMIN", role.toString());
        assertEquals(RoleEnum.ADMIN, role);
    }

    @Test
    public void unknownValueDeserializesWithoutThrowing() throws Exception {
        RoleEnum role = ObjectMappers.JSON_MAPPER.readValue("\"FUTURE_ROLE\"", RoleEnum.class);
        assertEquals(RoleEnum.Value.UNKNOWN, role.getEnumValue());
        assertEquals("FUTURE_ROLE", role.toString());
    }

    @Test
    public void unknownValueSurvivesRoundTrip() throws Exception {
        RoleEnum role = RoleEnum.valueOf("FUTURE_ROLE");
        String serialized = ObjectMappers.JSON_MAPPER.writeValueAsString(role);
        assertEquals("\"FUTURE_ROLE\"", serialized);
    }

    @Test
    public void unknownEnumInModelFieldDoesNotThrow() throws Exception {
        String json = "{\"model_id\":\"m-1\",\"model_name\":\"Employee\","
                + "\"selective_sync_configurations_usage\":\"FUTURE_USAGE\"}";

        SyncStatus status = ObjectMappers.JSON_MAPPER.readValue(json, SyncStatus.class);

        assertTrue(status.getSelectiveSyncConfigurationsUsage().isPresent());
        assertEquals(
                "FUTURE_USAGE",
                status.getSelectiveSyncConfigurationsUsage().get().toString());
    }
}
