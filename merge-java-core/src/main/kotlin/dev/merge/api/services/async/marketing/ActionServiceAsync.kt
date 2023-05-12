@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.Action
import dev.merge.api.models.marketing.ActionCreateParams
import dev.merge.api.models.marketing.ActionListPageAsync
import dev.merge.api.models.marketing.ActionListParams
import dev.merge.api.models.marketing.ActionResponse
import dev.merge.api.models.marketing.ActionRetrieveParams
import dev.merge.api.services.async.marketing.actions.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface ActionServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `Action` object with the given values. */
    @JvmOverloads
    fun create(
        params: ActionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ActionResponse>

    /** Returns an `Action` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ActionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Action>

    /** Returns a list of `Action` objects. */
    @JvmOverloads
    fun list(
        params: ActionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ActionListPageAsync>
}
