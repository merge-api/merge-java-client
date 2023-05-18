@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.Event
import dev.merge.api.models.marketing.EventListContactsPage
import dev.merge.api.models.marketing.EventListContactsParams
import dev.merge.api.models.marketing.EventListPage
import dev.merge.api.models.marketing.EventListParams
import dev.merge.api.models.marketing.EventRetrieveParams

interface EventService {

    /** Returns an `Event` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EventRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Event

    /** Returns a list of `Event` objects. */
    @JvmOverloads
    fun list(
        params: EventListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EventListPage

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun listContacts(
        params: EventListContactsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EventListContactsPage
}
