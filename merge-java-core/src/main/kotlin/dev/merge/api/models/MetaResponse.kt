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
import java.util.Optional

@JsonDeserialize(builder = MetaResponse.Builder::class)
@NoAutoDetect
class MetaResponse
private constructor(
    private val requestSchema: JsonValue,
    private val remoteFieldClasses: JsonValue,
    private val status: JsonField<LinkedAccountStatus>,
    private val hasConditionalParams: JsonField<Boolean>,
    private val hasRequiredLinkedAccountParams: JsonField<Boolean>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun status(): Optional<LinkedAccountStatus> = Optional.ofNullable(status.getNullable("status"))

    fun hasConditionalParams(): Boolean = hasConditionalParams.getRequired("has_conditional_params")

    fun hasRequiredLinkedAccountParams(): Boolean =
        hasRequiredLinkedAccountParams.getRequired("has_required_linked_account_params")

    @JsonProperty("request_schema") @ExcludeMissing fun _requestSchema() = requestSchema

    @JsonProperty("remote_field_classes")
    @ExcludeMissing
    fun _remoteFieldClasses() = remoteFieldClasses

    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("has_conditional_params")
    @ExcludeMissing
    fun _hasConditionalParams() = hasConditionalParams

    @JsonProperty("has_required_linked_account_params")
    @ExcludeMissing
    fun _hasRequiredLinkedAccountParams() = hasRequiredLinkedAccountParams

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            status().map { it.validate() }
            hasConditionalParams()
            hasRequiredLinkedAccountParams()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MetaResponse &&
            this.requestSchema == other.requestSchema &&
            this.remoteFieldClasses == other.remoteFieldClasses &&
            this.status == other.status &&
            this.hasConditionalParams == other.hasConditionalParams &&
            this.hasRequiredLinkedAccountParams == other.hasRequiredLinkedAccountParams &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    requestSchema,
                    remoteFieldClasses,
                    status,
                    hasConditionalParams,
                    hasRequiredLinkedAccountParams,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "MetaResponse{requestSchema=$requestSchema, remoteFieldClasses=$remoteFieldClasses, status=$status, hasConditionalParams=$hasConditionalParams, hasRequiredLinkedAccountParams=$hasRequiredLinkedAccountParams, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var requestSchema: JsonValue = JsonMissing.of()
        private var remoteFieldClasses: JsonValue = JsonMissing.of()
        private var status: JsonField<LinkedAccountStatus> = JsonMissing.of()
        private var hasConditionalParams: JsonField<Boolean> = JsonMissing.of()
        private var hasRequiredLinkedAccountParams: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(metaResponse: MetaResponse) = apply {
            this.requestSchema = metaResponse.requestSchema
            this.remoteFieldClasses = metaResponse.remoteFieldClasses
            this.status = metaResponse.status
            this.hasConditionalParams = metaResponse.hasConditionalParams
            this.hasRequiredLinkedAccountParams = metaResponse.hasRequiredLinkedAccountParams
            additionalProperties(metaResponse.additionalProperties)
        }

        @JsonProperty("request_schema")
        @ExcludeMissing
        fun requestSchema(requestSchema: JsonValue) = apply { this.requestSchema = requestSchema }

        @JsonProperty("remote_field_classes")
        @ExcludeMissing
        fun remoteFieldClasses(remoteFieldClasses: JsonValue) = apply {
            this.remoteFieldClasses = remoteFieldClasses
        }

        fun status(status: LinkedAccountStatus) = status(JsonField.of(status))

        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<LinkedAccountStatus>) = apply { this.status = status }

        fun hasConditionalParams(hasConditionalParams: Boolean) =
            hasConditionalParams(JsonField.of(hasConditionalParams))

        @JsonProperty("has_conditional_params")
        @ExcludeMissing
        fun hasConditionalParams(hasConditionalParams: JsonField<Boolean>) = apply {
            this.hasConditionalParams = hasConditionalParams
        }

        fun hasRequiredLinkedAccountParams(hasRequiredLinkedAccountParams: Boolean) =
            hasRequiredLinkedAccountParams(JsonField.of(hasRequiredLinkedAccountParams))

        @JsonProperty("has_required_linked_account_params")
        @ExcludeMissing
        fun hasRequiredLinkedAccountParams(hasRequiredLinkedAccountParams: JsonField<Boolean>) =
            apply {
                this.hasRequiredLinkedAccountParams = hasRequiredLinkedAccountParams
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

        fun build(): MetaResponse =
            MetaResponse(
                requestSchema,
                remoteFieldClasses,
                status,
                hasConditionalParams,
                hasRequiredLinkedAccountParams,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = LinkedAccountStatus.Builder::class)
    @NoAutoDetect
    class LinkedAccountStatus
    private constructor(
        private val linkedAccountStatus: JsonField<String>,
        private val canMakeRequest: JsonField<Boolean>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun linkedAccountStatus(): String = linkedAccountStatus.getRequired("linked_account_status")

        fun canMakeRequest(): Boolean = canMakeRequest.getRequired("can_make_request")

        @JsonProperty("linked_account_status")
        @ExcludeMissing
        fun _linkedAccountStatus() = linkedAccountStatus

        @JsonProperty("can_make_request") @ExcludeMissing fun _canMakeRequest() = canMakeRequest

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                linkedAccountStatus()
                canMakeRequest()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LinkedAccountStatus &&
                this.linkedAccountStatus == other.linkedAccountStatus &&
                this.canMakeRequest == other.canMakeRequest &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        linkedAccountStatus,
                        canMakeRequest,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "LinkedAccountStatus{linkedAccountStatus=$linkedAccountStatus, canMakeRequest=$canMakeRequest, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var linkedAccountStatus: JsonField<String> = JsonMissing.of()
            private var canMakeRequest: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(linkedAccountStatus: LinkedAccountStatus) = apply {
                this.linkedAccountStatus = linkedAccountStatus.linkedAccountStatus
                this.canMakeRequest = linkedAccountStatus.canMakeRequest
                additionalProperties(linkedAccountStatus.additionalProperties)
            }

            fun linkedAccountStatus(linkedAccountStatus: String) =
                linkedAccountStatus(JsonField.of(linkedAccountStatus))

            @JsonProperty("linked_account_status")
            @ExcludeMissing
            fun linkedAccountStatus(linkedAccountStatus: JsonField<String>) = apply {
                this.linkedAccountStatus = linkedAccountStatus
            }

            fun canMakeRequest(canMakeRequest: Boolean) =
                canMakeRequest(JsonField.of(canMakeRequest))

            @JsonProperty("can_make_request")
            @ExcludeMissing
            fun canMakeRequest(canMakeRequest: JsonField<Boolean>) = apply {
                this.canMakeRequest = canMakeRequest
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

            fun build(): LinkedAccountStatus =
                LinkedAccountStatus(
                    linkedAccountStatus,
                    canMakeRequest,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
