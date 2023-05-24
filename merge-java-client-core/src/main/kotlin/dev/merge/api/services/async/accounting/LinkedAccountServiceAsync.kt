@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.LinkedAccountDeleteParams
import dev.merge.api.models.accounting.LinkedAccountListPageAsync
import dev.merge.api.models.accounting.LinkedAccountListParams
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
