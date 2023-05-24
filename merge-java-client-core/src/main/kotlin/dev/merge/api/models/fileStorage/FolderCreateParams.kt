package dev.merge.api.models.fileStorage

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

class FolderCreateParams
constructor(
    private val model: FolderRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): FolderRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): FolderCreateBody {
        return FolderCreateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = FolderCreateBody.Builder::class)
    @NoAutoDetect
    class FolderCreateBody
    internal constructor(
        private val model: FolderRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The Folder Object
         *
         * ### Description
         *
         * The `Folder` object is used to represent a collection of files and/or folders in the
         * workspace. Could be within a drive, if it exsts.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/filestorage/v1/folders` endpoint and view their folders.
         */
        @JsonProperty("model") fun model(): FolderRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FolderCreateBody &&
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
            "FolderCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: FolderRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(folderCreateBody: FolderCreateBody) = apply {
                this.model = folderCreateBody.model
                additionalProperties(folderCreateBody.additionalProperties)
            }

            /**
             * # The Folder Object
             *
             * ### Description
             *
             * The `Folder` object is used to represent a collection of files and/or folders in the
             * workspace. Could be within a drive, if it exsts.
             *
             * ### Usage Example
             *
             * Fetch from the `GET /api/filestorage/v1/folders` endpoint and view their folders.
             */
            @JsonProperty("model") fun model(model: FolderRequest) = apply { this.model = model }

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

            fun build(): FolderCreateBody =
                FolderCreateBody(
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

        return other is FolderCreateParams &&
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
        "FolderCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: FolderRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(folderCreateParams: FolderCreateParams) = apply {
            this.model = folderCreateParams.model
            this.isDebugMode = folderCreateParams.isDebugMode
            this.runAsync = folderCreateParams.runAsync
            additionalQueryParams(folderCreateParams.additionalQueryParams)
            additionalHeaders(folderCreateParams.additionalHeaders)
            additionalBodyProperties(folderCreateParams.additionalBodyProperties)
        }

        /**
         * # The Folder Object
         *
         * ### Description
         *
         * The `Folder` object is used to represent a collection of files and/or folders in the
         * workspace. Could be within a drive, if it exsts.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/filestorage/v1/folders` endpoint and view their folders.
         */
        fun model(model: FolderRequest) = apply { this.model = model }

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

        fun build(): FolderCreateParams =
            FolderCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The Folder Object
     *
     * ### Description
     *
     * The `Folder` object is used to represent a collection of files and/or folders in the
     * workspace. Could be within a drive, if it exsts.
     *
     * ### Usage Example
     *
     * Fetch from the `GET /api/filestorage/v1/folders` endpoint and view their folders.
     */
    @JsonDeserialize(builder = FolderRequest.Builder::class)
    @NoAutoDetect
    class FolderRequest
    private constructor(
        private val name: String?,
        private val folderUrl: String?,
        private val size: Long?,
        private val description: String?,
        private val parentFolder: String?,
        private val drive: String?,
        private val permissions: List<String>?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The folder's name. */
        @JsonProperty("name") fun name(): String? = name

        /** The URL to access the folder. */
        @JsonProperty("folder_url") fun folderUrl(): String? = folderUrl

        /** The folder's size, in bytes. */
        @JsonProperty("size") fun size(): Long? = size

        /** The folder's description. */
        @JsonProperty("description") fun description(): String? = description

        /** The folder that the folder belongs to. */
        @JsonProperty("parent_folder") fun parentFolder(): String? = parentFolder

        /** The drive that the folder belongs to. */
        @JsonProperty("drive") fun drive(): String? = drive

        /**
         * The Permission object is used to represent a user's or group's access to a File or
         * Folder. Permissions are unexpanded by default. Use the query param `expand=permissions`
         * to see more details under `GET /folders`.
         */
        @JsonProperty("permissions") fun permissions(): List<String>? = permissions

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

            return other is FolderRequest &&
                this.name == other.name &&
                this.folderUrl == other.folderUrl &&
                this.size == other.size &&
                this.description == other.description &&
                this.parentFolder == other.parentFolder &&
                this.drive == other.drive &&
                this.permissions == other.permissions &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        name,
                        folderUrl,
                        size,
                        description,
                        parentFolder,
                        drive,
                        permissions,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "FolderRequest{name=$name, folderUrl=$folderUrl, size=$size, description=$description, parentFolder=$parentFolder, drive=$drive, permissions=$permissions, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var folderUrl: String? = null
            private var size: Long? = null
            private var description: String? = null
            private var parentFolder: String? = null
            private var drive: String? = null
            private var permissions: List<String>? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(folderRequest: FolderRequest) = apply {
                this.name = folderRequest.name
                this.folderUrl = folderRequest.folderUrl
                this.size = folderRequest.size
                this.description = folderRequest.description
                this.parentFolder = folderRequest.parentFolder
                this.drive = folderRequest.drive
                this.permissions = folderRequest.permissions
                this.integrationParams = folderRequest.integrationParams
                this.linkedAccountParams = folderRequest.linkedAccountParams
                additionalProperties(folderRequest.additionalProperties)
            }

            /** The folder's name. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /** The URL to access the folder. */
            @JsonProperty("folder_url")
            fun folderUrl(folderUrl: String) = apply { this.folderUrl = folderUrl }

            /** The folder's size, in bytes. */
            @JsonProperty("size") fun size(size: Long) = apply { this.size = size }

            /** The folder's description. */
            @JsonProperty("description")
            fun description(description: String) = apply { this.description = description }

            /** The folder that the folder belongs to. */
            @JsonProperty("parent_folder")
            fun parentFolder(parentFolder: String) = apply { this.parentFolder = parentFolder }

            /** The drive that the folder belongs to. */
            @JsonProperty("drive") fun drive(drive: String) = apply { this.drive = drive }

            /**
             * The Permission object is used to represent a user's or group's access to a File or
             * Folder. Permissions are unexpanded by default. Use the query param
             * `expand=permissions` to see more details under `GET /folders`.
             */
            @JsonProperty("permissions")
            fun permissions(permissions: List<String>) = apply { this.permissions = permissions }

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

            fun build(): FolderRequest =
                FolderRequest(
                    name,
                    folderUrl,
                    size,
                    description,
                    parentFolder,
                    drive,
                    checkNotNull(permissions) { "`permissions` is required but was not set" }
                        .toUnmodifiable(),
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
