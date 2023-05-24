@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing.templates

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.marketing.TemplateMetaForCreateParams

interface MetaService {

    /** Returns metadata for `MKTGTemplate` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: TemplateMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}
