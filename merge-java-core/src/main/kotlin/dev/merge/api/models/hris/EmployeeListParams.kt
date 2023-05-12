package dev.merge.api.models.hris

import com.fasterxml.jackson.annotation.JsonCreator
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

class EmployeeListParams
constructor(
    private val companyId: String?,
    private val createdAfter: OffsetDateTime?,
    private val createdBefore: OffsetDateTime?,
    private val cursor: String?,
    private val displayFullName: String?,
    private val employmentStatus: EmploymentStatus?,
    private val expand: List<Expand>?,
    private val firstName: String?,
    private val groups: String?,
    private val includeDeletedData: Boolean?,
    private val includeRemoteData: Boolean?,
    private val includeSensitiveFields: Boolean?,
    private val lastName: String?,
    private val managerId: String?,
    private val modifiedAfter: OffsetDateTime?,
    private val modifiedBefore: OffsetDateTime?,
    private val pageSize: Long?,
    private val payGroupId: String?,
    private val personalEmail: String?,
    private val remoteFields: RemoteFields?,
    private val remoteId: String?,
    private val showEnumOrigins: ShowEnumOrigins?,
    private val startedAfter: OffsetDateTime?,
    private val startedBefore: OffsetDateTime?,
    private val teamId: String?,
    private val terminatedAfter: OffsetDateTime?,
    private val terminatedBefore: OffsetDateTime?,
    private val workEmail: String?,
    private val workLocationId: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun companyId(): Optional<String> = Optional.ofNullable(companyId)

    fun createdAfter(): Optional<OffsetDateTime> = Optional.ofNullable(createdAfter)

    fun createdBefore(): Optional<OffsetDateTime> = Optional.ofNullable(createdBefore)

    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    fun displayFullName(): Optional<String> = Optional.ofNullable(displayFullName)

    fun employmentStatus(): Optional<EmploymentStatus> = Optional.ofNullable(employmentStatus)

    fun expand(): Optional<List<Expand>> = Optional.ofNullable(expand)

    fun firstName(): Optional<String> = Optional.ofNullable(firstName)

    fun groups(): Optional<String> = Optional.ofNullable(groups)

    fun includeDeletedData(): Optional<Boolean> = Optional.ofNullable(includeDeletedData)

    fun includeRemoteData(): Optional<Boolean> = Optional.ofNullable(includeRemoteData)

    fun includeSensitiveFields(): Optional<Boolean> = Optional.ofNullable(includeSensitiveFields)

    fun lastName(): Optional<String> = Optional.ofNullable(lastName)

    fun managerId(): Optional<String> = Optional.ofNullable(managerId)

    fun modifiedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedAfter)

    fun modifiedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(modifiedBefore)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    fun payGroupId(): Optional<String> = Optional.ofNullable(payGroupId)

    fun personalEmail(): Optional<String> = Optional.ofNullable(personalEmail)

    fun remoteFields(): Optional<RemoteFields> = Optional.ofNullable(remoteFields)

    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId)

    fun showEnumOrigins(): Optional<ShowEnumOrigins> = Optional.ofNullable(showEnumOrigins)

    fun startedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(startedAfter)

    fun startedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(startedBefore)

    fun teamId(): Optional<String> = Optional.ofNullable(teamId)

    fun terminatedAfter(): Optional<OffsetDateTime> = Optional.ofNullable(terminatedAfter)

    fun terminatedBefore(): Optional<OffsetDateTime> = Optional.ofNullable(terminatedBefore)

    fun workEmail(): Optional<String> = Optional.ofNullable(workEmail)

    fun workLocationId(): Optional<String> = Optional.ofNullable(workLocationId)

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.companyId?.let { params.put("company_id", listOf(it.toString())) }
        this.createdAfter?.let { params.put("created_after", listOf(it.toString())) }
        this.createdBefore?.let { params.put("created_before", listOf(it.toString())) }
        this.cursor?.let { params.put("cursor", listOf(it.toString())) }
        this.displayFullName?.let { params.put("display_full_name", listOf(it.toString())) }
        this.employmentStatus?.let { params.put("employment_status", listOf(it.toString())) }
        this.expand?.let { params.put("expand", listOf(it.joinToString(separator = ","))) }
        this.firstName?.let { params.put("first_name", listOf(it.toString())) }
        this.groups?.let { params.put("groups", listOf(it.toString())) }
        this.includeDeletedData?.let { params.put("include_deleted_data", listOf(it.toString())) }
        this.includeRemoteData?.let { params.put("include_remote_data", listOf(it.toString())) }
        this.includeSensitiveFields?.let {
            params.put("include_sensitive_fields", listOf(it.toString()))
        }
        this.lastName?.let { params.put("last_name", listOf(it.toString())) }
        this.managerId?.let { params.put("manager_id", listOf(it.toString())) }
        this.modifiedAfter?.let { params.put("modified_after", listOf(it.toString())) }
        this.modifiedBefore?.let { params.put("modified_before", listOf(it.toString())) }
        this.pageSize?.let { params.put("page_size", listOf(it.toString())) }
        this.payGroupId?.let { params.put("pay_group_id", listOf(it.toString())) }
        this.personalEmail?.let { params.put("personal_email", listOf(it.toString())) }
        this.remoteFields?.let { params.put("remote_fields", listOf(it.toString())) }
        this.remoteId?.let { params.put("remote_id", listOf(it.toString())) }
        this.showEnumOrigins?.let { params.put("show_enum_origins", listOf(it.toString())) }
        this.startedAfter?.let { params.put("started_after", listOf(it.toString())) }
        this.startedBefore?.let { params.put("started_before", listOf(it.toString())) }
        this.teamId?.let { params.put("team_id", listOf(it.toString())) }
        this.terminatedAfter?.let { params.put("terminated_after", listOf(it.toString())) }
        this.terminatedBefore?.let { params.put("terminated_before", listOf(it.toString())) }
        this.workEmail?.let { params.put("work_email", listOf(it.toString())) }
        this.workLocationId?.let { params.put("work_location_id", listOf(it.toString())) }
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

        return other is EmployeeListParams &&
            this.companyId == other.companyId &&
            this.createdAfter == other.createdAfter &&
            this.createdBefore == other.createdBefore &&
            this.cursor == other.cursor &&
            this.displayFullName == other.displayFullName &&
            this.employmentStatus == other.employmentStatus &&
            this.expand == other.expand &&
            this.firstName == other.firstName &&
            this.groups == other.groups &&
            this.includeDeletedData == other.includeDeletedData &&
            this.includeRemoteData == other.includeRemoteData &&
            this.includeSensitiveFields == other.includeSensitiveFields &&
            this.lastName == other.lastName &&
            this.managerId == other.managerId &&
            this.modifiedAfter == other.modifiedAfter &&
            this.modifiedBefore == other.modifiedBefore &&
            this.pageSize == other.pageSize &&
            this.payGroupId == other.payGroupId &&
            this.personalEmail == other.personalEmail &&
            this.remoteFields == other.remoteFields &&
            this.remoteId == other.remoteId &&
            this.showEnumOrigins == other.showEnumOrigins &&
            this.startedAfter == other.startedAfter &&
            this.startedBefore == other.startedBefore &&
            this.teamId == other.teamId &&
            this.terminatedAfter == other.terminatedAfter &&
            this.terminatedBefore == other.terminatedBefore &&
            this.workEmail == other.workEmail &&
            this.workLocationId == other.workLocationId &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            companyId,
            createdAfter,
            createdBefore,
            cursor,
            displayFullName,
            employmentStatus,
            expand,
            firstName,
            groups,
            includeDeletedData,
            includeRemoteData,
            includeSensitiveFields,
            lastName,
            managerId,
            modifiedAfter,
            modifiedBefore,
            pageSize,
            payGroupId,
            personalEmail,
            remoteFields,
            remoteId,
            showEnumOrigins,
            startedAfter,
            startedBefore,
            teamId,
            terminatedAfter,
            terminatedBefore,
            workEmail,
            workLocationId,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "EmployeeListParams{companyId=$companyId, createdAfter=$createdAfter, createdBefore=$createdBefore, cursor=$cursor, displayFullName=$displayFullName, employmentStatus=$employmentStatus, expand=$expand, firstName=$firstName, groups=$groups, includeDeletedData=$includeDeletedData, includeRemoteData=$includeRemoteData, includeSensitiveFields=$includeSensitiveFields, lastName=$lastName, managerId=$managerId, modifiedAfter=$modifiedAfter, modifiedBefore=$modifiedBefore, pageSize=$pageSize, payGroupId=$payGroupId, personalEmail=$personalEmail, remoteFields=$remoteFields, remoteId=$remoteId, showEnumOrigins=$showEnumOrigins, startedAfter=$startedAfter, startedBefore=$startedBefore, teamId=$teamId, terminatedAfter=$terminatedAfter, terminatedBefore=$terminatedBefore, workEmail=$workEmail, workLocationId=$workLocationId, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var companyId: String? = null
        private var createdAfter: OffsetDateTime? = null
        private var createdBefore: OffsetDateTime? = null
        private var cursor: String? = null
        private var displayFullName: String? = null
        private var employmentStatus: EmploymentStatus? = null
        private var expand: List<Expand>? = null
        private var firstName: String? = null
        private var groups: String? = null
        private var includeDeletedData: Boolean? = null
        private var includeRemoteData: Boolean? = null
        private var includeSensitiveFields: Boolean? = null
        private var lastName: String? = null
        private var managerId: String? = null
        private var modifiedAfter: OffsetDateTime? = null
        private var modifiedBefore: OffsetDateTime? = null
        private var pageSize: Long? = null
        private var payGroupId: String? = null
        private var personalEmail: String? = null
        private var remoteFields: RemoteFields? = null
        private var remoteId: String? = null
        private var showEnumOrigins: ShowEnumOrigins? = null
        private var startedAfter: OffsetDateTime? = null
        private var startedBefore: OffsetDateTime? = null
        private var teamId: String? = null
        private var terminatedAfter: OffsetDateTime? = null
        private var terminatedBefore: OffsetDateTime? = null
        private var workEmail: String? = null
        private var workLocationId: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(employeeListParams: EmployeeListParams) = apply {
            this.companyId = employeeListParams.companyId
            this.createdAfter = employeeListParams.createdAfter
            this.createdBefore = employeeListParams.createdBefore
            this.cursor = employeeListParams.cursor
            this.displayFullName = employeeListParams.displayFullName
            this.employmentStatus = employeeListParams.employmentStatus
            this.expand = employeeListParams.expand
            this.firstName = employeeListParams.firstName
            this.groups = employeeListParams.groups
            this.includeDeletedData = employeeListParams.includeDeletedData
            this.includeRemoteData = employeeListParams.includeRemoteData
            this.includeSensitiveFields = employeeListParams.includeSensitiveFields
            this.lastName = employeeListParams.lastName
            this.managerId = employeeListParams.managerId
            this.modifiedAfter = employeeListParams.modifiedAfter
            this.modifiedBefore = employeeListParams.modifiedBefore
            this.pageSize = employeeListParams.pageSize
            this.payGroupId = employeeListParams.payGroupId
            this.personalEmail = employeeListParams.personalEmail
            this.remoteFields = employeeListParams.remoteFields
            this.remoteId = employeeListParams.remoteId
            this.showEnumOrigins = employeeListParams.showEnumOrigins
            this.startedAfter = employeeListParams.startedAfter
            this.startedBefore = employeeListParams.startedBefore
            this.teamId = employeeListParams.teamId
            this.terminatedAfter = employeeListParams.terminatedAfter
            this.terminatedBefore = employeeListParams.terminatedBefore
            this.workEmail = employeeListParams.workEmail
            this.workLocationId = employeeListParams.workLocationId
            additionalQueryParams(employeeListParams.additionalQueryParams)
            additionalHeaders(employeeListParams.additionalHeaders)
        }

        /** If provided, will only return employees for this company. */
        fun companyId(companyId: String) = apply { this.companyId = companyId }

        /** If provided, will only return objects created after this datetime. */
        fun createdAfter(createdAfter: OffsetDateTime) = apply { this.createdAfter = createdAfter }

        /** If provided, will only return objects created before this datetime. */
        fun createdBefore(createdBefore: OffsetDateTime) = apply {
            this.createdBefore = createdBefore
        }

        /** The pagination cursor value. */
        fun cursor(cursor: String) = apply { this.cursor = cursor }

        /** If provided, will only return employees with this display name. */
        fun displayFullName(displayFullName: String) = apply {
            this.displayFullName = displayFullName
        }

        /**
         * If provided, will only return employees with this employment status.
         *
         * - `ACTIVE` - ACTIVE
         * - `PENDING` - PENDING
         * - `INACTIVE` - INACTIVE
         */
        fun employmentStatus(employmentStatus: EmploymentStatus) = apply {
            this.employmentStatus = employmentStatus
        }

        /**
         * Which relations should be returned in expanded form. Multiple relation names should be
         * comma separated without spaces.
         */
        fun expand(expand: List<Expand>) = apply { this.expand = expand }

        /** If provided, will only return employees with this first name. */
        fun firstName(firstName: String) = apply { this.firstName = firstName }

        /**
         * If provided, will only return employees matching the group ids; multiple groups can be
         * separated by commas.
         */
        fun groups(groups: String) = apply { this.groups = groups }

        /** Whether to include data that was marked as deleted by third party webhooks. */
        fun includeDeletedData(includeDeletedData: Boolean) = apply {
            this.includeDeletedData = includeDeletedData
        }

        /**
         * Whether to include the original data Merge fetched from the third-party to produce these
         * models.
         */
        fun includeRemoteData(includeRemoteData: Boolean) = apply {
            this.includeRemoteData = includeRemoteData
        }

        /**
         * Whether to include sensitive fields (such as social security numbers) in the response.
         */
        fun includeSensitiveFields(includeSensitiveFields: Boolean) = apply {
            this.includeSensitiveFields = includeSensitiveFields
        }

        /** If provided, will only return employees with this last name. */
        fun lastName(lastName: String) = apply { this.lastName = lastName }

        /** If provided, will only return employees for this manager. */
        fun managerId(managerId: String) = apply { this.managerId = managerId }

        /** If provided, only objects synced by Merge after this date time will be returned. */
        fun modifiedAfter(modifiedAfter: OffsetDateTime) = apply {
            this.modifiedAfter = modifiedAfter
        }

        /** If provided, only objects synced by Merge before this date time will be returned. */
        fun modifiedBefore(modifiedBefore: OffsetDateTime) = apply {
            this.modifiedBefore = modifiedBefore
        }

        /** Number of results to return per page. */
        fun pageSize(pageSize: Long) = apply { this.pageSize = pageSize }

        /** If provided, will only return employees for this pay group */
        fun payGroupId(payGroupId: String) = apply { this.payGroupId = payGroupId }

        /** If provided, will only return Employees with this personal email */
        fun personalEmail(personalEmail: String) = apply { this.personalEmail = personalEmail }

        /** Deprecated. Use show_enum_origins. */
        fun remoteFields(remoteFields: RemoteFields) = apply { this.remoteFields = remoteFields }

        /** The API provider's ID for the given object. */
        fun remoteId(remoteId: String) = apply { this.remoteId = remoteId }

        /** Which fields should be returned in non-normalized form. */
        fun showEnumOrigins(showEnumOrigins: ShowEnumOrigins) = apply {
            this.showEnumOrigins = showEnumOrigins
        }

        /** If provided, will only return employees that started after this datetime. */
        fun startedAfter(startedAfter: OffsetDateTime) = apply { this.startedAfter = startedAfter }

        /** If provided, will only return employees that started before this datetime. */
        fun startedBefore(startedBefore: OffsetDateTime) = apply {
            this.startedBefore = startedBefore
        }

        /** If provided, will only return employees for this team. */
        fun teamId(teamId: String) = apply { this.teamId = teamId }

        /** If provided, will only return employees that were terminated after this datetime. */
        fun terminatedAfter(terminatedAfter: OffsetDateTime) = apply {
            this.terminatedAfter = terminatedAfter
        }

        /** If provided, will only return employees that were terminated before this datetime. */
        fun terminatedBefore(terminatedBefore: OffsetDateTime) = apply {
            this.terminatedBefore = terminatedBefore
        }

        /** If provided, will only return Employees with this work email */
        fun workEmail(workEmail: String) = apply { this.workEmail = workEmail }

        /** If provided, will only return employees for this location. */
        fun workLocationId(workLocationId: String) = apply { this.workLocationId = workLocationId }

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

        fun build(): EmployeeListParams =
            EmployeeListParams(
                companyId,
                createdAfter,
                createdBefore,
                cursor,
                displayFullName,
                employmentStatus,
                expand?.toUnmodifiable(),
                firstName,
                groups,
                includeDeletedData,
                includeRemoteData,
                includeSensitiveFields,
                lastName,
                managerId,
                modifiedAfter,
                modifiedBefore,
                pageSize,
                payGroupId,
                personalEmail,
                remoteFields,
                remoteId,
                showEnumOrigins,
                startedAfter,
                startedBefore,
                teamId,
                terminatedAfter,
                terminatedBefore,
                workEmail,
                workLocationId,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }

    class EmploymentStatus
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EmploymentStatus && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ACTIVE = EmploymentStatus(JsonField.of("ACTIVE"))

            @JvmField val INACTIVE = EmploymentStatus(JsonField.of("INACTIVE"))

            @JvmField val PENDING = EmploymentStatus(JsonField.of("PENDING"))

            @JvmStatic fun of(value: String) = EmploymentStatus(JsonField.of(value))
        }

        enum class Known {
            ACTIVE,
            INACTIVE,
            PENDING,
        }

        enum class Value {
            ACTIVE,
            INACTIVE,
            PENDING,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ACTIVE -> Value.ACTIVE
                INACTIVE -> Value.INACTIVE
                PENDING -> Value.PENDING
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ACTIVE -> Known.ACTIVE
                INACTIVE -> Known.INACTIVE
                PENDING -> Known.PENDING
                else -> throw MergeInvalidDataException("Unknown EmploymentStatus: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Expand
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Expand && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val COMPANY = Expand(JsonField.of("company"))

            @JvmField val EMPLOYMENTS = Expand(JsonField.of("employments"))

            @JvmField val GROUPS = Expand(JsonField.of("groups"))

            @JvmField val HOME_LOCATION = Expand(JsonField.of("home_location"))

            @JvmField val MANAGER = Expand(JsonField.of("manager"))

            @JvmField val PAY_GROUP = Expand(JsonField.of("pay_group"))

            @JvmField val TEAM = Expand(JsonField.of("team"))

            @JvmField val WORK_LOCATION = Expand(JsonField.of("work_location"))

            @JvmStatic fun of(value: String) = Expand(JsonField.of(value))
        }

        enum class Known {
            COMPANY,
            EMPLOYMENTS,
            GROUPS,
            HOME_LOCATION,
            MANAGER,
            PAY_GROUP,
            TEAM,
            WORK_LOCATION,
        }

        enum class Value {
            COMPANY,
            EMPLOYMENTS,
            GROUPS,
            HOME_LOCATION,
            MANAGER,
            PAY_GROUP,
            TEAM,
            WORK_LOCATION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                COMPANY -> Value.COMPANY
                EMPLOYMENTS -> Value.EMPLOYMENTS
                GROUPS -> Value.GROUPS
                HOME_LOCATION -> Value.HOME_LOCATION
                MANAGER -> Value.MANAGER
                PAY_GROUP -> Value.PAY_GROUP
                TEAM -> Value.TEAM
                WORK_LOCATION -> Value.WORK_LOCATION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                COMPANY -> Known.COMPANY
                EMPLOYMENTS -> Known.EMPLOYMENTS
                GROUPS -> Known.GROUPS
                HOME_LOCATION -> Known.HOME_LOCATION
                MANAGER -> Known.MANAGER
                PAY_GROUP -> Known.PAY_GROUP
                TEAM -> Known.TEAM
                WORK_LOCATION -> Known.WORK_LOCATION
                else -> throw MergeInvalidDataException("Unknown Expand: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class RemoteFields
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RemoteFields && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val EMPLOYMENT_STATUS = RemoteFields(JsonField.of("employment_status"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY =
                RemoteFields(JsonField.of("employment_status,ethnicity"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_GENDER =
                RemoteFields(JsonField.of("employment_status,ethnicity,gender"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS =
                RemoteFields(JsonField.of("employment_status,ethnicity,gender,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS =
                RemoteFields(JsonField.of("employment_status,ethnicity,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_GENDER = RemoteFields(JsonField.of("employment_status,gender"))

            @JvmField
            val EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS =
                RemoteFields(JsonField.of("employment_status,gender,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_MARITAL_STATUS =
                RemoteFields(JsonField.of("employment_status,marital_status"))

            @JvmField val ETHNICITY = RemoteFields(JsonField.of("ethnicity"))

            @JvmField val ETHNICITY_GENDER = RemoteFields(JsonField.of("ethnicity,gender"))

            @JvmField
            val ETHNICITY_GENDER_MARITAL_STATUS =
                RemoteFields(JsonField.of("ethnicity,gender,marital_status"))

            @JvmField
            val ETHNICITY_MARITAL_STATUS = RemoteFields(JsonField.of("ethnicity,marital_status"))

            @JvmField val GENDER = RemoteFields(JsonField.of("gender"))

            @JvmField
            val GENDER_MARITAL_STATUS = RemoteFields(JsonField.of("gender,marital_status"))

            @JvmField val MARITAL_STATUS = RemoteFields(JsonField.of("marital_status"))

            @JvmStatic fun of(value: String) = RemoteFields(JsonField.of(value))
        }

        enum class Known {
            EMPLOYMENT_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS,
            EMPLOYMENT_STATUS_GENDER,
            EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_MARITAL_STATUS,
            ETHNICITY,
            ETHNICITY_GENDER,
            ETHNICITY_GENDER_MARITAL_STATUS,
            ETHNICITY_MARITAL_STATUS,
            GENDER,
            GENDER_MARITAL_STATUS,
            MARITAL_STATUS,
        }

        enum class Value {
            EMPLOYMENT_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS,
            EMPLOYMENT_STATUS_GENDER,
            EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_MARITAL_STATUS,
            ETHNICITY,
            ETHNICITY_GENDER,
            ETHNICITY_GENDER_MARITAL_STATUS,
            ETHNICITY_MARITAL_STATUS,
            GENDER,
            GENDER_MARITAL_STATUS,
            MARITAL_STATUS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMPLOYMENT_STATUS -> Value.EMPLOYMENT_STATUS
                EMPLOYMENT_STATUS_ETHNICITY -> Value.EMPLOYMENT_STATUS_ETHNICITY
                EMPLOYMENT_STATUS_ETHNICITY_GENDER -> Value.EMPLOYMENT_STATUS_ETHNICITY_GENDER
                EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS
                EMPLOYMENT_STATUS_GENDER -> Value.EMPLOYMENT_STATUS_GENDER
                EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_MARITAL_STATUS -> Value.EMPLOYMENT_STATUS_MARITAL_STATUS
                ETHNICITY -> Value.ETHNICITY
                ETHNICITY_GENDER -> Value.ETHNICITY_GENDER
                ETHNICITY_GENDER_MARITAL_STATUS -> Value.ETHNICITY_GENDER_MARITAL_STATUS
                ETHNICITY_MARITAL_STATUS -> Value.ETHNICITY_MARITAL_STATUS
                GENDER -> Value.GENDER
                GENDER_MARITAL_STATUS -> Value.GENDER_MARITAL_STATUS
                MARITAL_STATUS -> Value.MARITAL_STATUS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMPLOYMENT_STATUS -> Known.EMPLOYMENT_STATUS
                EMPLOYMENT_STATUS_ETHNICITY -> Known.EMPLOYMENT_STATUS_ETHNICITY
                EMPLOYMENT_STATUS_ETHNICITY_GENDER -> Known.EMPLOYMENT_STATUS_ETHNICITY_GENDER
                EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS
                EMPLOYMENT_STATUS_GENDER -> Known.EMPLOYMENT_STATUS_GENDER
                EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_MARITAL_STATUS -> Known.EMPLOYMENT_STATUS_MARITAL_STATUS
                ETHNICITY -> Known.ETHNICITY
                ETHNICITY_GENDER -> Known.ETHNICITY_GENDER
                ETHNICITY_GENDER_MARITAL_STATUS -> Known.ETHNICITY_GENDER_MARITAL_STATUS
                ETHNICITY_MARITAL_STATUS -> Known.ETHNICITY_MARITAL_STATUS
                GENDER -> Known.GENDER
                GENDER_MARITAL_STATUS -> Known.GENDER_MARITAL_STATUS
                MARITAL_STATUS -> Known.MARITAL_STATUS
                else -> throw MergeInvalidDataException("Unknown RemoteFields: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class ShowEnumOrigins
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ShowEnumOrigins && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val EMPLOYMENT_STATUS = ShowEnumOrigins(JsonField.of("employment_status"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY =
                ShowEnumOrigins(JsonField.of("employment_status,ethnicity"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_GENDER =
                ShowEnumOrigins(JsonField.of("employment_status,ethnicity,gender"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS =
                ShowEnumOrigins(JsonField.of("employment_status,ethnicity,gender,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS =
                ShowEnumOrigins(JsonField.of("employment_status,ethnicity,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_GENDER = ShowEnumOrigins(JsonField.of("employment_status,gender"))

            @JvmField
            val EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS =
                ShowEnumOrigins(JsonField.of("employment_status,gender,marital_status"))

            @JvmField
            val EMPLOYMENT_STATUS_MARITAL_STATUS =
                ShowEnumOrigins(JsonField.of("employment_status,marital_status"))

            @JvmField val ETHNICITY = ShowEnumOrigins(JsonField.of("ethnicity"))

            @JvmField val ETHNICITY_GENDER = ShowEnumOrigins(JsonField.of("ethnicity,gender"))

            @JvmField
            val ETHNICITY_GENDER_MARITAL_STATUS =
                ShowEnumOrigins(JsonField.of("ethnicity,gender,marital_status"))

            @JvmField
            val ETHNICITY_MARITAL_STATUS = ShowEnumOrigins(JsonField.of("ethnicity,marital_status"))

            @JvmField val GENDER = ShowEnumOrigins(JsonField.of("gender"))

            @JvmField
            val GENDER_MARITAL_STATUS = ShowEnumOrigins(JsonField.of("gender,marital_status"))

            @JvmField val MARITAL_STATUS = ShowEnumOrigins(JsonField.of("marital_status"))

            @JvmStatic fun of(value: String) = ShowEnumOrigins(JsonField.of(value))
        }

        enum class Known {
            EMPLOYMENT_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS,
            EMPLOYMENT_STATUS_GENDER,
            EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_MARITAL_STATUS,
            ETHNICITY,
            ETHNICITY_GENDER,
            ETHNICITY_GENDER_MARITAL_STATUS,
            ETHNICITY_MARITAL_STATUS,
            GENDER,
            GENDER_MARITAL_STATUS,
            MARITAL_STATUS,
        }

        enum class Value {
            EMPLOYMENT_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER,
            EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS,
            EMPLOYMENT_STATUS_GENDER,
            EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS,
            EMPLOYMENT_STATUS_MARITAL_STATUS,
            ETHNICITY,
            ETHNICITY_GENDER,
            ETHNICITY_GENDER_MARITAL_STATUS,
            ETHNICITY_MARITAL_STATUS,
            GENDER,
            GENDER_MARITAL_STATUS,
            MARITAL_STATUS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMPLOYMENT_STATUS -> Value.EMPLOYMENT_STATUS
                EMPLOYMENT_STATUS_ETHNICITY -> Value.EMPLOYMENT_STATUS_ETHNICITY
                EMPLOYMENT_STATUS_ETHNICITY_GENDER -> Value.EMPLOYMENT_STATUS_ETHNICITY_GENDER
                EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS
                EMPLOYMENT_STATUS_GENDER -> Value.EMPLOYMENT_STATUS_GENDER
                EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS ->
                    Value.EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_MARITAL_STATUS -> Value.EMPLOYMENT_STATUS_MARITAL_STATUS
                ETHNICITY -> Value.ETHNICITY
                ETHNICITY_GENDER -> Value.ETHNICITY_GENDER
                ETHNICITY_GENDER_MARITAL_STATUS -> Value.ETHNICITY_GENDER_MARITAL_STATUS
                ETHNICITY_MARITAL_STATUS -> Value.ETHNICITY_MARITAL_STATUS
                GENDER -> Value.GENDER
                GENDER_MARITAL_STATUS -> Value.GENDER_MARITAL_STATUS
                MARITAL_STATUS -> Value.MARITAL_STATUS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMPLOYMENT_STATUS -> Known.EMPLOYMENT_STATUS
                EMPLOYMENT_STATUS_ETHNICITY -> Known.EMPLOYMENT_STATUS_ETHNICITY
                EMPLOYMENT_STATUS_ETHNICITY_GENDER -> Known.EMPLOYMENT_STATUS_ETHNICITY_GENDER
                EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_ETHNICITY_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_ETHNICITY_MARITAL_STATUS
                EMPLOYMENT_STATUS_GENDER -> Known.EMPLOYMENT_STATUS_GENDER
                EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS ->
                    Known.EMPLOYMENT_STATUS_GENDER_MARITAL_STATUS
                EMPLOYMENT_STATUS_MARITAL_STATUS -> Known.EMPLOYMENT_STATUS_MARITAL_STATUS
                ETHNICITY -> Known.ETHNICITY
                ETHNICITY_GENDER -> Known.ETHNICITY_GENDER
                ETHNICITY_GENDER_MARITAL_STATUS -> Known.ETHNICITY_GENDER_MARITAL_STATUS
                ETHNICITY_MARITAL_STATUS -> Known.ETHNICITY_MARITAL_STATUS
                GENDER -> Known.GENDER
                GENDER_MARITAL_STATUS -> Known.GENDER_MARITAL_STATUS
                MARITAL_STATUS -> Known.MARITAL_STATUS
                else -> throw MergeInvalidDataException("Unknown ShowEnumOrigins: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
