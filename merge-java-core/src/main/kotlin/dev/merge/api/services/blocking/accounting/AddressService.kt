@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Address
import dev.merge.api.models.accounting.AddressRetrieveParams

interface AddressService {

    /** Returns an `Address` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: AddressRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Address
}
