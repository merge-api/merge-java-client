@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Account
import dev.merge.api.models.ticketing.AccountListPageAsync
import dev.merge.api.models.ticketing.AccountListParams
import dev.merge.api.models.ticketing.AccountRetrieveParams
import java.util.concurrent.CompletableFuture

interface AccountServiceAsync {

    /** Returns an `Account` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Account>

    /** Returns a list of `Account` objects. */
    @JvmOverloads
    fun list(
        params: AccountListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AccountListPageAsync>
}
