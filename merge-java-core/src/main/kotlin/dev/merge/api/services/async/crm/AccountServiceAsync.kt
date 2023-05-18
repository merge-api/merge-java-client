@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Account
import dev.merge.api.models.crm.AccountCreateParams
import dev.merge.api.models.crm.AccountListPageAsync
import dev.merge.api.models.crm.AccountListParams
import dev.merge.api.models.crm.AccountListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.AccountListRemoteFieldClassesParams
import dev.merge.api.models.crm.AccountResponse
import dev.merge.api.models.crm.AccountRetrieveParams
import dev.merge.api.models.crm.AccountUpdateParams
import dev.merge.api.services.async.crm.accounts.MetaServiceAsync
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

    /** Updates an `Account` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: AccountUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AccountResponse>

    /** Returns a list of `Account` objects. */
    @JvmOverloads
    fun list(
        params: AccountListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AccountListPageAsync>

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: AccountListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AccountListRemoteFieldClassesPageAsync>
}
