@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ticketing.Ticket
import dev.merge.api.models.ticketing.TicketCreateParams
import dev.merge.api.models.ticketing.TicketListCollaboratorsPageAsync
import dev.merge.api.models.ticketing.TicketListCollaboratorsParams
import dev.merge.api.models.ticketing.TicketListPageAsync
import dev.merge.api.models.ticketing.TicketListParams
import dev.merge.api.models.ticketing.TicketListRemoteFieldClassesPageAsync
import dev.merge.api.models.ticketing.TicketListRemoteFieldClassesParams
import dev.merge.api.models.ticketing.TicketResponse
import dev.merge.api.models.ticketing.TicketRetrieveParams
import dev.merge.api.models.ticketing.TicketUpdateParams
import dev.merge.api.services.async.ticketing.tickets.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface TicketServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `Ticket` object with the given values. */
    @JvmOverloads
    fun create(
        params: TicketCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TicketResponse>

    /** Returns a `Ticket` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TicketRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Ticket>

    /** Updates a `Ticket` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: TicketUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TicketResponse>

    /** Returns a list of `Ticket` objects. */
    @JvmOverloads
    fun list(
        params: TicketListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TicketListPageAsync>

    /** Returns a list of `User` objects. */
    @JvmOverloads
    fun listCollaborators(
        params: TicketListCollaboratorsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TicketListCollaboratorsPageAsync>

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: TicketListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TicketListRemoteFieldClassesPageAsync>
}
