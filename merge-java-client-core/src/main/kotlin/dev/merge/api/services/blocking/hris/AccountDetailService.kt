@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.AccountDetail
import dev.merge.api.models.hris.AccountDetailRetrieveParams

interface AccountDetailService {

    /** Get details for a linked account. */
    @JvmOverloads
    fun retrieve(
        params: AccountDetailRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountDetail
}
