package dev.merge.api.models.crm

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

class TaskUpdateParams
constructor(
    private val id: String,
    private val model: PatchedTaskRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun id(): String = id

    fun model(): PatchedTaskRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): TaskUpdateBody {
        return TaskUpdateBody(model, additionalBodyProperties)
    }

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.isDebugMode?.let { params.put("is_debug_mode", listOf(it.toString())) }
        this.runAsync?.let { params.put("run_async", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> id
            else -> ""
        }
    }

    @JsonDeserialize(builder = TaskUpdateBody.Builder::class)
    @NoAutoDetect
    class TaskUpdateBody
    internal constructor(
        private val model: PatchedTaskRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

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
        @JsonProperty("model") fun model(): PatchedTaskRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TaskUpdateBody &&
                this.model == other.model &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(model, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "TaskUpdateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: PatchedTaskRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(taskUpdateBody: TaskUpdateBody) = apply {
                this.model = taskUpdateBody.model
                additionalProperties(taskUpdateBody.additionalProperties)
            }

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
            @JsonProperty("model")
            fun model(model: PatchedTaskRequest) = apply { this.model = model }

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

            fun build(): TaskUpdateBody =
                TaskUpdateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    additionalProperties.toUnmodifiable()
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TaskUpdateParams &&
            this.id == other.id &&
            this.model == other.model &&
            this.isDebugMode == other.isDebugMode &&
            this.runAsync == other.runAsync &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            id,
            model,
            isDebugMode,
            runAsync,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "TaskUpdateParams{id=$id, model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var model: PatchedTaskRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(taskUpdateParams: TaskUpdateParams) = apply {
            this.id = taskUpdateParams.id
            this.model = taskUpdateParams.model
            this.isDebugMode = taskUpdateParams.isDebugMode
            this.runAsync = taskUpdateParams.runAsync
            additionalQueryParams(taskUpdateParams.additionalQueryParams)
            additionalHeaders(taskUpdateParams.additionalHeaders)
            additionalBodyProperties(taskUpdateParams.additionalBodyProperties)
        }

        fun id(id: String) = apply { this.id = id }

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
        fun model(model: PatchedTaskRequest) = apply { this.model = model }

        /** Whether to include debug fields (such as log file links) in the response. */
        fun isDebugMode(isDebugMode: Boolean) = apply { this.isDebugMode = isDebugMode }

        /** Whether or not third-party updates should be run asynchronously. */
        fun runAsync(runAsync: Boolean) = apply { this.runAsync = runAsync }

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

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): TaskUpdateParams =
            TaskUpdateParams(
                checkNotNull(id) { "`id` is required but was not set" },
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

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
    @JsonDeserialize(builder = PatchedTaskRequest.Builder::class)
    @NoAutoDetect
    class PatchedTaskRequest
    private constructor(
        private val subject: String?,
        private val content: String?,
        private val owner: String?,
        private val account: String?,
        private val completedDate: OffsetDateTime?,
        private val dueDate: OffsetDateTime?,
        private val status: TaskStatusEnum?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val remoteFields: List<RemoteFieldRequest>?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The task's subject. */
        @JsonProperty("subject") fun subject(): String? = subject

        /** The task's content. */
        @JsonProperty("content") fun content(): String? = content

        /** The task's owner. */
        @JsonProperty("owner") fun owner(): String? = owner

        /** The task's account. */
        @JsonProperty("account") fun account(): String? = account

        /** When the task is completed. */
        @JsonProperty("completed_date") fun completedDate(): OffsetDateTime? = completedDate

        /** When the task is due. */
        @JsonProperty("due_date") fun dueDate(): OffsetDateTime? = dueDate

        /**
         * - `OPEN` - OPEN
         * - `CLOSED` - CLOSED
         */
        @JsonProperty("status") fun status(): TaskStatusEnum? = status

        @JsonProperty("integration_params") fun integrationParams(): JsonValue? = integrationParams

        @JsonProperty("linked_account_params")
        fun linkedAccountParams(): JsonValue? = linkedAccountParams

        @JsonProperty("remote_fields") fun remoteFields(): List<RemoteFieldRequest>? = remoteFields

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PatchedTaskRequest &&
                this.subject == other.subject &&
                this.content == other.content &&
                this.owner == other.owner &&
                this.account == other.account &&
                this.completedDate == other.completedDate &&
                this.dueDate == other.dueDate &&
                this.status == other.status &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
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
                        integrationParams,
                        linkedAccountParams,
                        remoteFields,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "PatchedTaskRequest{subject=$subject, content=$content, owner=$owner, account=$account, completedDate=$completedDate, dueDate=$dueDate, status=$status, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, remoteFields=$remoteFields, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var subject: String? = null
            private var content: String? = null
            private var owner: String? = null
            private var account: String? = null
            private var completedDate: OffsetDateTime? = null
            private var dueDate: OffsetDateTime? = null
            private var status: TaskStatusEnum? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var remoteFields: List<RemoteFieldRequest>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(patchedTaskRequest: PatchedTaskRequest) = apply {
                this.subject = patchedTaskRequest.subject
                this.content = patchedTaskRequest.content
                this.owner = patchedTaskRequest.owner
                this.account = patchedTaskRequest.account
                this.completedDate = patchedTaskRequest.completedDate
                this.dueDate = patchedTaskRequest.dueDate
                this.status = patchedTaskRequest.status
                this.integrationParams = patchedTaskRequest.integrationParams
                this.linkedAccountParams = patchedTaskRequest.linkedAccountParams
                this.remoteFields = patchedTaskRequest.remoteFields
                additionalProperties(patchedTaskRequest.additionalProperties)
            }

            /** The task's subject. */
            @JsonProperty("subject") fun subject(subject: String) = apply { this.subject = subject }

            /** The task's content. */
            @JsonProperty("content") fun content(content: String) = apply { this.content = content }

            /** The task's owner. */
            @JsonProperty("owner") fun owner(owner: String) = apply { this.owner = owner }

            /** The task's account. */
            @JsonProperty("account") fun account(account: String) = apply { this.account = account }

            /** When the task is completed. */
            @JsonProperty("completed_date")
            fun completedDate(completedDate: OffsetDateTime) = apply {
                this.completedDate = completedDate
            }

            /** When the task is due. */
            @JsonProperty("due_date")
            fun dueDate(dueDate: OffsetDateTime) = apply { this.dueDate = dueDate }

            /**
             * - `OPEN` - OPEN
             * - `CLOSED` - CLOSED
             */
            @JsonProperty("status")
            fun status(status: TaskStatusEnum) = apply { this.status = status }

            @JsonProperty("integration_params")
            fun integrationParams(integrationParams: JsonValue) = apply {
                this.integrationParams = integrationParams
            }

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                this.linkedAccountParams = linkedAccountParams
            }

            @JsonProperty("remote_fields")
            fun remoteFields(remoteFields: List<RemoteFieldRequest>) = apply {
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

            fun build(): PatchedTaskRequest =
                PatchedTaskRequest(
                    subject,
                    content,
                    owner,
                    account,
                    completedDate,
                    dueDate,
                    status,
                    integrationParams,
                    linkedAccountParams,
                    remoteFields?.toUnmodifiable(),
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

        @JsonDeserialize(builder = RemoteFieldRequest.Builder::class)
        @NoAutoDetect
        class RemoteFieldRequest
        private constructor(
            private val remoteFieldClass: String?,
            private val value: JsonValue?,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var hashCode: Int = 0

            @JsonProperty("remote_field_class") fun remoteFieldClass(): String? = remoteFieldClass

            @JsonProperty("value") fun value(): JsonValue? = value

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RemoteFieldRequest &&
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
                "RemoteFieldRequest{remoteFieldClass=$remoteFieldClass, value=$value, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var remoteFieldClass: String? = null
                private var value: JsonValue? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(remoteFieldRequest: RemoteFieldRequest) = apply {
                    this.remoteFieldClass = remoteFieldRequest.remoteFieldClass
                    this.value = remoteFieldRequest.value
                    additionalProperties(remoteFieldRequest.additionalProperties)
                }

                @JsonProperty("remote_field_class")
                fun remoteFieldClass(remoteFieldClass: String) = apply {
                    this.remoteFieldClass = remoteFieldClass
                }

                @JsonProperty("value") fun value(value: JsonValue) = apply { this.value = value }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    this.additionalProperties.putAll(additionalProperties)
                }

                @JsonAnySetter
                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    this.additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): RemoteFieldRequest =
                    RemoteFieldRequest(
                        checkNotNull(remoteFieldClass) {
                            "`remoteFieldClass` is required but was not set"
                        },
                        value,
                        additionalProperties.toUnmodifiable(),
                    )
            }
        }
    }
}
