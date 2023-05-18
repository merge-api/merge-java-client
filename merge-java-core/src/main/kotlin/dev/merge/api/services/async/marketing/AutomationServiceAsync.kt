@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.Automation
import dev.merge.api.models.marketing.AutomationCreateParams
import dev.merge.api.models.marketing.AutomationListPageAsync
import dev.merge.api.models.marketing.AutomationListParams
import dev.merge.api.models.marketing.AutomationListRecipientsPageAsync
import dev.merge.api.models.marketing.AutomationListRecipientsParams
import dev.merge.api.models.marketing.AutomationResponse
import dev.merge.api.models.marketing.AutomationRetrieveParams
import dev.merge.api.services.async.marketing.automations.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface AutomationServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `Automation` object with the given values. */
    @JvmOverloads
    fun create(
        params: AutomationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AutomationResponse>

    /** Returns an `Automation` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: AutomationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Automation>

    /** Returns a list of `Automation` objects. */
    @JvmOverloads
    fun list(
        params: AutomationListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AutomationListPageAsync>

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun listRecipients(
        params: AutomationListRecipientsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AutomationListRecipientsPageAsync>
}
