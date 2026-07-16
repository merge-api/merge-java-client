package com.merge.api.integration;

import static com.merge.api.integration.IntegrationSupport.*;
import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.MergeApiClient;
import com.merge.api.filestorage.types.FilesListRequest;
import com.merge.api.filestorage.types.FilesListRequestExpandItem;
import com.merge.api.filestorage.types.FoldersListRequest;
import com.merge.api.filestorage.types.FoldersListRequestExpandItem;
import com.merge.api.filestorage.types.GroupsListRequest;
import com.merge.api.filestorage.types.GroupsListRequestExpandItem;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileStorageIntegrationTest {

    private MergeApiClient client;

    @BeforeEach
    void setUp() {
        String apiKey = System.getenv("MERGE_API_KEY_SECONDARY");
        String accountToken = System.getenv("MERGE_ACCOUNT_TOKEN_FILESTORAGE");
        assertNotNull(apiKey, "MERGE_API_KEY_SECONDARY must be set");
        assertNotNull(accountToken, "MERGE_ACCOUNT_TOKEN_FILESTORAGE must be set");
        client = MergeApiClient.builder()
                .apiKey(apiKey)
                .accountToken(accountToken)
                .build();
    }

    @Test
    void drives() {
        smokeListAndRetrieve(
                client.fileStorage().drives().list(),
                id -> client.fileStorage().drives().retrieve(id));
    }

    @Test
    void files() {
        smokeListAndRetrieve(
                client.fileStorage().files().list(), id -> client.fileStorage().files().retrieve(id));
    }

    @Test
    void folders() {
        smokeListAndRetrieve(
                client.fileStorage().folders().list(),
                id -> client.fileStorage().folders().retrieve(id));
    }

    @Test
    void groups() {
        smokeListAndRetrieve(
                client.fileStorage().groups().list(),
                id -> client.fileStorage().groups().retrieve(id));
    }

    @Test
    void users() {
        smokeListAndRetrieve(
                client.fileStorage().users().list(), id -> client.fileStorage().users().retrieve(id));
    }

    @Test
    void filesExpand() {
        smokeList(client.fileStorage()
                .files()
                .list(FilesListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(FilesListRequestExpandItem.PERMISSIONS, FilesListRequestExpandItem.FOLDER))
                        .build()));
    }

    @Test
    void foldersExpand() {
        smokeList(client.fileStorage()
                .folders()
                .list(FoldersListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(
                                FoldersListRequestExpandItem.PERMISSIONS,
                                FoldersListRequestExpandItem.PARENT_FOLDER))
                        .build()));
    }

    @Test
    void groupsExpand() {
        smokeList(client.fileStorage()
                .groups()
                .list(GroupsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(GroupsListRequestExpandItem.USERS))
                        .build()));
    }
}
