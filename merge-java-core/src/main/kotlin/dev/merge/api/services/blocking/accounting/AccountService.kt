@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Account
import dev.merge.api.models.accounting.AccountCreateParams
import dev.merge.api.models.accounting.AccountListPage
import dev.merge.api.models.accounting.AccountListParams
import dev.merge.api.models.accounting.AccountResponse
import dev.merge.api.models.accounting.AccountRetrieveParams
import dev.merge.api.services.blocking.accounting.accounts.MetaService

interface AccountService {

    fun meta(): MetaService

    /** Creates an `Account` object with the given values. */
    @JvmOverloads
    fun create(
        params: AccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountResponse

    /** Returns an `Account` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Account

    /** Returns a list of `Account` objects. */
    @JvmOverloads
    fun list(
        params: AccountListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountListPage
}
