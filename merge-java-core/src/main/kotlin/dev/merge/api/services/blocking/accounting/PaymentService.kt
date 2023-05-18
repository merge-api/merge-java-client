@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.Payment
import dev.merge.api.models.accounting.PaymentCreateParams
import dev.merge.api.models.accounting.PaymentListPage
import dev.merge.api.models.accounting.PaymentListParams
import dev.merge.api.models.accounting.PaymentResponse
import dev.merge.api.models.accounting.PaymentRetrieveParams
import dev.merge.api.services.blocking.accounting.payments.MetaService

interface PaymentService {

    fun meta(): MetaService

    /** Creates a `Payment` object with the given values. */
    @JvmOverloads
    fun create(
        params: PaymentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PaymentResponse

    /** Returns a `Payment` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: PaymentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Payment

    /** Returns a list of `Payment` objects. */
    @JvmOverloads
    fun list(
        params: PaymentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PaymentListPage
}
