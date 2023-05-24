@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.WebhookReceiver
import dev.merge.api.models.hris.WebhookReceiverCreateParams
import dev.merge.api.models.hris.WebhookReceiverListParams
import java.util.concurrent.CompletableFuture

interface WebhookReceiverServiceAsync {

    /** Creates a `WebhookReceiver` object with the given values. */
    @JvmOverloads
    fun create(
        params: WebhookReceiverCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<WebhookReceiver>

    /** Returns a list of `WebhookReceiver` objects. */
    @JvmOverloads
    fun list(
        params: WebhookReceiverListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<List<WebhookReceiver>>
}
