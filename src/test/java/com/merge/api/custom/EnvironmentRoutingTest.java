package com.merge.api.custom;

import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.core.Environment;
import org.junit.jupiter.api.Test;

public final class EnvironmentRoutingTest {

    @Test
    public void productionRoutesToProductionHost() {
        assertEquals("https://api.merge.dev/api", Environment.PRODUCTION.getUrl());
    }

    @Test
    public void sandboxRoutesToSandboxHost() {
        assertEquals("https://api-sandbox.merge.dev/api", Environment.SANDBOX.getUrl());
    }

    @Test
    public void productionEuRoutesToEuHost() {
        assertEquals("https://api-eu.merge.dev/api", Environment.PRODUCTION_EU.getUrl());
    }

    @Test
    public void customUrlRoundTrips() {
        assertEquals("http://localhost:8080", Environment.custom("http://localhost:8080").getUrl());
    }
}
