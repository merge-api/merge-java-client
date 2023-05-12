package dev.merge.api.services.blocking

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.blocking.ats.AccountDetailService
import dev.merge.api.services.blocking.ats.AccountDetailServiceImpl
import dev.merge.api.services.blocking.ats.AccountTokenService
import dev.merge.api.services.blocking.ats.AccountTokenServiceImpl
import dev.merge.api.services.blocking.ats.ActivityService
import dev.merge.api.services.blocking.ats.ActivityServiceImpl
import dev.merge.api.services.blocking.ats.ApplicationService
import dev.merge.api.services.blocking.ats.ApplicationServiceImpl
import dev.merge.api.services.blocking.ats.AttachmentService
import dev.merge.api.services.blocking.ats.AttachmentServiceImpl
import dev.merge.api.services.blocking.ats.AvailableActionService
import dev.merge.api.services.blocking.ats.AvailableActionServiceImpl
import dev.merge.api.services.blocking.ats.CandidateService
import dev.merge.api.services.blocking.ats.CandidateServiceImpl
import dev.merge.api.services.blocking.ats.CommonModelScopeService
import dev.merge.api.services.blocking.ats.CommonModelScopeServiceImpl
import dev.merge.api.services.blocking.ats.DepartmentService
import dev.merge.api.services.blocking.ats.DepartmentServiceImpl
import dev.merge.api.services.blocking.ats.EeocService
import dev.merge.api.services.blocking.ats.EeocServiceImpl
import dev.merge.api.services.blocking.ats.InterviewService
import dev.merge.api.services.blocking.ats.InterviewServiceImpl
import dev.merge.api.services.blocking.ats.IssueService
import dev.merge.api.services.blocking.ats.IssueServiceImpl
import dev.merge.api.services.blocking.ats.JobInterviewStageService
import dev.merge.api.services.blocking.ats.JobInterviewStageServiceImpl
import dev.merge.api.services.blocking.ats.JobService
import dev.merge.api.services.blocking.ats.JobServiceImpl
import dev.merge.api.services.blocking.ats.LinkTokenService
import dev.merge.api.services.blocking.ats.LinkTokenServiceImpl
import dev.merge.api.services.blocking.ats.LinkedAccountService
import dev.merge.api.services.blocking.ats.LinkedAccountServiceImpl
import dev.merge.api.services.blocking.ats.OfferService
import dev.merge.api.services.blocking.ats.OfferServiceImpl
import dev.merge.api.services.blocking.ats.OfficeService
import dev.merge.api.services.blocking.ats.OfficeServiceImpl
import dev.merge.api.services.blocking.ats.PassthroughRequestService
import dev.merge.api.services.blocking.ats.PassthroughRequestServiceImpl
import dev.merge.api.services.blocking.ats.RejectReasonService
import dev.merge.api.services.blocking.ats.RejectReasonServiceImpl
import dev.merge.api.services.blocking.ats.RemoteKeyService
import dev.merge.api.services.blocking.ats.RemoteKeyServiceImpl
import dev.merge.api.services.blocking.ats.ScorecardService
import dev.merge.api.services.blocking.ats.ScorecardServiceImpl
import dev.merge.api.services.blocking.ats.SelectiveSyncService
import dev.merge.api.services.blocking.ats.SelectiveSyncServiceImpl
import dev.merge.api.services.blocking.ats.SyncStatusService
import dev.merge.api.services.blocking.ats.SyncStatusServiceImpl
import dev.merge.api.services.blocking.ats.TagService
import dev.merge.api.services.blocking.ats.TagServiceImpl
import dev.merge.api.services.blocking.ats.UserService
import dev.merge.api.services.blocking.ats.UserServiceImpl
import dev.merge.api.services.blocking.ats.WebhookReceiverService
import dev.merge.api.services.blocking.ats.WebhookReceiverServiceImpl
import dev.merge.api.services.errorHandler

class AtsServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AtsService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val activities: ActivityService by lazy { ActivityServiceImpl(clientOptions) }

    private val applications: ApplicationService by lazy { ApplicationServiceImpl(clientOptions) }

    private val attachments: AttachmentService by lazy { AttachmentServiceImpl(clientOptions) }

    private val candidates: CandidateService by lazy { CandidateServiceImpl(clientOptions) }

    private val departments: DepartmentService by lazy { DepartmentServiceImpl(clientOptions) }

    private val eeocs: EeocService by lazy { EeocServiceImpl(clientOptions) }

    private val interviews: InterviewService by lazy { InterviewServiceImpl(clientOptions) }

    private val jobInterviewStages: JobInterviewStageService by lazy {
        JobInterviewStageServiceImpl(clientOptions)
    }

    private val jobs: JobService by lazy { JobServiceImpl(clientOptions) }

    private val offers: OfferService by lazy { OfferServiceImpl(clientOptions) }

    private val offices: OfficeService by lazy { OfficeServiceImpl(clientOptions) }

    private val rejectReasons: RejectReasonService by lazy {
        RejectReasonServiceImpl(clientOptions)
    }

    private val scorecards: ScorecardService by lazy { ScorecardServiceImpl(clientOptions) }

    private val tags: TagService by lazy { TagServiceImpl(clientOptions) }

    private val users: UserService by lazy { UserServiceImpl(clientOptions) }

    private val accountDetails: AccountDetailService by lazy {
        AccountDetailServiceImpl(clientOptions)
    }

    private val accountTokens: AccountTokenService by lazy {
        AccountTokenServiceImpl(clientOptions)
    }

    private val linkTokens: LinkTokenService by lazy { LinkTokenServiceImpl(clientOptions) }

    private val availableActions: AvailableActionService by lazy {
        AvailableActionServiceImpl(clientOptions)
    }

    private val remoteKeys: RemoteKeyService by lazy { RemoteKeyServiceImpl(clientOptions) }

    private val issues: IssueService by lazy { IssueServiceImpl(clientOptions) }

    private val commonModelScopes: CommonModelScopeService by lazy {
        CommonModelScopeServiceImpl(clientOptions)
    }

    private val passthroughRequests: PassthroughRequestService by lazy {
        PassthroughRequestServiceImpl(clientOptions)
    }

    private val syncStatus: SyncStatusService by lazy { SyncStatusServiceImpl(clientOptions) }

    private val webhookReceivers: WebhookReceiverService by lazy {
        WebhookReceiverServiceImpl(clientOptions)
    }

    private val linkedAccounts: LinkedAccountService by lazy {
        LinkedAccountServiceImpl(clientOptions)
    }

    private val selectiveSync: SelectiveSyncService by lazy {
        SelectiveSyncServiceImpl(clientOptions)
    }

    override fun activities(): ActivityService = activities

    override fun applications(): ApplicationService = applications

    override fun attachments(): AttachmentService = attachments

    override fun candidates(): CandidateService = candidates

    override fun departments(): DepartmentService = departments

    override fun eeocs(): EeocService = eeocs

    override fun interviews(): InterviewService = interviews

    override fun jobInterviewStages(): JobInterviewStageService = jobInterviewStages

    override fun jobs(): JobService = jobs

    override fun offers(): OfferService = offers

    override fun offices(): OfficeService = offices

    override fun rejectReasons(): RejectReasonService = rejectReasons

    override fun scorecards(): ScorecardService = scorecards

    override fun tags(): TagService = tags

    override fun users(): UserService = users

    override fun accountDetails(): AccountDetailService = accountDetails

    override fun accountTokens(): AccountTokenService = accountTokens

    override fun linkTokens(): LinkTokenService = linkTokens

    override fun availableActions(): AvailableActionService = availableActions

    override fun remoteKeys(): RemoteKeyService = remoteKeys

    override fun issues(): IssueService = issues

    override fun commonModelScopes(): CommonModelScopeService = commonModelScopes

    override fun passthroughRequests(): PassthroughRequestService = passthroughRequests

    override fun syncStatus(): SyncStatusService = syncStatus

    override fun webhookReceivers(): WebhookReceiverService = webhookReceivers

    override fun linkedAccounts(): LinkedAccountService = linkedAccounts

    override fun selectiveSync(): SelectiveSyncService = selectiveSync
}
