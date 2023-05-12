@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.AvailableAction
import dev.merge.api.models.accounting.AvailableActionRetrieveParams

interface AvailableActionService {

    /** Returns a list of models and actions available for an account. */
    @JvmOverloads
    fun retrieve(
        params: AvailableActionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AvailableAction
}
