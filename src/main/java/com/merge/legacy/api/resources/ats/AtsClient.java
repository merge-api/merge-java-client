/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.ats;

import com.merge.legacy.api.core.ClientOptions;
import com.merge.legacy.api.core.Suppliers;
import com.merge.legacy.api.resources.ats.accountdetails.AccountDetailsClient;
import com.merge.legacy.api.resources.ats.accounttoken.AccountTokenClient;
import com.merge.legacy.api.resources.ats.activities.ActivitiesClient;
import com.merge.legacy.api.resources.ats.applications.ApplicationsClient;
import com.merge.legacy.api.resources.ats.asyncpassthrough.AsyncPassthroughClient;
import com.merge.legacy.api.resources.ats.attachments.AttachmentsClient;
import com.merge.legacy.api.resources.ats.audittrail.AuditTrailClient;
import com.merge.legacy.api.resources.ats.availableactions.AvailableActionsClient;
import com.merge.legacy.api.resources.ats.candidates.CandidatesClient;
import com.merge.legacy.api.resources.ats.deleteaccount.DeleteAccountClient;
import com.merge.legacy.api.resources.ats.departments.DepartmentsClient;
import com.merge.legacy.api.resources.ats.eeocs.EeocsClient;
import com.merge.legacy.api.resources.ats.fieldmapping.FieldMappingClient;
import com.merge.legacy.api.resources.ats.forceresync.ForceResyncClient;
import com.merge.legacy.api.resources.ats.generatekey.GenerateKeyClient;
import com.merge.legacy.api.resources.ats.interviews.InterviewsClient;
import com.merge.legacy.api.resources.ats.issues.IssuesClient;
import com.merge.legacy.api.resources.ats.jobinterviewstages.JobInterviewStagesClient;
import com.merge.legacy.api.resources.ats.jobpostings.JobPostingsClient;
import com.merge.legacy.api.resources.ats.jobs.JobsClient;
import com.merge.legacy.api.resources.ats.linkedaccounts.LinkedAccountsClient;
import com.merge.legacy.api.resources.ats.linktoken.LinkTokenClient;
import com.merge.legacy.api.resources.ats.offers.OffersClient;
import com.merge.legacy.api.resources.ats.offices.OfficesClient;
import com.merge.legacy.api.resources.ats.passthrough.PassthroughClient;
import com.merge.legacy.api.resources.ats.regeneratekey.RegenerateKeyClient;
import com.merge.legacy.api.resources.ats.rejectreasons.RejectReasonsClient;
import com.merge.legacy.api.resources.ats.scopes.ScopesClient;
import com.merge.legacy.api.resources.ats.scorecards.ScorecardsClient;
import com.merge.legacy.api.resources.ats.syncstatus.SyncStatusClient;
import com.merge.legacy.api.resources.ats.tags.TagsClient;
import com.merge.legacy.api.resources.ats.users.UsersClient;
import com.merge.legacy.api.resources.ats.webhookreceivers.WebhookReceiversClient;
import java.util.function.Supplier;

public class AtsClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<AccountDetailsClient> accountDetailsClient;

    protected final Supplier<AccountTokenClient> accountTokenClient;

    protected final Supplier<ActivitiesClient> activitiesClient;

    protected final Supplier<ApplicationsClient> applicationsClient;

    protected final Supplier<AsyncPassthroughClient> asyncPassthroughClient;

    protected final Supplier<AttachmentsClient> attachmentsClient;

    protected final Supplier<AuditTrailClient> auditTrailClient;

    protected final Supplier<AvailableActionsClient> availableActionsClient;

    protected final Supplier<CandidatesClient> candidatesClient;

    protected final Supplier<ScopesClient> scopesClient;

    protected final Supplier<DeleteAccountClient> deleteAccountClient;

    protected final Supplier<DepartmentsClient> departmentsClient;

    protected final Supplier<EeocsClient> eeocsClient;

    protected final Supplier<FieldMappingClient> fieldMappingClient;

    protected final Supplier<GenerateKeyClient> generateKeyClient;

    protected final Supplier<InterviewsClient> interviewsClient;

    protected final Supplier<IssuesClient> issuesClient;

    protected final Supplier<JobInterviewStagesClient> jobInterviewStagesClient;

    protected final Supplier<JobPostingsClient> jobPostingsClient;

    protected final Supplier<JobsClient> jobsClient;

    protected final Supplier<LinkTokenClient> linkTokenClient;

    protected final Supplier<LinkedAccountsClient> linkedAccountsClient;

    protected final Supplier<OffersClient> offersClient;

    protected final Supplier<OfficesClient> officesClient;

    protected final Supplier<PassthroughClient> passthroughClient;

    protected final Supplier<RegenerateKeyClient> regenerateKeyClient;

    protected final Supplier<RejectReasonsClient> rejectReasonsClient;

    protected final Supplier<ScorecardsClient> scorecardsClient;

    protected final Supplier<SyncStatusClient> syncStatusClient;

    protected final Supplier<ForceResyncClient> forceResyncClient;

    protected final Supplier<TagsClient> tagsClient;

    protected final Supplier<UsersClient> usersClient;

    protected final Supplier<WebhookReceiversClient> webhookReceiversClient;

    public AtsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.accountDetailsClient = Suppliers.memoize(() -> new AccountDetailsClient(clientOptions));
        this.accountTokenClient = Suppliers.memoize(() -> new AccountTokenClient(clientOptions));
        this.activitiesClient = Suppliers.memoize(() -> new ActivitiesClient(clientOptions));
        this.applicationsClient = Suppliers.memoize(() -> new ApplicationsClient(clientOptions));
        this.asyncPassthroughClient = Suppliers.memoize(() -> new AsyncPassthroughClient(clientOptions));
        this.attachmentsClient = Suppliers.memoize(() -> new AttachmentsClient(clientOptions));
        this.auditTrailClient = Suppliers.memoize(() -> new AuditTrailClient(clientOptions));
        this.availableActionsClient = Suppliers.memoize(() -> new AvailableActionsClient(clientOptions));
        this.candidatesClient = Suppliers.memoize(() -> new CandidatesClient(clientOptions));
        this.scopesClient = Suppliers.memoize(() -> new ScopesClient(clientOptions));
        this.deleteAccountClient = Suppliers.memoize(() -> new DeleteAccountClient(clientOptions));
        this.departmentsClient = Suppliers.memoize(() -> new DepartmentsClient(clientOptions));
        this.eeocsClient = Suppliers.memoize(() -> new EeocsClient(clientOptions));
        this.fieldMappingClient = Suppliers.memoize(() -> new FieldMappingClient(clientOptions));
        this.generateKeyClient = Suppliers.memoize(() -> new GenerateKeyClient(clientOptions));
        this.interviewsClient = Suppliers.memoize(() -> new InterviewsClient(clientOptions));
        this.issuesClient = Suppliers.memoize(() -> new IssuesClient(clientOptions));
        this.jobInterviewStagesClient = Suppliers.memoize(() -> new JobInterviewStagesClient(clientOptions));
        this.jobPostingsClient = Suppliers.memoize(() -> new JobPostingsClient(clientOptions));
        this.jobsClient = Suppliers.memoize(() -> new JobsClient(clientOptions));
        this.linkTokenClient = Suppliers.memoize(() -> new LinkTokenClient(clientOptions));
        this.linkedAccountsClient = Suppliers.memoize(() -> new LinkedAccountsClient(clientOptions));
        this.offersClient = Suppliers.memoize(() -> new OffersClient(clientOptions));
        this.officesClient = Suppliers.memoize(() -> new OfficesClient(clientOptions));
        this.passthroughClient = Suppliers.memoize(() -> new PassthroughClient(clientOptions));
        this.regenerateKeyClient = Suppliers.memoize(() -> new RegenerateKeyClient(clientOptions));
        this.rejectReasonsClient = Suppliers.memoize(() -> new RejectReasonsClient(clientOptions));
        this.scorecardsClient = Suppliers.memoize(() -> new ScorecardsClient(clientOptions));
        this.syncStatusClient = Suppliers.memoize(() -> new SyncStatusClient(clientOptions));
        this.forceResyncClient = Suppliers.memoize(() -> new ForceResyncClient(clientOptions));
        this.tagsClient = Suppliers.memoize(() -> new TagsClient(clientOptions));
        this.usersClient = Suppliers.memoize(() -> new UsersClient(clientOptions));
        this.webhookReceiversClient = Suppliers.memoize(() -> new WebhookReceiversClient(clientOptions));
    }

    public AccountDetailsClient accountDetails() {
        return this.accountDetailsClient.get();
    }

    public AccountTokenClient accountToken() {
        return this.accountTokenClient.get();
    }

    public ActivitiesClient activities() {
        return this.activitiesClient.get();
    }

    public ApplicationsClient applications() {
        return this.applicationsClient.get();
    }

    public AsyncPassthroughClient asyncPassthrough() {
        return this.asyncPassthroughClient.get();
    }

    public AttachmentsClient attachments() {
        return this.attachmentsClient.get();
    }

    public AuditTrailClient auditTrail() {
        return this.auditTrailClient.get();
    }

    public AvailableActionsClient availableActions() {
        return this.availableActionsClient.get();
    }

    public CandidatesClient candidates() {
        return this.candidatesClient.get();
    }

    public ScopesClient scopes() {
        return this.scopesClient.get();
    }

    public DeleteAccountClient deleteAccount() {
        return this.deleteAccountClient.get();
    }

    public DepartmentsClient departments() {
        return this.departmentsClient.get();
    }

    public EeocsClient eeocs() {
        return this.eeocsClient.get();
    }

    public FieldMappingClient fieldMapping() {
        return this.fieldMappingClient.get();
    }

    public GenerateKeyClient generateKey() {
        return this.generateKeyClient.get();
    }

    public InterviewsClient interviews() {
        return this.interviewsClient.get();
    }

    public IssuesClient issues() {
        return this.issuesClient.get();
    }

    public JobInterviewStagesClient jobInterviewStages() {
        return this.jobInterviewStagesClient.get();
    }

    public JobPostingsClient jobPostings() {
        return this.jobPostingsClient.get();
    }

    public JobsClient jobs() {
        return this.jobsClient.get();
    }

    public LinkTokenClient linkToken() {
        return this.linkTokenClient.get();
    }

    public LinkedAccountsClient linkedAccounts() {
        return this.linkedAccountsClient.get();
    }

    public OffersClient offers() {
        return this.offersClient.get();
    }

    public OfficesClient offices() {
        return this.officesClient.get();
    }

    public PassthroughClient passthrough() {
        return this.passthroughClient.get();
    }

    public RegenerateKeyClient regenerateKey() {
        return this.regenerateKeyClient.get();
    }

    public RejectReasonsClient rejectReasons() {
        return this.rejectReasonsClient.get();
    }

    public ScorecardsClient scorecards() {
        return this.scorecardsClient.get();
    }

    public SyncStatusClient syncStatus() {
        return this.syncStatusClient.get();
    }

    public ForceResyncClient forceResync() {
        return this.forceResyncClient.get();
    }

    public TagsClient tags() {
        return this.tagsClient.get();
    }

    public UsersClient users() {
        return this.usersClient.get();
    }

    public WebhookReceiversClient webhookReceivers() {
        return this.webhookReceiversClient.get();
    }
}
