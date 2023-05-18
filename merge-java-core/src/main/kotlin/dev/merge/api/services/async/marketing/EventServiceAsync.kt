@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.Event
import dev.merge.api.models.marketing.EventListContactsPageAsync
import dev.merge.api.models.marketing.EventListContactsParams
import dev.merge.api.models.marketing.EventListPageAsync
import dev.merge.api.models.marketing.EventListParams
import dev.merge.api.models.marketing.EventRetrieveParams
import java.util.concurrent.CompletableFuture

interface EventServiceAsync {

    /** Returns an `Event` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EventRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Event>

    /** Returns a list of `Event` objects. */
    @JvmOverloads
    fun list(
        params: EventListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EventListPageAsync>

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun listContacts(
        params: EventListContactsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EventListContactsPageAsync>
}
