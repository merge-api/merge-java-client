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
import java.util.Objects
import java.util.Optional

class ActivityCreateParams
constructor(
    private val model: ActivityRequest,
    private val remoteUserId: String,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): ActivityRequest = model

    fun remoteUserId(): String = remoteUserId

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): ActivityCreateBody {
        return ActivityCreateBody(
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

    @JsonDeserialize(builder = ActivityCreateBody.Builder::class)
    @NoAutoDetect
    class ActivityCreateBody
    internal constructor(
        private val model: ActivityRequest?,
        private val remoteUserId: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Activity Object
         *
         * ### Description
         *
         * The `Activity` object is used to represent an activity for a candidate performed by a
         * user.
         *
         * ### Usage Example
         *
         * Fetch from the `LIST Activities` endpoint and filter by `ID` to show all activities.
         */
        @JsonProperty("model") fun model(): ActivityRequest? = model

        @JsonProperty("remote_user_id") fun remoteUserId(): String? = remoteUserId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ActivityCreateBody &&
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
            "ActivityCreateBody{model=$model, remoteUserId=$remoteUserId, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: ActivityRequest? = null
            private var remoteUserId: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(activityCreateBody: ActivityCreateBody) = apply {
                this.model = activityCreateBody.model
                this.remoteUserId = activityCreateBody.remoteUserId
                additionalProperties(activityCreateBody.additionalProperties)
            }

            /**
             * # The Activity Object
             *
             * ### Description
             *
             * The `Activity` object is used to represent an activity for a candidate performed by a
             * user.
             *
             * ### Usage Example
             *
             * Fetch from the `LIST Activities` endpoint and filter by `ID` to show all activities.
             */
            @JsonProperty("model") fun model(model: ActivityRequest) = apply { this.model = model }

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

            fun build(): ActivityCreateBody =
                ActivityCreateBody(
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

        return other is ActivityCreateParams &&
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
        "ActivityCreateParams{model=$model, remoteUserId=$remoteUserId, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: ActivityRequest? = null
        private var remoteUserId: String? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(activityCreateParams: ActivityCreateParams) = apply {
            this.model = activityCreateParams.model
            this.remoteUserId = activityCreateParams.remoteUserId
            this.isDebugMode = activityCreateParams.isDebugMode
            this.runAsync = activityCreateParams.runAsync
            additionalQueryParams(activityCreateParams.additionalQueryParams)
            additionalHeaders(activityCreateParams.additionalHeaders)
            additionalBodyProperties(activityCreateParams.additionalBodyProperties)
        }

        /**
         * # The Activity Object
         *
         * ### Description
         *
         * The `Activity` object is used to represent an activity for a candidate performed by a
         * user.
         *
         * ### Usage Example
         *
         * Fetch from the `LIST Activities` endpoint and filter by `ID` to show all activities.
         */
        fun model(model: ActivityRequest) = apply { this.model = model }

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

        fun build(): ActivityCreateParams =
            ActivityCreateParams(
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
     * # The Activity Object
     *
     * ### Description
     *
     * The `Activity` object is used to represent an activity for a candidate performed by a user.
     *
     * ### Usage Example
     *
     * Fetch from the `LIST Activities` endpoint and filter by `ID` to show all activities.
     */
    @JsonDeserialize(builder = ActivityRequest.Builder::class)
    @NoAutoDetect
    class ActivityRequest
    private constructor(
        private val user: String?,
        private val activityType: ActivityTypeEnum?,
        private val subject: String?,
        private val body: String?,
        private val visibility: VisibilityEnum?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The user that performed the action. */
        @JsonProperty("user") fun user(): String? = user

        /**
         * - `CALL` - CALL
         * - `MEETING` - MEETING
         * - `EMAIL` - EMAIL
         */
        @JsonProperty("activity_type") fun activityType(): ActivityTypeEnum? = activityType

        /** The activity's subject. */
        @JsonProperty("subject") fun subject(): String? = subject

        /** The activity's body. */
        @JsonProperty("body") fun body(): String? = body

        /**
         * - `ADMIN_ONLY` - ADMIN_ONLY
         * - `PUBLIC` - PUBLIC
         * - `PRIVATE` - PRIVATE
         */
        @JsonProperty("visibility") fun visibility(): VisibilityEnum? = visibility

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

            return other is ActivityRequest &&
                this.user == other.user &&
                this.activityType == other.activityType &&
                this.subject == other.subject &&
                this.body == other.body &&
                this.visibility == other.visibility &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        user,
                        activityType,
                        subject,
                        body,
                        visibility,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ActivityRequest{user=$user, activityType=$activityType, subject=$subject, body=$body, visibility=$visibility, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var user: String? = null
            private var activityType: ActivityTypeEnum? = null
            private var subject: String? = null
            private var body: String? = null
            private var visibility: VisibilityEnum? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(activityRequest: ActivityRequest) = apply {
                this.user = activityRequest.user
                this.activityType = activityRequest.activityType
                this.subject = activityRequest.subject
                this.body = activityRequest.body
                this.visibility = activityRequest.visibility
                this.integrationParams = activityRequest.integrationParams
                this.linkedAccountParams = activityRequest.linkedAccountParams
                additionalProperties(activityRequest.additionalProperties)
            }

            /** The user that performed the action. */
            @JsonProperty("user") fun user(user: String) = apply { this.user = user }

            /**
             * - `CALL` - CALL
             * - `MEETING` - MEETING
             * - `EMAIL` - EMAIL
             */
            @JsonProperty("activity_type")
            fun activityType(activityType: ActivityTypeEnum) = apply {
                this.activityType = activityType
            }

            /** The activity's subject. */
            @JsonProperty("subject") fun subject(subject: String) = apply { this.subject = subject }

            /** The activity's body. */
            @JsonProperty("body") fun body(body: String) = apply { this.body = body }

            /**
             * - `ADMIN_ONLY` - ADMIN_ONLY
             * - `PUBLIC` - PUBLIC
             * - `PRIVATE` - PRIVATE
             */
            @JsonProperty("visibility")
            fun visibility(visibility: VisibilityEnum) = apply { this.visibility = visibility }

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

            fun build(): ActivityRequest =
                ActivityRequest(
                    user,
                    activityType,
                    subject,
                    body,
                    visibility,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class ActivityTypeEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ActivityTypeEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val CALL = ActivityTypeEnum(JsonField.of("CALL"))

                @JvmField val MEETING = ActivityTypeEnum(JsonField.of("MEETING"))

                @JvmField val EMAIL = ActivityTypeEnum(JsonField.of("EMAIL"))

                @JvmStatic fun of(value: String) = ActivityTypeEnum(JsonField.of(value))
            }

            enum class Known {
                CALL,
                MEETING,
                EMAIL,
            }

            enum class Value {
                CALL,
                MEETING,
                EMAIL,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    CALL -> Value.CALL
                    MEETING -> Value.MEETING
                    EMAIL -> Value.EMAIL
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    CALL -> Known.CALL
                    MEETING -> Known.MEETING
                    EMAIL -> Known.EMAIL
                    else -> throw MergeInvalidDataException("Unknown ActivityTypeEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }

        class VisibilityEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is VisibilityEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val ADMIN_ONLY = VisibilityEnum(JsonField.of("ADMIN_ONLY"))

                @JvmField val PUBLIC = VisibilityEnum(JsonField.of("PUBLIC"))

                @JvmField val PRIVATE = VisibilityEnum(JsonField.of("PRIVATE"))

                @JvmStatic fun of(value: String) = VisibilityEnum(JsonField.of(value))
            }

            enum class Known {
                ADMIN_ONLY,
                PUBLIC,
                PRIVATE,
            }

            enum class Value {
                ADMIN_ONLY,
                PUBLIC,
                PRIVATE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    ADMIN_ONLY -> Value.ADMIN_ONLY
                    PUBLIC -> Value.PUBLIC
                    PRIVATE -> Value.PRIVATE
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    ADMIN_ONLY -> Known.ADMIN_ONLY
                    PUBLIC -> Known.PUBLIC
                    PRIVATE -> Known.PRIVATE
                    else -> throw MergeInvalidDataException("Unknown VisibilityEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
