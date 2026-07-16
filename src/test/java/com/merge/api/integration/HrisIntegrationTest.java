package com.merge.api.integration;

import static com.merge.api.integration.IntegrationSupport.*;
import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.MergeApiClient;
import com.merge.api.hris.types.EmployeePayrollRunsListRequest;
import com.merge.api.hris.types.EmployeePayrollRunsListRequestExpandItem;
import com.merge.api.hris.types.EmployeesListRequest;
import com.merge.api.hris.types.EmployeesListRequestExpandItem;
import com.merge.api.hris.types.EmploymentsListRequest;
import com.merge.api.hris.types.EmploymentsListRequestExpandItem;
import com.merge.api.hris.types.TimeOffListRequest;
import com.merge.api.hris.types.TimeOffListRequestExpandItem;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HrisIntegrationTest {

    private MergeApiClient client;

    @BeforeEach
    void setUp() {
        String apiKey = System.getenv("MERGE_API_KEY_SECONDARY");
        String accountToken = System.getenv("MERGE_ACCOUNT_TOKEN_HRIS");
        assertNotNull(apiKey, "MERGE_API_KEY_SECONDARY must be set");
        assertNotNull(accountToken, "MERGE_ACCOUNT_TOKEN_HRIS must be set");
        client = MergeApiClient.builder()
                .apiKey(apiKey)
                .accountToken(accountToken)
                .build();
    }

    @Test
    void bankInfo() {
        smokeListAndRetrieve(
                client.hris().bankInfo().list(), id -> client.hris().bankInfo().retrieve(id));
    }

    @Test
    void benefits() {
        smokeListAndRetrieve(
                client.hris().benefits().list(), id -> client.hris().benefits().retrieve(id));
    }

    @Test
    void companies() {
        smokeListAndRetrieve(
                client.hris().companies().list(), id -> client.hris().companies().retrieve(id));
    }

    @Test
    void dependents() {
        smokeListAndRetrieve(
                client.hris().dependents().list(), id -> client.hris().dependents().retrieve(id));
    }

    @Test
    void employeePayrollRuns() {
        smokeListAndRetrieve(
                client.hris().employeePayrollRuns().list(),
                id -> client.hris().employeePayrollRuns().retrieve(id));
    }

    @Test
    void employees() {
        smokeListAndRetrieve(
                client.hris().employees().list(), id -> client.hris().employees().retrieve(id));
    }

    @Test
    void employerBenefits() {
        smokeListAndRetrieve(
                client.hris().employerBenefits().list(),
                id -> client.hris().employerBenefits().retrieve(id));
    }

    @Test
    void employments() {
        smokeListAndRetrieve(
                client.hris().employments().list(), id -> client.hris().employments().retrieve(id));
    }

    @Test
    void groups() {
        smokeListAndRetrieve(
                client.hris().groups().list(), id -> client.hris().groups().retrieve(id));
    }

    @Test
    void locations() {
        smokeListAndRetrieve(
                client.hris().locations().list(), id -> client.hris().locations().retrieve(id));
    }

    @Test
    void payGroups() {
        smokeListAndRetrieve(
                client.hris().payGroups().list(), id -> client.hris().payGroups().retrieve(id));
    }

    @Test
    void payrollRuns() {
        smokeListAndRetrieve(
                client.hris().payrollRuns().list(), id -> client.hris().payrollRuns().retrieve(id));
    }

    @Test
    void teams() {
        smokeListAndRetrieve(client.hris().teams().list(), id -> client.hris().teams().retrieve(id));
    }

    @Test
    void timeOff() {
        smokeListAndRetrieve(
                client.hris().timeOff().list(), id -> client.hris().timeOff().retrieve(id));
    }

    @Test
    void timeOffBalances() {
        smokeListAndRetrieve(
                client.hris().timeOffBalances().list(),
                id -> client.hris().timeOffBalances().retrieve(id));
    }

    @Test
    void timesheetEntries() {
        smokeListAndRetrieve(
                client.hris().timesheetEntries().list(),
                id -> client.hris().timesheetEntries().retrieve(id));
    }

    @Test
    void employeesExpand() {
        smokeList(client.hris()
                .employees()
                .list(EmployeesListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(
                                EmployeesListRequestExpandItem.EMPLOYMENTS,
                                EmployeesListRequestExpandItem.PAY_GROUP))
                        .build()));
    }

    @Test
    void employmentsExpand() {
        smokeList(client.hris()
                .employments()
                .list(EmploymentsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(EmploymentsListRequestExpandItem.EMPLOYEE))
                        .build()));
    }

    @Test
    void employeePayrollRunsExpand() {
        smokeList(client.hris()
                .employeePayrollRuns()
                .list(EmployeePayrollRunsListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(EmployeePayrollRunsListRequestExpandItem.EMPLOYEE))
                        .build()));
    }

    @Test
    void timeOffExpand() {
        smokeList(client.hris()
                .timeOff()
                .list(TimeOffListRequest.builder()
                        .pageSize(5)
                        .expand(List.of(TimeOffListRequestExpandItem.EMPLOYEE, TimeOffListRequestExpandItem.APPROVER))
                        .build()));
    }
}
