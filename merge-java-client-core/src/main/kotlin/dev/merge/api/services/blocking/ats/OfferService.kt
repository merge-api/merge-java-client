@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Offer
import dev.merge.api.models.ats.OfferListPage
import dev.merge.api.models.ats.OfferListParams
import dev.merge.api.models.ats.OfferRetrieveParams

interface OfferService {

    /** Returns an `Offer` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: OfferRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Offer

    /** Returns a list of `Offer` objects. */
    @JvmOverloads
    fun list(
        params: OfferListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OfferListPage
}
