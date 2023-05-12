@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Contact
import dev.merge.api.models.crm.ContactCreateParams
import dev.merge.api.models.crm.ContactIgnoreRowParams
import dev.merge.api.models.crm.ContactListPage
import dev.merge.api.models.crm.ContactListParams
import dev.merge.api.models.crm.ContactListRemoteFieldClassesPage
import dev.merge.api.models.crm.ContactListRemoteFieldClassesParams
import dev.merge.api.models.crm.ContactResponse
import dev.merge.api.models.crm.ContactRetrieveParams
import dev.merge.api.models.crm.ContactUpdateParams
import dev.merge.api.services.blocking.crm.contacts.MetaService

interface ContactService {

    fun meta(): MetaService

    /** Creates a `Contact` object with the given values. */
    @JvmOverloads
    fun create(
        params: ContactCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ContactResponse

    /** Returns a `Contact` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ContactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Contact

    /** Updates a `Contact` object with the given `id`. */
    @JvmOverloads
    fun update(
        params: ContactUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ContactResponse

    /** Returns a list of `Contact` objects. */
    @JvmOverloads
    fun list(
        params: ContactListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ContactListPage

    /**
     * Ignores a specific row based on the `model_id` in the url. These records will have their
     * properties set to null, and will not be updated in future syncs. The "reason" and "message"
     * fields in the request body will be stored for audit purposes.
     */
    @JvmOverloads
    fun ignoreRow(
        params: ContactIgnoreRowParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: ContactListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ContactListRemoteFieldClassesPage
}
