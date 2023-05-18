package dev.merge.api.models.crm

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

class AccountUpdateParams
constructor(
    private val id: String,
    private val model: PatchedAccountRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun id(): String = id

    fun model(): PatchedAccountRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): AccountUpdateBody {
        return AccountUpdateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = AccountUpdateBody.Builder::class)
    @NoAutoDetect
    class AccountUpdateBody
    internal constructor(
        private val model: PatchedAccountRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Account Object
         *
         * ### Description
         *
         * The `Account` object is used to represent a company in a CRM system.
         *
         * ### Usage Example
         *
         * TODO
         */
        @JsonProperty("model") fun model(): PatchedAccountRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AccountUpdateBody &&
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
            "AccountUpdateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: PatchedAccountRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(accountUpdateBody: AccountUpdateBody) = apply {
                this.model = accountUpdateBody.model
                additionalProperties(accountUpdateBody.additionalProperties)
            }

            /**
             * # The Account Object
             *
             * ### Description
             *
             * The `Account` object is used to represent a company in a CRM system.
             *
             * ### Usage Example
             *
             * TODO
             */
            @JsonProperty("model")
            fun model(model: PatchedAccountRequest) = apply { this.model = model }

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

            fun build(): AccountUpdateBody =
                AccountUpdateBody(
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

        return other is AccountUpdateParams &&
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
        "AccountUpdateParams{id=$id, model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var model: PatchedAccountRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountUpdateParams: AccountUpdateParams) = apply {
            this.id = accountUpdateParams.id
            this.model = accountUpdateParams.model
            this.isDebugMode = accountUpdateParams.isDebugMode
            this.runAsync = accountUpdateParams.runAsync
            additionalQueryParams(accountUpdateParams.additionalQueryParams)
            additionalHeaders(accountUpdateParams.additionalHeaders)
            additionalBodyProperties(accountUpdateParams.additionalBodyProperties)
        }

        fun id(id: String) = apply { this.id = id }

        /**
         * # The Account Object
         *
         * ### Description
         *
         * The `Account` object is used to represent a company in a CRM system.
         *
         * ### Usage Example
         *
         * TODO
         */
        fun model(model: PatchedAccountRequest) = apply { this.model = model }

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

        fun build(): AccountUpdateParams =
            AccountUpdateParams(
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
     * # The Account Object
     *
     * ### Description
     *
     * The `Account` object is used to represent a company in a CRM system.
     *
     * ### Usage Example
     *
     * TODO
     */
    @JsonDeserialize(builder = PatchedAccountRequest.Builder::class)
    @NoAutoDetect
    class PatchedAccountRequest
    private constructor(
        private val owner: String?,
        private val name: String?,
        private val description: String?,
        private val industry: String?,
        private val website: String?,
        private val numberOfEmployees: Long?,
        private val lastActivityAt: OffsetDateTime?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val remoteFields: List<RemoteFieldRequest>?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The account's owner. */
        @JsonProperty("owner") fun owner(): String? = owner

        /** The account's name. */
        @JsonProperty("name") fun name(): String? = name

        /** The account's description. */
        @JsonProperty("description") fun description(): String? = description

        /** The account's industry. */
        @JsonProperty("industry") fun industry(): String? = industry

        /** The account's website. */
        @JsonProperty("website") fun website(): String? = website

        /** The account's number of employees. */
        @JsonProperty("number_of_employees") fun numberOfEmployees(): Long? = numberOfEmployees

        /**
         * The last date (either most recent or furthest in the future) of when an activity occurs
         * in an account.
         */
        @JsonProperty("last_activity_at") fun lastActivityAt(): OffsetDateTime? = lastActivityAt

        @JsonProperty("integration_params") fun integrationParams(): JsonValue? = integrationParams

        @JsonProperty("linked_account_params")
        fun linkedAccountParams(): JsonValue? = linkedAccountParams

        @JsonProperty("remote_fields") fun remoteFields(): List<RemoteFieldRequest>? = remoteFields

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PatchedAccountRequest &&
                this.owner == other.owner &&
                this.name == other.name &&
                this.description == other.description &&
                this.industry == other.industry &&
                this.website == other.website &&
                this.numberOfEmployees == other.numberOfEmployees &&
                this.lastActivityAt == other.lastActivityAt &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.remoteFields == other.remoteFields &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        owner,
                        name,
                        description,
                        industry,
                        website,
                        numberOfEmployees,
                        lastActivityAt,
                        integrationParams,
                        linkedAccountParams,
                        remoteFields,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "PatchedAccountRequest{owner=$owner, name=$name, description=$description, industry=$industry, website=$website, numberOfEmployees=$numberOfEmployees, lastActivityAt=$lastActivityAt, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, remoteFields=$remoteFields, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var owner: String? = null
            private var name: String? = null
            private var description: String? = null
            private var industry: String? = null
            private var website: String? = null
            private var numberOfEmployees: Long? = null
            private var lastActivityAt: OffsetDateTime? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var remoteFields: List<RemoteFieldRequest>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(patchedAccountRequest: PatchedAccountRequest) = apply {
                this.owner = patchedAccountRequest.owner
                this.name = patchedAccountRequest.name
                this.description = patchedAccountRequest.description
                this.industry = patchedAccountRequest.industry
                this.website = patchedAccountRequest.website
                this.numberOfEmployees = patchedAccountRequest.numberOfEmployees
                this.lastActivityAt = patchedAccountRequest.lastActivityAt
                this.integrationParams = patchedAccountRequest.integrationParams
                this.linkedAccountParams = patchedAccountRequest.linkedAccountParams
                this.remoteFields = patchedAccountRequest.remoteFields
                additionalProperties(patchedAccountRequest.additionalProperties)
            }

            /** The account's owner. */
            @JsonProperty("owner") fun owner(owner: String) = apply { this.owner = owner }

            /** The account's name. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /** The account's description. */
            @JsonProperty("description")
            fun description(description: String) = apply { this.description = description }

            /** The account's industry. */
            @JsonProperty("industry")
            fun industry(industry: String) = apply { this.industry = industry }

            /** The account's website. */
            @JsonProperty("website") fun website(website: String) = apply { this.website = website }

            /** The account's number of employees. */
            @JsonProperty("number_of_employees")
            fun numberOfEmployees(numberOfEmployees: Long) = apply {
                this.numberOfEmployees = numberOfEmployees
            }

            /**
             * The last date (either most recent or furthest in the future) of when an activity
             * occurs in an account.
             */
            @JsonProperty("last_activity_at")
            fun lastActivityAt(lastActivityAt: OffsetDateTime) = apply {
                this.lastActivityAt = lastActivityAt
            }

            @JsonProperty("integration_params")
            fun integrationParams(integrationParams: JsonValue) = apply {
                this.integrationParams = integrationParams
            }

            @JsonProperty("linked_account_params")
            fun linkedAccountParams(linkedAccountParams: JsonValue) = apply {
                this.linkedAccountParams = linkedAccountParams
            }

            @JsonProperty("remote_fields")
            fun remoteFields(remoteFields: List<RemoteFieldRequest>) = apply {
                this.remoteFields = remoteFields
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

            fun build(): PatchedAccountRequest =
                PatchedAccountRequest(
                    owner,
                    name,
                    description,
                    industry,
                    website,
                    numberOfEmployees,
                    lastActivityAt,
                    integrationParams,
                    linkedAccountParams,
                    remoteFields?.toUnmodifiable(),
                    additionalProperties.toUnmodifiable(),
                )
        }

        @JsonDeserialize(builder = RemoteFieldRequest.Builder::class)
        @NoAutoDetect
        class RemoteFieldRequest
        private constructor(
            private val remoteFieldClass: String?,
            private val value: JsonValue?,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var hashCode: Int = 0

            @JsonProperty("remote_field_class") fun remoteFieldClass(): String? = remoteFieldClass

            @JsonProperty("value") fun value(): JsonValue? = value

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RemoteFieldRequest &&
                    this.remoteFieldClass == other.remoteFieldClass &&
                    this.value == other.value &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            remoteFieldClass,
                            value,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "RemoteFieldRequest{remoteFieldClass=$remoteFieldClass, value=$value, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var remoteFieldClass: String? = null
                private var value: JsonValue? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(remoteFieldRequest: RemoteFieldRequest) = apply {
                    this.remoteFieldClass = remoteFieldRequest.remoteFieldClass
                    this.value = remoteFieldRequest.value
                    additionalProperties(remoteFieldRequest.additionalProperties)
                }

                @JsonProperty("remote_field_class")
                fun remoteFieldClass(remoteFieldClass: String) = apply {
                    this.remoteFieldClass = remoteFieldClass
                }

                @JsonProperty("value") fun value(value: JsonValue) = apply { this.value = value }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    this.additionalProperties.putAll(additionalProperties)
                }

                @JsonAnySetter
                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    this.additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): RemoteFieldRequest =
                    RemoteFieldRequest(
                        checkNotNull(remoteFieldClass) {
                            "`remoteFieldClass` is required but was not set"
                        },
                        value,
                        additionalProperties.toUnmodifiable(),
                    )
            }
        }
    }
}
