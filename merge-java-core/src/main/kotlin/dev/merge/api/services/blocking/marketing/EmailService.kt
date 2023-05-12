@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.Email
import dev.merge.api.models.marketing.EmailListPage
import dev.merge.api.models.marketing.EmailListParams
import dev.merge.api.models.marketing.EmailListRecipientsPage
import dev.merge.api.models.marketing.EmailListRecipientsParams
import dev.merge.api.models.marketing.EmailRetrieveParams

interface EmailService {

    /** Returns a `MarketingEmail` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EmailRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Email

    /** Returns a list of `MarketingEmail` objects. */
    @JvmOverloads
    fun list(
        params: EmailListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EmailListPage

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun listRecipients(
        params: EmailListRecipientsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EmailListRecipientsPage
}
