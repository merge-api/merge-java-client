@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.PhoneNumber
import dev.merge.api.models.accounting.PhoneNumberRetrieveParams

interface PhoneNumberService {

    /** Returns an `AccountingPhoneNumber` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: PhoneNumberRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhoneNumber
}
