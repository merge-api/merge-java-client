package dev.merge.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import java.util.Objects

@JsonDeserialize(builder = DebugLog.Builder::class)
@NoAutoDetect
class DebugLog
private constructor(
    private val logId: JsonField<String>,
    private val dashboardView: JsonField<String>,
    private val logSummary: JsonField<DebugModelLogSummary>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun logId(): String = logId.getRequired("log_id")

    fun dashboardView(): String = dashboardView.getRequired("dashboard_view")

    fun logSummary(): DebugModelLogSummary = logSummary.getRequired("log_summary")

    @JsonProperty("log_id") @ExcludeMissing fun _logId() = logId

    @JsonProperty("dashboard_view") @ExcludeMissing fun _dashboardView() = dashboardView

    @JsonProperty("log_summary") @ExcludeMissing fun _logSummary() = logSummary

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): DebugLog = apply {
        if (!validated) {
            logId()
            dashboardView()
            logSummary().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DebugLog &&
            this.logId == other.logId &&
            this.dashboardView == other.dashboardView &&
            this.logSummary == other.logSummary &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    logId,
                    dashboardView,
                    logSummary,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "DebugLog{logId=$logId, dashboardView=$dashboardView, logSummary=$logSummary, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var logId: JsonField<String> = JsonMissing.of()
        private var dashboardView: JsonField<String> = JsonMissing.of()
        private var logSummary: JsonField<DebugModelLogSummary> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(debugLog: DebugLog) = apply {
            this.logId = debugLog.logId
            this.dashboardView = debugLog.dashboardView
            this.logSummary = debugLog.logSummary
            additionalProperties(debugLog.additionalProperties)
        }

        fun logId(logId: String) = logId(JsonField.of(logId))

        @JsonProperty("log_id")
        @ExcludeMissing
        fun logId(logId: JsonField<String>) = apply { this.logId = logId }

        fun dashboardView(dashboardView: String) = dashboardView(JsonField.of(dashboardView))

        @JsonProperty("dashboard_view")
        @ExcludeMissing
        fun dashboardView(dashboardView: JsonField<String>) = apply {
            this.dashboardView = dashboardView
        }

        fun logSummary(logSummary: DebugModelLogSummary) = logSummary(JsonField.of(logSummary))

        @JsonProperty("log_summary")
        @ExcludeMissing
        fun logSummary(logSummary: JsonField<DebugModelLogSummary>) = apply {
            this.logSummary = logSummary
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

        fun build(): DebugLog =
            DebugLog(
                logId,
                dashboardView,
                logSummary,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = DebugModelLogSummary.Builder::class)
    @NoAutoDetect
    class DebugModelLogSummary
    private constructor(
        private val url: JsonField<String>,
        private val method: JsonField<String>,
        private val statusCode: JsonField<Long>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun url(): String = url.getRequired("url")

        fun method(): String = method.getRequired("method")

        fun statusCode(): Long = statusCode.getRequired("status_code")

        @JsonProperty("url") @ExcludeMissing fun _url() = url

        @JsonProperty("method") @ExcludeMissing fun _method() = method

        @JsonProperty("status_code") @ExcludeMissing fun _statusCode() = statusCode

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): DebugModelLogSummary = apply {
            if (!validated) {
                url()
                method()
                statusCode()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DebugModelLogSummary &&
                this.url == other.url &&
                this.method == other.method &&
                this.statusCode == other.statusCode &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        url,
                        method,
                        statusCode,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "DebugModelLogSummary{url=$url, method=$method, statusCode=$statusCode, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var url: JsonField<String> = JsonMissing.of()
            private var method: JsonField<String> = JsonMissing.of()
            private var statusCode: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(debugModelLogSummary: DebugModelLogSummary) = apply {
                this.url = debugModelLogSummary.url
                this.method = debugModelLogSummary.method
                this.statusCode = debugModelLogSummary.statusCode
                additionalProperties(debugModelLogSummary.additionalProperties)
            }

            fun url(url: String) = url(JsonField.of(url))

            @JsonProperty("url")
            @ExcludeMissing
            fun url(url: JsonField<String>) = apply { this.url = url }

            fun method(method: String) = method(JsonField.of(method))

            @JsonProperty("method")
            @ExcludeMissing
            fun method(method: JsonField<String>) = apply { this.method = method }

            fun statusCode(statusCode: Long) = statusCode(JsonField.of(statusCode))

            @JsonProperty("status_code")
            @ExcludeMissing
            fun statusCode(statusCode: JsonField<Long>) = apply { this.statusCode = statusCode }

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

            fun build(): DebugModelLogSummary =
                DebugModelLogSummary(
                    url,
                    method,
                    statusCode,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
