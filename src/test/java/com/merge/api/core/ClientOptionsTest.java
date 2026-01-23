package com.merge.api.core;

import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ClientOptionsTest {

    @Test
    public void testDefaultClientTimeouts() {
        // Test: No custom client, no explicit timeout -> uses 60s default
        ClientOptions options = ClientOptions.builder()
                .environment(Environment.PRODUCTION)
                .build();

        OkHttpClient client = options.httpClient();
        assertEquals(60, client.callTimeoutMillis() / 1000);
        assertEquals(0, client.connectTimeoutMillis());
        assertEquals(0, client.readTimeoutMillis());
        assertEquals(0, client.writeTimeoutMillis());
    }

    @Test
    public void testDefaultClientWithExplicitTimeout() {
        // Test: No custom client, explicit timeout -> uses explicit timeout
        ClientOptions options = ClientOptions.builder()
                .environment(Environment.PRODUCTION)
                .timeout(120)
                .build();

        OkHttpClient client = options.httpClient();
        assertEquals(120, client.callTimeoutMillis() / 1000);
        assertEquals(0, client.connectTimeoutMillis());
        assertEquals(0, client.readTimeoutMillis());
        assertEquals(0, client.writeTimeoutMillis());
    }

    @Test
    public void testCustomClientWithoutExplicitTimeout() {
        // Test: Custom client with OkHttp defaults, no explicit SDK timeout -> uses 60s default
        OkHttpClient customClient = new OkHttpClient.Builder().build();

        ClientOptions options = ClientOptions.builder()
                .environment(Environment.PRODUCTION)
                .httpClient(customClient)
                .build();

        OkHttpClient client = options.httpClient();
        assertEquals(60, client.callTimeoutMillis() / 1000);
        assertEquals(0, client.connectTimeoutMillis());
        assertEquals(0, client.readTimeoutMillis());
        assertEquals(0, client.writeTimeoutMillis());
    }

    @Test
    public void testCustomClientWithExplicitTimeout() {
        // Test: Custom client with explicit SDK timeout -> uses explicit timeout
        OkHttpClient customClient = new OkHttpClient.Builder().build();

        ClientOptions options = ClientOptions.builder()
                .environment(Environment.PRODUCTION)
                .httpClient(customClient)
                .timeout(90)
                .build();

        OkHttpClient client = options.httpClient();
        assertEquals(90, client.callTimeoutMillis() / 1000);
        assertEquals(0, client.connectTimeoutMillis());
        assertEquals(0, client.readTimeoutMillis());
        assertEquals(0, client.writeTimeoutMillis());
    }

    @Test
    public void testCustomClientOverridesOriginalTimeouts() {
        // Test: Custom client with different timeouts -> SDK overrides them
        OkHttpClient customClient = new OkHttpClient.Builder()
                .callTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
                .build();

        ClientOptions options = ClientOptions.builder()
                .environment(Environment.PRODUCTION)
                .httpClient(customClient)
                .timeout(120)
                .build();

        OkHttpClient client = options.httpClient();
        // SDK should override all timeouts
        assertEquals(120, client.callTimeoutMillis() / 1000);
        assertEquals(0, client.connectTimeoutMillis());
        assertEquals(0, client.readTimeoutMillis());
        assertEquals(0, client.writeTimeoutMillis());
    }

    @Test
    public void testTimeoutConsistencyBetweenCustomAndDefaultClients() {
        // Test: Both custom and default clients should have same timeout behavior

        // Default client
        ClientOptions defaultOptions = ClientOptions.builder()
                .environment(Environment.PRODUCTION)
                .build();

        // Custom client
        OkHttpClient customClient = new OkHttpClient.Builder().build();
        ClientOptions customOptions = ClientOptions.builder()
                .environment(Environment.PRODUCTION)
                .httpClient(customClient)
                .build();

        OkHttpClient defaultHttpClient = defaultOptions.httpClient();
        OkHttpClient customHttpClient = customOptions.httpClient();

        // Both should have same timeout configuration
        assertEquals(defaultHttpClient.callTimeoutMillis(), customHttpClient.callTimeoutMillis());
        assertEquals(defaultHttpClient.connectTimeoutMillis(), customHttpClient.connectTimeoutMillis());
        assertEquals(defaultHttpClient.readTimeoutMillis(), customHttpClient.readTimeoutMillis());
        assertEquals(defaultHttpClient.writeTimeoutMillis(), customHttpClient.writeTimeoutMillis());
    }

    @Test
    public void testTimeoutReflectedInClientOptionsTimeout() {
        // Test: ClientOptions.timeout() method returns actual client timeout
        ClientOptions options = ClientOptions.builder()
                .environment(Environment.PRODUCTION)
                .timeout(75)
                .build();

        assertEquals(75, options.timeout(null));
    }
}