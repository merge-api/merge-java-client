@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Candidate
import dev.merge.api.models.ats.CandidateCreateParams
import dev.merge.api.models.ats.CandidateIgnoreRowParams
import dev.merge.api.models.ats.CandidateListPageAsync
import dev.merge.api.models.ats.CandidateListParams
import dev.merge.api.models.ats.CandidateResponse
import dev.merge.api.models.ats.CandidateRetrieveParams
import dev.merge.api.services.async.ats.candidates.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface CandidateServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `Candidate` object with the given values. */
    @JvmOverloads
    fun create(
        params: CandidateCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CandidateResponse>

    /** Returns a `Candidate` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CandidateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Candidate>

    /** Returns a list of `Candidate` objects. */
    @JvmOverloads
    fun list(
        params: CandidateListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CandidateListPageAsync>

    /**
     * Ignores a specific row based on the `model_id` in the url. These records will have their
     * properties set to null, and will not be updated in future syncs. The "reason" and "message"
     * fields in the request body will be stored for audit purposes.
     */
    @JvmOverloads
    fun ignoreRow(
        params: CandidateIgnoreRowParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Void>
}
