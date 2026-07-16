package com.merge.api.integration;

import static com.merge.api.integration.IntegrationSupport.*;
import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.MergeApiClient;
import com.merge.api.ticketing.types.CollectionsListRequest;
import com.merge.api.ticketing.types.CollectionsListRequestExpandItem;
import com.merge.api.ticketing.types.CommentsListRequest;
import com.merge.api.ticketing.types.CommentsListRequestExpandItem;
import com.merge.api.ticketing.types.TicketsListRequest;
import com.merge.api.ticketing.types.TicketsListRequestExpandItem;
import com.merge.api.ticketing.types.UsersListRequest;
import com.merge.api.ticketing.types.UsersListRequestExpandItem;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketingIntegrationTest {

    private MergeApiClient client;

    @BeforeEach
    void setUp() {
        String apiKey = System.getenv("MERGE_API_KEY_TICKETING");
        String accountToken = System.getenv("MERGE_ACCOUNT_TOKEN_TICKETING");
        assertNotNull(apiKey, "MERGE_API_KEY_TICKETING must be set");
        assertNotNull(accountToken, "MERGE_ACCOUNT_TOKEN_TICKETING must be set");
        client = MergeApiClient.builder()
                .apiKey(apiKey)
                .accountToken(accountToken)
                .build();
    }

    @Test
    void accounts() {
        smokeListAndRetrieve(
                client.ticketing().accounts().list(),
                id -> client.ticketing().accounts().retrieve(id));
    }

    @Test
    void attachments() {
        smokeListAndRetrieve(
                client.ticketing().attachments().list(),
                id -> client.ticketing().attachments().retrieve(id));
    }

    @Test
    void collections() {
        smokeListAndRetrieve(
                client.ticketing().collections().list(),
                id -> client.ticketing().collections().retrieve(id));
    }

    @Test
    void comments() {
        smokeListAndRetrieve(
                client.ticketing().comments().list(),
                id -> client.ticketing().comments().retrieve(id));
    }

    @Test
    void contacts() {
        smokeListAndRetrieve(
                client.ticketing().contacts().list(),
                id -> client.ticketing().contacts().retrieve(id));
    }

    @Test
    void projects() {
        smokeListAndRetrieve(
                client.ticketing().projects().list(),
                id -> client.ticketing().projects().retrieve(id));
    }

    @Test
    void roles() {
        smokeListAndRetrieve(
                client.ticketing().roles().list(), id -> client.ticketing().roles().retrieve(id));
    }

    @Test
    void tags() {
        smokeListAndRetrieve(
                client.ticketing().tags().list(), id -> client.ticketing().tags().retrieve(id));
    }

    @Test
    void teams() {
        smokeListAndRetrieve(
                client.ticketing().teams().list(), id -> client.ticketing().teams().retrieve(id));
    }

    @Test
    void tickets() {
        smokeListAndRetrieve(
                client.ticketing().tickets().list(),
                id -> client.ticketing().tickets().retrieve(id));
    }

    @Test
    void users() {
        smokeListAndRetrieve(
                client.ticketing().users().list(), id -> client.ticketing().users().retrieve(id));
    }

    @Test
    void ticketsExpand() {
        smokeList(client.ticketing()
                .tickets()
                .list(TicketsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(
                                TicketsListRequestExpandItem.ASSIGNEES, TicketsListRequestExpandItem.ACCOUNT))
                        .build()));
    }

    @Test
    void collectionsExpand() {
        smokeList(client.ticketing()
                .collections()
                .list(CollectionsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(CollectionsListRequestExpandItem.PERMISSIONS))
                        .build()));
    }

    @Test
    void commentsExpand() {
        smokeList(client.ticketing()
                .comments()
                .list(CommentsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(CommentsListRequestExpandItem.USER, CommentsListRequestExpandItem.TICKET))
                        .build()));
    }

    @Test
    void usersExpand() {
        smokeList(client.ticketing()
                .users()
                .list(UsersListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(UsersListRequestExpandItem.TEAMS, UsersListRequestExpandItem.ROLES))
                        .build()));
    }
}
