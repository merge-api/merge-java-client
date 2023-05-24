@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.Benefit
import dev.merge.api.models.hris.BenefitListPage
import dev.merge.api.models.hris.BenefitListParams
import dev.merge.api.models.hris.BenefitRetrieveParams

interface BenefitService {

    /** Returns a `Benefit` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: BenefitRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Benefit

    /** Returns a list of `Benefit` objects. */
    @JvmOverloads
    fun list(
        params: BenefitListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BenefitListPage
}
