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
import java.util.Objects
import java.util.Optional

class ApplicationChangeStageParams
constructor(
    private val id: String,
    private val jobInterviewStage: String?,
    private val remoteUserId: String?,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun id(): String = id

    fun jobInterviewStage(): Optional<String> = Optional.ofNullable(jobInterviewStage)

    fun remoteUserId(): Optional<String> = Optional.ofNullable(remoteUserId)

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): ApplicationChangeStageBody {
        return ApplicationChangeStageBody(
            jobInterviewStage,
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

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> id
            else -> ""
        }
    }

    @JsonDeserialize(builder = ApplicationChangeStageBody.Builder::class)
    @NoAutoDetect
    class ApplicationChangeStageBody
    internal constructor(
        private val jobInterviewStage: String?,
        private val remoteUserId: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The interview stage to move the application to. */
        @JsonProperty("job_interview_stage") fun jobInterviewStage(): String? = jobInterviewStage

        @JsonProperty("remote_user_id") fun remoteUserId(): String? = remoteUserId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ApplicationChangeStageBody &&
                this.jobInterviewStage == other.jobInterviewStage &&
                this.remoteUserId == other.remoteUserId &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        jobInterviewStage,
                        remoteUserId,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ApplicationChangeStageBody{jobInterviewStage=$jobInterviewStage, remoteUserId=$remoteUserId, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var jobInterviewStage: String? = null
            private var remoteUserId: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(applicationChangeStageBody: ApplicationChangeStageBody) = apply {
                this.jobInterviewStage = applicationChangeStageBody.jobInterviewStage
                this.remoteUserId = applicationChangeStageBody.remoteUserId
                additionalProperties(applicationChangeStageBody.additionalProperties)
            }

            /** The interview stage to move the application to. */
            @JsonProperty("job_interview_stage")
            fun jobInterviewStage(jobInterviewStage: String) = apply {
                this.jobInterviewStage = jobInterviewStage
            }

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

            fun build(): ApplicationChangeStageBody =
                ApplicationChangeStageBody(
                    jobInterviewStage,
                    remoteUserId,
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

        return other is ApplicationChangeStageParams &&
            this.id == other.id &&
            this.jobInterviewStage == other.jobInterviewStage &&
            this.remoteUserId == other.remoteUserId &&
            this.isDebugMode == other.isDebugMode &&
            this.runAsync == other.runAsync &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            id,
            jobInterviewStage,
            remoteUserId,
            isDebugMode,
            runAsync,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "ApplicationChangeStageParams{id=$id, jobInterviewStage=$jobInterviewStage, remoteUserId=$remoteUserId, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var jobInterviewStage: String? = null
        private var remoteUserId: String? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(applicationChangeStageParams: ApplicationChangeStageParams) = apply {
            this.id = applicationChangeStageParams.id
            this.jobInterviewStage = applicationChangeStageParams.jobInterviewStage
            this.remoteUserId = applicationChangeStageParams.remoteUserId
            this.isDebugMode = applicationChangeStageParams.isDebugMode
            this.runAsync = applicationChangeStageParams.runAsync
            additionalQueryParams(applicationChangeStageParams.additionalQueryParams)
            additionalHeaders(applicationChangeStageParams.additionalHeaders)
            additionalBodyProperties(applicationChangeStageParams.additionalBodyProperties)
        }

        fun id(id: String) = apply { this.id = id }

        /** The interview stage to move the application to. */
        fun jobInterviewStage(jobInterviewStage: String) = apply {
            this.jobInterviewStage = jobInterviewStage
        }

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

        fun build(): ApplicationChangeStageParams =
            ApplicationChangeStageParams(
                checkNotNull(id) { "`id` is required but was not set" },
                jobInterviewStage,
                remoteUserId,
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }
}
