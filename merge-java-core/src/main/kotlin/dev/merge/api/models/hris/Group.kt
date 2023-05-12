package dev.merge.api.models.hris

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
 * # The Group Object
 *
 * ### Description
 *
 * The `Group` object is used to represent any subset of employees, such as `PayGroup` or `Team`.
 * Employees can be in multiple Groups.
 *
 * ### Usage Example
 *
 * Fetch from the `LIST Employee` endpoint and expand groups to view an employee's groups.
 */
@JsonDeserialize(builder = Group.Builder::class)
@NoAutoDetect
class Group
private constructor(
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val parentGroup: JsonField<String>,
    private val name: JsonField<String>,
    private val type: JsonField<GroupTypeEnum>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /** The third-party API ID of the matching object. */
    fun remoteId(): Optional<String> = Optional.ofNullable(remoteId.getNullable("remote_id"))

    /** The parent group for this group. */
    fun parentGroup(): Optional<String> =
        Optional.ofNullable(parentGroup.getNullable("parent_group"))

    /** The group name. */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /**
     * - `TEAM` - TEAM
     * - `DEPARTMENT` - DEPARTMENT
     * - `COST_CENTER` - COST_CENTER
     * - `BUSINESS_UNIT` - BUSINESS_UNIT
     * - `GROUP` - GROUP
     */
    fun type(): Optional<GroupTypeEnum> = Optional.ofNullable(type.getNullable("type"))

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    fun remoteWasDeleted(): Optional<Boolean> =
        Optional.ofNullable(remoteWasDeleted.getNullable("remote_was_deleted"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    fun remoteData(): Optional<List<RemoteData>> =
        Optional.ofNullable(remoteData.getNullable("remote_data"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    /** The parent group for this group. */
    @JsonProperty("parent_group") @ExcludeMissing fun _parentGroup() = parentGroup

    /** The group name. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /**
     * - `TEAM` - TEAM
     * - `DEPARTMENT` - DEPARTMENT
     * - `COST_CENTER` - COST_CENTER
     * - `BUSINESS_UNIT` - BUSINESS_UNIT
     * - `GROUP` - GROUP
     */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            id()
            remoteId()
            parentGroup()
            name()
            type()
            remoteWasDeleted()
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

        return other is Group &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.parentGroup == other.parentGroup &&
            this.name == other.name &&
            this.type == other.type &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    remoteId,
                    parentGroup,
                    name,
                    type,
                    remoteWasDeleted,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Group{id=$id, remoteId=$remoteId, parentGroup=$parentGroup, name=$name, type=$type, remoteWasDeleted=$remoteWasDeleted, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var parentGroup: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var type: JsonField<GroupTypeEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(group: Group) = apply {
            this.id = group.id
            this.remoteId = group.remoteId
            this.parentGroup = group.parentGroup
            this.name = group.name
            this.type = group.type
            this.remoteWasDeleted = group.remoteWasDeleted
            this.fieldMappings = group.fieldMappings
            this.modifiedAt = group.modifiedAt
            this.remoteData = group.remoteData
            additionalProperties(group.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The third-party API ID of the matching object. */
        fun remoteId(remoteId: String) = remoteId(JsonField.of(remoteId))

        /** The third-party API ID of the matching object. */
        @JsonProperty("remote_id")
        @ExcludeMissing
        fun remoteId(remoteId: JsonField<String>) = apply { this.remoteId = remoteId }

        /** The parent group for this group. */
        fun parentGroup(parentGroup: String) = parentGroup(JsonField.of(parentGroup))

        /** The parent group for this group. */
        @JsonProperty("parent_group")
        @ExcludeMissing
        fun parentGroup(parentGroup: JsonField<String>) = apply { this.parentGroup = parentGroup }

        /** The group name. */
        fun name(name: String) = name(JsonField.of(name))

        /** The group name. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * - `TEAM` - TEAM
         * - `DEPARTMENT` - DEPARTMENT
         * - `COST_CENTER` - COST_CENTER
         * - `BUSINESS_UNIT` - BUSINESS_UNIT
         * - `GROUP` - GROUP
         */
        fun type(type: GroupTypeEnum) = type(JsonField.of(type))

        /**
         * - `TEAM` - TEAM
         * - `DEPARTMENT` - DEPARTMENT
         * - `COST_CENTER` - COST_CENTER
         * - `BUSINESS_UNIT` - BUSINESS_UNIT
         * - `GROUP` - GROUP
         */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<GroupTypeEnum>) = apply { this.type = type }

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        fun remoteWasDeleted(remoteWasDeleted: Boolean) =
            remoteWasDeleted(JsonField.of(remoteWasDeleted))

        /** Indicates whether or not this object has been deleted by third party webhooks. */
        @JsonProperty("remote_was_deleted")
        @ExcludeMissing
        fun remoteWasDeleted(remoteWasDeleted: JsonField<Boolean>) = apply {
            this.remoteWasDeleted = remoteWasDeleted
        }

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

        fun build(): Group =
            Group(
                id,
                remoteId,
                parentGroup,
                name,
                type,
                remoteWasDeleted,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class GroupTypeEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is GroupTypeEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val TEAM = GroupTypeEnum(JsonField.of("TEAM"))

            @JvmField val DEPARTMENT = GroupTypeEnum(JsonField.of("DEPARTMENT"))

            @JvmField val COST_CENTER = GroupTypeEnum(JsonField.of("COST_CENTER"))

            @JvmField val BUSINESS_UNIT = GroupTypeEnum(JsonField.of("BUSINESS_UNIT"))

            @JvmField val GROUP = GroupTypeEnum(JsonField.of("GROUP"))

            @JvmStatic fun of(value: String) = GroupTypeEnum(JsonField.of(value))
        }

        enum class Known {
            TEAM,
            DEPARTMENT,
            COST_CENTER,
            BUSINESS_UNIT,
            GROUP,
        }

        enum class Value {
            TEAM,
            DEPARTMENT,
            COST_CENTER,
            BUSINESS_UNIT,
            GROUP,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TEAM -> Value.TEAM
                DEPARTMENT -> Value.DEPARTMENT
                COST_CENTER -> Value.COST_CENTER
                BUSINESS_UNIT -> Value.BUSINESS_UNIT
                GROUP -> Value.GROUP
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                TEAM -> Known.TEAM
                DEPARTMENT -> Known.DEPARTMENT
                COST_CENTER -> Known.COST_CENTER
                BUSINESS_UNIT -> Known.BUSINESS_UNIT
                GROUP -> Known.GROUP
                else -> throw MergeInvalidDataException("Unknown GroupTypeEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
