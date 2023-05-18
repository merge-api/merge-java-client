@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async

import dev.merge.api.services.async.ats.AccountDetailServiceAsync
import dev.merge.api.services.async.ats.AccountTokenServiceAsync
import dev.merge.api.services.async.ats.ActivityServiceAsync
import dev.merge.api.services.async.ats.ApplicationServiceAsync
import dev.merge.api.services.async.ats.AttachmentServiceAsync
import dev.merge.api.services.async.ats.AvailableActionServiceAsync
import dev.merge.api.services.async.ats.CandidateServiceAsync
import dev.merge.api.services.async.ats.CommonModelScopeServiceAsync
import dev.merge.api.services.async.ats.DepartmentServiceAsync
import dev.merge.api.services.async.ats.EeocServiceAsync
import dev.merge.api.services.async.ats.InterviewServiceAsync
import dev.merge.api.services.async.ats.IssueServiceAsync
import dev.merge.api.services.async.ats.JobInterviewStageServiceAsync
import dev.merge.api.services.async.ats.JobServiceAsync
import dev.merge.api.services.async.ats.LinkTokenServiceAsync
import dev.merge.api.services.async.ats.LinkedAccountServiceAsync
import dev.merge.api.services.async.ats.OfferServiceAsync
import dev.merge.api.services.async.ats.OfficeServiceAsync
import dev.merge.api.services.async.ats.PassthroughRequestServiceAsync
import dev.merge.api.services.async.ats.RejectReasonServiceAsync
import dev.merge.api.services.async.ats.RemoteKeyServiceAsync
import dev.merge.api.services.async.ats.ScorecardServiceAsync
import dev.merge.api.services.async.ats.SelectiveSyncServiceAsync
import dev.merge.api.services.async.ats.SyncStatusServiceAsync
import dev.merge.api.services.async.ats.TagServiceAsync
import dev.merge.api.services.async.ats.UserServiceAsync
import dev.merge.api.services.async.ats.WebhookReceiverServiceAsync

interface AtsServiceAsync {

    fun activities(): ActivityServiceAsync

    fun applications(): ApplicationServiceAsync

    fun attachments(): AttachmentServiceAsync

    fun candidates(): CandidateServiceAsync

    fun departments(): DepartmentServiceAsync

    fun eeocs(): EeocServiceAsync

    fun interviews(): InterviewServiceAsync

    fun jobInterviewStages(): JobInterviewStageServiceAsync

    fun jobs(): JobServiceAsync

    fun offers(): OfferServiceAsync

    fun offices(): OfficeServiceAsync

    fun rejectReasons(): RejectReasonServiceAsync

    fun scorecards(): ScorecardServiceAsync

    fun tags(): TagServiceAsync

    fun users(): UserServiceAsync

    fun accountDetails(): AccountDetailServiceAsync

    fun accountTokens(): AccountTokenServiceAsync

    fun linkTokens(): LinkTokenServiceAsync

    fun availableActions(): AvailableActionServiceAsync

    fun remoteKeys(): RemoteKeyServiceAsync

    fun issues(): IssueServiceAsync

    fun commonModelScopes(): CommonModelScopeServiceAsync

    fun passthroughRequests(): PassthroughRequestServiceAsync

    fun syncStatus(): SyncStatusServiceAsync

    fun webhookReceivers(): WebhookReceiverServiceAsync

    fun linkedAccounts(): LinkedAccountServiceAsync

    fun selectiveSync(): SelectiveSyncServiceAsync
}
