package dev.merge.api.models.marketing

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

class AutomationCreateParams
constructor(
    private val model: AutomationRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): AutomationRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): AutomationCreateBody {
        return AutomationCreateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = AutomationCreateBody.Builder::class)
    @NoAutoDetect
    class AutomationCreateBody
    internal constructor(
        private val model: AutomationRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Automation Object
         *
         * ### Description
         *
         * The `Automation` object is used to represent an automation, workflow or custom event in
         * the remote system.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/mktg/v1/automations` endpoint and view their automation_trigger
         * configurations.
         */
        @JsonProperty("model") fun model(): AutomationRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AutomationCreateBody &&
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
            "AutomationCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: AutomationRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(automationCreateBody: AutomationCreateBody) = apply {
                this.model = automationCreateBody.model
                additionalProperties(automationCreateBody.additionalProperties)
            }

            /**
             * # The Automation Object
             *
             * ### Description
             *
             * The `Automation` object is used to represent an automation, workflow or custom event
             * in the remote system.
             *
             * ### Usage Example
             *
             * Fetch from the `GET /api/mktg/v1/automations` endpoint and view their
             * automation_trigger configurations.
             */
            @JsonProperty("model")
            fun model(model: AutomationRequest) = apply { this.model = model }

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

            fun build(): AutomationCreateBody =
                AutomationCreateBody(
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

        return other is AutomationCreateParams &&
            this.model == other.model &&
            this.isDebugMode == other.isDebugMode &&
            this.runAsync == other.runAsync &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            isDebugMode,
            runAsync,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "AutomationCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: AutomationRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(automationCreateParams: AutomationCreateParams) = apply {
            this.model = automationCreateParams.model
            this.isDebugMode = automationCreateParams.isDebugMode
            this.runAsync = automationCreateParams.runAsync
            additionalQueryParams(automationCreateParams.additionalQueryParams)
            additionalHeaders(automationCreateParams.additionalHeaders)
            additionalBodyProperties(automationCreateParams.additionalBodyProperties)
        }

        /**
         * # The Automation Object
         *
         * ### Description
         *
         * The `Automation` object is used to represent an automation, workflow or custom event in
         * the remote system.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/mktg/v1/automations` endpoint and view their automation_trigger
         * configurations.
         */
        fun model(model: AutomationRequest) = apply { this.model = model }

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

        fun build(): AutomationCreateParams =
            AutomationCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Automation Object
     *
     * ### Description
     *
     * The `Automation` object is used to represent an automation, workflow or custom event in the
     * remote system.
     *
     * ### Usage Example
     *
     * Fetch from the `GET /api/mktg/v1/automations` endpoint and view their automation_trigger
     * configurations.
     */
    @JsonDeserialize(builder = AutomationRequest.Builder::class)
    @NoAutoDetect
    class AutomationRequest
    private constructor(
        private val name: String?,
        private val triggerType: TriggerTypeEnum?,
        private val startDate: OffsetDateTime?,
        private val endDate: OffsetDateTime?,
        private val description: String?,
        private val status: String?,
        private val automationTrigger: JsonValue?,
        private val actions: List<String>?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The automation's name. */
        @JsonProperty("name") fun name(): String? = name

        /**
         * - `TRIGGER_EVENT` - TRIGGER_EVENT
         * - `RECURRENCE` - RECURRENCE
         */
        @JsonProperty("trigger_type") fun triggerType(): TriggerTypeEnum? = triggerType

        /** The automation's start date. */
        @JsonProperty("start_date") fun startDate(): OffsetDateTime? = startDate

        /** The automation's end date. */
        @JsonProperty("end_date") fun endDate(): OffsetDateTime? = endDate

        /** The automation’s description. */
        @JsonProperty("description") fun description(): String? = description

        /** The automation's status. */
        @JsonProperty("status") fun status(): String? = status

        /** The trigger configuraton for the automation. */
        @JsonProperty("automation_trigger") fun automationTrigger(): JsonValue? = automationTrigger

        /** The actions performed by this automation. */
        @JsonProperty("actions") fun actions(): List<String>? = actions

        @JsonProperty("integration_params") fun integrationParams(): JsonValue? = integrationParams

        @JsonProperty("linked_account_params")
        fun linkedAccountParams(): JsonValue? = linkedAccountParams

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AutomationRequest &&
                this.name == other.name &&
                this.triggerType == other.triggerType &&
                this.startDate == other.startDate &&
                this.endDate == other.endDate &&
                this.description == other.description &&
                this.status == other.status &&
                this.automationTrigger == other.automationTrigger &&
                this.actions == other.actions &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        name,
                        triggerType,
                        startDate,
                        endDate,
                        description,
                        status,
                        automationTrigger,
                        actions,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "AutomationRequest{name=$name, triggerType=$triggerType, startDate=$startDate, endDate=$endDate, description=$description, status=$status, automationTrigger=$automationTrigger, actions=$actions, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var triggerType: TriggerTypeEnum? = null
            private var startDate: OffsetDateTime? = null
            private var endDate: OffsetDateTime? = null
            private var description: String? = null
            private var status: String? = null
            private var automationTrigger: JsonValue? = null
            private var actions: List<String>? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(automationRequest: AutomationRequest) = apply {
                this.name = automationRequest.name
                this.triggerType = automationRequest.triggerType
                this.startDate = automationRequest.startDate
                this.endDate = automationRequest.endDate
                this.description = automationRequest.description
                this.status = automationRequest.status
                this.automationTrigger = automationRequest.automationTrigger
                this.actions = automationRequest.actions
                this.integrationParams = automationRequest.integrationParams
                this.linkedAccountParams = automationRequest.linkedAccountParams
                additionalProperties(automationRequest.additionalProperties)
            }

            /** The automation's name. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /**
             * - `TRIGGER_EVENT` - TRIGGER_EVENT
             * - `RECURRENCE` - RECURRENCE
             */
            @JsonProperty("trigger_type")
            fun triggerType(triggerType: TriggerTypeEnum) = apply { this.triggerType = triggerType }

            /** The automation's start date. */
            @JsonProperty("start_date")
            fun startDate(startDate: OffsetDateTime) = apply { this.startDate = startDate }

            /** The automation's end date. */
            @JsonProperty("end_date")
            fun endDate(endDate: OffsetDateTime) = apply { this.endDate = endDate }

            /** The automation’s description. */
            @JsonProperty("description")
            fun description(description: String) = apply { this.description = description }

            /** The automation's status. */
            @JsonProperty("status") fun status(status: String) = apply { this.status = status }

            /** The trigger configuraton for the automation. */
            @JsonProperty("automation_trigger")
            fun automationTrigger(automationTrigger: JsonValue) = apply {
                this.automationTrigger = automationTrigger
            }

            /** The actions performed by this automation. */
            @JsonProperty("actions")
            fun actions(actions: List<String>) = apply { this.actions = actions }

            @JsonProperty("integration_params")
            fun integrationParams(integrationParams: JsonValue) = apply {
                this.integrationParams = integrationParams
            }

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                this.linkedAccountParams = linkedAccountParams
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

            fun build(): AutomationRequest =
                AutomationRequest(
                    name,
                    triggerType,
                    startDate,
                    endDate,
                    description,
                    status,
                    automationTrigger,
                    checkNotNull(actions) { "`actions` is required but was not set" }
                        .toUnmodifiable(),
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class TriggerTypeEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is TriggerTypeEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val TRIGGER_EVENT = TriggerTypeEnum(JsonField.of("TRIGGER_EVENT"))

                @JvmField val RECURRENCE = TriggerTypeEnum(JsonField.of("RECURRENCE"))

                @JvmStatic fun of(value: String) = TriggerTypeEnum(JsonField.of(value))
            }

            enum class Known {
                TRIGGER_EVENT,
                RECURRENCE,
            }

            enum class Value {
                TRIGGER_EVENT,
                RECURRENCE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TRIGGER_EVENT -> Value.TRIGGER_EVENT
                    RECURRENCE -> Value.RECURRENCE
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    TRIGGER_EVENT -> Known.TRIGGER_EVENT
                    RECURRENCE -> Known.RECURRENCE
                    else -> throw MergeInvalidDataException("Unknown TriggerTypeEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
