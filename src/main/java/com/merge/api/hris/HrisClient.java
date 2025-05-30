/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.Suppliers;
import java.util.function.Supplier;

public class HrisClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<AccountDetailsClient> accountDetailsClient;

    protected final Supplier<AccountTokenClient> accountTokenClient;

    protected final Supplier<AsyncPassthroughClient> asyncPassthroughClient;

    protected final Supplier<AuditTrailClient> auditTrailClient;

    protected final Supplier<AvailableActionsClient> availableActionsClient;

    protected final Supplier<BankInfoClient> bankInfoClient;

    protected final Supplier<BenefitsClient> benefitsClient;

    protected final Supplier<CompaniesClient> companiesClient;

    protected final Supplier<ScopesClient> scopesClient;

    protected final Supplier<DeleteAccountClient> deleteAccountClient;

    protected final Supplier<DependentsClient> dependentsClient;

    protected final Supplier<EmployeePayrollRunsClient> employeePayrollRunsClient;

    protected final Supplier<EmployeesClient> employeesClient;

    protected final Supplier<EmployerBenefitsClient> employerBenefitsClient;

    protected final Supplier<EmploymentsClient> employmentsClient;

    protected final Supplier<FieldMappingClient> fieldMappingClient;

    protected final Supplier<GenerateKeyClient> generateKeyClient;

    protected final Supplier<GroupsClient> groupsClient;

    protected final Supplier<IssuesClient> issuesClient;

    protected final Supplier<LinkTokenClient> linkTokenClient;

    protected final Supplier<LinkedAccountsClient> linkedAccountsClient;

    protected final Supplier<LocationsClient> locationsClient;

    protected final Supplier<PassthroughClient> passthroughClient;

    protected final Supplier<PayGroupsClient> payGroupsClient;

    protected final Supplier<PayrollRunsClient> payrollRunsClient;

    protected final Supplier<RegenerateKeyClient> regenerateKeyClient;

    protected final Supplier<SyncStatusClient> syncStatusClient;

    protected final Supplier<ForceResyncClient> forceResyncClient;

    protected final Supplier<TeamsClient> teamsClient;

    protected final Supplier<TimeOffClient> timeOffClient;

    protected final Supplier<TimeOffBalancesClient> timeOffBalancesClient;

    protected final Supplier<TimesheetEntriesClient> timesheetEntriesClient;

    protected final Supplier<WebhookReceiversClient> webhookReceiversClient;

    public HrisClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.accountDetailsClient = Suppliers.memoize(() -> new AccountDetailsClient(clientOptions));
        this.accountTokenClient = Suppliers.memoize(() -> new AccountTokenClient(clientOptions));
        this.asyncPassthroughClient = Suppliers.memoize(() -> new AsyncPassthroughClient(clientOptions));
        this.auditTrailClient = Suppliers.memoize(() -> new AuditTrailClient(clientOptions));
        this.availableActionsClient = Suppliers.memoize(() -> new AvailableActionsClient(clientOptions));
        this.bankInfoClient = Suppliers.memoize(() -> new BankInfoClient(clientOptions));
        this.benefitsClient = Suppliers.memoize(() -> new BenefitsClient(clientOptions));
        this.companiesClient = Suppliers.memoize(() -> new CompaniesClient(clientOptions));
        this.scopesClient = Suppliers.memoize(() -> new ScopesClient(clientOptions));
        this.deleteAccountClient = Suppliers.memoize(() -> new DeleteAccountClient(clientOptions));
        this.dependentsClient = Suppliers.memoize(() -> new DependentsClient(clientOptions));
        this.employeePayrollRunsClient = Suppliers.memoize(() -> new EmployeePayrollRunsClient(clientOptions));
        this.employeesClient = Suppliers.memoize(() -> new EmployeesClient(clientOptions));
        this.employerBenefitsClient = Suppliers.memoize(() -> new EmployerBenefitsClient(clientOptions));
        this.employmentsClient = Suppliers.memoize(() -> new EmploymentsClient(clientOptions));
        this.fieldMappingClient = Suppliers.memoize(() -> new FieldMappingClient(clientOptions));
        this.generateKeyClient = Suppliers.memoize(() -> new GenerateKeyClient(clientOptions));
        this.groupsClient = Suppliers.memoize(() -> new GroupsClient(clientOptions));
        this.issuesClient = Suppliers.memoize(() -> new IssuesClient(clientOptions));
        this.linkTokenClient = Suppliers.memoize(() -> new LinkTokenClient(clientOptions));
        this.linkedAccountsClient = Suppliers.memoize(() -> new LinkedAccountsClient(clientOptions));
        this.locationsClient = Suppliers.memoize(() -> new LocationsClient(clientOptions));
        this.passthroughClient = Suppliers.memoize(() -> new PassthroughClient(clientOptions));
        this.payGroupsClient = Suppliers.memoize(() -> new PayGroupsClient(clientOptions));
        this.payrollRunsClient = Suppliers.memoize(() -> new PayrollRunsClient(clientOptions));
        this.regenerateKeyClient = Suppliers.memoize(() -> new RegenerateKeyClient(clientOptions));
        this.syncStatusClient = Suppliers.memoize(() -> new SyncStatusClient(clientOptions));
        this.forceResyncClient = Suppliers.memoize(() -> new ForceResyncClient(clientOptions));
        this.teamsClient = Suppliers.memoize(() -> new TeamsClient(clientOptions));
        this.timeOffClient = Suppliers.memoize(() -> new TimeOffClient(clientOptions));
        this.timeOffBalancesClient = Suppliers.memoize(() -> new TimeOffBalancesClient(clientOptions));
        this.timesheetEntriesClient = Suppliers.memoize(() -> new TimesheetEntriesClient(clientOptions));
        this.webhookReceiversClient = Suppliers.memoize(() -> new WebhookReceiversClient(clientOptions));
    }

    public AccountDetailsClient accountDetails() {
        return this.accountDetailsClient.get();
    }

    public AccountTokenClient accountToken() {
        return this.accountTokenClient.get();
    }

    public AsyncPassthroughClient asyncPassthrough() {
        return this.asyncPassthroughClient.get();
    }

    public AuditTrailClient auditTrail() {
        return this.auditTrailClient.get();
    }

    public AvailableActionsClient availableActions() {
        return this.availableActionsClient.get();
    }

    public BankInfoClient bankInfo() {
        return this.bankInfoClient.get();
    }

    public BenefitsClient benefits() {
        return this.benefitsClient.get();
    }

    public CompaniesClient companies() {
        return this.companiesClient.get();
    }

    public ScopesClient scopes() {
        return this.scopesClient.get();
    }

    public DeleteAccountClient deleteAccount() {
        return this.deleteAccountClient.get();
    }

    public DependentsClient dependents() {
        return this.dependentsClient.get();
    }

    public EmployeePayrollRunsClient employeePayrollRuns() {
        return this.employeePayrollRunsClient.get();
    }

    public EmployeesClient employees() {
        return this.employeesClient.get();
    }

    public EmployerBenefitsClient employerBenefits() {
        return this.employerBenefitsClient.get();
    }

    public EmploymentsClient employments() {
        return this.employmentsClient.get();
    }

    public FieldMappingClient fieldMapping() {
        return this.fieldMappingClient.get();
    }

    public GenerateKeyClient generateKey() {
        return this.generateKeyClient.get();
    }

    public GroupsClient groups() {
        return this.groupsClient.get();
    }

    public IssuesClient issues() {
        return this.issuesClient.get();
    }

    public LinkTokenClient linkToken() {
        return this.linkTokenClient.get();
    }

    public LinkedAccountsClient linkedAccounts() {
        return this.linkedAccountsClient.get();
    }

    public LocationsClient locations() {
        return this.locationsClient.get();
    }

    public PassthroughClient passthrough() {
        return this.passthroughClient.get();
    }

    public PayGroupsClient payGroups() {
        return this.payGroupsClient.get();
    }

    public PayrollRunsClient payrollRuns() {
        return this.payrollRunsClient.get();
    }

    public RegenerateKeyClient regenerateKey() {
        return this.regenerateKeyClient.get();
    }

    public SyncStatusClient syncStatus() {
        return this.syncStatusClient.get();
    }

    public ForceResyncClient forceResync() {
        return this.forceResyncClient.get();
    }

    public TeamsClient teams() {
        return this.teamsClient.get();
    }

    public TimeOffClient timeOff() {
        return this.timeOffClient.get();
    }

    public TimeOffBalancesClient timeOffBalances() {
        return this.timeOffBalancesClient.get();
    }

    public TimesheetEntriesClient timesheetEntries() {
        return this.timesheetEntriesClient.get();
    }

    public WebhookReceiversClient webhookReceivers() {
        return this.webhookReceiversClient.get();
    }
}
