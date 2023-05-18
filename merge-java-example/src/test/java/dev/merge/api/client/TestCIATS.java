package dev.merge.api.client;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.merge.api.client.okhttp.MergeOkHttpClient;
import dev.merge.api.core.JsonValue;
import dev.merge.api.core.ObjectMappers;
import dev.merge.api.models.ats.Application;
import dev.merge.api.models.ats.Candidate;
import dev.merge.api.models.ats.CandidateListPage;
import dev.merge.api.models.ats.CandidateListParams;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

final class TestCIATS {
    private static final JsonMapper JSON_MAPPER = ObjectMappers.jsonMapper()
            .rebuild()
            .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
            .build();

    @Test
    @Tag("MergeCI")
    void testListCandidates() {
        MergeClient client = MergeOkHttpClient.builder()
                .apiKey(System.getenv("MERGE_API_KEY"))
                .accountToken(System.getenv("MERGE_ACCOUNT_TOKEN_ATS"))
                .build();

        CandidateListParams params = CandidateListParams.builder().build();

        CandidateListPage list = client.ats().candidates().list(params);

        for (Candidate candidate : list.results()) {
            assertThat(candidate.id()).isNotNull();
            assertThat(candidate.id().orElse(null)).isNotNull();
        }

        int iterations = 0;
        while (list.hasNextPage() && iterations < 10) {
            CandidateListParams iterParams = list.getNextPageParams().orElseThrow(IllegalStateException::new);
            list = client.ats().candidates().list(iterParams);

            for (Candidate candidate : list.results()) {
                assertThat(candidate.id()).isNotNull();
                assertThat(candidate.id().orElse(null)).isNotNull();
            }

            iterations += 1;
        }
    }

    @Test
    @Tag("MergeCI")
    void testListCandidatesExpand() throws JsonProcessingException {
        MergeClient client = MergeOkHttpClient.builder()
                .apiKey(System.getenv("MERGE_API_KEY"))
                .accountToken(System.getenv("MERGE_ACCOUNT_TOKEN_ATS"))
                .build();

        CandidateListParams params = CandidateListParams.builder()
                .expand(Arrays.asList(CandidateListParams.Expand.APPLICATIONS, CandidateListParams.Expand.ATTACHMENTS))
                .build();

        CandidateListPage list = client.ats().candidates().list(params);

        for (Candidate candidate : list.results()) {
            if (!candidate._applications().isNull()) {
                List<JsonValue> applicationsArray =
                        candidate._applications().asArray().orElse(null);
                assertThat(applicationsArray).isNotNull();

                for (JsonValue expandedApplication : applicationsArray) {
                    Application candidateApp = JSON_MAPPER.convertValue(expandedApplication, Application.class);

                    assertThat(candidateApp.id()).isNotNull();
                    assertThat(candidateApp.id().orElse(null)).isNotNull();
                }
            }
        }

        int iterations = 0;
        while (list.hasNextPage() && iterations < 10) {
            CandidateListParams iterParams = list.getNextPageParams().orElseThrow(IllegalStateException::new);
            list = client.ats().candidates().list(iterParams);

            for (Candidate candidate : list.results()) {
                if (!candidate._applications().isNull()) {
                    List<JsonValue> applicationsArray =
                            candidate._applications().asArray().orElse(null);
                    assertThat(applicationsArray).isNotNull();

                    for (JsonValue expandedApplication : applicationsArray) {
                        Application candidateApp = JSON_MAPPER.convertValue(expandedApplication, Application.class);

                        assertThat(candidateApp.id()).isNotNull();
                        assertThat(candidateApp.id().orElse(null)).isNotNull();
                    }
                }
            }

            iterations += 1;
        }
    }
}
