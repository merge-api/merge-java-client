package dev.merge.api.models.crm

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
 * # The Task Object
 *
 * ### Description
 *
 * The `Task` object is used to represent a task, such as a to-do item.
 *
 * ### Usage Example
 *
 * TODO
 */
@JsonDeserialize(builder = Task.Builder::class)
@NoAutoDetect
class Task
private constructor(
    private val subject: JsonField<String>,
    private val content: JsonField<String>,
    private val owner: JsonField<String>,
    private val account: JsonField<String>,
    private val completedDate: JsonField<OffsetDateTime>,
    private val dueDate: JsonField<OffsetDateTime>,
    private val status: JsonField<TaskStatusEnum>,
    private val remoteWasDeleted: JsonField<Boolean>,
    private val id: JsonField<String>,
    private val remoteId: JsonField<String>,
    private val fieldMappings: JsonValue,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val remoteData: JsonField<List<RemoteData>>,
    private val remoteFields: JsonField<List<RemoteField>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The task's subject. */
    fun subject(): Optional<String> = Optional.ofNullable(subject.getNullable("subject"))

    /** The task's content. */
    fun content(): Optional<String> = Optional.ofNullable(content.getNullable("content"))

    /** The task's owner. */
    fun owner(): Optional<String> = Optional.ofNullable(owner.getNullable("owner"))

    /** The task's account. */
    fun account(): Optional<String> = Optional.ofNullable(account.getNullable("account"))

    /** When the task is completed. */
    fun completedDate(): Optional<OffsetDateTime> =
        Optional.ofNullable(completedDate.getNullable("completed_date"))

    /** When the task is due. */
    fun dueDate(): Optional<OffsetDateTime> = Optional.ofNullable(dueDate.getNullable("due_date"))

    /**
     * - `OPEN` - OPEN
     * - `CLOSED` - CLOSED
     */
    fun status(): Optional<TaskStatusEnum> = Optional.ofNullable(status.getNullable("status"))

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

    fun remoteFields(): Optional<List<RemoteField>> =
        Optional.ofNullable(remoteFields.getNullable("remote_fields"))

    /** The task's subject. */
    @JsonProperty("subject") @ExcludeMissing fun _subject() = subject

    /** The task's content. */
    @JsonProperty("content") @ExcludeMissing fun _content() = content

    /** The task's owner. */
    @JsonProperty("owner") @ExcludeMissing fun _owner() = owner

    /** The task's account. */
    @JsonProperty("account") @ExcludeMissing fun _account() = account

    /** When the task is completed. */
    @JsonProperty("completed_date") @ExcludeMissing fun _completedDate() = completedDate

    /** When the task is due. */
    @JsonProperty("due_date") @ExcludeMissing fun _dueDate() = dueDate

    /**
     * - `OPEN` - OPEN
     * - `CLOSED` - CLOSED
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** Indicates whether or not this object has been deleted by third party webhooks. */
    @JsonProperty("remote_was_deleted") @ExcludeMissing fun _remoteWasDeleted() = remoteWasDeleted

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The third-party API ID of the matching object. */
    @JsonProperty("remote_id") @ExcludeMissing fun _remoteId() = remoteId

    @JsonProperty("field_mappings") @ExcludeMissing fun _fieldMappings() = fieldMappings

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonProperty("remote_data") @ExcludeMissing fun _remoteData() = remoteData

    @JsonProperty("remote_fields") @ExcludeMissing fun _remoteFields() = remoteFields

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            subject()
            content()
            owner()
            account()
            completedDate()
            dueDate()
            status()
            remoteWasDeleted()
            id()
            remoteId()
            modifiedAt()
            remoteData().map { it.forEach { it.validate() } }
            remoteFields().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Task &&
            this.subject == other.subject &&
            this.content == other.content &&
            this.owner == other.owner &&
            this.account == other.account &&
            this.completedDate == other.completedDate &&
            this.dueDate == other.dueDate &&
            this.status == other.status &&
            this.remoteWasDeleted == other.remoteWasDeleted &&
            this.id == other.id &&
            this.remoteId == other.remoteId &&
            this.fieldMappings == other.fieldMappings &&
            this.modifiedAt == other.modifiedAt &&
            this.remoteData == other.remoteData &&
            this.remoteFields == other.remoteFields &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    subject,
                    content,
                    owner,
                    account,
                    completedDate,
                    dueDate,
                    status,
                    remoteWasDeleted,
                    id,
                    remoteId,
                    fieldMappings,
                    modifiedAt,
                    remoteData,
                    remoteFields,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Task{subject=$subject, content=$content, owner=$owner, account=$account, completedDate=$completedDate, dueDate=$dueDate, status=$status, remoteWasDeleted=$remoteWasDeleted, id=$id, remoteId=$remoteId, fieldMappings=$fieldMappings, modifiedAt=$modifiedAt, remoteData=$remoteData, remoteFields=$remoteFields, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var subject: JsonField<String> = JsonMissing.of()
        private var content: JsonField<String> = JsonMissing.of()
        private var owner: JsonField<String> = JsonMissing.of()
        private var account: JsonField<String> = JsonMissing.of()
        private var completedDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var dueDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var status: JsonField<TaskStatusEnum> = JsonMissing.of()
        private var remoteWasDeleted: JsonField<Boolean> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var remoteId: JsonField<String> = JsonMissing.of()
        private var fieldMappings: JsonValue = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var remoteData: JsonField<List<RemoteData>> = JsonMissing.of()
        private var remoteFields: JsonField<List<RemoteField>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(task: Task) = apply {
            this.subject = task.subject
            this.content = task.content
            this.owner = task.owner
            this.account = task.account
            this.completedDate = task.completedDate
            this.dueDate = task.dueDate
            this.status = task.status
            this.remoteWasDeleted = task.remoteWasDeleted
            this.id = task.id
            this.remoteId = task.remoteId
            this.fieldMappings = task.fieldMappings
            this.modifiedAt = task.modifiedAt
            this.remoteData = task.remoteData
            this.remoteFields = task.remoteFields
            additionalProperties(task.additionalProperties)
        }

        /** The task's subject. */
        fun subject(subject: String) = subject(JsonField.of(subject))

        /** The task's subject. */
        @JsonProperty("subject")
        @ExcludeMissing
        fun subject(subject: JsonField<String>) = apply { this.subject = subject }

        /** The task's content. */
        fun content(content: String) = content(JsonField.of(content))

        /** The task's content. */
        @JsonProperty("content")
        @ExcludeMissing
        fun content(content: JsonField<String>) = apply { this.content = content }

        /** The task's owner. */
        fun owner(owner: String) = owner(JsonField.of(owner))

        /** The task's owner. */
        @JsonProperty("owner")
        @ExcludeMissing
        fun owner(owner: JsonField<String>) = apply { this.owner = owner }

        /** The task's account. */
        fun account(account: String) = account(JsonField.of(account))

        /** The task's account. */
        @JsonProperty("account")
        @ExcludeMissing
        fun account(account: JsonField<String>) = apply { this.account = account }

        /** When the task is completed. */
        fun completedDate(completedDate: OffsetDateTime) =
            completedDate(JsonField.of(completedDate))

        /** When the task is completed. */
        @JsonProperty("completed_date")
        @ExcludeMissing
        fun completedDate(completedDate: JsonField<OffsetDateTime>) = apply {
            this.completedDate = completedDate
        }

        /** When the task is due. */
        fun dueDate(dueDate: OffsetDateTime) = dueDate(JsonField.of(dueDate))

        /** When the task is due. */
        @JsonProperty("due_date")
        @ExcludeMissing
        fun dueDate(dueDate: JsonField<OffsetDateTime>) = apply { this.dueDate = dueDate }

        /**
         * - `OPEN` - OPEN
         * - `CLOSED` - CLOSED
         */
        fun status(status: TaskStatusEnum) = status(JsonField.of(status))

        /**
         * - `OPEN` - OPEN
         * - `CLOSED` - CLOSED
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<TaskStatusEnum>) = apply { this.status = status }

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

        fun remoteFields(remoteFields: List<RemoteField>) = remoteFields(JsonField.of(remoteFields))

        @JsonProperty("remote_fields")
        @ExcludeMissing
        fun remoteFields(remoteFields: JsonField<List<RemoteField>>) = apply {
            this.remoteFields = remoteFields
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

        fun build(): Task =
            Task(
                subject,
                content,
                owner,
                account,
                completedDate,
                dueDate,
                status,
                remoteWasDeleted,
                id,
                remoteId,
                fieldMappings,
                modifiedAt,
                remoteData.map { it.toUnmodifiable() },
                remoteFields.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    class TaskStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TaskStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val OPEN = TaskStatusEnum(JsonField.of("OPEN"))

            @JvmField val CLOSED = TaskStatusEnum(JsonField.of("CLOSED"))

            @JvmStatic fun of(value: String) = TaskStatusEnum(JsonField.of(value))
        }

        enum class Known {
            OPEN,
            CLOSED,
        }

        enum class Value {
            OPEN,
            CLOSED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                OPEN -> Value.OPEN
                CLOSED -> Value.CLOSED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                OPEN -> Known.OPEN
                CLOSED -> Known.CLOSED
                else -> throw MergeInvalidDataException("Unknown TaskStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = RemoteField.Builder::class)
    @NoAutoDetect
    class RemoteField
    private constructor(
        private val remoteFieldClass: JsonField<RemoteFieldClass>,
        private val value: JsonValue,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun remoteFieldClass(): RemoteFieldClass =
            remoteFieldClass.getRequired("remote_field_class")

        @JsonProperty("remote_field_class")
        @ExcludeMissing
        fun _remoteFieldClass() = remoteFieldClass

        @JsonProperty("value") @ExcludeMissing fun _value() = value

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                remoteFieldClass().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RemoteField &&
                this.remoteFieldClass == other.remoteFieldClass &&
                this.value == other.value &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        remoteFieldClass,
                        value,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "RemoteField{remoteFieldClass=$remoteFieldClass, value=$value, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var remoteFieldClass: JsonField<RemoteFieldClass> = JsonMissing.of()
            private var value: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(remoteField: RemoteField) = apply {
                this.remoteFieldClass = remoteField.remoteFieldClass
                this.value = remoteField.value
                additionalProperties(remoteField.additionalProperties)
            }

            fun remoteFieldClass(remoteFieldClass: RemoteFieldClass) =
                remoteFieldClass(JsonField.of(remoteFieldClass))

            @JsonProperty("remote_field_class")
            @ExcludeMissing
            fun remoteFieldClass(remoteFieldClass: JsonField<RemoteFieldClass>) = apply {
                this.remoteFieldClass = remoteFieldClass
            }

            @JsonProperty("value")
            @ExcludeMissing
            fun value(value: JsonValue) = apply { this.value = value }

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

            fun build(): RemoteField =
                RemoteField(
                    remoteFieldClass,
                    value,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
