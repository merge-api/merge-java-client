@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Account
import dev.merge.api.models.accounting.AccountCreateParams
import dev.merge.api.models.accounting.AccountListPageAsync
import dev.merge.api.models.accounting.AccountListParams
import dev.merge.api.models.accounting.AccountResponse
import dev.merge.api.models.accounting.AccountRetrieveParams
import dev.merge.api.services.async.accounting.accounts.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface AccountServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `Account` object with the given values. */
    @JvmOverloads
    fun create(
        params: AccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AccountResponse>

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
