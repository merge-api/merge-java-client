@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.AccountDetail
import dev.merge.api.models.crm.AccountDetailRetrieveParams
import java.util.concurrent.CompletableFuture

interface AccountDetailServiceAsync {

    /** Get details for a linked account. */
    @JvmOverloads
    fun retrieve(
        params: AccountDetailRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AccountDetail>
}
