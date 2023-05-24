@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.Campaign
import dev.merge.api.models.marketing.CampaignCreateParams
import dev.merge.api.models.marketing.CampaignListContactsPageAsync
import dev.merge.api.models.marketing.CampaignListContactsParams
import dev.merge.api.models.marketing.CampaignListPageAsync
import dev.merge.api.models.marketing.CampaignListParams
import dev.merge.api.models.marketing.CampaignResponse
import dev.merge.api.models.marketing.CampaignRetrieveParams
import dev.merge.api.services.async.marketing.campaigns.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface CampaignServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `Campaign` object with the given values. */
    @JvmOverloads
    fun create(
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CampaignResponse>

    /** Returns a `Campaign` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CampaignRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Campaign>

    /** Returns a list of `Campaign` objects. */
    @JvmOverloads
    fun list(
        params: CampaignListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CampaignListPageAsync>

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun listContacts(
        params: CampaignListContactsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CampaignListContactsPageAsync>
}
