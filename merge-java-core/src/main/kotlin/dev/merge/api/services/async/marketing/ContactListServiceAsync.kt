@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.ContactList
import dev.merge.api.models.marketing.ContactListCreateParams
import dev.merge.api.models.marketing.ContactListCreateResponse
import dev.merge.api.models.marketing.ContactListListPageAsync
import dev.merge.api.models.marketing.ContactListListParams
import dev.merge.api.models.marketing.ContactListListSubscribersPageAsync
import dev.merge.api.models.marketing.ContactListListSubscribersParams
import dev.merge.api.models.marketing.ContactListRetrieveParams
import dev.merge.api.services.async.marketing.contactLists.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface ContactListServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `List` object with the given values. */
    @JvmOverloads
    fun create(
        params: ContactListCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ContactListCreateResponse>

    /** Returns a `List` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ContactListRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ContactList>

    /** Returns a list of `List` objects. */
    @JvmOverloads
    fun list(
        params: ContactListListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ContactListListPageAsync>

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun listSubscribers(
        params: ContactListListSubscribersParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ContactListListSubscribersPageAsync>
}
