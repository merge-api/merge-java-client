@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm.opportunities

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.OpportunityMetaForCreateParams
import dev.merge.api.models.crm.OpportunityMetaForUpdateParams
import java.util.concurrent.CompletableFuture

interface MetaServiceAsync {

    /** Returns metadata for `Opportunity` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: OpportunityMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<MetaResponse>

    /** Returns metadata for `Opportunity` PATCHs. */
    @JvmOverloads
    fun forUpdate(
        params: OpportunityMetaForUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<MetaResponse>
}
