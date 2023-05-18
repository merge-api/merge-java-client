@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.Message
import dev.merge.api.models.marketing.MessageListPage
import dev.merge.api.models.marketing.MessageListParams
import dev.merge.api.models.marketing.MessageListRecipientsPage
import dev.merge.api.models.marketing.MessageListRecipientsParams
import dev.merge.api.models.marketing.MessageRetrieveParams

interface MessageService {

    /** Returns a `Message` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Message

    /** Returns a list of `Message` objects. */
    @JvmOverloads
    fun list(
        params: MessageListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MessageListPage

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun listRecipients(
        params: MessageListRecipientsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MessageListRecipientsPage
}
