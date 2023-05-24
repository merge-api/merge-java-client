@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm.customObjects

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.CustomObjectClass
import dev.merge.api.models.crm.CustomObjectGeneratorUpdateParams
import java.util.concurrent.CompletableFuture

interface GeneratorServiceAsync {

    /** Updates a `CustomObjectClass` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: CustomObjectGeneratorUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CustomObjectClass>
}
