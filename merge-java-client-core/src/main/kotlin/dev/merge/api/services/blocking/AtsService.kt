@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking

import dev.merge.api.services.blocking.ats.AccountDetailService
import dev.merge.api.services.blocking.ats.AccountTokenService
import dev.merge.api.services.blocking.ats.ActivityService
import dev.merge.api.services.blocking.ats.ApplicationService
import dev.merge.api.services.blocking.ats.AttachmentService
import dev.merge.api.services.blocking.ats.AvailableActionService
import dev.merge.api.services.blocking.ats.CandidateService
import dev.merge.api.services.blocking.ats.CommonModelScopeService
import dev.merge.api.services.blocking.ats.DepartmentService
import dev.merge.api.services.blocking.ats.EeocService
import dev.merge.api.services.blocking.ats.InterviewService
import dev.merge.api.services.blocking.ats.IssueService
import dev.merge.api.services.blocking.ats.JobInterviewStageService
import dev.merge.api.services.blocking.ats.JobService
import dev.merge.api.services.blocking.ats.LinkTokenService
import dev.merge.api.services.blocking.ats.LinkedAccountService
import dev.merge.api.services.blocking.ats.OfferService
import dev.merge.api.services.blocking.ats.OfficeService
import dev.merge.api.services.blocking.ats.PassthroughRequestService
import dev.merge.api.services.blocking.ats.RejectReasonService
import dev.merge.api.services.blocking.ats.RemoteKeyService
import dev.merge.api.services.blocking.ats.ScorecardService
import dev.merge.api.services.blocking.ats.SelectiveSyncService
import dev.merge.api.services.blocking.ats.SyncStatusService
import dev.merge.api.services.blocking.ats.TagService
import dev.merge.api.services.blocking.ats.UserService
import dev.merge.api.services.blocking.ats.WebhookReceiverService

interface AtsService {

    fun activities(): ActivityService

    fun applications(): ApplicationService

    fun attachments(): AttachmentService

    fun candidates(): CandidateService

    fun departments(): DepartmentService

    fun eeocs(): EeocService

    fun interviews(): InterviewService

    fun jobInterviewStages(): JobInterviewStageService

    fun jobs(): JobService

    fun offers(): OfferService

    fun offices(): OfficeService

    fun rejectReasons(): RejectReasonService

    fun scorecards(): ScorecardService

    fun tags(): TagService

    fun users(): UserService

    fun accountDetails(): AccountDetailService

    fun accountTokens(): AccountTokenService

    fun linkTokens(): LinkTokenService

    fun availableActions(): AvailableActionService

    fun remoteKeys(): RemoteKeyService

    fun issues(): IssueService

    fun commonModelScopes(): CommonModelScopeService

    fun passthroughRequests(): PassthroughRequestService

    fun syncStatus(): SyncStatusService

    fun webhookReceivers(): WebhookReceiverService

    fun linkedAccounts(): LinkedAccountService

    fun selectiveSync(): SelectiveSyncService
}
