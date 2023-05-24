@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Team
import dev.merge.api.models.hris.TeamListPage
import dev.merge.api.models.hris.TeamListParams
import dev.merge.api.models.hris.TeamRetrieveParams

interface TeamService {

    /** Returns a `Team` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TeamRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Team

    /** Returns a list of `Team` objects. */
    @JvmOverloads
    fun list(
        params: TeamListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TeamListPage
}
