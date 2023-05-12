package dev.merge.api.services.async

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.async.ats.AccountDetailServiceAsync
import dev.merge.api.services.async.ats.AccountDetailServiceAsyncImpl
import dev.merge.api.services.async.ats.AccountTokenServiceAsync
import dev.merge.api.services.async.ats.AccountTokenServiceAsyncImpl
import dev.merge.api.services.async.ats.ActivityServiceAsync
import dev.merge.api.services.async.ats.ActivityServiceAsyncImpl
import dev.merge.api.services.async.ats.ApplicationServiceAsync
import dev.merge.api.services.async.ats.ApplicationServiceAsyncImpl
import dev.merge.api.services.async.ats.AttachmentServiceAsync
import dev.merge.api.services.async.ats.AttachmentServiceAsyncImpl
import dev.merge.api.services.async.ats.AvailableActionServiceAsync
import dev.merge.api.services.async.ats.AvailableActionServiceAsyncImpl
import dev.merge.api.services.async.ats.CandidateServiceAsync
import dev.merge.api.services.async.ats.CandidateServiceAsyncImpl
import dev.merge.api.services.async.ats.CommonModelScopeServiceAsync
import dev.merge.api.services.async.ats.CommonModelScopeServiceAsyncImpl
import dev.merge.api.services.async.ats.DepartmentServiceAsync
import dev.merge.api.services.async.ats.DepartmentServiceAsyncImpl
import dev.merge.api.services.async.ats.EeocServiceAsync
import dev.merge.api.services.async.ats.EeocServiceAsyncImpl
import dev.merge.api.services.async.ats.InterviewServiceAsync
import dev.merge.api.services.async.ats.InterviewServiceAsyncImpl
import dev.merge.api.services.async.ats.IssueServiceAsync
import dev.merge.api.services.async.ats.IssueServiceAsyncImpl
import dev.merge.api.services.async.ats.JobInterviewStageServiceAsync
import dev.merge.api.services.async.ats.JobInterviewStageServiceAsyncImpl
import dev.merge.api.services.async.ats.JobServiceAsync
import dev.merge.api.services.async.ats.JobServiceAsyncImpl
import dev.merge.api.services.async.ats.LinkTokenServiceAsync
import dev.merge.api.services.async.ats.LinkTokenServiceAsyncImpl
import dev.merge.api.services.async.ats.LinkedAccountServiceAsync
import dev.merge.api.services.async.ats.LinkedAccountServiceAsyncImpl
import dev.merge.api.services.async.ats.OfferServiceAsync
import dev.merge.api.services.async.ats.OfferServiceAsyncImpl
import dev.merge.api.services.async.ats.OfficeServiceAsync
import dev.merge.api.services.async.ats.OfficeServiceAsyncImpl
import dev.merge.api.services.async.ats.PassthroughRequestServiceAsync
import dev.merge.api.services.async.ats.PassthroughRequestServiceAsyncImpl
import dev.merge.api.services.async.ats.RejectReasonServiceAsync
import dev.merge.api.services.async.ats.RejectReasonServiceAsyncImpl
import dev.merge.api.services.async.ats.RemoteKeyServiceAsync
import dev.merge.api.services.async.ats.RemoteKeyServiceAsyncImpl
import dev.merge.api.services.async.ats.ScorecardServiceAsync
import dev.merge.api.services.async.ats.ScorecardServiceAsyncImpl
import dev.merge.api.services.async.ats.SelectiveSyncServiceAsync
import dev.merge.api.services.async.ats.SelectiveSyncServiceAsyncImpl
import dev.merge.api.services.async.ats.SyncStatusServiceAsync
import dev.merge.api.services.async.ats.SyncStatusServiceAsyncImpl
import dev.merge.api.services.async.ats.TagServiceAsync
import dev.merge.api.services.async.ats.TagServiceAsyncImpl
import dev.merge.api.services.async.ats.UserServiceAsync
import dev.merge.api.services.async.ats.UserServiceAsyncImpl
import dev.merge.api.services.async.ats.WebhookReceiverServiceAsync
import dev.merge.api.services.async.ats.WebhookReceiverServiceAsyncImpl
import dev.merge.api.services.errorHandler

class AtsServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : AtsServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val activities: ActivityServiceAsync by lazy { ActivityServiceAsyncImpl(clientOptions) }

    private val applications: ApplicationServiceAsync by lazy {
        ApplicationServiceAsyncImpl(clientOptions)
    }

    private val attachments: AttachmentServiceAsync by lazy {
        AttachmentServiceAsyncImpl(clientOptions)
    }

    private val candidates: CandidateServiceAsync by lazy {
        CandidateServiceAsyncImpl(clientOptions)
    }

    private val departments: DepartmentServiceAsync by lazy {
        DepartmentServiceAsyncImpl(clientOptions)
    }

    private val eeocs: EeocServiceAsync by lazy { EeocServiceAsyncImpl(clientOptions) }

    private val interviews: InterviewServiceAsync by lazy {
        InterviewServiceAsyncImpl(clientOptions)
    }

    private val jobInterviewStages: JobInterviewStageServiceAsync by lazy {
        JobInterviewStageServiceAsyncImpl(clientOptions)
    }

    private val jobs: JobServiceAsync by lazy { JobServiceAsyncImpl(clientOptions) }

    private val offers: OfferServiceAsync by lazy { OfferServiceAsyncImpl(clientOptions) }

    private val offices: OfficeServiceAsync by lazy { OfficeServiceAsyncImpl(clientOptions) }

    private val rejectReasons: RejectReasonServiceAsync by lazy {
        RejectReasonServiceAsyncImpl(clientOptions)
    }

    private val scorecards: ScorecardServiceAsync by lazy {
        ScorecardServiceAsyncImpl(clientOptions)
    }

    private val tags: TagServiceAsync by lazy { TagServiceAsyncImpl(clientOptions) }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptions) }

    private val accountDetails: AccountDetailServiceAsync by lazy {
        AccountDetailServiceAsyncImpl(clientOptions)
    }

    private val accountTokens: AccountTokenServiceAsync by lazy {
        AccountTokenServiceAsyncImpl(clientOptions)
    }

    private val linkTokens: LinkTokenServiceAsync by lazy {
        LinkTokenServiceAsyncImpl(clientOptions)
    }

    private val availableActions: AvailableActionServiceAsync by lazy {
        AvailableActionServiceAsyncImpl(clientOptions)
    }

    private val remoteKeys: RemoteKeyServiceAsync by lazy {
        RemoteKeyServiceAsyncImpl(clientOptions)
    }

    private val issues: IssueServiceAsync by lazy { IssueServiceAsyncImpl(clientOptions) }

    private val commonModelScopes: CommonModelScopeServiceAsync by lazy {
        CommonModelScopeServiceAsyncImpl(clientOptions)
    }

    private val passthroughRequests: PassthroughRequestServiceAsync by lazy {
        PassthroughRequestServiceAsyncImpl(clientOptions)
    }

    private val syncStatus: SyncStatusServiceAsync by lazy {
        SyncStatusServiceAsyncImpl(clientOptions)
    }

    private val webhookReceivers: WebhookReceiverServiceAsync by lazy {
        WebhookReceiverServiceAsyncImpl(clientOptions)
    }

    private val linkedAccounts: LinkedAccountServiceAsync by lazy {
        LinkedAccountServiceAsyncImpl(clientOptions)
    }

    private val selectiveSync: SelectiveSyncServiceAsync by lazy {
        SelectiveSyncServiceAsyncImpl(clientOptions)
    }

    override fun activities(): ActivityServiceAsync = activities

    override fun applications(): ApplicationServiceAsync = applications

    override fun attachments(): AttachmentServiceAsync = attachments

    override fun candidates(): CandidateServiceAsync = candidates

    override fun departments(): DepartmentServiceAsync = departments

    override fun eeocs(): EeocServiceAsync = eeocs

    override fun interviews(): InterviewServiceAsync = interviews

    override fun jobInterviewStages(): JobInterviewStageServiceAsync = jobInterviewStages

    override fun jobs(): JobServiceAsync = jobs

    override fun offers(): OfferServiceAsync = offers

    override fun offices(): OfficeServiceAsync = offices

    override fun rejectReasons(): RejectReasonServiceAsync = rejectReasons

    override fun scorecards(): ScorecardServiceAsync = scorecards

    override fun tags(): TagServiceAsync = tags

    override fun users(): UserServiceAsync = users

    override fun accountDetails(): AccountDetailServiceAsync = accountDetails

    override fun accountTokens(): AccountTokenServiceAsync = accountTokens

    override fun linkTokens(): LinkTokenServiceAsync = linkTokens

    override fun availableActions(): AvailableActionServiceAsync = availableActions

    override fun remoteKeys(): RemoteKeyServiceAsync = remoteKeys

    override fun issues(): IssueServiceAsync = issues

    override fun commonModelScopes(): CommonModelScopeServiceAsync = commonModelScopes

    override fun passthroughRequests(): PassthroughRequestServiceAsync = passthroughRequests

    override fun syncStatus(): SyncStatusServiceAsync = syncStatus

    override fun webhookReceivers(): WebhookReceiverServiceAsync = webhookReceivers

    override fun linkedAccounts(): LinkedAccountServiceAsync = linkedAccounts

    override fun selectiveSync(): SelectiveSyncServiceAsync = selectiveSync
}
