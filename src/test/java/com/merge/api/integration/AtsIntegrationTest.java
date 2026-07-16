package com.merge.api.integration;

import static com.merge.api.integration.IntegrationSupport.*;
import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.MergeApiClient;
import com.merge.api.ats.types.ApplicationsListRequest;
import com.merge.api.ats.types.ApplicationsListRequestExpandItem;
import com.merge.api.ats.types.CandidatesListRequest;
import com.merge.api.ats.types.CandidatesListRequestExpandItem;
import com.merge.api.ats.types.InterviewsListRequest;
import com.merge.api.ats.types.InterviewsListRequestExpandItem;
import com.merge.api.ats.types.JobsListRequest;
import com.merge.api.ats.types.JobsListRequestExpandItem;
import com.merge.api.ats.types.OffersListRequest;
import com.merge.api.ats.types.OffersListRequestExpandItem;
import com.merge.api.ats.types.ScorecardsListRequest;
import com.merge.api.ats.types.ScorecardsListRequestExpandItem;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AtsIntegrationTest {

    private MergeApiClient client;

    @BeforeEach
    void setUp() {
        String apiKey = System.getenv("MERGE_API_KEY_ATS");
        String accountToken = System.getenv("MERGE_ACCOUNT_TOKEN_ATS");
        assertNotNull(apiKey, "MERGE_API_KEY_ATS must be set");
        assertNotNull(accountToken, "MERGE_ACCOUNT_TOKEN_ATS must be set");
        client = MergeApiClient.builder()
                .apiKey(apiKey)
                .accountToken(accountToken)
                .build();
    }

    @Test
    void activities() {
        smokeListAndRetrieve(
                client.ats().activities().list(), id -> client.ats().activities().retrieve(id));
    }

    @Test
    void applications() {
        smokeListAndRetrieve(
                client.ats().applications().list(), id -> client.ats().applications().retrieve(id));
    }

    @Test
    void attachments() {
        smokeListAndRetrieve(
                client.ats().attachments().list(), id -> client.ats().attachments().retrieve(id));
    }

    @Test
    void candidates() {
        smokeListAndRetrieve(
                client.ats().candidates().list(), id -> client.ats().candidates().retrieve(id));
    }

    @Test
    void departments() {
        smokeListAndRetrieve(
                client.ats().departments().list(), id -> client.ats().departments().retrieve(id));
    }

    @Test
    void eeocs() {
        smokeListAndRetrieve(client.ats().eeocs().list(), id -> client.ats().eeocs().retrieve(id));
    }

    @Test
    void interviews() {
        smokeListAndRetrieve(
                client.ats().interviews().list(), id -> client.ats().interviews().retrieve(id));
    }

    @Test
    void jobInterviewStages() {
        smokeListAndRetrieve(
                client.ats().jobInterviewStages().list(),
                id -> client.ats().jobInterviewStages().retrieve(id));
    }

    @Test
    void jobPostings() {
        smokeListAndRetrieve(
                client.ats().jobPostings().list(), id -> client.ats().jobPostings().retrieve(id));
    }

    @Test
    void jobs() {
        smokeListAndRetrieve(client.ats().jobs().list(), id -> client.ats().jobs().retrieve(id));
    }

    @Test
    void offers() {
        smokeListAndRetrieve(client.ats().offers().list(), id -> client.ats().offers().retrieve(id));
    }

    @Test
    void offices() {
        smokeListAndRetrieve(client.ats().offices().list(), id -> client.ats().offices().retrieve(id));
    }

    @Test
    void rejectReasons() {
        smokeListAndRetrieve(
                client.ats().rejectReasons().list(), id -> client.ats().rejectReasons().retrieve(id));
    }

    @Test
    void scorecards() {
        smokeListAndRetrieve(
                client.ats().scorecards().list(), id -> client.ats().scorecards().retrieve(id));
    }

    @Test
    void users() {
        smokeListAndRetrieve(client.ats().users().list(), id -> client.ats().users().retrieve(id));
    }

    @Test
    void tags() {
        smokeList(client.ats().tags().list());
    }

    @Test
    void applicationsExpand() {
        smokeList(client.ats()
                .applications()
                .list(ApplicationsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(
                                ApplicationsListRequestExpandItem.CANDIDATE,
                                ApplicationsListRequestExpandItem.OFFERS))
                        .build()));
    }

    @Test
    void candidatesExpand() {
        smokeList(client.ats()
                .candidates()
                .list(CandidatesListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(
                                CandidatesListRequestExpandItem.APPLICATIONS,
                                CandidatesListRequestExpandItem.ATTACHMENTS))
                        .build()));
    }

    @Test
    void interviewsExpand() {
        smokeList(client.ats()
                .interviews()
                .list(InterviewsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(
                                InterviewsListRequestExpandItem.APPLICATION,
                                InterviewsListRequestExpandItem.ORGANIZER))
                        .build()));
    }

    @Test
    void jobsExpand() {
        smokeList(client.ats()
                .jobs()
                .list(JobsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(JobsListRequestExpandItem.DEPARTMENTS))
                        .build()));
    }

    @Test
    void offersExpand() {
        smokeList(client.ats()
                .offers()
                .list(OffersListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(OffersListRequestExpandItem.APPLICATION))
                        .build()));
    }

    @Test
    void scorecardsExpand() {
        smokeList(client.ats()
                .scorecards()
                .list(ScorecardsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(ScorecardsListRequestExpandItem.APPLICATION))
                        .build()));
    }
}
