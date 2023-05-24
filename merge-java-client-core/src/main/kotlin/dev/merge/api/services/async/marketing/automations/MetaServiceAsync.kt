@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.marketing.automations

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.marketing.AutomationMetaForCreateParams
import java.util.concurrent.CompletableFuture

interface MetaServiceAsync {

    /** Returns metadata for `MKTGAutomation` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: AutomationMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<MetaResponse>
}
