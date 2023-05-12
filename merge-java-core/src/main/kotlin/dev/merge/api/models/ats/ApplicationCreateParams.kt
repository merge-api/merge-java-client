package dev.merge.api.models.ats

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.models.*
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

class ApplicationCreateParams
constructor(
    private val model: ApplicationRequest,
    private val remoteUserId: String,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): ApplicationRequest = model

    fun remoteUserId(): String = remoteUserId

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): ApplicationCreateBody {
        return ApplicationCreateBody(
            model,
            remoteUserId,
            additionalBodyProperties,
        )
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

    @JsonDeserialize(builder = ApplicationCreateBody.Builder::class)
    @NoAutoDetect
    class ApplicationCreateBody
    internal constructor(
        private val model: ApplicationRequest?,
        private val remoteUserId: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Application Object
         *
         * ### Description
         *
         * The Application Object is used to represent a candidate's journey through a particular
         * Job's recruiting process. If a Candidate applies for multiple Jobs, there will be a
         * separate Application for each Job if the third-party integration allows it.
         *
         * ### Usage Example
         *
         * Fetch from the `LIST Applications` endpoint and filter by `ID` to show all applications.
         */
        @JsonProperty("model") fun model(): ApplicationRequest? = model

        @JsonProperty("remote_user_id") fun remoteUserId(): String? = remoteUserId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ApplicationCreateBody &&
                this.model == other.model &&
                this.remoteUserId == other.remoteUserId &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        model,
                        remoteUserId,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ApplicationCreateBody{model=$model, remoteUserId=$remoteUserId, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: ApplicationRequest? = null
            private var remoteUserId: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(applicationCreateBody: ApplicationCreateBody) = apply {
                this.model = applicationCreateBody.model
                this.remoteUserId = applicationCreateBody.remoteUserId
                additionalProperties(applicationCreateBody.additionalProperties)
            }

            /**
             * # The Application Object
             *
             * ### Description
             *
             * The Application Object is used to represent a candidate's journey through a
             * particular Job's recruiting process. If a Candidate applies for multiple Jobs, there
             * will be a separate Application for each Job if the third-party integration allows it.
             *
             * ### Usage Example
             *
             * Fetch from the `LIST Applications` endpoint and filter by `ID` to show all
             * applications.
             */
            @JsonProperty("model")
            fun model(model: ApplicationRequest) = apply { this.model = model }

            @JsonProperty("remote_user_id")
            fun remoteUserId(remoteUserId: String) = apply { this.remoteUserId = remoteUserId }

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

            fun build(): ApplicationCreateBody =
                ApplicationCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    checkNotNull(remoteUserId) { "`remoteUserId` is required but was not set" },
                    additionalProperties.toUnmodifiable(),
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

        return other is ApplicationCreateParams &&
            this.model == other.model &&
            this.remoteUserId == other.remoteUserId &&
            this.isDebugMode == other.isDebugMode &&
            this.runAsync == other.runAsync &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            remoteUserId,
            isDebugMode,
            runAsync,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "ApplicationCreateParams{model=$model, remoteUserId=$remoteUserId, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: ApplicationRequest? = null
        private var remoteUserId: String? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(applicationCreateParams: ApplicationCreateParams) = apply {
            this.model = applicationCreateParams.model
            this.remoteUserId = applicationCreateParams.remoteUserId
            this.isDebugMode = applicationCreateParams.isDebugMode
            this.runAsync = applicationCreateParams.runAsync
            additionalQueryParams(applicationCreateParams.additionalQueryParams)
            additionalHeaders(applicationCreateParams.additionalHeaders)
            additionalBodyProperties(applicationCreateParams.additionalBodyProperties)
        }

        /**
         * # The Application Object
         *
         * ### Description
         *
         * The Application Object is used to represent a candidate's journey through a particular
         * Job's recruiting process. If a Candidate applies for multiple Jobs, there will be a
         * separate Application for each Job if the third-party integration allows it.
         *
         * ### Usage Example
         *
         * Fetch from the `LIST Applications` endpoint and filter by `ID` to show all applications.
         */
        fun model(model: ApplicationRequest) = apply { this.model = model }

        fun remoteUserId(remoteUserId: String) = apply { this.remoteUserId = remoteUserId }

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

        fun build(): ApplicationCreateParams =
            ApplicationCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                checkNotNull(remoteUserId) { "`remoteUserId` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Application Object
     *
     * ### Description
     *
     * The Application Object is used to represent a candidate's journey through a particular Job's
     * recruiting process. If a Candidate applies for multiple Jobs, there will be a separate
     * Application for each Job if the third-party integration allows it.
     *
     * ### Usage Example
     *
     * Fetch from the `LIST Applications` endpoint and filter by `ID` to show all applications.
     */
    @JsonDeserialize(builder = ApplicationRequest.Builder::class)
    @NoAutoDetect
    class ApplicationRequest
    private constructor(
        private val candidate: String?,
        private val job: String?,
        private val appliedAt: OffsetDateTime?,
        private val rejectedAt: OffsetDateTime?,
        private val source: String?,
        private val creditedTo: String?,
        private val currentStage: String?,
        private val rejectReason: String?,
        private val remoteTemplateId: String?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The candidate applying. */
        @JsonProperty("candidate") fun candidate(): String? = candidate

        /** The job being applied for. */
        @JsonProperty("job") fun job(): String? = job

        /** When the application was submitted. */
        @JsonProperty("applied_at") fun appliedAt(): OffsetDateTime? = appliedAt

        /** When the application was rejected. */
        @JsonProperty("rejected_at") fun rejectedAt(): OffsetDateTime? = rejectedAt

        /** The application's source. */
        @JsonProperty("source") fun source(): String? = source

        /** The user credited for this application. */
        @JsonProperty("credited_to") fun creditedTo(): String? = creditedTo

        /** The application's current stage. */
        @JsonProperty("current_stage") fun currentStage(): String? = currentStage

        /** The application's reason for rejection. */
        @JsonProperty("reject_reason") fun rejectReason(): String? = rejectReason

        @JsonProperty("remote_template_id") fun remoteTemplateId(): String? = remoteTemplateId

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

            return other is ApplicationRequest &&
                this.candidate == other.candidate &&
                this.job == other.job &&
                this.appliedAt == other.appliedAt &&
                this.rejectedAt == other.rejectedAt &&
                this.source == other.source &&
                this.creditedTo == other.creditedTo &&
                this.currentStage == other.currentStage &&
                this.rejectReason == other.rejectReason &&
                this.remoteTemplateId == other.remoteTemplateId &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        candidate,
                        job,
                        appliedAt,
                        rejectedAt,
                        source,
                        creditedTo,
                        currentStage,
                        rejectReason,
                        remoteTemplateId,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ApplicationRequest{candidate=$candidate, job=$job, appliedAt=$appliedAt, rejectedAt=$rejectedAt, source=$source, creditedTo=$creditedTo, currentStage=$currentStage, rejectReason=$rejectReason, remoteTemplateId=$remoteTemplateId, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var candidate: String? = null
            private var job: String? = null
            private var appliedAt: OffsetDateTime? = null
            private var rejectedAt: OffsetDateTime? = null
            private var source: String? = null
            private var creditedTo: String? = null
            private var currentStage: String? = null
            private var rejectReason: String? = null
            private var remoteTemplateId: String? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(applicationRequest: ApplicationRequest) = apply {
                this.candidate = applicationRequest.candidate
                this.job = applicationRequest.job
                this.appliedAt = applicationRequest.appliedAt
                this.rejectedAt = applicationRequest.rejectedAt
                this.source = applicationRequest.source
                this.creditedTo = applicationRequest.creditedTo
                this.currentStage = applicationRequest.currentStage
                this.rejectReason = applicationRequest.rejectReason
                this.remoteTemplateId = applicationRequest.remoteTemplateId
                this.integrationParams = applicationRequest.integrationParams
                this.linkedAccountParams = applicationRequest.linkedAccountParams
                additionalProperties(applicationRequest.additionalProperties)
            }

            /** The candidate applying. */
            @JsonProperty("candidate")
            fun candidate(candidate: String) = apply { this.candidate = candidate }

            /** The job being applied for. */
            @JsonProperty("job") fun job(job: String) = apply { this.job = job }

            /** When the application was submitted. */
            @JsonProperty("applied_at")
            fun appliedAt(appliedAt: OffsetDateTime) = apply { this.appliedAt = appliedAt }

            /** When the application was rejected. */
            @JsonProperty("rejected_at")
            fun rejectedAt(rejectedAt: OffsetDateTime) = apply { this.rejectedAt = rejectedAt }

            /** The application's source. */
            @JsonProperty("source") fun source(source: String) = apply { this.source = source }

            /** The user credited for this application. */
            @JsonProperty("credited_to")
            fun creditedTo(creditedTo: String) = apply { this.creditedTo = creditedTo }

            /** The application's current stage. */
            @JsonProperty("current_stage")
            fun currentStage(currentStage: String) = apply { this.currentStage = currentStage }

            /** The application's reason for rejection. */
            @JsonProperty("reject_reason")
            fun rejectReason(rejectReason: String) = apply { this.rejectReason = rejectReason }

            @JsonProperty("remote_template_id")
            fun remoteTemplateId(remoteTemplateId: String) = apply {
                this.remoteTemplateId = remoteTemplateId
            }

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

            fun build(): ApplicationRequest =
                ApplicationRequest(
                    candidate,
                    job,
                    appliedAt,
                    rejectedAt,
                    source,
                    creditedTo,
                    currentStage,
                    rejectReason,
                    remoteTemplateId,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
