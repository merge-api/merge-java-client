package dev.merge.api.client;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.merge.api.client.okhttp.MergeOkHttpClient;
import dev.merge.api.core.ObjectMappers;
import dev.merge.api.models.hris.Company;
import dev.merge.api.models.hris.Employee;
import dev.merge.api.models.hris.EmployeeListPage;
import dev.merge.api.models.hris.EmployeeListParams;
import java.util.Arrays;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

final class TestCIHRIS {
    private static final JsonMapper JSON_MAPPER = ObjectMappers.jsonMapper()
            .rebuild()
            .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
            .build();

    @Test
    @Tag("MergeCI")
    void testListEmployees() {
        MergeClient client = MergeOkHttpClient.builder()
                .apiKey(System.getenv("MERGE_API_KEY"))
                .accountToken(System.getenv("MERGE_ACCOUNT_TOKEN_HRIS"))
                .build();

        EmployeeListParams params = EmployeeListParams.builder().pageSize(5).build();

        EmployeeListPage list = client.hris().employees().list(params);

        for (Employee employee : list.results()) {
            assertThat(employee.id()).isNotNull();
            assertThat(employee.id().orElse(null)).isNotNull();
        }

        while (list.hasNextPage()) {
            EmployeeListParams iterParams = list.getNextPageParams().orElseThrow(IllegalStateException::new);
            list = client.hris().employees().list(iterParams);

            for (Employee employee : list.results()) {
                assertThat(employee.id()).isNotNull();
                assertThat(employee.id().orElse(null)).isNotNull();
            }
        }
    }

    @Test
    @Tag("MergeCI")
    void testListEmployeesExpand() throws JsonProcessingException {
        MergeClient client = MergeOkHttpClient.builder()
                .apiKey(System.getenv("MERGE_API_KEY"))
                .accountToken(System.getenv("MERGE_ACCOUNT_TOKEN_HRIS"))
                .build();

        EmployeeListParams params = EmployeeListParams.builder()
                .expand(Arrays.asList(EmployeeListParams.Expand.COMPANY))
                .pageSize(5)
                .build();

        EmployeeListPage list = client.hris().employees().list(params);

        for (Employee employee : list.results()) {
            if (!employee._company().isNull()) {
                Company employeeCo = JSON_MAPPER.convertValue(employee._company(), Company.class);

                assertThat(employeeCo.id()).isNotNull();
                assertThat(employeeCo.id().orElse(null)).isNotNull();
            }
        }

        while (list.hasNextPage()) {
            EmployeeListParams iterParams = list.getNextPageParams().orElseThrow(IllegalStateException::new);
            list = client.hris().employees().list(iterParams);

            for (Employee employee : list.results()) {
                if (!employee._company().isNull()) {
                    Company employeeCo =
                            JSON_MAPPER.convertValue(employee._company(), Company.class);

                    assertThat(employeeCo.id()).isNotNull();
                    assertThat(employeeCo.id().orElse(null)).isNotNull();
                }
            }
        }
    }
}
