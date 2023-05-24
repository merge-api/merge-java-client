@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm.customObjects

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.CustomObjectClass
import dev.merge.api.models.crm.CustomObjectGeneratorUpdateParams

interface GeneratorService {

    /** Updates a `CustomObjectClass` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: CustomObjectGeneratorUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CustomObjectClass
}
