@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.CompanyInfo
import dev.merge.api.models.accounting.CompanyInfoListPage
import dev.merge.api.models.accounting.CompanyInfoListParams
import dev.merge.api.models.accounting.CompanyInfoRetrieveParams

interface CompanyInfoService {

    /** Returns a `CompanyInfo` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CompanyInfoRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompanyInfo

    /** Returns a list of `CompanyInfo` objects. */
    @JvmOverloads
    fun list(
        params: CompanyInfoListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompanyInfoListPage
}
