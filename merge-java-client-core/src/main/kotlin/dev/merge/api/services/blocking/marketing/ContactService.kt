@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Contact
import dev.merge.api.models.marketing.ContactCreateParams
import dev.merge.api.models.marketing.ContactListPage
import dev.merge.api.models.marketing.ContactListParams
import dev.merge.api.models.marketing.ContactResponse
import dev.merge.api.models.marketing.ContactRetrieveParams
import dev.merge.api.services.blocking.marketing.contacts.MetaService

interface ContactService {

    fun meta(): MetaService

    /** Creates a `Contact` object with the given values. */
    @JvmOverloads
    fun create(
        params: ContactCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ContactResponse

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
