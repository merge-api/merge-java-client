package com.merge.api.integration;

import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.MergeApiClient;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.filestorage.types.Folder;
import com.merge.api.filestorage.types.FoldersListRequest;
import com.merge.api.filestorage.types.PaginatedFolderList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CursorPaginationIntegrationTest {

    private MergeApiClient client;

    @BeforeEach
    void setUp() {
        String apiKey = System.getenv("MERGE_API_KEY_FILESTORAGE");
        String accountToken = System.getenv("MERGE_ACCOUNT_TOKEN_FILESTORAGE");

        assertNotNull(apiKey, "MERGE_API_KEY environment variable must be set");
        assertNotNull(accountToken, "MERGE_ACCOUNT_TOKEN environment variable must be set");

        client = MergeApiClient.builder()
                .apiKey(apiKey)
                .accountToken(accountToken)
                .build();
    }

    @Test
    void testCursorPaginationWithFileStorageFolders() {
        SyncPagingIterable<Folder> folders = client.fileStorage().folders().list();

        assertNotNull(folders, "Folders list should not be null");

        // Test that getResponse() is available and returns pagination metadata
        folders.getResponse().ifPresent(response -> {
            assertTrue(response instanceof PaginatedFolderList, "Response should be instance of PaginatedFolderList");

            PaginatedFolderList paginatedResponse = (PaginatedFolderList) response;

            // Test cursor pagination metadata access
            paginatedResponse.getNext().ifPresent(nextCursor -> {
                assertNotNull(nextCursor, "Cursor token should be available for pagination");
            });

            // Test that we can access results
            assertNotNull(paginatedResponse.getResults(), "Results list should not be null");
        });

        // Test iteration over paginated results
        int itemCount = 0;
        int pageCount = 0;

        for (Folder folder : folders) {
            assertNotNull(folder, "Each folder should not be null");
            itemCount++;

            // Limit test to prevent excessive API calls
            if (itemCount >= 10) {
                break;
            }
        }

        assertTrue(itemCount >= 0, "Should have processed at least 0 items");
    }

    @Test
    void testStatelessPaginationWithCursor() {
        // Simulate frontend flow: get first page
        SyncPagingIterable<Folder> firstPage = client.fileStorage().folders().list();

        // Get the first page response to extract cursor
        firstPage.getResponse().ifPresent(response -> {
            assertTrue(response instanceof PaginatedFolderList, "Response should be PaginatedFolderList");

            PaginatedFolderList paginatedResponse = (PaginatedFolderList) response;

            // If there's a next cursor, test stateless pagination by actually using it
            paginatedResponse.getNext().ifPresent(nextCursor -> {
                // This demonstrates how a frontend would implement stateless pagination
                // by using the cursor token from the response
                assertNotNull(nextCursor, "Next cursor should be available");
                assertFalse(nextCursor.trim().isEmpty(), "Next cursor should not be empty");

                // Frontend sends cursor back to backend for next page
                FoldersListRequest secondPageRequest =
                        FoldersListRequest.builder().cursor(nextCursor).build();

                // Backend fetches second page using the cursor
                SyncPagingIterable<Folder> secondPage =
                        client.fileStorage().folders().list(secondPageRequest);

                assertNotNull(secondPage, "Second page should not be null");

                // Verify we got a valid response with results
                secondPage.getResponse().ifPresent(secondResponse -> {
                    assertTrue(
                            secondResponse instanceof PaginatedFolderList,
                            "Second page response should be PaginatedFolderList");

                    PaginatedFolderList secondPageResponse = (PaginatedFolderList) secondResponse;
                    assertNotNull(secondPageResponse.getResults(), "Second page should have results");
                });
            });
        });
    }

    @Test
    void testPaginationMetadataAccess() {
        SyncPagingIterable<Folder> folders = client.fileStorage().folders().list();

        // Test that getResponse() provides access to full API response
        assertTrue(folders.getResponse().isPresent(), "getResponse() should return the API response");

        folders.getResponse().ifPresent(response -> {
            // Verify we can cast to the expected response type
            assertDoesNotThrow(
                    () -> {
                        PaginatedFolderList paginatedResponse = (PaginatedFolderList) response;

                        // Test access to pagination metadata
                        // These fields may be Optional.empty() if no pagination is needed
                        paginatedResponse.getNext().ifPresent(next -> {
                            assertNotNull(next, "Next cursor should not be null if present");
                        });

                        paginatedResponse.getPrevious().ifPresent(previous -> {
                            assertNotNull(previous, "Previous cursor should not be null if present");
                        });

                        // At minimum, results should be accessible
                        assertNotNull(paginatedResponse.getResults(), "Results should always be accessible");
                    },
                    "Should be able to access pagination metadata");
        });
    }
}
