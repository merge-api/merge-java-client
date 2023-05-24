@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.Template
import dev.merge.api.models.marketing.TemplateCreateParams
import dev.merge.api.models.marketing.TemplateListPage
import dev.merge.api.models.marketing.TemplateListParams
import dev.merge.api.models.marketing.TemplateResponse
import dev.merge.api.models.marketing.TemplateRetrieveParams
import dev.merge.api.services.blocking.marketing.templates.MetaService

interface TemplateService {

    fun meta(): MetaService

    /** Creates a `Template` object with the given values. */
    @JvmOverloads
    fun create(
        params: TemplateCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TemplateResponse

    /** Returns a `Template` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Template

    /** Returns a list of `Template` objects. */
    @JvmOverloads
    fun list(
        params: TemplateListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TemplateListPage
}
