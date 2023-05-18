@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.fileStorage

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.AvailableAction
import dev.merge.api.models.fileStorage.AvailableActionRetrieveParams
import java.util.concurrent.CompletableFuture

interface AvailableActionServiceAsync {

    /** Returns a list of models and actions available for an account. */
    @JvmOverloads
    fun retrieve(
        params: AvailableActionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AvailableAction>
}
