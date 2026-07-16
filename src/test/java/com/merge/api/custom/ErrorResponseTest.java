package com.merge.api.custom;

import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.MergeApiClient;
import com.merge.api.core.ApiError;
import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class ErrorResponseTest {

    private HttpServer server;
    private MergeApiClient client;

    private int statusToReturn = 200;
    private String bodyToReturn = "{}";
    private String contentType = "application/json";
    private volatile String lastPath;

    @BeforeEach
    public void setUp() throws Exception {
        server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
        server.createContext("/", exchange -> {
            lastPath = exchange.getRequestURI().getPath();
            byte[] payload = bodyToReturn.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", contentType);
            exchange.sendResponseHeaders(statusToReturn, payload.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(payload);
            }
        });
        server.start();
        int port = server.getAddress().getPort();
        client = MergeApiClient.builder()
                .apiKey("test-key")
                .accountToken("test-account-token")
                .url("http://localhost:" + port)
                .build();
    }

    @AfterEach
    public void tearDown() {
        if (server != null) {
            server.stop(0);
        }
    }

    @Test
    public void notFoundThrowsApiErrorWithStatusAndBody() {
        statusToReturn = 404;
        bodyToReturn = "{\"detail\":\"Not found.\"}";
        contentType = "application/json";

        ApiError error =
                assertThrows(ApiError.class, () -> client.hris().employees().retrieve("does-not-exist"));
        assertEquals(404, error.statusCode());
        assertNotNull(error.body());
    }

    @Test
    public void nonJsonErrorBodyDoesNotCrashHandler() {
        statusToReturn = 502;
        bodyToReturn = "Bad Gateway";
        contentType = "text/plain";

        ApiError error =
                assertThrows(ApiError.class, () -> client.hris().employees().retrieve("does-not-exist"));
        assertEquals(502, error.statusCode());
        assertTrue(error.body().toString().contains("Bad Gateway"));
    }

    @Test
    public void clientRoutesToConfiguredBaseUrl() {
        statusToReturn = 404;
        bodyToReturn = "{}";

        assertThrows(ApiError.class, () -> client.hris().employees().retrieve("emp-1"));
        assertNotNull(lastPath);
        assertTrue(lastPath.contains("/hris/v1/employees"), lastPath);
    }
}
