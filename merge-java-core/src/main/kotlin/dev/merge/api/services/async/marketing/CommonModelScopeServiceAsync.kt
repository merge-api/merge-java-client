@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.CommonModelScope
import dev.merge.api.models.marketing.CommonModelScopeRetrieveParams
import dev.merge.api.models.marketing.CommonModelScopeUpdateParams
import java.util.concurrent.CompletableFuture

interface CommonModelScopeServiceAsync {

    /**
     * Fetch the configuration of what data is saved by Merge when syncing. Common model scopes are
     * set as a default across all linked accounts, but can be updated to have greater granularity
     * per account.
     */
    @JvmOverloads
    fun retrieve(
        params: CommonModelScopeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CommonModelScope>

    /**
     * Update the configuration of what data is saved by Merge when syncing. Common model scopes are
     * set as a default across all linked accounts, but can be updated to have greater granularity
     * per account.
     */
    @JvmOverloads
    fun update(
        params: CommonModelScopeUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CommonModelScope>
}
