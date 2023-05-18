@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.WebhookReceiver
import dev.merge.api.models.accounting.WebhookReceiverCreateParams
import dev.merge.api.models.accounting.WebhookReceiverListParams

interface WebhookReceiverService {

    /** Creates a `WebhookReceiver` object with the given values. */
    @JvmOverloads
    fun create(
        params: WebhookReceiverCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): WebhookReceiver

    /** Returns a list of `WebhookReceiver` objects. */
    @JvmOverloads
    fun list(
        params: WebhookReceiverListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): List<WebhookReceiver>
}
