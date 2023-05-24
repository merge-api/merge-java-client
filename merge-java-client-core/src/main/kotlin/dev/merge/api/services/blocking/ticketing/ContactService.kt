@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Contact
import dev.merge.api.models.ticketing.ContactListPage
import dev.merge.api.models.ticketing.ContactListParams
import dev.merge.api.models.ticketing.ContactRetrieveParams

interface ContactService {

    /** Returns a `Contact` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ContactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Contact

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun list(
        params: ContactListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ContactListPage
}
