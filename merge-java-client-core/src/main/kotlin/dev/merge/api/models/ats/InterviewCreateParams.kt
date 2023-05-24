package dev.merge.api.models.ats

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

class InterviewCreateParams
constructor(
    private val model: ScheduledInterviewRequest,
    private val remoteUserId: String,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): ScheduledInterviewRequest = model

    fun remoteUserId(): String = remoteUserId

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): InterviewCreateBody {
        return InterviewCreateBody(
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

    @JsonDeserialize(builder = InterviewCreateBody.Builder::class)
    @NoAutoDetect
    class InterviewCreateBody
    internal constructor(
        private val model: ScheduledInterviewRequest?,
        private val remoteUserId: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The ScheduledInterview Object
         *
         * ### Description
         *
         * The `ScheduledInterview` object is used to represent a scheduled interview for a given
         * candidate’s application to a job. An `Application` can have multiple
         * `ScheduledInterview`s depending on the particular hiring process.
         *
         * ### Usage Example
         *
         * Fetch from the `LIST ScheduledInterviews` endpoint and filter by `interviewers` to show
         * all office locations.
         */
        @JsonProperty("model") fun model(): ScheduledInterviewRequest? = model

        @JsonProperty("remote_user_id") fun remoteUserId(): String? = remoteUserId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is InterviewCreateBody &&
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
            "InterviewCreateBody{model=$model, remoteUserId=$remoteUserId, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: ScheduledInterviewRequest? = null
            private var remoteUserId: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(interviewCreateBody: InterviewCreateBody) = apply {
                this.model = interviewCreateBody.model
                this.remoteUserId = interviewCreateBody.remoteUserId
                additionalProperties(interviewCreateBody.additionalProperties)
            }

            /**
             * # The ScheduledInterview Object
             *
             * ### Description
             *
             * The `ScheduledInterview` object is used to represent a scheduled interview for a
             * given candidate’s application to a job. An `Application` can have multiple
             * `ScheduledInterview`s depending on the particular hiring process.
             *
             * ### Usage Example
             *
             * Fetch from the `LIST ScheduledInterviews` endpoint and filter by `interviewers` to
             * show all office locations.
             */
            @JsonProperty("model")
            fun model(model: ScheduledInterviewRequest) = apply { this.model = model }

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

            fun build(): InterviewCreateBody =
                InterviewCreateBody(
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

        return other is InterviewCreateParams &&
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
        "InterviewCreateParams{model=$model, remoteUserId=$remoteUserId, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: ScheduledInterviewRequest? = null
        private var remoteUserId: String? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(interviewCreateParams: InterviewCreateParams) = apply {
            this.model = interviewCreateParams.model
            this.remoteUserId = interviewCreateParams.remoteUserId
            this.isDebugMode = interviewCreateParams.isDebugMode
            this.runAsync = interviewCreateParams.runAsync
            additionalQueryParams(interviewCreateParams.additionalQueryParams)
            additionalHeaders(interviewCreateParams.additionalHeaders)
            additionalBodyProperties(interviewCreateParams.additionalBodyProperties)
        }

        /**
         * # The ScheduledInterview Object
         *
         * ### Description
         *
         * The `ScheduledInterview` object is used to represent a scheduled interview for a given
         * candidate’s application to a job. An `Application` can have multiple
         * `ScheduledInterview`s depending on the particular hiring process.
         *
         * ### Usage Example
         *
         * Fetch from the `LIST ScheduledInterviews` endpoint and filter by `interviewers` to show
         * all office locations.
         */
        fun model(model: ScheduledInterviewRequest) = apply { this.model = model }

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

        fun build(): InterviewCreateParams =
            InterviewCreateParams(
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
     * # The ScheduledInterview Object
     *
     * ### Description
     *
     * The `ScheduledInterview` object is used to represent a scheduled interview for a given
     * candidate’s application to a job. An `Application` can have multiple `ScheduledInterview`s
     * depending on the particular hiring process.
     *
     * ### Usage Example
     *
     * Fetch from the `LIST ScheduledInterviews` endpoint and filter by `interviewers` to show all
     * office locations.
     */
    @JsonDeserialize(builder = ScheduledInterviewRequest.Builder::class)
    @NoAutoDetect
    class ScheduledInterviewRequest
    private constructor(
        private val application: String?,
        private val jobInterviewStage: String?,
        private val organizer: String?,
        private val interviewers: List<String>?,
        private val location: String?,
        private val startAt: OffsetDateTime?,
        private val endAt: OffsetDateTime?,
        private val status: ScheduledInterviewStatusEnum?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The application being interviewed. */
        @JsonProperty("application") fun application(): String? = application

        /** The stage of the interview. */
        @JsonProperty("job_interview_stage") fun jobInterviewStage(): String? = jobInterviewStage

        /** The user organizing the interview. */
        @JsonProperty("organizer") fun organizer(): String? = organizer

        /** Array of `RemoteUser` IDs. */
        @JsonProperty("interviewers") fun interviewers(): List<String>? = interviewers

        /** The interview's location. */
        @JsonProperty("location") fun location(): String? = location

        /** When the interview was started. */
        @JsonProperty("start_at") fun startAt(): OffsetDateTime? = startAt

        /** When the interview was ended. */
        @JsonProperty("end_at") fun endAt(): OffsetDateTime? = endAt

        /**
         * - `SCHEDULED` - SCHEDULED
         * - `AWAITING_FEEDBACK` - AWAITING_FEEDBACK
         * - `COMPLETE` - COMPLETE
         */
        @JsonProperty("status") fun status(): ScheduledInterviewStatusEnum? = status

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

            return other is ScheduledInterviewRequest &&
                this.application == other.application &&
                this.jobInterviewStage == other.jobInterviewStage &&
                this.organizer == other.organizer &&
                this.interviewers == other.interviewers &&
                this.location == other.location &&
                this.startAt == other.startAt &&
                this.endAt == other.endAt &&
                this.status == other.status &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        application,
                        jobInterviewStage,
                        organizer,
                        interviewers,
                        location,
                        startAt,
                        endAt,
                        status,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ScheduledInterviewRequest{application=$application, jobInterviewStage=$jobInterviewStage, organizer=$organizer, interviewers=$interviewers, location=$location, startAt=$startAt, endAt=$endAt, status=$status, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var application: String? = null
            private var jobInterviewStage: String? = null
            private var organizer: String? = null
            private var interviewers: List<String>? = null
            private var location: String? = null
            private var startAt: OffsetDateTime? = null
            private var endAt: OffsetDateTime? = null
            private var status: ScheduledInterviewStatusEnum? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(scheduledInterviewRequest: ScheduledInterviewRequest) = apply {
                this.application = scheduledInterviewRequest.application
                this.jobInterviewStage = scheduledInterviewRequest.jobInterviewStage
                this.organizer = scheduledInterviewRequest.organizer
                this.interviewers = scheduledInterviewRequest.interviewers
                this.location = scheduledInterviewRequest.location
                this.startAt = scheduledInterviewRequest.startAt
                this.endAt = scheduledInterviewRequest.endAt
                this.status = scheduledInterviewRequest.status
                this.integrationParams = scheduledInterviewRequest.integrationParams
                this.linkedAccountParams = scheduledInterviewRequest.linkedAccountParams
                additionalProperties(scheduledInterviewRequest.additionalProperties)
            }

            /** The application being interviewed. */
            @JsonProperty("application")
            fun application(application: String) = apply { this.application = application }

            /** The stage of the interview. */
            @JsonProperty("job_interview_stage")
            fun jobInterviewStage(jobInterviewStage: String) = apply {
                this.jobInterviewStage = jobInterviewStage
            }

            /** The user organizing the interview. */
            @JsonProperty("organizer")
            fun organizer(organizer: String) = apply { this.organizer = organizer }

            /** Array of `RemoteUser` IDs. */
            @JsonProperty("interviewers")
            fun interviewers(interviewers: List<String>) = apply {
                this.interviewers = interviewers
            }

            /** The interview's location. */
            @JsonProperty("location")
            fun location(location: String) = apply { this.location = location }

            /** When the interview was started. */
            @JsonProperty("start_at")
            fun startAt(startAt: OffsetDateTime) = apply { this.startAt = startAt }

            /** When the interview was ended. */
            @JsonProperty("end_at") fun endAt(endAt: OffsetDateTime) = apply { this.endAt = endAt }

            /**
             * - `SCHEDULED` - SCHEDULED
             * - `AWAITING_FEEDBACK` - AWAITING_FEEDBACK
             * - `COMPLETE` - COMPLETE
             */
            @JsonProperty("status")
            fun status(status: ScheduledInterviewStatusEnum) = apply { this.status = status }

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

            fun build(): ScheduledInterviewRequest =
                ScheduledInterviewRequest(
                    application,
                    jobInterviewStage,
                    organizer,
                    interviewers?.toUnmodifiable(),
                    location,
                    startAt,
                    endAt,
                    status,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class ScheduledInterviewStatusEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ScheduledInterviewStatusEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val SCHEDULED = ScheduledInterviewStatusEnum(JsonField.of("SCHEDULED"))

                @JvmField
                val AWAITING_FEEDBACK =
                    ScheduledInterviewStatusEnum(JsonField.of("AWAITING_FEEDBACK"))

                @JvmField val COMPLETE = ScheduledInterviewStatusEnum(JsonField.of("COMPLETE"))

                @JvmStatic fun of(value: String) = ScheduledInterviewStatusEnum(JsonField.of(value))
            }

            enum class Known {
                SCHEDULED,
                AWAITING_FEEDBACK,
                COMPLETE,
            }

            enum class Value {
                SCHEDULED,
                AWAITING_FEEDBACK,
                COMPLETE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    SCHEDULED -> Value.SCHEDULED
                    AWAITING_FEEDBACK -> Value.AWAITING_FEEDBACK
                    COMPLETE -> Value.COMPLETE
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    SCHEDULED -> Known.SCHEDULED
                    AWAITING_FEEDBACK -> Known.AWAITING_FEEDBACK
                    COMPLETE -> Known.COMPLETE
                    else ->
                        throw MergeInvalidDataException(
                            "Unknown ScheduledInterviewStatusEnum: $value"
                        )
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
