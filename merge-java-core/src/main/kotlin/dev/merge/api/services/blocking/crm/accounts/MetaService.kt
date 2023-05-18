@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm.accounts

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.AccountMetaForCreateParams
import dev.merge.api.models.crm.AccountMetaForUpdateParams

interface MetaService {

    /** Returns metadata for `CRMAccount` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: AccountMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse

    /** Returns metadata for `CRMAccount` PATCHs. */
    @JvmOverloads
    fun forUpdate(
        params: AccountMetaForUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}
