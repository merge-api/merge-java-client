@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.VendorCredit
import dev.merge.api.models.accounting.VendorCreditListPage
import dev.merge.api.models.accounting.VendorCreditListParams
import dev.merge.api.models.accounting.VendorCreditRetrieveParams

interface VendorCreditService {

    /** Returns a `VendorCredit` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: VendorCreditRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VendorCredit

    /** Returns a list of `VendorCredit` objects. */
    @JvmOverloads
    fun list(
        params: VendorCreditListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VendorCreditListPage
}
