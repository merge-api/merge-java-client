@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Team
import dev.merge.api.models.hris.TeamListPageAsync
import dev.merge.api.models.hris.TeamListParams
import dev.merge.api.models.hris.TeamRetrieveParams
import java.util.concurrent.CompletableFuture

interface TeamServiceAsync {

    /** Returns a `Team` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TeamRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Team>

    /** Returns a list of `Team` objects. */
    @JvmOverloads
    fun list(
        params: TeamListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TeamListPageAsync>
}
