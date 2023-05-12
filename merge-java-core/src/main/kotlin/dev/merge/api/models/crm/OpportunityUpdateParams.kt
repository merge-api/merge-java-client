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

class OpportunityUpdateParams
constructor(
    private val id: String,
    private val model: PatchedOpportunityRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun id(): String = id

    fun model(): PatchedOpportunityRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): OpportunityUpdateBody {
        return OpportunityUpdateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = OpportunityUpdateBody.Builder::class)
    @NoAutoDetect
    class OpportunityUpdateBody
    internal constructor(
        private val model: PatchedOpportunityRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Opportunity Object
         *
         * ### Description
         *
         * The `Opportunity` object is used to represent a deal opportunity in a CRM system.
         *
         * ### Usage Example
         *
         * TODO
         */
        @JsonProperty("model") fun model(): PatchedOpportunityRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OpportunityUpdateBody &&
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
            "OpportunityUpdateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: PatchedOpportunityRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(opportunityUpdateBody: OpportunityUpdateBody) = apply {
                this.model = opportunityUpdateBody.model
                additionalProperties(opportunityUpdateBody.additionalProperties)
            }

            /**
             * # The Opportunity Object
             *
             * ### Description
             *
             * The `Opportunity` object is used to represent a deal opportunity in a CRM system.
             *
             * ### Usage Example
             *
             * TODO
             */
            @JsonProperty("model")
            fun model(model: PatchedOpportunityRequest) = apply { this.model = model }

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

            fun build(): OpportunityUpdateBody =
                OpportunityUpdateBody(
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

        return other is OpportunityUpdateParams &&
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
        "OpportunityUpdateParams{id=$id, model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var model: PatchedOpportunityRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(opportunityUpdateParams: OpportunityUpdateParams) = apply {
            this.id = opportunityUpdateParams.id
            this.model = opportunityUpdateParams.model
            this.isDebugMode = opportunityUpdateParams.isDebugMode
            this.runAsync = opportunityUpdateParams.runAsync
            additionalQueryParams(opportunityUpdateParams.additionalQueryParams)
            additionalHeaders(opportunityUpdateParams.additionalHeaders)
            additionalBodyProperties(opportunityUpdateParams.additionalBodyProperties)
        }

        fun id(id: String) = apply { this.id = id }

        /**
         * # The Opportunity Object
         *
         * ### Description
         *
         * The `Opportunity` object is used to represent a deal opportunity in a CRM system.
         *
         * ### Usage Example
         *
         * TODO
         */
        fun model(model: PatchedOpportunityRequest) = apply { this.model = model }

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

        fun build(): OpportunityUpdateParams =
            OpportunityUpdateParams(
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
     * # The Opportunity Object
     *
     * ### Description
     *
     * The `Opportunity` object is used to represent a deal opportunity in a CRM system.
     *
     * ### Usage Example
     *
     * TODO
     */
    @JsonDeserialize(builder = PatchedOpportunityRequest.Builder::class)
    @NoAutoDetect
    class PatchedOpportunityRequest
    private constructor(
        private val name: String?,
        private val description: String?,
        private val amount: Long?,
        private val owner: String?,
        private val account: String?,
        private val stage: String?,
        private val status: OpportunityStatusEnum?,
        private val lastActivityAt: OffsetDateTime?,
        private val closeDate: OffsetDateTime?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The opportunity's name. */
        @JsonProperty("name") fun name(): String? = name

        /** The opportunity's description. */
        @JsonProperty("description") fun description(): String? = description

        /** The opportunity's amount. */
        @JsonProperty("amount") fun amount(): Long? = amount

        /** The opportunity's owner. */
        @JsonProperty("owner") fun owner(): String? = owner

        /** The account of the opportunity. */
        @JsonProperty("account") fun account(): String? = account

        /** The stage of the opportunity. */
        @JsonProperty("stage") fun stage(): String? = stage

        /**
         * - `OPEN` - OPEN
         * - `WON` - WON
         * - `LOST` - LOST
         */
        @JsonProperty("status") fun status(): OpportunityStatusEnum? = status

        /** When the opportunity's last activity occurred. */
        @JsonProperty("last_activity_at") fun lastActivityAt(): OffsetDateTime? = lastActivityAt

        /** When the opportunity was closed. */
        @JsonProperty("close_date") fun closeDate(): OffsetDateTime? = closeDate

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

            return other is PatchedOpportunityRequest &&
                this.name == other.name &&
                this.description == other.description &&
                this.amount == other.amount &&
                this.owner == other.owner &&
                this.account == other.account &&
                this.stage == other.stage &&
                this.status == other.status &&
                this.lastActivityAt == other.lastActivityAt &&
                this.closeDate == other.closeDate &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        name,
                        description,
                        amount,
                        owner,
                        account,
                        stage,
                        status,
                        lastActivityAt,
                        closeDate,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "PatchedOpportunityRequest{name=$name, description=$description, amount=$amount, owner=$owner, account=$account, stage=$stage, status=$status, lastActivityAt=$lastActivityAt, closeDate=$closeDate, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var description: String? = null
            private var amount: Long? = null
            private var owner: String? = null
            private var account: String? = null
            private var stage: String? = null
            private var status: OpportunityStatusEnum? = null
            private var lastActivityAt: OffsetDateTime? = null
            private var closeDate: OffsetDateTime? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(patchedOpportunityRequest: PatchedOpportunityRequest) = apply {
                this.name = patchedOpportunityRequest.name
                this.description = patchedOpportunityRequest.description
                this.amount = patchedOpportunityRequest.amount
                this.owner = patchedOpportunityRequest.owner
                this.account = patchedOpportunityRequest.account
                this.stage = patchedOpportunityRequest.stage
                this.status = patchedOpportunityRequest.status
                this.lastActivityAt = patchedOpportunityRequest.lastActivityAt
                this.closeDate = patchedOpportunityRequest.closeDate
                this.integrationParams = patchedOpportunityRequest.integrationParams
                this.linkedAccountParams = patchedOpportunityRequest.linkedAccountParams
                additionalProperties(patchedOpportunityRequest.additionalProperties)
            }

            /** The opportunity's name. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /** The opportunity's description. */
            @JsonProperty("description")
            fun description(description: String) = apply { this.description = description }

            /** The opportunity's amount. */
            @JsonProperty("amount") fun amount(amount: Long) = apply { this.amount = amount }

            /** The opportunity's owner. */
            @JsonProperty("owner") fun owner(owner: String) = apply { this.owner = owner }

            /** The account of the opportunity. */
            @JsonProperty("account") fun account(account: String) = apply { this.account = account }

            /** The stage of the opportunity. */
            @JsonProperty("stage") fun stage(stage: String) = apply { this.stage = stage }

            /**
             * - `OPEN` - OPEN
             * - `WON` - WON
             * - `LOST` - LOST
             */
            @JsonProperty("status")
            fun status(status: OpportunityStatusEnum) = apply { this.status = status }

            /** When the opportunity's last activity occurred. */
            @JsonProperty("last_activity_at")
            fun lastActivityAt(lastActivityAt: OffsetDateTime) = apply {
                this.lastActivityAt = lastActivityAt
            }

            /** When the opportunity was closed. */
            @JsonProperty("close_date")
            fun closeDate(closeDate: OffsetDateTime) = apply { this.closeDate = closeDate }

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

            fun build(): PatchedOpportunityRequest =
                PatchedOpportunityRequest(
                    name,
                    description,
                    amount,
                    owner,
                    account,
                    stage,
                    status,
                    lastActivityAt,
                    closeDate,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class OpportunityStatusEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is OpportunityStatusEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val OPEN = OpportunityStatusEnum(JsonField.of("OPEN"))

                @JvmField val WON = OpportunityStatusEnum(JsonField.of("WON"))

                @JvmField val LOST = OpportunityStatusEnum(JsonField.of("LOST"))

                @JvmStatic fun of(value: String) = OpportunityStatusEnum(JsonField.of(value))
            }

            enum class Known {
                OPEN,
                WON,
                LOST,
            }

            enum class Value {
                OPEN,
                WON,
                LOST,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    OPEN -> Value.OPEN
                    WON -> Value.WON
                    LOST -> Value.LOST
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    OPEN -> Known.OPEN
                    WON -> Known.WON
                    LOST -> Known.LOST
                    else -> throw MergeInvalidDataException("Unknown OpportunityStatusEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
