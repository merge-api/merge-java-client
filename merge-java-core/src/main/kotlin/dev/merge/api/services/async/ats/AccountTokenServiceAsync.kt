@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.AccountToken
import dev.merge.api.models.ats.AccountTokenRetrieveParams
import java.util.concurrent.CompletableFuture

interface AccountTokenServiceAsync {

    /** Returns the account token for the end user with the provided public token. */
    @JvmOverloads
    fun retrieve(
        params: AccountTokenRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AccountToken>
}
