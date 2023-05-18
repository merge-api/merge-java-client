@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.LinkedAccountDeleteParams
import dev.merge.api.models.crm.LinkedAccountListPageAsync
import dev.merge.api.models.crm.LinkedAccountListParams
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
