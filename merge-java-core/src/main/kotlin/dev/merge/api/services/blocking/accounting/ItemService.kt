@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.Item
import dev.merge.api.models.accounting.ItemListPage
import dev.merge.api.models.accounting.ItemListParams
import dev.merge.api.models.accounting.ItemRetrieveParams

interface ItemService {

    /** Returns an `Item` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Item

    /** Returns a list of `Item` objects. */
    @JvmOverloads
    fun list(
        params: ItemListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ItemListPage
}
