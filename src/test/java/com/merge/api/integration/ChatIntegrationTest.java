package com.merge.api.integration;

import static com.merge.api.integration.IntegrationSupport.*;
import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.MergeApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChatIntegrationTest {

    private MergeApiClient client;

    @BeforeEach
    void setUp() {
        String apiKey = System.getenv("MERGE_API_KEY_CHAT");
        String accountToken = System.getenv("MERGE_ACCOUNT_TOKEN_CHAT");
        assertNotNull(apiKey, "MERGE_API_KEY_CHAT must be set");
        assertNotNull(accountToken, "MERGE_ACCOUNT_TOKEN_CHAT must be set");
        client = MergeApiClient.builder()
                .apiKey(apiKey)
                .accountToken(accountToken)
                .build();
    }

    @Test
    void conversations() {
        smokeListAndRetrieve(
                client.chat().conversations().list(),
                id -> client.chat().conversations().retrieve(id));
    }

    @Test
    void groups() {
        smokeListAndRetrieve(
                client.chat().groups().list(), id -> client.chat().groups().retrieve(id));
    }

    @Test
    void messages() {
        smokeListAndRetrieve(
                client.chat().messages().list(), id -> client.chat().messages().retrieve(id));
    }

    @Test
    void users() {
        smokeListAndRetrieve(
                client.chat().users().list(), id -> client.chat().users().retrieve(id));
    }
}
