@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.Note
import dev.merge.api.models.crm.NoteCreateParams
import dev.merge.api.models.crm.NoteListPage
import dev.merge.api.models.crm.NoteListParams
import dev.merge.api.models.crm.NoteListRemoteFieldClassesPage
import dev.merge.api.models.crm.NoteListRemoteFieldClassesParams
import dev.merge.api.models.crm.NoteResponse
import dev.merge.api.models.crm.NoteRetrieveParams
import dev.merge.api.services.blocking.crm.notes.MetaService

interface NoteService {

    fun meta(): MetaService

    /** Creates a `Note` object with the given values. */
    @JvmOverloads
    fun create(
        params: NoteCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): NoteResponse

    /** Returns a `Note` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: NoteRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Note

    /** Returns a list of `Note` objects. */
    @JvmOverloads
    fun list(
        params: NoteListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): NoteListPage

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: NoteListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): NoteListRemoteFieldClassesPage
}
