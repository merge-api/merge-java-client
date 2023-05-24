@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.Template
import dev.merge.api.models.marketing.TemplateCreateParams
import dev.merge.api.models.marketing.TemplateListPageAsync
import dev.merge.api.models.marketing.TemplateListParams
import dev.merge.api.models.marketing.TemplateResponse
import dev.merge.api.models.marketing.TemplateRetrieveParams
import dev.merge.api.services.async.marketing.templates.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface TemplateServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `Template` object with the given values. */
    @JvmOverloads
    fun create(
        params: TemplateCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TemplateResponse>

    /** Returns a `Template` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Template>

    /** Returns a list of `Template` objects. */
    @JvmOverloads
    fun list(
        params: TemplateListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TemplateListPageAsync>
}
