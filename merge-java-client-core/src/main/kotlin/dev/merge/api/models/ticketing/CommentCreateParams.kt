package dev.merge.api.models.ticketing

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

class CommentCreateParams
constructor(
    private val model: CommentRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): CommentRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): CommentCreateBody {
        return CommentCreateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = CommentCreateBody.Builder::class)
    @NoAutoDetect
    class CommentCreateBody
    internal constructor(
        private val model: CommentRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Comment Object
         *
         * ### Description
         *
         * The `Comment` object is used to represent a comment on a ticket.
         *
         * ### Usage Example
         *
         * TODO
         */
        @JsonProperty("model") fun model(): CommentRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CommentCreateBody &&
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
            "CommentCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: CommentRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(commentCreateBody: CommentCreateBody) = apply {
                this.model = commentCreateBody.model
                additionalProperties(commentCreateBody.additionalProperties)
            }

            /**
             * # The Comment Object
             *
             * ### Description
             *
             * The `Comment` object is used to represent a comment on a ticket.
             *
             * ### Usage Example
             *
             * TODO
             */
            @JsonProperty("model") fun model(model: CommentRequest) = apply { this.model = model }

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

            fun build(): CommentCreateBody =
                CommentCreateBody(
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

        return other is CommentCreateParams &&
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
        "CommentCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: CommentRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(commentCreateParams: CommentCreateParams) = apply {
            this.model = commentCreateParams.model
            this.isDebugMode = commentCreateParams.isDebugMode
            this.runAsync = commentCreateParams.runAsync
            additionalQueryParams(commentCreateParams.additionalQueryParams)
            additionalHeaders(commentCreateParams.additionalHeaders)
            additionalBodyProperties(commentCreateParams.additionalBodyProperties)
        }

        /**
         * # The Comment Object
         *
         * ### Description
         *
         * The `Comment` object is used to represent a comment on a ticket.
         *
         * ### Usage Example
         *
         * TODO
         */
        fun model(model: CommentRequest) = apply { this.model = model }

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

        fun build(): CommentCreateParams =
            CommentCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Comment Object
     *
     * ### Description
     *
     * The `Comment` object is used to represent a comment on a ticket.
     *
     * ### Usage Example
     *
     * TODO
     */
    @JsonDeserialize(builder = CommentRequest.Builder::class)
    @NoAutoDetect
    class CommentRequest
    private constructor(
        private val user: String?,
        private val contact: String?,
        private val body: String?,
        private val htmlBody: String?,
        private val ticket: String?,
        private val isPrivate: Boolean?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The author of the Comment, if the author is a User. */
        @JsonProperty("user") fun user(): String? = user

        /** The author of the Comment, if the author is a Contact. */
        @JsonProperty("contact") fun contact(): String? = contact

        /** The comment's text body. */
        @JsonProperty("body") fun body(): String? = body

        /** The comment's text body formatted as html. */
        @JsonProperty("html_body") fun htmlBody(): String? = htmlBody

        /** The ticket associated with the comment. */
        @JsonProperty("ticket") fun ticket(): String? = ticket

        /** Whether or not the comment is internal. */
        @JsonProperty("is_private") fun isPrivate(): Boolean? = isPrivate

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

            return other is CommentRequest &&
                this.user == other.user &&
                this.contact == other.contact &&
                this.body == other.body &&
                this.htmlBody == other.htmlBody &&
                this.ticket == other.ticket &&
                this.isPrivate == other.isPrivate &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        user,
                        contact,
                        body,
                        htmlBody,
                        ticket,
                        isPrivate,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CommentRequest{user=$user, contact=$contact, body=$body, htmlBody=$htmlBody, ticket=$ticket, isPrivate=$isPrivate, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var user: String? = null
            private var contact: String? = null
            private var body: String? = null
            private var htmlBody: String? = null
            private var ticket: String? = null
            private var isPrivate: Boolean? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(commentRequest: CommentRequest) = apply {
                this.user = commentRequest.user
                this.contact = commentRequest.contact
                this.body = commentRequest.body
                this.htmlBody = commentRequest.htmlBody
                this.ticket = commentRequest.ticket
                this.isPrivate = commentRequest.isPrivate
                this.integrationParams = commentRequest.integrationParams
                this.linkedAccountParams = commentRequest.linkedAccountParams
                additionalProperties(commentRequest.additionalProperties)
            }

            /** The author of the Comment, if the author is a User. */
            @JsonProperty("user") fun user(user: String) = apply { this.user = user }

            /** The author of the Comment, if the author is a Contact. */
            @JsonProperty("contact") fun contact(contact: String) = apply { this.contact = contact }

            /** The comment's text body. */
            @JsonProperty("body") fun body(body: String) = apply { this.body = body }

            /** The comment's text body formatted as html. */
            @JsonProperty("html_body")
            fun htmlBody(htmlBody: String) = apply { this.htmlBody = htmlBody }

            /** The ticket associated with the comment. */
            @JsonProperty("ticket") fun ticket(ticket: String) = apply { this.ticket = ticket }

            /** Whether or not the comment is internal. */
            @JsonProperty("is_private")
            fun isPrivate(isPrivate: Boolean) = apply { this.isPrivate = isPrivate }

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

            fun build(): CommentRequest =
                CommentRequest(
                    user,
                    contact,
                    body,
                    htmlBody,
                    ticket,
                    isPrivate,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
