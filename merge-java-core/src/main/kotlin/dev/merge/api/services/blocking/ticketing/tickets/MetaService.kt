@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ticketing.tickets

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.ticketing.TicketMetaForCreateParams
import dev.merge.api.models.ticketing.TicketMetaForUpdateParams

interface MetaService {

    /** Returns metadata for `Ticket` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: TicketMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse

    /** Returns metadata for `Ticket` PATCHs. */
    @JvmOverloads
    fun forUpdate(
        params: TicketMetaForUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}
