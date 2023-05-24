package dev.merge.api.models.marketing

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.models.*
import java.util.Objects
import java.util.Optional

class CampaignCreateParams
constructor(
    private val model: CampaignRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): CampaignRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): CampaignCreateBody {
        return CampaignCreateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = CampaignCreateBody.Builder::class)
    @NoAutoDetect
    class CampaignCreateBody
    internal constructor(
        private val model: CampaignRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Campaign Object
         *
         * ### Description
         *
         * The `Campaign` object is used to represent a marketing campaign in the remote system.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/mktg/v1/campaigns` endpoint and view their unique opens.
         */
        @JsonProperty("model") fun model(): CampaignRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CampaignCreateBody &&
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
            "CampaignCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: CampaignRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(campaignCreateBody: CampaignCreateBody) = apply {
                this.model = campaignCreateBody.model
                additionalProperties(campaignCreateBody.additionalProperties)
            }

            /**
             * # The Campaign Object
             *
             * ### Description
             *
             * The `Campaign` object is used to represent a marketing campaign in the remote system.
             *
             * ### Usage Example
             *
             * Fetch from the `GET /api/mktg/v1/campaigns` endpoint and view their unique opens.
             */
            @JsonProperty("model") fun model(model: CampaignRequest) = apply { this.model = model }

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

            fun build(): CampaignCreateBody =
                CampaignCreateBody(
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

        return other is CampaignCreateParams &&
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
        "CampaignCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: CampaignRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(campaignCreateParams: CampaignCreateParams) = apply {
            this.model = campaignCreateParams.model
            this.isDebugMode = campaignCreateParams.isDebugMode
            this.runAsync = campaignCreateParams.runAsync
            additionalQueryParams(campaignCreateParams.additionalQueryParams)
            additionalHeaders(campaignCreateParams.additionalHeaders)
            additionalBodyProperties(campaignCreateParams.additionalBodyProperties)
        }

        /**
         * # The Campaign Object
         *
         * ### Description
         *
         * The `Campaign` object is used to represent a marketing campaign in the remote system.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/mktg/v1/campaigns` endpoint and view their unique opens.
         */
        fun model(model: CampaignRequest) = apply { this.model = model }

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

        fun build(): CampaignCreateParams =
            CampaignCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Campaign Object
     *
     * ### Description
     *
     * The `Campaign` object is used to represent a marketing campaign in the remote system.
     *
     * ### Usage Example
     *
     * Fetch from the `GET /api/mktg/v1/campaigns` endpoint and view their unique opens.
     */
    @JsonDeserialize(builder = CampaignRequest.Builder::class)
    @NoAutoDetect
    class CampaignRequest
    private constructor(
        private val name: String?,
        private val uniqueOpens: Long?,
        private val emailsSent: Long?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The campaign's name. */
        @JsonProperty("name") fun name(): String? = name

        /** The campaign's unique opens. */
        @JsonProperty("unique_opens") fun uniqueOpens(): Long? = uniqueOpens

        /** The campaign's number of emails sent. */
        @JsonProperty("emails_sent") fun emailsSent(): Long? = emailsSent

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

            return other is CampaignRequest &&
                this.name == other.name &&
                this.uniqueOpens == other.uniqueOpens &&
                this.emailsSent == other.emailsSent &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        name,
                        uniqueOpens,
                        emailsSent,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CampaignRequest{name=$name, uniqueOpens=$uniqueOpens, emailsSent=$emailsSent, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var uniqueOpens: Long? = null
            private var emailsSent: Long? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(campaignRequest: CampaignRequest) = apply {
                this.name = campaignRequest.name
                this.uniqueOpens = campaignRequest.uniqueOpens
                this.emailsSent = campaignRequest.emailsSent
                this.integrationParams = campaignRequest.integrationParams
                this.linkedAccountParams = campaignRequest.linkedAccountParams
                additionalProperties(campaignRequest.additionalProperties)
            }

            /** The campaign's name. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /** The campaign's unique opens. */
            @JsonProperty("unique_opens")
            fun uniqueOpens(uniqueOpens: Long) = apply { this.uniqueOpens = uniqueOpens }

            /** The campaign's number of emails sent. */
            @JsonProperty("emails_sent")
            fun emailsSent(emailsSent: Long) = apply { this.emailsSent = emailsSent }

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

            fun build(): CampaignRequest =
                CampaignRequest(
                    name,
                    uniqueOpens,
                    emailsSent,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
