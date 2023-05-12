@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ticketing.Comment
import dev.merge.api.models.ticketing.CommentCreateParams
import dev.merge.api.models.ticketing.CommentListPage
import dev.merge.api.models.ticketing.CommentListParams
import dev.merge.api.models.ticketing.CommentResponse
import dev.merge.api.models.ticketing.CommentRetrieveParams
import dev.merge.api.services.blocking.ticketing.comments.MetaService

interface CommentService {

    fun meta(): MetaService

    /** Creates a `Comment` object with the given values. */
    @JvmOverloads
    fun create(
        params: CommentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CommentResponse

    /** Returns a `Comment` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CommentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Comment

    /** Returns a list of `Comment` objects. */
    @JvmOverloads
    fun list(
        params: CommentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CommentListPage
}
