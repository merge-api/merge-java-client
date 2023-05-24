package dev.merge.api.models.fileStorage

import com.fasterxml.jackson.annotation.JsonCreator
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.util.Objects
import java.util.Optional

class LinkedAccountListParams
constructor(
    private val category: Category?,
    private val cursor: String?,
    private val endUserEmailAddress: String?,
    private val endUserOrganizationName: String?,
    private val endUserOriginId: String?,
    private val endUserOriginIds: String?,
    private val id: String?,
    private val ids: String?,
    private val includeDuplicates: Boolean?,
    private val integrationName: String?,
    private val isTestAccount: String?,
    private val pageSize: Long?,
    private val status: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun category(): Optional<Category> = Optional.ofNullable(category)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun endUserEmailAddress(): Optional<String> = Optional.ofNullable(endUserEmailAddress)

    fun endUserOrganizationName(): Optional<String> = Optional.ofNullable(endUserOrganizationName)

    fun endUserOriginId(): Optional<String> = Optional.ofNullable(endUserOriginId)

    fun endUserOriginIds(): Optional<String> = Optional.ofNullable(endUserOriginIds)

    fun id(): Optional<String> = Optional.ofNullable(id)

    fun ids(): Optional<String> = Optional.ofNullable(ids)

    fun includeDuplicates(): Optional<Boolean> = Optional.ofNullable(includeDuplicates)

    fun integrationName(): Optional<String> = Optional.ofNullable(integrationName)

    fun isTestAccount(): Optional<String> = Optional.ofNullable(isTestAccount)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun status(): Optional<String> = Optional.ofNullable(status)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.category?.let { params.put("category", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.endUserEmailAddress?.let {
            params.put("end_user_email_address", listOf(it.toString()))
        }
        this.endUserOrganizationName?.let {
            params.put("end_user_organization_name", listOf(it.toString()))
        }
        this.endUserOriginId?.let { params.put("end_user_origin_id", listOf(it.toString())) }
        this.endUserOriginIds?.let { params.put("end_user_origin_ids", listOf(it.toString())) }
        this.id?.let { params.put("id", listOf(it.toString())) }
        this.ids?.let { params.put("ids", listOf(it.toString())) }
        this.includeDuplicates?.let { params.put("include_duplicates", listOf(it.toString())) }
        this.integrationName?.let { params.put("integration_name", listOf(it.toString())) }
        this.isTestAccount?.let { params.put("is_test_account", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.status?.let { params.put("status", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is LinkedAccountListParams &&
            this.category == other.category &&
            this.cursor == other.cursor &&
            this.endUserEmailAddress == other.endUserEmailAddress &&
            this.endUserOrganizationName == other.endUserOrganizationName &&
            this.endUserOriginId == other.endUserOriginId &&
            this.endUserOriginIds == other.endUserOriginIds &&
            this.id == other.id &&
            this.ids == other.ids &&
            this.includeDuplicates == other.includeDuplicates &&
            this.integrationName == other.integrationName &&
            this.isTestAccount == other.isTestAccount &&
            this.pageSize == other.pageSize &&
            this.status == other.status &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            category,
            cursor,
            endUserEmailAddress,
            endUserOrganizationName,
            endUserOriginId,
            endUserOriginIds,
            id,
            ids,
            includeDuplicates,
            integrationName,
            isTestAccount,
            pageSize,
            status,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "LinkedAccountListParams{category=$category, cursor=$cursor, endUserEmailAddress=$endUserEmailAddress, endUserOrganizationName=$endUserOrganizationName, endUserOriginId=$endUserOriginId, endUserOriginIds=$endUserOriginIds, id=$id, ids=$ids, includeDuplicates=$includeDuplicates, integrationName=$integrationName, isTestAccount=$isTestAccount, pageSize=$pageSize, status=$status, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var category: Category? = null
        private var cursor: String? = null
        private var endUserEmailAddress: String? = null
        private var endUserOrganizationName: String? = null
        private var endUserOriginId: String? = null
        private var endUserOriginIds: String? = null
        private var id: String? = null
        private var ids: String? = null
        private var includeDuplicates: Boolean? = null
        private var integrationName: String? = null
        private var isTestAccount: String? = null
        private var pageSize: Long? = null
        private var status: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(linkedAccountListParams: LinkedAccountListParams) = apply {
            this.category = linkedAccountListParams.category
            this.cursor = linkedAccountListParams.cursor
            this.endUserEmailAddress = linkedAccountListParams.endUserEmailAddress
            this.endUserOrganizationName = linkedAccountListParams.endUserOrganizationName
            this.endUserOriginId = linkedAccountListParams.endUserOriginId
            this.endUserOriginIds = linkedAccountListParams.endUserOriginIds
            this.id = linkedAccountListParams.id
            this.ids = linkedAccountListParams.ids
            this.includeDuplicates = linkedAccountListParams.includeDuplicates
            this.integrationName = linkedAccountListParams.integrationName
            this.isTestAccount = linkedAccountListParams.isTestAccount
            this.pageSize = linkedAccountListParams.pageSize
            this.status = linkedAccountListParams.status
            additionalQueryParams(linkedAccountListParams.additionalQueryParams)
            additionalHeaders(linkedAccountListParams.additionalHeaders)
        }

        /**
         * Options: ('hris', 'ats', 'accounting', 'ticketing', 'crm', 'mktg', 'filestorage')
         *
         * - `hris` - hris
         * - `ats` - ats
         * - `accounting` - accounting
         * - `ticketing` - ticketing
         * - `crm` - crm
         * - `mktg` - mktg
         * - `filestorage` - filestorage
         */
        fun category(category: Category) = apply { this.category = category }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

        /**
         * If provided, will only return linked accounts associated with the given email address.
         */
        fun endUserEmailAddress(endUserEmailAddress: String) = apply {
            this.endUserEmailAddress = endUserEmailAddress
        }

        /**
         * If provided, will only return linked accounts associated with the given organization
         * name.
         */
        fun endUserOrganizationName(endUserOrganizationName: String) = apply {
            this.endUserOrganizationName = endUserOrganizationName
        }

        /** If provided, will only return linked accounts associated with the given origin ID. */
        fun endUserOriginId(endUserOriginId: String) = apply {
            this.endUserOriginId = endUserOriginId
        }

        /**
         * Comma-separated list of EndUser origin IDs, making it possible to specify multiple
         * EndUsers at once.
         */
        fun endUserOriginIds(endUserOriginIds: String) = apply {
            this.endUserOriginIds = endUserOriginIds
        }

        fun id(id: String) = apply { this.id = id }

        /**
         * Comma-separated list of LinkedAccount IDs, making it possible to specify multiple
         * LinkedAccounts at once.
         */
        fun ids(ids: String) = apply { this.ids = ids }

        /**
         * If `true`, will include complete production duplicates of the account specified by the
         * `id` query parameter in the response. `id` must be for a complete production linked
         * account.
         */
        fun includeDuplicates(includeDuplicates: Boolean) = apply {
            this.includeDuplicates = includeDuplicates
        }

        /**
         * If provided, will only return linked accounts associated with the given integration name.
         */
        fun integrationName(integrationName: String) = apply {
            this.integrationName = integrationName
        }

        /**
         * If included, will only include test linked accounts. If not included, will only include
         * non-test linked accounts.
         */
        fun isTestAccount(isTestAccount: String) = apply { this.isTestAccount = isTestAccount }

        /** Number of results to return per page. */
        fun pageSize(pageSize: Long) = apply { this.pageSize = pageSize }

        /** Filter by status. Options: `COMPLETE`, `INCOMPLETE`, `RELINK_NEEDED` */
        fun status(status: String) = apply { this.status = status }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun build(): LinkedAccountListParams =
            LinkedAccountListParams(
                category,
                cursor,
                endUserEmailAddress,
                endUserOrganizationName,
                endUserOriginId,
                endUserOriginIds,
                id,
                ids,
                includeDuplicates,
                integrationName,
                isTestAccount,
                pageSize,
                status,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }

    class Category
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Category && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ACCOUNTING = Category(JsonField.of("accounting"))

            @JvmField val ATS = Category(JsonField.of("ats"))

            @JvmField val CRM = Category(JsonField.of("crm"))

            @JvmField val FILESTORAGE = Category(JsonField.of("filestorage"))

            @JvmField val HRIS = Category(JsonField.of("hris"))

            @JvmField val MKTG = Category(JsonField.of("mktg"))

            @JvmField val TICKETING = Category(JsonField.of("ticketing"))

            @JvmStatic fun of(value: String) = Category(JsonField.of(value))
        }

        enum class Known {
            ACCOUNTING,
            ATS,
            CRM,
            FILESTORAGE,
            HRIS,
            MKTG,
            TICKETING,
        }

        enum class Value {
            ACCOUNTING,
            ATS,
            CRM,
            FILESTORAGE,
            HRIS,
            MKTG,
            TICKETING,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ACCOUNTING -> Value.ACCOUNTING
                ATS -> Value.ATS
                CRM -> Value.CRM
                FILESTORAGE -> Value.FILESTORAGE
                HRIS -> Value.HRIS
                MKTG -> Value.MKTG
                TICKETING -> Value.TICKETING
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ACCOUNTING -> Known.ACCOUNTING
                ATS -> Known.ATS
                CRM -> Known.CRM
                FILESTORAGE -> Known.FILESTORAGE
                HRIS -> Known.HRIS
                MKTG -> Known.MKTG
                TICKETING -> Known.TICKETING
                else -> throw MergeInvalidDataException("Unknown Category: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
