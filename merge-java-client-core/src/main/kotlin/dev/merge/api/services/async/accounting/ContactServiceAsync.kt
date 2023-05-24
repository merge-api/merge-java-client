@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Contact
import dev.merge.api.models.accounting.ContactCreateParams
import dev.merge.api.models.accounting.ContactListPageAsync
import dev.merge.api.models.accounting.ContactListParams
import dev.merge.api.models.accounting.ContactResponse
import dev.merge.api.models.accounting.ContactRetrieveParams
import dev.merge.api.services.async.accounting.contacts.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface ContactServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `Contact` object with the given values. */
    @JvmOverloads
    fun create(
        params: ContactCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ContactResponse>

    /** Returns a `Contact` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ContactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Contact>

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun list(
        params: ContactListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ContactListPageAsync>
}
