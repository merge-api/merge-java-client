@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.Automation
import dev.merge.api.models.marketing.AutomationCreateParams
import dev.merge.api.models.marketing.AutomationListPage
import dev.merge.api.models.marketing.AutomationListParams
import dev.merge.api.models.marketing.AutomationListRecipientsPage
import dev.merge.api.models.marketing.AutomationListRecipientsParams
import dev.merge.api.models.marketing.AutomationResponse
import dev.merge.api.models.marketing.AutomationRetrieveParams
import dev.merge.api.services.blocking.marketing.automations.MetaService

interface AutomationService {

    fun meta(): MetaService

    /** Creates an `Automation` object with the given values. */
    @JvmOverloads
    fun create(
        params: AutomationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AutomationResponse

    /** Returns an `Automation` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: AutomationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Automation

    /** Returns a list of `Automation` objects. */
    @JvmOverloads
    fun list(
        params: AutomationListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AutomationListPage

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun listRecipients(
        params: AutomationListRecipientsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AutomationListRecipientsPage
}
