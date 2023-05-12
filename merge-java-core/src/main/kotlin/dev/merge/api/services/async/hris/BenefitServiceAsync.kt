@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.Benefit
import dev.merge.api.models.hris.BenefitListPageAsync
import dev.merge.api.models.hris.BenefitListParams
import dev.merge.api.models.hris.BenefitRetrieveParams
import java.util.concurrent.CompletableFuture

interface BenefitServiceAsync {

    /** Returns a `Benefit` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: BenefitRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Benefit>

    /** Returns a list of `Benefit` objects. */
    @JvmOverloads
    fun list(
        params: BenefitListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<BenefitListPageAsync>
}
