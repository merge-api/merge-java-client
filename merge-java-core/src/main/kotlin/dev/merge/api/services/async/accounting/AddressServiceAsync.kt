@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Address
import dev.merge.api.models.accounting.AddressRetrieveParams
import java.util.concurrent.CompletableFuture

interface AddressServiceAsync {

    /** Returns an `Address` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: AddressRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Address>
}
