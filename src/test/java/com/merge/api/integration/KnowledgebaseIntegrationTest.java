package com.merge.api.integration;

import static com.merge.api.integration.IntegrationSupport.*;
import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.MergeApiClient;
import com.merge.api.knowledgebase.types.ArticlesListRequest;
import com.merge.api.knowledgebase.types.ArticlesListRequestExpandItem;
import com.merge.api.knowledgebase.types.ContainersListRequest;
import com.merge.api.knowledgebase.types.ContainersListRequestExpandItem;
import com.merge.api.knowledgebase.types.GroupsListRequest;
import com.merge.api.knowledgebase.types.GroupsListRequestExpandItem;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnowledgebaseIntegrationTest {

    private MergeApiClient client;

    @BeforeEach
    void setUp() {
        String apiKey = System.getenv("MERGE_API_KEY_SECONDARY");
        String accountToken = System.getenv("MERGE_ACCOUNT_TOKEN_KNOWLEDGEBASE");
        assertNotNull(apiKey, "MERGE_API_KEY_SECONDARY must be set");
        assertNotNull(accountToken, "MERGE_ACCOUNT_TOKEN_KNOWLEDGEBASE must be set");
        client = MergeApiClient.builder()
                .apiKey(apiKey)
                .accountToken(accountToken)
                .build();
    }

    @Test
    void articles() {
        smokeListAndRetrieve(
                client.knowledgebase().articles().list(),
                id -> client.knowledgebase().articles().retrieve(id));
    }

    @Test
    void attachments() {
        smokeListAndRetrieve(
                client.knowledgebase().attachments().list(),
                id -> client.knowledgebase().attachments().retrieve(id));
    }

    @Test
    void containers() {
        smokeListAndRetrieve(
                client.knowledgebase().containers().list(),
                id -> client.knowledgebase().containers().retrieve(id));
    }

    @Test
    void groups() {
        smokeListAndRetrieve(
                client.knowledgebase().groups().list(),
                id -> client.knowledgebase().groups().retrieve(id));
    }

    @Test
    void users() {
        smokeListAndRetrieve(
                client.knowledgebase().users().list(),
                id -> client.knowledgebase().users().retrieve(id));
    }

    @Test
    void articlesExpand() {
        smokeList(client.knowledgebase()
                .articles()
                .list(ArticlesListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(ArticlesListRequestExpandItem.ATTACHMENTS))
                        .build()));
    }

    @Test
    void containersExpand() {
        smokeList(client.knowledgebase()
                .containers()
                .list(ContainersListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(
                                ContainersListRequestExpandItem.PERMISSIONS,
                                ContainersListRequestExpandItem.PARENT_CONTAINER))
                        .build()));
    }

    @Test
    void groupsExpand() {
        smokeList(client.knowledgebase()
                .groups()
                .list(GroupsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(GroupsListRequestExpandItem.USERS))
                        .build()));
    }
}
