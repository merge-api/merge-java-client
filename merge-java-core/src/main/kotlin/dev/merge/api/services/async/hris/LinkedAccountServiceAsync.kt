@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.LinkedAccountDeleteParams
import dev.merge.api.models.hris.LinkedAccountListPageAsync
import dev.merge.api.models.hris.LinkedAccountListParams
import java.util.concurrent.CompletableFuture

interface LinkedAccountServiceAsync {

    /** List linked accounts for your organization. */
    @JvmOverloads
    fun list(
        params: LinkedAccountListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<LinkedAccountListPageAsync>

    /** Delete a linked account. */
    @JvmOverloads
    fun delete(
        params: LinkedAccountDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Void>
}
