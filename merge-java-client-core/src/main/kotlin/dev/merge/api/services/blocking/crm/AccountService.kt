@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Account
import dev.merge.api.models.crm.AccountCreateParams
import dev.merge.api.models.crm.AccountListPage
import dev.merge.api.models.crm.AccountListParams
import dev.merge.api.models.crm.AccountListRemoteFieldClassesPage
import dev.merge.api.models.crm.AccountListRemoteFieldClassesParams
import dev.merge.api.models.crm.AccountResponse
import dev.merge.api.models.crm.AccountRetrieveParams
import dev.merge.api.models.crm.AccountUpdateParams
import dev.merge.api.services.blocking.crm.accounts.MetaService

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

    /** Updates an `Account` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: AccountUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountResponse

    /** Returns a list of `Account` objects. */
    @JvmOverloads
    fun list(
        params: AccountListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountListPage

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: AccountListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountListRemoteFieldClassesPage
}
