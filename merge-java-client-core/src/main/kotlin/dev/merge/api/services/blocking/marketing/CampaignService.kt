@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.Campaign
import dev.merge.api.models.marketing.CampaignCreateParams
import dev.merge.api.models.marketing.CampaignListContactsPage
import dev.merge.api.models.marketing.CampaignListContactsParams
import dev.merge.api.models.marketing.CampaignListPage
import dev.merge.api.models.marketing.CampaignListParams
import dev.merge.api.models.marketing.CampaignResponse
import dev.merge.api.models.marketing.CampaignRetrieveParams
import dev.merge.api.services.blocking.marketing.campaigns.MetaService

interface CampaignService {

    fun meta(): MetaService

    /** Creates a `Campaign` object with the given values. */
    @JvmOverloads
    fun create(
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CampaignResponse

    /** Returns a `Campaign` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CampaignRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Campaign

    /** Returns a list of `Campaign` objects. */
    @JvmOverloads
    fun list(
        params: CampaignListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CampaignListPage

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun listContacts(
        params: CampaignListContactsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CampaignListContactsPage
}
