package dev.merge.api.models.accounting

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

/**
 * # The TrackingCategory Object
 *
 * ### Description
 *
 * The `TrackingCategory` object is used to represent a company's tracking categories.
 *
 * ### Usage Example
 *
 * Fetch from the `GET TrackingCategory` endpoint and view a company's tracking category.
 */
@JsonDeserialize(builder = TrackingCategory.Builder::class)
@NoAutoDetect
class TrackingCategory
private constructor(
    private val name: JsonField<String>,
    private val status: JsonField<Status7d1Enum>,
    private val categoryType: JsonField<CategoryTypeEnum>,
    private val parentCategory: JsonField<String>,
    private val company: JsonField<String>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The tracking category's name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /**
     * - `ACTIVE` - ACTIVE
     * - `ARCHIVED` - ARCHIVED
     */
    fun status(): Optional<Status7d1Enum> = Optional.ofNullable(status.getNullable("status"))

    /**
     * - `CLASS` - CLASS
     * - `DEPARTMENT` - DEPARTMENT
     */
    fun categoryType(): Optional<CategoryTypeEnum> =
        Optional.ofNullable(categoryType.getNullable("category_type"))

    /** ID of the parent tracking category. */
    fun parentCategory(): Optional<String> =
        Optional.ofNullable(parentCategory.getNullable("parent_category"))

    /** The company the tracking category belongs to. */
    fun company(): Optional<String> = Optional.ofNullable(company.getNullable("company"))

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    fun remoteWasDeleted(): Optional<Boolean> =
        Optional.ofNullable(remoteWasDeleted.getNullable("remote_was_deleted"))

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<RemoteData>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    /** The tracking category's name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /**
     * - `ACTIVE` - ACTIVE
     * - `ARCHIVED` - ARCHIVED
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /**
     * - `CLASS` - CLASS
     * - `DEPARTMENT` - DEPARTMENT
     */
    @JsonProperty("category_type") @ExcludeMissing fun _categoryType() = categoryType

    /** ID of the parent tracking category. */
    @JsonProperty("parent_category") @ExcludeMissing fun _parentCategory() = parentCategory

    /** The company the tracking category belongs to. */
    @JsonProperty("company") @ExcludeMissing fun _company() = company

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): TrackingCategory = apply {
        if (!validated) {
            name()
            status()
            categoryType()
            parentCategory()
            company()
            remoteWasDeleted()
            id()
            remoteId()
            modifiedAt()
            remoteData().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TrackingCategory &&
            this.name == other.name &&
            this.status == other.status &&
            this.categoryType == other.categoryType &&
            this.parentCategory == other.parentCategory &&
            this.company == other.company &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    name,
                    status,
                    categoryType,
                    parentCategory,
                    company,
                    remoteWasDeleted,
                    id,
                    remoteId,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "TrackingCategory{name=$name, status=$status, categoryType=$categoryType, parentCategory=$parentCategory, company=$company, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status7d1Enum> = JsonMissing.of()
        private var categoryType: JsonField<CategoryTypeEnum> = JsonMissing.of()
        private var parentCategory: JsonField<String> = JsonMissing.of()
        private var company: JsonField<String> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(trackingCategory: TrackingCategory) = apply {
            this.name = trackingCategory.name
            this.status = trackingCategory.status
            this.categoryType = trackingCategory.categoryType
            this.parentCategory = trackingCategory.parentCategory
            this.company = trackingCategory.company
            this.remoteWasDeleted = trackingCategory.remoteWasDeleted
            this.id = trackingCategory.id
            this.remoteId = trackingCategory.remoteId
            this.fieldMappings = trackingCategory.fieldMappings
            this.modifiedAt = trackingCategory.modifiedAt
            this.remoteData = trackingCategory.remoteData
            additionalProperties(trackingCategory.additionalProperties)
        }

        /** The tracking category's name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The tracking category's name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * - `ACTIVE` - ACTIVE
         * - `ARCHIVED` - ARCHIVED
         */
        fun status(status: Status7d1Enum) = status(JsonField.of(status))

        /**
         * - `ACTIVE` - ACTIVE
         * - `ARCHIVED` - ARCHIVED
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status7d1Enum>) = apply { this.status = status }

        /**
         * - `CLASS` - CLASS
         * - `DEPARTMENT` - DEPARTMENT
         */
        fun categoryType(categoryType: CategoryTypeEnum) = categoryType(JsonField.of(categoryType))

        /**
         * - `CLASS` - CLASS
         * - `DEPARTMENT` - DEPARTMENT
         */
        @JsonProperty("category_type")
        @ExcludeMissing
        fun categoryType(categoryType: JsonField<CategoryTypeEnum>) = apply {
            this.categoryType = categoryType
        }

        /** ID of the parent tracking category. */
        fun parentCategory(parentCategory: String) = parentCategory(JsonField.of(parentCategory))

        /** ID of the parent tracking category. */
        @JsonProperty("parent_category")
        @ExcludeMissing
        fun parentCategory(parentCategory: JsonField<String>) = apply {
            this.parentCategory = parentCategory
        }

        /** The company the tracking category belongs to. */
        fun company(company: String) = company(JsonField.of(company))

        /** The company the tracking category belongs to. */
        @JsonProperty("company")
        @ExcludeMissing
        fun company(company: JsonField<String>) = apply { this.company = company }

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        @JsonProperty("remote_was_deleted")
        @ExcludeMissing
        fun remoteWasDeleted(remoteWasDeleted: JsonField<Boolean>) = apply {
            this.remoteWasDeleted = remoteWasDeleted
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        @JsonProperty("field_mappings")
        @ExcludeMissing
        fun fieldMappings(fieldMappings: JsonValue) = apply { this.fieldMappings = fieldMappings }

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at")
        @ExcludeMissing
        fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
            this.modifiedAt = modifiedAt
        }

        fun remoteData(remoteData: List<RemoteData>) = remoteData(JsonField.of(remoteData))

        @JsonProperty("remote_data")
        @ExcludeMissing
        fun remoteData(remoteData: JsonField<List<RemoteData>>) = apply {
            this.remoteData = remoteData
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): TrackingCategory =
            TrackingCategory(
                name,
                status,
                categoryType,
                parentCategory,
                company,
                remoteWasDeleted,
                id,
                remoteId,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class Status7d1Enum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status7d1Enum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ACTIVE = Status7d1Enum(JsonField.of("ACTIVE"))

            @JvmField val ARCHIVED = Status7d1Enum(JsonField.of("ARCHIVED"))

            @JvmStatic fun of(value: String) = Status7d1Enum(JsonField.of(value))
        }

        enum class Known {
            ACTIVE,
            ARCHIVED,
        }

        enum class Value {
            ACTIVE,
            ARCHIVED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ACTIVE -> Value.ACTIVE
                ARCHIVED -> Value.ARCHIVED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ACTIVE -> Known.ACTIVE
                ARCHIVED -> Known.ARCHIVED
                else -> throw MergeInvalidDataException("Unknown Status7d1Enum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class CategoryTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CategoryTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val CLASS = CategoryTypeEnum(JsonField.of("CLASS"))

            @JvmField val DEPARTMENT = CategoryTypeEnum(JsonField.of("DEPARTMENT"))

            @JvmStatic fun of(value: String) = CategoryTypeEnum(JsonField.of(value))
        }

        enum class Known {
            CLASS,
            DEPARTMENT,
        }

        enum class Value {
            CLASS,
            DEPARTMENT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CLASS -> Value.CLASS
                DEPARTMENT -> Value.DEPARTMENT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CLASS -> Known.CLASS
                DEPARTMENT -> Known.DEPARTMENT
                else -> throw MergeInvalidDataException("Unknown CategoryTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
