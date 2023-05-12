package dev.merge.example;

import dev.merge.api.client.MergeClient;
import dev.merge.api.client.okhttp.MergeOkHttpClient;
import dev.merge.api.models.hris.Employee;
import dev.merge.api.models.hris.EmployeeListPage;
import dev.merge.api.models.hris.EmployeeListParams;

public class Main {
    static final String ACCOUNT_TOKEN = System.getenv("MERGE_ACCOUNT_TOKEN");

    public static void main(String[] args) {
        MergeClient client = MergeOkHttpClient.builder()
                .accountToken(ACCOUNT_TOKEN)
                .fromEnv()
                .build();

        EmployeeListParams params = EmployeeListParams.builder().build();

        EmployeeListPage list = client.hris().employees().list(params);
        for (Employee employee : list.results()) {
            System.out.println(employee);
        }
    }
}
