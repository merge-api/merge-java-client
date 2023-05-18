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

class EngagementCreateParams
constructor(
    private val model: EngagementRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): EngagementRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): EngagementCreateBody {
        return EngagementCreateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = EngagementCreateBody.Builder::class)
    @NoAutoDetect
    class EngagementCreateBody
    internal constructor(
        private val model: EngagementRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Engagement Object
         *
         * ### Description
         *
         * The `Engagement` object is used to represent an interaction noted in a CRM system.
         *
         * ### Usage Example
         *
         * TODO
         */
        @JsonProperty("model") fun model(): EngagementRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EngagementCreateBody &&
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
            "EngagementCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: EngagementRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(engagementCreateBody: EngagementCreateBody) = apply {
                this.model = engagementCreateBody.model
                additionalProperties(engagementCreateBody.additionalProperties)
            }

            /**
             * # The Engagement Object
             *
             * ### Description
             *
             * The `Engagement` object is used to represent an interaction noted in a CRM system.
             *
             * ### Usage Example
             *
             * TODO
             */
            @JsonProperty("model")
            fun model(model: EngagementRequest) = apply { this.model = model }

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

            fun build(): EngagementCreateBody =
                EngagementCreateBody(
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

        return other is EngagementCreateParams &&
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
        "EngagementCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: EngagementRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(engagementCreateParams: EngagementCreateParams) = apply {
            this.model = engagementCreateParams.model
            this.isDebugMode = engagementCreateParams.isDebugMode
            this.runAsync = engagementCreateParams.runAsync
            additionalQueryParams(engagementCreateParams.additionalQueryParams)
            additionalHeaders(engagementCreateParams.additionalHeaders)
            additionalBodyProperties(engagementCreateParams.additionalBodyProperties)
        }

        /**
         * # The Engagement Object
         *
         * ### Description
         *
         * The `Engagement` object is used to represent an interaction noted in a CRM system.
         *
         * ### Usage Example
         *
         * TODO
         */
        fun model(model: EngagementRequest) = apply { this.model = model }

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

        fun build(): EngagementCreateParams =
            EngagementCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Engagement Object
     *
     * ### Description
     *
     * The `Engagement` object is used to represent an interaction noted in a CRM system.
     *
     * ### Usage Example
     *
     * TODO
     */
    @JsonDeserialize(builder = EngagementRequest.Builder::class)
    @NoAutoDetect
    class EngagementRequest
    private constructor(
        private val owner: String?,
        private val content: String?,
        private val subject: String?,
        private val direction: DirectionEnum?,
        private val engagementType: String?,
        private val startTime: OffsetDateTime?,
        private val endTime: OffsetDateTime?,
        private val account: String?,
        private val contacts: List<String>?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val remoteFields: List<RemoteFieldRequest>?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The engagement's owner. */
        @JsonProperty("owner") fun owner(): String? = owner

        /** The engagement's content. */
        @JsonProperty("content") fun content(): String? = content

        /** The engagement's subject. */
        @JsonProperty("subject") fun subject(): String? = subject

        /**
         * - `INBOUND` - INBOUND
         * - `OUTBOUND` - OUTBOUND
         */
        @JsonProperty("direction") fun direction(): DirectionEnum? = direction

        /** The engagement type of the engagement. */
        @JsonProperty("engagement_type") fun engagementType(): String? = engagementType

        /** The time at which the engagement started. */
        @JsonProperty("start_time") fun startTime(): OffsetDateTime? = startTime

        /** The time at which the engagement ended. */
        @JsonProperty("end_time") fun endTime(): OffsetDateTime? = endTime

        /** The account of the engagement. */
        @JsonProperty("account") fun account(): String? = account

        @JsonProperty("contacts") fun contacts(): List<String>? = contacts

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

            return other is EngagementRequest &&
                this.owner == other.owner &&
                this.content == other.content &&
                this.subject == other.subject &&
                this.direction == other.direction &&
                this.engagementType == other.engagementType &&
                this.startTime == other.startTime &&
                this.endTime == other.endTime &&
                this.account == other.account &&
                this.contacts == other.contacts &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.remoteFields == other.remoteFields &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        owner,
                        content,
                        subject,
                        direction,
                        engagementType,
                        startTime,
                        endTime,
                        account,
                        contacts,
                        integrationParams,
                        linkedAccountParams,
                        remoteFields,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "EngagementRequest{owner=$owner, content=$content, subject=$subject, direction=$direction, engagementType=$engagementType, startTime=$startTime, endTime=$endTime, account=$account, contacts=$contacts, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, remoteFields=$remoteFields, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var owner: String? = null
            private var content: String? = null
            private var subject: String? = null
            private var direction: DirectionEnum? = null
            private var engagementType: String? = null
            private var startTime: OffsetDateTime? = null
            private var endTime: OffsetDateTime? = null
            private var account: String? = null
            private var contacts: List<String>? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var remoteFields: List<RemoteFieldRequest>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(engagementRequest: EngagementRequest) = apply {
                this.owner = engagementRequest.owner
                this.content = engagementRequest.content
                this.subject = engagementRequest.subject
                this.direction = engagementRequest.direction
                this.engagementType = engagementRequest.engagementType
                this.startTime = engagementRequest.startTime
                this.endTime = engagementRequest.endTime
                this.account = engagementRequest.account
                this.contacts = engagementRequest.contacts
                this.integrationParams = engagementRequest.integrationParams
                this.linkedAccountParams = engagementRequest.linkedAccountParams
                this.remoteFields = engagementRequest.remoteFields
                additionalProperties(engagementRequest.additionalProperties)
            }

            /** The engagement's owner. */
            @JsonProperty("owner") fun owner(owner: String) = apply { this.owner = owner }

            /** The engagement's content. */
            @JsonProperty("content") fun content(content: String) = apply { this.content = content }

            /** The engagement's subject. */
            @JsonProperty("subject") fun subject(subject: String) = apply { this.subject = subject }

            /**
             * - `INBOUND` - INBOUND
             * - `OUTBOUND` - OUTBOUND
             */
            @JsonProperty("direction")
            fun direction(direction: DirectionEnum) = apply { this.direction = direction }

            /** The engagement type of the engagement. */
            @JsonProperty("engagement_type")
            fun engagementType(engagementType: String) = apply {
                this.engagementType = engagementType
            }

            /** The time at which the engagement started. */
            @JsonProperty("start_time")
            fun startTime(startTime: OffsetDateTime) = apply { this.startTime = startTime }

            /** The time at which the engagement ended. */
            @JsonProperty("end_time")
            fun endTime(endTime: OffsetDateTime) = apply { this.endTime = endTime }

            /** The account of the engagement. */
            @JsonProperty("account") fun account(account: String) = apply { this.account = account }

            @JsonProperty("contacts")
            fun contacts(contacts: List<String>) = apply { this.contacts = contacts }

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

            fun build(): EngagementRequest =
                EngagementRequest(
                    owner,
                    content,
                    subject,
                    direction,
                    engagementType,
                    startTime,
                    endTime,
                    account,
                    contacts?.toUnmodifiable(),
                    integrationParams,
                    linkedAccountParams,
                    remoteFields?.toUnmodifiable(),
                    additionalProperties.toUnmodifiable(),
                )
        }

        class DirectionEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is DirectionEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val INBOUND = DirectionEnum(JsonField.of("INBOUND"))

                @JvmField val OUTBOUND = DirectionEnum(JsonField.of("OUTBOUND"))

                @JvmStatic fun of(value: String) = DirectionEnum(JsonField.of(value))
            }

            enum class Known {
                INBOUND,
                OUTBOUND,
            }

            enum class Value {
                INBOUND,
                OUTBOUND,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    INBOUND -> Value.INBOUND
                    OUTBOUND -> Value.OUTBOUND
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    INBOUND -> Known.INBOUND
                    OUTBOUND -> Known.OUTBOUND
                    else -> throw MergeInvalidDataException("Unknown DirectionEnum: $value")
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
