@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.ContactList
import dev.merge.api.models.marketing.ContactListCreateParams
import dev.merge.api.models.marketing.ContactListCreateResponse
import dev.merge.api.models.marketing.ContactListListPage
import dev.merge.api.models.marketing.ContactListListParams
import dev.merge.api.models.marketing.ContactListListSubscribersPage
import dev.merge.api.models.marketing.ContactListListSubscribersParams
import dev.merge.api.models.marketing.ContactListRetrieveParams
import dev.merge.api.services.blocking.marketing.contactLists.MetaService

interface ContactListService {

    fun meta(): MetaService

    /** Creates a `List` object with the given values. */
    @JvmOverloads
    fun create(
        params: ContactListCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ContactListCreateResponse

    /** Returns a `List` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ContactListRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ContactList

    /** Returns a list of `List` objects. */
    @JvmOverloads
    fun list(
        params: ContactListListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ContactListListPage

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun listSubscribers(
        params: ContactListListSubscribersParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ContactListListSubscribersPage
}
