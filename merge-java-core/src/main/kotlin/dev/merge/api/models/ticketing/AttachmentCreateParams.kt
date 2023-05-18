package dev.merge.api.models.ticketing

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

class AttachmentCreateParams
constructor(
    private val model: AttachmentRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): AttachmentRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): AttachmentCreateBody {
        return AttachmentCreateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = AttachmentCreateBody.Builder::class)
    @NoAutoDetect
    class AttachmentCreateBody
    internal constructor(
        private val model: AttachmentRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Attachment Object
         *
         * ### Description
         *
         * The `Attachment` object is used to represent an attachment for a ticket.
         *
         * ### Usage Example
         *
         * TODO
         */
        @JsonProperty("model") fun model(): AttachmentRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AttachmentCreateBody &&
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
            "AttachmentCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: AttachmentRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(attachmentCreateBody: AttachmentCreateBody) = apply {
                this.model = attachmentCreateBody.model
                additionalProperties(attachmentCreateBody.additionalProperties)
            }

            /**
             * # The Attachment Object
             *
             * ### Description
             *
             * The `Attachment` object is used to represent an attachment for a ticket.
             *
             * ### Usage Example
             *
             * TODO
             */
            @JsonProperty("model")
            fun model(model: AttachmentRequest) = apply { this.model = model }

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

            fun build(): AttachmentCreateBody =
                AttachmentCreateBody(
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

        return other is AttachmentCreateParams &&
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
        "AttachmentCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: AttachmentRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(attachmentCreateParams: AttachmentCreateParams) = apply {
            this.model = attachmentCreateParams.model
            this.isDebugMode = attachmentCreateParams.isDebugMode
            this.runAsync = attachmentCreateParams.runAsync
            additionalQueryParams(attachmentCreateParams.additionalQueryParams)
            additionalHeaders(attachmentCreateParams.additionalHeaders)
            additionalBodyProperties(attachmentCreateParams.additionalBodyProperties)
        }

        /**
         * # The Attachment Object
         *
         * ### Description
         *
         * The `Attachment` object is used to represent an attachment for a ticket.
         *
         * ### Usage Example
         *
         * TODO
         */
        fun model(model: AttachmentRequest) = apply { this.model = model }

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

        fun build(): AttachmentCreateParams =
            AttachmentCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Attachment Object
     *
     * ### Description
     *
     * The `Attachment` object is used to represent an attachment for a ticket.
     *
     * ### Usage Example
     *
     * TODO
     */
    @JsonDeserialize(builder = AttachmentRequest.Builder::class)
    @NoAutoDetect
    class AttachmentRequest
    private constructor(
        private val fileName: String?,
        private val fileUrl: String?,
        private val candidate: String?,
        private val attachmentType: AttachmentTypeEnum?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val ticket: String?,
        private val contentType: String?,
        private val uploadedBy: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * The attachment's name. It is required to include the file extension in the attachment's
         * name.
         */
        @JsonProperty("file_name") fun fileName(): String? = fileName

        /** The attachment's url. It is required to include the file extension in the file's URL. */
        @JsonProperty("file_url") fun fileUrl(): String? = fileUrl

        @JsonProperty("candidate") fun candidate(): String? = candidate

        /**
         * - `RESUME` - RESUME
         * - `COVER_LETTER` - COVER_LETTER
         * - `OFFER_LETTER` - OFFER_LETTER
         * - `OTHER` - OTHER
         */
        @JsonProperty("attachment_type") fun attachmentType(): AttachmentTypeEnum? = attachmentType

        @JsonProperty("integration_params") fun integrationParams(): JsonValue? = integrationParams

        @JsonProperty("linked_account_params")
        fun linkedAccountParams(): JsonValue? = linkedAccountParams

        /** The ticket associated with the attachment. */
        @JsonProperty("ticket") fun ticket(): String? = ticket

        /** The attachment's file format. */
        @JsonProperty("content_type") fun contentType(): String? = contentType

        /** The user who uploaded the attachment. */
        @JsonProperty("uploaded_by") fun uploadedBy(): String? = uploadedBy

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AttachmentRequest &&
                this.fileName == other.fileName &&
                this.fileUrl == other.fileUrl &&
                this.candidate == other.candidate &&
                this.attachmentType == other.attachmentType &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.ticket == other.ticket &&
                this.contentType == other.contentType &&
                this.uploadedBy == other.uploadedBy &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        fileName,
                        fileUrl,
                        candidate,
                        attachmentType,
                        integrationParams,
                        linkedAccountParams,
                        ticket,
                        contentType,
                        uploadedBy,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "AttachmentRequest{fileName=$fileName, fileUrl=$fileUrl, candidate=$candidate, attachmentType=$attachmentType, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, ticket=$ticket, contentType=$contentType, uploadedBy=$uploadedBy, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var fileName: String? = null
            private var fileUrl: String? = null
            private var candidate: String? = null
            private var attachmentType: AttachmentTypeEnum? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var ticket: String? = null
            private var contentType: String? = null
            private var uploadedBy: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(attachmentRequest: AttachmentRequest) = apply {
                this.fileName = attachmentRequest.fileName
                this.fileUrl = attachmentRequest.fileUrl
                this.candidate = attachmentRequest.candidate
                this.attachmentType = attachmentRequest.attachmentType
                this.integrationParams = attachmentRequest.integrationParams
                this.linkedAccountParams = attachmentRequest.linkedAccountParams
                this.ticket = attachmentRequest.ticket
                this.contentType = attachmentRequest.contentType
                this.uploadedBy = attachmentRequest.uploadedBy
                additionalProperties(attachmentRequest.additionalProperties)
            }

            /**
             * The attachment's name. It is required to include the file extension in the
             * attachment's name.
             */
            @JsonProperty("file_name")
            fun fileName(fileName: String) = apply { this.fileName = fileName }

            /**
             * The attachment's url. It is required to include the file extension in the file's URL.
             */
            @JsonProperty("file_url")
            fun fileUrl(fileUrl: String) = apply { this.fileUrl = fileUrl }

            @JsonProperty("candidate")
            fun candidate(candidate: String) = apply { this.candidate = candidate }

            /**
             * - `RESUME` - RESUME
             * - `COVER_LETTER` - COVER_LETTER
             * - `OFFER_LETTER` - OFFER_LETTER
             * - `OTHER` - OTHER
             */
            @JsonProperty("attachment_type")
            fun attachmentType(attachmentType: AttachmentTypeEnum) = apply {
                this.attachmentType = attachmentType
            }

            @JsonProperty("integration_params")
            fun integrationParams(integrationParams: JsonValue) = apply {
                this.integrationParams = integrationParams
            }

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                this.linkedAccountParams = linkedAccountParams
            }

            /** The ticket associated with the attachment. */
            @JsonProperty("ticket") fun ticket(ticket: String) = apply { this.ticket = ticket }

            /** The attachment's file format. */
            @JsonProperty("content_type")
            fun contentType(contentType: String) = apply { this.contentType = contentType }

            /** The user who uploaded the attachment. */
            @JsonProperty("uploaded_by")
            fun uploadedBy(uploadedBy: String) = apply { this.uploadedBy = uploadedBy }

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

            fun build(): AttachmentRequest =
                AttachmentRequest(
                    fileName,
                    fileUrl,
                    candidate,
                    attachmentType,
                    integrationParams,
                    linkedAccountParams,
                    ticket,
                    contentType,
                    uploadedBy,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class AttachmentTypeEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is AttachmentTypeEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val RESUME = AttachmentTypeEnum(JsonField.of("RESUME"))

                @JvmField val COVER_LETTER = AttachmentTypeEnum(JsonField.of("COVER_LETTER"))

                @JvmField val OFFER_LETTER = AttachmentTypeEnum(JsonField.of("OFFER_LETTER"))

                @JvmField val OTHER = AttachmentTypeEnum(JsonField.of("OTHER"))

                @JvmStatic fun of(value: String) = AttachmentTypeEnum(JsonField.of(value))
            }

            enum class Known {
                RESUME,
                COVER_LETTER,
                OFFER_LETTER,
                OTHER,
            }

            enum class Value {
                RESUME,
                COVER_LETTER,
                OFFER_LETTER,
                OTHER,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    RESUME -> Value.RESUME
                    COVER_LETTER -> Value.COVER_LETTER
                    OFFER_LETTER -> Value.OFFER_LETTER
                    OTHER -> Value.OTHER
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    RESUME -> Known.RESUME
                    COVER_LETTER -> Known.COVER_LETTER
                    OFFER_LETTER -> Known.OFFER_LETTER
                    OTHER -> Known.OTHER
                    else -> throw MergeInvalidDataException("Unknown AttachmentTypeEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
