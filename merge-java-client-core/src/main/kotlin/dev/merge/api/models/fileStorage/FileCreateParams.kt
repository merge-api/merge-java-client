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

class FileCreateParams
constructor(
    private val model: FileRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): FileRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): FileCreateBody {
        return FileCreateBody(model, additionalBodyProperties)
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

    @JsonDeserialize(builder = FileCreateBody.Builder::class)
    @NoAutoDetect
    class FileCreateBody
    internal constructor(
        private val model: FileRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * # The File Object
         *
         * ### Description
         *
         * The `File` object is used to represent a file in the workspace. The Object typically
         * exists under a folder or drive, if it exists.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/filestorage/v1/files` endpoint and view their files.
         */
        @JsonProperty("model") fun model(): FileRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FileCreateBody &&
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
            "FileCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: FileRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileCreateBody: FileCreateBody) = apply {
                this.model = fileCreateBody.model
                additionalProperties(fileCreateBody.additionalProperties)
            }

            /**
             * # The File Object
             *
             * ### Description
             *
             * The `File` object is used to represent a file in the workspace. The Object typically
             * exists under a folder or drive, if it exists.
             *
             * ### Usage Example
             *
             * Fetch from the `GET /api/filestorage/v1/files` endpoint and view their files.
             */
            @JsonProperty("model") fun model(model: FileRequest) = apply { this.model = model }

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

            fun build(): FileCreateBody =
                FileCreateBody(
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

        return other is FileCreateParams &&
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
        "FileCreateParams{model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: FileRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileCreateParams: FileCreateParams) = apply {
            this.model = fileCreateParams.model
            this.isDebugMode = fileCreateParams.isDebugMode
            this.runAsync = fileCreateParams.runAsync
            additionalQueryParams(fileCreateParams.additionalQueryParams)
            additionalHeaders(fileCreateParams.additionalHeaders)
            additionalBodyProperties(fileCreateParams.additionalBodyProperties)
        }

        /**
         * # The File Object
         *
         * ### Description
         *
         * The `File` object is used to represent a file in the workspace. The Object typically
         * exists under a folder or drive, if it exists.
         *
         * ### Usage Example
         *
         * Fetch from the `GET /api/filestorage/v1/files` endpoint and view their files.
         */
        fun model(model: FileRequest) = apply { this.model = model }

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

        fun build(): FileCreateParams =
            FileCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    /**
     * # The File Object
     *
     * ### Description
     *
     * The `File` object is used to represent a file in the workspace. The Object typically exists
     * under a folder or drive, if it exists.
     *
     * ### Usage Example
     *
     * Fetch from the `GET /api/filestorage/v1/files` endpoint and view their files.
     */
    @JsonDeserialize(builder = FileRequest.Builder::class)
    @NoAutoDetect
    class FileRequest
    private constructor(
        private val name: String?,
        private val fileUrl: String?,
        private val fileThumbnailUrl: String?,
        private val size: Long?,
        private val mimeType: String?,
        private val description: String?,
        private val folder: String?,
        private val permissions: List<String>?,
        private val drive: String?,
        private val integrationParams: JsonValue?,
        private val linkedAccountParams: JsonValue?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The file's name. */
        @JsonProperty("name") fun name(): String? = name

        /** The URL to access the file. */
        @JsonProperty("file_url") fun fileUrl(): String? = fileUrl

        /** The URL that produces a thumbnail preview of the file. Typically an image. */
        @JsonProperty("file_thumbnail_url") fun fileThumbnailUrl(): String? = fileThumbnailUrl

        /** The file's size, in bytes. */
        @JsonProperty("size") fun size(): Long? = size

        /** The file's mime type. */
        @JsonProperty("mime_type") fun mimeType(): String? = mimeType

        /** The file's description. */
        @JsonProperty("description") fun description(): String? = description

        /** The folder that the file belongs to. */
        @JsonProperty("folder") fun folder(): String? = folder

        /**
         * The Permission object is used to represent a user's or group's access to a File or
         * Folder. Permissions are unexpanded by default. Use the query param `expand=permissions`
         * to see more details under `GET /files`.
         */
        @JsonProperty("permissions") fun permissions(): List<String>? = permissions

        /** The drive that the file belongs to. */
        @JsonProperty("drive") fun drive(): String? = drive

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

            return other is FileRequest &&
                this.name == other.name &&
                this.fileUrl == other.fileUrl &&
                this.fileThumbnailUrl == other.fileThumbnailUrl &&
                this.size == other.size &&
                this.mimeType == other.mimeType &&
                this.description == other.description &&
                this.folder == other.folder &&
                this.permissions == other.permissions &&
                this.drive == other.drive &&
                this.integrationParams == other.integrationParams &&
                this.linkedAccountParams == other.linkedAccountParams &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        name,
                        fileUrl,
                        fileThumbnailUrl,
                        size,
                        mimeType,
                        description,
                        folder,
                        permissions,
                        drive,
                        integrationParams,
                        linkedAccountParams,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "FileRequest{name=$name, fileUrl=$fileUrl, fileThumbnailUrl=$fileThumbnailUrl, size=$size, mimeType=$mimeType, description=$description, folder=$folder, permissions=$permissions, drive=$drive, integrationParams=$integrationParams, linkedAccountParams=$linkedAccountParams, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var fileUrl: String? = null
            private var fileThumbnailUrl: String? = null
            private var size: Long? = null
            private var mimeType: String? = null
            private var description: String? = null
            private var folder: String? = null
            private var permissions: List<String>? = null
            private var drive: String? = null
            private var integrationParams: JsonValue? = null
            private var linkedAccountParams: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileRequest: FileRequest) = apply {
                this.name = fileRequest.name
                this.fileUrl = fileRequest.fileUrl
                this.fileThumbnailUrl = fileRequest.fileThumbnailUrl
                this.size = fileRequest.size
                this.mimeType = fileRequest.mimeType
                this.description = fileRequest.description
                this.folder = fileRequest.folder
                this.permissions = fileRequest.permissions
                this.drive = fileRequest.drive
                this.integrationParams = fileRequest.integrationParams
                this.linkedAccountParams = fileRequest.linkedAccountParams
                additionalProperties(fileRequest.additionalProperties)
            }

            /** The file's name. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /** The URL to access the file. */
            @JsonProperty("file_url")
            fun fileUrl(fileUrl: String) = apply { this.fileUrl = fileUrl }

            /** The URL that produces a thumbnail preview of the file. Typically an image. */
            @JsonProperty("file_thumbnail_url")
            fun fileThumbnailUrl(fileThumbnailUrl: String) = apply {
                this.fileThumbnailUrl = fileThumbnailUrl
            }

            /** The file's size, in bytes. */
            @JsonProperty("size") fun size(size: Long) = apply { this.size = size }

            /** The file's mime type. */
            @JsonProperty("mime_type")
            fun mimeType(mimeType: String) = apply { this.mimeType = mimeType }

            /** The file's description. */
            @JsonProperty("description")
            fun description(description: String) = apply { this.description = description }

            /** The folder that the file belongs to. */
            @JsonProperty("folder") fun folder(folder: String) = apply { this.folder = folder }

            /**
             * The Permission object is used to represent a user's or group's access to a File or
             * Folder. Permissions are unexpanded by default. Use the query param
             * `expand=permissions` to see more details under `GET /files`.
             */
            @JsonProperty("permissions")
            fun permissions(permissions: List<String>) = apply { this.permissions = permissions }

            /** The drive that the file belongs to. */
            @JsonProperty("drive") fun drive(drive: String) = apply { this.drive = drive }

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

            fun build(): FileRequest =
                FileRequest(
                    name,
                    fileUrl,
                    fileThumbnailUrl,
                    size,
                    mimeType,
                    description,
                    folder,
                    checkNotNull(permissions) { "`permissions` is required but was not set" }
                        .toUnmodifiable(),
                    drive,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
