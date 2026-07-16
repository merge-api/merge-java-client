package com.merge.api.integration;

import static com.merge.api.integration.IntegrationSupport.*;
import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.MergeApiClient;
import com.merge.api.crm.types.ContactsListRequest;
import com.merge.api.crm.types.ContactsListRequestExpandItem;
import com.merge.api.crm.types.EngagementsListRequest;
import com.merge.api.crm.types.EngagementsListRequestExpandItem;
import com.merge.api.crm.types.LeadsListRequest;
import com.merge.api.crm.types.LeadsListRequestExpandItem;
import com.merge.api.crm.types.NotesListRequest;
import com.merge.api.crm.types.NotesListRequestExpandItem;
import com.merge.api.crm.types.OpportunitiesListRequest;
import com.merge.api.crm.types.OpportunitiesListRequestExpandItem;
import com.merge.api.crm.types.TasksListRequest;
import com.merge.api.crm.types.TasksListRequestExpandItem;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrmIntegrationTest {

    private MergeApiClient client;

    @BeforeEach
    void setUp() {
        String apiKey = System.getenv("MERGE_API_KEY_SECONDARY");
        String accountToken = System.getenv("MERGE_ACCOUNT_TOKEN_CRM");
        assertNotNull(apiKey, "MERGE_API_KEY_SECONDARY must be set");
        assertNotNull(accountToken, "MERGE_ACCOUNT_TOKEN_CRM must be set");
        client = MergeApiClient.builder()
                .apiKey(apiKey)
                .accountToken(accountToken)
                .build();
    }

    @Test
    void accounts() {
        smokeListAndRetrieve(
                client.crm().accounts().list(), id -> client.crm().accounts().retrieve(id));
    }

    @Test
    void contacts() {
        smokeListAndRetrieve(
                client.crm().contacts().list(), id -> client.crm().contacts().retrieve(id));
    }

    @Test
    void customObjectClasses() {
        smokeListAndRetrieve(
                client.crm().customObjectClasses().list(),
                id -> client.crm().customObjectClasses().retrieve(id));
    }

    @Test
    void engagementTypes() {
        smokeListAndRetrieve(
                client.crm().engagementTypes().list(),
                id -> client.crm().engagementTypes().retrieve(id));
    }

    @Test
    void engagements() {
        smokeListAndRetrieve(
                client.crm().engagements().list(), id -> client.crm().engagements().retrieve(id));
    }

    @Test
    void leads() {
        smokeListAndRetrieve(client.crm().leads().list(), id -> client.crm().leads().retrieve(id));
    }

    @Test
    void notes() {
        smokeListAndRetrieve(client.crm().notes().list(), id -> client.crm().notes().retrieve(id));
    }

    @Test
    void opportunities() {
        smokeListAndRetrieve(
                client.crm().opportunities().list(),
                id -> client.crm().opportunities().retrieve(id));
    }

    @Test
    void stages() {
        smokeListAndRetrieve(client.crm().stages().list(), id -> client.crm().stages().retrieve(id));
    }

    @Test
    void tasks() {
        smokeListAndRetrieve(client.crm().tasks().list(), id -> client.crm().tasks().retrieve(id));
    }

    @Test
    void users() {
        smokeListAndRetrieve(client.crm().users().list(), id -> client.crm().users().retrieve(id));
    }

    @Test
    void contactsExpand() {
        smokeList(client.crm()
                .contacts()
                .list(ContactsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(ContactsListRequestExpandItem.ACCOUNT))
                        .build()));
    }

    @Test
    void engagementsExpand() {
        smokeList(client.crm()
                .engagements()
                .list(EngagementsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(
                                EngagementsListRequestExpandItem.CONTACTS,
                                EngagementsListRequestExpandItem.OWNER))
                        .build()));
    }

    @Test
    void leadsExpand() {
        smokeList(client.crm()
                .leads()
                .list(LeadsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(LeadsListRequestExpandItem.OWNER))
                        .build()));
    }

    @Test
    void notesExpand() {
        smokeList(client.crm()
                .notes()
                .list(NotesListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(NotesListRequestExpandItem.ACCOUNT, NotesListRequestExpandItem.OWNER))
                        .build()));
    }

    @Test
    void opportunitiesExpand() {
        smokeList(client.crm()
                .opportunities()
                .list(OpportunitiesListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(
                                OpportunitiesListRequestExpandItem.ACCOUNT,
                                OpportunitiesListRequestExpandItem.OWNER))
                        .build()));
    }

    @Test
    void tasksExpand() {
        smokeList(client.crm()
                .tasks()
                .list(TasksListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(TasksListRequestExpandItem.ACCOUNT, TasksListRequestExpandItem.OWNER))
                        .build()));
    }
}
