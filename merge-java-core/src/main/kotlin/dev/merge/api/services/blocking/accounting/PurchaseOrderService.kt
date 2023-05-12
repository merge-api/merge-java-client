@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.PurchaseOrder
import dev.merge.api.models.accounting.PurchaseOrderCreateParams
import dev.merge.api.models.accounting.PurchaseOrderListPage
import dev.merge.api.models.accounting.PurchaseOrderListParams
import dev.merge.api.models.accounting.PurchaseOrderResponse
import dev.merge.api.models.accounting.PurchaseOrderRetrieveParams
import dev.merge.api.services.blocking.accounting.purchaseOrders.MetaService

interface PurchaseOrderService {

    fun meta(): MetaService

    /** Creates a `PurchaseOrder` object with the given values. */
    @JvmOverloads
    fun create(
        params: PurchaseOrderCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PurchaseOrderResponse

    /** Returns a `PurchaseOrder` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: PurchaseOrderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PurchaseOrder

    /** Returns a list of `PurchaseOrder` objects. */
    @JvmOverloads
    fun list(
        params: PurchaseOrderListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PurchaseOrderListPage
}
