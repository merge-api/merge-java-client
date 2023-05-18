@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Application
import dev.merge.api.models.ats.ApplicationChangeStageParams
import dev.merge.api.models.ats.ApplicationCreateParams
import dev.merge.api.models.ats.ApplicationListPageAsync
import dev.merge.api.models.ats.ApplicationListParams
import dev.merge.api.models.ats.ApplicationResponse
import dev.merge.api.models.ats.ApplicationRetrieveParams
import dev.merge.api.services.async.ats.applications.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface ApplicationServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `Application` object with the given values. */
    @JvmOverloads
    fun create(
        params: ApplicationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ApplicationResponse>

    /** Returns an `Application` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ApplicationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Application>

    /** Returns a list of `Application` objects. */
    @JvmOverloads
    fun list(
        params: ApplicationListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ApplicationListPageAsync>

    /** Updates the `current_stage` field of an `Application` object */
    @JvmOverloads
    fun changeStage(
        params: ApplicationChangeStageParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ApplicationResponse>
}
